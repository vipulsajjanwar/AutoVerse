package nexgen.automation.framework.baseclass;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.jira.JiraIntegration;
import nexgen.automation.framework.reports.WebEventListener;
import nexgen.automation.framework.sendmail.SendMailSSLWithAttachment;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.xray.UpdateTestExecutionsUsingIDs;
import nexgen.automation.pageclasses.otherpages.LoginPage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseSuite {

	public final static Logger log = Logger.getLogger(BaseSuite.class);

	public static WebDriver driver;
	public static String reportname;
	public static String reportFolder;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	protected static ReadConfig readconfig = new ReadConfig();
	public static String baseURL = "";
	public static String username = "";
	public static String password = "";
	public static boolean singleUserLogin;
	public static String Sybasetype;
	public static String repo = "";
	public static String os = "";
	public static String dbName = "";
	public static String browserName = "";


	/**public static String moduleName = "";*/

	public static String ModuleName = "";
	public static String WorkspaceName = "";
	public static String WorkspaceID = "";
	public static String SourceConnection = "";
	public static String TargetConnection = "";
	public static boolean RunFailedTestCases;


	public static String xl = System.getProperty("user.dir") + Constant.DBDETAILS;
	public static String timesp;
	public static String endTime;
	public static String dbHost;
	public static String dbUserName;
	public static String dbPassword;
	public static String dbDriver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;

	public static ExtentTest test;
	public static String cycleId;
	public static String versionId;
	public static String version;
	public static String fixVersionID;
	public static String projectId;
	public static String projectKey;
	public static String executionKey;
	public static String planKey;
	public static String assignee;
	public static boolean createIssue;
	public static boolean sendMail;
	public static String seqNumber;
	public static boolean updateXrayStatus;
	public static boolean logging;
	public static boolean beforeSuite;
	public static String ReportDocument =null;

	public static String subjectMessage = "";
	public static String accountName = "";
	public static final String buildId = System.getProperty("build.id", "index-v1");
	public static final String suiteType = System.getProperty("suite.type", "sanity");
	public static final boolean elkFlag = Boolean.parseBoolean(System.getProperty("elk.flag", "false"));
	public static final String releaseName = System.getProperty("release.name", "Release-7.1");


	public static String kibanaURL = Constant.KIBANA_URL;
	BaseClassUtil util = new BaseClassUtil();
	XLUtils xlUtils = new XLUtils();
	public static String dirPath=System.getProperty("user.dir");
	protected LoginPage lp; // Page Object will be initialized here	
	
	public static final String PASS="Pass";
	public static final String FAIL="Fail";
	public static final String SKIP="Skip";
	public static final String YES="yes";
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {

		String staticMsg = "TEST CASE FAILED IS ";
		for (String group : result.getMethod().getGroups()) {
			test.assignCategory(group);

		}

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, staticMsg + result.getName()); // to add name in extent report
			String screenshotPath = util.takeScreenshotAtEndOfTest(result.getMethod().getMethodName(), driver);
			test.log(Status.FAIL, staticMsg + result.getThrowable()).addScreenCaptureFromBase64String(screenshotPath); // to


		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getMethod().getMethodName());
			String screenshotPath = util.takeScreenshotAtEndOfTest(result.getMethod().getMethodName(), driver);
			test.log(Status.SKIP, staticMsg + result.getThrowable()).addScreenCaptureFromBase64String(screenshotPath); // to


		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getMethod().getMethodName());
		}
	}

	@Parameters({"db", "version",})
	@BeforeTest(alwaysRun = true)
	public void beforeTest(String dbname, String versioncode, ITestContext result) {

		version = versioncode;
		dbName = dbname;

		String sheetName = "";

		try {
			if (dbName.equalsIgnoreCase("Oracle")) {

				sheetName = "Oracle";

			} else if (dbName.equalsIgnoreCase("SQL")) {

				sheetName = "SQL";

			} else if (dbName.equalsIgnoreCase("Postgres")) {

				sheetName = "Postgres";
			}

			dbHost = xlUtils.getCellData(xl, sheetName, 1, 1);

			dbUserName = xlUtils.getCellData(xl, sheetName, 1, 2);

			dbPassword = xlUtils.getCellData(xl, sheetName, 1, 3);

			dbDriver = xlUtils.getCellData(xl, sheetName, 1, 4);

		} catch (Exception e) {
			reportErrorLog(e.getMessage());
		}


	}

	@Parameters({ "cycleId", "versionId", "version", "projectId", "projectKey", "executionKey", "planKey",
		"fixVersionId", "assignee", "createIssue","seqNumber", "updateXrayStatus" })
	@AfterTest(alwaysRun = true)
	public void afterTest(String cycleid, String versionid, String versioncode, String projectid, String projectkey,
			String executionkey, String plankey, String fixversionid, String assignto, boolean createissue,
			String seqnum, boolean updatexraytest, ITestContext result) throws IOException {
		ReadConfig mailconfig = new ReadConfig();

		try {
			extent.setSystemInfo("Instance URL", baseURL);

			endTime = new SimpleDateFormat("HH.mm.ss-MM/dd/yyyy").format(new Date());

			ExecutionResult.totalcount = ExecutionResult.test - ExecutionResult.retryFlagCount;
			cycleId = cycleid;
			versionId = versionid;
			version = versioncode;
			fixVersionID = fixversionid;
			projectId = projectid;
			projectKey = projectkey;
			executionKey = executionkey;
			if (executionKey == null || executionKey.isEmpty()) {
			    executionKey = System.getProperty("testExecutionKey", "");
			}

			if (!executionKey.isEmpty()) {
			    String xrayExecutionUrl = mailconfig.xRayBaseUrl() + executionKey;
			    extent.setSystemInfo("Test Execution ID", xrayExecutionUrl);
			}
			planKey = plankey;
			assignee = assignto;
			createIssue = createissue;

			seqNumber = seqnum;
			updateXrayStatus = updatexraytest;

			extent.flush();

		} catch (Exception e) {
			reportErrorLog(e.getMessage());
			throw new IOException();
		}
	}

	@Parameters({ "sendMail" })
	@AfterSuite(alwaysRun = true)
	public void afterSuite(boolean sendmail) throws Exception {

		sendMail = sendmail;

		if (sendMail) {
			SendMailSSLWithAttachment mailReport = new SendMailSSLWithAttachment();
			mailReport.sendmailNew();
		}

		if(beforeSuite)
		{
			driver.quit();

		}

		if (updateXrayStatus && !executionKey.isEmpty()){

			UpdateTestExecutionsUsingIDs obj = new UpdateTestExecutionsUsingIDs();

			obj.updateTestExecutions();

		}

		JiraIntegration.create();


	}

	@Parameters({ "beforeSuiteLogin", "browser", "applicationURL", "userName", "password", "os", "logging",

		"singleUserLogin", "moduleName", "workspaceName", "workspaceId", "sourceConnection", "targetConnection","runFailedTestCases"})
	@BeforeSuite(alwaysRun=true)

	public void beforeSuite(ITestContext Result, boolean beforeSuiteLogin, String browser, String applicationURL,
			String userName, String passWord, String osName, ITestContext resultContext, ITestResult result,
			boolean logg, boolean singleLogin, String moduleName, String workspaceName, String workspaceId,

			String sourceConnection, String targetConnection, boolean runFailedTestCases) throws MalformedURLException {


		String suiteName ="";

		PageUtil.beforesuite();

		suiteName = PageUtil.getSuiteName();

		subjectMessage=PageUtil.getExecutionMessage();

		ExecutionResult.suitename = Result.getCurrentXmlTest().getSuite().getName();

		/**	String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM/dd/yyyy").format(new Date());

		timesp = timeStampformail;
		 **/
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String timeStampformail1 = new SimpleDateFormat("HH.mm.ss-MM/dd/yyyy").format(new Date());
		timesp = timeStampformail1;
		String repName = ExecutionResult.suitename+suiteName+ "-Suite-" + timeStamp + ".html";

		reportname = repName;
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/reports/"+buildId+"/" + ExecutionResult.suitename + "-reports" + "/" + repName);
		htmlReporter.config().setDocumentTitle(readconfig.subject());
		htmlReporter.config().setReportName(ExecutionResult.suitename);
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", util.gethost());
		extent.setSystemInfo("OS", util.getOSName());
		extent.setSystemInfo("PC User", util.getuserName());
		extent.setSystemInfo("Execution Info", subjectMessage);
		beforeSuite = beforeSuiteLogin;
		browserName = PageUtil.getBrowser(browser);
		baseURL=PageUtil.getUrl(applicationURL);

		username = userName;
		password = passWord;
		os = osName;
		logging = logg;
		singleUserLogin = singleLogin;
		ModuleName = moduleName;
		WorkspaceName = PageUtil.getWorkspaceName(workspaceName, true);
		WorkspaceID = workspaceId;
		SourceConnection = sourceConnection;
		TargetConnection = targetConnection;
		RunFailedTestCases = runFailedTestCases;

		Sybasetype= PageUtil.getSybaseType("");
		accountName =PageUtil.getAccountName("");

		BaseClassUtil.setSystemPropertiesForExecution();

		if (beforeSuite) {
			driver = util.launchBrowser(driver, browserName, baseURL, username, password, log, logging, e_driver,
					eventListener, singleUserLogin, ModuleName, WorkspaceName);

			lp = new LoginPage(driver);
		}

	}

	@Parameters({ "browser" })
	@BeforeSuite
	public void beforeSuitegetBrowser(String browser) {
		browserName = browser;
	}


	@BeforeClass(alwaysRun=true)
	public void beforeClass() throws MalformedURLException {

		if(!beforeSuite)
		{
			driver = util.launchBrowser(driver, browserName, baseURL, username, password,log, logging, e_driver,
					eventListener, singleUserLogin,ModuleName,WorkspaceName);
		}
	}


	@AfterClass
	public void quit()
	{
		if(!beforeSuite)
		{
			driver.quit();
		}
	}


	public static void reportLog(String message) {

		test.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.TRANSPARENT));

		Reporter.log(message);

	}

	public static void validationReportLog(String message) {

		test.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.GREEN));
		Reporter.log(message);

	}

	public static void otherReportLog(String message) {

		test.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
		Reporter.log(message);

	}

	public static int reportFailLog(String message, String methodname) {

		test.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
		log.warn("ReportFailLog --- methodName: "+methodname);
		try {
			String screenshotPath = takeScreenshotForValidationFailure(methodname, driver);

			test.log(Status.FAIL, message + "::::::::" + methodname,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			ConstantProperty.NUMBEROFFAILURES++;
		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportFailLog method" + e.getMessage());
		}
		Reporter.log(message);return ConstantProperty.NUMBEROFFAILURES;
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
		log.warn("ReportErrorLog --- message: "+message);
		try {

			String screenshotPath = takeScreenshotForValidationFailure("reportErrorLog", driver);

			test.log(Status.FAIL, message + "::::::::" + "reportErrorLog",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			ConstantProperty.NUMBEROFFAILURES++;
		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportErrorLog method" + e.getMessage());
		}
		Reporter.log(message);
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

	}
	public static void skipReportLog(String message) {

		test.log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.BLUE));
		Reporter.log(message);
		ConstantProperty.NUMBEROFSKIPPED++;
	}
	public static void reportTableLog(String [][]message) {

		test.log(Status.INFO, MarkupHelper.createTable(message));

		Reporter.log(Arrays.deepToString(message));
	}
	public static void reportCodeLog(String code) {

		test.log(Status.INFO, MarkupHelper.createCodeBlock(code));

		Reporter.log(code);

	}


	public static void waitForLoaderToDisappear(WebDriver driver) {

		PageUtil.waitForLoaderToDisapper(driver);
	}

	public static String titleLog(int rowNum, String scenario) {

		reportLog("=================== Test Scenario : "+rowNum+" : "+scenario+" =========================");
		ConstantProperty.NUMBEROFSKIPPED=0;
		return SKIP;
	}

	public static String getTestResult(boolean flag) {

		String result=flag || ConstantProperty.NUMBEROFTestFail==0 ? PASS : FAIL; 
		ConstantProperty.NUMBEROFTestFail=0;
		return result; // Return pass or fail based on the flag
	}

	public static void logTestInfo(String testcaseId, String testcaseName, String testCatagory, String authorName, String icedqUser) {

		test = extent.createTest(testcaseName+"-"+testcaseId);
		test.log(Status.INFO, ConstantProperty.XRAY_URL_INFO);
		test.log(Status.INFO, new ReadConfig().xRayBaseUrl() + testcaseId);
		ExecutionResult.issueKey = testcaseId;
		ExecutionResult.catagory = testCatagory;
		test.assignAuthor(authorName);
		ExecutionResult.author = authorName;
		ExecutionResult.testName = testcaseName;
		ConstantProperty.NUMBEROFFAILURES=0;
		ExecutionResult.icedqUser=icedqUser;
		ConstantProperty.NUMBEROFSKIPPED=0;
	}

	public static void reportErrorLog(Exception e, String message) {

		String brend= "<br>";
		
		StackTraceElement element = e.getStackTrace()[0]; // Get the first element of the stack trace
		String exceptionLocation = "Class: " + element.getClassName() + 
				" | Method: " + element.getMethodName() +
				" | Line: " + element.getLineNumber();

		test.log(Status.ERROR, MarkupHelper.createLabel(
			    "<b>Message:</b> " + message + brend +
			    "<b>Exception Class:</b> " + e.getClass().getSimpleName() + brend +
			    "<b>Message:</b> " + e.getMessage() + brend +
			    "<b>Location:</b> " + exceptionLocation + brend +
			    "<b>Possible Cause:</b> " + BaseClassUtil.getExceptionCause(e), 
			    ExtentColor.GREY
			));

		log.error("ReportErrorLog --- message: "+message+ exceptionLocation);

		try {
			// Extract method name from stack trace
			String methodName = element.getMethodName();

			String screenshotPath = takeScreenshotForValidationFailure(methodName, driver);

			test.log(Status.ERROR, message + "::::::::" + methodName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
			ConstantProperty.NUMBEROFFAILURES++;
		} catch (IOException ex) {
			Reporter.log("Error observed while captruing screesnhot in reportErrorLog method" + ex.getMessage());
		}

		Reporter.log(message+exceptionLocation);

	}
	
	public void logTestResult(boolean flag, String testcaseName, String testcaseId) {
		
		if(flag) {

			validationReportLog(testcaseName+ConstantProperty.TESTCASE_PASSED);

		}else {

			reportFailLog(testcaseName+ConstantProperty.TESTCASE_FAILED, testcaseId);

			throw new AssertionError(ConstantProperty.TESTCASE_FAILED+testcaseId);
		}
	}

	public static int getCount(XLUtils xl, String filePath, String sheetName, String type) {

		switch(type.toLowerCase()) {

		case "1":
			return 1;

		case "2":
			return 2;

		case "3":
			return xl.getRowCount(filePath, sheetName);  

		default:
			return xl.getRowCount(filePath, sheetName); 

		}

	}
}
