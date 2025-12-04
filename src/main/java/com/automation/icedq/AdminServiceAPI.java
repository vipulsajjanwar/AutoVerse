package com.automation.icedq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.restassured.RestAPI;

import io.restassured.response.Response;

public class AdminServiceAPI extends RestAPI{


	public boolean createUserTest(
			String url,
			String token,
			Map<String, String> extraHeaders,
			Map<String, Object> requestBody,
			String expectedStatusCode,
			Map<String, String> responseCheck,
			List <String> expectedRoles,
			Map<String, Object> expectedJson,
			String schemaValidate
			) {
		boolean flag = true;
		try {

			Response response = post(url, requestBody, token, extraHeaders, ApiConstants.applicationJson);

			validateApiResponse(
					response,
					(int) Double.parseDouble(expectedStatusCode),
					"",
					responseCheck,
					expectedJson,
					schemaValidate
					);
			
			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("Content-Type", ApiConstants.applicationJson);
			requestHeaders.put("Authorization", "Bearer xxxxx");   // WILL BE SKIPPED

			// List of headers to ignore
			List<String> skip = Arrays.asList("Authorization");

			validateResponseHeaders(response, requestHeaders, skip);

			if ((int) Double.parseDouble(expectedStatusCode)!=200) {
				return flag;
			}
		
			if (expectedRoles != null && !expectedRoles.isEmpty()) {
				validateListValues(response, "roles", expectedRoles);
			} else {
				BaseClass.reportLog("No list validation applied for roles");
			}

		} catch (Exception e) {
			BaseClass.reportErrorLog("Error occurs while createUserTest : "+e.getMessage());
			return false;
		}
		return flag;
	}
	
	public boolean searchUserTest(
			String url,
			String token,
			Map<String, String> extraHeaders,
			Map<String, Object> requestBody,
			String expectedStatusCode,
			Map<String, String> responseCheck,
			Map<String, Object> expectedJson,
			String schemaValidate
			) {
		boolean flag = true;
		try {

			Response response = post(url, requestBody, token, extraHeaders, ApiConstants.applicationJson);

			validateApiResponse(
					response,
					(int) Double.parseDouble(expectedStatusCode),
					"",
					responseCheck,
					expectedJson,
					schemaValidate
					);
			
			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("Content-Type", ApiConstants.applicationJson);
			requestHeaders.put("Authorization", "Bearer xxxxx");   // WILL BE SKIPPED

			// List of headers to ignore
			List<String> skip = Arrays.asList("Authorization");

			validateResponseHeaders(response, requestHeaders, skip);

		} catch (Exception e) {
			BaseClass.reportErrorLog("Error occurs while createUserTest : "+e.getMessage());
			return false;
		}
		return flag;
	}


}
