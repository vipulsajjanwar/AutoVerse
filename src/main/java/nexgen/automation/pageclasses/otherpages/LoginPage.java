package nexgen.automation.pageclasses.otherpages;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import static org.testng.Assert.assertEquals;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.aventstack.extentreports.Status;

import nexgen.automation.framework.administration.AccountsServicePage;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.connectionRepo.ConnectionHome;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nextgen.automation.RuleRepo.pages.RuleRepoHomePage;
//import nextgen.automation.RuleRepo.pages.RuleRepoHomePage;

public class LoginPage extends PageUtil {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}
	protected static final Logger log = Logger.getLogger(LoginPage.class);
	String userDetails = System.getProperty("user.dir") + Constant.LOGINDETAILS;

	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();

	By secureAdvanceButton = getElementLocator(prop.getProperty("secure.AdvanceButton"));
	By secureProceedtounsafe = getElementLocator(prop.getProperty("secure.Proceedtounsafe"));
	By userName = getElementLocator(prop.getProperty("Login.UserName"));
	By passWord = getElementLocator(prop.getProperty("Login.Password"));
	By signin = getElementLocator(prop.getProperty("Login.SubmitButton"));
	By welcomeText = getElementLocator(prop.getProperty("LandingPage.WelcomeText"));
	By landingPageUserOptions = getElementLocator(prop.getProperty("LandingPage.UserOptions"));
	By signOut = getElementLocator(prop.getProperty("LandingPage.Logout1"));
	By signoutConfirmOption = getElementLocator(prop.getProperty("LandingPage.LogoutConfirmOption"));
	By loginLoadingIcon = getElementLocator(prop.getProperty("login.LoadingIcon"));
	By landingPageSuccessLoginMessage = getElementLocator(prop.getProperty("LandingPage.SuccessLoginMessage"));
	By forgotLink = getElementLocator(prop.getProperty("forgotpassword.forgotlink"));
	By Enteremailforgotpassword = getElementLocator(prop.getProperty("Enteremailforgotpassword.enteremail"));
	By submit = getElementLocator(prop.getProperty("Enteremailforgotpassword.submitButton"));
	By ForgetBacktoLogin = getElementLocator(prop.getProperty("forgotpassword.backtologin"));
	By loginHeader = getElementLocator(prop.getProperty("login.LoginHeader"));
	By welcome = getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));
	By hoverdownWait = getElementLocator(prop.getProperty("login.hoverdownWait"));
	By AzureAD = getElementLocator(prop.getProperty("verifyAzureADfunction.signin"));
	By ForgotpageLabel = getElementLocator(prop.getProperty("verifymandatoryfields.label"));
	By AzureADsubmit = getElementLocator(prop.getProperty("verifyAzureADfunction.submit"));
	By AzureADLabel = getElementLocator(prop.getProperty("verifyAzureADfunction.label"));
	By Microsoftsignin = getElementLocator(prop.getProperty("verifyAzureADfunction.microsoftlogin"));
	By Microsoftnext = getElementLocator(prop.getProperty("verifyAzureADfunction.microsoftemailnext"));
	By Loginheader = getElementLocator(prop.getProperty("verifyAzureADfunction.loginheader1"));
	By Micropass = getElementLocator(prop.getProperty("verifyAzureADfunction.micropass"));
	By Micronext = getElementLocator(prop.getProperty("verifyAzureADfunction.microbuttonnext"));
	By AzureUpdatepage = getElementLocator(prop.getProperty("verifyAzureADfunction.updateAzureAD"));
	By StaySignIn = getElementLocator(prop.getProperty("verifyAzureADfunction.staysignin"));
	By LableAzureAD = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.ADpageLabel"));
	By ADUsername = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureUsername"));
	By ADemail = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureEmail"));
	By ADfirstname = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureFirstName"));
	By ADlastname = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureLastName"));
	By ADSubmit = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureSubmit"));
	By sendAnyWayButton = getElementLocator(prop.getProperty("SendAnyWayButton"));
	By proceedToApplication = getElementLocator(prop.getProperty("ProceedToApp"));
	By welcomeTxt = getElementLocator(prop.getProperty("LadingPage.WelcomeTxt"));
	By backToApplicationLink= getElementLocator(prop.getProperty("LandingPage.BackToApplication.link"));

	public By AdministrationLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationLabel"));

	By LoggedInMsg = getElementLocator(prop.getProperty("Login.LoggedInMsg"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	String logeedInText = prop.getProperty("LogeedInText");

	String invalidLoginMsg = prop.getProperty("InvalidLoginMsg");
	String Epass = prop.getProperty("verifyAzureADfunction.emailpass");
	String actualTitle;
	String expectedTitle;

	By iCEDQ = getElementLocator(prop.getProperty("Landingpage.iCEDQ"));

	By forgotPasswordLabel = getElementLocator(prop.getProperty("forgotpassword.label"));
	By forgotPasswordUserName = getElementLocator(prop.getProperty("forgotpassword.username"));
	By forgotPasswordSubmitBtn = getElementLocator(prop.getProperty("forgotpassword.submitBtn"));
	By forgotPasswordBackToLogin = getElementLocator(prop.getProperty("forgotpassword.BackToLogin"));

	By signInWithAzureAD = getElementLocator(prop.getProperty("login.signInWithAzureAD"));
	By AzureADSignIn = getElementLocator(prop.getProperty("login.signInWithAzureAD.signIn"));
	By AzureADSubmit = getElementLocator(prop.getProperty("login.signInWithAzureAD.submit"));
	By AzureADPassword = getElementLocator(prop.getProperty("login.signInWithAzureAD.password"));

	String userDetails1 = prop.getProperty("login.User");
	By ProfileDropDownOptionClick = getElementLocator(prop.getProperty("ProfileDropDownOptionClick"));
	By dataprepTitlePage = getElementLocator(prop.getProperty("Dataprep.titleDataset"));
	By icedqTitle = getElementLocator(prop.getProperty("Login.icedqTitle"));
	By rememberMe = getElementLocator(prop.getProperty("RememberMeCheckBox"));
	By forgetPassword = getElementLocator(prop.getProperty("ForgotPasswordLink"));
	By customerLogin = getElementLocator(prop.getProperty("CustomerLogin"));
	By employeeLogin = getElementLocator(prop.getProperty("EmployeeLogin"));
	By discardButtons = getElementLocator(prop.getProperty("dataT.discardButton"));
	By sidebarCloseIcon = getElementLocator(prop.getProperty("dataT.Sidebars.CloseIcon"));
	By workspacePopUpWindow = getElementLocator(prop.getProperty("WorkspacePopUpWindow"));
	By selectWorkspace = getElementLocator(prop.getProperty("Home.selectWOrkspace"));
	By workspaceList = getElementLocator(prop.getProperty("DataTesting.WorkspaceWindow"));
	By workspaceSearch = getElementLocator(prop.getProperty("DataTesting.WorkspaceSearch"));
	By workspaceSearchTxt = getElementLocator(prop.getProperty("Data.WorkspaceSearchTxt"));
	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By okButton = getElementLocator(prop.getProperty("WorkspaceOkButton"));
	By cancelButton = getElementLocator(prop.getProperty("WorkspaceCancelButton"));
	By spinner = getElementLocator(prop.getProperty("Conn.Spinner.AfterRefresh"));
	By invalidCredentialMsg = getElementLocator(prop.getProperty("invalidCredentialMsg"));
	By newPassword = getElementLocator(prop.getProperty("Login.NewPassword"));
	By confirmNewPassword = getElementLocator(prop.getProperty("Login.ConfirmNewPassword"));
	By submitButton = getElementLocator(prop.getProperty("Login.SubmitButton"));
	By workspaceNoRecordFound = getElementLocator(prop.getProperty("Workspace.NoRecordFound"));
	String createElement = prop.getProperty("Data.desiredConn");
	String dynamicWorkspaceSelect = prop.getProperty("Workspace.select.dynamic.input");
	String dynamicName = prop.getProperty("DynName");
	String valueAttribute = prop.getProperty("Attribute.value");
	public String forbiddenToastMsg = prop.getProperty("Connection.NewConnBtn.UserAuth.ErrMsg");
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	String popupOpenDiscardCancel=prop.getProperty("popupopen.canceldiscard");

	public boolean navigatetoAppPage() {
		boolean flag = false;
		try {

			isDisplayedInLoop(driver, 5, secureAdvanceButton);
			if (isDisplayed(driver, secureAdvanceButton)) {
				click(driver, secureAdvanceButton);
				BaseSuite.reportLog("Successfully clicked on the Advanced button ");
				isDisplayedInLoop(driver, 5, secureProceedtounsafe);
				Thread.sleep(4000);
				if (isDisplayed(driver, secureProceedtounsafe)) {
					flag = true;
					click(driver, secureProceedtounsafe);
					BaseSuite.reportLog("Successfully clicked on the procced button ");

				} else
					BaseSuite.reportLog("Unable to click on the procced button");
				System.out.println("");
			} else
				BaseSuite.reportLog("Unable to click on the procced button");
			System.out.println("");

		} catch (Exception Ex) {
			throw new AssertionError("Unable to login to the application!", Ex);
		}
		return flag;

	}

	public void verifyTitleOfPage() {
		// boolean flag = false;
		String title = driver.getTitle();
		System.out.println("Page title: " + title);

		// Check point
		if (title.equals("Nextgenicedq")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect title");
		}
	}

	public boolean login(String username, String password, String ModuleName) {

		boolean flag = false;
		try {

			BaseSuite bs = new BaseSuite();
			bs.test = bs.extent.createTest("verifyLoginToApplication_503");
			ReadConfig mailconfig = new ReadConfig();

			bs.test.log(Status.INFO, "X-ray Test Case URL");
			bs.test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-503");
			ExecutionResult.issueKey = "NG21-503";

			BaseSuite.reportLog("Launching browser!!!!");
			BaseSuite.validationReportLog("Launching browser successfully!!!");

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			if (isDisplayed(driver, loginHeader)) {
				flag = true;

				BaseSuite.validationReportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);

			BaseSuite.validationReportLog("Entered owner previledge UserName: " + username);
			clear_Click_SendKeys(driver, 2, passWord, password);

			BaseSuite.reportLog("Entered Password: " + password);
			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");
			// Thread.sleep(3000);
			waitForElement(driver, ToastMsgClosedBtn);
			captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, logeedInText, "LoggedIn");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");

			isDisplayedInLoop(driver, 30, welcome);
			if (isDisplayed(driver, welcome)) {
				flag = true;
				BaseSuite.validationReportLog("Welcome User label in the profile section is showing properly");
				BaseSuite.reportLog("Login User is :::: " + username);
				BaseSuite.validationReportLog("User Login successfully in the application!!");

				BaseSuite.reportLog("Getting Started with NextGen serivces");
			}
			switch (ModuleName) {
			case "Administration":
				HomePage hp = new HomePage(driver);
				hp.administration();
				break;

			case "connectionRepo":
				ConnectionHome ch = new ConnectionHome(driver);
				ch.ConnectionRepo();
				driver.navigate().to("https://icedqngvm1.eastus.cloudapp.azure.com:9443/ruler/outbound/workspaces");
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				navigatetoAppPage();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.navigate().refresh();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				break;

			case "ruleRepo":
				RuleRepoHomePage rr = new RuleRepoHomePage(driver);
				rr.ruleRepository();
				/*
				 * JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript(
				 * "window.open('https://icedqngvm1.eastus.cloudapp.azure.com:9443/ruler/outbound/workspaces','_blank');"
				 * ); ArrayList<String> tabs = new ArrayList<String>
				 * (driver.getWindowHandles()); driver.switchTo().window(tabs.get(1));
				 * //switches to new tab driver.manage().timeouts().pageLoadTimeout(3,
				 * TimeUnit.MINUTES); navigatetoAppPage();
				 * driver.switchTo().window(tabs.get(0)); // switch back to main screen
				 * driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				 */
				driver.navigate().to("https://icedqngvm1.eastus.cloudapp.azure.com:9443/ruler/outbound/workspaces");
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				navigatetoAppPage();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.navigate().refresh();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				break;
			case "DataPrep":
				HomePage dp = new HomePage(driver);
				dp.dataPrep();
				driver.navigate()
				.to("http://icedqngvm1.eastus.cloudapp.azure.com:4800/dataprep-ui/#/dataprep/datasets");
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				navigatetoAppPage();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.navigate().refresh();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				break;

			default:
				BaseSuite.reportLog("ModuleName not defined.");
				break;
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean loginWithRole(String username, String password) {

		boolean flag = false;
		try {

			BaseSuite bs = new BaseSuite();
			// bs.test = bs.extent.createTest("Login With Role::::: " + username);
			ReadConfig mailconfig = new ReadConfig();

			BaseSuite.reportLog("Launching browser!!!!");
			BaseSuite.validationReportLog("Launching browser successfully!!!");

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head")) && (!isDisplayed(driver, loginHeader))) {
				navigatetoAppPage();
			}
			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.validationReportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);

			BaseSuite.validationReportLog("Entered owner previledge UserName: " + username);
			clear_Click_SendKeys(driver, 2, passWord, password);

			BaseSuite.reportLog("Entered Password: " + password);
			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");
			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");
			waitForElement(driver, ToastMsgClosedBtn);
			captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, logeedInText, "LoggedIn");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");
			isDisplayedInLoop(driver, 30, welcome);
			if (isDisplayed(driver, welcome)) {
				flag = true;
				BaseSuite.validationReportLog("Welcome User label in the profile section is showing properly");
				BaseSuite.reportLog("Login User is :::: " + username);
				BaseSuite.validationReportLog("User Login successfully in the application!!");
				BaseSuite.reportLog("Getting Started with NextGen serivces");
			}
			HomePage hp = new HomePage(driver);
			hp.administration();
		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean loginWithOtherRole(String username, String password, String ModuleName) {

		boolean flag = false;
		try {

			if (isDisplayed(driver, loginHeader)) {
				flag = true;

				BaseSuite.validationReportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}
			isDisplayedInLoop(driver, 5, icedqTitle);
			if (isDisplayed(driver, icedqTitle)) {

				BaseSuite.validationReportLog("icedq Logo image is visible");
			} else {
				BaseSuite.reportLog("iceDQ logo is not loaded!");
			}
			verifyIndividualLabel(driver, rememberMe, "Remember Me");
			verifyIndividualLabel(driver, forgetPassword, "Forgot Password");

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 10, userName, username);

			BaseSuite.validationReportLog("Entered owner previledge UserName: " + username);
			clear_Click_SendKeys(driver, 10, passWord, password);

			BaseSuite.reportLog("Entered Password: " + password);
			isDisplayedInLoop(driver, 10, signin);
			displayAndClick(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");

			Thread.sleep(4000);
			/*
			 * isDisplayedInLoop(driver, 3, workspacePopUpWindow); if(isDisplayed(driver,
			 * workspacePopUpWindow)) { HomePage h1 = new HomePage(driver);
			 * h1.chooseWorkspace(BaseSuite.WorkspaceName); }else { if (isDisplayed(driver,
			 * ToastMsgClosedBtn)) { waitForElement(driver, ToastMsgClosedBtn);
			 * captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, logeedInText,
			 * "LoggedIn"); } isDisplayedInLoop(driver, 30, welcomeTxt); if
			 * (isDisplayed(driver, welcomeTxt)) { flag = true; BaseSuite.
			 * validationReportLog("Welcome User label in the profile section is showing properly"
			 * ); BaseSuite.reportLog("Login User is :::: " + username);
			 * BaseSuite.validationReportLog("User Login successfully in the application!!"
			 * );
			 * 
			 * BaseSuite.reportLog("Getting Started with NextGen serivces"); }
			 */
			switch (ModuleName) {
			case "administration":
				HomePage hp = new HomePage(driver);
				hp.administration();
				break;

			case "connectionRepo":
				ConnectionHome ch = new ConnectionHome(driver);
				ch.ConnectionRepo();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				Thread.sleep(3000);
				HomePage h1 = new HomePage(driver);
				h1.chooseWorkspace(BaseSuite.WorkspaceName);
				break;

			case "dataTesting":
				RuleRepoHomePage rr = new RuleRepoHomePage(driver);
				rr.dataTesting();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				Thread.sleep(5000);
				HomePage h = new HomePage(driver);
				h.chooseWorkspace(BaseSuite.WorkspaceName);
				break;

			case "DataPrep":
				HomePage dp = new HomePage(driver);
				dp.dataPrep();
				driver.navigate().to("https://icedqngvm1.eastus.cloudapp.azure.com:9443/ruler/outbound/workspaces");
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				navigatetoAppPage();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.navigate().refresh();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				break;

			default:
				BaseSuite.reportLog("ModuleName not defined.");
				break;
			}
			// }
		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean logOut() {
		boolean flag = false;
		int a = 0;
		try {
			isDisplayedInLoop(driver, 2, icedqLogo);
			if(isDisplayed(driver, icedqLogo)) {

				displayAndClick(driver, icedqLogo);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}

			waitForExecution(1000);
			isDisplayedInLoop(driver, 30, userProfile);
			waitForElement(driver, userProfile);
			displayAndClick(driver, userProfile);
			waitForExecution(2000);
			BaseSuite.reportLog("Clicked on the profile drop down option...");
			isDisplayedInLoop(driver, 30, signOut);
			if (isDisplayed(driver, signOut)) {
				click(driver, signOut);
				waitForExecution(3000);
				BaseSuite.reportLog("Clicked on Logout button");
				
				isDisplayedInLoop(driver, 2 , userName);
				if (isDisplayed(driver, userName)) {
					BaseSuite.reportLog("You are on login page...");
					return true; 
				}
				
			} else {
				BaseSuite.reportFailLog("Logout button not visible on current page", "logOut");
				displayAndClick(driver, ProfileDropDownOptionClick);

				isDisplayedInLoop(driver, 30, signOut);

				click(driver, signOut);
				waitForExecution(3000);
			}
			isDisplayedInLoop(driver, 1, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				clickOnButton(driver, discardButtons, "Discard ", true);
			}
			isDisplayedInLoop(driver, 1, sidebarCloseIcon);
			if (isDisplayed(driver, sidebarCloseIcon)) {
				clickOnButton(driver, sidebarCloseIcon, "Sidebar close icon ", true);
			}
			if (isDisplayed(driver, signin)) {
				flag = true;
				BaseSuite.reportLog("User Logout is successful");
				BaseSuite.validationReportLog("User Logout successfully from the application!!");
			} else {

				if (a == 0) {
					logOut();
				}
				a++;

			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to logged out from the application!", ex);
		}

		return flag;

	}

	public boolean logoutFromApplication() {
		boolean flag = false;

		try {
			if (logoutSteps()) {
				waitForSignOut();

				if (isUserLoggedOut()) {
					flag = true;
					waitForExecution(1000);
					//driver.get(BaseSuite.baseURL);
					//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

					//waitForExecution(1000);

					BaseSuite.reportLog("User Logout is successful");
					BaseSuite.validationReportLog("User Logout successfully from the application!!");


				} else {
					BaseSuite.reportFailLog("Unable to log out from the application!!!", "logoutFromApplication");
				}
			}
		} catch (Exception e) {
			throw new AssertionError("Unable to log out from the application!!", e);
		}

		return flag;
	}

	private boolean logoutSteps() {
		try {
			// Check for logo and navigate to user profile
			if (isDisplayed(driver, icedqLogo)) {
				displayAndClick(driver, icedqLogo);
				BaseSuite.reportLog("Click on icedq logo");
				waitForSpinnerToDisappear();
			}

			// Check and click user profile
			if (isDisplayed(driver, userProfile)) {
				displayAndClick(driver, userProfile);
				BaseSuite.reportLog("Clicked on the profile drop-down option...");
				waitForSpinnerToDisappear();
			}else {
				BaseSuite.reportLog("Reattempting to logout from application...");
				displayAndClick(driver, icedqLogo);
				BaseSuite.reportLog("Click on icedq logo");
				waitForSpinnerToDisappear();
				displayAndClick(driver, userProfile);
				BaseSuite.reportLog("Clicked on the profile drop-down option...");
				waitForSpinnerToDisappear();
			}

			// Ensure the sign-out button is displayed
			return isDisplayed(driver, signOut);
		} catch (Exception e) {
			BaseSuite.reportFailLog("Error during logout steps", "logoutSteps");
			return false;
		}
	}

	private void waitForSpinnerToDisappear() {
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	}

	private void waitForSignOut() {
		waitMethod(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(signOut)).isDisplayed();
		displayAndClick(driver, signOut);
		BaseSuite.reportLog("Clicked on Logout button");
	}

	private boolean isUserLoggedOut() {
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		waitMethod(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(userName)).isDisplayed();
		if(!isDisplayed(driver, userName)) {
			BaseSuite.reportLog("Username field not visible refreshing a browser tab");
			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		}
		waitForSpinnerToDisappear();
		waitForExecution(1000);
		return elementNotVisible(driver, signOut);
	}

	public boolean loginWithInvalidUserData(String username, String password, String loginInvalid) {

		boolean flag = false;
		try {

			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.reportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);
			BaseSuite.reportLog("Entered UserName: " + username);

			clear_Click_SendKeys(driver, 2, passWord, password);
			BaseSuite.reportLog("Entered Password: " + password);

			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");

			if (loginInvalid.equalsIgnoreCase("Invalid")) {
				flag = true;
				BaseSuite.validationReportLog("Entered Username/Password is invalid");
			}

			else if (loginInvalid.equalsIgnoreCase("space")) {
				BaseSuite.validationReportLog(
						"Entered Username/Password is blank and not able to login into application!");
			} else if (loginInvalid.equalsIgnoreCase("specialChar")) {
				BaseSuite.validationReportLog(
						"Entered Username/Password having special character, hence not able to login into application!");
			}

			else {

				BaseSuite.validationReportLog("User is able to login with the invalid data");
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public void redirectToApp() {
		String browserInfo = BaseSuite.browserName.toLowerCase();

		if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			navigatetoAppPage();
		}
	}

	public boolean LoginWithValidUserData(String username, String password, String loginValid) {

		boolean flag = false;
		try {

			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.reportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);
			BaseSuite.reportLog("Entered UserName: " + username);

			clear_Click_SendKeys(driver, 2, passWord, password);
			BaseSuite.reportLog("Entered Password: " + password);

			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");
			Thread.sleep(5000);

			if (isDisplayed(driver, welcome)) {

				flag = true;
				BaseSuite.validationReportLog("User Login successfully: " + username);
				isDisplayedInLoop(driver, 20, landingPageUserOptions);
				click(driver, landingPageUserOptions);
				isDisplayedInLoop(driver, 10, signOut);
				click(driver, signOut);
				BaseSuite.reportLog("Clicked on logout button");
				BaseSuite.validationReportLog("User Logout successfully: " + username);

			} else {

				BaseSuite.reportFailLog("User is unable to login into application with specified details!",
						"LoginWithValidUserData");
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean verifyforgotPasswordlink() {
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}
			// isDisplayedInPage(driver, "Forgot Password");
			isDisplayedInLoop(driver, 3, forgotLink);

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");
			}

			/*
			 * if(isDisplayed(driver,ForgetBacktoLogin)) { flag =true; click(driver,
			 * submit); BaseSuite.reportLog("Clicked on Submit button"); Thread.sleep(3000);
			 * click(driver, ForgetBacktoLogin);
			 * BaseSuite.reportLog("Clicked on Back to login button");
			 * 
			 * }
			 */

		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}

	public boolean verifyforgotPasswordLink() {
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			isDisplayedInLoop(driver, 3, forgotLink);

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");

				if (isDisplayed(driver, forgotPasswordBackToLogin)) {
					click(driver, forgotPasswordBackToLogin);

					isDisplayedInLoop(driver, 3, signin);
					if (isDisplayed(driver, signin)) {
						flag = true;
						BaseSuite.reportLog("Back to Login Page");
					}
				} else {
					assertEqual(softAssert, forgotPasswordBackToLogin, "Unable to click Back to login link");

				}

			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}
	/*
	 * public boolean Enterforgotpasswordemail(String email) { boolean flag=false;
	 * try { String browserInfo = BaseSuite.browserName.toLowerCase();
	 * 
	 * if ((browserInfo != null) && (!browserInfo.contains("head"))) {
	 * navigatetoAppPage(); } //String actualTitle = driver.getTitle(); //String
	 * expectedTitle = "Log in to Development Environment";
	 * //assertEquals(expectedTitle, actualTitle); isDisplayedInPage(driver,
	 * "Forgot Your Password?"); isDisplayedInLoop(driver, 3,
	 * Enteremailforgotpassword );
	 * 
	 * if(isDisplayed(driver, Enteremailforgotpassword)) { flag =true;
	 * //click(driver, Enteremailforgotpassword); sendKeys(driver,
	 * Enteremailforgotpassword, email); BaseSuite.reportLog("Entered email" +
	 * email); click(driver, submit);
	 * BaseSuite.reportLog("Clicked on Submit button");
	 * 
	 * }
	 * 
	 * } catch (Exception ex) { throw new AssertionError("Unable to enter email",
	 * ex); } return flag; }
	 */

	// public boolean verifymandatoryfields(SoftAssert softAssert, String email){
	//
	// boolean loginLabel = isDisplayed(driver, ForgotpageLabel);
	//
	// softAssert.assertTrue(loginLabel);
	//
	// boolean flag=false;
	// try {
	// String browserInfo = BaseSuite.browserName.toLowerCase();
	//
	// if ((browserInfo != null) && (!browserInfo.contains("head")))
	// {
	// navigatetoAppPage();
	// }
	//
	// //boolean verifyemail= isDisplayed(driver, ForgetBacktoLogin);
	// isDisplayedInLoop(driver, 3,ForgotpageLabel);
	//
	// if(isDisplayed(driver, ForgotpageLabel)) {
	// flag = true;
	// if (!email.isEmpty())
	// {
	// clear(driver, Enteremailforgotpassword);
	// sendKeys(driver, Enteremailforgotpassword, email);
	// click(driver, submit);
	// BaseSuite.reportLog("Clicked on Submit button");
	//
	// }
	// }
	//
	// }
	// catch (Exception ex)
	// {
	// throw new AssertionError("Unable to enter email", ex);
	// }

	// Login Page assertion for valid and invalid details
	public void assertEqual(SoftAssert softAssert, By actual, String expectedResult) {

		String actualResult = getText(driver, actual);

		softAssert.assertEquals(actualResult, expectedResult, "Msg didn't match for " + expectedResult);

	}

	public void continueNext(String FileName, String SheetName, String userNameCol, ExtentTest test, int userNumber,
			String errorMsg, Logger log, String columnName, String methodName)
					throws IOException, EncryptedDocumentException, InvalidFormatException,
					org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		BaseClassUtil util = new BaseClassUtil();

		XLUtils xl = new XLUtils();

		String ruleName = xl.readUsingColName(FileName, SheetName, userNumber, userNameCol);// get the rule name from
		// excel
		// sheet

		try {

			xl.writeToExcel("Fail", FileName, SheetName, userNumber, columnName);// write the excel as fail into the
			// status
			// column

		} catch (Exception e) {

			e.getStackTrace();

		}

		test.error("User Name " + userNameCol + " with User number " + userNumber + " failed");// log the error in
		// extent
		// report

		test.error(errorMsg);// Log the exception in extent report

		String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen shot
		// name

		test.addScreenCaptureFromBase64String(screenshotPath);// log the screen shot in extent report

		log.debug(errorMsg);// also log this error into application log

	}

	public boolean verifyBackToLogin() {
		boolean flag = false;
		SoftAssert softAssert = new SoftAssert();
		try {
			//
			// String browserInfo = BaseSuite.browserName.toLowerCase();
			//
			//
			//
			// if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			// navigatetoAppPage();
			// }
			//
			if (isDisplayed(driver, forgotLink)) {
				click(driver, forgotLink);
				if (isDisplayed(driver, forgotPasswordBackToLogin)) {
					click(driver, forgotPasswordBackToLogin);

					if (isDisplayed(driver, signin)) {
						flag = true;
						BaseSuite.reportLog("Back to Login Page");
					}
				} else {
					assertEqual(softAssert, forgotPasswordBackToLogin, "Unable to click Back to login link");

				}
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}

	public boolean verifyForgetPasswordDetails() {
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");
				if (isDisplayed(driver, forgotPasswordLabel)) {
					BaseSuite.reportLog("Forgot password label is displayed properly");
					clear_Click_SendKeys(driver, 2, forgotPasswordUserName, userDetails1);
					click(driver, forgotPasswordSubmitBtn);

				}

				else if (isDisplayed(driver, forgotPasswordBackToLogin)) {
					click(driver, forgotPasswordBackToLogin);

				} else {
					assertEqual(softAssert, forgotPasswordLabel, "Forgot password page not displayed");

				}
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}

	public boolean ForgetPasswordWithValid_InvalidData(SoftAssert softAssert, String email) {

		boolean loginLabel = isDisplayed(driver, forgotPasswordLabel);

		softAssert.assertTrue(loginLabel);

		boolean flag = false;
		try {
			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");

				isDisplayedInLoop(driver, 3, forgotPasswordLabel);

				if (isDisplayed(driver, forgotPasswordLabel)) {
					flag = true;
					if (!email.isEmpty()) {
						clear(driver, forgotPasswordUserName);
						sendKeys(driver, forgotPasswordUserName, email);
						click(driver, forgotPasswordSubmitBtn);
						BaseSuite.reportLog("Clicked on Submit button");

					}
				}
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to enter email", ex);
		}
		return flag;
	}

	public void secure() {
		String browserInfo = BaseSuite.browserName.toLowerCase();

		if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			navigatetoAppPage();
		}
	}

	public boolean loginWithValidUsers(String username, String password, String loginvalid) {

		boolean flag = false;
		try {
			/*
			 * String browserInfo = BaseSuite.browserName.toLowerCase();
			 * 
			 * 
			 * if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			 * navigatetoAppPage(); }
			 */

			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.reportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);
			BaseSuite.reportLog("Entered UserName" + username);

			clear_Click_SendKeys(driver, 2, passWord, password);
			BaseSuite.reportLog("Entered Password" + password);

			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");
			Thread.sleep(5000);
			if (loginvalid.equalsIgnoreCase("Valid")) {
				if (isDisplayed(driver, welcome)) {

					flag = true;
					BaseSuite.reportLog("User Login is successful");
					isDisplayedInLoop(driver, 20, landingPageUserOptions);
					click(driver, landingPageUserOptions);
					isDisplayedInLoop(driver, 10, signOut);
					click(driver, signOut);
					BaseSuite.reportLog("Clicked on logout button");
				}
			} else {

				BaseSuite.reportErrorLog("User not able to login into the application");
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean verifyAzureADfunction1st() {
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			isDisplayedInLoop(driver, 3, AzureADLabel);
			if (isDisplayed(driver, AzureADLabel)) {
				flag = true;
				click(driver, AzureAD);
				// driver.get(key2);

				BaseSuite.reportLog("User clicked on Sign in With AzureAD button");
			} else {
				BaseSuite.reportLog("User not able to click on the AzureAd button");
			}

			if (actualTitle == expectedTitle) {
				flag = true;
				actualTitle = driver.getTitle();
				expectedTitle = "Sign in to your account";
				assertEquals(expectedTitle, actualTitle);
				// driver.getCurrentUrl();
				// driver.navigate().to("");
				// isDisplayedInLoop(driver,3, Microsoftsignin);
				click(driver, Microsoftsignin);
				sendKeys(driver, Microsoftsignin, "abhilesh.k@toranainc.com");
				Thread.sleep(3000);
				click(driver, Microsoftnext);
				isDisplayedInLoop(driver, 3, Loginheader);
				Thread.sleep(3000);
				click(driver, Micropass);
				sendKeys(driver, Micropass, Epass);
				click(driver, Micronext);
				actualTitle = driver.getTitle();
				expectedTitle = "Sign in to your account";
				assertEquals(expectedTitle, actualTitle);
				Thread.sleep(3000);
				click(driver, StaySignIn);
				Thread.sleep(3000);

			} else if (isDisplayed(driver, AzureUpdatepage)) {
				BaseSuite.reportLog("User redirected on the page AzureAD update accout information page ");
			}

			else {
				BaseSuite.reportLog("User redirected on the home page if already Sign in with AzureAD");
			}

		}

		catch (Exception ex) {
			throw new AssertionError("Unable to click on Button!", ex);
		}

		return flag;

	}

	public boolean verifyAzureADfunction2nd(SoftAssert softAssert, String USERNAME, String Email, String FirstName,
			String LastName) {
		boolean flag = false;
		boolean AzureLabel = isDisplayed(driver, LableAzureAD);
		softAssert.assertTrue(AzureLabel);
		try {
			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			isDisplayedInLoop(driver, 3, LableAzureAD);
			BaseSuite.reportLog("User is on the Update Account Information page");
			if (isDisplayed(driver, LableAzureAD) && (Email.isEmpty())) {
				flag = true;
				click(driver, ADSubmit);
				BaseSuite.reportLog("All the  mandatory field messages should be display");
			} else {
				BaseSuite.reportLog("Not able to see the all mandatory field messages");
			}

			if (isDisplayed(driver, ADUsername)) {
				flag = true;
				clear_Click_SendKeys(driver, 2, ADUsername, USERNAME);
				clear_Click_SendKeys(driver, 2, ADemail, Email);
				clear_Click_SendKeys(driver, 2, ADfirstname, FirstName);
				clear_Click_SendKeys(driver, 2, ADlastname, LastName);
				click(driver, ADSubmit);
				BaseSuite.reportLog("User clicked on Submit button");
				BaseSuite.reportLog("User not able to sign in with Invalid data");
			} else {
				BaseSuite.reportLog("User able to sign in with invalid data");
			}

			if (isDisplayed(driver, LableAzureAD)) {
				flag = true;
				clear_Click_SendKeys(driver, 2, ADUsername, USERNAME);
				clear_Click_SendKeys(driver, 2, ADemail, Email);
				clear_Click_SendKeys(driver, 2, ADfirstname, FirstName);
				clear_Click_SendKeys(driver, 2, ADlastname, LastName);
				click(driver, ADSubmit);
				BaseSuite.reportLog("User clicked on Submit button");
				BaseSuite.reportLog("User able to sign in with valid data");
			}

			else {
				BaseSuite.reportLog("User not able to sign in with valid data");
			}
		}

		catch (Exception ex) {
			throw new AssertionError("User not able to enter on the update account information page", ex);
		}
		return flag;

	}

	public void otherUserLogin(String usertype) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(usertype);

		String UN = loginDetails[0];

		String PW = loginDetails[1];

		// String MN = loginDetails[2];
		BaseSuite.reportLog("Logging with " + usertype);
		// login(UN, PW, MN);

		loginWithRole(UN, PW);

	}

	public void otherUserLogin(String usertype, String MN)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(usertype);

		String UN = loginDetails[0];

		String PW = loginDetails[1];

		// String MN = loginDetails[2];
		BaseSuite.reportLog("Logging with " + usertype);
		// login(UN, PW, MN);

		loginWithOtherRole(UN, PW, MN);

	}

	public boolean navigatetoAppPage1() {
		boolean flag = false;
		try {

			isDisplayedInLoop(driver, 2, sendAnyWayButton);
			if (isDisplayed(driver, sendAnyWayButton)) {
				displayAndClick(driver, sendAnyWayButton);

				BaseSuite.reportLog("Successfully clicked on the Send Anyway button ");

				isDisplayedInLoop(driver, 2, proceedToApplication);

				waitMethod(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(proceedToApplication)).isDisplayed();

				displayAndClick(driver, proceedToApplication);

				waitMethod(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(userName)).isDisplayed();
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}
	// new login method for qa instance also updated in baseclassutil - in
	// launchbrowser

	public boolean login1(String username, String password, String ModuleName, String workspaceName) {

		boolean flag = false;
		try {

			BaseSuite bs = new BaseSuite();
			bs.test = bs.extent.createTest("verifyLoginToApplication_503");
			ReadConfig mailconfig = new ReadConfig();

			bs.test.log(Status.INFO, "X-ray Test Case URL");
			bs.test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-503");
			ExecutionResult.issueKey = "NG21-503";

			BaseSuite.reportLog("Launching browser!!!!");
			BaseSuite.validationReportLog("Launching browser successfully!!!");

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {

				navigatetoAppPage();
			}

			if (isDisplayed(driver, loginHeader)) {
				flag = true;

				BaseSuite.validationReportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}
			isDisplayedInLoop(driver, 5, icedqTitle);
			if (isDisplayed(driver, icedqTitle)) {

				BaseSuite.validationReportLog("icedq Logo image is visible");
			} else {
				BaseSuite.reportLog("iceDQ logo is not loaded!");
			}
			//verifyIndividualLabel(driver, rememberMe, "Remember Me");
			verifyIndividualLabel(driver, forgetPassword, "Forgot Password");
			// verifyVisibilityOfButtons(driver, customerLogin, "Customer Login", true);
			// verifyVisibilityOfButtons(driver, employeeLogin, "Employee Login", true);

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 10, userName, username);

			BaseSuite.validationReportLog("Entered owner previledge UserName: " + username);
			clear_Click_SendKeys(driver, 10, passWord, password);

			BaseSuite.reportLog("Entered Password: " + password);
			isDisplayedInLoop(driver, 10, signin);
			displayAndClick(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");

			// isDisplayedInLoop(driver, 30, sendAnyWayButton);
			/*
			 * if (isDisplayed(driver, sendAnyWayButton)) { navigatetoAppPage1(); }
			 */

			Thread.sleep(1000);
			if (isDisplayed(driver, ToastMsgClosedBtn)) {
				waitForElement(driver, ToastMsgClosedBtn);
				captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, logeedInText, "LoggedIn");
			}
			isDisplayedInLoop(driver, 30, welcomeTxt);
			if (isDisplayed(driver, welcomeTxt)) {
				flag = true;
				BaseSuite.validationReportLog("Welcome User label in the profile section is showing properly");
				BaseSuite.reportLog("Login User is :::: " + username);
				BaseSuite.validationReportLog("User Login successfully in the application!!");

				BaseSuite.reportLog("Getting Started with NextGen serivces");
			}
			switch (ModuleName) {
			case "administration":
				HomePage hp = new HomePage(driver);
				hp.administration();
				break;

			case "connectionRepo":
				ConnectionHome ch = new ConnectionHome(driver);
				ch.ConnectionRepo();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				Thread.sleep(3000);
				HomePage h1 = new HomePage(driver);
				h1.chooseWorkspace(workspaceName);
				break;

			case "dataTesting":
				RuleRepoHomePage rr = new RuleRepoHomePage(driver);
				rr.dataTesting();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				Thread.sleep(5000);
				HomePage h = new HomePage(driver);
				h.chooseWorkspace(workspaceName);
				break;

			case "DataPrep":
				HomePage dp = new HomePage(driver);
				dp.dataPrep();
				driver.navigate().to("https://icedqngvm1.eastus.cloudapp.azure.com:9443/ruler/outbound/workspaces");
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				navigatetoAppPage();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.navigate().refresh();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				break;

			default:
				BaseSuite.reportLog("ModuleName not defined.");
				break;
			}

		} catch (Exception ex) {
			Thread.currentThread().interrupt();

			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean loginToAppWithDifferentRole(String username, String password) {

		boolean flag = true;

		try {
			isDisplayedInLoop(driver, 0, userName);

			if (!isDisplayed(driver, userName)) {
				isDisplayedInLoop(driver, 0, ProfileDropDownOptionClick);
				if (isDisplayed(driver, ProfileDropDownOptionClick)) {
					logOut();
				}

				isDisplayedInLoop(driver, 10, sendAnyWayButton);

				if (isDisplayed(driver, sendAnyWayButton)) {
					navigatetoAppPage1();
				}

				if (isDisplayed(driver, workspacePopUpWindow)) {
					driver.get(BaseSuite.baseURL);
					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
				}
			}
			isDisplayedInLoop(driver, 2, loginHeader);
			if (isDisplayed(driver, loginHeader)) {

				BaseSuite.validationReportLog("You are on the Login Page!");

			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}
			isDisplayedInLoop(driver, 2, icedqTitle);
			if (isDisplayed(driver, icedqTitle)) {

				BaseSuite.validationReportLog("icedq Logo image is visible");
			} else {
				BaseSuite.reportLog("iceDQ logo is not loaded!");
			}

			//verifyIndividualLabel(driver, rememberMe, "Remember Me");

			verifyIndividualLabel(driver, forgetPassword, "Forgot Password");

			flag = enterValueToTextField(driver, userName, "Username", username);
			if (flag) {
				flag = enterValueToTextField(driver, passWord, "Password", password);
			}
			if (flag) {
				flag = clickOnButton(driver, signin, "Sign In", true);
			}
			Thread.sleep(2000);
			if (flag) {

				isDisplayedInLoop(driver, 0, invalidCredentialMsg);
				if (isDisplayed(driver, invalidCredentialMsg)) {

					String errmsg = getText(driver, invalidCredentialMsg);
					BaseSuite.reportFailLog("User Not logged into application :: " + errmsg,
							"loginToAppWithDifferentRole");
					driver.get(BaseSuite.baseURL);
					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
					flag = false;
				} else if (isDisplayed(driver, newPassword)) {

					flag = enterValueToTextField(driver, newPassword, "New Password", password);
					if (flag) {
						flag = enterValueToTextField(driver, confirmNewPassword, "Confirm Password", password);
					}
					if (flag) {
						flag = clickOnButton(driver, submitButton, "Submit", true);
					}
				} else {

					isDisplayedInLoop(driver, 10, welcome);
					if (isDisplayed(driver, welcome)) {
						String name = getText(driver, welcome);
						BaseSuite.reportLog("welcome message is visible .... " + name);
						BaseSuite.validationReportLog("You are on the icedq welcome Page!!");
					} else {
						flag = false;
						BaseSuite.reportFailLog(
								"User : " + username + " not able to login into application, kindly check", password);
					}
				}
			} else {
				BaseSuite.reportFailLog("User not login successfully kundly check", "loginToAppWithDifferentRole");
			}
		} catch (Exception e) {
			flag = false;
			BaseSuite.reportErrorLog("Observed error :  : " + e.toString());
			Thread.currentThread().interrupt();
		}

		return flag;
	}

	public boolean seleteModuleAndWorkspace(String moduleName, String workspaceName, String toastMessage,
			String icedqUser) {

		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {
			Thread.sleep(1000);

			isDisplayedInLoop(driver, 2, welcomeTxt);
			if (isDisplayed(driver, welcomeTxt)) {

				BaseSuite.validationReportLog("Welcome User label in the profile section is showing properly");

				BaseSuite.reportLog("Getting Started with NextGen serivces");
			}
			switch (moduleName) {
			case "administration":

				hp.clickOnAdministrationTab();
				break;

			case "connectionRepo":
				ConnectionHome ch = new ConnectionHome(driver);
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				flag = ch.ConnectionRepo();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				Thread.sleep(3000);
				isDisplayedInLoop(driver, 2, workspacePopUpWindow);
				if (!isDisplayed(driver, workspacePopUpWindow)) {
					ch.ConnectionRepo();
				}
				flag = chooseWorkspaceWithToast(workspaceName, toastMessage, icedqUser);
				break;

			case "Data Testing":
				RuleRepoHomePage rr = new RuleRepoHomePage(driver);
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				rr.dataTesting();
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				Thread.sleep(3000);
				flag = chooseWorkspaceWithToast(workspaceName, toastMessage, icedqUser);

				break;
			case "connectors":

				hp.clickOnConnectorsTab();

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				waitForExecution(2000);

				flag=chooseWorkspaceWithToast(workspaceName,toastMessage,icedqUser);

				break;
			default:
				BaseSuite.reportLog("ModuleName not defined.");
				flag = false;
				break;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Observed error :  : " + e.toString());
			Thread.currentThread().interrupt();
			flag = false;
		}

		return flag;
	}

	/** Choose workspace method as per new ui **/

	public boolean chooseWorkspaceWithToast(String workspaceName, String message, String icedqUser) {

		boolean flag = false;

		SoftAssert s = new SoftAssert();

		Actions action = new Actions(driver);

		try {
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
			isDisplayedInLoop(driver, 5, workspacePopUpWindow);

			if (isDisplayed(driver, workspacePopUpWindow)) {

				// chooseWorkspaceType();

				WebElement s1 = driver.findElement(workspaceList);

				if (!icedqUser.equalsIgnoreCase("application_admin")) {

					BaseSuite.reportLog("Selecting Workspace...");

					isDisplayedInLoop(driver, 20, workspaceList);

					BaseSuite.reportLog("Search text box is displayed, to search workspace :: " + workspaceName);

					action.click(s1).build().perform();

					BaseSuite.validationReportLog("Clicked on workspace search successfully");

					isDisplayedInLoop(driver, 10, workspaceSearch);

					WebElement s2 = driver.findElement(workspaceSearch);

					action.click(s2).build().perform();

					BaseSuite.reportLog("Entering workspace name :: " + workspaceName);

					sendKeys(driver, workspaceSearch, workspaceName);

					BaseSuite.reportLog("Entered workspace name :: " + workspaceName);

					isDisplayedInLoop(driver, 5, returnElement(createElement, dynamicName, workspaceName));

					if (isDisplayed(driver, returnElement(createElement, dynamicName, workspaceName))) {

						displayAndClick(driver, returnElement(createElement, dynamicName, workspaceName));

						BaseSuite.validationReportLog(

								"Successfully searched & clicked on workspace :: " + workspaceName);

						// check weather correct connection is selected.

						waitForElement(driver, workspaceList);

						String con = getAttribute(driver, workspaceList, valueAttribute);

						s.assertEquals(con, workspaceName, "Expected workspace didnt matched with selected workspace.");

						if (con.equalsIgnoreCase(workspaceName)) {

							flag = true;

							BaseSuite.validationReportLog("Correct workspace :: " + con + " is selected.");

						}

						clickOnButton(driver, okButton, "Ok", true);

						inVisible(driver, spinner, Constant.ruleWait);

						// driver.get("https://qa.onprem.icedq.com/connection-ui/#/connection-repo/connections?workspaceId=wksc-d50f794e-8b9a-5af4-8c06-de3fc86a01e0&workspaceName=wip_rahulw");
						// driver.manage().window().maximize();
						//driver.navigate().refresh();

						inVisible(driver, spinner, Constant.ruleWait);

						if (isDisplayed(driver, toastMsg)) {

							flag = captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, message, "Validation Toast");

						}

					} else {

						BaseSuite.reportFailLog("Workspace name not found :: " + workspaceName, "chooseWorkspace");

						action.click(s1).build().perform();

						clickOnButton(driver, cancelButton, "Cancel", true);

						inVisible(driver, spinner, Constant.ruleWait);

						if (isDisplayed(driver, workspacePopUpWindow)) {

							clickOnButton(driver, okButton, "ok", true);

							inVisible(driver, spinner, Constant.ruleWait);

						}

						logOut();

					}

				} else {

					action.click(s1).build().perform();

					isDisplayedInLoop(driver, 1, workspaceNoRecordFound);

					if (isDisplayed(driver, workspaceNoRecordFound)) {

						flag = true;

						BaseSuite.validationReportLog("No Records Found messege received for Admin User");

						action.click(s1).build().perform();

						clickOnButton(driver, cancelButton, "Cancel", true);

						inVisible(driver, spinner, Constant.ruleWait);

						Thread.sleep(2000);

						if (isDisplayed(driver, workspacePopUpWindow)) {

							clickOnButton(driver, okButton, "ok", true);

							inVisible(driver, spinner, Constant.ruleWait);

						}

					} else {

						BaseSuite.reportFailLog("Workspace list is visible ", "chooseWorkspace");

						if (isDisplayed(driver, workspacePopUpWindow)) {

							clickOnButton(driver, okButton, "ok", true);

							inVisible(driver, spinner, Constant.ruleWait);

						}

						logOut();

					}

				}

			} else {

				BaseSuite.reportLog("Workspace pop up window not visible ");

			}

		} catch (Exception e) {

			e.getMessage();

			flag = false;

			Thread.currentThread().interrupt();

			flag = false;

		}

		return flag;

	}

	/** Choose workspace method as per new UI */
	public boolean chooseWorkspaceWithToast(String workspaceName, String message, String icedqUser, boolean a) {
		boolean flag = false;
		SoftAssert s = new SoftAssert();
		Actions action = new Actions(driver);
		log.info(a);
		try {

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			waitMethod(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(workspacePopUpWindow)).isDisplayed();

			if (isDisplayed(driver,workspacePopUpWindow, 20)) {

				flag = handleWorkspaceSelection(workspaceName, message, icedqUser, action, s);
			} else {
				BaseSuite.reportLog("Workspace pop up window not visible ");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("chooseWorkspaceWithToast "+e.getMessage());
			flag = false;
		}

		return flag;
	}

	/** Handles the selection of workspace */
	private boolean handleWorkspaceSelection(String workspaceName, String message, String icedqUser, Actions action, SoftAssert s) {
		boolean flag = false;
		WebElement workspaceElement = driver.findElement(workspaceList);

		if (!icedqUser.equalsIgnoreCase("application_admin")) {
			//	flag = selectWorkspace(workspaceName, message, action, s, workspaceElement);
			flag = selectWorkspace(workspaceName, getAccountName(""), message);
		} else {
			flag = handleAdminUser(action, workspaceElement);
		}

		return flag;
	}

	/** Selects the workspace for non-admin users */
	private boolean selectWorkspace(String workspaceName, String message, Actions action, SoftAssert s, WebElement workspaceElement) {
		boolean flag = false;

		BaseSuite.reportLog("Selecting Workspace...");
		isDisplayedInLoop(driver, 20, workspaceList);

		action.click(workspaceElement).build().perform();
		BaseSuite.validationReportLog("Clicked on workspace search successfully");

		WebElement workspaceSearchBox = driver.findElement(workspaceSearch);
		action.click(workspaceSearchBox).build().perform();

		isDisplayed(driver,  workspaceSearch, 20);
		BaseSuite.reportLog("Entering workspace name :: " + workspaceName);
		sendKeys(driver, workspaceSearch, workspaceName);

		isDisplayedInLoop(driver, 5, returnElement(createElement, dynamicName, workspaceName));

		if (isDisplayed(driver, returnElement(createElement, dynamicName, workspaceName), 20)) {
			displayAndClick(driver, returnElement(createElement, dynamicName, workspaceName));
			BaseSuite.validationReportLog("Successfully searched & clicked on workspace :: " + workspaceName);

			// Validate workspace selection
			waitForElement(driver, workspaceList);
			String selectedWorkspace = getAttribute(driver, workspaceList, valueAttribute);
			s.assertEquals(selectedWorkspace, workspaceName, "Expected workspace didn't match with selected workspace.");

			if (selectedWorkspace.equalsIgnoreCase(workspaceName)) {
				flag = true;
				BaseSuite.validationReportLog("Correct workspace :: " + selectedWorkspace + " is selected.");
			}

			// Final steps
			clickOnButton(driver, okButton, "Ok", true);
			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, toastMsg)) {
				flag = captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, message, "Validation Toast");
			}
		}
		else {
			handleWorkspaceNotFound(workspaceElement);
		}

		return flag;
	}

	public boolean selectWorkspace(String workspaceName,String accountName, String message) {
		boolean flag = false;

		Actions action = new Actions(driver);
		BaseSuite.reportLog("Selecting Workspace...");
		isDisplayedInLoop(driver, 20, workspaceList);

		WebElement workspaceElement = driver.findElement(workspaceList);

		action.click(workspaceElement).build().perform();
		BaseSuite.validationReportLog("Clicked on workspace search successfully");

		WebElement workspaceSearchBox = driver.findElement(workspaceSearch);
		action.click(workspaceSearchBox).build().perform();

		isDisplayed(driver,  workspaceSearch, 20);
		BaseSuite.reportLog("Entering workspace name :: " + workspaceName);
		sendKeys(driver, workspaceSearch, workspaceName);

		isDisplayedInLoop(driver, 5, returnTwoElements(dynamicWorkspaceSelect,"$acc", accountName, dynamicName, workspaceName));

		if (isDisplayed(driver, returnTwoElements(dynamicWorkspaceSelect,"$acc", accountName, dynamicName, workspaceName), 20)) {

			displayAndClick(driver, returnTwoElements(dynamicWorkspaceSelect,"$acc", accountName, dynamicName, workspaceName));

			BaseSuite.validationReportLog("Successfully searched & clicked on workspace :: " + workspaceName);

			// Validate workspace selection
			waitForElement(driver, workspaceList);
			String selectedWorkspace = getAttribute(driver, workspaceList, valueAttribute);

			if (selectedWorkspace.contains(workspaceName)) {
				flag = true;
				BaseSuite.validationReportLog("Correct workspace :: " + selectedWorkspace + " is selected.");
			}

			// Final steps
			clickOnButton(driver, okButton, "Ok", true);
			inVisible(driver, spinner, Constant.ruleWait);

			if (isDisplayed(driver, toastMsg)) {
				flag = captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, message, "Validation Toast");
			}
		}
		else {
			handleWorkspaceNotFound(workspaceElement);
		}

		return flag;

	}



	/** Handles the case when the workspace is not found */
	private void handleWorkspaceNotFound(WebElement workspaceElement) {
		BaseSuite.reportFailLog("Workspace name not found", "chooseWorkspace");

		// Retry or cancel
		Actions action = new Actions(driver);
		action.click(workspaceElement).build().perform();
		clickOnButton(driver, cancelButton, "Cancel", true);
		inVisible(driver, spinner, Constant.ruleWait);

		if (isDisplayed(driver, workspacePopUpWindow)) {
			clickOnButton(driver, okButton, "ok", true);
			inVisible(driver, spinner, Constant.ruleWait);
		}

		logOut();
	}

	/** Handles the workspace selection for admin users */
	private boolean handleAdminUser(Actions action, WebElement workspaceElement) {
		boolean flag = false;

		action.click(workspaceElement).build().perform();
		isDisplayedInLoop(driver, 1, workspaceNoRecordFound);

		if (isDisplayed(driver, workspaceNoRecordFound)) {
			flag = true;
			BaseSuite.validationReportLog("No Records Found message received for Admin User");

			action.click(workspaceElement).build().perform();
			clickOnButton(driver, cancelButton, "Cancel", true);
			inVisible(driver, spinner, Constant.ruleWait);

			// Wait for the pop-up to disappear
			waitForExecution(2000);
			if (isDisplayed(driver, workspacePopUpWindow)) {
				clickOnButton(driver, okButton, "ok", true);
				inVisible(driver, spinner, Constant.ruleWait);
			}
		} else {
			BaseSuite.reportFailLog("Workspace list is visible for admin grant user ", "chooseWorkspace");
			clickOnButton(driver, okButton, "ok", true);
			inVisible(driver, spinner, Constant.ruleWait);
			logOut();
		}

		return flag;
	}







	public boolean loginWithIcedqUserAndSelectWorkspace(String icedqUser, String workspaceName, String moduleName, String expectedMessage) {

		String username;
		String password;
		String temp = "";

		try {
			if (icedqUser != null && !icedqUser.isEmpty()) {

				if (icedqUser.equalsIgnoreCase(ConstantProperty.ICEDQ_SUPERADMINUSER)) {
					username = Constant.ICEDQ_ADMIN_USERNAME;
					password = Constant.ICEDQ_ADMIN_PASSWORD;

				} else {
					String[] loginDetails = new XLUtils().readDataFromExcelUsingColumnName(icedqUser);
					username = loginDetails[0];
					password = loginDetails[1];
					temp = loginDetails[2];
				}

			} else {
				username = BaseSuite.username;
				password = BaseSuite.password;
			}

			boolean loginSuccess = loginToAppWithDifferentRoleNew(username, password, temp);

			if (loginSuccess) {
				return seleteModuleAndWorkspaceNew(moduleName, workspaceName, expectedMessage, icedqUser);
			}
			return false;

		} catch (Exception e) {
			BaseSuite.reportFailLog("Exception occurs kindly check : " + e.getMessage(),
					"loginWithIcedqUserAndSelectWorkspace");
			return false;
		}
	}

	By selectWorkspaceTypeInput = getElementLocator(prop.getProperty("Workspace.WorkspaceType.input"));

	/** select workspace type **/

	public void chooseWorkspaceType() {

		isDisplayedInLoop(driver, 1, selectWorkspaceTypeInput);

		if (isDisplayed(driver, selectWorkspaceTypeInput)) {

			if (isEnabled(driver, selectWorkspaceTypeInput)) {
				BaseSuite.reportLog("select workspace type is enabled");

			} else {
				BaseSuite.reportLog("select workspace type is disabled");

				String acType = getAttribute(driver, selectWorkspaceTypeInput, valueAttribute);

				BaseSuite.reportLog("Workspace type : " + acType + " is selected");
			}

		}

	}

	public boolean loginToAppWithDifferentRole1(String username, String password) {

		boolean flag=true;

		try {

			isDisplayedInLoop(driver, 0, userName);

			if(!isDisplayed(driver, userName)) {

				if(isDisplayed(driver, workspacePopUpWindow)) {
					clickOnButton(driver, okButton, "Ok", true);
				}

				isDisplayedInLoop(driver, 1, ProfileDropDownOptionClick);

				if(isDisplayed(driver,ProfileDropDownOptionClick)) {
					logOut();
				}

				isDisplayedInLoop(driver, 10, sendAnyWayButton);

				if (isDisplayed(driver, sendAnyWayButton)) {
					navigatetoAppPage1(); 
				}

				if(isDisplayed(driver, workspacePopUpWindow) || isDisplayed(driver, newPassword)) {
					driver.get(BaseSuite.baseURL);
					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
				}
			}

			isDisplayedInLoop(driver, 2, loginHeader);
			if (isDisplayed(driver, loginHeader)) {

				BaseSuite.validationReportLog("You are on the Login Page!");

			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}
			isDisplayedInLoop(driver, 2, icedqTitle);
			if (isDisplayed(driver, icedqTitle)) {

				BaseSuite.validationReportLog("icedq Logo image is visible");
			} else {
				BaseSuite.reportLog("iceDQ logo is not loaded!");
			}

			verifyIndividualLabel(driver, forgetPassword, "Forgot Password");

			flag=enterValueToTextField(driver, userName, "Username", username);
			if(flag) {
				flag=enterValueToTextField(driver, passWord, "Password", password);
			}
			if(flag) {
				flag=clickOnButton(driver, signin, "Sign In", true);
			}
			waitForExecution(2000);
			if(flag) {

				isDisplayedInLoop(driver, 0, invalidCredentialMsg);
				if(isDisplayed(driver, invalidCredentialMsg)) {

					String errmsg=getText(driver, invalidCredentialMsg);
					BaseSuite.reportFailLog("User Not logged into application :: "+errmsg, "loginToAppWithDifferentRole");
					driver.get(BaseSuite.baseURL);
					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
					flag=false;
				}else if(isDisplayed(driver, newPassword)) {

					flag=enterValueToTextField(driver, newPassword, "New Password", password);
					if(flag) {
						flag=enterValueToTextField(driver, confirmNewPassword, "Confirm Password", password);
					}
					if(flag) {
						flag=clickOnButton(driver, submitButton, "Submit", true);
					}
				}	
				else {

					isDisplayedInLoop(driver, 10, welcome);
					if(isDisplayed(driver, welcome)) {
						String name = getText(driver, welcome);
						BaseSuite.reportLog("welcome message is visible .... "+name);
						BaseSuite.validationReportLog("You are on the icedq welcome Page!!");
					}else {
						//	flag=false;
						//	BaseSuite.reportFailLog("User : "+username+" not able to login into application, kindly check", password);
					}
				}
			}else {
				BaseSuite.reportFailLog("User not login successfully kundly check", "loginToAppWithDifferentRole");
			}
		} catch (Exception e) {
			flag=false;
			BaseSuite.reportErrorLog("Observed error :  : "+e.toString());
			Thread.currentThread().interrupt();
		}

		return flag;
	}

	public void handleDiscardDeletePopupOpenAndLogout() {

		By discardLocator = returnElement(popupOpenDiscardCancel, dynamicName, "Discard");
		By cancelLocator = returnElement(popupOpenDiscardCancel, dynamicName, "Cancel");
		if(isDisplayed(driver, discardLocator)) {

			clickOnButton(driver, discardLocator, "discard", true);

		}else if(isDisplayed(driver, cancelLocator)){
			clickOnButton(driver, cancelLocator, "cancel", true);
		}
	}

	public void checkForUserNameOnPage() {
		try {
			if (isDisplayed(driver, userName)) {
				BaseSuite.reportLog("You are on login page...");
				return; // Exit early if userName is already visible
			}

			// Handle sendAnyway button and navigate back
			isDisplayedInLoop(driver, 1, sendAnyWayButton);
			if (isDisplayed(driver, sendAnyWayButton)) {
				navigatetoAppPage1();
				if (isDisplayed(driver, userName)) return;
			}

			if(!isDisplayed(driver, userName)) {
				driver.get(BaseSuite.baseURL);
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
				navigatetoAppPage1();
				if (isDisplayed(driver, userName)) return;
			}

			// Handle workspace popup
			if (isDisplayed(driver, workspacePopUpWindow)) {
				clickOnButton(driver, okButton, "Ok", true);
				if (isDisplayed(driver, userName)) return;
			}

			// Check user profile and log out if necessary
			isDisplayedInLoop(driver, 1, userProfile);
			if (isDisplayed(driver, userProfile)) {
				logoutFromApplication();
				if (isDisplayed(driver, userName)) return;
			}

			// Check user profile and log out if necessary
			isDisplayedInLoop(driver, 1, userProfile);
			if (isDisplayed(driver, userProfile)) {
				logoutFromApplication();
				if (isDisplayed(driver, userName)) return;
			}

			// Check user profile and log out if necessary
			isDisplayedInLoop(driver, 1, userProfile);
			if (isDisplayed(driver, userProfile)) {
				handleDiscardDeletePopupOpenAndLogout();
				logoutFromApplication();
				if (isDisplayed(driver, userName)) return;
			}

			// Handle cases where workspace popup or new password is still present
			if (isDisplayed(driver, workspacePopUpWindow) || isDisplayed(driver, newPassword)) {
				driver.get(BaseSuite.baseURL);
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "checkForUserNameOnPage");
		}
	}


	public void checkForField(By locator, String message, String errorMsg) {

		isDisplayedInLoop(driver, 2, locator);
		if (isDisplayed(driver, locator)) {

			BaseSuite.validationReportLog(message);

		} else {
			BaseSuite.reportLog(errorMsg);
		}

	}

	public boolean enterUserNameAndPasswordToSignIn(Boolean flag, String username, String password) {

		flag = enterValueToTextField(driver, userName, "Username", username);

		if (Boolean.TRUE.equals(flag)) {
			flag = enterValueToTextField(driver, passWord, "Password", password);
		}
		if (Boolean.TRUE.equals(flag)) {
			flag = clickOnButton(driver, signin, "Sign In", true);
		}
		return flag;
	}

	public boolean enterNewPasswordToSignIn(Boolean flag, String password) {

		flag = enterValueToTextField(driver, newPassword, "New Password", password);
		if (Boolean.TRUE.equals(flag)) {
			flag = enterValueToTextField(driver, confirmNewPassword, "Confirm Password", password);
		}
		if (Boolean.TRUE.equals(flag)) {
			flag = clickOnButton(driver, submitButton, "Submit", true);
		}
		return flag;
	}

	public boolean loginToAppWithDifferentRoleWithNewPassoword(String username, String password, String tempPassword) {

		boolean flag = true;

		try {

			isDisplayedInLoop(driver, 0, userName);

			checkForUserNameOnPage();

			checkForField(loginHeader, "You are on the Login Page!", "Login Page is not loaded!");

			checkForField(icedqTitle, "icedq Logo image is visible", "iceDQ logo is not loaded!");

			/** verifyIndividualLabel(driver, rememberMe, "Remember Me"); **/

			verifyIndividualLabel(driver, forgetPassword, "Forgot Password");

			enterUserNameAndPasswordToSignIn(true, username, tempPassword);

			waitForExecution(2000);

			//	if (flag) {

			isDisplayedInLoop(driver, 0, invalidCredentialMsg);
			if (isDisplayed(driver, invalidCredentialMsg)) {

				String errmsg = getText(driver, invalidCredentialMsg);

				BaseSuite.reportFailLog("User Not logged into application :: " + errmsg,
						"loginToAppWithDifferentRole");

				driver.navigate().refresh();

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

				flag=enterUserNameAndPasswordToSignIn(true, username, tempPassword);

			}else if(isDisplayed(driver, newPassword)) {


			} else if (isDisplayed(driver, newPassword)) {

				flag = enterNewPasswordToSignIn(true, password);
			} else {

				isDisplayedInLoop(driver, 10, welcome);
				if (isDisplayed(driver, welcome)) {
					String name = getText(driver, welcome);
					BaseSuite.reportLog("welcome message is visible .... " + name);
					BaseSuite.validationReportLog("You are on the icedq welcome Page!!");

				}else {
					//							flag=false;
					//							BaseSuite.reportFailLog("User : "+username+" not able to login into application, kindly check", password);

				}
			}
			//	} else {
			//		BaseSuite.reportFailLog("User not login successfully kundly check", "loginToAppWithDifferentRole");
			//	}
		} catch (Exception e) {

			flag=false;
			BaseSuite.reportErrorLog("Observed error :  : "+e.toString());


		}

		return flag;
	}

	public boolean loginWithNewIcedqUserAndSelectWorkspace(String icedqUser, String workspaceName, String moduleName,
			String expectedMessage) {
		boolean flag = true;

		XLUtils xl = new XLUtils();

		String[] loginDetails = xl.readDataFromExcelUsingColumnName(icedqUser);

		String uN = loginDetails[0];

		String pW = loginDetails[1];

		String temp = loginDetails[2];

		try {

			flag = loginToAppWithDifferentRoleWithNewPassoword(uN, pW, temp);

			if (flag) {

				flag = seleteModuleAndWorkspace(moduleName, workspaceName, expectedMessage, icedqUser);

			}

		} catch (Exception e) {

			flag = false;

			BaseSuite.reportFailLog("Exception occurs kindly check : " + e.getMessage(),
					"loginWithIcedqUserAndSelectWorkspace");

		}

		return flag;
	}


	public boolean loginToAppWithDifferentRoleNew(String username, String password, String tempPassword) {
	    boolean flag = true;

	    try {
	        // Initial login page checks
	        isDisplayedInLoop(driver, 0, userName);
	        checkForUserNameOnPage();
	        checkForField(loginHeader, "You are on the Login Page!", "Login Page is not loaded!");
	        checkForField(icedqTitle, "icedq Logo image is visible", "iceDQ logo is not loaded!");
	        verifyIndividualLabel(driver, forgetPassword, "Forgot Password");

	        // First login attempt
	        flag = enterUserNameAndPasswordToSignIn(true, username, password);
	        waitForExecution(2000);
	        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

	        // Check for welcome message
	        if (isDisplayed(driver, welcome)) {
	            displayWelcomeMessage();
	            return true;
	        }

	        // If login failed, handle invalid credentials or password change
	        handleInvalidOrChangedPassword(username, password, tempPassword);

	        // Final welcome check
	        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	        waitForExecution(2000);
	        isDisplayedInLoop(driver, 2, welcome);

	        if (!isDisplayed(driver, welcome)) {
	            BaseSuite.reportLog("Welcome message not visible, refreshing browser tab.");
	            driver.navigate().refresh();
	            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

	            if (isDisplayed(driver, backToApplicationLink)) {
	                BaseSuite.reportFailLog("Logout screen appears, kindly check", "loginToAppWithDifferentRoleNew1");
	                clickOnButton(driver, backToApplicationLink, "Back to Application", true);
	                driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	                waitForLoaderToDisapper(driver);
	                isDisplayedInLoop(driver, 10, welcome);
	            }
	        }

	        // Final validation
	        if (isDisplayed(driver, welcome, 1200)) {
	            displayWelcomeMessage();
	        } else {
	            BaseSuite.reportFailLog("User not logged into application. Kindly check.", "loginToAppWithDifferentRoleNew");
	            flag = false;
	        }

	    } catch (Exception e) {
	        flag = false;
	        BaseSuite.reportErrorLog("Observed error: " + e.toString());
	    }

	    return flag;
	}

	// Extracted for readability
	private void displayWelcomeMessage() {
	   
	    String name = getText(driver, welcome);
	    BaseSuite.reportLog("Welcome message is visible: " + name);
	    BaseSuite.validationReportLog("You are on the icedq welcome page!");
	}

	private void handleInvalidOrChangedPassword(String username, String password, String tempPassword) {
	    
		if (isDisplayed(driver, invalidCredentialMsg)) {
	        driver.navigate().refresh();
	        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
	        enterUserNameAndPasswordToSignIn(true, username, tempPassword);

	        if (isDisplayed(driver, newPassword)) {
	            enterNewPasswordToSignIn(true, password);
	        }
	    } else if (isDisplayed(driver, newPassword)) {
	        enterNewPasswordToSignIn(true, password);
	    }
	}

	public boolean seleteModuleAndWorkspaceNew(String moduleName, String workspaceName, String toastMessage, String icedqUser) {

		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {
			waitForExecution(2000);

			/**	validateElement(driver, welcomeTxt, "Welcome User label in the profile section", "label");*/

			switch (moduleName.toLowerCase()) {
			case "administration":

				hp.clickOnAdministrationTab();

				break;

			case "datatesting":
			case "data testing":
				hp.clickOnDataTestingTab();

				driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
				waitForExecution(2000);

				flag=chooseWorkspaceWithToast(workspaceName,toastMessage,icedqUser, true);

				break;

			case "connectionrepo":

				hp.clickOnConnectorsTab();

				driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
				waitForExecution(2000);

				flag=chooseWorkspaceWithToast(workspaceName,toastMessage,icedqUser,true);

				break;

			case "scheduler":

				hp.clickOnSchedulerTab();

				driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
				waitForExecution(2000);
				waitForLoaderToDisapper(driver);
				flag=chooseWorkspaceWithToast(workspaceName,toastMessage,icedqUser,true);

				break;

			default:
				BaseSuite.reportLog("ModuleName not defined kindly check");
				flag=false;
				break;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Observed error :  : " + e.toString());

			flag=false;
		}

		return flag;
	}


	//--------------------------------------- data encryption and de-cryption code -----------------------



	String secretkey=prop.getProperty("ref.key");
	static String secretInstance=prop.getProperty("ref.instance");
	static String secretByteType=prop.getProperty("ref.encode.type");

	private static SecretKeySpec secretInstanceKey;

	public static void setKey(String myKey) 
	{
		MessageDigest sha = null;
		try {
			byte[] key1 = myKey.getBytes(secretByteType);
			sha = MessageDigest.getInstance("SHA-1");
			key1 = sha.digest(key1);
			key1 = Arrays.copyOf(key1, 16); 
			secretInstanceKey = new SecretKeySpec(key1, "AES");
		} 
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} 

	}

	public static String encrypt(String strToEncrypt, String secret) 
	{
		try
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance(secretInstance);
			cipher.init(Cipher.ENCRYPT_MODE, secretInstanceKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(secretByteType)));
		} 
		catch (Exception e) 
		{
			BaseSuite.reportErrorLog("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt, String secret) 
	{
		try
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance(secretInstance);
			cipher.init(Cipher.DECRYPT_MODE, secretInstanceKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} 
		catch (Exception e) 
		{
			BaseSuite.reportErrorLog("Error while decrypting: " + e.toString());
		}
		return null;
	}


	public String encryptedPasswordDecrypt(String icedqUser) {
		String password="";

		try {
			switch(icedqUser.toLowerCase()) {

			case "account_owner":
				/**	enString = encrypt("", secretkey);
				System.out.println(enString);**/
				password = decrypt("/8HD+m8I1dsxs8V95dZnSA==", secretkey);
				break;

			case "account_contributor":
			case "account_executor":
			case "account_reader":
				/**	enString = encrypt("", secretkey);
				System.out.println(enString);**/
				password = decrypt("ohWbHkhwUbVlLirwEEPmEg==", secretkey);
				break;

			case "workspace_owner":
				/**	enString = encrypt("", secretkey);
				System.out.println(enString);**/
				password = decrypt("xtFzB52Qyj5+KOihFwdU+Q==", secretkey);
				break;

			case "workspace_contributor":
			case "workspace_executor":
			case "workspace_reader":
				/**	enString = encrypt("", secretkey);
				System.out.println(enString);**/
				password = decrypt("dMO9LWwz0aNA0Sp8hOxA3g==", secretkey);
				break;

			case "application_admin":
				/**	enString = encrypt("", secretkey);
				System.out.println(enString);**/
				password = decrypt("qK9MusSwKsugGBMdaT+RJw==", secretkey);
				break;
			default:

				break;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("error occur while decrypting password "+e.getMessage());
		}

		return password;
	}

}