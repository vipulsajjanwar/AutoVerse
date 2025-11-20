package com.framework.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.config.ConfigManager;
import com.framework.report.ExtentManager;
import com.framework.utils.PageUtil;
import com.framework.variables.ExecutionVariables;

public class BaseClass {

	public static final Logger log = LogManager.getLogger(BaseClass.class);
	public static final String DIR_PATH=System.getProperty("user.dir");

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
			ConfigManager.load(DIR_PATH +"/src/main/resources/config/constant.properties");
			
			PageUtil.beforesuite(DIR_PATH + ConfigManager.getString("icedq.locators.folder.path"));

			ExecutionVariables.suitename = suiteName;

			/*
			 * // --------------------------- // 2. Setup Extent Reporting //
			 * --------------------------- String timeStamp = new
			 * SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); String repName =
			 * suiteName + "-Suite-" + timeStamp + ".html";
			 * 
			 * System.setProperty("chaintest.generator.simple.output-file", DIR_PATH +
			 * "/reports/" + buildId + "/" + suiteName+timeStamp + "/"+repName);
			 * 
			 * ExtentSparkReporter spark = new ExtentSparkReporter( DIR_PATH + "/reports/" +
			 * buildId + "/" + suiteName+timeStamp+"/"+ repName);
			 * 
			 * 
			 * spark.config().setEncoding("utf-8"); spark.config().setTheme(Theme.DARK);
			 * 
			 * spark.config().setDocumentTitle("Automation Execution Report");
			 * spark.config().setReportName(suiteName);
			 * spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
			 * 
			 * // Custom JS (optional) spark.config().setJS("""
			 * document.addEventListener('DOMContentLoaded', () => { console.log('Custom JS
			 * Loaded'); }); """);
			 * 
			 * // Custom CSS (optional) spark.config().setCSS(""" .badge-primary {
			 * background-color: #0097e6 !important; } .nav-link.active { color: #fff
			 * !important; font-weight: bold; } """);
			 * 
			 * extent = new ExtentReports(); extent.attachReporter(spark);
			 * 
			 * 
			 * extent.setSystemInfo("Suite Name", suiteName); extent.setSystemInfo("OS",
			 * System.getProperty("os.name")); extent.setSystemInfo("User",
			 * System.getProperty("user.name")); extent.setSystemInfo("Java Version",
			 * System.getProperty("java.version")); extent.setSystemInfo("Environment",
			 * System.getProperty("env", "QA")); extent.setSystemInfo("Execution Time",
			 * timeStamp);
			 */
			//    reportLog("Extent Report Initialized for suite: " + suiteName);

