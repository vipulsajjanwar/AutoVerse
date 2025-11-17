package com.framework.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.framework.report.ExtentManager;

public class ReportUtil {

	private ReportUtil() {}
	
	private static Map<Integer, ExtentTest> testMap = new HashMap<>();
	private static ExtentReports extent = ExtentManager.getInstance();

	public static synchronized ExtentTest getTest() {
		return testMap.get((int) Thread.currentThread().getId());
	}

	public static synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest test = extent.createTest(testName, description);
		testMap.put((int) Thread.currentThread().getId(), test);
		return test;
	}

	public static void endTest() {
		extent.flush();
	}
	
	public static void info(String message) {
        getTest().info(message);
    }

    public static void pass(String message) {
        getTest().pass(message);
    }

    public static void fail(String message) {
        getTest().fail(message);
        
    }

    public static void warning(String message) {
        getTest().warning(message);
    }
    
    public static String getBase64Screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static void attachScreenshot(WebDriver driver, String message) {
        try {
            String base64Screenshot = getBase64Screenshot(driver);
            getTest().info(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            getTest().warning("Screenshot capture failed: " + e.getMessage());
        }
    }

}
