package com.framework.base;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.framework.utils.PageUtil;
import com.framework.utils.ReportUtil;




public class BaseClass{
	
	public static final Logger log = Logger.getLogger(BaseClass.class);
	public static final String DIR_PATH=System.getProperty("user.dir");
	public static final String CONFIG_FILE=System.getProperty("config.file").isEmpty() ? "src/main/resources/config"	: System.getProperty("config.file");
	
	public void beforeTestSuite() {
		
		PageUtil.beforesuite(DIR_PATH + "/src/main/resources/locators/");
		
		
		
		
	}
	
	public static void handleExceptions(Exception e) {
        if (e instanceof NoSuchElementException) {
        	log.error("Element not found", e);
        } else if (e instanceof TimeoutException) {
        	log.error("Element wait timeout", e);
        } else if (e instanceof NullPointerException) {
        	log.error("Null reference encountered", e);
        } else if (e instanceof WebDriverException) {
        	log.error("WebDriver issue", e);
        } else {
        	log.error("Unexpected error occurred", e);
        }
    }
	
	  @BeforeMethod
	    public void setUp(Method method) {
	        // Start report test
		  ReportUtil.startTest(method.getName(), "Automated test execution");

	        // driver setup...
	        // driver = new ChromeDriver();
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) {

	        if (result.getStatus() == ITestResult.FAILURE) {
	        	ReportUtil.fail("Test Failed: " + result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	        	ReportUtil.pass("Test Passed");
	        } else {
	        	ReportUtil.warning("Test Skipped");
	        }

	        // driver.quit();
	    }

	    @AfterSuite
	    public void flushReport() {
	    	ReportUtil.endTest();
	    }

}
