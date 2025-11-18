package com.automation.apitest;

import org.testng.annotations.Test;

import com.framework.utils.APIUtil;
import com.framework.utils.ReportUtil;

public class AdminAPITest {

	@Test
	public void loginAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}

	@Test
	public void createUserAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}

	@Test
	public void retrieveUserAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}

	@Test
	public void updateUserAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}
	@Test
	public void assignToUserAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}

	@Test
	public void revokeAccessUserAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}

	@Test
	public void deleteUserAPITest() {
		String token = APIUtil.generateOAuth2Token("http://qa.onprem.icedq.com:8080/auth/realms/icedq.qa/protocol/openid-connect/token","icedq.admin-ui", "vipuls", "Admin@123");
		ReportUtil.info(token);
	}
}
