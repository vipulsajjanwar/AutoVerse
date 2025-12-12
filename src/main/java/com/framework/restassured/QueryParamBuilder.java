package com.framework.restassured;

import java.util.Map;
import java.util.HashMap;

public class QueryParamBuilder {

	private final Map<String, Object> queryParams = new HashMap<>();

	public QueryParamBuilder add(String key, Object value) {
		if (key != null && !key.trim().isEmpty() && value != null) {
			queryParams.put(key, value);
		}
		return this;
	}

	public QueryParamBuilder addAll(Map<String, Object> map) {
		if (map != null) {
			map.forEach((k, v) -> {
				if (k != null && !k.trim().isEmpty() && v != null) {
					queryParams.put(k, v);
				}
			});
		}
		return this;
	}

	public Map<String, Object> build() {
		return new HashMap<>(queryParams);
	}

	/**
	 * Converts a query string like "a=1&b=2" into a Map<String,Object>
	 */
	public static Map<String, Object> parseQueryString(String queryString) {
		Map<String, Object> map = new HashMap<>();
		if (queryString == null || queryString.trim().isEmpty()) return map;

		String[] pairs = queryString.split("&");
		for (String pair : pairs) {
			String[] keyValue = pair.split("=", 2);
			if (keyValue.length == 2) {
				map.put(keyValue[0].trim(), keyValue[1].trim());
			}
		}
		return map;
	}

	/**
	 * Merge map and query string into one Map<String,Object>
	 */
	public static Map<String, Object> mergeQueryParams(Map<String, Object> map, String queryString) {
		Map<String, Object> merged = new HashMap<>();
		if (map != null) merged.putAll(map);

		Map<String, Object> parsedFromString = parseQueryString(queryString);
		merged.putAll(parsedFromString);  // queryString params overwrite map if key duplicates

		return merged;
	}
}
