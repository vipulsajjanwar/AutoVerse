package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class JsonUtil {

	private JsonUtil(){}

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String convertObjectToJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return null;
	}

	private static final ObjectMapper mapper = new ObjectMapper()
			.enable(SerializationFeature.INDENT_OUTPUT);  // pretty JSON

			// ---------------------- READ JSON ----------------------
	public static <T> T readJson(String filePath, Class<T> clazz) {
		try {
			return mapper.readValue(new File(filePath), clazz);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read JSON file: " + filePath, e);
		}
	}

	// Generic map reader
	public static Map<String, Object> readJsonAsMap(String filePath) {
		try {
			return mapper.readValue(new File(filePath), new TypeReference<Map<String, Object>>() {});
		} catch (IOException e) {
			throw new RuntimeException("Failed to read JSON file as Map: " + filePath, e);
		}
	}

	// ---------------------- WRITE / CREATE JSON ----------------------
	public static void writeJson(String filePath, Object data) {
		try {
			mapper.writeValue(new File(filePath), data);
		} catch (IOException e) {
			throw new RuntimeException("Failed to write JSON file: " + filePath, e);
		}
	}

	// Only creates if file does not exist
	public static void createJsonFile(String filePath, Object data) {
		File file = new File(filePath);

		if (file.exists()) {
			throw new RuntimeException("JSON file already exists: " + filePath);
		}

		writeJson(filePath, data);
	}

	// ---------------------- UPDATE JSON ----------------------

	public static void updateJson(String filePath, String key, Object newValue) {
		try {
			Map<String, Object> map = readJsonAsMap(filePath);
			map.put(key, newValue);
			writeJson(filePath, map);
		} catch (Exception e) {
			throw new RuntimeException("Failed to update JSON file: " + filePath, e);
		}
	}

	// ---------------------- DELETE JSON FILE ----------------------
	public static boolean deleteJsonFile(String filePath) {
		File file = new File(filePath);
		return file.exists() && file.delete();
	}

	// ---------------------- DELETE KEY FROM JSON ----------------------
	public static void deleteKey(String filePath, String key) {
		try {
			Map<String, Object> map = readJsonAsMap(filePath);
			map.remove(key);
			writeJson(filePath, map);
		} catch (Exception e) {
			throw new RuntimeException("Failed to delete key from JSON: " + filePath, e);
		}
	}

	// ---------------------- CHECK JSON EXIST ----------------------
	public static boolean exists(String filePath) {
		return new File(filePath).exists();
	}
}
