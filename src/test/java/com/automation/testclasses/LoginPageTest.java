package com.automation.testclasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.base.BaseClass;
import com.framework.report.CustomChainTestReport;

import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners({ChainTestListener.class, CustomChainTestReport.class})
public class LoginPageTest extends BaseClass{
	
	

	    @Test
	    public void sum1() {
	    	
	    	logTestInfo("sum1", "verify addition", "Arthmatic", "vipuls");
	    	
	        ChainTestListener.log("during test 1");
	       assertEquals(10, Math.addExact(6, 4));
	       
	        ChainTestListener.log("during test 2");
	        
	    }

	    @Test
	    public void sum2() {
	    	logTestInfo("sum2", "verify addition", "Arthmatic", "ashwind");
	        ChainTestListener.log("during test 3");
	        assertEquals(10, Math.addExact(5, 4));
	        if(true) {
	        	reportFailLog("Assertion failure", "sum2");
	        }
	        ChainTestListener.log("during test 4");
	    }

}
