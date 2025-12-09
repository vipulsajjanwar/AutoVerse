package com.framework.restassured;

import java.io.File;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentManager;
import com.framework.utils.JsonUtil;
import com.framework.utils.RestAPIUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI {

    public static final Logger logger = LogManager.getLogger(RestAPI.class);

    // Use absolute schema folder path from BaseClass
    static String schemasFolderPath = BaseClass.DIR_PATH + "/src/test/resources/schemas/";

    private static RequestSpecification applyHeaders(RequestSpecification req,
            String token,
            Map<String, String> extraHeaders,
            String contentType) {

    	Map<String, String> headerLogMap = new LinkedHashMap<>();

    	if (contentType != null && !contentType.trim().isEmpty() && !contentType.equalsIgnoreCase("NA")) {
    		// Normal case
    		req.header("content-type", contentType);
    		
    	}
    	headerLogMap.put("Content-Type", contentType);
    	
    	// Token header (if provided)
    	if (token != null && !token.trim().isEmpty()) {
    		req.header("Authorization", String.format("Bearer %s", token));
    		headerLogMap.put("Authorization", "Bearer " + token);
    	}

    	// Extra headers
    	if (extraHeaders != null) {
    		for (Map.Entry<String, String> entry : extraHeaders.entrySet()) {
    			if (entry.getKey() == null || entry.getKey().trim().isEmpty()) continue;
    			String val = entry.getValue() == null ? "" : entry.getValue();
    			req.header(entry.getKey().trim(), val);
    			headerLogMap.put(entry.getKey().trim(), val);
    		}
    	}

    	// Log headers in Extent
    	BaseClass.reportLog("Request Headers:");
    	BaseClass.reportCodeLog(headerLogMap.toString());
    	logger.info("Request Headers: {}", headerLogMap);

    	return req;
    }
    
    private static Object serializeBody(Object body, String contentType) {

        if (body == null) {
            return null;
        }

        // Normalize content type
        String ct = (contentType == null) ? "" : contentType.trim().toLowerCase();

        try {
            ObjectMapper mapper = new ObjectMapper();

            if(ct.isEmpty()) {
            	 return mapper.writeValueAsString(body);
            }
            	
            // 1) JSON → actual JSON string
            if (ct.contains("application/json")) {
                return mapper.writeValueAsString(body);
            }

            // 3) text/plain → return plain string
            if (ct.contains("text/plain") || ct.equalsIgnoreCase("na")) {
                return mapper.writeValueAsString(body);  // safe string
            }

            // 4) XML → return string
            if (ct.contains("xml")) {
                return body.toString();
            }

            // 5) multipart → as-is
            if (ct.contains("multipart/form-data") || ct.contains("application/x-www-form-urlencoded")) {
                return body;
            }
            
            return JsonUtil.toPrettyJson(body);
          

        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize body: " + e.getMessage(), e);
        }
    }

    // --------------------- HTTP helpers -------------------------

    public Response get(String url, String token, Map<String, String> extraHeaders, String contentType) {
        BaseClass.reportLog("GET Request URL => " + url);
        logger.info("GET Request: {}", url);

        RequestSpecification req = RestAssured.given();
        applyHeaders(req, token, extraHeaders, contentType);

        Response response = req.when()
                .get(url)
                .then()
                .log().all()
                .extract().response();

        logResponse(response);
        return response;
    }

    public static Response post(String url, Object body, String token, Map<String, String> extraHeaders, String contentType) {
        Response response = null;
        try {
            BaseClass.reportLog("POST Request URL => " + url);
            logger.info("POST Request: {}", url);
            
            RequestSpecification req = RestAssured.given();
            applyHeaders(req, token, extraHeaders, contentType);

            if (body != null) {
                BaseClass.reportLog("Request Body :");
                BaseClass.reportCodeLog(JsonUtil.toPrettyJson(body));
                logger.info("Body: {}", body);
            } else {
                BaseClass.reportLog("Request Body : null");
            }
            body = serializeBody(body, contentType);
        
            response = req.body(body)
                    .when()
                    .post(url)
                    .then()
                    .log().all()
                    .extract().response();

            logResponse(response);

        } catch (Exception e) {
            BaseClass.reportErrorLog(e.getMessage());
            logger.error("Exception occur while post request: {}", e.getMessage(), e);
        }
        return response;
    }

    public Response put(String url, Object body, String token, Map<String, String> extraHeaders, String contentType) {
        BaseClass.reportLog("PUT Request URL => " + url);
        BaseClass.reportCodeLog("Request Body => " + body);
        logger.info("PUT Request: {}", url);
        logger.info("Body: {}", body);

        RequestSpecification req = RestAssured.given();
        applyHeaders(req, token, extraHeaders, contentType);
        
        body = serializeBody(body, contentType);

        Response response = req.body(body)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();

        logResponse(response);
        return response;
    }

    public Response delete(String url, String token, Map<String, String> extraHeaders, String contentType) {
        BaseClass.reportLog("DELETE Request URL => " + url);
        logger.info("DELETE Request: {}", url);

        RequestSpecification req = RestAssured.given();
        applyHeaders(req, token, extraHeaders, contentType);

        Response response = req.when()
                .delete(url)
                .then()
                .log().all()
                .extract().response();

        logResponse(response);
        return response;
    }
    
    public static Response sendRequest(
            String method,                   // GET / POST / PUT / DELETE / PATCH
            String url,
            Object body,
            String token,
            Map<String, String> extraHeaders,
            String contentType
    ) {
        Response response = null;

        try {
            BaseClass.reportLog(method + " Request URL => " + url);
            logger.info("{} Request: {}", method, url);

            RequestSpecification req = RestAssured.given();

            // attach headers including empty Content-Type handling
            applyHeaders(req, token, extraHeaders, contentType);

            // body handling
            if (body != null && !method.equalsIgnoreCase("GET") && !method.equalsIgnoreCase("DELETE")) {
                BaseClass.reportLog("Request Body :");
                BaseClass.reportCodeLog(JsonUtil.toPrettyJson(body));

                logger.info("Body: {}", body);

                body = serializeBody(body, contentType);

                req.body(body);
            }

            // Choose the HTTP method
            switch (method.toUpperCase()) {

                case "GET":
                    response = req.when().get(url);
                    break;

                case "POST":
                    response = req.when().post(url);
                    break;

                case "PUT":
                    response = req.when().put(url);
                    break;

                case "DELETE":
                    response = req.when().delete(url);
                    break;

                case "PATCH":
                    response = req.when().patch(url);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported HTTP method: " + method);
            }

            // extract + log
            response.then().log().all();
            logResponse(response);

        } catch (Exception e) {
            BaseClass.reportErrorLog(e.getMessage());
            logger.error("Exception while sending request: {}", e.getMessage(), e);
        }

        return response;
    }

    
    

    // --------------------- Logging Helper -----------------------

    private static void logResponse(Response response) {
        int statusCode = response.getStatusCode();
        String responseBody = response.asPrettyString();

        BaseClass.reportLog("Status Code: " + statusCode);

        RestAPIUtil.validateResponseNotNull(response);

        BaseClass.reportLog("Response Body:");
        BaseClass.reportCodeLog(responseBody);

        logger.info("Status Code: {}", statusCode);
        logger.info("Response Body: {}", responseBody);

        if (statusCode < 500) {
            BaseClass.reportPassLog("API call successful");
            logger.info("API call successful");
        } else {
            ExtentManager.getTest().fail("API returned error code: " + statusCode);
            logger.error("API returned error code: {}", statusCode);
        }
    }

    // --------------------- Auth helper -------------------------

    public static String generateAuthToken(String url, String userName, String password) {
        String token = null;
        try {
            String formData = String.format(
                    "grant_type=%s&client_id=%s&username=%s&password=%s",
                    "password",
                    "icedq.admin-ui",
                    userName,
                    password
            );

            Response response = post(
                    url,
                    formData,
                    "",
                    null,
                    "application/x-www-form-urlencoded"
            );

            if (response != null && response.getStatusCode() == 200) {
                token = response.jsonPath().getString("access_token");
                ApiConstants.setAuthToken(token);
            } else {
                logger.error("Response is null or returned non-200 status. Cannot extract token.");
            }

        } catch (Exception e) {
            BaseClass.reportErrorLog(e.getMessage());
            logger.error("Exception occur while generateAuthToken request: {}", e.getMessage(), e);
        }
        return token;
    }

    // --------------------- Validations -------------------------

    public static void validateApiResponse(
            Response response,
            int expectedStatusCode,
            String expectedBodyContains,
            Map<String, String> expectedJsonFields,
            Map<String, Object> expectedJson,
            String schemaValidate,
            Map<String, String[]> jsonPathValidate
    ) {

    	RestAPIUtil.validateStatusCode(response, expectedStatusCode);

        if (expectedBodyContains != null && !expectedBodyContains.isEmpty()) {
        	RestAPIUtil.validateResponseBodyContains(response, expectedBodyContains);
        }

        if (expectedJsonFields != null && !expectedJsonFields.isEmpty()) {
        	RestAPIUtil.validateJsonStringMap(response, expectedJsonFields);
        }

        if (expectedJson != null && !expectedJson.isEmpty()) {
        	RestAPIUtil.validateJsonObjectMap(response, expectedJson);
        }

        if (jsonPathValidate != null && !jsonPathValidate.isEmpty()) {
        	RestAPIUtil.validateJsonPath(response, jsonPathValidate);
        }

        RestAPIUtil.validateResponseTime(response, 5000);

        // schemaValidate may be null/empty; guard and check file existence
        if (schemaValidate != null && !schemaValidate.trim().isEmpty()) {
            String schemaPath = schemaValidate;
            // If a relative file name provided, prefix with schemasFolderPath
            File f = new File(schemaPath);
            if (!f.exists()) {
                schemaPath = schemasFolderPath + schemaValidate;
            }
            // Only attempt validation if file exists
            if (new File(schemaPath).exists()) {
            	RestAPIUtil.validateSchema(true, response, schemaPath);
            } else {
                BaseClass.reportLog("Schema file not found, skipping schema validation: " + schemaPath);
            }
        } else {
            BaseClass.reportLog("No schema validation requested.");
        }
    }

   
}
