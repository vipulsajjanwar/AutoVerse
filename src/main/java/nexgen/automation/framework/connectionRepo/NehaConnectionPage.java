package nexgen.automation.framework.connectionRepo;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.python.modules.thread.thread;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class NehaConnectionPage extends PageUtil 
{
	WebDriver driver;
	
	public NehaConnectionPage(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();

	
//Old UI elements********************************************************************************	
	By listOfConnection = getElementLocator(prop.getProperty("conn.connImgElement"));
	
	By testButton=getElementLocator(prop.getProperty("conn.TestBtn"));
	By disableButton=getElementLocator(prop.getProperty("conn.DisableBtn"));
	By addPropButton=getElementLocator(prop.getProperty("conn.AddPropBtn"));
	By removePropButton=getElementLocator(prop.getProperty("conn.RemovePropBtn"));
	
	
	
	By newConn_ToogleSwitch=getElementLocator(prop.getProperty("conn.toogleSWTest"));//conn.toogleSwitch
	By newConn_ToogleSwitch_Yes=getElementLocator(prop.getProperty("conn.toogleSwitchY"));//

	
	

	//connection details page element

		By newConn_ClickConnTile=getElementLocator( prop.getProperty("conn.clickonConnTypeBtn"));
		By connWorkspacedropdown=getElementLocator( prop.getProperty("conn.workspaceDropdown"));	
		By workspaceInput=getElementLocator( prop.getProperty("conn.workspaceSearchInpu"));
		
		
		//need to finish
		
		
		
		
		
		
		
		
		
		public String chooseCol_selectcolchk=prop.getProperty("conn.SelectColNamesChk");
		public String toastmsg_Connretrived=prop.getProperty("conn.connDetailsPageToastMsg");
//*****************************************************************************************************//	
		
		
//-----Element as per new UI of Connection repo.---------------------------------------------------------------------
	
	By connectionNameWb=getElementLocator(prop.getProperty("conn.connectionName"));
	By totalConn = getElementLocator(prop.getProperty("conn.totalConnections"));
	By totalpagesOnlandingPage=getElementLocator( prop.getProperty("conn.totalPagesInpagination"));
	By refreshButton=getElementLocator( prop.getProperty("UConnection.URefresh"));
	By spinnerAfterRefresh=getElementLocator(prop.getProperty("Conn.Spinner.AfterRefresh"));
	By newConn_SaveBtn=getElementLocator(prop.getProperty("conn.newConn.SaveBtn"));
	By newConn_TestBtn=getElementLocator(prop.getProperty("conn.newConn.TestBtn"));
	By newConn_DisableBtn=getElementLocator(prop.getProperty("conn.newConn.DisableBtn"));
	By newConn_ChangeConnectionBtn=getElementLocator(prop.getProperty("conn.newConn.ChangeConnBtn"));
	By newConn_AddPropertyBtn=getElementLocator(prop.getProperty("conn.newConn.AddPropertyBtn"));
	By newConn_RemovePropertyBtn=getElementLocator(prop.getProperty("conn.newConn.RemovePropertyBtn"));
	By listOfBtnOnConnDetailsPg=getElementLocator(prop.getProperty("conn.btnGroup")); // except change connection button
	By newConn_Textboxes=getElementLocator(prop.getProperty("conn.TextBoxes"));
	By newConn_Dropdownlist=getElementLocator(prop.getProperty("conn.Dropdownlist"));
	By newConn_Chk_JDBCUrl=getElementLocator(prop.getProperty("conn.newConn.Chk.CustJDBCUrl"));
	By existingConn_nopropertyMsg=getElementLocator(prop.getProperty("conn.existing.coProp.message"));
	By chooseConnectionType_Spinner=getElementLocator(prop.getProperty("conn.spinner.afterCTypeClicked"));
	By chooseConnectionType_SearchTxt=getElementLocator(prop.getProperty("conn.chooseCtype.searchtxt"));
	By chooseConnectionType_SearchResultele=getElementLocator(prop.getProperty("conn.chooseCtype.afterSearchedCtype"));
	By existingConnRevisit_workspaceTxtbox=getElementLocator(prop.getProperty("conn.existingConn.WorkspacetxtBox"));
	By existingConnRevisit_connName=getElementLocator( prop.getProperty("conn.ConnectionName"));
	By existingConnRevisit_connDriver=getElementLocator( prop.getProperty("conn.driver"));
	By existingConnRevisit_connAuthentication =getElementLocator( prop.getProperty("conn.Authentication"));
	By newConn_Textarea=getElementLocator(prop.getProperty("conn.Textarea"));
	By connHost =getElementLocator( prop.getProperty("conn.host"));
	By connPort =getElementLocator( prop.getProperty("conn.port"));
	By connDatabase =getElementLocator( prop.getProperty("conn.Database"));
	By connectionType =getElementLocator( prop.getProperty("conn.type"));
	By connUsernameinput =getElementLocator( prop.getProperty("conn.username"));
	By conncreatedType=getElementLocator( prop.getProperty("conn.databaseImgBtn"));
	By connHomePage_searchbox=getElementLocator(prop.getProperty("conn.searchtxtbox"));
	By connHomePage_searchbtn=getElementLocator(prop.getProperty("conn.searchIcon"));
	By connHomePage_spinner=getElementLocator(prop.getProperty("conn.SearchSpinner"));
	By toastMsgCon=getElementLocator(prop.getProperty("Commontoastmsg"));
	By popUpClose=getElementLocator( prop.getProperty("PopUpClose"));
	
	
	
	public String connLPage_searchedConn=prop.getProperty("conn.searchResultConn");
	
	//Generic method creation as per page
	

/***************************************************** Generic Method for :: Refresh - after searching list should be refreshed*************************************************/
	public String returnTotalConnection(String strTotalConn,int index,int beginIndex)
	{
		String tempStr;
		String [] temp=strTotalConn.split(" ");
		tempStr=temp[index].substring(beginIndex);
		return tempStr;
		
	}
	

	public void refreshAfterSearchingConnection(String connectionName) throws Exception
{
	int noOfConnBeforeSearch,noOfConnAfterSearch;
	String totalCBefore,totalCAfter;
	//before searching get list of connections available
	List<WebElement> connectionList = getElements(driver, connectionNameWb);
	 noOfConnBeforeSearch = connectionList.size();
	BaseSuite.reportLog("Number of connections available in connection landing page before search are -: "+noOfConnBeforeSearch);
	totalCBefore =getText(driver, totalConn);
	String paginationLable=getText(driver, totalpagesOnlandingPage);
	String totalPages=returnTotalConnection(paginationLable,2,0);
	BaseSuite.reportLog("Total of pages available on connection landing page before search are -: "+totalPages);
	String temp=returnTotalConnection(totalCBefore,0,1);	
	//BaseSuite.reportLog("Total of connections available in connection landing page before search are -: "+temp);
	//Search
	BaseSuite.validationReportLog("Searching for connection :: ");
	ConnectionHome cH= new ConnectionHome(driver);
	cH.searchConnectionFunctionality(connectionName);
	//Click on refresh button
	isDisplayedInLoop(driver, 3, refreshButton);
	displayAndClick(driver, refreshButton);
	inVisible(driver, spinnerAfterRefresh, Constant.ruleWait);
	Thread.sleep(1500);
	BaseSuite.validationReportLog("Searched connection name has been cleared from search textbox.");
	BaseSuite.reportLog("Will check total number of connections available after refresh are:");
	//After search also tget list of connections available check if any new added
	List<WebElement> connectionListAfterRefresh = getElements(driver, connectionNameWb);
	noOfConnAfterSearch=connectionListAfterRefresh.size();
	BaseSuite.reportLog("Number of connections available in connection landing page after search are -: "+noOfConnAfterSearch);
	/*
	 * totalCAfter =getText(driver, totalConn); String
	 * strtemp=returnTotalConnection(totalCAfter,0,1); BaseSuite.
	 * reportLog("Total of connections available in connection landing page after search are -: "
	 * +strtemp);
	 */
}
	
	

	
/***************************************************** Generic Method for ::newConnectiondetails page & validating FieldValidation for DB connections *************************************************/	
//Method to verify UI elements on connection details page before entering any data
public void dbConn_newConnectionDetailedUIPage()throws Exception
{
	
	//Verify count of buttons available on page.
	validateButtons(driver, listOfBtnOnConnDetailsPg, 5);
	//Check visibility of buttons.
	verifyVisibilityOfButtons(driver, newConn_SaveBtn, "Save", false);
	verifyVisibilityOfButtons(driver,newConn_ChangeConnectionBtn , "Change Connection", true);
	verifyVisibilityOfButtons(driver, newConn_TestBtn, "Test", false);
	verifyVisibilityOfButtons(driver, newConn_DisableBtn, "Disable", false);
	verifyVisibilityOfButtons(driver, newConn_AddPropertyBtn, "Add Property", true);
	verifyVisibilityOfButtons(driver, newConn_RemovePropertyBtn, "Remove Property", false);
	//Check count of textboxes available on page
	validateInputFields(driver,newConn_Textboxes, 7);
	//Check visibility of textboxes.
	verify_InputBoxesStatus(newConn_Textboxes, "Textboxes");
	//Check count of dropdowns available on page
	validateInputFields(driver,newConn_Dropdownlist, 3);
	//Check visibility of Dropdown
	verify_InputBoxesStatus(newConn_Dropdownlist,"Dropdown");
	//Check visibility of textarea.
	validateInputFields(driver,newConn_Textarea, 1);
	
	//verifying JDBC url checkbox
	isDisplayedInLoop(driver, 2,newConn_Chk_JDBCUrl);
	BaseSuite.validationReportLog("Custom JDBC Url is displayed on UI.");
	
	boolean s=isEnabled(driver, newConn_Chk_JDBCUrl);
	if(s)
	{
		BaseSuite.reportLog("Custom JDBC url check box is enabled by default.");
	}
	
	String checkStatus=getAttribute(driver, newConn_Chk_JDBCUrl, "aria-checked");
	if(checkStatus.equalsIgnoreCase("false"))
	{
		BaseSuite.validationReportLog("Custom JDBC Url checkbox is unchecked by default.");
	}
	else if(checkStatus.equalsIgnoreCase("true"))
	{
		BaseSuite.reportErrorLog("Custom JDBC Url checkbox is checked by default, kindly check.");
	}
	
	
	
	
}
//Method to verify UI elements on connection details page after saving connection details
public void existingConnectionDetailedUIPage()throws Exception
{
	
	//Verify count of buttons available on page.
	validateButtons(driver, listOfBtnOnConnDetailsPg, 5);
	//Check visibility of buttons.
	verifyVisibilityOfButtons(driver, newConn_SaveBtn, "Save", true);
	verifyVisibilityOfButtons(driver, newConn_TestBtn, "Test", true);
	verifyVisibilityOfButtons(driver, newConn_DisableBtn, "Disable", true);
	verifyVisibilityOfButtons(driver, newConn_AddPropertyBtn, "Add Property", true);
	//check wether properties are added or not.
	String msgLabel=getText(driver, existingConn_nopropertyMsg);
	if(isDisplayed(driver, existingConn_nopropertyMsg))
	{
		verifyVisibilityOfButtons(driver, newConn_RemovePropertyBtn, "Remove Property", false);
	}
	else
	{	
		verifyVisibilityOfButtons(driver, newConn_RemovePropertyBtn, "Remove Property", true);
	}
	//Check count of textboxes available on page
	validateInputFields(driver,newConn_Textboxes, 8);
	//Check visibility of textboxes.
	verify_InputBoxesStatus(newConn_Textboxes, "Textboxes");
	//Check count of dropdowns available on page
	validateInputFields(driver,newConn_Dropdownlist, 5);
	//Check visibility of Dropdown
	verify_InputBoxesStatus(newConn_Dropdownlist,"Dropdown");
	//Check visibility of textarea.
	validateInputFields(driver,newConn_Textarea, 1);

	
}

public void verify_InputBoxesStatus( By locator, String filedName)throws Exception
{
	boolean selection;
	int count=0;
	//Checking for textboxes
	List<WebElement> connTxt = getElements(driver, locator);
	int noOfTxtbox=connTxt.size();
		
	for(int i=0;i<noOfTxtbox;i++)
	{
		selection=connTxt.get(i).isEnabled();
		
		if(selection)
		{
			count++;
		}
		
	}
	
	if(noOfTxtbox==count)
	{
		BaseSuite.validationReportLog("All "+filedName+" available on new connection page are enable by default.");
	}
	else
	{
		BaseSuite.reportFailLog("Some "+filedName+" is not enabled by default,kindly check", "newConnection_UIVerification_Input");
	}
	
	
}

//click on searched  and choose connection type.

public void chooseConnectionType(String connectionName,SoftAssert soft)
{

	try {
		//Search desired connection type
		isDisplayedInLoop(driver, 2, chooseConnectionType_SearchTxt);
		BaseSuite.validationReportLog("Search textbox is displayed on choose connection type page.");
		clear_SendKeys(driver, chooseConnectionType_SearchTxt, connectionName);
		driver.findElement(chooseConnectionType_SearchTxt).sendKeys(Keys.ENTER);
		BaseSuite.reportLog("Enter button clicked successfully, verifying searched record.");
		String connSearched  = getAttribute(driver, chooseConnectionType_SearchResultele, "title");
		//soft.assertEquals(connSearched, connectionName,"Searched connection type didnt matched with expected.");
		BaseSuite.validationReportLog("Searched successfully "+connectionName+" connection type.");
		//Click on searched connection type
		isDisplayed(driver, newConn_ClickConnTile);
		displayAndClick(driver, newConn_ClickConnTile);
		BaseSuite.validationReportLog("Successfully clicked on connection "+connectionName+" button.");
		inVisible(driver, chooseConnectionType_Spinner, Constant.ruleWait);
		
	} catch (Exception e) {
		
		e.getMessage();
	}

}

//Search connection on connection landing page and opens connection details page
public void connectionLandingpage_SearchConnection(String connectionName,SoftAssert soft) throws Exception
{
	try {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		isDisplayed(driver, connHomePage_searchbox);
		BaseSuite.reportLog("Search textbox is displayed.");
		clear_Click_SendKeys(driver, 2, connHomePage_searchbox, connectionName);
		BaseSuite.reportLog("Entered connection to be searched as : "+connectionName);
		displayAndClick(driver, connHomePage_searchbtn);
		BaseSuite.reportLog("Clicked on search button icon.");
		inVisible(driver, connHomePage_spinner, Constant.ruleWait);
		BaseSuite.validationReportLog("Spinner is displayed.");
		isDisplayedInLoop(driver,3, returnElement(connLPage_searchedConn, "$cName", connectionName));
		displayAndClick(driver, returnElement(connLPage_searchedConn, "$cName", connectionName));
		BaseSuite.validationReportLog("Successfully clicked on connection name.");
		captureToastMsg(driver, toastMsgCon, popUpClose, toastmsg_Connretrived, "ConnectionDetailsPage");
		
		
	} catch (Exception e) {
		e.getMessage();
	}
	
}
//create connection & then revisit to check all details entred are saved correctly.

  public void revisitRecentlyCreatedConnection(String workspace,String connectionName,String dbDriver,String dbAuthentication,String chkboxJDBCFlag,String customJDBCURL,String host,String port,String database,String cType,String connSelectedTName,String username,SoftAssert soft)
  {
	  try {
		
	
	 BaseSuite.reportLog("Verifying newly created connection of type :: "+connSelectedTName+" having connection name :: "+connectionName+"."); 
	 
	
	
	 isDisplayed(driver,existingConnRevisit_workspaceTxtbox);
	 String connWks= getAttribute(driver,existingConnRevisit_workspaceTxtbox,"value");
	 if(connWks.equalsIgnoreCase(workspace))
	 {
	 soft.assertEquals(connWks, workspace,"Connection workspace do not match");
	 BaseSuite.validationReportLog("Connection workspace is matched successfully as "+workspace);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector workspace do not match as expected was "+workspace+" found "+connWks,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 //Connection Id should be added
	 
	 	 
	 isDisplayed(driver,existingConnRevisit_connName);
	 String connectionNamet= getAttribute(driver, existingConnRevisit_connName,"value");
	 if(connectionNamet.equalsIgnoreCase(connectionName))
	 {
	 soft.assertEquals(connectionNamet, connectionName,"Connection Name do not match");
	 BaseSuite.validationReportLog("Connection name is matched successfully as "+connectionName);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector name do not match as expected was "+connectionName+" found "+connectionNamet,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver, existingConnRevisit_connDriver);
	 String conn_Driver= getAttribute(driver, existingConnRevisit_connDriver,"aria-label");
	 if(conn_Driver.equalsIgnoreCase(dbDriver))
	 {
	 soft.assertEquals(conn_Driver, dbDriver,"Connection driver do not match");
	 BaseSuite.validationReportLog("Connection driver is matched successfully as "+dbDriver);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector driver do not match as expected was "+dbDriver+" found "+conn_Driver,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver, existingConnRevisit_connAuthentication );
	 String conn_Auth= getAttribute(driver, existingConnRevisit_connAuthentication,"aria-label");
	 if(conn_Auth.equalsIgnoreCase(dbAuthentication))
	 {
	 soft.assertEquals(conn_Auth,dbAuthentication,"Connection authentication value do not match");
	 BaseSuite.validationReportLog("Connection authentication value is matched successfully as "+dbAuthentication);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector authentication value do not match as expected was "+dbAuthentication+" found "+conn_Auth,"revisitRecentlyCreatedConnection");
		 
	 }
	 //NEED TO ADD TOGGLE BUTTON LOGIC ONCE WE GET DYNAMIC LABEL
	 isDisplayed(driver, newConn_Chk_JDBCUrl);
	//BaseSuite.validationReportLog("Custom JDBC Url is displayed on UI.");
	 String checkboxCh=getAttribute(driver, newConn_Chk_JDBCUrl,"aria-checked");
	 if(checkboxCh.equalsIgnoreCase(chkboxJDBCFlag))
	 {
		 BaseSuite.reportLog("Enable Custom JDBC URL checkbox status is matched.");
		 if(checkboxCh.equalsIgnoreCase("true"))
			 {
			 	BaseSuite.reportLog("As check box is checked, so textarea should be enabled.");
			 	 boolean status=isEnabled(driver, newConn_Textarea);
				 if(status)
				 {
					 BaseSuite.validationReportLog("Custom JDBC URL textarea is enabled by default.");
					 
				 }else
				 {
					 BaseSuite.reportFailLog("Custom JDBC URL textarea is disabled when checkbox is checked, kindly check.", "revisitRecentlyCreatedConnection");
				 }
			 }
		 else if(checkboxCh.equalsIgnoreCase("false")) 
		 {
			 BaseSuite.reportLog("As check box is unchecked, so textarea should be disabled.");
		 	 boolean status=isEnabled(driver, newConn_Textarea);
			 if(!status)
			 {
				 BaseSuite.validationReportLog("Custom JDBC URL textarea is disabled by default.");
				 
			 }else
			 {
				 BaseSuite.reportFailLog("Custom JDBC URL textarea is enabled when checkbox is unchecked, kindly check.", "revisitRecentlyCreatedConnection");
			 }
		 }
			 
		
		 
	 }
	 else 
	 {
		 BaseSuite.reportFailLog("Enable Custom JDBC URL checkbox status do not match with expected i.e. was "+chkboxJDBCFlag+" found "+checkboxCh,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver,  newConn_Textarea);
	 String strConnCustomUrl= getText(driver, newConn_Textarea);
	 if(strConnCustomUrl.equalsIgnoreCase(customJDBCURL))
	 {
	 soft.assertEquals(strConnCustomUrl,customJDBCURL,"Connection custom JDBC url do not match");
	 BaseSuite.validationReportLog("Connection custom JDBC url is matched successfully as "+customJDBCURL);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector custom JDBC url do not match as expected was "+customJDBCURL+" found "+strConnCustomUrl,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver, connHost );
	 String strConnHost= getAttribute(driver, connHost,"value");
	 if(strConnHost.equalsIgnoreCase(host))
	 {
	 soft.assertEquals(strConnHost,host,"Connection host value do not match");
	 BaseSuite.validationReportLog("Connection host value is matched successfully as "+host);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector host value do not match as expected was "+host+" found "+strConnHost,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver, connPort);
	 String strConnPort= getAttribute(driver, connPort,"value");
	 if(strConnPort.equalsIgnoreCase(port))
	 {
	 soft.assertEquals(strConnPort,port,"Connection port value do not match");
	 BaseSuite.validationReportLog("Connection port value is matched successfully as "+port);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector port value do not match as expected was "+port+" found "+strConnPort,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 
	 isDisplayed(driver, connDatabase);
	 String strConnDB= getAttribute(driver, connDatabase,"value");
	 if(strConnDB.equalsIgnoreCase(database))
	 {
	 soft.assertEquals(strConnDB,database,"Connection database value do not match");
	 BaseSuite.validationReportLog("Connection database value is matched successfully as "+database);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector database value do not match as expected was "+database+" found "+strConnDB,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver, connectionType);
	 String strconnType= getAttribute(driver, connectionType,"aria-label");
	 if(strconnType.equalsIgnoreCase(cType))
	 {
	 soft.assertEquals(strconnType,cType,"Connection type value do not match");
	 BaseSuite.validationReportLog("Connection type value is matched successfully as "+cType);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector type value do not match as expected was "+cType+" found "+strconnType,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayed(driver, connUsernameinput);
	 String connUsername= getAttribute(driver, connUsernameinput,"value");
	 if(connUsername.equalsIgnoreCase(username))
	 {
	 soft.assertEquals(connUsername,username,"Connection username value do not match");
	 BaseSuite.validationReportLog("Connection username value is matched successfully as "+username);
	 } else
	 {
		 BaseSuite.reportFailLog("Connector username value do not match as expected was "+username+" found "+connUsername,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	 isDisplayedInLoop(driver,5, conncreatedType);
	 String typeOfConn=getAttribute(driver, conncreatedType,"title");
	 if(typeOfConn.equalsIgnoreCase(connSelectedTName))
	 {
	 soft.assertEquals(typeOfConn, connSelectedTName,"Connector type do not match");
	 BaseSuite.validationReportLog("Connector type is matched successfully as "+connSelectedTName);	
	 }
	 else
	 {
		 BaseSuite.reportFailLog("Connector type do not match as expected was "+connSelectedTName+" found "+typeOfConn,"revisitRecentlyCreatedConnection");
		 
	 }
	 
	  } catch (Exception e) {
			e.getMessage();
		}
	 
	 
  }
 

}
