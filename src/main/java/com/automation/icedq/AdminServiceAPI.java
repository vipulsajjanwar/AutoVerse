package com.automation.icedq;

import java.util.*;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.enums.FieldPattern;
import com.framework.restassured.RestAPI;
import com.framework.utils.JsonUtil;
import com.framework.utils.RestAPIUtil;

import io.restassured.response.Response;

public class AdminServiceAPI extends RestAPI {


	public static final String UUID_REGEX = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
	public static final String USERNAME_REGEX ="^[a-zA-Z0-9-_.@]+$";
	public static final String FIRSTLASTNAME_REGEX ="^[a-zA-Z]+$";
	public static final String PASSWORD_REGEX ="^(?! ).*(?<! )$";
	public static final String EMAIL_REGEX =
			"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	public static final String DEFAULT_DATEFORMAT = "dd/MM/yyyy HH:mm:ss 'UTC'";

	public boolean executeApiTest(
			String url,
			String token,
			String contentType,
			Map<String, String> extraHeaders,
			Map<String, Object> requestBody,
			String expectedStatusCode,
			Map<String, String> responseCheck,
			Map<String, Object> expectedJson,
			String schemaValidate,
			Map<String, String[]> jsonPathValidate,
			List<String> expectedRoles,             // OPTIONAL (only for some tests)
			boolean validateRoles                   // indicate if roles validation is needed
			) {
		boolean flag = true;

		try {

			Response response = post(url, requestBody, token, extraHeaders, contentType);

			validateApiResponse(
					response,
					(int) Double.parseDouble(expectedStatusCode),
					"",
					responseCheck,
					expectedJson,
					schemaValidate,
					jsonPathValidate
					);

			Map<String, String> expectedHeaders = new HashMap<>();
			if(contentType != null && !contentType.trim().isEmpty() && !contentType.contains("text") && !contentType.equalsIgnoreCase("na")) {
				expectedHeaders.put("Content-Type", contentType);
			}
			expectedHeaders.put("Authorization", "Bearer XXXXX");  // ignored

			List<String> skipHeaders = Arrays.asList("Authorization");

			RestAPIUtil.validateResponseHeaders(expectedHeaders!=null, response, expectedHeaders, skipHeaders);

			// 4️⃣ Optional: Validate list items like roles[]
			if (validateRoles) {
				if (expectedRoles != null && !expectedRoles.isEmpty()) {
					RestAPIUtil.validateListValues(response, "roles", expectedRoles);
				} else {
					BaseClass.reportLog("No role validation applied");
				}
			}

		} catch (Exception e) {
			BaseClass.reportErrorLog("Error in executeApiTest : " + e.getMessage());
			flag = false;
		}

		return flag;
	}


	public static String getAccessTokenUsingExpectedCode(int expectedCode) {

		// 🔥 Authentication Handling
		if (expectedCode == 401) {
			return "";
		} 

		if(expectedCode == 403) {
			return generateAuthToken(BaseClass.APIBASEURL+BaseClass.TOKENPATHPARAM, "account_owner", "Account!2345");

		}

		return RestAPI.generateAuthToken(BaseClass.APIBASEURL+BaseClass.TOKENPATHPARAM, "vipuls", "Admin@123");

	}

	public static String getQueryParameter(String queryParam) {

		if(queryParam!=null && !queryParam.trim().isEmpty()) {

			return "?"+queryParam;
		}else {
			return "";
		}
	}

	public static String getDynamicEndpoints(String url, String stringToBeReplaced, String dynamicValue) {

		return url.replace(stringToBeReplaced, dynamicValue);

	}

	public static Map<String, Object> buildRequestBodyIfRequired(
			String method,
			String templateFilePath,
			Map<String, String> testData) {

		// GET does not require request body
		if (method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("DELETE")) {
			return null;
		}

		try {
			String template = JsonUtil.loadJsonTemplate(templateFilePath);
			String requestBody = JsonUtil.applyData(template, testData);

			return new ObjectMapper().readValue(
					requestBody,
					new TypeReference<Map<String, Object>>() {}
					);
		} catch (Exception e) {
			throw new RuntimeException("Failed to build request body: " + e.getMessage(), e);
		}
	}


