package com.framework.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeSuite;

import com.framework.utils.PageUtil;


public class BaseClass{
	


	public static final Logger log = Logger.getLogger(BaseClass.class);
	public static final String DIR_PATH=System.getProperty("user.dir");
		
	@BeforeSuite(alwaysRun=true)
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

}