			// ---------------------------
			// 3. Launch Browser (if UI)
			// ---------------------------
			if (testType != null && testType.trim().equalsIgnoreCase("ui")) {

				if (driver == null) {

					driver = Launcher.launchBrowser(
							driver,
							browser,
							baseURL,
							userName,
							password,
							log,
							true,
							false,
							moduleName,
							workspaceName
							);

					
				} else {
					
				}
			} else {
				
			}

		} catch (Exception e) {
			
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

	@AfterSuite(alwaysRun = true)
	public void tearDown() {

		try {
			log.info("🧹 Starting suite cleanup...");
		} catch (Exception ignore) { }

		// -----------------------------
		// 1. Flush Extent Report safely
		// -----------------------------
		try {
			if (ExtentManager
	                .getInstance() != null) {
				log.info("Flushing Extent Report...");
				ExtentManager
                .getInstance().flush();
				
			} else {
				log.info("Extent was null → Nothing to flush.");
			}
		} catch (Exception e) {
			log.info("Failed to flush Extent Report: " + e.getMessage());
		}

		// -----------------------------
		// 2. Close Browser safely
		// -----------------------------
		try {
			if (driver != null) {
				log.info("Closing browser session...");
				driver.quit();
				driver = null;
			} else {
				log.info("Driver was null → Browser already closed or not launched.");
			}
		} catch (Exception e) {
			log.info("Error closing browser: " + e.getMessage());
		}

		log.info(" Suite cleanup complete.");
	}

	public static void reportLog(String msg) {
		ExtentManager.getTest().pass(msg);
		
		Reporter.log(msg);
	}

	public static void fail(String msg) {
		ExtentManager.getTest().fail(msg);
		
		Reporter.log(msg);
	}

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@AfterMethod
	public void afterMethod() {
		
	}

	public static void reportPassLog(String message) {
		ExtentManager.getTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));

		try {
			String screenshotPath = takeScreenshotForValidationFailure("reportPassLog", driver);
			ExtentManager.getTest().log(Status.PASS, message + " :::::::: " + "reportPassLog",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportPassLog method" + e.getMessage());
		}
		Reporter.log(message);
		
		
	}

	public static String takeScreenshotForValidationFailure(String methodName, WebDriver driver) throws IOException {

		String timestamp = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture Base64 (for report)
		String base64 = ts.getScreenshotAs(OutputType.BASE64);

		// Capture file (for saving)
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		// Create folder path
		String screenshotDir = Paths.get("").toAbsolutePath().toString()
				+ "/reports/" + buildId + "/Screenshots/" + methodName;

		File folder = new File(screenshotDir);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// Save file
		File destination = new File(folder, methodName + "-" + timestamp + ".png");
		FileUtils.copyFile(sourceFile, destination);

		return base64;
	}

	public static String takeScreenshotForChainTestListener(String methodName, WebDriver driver) throws IOException {


		String base64=null;

		String timestamp = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		base64 = ts.getScreenshotAs(OutputType.BASE64);

		// Capture file (for saving)
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		// Create folder path
		String screenshotDir = Paths.get("").toAbsolutePath().toString()
				+ "/reports/" + buildId + "/Screenshots/" + methodName;

		File folder = new File(screenshotDir);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// Save file
		File destination = new File(folder, methodName + "-" + timestamp + ".png");
		FileUtils.copyFile(sourceFile, destination);

		ChainTestListener.embed(destination, methodName + "-" + timestamp + ".png");


		return base64;
	}

	public static void reportErrorLog(String message) {

		ExtentManager.getTest().log(Status.ERROR, MarkupHelper.createLabel(message, ExtentColor.GREY));

		try {

			String screenshotPath = takeScreenshotForValidationFailure("reportErrorLog", driver);

			ExtentManager.getTest().log(Status.FAIL, message + "::::::::" + "reportErrorLog",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportErrorLog method" + e.getMessage());
		}
		Reporter.log(message);
	}

	public static void reportFailLog(String message, String methodname) {

		ExtentManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
		String screenshotPath =null;
		try {
			screenshotPath = takeScreenshotForValidationFailure(methodname, driver);

			ExtentManager.getTest().log(Status.FAIL, message + "::::::::" + methodname,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportFailLog method" + e.getMessage());
		}
		Reporter.log(message);
		try {
			takeScreenshotForChainTestListener(methodname, driver);
		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportFailLog method" + e.getMessage());
		}

	}

	public static String getValidFileName(String methodname) {
		return methodname.replaceAll("[^a-zA-Z0-9_-]", "_") + ".png";
	}

	public static void skipReportLog(String message) {

		ExtentManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.BLUE));
		Reporter.log(message);

	}
	public static void reportTableLog(String [][]message) {

		ExtentManager.getTest().log(Status.INFO, MarkupHelper.createTable(message));

		Reporter.log(Arrays.deepToString(message));

	}
	public static void reportCodeLog(String code) {

		ExtentManager.getTest().log(Status.INFO, MarkupHelper.createCodeBlock(code));

		Reporter.log(code);

	}

	public static void logTestInfo(String testcaseId, String testcaseName, String testCatagory, String authorName) {

		String fullTestName = testcaseId + " - " + testcaseName;

	    // Create Extent test
	    ExtentTest test = ExtentManager
	            .getInstance()
	            .createTest(fullTestName)
	            .assignCategory(testCatagory)
	            .assignAuthor(authorName);

	    // Attach test instance to thread
	    ExtentManager.setTest(test);

	    // Log basic test info
	    test.log(Status.INFO, "TestCase ID: " + testcaseId);
	    test.log(Status.INFO, "Category: " + testCatagory);
	    test.log(Status.INFO, "Author: " + authorName);

	    // Set Execution variables
	    ExecutionVariables.issueKey = testcaseId;
	    ExecutionVariables.testName = testcaseName;
	    ExecutionVariables.catagory = testCatagory;
	    ExecutionVariables.author = authorName;

	    // Log to console (Log4j)
	    log.info("STARTING TEST → " + fullTestName + " | Category: " + testCatagory + " | Author: " + authorName);
	}

}
