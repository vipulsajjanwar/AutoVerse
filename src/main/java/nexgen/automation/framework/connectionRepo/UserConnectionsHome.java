package nexgen.automation.framework.connectionRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class UserConnectionsHome extends PageUtil {

WebDriver driver;
	
	public UserConnectionsHome(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By connectionPageSpinner=getElementLocator(prop.getProperty("connectionPageSpinner"));
	By clickonUConnection = getElementLocator(prop.getProperty("UConnection.userConnection"));
	By clickonURefresh = getElementLocator(prop.getProperty("UConnection.URefresh"));
	By selectUallCheckbox = getElementLocator(prop.getProperty("UConnection.UallCheckbox"));
	By UsearchBar = getElementLocator(prop.getProperty("UConnection.USearchBox"));
	By UsearchBclick = getElementLocator(prop.getProperty("UConnection.USearchButton"));
	By userColumnBtn=getElementLocator(prop.getProperty("userColumnBtn"));
	String ClickUsearchConnection = prop.getProperty("UConnection.USearchConnection");
	By ClickUHomeLink = getElementLocator(prop.getProperty("UConnection.UHomeLink"));
	By userConnectionNameLabel=getElementLocator(prop.getProperty("userConnectionNameLabel"));
	By userWorkspaceLabel=getElementLocator(prop.getProperty("userWorkspaceLabel"));
	By userTypeLabel=getElementLocator(prop.getProperty("userTypeLabel"));
	By userCreatedByLabel=getElementLocator(prop.getProperty("userCreatedByLabel"));
	By userLastModified=getElementLocator(prop.getProperty("userLastModified"));
	
	public void clickConnnectionsTab() {
		try
		{
		BaseSuite.reportLog("Clicking on User connections Tab");
		Thread.sleep(1000);					 
		 isDisplayedInLoop(driver,20,clickonUConnection);
		 
		displayAndClick(driver, clickonUConnection);
	        
		inVisible(driver, connectionPageSpinner, Constant.ruleWait);	
					
		BaseSuite.validationReportLog("User connections Tab clicked successfully");				        
		}
		catch(Exception e)
		{
			throw new AssertionError("Error occured in this method", e);
		}
	}	
	
	public void clickOnRefreshButton()
	{
		isClickable(driver, clickonURefresh, "Refresh Button", true);
		isDisplayedInLoop(driver,10,clickonURefresh);
		displayAndClick(driver,clickonURefresh);
		inVisible(driver, connectionPageSpinner, Constant.ruleWait);	
	}
	
	public void validateUserLandingPage() {
		try {
			validateButtons(driver, userColumnBtn, 1);
			validateButtons(driver, clickonURefresh, 1);
			verifyIndividualLabel(driver, userConnectionNameLabel, "Connection Name");
			verifyIndividualLabel(driver, userWorkspaceLabel, "Workspace");
			verifyIndividualLabel(driver, userTypeLabel, "Type");
			verifyIndividualLabel(driver, userCreatedByLabel, "Created By");
			verifyIndividualLabel(driver, userLastModified, "Last Modified");			
			
		} catch (Exception e) {
			throw new AssertionError("All buttons are disabled", e);
		}
	}	
	public void SearchUConnection(String Connection_search) throws Exception
	{
		
			isDisplayed(driver, clickonUConnection);
			click(driver, clickonUConnection);
			
			BaseSuite.reportLog("Searching for Connection:" + Connection_search);
			isDisplayedInLoop(driver, 10, UsearchBar);
			Thread.sleep(3000);
			click(driver, UsearchBar);
			clear(driver, UsearchBar);
			isDisplayedInLoop(driver, 4, UsearchBar);
			BaseSuite.reportLog("Search User Connection");
			sendKeys(driver, UsearchBar, Connection_search);
			BaseSuite.reportLog("Click On searched");
			isDisplayedInLoop(driver, 3, UsearchBclick);
			click(driver, UsearchBclick);
			try {
				isDisplayedInLoop(driver, 4, UsearchBclick);
				BaseSuite.reportLog("Click on Searched User");
				click(driver, returnElement(ClickUsearchConnection, "$name", Connection_search));
				BaseSuite.reportLog("Clicked on User: " + Connection_search);
				BaseSuite.reportLog("User Details retrieved successfully for user " + Connection_search);

			} catch (Exception e) {
				throw new Exception("User_search " + UsearchBclick + " not found");
			}
		}	

}
