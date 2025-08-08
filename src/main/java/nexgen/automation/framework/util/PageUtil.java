package nexgen.automation.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.connectionRepo.ConnectionPoJO;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.constant.ExecutionResult;

public class PageUtil {

	public static WebDriverWait wait;

	protected static final Properties prop = new Properties();
	/**
//	public static String splitArea1 = "";

//	public static String splitArea2 = "";

//	public static String splitArea3 = "";*/
	SoftAssert softAssert = new SoftAssert();

	static final Logger log = Logger.getLogger(PageUtil.class);

	public static final String DIR_PATH=System.getProperty("user.dir");

	String returnReadyStateContent="return document.readyState";
	String completeContent="complete";
	String attributeTextContents="textContent";
	static String toastMessageProp="Workflow.Toast.Message";
	static String spinnerProp="dataT.spinner";
	String scrollProp="ScrollToElementArgument";
	String errorState="Observed error for : ";

	String msgDontMatched=" Messages didn't match.";
	String verifyingContent="Verifying ";
	String noRecordsToDisplayContent="No records to display";
	String isContentLog = " is : ";
	
	String valueContent = "value";
	String attributeClassx ="class";
	String checkContentx ="check";
	String uncheckContentx="uncheck";
	String enableContentx="enabled";
	String disableContentx="disabled";
	
