package com.framework.restassured;

import java.util.Map;

import com.framework.base.BaseClass;

import io.restassured.response.Response;

public class ResponseValidator {
	
	private ResponseValidator() {}
	
	public static String getErrorCodeSchemaValidationFile(String method, Response response, String schemaFolderPath, String schemaFileName) {

	    int statusCode = response.getStatusCode();

	    
	    String basePath = (schemaFolderPath == null || schemaFolderPath.isEmpty())
	            ? BaseClass.SCHEMAFOLDERPATH
	            : schemaFolderPath;

	   
	    if (!basePath.endsWith("/")) {
	        basePath = basePath + "/";
	    }

	    // Error → errorSchema.json mapping
	    Map<Integer, String> errorSchemas = Map.of(
	            400, "errors/400Schema.json",
	            401, "errors/401Schema.json",
	            403, "errors/403Schema.json",
	            404, "errors/404Schema.json",
	            409, "errors/409Schema.json",
	            415, "errors/404Schema.json"
	    );
	    
	    if ((method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("DELETE")) && statusCode==400) {
	    	 return basePath + "errors/404Schema.json";
	    }
	    if(method.equalsIgnoreCase("PUT") && statusCode==400) {
	    	String err =response.getBody().asString();
	    	if(err.contains("uuid")) {
	    		return basePath + "errors/404Schema.json";
	    	}
	    }

	    // If status code exists in error map → return corresponding error schema
	    if (errorSchemas.containsKey(statusCode)) {
	        return basePath + errorSchemas.get(statusCode);
	    }

	    // Default: normal schema for valid 2xx response
	    if (schemaFileName == null || schemaFileName.isEmpty()) {
	        throw new RuntimeException("schemaFileName is required for non-error responses.");
	    }

	    return basePath + "admin/" + schemaFileName;
	}

}
