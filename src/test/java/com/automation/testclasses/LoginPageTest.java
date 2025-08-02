package com.automation.testclasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)
public class LoginPageTest {
	
	 @BeforeMethod
	    public void beforeMethod() {
	        ChainTestListener.log("starting test");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        ChainTestListener.log("ending test");
	    }

	    @Test
	    public void sum1() {
	        ChainTestListener.log("during test 1");
	        assertEquals(10, Math.addExact(6, 4));
	        ChainTestListener.log("during test 2");
	    }

	    @Test
	    public void sum2() {
	        ChainTestListener.log("during test 3");
	        assertEquals(10, Math.addExact(6, 4));
	        ChainTestListener.log("during test 4");
	    }

}
