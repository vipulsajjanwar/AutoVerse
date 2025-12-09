package com.framework.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.framework.base.BaseClass;
import com.framework.constant.ApiConstants;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Modern, Optimized API Utility using OkHttp
 */
public class RestAPIUtil {

	private static final Logger logger = LogManager.getLogger(RestAPIUtil.class);

	private RestAPIUtil() {}

	//------------------------------------ REST API VALIDATIONS HELPER METHODS -----------------------

	public static void validateListValues(Response response, String jsonKey,
			List<String> expectedValues) {

		List<String> actualValues = response.jsonPath().getList(jsonKey);

		if (actualValues == null) {
			BaseClass.reportFailLog("Expected list for key '" + jsonKey + "' but got null", "validateListValues");
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

	public static void validateResponseNotNull(Response response) {
		try {
			BaseClass.reportLog("Verifying Response is Null or not Null");
			Assert.assertNotNull(response, "Response is NULL");
			BaseClass.reportPassLog("Response is NOT NULL");
			logger.info("Response object validated - not null");

		} catch (AssertionError e) {
			BaseClass.reportFailLog("Response is NULL", "validateResponseNotNull");
			logger.error("Response is NULL!", e);

		}catch(Exception e){
			BaseClass.reportErrorLog("Error observed while validateResponseNotNull");
		}
	}

	public static void validateStatusCode(Response response, int expectedStatusCode) {
		try {
			BaseClass.reportLog("Verifying Response Status code");

			ApiConstants.setStatusCode(response.getStatusCode());

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

		}catch(Exception e){
			BaseClass.reportErrorLog("Error observed while validateStatusCode");
		}
	}

	public static void validateResponseBodyContains(Response response, String expectedText) {
		String body = response.getBody().asString();

		try {
			Assert.assertTrue(body.contains(expectedText),
					"Body does not contain expected text: " + expectedText);

			BaseClass.reportPassLog("Body contains: " + expectedText);
			logger.info("Body contains {}", expectedText);

		} catch (AssertionError e) {
			BaseClass.reportFailLog("Expected text NOT found in body: " + expectedText,
					"validateResponseBodyContains");
			logger.error("Body text missing: {}", expectedText);
			throw e;
		}catch(Exception e){
			BaseClass.reportErrorLog("Error observed while validateResponseBodyContains");
		}
	}

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

			}catch(Exception e){
				BaseClass.reportErrorLog("Error observed while validateJsonStringMap");
			}
		});
	}

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

			}catch(Exception e){
				BaseClass.reportErrorLog("Error observed while validateJsonObjectMap");
			}
		});
	}

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
		}catch(Exception e){
			BaseClass.reportErrorLog("Error observed while validateResponseTime");
		}
	}

	private static JsonPath getJsonPath(Response response) {
		try {
			return response.jsonPath();

		} catch (Exception e) {
			BaseClass.reportFailLog("Response is NOT valid JSON", "getJsonPath");
			logger.error("Invalid JSON", e);
			throw new AssertionError("Response not a valid JSON");
		}
	}

	public static void validateSchema(Boolean check, Response response, String schemaPath) {
		try {
			if(!check) return ;
			// schemaValidate may be null/empty; guard and check file existence
			if (schemaPath != null && !schemaPath.trim().isEmpty()) {

				File f = new File(schemaPath);

				if (!f.exists()) {
					logger.info("Schema file not found at: {}", schemaPath);
					BaseClass.reportLog("Schema file not found, skipping schema validation: " + schemaPath);
					return ;
				}

				BaseClass.reportLog("Schema Validation Started: " + schemaPath);

				response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));

				BaseClass.logSchemaAndResponse(JsonUtil.readJsonAsPrettyString(schemaPath), response.asPrettyString());

				BaseClass.reportPassLog("Schema validation passed : " + schemaPath);
				logger.info("Schema validation passed for schema: {}", schemaPath);
			}
		} catch (AssertionError e) {
			BaseClass.reportFailLog("Schema validation FAILED → " + schemaPath, "validateSchema");
			logger.error("Schema validation failed for schema {}: {}", schemaPath, e.getMessage());
			throw e;
		}catch(Exception e){
			BaseClass.reportErrorLog("Error observed while validateSchema");
		}
	}

	/**
	 * Build expectedFields map from test data row that contains comma-separated keys in 'keyValidate' column.
	 */
	public static Map<String, String> buildExpectedFields(Map<String, String> testData, String keyValidate) {
		Map<String, String> expectedFields = new HashMap<>();

		String validateKeys = testData.get(keyValidate);

		if (validateKeys == null || validateKeys.trim().isEmpty()) {
			return expectedFields;
		}

		String[] keys = validateKeys.split(",");
		for (String key : keys) {
			String trimmedKey = key.trim();
			String value = testData.get(trimmedKey);
			if (value != null) {
				expectedFields.put(trimmedKey, value);
			}
		}

		return expectedFields;
	}

	public static void validateSchemaByStatus(Response response) {
		int status = response.getStatusCode();

		String schema;
		switch (status) {
		case 200 -> {
			schema = "src/test/resources/schemas/createUserSuccessSchema.json";
		}
		case 409 -> {
			schema = "src/test/resources/schemas/errorSchema.json";
		}
		default -> {
			schema = "src/test/resources/schemas/defaultErrorSchema.json";
		}
		}

		validateSchema(true, response, schema);
	}

	public static void validateResponseHeaders( boolean check,
			Response response,
			Map<String, String> requestHeaders,
			List<String> excludeHeaders
			) {
		if(!check) return;

		Map<String, String> responseHeaders = new HashMap<>();

		for (Header h : response.getHeaders()) {
			responseHeaders.put(h.getName(), h.getValue());
		}

		BaseClass.reportLog("---- Validating Response Headers ----");

		for (Map.Entry<String, String> reqHeader : requestHeaders.entrySet()) {

			String key = reqHeader.getKey();
			String expectedValue = reqHeader.getValue();

			if (excludeHeaders != null && excludeHeaders.contains(key)) {
				BaseClass.reportLog("Skipping header validation → " + key);
				continue;
			}

			try {
				Assert.assertTrue(responseHeaders.containsKey(key),
						"Header missing: " + key);

				String actualValue = responseHeaders.get(key);

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
			} catch (AssertionError e) {
				BaseClass.reportFailLog("Header validation FAILED → " + key + " (Expected: " + expectedValue + ")", "validateResponseHeaders");
				logger.error("Header validation failed for {} : {}", key, e.getMessage());
				throw e;
			}
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

			BaseClass.reportPassLog("Header validated → " + key + ": " + responseHeaders.get(key));
		}
	}

	public static boolean validateJsonPath(Response response, Map<String, String[]> validations) {
		boolean flag = true;

		try {
			JsonPath jsonPath = response.jsonPath();

			for (Map.Entry<String, String[]> entry : validations.entrySet()) {
				String path = entry.getKey();
				String conditionRaw = entry.getValue()[0];
				String expectedValueRaw = entry.getValue()[1];

				String condition = conditionRaw == null ? "" : conditionRaw.trim().toUpperCase();
				String expectedValue = expectedValueRaw == null ? "" : expectedValueRaw.trim();

				// Fetch all matching objects (supports $.. and array paths)
				List<Object> actualValues = null;
				try {
					actualValues = jsonPath.getList(path);
				} catch (Exception e) {
					// try single value fallback
					Object single = jsonPath.get(path);
					if (single != null) {
						actualValues = Arrays.asList(single);
					}
				}

				if (actualValues == null || actualValues.isEmpty()) {
					BaseClass.reportFailLog("No values found for JSONPath: " + path, "validateJsonPath");
					flag = false;
					continue;
				}

				// support multiple expected alternatives separated by "||"
				String[] expectedAlternatives = expectedValue.split("\\|\\|");

				for (Object valObj : actualValues) {
					String actual = valObj == null ? "" : valObj.toString();
					boolean conditionPassed = false;

					// Normalize condition synonyms
					switch (condition.toUpperCase()) {
					case "EQUALS":

						for (String alt : expectedAlternatives) {
							if (actual.toLowerCase().equalsIgnoreCase(alt.toLowerCase())) {
								conditionPassed = true;
								break;
							}
						}
						break;

					case "LIKE":

						for (String alt : expectedAlternatives) {
							if (actual.toLowerCase().contains(alt.toLowerCase())) {
								conditionPassed = true;
								break;
							}
						}
						break;

					case "STARTSWITH":

						for (String alt : expectedAlternatives) {
							if (actual.toLowerCase().startsWith(alt.toLowerCase())) {
								conditionPassed = true;
								break;
							}
						}
						break;

					case "ENDSWITH":

						for (String alt : expectedAlternatives) {
							if (actual.toLowerCase().endsWith(alt.toLowerCase())) {
								conditionPassed = true;
								break;
							}
						}
						break;

					default:
						BaseClass.reportFailLog("Unsupported condition '" + condition + "' for JSONPath: " + path, "validateJsonPath");
						flag = false;
					}

					if (conditionPassed) {
						BaseClass.reportPassLog("JSONPath '" + path + "' validated successfully. " +
								"Expected Condition [" + condition + " ' Values :" + expectedValue 
								+ "'], Actual [" + actual + "]");
					} else {
						BaseClass.reportFailLog("Validation FAILED for path '" + path + "': Expected [" + condition + " '" + expectedValue + "'], Actual [" + actual + "]", "validateJsonPath");
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			BaseClass.reportErrorLog("Exception occurred in validateJsonPath: " + e.getMessage());
			logger.error("validateJsonPath exception", e);
			flag = false;
		}

		return flag;
	}

	/**
	 * Generic helper to convert three columns (possibly containing multiple delimited entries)
	 * into the Map<String,String[]> validations.
	 *
	 * Accepts:
	 *   jsonPathCol   -> raw string from Excel JSONPath column (supports multiple entries separated by "||")
	 *   conditionCol  -> raw string from Excel condition column (supports multiple entries separated by "||")
	 *   expectedCol   -> raw string from Excel expected value column (supports multiple entries separated by "||")
	 *
	 * Examples:
	 *   jsonPathCol = "$[0].name||$..name"
	 *   conditionCol = "EQUALS||CONTAINS"
	 *   expectedCol = "Leanne Graham||Leanne"
	 *
	 * Returns a map:
	 *   $[0].name -> [EQUALS, Leanne Graham]
	 *   $..name   -> [CONTAINS, Leanne]
	 */
	public static Map<String, String[]> getValidationsFromExcel(
			String jsonPathCol,
			String conditionCol,
			String expectedCol) {

		Map<String, String[]> validations = new LinkedHashMap<>();

		try {
			if ((jsonPathCol == null || jsonPathCol.trim().isEmpty())
					|| (conditionCol == null || conditionCol.trim().isEmpty())
					|| (expectedCol == null || expectedCol.trim().isEmpty())) {
				return validations;
			}

			// split rows by double-pipe || (common delimiter), or newline fallback
			String[] paths = jsonPathCol.split("\\|\\|");
			String[] conditions = conditionCol.split("\\|\\|");
			String[] expecteds = expectedCol.split("\\|\\|");

			int max = Math.max(paths.length, Math.max(conditions.length, expecteds.length));

			for (int i = 0; i < max; i++) {
				String path = i < paths.length ? paths[i].trim() : "";
				String cond = i < conditions.length ? conditions[i].trim() : "";
				String exp = i < expecteds.length ? expecteds[i].trim() : "";

				if (path.isEmpty() || cond.isEmpty() || exp.isEmpty()) {
					BaseClass.reportLog("Skipping empty validation entry at index " + i);
					continue;
				}

				validations.put(path, new String[]{cond, exp});
			}
		} catch (Exception e) {
			BaseClass.reportErrorLog("Error in getValidationsFromExcel: " + e.getMessage());
			logger.error("getValidationsFromExcel error", e);
		}

		return validations;
	}


	public static boolean validateJson(JsonPath jsonPath, Map<String, String[]> validations) {

		boolean finalFlag = true;

		for (Map.Entry<String, String[]> entry : validations.entrySet()) {

			String path = entry.getKey();
			String condition = entry.getValue()[0].trim().toUpperCase();
			String expected = entry.getValue()[1].trim();

			List<String> actualValues = resolve(jsonPath, path);

			if (actualValues.isEmpty()) {
				BaseClass.reportFailLog("No values found for path: " + path, "validateJson");
				finalFlag = false;
				continue;
			}

			for (String actual : actualValues) {

				boolean passed = evaluate(actual, expected, condition);

				if (passed) {
					BaseClass.reportPassLog(
							"PASS → Path: " + path +
							" | Condition: " + condition +
							" | Expected: " + expected +
							" | Actual: " + actual
							);
				} else {
					BaseClass.reportFailLog(
							"FAIL → Path: " + path +
							" | Condition: " + condition +
							" | Expected: " + expected +
							" | Actual: " + actual,
							"validateJson"
							);
					finalFlag = false;
				}
			}
		}

		return finalFlag;
	}

	public static List<String> resolve(JsonPath jp, String path) {

		List<String> results = new ArrayList<>();

		try {
			// First try list
			List<Object> list = jp.getList(path);
			if (list != null) {
				list.forEach(item -> results.add(item != null ? item.toString() : ""));
				return results;
			}
		} catch (Exception ignored) {}

		try {
			// Then try single value
			Object single = jp.get(path);
			if (single != null) {
				results.add(single.toString());
			}
		} catch (Exception ignored) {}

		return results;
	}

	public static boolean evaluate(String actual, String expected, String condition) {

		if (actual == null) actual = "";
		if (expected == null) expected = "";

		String act = actual.trim();
		String exp = expected.trim();

		switch (condition.toUpperCase()) {

		case "EQUALS":
			return act.equalsIgnoreCase(exp);

		case "IN":  // exp = "admin, user, manager"
			return Arrays.stream(exp.split(","))
					.map(String::trim)
					.anyMatch(a -> a.equalsIgnoreCase(act));

		case "CONTAINS":
			return act.toLowerCase().contains(exp.toLowerCase());

		case "STARTS_WITH":
			return act.toLowerCase().startsWith(exp.toLowerCase());

		case "ENDS_WITH":
			return act.toLowerCase().endsWith(exp.toLowerCase());

		default:
			throw new IllegalArgumentException("Unsupported condition: " + condition);
		}
	}
	// ================= COMMON JSON VALUE EXTRACTOR =================
	private static List<String> extractValues(Response response, String jsonPath) {
		Object raw = response.jsonPath().get(jsonPath);

		if (raw == null) return Collections.emptyList();

		if (raw instanceof List<?>) {
			return ((List<?>) raw).stream()
					.map(v -> v == null ? null : v.toString())
					.collect(Collectors.toList());
		}

		return List.of(raw.toString()); // single value
	}

	private static String stripUUIDPrefix(String value) {
		if (value == null) return null;

		value = value.replaceAll("(?i)^(uuid:|id:|user-|uid_|obj-|key:)", "");
		value = value.replaceAll("[^a-fA-F0-9\\-]", "");

		return value.trim();
	}


	public static void validateUUID(Response response, String jsonPath) {

		List<String> values = extractValues(response, jsonPath);

		if (values.isEmpty()) {
			throw new AssertionError("UUID value not found at path: " + jsonPath);
		}

		for (String raw : values) {
			String cleaned = stripUUIDPrefix(raw);

			try {
				UUID.fromString(cleaned);
				BaseClass.reportPassLog("Valid UUID at '" + jsonPath + "' : " + cleaned);
			} catch (Exception e) {
				BaseClass.reportFailLog("Invalid UUID at '" + jsonPath + "' → " + raw, "validateUUID");
				throw new AssertionError("Invalid UUID at path: " + jsonPath + " → " + raw);
			}
		}
	}



	public static void validatePattern(Response response, String jsonPath, String regex) {

		List<String> values = extractValues(response, jsonPath);

		if (values.isEmpty()) {
			throw new AssertionError("No value found at '" + jsonPath + "'");
		}

		Pattern pattern = Pattern.compile(regex);

		for (String value : values) {
			if (!pattern.matcher(value).matches()) {
				BaseClass.reportFailLog("Pattern FAILED at '" + jsonPath +
						"'. Expected: " + regex + " | Actual: " + value, "validatePattern");
				throw new AssertionError("Pattern mismatch at '" + jsonPath + "' → " + value);
			}

			BaseClass.reportPassLog("Pattern PASSED at '" + jsonPath + "' Value: " + value);
		}
	}



	public static void validateStringLength(Response response, String jsonPath, int min, int max) {

		List<String> values = extractValues(response, jsonPath);

		if (values.isEmpty()) {
			throw new AssertionError(jsonPath + " is NULL or empty");
		}

		for (String value : values) {
			if (value.length() < min || value.length() > max) {
				BaseClass.reportFailLog(jsonPath + " length invalid. Expected " + min + "-" + max +
						", Actual: " + value.length(), "validateStringLength");
				throw new AssertionError("Invalid string length at '" + jsonPath + "'");
			}

			BaseClass.reportPassLog(
					"String length PASSED at '" + jsonPath + "' Length: " + value.length());
		}
	}



	public static void validateBoolean(Response response, String jsonPath) {

		List<String> values = extractValues(response, jsonPath);

		if (values.isEmpty()) {
			throw new AssertionError("Boolean value missing at '" + jsonPath + "'");
		}

		for (String value : values) {
			if (!"true".equalsIgnoreCase(value) && !"false".equalsIgnoreCase(value)) {
				BaseClass.reportFailLog("Boolean FAILED at '" + jsonPath +
						"'. Actual: " + value, "validateBoolean");
				throw new AssertionError("Expected boolean at '" + jsonPath + "'");
			}

			BaseClass.reportPassLog("Boolean PASSED at '" + jsonPath + "' Value: " + value);
		}
	}



	public static void validateDateFormat(Response response, String jsonPath, String format) {

		List<String> values = extractValues(response, jsonPath);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);

		if (values.isEmpty()) {
			throw new AssertionError("Date missing at '" + jsonPath + "'");
		}

		for (String value : values) {
			try {
				sdf.parse(value);
				BaseClass.reportPassLog("Date Format PASSED at '" + jsonPath + "'. Value: " + value);
			} catch (Exception e) {
				BaseClass.reportFailLog(
						"Date Format FAILED at '" + jsonPath +
						"'. Expected: " + format + " | Actual: " + value,
						"validateDateFormat");
				throw new AssertionError("Invalid date at '" + jsonPath + "'");
			}
		}
	}


	public static void validateArrayNotEmpty(Response response, String jsonPath) {
		List<?> list = response.jsonPath().getList(jsonPath);

		if (list == null || list.isEmpty()) {
			BaseClass.reportFailLog("Array empty or null → " + jsonPath, "validateArrayNotEmpty");
			throw new AssertionError("Array '" + jsonPath + "' is empty or null.");
		}

		BaseClass.reportPassLog("Array PASSED at '" + jsonPath + "' Size: " + list.size());
	}


}

