package com.automation.apitest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.icedq.AdminServiceAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RestAPI;
import com.framework.utils.JsonUtil;
import com.framework.utils.XLUtil;


@Listeners(ExtentReportListener.class)
public class AdminAPITest extends BaseClass{


	String userExcelPath = DIR_PATH+"/src/test/resources/testdata/createUserTestData.xlsx";
	String jsonTemplatesPath = DIR_PATH+"/src/test/resources/jsonTemplates/";

	String apiBaseURL = "http://192.168.100.35:42445/";
	String tokenPathParam = "auth/realms/icedq/protocol/openid-connect/token";

	String createUserPathParam = "api/v1/users";
	String searchUserPathParam = "api/v1/users/search";

	@DataProvider(name = "createUserData")
	public Object[][] getCreateUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, "createuserapi");

		Object[][] data = new Object[excelData.size()][1];

		for (int i = 0; i < excelData.size(); i++) {
			data[i][0] = excelData.get(i);
		}

		return data;
	}
	
	@DataProvider(name = "searchUserData")
	public Object[][] getSearchUserData() {

		List<Map<String, String>> excelData =
				XLUtil.readExcel(userExcelPath, "searchuserapi");

		Object[][] data = new Object[excelData.size()][1];

		for (int i = 0; i < excelData.size(); i++) {
			data[i][0] = excelData.get(i);
		}

		return data;
	}

	@Test
	public void test_GenerateToken() {

		try {
			logTestInfo("icedq-Login-api1", "Generate token", "Login", "Vipul S.");

			String token = RestAPI.generateAuthToken(apiBaseURL+ tokenPathParam, "vipuls", "Admin@123");

			reportLog(String.format("Generated Token: %s", token));

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}

	@Test(dataProvider = "createUserData")
	public void test_CreateUserAPI(Map<String, String> testData) {

		try {
			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "Users", "Vipul S.");

			AdminServiceAPI adapi = new AdminServiceAPI();

			String template = JsonUtil.loadJsonTemplate(jsonTemplatesPath+"createUserTemplate.json");

			String requestBody = JsonUtil.applyData(template, testData);

			Map<String, Object> requestMap = new ObjectMapper().readValue(requestBody, Map.class);

			String listValueStr  = testData.get("roles");

			List<String> expectedRoles = Arrays.asList(listValueStr.split(","))
					.stream()
					.map(String::trim)
					.collect(Collectors.toList());

			Map<String, String> expectedFields = RestAPI.buildExpectedFields(testData, "ValidateKey");

			adapi.createUserTest(apiBaseURL+createUserPathParam,
					ApiConstants.getAuthToken(),
					null,
					requestMap,
					testData.get("ExpectedStatus"),
					expectedFields,
					expectedRoles,
					null,
					testData.get("schemaFile")
					);


		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}
	
	@Test(dataProvider = "searchUserData")
	public void test_SearchUserAPI(Map<String, String> testData) {

		try {
			logTestInfo(testData.get("TestCaseID"), testData.get("TestName"), "Users", "Vipul S.");

			AdminServiceAPI adapi = new AdminServiceAPI();

			String template = JsonUtil.loadJsonTemplate(jsonTemplatesPath+"searchUserTemplate.json");

			String requestBody = JsonUtil.applyData(template, testData);

			Map<String, Object> requestMap = new ObjectMapper().readValue(requestBody, Map.class);

			String listValueStr  = testData.get("roles");

			List<String> expectedRoles = Arrays.asList(listValueStr.split(","))
					.stream()
					.map(String::trim)
					.collect(Collectors.toList());

			Map<String, String> expectedFields = RestAPI.buildExpectedFields(testData, "ValidateKey");

			adapi.searchUserTest(apiBaseURL+searchUserPathParam,
					ApiConstants.getAuthToken(),
					null,
					requestMap,
					testData.get("ExpectedStatus"),
					expectedFields,
					null,
					testData.get("schemaFile")
					);


		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}
}
