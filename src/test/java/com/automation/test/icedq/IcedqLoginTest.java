package com.automation.test.icedq;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.icedq.IcedqLoginPage;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.framework.base.BaseClass;

@Listeners({ChainTestListener.class})
public class IcedqLoginTest extends BaseClass{

	
	@Test(  groups = {"icedq","Login", "Valid"}, 
			testName = "To verify icedq login functionality", 
			description = "To verify icedq login functionality with valid credentials", 
			enabled = true
		)
	public void validateIcedqLoginFunctionality() {
		
		logTestInfo("Test-001", "To verify icedq login functionality", "Login", "vipuls");
		
		IcedqLoginPage lp = new IcedqLoginPage(driver);
		
		lp.loginToApplication();
		
	}
	
}
