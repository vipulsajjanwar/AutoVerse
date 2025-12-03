package com.automation.icedq;

import java.util.Map;

import com.framework.base.BaseClass;
import com.framework.restassured.RestAPI;

import io.restassured.response.Response;

public class AdminServiceAPI extends RestAPI{
	
	
	public boolean createUserTest(
	        String url,
	        String token,
	        Map<String, String> extraHeaders,
	        Map<String, Object> requestBody,
	        String expectedStatusCode,
	        Map<String, String> responseCheck
	) {
		
	    try {
			Response response = post(url, requestBody, token, extraHeaders);
			
			validateApiResponse(
			        response,
			        Integer.parseInt(expectedStatusCode),
			        "",
			        responseCheck    
			);
		} catch (Exception e) {
			BaseClass.reportErrorLog("Error occurs while createUserTest : "+e.getMessage());
			return false;
		}
	    return true;
	}
	

}
