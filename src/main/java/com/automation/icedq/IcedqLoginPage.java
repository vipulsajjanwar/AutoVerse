package com.automation.icedq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.framework.utils.PageUtil;


public class IcedqLoginPage extends PageUtil{

	
	WebDriver driver;
	protected static final Logger log = LoggerFactory.getLogger(IcedqLoginPage.class);

	public IcedqLoginPage(WebDriver driver) {

		this.driver = driver;

	}
	// 🔹 Auto-generated locators
		By passwordFieldLocator = By.name("password");
	    By advancedButtonLocator = By.xpath("//button[normalize-space(text())='Advanced']");
	    By continueLinkLocator = By.xpath("//a[text()='Proceed to 192.168.100.35 (unsafe)']");
	    By usernameFieldLocator = By.name("username");
	    By signInButtonLocator = By.xpath("//input[@value='Sign In']");
	    
	    String appURL="https://192.168.100.35:32222";
	    String username="vipuls";
	    String password="Admin@123";
	    
	    
	    
	 public void loginToApplication() {
		 
		 log.info("Navigated to the URL.");
		 
		 
	      
	 }
}
