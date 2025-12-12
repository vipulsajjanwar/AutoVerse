package com.framework.restassured;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class FormDataBuilder {

	private final Map<String, String> formData = new LinkedHashMap<>();

	public FormDataBuilder add(String key, String value) {
		if (key != null && value != null) {
			formData.put(key, value);
		}
		return this;
	}

	public FormDataBuilder addAll(Map<String, String> map) {
		if (map != null) {
			map.forEach((k, v) -> {
				if (k != null && v != null) {
					formData.put(k, v);
				}
			});
		}
		return this;
	}

	/**
	 * Build URL-encoded form data string
	 */
	 public String build() {
		StringJoiner joiner = new StringJoiner("&");
		for (Map.Entry<String, String> entry : formData.entrySet()) {
			try {
				String encodedKey = URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.toString());
				String encodedValue = URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString());
				joiner.add(encodedKey + "=" + encodedValue);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("Error encoding form data", e);
			}
		}
		return joiner.toString();
	 }
}
