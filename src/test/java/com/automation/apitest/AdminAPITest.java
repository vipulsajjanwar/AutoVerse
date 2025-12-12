package com.automation.apitest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentReportListener;
import com.framework.restassured.RestAPI;
import com.framework.variables.ExecutionVariables;


@Listeners(ExtentReportListener.class)
public class AdminAPITest extends BaseClass{

	
	@Test
	public void testGenerateToken() {

		try {
			logTestInfo("icedq-Login-api1", "Generate token", "Login", "Vipul S.");

			String token = RestAPI.generateAuthToken(ExecutionVariables.baseURL+ TOKENPATHPARAM, "vipuls", "Admin@123");

			reportLog(String.format("Generated Token: %s", token));

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
		}
	}
	
	@Test
	public void test_AccountWorkspacesAPI() {
			
		logTestInfo("icedq-Login-api1", "Generate token", "Login", "Vipul S.");
		
		RestAPI.getAccountId("Quality_Assurance");
			
		RestAPI.getWorkspaceId(ApiConstants.getAccountId(), "Automation-7.3.0-v3");
		
		RestAPI.getConnectionListUsingConnector(ApiConstants.getWorkspaceId(), "oracle");
	}



}
