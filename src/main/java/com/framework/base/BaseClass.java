package com.framework.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.framework.utils.PageUtil;
import com.framework.utils.ReportUtil;
import com.framework.variables.ExecutionVariables;

public class BaseClass {

	public static final Logger log = LoggerFactory.getLogger(BaseClass.class);
	public static final String DIR_PATH=System.getProperty("user.dir");

	public static ExtentReports extent;
	public static ExtentTest test;
	public static final String buildId = System.getProperty("build.id", "index-v1");
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	@Parameters({
	        "suiteName",
	        "testType",
	        "browser",
	        "applicationURL",
	        "userName",
	        "password",
	        "moduleName",
	        "workspaceName"
	})
	public void beforeSuite(
	        String suiteName,
	        String testType,
	        String browser,
	        String baseURL,
	        String userName,
	        String password,
	        String moduleName,
	        String workspaceName
	) {

	    try {
	        // ---------------------------
	        // 1. Load Locators
	        // ---------------------------
	        PageUtil.beforesuite(DIR_PATH + "/src/main/resources/locators/");

	        ExecutionVariables.suitename = suiteName;

	        // ---------------------------
	        // 2. Setup Extent Reporting
	        // ---------------------------
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        String repName = suiteName + "-Suite-" + timeStamp + ".html";
	        
	        System.setProperty("chaintest.generator.simple.output-file",
	        		DIR_PATH + "/reports/" + buildId + "/" +
	                        suiteName+timeStamp + "/"+repName);

	        ExtentSparkReporter spark = new ExtentSparkReporter(
	        		DIR_PATH + "/reports/" + buildId + "/" +
	                        suiteName+timeStamp+"/"+ repName);
	        
	       
	        spark.config().setEncoding("utf-8");
	        spark.config().setTheme(Theme.DARK);
	       
	        spark.config().setDocumentTitle("Automation Execution Report");
	        spark.config().setReportName(suiteName);
	        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
	        
	     // Custom JS (optional)
	        spark.config().setJS("""
	            document.addEventListener('DOMContentLoaded', () => {
	                console.log('Custom JS Loaded');
	            });
	        """);

	        // Custom CSS (optional)
	        spark.config().setCSS("""
	            .badge-primary { background-color: #0097e6 !important; }
	            .nav-link.active { color: #fff !important; font-weight: bold; }
	        """);

	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	        
	       
	        extent.setSystemInfo("Suite Name", suiteName);
	        extent.setSystemInfo("OS", System.getProperty("os.name"));
	        extent.setSystemInfo("User", System.getProperty("user.name"));
	        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	        extent.setSystemInfo("Environment", System.getProperty("env", "QA"));
	        extent.setSystemInfo("Execution Time", timeStamp);
	    //    reportLog("Extent Report Initialized for suite: " + suiteName);

	        // ---------------------------
	        // 3. Launch Browser (if UI)
	        // ---------------------------
	        if (testType != null && testType.trim().equalsIgnoreCase("ui")) {

	            if (driver == null) {

	            //    reportLog("🚀 Launching browser: " + browser);

	                driver = Launcher.launchBrowser(
	                        driver,
	                        browser,
	                        baseURL,
	                        userName,
	                        password,
	                        log,
	                        false,
	                        false,
	                        moduleName,
	                        workspaceName
	                );

	     //           reportPassLog("Browser launched successfully.");
	            } else {
	     //       	reportFailLog("Browser already initialized → Reusing existing instance.", "beforeSuite");
	            }
	        } else {
	    //        reportLog("Test type is not UI → Skipping browser launch.");
	        }

	    } catch (Exception e) {
	   //     reportErrorLog("Error in @BeforeSuite : " + e.getMessage());
	        e.printStackTrace();
	    }
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


	public void setUp(Method method) {
		// Start report test
		ReportUtil.startTest(method.getName(), "Automated test execution");

		
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {

	    try {
	        reportLog("🧹 Starting suite cleanup...");
	    } catch (Exception ignore) { }

	    // -----------------------------
	    // 1. Flush Extent Report safely
	    // -----------------------------
	    try {
	        if (extent != null) {
	            reportLog("Flushing Extent Report...");
	            extent.flush();
	        } else {
	            reportLog("Extent was null → Nothing to flush.");
	        }
	    } catch (Exception e) {
	        System.out.println("Failed to flush Extent Report: " + e.getMessage());
	    }

	    // -----------------------------
	    // 2. Close Browser safely
	    // -----------------------------
	    try {
	        if (driver != null) {
	            reportLog("Closing browser session...");
	            driver.quit();
	            driver = null;
	        } else {
	            reportLog("Driver was null → Browser already closed or not launched.");
	        }
	    } catch (Exception e) {
	    	reportLog("Error closing browser: " + e.getMessage());
	    }

	    reportLog("✅ Suite cleanup complete.");
	}


	public void flushReport() {
		ReportUtil.endTest();
	}

	public static void reportLog(String msg) {
		test.pass(msg);
		ChainTestListener.log(msg);
		Reporter.log(msg);
	}

	public static void fail(String msg) {
		test.fail(msg);
		ChainTestListener.log(msg);
		Reporter.log(msg);
	}

	@BeforeMethod
	public void beforeMethod() {
		ChainTestListener.log("starting test");
	}

	@AfterMethod
	public void afterMethod() {
		ChainTestListener.log("ending test");
	}
	
	public static void reportPassLog(String message) {
		test.log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
		
		try {
			String screenshotPath = takeScreenshotForValidationFailure("reportPassLog", driver);
			test.log(Status.PASS, message + " :::::::: " + "reportPassLog",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportPassLog method" + e.getMessage());
		}
		Reporter.log(message);
		ChainTestListener.log(message);
	}
		
	public static String takeScreenshotForValidationFailure(String methodName, WebDriver driver) throws IOException {
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		String dest = ts.getScreenshotAs(OutputType.BASE64);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(Paths.get("").toAbsolutePath().toString() + "/reports/"+buildId+"/Screenshots/" + methodName + File.separator
				+ methodName + "-"+timeStampformail + ".png");
		FileUtils.copyFile(source, target);
		return dest;

	}
	
	public static void reportErrorLog(String message) {

		test.log(Status.ERROR, MarkupHelper.createLabel(message, ExtentColor.GREY));
		
		try {

			String screenshotPath = takeScreenshotForValidationFailure("reportErrorLog", driver);

			test.log(Status.FAIL, message + "::::::::" + "reportErrorLog",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			
		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportErrorLog method" + e.getMessage());
		}
		Reporter.log(message);
		ChainTestListener.log(message);
	}
	
	public static void reportFailLog(String message, String methodname) {

		test.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
		
		try {
			String screenshotPath = takeScreenshotForValidationFailure(methodname, driver);

			test.log(Status.FAIL, message + "::::::::" + methodname,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			
		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportFailLog method" + e.getMessage());
		}
		Reporter.log(message);
		ChainTestListener.log(message);
	}
	
	public static void skipReportLog(String message) {

		test.log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.BLUE));
		Reporter.log(message);
		ChainTestListener.log(message);
		
	}
	public static void reportTableLog(String [][]message) {

		test.log(Status.INFO, MarkupHelper.createTable(message));

		Reporter.log(Arrays.deepToString(message));
		
	}
	public static void reportCodeLog(String code) {

		test.log(Status.INFO, MarkupHelper.createCodeBlock(code));

		Reporter.log(code);
		
		ChainTestListener.log(code);
	}
	
	public static void logTestInfo(String testcaseId, String testcaseName, String testCatagory, String authorName) {

		test = extent.createTest(testcaseName+"-"+testcaseId);
		test.log(Status.INFO, "");
		test.log(Status.INFO, "" + testcaseId);
		ExecutionVariables.issueKey = testcaseId;
		ExecutionVariables.catagory = testCatagory;
		test.assignAuthor(authorName);
		ExecutionVariables.author = authorName;
		ExecutionVariables.testName = testcaseName;
	
	}
	
}
