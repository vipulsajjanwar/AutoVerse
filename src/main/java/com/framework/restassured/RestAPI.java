package com.framework.restassured;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentManager;
import com.framework.utils.JsonUtil;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI {

	public static final Logger logger = LogManager.getLogger(RestAPI.class);

	static String schemasFolderPath = BaseClass.DIR_PATH+"/src/test/resources/schemas/";

	private static RequestSpecification applyHeaders(RequestSpecification req, 
			String token, 
			Map<String, String> extraHeaders, String contentType) {
		// ---------------- ADD & LOG HEADERS ----------------
		Map<String, String> headerLogMap = new HashMap<>();

		// Default header
		req.header("Content-Type", contentType);
		headerLogMap.put("Content-Type", contentType);
		// Token header
		if (token != null && !token.isEmpty()) {
			req.header("Authorization", String.format("Bearer %s", token));
			headerLogMap.put("Authorization", "Bearer " + token);
		}

		if (extraHeaders != null) {
			for (Map.Entry<String, String> entry : extraHeaders.entrySet()) {
				req.header(entry.getKey(), entry.getValue());
				headerLogMap.put(entry.getKey(), entry.getValue());
			}
		}

		// Log headers in Extent
		BaseClass.reportLog("Request Headers:");
		BaseClass.reportCodeLog(headerLogMap.toString());
		logger.info("Request Headers: {}", headerLogMap);

		return req;
	}


	//----------------------------------------------------------
	//------------------------ GET ------------------------------
	//----------------------------------------------------------
	public Response get(String url, String token, Map<String, String> extraHeaders) {
		BaseClass.reportLog("GET Request URL => " + url);
		logger.info("GET Request: {}", url);

		RequestSpecification req = RestAssured.given();
		applyHeaders(req, token, extraHeaders, "application/json");

		Response response = req.when()
				.get(url)
				.then()
				.log().all()
				.extract().response();

		logResponse(response);
		return response;
	}

	//----------------------------------------------------------
	//------------------------ POST -----------------------------
	//----------------------------------------------------------
	public static Response post(String url, Object body, String token, Map<String, String> extraHeaders, String contentType) {
		Response response=null;
		try {

			BaseClass.reportLog("POST Request URL => " + url);
			logger.info("POST Request: {}", url);
						
			RequestSpecification req = RestAssured.given();
			applyHeaders(req, token, extraHeaders, contentType);
			
			BaseClass.reportLog("Request Body :");
			BaseClass.reportCodeLog(JsonUtil.toPrettyJson(body));
			logger.info("Body: {}", body);
			
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

	//----------------------------------------------------------
	//------------------------ PUT ------------------------------
	//----------------------------------------------------------
	public Response put(String url, Object body, String token, Map<String, String> extraHeaders) {
		BaseClass.reportLog("PUT Request URL => " + url);
		BaseClass.reportCodeLog("Request Body => " + body);
		logger.info("PUT Request: {}" , url);
		logger.info("Body: {}" , body);

		RequestSpecification req = RestAssured.given();
		applyHeaders(req, token, extraHeaders, "application/json");

		Response response = req.body(body)
				.when()
				.put(url)
				.then()
				.log().all()
				.extract().response();

		logResponse(response);
		return response;
	}

	//----------------------------------------------------------
	//------------------------ DELETE ---------------------------
	//----------------------------------------------------------
	public Response delete(String url, String token, Map<String, String> extraHeaders) {
		BaseClass.reportLog("DELETE Request URL => " + url);
		logger.info("DELETE Request: {}" , url);

		RequestSpecification req = RestAssured.given();
		applyHeaders(req, token, extraHeaders, "application/json");

		Response response = req.when()
				.delete(url)
				.then()
				.log().all()
				.extract().response();

		logResponse(response);
		return response;
	}

	//----------------------------------------------------------
	//--------------------- Logging Helper ----------------------
	//----------------------------------------------------------
	private static void logResponse(Response response) {
		int statusCode = response.getStatusCode();
		String responseBody = response.asPrettyString();

		BaseClass.reportLog("Status Code: " + statusCode);
		
		validateResponseNotNull(response);
		
		BaseClass.reportLog("Response Body:");
		BaseClass.reportCodeLog(responseBody);

		logger.info("Status Code: {}" , statusCode);
		logger.info("Response Body: {}" , responseBody);

		if (statusCode < 500) {
			BaseClass.reportPassLog("API call successful");
			logger.info("API call successful");
		} else {
			ExtentManager.getTest().fail("API returned error code: " + statusCode);
			logger.error("API returned error code: {}" ,  statusCode);
		}
	}


	public static String generateAuthToken(String url, String userName, String password) {
		String token=null;
		try {
			// Body for x-www-form-urlencoded
			String formData = String.format(
					"grant_type=%s&client_id=%s&username=%s&password=%s",
					"password",
					"icedq.admin-ui",
					userName,
					password
					);

			Response responce = post(
					url,
					formData,
					"",
					null,
					"application/x-www-form-urlencoded"
					);

			if (responce != null && responce.getStatusCode() == 200) {
				token = responce.jsonPath().getString("access_token");
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


	public static void validateApiResponse(
			Response response,
			int expectedStatusCode,
			String expectedBodyContains,
			Map<String, String> expectedJsonFields,
			Map<String, Object> expectedJson,
			String schemaValidate

			) {

		validateStatusCode(response, expectedStatusCode);

		if (expectedBodyContains != null && !expectedBodyContains.isEmpty()) {
			validateResponseBodyContains(response, expectedBodyContains);
		}

		if (expectedJsonFields != null && !expectedJsonFields.isEmpty()) {
			validateJsonStringMap(response, expectedJsonFields);
		}

		if (expectedJson != null && !expectedJson.isEmpty()) {
			validateJsonObjectMap(response, expectedJson);
		}

		validateResponseTime(response, 5000);

		validateSchema(response, schemasFolderPath+schemaValidate);


	}

	public static void validateListValues(Response response, String jsonKey, 
			List<String> expectedValues) {

		List<String> actualValues = response.jsonPath().getList(jsonKey);

		if (actualValues == null) {
			BaseClass.reportFailLog("Expected list for key '" + jsonKey + "' but got null","validateListValues");
			Assert.fail("List is null for key: " + jsonKey);
			return;
		}

		for (String value : expectedValues) {
			Assert.assertTrue(actualValues.contains(value),
					"Missing expected list value: " + value);

			BaseClass.reportPassLog("Validated list value present → " + value);
		}

		logger.info("List validation successful for key {}: {}", jsonKey, actualValues);
	}

	// ---------- Response Object NULL Check ----------
	public static void validateResponseNotNull(Response response) {
		try {
			Assert.assertNotNull(response, "Response is NULL");
			BaseClass.reportPassLog("Response is NOT NULL");
			logger.info("Response object validated - not null");

		} catch (AssertionError e) {
			BaseClass.reportFailLog("Response is NULL", "validateResponseNotNull");
			logger.error("Response is NULL!", e);
			throw e;
		}
	}


	// ---------- Status Code Validation ----------
	public static void validateStatusCode(Response response, int expectedStatusCode) {
		try {
			Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
					"Status code mismatch");

			BaseClass.reportPassLog(
	                "Status Code Validated: → " + 
	                " | Expected: " + expectedStatusCode +
	                " | Actual: " + response.getStatusCode()
	        );
			
			logger.info("Status Code Validated: {}", expectedStatusCode);

		} catch (AssertionError e) {
			BaseClass.reportFailLog("Status Code Mismatch → Expected: "
					+ expectedStatusCode + ", Actual: " + response.getStatusCode(), "validateStatusCode");
			logger.error("Status Code mismatch", e);
			throw e;
		}
	}


	// ---------- Body Must Contain Text ----------
	public static void validateResponseBodyContains(Response response, String expectedText) {
		String body = response.getBody().asString();

		try {
			Assert.assertTrue(body.contains(expectedText),
					"Body does not contain expected text: " + expectedText);

			BaseClass.reportPassLog("Body contains: " + expectedText +" : "+ response.jsonPath().getString(expectedText));
			logger.info("Body contains {}", expectedText+" : "+ response.jsonPath().getString(expectedText));

		} catch (AssertionError e) {
			BaseClass.reportFailLog("Expected text NOT found in body: " + expectedText,
					"validateResponseBodyContains");
			logger.error("Body text missing: {}", expectedText);
			throw e;
		}
	}


	// ---------- Validate JSON String-Based Map ----------
	public static void validateJsonStringMap(Response response, Map<String, String> expectedJsonFields) {
		JsonPath json = getJsonPath(response);

		expectedJsonFields.forEach((key, expectedValue) -> {
			try {
				Object actualValue = json.get(key);

				Assert.assertNotNull(actualValue, "JSON key missing: " + key);
				Assert.assertEquals(actualValue.toString(), expectedValue,
						"Value mismatch for key: " + key);

				BaseClass.reportPassLog("JSON Key Validated: " + key + " = " + expectedValue);
				logger.info("Validated: {} = {}", key, expectedValue);

			} catch (AssertionError e) {
				BaseClass.reportFailLog("JSON mismatch → Key: " + key + ", Expected: " + expectedValue,
						"validateJsonStringMap");
				logger.error("JSON validation failed", e);
				throw e;
			}
		});
	}


	// ---------- Validate JSON Object-Based Map (More Flexible) ----------
	public static void validateJsonObjectMap(Response response, Map<String, Object> expectedJson) {
		JsonPath json = getJsonPath(response);

		expectedJson.forEach((key, expectedValue) -> {
			Object actualValue = json.get(key);

			try {
				Assert.assertNotNull(actualValue, "Value is NULL for key: " + key);
				Assert.assertEquals(actualValue, expectedValue,
						"Mismatch for key: " + key);

				BaseClass.reportPassLog("JSON validated → " + key + " = " + expectedValue);
				logger.info("JSON object validation passed → {} : {}", key, expectedValue);

			} catch (AssertionError e) {
				BaseClass.reportFailLog(
						"JSON Validation FAILED → Key: " + key +
						" (Expected: " + expectedValue + ", Actual: " + actualValue + ")",
						"validateJsonObjectMap");
				logger.error("Object validation failed", e);
				throw e;
			}
		});
	}


	// ---------- Response Time Validation ----------
	public static void validateResponseTime(Response response, long maxTimeMs) {
		long time = response.getTime();

		try {
			Assert.assertTrue(time < maxTimeMs,
					"API response time exceeded " + maxTimeMs + " ms");

			BaseClass.reportPassLog("Response time OK (" + time + " ms)");
			logger.info("Response time validated = {} ms", time);

		} catch (AssertionError e) {
			BaseClass.reportFailLog("Slow API Response: " + time + " ms",
					"validateResponseTime");
			logger.error("Response slow: {} ms", time);
			throw e;
		}
	}


	// ---------- Safe JSONPath Extraction ----------
	private static JsonPath getJsonPath(Response response) {
		try {
			return response.jsonPath();

		} catch (Exception e) {
			BaseClass.reportFailLog("Response is NOT valid JSON", "getJsonPath");
			logger.error("Invalid JSON", e);
			throw new AssertionError("Response not a valid JSON");
		}
	}

	public static void validateSchema(Response response, String schemaPath) {
		try {
			BaseClass.reportLog("Schema Validation Started");

			response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));

			BaseClass.logSchemaAndResponse(JsonUtil.readJsonAsPrettyString(schemaPath), response.asPrettyString());

			BaseClass.reportPassLog("Schema validation passed : " + schemaPath);
			logger.info("Schema validation passed for schema: {}", schemaPath);



		} catch (AssertionError e) {
			BaseClass.reportFailLog("Schema validation FAILED → " + schemaPath, "validateSchema");
			logger.error("Schema validation failed for schema {}: {}", schemaPath, e.getMessage());
			throw e;
		}
	}

	public static Map<String, String> buildExpectedFields(Map<String, String> testData, String keyValidate) {
		Map<String, String> expectedFields = new HashMap<>();

		// Read column "ValidateKey" → e.g. "email,userName,firstName"
		String validateKeys = testData.get(keyValidate);

		if (validateKeys == null || validateKeys.trim().isEmpty()) {
			return expectedFields; // return empty map if nothing to validate
		}

		// Split keys by comma
		String[] keys = validateKeys.split(",");

		for (String key : keys) {
			String trimmedKey = key.trim();

			// Fetch corresponding column value from Excel
			String value = testData.get(trimmedKey);

			// Only add if value exists
			if (value != null) {
				expectedFields.put(trimmedKey, value);
			}
		}

		return expectedFields;
	}

	public static void validateSchemaByStatus(Response response) {
		int status = response.getStatusCode();

		String schema;

		if (status == 200) {
			schema = "src/test/resources/schemas/createUserSuccessSchema.json";
		} else if (status == 409) {
			schema = "src/test/resources/schemas/errorSchema.json";
		} else {
			schema = "src/test/resources/schemas/defaultErrorSchema.json";
		}

		validateSchema(response, schema);
	}
	
	public static void validateResponseHeaders(
	        Response response,
	        Map<String, String> requestHeaders,
	        List<String> excludeHeaders
	) {
	    Map<String, String> responseHeaders = new HashMap<>();

	    // Convert response headers to map
	    for (Header h : response.getHeaders()) {
	        responseHeaders.put(h.getName(), h.getValue());
	    }

	    BaseClass.reportLog("---- Validating Response Headers ----");

	    for (Map.Entry<String, String> reqHeader : requestHeaders.entrySet()) {

	        String key = reqHeader.getKey();
	        String expectedValue = reqHeader.getValue();

	        // Skip validation for excluded headers
	        if (excludeHeaders != null && excludeHeaders.contains(key)) {
	         //   BaseClass.reportLog("Skipping header validation → " + key);
	            continue;
	        }

	        Assert.assertTrue(responseHeaders.containsKey(key),
	                "Header missing: " + key);
	        
	        String actualValue = responseHeaders.get(key);
	        
	        // Validate value match
	        Assert.assertEquals(
	                actualValue,
	                expectedValue,
	                "Header value mismatch for: " + key
	        );

	        BaseClass.reportPassLog(
	                "Header validated → " + key +
	                " | Expected: " + expectedValue +
	                " | Actual: " + actualValue
	        );
	    }

	    logger.info("Response Headers validated successfully");
	}
	
	public static void validateSpecificHeaders(Response response, List<String> headerKeys) {
	    
	    Map<String, String> responseHeaders = new HashMap<>();
	    for (Header h : response.getHeaders()) {
	        responseHeaders.put(h.getName(), h.getValue());
	    }

	    for (String key : headerKeys) {
	        Assert.assertTrue(responseHeaders.containsKey(key),
	                "Response header missing: " + key);

	        BaseClass.reportPassLog("Header validated → " + key + ": "+ responseHeaders.get(key));
	    }
	}

}
