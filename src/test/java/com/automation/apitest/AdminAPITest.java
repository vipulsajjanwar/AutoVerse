package com.automation.apitest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.icedq.AdminServiceAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RestAPI;
import com.framework.utils.JsonUtil;
import com.framework.utils.RestAPIUtil;
import com.framework.utils.XLUtil;

import io.restassured.response.Response;


@Listeners(ExtentReportListener.class)
public class AdminAPITest extends BaseClass{


	String userExcelPath = DIR_PATH+"/src/test/resources/testdata/UsersAPITestData.xlsx";
	String jsonTemplatesPath = DIR_PATH+"/src/test/resources/templates/";
	
	public static final String EMAIL_REGEX =
	        "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	String defaultDateFormat = "dd/MM/yyyy HH:mm:ss 'UTC'";

	@DataProvider(name = "createUserData")
	public Object[][] getCreateUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, "Sheet4");

		List<Object[]> filtered = new ArrayList<>();

	    for (Map<String, String> row : excelData) {

	        // CONDITION: skip row without logging anywhere
	        if ("No".equalsIgnoreCase(row.get("ExecuteFlag"))) {
	            continue; // ← Completely removes row
	        }

	        // Add only valid rows
	        filtered.add(new Object[]{row});
	    }

	    return filtered.toArray(new Object[0][]);
	}
	
	@DataProvider(name = "searchUserData")
	public Object[][] getSearchUserData() {

		List<Map<String, String>> excelData =
	            XLUtil.readExcel(userExcelPath, "Sheet3");//Sheet3//searchuserapi

	    List<Object[]> filtered = new ArrayList<>();

	    for (Map<String, String> row : excelData) {

	        // CONDITION: skip row without logging anywhere
	        if ("No".equalsIgnoreCase(row.get("ExecuteFlag"))) {
	            continue; // ← Completely removes row
	        }

	        // Add only valid rows
	        filtered.add(new Object[]{row});
	    }

	    return filtered.toArray(new Object[0][]);
	}

	@Test
	public void test_GenerateToken() {

		try {
			logTestInfo("icedq-Login-api1", "Generate token", "Login", "Vipul S.");

			String token = RestAPI.generateAuthToken(APIBASEURL+ TOKENPATHPARAM, "vipuls", "Admin@123");

			reportLog(String.format("Generated Token: %s", token));

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}

	@Test(dataProvider = "createUserData")
	public void test_CreateUserAPI(Map<String, String> testData) {

		try {
			
			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "Users", "Vipul S.");
			
			String requestURL = APIBASEURL+testData.get("EndPoints");
			
			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			String template = JsonUtil.loadJsonTemplate(jsonTemplatesPath+testData.get("templateFile"));

			String requestBody = JsonUtil.applyData(template, testData);

			Map<String, Object> requestMap =  new ObjectMapper().readValue(requestBody, new TypeReference<Map<String, Object>>() {});
				
			Response response = RestAPI.sendRequest(testData.get("MethodType"), requestURL, requestMap, accessToken, null, testData.get("ContentType"));
			
			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));
			
			RestAPIUtil.validateResponseTime(response, 5000);
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, SCHEMAFOLDERPATH+testData.get("SchemaFile"));
			
			if(ApiConstants.getStatusCode()==200) {

				String listValueStr  = testData.get("roles");

				if(listValueStr !=null) {

					List<String> expectedRoles = Arrays.stream(listValueStr.split(","))
					        .map(String::trim)
					        .toList();

					RestAPIUtil.validateListValues(response, "roles", expectedRoles);
				}
				
				RestAPIUtil.validateUUID(response, "id");

				RestAPIUtil.validateStringLength(response, "userName", 1, 255);
				RestAPIUtil.validateStringLength(response, "firstName", 1, 255);
				RestAPIUtil.validateStringLength(response, "lastName", 1, 255);

				RestAPIUtil.validatePattern(response, "email", EMAIL_REGEX);
				
				RestAPIUtil.validateArrayNotEmpty(response, "roles");

				RestAPIUtil.validateBoolean(response, "isBlocked");

				RestAPIUtil.validateDateFormat(response, "createdTimestamp", defaultDateFormat);
				RestAPIUtil.validateDateFormat(response, "updatedTimestamp", defaultDateFormat);
			}
			
			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
			        testData.get("JSONPath"),
			        testData.get("ValidationType"),
			        testData.get("JSONValue")
			);
			
			RestAPIUtil.validateJsonPath(response, jsonPathValidate);
		
		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}
	
	@Test(dataProvider = "searchUserData")
	public void test_SearchUserAPI(Map<String, String> testData) {

		try {
			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "Users", "Vipul S.");
			
			String requestURL = APIBASEURL + testData.get("EndPoints") + AdminServiceAPI.getQueryParameter(testData.get("QueryParam"));
			
			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			String template = JsonUtil.loadJsonTemplate(jsonTemplatesPath+testData.get("templateFile"));

			String requestBody = JsonUtil.applyData(template, testData);

			Map<String, Object> requestMap = new ObjectMapper().readValue(requestBody, new TypeReference<Map<String, Object>>() {});
			
			Response response = RestAPI.sendRequest(testData.get("MethodType"), requestURL, requestMap, accessToken, null, testData.get("ContentType"));
			
			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));
			
			RestAPIUtil.validateResponseTime(response, 5000);
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, SCHEMAFOLDERPATH+testData.get("SchemaFile"));
			
			if(ApiConstants.getStatusCode()==200) {

				String listValueStr  = testData.get("roles");

				if(listValueStr !=null) {

					List<String> expectedRoles = Arrays.stream(listValueStr.split(","))
					        .map(String::trim)
					        .toList();

					RestAPIUtil.validateListValues(response, "roles", expectedRoles);
				}
				
				
				RestAPIUtil.validateUUID(response, "items.id");

				RestAPIUtil.validateStringLength(response, "items.userName", 1, 255);
				RestAPIUtil.validateStringLength(response, "items.firstName", 1, 255);
				RestAPIUtil.validateStringLength(response, "items.lastName", 1, 255);

				RestAPIUtil.validatePattern(response, "items.email", EMAIL_REGEX);
				
				RestAPIUtil.validateArrayNotEmpty(response, "items.roles");

				RestAPIUtil.validateBoolean(response, "items.isBlocked");

				RestAPIUtil.validateDateFormat(response, "items.createdTimestamp", defaultDateFormat);
				RestAPIUtil.validateDateFormat(response, "items.updatedTimestamp", defaultDateFormat);
			}
			
			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
			        testData.get("JSONPath"),
			        testData.get("ValidationType"),
			        testData.get("JSONValue")
			);
			
			RestAPIUtil.validateJsonPath(response, jsonPathValidate);
		
		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}
}
