package nexgen.automation.framework.connectionRepo;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class FlatFileConnection extends PageUtil {

	WebDriver driver;
	
	public FlatFileConnection(WebDriver driver)
	{
		this.driver = driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By connectionPageSpinner=getElementLocator(prop.getProperty("connectionPageSpinner"));
	
	By selectWorspaceDrop=getElementLocator(prop.getProperty("selectWorspaceDrop"));
	By addWorkspace=getElementLocator(prop.getProperty("addWorkspace"));
	By selectLocation=getElementLocator(prop.getProperty("selectLocation"));
	By addLocation=getElementLocator(prop.getProperty("addLocation"));
	
	By selectAuthentication=getElementLocator(prop.getProperty("selectAuthentication"));
	By addAuthentication=getElementLocator(prop.getProperty("addAuthentication"));
	
	By selectType=getElementLocator(prop.getProperty("selectType"));
	By addType=getElementLocator(prop.getProperty("addType"));
	By selectCacheConn=getElementLocator(prop.getProperty("selectCacheConn"));
	By addCacheConnection=getElementLocator(prop.getProperty("addCacheConnection"));
	
	By selectAllPropCheckbox=getElementLocator(prop.getProperty("selectAllPropCheckbox"));
	By isSelectedAllPropCheckbox=getElementLocator(prop.getProperty("isSelectedAllPropCheckbox"));
	By selectSinglePropCheckbox=getElementLocator(prop.getProperty("selectSinglePropCheckbox"));
	By isSelectedSingleCheckbox=getElementLocator(prop.getProperty("isSelectedSingleCheckbox"));
	By addPropertyBtn=getElementLocator(prop.getProperty("addPropertyBtn"));
	By removePropertyBtn=getElementLocator(prop.getProperty("removePropertyBtn"));
	
	By noOfButtons=getElementLocator(prop.getProperty("noOfButtons"));
	By disableBtn=getElementLocator(prop.getProperty("disableBtn"));
	By testBtn=getElementLocator(prop.getProperty("testBtn"));
	By saveBtn=getElementLocator(prop.getProperty("saveBtn"));
	By discardBtn=getElementLocator(prop.getProperty("discardBtn"));
	By enableCacheBtn=getElementLocator(prop.getProperty("enableCacheBtn"));
	By workspaceLabel=getElementLocator(prop.getProperty("workspaceLabel"));
	By nameLabel=getElementLocator(prop.getProperty("nameLabel"));
	By locationLabel=getElementLocator(prop.getProperty("locationLabel"));
	By filePathLabel=getElementLocator(prop.getProperty("filePathLabel"));
	By regionLabel=getElementLocator(prop.getProperty("regionLabel"));
	By typeLabel=getElementLocator(prop.getProperty("typeLabel"));
	By accessKeyLabel=getElementLocator(prop.getProperty("accessKeyLabel"));
	By secretKeyLabel=getElementLocator(prop.getProperty("secretKeyLabel"));
	By connPropLabel=getElementLocator(prop.getProperty("connPropLabel"));
	By propnameLabel=getElementLocator(prop.getProperty("propnameLabel"));
	By propvalueLabel=getElementLocator(prop.getProperty("propvalueLabel"));
	By propTypeLabel=getElementLocator(prop.getProperty("propTypeLabel"));
	By connDiscardTitle=getElementLocator(prop.getProperty("connDiscardTitle"));
	By msgOnDiscardWin=getElementLocator(prop.getProperty("msgOnDiscardWin"));
	By connDiscardYesBtn=getElementLocator(prop.getProperty("connDiscardYesBtn"));
	By connDiscardNoBtn=getElementLocator(prop.getProperty("connDiscardNoBtn"));
	By clickonNewConnection = getElementLocator(prop.getProperty("Connection.newConnection"));
	By clickOnFilePath = getElementLocator(prop.getProperty("ConnectionB.filePath"));
	By ConnectionName=getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	By flatRegion=getElementLocator(prop.getProperty("flatRegion"));
	By flatAccessKey=getElementLocator(prop.getProperty("flatAccessKey"));
	By flatSecretKey=getElementLocator(prop.getProperty("flatSecretKey"));
	By flatSessionToken=getElementLocator(prop.getProperty("flatSessionToken"));
	By flatConnPropName=getElementLocator(prop.getProperty("flatConnPropName"));
	By flatConnPropValue=getElementLocator(prop.getProperty("flatConnPropValue"));
	By selectConnPropType=getElementLocator(prop.getProperty("selectConnPropType"));
	By enterConnPropType=getElementLocator(prop.getProperty("enterConnPropType"));
	By flatErrorMsgRed=getElementLocator(prop.getProperty("flatErrorMsgRed"));
	By Commontoastmsg=getElementLocator(prop.getProperty("Commontoastmsg"));
	By PopUpClose=getElementLocator(prop.getProperty("PopUpClose"));
	
	String connErrorMessage = prop.getProperty("ConnectionB.Mandatory.ConnErrorMsg");
	public String selectWorkspaceName=prop.getProperty("selectWorkspaceName");
	public String searchNewconnectionName=prop.getProperty("searchNewconnectionName");
	public String location=prop.getProperty("location");
	public String authentication=prop.getProperty("authentication");
	public String type=prop.getProperty("type");
	public String searchWorkspaceName=prop.getProperty("searchWorkspaceName");
	public String enteredConnName=prop.getProperty("enteredConnName");
	public String enteredConnFilePath=prop.getProperty("enteredConnFilePath");
	
	public void mandatoryField(SoftAssert soft,String connectionType,String connFormat,String SpecialChar,String connectionName,String errorMess,
			String location,String authentication,String filePath,String region,String userName,String password,String connProp,String connType,String enableCache,String selectcacheName) throws Exception {
			
				
		if (!connectionName.isEmpty()) {

			if (SpecialChar.equalsIgnoreCase("Yes")) {
				BaseSuite.reportLog("Clicking on connection name ");
				displayAndClick(driver,ConnectionName);
				BaseSuite.reportLog("Entering Connection Name In Connection Name Field");
				sendKeys(driver, ConnectionName, connectionName);
				BaseSuite.reportLog("Check Error message with invalid Connection name ");
				String ConnectionSpecialCharErrmsg = getText(driver, flatErrorMsgRed).trim();
				BaseSuite.validationReportLog("Retrived Message for " + "Connection Name" + " field is :" + ConnectionSpecialCharErrmsg);
				BaseSuite.validationReportLog("Expected Message for " + "Connection Name" + " field is :" + errorMess);
				if (!ConnectionSpecialCharErrmsg.isEmpty()) {
					soft.assertEquals(ConnectionSpecialCharErrmsg, errorMess);
					
					BaseSuite.validationReportLog(nameLabel + "Field Error Message Successfully Matched");
				} else {
					BaseSuite.reportFailLog(nameLabel + "Field Error Message not Matched", "specialCharaMandatoryField");
				}					
			}
			else {
				BaseSuite.reportLog("Clicking on connection name ");
				displayAndClick(driver,ConnectionName);
				BaseSuite.reportLog("Entering Connection Name In Connection Name Field");
				sendKeys(driver, ConnectionName, connectionName);
				BaseSuite.reportLog("Connection Name added successfully");
			}
		}
		else
		{
			displayAndClick(driver,ConnectionName);
			sendKeys(driver, ConnectionName, "Test");
			clear(driver,ConnectionName);
			String ConnectionNameErrmsg = getText(driver, flatErrorMsgRed).trim();
			BaseSuite.validationReportLog("Retrived Message for " + "Connection Name" + " field is :" + ConnectionNameErrmsg);
			BaseSuite.validationReportLog("Expected Message for " + "Connection Name" + " field is :" + errorMess);

			if (!ConnectionNameErrmsg.isEmpty()) {
				soft.assertEquals(ConnectionNameErrmsg, errorMess);
				
				BaseSuite.validationReportLog(nameLabel + "Field Error Message Successfully Matched");
			} else {
				BaseSuite.reportFailLog(nameLabel + "Field Error Message not Matched", "specialCharaMandatoryField");
			}	
		}
		if (!location.isEmpty()) {

			BaseSuite.reportLog("Selecting Location");

			selectDrowdownLocation(location);	
		}
		if (!authentication.isEmpty()) {

			BaseSuite.reportLog("Selecting authentication type");

			selectDrowdownAuthentication(authentication);					
			}

		if (!filePath.isEmpty()) {
			
			BaseSuite.reportLog("Entering file path");			
			clear_Click_SendKeys(driver, 5, clickOnFilePath, filePath);
			BaseSuite.validationReportLog("File path entered successfully");
		}
		else
		{
			verifyVisibilityOfButtons(driver, testBtn, "Test Button", false);			
			isClickable(driver, testBtn, "Test Button", false);
			verifyVisibilityOfButtons(driver, saveBtn, "Save Button", false);			
			isClickable(driver, saveBtn, "Save Button", false);
		}
			
		if (!region.isEmpty()) {
			
			BaseSuite.reportLog("Entering region details");
			
			clear_Click_SendKeys(driver, 5, clickOnFilePath, region);
			BaseSuite.validationReportLog("Region details entered successfully");
		
			}
			
			if (!connType.equals("System")) {
				selectDrowdownType(connType);				
			}
			
			if (connType.equals("User Connection") || connType.equals("User")) {

				BaseSuite.reportLog("Entering Connection User Name In UserName Field");

				clear_SendKeys(driver, flatAccessKey, userName);

				BaseSuite.reportLog("Entering Connection Password In Password Field");

				clear_SendKeys(driver, flatSecretKey, password);
			}
			
			if (!userName.isEmpty()) {
				BaseSuite.reportLog("Clicking on Connection Access key Field");
				displayAndClick(driver,flatAccessKey);
				BaseSuite.reportLog("Entering Connection access key In User Name Field");
				sendKeys(driver, flatAccessKey, userName);
			}
			if (!password.isEmpty()) {

				BaseSuite.reportLog("Clicking on Connection secret key Field");
				displayAndClick(driver,flatSecretKey);
				BaseSuite.reportLog("Entering Connection secret key in Field");
				sendKeys(driver, flatSecretKey, password);
			}
			
			if(authentication.equalsIgnoreCase("Custom Credential"))
			{
				BaseSuite.reportLog("Clicking on Connection session token Field");
				displayAndClick(driver,flatSessionToken);
				BaseSuite.reportLog("Entering Connection session token in Field");
				sendKeys(driver, flatSessionToken, password);
			}		
			if(enableCache.contains("Yes"))
			{
				displayAndClick(driver,enableCacheBtn);	
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				if(!selectcacheName.isEmpty())
				{
					selectDropdownCacheConn(selectcacheName);
				}
				else
				{
					BaseSuite.validationReportLog("Cache connection not selected");
				}
			}
		}
	
	public void clickOnSaveBtn()
	{
		
		isClickable(driver,saveBtn , "Save Button", false);
		isDisplayedInLoop(driver,10, saveBtn);
		displayAndClick(driver,saveBtn);
		
	}
	public void TestConnection(WebDriver driver, SoftAssert soft,String connectionTestMess, String connectionStatus) throws Exception
	{
		try {
			if(connectionStatus.equalsIgnoreCase("Yes"))
			{					
				if(isClickable(driver, testBtn, "Test Button", true))
				{
					displayAndClick(driver,testBtn);
					
					String TestConnection = getText(driver, Commontoastmsg).trim();

					waitForElement(driver, PopUpClose);

					displayAndClick(driver, PopUpClose);
					
				    if (TestConnection.equalsIgnoreCase(connectionTestMess)) {
				       BaseSuite.validationReportLog("Connection tested successfully");
				       BaseSuite.validationReportLog("Retrived Message for " + "test connection" + " is :" + TestConnection);
				       BaseSuite.validationReportLog("Expected Message for " + "test connection" + " is :" + connectionTestMess.trim());
				       
				    } else {
				    	BaseSuite.reportFailLog("Connection not tested and error message is ", "TestConnection :" + TestConnection);
				    }								
				}
			}			
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	
	public void TestInvalidConnection(WebDriver driver, SoftAssert soft,String connectionTestMess, String connectionStatus) throws Exception
	{
		try {
			if(connectionStatus.equalsIgnoreCase("Yes"))
			{					
				if(isClickable(driver, testBtn, "Test Button", true))
				{
					displayAndClick(driver,testBtn);
					
					String TestConnection = getText(driver, Commontoastmsg).trim();

					waitForElement(driver, PopUpClose);

					displayAndClick(driver, PopUpClose);
					
				    if (TestConnection.equalsIgnoreCase(connectionTestMess)) {
				       BaseSuite.reportFailLog("Invalid connection getting tested", "TestInvalidConnection");				      
				       
				    } else {
				    	BaseSuite.validationReportLog("Invalid connection not getting tested");
				    	
				    }								
				}
			}			
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	public void selectWorkspaceInNewConn(String selectWorkspace) throws Exception
	{	
		try
		{		
		wait = waitMethod(driver);
		isDisplayedInLoop(driver, 30, selectWorspaceDrop);
		BaseSuite.reportLog("Selecting existing workspace");		
		displayAndClick(driver,selectWorspaceDrop);	
		Thread.sleep(1000);
		sendKeys(driver,addWorkspace,selectWorkspace);	
		//displayAndClick(driver, returnElement(dropDownClick, "$dropDownName", selectWorkspace));
		Thread.sleep(1000);	
		WebElement element = driver.findElement(selectWorspaceDrop);
		element.sendKeys(Keys.ENTER);
		BaseSuite.reportLog("Verifying entered workspace name is available in the list or not");
		String workName = driver.findElement(addWorkspace).getAttribute("aria-label");
		if(!workName.isEmpty())
		{
			BaseSuite.validationReportLog("Workspace name is available in the list and selected successfully");
		}
		else
		{
			BaseSuite.reportFailLog("Workspace name is not available or workspace not selected", "selectWorkspaceInNewRule");
		}
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
		}
	
	public void selectDrowdownLocation(String Location) throws Exception
	{		
		BaseSuite.reportLog("Clicking on the location dropdown");
		 isDisplayedInLoop(driver,30,selectLocation);			
		 click(driver,selectLocation);
		 Thread.sleep(1000);
	     BaseSuite.reportLog("Selecting the value from dropdown");
	     sendKeys(driver, addLocation, Location);
	     BaseSuite.reportLog("Verifying entered location type is available in the list or not");
	     String locationName = driver.findElement(addLocation).getAttribute("aria-label");
			if(!locationName.isEmpty())
			{
				BaseSuite.validationReportLog("Location name is available in the list and selected successfully and Selected location is :" + Location);
			}
			else
			{
				BaseSuite.reportFailLog("Location name is not available or Location not selected", "selectDrowdownLocation");
			}	    
	}
	
	public void selectDrowdownAuthentication(String Auth) throws Exception
	{		
		 BaseSuite.reportLog("Clicking on the Authentication dropdown");
		 isDisplayedInLoop(driver,30,selectAuthentication);			
		 click(driver,selectAuthentication);
		 Thread.sleep(1000);
	     BaseSuite.reportLog("Selecting the value from dropdown");
	     sendKeys(driver, addAuthentication, Auth);	  
	     BaseSuite.reportLog("Verifying entered authentication type is available in the list or not");
	     String authnName = driver.findElement(addAuthentication).getAttribute("aria-label");
			if(!authnName.isEmpty())
			{
				BaseSuite.validationReportLog("Authentication name is available in the list and selected successfully and Selected Authentication type is :" + authnName);
			}
			else
			{
				BaseSuite.reportFailLog("Authentication type is not available or Authentication type not selected", "selectDrowdownAuthentication");
			}	    		
	}
	
	public void selectDrowdownType(String type) throws Exception
	{		
		 BaseSuite.reportLog("Clicking on the Type dropdown");
		 isDisplayedInLoop(driver,30,selectType);			
		 click(driver,selectType);
		 Thread.sleep(1000);
	     BaseSuite.reportLog("Selecting the value from dropdown");
	     sendKeys(driver, addType, type);	
	     BaseSuite.reportLog("Verifying entered type is available in the list or not");
		String typeName = driver.findElement(addType).getAttribute("aria-label");
			if(!typeName.isEmpty())
			{
				BaseSuite.validationReportLog("Type name is available in the list and selected successfully and Selected type is :"  + type);
			}
			else
			{
				BaseSuite.reportFailLog("Type name is not available or type not selected", "selectDrowdownType");
			}	    		
	}
	
	public void selectDropdownCacheConn(String cacheConn) throws Exception
	{		
		 BaseSuite.reportLog("Clicking on the Type dropdown");
		 isDisplayedInLoop(driver,30,selectCacheConn);			
		 click(driver,selectCacheConn);
		 Thread.sleep(1000);
	     BaseSuite.reportLog("Selecting the value from dropdown");
	     sendKeys(driver, addCacheConnection, cacheConn);	    
	     BaseSuite.validationReportLog("Selected type is : " + cacheConn);				
	}	
	public void clickOnAddPropertyBtn()
	{
		BaseSuite.reportLog("Verifying add property button is enabled or not");
		boolean add = driver.findElement(addPropertyBtn).isEnabled();
		if(add)
		{
			BaseSuite.validationReportLog("Property add button is enabled and clickable");
			displayAndClick(driver,addPropertyBtn);
			BaseSuite.validationReportLog("Property add button clicked successfully");
		}
		else
		{
			BaseSuite.reportFailLog("Property button is not enabled", "clickOnAddPropertyBtn");
		}
	}
	public void clickOnRemovePropBtn()
	{
		isDisplayedInLoop(driver,10,removePropertyBtn);
		displayAndClick(driver,removePropertyBtn);
	}
		
	public void labelsAndButtonsOnFlatFileConnPage()
	{
		try
		{
			validateButtons(driver, noOfButtons, 6);
			verifyIndividualLabel(driver, workspaceLabel, "Workspace");
			verifyIndividualLabel(driver, nameLabel, "Name");
			verifyIndividualLabel(driver, locationLabel, "Location");
			verifyIndividualLabel(driver, filePathLabel, "File Path");
			verifyIndividualLabel(driver, regionLabel, "Region");
			verifyIndividualLabel(driver, typeLabel, "Type");
			verifyIndividualLabel(driver, accessKeyLabel, "Access Key");
			verifyIndividualLabel(driver, secretKeyLabel, "Secret Key");
			verifyIndividualLabel(driver, connPropLabel, "Connection Properties");
			verifyIndividualLabel(driver, propnameLabel, "Name");
			verifyIndividualLabel(driver, propvalueLabel, "Value");
			verifyIndividualLabel(driver, propTypeLabel, "Type");
			
			verifyVisibilityOfButtons(driver, disableBtn, "Disable Button", false);			
			isClickable(driver, disableBtn, "Disable Button", false);
			verifyVisibilityOfButtons(driver, testBtn, "Test Button", false);			
			isClickable(driver, testBtn, "Test Button", false);
			verifyVisibilityOfButtons(driver, saveBtn, "Save Button", false);			
			isClickable(driver, saveBtn, "Save Button", false);
			verifyVisibilityOfButtons(driver, discardBtn, "Discard Button", false);			
			isClickable(driver, discardBtn, "Discard Button", false);
			verifyVisibilityOfButtons(driver, enableCacheBtn, "Enable Cache Button", true);			
			isClickable(driver, enableCacheBtn, "Enable Cache Button", true);
			verifyVisibilityOfButtons(driver, addPropertyBtn, "Add property Button", true);			
			isClickable(driver, addPropertyBtn, "Add Property Button", true);
			verifyVisibilityOfButtons(driver, removePropertyBtn, "Remove property Button", false);			
			isClickable(driver, removePropertyBtn, "Remove Property Button", false);
		}
		 catch (Exception ex) {
				throw new AssertionError("Error occured in this method", ex);
			}
	}
	
	public void selectWorspaceDropdownFunction(String selectWorkspace)
	{
	try
	{
		BaseSuite.reportLog("Verify select workspace dropdown is enabled and clickable");
		isDisplayedInLoop(driver,10,selectWorspaceDrop);
		if(isEnabled(driver,selectWorspaceDrop) && isClickable(driver,selectWorspaceDrop,"Dropdown field",true))
		{
			BaseSuite.validationReportLog("Select workspace dropdown field is enabled and clickable now user can select the workspace from the list");
			BaseSuite.reportLog("Selecting workspace from the dropdown list");
			selectWorkspaceInNewConn(selectWorkspace);
			BaseSuite.validationReportLog("Workspace selected successfully and name of selected workspace is :" + selectWorkspace);
		}	
		else
		{
			BaseSuite.reportFailLog("Workspace dropdown field is not enabled or not clickable", "selectWorspaceDropdown");
		}
	}
	 catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
	public void selectTypeDropdownFunction(String type)
	{
	try
	{
		BaseSuite.reportLog("Verify select type dropdown is enabled and clickable");
		isDisplayedInLoop(driver,10,selectType);
		if(isEnabled(driver,selectType) && isClickable(driver,selectType,"Dropdown field",true))
		{
			BaseSuite.validationReportLog("Select type dropdown field is enabled and clickable now user can select the type from the list");
			BaseSuite.reportLog("Selecting type from the dropdown list");
			selectDrowdownType( type);
			BaseSuite.validationReportLog("Type selected successfully and name of selected type is :" + type);
		}	
		else
		{
			BaseSuite.reportFailLog("Type dropdown field is not enabled or not clickable", "selectTypeDropdown");
		}
	}
	 catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	public void selectLocationDropdownFunction(String location)
	{
		try
		{
		BaseSuite.reportLog("Verify select location dropdown is enabled and clickable");
		isDisplayedInLoop(driver,10,selectLocation);
		if(isEnabled(driver,selectLocation) && isClickable(driver,selectLocation,"Dropdown field",true))
		{
			BaseSuite.validationReportLog("Select location dropdown field is enabled and clickable now user can select the location from the list");
			BaseSuite.reportLog("Selecting type from the dropdown list");
			selectDrowdownLocation(location);
			BaseSuite.validationReportLog("Location selected successfully and name of selected location is :" + location);
		}
		else
		{
			BaseSuite.reportFailLog("Location dropdown field is not enabled or not clickable", "selectLocationDropdown");
		}
	}
	 catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
	public void selectAuthenticationDropdownFunction(String authentication)
	{
		try
		{
		BaseSuite.reportLog("Verify select authentication dropdown is enabled and clickable");
		isDisplayedInLoop(driver,10,selectAuthentication);
		if(isEnabled(driver,selectAuthentication) && isClickable(driver,selectAuthentication,"Dropdown field",true))
		{
			BaseSuite.validationReportLog("Select authentication dropdown field is enabled and clickable now user can select the authentication type from the list");
			BaseSuite.reportLog("Selecting authenticatin type from the dropdown list");
			selectDrowdownAuthentication(authentication);
			BaseSuite.validationReportLog("Authentication type selected successfully and name of selected authentication type is :" + authentication);
		}
		else
		{
			BaseSuite.reportFailLog("Authentication dropdown field is not enabled or not clickable", "selectAuthenticationDropdown");
		}
	}
	 catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
	public void discardBtnFunctionWithDetails()
	{
		try
		{			 
			 BaseSuite.reportLog("Verifying discard button is enabled or disabled after entering the details");
			 verifyVisibilityOfButtons(driver, discardBtn, "Discard Button", true);			
			 if(isClickable(driver, discardBtn, "Discard Button", true))
			 {
				 BaseSuite.reportLog("Clicking on the discard button");
				 displayAndClick(driver,discardBtn);
				 if(isDisplayed(driver,connDiscardTitle))
				 {
					 BaseSuite.validationReportLog("Discard button clicked successfully and discard popup window opened successfully");
					 String title = driver.findElement(connDiscardTitle).getText();
					 getAllLinkAndVerifyLinkText(driver,connDiscardTitle, "Discard Changes");
					 BaseSuite.validationReportLog("Title of popup window is :" + title);
					 String msg = driver.findElement(msgOnDiscardWin).getText();
					 getAllLinkAndVerifyLinkText(driver,msgOnDiscardWin, "You want to discard the changes?");
					 BaseSuite.validationReportLog("Message on discard popup window is :" + msg);
					 verifyVisibilityOfButtons(driver, connDiscardYesBtn, "Discard Yes Button", true);	
					 verifyVisibilityOfButtons(driver, connDiscardNoBtn, "Discard No Button", true);	
					 boolean flag = isClickable(driver, connDiscardYesBtn, "Discard Yes Button", true);
					 if(flag)
					 {
						 BaseSuite.reportLog("Clicking on the discard yes button"); 
						 displayAndClick(driver,connDiscardYesBtn);
						 inVisible(driver, connectionPageSpinner, Constant.ruleWait);
						 if(isDisplayed(driver,clickonNewConnection))
						 {
							 BaseSuite.validationReportLog("Clicked suceesfully on discard yes button and user redirected on the connection landing page");
						 }
						 else
						 {
							 BaseSuite.reportFailLog("Discard yes button not clicked or user not redirected on the connection landing page", "discardBtnFunctionWith");
						 }
					 }
					 else
					 {
						 BaseSuite.reportFailLog("Discard yes button is not visible or not enabled to perfor click", "discardBtnFunctionWith");
					 }
				 }
			 }
			 
		}
		catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
	public void disableBtnFuncWithoutSaveConnection(String searchWorkspaceName, String connName,String filePath)
	{
		try
		{
			selectWorspaceDropdownFunction(searchWorkspaceName);
			BaseSuite.reportLog("Enter some details in connection field to check save button and disable button enabled or not");
			clear_Click_SendKeys(driver, 10, clickonNewConnection, connName.trim());
			clear_Click_SendKeys(driver, 10, clickOnFilePath, filePath.trim());
			BaseSuite.reportLog("Verify Save button enabled or not");			
			verifyVisibilityOfButtons(driver, saveBtn, "Save Button", true);			
			isClickable(driver, saveBtn, "Save Button", true);
			BaseSuite.reportLog("Verify disable button is enabled or not without perform click on the save button");
			verifyVisibilityOfButtons(driver, disableBtn, "Disable Button", false);			
			isClickable(driver, disableBtn, "Disable Button", false);
		}
		catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
	public void discardPopUpAlertWindow()
	{
		try
		{
			BaseSuite.reportLog("Verifying discard pop up window");
			discardBtnFunctionWithDetails();
		}
		catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
	public void disabledBtnFuncWithoutConnDetails()
	{
		try
		{
			BaseSuite.reportLog("Verifying disable button is disabled or enabled without entering any connection details");
			verifyVisibilityOfButtons(driver, disableBtn, "Disable Button", false);			
			isClickable(driver, disableBtn, "Disable Button", false);
			if(!isEnabled(driver,disableBtn))
			{
				BaseSuite.validationReportLog("Disable button is not enabled without entering any details");
			}
			else
			{
				BaseSuite.reportFailLog("Disable button is enabled without entering any connection details on page", "disabledBtnFuncWithoutConnDetails");
			}
		}
		catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	public void discardBtnFuncWithoutConnDetails()
	{
		try
		{
			BaseSuite.reportLog("Verifying discard button is disabled or enabled without entering any connection details");
			verifyVisibilityOfButtons(driver, discardBtn, "Discard Button", false);			
			isClickable(driver, discardBtn, "Discard Button", false);
			if(!isEnabled(driver,discardBtn))
			{
				BaseSuite.validationReportLog("Discard button is not enabled without entering any details");
			}
			else
			{
				BaseSuite.reportFailLog("Discard button is enabled without entering any connection details on page", "discardBtnFuncWithoutConnDetails");
			}
		}
		catch (Exception ex) {
			throw new AssertionError("Error occured in this method", ex);
		}
	}
	
}
