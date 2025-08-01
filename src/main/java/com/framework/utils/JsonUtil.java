package com.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	 private static final ObjectMapper objectMapper = new ObjectMapper();

	    public static String convertObjectToJson(Object obj) throws Exception {
	        return objectMapper.writeValueAsString(obj);
	    }
}
