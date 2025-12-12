package com.framework.restassured;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.utils.JsonUtil;

public class RequestBodyBuilder {

	private Object body;

	public RequestBodyBuilder body(Object body) {
		this.body = body;
		return this;
	}

	public String build() {
		if (body == null) return null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(body);
		} catch (Exception e) {
			throw new RuntimeException("Error serializing body", e);
		}
	}
	
	public static Map<String, Object> buildRequestBodyIfRequired(
			String method,
			String templateFilePath,
			Map<String, String> testData) {

		// GET does not require request body
		if (method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("DELETE")) {
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