	public static void validateUserAPIResponse(
			boolean check,
			String type,
			Response response,
			Map<String, String> testData,
			SoftAssert softAssert
			) {

		if(!check) return ;

		String jsonPrefix = "";

		if(type.contains("search")) {
			jsonPrefix="items.";
		}

		if(ApiConstants.getStatusCode()==200) {

			String listValueStr  = testData.get("roles");

			if(listValueStr !=null) {

				List<String> expectedRoles = Arrays.stream(listValueStr.split(","))
						.map(String::trim)
						.toList();

				RestAPIUtil.validateListValues(response, jsonPrefix+"roles", expectedRoles);
			}

			RestAPIUtil.validateUUID(response, jsonPrefix+"id",softAssert);

			RestAPIUtil.validateStringLength(response, jsonPrefix+"userName", 2, 255,softAssert);
			RestAPIUtil.validateStringLength(response, jsonPrefix+"firstName", 2, 255,softAssert);
			RestAPIUtil.validateStringLength(response, jsonPrefix+"lastName", 2, 255,softAssert);

			RestAPIUtil.validatePattern(response, jsonPrefix+"id", FieldPattern.UUID.getRegex(),softAssert);
			RestAPIUtil.validatePattern(response, jsonPrefix+"userName", FieldPattern.USERNAME.getRegex(),softAssert);
			RestAPIUtil.validatePattern(response, jsonPrefix+"firstName", FieldPattern.FIRST_LAST_NAME.getRegex(),softAssert);
			RestAPIUtil.validatePattern(response, jsonPrefix+"lastName", FieldPattern.FIRST_LAST_NAME.getRegex(),softAssert);
			RestAPIUtil.validatePattern(response, jsonPrefix+"email", FieldPattern.EMAIL.getRegex(),softAssert);

			RestAPIUtil.validateArrayNotEmpty(response, jsonPrefix+"roles",softAssert);

			RestAPIUtil.validateBoolean(response, jsonPrefix+"isBlocked",softAssert);

			RestAPIUtil.validateDateFormat(response, jsonPrefix+"createdTimestamp", DEFAULT_DATEFORMAT,softAssert);
			RestAPIUtil.validateDateFormat(response, jsonPrefix+"updatedTimestamp", DEFAULT_DATEFORMAT,softAssert);
		}
	}
	
	public static String getErrorCodeSchemaValidationFile(String method, Response response, String schemaFolderPath, String schemaFileName) {

	    int statusCode = response.getStatusCode();

	    
	    String basePath = (schemaFolderPath == null || schemaFolderPath.isEmpty())
	            ? BaseClass.SCHEMAFOLDERPATH
	            : schemaFolderPath;

	   
	    if (!basePath.endsWith("/")) {
	        basePath = basePath + "/";
	    }

	    // Error → errorSchema.json mapping
	    Map<Integer, String> errorSchemas = Map.of(
	            400, "errors/400Schema.json",
	            401, "errors/401Schema.json",
	            403, "errors/403Schema.json",
	            404, "errors/404Schema.json",
	            409, "errors/409Schema.json",
	            415, "errors/404Schema.json"
	    );
	    
	    if ((method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("DELETE")) && statusCode==400) {
	    	 return basePath + "errors/404Schema.json";
	    }
	    if(method.equalsIgnoreCase("PUT") && statusCode==400) {
	    	String err =response.getBody().asString();
	    	if(err.contains("uuid")) {
	    		return basePath + "errors/404Schema.json";
	    	}
	    }

	    // If status code exists in error map → return corresponding error schema
	    if (errorSchemas.containsKey(statusCode)) {
	        return basePath + errorSchemas.get(statusCode);
	    }

	    // Default: normal schema for valid 2xx response
	    if (schemaFileName == null || schemaFileName.isEmpty()) {
	        throw new RuntimeException("schemaFileName is required for non-error responses.");
	    }

	    return basePath + "admin/" + schemaFileName;
	}
	
	public static void validateGroupAPIResponse(
			boolean check,
			String type,
			Response response,
			Map<String, String> testData,
			SoftAssert softAssert
			) {

		if(!check) return ;

		String jsonPrefix = "";

		if(type.contains("search")) {
			jsonPrefix="items.";
		}

		if(ApiConstants.getStatusCode()==200) {

			String listValueStr  = testData.get("roles");

			if(listValueStr !=null) {

				List<String> expectedRoles = Arrays.stream(listValueStr.split(","))
						.map(String::trim)
						.toList();

				RestAPIUtil.validateListValues(response, jsonPrefix+"roles", expectedRoles);
			}

			RestAPIUtil.validateUUID(response, jsonPrefix+"id",softAssert);

			RestAPIUtil.validateStringLength(response, jsonPrefix+"name", 2, 255, softAssert);
			RestAPIUtil.validateStringLength(response, jsonPrefix+"description", 0, 255, softAssert);
			
			RestAPIUtil.validatePattern(response, jsonPrefix+"id", FieldPattern.UUID.getRegex(), softAssert);
			RestAPIUtil.validatePattern(response, jsonPrefix+"name", FieldPattern.GROUP_NAME.getRegex(), softAssert);
			RestAPIUtil.validatePattern(response, jsonPrefix+"description", FieldPattern.GROUP_DESCRIPTION.getRegex(), softAssert);
			
			RestAPIUtil.validateDateFormat(response, jsonPrefix+"createdTimestamp", DEFAULT_DATEFORMAT, softAssert);
			RestAPIUtil.validateDateFormat(response, jsonPrefix+"updatedTimestamp", DEFAULT_DATEFORMAT, softAssert);
		}
	}
	

}