	public static void beforesuite() {

		File folder = new File(DIR_PATH + "/src/main/resources/locator/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				log.info("File " + listOfFiles[i].getName());

				Properties prop2 = new Properties();

				File src = new File(DIR_PATH + "/src/main/resources/locator/" + listOfFiles[i].getName());

				try (FileInputStream fis = new FileInputStream(src);){

					prop2.load(fis);

					prop.putAll(prop2);
				} catch (Exception e) {
					log.info("Exception is " + e.getMessage());

				}

			} else if (listOfFiles[i].isDirectory()) {
				log.info("Directory " + listOfFiles[i].getName());
			}
		}
		/**
	//	splitArea1 = prop.getProperty("SplitArea1");

	//	splitArea2 = prop.getProperty("SplitArea2");

	//	splitArea3 = prop.getProperty("SplitArea3");*/
		ExecutionResult.totalcount = 0;
		ExecutionResult.passedTC = 0;
		ExecutionResult.failedTC = 0;
		ExecutionResult.testskip = 0;
		ExecutionResult.test = 0;
		ExecutionResult.catagory="";
		ExecutionResult.testName="";
		ExecutionResult.author="";
	}

	public String readConfig(String key) {
		return prop.getProperty(key);
	}

	public By getElementLocator(String locator) {

		if (locator == null || !locator.contains("~~")) {
			log.error("Invalid locator format: " + locator);
			return null;
		}

		try {

			String[] parts = locator.split("~~", 2);

			String type = parts[0].trim().toLowerCase();
			String value = parts[1].trim();

			switch (type) {
			case "xpath":           return By.xpath(value);
			case "id":              return By.id(value);
			case "css":             return By.cssSelector(value);
			case "name":            return By.name(value);
			case "classname":       return By.className(value);
			case "linktext":        return By.linkText(value);
			case "partiallinktext": return By.partialLinkText(value);
			case "tagname":         return By.tagName(value);
			default:
				log.warn("Unknown locator type '" + type + "'. Defaulting to XPath.");
				return By.xpath(value);
			}

		} catch (Exception e) {
			log.error("Error while parsing locator: " + locator + " - " + e.getMessage(), e);
			return null;
		}
	}


	public By concate(String locator1, String locator2) {
		By locator = null;
		try {
			String[] result1 = locator1.split("~~");

			String locatorValue1 = result1[1];

			String[] result2 = locator2.split("~~");

			String locatorValue2 = result2[1];

			String finalLocator = locatorValue1 + locatorValue2;

			locator = By.xpath(finalLocator);


		} catch (Exception e) {
			log.error(e.getMessage());
			throw new IllegalArgumentException("Failed in concate()");
		}
		return locator;
	}

	public boolean isDisplayed(WebDriver driver, By locator) {
		try {

			WebElement element = waitMethod(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element.isDisplayed(); 
		} catch (TimeoutException e) {
			log.error("Element not visible within timeout: " + locator);
			// try finding the element again
			try {
				waitForSpinnerToDisappear(driver);
				waitForExecution(1000);
				return driver.findElement(locator).isDisplayed(); // Fallback
			} catch (Exception ex) {
				log.error("Element not found during fallback check: " + locator);
				return false;
			}
		} catch (Exception e) {
			log.error(" Unexpected error: " + e.getMessage());
			return false;
		}
	}

	public boolean isEnabled(WebDriver driver, By locator) {

		try {

			return  waitMethod(driver).until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in isEnabled() for locator" + locator);
		}
	}

	public boolean isSelected(WebDriver driver, By locator) {

		try {

			return  waitMethod(driver).until(ExpectedConditions.elementToBeClickable(locator)).isSelected();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in isSelected() for locator" + locator);
		}
	}

	public void click(WebDriver driver, By locator) {

		try {

			waitMethod(driver).until(ExpectedConditions.elementToBeClickable(locator)).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in click() for locator " + locator);
		}
	}

	public String getText(WebDriver driver, By locator) {

		try {
			String resulttring = null;

			resulttring =  waitMethod(driver).until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
			return resulttring;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in getText() for locator " + locator);
		}

	}

	public void clear(WebDriver driver, By locator) {

		try {

			waitMethod(driver).until(ExpectedConditions.elementToBeClickable(locator)).clear();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in clear() for locator " + locator);
		}
	}

	public void visible(WebDriver driver, By locator) {

		try {

			waitMethod(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ElementNotVisibleException("Failed in visible() for locator " + locator);
		}

	}

	public void clear_SendKeys(WebDriver driver, By locator, String keysToSend) {

		try {

			isDisplayed(driver, locator);

			clear(driver, locator);

			isDisplayed(driver, locator);

			sendKeys(driver, locator, keysToSend);

		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());

			throw new NoSuchElementException("Failed in clear_SendKeys() for locator " + locator);
		}

	}

	public void visible(WebDriver driver, By locator, int time) {

		WebDriverWait ewait = new WebDriverWait(driver, time);
		ewait.ignoring(NoSuchElementException.class);
		ewait.ignoring(StaleElementReferenceException.class);
		ewait.ignoring(ElementClickInterceptedException.class);

		try {

			ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ElementNotVisibleException("Failed in visible() for locator " + locator);
		}
	}

	public void inVisible(WebDriver driver, By locator) {

		try {

			waitMethod(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in inVisible() for locator " + locator);
		}
	}

	public boolean inVisible(WebDriver driver, By locator, int time) {

		boolean flag=true;
		WebDriverWait exwait = new WebDriverWait(driver, time);
		exwait.ignoring(NoSuchElementException.class);
		exwait.ignoring(StaleElementReferenceException.class);
		exwait.ignoring(ElementClickInterceptedException.class);
		exwait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(returnReadyStateContent).equals(completeContent));
		try {

			flag=exwait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			BaseSuite.reportFailLog("Spinner Didn't stop", "inVisible");
			driver.navigate().refresh();
			log.error(e.getMessage());
			BaseSuite.reportFailLog("Failed due to visible spinner", "inVisible");
			driver.navigate().refresh();
			BaseSuite.reportLog("Refreshing the current page");
			driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			flag=false;
		}
		return flag;
	}

	public void sendKeys(WebDriver driver, By locator, String keysToSend) {
		try {

			waitMethod(driver).until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(keysToSend);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in sendkeys() for locator " + locator);
		}
	}

	public boolean sendKeys(WebDriver driver, By locator, String label, String inputValue) {

		boolean state = true;
		String methodName = "enterValueToTextField";

		try {
			isDisplayedInLoop(driver, 2, locator);

			if(isDisplayed(driver, locator)) {
				BaseSuite.reportLog(label+" is visible.");

				if (isEnabled(driver, locator)) {

					BaseSuite.reportLog(label+" is enabled.");

					if (isEditable(driver, locator, label)) {

						BaseSuite.reportLog(label + " is editable");

						BaseSuite.reportLog(" Entering " + label + " : " + inputValue);

						sendKeys(driver, locator, inputValue);

						BaseSuite.validationReportLog("Entered " + label + ": " + inputValue);

					} else {
						state = false;
						BaseSuite.reportFailLog(label + " is not editable", methodName);

					}
				} else {
					state = false;
					BaseSuite.reportFailLog(label + " is not enabled", methodName);

				}

			}else {
				state=false;
				BaseSuite.reportFailLog(label+" is not displayed.", methodName);

			}
		} catch (Exception e) {
			state = false;
			BaseSuite.reportErrorLog(e,errorState + label + " : " + e.getMessage());

		}
		return state;
	}

	public void selectByVisibleText(WebDriver driver, By locator, String text) {

		try {

			Select select = new Select(waitMethod(driver, Constant.LONGW).until(ExpectedConditions.visibilityOf(driver.findElement(locator))));
			select.selectByVisibleText(text);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in selectByVisibleText() for locator" + locator);
		}

	}

	public void selectByValue(WebDriver driver, WebElement locator, String text) {

		try {

			Select select = new Select(waitMethod(driver, Constant.LONGW).until(ExpectedConditions.visibilityOf(locator)));
			select.selectByValue(text);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in selectByValue() for locator" + locator);
		}

	}

	public WebDriverWait waitMethod(WebDriver driver) {

		wait = new WebDriverWait(driver, Constant.SHOTW);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementClickInterceptedException.class);
		// Wait for the page to load completely
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(returnReadyStateContent)
				.equals(completeContent));

		return wait;

	}

	public WebDriverWait waitMethod(WebDriver driver, int waitInSeconds) {

		wait = new WebDriverWait(driver, waitInSeconds);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementClickInterceptedException.class);
		// Wait for the page to load completely
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript(returnReadyStateContent)
				.equals(completeContent));

		return wait;

	}

	public void waitForPageLoad(WebDriver driver) {

		try {
			new WebDriverWait(driver, 60).until(
					webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript(returnReadyStateContent)
					.equals(completeContent)
					);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void dragAndDrop(WebDriver driver, By sourceObjectValue, By destinationObjectValue) {

		try {

			/**By sourceObject = getElementLocator(sourceObjectValue);

			//By destinationObject = getElementLocator(destinationObjectValue);**/


			WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(sourceObjectValue));
			WebElement destinationElement = wait.until(ExpectedConditions.elementToBeClickable(destinationObjectValue));

			((JavascriptExecutor) driver).executeScript(
					getJsDndHelper() + "simulateDragDrop(arguments[0], arguments[1])", sourceElement,
					destinationElement);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in dragAndDrop() for sourceObjectValue" + sourceObjectValue);

		}
	}

	private String getJsDndHelper() {

		return "function simulateDragDrop(sourceNode, destinationNode) {\r\n" + "var EVENT_TYPES = {\r\n"
				+ "DRAG_END: 'dragend',\r\n" + "DRAG_START: 'dragstart',\r\n" + "DROP: 'drop'\r\n" + "}\r\n" + " \r\n"
				+ "function createCustomEvent(type) {\r\n" + "var event = new CustomEvent(\"CustomEvent\")\r\n"
				+ "event.initCustomEvent(type, true, true, null)\r\n" + "event.dataTransfer = {\r\n" + "data: {\r\n"
				+ "},\r\n" + "setData: function(type, val) {\r\n" + "this.data[type] = val\r\n" + "},\r\n"
				+ "getData: function(type) {\r\n" + "return this.data[type]\r\n" + "}\r\n" + "}\r\n"
				+ "return event\r\n" + "}\r\n" + " \r\n" + "function dispatchEvent(node, type, event) {\r\n"
				+ "if (node.dispatchEvent) {\r\n" + "return node.dispatchEvent(event)\r\n" + "}\r\n"
				+ "if (node.fireEvent) {\r\n" + "return node.fireEvent(\"on\" + type, event)\r\n" + "}\r\n" + "}\r\n"
				+ " \r\n" + "var event = createCustomEvent(EVENT_TYPES.DRAG_START)\r\n"
				+ "dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, event)\r\n" + " \r\n"
				+ "var dropEvent = createCustomEvent(EVENT_TYPES.DROP)\r\n"
				+ "dropEvent.dataTransfer = event.dataTransfer\r\n"
				+ "dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent)\r\n" + " \r\n"
				+ "var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END)\r\n"
				+ "dragEndEvent.dataTransfer = event.dataTransfer\r\n"
				+ "dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent)\r\n" + "}";


	}

	public By returnElement(String dynamiclocator, String stringToBeReplaced, String dynamicValue) {

		try {
			String[] dynamiclocatorloca = dynamiclocator.split("~~");

			String locator = dynamiclocatorloca[1];

			return By.xpath(locator.replace(stringToBeReplaced, dynamicValue));

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in returnElement()");
		}
	}

	public String returnScript(String dynamiclocator, String stringToBeReplaced, String dynamicValue) {

		try {
			return dynamiclocator.replace(stringToBeReplaced, dynamicValue);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in returnScript()");
		}
	}

	public void javascript(WebDriver driver, String script) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javascript()");
		}

	}

	public void javascript(WebDriver driver, String script, By locator) {

		try {
			WebElement elem = driver.findElement(locator);

			((JavascriptExecutor) driver).executeScript(script, elem);

		} catch (Exception e) {
			log.error(e.getMessage());
			/**	throw new NoSuchElementException("Failed in javascriptScroll()");*/

		}

	}

	public void javascript(WebDriver driver, String script, WebElement elem) {

		try {
			((JavascriptExecutor) driver).executeScript(script, elem);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javascriptScroll()");

		}

	}

	public void scrollToElement(WebDriver driver, By locator) {
		WebElement elem = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elem);
	}

	public By concateAndReplace(String dynamiclocator1, String dynamiclocator2, String stringToBeReplaced,
			String dynamicValue) {
		try {

			String[] result1 = dynamiclocator1.split("~~");

			String locatorValue1 = result1[1];

			String[] result2 = dynamiclocator2.split("~~");

			String locatorValue2 = result2[1];

			String finalLocator = locatorValue1 + locatorValue2;

			return By.xpath(finalLocator.replace(stringToBeReplaced, dynamicValue));

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in concateAndReplace()");
		}
	}

	public void moveToElement(WebDriver driver, By locator) {

		try {
			Actions action = new Actions(driver);

			WebElement elem = driver.findElement(locator);

			action.moveToElement((elem)).clickAndHold().build().perform();
		} catch (Exception e) {

			throw new AssertionError();
		}
	}

	public void moveToElementBackSpace(WebDriver driver, By locator) {

		Actions action = new Actions(driver);

		WebElement elem = waitMethod(driver).until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));

		action.moveToElement((elem)).sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();

		action.moveToElement((elem)).sendKeys(Keys.BACK_SPACE).build().perform();
	}

	/**
	 * getcount
	 * 
	 * get count of the splitters
	 * 
	 * @param string
	 * @param type
	 * 
	 */
	public int getcount(String string, char type) {
		int commas = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == type)
				commas++;
		}

		return commas;

	}

	/*
	 * testCaseStatus
	 * 
	 * This method should be called for every rule script to check the test case
	 * status flag and it will also mark the script as failed if flag is greater
	 * than one
	 * 
	 * @param testCaseStatus
	 * 
	 * @param log
	 * 
	 */
	public void testCaseStatus(int testCaseStatus, Logger log) {

		if (testCaseStatus > 1) {// if the testCaseStatus flag is greater than one then it will mark the test
			// case as failed with a message.

			boolean testCaseFail = true;

			Assert.assertFalse(testCaseFail, "---Script failed due to some data creation/updation failed---");

			log.info("Script failed due to some data creation/updation failed");

		}

	}

	public void slider(WebDriver driver, By locator, Keys keys) {

		Actions action = new Actions(driver);

		action.moveToElement(waitMethod(driver).until(ExpectedConditions.elementToBeClickable(driver.findElement(locator))))
		.sendKeys(keys).build().perform();

	}

	public void verifyText(WebDriver driver, By verifyMsgLocator, String msgToBeVerified) {
		String msgText = getText(driver, verifyMsgLocator);

		if (!msgText.isEmpty()) {
			softAssert.assertEquals(msgText, msgToBeVerified, "Messages did'nt match");

			BaseSuite.reportLog("verified the message " + msgToBeVerified);
		}
	}

	public void isDisplayedInLoop(WebDriver driver, int count, By locator) {

		for (int i = 0; i <= count; i++) {

			if ((isDisplayed(driver, locator)) || (i == count))
				break;
		}
	}

	public void isDisplayedInPage(WebDriver driver, String message) {
		try {
			while (isAvailableInPage(driver, message)) {
				waitForExecution(200);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	public boolean isAvailableInPage(WebDriver driver, String message) {
		boolean flag = false;
		try {
			flag = driver.getPageSource().contains(message);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return flag;
	}

	public void javaScriptClick(WebDriver driver, By locator) {

		try {
			WebElement elem = driver.findElement(locator);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javaScriptClick()");
		}
	}

	public String getBrowserName(WebDriver driver) {
		String browserName = null;
		try {
			WrapsDriver wrapperAccess = (WrapsDriver) driver;
			WebDriver edriver = wrapperAccess.getWrappedDriver();
			Capabilities cap = ((RemoteWebDriver) edriver).getCapabilities();
			browserName = cap.getBrowserName().toLowerCase();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return browserName;
	}

	public void getColumnNames(String filename) {
		try (FileInputStream fis = new FileInputStream(new File(filename));
				XSSFWorkbook workbook = new XSSFWorkbook(fis);) {
			XSSFSheet spreadsheet = workbook.getSheetAt(0);

			int lastcell = spreadsheet.getRow(0).getLastCellNum();

			for (int i = 0; i <= lastcell; i++) {

				log.info(spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString());

			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public String getAttribute(WebDriver driver, By locator, String attribute) {
		String resulttring = null;
		try {

			resulttring = waitMethod(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);

		} catch (Exception e) {
			log.error(e.getMessage());
			/**	BaseSuite.reportFailLog("Failed in getAttribute() : "+attribute+" for locator " + locator, e.getMessage());*/
		}
		return resulttring;
	}

	public String javaScriptGetText(WebDriver driver, String script) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			return (String) js.executeScript(script);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javaScriptGetText()");

		}

	}

	public void waitForElement(WebDriver driver, By locator) {

		try {
			WebDriverWait waits = new WebDriverWait(driver, Constant.LONGW);
			waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in waitForElement() for locator " + locator);
		}

	}

	public List<WebElement> getElements(WebDriver driver, By locator) {
		List<WebElement> results = null;
		try {
			results = driver.findElements(locator);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in getElements() for locator " + locator);
		}
		return results;

	}

	public WebElement getElement(WebDriver driver, By locator) {
		WebElement results = null;
		try {

			results = waitMethod(driver, Constant.LONGW).until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));

		} catch (Exception e) {

			log.error(e.getMessage() + "Failed in getElement() for locator " + locator);

		}
		return results;

	}

	public void clear_Click_SendKeys(WebDriver driver, int count, By locator, String keysToSend) {

		try {
			waitForSpinnerToDisappear(driver);

			isDisplayedInLoop(driver, count, locator);

			click(driver, locator);

			waitForSpinnerToDisappear(driver);

			clear(driver, locator);

			waitForSpinnerToDisappear(driver);

			/**	isDisplayedInLoop(driver, count, locator);*/

			sendKeys(driver, locator, keysToSend);

		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());

			throw new NoSuchElementException("Failed in clear_Click_SendKeys() for locator " + locator);
		}

	}

	public void paginationInsearchfield(WebDriver driver, By locator) {

		try {

			List<WebElement> p = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
			// check if pagination link exists

			/**	log.info(p.size());**/

			if (!p.isEmpty()) {
				log.info("pagination exists ");

				// click on pagination link

				for (int i = 0; i < p.size(); i++) {

					log.info(p.get(i));
					p.get(i).click();
				}
			} else {
				log.info("pagination not exists");
			}

		} catch (Exception e) {
			throw new NoSuchElementException("Failed in pagination");
		}

	}

	public void paginationAllSymbol(WebDriver driver, By locator1, By locator2) {
		try {

			List<WebElement> p = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator1)));

			log.info(p.size());

			if (!p.isEmpty()) {
				log.info("pagination exists");

				for (int i = 0; i < p.size(); i++) {

					log.info(p.get(i));
					waitForExecution(1000);
					BaseSuite.reportLog("Try to click on pagination icon");
					p.get(i).click();
				}
			}

			List<WebElement> q = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator2)));
			log.info(q.size());
			if (!q.isEmpty()) {
				log.info("pagination exists");
				for (int j = 0; j < q.size(); j++) {

					log.info(q.get(j));
					waitForExecution(1000);

					q.get(j).click();
				}
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Failed in pagination");
		}
	}

	public void searchData(WebDriver driver, By locator1, By locator2, String keysToSend, int count,
			String dynamiclocator, String stringToBeReplaced, String dynamicValue) {

		try {
			/**	wait = waitMethod(driver);*/

			clear_Click_SendKeys(driver, count, locator1, keysToSend);

			isDisplayedInLoop(driver, count, locator2);

			click(driver, locator2);

			isDisplayedInLoop(driver, count, locator2);

			BaseSuite.reportLog("Select Searched Folder Group");

			click(driver, returnElement(dynamiclocator, stringToBeReplaced, dynamicValue));

		} catch (Exception e) {
			throw new NoSuchElementException("Failed in searchData() for locator " + dynamiclocator);
		}

	}

	public void getWindowHandler(WebDriver driver) {

		String mainWindow = driver.getWindowHandle(); // It will return the parent window name as a String
		Set<String> set = driver.getWindowHandles(); // It returns no. of windows opened by WebDriver and will return
		// Set of Strings
		Iterator<String> itr = set.iterator(); // Using Iterator to iterate with in windows
		while (itr.hasNext()) {
			String childWindow = itr.next(); // Compare whether the main windows is not equal to child window. If not
			// equal, we will close.

			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
				log.info(driver.switchTo().window(childWindow).getTitle());

				// Switch to the parent window and close the parent window.
				// then after closing parent window, switch to child window again to perform the
				// action.
				driver.switchTo().window(mainWindow);
				driver.close();
				driver.switchTo().window(childWindow);

			}
		}
	}

	public String javaScriptGetText(WebDriver driver, By locator) {

		try {
			WebElement elem = driver.findElement(locator);
			waitForExecution(1000);
			return (String) ((JavascriptExecutor) driver).executeScript("return jQuery(arguments[0]).text();", elem);

		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());

			throw new NoSuchElementException("Failed in javascriptGetText()");

		}

	}

	public void displayAndClick(WebDriver driver, By locator) {

		try {
			isDisplayed(driver, locator, Constant.MEDIUMW);

			click(driver, locator);

		} catch (Exception e) {

			BaseSuite.log.error(e.getMessage());
		}
	}

	public boolean displayAndClick(WebDriver driver, By locator, String label) {
		try {
			if (isDisplayed(driver, locator, Constant.MEDIUMW)) {

				TestLogger.clickOn(label);

				click(driver, locator);

				TestLogger.clicked(label);

			} else {
				BaseSuite.reportFailLog("Element '" + label + "' not displayed, skipping click.", "displayAndClick");
				return false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"displayAndClick failed: " + e.getMessage());
			return false;
		}
		return true;
	}

	public void captureToastMsg1(WebDriver driver, By locator1, By locator2, String mess, String label){

		SoftAssert soft = new SoftAssert();

		try {
			BaseSuite.reportLog("  Verifying " + label + " Message.");
			waitForLoaderToDisapper(driver);
			String validMess = getText(driver, locator1).trim();

			waitForElement(driver, locator2);

			displayAndClick(driver, locator2);

			BaseSuite.validationReportLog("Retrived Message for : " + label + " is :  " + validMess);
			BaseSuite.validationReportLog("Expected Message for : " + label + " is  : " + mess.trim());

			if (!validMess.isEmpty() && validMess.equalsIgnoreCase(mess.trim())) {

				soft.assertEquals(validMess, mess.trim());

				BaseSuite.validationReportLog(label + " Message Successfully Matched.");

			}

			else {
				BaseSuite.reportFailLog(label + msgDontMatched, "captureToastMsg1");

			}
		} catch (Exception e) {
			log.error(e.getMessage());

		}

	}

	public boolean captureToastMsg(WebDriver driver, By locator1, By locator2, String mess, String label) {
		String validMess;
		boolean flag = true;
		String methodName = "captureToastMsg2";
		try {
			BaseSuite.reportLog(" Verifying  " + label + " Message.");
			waitForLoaderToDisapper(driver);
			Actions actions = new Actions(driver);

			/** visible(driver, locator1, Constant.ruleWait);

			// moveToElement(driver, locator1);*/
			waitMethod(driver, Constant.LONGW).until(ExpectedConditions.visibilityOfElementLocated(locator1));
			actions.moveToElement(driver.findElement(locator1)).perform();

			/** wait.until(ExpectedConditions.textToBePresentInElementLocated(locator1,
			// mess));*/

			validMess = getText(driver, locator1).trim();

			if (validMess.isEmpty()) {
				validMess = getAttribute(driver, locator1, attributeTextContents);
			}

			/** actions.clickAndHold(driver.findElement(locator2)).build().perform();

			// wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));*/

			actions.click(driver.findElement(locator2)).build().perform();

			SoftAssert s = new SoftAssert();
			/** moveToElement(driver, locator2);*/
			s.assertEquals(validMess.trim(), mess.trim());
			BaseSuite.validationReportLog("Retrived Message for : " + label + isContentLog + validMess);
			BaseSuite.validationReportLog("Expected Message for : " + label + isContentLog + mess.trim());

			if (!validMess.isEmpty()) {

				if (validMess.trim().equalsIgnoreCase(mess.trim())) {

					BaseSuite.validationReportLog(label + " Message Successfully Matched.");
				} else {
					BaseSuite.reportFailLog(label + msgDontMatched, methodName);
					flag = false;
				}

			} else {
				BaseSuite.reportFailLog(label + msgDontMatched, methodName);
				flag = false;
			}
			isNotDisplayed(driver, locator2, 5);
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
			BaseSuite.reportFailLog(label + " Messages didn't found kindly check, captureToastMsg", methodName);
			flag = false;
		}
		return flag;
	}

	public boolean captureToastMsg(WebDriver driver,By locator1,By locator2,String mess,String label, boolean state){
		String validMess;
		boolean flag=true;
		String methodName ="captureToastMsg";
		try {
			BaseSuite.reportLog("Verifying  " +label+ " Message. ");
			waitForLoaderToDisapper(driver);
			Actions actions = new Actions(driver);

			waitMethod(driver).until(ExpectedConditions.visibilityOfElementLocated(locator1));
			actions.moveToElement(driver.findElement(locator1)).perform();

			validMess = getText(driver, locator1).trim();

			if(validMess.isEmpty()){ validMess = getAttribute(driver, locator1, attributeTextContents);}

			actions.click(driver.findElement(locator2)).build().perform();

			SoftAssert s =new SoftAssert();

			s.assertEquals(validMess.trim(), mess.trim());
			BaseSuite.validationReportLog("Retrived Message for  : " +label+ "  is :" + validMess);
			BaseSuite.validationReportLog("Expected Message for  : " +label+ "  is :" + mess.trim());

			if (!validMess.isEmpty()) {
				if (state) {
					if(validMess.trim().equalsIgnoreCase(mess.trim())) {

						BaseSuite.validationReportLog(label+ " Message Successfully Matched. ");
					}
					else
					{
						BaseSuite.reportFailLog(label+ msgDontMatched, methodName);
						flag=false;
					}
				}else {
					if(!validMess.trim().equalsIgnoreCase(mess.trim())) {

						BaseSuite.validationReportLog("Expected condition Successfully Matched");
					}
					else
					{
						BaseSuite.reportFailLog("Expected condition didn't Matched", methodName);
						flag=false;
					}

				}
			}
			else {
				BaseSuite.reportFailLog(label+ msgDontMatched, methodName);
				flag=false;
			}
			isNotDisplayed(driver, locator2, 5);
		} catch (Exception e) {
			BaseSuite.reportFailLog(label+ " Messages didn't found kindly check,",methodName+e.getMessage());
			flag=false;
		}
		return flag;
	}

	public boolean isClickable(WebDriver driver, By locator, String linkName, boolean expected) {

		SoftAssert soft = new SoftAssert();
		boolean status = false;
		try {

			waitMethod(driver).until(ExpectedConditions.elementToBeClickable(locator));
			BaseSuite.validationReportLog(linkName + " Link/Button/Field is Clickable");
			status = true;

		} catch (Exception e) {

			BaseSuite.validationReportLog(linkName + " Link/Button/Field is not Clickable");

		}
		soft.assertEquals(status, expected);
		return status;
	}

	public boolean isEditable(WebDriver driver, By locator, String fieldName) {

		try {

			waitMethod(driver).until(ExpectedConditions.elementToBeClickable(locator));
			BaseSuite.validationReportLog(fieldName + " field is Editable.");
			return true;
		} catch (Exception e) {

			BaseSuite.validationReportLog(fieldName + " field is not Editable.");
			return false;
		}
	}

	public void getAllLinkAndVerifyLinkText(WebDriver driver, By locator, String linkText) {

		try {

			List<WebElement> allLinks = driver.findElements(locator);

			for (WebElement specificlink : allLinks) {

				if (specificlink.getText().trim().equalsIgnoreCase(linkText.trim())) {

					BaseSuite.validationReportLog(linkText + " text found and Text is matched");

					break;

				} else {

					BaseSuite.reportFailLog(linkText + " Text not found and Text is not matched",
							"getAllLinkAndVerifyLinkText");

				}
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}
	}

	public boolean verifyIndividualLabel(WebDriver driver, By locator, String labelName) {

		boolean status = false;
		try {
			BaseSuite.reportLog("Checking for label " + labelName);

			if (isDisplayed(driver, locator, Constant.SHOTW)) {

				if (isDisplayed(driver, locator)) {

					status = true;

					BaseSuite.validationReportLog(labelName + " field is displaying in the page");
				} else {

					BaseSuite.reportFailLog(labelName + " field is not displaying in the page",
							"verifyIndividualLabel");
				}
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}

		return status;
	}

	public boolean verifyVisibilityOfButtons(WebDriver driver, By locator, String buttonName, boolean expected) {
		SoftAssert soft = new SoftAssert();
		boolean status = false;
		try {

			BaseSuite.reportLog("Verifying for button " + buttonName);

			isDisplayedInLoop(driver, 1, locator);
			if (isDisplayed(driver, locator)) {
				boolean b = isEnabled(driver, locator);
				if (b) {
					status = true;

					BaseSuite.validationReportLog(buttonName + " button is enabled in the page");
				} else {

					BaseSuite.validationReportLog(buttonName + " button is disabled in the page");
				}
				soft.assertEquals(status, expected, buttonName + " button is expected to be " + expected
						+ " & actual status of button as " + status + " :: ");
				boolean isEqual = (status == expected);
				if (isEqual) {
					status = true;
					BaseSuite.validationReportLog(buttonName + " button visibility is matched with expected condition");
				} else {
					BaseSuite.reportFailLog(buttonName + " button is expected to be " + expected
							+ " & actual status of button as " + status, "verifyVisibilityOfButtons");
					status =false;
				}
			} else {
				BaseSuite.reportFailLog(buttonName + " button is not visible", "verifyVisibilityOfButtons");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"verifyVisibilityOfButtons :: " + e.getMessage());
		}

		return status;
	}

	public void validateButtons(WebDriver driver, By locator, int count) {

		try {
			if (count!=0) {

				BaseSuite.reportLog("Validating Buttons in page");

				List<WebElement> radioButton = getElements(driver, locator);

				int buttons = radioButton.size();

				BaseSuite.reportLog("Expected Size of Buttons in page is " + count);
				BaseSuite.reportLog("Retrieved Size of Buttons in page is " + buttons);

				if (buttons == count) {
					BaseSuite.validationReportLog("Size of Buttons are matched");

				} else {
					BaseSuite.reportFailLog("Failed due to size of Buttons didn't matched in Page", "validateButtons");
				}
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}

	}

	public void validateTextFields(WebDriver driver, By locator, int count) {


		try {
			if (count!=0) {
				BaseSuite.reportLog("Validating Text Fields");

				List<WebElement> list = getElements(driver, locator);

				int inputFieldCount = list.size();

				BaseSuite.reportLog("Size of Text Fields is " + inputFieldCount);

				if (inputFieldCount == count) {
					BaseSuite.validationReportLog("Text Fields are Matched");

				} else {
					BaseSuite.reportFailLog("Failed due to some extra Text Fields in Page", "validateTextFields");
				}
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}

	}

	public void selectAllAndBackSpace(WebDriver driver, By locator) {
		try {

			WebElement ele = driver.findElement(locator);

			ele.sendKeys(Keys.chord(Keys.CONTROL, "a"));

			ele.sendKeys(Keys.BACK_SPACE);
		} catch (Exception e) {

			BaseSuite.log.error(e.getMessage());
		}

	}


	public void validateInputFields(WebDriver driver, By locator, int count) {

		try {
			if (count!=0) {
				BaseSuite.reportLog("Validating Input Fields");

				List<WebElement> list = getElements(driver, locator);

				int inputFieldCount = list.size();

				BaseSuite.reportLog("Size of Input Fields is " + inputFieldCount);

				if (inputFieldCount == count) {
					BaseSuite.validationReportLog("Input Fields are Matched");

				} else {
					BaseSuite.reportFailLog("Failed due to some extra Input Fields in Page", "validateInputFields");
				}
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}

	}

	public boolean specialCharaMandatoryField(WebDriver driver, By locator1, By locator2, String keysToSend,
			SoftAssert soft, String lable, String errorMess) {
		boolean status = false;

		try {
			displayAndSendkey(driver, locator1, keysToSend, "Clicked on " + lable, "Entering " + lable,
					lable + " added successfully");

			BaseSuite.reportLog("Entering the details::::  " + keysToSend);
			String systemGErrmsg = getText(driver, locator2).trim();

			BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + systemGErrmsg);
			BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

			if (!systemGErrmsg.isEmpty()) {
				soft.assertEquals(systemGErrmsg, errorMess);
				status = true;
				BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
			} else {
				BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "specialCharaMandatoryField");
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}
		return status;

	}

	public boolean otherMandatoryField(WebDriver driver, By locator1, By locator2, String keysToSend, SoftAssert soft,
			String lable, String errorMess) {
		boolean status = false;
		try {
			displayAndSendkey(driver, locator1, keysToSend, "Clicked on " + lable, "Adding " + lable,
					lable + " added successfully");

			BaseSuite.reportLog("Entering the details::::  " + keysToSend);
			String selectAll = Keys.chord(Keys.CONTROL, "a");
			sendKeys(driver, locator1, selectAll);
			moveToElementBackSpace(driver, locator1);

			String connectionNameErrmsg = getText(driver, locator2).trim();
			BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + connectionNameErrmsg);
			BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

			if (!connectionNameErrmsg.isEmpty()) {
				soft.assertEquals(connectionNameErrmsg, errorMess);
				status = true;
				BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
			} else {
				BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "mandatoryField");
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}
		return status;
	}

	public void displayAndSendkey(WebDriver driver, By locator, String keysToSend, String labelName1, String labelName2,
			String labelName3) {
		BaseSuite.reportLog(labelName1);
		click(driver, locator);
		BaseSuite.reportLog(labelName2);
		sendKeys(driver, locator, keysToSend);
		BaseSuite.reportLog(labelName3);
	}

	public List<String> getColumnNamesUsingSheet(String excelPath, String sheetName) {
		List<String> colNames = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(new File(excelPath));) {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet spreadsheet = workbook.getSheet(sheetName);

			int lastcell = spreadsheet.getRow(0).getLastCellNum();
			// Non empty Last cell Number or index return

			for (int i = 0; i <= lastcell; i++) {

				if (spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString() != null
						|| !(spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString().isEmpty()))
					colNames.add(spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString());

			}

		} catch (Exception e) {

			BaseSuite.log.error(e.getMessage());
		}

		return colNames;
	}

	public void continueNext(WebDriver driver, String methodName, By homeClickLocator, By discardPopUpLocator,
			ExtentTest test) {

		try {
			BaseClassUtil util = new BaseClassUtil();

			String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen
			// shot

			test.log(Status.FAIL, methodName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

			waitForElement(driver, homeClickLocator);

			displayAndClick(driver, homeClickLocator);

			if (isDisplayed(driver, discardPopUpLocator)) {

				displayAndClick(driver, discardPopUpLocator);// we have to click on yes button to discard changed if
				// this message appears

			}

		} catch (Exception e) {

			BaseSuite.log.error(e.getMessage());

		}

	}

	public boolean verifyRetrivedValues(WebDriver driver, By locator, String labelName, String attribute,
			String inputToCompare) {
		boolean status = false;
		try {
			BaseSuite.reportLog("retriving values for " + labelName);

			/**javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			//waitForElement(driver, locator);*/

			String retrivedValue = getAttribute(driver, locator, attribute);

			BaseSuite.validationReportLog("Retrived Message for " + labelName + isContentLog + retrivedValue);

			BaseSuite.validationReportLog("Expected Message for " + labelName + isContentLog + inputToCompare.trim());

			if (!retrivedValue.isEmpty()) {
				Assert.assertEquals(retrivedValue, inputToCompare);

				status = true;

				BaseSuite.validationReportLog(labelName +  " is matched & verified");

			} else {

				BaseSuite.reportFailLog(labelName + " is not matching", "verifyRetrivedValues");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, e.getMessage());
		}

		return status;
	}

	public boolean verifyRetrivedValues(WebDriver driver, By locator, String labelName, String inputToCompare) {
		boolean status = false;
		try {
			BaseSuite.reportLog("retriving values for " + labelName);

			isDisplayedInLoop(driver, 2, locator);
			if (isDisplayed(driver, locator)) {

				String retrivedValue = getText(driver, locator);

				BaseSuite.validationReportLog("Retrived Message for " + labelName + isContentLog + retrivedValue);
				BaseSuite.validationReportLog("Expected Message for " + labelName + isContentLog + inputToCompare.trim());

				if (!retrivedValue.isEmpty()) {
					Assert.assertEquals(retrivedValue, inputToCompare);
					status = true;
					BaseSuite.validationReportLog(labelName + " is matched & verified");

				} else {

					BaseSuite.reportFailLog(labelName + " is not matching", "verifyRetrivedValues");
				}
			} else {
				BaseSuite.reportFailLog(labelName + " is not visible ", "verifyRetrivedValues");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, e.getMessage());
		}

		return status;
	}

	public By returnTwoElements(String dynamiclocator, String stringToBeReplaced1, String dynamicValue1,
			String stringToBeReplaced2, String dynamicValue2) {
		By elem=null;
		try {
			String[] dynamiclocatorloca = dynamiclocator.split("~~");

			String locator = dynamiclocatorloca[1];

			locator = locator.replace(stringToBeReplaced1, dynamicValue1);

			elem = By.xpath(locator.replace(stringToBeReplaced2, dynamicValue2));

		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());

		}
		return elem;
	}

	public boolean clickOnButton(WebDriver driver, By locator, String labelName, boolean expected) {
		boolean success = true;
		String methodName = "clickOnButton";

		try {
			// Wait for the element to be visible
			isDisplayedInLoop(driver, 2, locator);

			// Verify visibility and clickable
			boolean isVisible = verifyVisibilityOfButtons(driver, locator, labelName, expected);
			boolean isClickable = isClickable(driver, locator, labelName, expected);

			if ((isVisible && isClickable) || expected) {
				BaseSuite.reportLog("Clicking on " + labelName + " button/link/field");
				displayAndClick(driver, locator);
				BaseSuite.validationReportLog(labelName + " button/link/field clicked successfully");
			} else {
				BaseSuite.reportFailLog(labelName + " button is disabled", methodName);
				success = false;
			}

		} catch (Exception e) {
			BaseSuite.log.error("Exception in " + methodName + ": " + e.getMessage());
			success = false;
		}

		return success;
	}

	// this method for comparing two strings with ignore case
	public boolean containsIgnoreCase(String str, String searchStr) {

		if (str == null || searchStr == null) {
			return false;
		}
		int len = searchStr.length();
		int max = str.length() - len;
		for (int i = 0; i <= max; i++) {
			if (str.regionMatches(true, i, searchStr, 0, len)) {
				return true;
			}
		}
		return false;
	}

	public static String base64Encoder(String filePath) {
		String base64File = "";
		File file = new File(filePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a file from file system
			byte[] fileData = new byte[(int) file.length()];
			imageInFile.read(fileData);
			base64File = Base64.getEncoder().encodeToString(fileData);
		} catch (FileNotFoundException e) {
			log.info("File not found" + e);
		} catch (IOException ioe) {
			log.info("Exception while reading the file " + ioe);
		}
		return base64File;
	}

	public static String capitalize(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	// this method only work for single column -
	public String changeColumnCaseToLower(String expression) {
		String input = null;

		try {
			Pattern p = Pattern.compile("\\[+[a-zA-Z_]+");

			Matcher m = p.matcher(expression);

			while (m.find()) {
				input = m.group();
			}
			if(input!=null) {
				input = expression.replaceAll("\\[+[a-zA-Z_]+", input.toLowerCase());
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, e.getMessage());

		}

		return input;

	}

	public void checkElement(WebDriver driver, By locator, String label, String message) {

		isDisplayedInLoop(driver, 0, locator);
		if (isDisplayed(driver, locator)) {

			BaseSuite.reportFailLog("Unexprected " + label + "found on page, kindly check :" + message, "checkElement");
			driver.navigate().refresh();
			BaseSuite.reportLog("Reloading application page...");
			throw new AssertionError();
		}
	}

	public boolean stringContainsOutput(String actualString, String expectedString, boolean shouldContain) {
		boolean flag = true;

		try {

			BaseSuite.reportLog("Expected : " + expectedString);
			BaseSuite.reportLog("Retrieved : " + actualString);

			expectedString = checkNullValue(expectedString).trim().toLowerCase();
			actualString = checkNullValue(actualString).trim().toLowerCase();

			if (!expectedString.isEmpty()) {

			//	waitForExecution(1000);
				boolean contains = actualString.contains(expectedString);

				if (shouldContain && contains) {
					BaseSuite.validationReportLog("Expected result matched as both are identical. " + ConstantProperty.SUCCESSSTRING);
				} else if (!shouldContain && !contains) {
					BaseSuite.validationReportLog("Expected result matched as both are not identical. " + ConstantProperty.SUCCESSSTRING);
				} else {
					String failMsg = shouldContain
							? "Expected result not matched as both are not identical."
									: "Expected result not matched as both are identical.";
					BaseSuite.reportFailLog(failMsg, "stringContainsOutput");
					flag = false;
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Exception in stringContainsOutput: " + e);
			flag = false;
		}

		return flag;
	}


	// common method to enter something in text box

	public boolean enterValueToTextField(WebDriver driver, By locator, String label, String inputValue) {
		String methodName = "enterValueToTextField";
		boolean state = true;

		try {
			waitForSpinnerToDisappear(driver);
			isDisplayedInLoop(driver, 1, locator);

			if (!isDisplayed(driver, locator)) {
				BaseSuite.reportFailLog(label + " is not displayed", methodName);
				return false;
			}

			BaseSuite.reportLog(label + " is visible ");

			if (!isEnabled(driver, locator)) {
				BaseSuite.reportFailLog(label + " is not enabled", methodName);
				return false;
			}

			BaseSuite.reportLog(label + " is enabled ");

			if (!isEditable(driver, locator, label)) {
				BaseSuite.reportFailLog(label + " is not editable", methodName);
				return false;
			}

			BaseSuite.reportLog(label + " is editable");

			inputValue = checkNullValue(inputValue);
			BaseSuite.reportLog("Entering " + label + ": " + inputValue);

			if (!inputValue.isEmpty()) {
				clear_Click_SendKeys(driver, 5, locator, inputValue);
			} else {
				// Clear and click in case of blank input
				click(driver, locator);
				waitForExecution(500);
				clear(driver, locator);
				sendKeys(driver, locator, "");
				waitForExecution(500);
				click(driver, locator);
				clear(driver, locator);
			}

			BaseSuite.validationReportLog("Entered " + label + ": " + inputValue);

		} catch (Exception e) {
			state = false;
			BaseSuite.reportErrorLog(e, errorState + label + " : " + e.getMessage());
		}

		return state;
	}

	public boolean captureToastMsgWithContains(WebDriver driver, By locator1, By locator2, String mess, String label) {
		String validMess;
		boolean flag = true;
		try {
			BaseSuite.reportLog(verifyingContent + label + " Message");

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(locator1)).perform();

			validMess = getText(driver, locator1).trim();

			if (validMess.isEmpty()) {
				validMess = getAttribute(driver, locator1, attributeTextContents);
			}

			actions.click(driver.findElement(locator2)).build().perform();

			BaseSuite.validationReportLog("Retrived Message for " + label + isContentLog + validMess);
			BaseSuite.validationReportLog("Expected Message for " + label + isContentLog + mess.trim());

			if (!validMess.isEmpty()) {

				if (validMess.trim().contains(mess.trim())) {

					BaseSuite.validationReportLog(label + " Message Successfully Matched");
				} else {
					BaseSuite.reportFailLog(label + msgDontMatched, "captureLoginMsg");
					flag = false;
				}

			} else {
				BaseSuite.reportFailLog(label + msgDontMatched, "captureLoginMsg");
				flag = false;
			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
			BaseSuite.reportFailLog(label + " Messages didn't found kindly check, captureToastMsg", "captureToastMsgWithContains");
			flag = false;
		}
		return flag;
	}

	/** Database connection code **/

	/**
	 * read data from database
	 **/

	public static Connection conn;
	public static Statement stmt;
	public static ResultSet resultSet;

	public static Connection setUpConnectionAndTest(String jdbcURL, String username, String password)
			throws SQLException, ClassNotFoundException {

		try {

			Class.forName("org.postgresql.Driver");

			DriverManager.registerDriver(new org.postgresql.Driver());

			conn = DriverManager.getConnection(jdbcURL, username, password);

			if (conn.isClosed()) {

				log.info("-------database is not connected");

			} else {

				log.info("--------database is connected ");

			}
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		}
		return conn;
	}

	public void getValuesFromDatabase(Connection conn, String query) {

		try {

			stmt = conn.createStatement();

			resultSet = stmt.executeQuery(query);

			log.info("key\tsummary\tscenario\tconnection type\tconnection name\tnectgenuserrole");

			while (resultSet.next()) {

				String key = resultSet.getString("key");
				String summary = resultSet.getString("summary");
				String scenario = resultSet.getString("scenario");
				String connectiontype = resultSet.getString("connection_type");
				String connectionname = resultSet.getString("connection_name");
				String nextgenuserrole = resultSet.getString("nextgen_user_role");

				String connectionjsons = resultSet.getString("connection_json");

				log.info(key + "\t" + summary + "\t" + scenario + "\t" + connectiontype + "\t"
						+ connectionname + "\t" + nextgenuserrole + "\t"+connectionjsons);

			}
		} catch (Exception e) {
			log.info("Exeception occured in db testing");
			e.printStackTrace();
		}

	}

	public ConnectionPoJO retrieveValuesFromDatabase(Connection conn, String query) {
		ConnectionPoJO connParam = new ConnectionPoJO();
		try {

			stmt = conn.createStatement();

			resultSet = stmt.executeQuery(query);

			while (resultSet.next()) {


				String key = resultSet.getString("id");

				String connectionname = resultSet.getString("connection_name");

				String connectiontype = resultSet.getString("connection_type");

				String connectortype = resultSet.getString("connector_type");
				String connectioninfo = resultSet.getString("connection_info");
				log.info(key + "\t" + connectiontype + "\t"
						+ connectionname + "\t" + connectortype );
				connParam.setConnectionJsonValue(connectioninfo);

			}
		} catch (Exception e) {
			log.info("Exeception occured in db testing");
			e.printStackTrace();
		}
		return connParam;

	}

	/**
	 * Retrieve connection json from database using testcase id and connector type
	 * 
	 * @throws SQLException
	 **/

	public String getConnectionJsonFromDataBaseForTestCase(String testcaseId, String moduleName) throws SQLException {

		String jsonEntity = null;
		String sqlQuery = null;
		try {

			conn = setUpConnectionAndTest(Constant.DATABASEURL, Constant.DATABASEUSERNAME, Constant.DATABASEPASSWORD);

			stmt = conn.createStatement();

			switch (moduleName.toLowerCase()) {

			case "connections":

				sqlQuery = "SELECT *  FROM connections.ice_connections where testcaseid like \'%" + testcaseId + "%\'";

				break;

			case "data testing":

				sqlQuery = "SELECT *  FROM connections.ice_rules where testcaseid like \'%" + testcaseId + "%\'";

				break;

			default:
				BaseSuite.reportErrorLog("Connector type not found kindly check , Connector :: " + moduleName);
				break;
			}

			if (sqlQuery != null) {
				resultSet = stmt.executeQuery(sqlQuery);

				while (resultSet.next()) {

					String iptype = getConnectionHostType(prop.getProperty("Connections.host.type"));

					if (!iptype.trim().equalsIgnoreCase("staticip")) {

						jsonEntity = resultSet.getString("connection_info");// this will be execute for api.net and EC2
						// instance but use Ec2 url here
					} else {
						jsonEntity = resultSet.getString("onprem_connectioninfo");// this will be execute for onprem and
						// Dev2 instance no need to add url
					}

				}
				if (jsonEntity != null) {
					log.info("Json value found :: " + jsonEntity);

				} else {

					BaseSuite.reportErrorLog("Connection name not found kindly check");
				}
			}


		}catch(Exception e ) {
			BaseSuite.reportErrorLog(e,"Error occurs while retriving data from database kindly check , "+e.getMessage());
		}finally {

			conn.close();
		}

		return jsonEntity;
	}

	// SELECT connection_info FROM connections.ice_connections where testcaseid
	// In(select testCaseId from connections.postgresql_tc pt where testcaseid like
	// '%NRR-10713%')

	/** Database connection code **/

	public void displayAndClearInputField(WebDriver driver, int count, By locator) {

		isDisplayedInLoop(driver, count, locator);

		try {
			if (isDisplayed(driver, locator)) {

				click(driver, locator);

				driver.findElement(locator).sendKeys(Keys.CONTROL + "a");

				waitForExecution(500);

				driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
			} else {
				log.info(locator + " :: Locator not visible");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs kindly check displayAndClearInputField");
			Thread.currentThread().interrupt();
		}

	}


	/**
	 * By connPaginationMsg = getElementLocator(prop.getProperty("Connection.PaginationMsg"));
	By connPaginationBar = getElementLocator(prop.getProperty("Connection.PaginationBar"));
	By pageArrows = getElementLocator(prop.getProperty("Connection.PageArrow"));
	// method to validate pagination arrows and return page and record details
	public List<String> getPaginationDetails(WebDriver driver) {

		String pageinfo = null;
		String totalRecords = null;
		String currentpage = null;
		int totalpage;
		List<WebElement> arrows = null;
		try {
			isDisplayedInLoop(driver, 2, connPaginationMsg);

			pageinfo = getAttribute(driver, connPaginationMsg, "innerText");

			BaseSuite.reportLog("Page details displayed :: " + pageinfo);

			totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

			BaseSuite.reportLog("Total page available are :: " + totalpage);

			totalRecords = pageinfo.split(" ")[4].replace("(", "");

			BaseSuite.reportLog("Total Records available are :: " + totalRecords);

			currentpage = pageinfo.split(" ")[0];

			BaseSuite.reportLog("Current page number is :: " + currentpage);

			arrows = getElements(driver, pageArrows);

			for (int j = 0; j < arrows.size(); j++) {

				String arrow = arrows.get(j).getAttribute("title").replaceAll("Go to", "");

				BaseSuite.reportLog("Checking page arrow :: " + arrow);

				String status = arrows.get(j).getAttribute(attributeClassx);

				if (status.contains("disable")) {
					BaseSuite.validationReportLog("Page arrow :: " + arrow + " is disabled");
				} else {
					BaseSuite.validationReportLog("Page arrow :: " + arrow + " is enabled");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while getPaginationDetails kindly check , " + e.getMessage());
		}
		return Arrays.asList(pageinfo, totalRecords, currentpage);
	}
	 */
	public void sendkeysToField(WebDriver driver, By locator, String label, String input) {

		try {
			isDisplayedInLoop(driver, 2, locator);

			if (isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog(label + " field is visible");

				driver.findElement(locator).click();

				driver.findElement(locator).clear();

				BaseSuite.reportLog("Entering : " + input);

				sendKeys(driver, locator, "emp");

				selectAllAndBackSpace(driver, locator);

				sendKeys(driver, locator, input);

				BaseSuite.validationReportLog("Entered : " + input);

			} else {
				BaseSuite.reportFailLog(label + " field is not visible", "sendkeysToField");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while sendkeysToField kindly check ");
		}finally {

			isNotDisplayed(driver, getElementLocator(prop.getProperty(spinnerProp)), 60);
		}
	}

	public void clickOnFieldOrButton(WebDriver driver, By locator, String label) {

		try {
			isDisplayedInLoop(driver, 2, locator);
			if (isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog(label + " is visible.");

				driver.findElement(locator).click();

				BaseSuite.reportLog("Clicked on " + label);

			}else {
				BaseSuite.reportFailLog(label+" is not visible.", "clickOnFieldOrButton");

			}
		} catch (Exception e) {
			BaseSuite
			.reportErrorLog(e,"Error occurs while clickOnFieldOrButton kindly check , " + e.getMessage() + locator);
		}
	}

	public static void waitForExecution(int waitTime) {
		long endTime = System.currentTimeMillis() + (waitTime);
		while (System.currentTimeMillis() < endTime) {
			/**log.info("latency ignore wait");*/
		}
	}

	public boolean validateIsDisplayedOrNot(WebDriver driver, By locator, String label, boolean expected) {

		boolean flag=true;
		try {
			isDisplayedInLoop(driver, 0, locator);

			if(isDisplayed(driver, locator) && expected) {

				BaseSuite.validationReportLog(label+" is visible");

			}
			else if(!isDisplayed(driver, locator) && !expected){

				BaseSuite.validationReportLog(label+" is not visible");
			}
			else{
				BaseSuite.reportFailLog(label+" is not visible kindly check "+locator,"validateIsDisplayedOrNot");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while validateIsDisplayedOrNot kindly check , "+e.getMessage()+locator);
			flag=false;
		}

		return flag;

	}

	// method to validate pagination arrows and return page and record details
	public List<String> getPaginationDetails1(WebDriver driver, By locator1, By locator2, By locator3, String label) {

		String pageinfo = null;
		String totalRecords = null;
		String currentpage = null;
		int totalpage = 0;

		try {
			BaseSuite.reportLog("Verifying pagination of " + label);

			isDisplayedInLoop(driver, 2, locator1);

			if (isDisplayed(driver, locator1)) {
				pageinfo = getAttribute(driver, locator1, "innerText");
				BaseSuite.reportLog("Page details displayed :: " + pageinfo);

				totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

				BaseSuite.reportLog("Total page available are :: " + totalpage);

				totalRecords = pageinfo.split(" ")[4].replace("(", "");

				if(totalRecords.contains(",")) {
					totalRecords=totalRecords.replace(",", "");
				}

				BaseSuite.reportLog("Total Records available are :: " + totalRecords);

				currentpage = pageinfo.split(" ")[0];

				BaseSuite.reportLog("Current page number is :: " + currentpage);

				if (Integer.parseInt(totalRecords.trim()) == 0) {

					BaseSuite.reportLog("Verifying no records to display text for zero records");

					validateIsDisplayedOrNot(driver, locator3, noRecordsToDisplayContent, true);
				}
			} else {
				BaseSuite.reportFailLog("Not visible " + locator1, "getPaginationDetails1");
			}

			if (isDisplayed(driver, locator2)) {

				List<WebElement> arrows = getElements(driver, locator2);
				for (int j = 0; j < arrows.size(); j++) {

					String arrow = arrows.get(j).getAttribute("title").replaceAll("Go to", "");

					BaseSuite.reportLog("Checking page arrow :: " + arrow);

					String status = arrows.get(j).getAttribute(attributeClassx);

					if (status.contains("disable")) {
						BaseSuite.validationReportLog("Page arrow :: " + arrow + " is disabled");
					} else {
						BaseSuite.validationReportLog("Page arrow :: " + arrow + " is enabled");
					}
				}
			} else {
				BaseSuite.reportFailLog("Not visible " + locator2, "getPaginationDetails1");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occur while getPaginationDetails1" + e.getMessage());
		}
		String tp = Integer.toString(totalpage);
		return Arrays.asList(pageinfo, totalRecords, currentpage, tp);
	}

	public List<String> getPaginationDetails(WebDriver driver, By paginationInfoLocator, By arrowsLocator, By noRecordsLocator, String label) {
		String pageInfo = "";
		String totalRecords = "0";
		String currentPage = "0";
		int totalPages = 0;

		try {
			BaseSuite.reportLog("Verifying pagination of " + label);

			isDisplayedInLoop(driver, 2, paginationInfoLocator);

			if (!isDisplayed(driver, paginationInfoLocator)) {
				BaseSuite.reportFailLog("Pagination info not visible: " + paginationInfoLocator, "getPaginationDetails");
				return Arrays.asList(pageInfo, totalRecords, currentPage, String.valueOf(totalPages));
			}

			pageInfo = getAttribute(driver, paginationInfoLocator, "innerText");
			BaseSuite.reportLog("Page details displayed :: " + pageInfo);

			String[] parts = pageInfo.split(" ");
			if (parts.length < 5) {
				BaseSuite.reportFailLog("Unexpected pagination info format: " + pageInfo, "getPaginationDetails");
				return Arrays.asList(pageInfo, totalRecords, currentPage, String.valueOf(totalPages));
			}

			currentPage = parts[0];
			totalPages = Integer.parseInt(parts[2]);
			totalRecords = parts[4].replace("(", "").replace(",", "").trim();
			int recordCount = Integer.parseInt(totalRecords);

			BaseSuite.reportLog("Current page number is :: " + currentPage);
			BaseSuite.reportLog("Total pages available :: " + totalPages);
			BaseSuite.reportLog("Total records available :: " + totalRecords);

			if (recordCount == 0) {
				BaseSuite.reportLog("Verifying 'No records to display' text for zero records.");
				validateIsDisplayedOrNot(driver, noRecordsLocator, noRecordsToDisplayContent, true);
				validateArrowStates(driver, arrowsLocator, true);
			} else if (recordCount <= 20) {
				BaseSuite.reportLog("Verifying 'No records to display' text is not shown.");
				validateIsDisplayedOrNot(driver, noRecordsLocator, noRecordsToDisplayContent, false);
				validateArrowStates(driver, arrowsLocator, true);
			} else {
				validateArrowStates(driver, arrowsLocator, false);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error in getPaginationDetails: " + e.getMessage());
		}

		return Arrays.asList(pageInfo, totalRecords, currentPage, String.valueOf(totalPages));
	}

	private void validateArrowStates(WebDriver driver, By arrowsLocator, boolean shouldBeDisabled) {
		if (!isDisplayed(driver, arrowsLocator)) {
			BaseSuite.reportFailLog("Pagination arrows not visible: " + arrowsLocator, "validateArrowStates");
			return;
		}

		List<WebElement> arrows = getElements(driver, arrowsLocator);
		for (WebElement arrow : arrows) {
			String arrowName = arrow.getAttribute("title").replace("Go to", "").trim();
			String arrowClass = arrow.getAttribute(attributeClassx);
			boolean isDisabled = arrowClass.contains("disable");

			if (shouldBeDisabled) {
				if (isDisabled) {
					BaseSuite.validationReportLog(String.format("Page arrow '%s' is correctly disabled.", arrowName));
				} else {
					BaseSuite.reportFailLog(String.format("Page arrow '%s' should be disabled!", arrowName), "validateArrowStates");
				}
			} else {
				BaseSuite.validationReportLog(String.format("Page arrow '%s' is %s.", arrowName, isDisabled ? disableContentx : enableContentx));
			}
		}
	}

/**
	public static String getMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace.length >= 3) {
			// The method name is in stackTrace[2]
			return stackTrace[2].getMethodName();
		}
		return "UnknownMethod";
	}
*/
	public boolean stringOutput(String actualString, String expectedString, boolean result) {

		boolean flag = true;

		try {
			BaseSuite.reportLog("Expected : " + expectedString);
			BaseSuite.reportLog("Retrived : " + actualString);
			if (result) {

				if (actualString.trim().equalsIgnoreCase(expectedString.trim())) {

					BaseSuite.validationReportLog("Expected result matched " + ConstantProperty.SUCCESSSTRING + "");

				} else {
					BaseSuite.reportFailLog("Expected result not matched", "stringOutput");
					flag = false;
				}
			} else {

				if (!actualString.trim().equalsIgnoreCase(expectedString.trim())) {
					BaseSuite.validationReportLog("Expected result matched " + ConstantProperty.SUCCESSSTRING + "");
				} else {
					BaseSuite.reportFailLog("Expected result not matched", "stringOutput");
					flag = false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean isNotDisplayed(WebDriver driver, By locator, int waitTime) {
		boolean flag = false;
		long endTime = 0;
		try {
			endTime = System.currentTimeMillis() + (waitTime * 1000);

			while (System.currentTimeMillis() < endTime) {
				waitForExecution(200);
				if (!driver.findElement(locator).isDisplayed()) {
					flag = true;
					break;
				}
			}

			if(System.currentTimeMillis() > endTime && driver.findElement(locator).isDisplayed()) {
				BaseSuite.reportFailLog("Unexpected webelement still visible on page kindly check"+locator, "isNotDisplayed");
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return flag;
	}

	public boolean isDisplayed(WebDriver driver, By locator, int waitTime) {
		boolean flag = false;
		try {
			waitForSpinnerToDisappear(driver);

			long endTime = System.currentTimeMillis() + (waitTime * 100);

			while (System.currentTimeMillis() < endTime) {

				if (driver.findElement(locator).isDisplayed()) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return flag;
	}

	public boolean waitTillDisplayed(WebDriver driver, By locator, int waitTime) {

		boolean flag=false;

		try {

			for(int i=0;i<waitTime;i++) {

				if (!driver.findElement(locator).isDisplayed()) {
					flag = true;
					break;
				}
			}

		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return flag;

	}

	// Fetch value from a web element using "value" or fallback to "textContent"
	public String getValue(WebDriver driver, By locator, String label) {

		BaseSuite.reportLog("Getting value of "+label);

		isDisplayedInLoop(driver, 2, locator);

		String value = null;

		try {
			value = getAttribute(driver, locator, valueContent);

			// If empty or null, try fallback
			if (value == null || value.trim().isEmpty()) {
				value = getAttribute(driver, locator, attributeTextContents);
			}

		} catch (Exception e) {
			// Fallback if exception occurs
			value = getAttribute(driver, locator, attributeTextContents);
		}

		return (value != null) ? value.trim() : "";
	}

	// check expected and actual values
	public String getValue(WebDriver driver, By locator) {

		isDisplayedInLoop(driver, 2, locator);

		String ac = "";
		try {

			ac = getText(driver, locator);

			if(ac == null || ac.isEmpty()) {
				ac = getAttribute(driver, locator, valueContent);
			}

		} catch (Exception e) {

			ac = getAttribute(driver, locator, attributeTextContents);

		} finally {
			if (ac == null || ac.isEmpty()) {
				ac = getAttribute(driver, locator, attributeTextContents);
			}
		}

		return ac.trim();
	}

	public boolean checkCssOfTextField(WebDriver driver, By locator, String label, String scenario, String cssAttr) {
	    boolean flag = true;

	    isDisplayedInLoop(driver, 0, locator);

	    if (!isDisplayed(driver, locator)) {
	        BaseSuite.reportLog(label + " is not displayed, skipping CSS check.");
	        return false;
	    }

	    BaseSuite.reportLog("Checking state of " + label);

	    String cssValue = driver.findElement(locator).getCssValue(cssAttr);
	    String hexColor = Color.fromString(cssValue).asHex().toLowerCase();

	    boolean isRed = isHexRedColor(hexColor);
	    String normalizedScenario = scenario.trim().toLowerCase();

	    switch (normalizedScenario) {
	        case "valid":
	            if (isRed) {
	                BaseSuite.reportFailLog(
	                    label + " is incorrectly highlighted in RED for a valid value. Actual color: " + hexColor,
	                    "checkCssOfTextField");
	                flag = false;
	            } else {
	                BaseSuite.validationReportLog(label + " is correctly not highlighted in RED for valid value.");
	            }
	            break;

	        case "invalid":
	            if (isRed) {
	                BaseSuite.validationReportLog(label + " is correctly highlighted in RED for invalid value.");
	            } else {
	                BaseSuite.reportFailLog(
	                    label + " is not highlighted in RED for invalid value. Actual color: " + hexColor,
	                    "checkCssOfTextField");
	                flag = false;
	            }
	            break;

	        default:
	            BaseSuite.reportLog("Unknown scenario: " + scenario + ". No validation applied.");
	            break;
	    }

	    return flag;
	}

	// Reusable method for identifying "red" color codes
	private boolean isHexRedColor(String hexColor) {
	    return "#ff0000".equals(hexColor) || "#a80000".equals(hexColor);
	}

	public void getTableForTestScenario(WebDriver driver, List<String> scenarioList) {
	    if (scenarioList == null || scenarioList.isEmpty()) {
	        log.warn("No test scenarios provided for table log.");
	        return;
	    }

	    try {
	        log.info("Driver session: " + driver);

	        String[][] table = new String[scenarioList.size() + 1][3];
	        
	        table[0] = new String[] { "No.", "Test Scenario Name", "Execution Status" };

	        for (int i = 0; i < scenarioList.size(); i++) {
	        	
	            String row = scenarioList.get(i);
	            String[] parts = row.split(",", 2); 

	            String scenarioName = parts.length > 0 ? parts[0].trim() : "Unknown Scenario";
	            String status = parts.length > 1 ? parts[1].trim() : "Unknown Status";

	            table[i + 1] = new String[] { String.valueOf(i + 1), scenarioName, status };
	        }

	        String htmlTable = createHtmlTable1(table, "Test Scenarios");
	        BaseSuite.reportLog(htmlTable);

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(e, "Error observed in getTableForTestScenario: " + e.getMessage());
	    }
	}


	public String getWorkflowCommonFolderName() {
	    String columnName = valueContent; // default
	    XLUtils xl = new XLUtils();
	    String propertyKey = "wkflConfigColumn";
	    String folderName = "";

	    try {
	        String sysPropValue = System.getProperty(propertyKey);

	        if (sysPropValue != null && !sysPropValue.trim().isEmpty()) {
	            columnName = sysPropValue.trim();
	        }

	        folderName = xl.readUsingColNameAndCellContains(DIR_PATH + Constant.NEXTGEN_WORKFLOW_TESTDATA_EXCEL_PATH,"config", "key", "RuleFolder", columnName);

	        if (folderName == null || folderName.trim().isEmpty()) {
	        	String message = "Workflow Common folder name not found — please check test data.";
	            BaseSuite.reportErrorLog(message);
	            log.error("----------- " + message + " -----------");
	        } else {
	            log.info("----------- Workflows Common folder name :: " + folderName + " -----------");
	        }
	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(e, "Workflow folder name not found — check test data file or structure.");
	    }

	    return folderName;
	}


	public boolean getCSSColorOfElement(WebDriver driver, By locator, String label, String cssAttribute, String expectedColor) {
	    boolean result = false;
	    try {
	        BaseSuite.reportLog("Checking CSS Background Color of " + label);

	        isDisplayedInLoop(driver, 2, locator);

	        if (isDisplayed(driver, locator)) {
	            String cssValue = driver.findElement(locator).getCssValue(cssAttribute);
	            if (cssValue == null || cssValue.isEmpty()) {
	                BaseSuite.reportLog("CSS attribute '" + cssAttribute + "' is empty for " + label);
	                return false;
	            }

	            String hexColor = Color.fromString(cssValue).asHex().toLowerCase();

	            // Basic colors hex mapping
	            Map<String, String> hexToColorName = Map.ofEntries(
	                Map.entry("#000000", "Black"),
	                Map.entry("#ffffff", "White"),
	                Map.entry("#ff0000", "Red"),
	                Map.entry("#a80000", "Red"),
	                Map.entry("#00ff00", "Lime"),
	                Map.entry("#008000", "Green"),
	                Map.entry("#0000ff", "Blue"),
	                Map.entry("#3c4fff", "Blue"),
	                Map.entry("#0078d4", "Blue"),
	                Map.entry("#ffff00", "Yellow"),
	                Map.entry("#ffa500", "Orange"),
	                Map.entry("#800080", "Purple"),
	                Map.entry("#808080", "Gray"),
	                Map.entry("#c0c0c0", "Silver"),
	                Map.entry("#ffc0cb", "Pink"),
	                Map.entry("#00ffff", "Cyan"),
	                Map.entry("#000080", "Navy")
	            );

	            String actualColorName = hexToColorName.getOrDefault(hexColor, "Unknown");

	            BaseSuite.reportLog(label + " CSS color resolved as: " + actualColorName);

	            result = stringContainsOutput(actualColorName, expectedColor, true);
	        }
	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(e, "Error observed while getCSSColorOfElement: " + e.getMessage());
	    }

	    return result;
	}


	public static String getExecutionMessage() {
		return getValue("executionMessage", "execution.message", "");
	}

	public static String getSuiteName() {
		String suiteName = System.getProperty("testSuiteName");
		return (suiteName != null && !suiteName.trim().isEmpty()) ? "-" + suiteName.trim() : "";
	}

	public static String getConnectionInfo() {
		return getValue("wkflConfigColumn", null, "");
	}

	// Reusable method
	private static String getValue(String sysPropKey, String propKey, String defaultVal) {
		String sysVal = System.getProperty(sysPropKey);
		if (sysVal != null && !sysVal.trim().isEmpty()) {
			return sysVal.trim();
		}

		if (propKey != null) {
			String propVal = prop.getProperty(propKey);
			if (propVal != null && !propVal.trim().isEmpty()) {
				return propVal.trim();
			}
		}

		return defaultVal;
	}

	public static String getWorkspaceName(String workspaceName, boolean flag) {
		double releaseNum = 6.2; // This should ideally be passed as parameter or a constant.
		String wkscProperty = System.getProperty("WkscName");
		String str;

		// Safely determine the base workspace name
		if (wkscProperty != null && !wkscProperty.trim().isEmpty()) {
			str = wkscProperty.trim();
		} else if (workspaceName != null && !workspaceName.trim().isEmpty()) {
			str = workspaceName.trim();
		} else {
			str = prop.getProperty("workspace.name.constant", "Default_Workspace");
		}

		// Append account name only if releaseNum is not exactly 6.2 and flag is true
		if (releaseNum > 5 && flag && releaseNum != 6.2) {
			String acc = getAccountName("");
			str = str + " [" + acc + "]";
		}

		return str;
	}


	// Generic method to get system property, fallback to method arg, then to properties file
	private static String getEnvValue(String sysPropKey, String methodArg, String propKey, String defaultValue) {
		String value = System.getProperty(sysPropKey);
		if (value != null && !value.trim().isEmpty()) {
			return value.trim();
		} else if (methodArg != null && !methodArg.trim().isEmpty()) {
			return methodArg.trim();
		} else if (prop != null) {
			return prop.getProperty(propKey, defaultValue);
		} else {
			return defaultValue;
		}
	}

	public static String getUrl(String url) {
		return getEnvValue("appURL", url, "application.url.constant", "https://192.168.100.35:32222/");
	}

	public static String getBrowser(String browser) {
		return getEnvValue("browser1", browser, "browser.name.constant", "chrome");
	}

	public static String getOrgId(String orgid) {
		return getEnvValue("orgid", orgid, "application.orgid.constant", "icedq.qa");
	}

	public static String getAccountId(String accountId) {
		return getEnvValue("accountId", accountId, "account.id.constant", Constant.accountId);
	}

	public static String getAccountName(String accountName) {
		return getEnvValue("accountName", accountName, "account.name.constant", "Quality_Assurance");
	}

	public static String getAccountDescription() {

		return prop.getProperty("account.description.constant", "QA_Team");
	}

	public boolean validateElement(WebDriver driver, By locator, String label, String type) {
		boolean flag=false;
		try {waitForSpinnerToDisappear(driver);
			isDisplayedInLoop(driver, 1, locator);
			BaseSuite.reportLog("  Verifying "+label+" "+type);
			if(isDisplayed(driver, locator)) {

				flag = true;

				/**	javascript(driver, prop.getProperty(scrollProp), locator);*/

				BaseSuite.validationReportLog(label+" "+type+" "+" is visible ");

			}else {
				BaseSuite.reportFailLog(label+" "+type+" "+" not visible", "validateElement");
				log.info(label+" "+type+" "+" not visible kindly check :: "+locator);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"error occurs while validateElement :: "+e.getMessage());
		}
		return flag;
	}

	public boolean isDisabledOrNot(WebDriver driver, By locator, String label, String type) {
		boolean flag=false;
		isDisplayedInLoop(driver, 2, locator);
		BaseSuite.reportLog(" Verifying "+label+" "+type +" is disabled or not");
		if(isDisplayed(driver, locator)) {

			String str= getAttribute(driver, locator, attributeClassx);

			if(str.contains(disableContentx)) {
				BaseSuite.validationReportLog(label+" "+type +" is disabled");
			}else {
				BaseSuite.reportFailLog(label+" "+type +" is enabled", "isDisabledOrNot");
			}

		}else {
			BaseSuite.reportFailLog(label+" "+type+" "+" not visible", "isDisabledOrNot");
			log.info(label+" "+type+" "+" not visible kindly check :: "+locator);
		}
		return flag;
	}

	public boolean verifySearchField(WebDriver driver,By locator, String label, String placeHolder) {
		boolean flag =true;
		try {
			BaseSuite.reportLog(" Verifying  "+label+" ");
			waitForSpinnerToDisappear(driver);
			isDisplayedInLoop(driver, 1, locator);
			if(isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog(label+" is visible ");

				isClickable(driver, locator, label, true);

				String acph = getAttribute(driver, locator, "placeholder");

				BaseSuite.reportLog(" Verifying "+label+" placeholder");

				flag=stringContainsOutput(acph, placeHolder, true);

			}else {
				BaseSuite.reportFailLog(label+" field not visible ", "verifySearchField");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"error occurs while verifySearchField :: "+e.getMessage());
		}
		return flag;
	}

	public boolean enterValueToField(WebDriver driver, boolean flag, By searchBar, By searchButton, String searchLabel, String searchValue) {
		Actions actions = new Actions(driver);

		try {
			if (!flag) return false;

			boolean isValueEmpty = searchValue == null || searchValue.trim().isEmpty();

			BaseSuite.reportLog("Entering value for: " + searchLabel + " | Value: " + (isValueEmpty ? "<empty>" : searchValue));

			waitForSpinnerToDisappear(driver);

			focusAndClearSearchBar(driver, searchBar);

			if (!isValueEmpty) {
				sendKeys(driver, searchBar, searchValue);
			} else {
				clear_Click_SendKeys(driver, 0, searchBar, searchValue);
			}

			waitForSpinnerToDisappear(driver);

			if (isDisplayed(driver, searchButton, 1)) {
				BaseSuite.reportLog("Clicking on " + searchLabel + " button.");
				actions.click(driver.findElement(searchButton)).build().perform();
				BaseSuite.validationReportLog("Clicked on " + searchLabel + " button successfully.");
			} else {
				BaseSuite.reportFailLog(searchLabel + " button not visible.", "enterValueToField");
				return false;
			}

			waitForSpinnerToDisappear(driver);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error in enterValueToField :: " + e.getMessage());
			return false;
		}

		return true;
	}

	private void focusAndClearSearchBar(WebDriver driver, By searchBar) {
		isDisplayedInLoop(driver, 0, searchBar);
		displayAndClick(driver, searchBar);
		sendKeys(driver, searchBar, "emp");
		selectAllAndBackSpace(driver, searchBar);
	}

	private void waitForSpinnerToDisappear(WebDriver driver) {

		By spinner = getElementLocator(prop.getProperty(spinnerProp));

		isNotDisplayed(driver, spinner, Constant.ruleWait);

	}


	public void verifyPlaceHolderValue(WebDriver driver,By fieldLocator ,String label, String placeHolder) {

		if(!placeHolder.isEmpty()) {

			/**	javascript(driver, prop.getProperty(scrollProp), fieldLocator);*/

			BaseSuite.reportLog("----- Verifying placeholder of "+label);

			String ph = getAttribute(driver, fieldLocator, "placeholder");

			BaseSuite.reportLog("Expected placeholder : "+placeHolder);

			BaseSuite.reportLog("Retrived placeholder : "+ph);

			if (!ph.isEmpty() && ph.trim().equalsIgnoreCase(placeHolder)) {

				BaseSuite.validationReportLog(label+" placeholder value matched");

			} else {

				BaseSuite.reportFailLog(label+" field place holder not found : Actual :"+ph+" and Expected : "+placeHolder,
						" verifyPlaceHolderValue");
			}
		}
	}

	public void verifyDefaultValue(WebDriver driver,By fieldLocator ,String label, String defaultValue, String attribute) {

		try {

			if(!defaultValue.isEmpty()) {

				/**	javascript(driver, prop.getProperty(scrollProp), fieldLocator);*/

				BaseSuite.reportLog("Verifying default value of "+label);

				String ph = getAttribute(driver, fieldLocator, attribute);

				BaseSuite.reportLog("Expected Default value : "+defaultValue);

				BaseSuite.reportLog("Retrived Default value : "+ph);

				if (!ph.isEmpty() && ph.equalsIgnoreCase(defaultValue)) {

					BaseSuite.validationReportLog(label+" Default value matched");

				} else {

					BaseSuite.reportFailLog(label+" field default value not found ","verifyDefaultValue");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Observed error for : verifyDefaultValue : "+e.getMessage());
		}
	}

	public boolean validateField(WebDriver driver,By locator, String fieldName, String placeholder, String fieldType, String defaultValue, String attribute, boolean isenable) {

		boolean state =true;
		String methodName="validateField";

		try {waitForSpinnerToDisappear(driver);
			isDisplayedInLoop(driver, 1, locator);

			BaseSuite.reportLog("--------------- Verifying "+fieldName+" "+fieldType+"  --------------- ");

			if(isDisplayed(driver, locator)) {

				/**	javascript(driver, prop.getProperty(scrollProp), locator);*/

				BaseSuite.validationReportLog(fieldName+" "+fieldType+" is visible");

				verifyPlaceHolderValue(driver, locator, fieldName, placeholder);

				verifyDefaultValue(driver, locator, fieldName, defaultValue, attribute);

				checkFieldEnabledOrNot(driver, locator, fieldName, isenable);

			}else {
				state=false;
				BaseSuite.reportFailLog(fieldName+" "+fieldType+" is not displayed", methodName);

			}
		} catch (Exception e) {
			state=false;
			BaseSuite.reportErrorLog(e,errorState+fieldName+" "+fieldType+" : "+e.getMessage());

		}
		return state;

	}

	public static String checkNullValue(String input) {

		if(input==null) {
			input="";
		}
		return input;
	}

	public boolean validateElementVisibility(WebDriver driver, By locator, String label, String type, boolean state) {
		boolean flag=false;
		try {waitForSpinnerToDisappear(driver);
			isDisplayedInLoop(driver, 1, locator);
			BaseSuite.reportLog(verifyingContent+label+" "+type);
			if(state) {
				if(isDisplayed(driver, locator)) {

					flag = true;

					BaseSuite.validationReportLog(label+" "+type+" "+" is visible");

				}else {
					BaseSuite.reportFailLog(label+" "+type+" "+" not visible", "validateElementVisibility");
					log.info(label+" "+type+" "+" not visible kindly check :: "+locator);
				}
			}else {

				if(!isDisplayed(driver, locator)) {

					flag = true;

					BaseSuite.validationReportLog(label+" "+type+" "+" is not visible");

				}else {
					BaseSuite.reportFailLog(label+" "+type+" "+" visible", "validateElementVisibility");
					log.info(label+" "+type+" "+" visible kindly check :: "+locator);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Observed error for : validateElementVisibility : "+e.getMessage());
		}
		return flag;
	}

	public void validateMessage(String valMsg, String expected, String label ) {
		if(valMsg.trim().contains(expected)) {

			BaseSuite.validationReportLog("Proper Validation message applied on "+label+" field ");

		}else {
			BaseSuite.reportFailLog("Validation message not matched for "+label+" field  ", "validateMessage");
		}
	}

	public String validationMessageOfField(WebDriver driver, By locator,String label, String expected, boolean state) {

		String valMsg = null;waitForSpinnerToDisappear(driver);
		isDisplayedInLoop(driver, 1, locator);

		try {
			if(!expected.isEmpty() && state && isDisplayed(driver, locator)) {
				/**
				//click(driver, locator);
				javascript(driver,  prop.getProperty(scrollProp), locator);
				/**waitForExecution(1000);
				 */

				valMsg = getText(driver, locator);

				if(!valMsg.isEmpty()) {

					BaseSuite.reportLog("Expected Value:- "+expected);

					BaseSuite.reportLog("Actual Value:- "+valMsg);

					validateMessage(valMsg, expected, label);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Observed error while validationMessageOfField for locator : "+locator+" and error : "+e.getMessage());
		}

		return valMsg;
	}

	public boolean validatAndeEnterValueToTextField(WebDriver driver,By labelLocator, By fieldLocator,By fieldValidLocator, String label, String placeHolder, String input, String fieldValidation) throws NoSuchElementException {
		boolean flag =true;
		try {
			isDisplayedInLoop(driver, 1, labelLocator);

			javascript(driver, prop.getProperty(scrollProp), labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator,label, true);

				verifyPlaceHolderValue(driver, fieldLocator, label, placeHolder);

				input=checkNullValue(input);

				if(!input.isEmpty()) {	

					click(driver, fieldLocator);

					sendKeys(driver, fieldLocator, "emp");

					/**clear(driver, fieldLocator);*/
					selectAllAndBackSpace(driver, fieldLocator);

					validationMessageOfField(driver, fieldValidLocator, label, fieldValidation, true);

					BaseSuite.reportLog("Entering value : " + input);

					sendKeys(driver, fieldLocator, input);

					if(isDisplayed(driver, fieldLocator)) {

						String ac = getAttribute(driver, fieldLocator, valueContent);

						flag = stringContainsOutput(ac, input, true);

						validationMessageOfField(driver, fieldValidLocator, label, fieldValidation, false);

					}
				}else {
					BaseSuite.reportLog(label+" Input value is empty");
				}
			} else {
				flag=false;
				BaseSuite.reportFailLog(label+" field not displayed", "validatAndeEnterValueToTextField");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,"Observed error for :  validatAndeEnterValueToTextField : " + e.getMessage());
			flag=false;
		}

		return flag;
	}

	public boolean searchFunctionalityMethod(WebDriver driver,boolean flag, By searchbar, By searchButton,String searchLabel, String placeholder, String searchValue ) {
		String methodName = "searchFunctionalityMethod";

		try {
			if(!flag) { return true; }

			waitForSpinnerToDisappear(driver);

			isDisplayedInLoop(driver, 0, searchbar);

			if(isDisplayed(driver, searchbar)) {

				flag=isClickable(driver, searchbar,"Search box", flag);

				if(flag) {

					flag=verifySearchField(driver,searchbar, searchLabel, placeholder);

					flag=enterValueToField(driver,flag, searchbar, searchButton, searchLabel, searchValue);

				}else {
					BaseSuite.reportFailLog(searchLabel+" field not clickable ", methodName);
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog(searchLabel+" box not displayed ", methodName);
				flag=false;
			}
			waitForSpinnerToDisappear(driver);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorState+methodName+" :: "+e.getMessage());
			flag=false;
		}

		return flag;

	}

	public boolean enterValueToField1(WebDriver driver, boolean flag, By searchbar, By searchButton,String searchLabel, String searchValue) {

		Actions actions = new Actions(driver);

		try {
			if(!searchValue.isEmpty()) {

				BaseSuite.reportLog(" Entering value : "+searchValue);

				isDisplayedInLoop(driver, 2, searchbar);

				displayAndClick(driver, searchbar);displayAndClick(driver, searchbar);

				clear_Click_SendKeys(driver, 4, searchbar, searchValue);

				isDisplayedInLoop(driver, 2, searchButton);

				if(isDisplayed(driver, searchButton)) {

					BaseSuite.reportLog(" Clicking on "+searchLabel+" button ");

					actions.click(driver.findElement(searchButton)).build().perform();

					BaseSuite.validationReportLog("Clicked on "+searchLabel+" button successfully ");

					waitForSpinnerToDisappear(driver);
				}else {
					BaseSuite.reportFailLog(searchLabel+" button not visible ", "enterValueToField1");
					flag=false;
				}
			}else if(searchValue.isEmpty()) {
				isDisplayedInLoop(driver, 2, searchbar);

				displayAndClick(driver, searchbar);displayAndClick(driver, searchbar);

				clear_Click_SendKeys(driver, 4, searchbar, searchValue);

				isDisplayedInLoop(driver, 2, searchButton);

				if(isDisplayed(driver, searchButton)) {

					BaseSuite.reportLog(" Clicking on "+searchLabel+" button ");

					actions.click(driver.findElement(searchButton)).build().perform();

					BaseSuite.validationReportLog("Clicked on"+searchLabel+" button successfully ");

					waitForSpinnerToDisappear(driver);
				}else {
					BaseSuite.reportFailLog(searchLabel+" button not visible ", "entervaluetoField1");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Observed error for : entervaluetoField :: "+e.getMessage());
			flag=false;
		}
		return flag;
	}

	public boolean validateValueWithActual(WebDriver driver,By locator,String label,  String expected, String attribute) {

		boolean flag=true;

		try {
			if(!expected.isEmpty()) {
				BaseSuite.reportLog(verifyingContent+label+" with expected value");	
				if(isDisplayed(driver, locator)) {

					String actualValue=getAttribute(driver, locator, attribute);

					flag=stringOutput(actualValue, expected, flag);
				}else {
					BaseSuite.reportFailLog(label+" field value is not visible", "validateValueWithActual");

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Observed error for : validateValueWithActual :: "+e.getMessage());
			flag=false;
		}


		return flag;
	}

	public boolean checkFieldEnabledOrNot(WebDriver driver, By locator, String label, boolean expectedState) {
		try {
			boolean actualState = isEnabled(driver, locator);

			if (actualState == expectedState) {
				String stateText = expectedState ? enableContentx : disableContentx;
				BaseSuite.validationReportLog(label + " is " + stateText + " as expected");
			} else {
				String actual = actualState ? enableContentx : disableContentx;
				String expected = expectedState ? enableContentx : disableContentx;
				BaseSuite.reportFailLog(label + " is " + actual + " but expected is " + expected, "checkFieldEnabledOrNot");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error in checkFieldEnabledOrNot for locator [" + locator + "] - " + e.getMessage());
			return false;
		}

		return expectedState;
	}


	public boolean selectcheckbox(WebDriver driver, By locator, String label) {
		boolean isSuccess = true;

		try {
			waitForSpinnerToDisappear(driver);
			// Retry visibility check
			isDisplayedInLoop(driver, 1, locator);
			if (!isDisplayed(driver, locator)) {
				BaseSuite.reportFailLog(" Checkbox not visible for " + label, "selectCheckbox");
				return false;
			}

			// Get checkbox class attribute
			String checkboxClass = getAttribute(driver, locator, attributeClassx);

			// Check if already selected
			boolean isAlreadySelected = checkboxClass.contains(checkContentx) && !checkboxClass.contains(uncheckContentx);

			if (isAlreadySelected) {
				BaseSuite.reportLog(label + " checkbox is already selected.");
				return false;
			}

			// Attempt to click
			BaseSuite.reportLog("Clicking on checkbox: " + label);
			displayAndClick(driver, locator);
			waitForSpinnerToDisappear(driver);

			// Verify checkbox state post-click
			String updatedClass = getAttribute(driver, locator, attributeClassx);
			boolean isNowSelected = updatedClass.contains(checkContentx) && !updatedClass.contains(uncheckContentx);

			if (isNowSelected) {
				BaseSuite.validationReportLog("Successfully selected checkbox: " + label);
			} else {
				BaseSuite.reportFailLog("Failed to select checkbox: " + label, "selectCheckbox");
				isSuccess = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error occurs while :: selectCheckbox - " + e.getMessage());
			isSuccess = false;
		}

		return isSuccess;
	}

	public boolean selectcheckbox1(WebDriver driver, By locator, String label) {
		boolean flag=true;
		try {

			waitForSpinnerToDisappear(driver);
			
			isDisplayedInLoop(driver, 1, locator);

			if(isDisplayed(driver, locator)) {

				String acs=getAttribute(driver,locator, attributeClassx);

				if(!acs.contains(checkContentx)) {

					BaseSuite.reportLog(" Clicking on checkbox  of "+label);

					isDisplayedInLoop(driver, 2, locator);

					displayAndClick(driver, locator);

					BaseSuite.validationReportLog(label+" checkbox is selected");

					waitForSpinnerToDisappear(driver);
				}else {
					BaseSuite.reportLog(label+" type is checkbox already selected");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog("Checkbox not visible for :: "+label, "selectcheckbox");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while selectcheckbox kindly check , "+e.getMessage()+locator);
		}
		return flag;
	}

	public boolean unselectcheckbox(WebDriver driver, By locator, String label) {
		boolean flag=true;
		try {

			waitForSpinnerToDisappear(driver);

			isDisplayedInLoop(driver, 1, locator);

			if(isDisplayed(driver, locator)) {

				String acs=getAttribute(driver,locator, attributeClassx);

				if(acs.contains(checkContentx) || !acs.contains(uncheckContentx)) {

					BaseSuite.reportLog(" Clicking on checkbox "+label);

					isDisplayedInLoop(driver, 2, locator);

					displayAndClick(driver, locator);

					BaseSuite.validationReportLog(label+" checkbox is unselected");

					waitForSpinnerToDisappear(driver);
				}else {
					BaseSuite.reportLog(label+" type is checkbox already unselected");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog("Checkbox not visible for "+label, "unselectcheckbox");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while unselectcheckbox kindly check , "+e.getMessage()+locator);
		}
		return flag;
	}

	public boolean unselectcheckbox1(WebDriver driver, By locator, String label) {
		boolean flag=true;
		try {

			waitForSpinnerToDisappear(driver);

			isDisplayedInLoop(driver, 1, locator);

			if(isDisplayed(driver, locator)) {

				String acs=getAttribute(driver,locator, attributeClassx);

				if(acs.contains(checkContentx)) {

					BaseSuite.reportLog(" Clicking on checkbox "+label);

					isDisplayedInLoop(driver, 2, locator);

					displayAndClick(driver, locator);

					BaseSuite.validationReportLog(label+" checkbox is unselected");

					waitForSpinnerToDisappear(driver);
				}else {
					BaseSuite.reportLog(label+" type is checkbox already unselected");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog("Checkbox not visible for "+label, "unselectcheckbox");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while unselectcheckbox kindly check , "+e.getMessage()+locator);
		}
		return flag;
	}

	public void selectUncheckbox(WebDriver driver, By locator, String label) {

		waitForSpinnerToDisappear(driver);

		isDisplayedInLoop(driver, 1, locator);

		if(isDisplayed(driver, locator)) {

			String acs=getAttribute(driver,locator, attributeClassx);

			if(acs.contains("e-check") && !acs.contains("e-uncheck")) {
				BaseSuite.reportLog("checkbox is visible as selected for "+label);
				BaseSuite.reportLog("Clicking on checkbox "+label);

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label+" checkbox is unchecked");
			}else if(acs.contains("e-stop")){
				BaseSuite.reportLog("checkbox is visible as stop sign for "+label);
				BaseSuite.reportLog("Clicking on checkbox "+label);

				displayAndClick(driver, locator);
				waitForSpinnerToDisappear(driver);
				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label+" checkbox is unchecked");

			}else if(acs.contains("e-uncheck")){

				BaseSuite.reportLog(label+" type is checkbox already unchecked");
			}
		}
	}

	public boolean validatePopupWindowContent(WebDriver driver, boolean flag, By titleLocator, By contentLocator, String title, String content) {

		try {
			if(flag) {
				String removetitle = getValue(driver, titleLocator);

				flag = stringContainsOutput(removetitle, title, true);

				if(flag) {

					String removecontents = getValue(driver, contentLocator);

					flag = stringContainsOutput(removecontents, content, true);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while validatePopupWindowContent kindly check , "+e.getMessage()+titleLocator);
		}
		return flag;
	}

	public boolean enterValueToFieldForInvalidDetails(WebDriver driver, By fieldLocator, By validationLocator,String fieldLabel, String inputValue, String fieldValidation) {
		boolean flag =true;

		try {
			waitForSpinnerToDisappear(driver);

			inputValue=checkNullValue(inputValue);

			if(!inputValue.isEmpty()) {
				enterValueToTextField(driver, fieldLocator, fieldLabel, inputValue);	
			}else {
				/**	sendKeys(driver, fieldLocator, "emp");*/
				waitForExecution(500);
				click(driver, fieldLocator);sendKeys(driver, fieldLocator, "emp");selectAllAndBackSpace(driver, fieldLocator);
				
			}

			String acmesg = validationMessageOfField(driver, validationLocator, fieldLabel, fieldValidation, true);

			if(!fieldValidation.equalsIgnoreCase(acmesg)) {
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Observed error for : enterValueToFieldForInvalidDetails :: "+e.getMessage());
			flag=false;
		}
		return flag;
	}

	public StringBuilder setHtmlColorCode(String cell,StringBuilder htmlbuilder) {

		try {
			String tdClose="</td>";
			String text=cell.trim().toLowerCase();

			switch(text+1) {

			case "success1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#32cd32\">").append(cell).append(tdClose);
				break;
			case "warning1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#F8C753\">").append(cell).append(tdClose);
				break;
			case "error1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#a9a6a6\">").append(cell).append(tdClose);
				break;
			case "critical1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#FFDFC9\">").append(cell).append(tdClose);
				break;
			case "blocker1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#f56464\">").append(cell).append(tdClose);
				break;
			case "running1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#2F8DFA\">").append(cell).append(tdClose);
				break;
			case "submitted1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#8181F7\">").append(cell).append(tdClose);
				break;
			case "pass1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#32cd32\">").append(cell).append(tdClose);
				break;
			case "fail1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#d03211\">").append(cell).append(tdClose);
				break;
			case "skipped1":
				htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#c8c8c8\">").append(cell).append(tdClose);
				break;
			default:
				htmlbuilder.append("<td class=\"e-rowcell\">").append(cell).append(tdClose);
				break;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while setHtmlColorCode kindly check , "+e.getMessage());
		}
		return htmlbuilder;
	}

	public String createHtmlTable1(String [][] datatable, String tableTitle) {


		String trClose="</tr>";
		StringBuilder htmlbuilder = new StringBuilder();

		try {
			if(datatable!=null) {

				htmlbuilder.append(prop.getProperty("workflow.recentRuns.Details.Table.cssStyle"));

				htmlbuilder.append("<table class =\"rule1\">");

				htmlbuilder.append("<caption>"+tableTitle+" table"+"</caption>");

				htmlbuilder.append("<thead>");

				htmlbuilder.append("<tr class=\"e-row\">");

				for(String header : datatable[0]) {

					htmlbuilder.append("<th class=\"e-headercell\" style=\"text-align: center;\">").append(header).append("</th>");

				}
				htmlbuilder.append(trClose);

				htmlbuilder.append("</thead>");

				htmlbuilder.append("<tbody>");

				for(int i=1;i<datatable.length;i++) {

					htmlbuilder.append("<tr class=\"e-row\">");

					for(String cell :datatable[i]) {

						htmlbuilder=setHtmlColorCode(cell, htmlbuilder);
					}

					htmlbuilder.append(trClose);
				}

				htmlbuilder.append("</tbody>");

				htmlbuilder.append("</table>");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while createHtmlTable1 kindly check , "+e.getMessage());
		}
		return htmlbuilder.toString();
	}

	public boolean viewAndValidateField(WebDriver driver, By locator, String label, String expectedValue, boolean state) {

		boolean flag = true;
		String methodName="viewAndValidateField";
		try {
		
			waitForSpinnerToDisappear(driver);
			
			isDisplayedInLoop(driver, 2, locator);

			javascript(driver, prop.getProperty(scrollProp), locator);

			if(isDisplayed(driver, locator)) {			

				checkFieldEnabledOrNot(driver, locator, label,state);

				checkExpectedValueWithActual(driver,flag, locator, label,expectedValue,true);

			}else {
				BaseSuite.reportFailLog(label+" not visible  ", methodName);
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,e.getMessage());
			flag=false;
		}

		return flag;
	}

	public String getAttributeValue(WebDriver driver, By locator) {
		String value = "";

		try {
			value = getAttribute(driver, locator, valueContent);

			// Fallback if "value" is null or empty
			if (value == null || value.trim().isEmpty()) {
				value = getAttribute(driver, locator, attributeTextContents);
			}

		} catch (Exception e) {
			log.info("Exception in getAttributeValue for locator: " + locator + " | Error: " + e.getMessage());

			// Fallback after exception
			try {
				value = getAttribute(driver, locator, attributeTextContents);
			} catch (Exception innerEx) {
				log.info("Fallback also failed for locator: " + locator + " | Error: " + innerEx.toString());
				value = "";
			}
		}

		log.info("Final attribute value for locator " + locator + " is: '" + value + "'");
		return (value != null) ? value.trim() : "";
	}

	//check expected and actual values
	public boolean checkExpectedValueWithActual(WebDriver driver, boolean flag, By locator,String label, String expectedValue, boolean compareflag) {

		try {
			if(compareflag && !expectedValue.isEmpty()) {

				BaseSuite.reportLog("Validating "+label+" field value");waitForSpinnerToDisappear(driver);
				

				isDisplayedInLoop(driver, 2, locator);

				String ac=getAttributeValue(driver, locator);

				flag=stringContainsOutput(ac, expectedValue, true);

			}else if(compareflag && expectedValue.isEmpty()) {
				//
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while checkExpectedValueWithActual kindly check , "+e.getMessage()+locator);
		}

		return flag;
	}

	//check expected and actual values
	public boolean checkExpectedValueWithActual(WebDriver driver, boolean flag, By locator,String label, String expectedValue, boolean compareflag, String attribute) {

		try {
			if(compareflag && !expectedValue.isEmpty()) {

				BaseSuite.reportLog("Validating "+label+" field value");

				isDisplayedInLoop(driver, 2, locator);

				String ac=getAttribute(driver, locator, attribute);

				flag=stringContainsOutput(ac, expectedValue, true);

			}else if(compareflag && expectedValue.isEmpty()) {
				//
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error occurs while checkExpectedValueWithActual kindly check , "+e.getMessage()+locator);
		}

		return flag;
	}


	public boolean validatAndEnterValueToTextFieldForValidation(WebDriver driver, By labelLocator, By fieldLocator,By validationLocator, String label, String placeHolder, String input, String fieldValidation){

		boolean flag=true;
		try {
			waitForSpinnerToDisappear(driver);
			
			isDisplayedInLoop(driver, 2, labelLocator);

			javascript(driver, prop.getProperty(scrollProp), labelLocator);

			verifyIndividualLabel(driver, labelLocator, label);

			if (isDisplayed(driver, fieldLocator)) {

				isClickable(driver, fieldLocator,label, true);

				verifyPlaceHolderValue(driver,fieldLocator, label, placeHolder);

				if(input==null) {
					input="";
				}

				click(driver, fieldLocator);

				clear(driver, fieldLocator);

				BaseSuite.reportLog("Entering value : " + input);

				sendKeys(driver, fieldLocator, input);

				String ac = getAttribute(driver, fieldLocator, valueContent);

				flag = stringContainsOutput(ac, input, true);

				validationMessageOfField(driver,validationLocator, label, fieldValidation, true);

			} else {
				flag=false;
				BaseSuite.reportFailLog(label+" field not displayed", "validatAndeEnterValueToTextField");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e," Exception found while validatAndeEnterValueToTextField : " + e.getMessage());
		}
		return flag;
	}

	public void navigateToLink(WebDriver driver, By linkLocator,By validateLocator, String label) {

		try {

			if(!label.isEmpty()) {
				BaseSuite.reportLog("-------------- Navigating to link "+label+" ---------------");

				waitForSpinnerToDisappear(driver);

				clickOnButton(driver, linkLocator, label, true);

				waitForSpinnerToDisappear(driver);

				/**	handleDiscardWindow();**/

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

				waitForSpinnerToDisappear(driver);

				waitForExecution(3000);
				isDisplayedInLoop(driver, 5, validateLocator);

				validateIsDisplayedOrNot(driver, validateLocator, label, true);

				waitForSpinnerToDisappear(driver);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Exception found while navigateToLink :: "+e.getMessage());
		}

	}

	public WebElement findElementWithRetry(WebDriver driver, By primaryLocator, String[] alternateLocators) {

		WebElement element = null;

		try {

			element = driver.findElement(primaryLocator);

		}catch(Exception e) {

			log.info(primaryLocator+" - Primary locator failed trying "+e.getMessage()+" with alternate locators");

			for(String altLocator : alternateLocators) {

				try {

					element = driver.findElement(By.xpath(altLocator));

					log.info(altLocator+" - alternate locator is choosen and worked ");

					break;

				}catch(Exception ex) {
					log.info(altLocator+" - alternate locator is choosen and failed ");

				}
			}
		}


		return element;
	}

	public static String getSybaseType(String sybasetype) {

		String str="";
		if(!System.getProperty("sybaseType").isEmpty()) {

			str = System.getProperty("sybaseType").trim();

		}else if(!sybasetype.isEmpty()){

			str = sybasetype;

		}else {
			str =prop.getProperty("Connections.sybase.type");
		}
		return str;
	}

	public static String getConnectionHostType(String hosttype) {

		String str="";
		if(!System.getProperty("hosttype").isEmpty()) {

			str = System.getProperty("hosttype").trim();

		}else if(!hosttype.isEmpty()){

			str = hosttype;

		}else {
			str =prop.getProperty("Connections.host.type");
		}
		return str;
	}

	public static Actions waitForLoaderToDisapper(WebDriver driver) {

		Actions action = new Actions(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);

			String toastContentLocator = "//div[@class='e-toast-content']";
			By spinnerLocator = By.xpath("//div[@id='sp-container']//div[@class='e-spinner-pane e-spin-show']//div");

			// Check if the toast message is displayed and interact with it
			WebElement toastLocator1 = driver.findElement(By.xpath(toastContentLocator));
			if (toastLocator1.isDisplayed()) {
				for(int i=0; i<1; i++) {
					action.moveToElement(toastLocator1).clickAndHold().build().perform();
					log.info("Toast message is displayed before spinner.");

				}
			}

			// Wait for the spinner to disappear
			wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));

			// Check if the toast message is displayed and interact with it
			WebElement toastLocator = driver.findElement(By.xpath(toastContentLocator));
			if (toastLocator.isDisplayed()) {
				for(int i=0; i<2; i++) {
					action.moveToElement(toastLocator).clickAndHold().build().perform();
					log.info("Toast message is displayed after spinner.");

				}
			}

		} catch (TimeoutException e) {
			log.error("Spinner did not disappear within the expected time 60 seconds : "+ e.getMessage());
			BaseSuite.reportErrorLog(e, "waitForLoaderToDisapper Spinner did not disappear within the expected time 60 seconds.");
		} catch (NoSuchElementException e) {
			log.error("waitForLoaderToDisapper Spinner element not found, possibly already disappeared. : "+ e.getMessage());
		} catch(Exception e) {
			log.error("Unexpected error in waitForLoaderToDisapper : " + e.getMessage());
		}

		return action;
	}

	public boolean captureToastMsgWithOutWait(WebDriver driver, By locator1, By locator2, String mess, String label) {
		String validMess;
		boolean flag = true;
		String methodName = "captureToastMsg";
		Actions actions = new Actions(driver);
		try {

			BaseSuite.reportLog(verifyingContent + label + " Message");
			/**	waitForLoaderToDisapper(driver);*/

			WebElement element = waitMethod(driver, 60).until(ExpectedConditions.elementToBeClickable(locator1));

			actions.moveToElement(element).clickAndHold().build().perform();

			validMess = getText(driver, locator1).trim();

			if (validMess.isEmpty()) {
				validMess = getAttribute(driver, locator1, attributeTextContents);
			}

			/**		actions.click(driver.findElement(locator2)).build().perform();*/

			BaseSuite.reportLog("Retrived Message for " + label + isContentLog + validMess);
			BaseSuite.reportLog("Expected Message for " + label + isContentLog + mess.trim());

			if (!validMess.isEmpty()) {

				if (validMess.trim().equalsIgnoreCase(mess.trim())) {

					BaseSuite.validationReportLog(label + " Message Successfully Matched");
				} else {
					BaseSuite.reportFailLog(label + msgDontMatched, methodName);
					flag = false;
				}

			} else {
				BaseSuite.reportFailLog("Retrived Messages is empty kindly check"+validMess, methodName);
				flag = false;
			}

			if (driver.findElement(locator2).isDisplayed()) {
				actions.click(driver.findElement(locator2)).build().perform();
			}

			/**waitForLoaderToDisapper(driver);*/

			isNotDisplayed(driver, locator2, 5);
		} catch (TimeoutException e) {
			BaseSuite.log.error("Timeout occurred: " + e.getMessage());
			BaseSuite.reportErrorLog(e, label + " Messages not found, check captureToastMsgWithOutWait");
			flag = false;
		} catch (NoSuchElementException e) {
			BaseSuite.log.error("Toast element not found: " + e.getMessage());
			BaseSuite.reportErrorLog(e, label + " Toast message missing, check captureToastMsgWithOutWait");
			flag = false;
		} catch (Exception e) {
			BaseSuite.log.error("Unexpected error: " + e.getMessage());
			BaseSuite.reportErrorLog(e, label + " Exception catched, check captureToastMsgWithOutWait");
			flag = false;
		}
		return flag;
	}

	public boolean captureToastMsgContainsWithOutWait(WebDriver driver, By toastLocator, By dismissLocator, String expectedMessage, String label) {
		String actualMessage = null;
		boolean isSuccess = true;
		String methodName = "captureToastMsgWithOutWait";
		Actions actions = new Actions(driver);

		try {
			BaseSuite.reportLog(verifyingContent + label + " message...");

			// Wait until the toast message is clickable
			WebElement toastElement = waitMethod(driver, 60).until(ExpectedConditions.elementToBeClickable(toastLocator));
			actions.moveToElement(toastElement).clickAndHold().perform();

			actualMessage = getText(driver, toastLocator).trim();
			if (actualMessage.isEmpty()) {
				actualMessage = getAttribute(driver, toastLocator, attributeTextContents);
			}

			BaseSuite.reportLog("Retrieved message: " + actualMessage);
			BaseSuite.reportLog("Expected message: " + expectedMessage.trim());

			if (actualMessage == null || actualMessage.trim().isEmpty()) {
				BaseSuite.reportFailLog("Retrieved message is empty. Check locator or DOM.", methodName);
				return false;
			}

			if (actualMessage.trim().contains(expectedMessage.trim())) {
				BaseSuite.validationReportLog(label + " message contains matched successfully.");
			} else {
				BaseSuite.reportFailLog("Mismatch: Expected vs Actual", methodName);
				isSuccess = false;
			}

			// Dismiss toast if it's visible
			WebElement dismissBtn = driver.findElement(dismissLocator);
			if (dismissBtn.isDisplayed()) {
				actions.click(dismissBtn).perform();
			}

			// Ensure it is no longer visible
			isNotDisplayed(driver, dismissLocator, 5);

		} catch (TimeoutException e) {
			BaseSuite.log.error("Timeout: " + e.getMessage());
			BaseSuite.reportErrorLog(e, label + " toast not found.");
			isSuccess = false;
		} catch (NoSuchElementException e) {
			BaseSuite.log.error("Element missing: " + e.getMessage());
			BaseSuite.reportErrorLog(e, label + " toast or dismiss element not found.");
			isSuccess = false;
		} catch (Exception e) {
			BaseSuite.log.error("Unexpected error: " + e.getMessage());
			BaseSuite.reportErrorLog(e, label + " exception in " + methodName);
			isSuccess = false;
		}

		return isSuccess;
	}


	public boolean validateTitle(WebDriver driver, By locator, String label) {
		boolean flag=false;
		isDisplayedInLoop(driver, 2, locator);

		if(isDisplayed(driver, locator)) {

			flag = true;

			BaseSuite.validationReportLog(label+" title is visible");

		}else {
			BaseSuite.reportFailLog(label+" title not visible", "validateTitle");

		}
		return flag;
	}

	public void handleDiscardWindow(WebDriver driver, By locator, String button) {
		try {
			isNotDisplayed(driver, By.xpath(prop.getProperty(spinnerProp)), Constant.ruleWait);
			isDisplayed(driver, locator, 10);
			if (isDisplayed(driver, locator, 10)) {
				clickOnButton(driver, locator, button, true);
				isNotDisplayed(driver, By.xpath(prop.getProperty(spinnerProp)), Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Exception found while handleDiscardWindow ::"+e.getMessage());

		}
	}

	public boolean elementNotVisible(WebDriver driver, By locator) {

		boolean state = true;

		try {

			state=waitMethod(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(locator));

		} catch (Exception e) {

			log.info("ElementNotVisible exception"+e.getMessage());
			log.info("element is visible");
			state=false;
		}
		return state;
	}


	/**
	 * Updates or sets a property in the given properties file.
	 *
	 * @param filePath the path to the properties file
	 * @param key      the key to update or add
	 * @param value    the value to set for the key
	 */
	public static void updateProperty(String filePath, String key, String value) {
		Properties properties = new Properties();

		// Try-with-resources to ensure streams are closed automatically
		try (FileInputStream inputStream = new FileInputStream(filePath)) {
			// Load the existing properties file
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			log.info("Properties file not found. A new file will be created.");
		} catch (IOException e) {
			log.info("Error reading properties file: " + e.getMessage());
			return;
		}

		// Set or update the property
		properties.setProperty(key, value);

		// Write the updated properties back to the file
		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			properties.store(outputStream, "Updated properties file");
			log.info("Property updated successfully!");
		} catch (IOException e) {
			log.info("Error writing to properties file: " + e.getMessage());
		}
	}

	public static String trimLastCharIfSlash(String input) {
		if (input != null && input.endsWith("/")) {
			return input.substring(0, input.length() - 1);
		}
		return input; // Return the original string if it doesn't end with '/'.
	}

	public static String getTokenPathForIDP(String input) {
		String output="";
		try {
			if(!checkNullValue(input).isEmpty()) {
				String trimmedInput = trimLastCharIfSlash(input); // Trim '/' if present
				trimmedInput=checkNullValue(trimmedInput);
				if(trimmedInput.equalsIgnoreCase("https://qa.onprem.icedq.com")) {
					output= trimLastCharIfSlash(input)+"/auth/realms/icedq.qa";
				}else {
					output= trimLastCharIfSlash(input)+"/auth/realms/icedq";
				}
			}else {

				return input;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error observed while getTokenPathForIDP :: " + e.getMessage());
		}
		return output;
	}

	public void waitForTime(int seconds) {

		waitForExecution(seconds*1000);

	}

	public String getExpectedInput(String input, String ifEmpty, String ifNotEmpty) {

		input = checkNullValue(input);

		if(input.isEmpty()) {
			BaseSuite.reportLog("Selecting values : "+ifEmpty);
			return ifEmpty;
		}else {
			BaseSuite.reportLog("Selecting values : "+ifNotEmpty);
			return ifNotEmpty;
		}

	}

	public static int getSplitCount(String input, String delimiter) {
		if (input == null || input.trim().isEmpty()) {
			return 0; // Return 0 for empty or null input
		}
		return input.split(delimiter).length; // Count the number of values after split
	}

	public boolean checkFieldIsEnabledOrNot(WebDriver driver, String label, String locator, String dynamicElement,  boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of field is enabled or not for : "+label);

			// Dynamically build XPath based on expected condition
			String elementXPath = expected ? "[not(@disabled)]" : "[@disabled]";

			if (isDisplayed(driver, returnElement(locator, dynamicElement, elementXPath))) {

				BaseSuite.validationReportLog(label + " field is  " + (expected ? enableContentx : disableContentx));

			} else {
				BaseSuite.reportFailLog(label + " field is " + (expected ? enableContentx : disableContentx) + " not matched with expected condition ", "checkFieldIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error observed while checkFieldIsEnabledOrNot :: " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean checkFieldIsEnabledOrNotUsingAttribute(WebDriver driver,By locator,  String label, String attribute, boolean expected) {
		try {
			BaseSuite.reportLog("Verifying state of field is enabled or not for: " + label);

			boolean isEnabled = !getAttribute(driver, locator, attribute).contains(disableContentx);

			if (isEnabled == expected) {
				BaseSuite.validationReportLog(label + " field is  " + (expected ? enableContentx : disableContentx));
			} else {
				BaseSuite.reportFailLog(label + " field is expected to be " + (expected ? enableContentx : disableContentx) + " but found otherwise", 
						"checkFieldIsEnabledOrNotUsingAttribute");
			}
			return isEnabled;
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"Error in checkFieldIsEnabledOrNotUsingAttribute: " + e.getMessage());
			return false;
		}
	}

	public static boolean compareValues(Object value1, Object value2 , String label) {

		BaseSuite.reportLog("Expected "+label+" : " + value1);
		BaseSuite.reportLog("Actual "+label+" : " + value2);

		boolean result;

		if (value1 == null || value2 == null) {
			result = (value1 == value2);
		} else if (value1 instanceof Number && value2 instanceof Number) {
			result = Double.compare(((Number) value1).doubleValue(), ((Number) value2).doubleValue()) == 0;
		} else if (value1 instanceof List && value2 instanceof List) {
			result = ((List<?>) value1).equals((List<?>) value2);
		} else {
			result = value1.equals(value2);
		}

		if (!result) {
			BaseSuite.reportFailLog(label+" Values do not match.", "compareValues");
		} else {
			BaseSuite.validationReportLog(label+" Values matched.");
		}

		return result;
	}

	public String getUserFullName(String icedqUser) {
		String user="";
		switch(icedqUser.toLowerCase()){

		case "account_owner":
			user="Account Owner";
			break;
		case "account_contributor":
			user="Account Contributor";
			break;
		case "account_executor":
			user="Account Executor";
			break;
		case "workspace_owner":
			user="Workspace Owner";
			break;
		case "workspace_contributor":
			user="Workspace Contributor";
			break;
		case "workspace_executor":
			user="Workspace Executor";
			break;
		default : 
			user=null;
			break;

		}

		return user;
	}

	// Get window handle for workflow and rules
	public String getWindowHandle(WebDriver driver) {
		String mainWindow = null;
		try {
			mainWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();

			for (String window : allWindows) {
				if (!window.equals(mainWindow)) {
					log.info("Switching to child window: " + window);
					driver.switchTo().window(window);
					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
					break; // switch to the first child and break
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Exception while getWindowHandle :: " + e.getMessage());
			log.error("Exception while switching to child window", e);
		}
		return mainWindow;
	}

	public void closeCurrentTabAndSwitchToMain(WebDriver driver, String mainWindow) {
		if (mainWindow == null || mainWindow.isEmpty()) {
			throw new IllegalArgumentException("Main window handle is null or empty");
		}

		try {
			String currentWindow = driver.getWindowHandle();

			// Log current and main window handles
			BaseSuite.reportLog("Current window handle: " + currentWindow);
			BaseSuite.reportLog("Main window handle: " + mainWindow);

			// Only proceed if we are not already on the main window
			if (!currentWindow.equals(mainWindow)) {
				waitForSpinnerToDisappear(driver);

				BaseSuite.reportLog("Closing current tab and switching control to main window");

				driver.close(); // Closes current tab

				driver.switchTo().window(mainWindow); // Switches back to main tab

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

				waitForSpinnerToDisappear(driver);
			} else {
				BaseSuite.reportLog("Already on the main window. No action needed.");
			}

		} catch (NoSuchWindowException e) {
			BaseSuite.reportLog("Main window not found: " + e.getMessage());
			throw e;
		}
	}


	public static String getModuleName(String moduleName) {
		if (moduleName == null) return null;

		switch (moduleName.toLowerCase()) {
		case "scheduler":	    	return "Scheduler";
		case "datatesting":	    	return "Data Testing";
		case "connectors":	 case "connectionrepo":	    	return "Connectors";
		case "administration":	    	return "administration";
		default:
			return moduleName;
		}
	}
	
	public String getValueUsingAttribute(WebDriver driver, By locator, String attribute) {

		String actualValue="";
		try {

			actualValue=getAttribute(driver, locator, attribute);
			
			actualValue=checkNullValue(actualValue);
			
			actualValue=actualValue.isEmpty() ? " " : actualValue;

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  "Error occurs while getValueUsingAttribute :: "+e.getMessage());

		}
		return actualValue;
	}


}

