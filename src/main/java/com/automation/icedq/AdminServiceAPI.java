package com.automation.icedq;

import java.util.*;

import org.testng.asserts.SoftAssert;

import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.enums.FieldPattern;
import com.framework.restassured.RestAPI;
import com.framework.utils.RestAPIUtil;
import com.framework.variables.ExecutionVariables;

import io.restassured.response.Response;

public class AdminServiceAPI extends RestAPI {


//	public boolean executeApiTest(
//			String url,
//			String token,
//			String contentType,
//			Map<String, String> extraHeaders,
//			Map<String, Object> requestBody,
//			String expectedStatusCode,
//			Map<String, String> responseCheck,
//			Map<String, Object> expectedJson,
//			String schemaValidate,
//			Map<String, String[]> jsonPathValidate,
//			List<String> expectedRoles,             // OPTIONAL (only for some tests)
//			boolean validateRoles                   // indicate if roles validation is needed
//			) {
//		boolean flag = true;
//
//		try {
//
//			Response response = post(url, requestBody, token, extraHeaders, contentType);
///**
//			validateApiResponse(
//					response,
//					(int) Double.parseDouble(expectedStatusCode),
//					"",
//					responseCheck,
//					expectedJson,
//					schemaValidate,
//					jsonPathValidate
//					);
//*/
//			Map<String, String> expectedHeaders = new HashMap<>();
//			if(contentType != null && !contentType.trim().isEmpty() && !contentType.contains("text") && !contentType.equalsIgnoreCase("na")) {
//				expectedHeaders.put("Content-Type", contentType);
//			}
//			expectedHeaders.put("Authorization", "Bearer XXXXX");  // ignored
//
//			List<String> skipHeaders = Arrays.asList("Authorization");
//
//			RestAPIUtil.validateResponseHeaders(expectedHeaders!=null, response, expectedHeaders, skipHeaders);
//
//			// 4️⃣ Optional: Validate list items like roles[]
//			if (validateRoles) {
//				if (expectedRoles != null && !expectedRoles.isEmpty()) {
//					RestAPIUtil.validateListValues(response, "roles", expectedRoles);
//				} else {
//					BaseClass.reportLog("No role validation applied");
//				}
//			}
//
//		} catch (Exception e) {
//			BaseClass.reportErrorLog("Error in executeApiTest : " + e.getMessage());
//			flag = false;
//		}
//
//		return flag;
//	}


	public static String getAccessTokenUsingExpectedCode(int expectedCode) {

		// 🔥 Authentication Handling
		if (expectedCode == 401) {
			return "";
		} 

		if(expectedCode == 403) {
			return generateAuthToken(ExecutionVariables.baseURL+BaseClass.TOKENPATHPARAM, "account_owner", "Account!2345");

		}

		return RestAPI.generateAuthToken(ExecutionVariables.baseURL+BaseClass.TOKENPATHPARAM, "vipuls", "Admin@123");

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

			RestAPIUtil.validateDateFormat(response, jsonPrefix+"createdTimestamp", FieldPattern.DATEFORMAT_UTC.getRegex(),softAssert);
			RestAPIUtil.validateDateFormat(response, jsonPrefix+"updatedTimestamp", FieldPattern.DATEFORMAT_UTC.getRegex(),softAssert);
		}
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
			
			RestAPIUtil.validateDateFormat(response, jsonPrefix+"createdTimestamp", FieldPattern.DATEFORMAT_UTC.getRegex(), softAssert);
			RestAPIUtil.validateDateFormat(response, jsonPrefix+"updatedTimestamp", FieldPattern.DATEFORMAT_UTC.getRegex(), softAssert);
		}
	}
	

}
