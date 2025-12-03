package com.automation.apitest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.icedq.AdminServiceAPI;
import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RestAPI;


@Listeners(ExtentReportListener.class)
public class AdminAPITest extends BaseClass{

	@Test
	public void test_GenerateToken() {

		try {
			logTestInfo("icedq-Login-api1", "Generate token", "Login", "Vipul S.");

			String token = RestAPI.generateAuthToken("http://192.168.100.35:42445/auth/realms/icedq/protocol/openid-connect/token", "vipuls", "Admin@123");

			reportLog(String.format("Generated Token: %s", token));
		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}

	@Test
	public void test_CreateUserAPI() {

		try {
			logTestInfo("icedq-user-api-1", "Create User API", "Users", "Vipul S.");

	//		RestAPI.generateAuthToken("http://192.168.100.35:42445/auth/realms/icedq/protocol/openid-connect/token", "vipuls", "Admin@123");

			AdminServiceAPI adapi = new AdminServiceAPI();
			
			 // Request body
		    Map<String, Object> requestBody = new HashMap<>();
		    requestBody.put("userName", "test123");
		    requestBody.put("firstName", "John");
		    requestBody.put("lastName", "Doe");
		    requestBody.put("email", "john@example.com");
		    requestBody.put("tempCredential", "Pass@123");
		    
		    Map<String, String> expectedJsonValidation = Map.of(
			        "userName", "test123",
			        "firstName", "John"
			);
			
			adapi.createUserTest("http://192.168.100.35:42445/api/v1/users", ApiConstants.getAuthToken(), null, requestBody, "200", expectedJsonValidation);

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}
}
