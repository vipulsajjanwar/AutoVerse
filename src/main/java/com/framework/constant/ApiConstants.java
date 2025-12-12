package com.framework.constant;

public class ApiConstants {
	
	public static String authToken;
	
	public static int statusCode;
	
	public static String applicationJson="application/json";
	
	static String workspaceId;
	static String accountId;

	public static String getAuthToken() {
        return authToken;
    }

    public static void setAuthToken(String token) {
        authToken = token;
    }

	public static int getStatusCode() {
		return statusCode;
	}

	public static void setStatusCode(int statusCode) {
		ApiConstants.statusCode = statusCode;
	}

	public static String getWorkspaceId() {
		return workspaceId;
	}

	public static void setWorkspaceId(String WorkspaceId) {
		workspaceId = WorkspaceId;
	}

	public static String getAccountId() {
		return accountId;
	}

	public static void setAccountId(String AccountId) {
		accountId = AccountId;
	}
    
    
}
