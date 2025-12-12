package com.framework.restassured;

import java.util.HashMap;
import java.util.Map;

import com.framework.pojo.Headers;

public class HeadersBuilder {

	private final Map<String, String> headers = new HashMap<>();

	public HeadersBuilder add(String key, String value) {
		if (value != null) {
			headers.put(key, value);
		}
		return this;
	}

	public HeadersBuilder addAll(Map<String, String> map) {
		if (map != null) {
			map.forEach((k, v) -> {
				if (v != null) headers.put(k, v);
			});
		}
		return this;
	}

	public HeadersBuilder fromPojo(Headers pojo) {
		if (pojo == null) return this;

		add("Authorization", pojo.getAccessToken() != null ? "Bearer " + pojo.getAccessToken() : null);
		add("Content-Type", pojo.getContenttype());
		add("Org-id", pojo.getOrgid());
		add("Account-id", pojo.getAccountid());
		add("Workspace-id", pojo.getWorkspaceid());
		add("Secret-id", pojo.getSecretid());
		add("Connection-id", pojo.getConnectionid());

		return this;
	}
	
	 // ---------------- Parse headers from string ----------------
    // Format: "key1=value1;key2=value2"
    public HeadersBuilder parse(String headerString) {
        if (headerString == null || headerString.trim().isEmpty()) return this;

        String[] pairs = headerString.split(";");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=", 2);
            if (keyValue.length == 2 && keyValue[0].trim().length() > 0) {
                headers.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        return this;
    }

    // ---------------- Merge with another HeadersBuilder ----------------
    public HeadersBuilder merge(HeadersBuilder other) {
        if (other != null && other.headers != null) {
            headers.putAll(other.headers);
        }
        return this;
    }

	public Map<String, String> build() {
		return new HashMap<>(headers);
	}
}
