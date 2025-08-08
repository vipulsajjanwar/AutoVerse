package nexgen.automation.framework.connectionRepo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;

//import nexgen.automation.pageclasses.pages.LoginPage;
//import views.html.ac.aui.message;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class ConnectionUtil extends PageUtil {

	public WebDriver driver;

	public ConnectionUtil(WebDriver driver) {

		this.driver = driver;
	}
	//protected NewConnections connectiontab = new NewConnections(driver);
	
	protected By Mysqlconnection = getElementLocator(prop.getProperty("ConnectionB.Mysql"));
	protected By Oracleconnection=getElementLocator(prop.getProperty("ConnectionB.Oracle"));
	protected By Postgresconnection = getElementLocator(prop.getProperty("ConnectionB.Postgres"));
	protected By Teradataconnection = getElementLocator(prop.getProperty("ConnectionB.Teradata"));
	protected By Netezzaconnection = getElementLocator(prop.getProperty("ConnectionB.Netezza"));
	protected By Sybaseconnection = getElementLocator(prop.getProperty("ConnectionB.Sybase"));
	protected By Redshiftconnection = getElementLocator(prop.getProperty("ConnectionB.Redshift"));
	protected By Greenplumconnection = getElementLocator(prop.getProperty("ConnectionB.Greenplum"));
	protected By HPVerticaconnection = getElementLocator(prop.getProperty("ConnectionB.HPVertica"));
	protected By DB2connection = getElementLocator(prop.getProperty("ConnectionB.DB2"));
	protected By ConnectionName=getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	protected By selectWorkspace=getElementLocator(prop.getProperty("ConnectionB.Selectworkspace"));
	By selectDriver=getElementLocator(prop.getProperty("ConnectionB.Selectdriver"));
	protected By clickonNewConnectionButton = getElementLocator(prop.getProperty("Connection.newConnection"));
	By clickonConnectionMenu = getElementLocator(prop.getProperty("Connection.connections"));
	protected By selectworkspace = getElementLocator(prop.getProperty("ConnectionB.SearchWorkspace"));
	String clickonSearchWorkspace = prop.getProperty("ConnectionB.ClickonWorkspace");
	protected By connectionHost = getElementLocator(prop.getProperty("ConnectionB.ClickonConnectionHost"));
	protected By connectionPort = getElementLocator(prop.getProperty("ConnectionB.ClickonConnectionPort"));
	protected By connectionDBName = getElementLocator(prop.getProperty("ConnectionB.ClickonDatabase"));
	protected By connectionFullUrl = getElementLocator(prop.getProperty("ConnectionB.EnterFullUrl"));
	By connectionTypeUser = getElementLocator(prop.getProperty("ConnectionB.SelectType"));
	protected By connectionUsername = getElementLocator(prop.getProperty("ConnectionB.EnterUsername"));
	protected By connectionPassword = getElementLocator(prop.getProperty("ConnectionB.EnterPassword"));
	protected By clickonToggleButton = getElementLocator(prop.getProperty("ConnectionB.ClickonToggleButton"));
	protected By connectionTestButton = getElementLocator(prop.getProperty("ConnectionB.ClickTestButton"));
	String successToastMsg = prop.getProperty("ConnectionB.TestconnectionToast");	
	protected By testToastmsg= getElementLocator(prop.getProperty("ConnectionB.TestconnectionToast"));
	protected By connectionSaveButton= getElementLocator(prop.getProperty("ConnectionB.SaveButton"));
	By saveToastmsg = getElementLocator(prop.getProperty("ConnectionB.SaveConnection"));
	By dropdownIconClick = getElementLocator(prop.getProperty("ConnectionB.DropdownIconClick"));
	By selectUserType = getElementLocator(prop.getProperty("ConnectionB.UserType"));
	By clickOnDiscardButton = getElementLocator(prop.getProperty("ConnectionB.DiscardConnection"));
	 By searchBar = getElementLocator(prop.getProperty("Connection.SearchBox"));
	 By searchBclick = getElementLocator(prop.getProperty("Connection.SearchButton"));
	 String clickonSearchConnection = prop.getProperty("Connection.SearchConnection");
	By duplicateConnectionMess = getElementLocator(prop.getProperty("ConnectionB.DuplicateConnectionMess"));
	
	//Mandatory Label
	protected By workspaceLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.WorkspaceLabel"));
	protected By connectionLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.ConnectionLabel"));
	protected By driverLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.DriverLable"));
	protected By authenticationLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.AuthenticationLabel"));
	protected By customJDBCLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.CustomJdbcLable"));
	protected By hostLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.HostLable"));
	protected By portLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PortLable"));
	protected By databaseLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.DatabaseLable"));
	protected By typeLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.TypeLable"));
	protected By usernameLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.UsernameLabel"));
	protected By passwordLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PasswordLabel"));
	protected By connPropertyNameLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PropertyNameLabel"));
	protected By connPropertyValueLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PropertyValueLabel"));
	protected By connPropertyTypeLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PropertyTypeLabel"));
	protected By connectionNameErrorMsg = getElementLocator(prop.getProperty("flatErrorMsgRed"));
	String connErrorMessage = prop.getProperty("ConnectionB.Mandatory.ConnErrorMsg");
	String connNameMandateErrorMsg=prop.getProperty("connNameMandateErrorMsg");
	String emptyHostMsg=prop.getProperty("emptyHostMsg");
	String emptyPortMsg=prop.getProperty("emptyPortMsg");
	String emptyDatabaseMsg=prop.getProperty("emptyDatabaseMsg");
	String emptyUserNameMsg=prop.getProperty("emptyUserNameMsg");
	String emptyPasswordMsg=prop.getProperty("emptyPasswordMsg");
	public String connectionTestMess=prop.getProperty("connectionTestMess");
	By addPropertyBtn=getElementLocator(prop.getProperty("addPropertyBtn"));
	By removePropertyBtn=getElementLocator(prop.getProperty("removePropertyBtn"));	
	By flatConnPropName=getElementLocator(prop.getProperty("flatConnPropName"));
	By flatConnPropValue=getElementLocator(prop.getProperty("flatConnPropValue"));
	By selectConnPropType=getElementLocator(prop.getProperty("selectConnPropType"));
	By enterConnPropType=getElementLocator(prop.getProperty("enterConnPropType"));
	By selectAllPropCheckbox=getElementLocator(prop.getProperty("selectAllPropCheckbox"));
	By isSelectedAllPropCheckbox=getElementLocator(prop.getProperty("isSelectedAllPropCheckbox"));
	By selectSinglePropCheckbox=getElementLocator(prop.getProperty("selectSinglePropCheckbox"));
	By isSelectedSingleCheckbox=getElementLocator(prop.getProperty("isSelectedSingleCheckbox"));
	By flatErrorMsgRed=getElementLocator(prop.getProperty("flatErrorMsgRed"));
	By popUpClose=getElementLocator( prop.getProperty("PopUpClose"));	
	By Commontoastmsg=getElementLocator(prop.getProperty("Commontoastmsg"));
	By selectType=getElementLocator(prop.getProperty("selectType"));
	By addType=getElementLocator(prop.getProperty("addType"));
	By connTestBtn=getElementLocator(prop.getProperty("connTestBtn"));
	By selectWorspaceDrop=getElementLocator(prop.getProperty("selectWorspaceDrop"));
	By addWorkspace=getElementLocator(prop.getProperty("addWorkspace"));
	By connectionPageSpinner=getElementLocator(prop.getProperty("connectionPageSpinner"));
	By connSaveBtn=getElementLocator(prop.getProperty("connSaveBtn"));
	
	public void clickSelectedConnections(By locator, String connectionName) throws Exception {
		//click(driver, locator);
		isDisplayedInLoop(driver, 40, locator);
		javascript(driver, "arguments[0].click();", locator);
		BaseSuite.reportLog("Clicked On " + connectionName + " Connection");
	}
	
	public void ClickonConnectionsMenu() throws Exception 
	{
		isDisplayedInLoop(driver ,40 , clickonConnectionMenu);
		//click(driver,clickonConnectionMenu);
		javascript(driver, "arguments[0].click();", clickonConnectionMenu);
	}
	
	public void displayAndClick(By locator) {

		try {
		
			isDisplayedInLoop(driver, 60, locator);
			//click(driver, locator);
			javascript(driver, "arguments[0].click();", locator);
		} catch (Exception e) {

			e.getMessage();
		}
	}
	
	
	
	public void selectDriverName(String DriverName)
	{
		switch(DriverName)
		{
		case "Cassendra Native":
			selectByVisibleText(driver,selectDriver ,"Cassendra Native");
			break;
			default:
			break;
		}
	}
	
	public void SearchConnection(String connectionName) throws Exception
	{		
			isDisplayed(driver, clickonConnectionMenu);
			click(driver, clickonConnectionMenu);			
			BaseSuite.reportLog("Searching for Connection:" + connectionName);
			isDisplayedInLoop(driver, 10, searchBar);
			Thread.sleep(3000);
			click(driver, searchBar);
			clear(driver, searchBar);
			isDisplayedInLoop(driver, 4, searchBar);
			BaseSuite.reportLog("Search Connection");
			sendKeys(driver, searchBar, connectionName);
			BaseSuite.reportLog("Click On searched");
			isDisplayedInLoop(driver, 3, searchBclick);
			click(driver, searchBclick);
			try {
				isDisplayedInLoop(driver, 4, searchBclick);
				BaseSuite.reportLog("Click on Searched User");
				click(driver, returnElement(clickonSearchConnection, "$Connection", connectionName));
				BaseSuite.reportLog("Clicked on connection: " + connectionName);
				BaseSuite.reportLog("Connection Details retrieved successfully for connection " + connectionName);
			} catch (Exception e) {
				throw new Exception("Connection_search " + searchBclick + " not found");
			}
		}
	
		/*
		 * public void captureToastMsg(WebDriver driver, By locator1, By locator2,
		 * String mess, String label) throws Exception { SoftAssert soft = new
		 * SoftAssert(); try { BaseSuite.reportLog("Verifying " + label + " Message");
		 * 
		 * String validMess = getText(driver, locator1).trim();
		 * 
		 * waitForElement(driver, locator2);
		 * 
		 * displayAndClick(driver, locator2);
		 * 
		 * BaseSuite.validationReportLog("Retrived Message for " + label + " is :" +
		 * validMess); BaseSuite.validationReportLog("Expected Message for " + label +
		 * " is :" + mess.trim());
		 * 
		 * if (!validMess.isEmpty() && validMess.equalsIgnoreCase(mess.trim())) {
		 * 
		 * soft.assertEquals(validMess, mess.trim());
		 * 
		 * BaseSuite.validationReportLog(label + " Message Successfully Matched"); }
		 * else { BaseSuite.reportFailLog(label + " Messages didn't match",
		 * "captureToastMsg"); } } catch (Exception e) { throw new Exception(); } }
		 */
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
	
		public void selectDropdownType(String type) throws Exception
		{		
			 BaseSuite.reportLog("Clicking on the Type dropdown");
			 isDisplayedInLoop(driver,30,selectType);	
			 BaseSuite.reportLog("Verifying System type is already selected or not and available in the list or not");
			 String typeName = driver.findElement(addType).getAttribute("aria-label");			
			 if(!typeName.isEmpty()&&typeName.equalsIgnoreCase(type))
				{
				 BaseSuite.validationReportLog( typeName + "Type name is already selected and available in the list and selected successfully" );
				}
			 else 
			 {
				 displayAndClick(driver,selectType);
				 Thread.sleep(1000);
			     BaseSuite.reportLog("Selecting the value from dropdown");
			     BaseSuite.validationReportLog("Selecting connection type in type field is :" + type);
			     sendKeys(driver, addType, type);	
			     BaseSuite.validationReportLog("Entered connection type selected successfully :" + type);
			 }						
		}
		public void testConnection(WebDriver driver, SoftAssert soft,String connectionTestMess, String connectionStatus) throws Exception
		{
			try {
				if(connectionStatus.equalsIgnoreCase("Yes"))
				{					
					if(isEnabled(driver,connTestBtn))
					{
						displayAndClick(driver,connTestBtn);
						inVisible(driver, connectionPageSpinner, Constant.ruleWait);
						waitForElement(driver, popUpClose);
						String TestConnection = getText(driver, Commontoastmsg).trim();						
						displayAndClick(driver, popUpClose);						
					    if (TestConnection.equalsIgnoreCase(connectionTestMess)) {
					       BaseSuite.validationReportLog("Connection tested successfully");
					       BaseSuite.validationReportLog("Retrived Message for " + "test connection" + " is :" + TestConnection);
							BaseSuite.validationReportLog("Expected Message for " + "test connection" + " is :" + connectionTestMess.trim());					       
					    } else {
					    	BaseSuite.reportFailLog(TestConnection + ": Connection not tested and error message displayed successfully :","testConnection " );
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
					if(isClickable(driver, connTestBtn, "Test Button", true))
					{
						displayAndClick(driver,connTestBtn);
						
						String TestConnection = getText(driver, Commontoastmsg).trim();

						waitForElement(driver, popUpClose);

						displayAndClick(driver, popUpClose);
						
					    if (TestConnection.equalsIgnoreCase(connectionTestMess)) {
					       BaseSuite.reportFailLog("Invalid connection getting tested", "TestInvalidConnection"); 
					   }					    
					    else {
					    	BaseSuite.validationReportLog("Invalid connection not getting tested");					    	
					    }								
					}
				}	
				else
				{
					BaseSuite.validationReportLog("Test button is not enabled or not clickable");
				}
			}
			catch(Exception ex)
			{
				throw new Exception();
			}
		}
		
		public void mandatoryField(SoftAssert soft,String SpecialChar,String connectionName,String host,String port,String serviceDBName,String fullUrl,
				String userName,String password,String connProp,String connType,String connectionTestMess,String portdata,String connectionStatus,String selectWorkspace) throws Exception
		{	
			try
			{
			verifyIndividualLabel(driver, workspaceLabel, "Workspace");
			verifyIndividualLabel(driver, connectionLabel, "Name");				
			verifyIndividualLabel(driver, driverLabel, "Driver");				
			verifyIndividualLabel(driver, authenticationLabel, "Authentication");	
			verifyIndividualLabel(driver, customJDBCLabel, "Custom JDBC URL");		
			verifyIndividualLabel(driver, hostLabel, "Host");		
			verifyIndividualLabel(driver, portLabel, "Port");			
			verifyIndividualLabel(driver, databaseLabel, "Database");		
			verifyIndividualLabel(driver, typeLabel, "Type");		
			verifyIndividualLabel(driver, usernameLabel, "Username");				
			verifyIndividualLabel(driver, passwordLabel, "Password");				
			verifyIndividualLabel(driver, connPropertyNameLabel, "Connection Name");
			verifyIndividualLabel(driver, connPropertyValueLabel, "Connection Value");
			verifyIndividualLabel(driver, connPropertyTypeLabel, "Connection Type");
			if(!selectWorkspace.isEmpty())
			{
				selectWorkspaceInNewConn(selectWorkspace);		
				}
			else
			{
				BaseSuite.validationReportLog("Workspace name is empty");
				BaseSuite.reportLog("Verify save and test button are disabled or not without selection of workspace name");
				isClickable(driver, connTestBtn, "Test Button", false);
				isClickable(driver, connSaveBtn, "Save Button", false);
			}
			if (!connectionName.isEmpty())
				{
				if (SpecialChar.equalsIgnoreCase("Yes")) {
					BaseSuite.reportLog("Clicking on connection name ");
					displayAndClick(ConnectionName);
					BaseSuite.reportLog("Entering Connection Name In Connection Name Field");
					clear(driver,ConnectionName);
					sendKeys(driver, ConnectionName, connectionName);
					BaseSuite.validationReportLog("Connection name entered successfully :" + connectionName);
					BaseSuite.reportLog("Check Error message with invalid Connection name ");
					String specialCharMsg = getText(driver, connectionNameErrorMsg).trim();
					BaseSuite.validationReportLog("Mandatory error msg displayed for special character and error is : " + specialCharMsg);
					soft.assertEquals(specialCharMsg, connErrorMessage,"Failed at to connection name field error message");
				}				
				else {
					BaseSuite.reportLog("Clicking on connection name ");
					displayAndClick(ConnectionName);
					BaseSuite.reportLog("Entering Connection Name In Connection Name Field");
					clear_Click_SendKeys(driver,2, ConnectionName, connectionName);
					BaseSuite.reportLog("Connection Name entered successfully :" + connectionName);
				}
			}
			else
			{
				displayAndClick(driver,ConnectionName);
				clear(driver,ConnectionName);
				sendKeys(driver, ConnectionName, "Test");
				clear(driver,ConnectionName);
				String nameMandateMsg = getText(driver, flatErrorMsgRed).trim();
				BaseSuite.validationReportLog("Mandatory error msg displayed for empty connection name and error is : " + nameMandateMsg);
				soft.assertEquals(nameMandateMsg, connNameMandateErrorMsg);				
			}
			if (!fullUrl.isEmpty()) {
				if (isEnabled(driver,clickonToggleButton))
				{	
					displayAndClick(driver, clickonToggleButton);
					if(isEnabled(driver,connectionFullUrl))
					{					
					Thread.sleep(1000);					
					isDisplayed(driver, connectionFullUrl);					
					BaseSuite.reportLog("Entering Connection Full Url In Full Url Field");
					clear_Click_SendKeys(driver, 5, connectionFullUrl, fullUrl);
					BaseSuite.validationReportLog("Connection full url entered successfully :" + fullUrl);
					BaseSuite.reportLog("Verify after clicking on custom JDBC URL toggel button host, port and database field should get disabled or not");
					isClickable(driver, connectionHost, "Host Field", false);
					isClickable(driver, connectionPort, "Port Field", false);
					isClickable(driver, connectionDBName, "Database Field", false);
					}
					else
					{
						BaseSuite.reportFailLog("Full url text area box is disabled", "mandatoryField");
					}
				}
				else {
					BaseSuite.reportFailLog("Custom JDBC url toggle button is disabled","mandatoryField");
				}
			}			
			if (!host.isEmpty()&& isEnabled(driver,connectionHost)) {
				BaseSuite.reportLog("Clicking on Connection Host Field");
				displayAndClick(connectionHost);
				BaseSuite.reportLog("Entering Connection Host In Host Field");
				clear_Click_SendKeys(driver,2, connectionHost, host);
				BaseSuite.validationReportLog("Connection host name entered successfully :" + host);
			}
				else
				{
					BaseSuite.validationReportLog("Host name field details are not available or field is disabled");										
				}
			
			if (!port.isEmpty()&&isEnabled(driver,connectionPort))
			{				
					BaseSuite.reportLog("Clicking on Connection Port Field");
					displayAndClick(connectionPort);
					BaseSuite.reportLog("Entering Connection Port In Port Field");
					clear_Click_SendKeys(driver,2, connectionPort, port);
					BaseSuite.validationReportLog("Portdata detais enter successfully:" + port);
			}
			else
				{
				BaseSuite.validationReportLog("Port name field details are not available or field is disabled");						
				}			
			if (!serviceDBName.isEmpty()&&isEnabled(driver,connectionDBName)) {
				BaseSuite.reportLog("Clicking on Connection DB Field");
				displayAndClick(connectionDBName);
				BaseSuite.reportLog("Entering Connection DB Name In DB Field");
				clear_Click_SendKeys(driver,2, connectionDBName, serviceDBName);
				BaseSuite.validationReportLog("ServiceDatabase detais enter successfully and name of database is :" + serviceDBName);
			}
			else
			{							
				BaseSuite.validationReportLog("Database name field details are not available or field is disabled");				
			}					
				if(connType.equalsIgnoreCase("System"))
				{
					selectDropdownType(connType);			
				}
				else
				{
					selectDropdownType(connType);
				}				
				if (!userName.isEmpty()) {
					BaseSuite.reportLog("Clicking on Connection User Name Field");
					if(isEnabled(driver,connectionUsername))
					{
					displayAndClick(connectionUsername);
					BaseSuite.reportLog("Entering Connection User Name In User Name Field");
					clear_Click_SendKeys(driver,2, connectionUsername, userName);
					BaseSuite.validationReportLog("Username entered successfully and username is :" +userName);
					}
					else
					{
						BaseSuite.reportFailLog("Username field is not enabled or not clickable", "mandatoryField");
					}
				}
					else
					{
						BaseSuite.reportLog("Error msg should be display for empty Username");										
					}
			
				if (!password.isEmpty()) {
					BaseSuite.reportLog("Clicking on Connection Password Field");
					if(isEnabled(driver,connectionUsername))
					{
					displayAndClick(connectionPassword);
					BaseSuite.reportLog("Entering Connection Password In Password Field");
					clear_Click_SendKeys(driver,2, connectionPassword, password);
					BaseSuite.validationReportLog("Password entered successfully");
					}
					else
					{
						BaseSuite.reportFailLog("Password field is not enabled or not clickable", "mandatoryField");
					}
				}
				else
				{
					BaseSuite.reportLog("Error msg should be display for empty Password");						
				}
				
				testConnection(driver, soft,connectionTestMess, connectionStatus);
				driver.navigate().refresh();
				waitForElement(driver, popUpClose);									
				displayAndClick(driver, popUpClose);	
			}
			catch(Exception e)
			{
				throw new AssertionError("Error occured in this method", e);
			}
			}
			
		
		
		public void clickOnAddPropertyBtn() throws Exception
		{
			BaseSuite.reportLog("Verifying add property button is enabled or not");
			boolean add = driver.findElement(addPropertyBtn).isEnabled();
			if(add)
			{
				Thread.sleep(1000);
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
		
		public void addConnProperty(String connName,String connValue, String connType)
		{
			isDisplayedInLoop(driver,10,flatConnPropName);
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement ele = driver.findElement(flatConnPropName);
			jse.executeScript("arguments[0].scrollIntoView();", ele);
			
			BaseSuite.reportLog("Verifying connection property fields are enabled or not");
			if(isEnabled(driver,flatConnPropName)&&isEnabled(driver,flatConnPropValue)&&isEnabled(driver,selectConnPropType))
			{
				BaseSuite.validationReportLog("Connection property name field is enabled and user able to enter details in field");				
				List<WebElement> name = driver.findElements(flatConnPropName);				
				for(int i=0;i<name.size();i++)
				{
					//String[] result = connName.split(",");
					//String conname = result[i];
					String flag = name.get(i).getAttribute("value");
					if(flag.isEmpty())
					{
						name.get(i).click();
						name.get(i).sendKeys(connName);
						//clear_Click_SendKeys(driver,10,flatConnPropName,connName);
						BaseSuite.validationReportLog("Connection property name entered successfully :" + connName);
					}
					else
					{
						BaseSuite.validationReportLog("Connection prop already available");
					}
				}
				List<WebElement> value = driver.findElements(flatConnPropValue);				
				for(int i=0;i<value.size();i++)
				{
					//String[] result = connValue.split(",");
					//String conValue = result[i];
					String flag = value.get(i).getAttribute("value");
					if(flag.isEmpty())
					{
						value.get(i).click();
						value.get(i).sendKeys(connValue);
						//clear_Click_SendKeys(driver,10,flatConnPropValue,connValue);
						BaseSuite.validationReportLog("Connection property value entered successfully :" + connValue);
					}
					else
					{
						BaseSuite.validationReportLog("Connection prop field is not empty");
					}
				}	
				List<WebElement> type = driver.findElements(enterConnPropType);				
				for(int i=0;i<type.size();i++)
				{
					//String[] result = connType.split(",");
					//String conType = result[i];
					String flag = type.get(i).getAttribute("value");
					if(flag.isEmpty())
					{
						displayAndClick(driver,selectConnPropType);
						type.get(i).sendKeys(connType);
						//sendKeys(driver,enterConnPropType,connType);
						BaseSuite.validationReportLog("Connection property type selected successfully :" + connType);
					}
					else
					{
						BaseSuite.validationReportLog("Connection prop field is not empty");
					}
				}		
			}			
			else
			{
				BaseSuite.reportFailLog("Connection property fields are not enabled or not clickable", "addConnProperty");
			}			
		}
		
		public void selectionOfCheckboxes(String typeOfCheckSelection, int number) {
			try {
				BaseSuite.reportLog("Verifying the selection of checkboxes");			
				if (typeOfCheckSelection.equalsIgnoreCase("All")) {
					int count = driver.findElements(selectAllPropCheckbox).size();
					BaseSuite.reportLog("Verifying the all properties select checkbox selected or not");
					boolean test = driver.findElement(isSelectedAllPropCheckbox).isSelected();
					if (!test) {
						BaseSuite.validationReportLog("Property checkbox not selected and the size of all connection select checkbox on page is: "+ count);
						BaseSuite.reportLog("Now clicking on the checkbox to select the all the connections");
						displayAndClick(driver, selectAllPropCheckbox);
						boolean test1 = driver.findElement(isSelectedAllPropCheckbox).isSelected();
						if (test1) {
							BaseSuite.validationReportLog("All the properties checkbox selected successfully");
						} else {
							BaseSuite.reportFailLog("Checkbox not selected", "selectionOfCheckboxes");
						}
					} else {
						BaseSuite.validationReportLog("All properties checkboxes are selected");
					}				
				} else {
					BaseSuite.reportFailLog("Selection of name is empty", "selectionOfCheckboxes");
				}
				if (typeOfCheckSelection.equalsIgnoreCase("Single"))
				{
					Thread.sleep(2000);
					List<WebElement> check = driver.findElements(selectSinglePropCheckbox);
					int count1 = check.size();
					//int i = 1;
					//int j = 1;
					BaseSuite.reportLog("Verifying the single connection select checkbox selected or not");
					BaseSuite.validationReportLog("Initially connection checkbox is not checked and the size of connection list checkbox on page is :" + count1);
					List<WebElement> check1 = driver.findElements(isSelectedSingleCheckbox);
					for (int i = 0; i <= check1.size()-number; i++) {
						boolean test = check1.get(i).isSelected();
						if (!test) {
							BaseSuite.reportLog("Initially property checkbox is not selected");
							BaseSuite.reportLog("Now clicking on the checkbox to select single connections");
							check.get(i).click();
							//i++;
							boolean test1 = check1.get(i).isSelected();
							if (!test1) {
								BaseSuite.validationReportLog(" Single Connnection checkbox selected successfully");
							} else {
								BaseSuite.reportFailLog("Connection not selected", "selectionOfCheckboxes");
							}
						} else {
							BaseSuite.validationReportLog("Connection checkboxes already selected");
						}
					}
				} else {
					BaseSuite.reportFailLog("Selection of name is empty", "selectionOfCheckboxes");
				}
				
			} catch (Exception ex) {
				throw new AssertionError("Error occured in this method", ex);
			}
		}
		
		public void enterConnProperty(String connName,String connValue, String connType)
		{
			try
			{								
				addConnProperty(connName, connValue, connType);
			}
			catch(Exception e)
			{
				throw new AssertionError("Error occured in this method", e);
			}
		}
}		

	


