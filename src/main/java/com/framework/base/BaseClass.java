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
import org.testng.annotations.AfterTest;
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
import com.framework.constant.ApiConstants;
import com.framework.constant.Constant;
import com.framework.integration.EmailIntegration;
import com.framework.report.ExtentManager;
import com.framework.utils.PageUtil;
import com.framework.variables.ExecutionVariables;

public class BaseClass {

	public static final Logger log = LogManager.getLogger(BaseClass.class);
	public static final String DIR_PATH=System.getProperty("user.dir");

	public static final String buildId = System.getProperty("build.id", "index-v1");
	public static WebDriver driver;

	public static final String APIBASEURL = "http://192.168.100.35:42445/";
	public static final String TOKENPATHPARAM = "auth/realms/icedq/protocol/openid-connect/token";

	public static final String SCHEMAFOLDERPATH = BaseClass.DIR_PATH + "/src/test/resources/schemas/";
	 
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
	public static void beforeSuite(
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
			ExecutionVariables.testType =testType;
			ExecutionVariables.browser =browser;
			ExecutionVariables.baseURL=baseURL;
			ExecutionVariables.userName=userName;
			ExecutionVariables.password=password;
			ExecutionVariables.moduleName=moduleName;
			ExecutionVariables.workspaceName=workspaceName;

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

			log.info("🧹 Starting suite cleanup...");
		
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
			log.error("Failed to flush Extent Report: {} " , e.getMessage(), e);
		}

		// -----------------------------
		// 2. Close Browser safely
		// -----------------------------
		try {
			if (ExecutionVariables.testType != null && ExecutionVariables.testType.trim().equalsIgnoreCase("ui")) {
				if (driver != null) {
					log.info("Closing browser session...");
					driver.quit();
					driver = null;
				} else {
					log.info("Driver was null → Browser already closed or not launched.");
				}
			}
		} catch (Exception e) {
			log.error("Error closing browser: {} " , e.getMessage(), e);
		}

		log.info(" Suite cleanup complete.");
		log.info(" Test Report File => {} ",ExecutionVariables.reportFilePath);
		
		sendMail(ExecutionVariables.reportFileFolder);
		
	}
	
	public void sendMail(String reportFilePath) {

		try {
			if(!Constant.MAIL_SENT_FLAG) { return ;}

			EmailIntegration mailer = new EmailIntegration.Builder()
					.setHost(Constant.MAIL_EMAIL_HOST)
					.setPort(Constant.MAIL_PORT)
					.setUser(Constant.MAIL_USERNAME)
					.setPassword(Constant.MAIL_PASSWORD)
					.build();

			mailer.sendEmail(
					Constant.MAIL_SUBJECT,
					reportFilePath,
					Constant.MAIL_TO,
					Constant.MAIL_CC,
					Constant.MAIL_BCC
					);
		} catch (Exception e) {
			log.error("Error sendMail: {} " , e.getMessage(), e);
		}
	}
	
	@AfterTest
	public void afterTest() {
		if(ApiConstants.getAuthToken() != null) {
			ApiConstants.setAuthToken(null);
		}
		ExecutionVariables.totalcount = ExecutionVariables.test - ExecutionVariables.retryFlagCount;
	}
	
	
	

	public static void reportLog(String msg) {
		ExtentManager.getTest().info(msg);

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
			if(!screenshotPath.isEmpty()) {
				ExtentManager.getTest().log(Status.PASS, message + " :::::::: " + "reportPassLog",
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			}
		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportPassLog method" + e.getMessage());
		}
		Reporter.log(message);


	}

	public static String takeScreenshotForValidationFailure(String methodName, WebDriver driver) throws IOException {

		if(driver == null) return "";

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

		if(driver == null) return "";
		
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

		ExtentManager.getTest().log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.GREY));

		try {

			String screenshotPath = takeScreenshotForValidationFailure("reportErrorLog", driver);
			if(!screenshotPath.isEmpty()) {
				ExtentManager.getTest().log(Status.FAIL, message + "::::::::" + "reportErrorLog",
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			}
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
			if(!screenshotPath.isEmpty()) {
				ExtentManager.getTest().log(Status.FAIL, message + "::::::::" + methodname,
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			}
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
	
	public static void logSchemaAndResponse(String schemaJson, String responseJson) {

	    String html = "<table border='1' style='width:100%; border-collapse:collapse;'>"
	            + "<tr>"
	            + "<th style='padding:8px;'>Schema</th>"
	            + "<th style='padding:8px;'>Response</th>"
	            + "</tr>"
	            + "<tr>"
	            + "<td style='max-height:300px; overflow:auto; white-space:pre-wrap;'>" + schemaJson + "</td>"
	            + "<td style='max-height:300px; overflow:auto; white-space:pre-wrap;'>" + responseJson + "</td>"
	            + "</tr>"
	            + "</table>";

	    ExtentManager.getTest().info(html);  
	}

}
