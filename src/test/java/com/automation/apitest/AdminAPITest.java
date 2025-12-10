package com.automation.apitest;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.icedq.AdminServiceAPI;
import com.framework.base.BaseClass;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RestAPI;
import com.framework.utils.RestAPIUtil;

import io.restassured.response.Response;


@Listeners(ExtentReportListener.class)
public class AdminAPITest extends BaseClass{


	
	String jsonTemplatesPath = DIR_PATH+"/src/test/resources/templates/admin/";
	String schemaFolderPath = SCHEMAFOLDERPATH+"";

	String userID = "6b857d1b-a1a1-42c2-b308-808addd2d7f4";
	@Test
	public void testGenerateToken() {

		try {
			logTestInfo("icedq-Login-api1", "Generate token", "Login", "Vipul S.");

			String token = RestAPI.generateAuthToken(APIBASEURL+ TOKENPATHPARAM, "vipuls", "Admin@123");

			reportLog(String.format("Generated Token: %s", token));

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}

	@Test(description = "To verify, Create User API Test Scenarios", dataProvider = "createUserData", dataProviderClass = ApiDataProvider.class)
	public void testCreateUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "CreateUsersAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL+testData.get("EndPoints");

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);
			
			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);
			
			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);
			
			AdminServiceAPI.validateUserAPIResponse(true, "create", response, testData, softAssert);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(description = "To verify, Create User API Test Scenarios", dataProvider = "searchUserData", dataProviderClass = ApiDataProvider.class)
	public void testSearchUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {
			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "SearchUsersAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL + testData.get("EndPoints") + AdminServiceAPI.getQueryParameter(testData.get("QueryParam"));

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);

			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);

			AdminServiceAPI.validateUserAPIResponse(true, "search", response, testData, softAssert);


		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(description = "To verify, Update User API Test Scenarios", dataProvider = "updateUserData", dataProviderClass = ApiDataProvider.class)
	public void testUpdateUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "UpdateUsersAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL+testData.get("EndPoints");
			
			requestURL=AdminServiceAPI.getDynamicEndpoints(requestURL, "${userid}", userID);

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);
			
			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);

			AdminServiceAPI.validateUserAPIResponse(true, "update", response, testData, softAssert);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(description = "To verify, Retrieve User API Test Scenarios", dataProvider = "getUserData", dataProviderClass = ApiDataProvider.class)
	public void testRetrieveUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "RetrieveUsersAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL+testData.get("EndPoints");
			
			requestURL=AdminServiceAPI.getDynamicEndpoints(requestURL, "${userid}", userID);
			
			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);

			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);

			AdminServiceAPI.validateUserAPIResponse(true, "get", response, testData, softAssert);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(description = "To verify, Delete User API Test Scenarios", dataProvider = "deleteUserData", dataProviderClass = ApiDataProvider.class)
	public void testDeleteUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "DeleteUsersAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL+testData.get("EndPoints");
			
			requestURL=AdminServiceAPI.getDynamicEndpoints(requestURL, "${userid}", userID);
			
			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);

			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);
			
			AdminServiceAPI.validateUserAPIResponse(false, "delete", response, testData, softAssert);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(description = "To verify, Create Group API Test Scenarios", dataProvider = "createGroupData", dataProviderClass = ApiDataProvider.class)
	public void testCreateGroupAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "CreateGroupAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL+testData.get("EndPoints");

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);
			
			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);
			
			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);
			
			AdminServiceAPI.validateGroupAPIResponse(true, "create", response, testData, softAssert);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	@Test(description = "To verify, Retrieve Group API Test Scenarios", dataProvider = "getGroupData", dataProviderClass = ApiDataProvider.class)
	public void testRetrieveGroupAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "RetrieveGroupsAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = APIBASEURL+testData.get("EndPoints");
			
			requestURL=AdminServiceAPI.getDynamicEndpoints(requestURL, "${groupid}", userID);
			
			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  AdminServiceAPI.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);

			Response response = RestAPI.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			String schemaFile = AdminServiceAPI.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, schemaFile);

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);

			AdminServiceAPI.validateGroupAPIResponse(true, "get", response, testData, softAssert);
			
			RestAPIUtil.validateErrorMessage(response, "", "", softAssert);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}


}
