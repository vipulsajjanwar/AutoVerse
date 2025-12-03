package com.framework.restassured;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;
import com.framework.report.ExtentManager;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAPI {

	public static final Logger logger = LogManager.getLogger(RestAPI.class);

	private static RequestSpecification applyHeaders(RequestSpecification req, 
			String token, 
			Map<String, String> extraHeaders) {

		// Default header
		req.header("Content-Type", "application/json");

		// Token header
		if (token != null && !token.isEmpty()) {
			req.header("Authorization", String.format("Bearer %s", token));
		}

		// Extra/custom headers
		if (extraHeaders != null && !extraHeaders.isEmpty()) {
			extraHeaders.forEach(req::header);
		}

		return req;
	}


	//----------------------------------------------------------
	//------------------------ GET ------------------------------
	//----------------------------------------------------------
	public Response get(String url, String token, Map<String, String> extraHeaders) {
		BaseClass.reportLog("GET Request URL => " + url);
		logger.info("GET Request: {}", url);

		RequestSpecification req = RestAssured.given();
		applyHeaders(req, token, extraHeaders);

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
	public static Response post(String url, Object body, String token, Map<String, String> extraHeaders) {
		BaseClass.reportLog("POST Request URL => " + url);
		BaseClass.reportLog("Request Body :");
		BaseClass.reportCodeLog(body.toString());
		logger.info("POST Request: {}", url);
		logger.info("Body: {}", body);

		Response response=null;
		try {
			RequestSpecification req = RestAssured.given();
			applyHeaders(req, token, extraHeaders);

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
		applyHeaders(req, token, extraHeaders);

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
		applyHeaders(req, token, extraHeaders);

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
		BaseClass.reportLog("Response Body:");
		BaseClass.reportCodeLog(responseBody);

		logger.info("Status Code: {}" , statusCode);
		logger.info("Response Body: {}" , responseBody);

		if (statusCode >= 200 && statusCode < 300) {
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

			// Custom headers
			Map<String, String> extraHeaders = new HashMap<>();
			extraHeaders.put("Content-Type", "application/x-www-form-urlencoded");

			Response responce = post(
					url,
					formData,
					null,
					extraHeaders
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
            Map<String, String> expectedJsonFields
          
    ) {
		String method="validateApiResponse";
       
        try {
        	Assert.assertNotNull(response, "Response is NULL");
           BaseClass.reportPassLog("Response object is NOT null");
            logger.info("Response object validated - not null");

        } catch (AssertionError e) {
            BaseClass.reportFailLog("Response is NULL", method);
            logger.error("Response is NULL !!");
            throw e;
        }

        // ------------------- STATUS CODE VALIDATION -------------------
        try {
        	Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                    "Status code mismatch");

            BaseClass.reportPassLog("Status Code Validated: " + expectedStatusCode);
            logger.info("Status Code Validated: {}", expectedStatusCode);

        } catch (AssertionError e) {
            BaseClass.reportFailLog("Status Code Mismatch. Expected: " 
                    + expectedStatusCode + ", Actual: " + response.getStatusCode(), method);
            logger.error("Status Code mismatch. Expected {} Actual {}", expectedStatusCode, response.getStatusCode());
            throw e;
        }

        // ------------------- BODY STRING VALIDATION -------------------
        if (expectedBodyContains != null && !expectedBodyContains.isEmpty()) {
            String body = response.getBody().asString();

            try {
            	Assert.assertTrue(body.contains(expectedBodyContains),
                        "Body does not contain expected text: " + expectedBodyContains);

                BaseClass.reportPassLog("Response body contains: " + expectedBodyContains);
                logger.info("Body contains expected value {}", expectedBodyContains);

            } catch (AssertionError e) {
                BaseClass.reportFailLog("Expected text NOT found in response body: " + expectedBodyContains, method);
                logger.error("Expected body text not found: {}", expectedBodyContains);
                throw e;
            }
        }

        // ------------------- JSON FIELD VALIDATION -------------------
        if (expectedJsonFields != null && !expectedJsonFields.isEmpty()) {
            JsonPath json = null;

            try {
                json = response.jsonPath();
            } catch (Exception ex) {
            	BaseClass.reportFailLog("Response is NOT valid JSON","");
                logger.error("Response not in JSON format", ex);
                throw new AssertionError("Response not JSON");
            }

            for (Map.Entry<String, String> entry : expectedJsonFields.entrySet()) {
                String key = entry.getKey();
                String expectedValue = entry.getValue();

                try {
                    Object actualValue = json.get(key);
                    Assert.assertNotNull(actualValue, "JSON key missing: " + key);
                    Assert.assertEquals(actualValue.toString(), expectedValue,
                            "JSON value mismatch for key: " + key);

                    BaseClass.reportPassLog("JSON Key Validated: " + key + " = " + expectedValue);
                    logger.info("JSON Key Validated: {} = {}", key, expectedValue);

                } catch (AssertionError e) {
                    BaseClass.reportFailLog("JSON Key Mismatch → Key: " + key + 
                            ", Expected: " + expectedValue, method);
                    logger.error("JSON validation failed for key {} expected {}", key, expectedValue);
                    throw e;
                }
            }
        }

        // ------------------- RESPONSE TIME VALIDATION (Optional) -------------------
        try {
            long time = response.getTime();
            Assert.assertTrue(time < 5000, "API response time exceeded limit");

            BaseClass.reportPassLog("Response time validated (" + time + " ms)");
            logger.info("Response time validated: {} ms", time);

        } catch (AssertionError e) {
        	BaseClass.reportFailLog(" API response took too long: " + response.getTime() + " ms", "");
            logger.error("Slow response: {} ms", response.getTime());
            throw e;
        }
    }



}
