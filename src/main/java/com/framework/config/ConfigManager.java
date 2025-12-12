package com.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static Properties properties = new Properties();

	// Private constructor to prevent instantiation
    private ConfigManager() {}

    /**
     * Load properties file from custom path
     * @param filePath path of the .properties file
     */
    public static void load(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + filePath, e);
        }
    }
    
    public static void loadFromClasspath(String fileName) {
        try {
            properties.load(ConfigManager.class.getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config from classpath: " + fileName, e);
        }
    }

    /**
     * Get property as String
     */
    public static String getString(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get property as Int
     */
    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    /**
     * Get property as Boolean
     */
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    /**
     * Get property with default value
     */
    public static String getOrDefault(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    public static String getDynamicString(String key, String replace, String value) {
        String original = properties.getProperty(key);
        if (original != null) {
            return original.replace(replace, value);
        }
        return null;
    }

}
