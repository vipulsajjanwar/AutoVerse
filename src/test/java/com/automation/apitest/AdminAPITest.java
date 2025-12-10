package com.automation.apitest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.icedq.AdminServiceAPI;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RestAPI;
import com.framework.utils.JsonUtil;
import com.framework.utils.RestAPIUtil;

import io.restassured.response.Response;


@Listeners(ExtentReportListener.class)
public class AdminAPITest extends BaseClass{


	String userExcelPath = DIR_PATH+"/src/test/resources/testdata/UsersAPITestData.xlsx";
	String jsonTemplatesPath = DIR_PATH+"/src/test/resources/templates/";

	public static final String USERNAME_REGEX ="^[a-zA-Z0-9-_.@]+$";
	public static final String FIRSTLASTNAME_REGEX ="^[a-zA-Z]+$";
	public static final String PASSWORD_REGEX ="^(?! ).*(?<! )$";
	public static final String EMAIL_REGEX =
			"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	String defaultDateFormat = "dd/MM/yyyy HH:mm:ss 'UTC'";

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

	@Test(description = "To verify, Create User API Test Scenarios", dataProvider = "createUserData", dataProviderClass = ApiDataProvider.class)
	public void test_CreateUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {

			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "CreateUsersAPI", "Vipul S.");

			String requestURL = APIBASEURL+testData.get("EndPoints");

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			String template = JsonUtil.loadJsonTemplate(jsonTemplatesPath+testData.get("templateFile"));

			String requestBody = JsonUtil.applyData(template, testData);

			Map<String, Object> requestMap =  new ObjectMapper().readValue(requestBody, new TypeReference<Map<String, Object>>() {});

			Response response = RestAPI.sendRequest(testData.get("MethodType"), requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, SCHEMAFOLDERPATH+testData.get("SchemaFile"));

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);

			if(ApiConstants.getStatusCode()==200) {

				String listValueStr  = testData.get("roles");

				if(listValueStr !=null) {

					List<String> expectedRoles = Arrays.stream(listValueStr.split(","))
							.map(String::trim)
							.toList();

					RestAPIUtil.validateListValues(response, "roles", expectedRoles);
				}

				RestAPIUtil.validateUUID(response, "id",softAssert);

				RestAPIUtil.validateStringLength(response, "userName", 2, 255,softAssert);
				RestAPIUtil.validateStringLength(response, "firstName", 2, 255,softAssert);
				RestAPIUtil.validateStringLength(response, "lastName", 2, 255,softAssert);

				RestAPIUtil.validatePattern(response, "userName", USERNAME_REGEX,softAssert);
				RestAPIUtil.validatePattern(response, "firstName", FIRSTLASTNAME_REGEX,softAssert);
				RestAPIUtil.validatePattern(response, "lastName", FIRSTLASTNAME_REGEX,softAssert);
				RestAPIUtil.validatePattern(response, "email", EMAIL_REGEX,softAssert);

				RestAPIUtil.validateArrayNotEmpty(response, "roles",softAssert);

				RestAPIUtil.validateBoolean(response, "isBlocked",softAssert);

				RestAPIUtil.validateDateFormat(response, "createdTimestamp", defaultDateFormat,softAssert);
				RestAPIUtil.validateDateFormat(response, "updatedTimestamp", defaultDateFormat,softAssert);
			}

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	@Test(description = "To verify, Create User API Test Scenarios", dataProvider = "searchUserData", dataProviderClass = ApiDataProvider.class)
	public void test_SearchUserAPI(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		try {
			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "SearchUsersAPI", "Vipul S.");

			String requestURL = APIBASEURL + testData.get("EndPoints") + AdminServiceAPI.getQueryParameter(testData.get("QueryParam"));

			String accessToken = AdminServiceAPI.getAccessTokenUsingExpectedCode((int) Double.parseDouble(testData.get("ExpectedCode")));

			String template = JsonUtil.loadJsonTemplate(jsonTemplatesPath+testData.get("templateFile"));

			String requestBody = JsonUtil.applyData(template, testData);

			Map<String, Object> requestMap = new ObjectMapper().readValue(requestBody, new TypeReference<Map<String, Object>>() {});

			Response response = RestAPI.sendRequest(testData.get("MethodType"), requestURL, requestMap, accessToken, null, testData.get("ContentType"));

			RestAPIUtil.validateStatusCode(response, (int) Double.parseDouble(testData.get("ExpectedCode")));

			RestAPIUtil.validateResponseTime(response, 5000);

			RestAPIUtil.validateSchema(!testData.get("SchemaFile").isEmpty(), response, SCHEMAFOLDERPATH+testData.get("SchemaFile"));

			Map<String, String[]> jsonPathValidate = RestAPIUtil.getValidationsFromExcel(
					testData.get("JSONPath"),
					testData.get("ValidationType"),
					testData.get("JSONValue")
					);

			RestAPIUtil.validateJsonPath(response, jsonPathValidate);

			if(ApiConstants.getStatusCode()==200) {

				String listValueStr  = testData.get("roles");

				if(listValueStr !=null) {

					List<String> expectedRoles = Arrays.stream(listValueStr.split(","))
							.map(String::trim)
							.toList();

					RestAPIUtil.validateListValues(response, "roles", expectedRoles);
				}


				RestAPIUtil.validateUUID(response, "items.id",softAssert);

				RestAPIUtil.validateStringLength(response, "items.userName", 2, 255,softAssert);
				RestAPIUtil.validateStringLength(response, "items.firstName", 2, 255,softAssert);
				RestAPIUtil.validateStringLength(response, "items.lastName", 2, 255,softAssert);

				RestAPIUtil.validatePattern(response, "items.userName", USERNAME_REGEX,softAssert);
				RestAPIUtil.validatePattern(response, "items.firstName", FIRSTLASTNAME_REGEX,softAssert);
				RestAPIUtil.validatePattern(response, "items.lastName", FIRSTLASTNAME_REGEX,softAssert);
				RestAPIUtil.validatePattern(response, "items.email", EMAIL_REGEX,softAssert);

				RestAPIUtil.validateArrayNotEmpty(response, "items.roles",softAssert);

				RestAPIUtil.validateBoolean(response, "items.isBlocked",softAssert);

				RestAPIUtil.validateDateFormat(response, "items.createdTimestamp", defaultDateFormat,softAssert);
				RestAPIUtil.validateDateFormat(response, "items.updatedTimestamp", defaultDateFormat,softAssert);
			}


		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
}
