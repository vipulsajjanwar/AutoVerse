package com.automation.icedq;

import java.util.*;

import com.framework.base.BaseClass;
import com.framework.restassured.RestAPI;
import com.framework.utils.RestAPIUtil;

import io.restassured.response.Response;

public class AdminServiceAPI extends RestAPI {

 
    public boolean createUserTest(
            String url,
            String token,
            String contentType,
            Map<String, String> extraHeaders,
            Map<String, Object> requestBody,
            String expectedStatusCode,
            Map<String, String> responseCheck,
            List<String> expectedRoles,
            Map<String, Object> expectedJson,
            String schemaValidate,
            Map<String, String[]> jsonPathValidate
    ) {
       
        return executeApiTest(
                url,
                token,
                contentType,
                extraHeaders,
                requestBody,
                expectedStatusCode,
                responseCheck,
                expectedJson,
                schemaValidate,
                jsonPathValidate,
                expectedRoles,
                true
                
        );
    }

   
    public boolean searchUserTest(
            String url,
            String token,
            String contentType,
            Map<String, String> extraHeaders,
            Map<String, Object> requestBody,
            String expectedStatusCode,
            Map<String, String> responseCheck,
            Map<String, Object> expectedJson,
            String schemaValidate,
            Map<String, String[]> jsonPathValidate
    ) {
    	return executeApiTest(
                url,
                token,
                contentType,
                extraHeaders,
                requestBody,
                expectedStatusCode,
                responseCheck,
                expectedJson,
                schemaValidate,
                jsonPathValidate,
                null,
                false
                
        );
       
    }

 
    public boolean executeApiTest(
            String url,
            String token,
            String contentType,
            Map<String, String> extraHeaders,
            Map<String, Object> requestBody,
            String expectedStatusCode,
            Map<String, String> responseCheck,
            Map<String, Object> expectedJson,
            String schemaValidate,
            Map<String, String[]> jsonPathValidate,
            List<String> expectedRoles,             // OPTIONAL (only for some tests)
            boolean validateRoles                   // indicate if roles validation is needed
    ) {
        boolean flag = true;

        try {
           
            Response response = post(url, requestBody, token, extraHeaders, contentType);

            validateApiResponse(
                    response,
                    (int) Double.parseDouble(expectedStatusCode),
                    "",
                    responseCheck,
                    expectedJson,
                    schemaValidate,
                    jsonPathValidate
            );
            
            Map<String, String> expectedHeaders = new HashMap<>();
            if(contentType != null && !contentType.trim().isEmpty() && !contentType.contains("text") && !contentType.equalsIgnoreCase("na")) {
            	expectedHeaders.put("Content-Type", contentType);
            }
            expectedHeaders.put("Authorization", "Bearer XXXXX");  // ignored

            List<String> skipHeaders = Arrays.asList("Authorization");

            RestAPIUtil.validateResponseHeaders(expectedHeaders!=null, response, expectedHeaders, skipHeaders);

            // 4️⃣ Optional: Validate list items like roles[]
            if (validateRoles) {
                if (expectedRoles != null && !expectedRoles.isEmpty()) {
                	RestAPIUtil.validateListValues(response, "roles", expectedRoles);
                } else {
                    BaseClass.reportLog("No role validation applied");
                }
            }

        } catch (Exception e) {
            BaseClass.reportErrorLog("Error in executeApiTest : " + e.getMessage());
            flag = false;
        }

        return flag;
    }

    
    public static String getAccessTokenUsingExpectedCode(int expectedCode) {
    	
    	// 🔥 Authentication Handling
        if (expectedCode == 401) {
        	return "";
        } 
        
        if(expectedCode == 403) {
        	 return generateAuthToken(BaseClass.APIBASEURL+BaseClass.TOKENPATHPARAM, "account_owner", "Account!2345");
        	
        }
        
        return RestAPI.generateAuthToken(BaseClass.APIBASEURL+BaseClass.TOKENPATHPARAM, "vipuls", "Admin@123");
        
    }
    
    public static String getQueryParameter(String queryParam) {
    	
		if(queryParam!=null && !queryParam.trim().isEmpty()) {
			
			return "?"+queryParam;
		}else {
			return "";
		}
    }

}
