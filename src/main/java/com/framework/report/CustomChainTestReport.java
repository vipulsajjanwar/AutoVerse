package com.framework.report;

import java.io.FileWriter;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.framework.base.BaseClass;
import com.framework.variables.ExecutionVariables;




public class CustomChainTestReport implements ITestListener {

	
	private StringBuilder textLog = new StringBuilder();
	
	@Override
	public void onStart(ITestContext context) {
		// Setup Extent
		ExecutionVariables.reportName=context.getCurrentXmlTest().getSuite().getName();
	
		textLog.append("===== Test Suite Started: " + context.getName() + " =====\n\n");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String msg = "Test Started: " + result.getName();
		ChainTestListener.log(msg);
		textLog.append(msg + "\n");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String msg = "PASSED: " + result.getName();
		BaseClass.reportLog(msg);
		ChainTestListener.log(msg);
		textLog.append(msg + "\n");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String msg = "FAILED: " + result.getName() + " => " + result.getThrowable();
		BaseClass.fail(result.getThrowable().toString());
		ChainTestListener.log(msg);
		textLog.append(msg + "\n");
	}

	@Override
	public void onFinish(ITestContext context) {
		

		textLog.append("\n===== Suite Finished: " + context.getName() + " =====\n");

		try (FileWriter writer = new FileWriter("AutomationReport.txt")) {
			writer.write(textLog.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
