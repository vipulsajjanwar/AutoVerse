package com.framework.report;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BaseClass;
import com.framework.constant.Constant;
import com.framework.utils.TimeUtil;
import com.framework.utils.XLUtil;
import com.framework.variables.ExecutionVariables;


public class ExtentReportListener implements ITestListener {

	public static final Logger log = LogManager.getLogger(ExtentReportListener.class);
	
	XLUtil xlReader = new XLUtil();

	boolean testSuccess = true;

	public static String ReportDocument =null;

	String tstartTime;
	String tendTime;
	String timeformat="M/d/yyyy, h:mm:ss a";
	String timezone="Asia/Calcutta";

	@Override
	public void onStart(ITestContext context) {
		ExecutionVariables.startTime = TimeUtil.getCurrentTime(timeformat, timezone);
		if(Constant.REPORTDOC_FLAG) {
			ExecutionVariables.reportDocPath = XLUtil.createWorkBook(BaseClass.DIR_PATH+"/src/main/resources/reportdoc", ExecutionVariables.suitename, ".xlsx");
			ReportDocument = ExecutionVariables.reportDocPath;
			log.info("Execution status report doc path :: {}", ReportDocument);
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info(" Test case started : {}", result.getName());	

		ExecutionVariables.retryFlag = false;

		ExecutionVariables.test++;

	//	tstartTime=CustomTimeUtil.getCurrentTime(timeformat, timezone);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 ExtentManager.getTest().pass("Test Passed");
		log.info("The name of the testcase passed is  : {}", result.getName());	
		ExecutionVariables.passedTC++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 ExtentManager.getTest().fail(result.getThrowable());
		log.info("The name of the testcase failed is :{}", result.getName());	
		ExecutionVariables.failedTC++;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 ExtentManager.getTest().skip("Test Skipped");
		log.info("The name of the testcase skipped is :{}", result.getName());	
		ExecutionVariables.skippedTC++;
	}

	@Override
	public void onFinish(ITestContext context) {
		ExecutionVariables.endTime = TimeUtil.getCurrentTime(timeformat, timezone);
	}

}
