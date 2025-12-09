package com.framework.constant;

public class ApiConstants {
	
	public static String authToken;
	
	public static int statusCode;
	
	public static String applicationJson="application/json";

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
    
    
}
