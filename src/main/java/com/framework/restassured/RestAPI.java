package com.framework.restassured;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.framework.base.BaseClass;
import com.framework.config.AppConfig;
import com.framework.config.ConfigManager;
import com.framework.constant.ApiConstants;
import com.framework.enums.ApiEndpoints;
import com.framework.enums.HttpMethod;
import com.framework.utils.RestAPIUtil;
import com.framework.variables.ExecutionVariables;

import io.restassured.response.Response;

public class RestAPI extends AppConfig {
	
	public RestAPI() {
		
		
	}
	
    public static final Logger logger = LogManager.getLogger(RestAPI.class);

    public static String generateAuthToken(String url, String userName, String password) {
        String token = null;
        try {
        	String formData = new FormDataBuilder()
        	        .add("grant_type", "password")
        	        .add("client_id", "icedq.admin-ui")
        	        .add("username", userName)
        	        .add("password", password)
        	        .build();

        	Response response = RequestBuilder.sendRequest("POST", url, formData, "", null, "application/x-www-form-urlencoded", null);

            if (response != null && response.getStatusCode() == 200) {
                token = RestAPIUtil.getJsonPathValue(response, "access_token", String.class);
                ApiConstants.setAuthToken(token);
            } else {
                logger.error("Response is null or returned non-200 status. Cannot extract token.");
            }

        } catch (Exception e) {
            BaseClass.reportErrorLog("Exception occur while generateAuthToken request: "+e.getMessage());
            logger.error("Exception occur while generateAuthToken request: {}", e.getMessage(), e);
        }
        return token;
    }
    
    public static String getAccountId(String accountName) {
    	
    	String accountId=null;
    	
		try {
			String requestURL = ExecutionVariables.baseURL+ConfigManager.getString(ApiEndpoints.ACCOUNTS.key())+"/search";
				
			String accessToken = ApiConstants.getAuthToken();
							
			Map<String, String> extraHeaders = new HashMap<>();
			extraHeaders.put("Org-Id", "org-"+ConfigManager.getString(ApiEndpoints.ORG_ID.key()));

			Map<String, Object> searchItem = new HashMap<>();
			searchItem.put("attribute", "name");
			searchItem.put("operator", "equals");
			searchItem.put("value", accountName);

			Map<String, Object> bodyMap = new HashMap<>();
			bodyMap.put("search", new Object[]{ searchItem });

			Response response = RequestBuilder.sendRequest(HttpMethod.POST.toString(), requestURL, bodyMap, accessToken, extraHeaders, ApiConstants.applicationJson, null);
			
			if (response != null && response.getStatusCode() == 200) {
				accountId = RestAPIUtil.getJsonPathValue(response, "items[0].id", String.class);
			    ApiConstants.setAccountId(accountId);
			} else {
			    logger.error("Response is null or returned non-200 status. Cannot extract token.");
			    BaseClass.reportFailLog("Error while getAccountId, Responce: "+response, "getAccountId");
			}
		} catch (Exception e) {
			 	BaseClass.reportErrorLog("Exception occur while getAccountId request: "+e.getMessage());
	            logger.error("Exception occur while getAccountId request: {}", e.getMessage(), e);
		}
		
		return accountId;
    }
    

    public static String getWorkspaceId(String accountId, String workspaceName) {
    	
    	String workspaceId=null;
    	
		try {
			String requestURL = ExecutionVariables.baseURL+ConfigManager.getString(ApiEndpoints.WORKSPACES.key())+"/search";
				
			String accessToken = ApiConstants.getAuthToken();
						
			Map<String, String> extraHeaders = new HashMap<>();
			extraHeaders.put("Org-Id", "org-"+ConfigManager.getString(ApiEndpoints.ORG_ID.key()));
			extraHeaders.put("Account-Id", accountId);

			Map<String, Object> searchItem = new HashMap<>();
			searchItem.put("attribute", "name");
			searchItem.put("operator", "equals");
			searchItem.put("value", workspaceName);

			Map<String, Object> bodyMap = new HashMap<>();
			bodyMap.put("search", new Object[]{ searchItem });

			Response response = RequestBuilder.sendRequest(HttpMethod.POST.toString(), requestURL, bodyMap, accessToken, extraHeaders, ApiConstants.applicationJson, null);
			
			if (response != null && response.getStatusCode() == 200) {
				workspaceId = RestAPIUtil.getJsonPathValue(response, "items[0].id", String.class);
			    ApiConstants.setWorkspaceId(workspaceId);
			} else {
			    logger.error("Response is null or returned non-200 status. Cannot extract token.");
			    BaseClass.reportFailLog("Error while getWorkspaceId, Responce: "+response, "getWorkspaceId");
			}
		} catch (Exception e) {
			 	BaseClass.reportErrorLog("Exception occur while getWorkspaceId request: "+e.getMessage());
	            logger.error("Exception occur while getWorkspaceId request: {}", e.getMessage(), e);
		}
		
		return workspaceId;
    }
    
    public static String getConnectionListUsingConnector(String workspaceid, String connectorName) {
    	
    	String connectionId=null;
    	
		try {
			String requestURL = ExecutionVariables.baseURL+ConfigManager.getString(ApiEndpoints.CONNECTIONS.key())+"/search";
				
			String accessToken = ApiConstants.getAuthToken();
						
			Map<String, String> extraHeaders = new HashMap<>();
			//extraHeaders.put("Org-Id", "org-"+ConfigManager.getString(ApiEndpoints.ORG_ID.key()));
			extraHeaders.put("Workspace-Id", workspaceid);

			Map<String, Object> searchItem = new HashMap<>();
			searchItem.put("attribute", "connectorId");
			searchItem.put("operator", "In");
			searchItem.put("value", connectorName);

			Map<String, Object> bodyMap = new HashMap<>();
			bodyMap.put("filter", new Object[]{ searchItem });

			Response response = RequestBuilder.sendRequest(HttpMethod.POST.toString(), requestURL, bodyMap, accessToken, extraHeaders, ApiConstants.applicationJson, null);
			
			if (response != null && response.getStatusCode() == 200) {
				connectionId = RestAPIUtil.getJsonPathValue(response, "items.id", String.class);
			    ApiConstants.setWorkspaceId(connectionId);
			} else {
			    logger.error("Response is null or returned non-200 status. Cannot extract token.");
			    BaseClass.reportFailLog("Error while getWorkspaceId, Responce: "+response, "getWorkspaceId");
			}
		} catch (Exception e) {
			 	BaseClass.reportErrorLog("Exception occur while getWorkspaceId request: "+e.getMessage());
	            logger.error("Exception occur while getWorkspaceId request: {}", e.getMessage(), e);
		}
		
		return connectionId;
    }
    
   
}
