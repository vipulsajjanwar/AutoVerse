package com.automation.icedq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.framework.base.BaseClass;
import com.framework.utils.PageUtil;

public class IcedqHomePage extends PageUtil{

	
public static final Logger log = LogManager.getLogger(IcedqHomePage.class);
	
	WebDriver driver;
	

	public IcedqHomePage(WebDriver driver) {

		this.driver = driver;

	}
	
	By homePageTitle=getElementLocator(prop.getProperty("icedq.home.page.title"));
	String expectedPageTitle="Hi Vipul, welcome to iceDQ!";
	
	
	public boolean validateIcedqHomePageTitle() {
		
		 try {
			 
			 String actitle = getText(driver, homePageTitle, "Home page title");
			 
			 SoftAssert s = new SoftAssert();
			 
			 BaseClass.reportLog("Retrived: "+actitle);
			 BaseClass.reportLog("Expected: "+expectedPageTitle);
			 			 
			 s.assertEquals(actitle, expectedPageTitle);
		} catch (Exception e) {
			BaseClass.reportErrorLog("Error occured while : validateIcedqHomePageTitle : "+e.getMessage());
			return false;
		}
		 
		
		return true;
	}
}
