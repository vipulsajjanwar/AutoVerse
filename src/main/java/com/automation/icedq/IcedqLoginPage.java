package com.automation.icedq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.PageUtil;


public class IcedqLoginPage extends PageUtil{

	public static final Logger log = LogManager.getLogger(IcedqLoginPage.class);
	
	WebDriver driver;
	

	public IcedqLoginPage(WebDriver driver) {

		this.driver = driver;

	}
		By icedqSpinner = getElementLocator(prop.getProperty("icedq.spinner"));
		By passwordFieldLocator = getElementLocator(prop.getProperty("icedq.login.password.field"));
	    By advancedButtonLocator = getElementLocator(prop.getProperty("icedq.login.advance.button"));
	    By continueLinkLocator =  getElementLocator(prop.getProperty("icedq.login.continue.link"));
	    By usernameFieldLocator = getElementLocator(prop.getProperty("icedq.login.username.field"));
	    By signInButtonLocator =  getElementLocator(prop.getProperty("icedq.login.signin.button"));
	    
	    String appURL= prop.getProperty("icedq.app.url");
	    String username=prop.getProperty("icedq.admin.username");
	    String password=prop.getProperty("icedq.admin.password");
	    
	    
	    
	 public void loginToApplication() {
		 
		 IcedqHomePage hp = new IcedqHomePage(driver);
		 
		 driver.get(appURL);
				 
		 isNotDisplayed(driver, icedqSpinner, 60);
		 
		 click(driver, usernameFieldLocator, "username");
		 
		 sendKeys(driver, usernameFieldLocator, username, "username field");
		 
		 sendKeys(driver, passwordFieldLocator, password, "password field");
		 
		 click(driver, signInButtonLocator, "Sign In");
				 
		 hp.validateIcedqHomePageTitle();
	      
	 }
}
