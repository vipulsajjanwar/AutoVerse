package com.framework.constant;

public class ApiConstants {
	
	public static String authToken;
	
	public static String applicationJson="application/json";

	public static String getAuthToken() {
        return authToken;
    }

    public static void setAuthToken(String token) {
        authToken = token;
    }
}
