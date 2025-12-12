package com.automation.api.testcases;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.api.provider.ApiDataProvider;
import com.automation.icedq.AdminServiceAPI;
import com.framework.base.BaseClass;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RequestBodyBuilder;
import com.framework.restassured.RequestBuilder;
import com.framework.restassured.ResponseValidator;
import com.framework.utils.RestAPIUtil;
import com.framework.variables.ExecutionVariables;

import io.restassured.response.Response;
@Listeners(ExtentReportListener.class)
public class GroupsTest extends BaseClass{

	String jsonTemplatesPath = DIR_PATH+"/src/test/resources/templates/admin/";
	String schemaFolderPath = SCHEMAFOLDERPATH+"";
	String groupID = "6b857d1b-a1a1-42c2-b308-808addd2d7f4";
	
	@Test(description = "To verify, Create Group API Test Scenarios", dataProvider = "createGroupData", dataProviderClass = ApiDataProvider.class)
	public void testCreateGroupAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "CreateGroupAPI", "Vipul S.");
			
			String httpMethod = testData.get("MethodType");

			String requestURL = ExecutionVariables.baseURL+testData.get("EndPoints");

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  RequestBodyBuilder.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);
			
			Response response = RequestBuilder.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"), null);

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);
			
			String schemaFile = ResponseValidator.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
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

			String requestURL = ExecutionVariables.baseURL+testData.get("EndPoints");
			
			requestURL= RequestBuilder.getDynamicEndpoints(requestURL, "${groupid}", groupID);
			
			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			Map<String, Object> requestMap =  RequestBodyBuilder.buildRequestBodyIfRequired(httpMethod, jsonTemplatesPath+testData.get("templateFile"), testData);

			Response response = RequestBuilder.sendRequest(httpMethod, requestURL, requestMap, accessToken, null, testData.get("ContentType"), null);

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			String schemaFile = ResponseValidator.getErrorCodeSchemaValidationFile(httpMethod, response, schemaFolderPath, testData.get("SchemaFile"));
			
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
