package com.framework.restassured;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.utils.JsonUtil;

public class RequestBodyBuilder {

	private Object body;

	/* --- NEW: dynamic search & filter holders --- */
	private final List<Map<String, Object>> searchList = new ArrayList<>();
	private final List<Map<String, Object>> filterList = new ArrayList<>();

	private boolean isEmptyValue(Object value) {

		if (value == null) return true;

		if (value instanceof String) {
			return ((String) value).trim().isEmpty();
		}

		if (value instanceof Collection) {
			return ((Collection<?>) value).isEmpty();
		}

		if (value instanceof Map) {
			return ((Map<?, ?>) value).isEmpty();
		}

		return false;
	}

	/* ---------- Existing ---------- */
	public RequestBodyBuilder body(Object body) {
		this.body = body;
		return this;
	}

	/* ---------- NEW: Search ---------- */
	public RequestBodyBuilder addSearch(
			String attribute,
			String operator,
			String datatype,
			Object value) {
		if (isEmptyValue(value)) {
			return this; 
		}
		searchList.add(condition(attribute, operator, datatype, value));
		return this;
	}

	/* ---------- NEW: Filter ---------- */
	public RequestBodyBuilder addFilter(
			String attribute,
			String operator,
			String datatype,
			Object value) {

		if (isEmptyValue(value)) {
			return this; 
		}
		filterList.add(condition(attribute, operator, datatype, value));
		return this;
	}

	/* ---------- Common Condition ---------- */
	private Map<String, Object> condition(
			String attribute,
			String operator,
			String datatype,
			Object value) {

		Map<String, Object> map = new HashMap<>();
		map.put("attribute", attribute);
		map.put("operator", operator);
		map.put("datatype", datatype);
		map.put("value", value);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> build() {

		
		if (body != null) {
			if (body instanceof Map) {
				return (Map<String, Object>) body;
			}

			// Convert POJO → Map
			return new ObjectMapper().convertValue(
					body,
					new TypeReference<Map<String, Object>>() {}
					);
		}

		Map<String, Object> dynamicBody = new HashMap<>();

		if (!searchList.isEmpty()) {
			dynamicBody.put("search", searchList);
		}

		if (!filterList.isEmpty()) {
			dynamicBody.put("filter", filterList);
		}

		return dynamicBody;
	}

	/* ---------- Optional: JSON String ---------- */
	public String buildAsString() {
		try {
			return new ObjectMapper().writeValueAsString(build());
		} catch (Exception e) {
			throw new RuntimeException("Error serializing request body", e);
		}
	}

	/* ---------- Existing Template-based Builder ---------- */
	public static Map<String, Object> buildRequestBodyIfRequired(
			String method,
			String templateFilePath,
			Map<String, String> testData) {

		if (method.equalsIgnoreCase("GET")
				|| method.equalsIgnoreCase("DELETE")) {
			return Collections.emptyMap();
		}

		try {
			String template = JsonUtil.loadJsonTemplate(templateFilePath);
			String requestBody = JsonUtil.applyData(template, testData);

			return new ObjectMapper().readValue(
					requestBody,
					new TypeReference<Map<String, Object>>() {}
					);
		} catch (Exception e) {
			throw new RuntimeException("Failed to build request body: " + e.getMessage(), e);
		}
	}
}
