package com.framework.report;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.framework.variables.ExecutionVariables;

public class ExtentManager {
	private static ExtentReports extent;
	
	private ExtentManager() {}

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName(ExecutionVariables.reportName);
        spark.config().setDocumentTitle(ExecutionVariables.documentTitle);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Author", "SRK Automation");

        return extent;
    }
}
