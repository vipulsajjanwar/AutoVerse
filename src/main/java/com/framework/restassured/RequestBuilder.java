package com.framework.restassured;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.BaseClass;
import com.framework.utils.JsonUtil;
import com.framework.utils.RestAPIUtil;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	private RequestBuilder() {}

	public static final Logger logger = LogManager.getLogger(RequestBuilder.class);

	public static Response sendRequest(
			String method,                   // GET / POST / PUT / DELETE / PATCH
			String url,
			Object body,
			String token,
			Map<String, String> extraHeaders,
			String contentType,
			Map<String, Object> queryParams  // optional query params
			) {
		Response response = null;

		try {
			logger.info("=================================== START REST API =============================================");
			logger.info("");
			BaseClass.reportLog(method + " Request URL => " + url);
			logger.info("{} Request: {}", method, url);

			RequestSpecification req = RestAssured.given();

			// ---------------- Headers ----------------
			applyHeaders(req, token, extraHeaders, contentType);

			// ---------------- Query Params ----------------
			if (queryParams != null && !queryParams.isEmpty()) {
				queryParams.forEach(req::queryParam);
				BaseClass.reportLog("Query Params: " + queryParams);
				logger.info("Query Params: {}", queryParams);
			}

			// ---------------- Body ----------------
			if (body != null && !method.equalsIgnoreCase("GET") && !method.equalsIgnoreCase("DELETE")) {
				BaseClass.reportLog("Request Body:");
				BaseClass.reportCodeLog(JsonUtil.toPrettyJson(body));
				Optional.ofNullable(body)
				.ifPresent(b -> logger.info("Body:\n{}", JsonUtil.toPrettyJson(b)));

				Object serializedBody = serializeBody(body, contentType);
				req.body(serializedBody);
			}

			// ---------------- Execute ----------------
			switch (method.toUpperCase()) {
			case "GET": response = req.get(url); break;
			case "POST": response = req.post(url); break;
			case "PUT": response = req.put(url); break;
			case "DELETE": response = req.delete(url); break;
			case "PATCH": response = req.patch(url); break;
			default:
				throw new IllegalArgumentException("Unsupported HTTP method: " + method);
			}

			// ---------------- Log Response ----------------
			response.then().log().all();
			logResponse(response);
			logger.info("");
			logger.info("=================================== END REST API =============================================");

		} catch (Exception e) {
			BaseClass.reportErrorLog(e.getMessage());
			logger.error("Exception while sending request: {}", e.getMessage(), e);
		}

		return response;
	}

	private static String formatHeaders(Map<String, String> headers) {
		StringBuilder sb = new StringBuilder();
		headers.forEach((key, value) ->
		sb.append(key)
		.append(" : ")
		.append(value)
		.append(System.lineSeparator())
				);
		return sb.toString();
	}

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

		String headerLog=formatHeaders(headerLogMap);
		BaseClass.reportCodeLog(headerLog);
		logger.info("Request Headers: \n{}", headerLog);

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
			BaseClass.reportFailLog("API returned error code: " + statusCode, "logResponse");
			logger.error("API returned error code: {}", statusCode);
		}
	}

	public static String getDynamicEndpoints(String url, String stringToBeReplaced, String dynamicValue) {

		return url.replace(stringToBeReplaced, dynamicValue);

	}

	public static String getQueryParameter(String queryParam) {

		if(queryParam!=null && !queryParam.trim().isEmpty()) {

			return "?"+queryParam;
		}else {
			return "";
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
				logger.info("Request Body:  {}", body);
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
		logger.info("Request Body: {}", body);

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


}
