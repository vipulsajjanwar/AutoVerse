package nexgen.automation.framework.connectionRepo;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class ConnectionHome extends PageUtil 
{
	WebDriver driver;
	
	public ConnectionHome(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By ClickonDataConnection = getElementLocator(prop.getProperty("Connection.connectionLabel"));
	By pagelabel = getElementLocator(prop.getProperty("Connection.PageLabel"));
	
	By clickonNewConnection = getElementLocator(prop.getProperty("Connection.newConnection"));
	By clickonConnectionMenu = getElementLocator(prop.getProperty("Connection.connections"));
	By SelectAllcheckboxes = getElementLocator(prop.getProperty("Connection.allCheckbox"));
	By connSingleCheck = getElementLocator(prop.getProperty("connSingleCheck"));
	
	public String typeOfCheckSelection=prop.getProperty("typeOfCheckSelection");
	By nameLable = getElementLocator(prop.getProperty("Connection.connectionNameLable"));
	By clickonRefresh = getElementLocator(prop.getProperty("Connection.refresh"));
	By clickonDisable = getElementLocator(prop.getProperty("Connection.disable"));
	By clickonDisableNo = getElementLocator(prop.getProperty("Connection.disableNo"));
	By landingPageAllBtn = getElementLocator(prop.getProperty("landingPageAllBtn"));
	By connectionNameLabel = getElementLocator(prop.getProperty("connectionNameLabel"));
	By workspaceLabel=getElementLocator(prop.getProperty("landWorkspaceLabel"));
	By typeLabel=getElementLocator(prop.getProperty("typeLabel1"));
	By createdByLabel=getElementLocator(prop.getProperty("landCreatedByLabel"));
	By lastModified=getElementLocator(prop.getProperty("landLastModified"));	
	By connectionCheckbox=getElementLocator(prop.getProperty("connectionCheckbox"));	
	By searchBar = getElementLocator(prop.getProperty("Connection.SearchBox"));
	By searchBclick = getElementLocator(prop.getProperty("Connection.SearchButton"));
	By noRecondsFound=getElementLocator(prop.getProperty("noRecondsFound"));
	String clickonSearchConnection = prop.getProperty("Connection.SearchConnection");	
	public String invalidSearchName=prop.getProperty("invalidSearchName");
	public String searchName=prop.getProperty("searchName");
	public String searchWorkspaceName=prop.getProperty("searchWorkspaceName");	
	public String searchCreatedByName=prop.getProperty("searchCreatedByName");
	public String searchNewconnectionName=prop.getProperty("searchNewconnectionName");
	By sideBarclick = getElementLocator(prop.getProperty("Connection.SideBarIcon"));
	By sideBarUser = getElementLocator(prop.getProperty("Connection.UserConnections"));	
	By clickonHomeLink = getElementLocator(prop.getProperty("Connection.HomeLink"));	
	By NumberofConnections = getElementLocator(prop.getProperty("Connection.NumberofConnections"));
	By PaginationCount = getElementLocator(prop.getProperty("Connection.Pagination"));
	
	By clickOnConnNameCol=getElementLocator(prop.getProperty("clickOnConnNameCol"));
	By listOfConnName=getElementLocator(prop.getProperty("listOfConnName"));
	By connectionPageSpinner=getElementLocator(prop.getProperty("connectionPageSpinner"));
	By paginationSpinner=getElementLocator(prop.getProperty("paginationSpinner"));
	By connWorkspaceName=getElementLocator(prop.getProperty("connWorkspaceName"));
	By connCreatedByName=getElementLocator(prop.getProperty("connCreatedByName"));
	By disableWinTitle=getElementLocator(prop.getProperty("disableWinTitle"));
	By disablePopUpMsg=getElementLocator(prop.getProperty("disablePopUpMsg"));
	By disableNoOption=getElementLocator(prop.getProperty("Connection.disableNo1"));
	By disableYesOption=getElementLocator(prop.getProperty("Connection.disableYes1"));
	By popUpClose=getElementLocator( prop.getProperty("PopUpClose"));		
	By toastMsg=getElementLocator(prop.getProperty("Commontoastmsg"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By connectionNameClick=getElementLocator(prop.getProperty("connectionNameClick"));
	By connNameOnPage=getElementLocator(prop.getProperty("connNameOnPage"));
	By landingPageTitle=getElementLocator(prop.getProperty("landingPageTitle"));
	By newConnectionNameSearch=getElementLocator(prop.getProperty("newConnectionNameSearch"));
	By connectionImg=getElementLocator(prop.getProperty("connectionImg"));
	By connPaginationIcon=getElementLocator(prop.getProperty("connPaginationIcon"));
	By connPaginationNumber=getElementLocator(prop.getProperty("connPaginationNumber"));
	By updatedByLabel=getElementLocator(prop.getProperty("UpdatedByLabel"));
	By connectionType=getElementLocator(prop.getProperty("ConnectionTypeLabel"));
	By advancedSearchButton=getElementLocator(prop.getProperty("AdvancedSearchButton"));
	By connectionLabels=getElementLocator(prop.getProperty("ConnectionsLabel"));
	
	By brdCrumsHomeLink=getElementLocator(prop.getProperty("Connection.HomeLink1"));
	By brdCrumsConnRepo=getElementLocator(prop.getProperty("Connection.ConnRepoLink"));
	By brdCrumsConnections=getElementLocator(prop.getProperty("Connection.ConnectionBr"));
	By connectionNameClick1=getElementLocator(prop.getProperty("connectionNameClick1"));
	By leftArrow_connection=getElementLocator(prop.getProperty("Connection.LeftSideBarArrowClose"));
	By leftArrowOpen_connection=getElementLocator(prop.getProperty("Connection.LeftSiderBarArrowOpen"));
	By LoggedInMsg = getElementLocator(prop.getProperty("Login.LoggedInMsg"));
	
	
	public String alertMsg=prop.getProperty("alertMsg");
	public String disableConnMsg=prop.getProperty("disableConnMsg");
	public String disableSearchName=prop.getProperty("disableSearchName");
	String SearchWorkspace=prop.getProperty("Connection.SearchWorkspace");
	String searchCreatedBy=prop.getProperty("Connection.SearchCreatedBy");
	String connectionRetriveMsg=prop.getProperty("connectionRetriveMsg");
	String brdCrumsWorkspaceName=prop.getProperty("Connection.WorkspaceNameBrdcr");
	public String disableMess=prop.getProperty("Connection.DisableMess");
	String connectionName=prop.getProperty("connName");
	String newConnToastMsg=prop.getProperty("Connection.NewConnToastMsg");
	String logeedInText = prop.getProperty("LogeedInText");
	String connFetchedMsg=prop.getProperty("Connection.ConnFetchMsg");
	//method to click on conn repo on homepage
		public boolean ConnectionRepo()
		{boolean flag =false;
			try
			{
				isDisplayedInLoop(driver, 2, ClickonDataConnection);
				if(isDisplayed(driver, ClickonDataConnection))
			{
				displayAndClick(driver, ClickonDataConnection);
				//getWindowHandler(driver);				
				BaseSuite.reportLog("clicked on Connections tab");
				
			}
			/*	if(isDisplayed(driver, ToastMsgClosedBtn)) {
					captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, "", "invalid message");
				}
			/*
			 * else { BaseSuite.reportLog("Not able to click on the Data Connections tab");
			 * }
			 */
			}			
			catch(Exception e)
			{
				throw new AssertionError("User not able to navigate on Administration page", e);
			}
			return flag;
		}
		//not working - need to remove this method
		public void clickConnnectionsTab() {
			try
			{
			BaseSuite.reportLog("Clicking on connections Tab");
			Thread.sleep(1000);
						 
			 isDisplayedInLoop(driver,20,clickonConnectionMenu);
			 
			displayAndClick(driver, clickonConnectionMenu);
		        
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);	
						
			BaseSuite.validationReportLog("Connections Tab clicked successfully");		
				        
			}
			catch(Exception e)
			{
			//	throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to click on refresh button on conn repo home page - tested
		public void clickOnRefreshBtn() throws Exception
		{

			clickOnButton(driver, clickonRefresh, "Refresh", true);
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
		}
		
		//method to click on new conn button on conn repo home page - tested
		public void clickOnNewConnectionBtn() throws Exception
		{
			clickOnButton(driver, clickonNewConnection, "New Connection", true);
			inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, newConnToastMsg, "LoggedIn");
		}
		
		public void newConnectionRulepageScroll()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('#iscroll > app-connections > app-new-connection > div.scrollable-area > div > div').scrollTop=500");
		}
		
		//need to remove 
		public void clickOnNewConnection() throws Exception
		{
			Thread.sleep(1000);
			isDisplayedInLoop(driver,10,connectionNameClick);
			displayAndClick(driver,connectionNameClick);
		}
		
		//method to check button and lables on conn repo - tested
		public void validateButtonsAndLables() 
		{
			try
			{
	
				
				BaseSuite.reportLog("Verifying Connection Repository Breadcrums links on page");
				
				verifyVisibilityOfButtons(driver, brdCrumsHomeLink, "Home Link", true);
				verifyIndividualLabel(driver, brdCrumsConnRepo, "Connection Repository ");
				verifyIndividualLabel(driver, brdCrumsConnections, "Connections");
				
				BaseSuite.validationReportLog("Connection Repository Breadcrums links verified on page");
				
				verifyIndividualLabel(driver, connectionLabels, "Connections Title");
				
				BaseSuite.reportLog("Verifying the count of Button on connection page");
				
				validateButtons(driver, landingPageAllBtn, 3);
				verifyVisibilityOfButtons(driver, clickonNewConnection, "New Connection ", true);				
				isClickable(driver, clickonNewConnection, "New Connection ",true);
				verifyVisibilityOfButtons(driver, clickonRefresh, "Refresh ", true);				
				isClickable(driver, clickonRefresh, "Refresh Button",true);
				verifyVisibilityOfButtons(driver, clickonDisable, "Delete  ", false);				
				isClickable(driver, clickonDisable, "Delete Button ",false);
					
			
				
				verifyIndividualLabel(driver, connectionNameLabel, "Connection Name");
				verifyIndividualLabel(driver, connectionType, "Connection Type");
				verifyIndividualLabel(driver, typeLabel, "Type");
		//		verifyIndividualLabel(driver, updatedByLabel, "Updated By");
		//		verifyIndividualLabel(driver, lastModified, "Last Updated");				
				
				
			}
			
			catch(Exception ex)
			{
				throw new AssertionError("All buttons are disabled", ex);
			}			
		}
		//need to remove
		public void selectionOfCheckboxes(String typeOfCheckSelection) {
			try {
				BaseSuite.reportLog("Verifying the selection of checkboxes");
				String[] result = typeOfCheckSelection.split(",");
				String sel = result[0];
				//String sel1 = result[1];
				/*if (sel.equalsIgnoreCase("All")) {
					int count = driver.findElements(SelectAllcheckboxes).size();

					BaseSuite.reportLog("Verifying the all connection select checkbox selected or not");

					boolean test = driver.findElement(connectionCheckbox).isSelected();
					if (!test) {
						BaseSuite.validationReportLog(
								"Connection checkbox not selected and the size of all connection select checkbox on page is: "
										+ count);
						BaseSuite.reportLog("Now clicking on the checkbox to select the all the connections");
						displayAndClick(driver, SelectAllcheckboxes);
						boolean test1 = driver.findElement(connectionCheckbox).isSelected();
						if (test1) {
							BaseSuite.validationReportLog("All the connnections selected successfully");
						} else {
							BaseSuite.reportFailLog("Connection not selected", "selectionOfCheckboxes");
						}
					} else {
						BaseSuite.validationReportLog("All connection checkboxes are selected");
					}
					driver.navigate().refresh();
					inVisible(driver, connectionPageSpinner, Constant.ruleWait);
					waitForElement(driver, connSingleCheck);

				} else {
					BaseSuite.reportFailLog("Selection of name is empty", "selectionOfCheckboxes");
				}*/
				if (sel.equalsIgnoreCase("Single"))
				{
					Thread.sleep(2000);
					List<WebElement> check = driver.findElements(connSingleCheck);
					int count1 = check.size();
					int i = 1;
					//int j = 1;
					BaseSuite.reportLog("Verifying the single connection select checkbox selected or not");
					BaseSuite.validationReportLog("Initially connection checkbox is not checked and the size of connection list checkbox on page is :" + count1);
					List<WebElement> check1 = driver.findElements(connectionCheckbox);
					//for (int j = 1; i <= check1.size() - 13; j++) {
						boolean test = check1.get(i).isSelected();
						if (!test) {
							BaseSuite.reportLog("Initially Connection checkbox is not selected");
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
						//}
					}
				} else {
					BaseSuite.reportFailLog("Selection of name is empty", "selectionOfCheckboxes");
				}
				connectionHomeLink();
			} catch (Exception ex) {
				throw new AssertionError("Error occured in this method", ex);
			}
		}
		//method to sort connection list in ascending order on conn repo - tested
		public void ascendingAndDescendingConnectionName()
		{
			try
			{
				BaseSuite.reportLog("Verify sorting of connection list");
				BaseSuite.reportLog("Capturing all the connection list");
				List<WebElement> elementList = driver.findElements(listOfConnName);
				BaseSuite.reportLog("Capturing text of all the connection name into the list");
				List<String> beforesortingList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
				BaseSuite.reportLog("Verifying connection sorted or not:" + beforesortingList);
				BaseSuite.reportLog("Clicking on the connection name column to check the sorting function");
				displayAndClick(driver,clickOnConnNameCol);
				inVisible(driver, paginationSpinner, Constant.ruleWait);
				List<WebElement> elementList1 = driver.findElements(listOfConnName);
				BaseSuite.reportLog("Capturing text of all the connection name into the list");
				List<String> aftersortingList = elementList1.stream().map(s->s.getText()).collect(Collectors.toList());
				BaseSuite.reportLog("Verifying connection sorted or not:" + aftersortingList);
				List<String> sortedList = beforesortingList.stream().sorted().collect(Collectors.toList());
				BaseSuite.validationReportLog("Compairing the list after sorting the connection list:" + sortedList);
				if(aftersortingList.equals(sortedList))
				{
					BaseSuite.validationReportLog("Sorting function working correctly");
				}
				else
				{
					BaseSuite.reportFailLog("Sorting function not working", "ascendingAndDescendingConnection");
				}
				//connectionHomeLink();
			}
			catch(Exception ex)
			{
				throw new AssertionError("Error occured in this method", ex);
			}	
		}
		//method to search connection name on conn repo home page - tested
		public void searchConnectionFunctionality(String Connection_search) throws Exception
		{
				BaseSuite.reportLog("Searching for Connection:" + Connection_search);
				isDisplayedInLoop(driver, 20, searchBar);
				clear_Click_SendKeys(driver, 20, searchBar, Connection_search.trim());
				BaseSuite.validationReportLog("Connection name entered successfullly :" + Connection_search);
				BaseSuite.reportLog("Clicking on search icon");
				isDisplayedInLoop(driver, 3, searchBclick);
				displayAndClick(driver, searchBclick);				
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
			
				try {
					isDisplayedInLoop(driver, 10, searchBclick);	
					if(!isDisplayed(driver, noRecondsFound)) {
					String name = driver.findElement(returnElement(clickonSearchConnection, "$title", Connection_search)).getText();
					boolean flag = isDisplayed(driver,returnElement(clickonSearchConnection, "$title", Connection_search));
					if(flag)
					{
						BaseSuite.validationReportLog("Connection displayed in the list" );
				
						if(name.equalsIgnoreCase(Connection_search))
						{
							BaseSuite.validationReportLog("Searched connection found in the list :" + Connection_search);
							BaseSuite.validationReportLog("Search functionality working properly");
						}
						else
						{
							BaseSuite.reportFailLog("Searched connection not matched", "searchConnectionFunctionality");
						}
					}
					else
					{
						BaseSuite.validationReportLog("Searched connection not available in the list :" + Connection_search);
					}
					}else {
						BaseSuite.validationReportLog( "No connection found for searched value ");
					}
									
				} catch (Exception e) {
					throw new AssertionError("Error occured in this method", e);
				}
			}
		
		//method to search connection with invalid data -tested
		public void searchConnectionWithInvalidData(String Connection_search) throws Exception
		{
				BaseSuite.reportLog("Searching for Connection:" + Connection_search);
				isDisplayedInLoop(driver, 10, searchBar);
				clear_Click_SendKeys(driver, 10, searchBar, Connection_search.trim());
				BaseSuite.validationReportLog("Connection name entered successfullly :" + Connection_search);
				BaseSuite.reportLog("Clicking On search icon");
				isDisplayedInLoop(driver, 3, searchBclick);
				displayAndClick(driver, searchBclick);
				try {
					isDisplayedInLoop(driver, 4, searchBclick);
					BaseSuite.reportLog("Click on Searched User");
					BaseSuite.reportLog("Verify that invalid searched connection available in the list or not");
					boolean flag = isDisplayed(driver,returnElement(clickonSearchConnection, "$title", Connection_search));
					if(!flag)
					{
						BaseSuite.validationReportLog("Invalid connection not available in the list" );
						isDisplayedInLoop(driver,20,noRecondsFound);
						String msg=driver.findElement(noRecondsFound).getText();
						BaseSuite.validationReportLog("Message displayed on page is :" + msg);
					}
					else
					{
						BaseSuite.reportFailLog("Invalid searched connection available in the list", "searchConnectionWithInvalidData");
					}					
					//connectionHomeLink();
				} catch (Exception e) {
					throw new AssertionError("Error occured in this method", e);
				}
			}
		//This method is for search by workspace functionality invalid on new nextgen ui - need to remove
		public void searchByWorkspaceFunctionality(String Workspace_search)
		{
			try {
				BaseSuite.reportLog("Searching for Connection:" + Workspace_search);
				isDisplayedInLoop(driver, 10, searchBar);
				clear_Click_SendKeys(driver, 10, searchBar, Workspace_search.trim());
				BaseSuite.validationReportLog("Connection name entered successfullly :" + Workspace_search);
				BaseSuite.reportLog("Clicking On search icon");
				isDisplayedInLoop(driver, 3, searchBclick);
				click(driver, searchBclick);
				isDisplayedInLoop(driver, 4, searchBclick);	
				Thread.sleep(1000);
				String name = driver.findElement(returnElement(SearchWorkspace, "$name", Workspace_search)).getText();
				boolean flag = isDisplayed(driver, returnElement(SearchWorkspace, "$name", Workspace_search));
				if (flag) {
					BaseSuite.validationReportLog("Workspace available in the list");

					if (name.equalsIgnoreCase(Workspace_search)) {
						BaseSuite.validationReportLog("Searched workspace found in the list so its verify that search functionality working correctly :"+ Workspace_search);
					} else {
						BaseSuite.reportFailLog("Searched workspace not matched", "searchByWorkspaceFunctionality");
					}
				} else {
					BaseSuite.validationReportLog("Searched using workspace name functionality not available in application ");
				}
				BaseSuite.reportLog("Verify after search with workspace name only workspace according connections are displaying in the list or not");				
				if (isDisplayed(driver, connWorkspaceName)) {
					Thread.sleep(1000);
					List<WebElement> tablelist = driver.findElements(connWorkspaceName);
					List<String> originalList = tablelist.stream().map(s -> s.getText()).distinct().collect(Collectors.toList());

					for (int i = 0; i < originalList.size(); i++) {
						String name1 = originalList.get(i);
						if (Workspace_search.contains(name1)) {
							BaseSuite.validationReportLog("Only searched workspace type connections are displaying in rule list :" + name1);
						} else {
							BaseSuite.validationReportLog("Searched workspace connections not available in the list");
						}
					}
				} else {
					BaseSuite.validationReportLog("No records found message displayed on the rule list page");
				}
				BaseSuite.validationReportLog("Workspace search functionality working correctly");

				connectionHomeLink();
			} catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		//This method is for search by Created by functionality invalid on new nextgen ui - need to remove
		public void searchCreatedByFunctionality(String CreatedBy_search)
		{
			try {
				BaseSuite.reportLog("Searching for Created by name:" + CreatedBy_search);
				isDisplayedInLoop(driver, 10, searchBar);
				clear_Click_SendKeys(driver, 10, searchBar, CreatedBy_search.trim());
				BaseSuite.validationReportLog("Created by name entered successfullly :" + CreatedBy_search);
				BaseSuite.reportLog("Clicking On search icon");
				isDisplayedInLoop(driver, 3, searchBclick);
				click(driver, searchBclick);
				isDisplayedInLoop(driver, 4, searchBclick);
				BaseSuite.reportLog("Click on Searched User");
				BaseSuite.reportLog("Verify search using created by function working or not");
				Thread.sleep(1000);
				String name = driver.findElement(returnElement(searchCreatedBy, "$name", CreatedBy_search)).getText();
				boolean flag = isDisplayed(driver, returnElement(searchCreatedBy, "$name", CreatedBy_search));
				if (flag) {
					BaseSuite.validationReportLog("Search using created by name function is available and working");

					if (name.equalsIgnoreCase(CreatedBy_search)) {
						BaseSuite.validationReportLog("Searched created by name found in the list so its verify that search functionality working correctly :" + CreatedBy_search);
					} else {
						BaseSuite.reportFailLog("Searched created by name not matched", "searchByWorkspaceFunctionality");
					}
				} else {
					BaseSuite.validationReportLog("Searched using created by function is not available in application");
				}
				BaseSuite.reportLog("Verify after search with created by name only created by according connections are displaying in the list or not");
				if (isDisplayed(driver, connCreatedByName)) {
					Thread.sleep(1000);
					List<WebElement> tablelist = driver.findElements(connCreatedByName);
					List<String> originalList = tablelist.stream().map(s -> s.getText()).distinct().collect(Collectors.toList());

					for (int i = 0; i < originalList.size(); i++) {
						String name1 = originalList.get(i);
						if (CreatedBy_search.contains(name1)) {
							BaseSuite.validationReportLog("Only searched created by name connections are displaying in connection list :" + name1);
						} else {
							BaseSuite.validationReportLog("Searched created by name connections not available in the list");
						}
					}
				} else {
					BaseSuite.validationReportLog("No records found message displayed on the rule list page");
				}
				BaseSuite.validationReportLog("Created by search functionality working correctly");

				connectionHomeLink();
			} catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to select multiple connection and verify disable button functionality -multiple conn selection not possible on new ui -need to remove this method
		public void disableBtnFunctionWithMultipleConnSelection()
		{
			try
			{
				
				List<WebElement> check = driver.findElements(connSingleCheck);
				int count1 = check.size();
				int i = 0;
				BaseSuite.reportLog("Verifying the single connection select checkbox selected or not");
				BaseSuite.validationReportLog("Connection checkbox not selected and the size of connection list checkbox on page is: "+ count1);
				List<WebElement> check1 = driver.findElements(connectionCheckbox);
				for (int j = 0; j < count1; j++) {
					String s = check.get(i).getAttribute("class");
				
					if (!s.contains("active")) {
						BaseSuite.reportLog("Connectin checkbox is not selected");
						BaseSuite.reportLog("Now clicking on the checkbox to select single connections");
						Actions action = new Actions(driver);	
						action.click(check.get(i)).build().perform();
						String s1  = check1.get(j).getAttribute("class");
						if (s1.contains("active")) {
							BaseSuite.validationReportLog("Connnection selected successfully");
						} else {
							BaseSuite.reportFailLog("Connection not selected", "selectionOfCheckboxes");
						}
					} else {
						BaseSuite.validationReportLog("Connection checkboxes already selected");
					}	i++;				
				}
				BaseSuite.reportLog("Verifying disable button enabled or not after the selection of multiple connection");
				isDisplayedInLoop(driver, 10, clickonDisable);
				verifyVisibilityOfButtons(driver, clickonDisable, "Disable Button", true);				
				isClickable(driver, clickonDisable, "Disable Button",true);					
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to validate disable functionality pop up window - tested
		public void disableFunWithAlertPopUp(String mess)
		{
			try
			{	//displayAndClick(driver,connSingleCheck);			
				BaseSuite.reportLog("Verify disable alert pop up window alert messages and buttons");
				isDisplayedInLoop(driver, 20, clickonDisable);
				if(isEnabled(driver,clickonDisable))
				{
					displayAndClick(driver,clickonDisable);
					BaseSuite.validationReportLog("Clicked on the Disable button");
					isDisplayedInLoop(driver, 20, disableWinTitle);
					if(isDisplayed(driver,disableWinTitle))
					{
						isDisplayedInLoop(driver, 20, disableWinTitle);waitForElement(driver, disableWinTitle);
						String title = driver.findElement(disableWinTitle).getText();
						BaseSuite.validationReportLog("After click on disable button alert pou up window opened successfully with title :" + title);
						BaseSuite.reportLog("Verify the alert popup message on the window");waitForElement(driver, disablePopUpMsg);
						String validMess = getText(driver, disablePopUpMsg).trim();
						BaseSuite.validationReportLog("Retrived Message on popup window is :" + validMess);
						BaseSuite.validationReportLog("Expected Message on popup window is :" + mess.trim());

						if (!validMess.isEmpty() && validMess.equalsIgnoreCase(mess.trim())) {

							soft.assertEquals(validMess, mess.trim());

							BaseSuite.validationReportLog("Popup window Message Successfully Matched and the message is :" + validMess);
						}
						else {
							BaseSuite.reportFailLog("Messages didn't match", "captureToastMsg");
						}
						BaseSuite.reportLog("Verify yes and no button is diplayed and enabled on the popup window");
						verifyVisibilityOfButtons(driver, disableYesOption, "Disable ", true);				
						isClickable(driver, disableYesOption, "Disable ",true);	
						verifyVisibilityOfButtons(driver, disableNoOption, "Cancel ", true);				
						isClickable(driver, disableNoOption, "Disable ",true);	
					}
					else
					{
						BaseSuite.reportFailLog("Popup window not opened or title message not getting displayed on window", "disableFunWithAlertPopUp");
					}
				}
				
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to validate disable button should be disabled when non of connections are selected - tested
		public void disbleBtnShouldNotEnabledWithoutSelectionOfConnection()
		{
			try
			{
				
				BaseSuite.reportLog("Verify disable button enabled or disabled without the selection of connection");
				verifyVisibilityOfButtons(driver, clickonDisable, "Disable Button", false);				
				isClickable(driver, clickonDisable, "Disable Button",false);
				BaseSuite.validationReportLog("Disable button is disabled without the selection of connection");
				//connectionHomeLink();
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}			
		}
		
		//method to validate disable button should be enabled when one of connection is selected - tested
		public void disbleBtnShouldBeEnabledWithSelectionOfConnection(String Connection_search)
		{
			try
			{
				searchConnectionFunctionality(Connection_search);
				isDisplayedInLoop(driver,10,connSingleCheck);
				BaseSuite.reportLog("Clicking on connection's checkbox");
				displayAndClick(driver,connSingleCheck);
				BaseSuite.validationReportLog("Connection's checkbox is selected");
				//Thread.sleep(1000);
				BaseSuite.reportLog("Verify disable button enabled or disabled with the selection of connection");
				verifyVisibilityOfButtons(driver, clickonDisable, "Disable Button", true);				
				isClickable(driver, clickonDisable, "Disable Button",true);
				BaseSuite.validationReportLog("Disable button is enabled with the selection of connection");
				//connectionHomeLink();
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}			
		}		
		//method to check refresh button functionality on conn repo - tested
		public void refreshBtnFunction()
		{
			try
			{
				BaseSuite.reportLog("Verifiying refresh button function");
				int count = driver.findElements(connectionCheckbox).size();
				List<WebElement> list = driver.findElements(connectionCheckbox);
				BaseSuite.reportLog("Before refresh button click select all the connections");
				String a =list.get(0).getAttribute("class");
				
				if (!a.contains("active") ) {
					BaseSuite.validationReportLog("Connection checkbox not selected and the size of all connection select checkbox on page is:"	+ count);
					BaseSuite.reportLog("Now clicking on the checkbox to select the all the connections");
					list.get(0).click();
					String a1 =list.get(0).getAttribute("class");
					if (a1.contains("active")) {
						BaseSuite.validationReportLog("connnection selected successfully");
					} else {
						BaseSuite.reportFailLog("Connection not selected", "selectionOfCheckboxes");
					}
				}
				else {
					BaseSuite.validationReportLog("All connection checkboxes are selected");
				}
				BaseSuite.reportLog("Clicking on the refresh button to check after click on refresh button all the connections should get unchecked or not ");
				clickOnRefreshBtn();
				inVisible(driver, connectionPageSpinner, Constant.ruleWait);
				List<WebElement> list1 = driver.findElements(connectionCheckbox);
				String a2 =list1.get(0).getAttribute("class");
				if (a2.contains("true")) {
					BaseSuite.reportFailLog("After click on refresh button connection page not getting refreshed", "selectionOfCheckboxes");
					
				} else {
					BaseSuite.validationReportLog("All the selected connnections unchecked successfully hence refresh button function working successfylly");
				}
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to search and disable connection on connection repo home page - tested
		public void disableConnWithYesOption(String mess,String Connection_search)
		{
			try
			{
				searchConnectionFunctionality(Connection_search);
				isDisplayedInLoop(driver,10,connSingleCheck);
				BaseSuite.reportLog("Clicking on connection's checkbox");
				displayAndClick(driver,connSingleCheck);
				BaseSuite.validationReportLog("Connection's checkbox is selected");
				disableFunWithAlertPopUp(mess);
				BaseSuite.reportLog("Verify Yes button is diplayed and enabled on the popup window");
				verifyVisibilityOfButtons(driver, disableYesOption, "Disable", true);				
				if(isEnabled(driver,disableYesOption))
				{
					BaseSuite.reportLog("Clicking on the Yes button");
					displayAndClick(driver,disableYesOption);		
					inVisible(driver, connectionPageSpinner, Constant.ruleWait);
					captureToastMsg(driver,toastMsg,popUpClose, disableConnMsg, "Msg retrived");
					BaseSuite.reportLog("Verifying disabled connection present in the list or not");
					searchConnectionFunctionality(Connection_search);
					BaseSuite.validationReportLog("Connection's disable Alert popup window Disable button working properly");
				}
				else
				{
					BaseSuite.reportFailLog("Yes button is not enabled on the pop up window", "disableConnWithYesOption");
				}				
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to check cancel button functionality on disable pop-up window -tested
		public void disableConnWithNoOption(String mess,String Connection_search)
		{
			try
			{
				searchConnectionFunctionality(Connection_search);
				isDisplayedInLoop(driver,10,connSingleCheck);
				BaseSuite.reportLog("Clicking on connection's checkbox");
				displayAndClick(driver,connSingleCheck);
				BaseSuite.validationReportLog("Connection's checkbox is selected");
				disableFunWithAlertPopUp(mess);
				BaseSuite.reportLog("Verify No button is diplayed and enabled on the popup window");
				verifyVisibilityOfButtons(driver, disableNoOption, "Cancel", true);				
				if(isEnabled(driver,disableNoOption))
				{
					BaseSuite.reportLog("Clicking on the Cancel button");
					displayAndClick(driver,disableNoOption);		
					BaseSuite.reportLog("Verifying after choosing disable Cancel option connection present in the list or not");
					searchConnectionFunctionality(Connection_search);
					BaseSuite.validationReportLog("Connection's disable Alert popup window Cancel button working properly");
				}
				else
				{
					BaseSuite.reportFailLog("Cancel button is not enabled on the pop up window", "disableConnWithNoOption");
				}
				
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		//method to check connection tab clickable or not on new connection page - tested
		public void connTabsButtonsClickableOrNotOnNewConnectionPage() {
			try {
				//clickOnNewConnectionBtn();
				BaseSuite.reportLog("Verify connections button are visible and enabled or not on the new connection page.");
				isDisplayedInLoop(driver, 10, connectionNameClick);
				List<WebElement> connectionList = driver.findElements(connectionNameClick);
				List<String> connName = connectionList.stream().map(s->s.getText()).collect(Collectors.toList());
				for(int i=0;i<connName.size();i++) {
					boolean dis = connectionList.get(i).isDisplayed();				 
					String name = connName.get(i);
					BaseSuite.reportLog("verifying connection tab :"+name);
					if(dis) {
						BaseSuite.validationReportLog(name + " button is visible in the page");
					
					}else {
						BaseSuite.reportFailLog(name + " button is disabled and invisible in the page", "connectionTabsClickableOrNotOnNewConnectionPage");
					}	
					isDisplayedInLoop(driver, 10, connectionNameClick1);
					List<WebElement> connectionList1 = driver.findElements(connectionNameClick1);
					String ena = connectionList1.get(i).getAttribute("class");
					if(ena.contains("disable")) {
						BaseSuite.validationReportLog(name +" connection tab is disabled and not clickable");
					}else {
						BaseSuite.validationReportLog(name +" connection tab is enabled and clickable");
					}
					
				}
				BaseSuite.validationReportLog("Connections button/ tab are verified on new connection page");
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		//not working  -need to remove this method
		public void connectionTabsClickableOrNotOnNewConnectionPage()
		{
			try
			{ 	
				clickOnNewConnectionBtn();
				//Thread.sleep(1000);
				BaseSuite.reportLog("Verify connections button are visible and enabled or not on the new connection page.");
				List<WebElement> connectionList = driver.findElements(connectionNameClick);
				List<String> connName = connectionList.stream().map(s->s.getText()).collect(Collectors.toList());
				//int j = 0;
				for(int i=0;i<connName.size();i++)
				{
				 boolean dis = connectionList.get(i).isDisplayed();				 
				 String name = connName.get(i);
				 
				 if(dis)
				 {
					 BaseSuite.validationReportLog(name + " button is visible in the page");
				 }
				 else
				 {
					 BaseSuite.reportFailLog(name + " button is disabled and invisible in the page", "connectionTabsClickableOrNotOnNewConnectionPage");
				 }
				 boolean ena = connectionList.get(i).isEnabled();
				 if(ena)
				 {
					 BaseSuite.validationReportLog(name + " button is enabled and clickable on the page");
				 }
				 else
				 {
					 BaseSuite.reportFailLog(name + " button is not enabled and not clickable on the page", "connectionTabsClickableOrNotOnNewConnectionPage");
				 }				
				}	
				
				 String clickedConnName = connectionList.get(16).getText();
				 connectionList.get(16).click();				 
				 BaseSuite.validationReportLog("Connection clicked successfully and clicked connection name is :" + clickedConnName);
				 Thread.sleep(1000);
				 waitForElement(driver,connNameOnPage);
				 String  dis1 = driver.findElement(connNameOnPage).getText();		
				 if(dis1.equalsIgnoreCase(clickedConnName))
				 {
					BaseSuite.validationReportLog(clickedConnName+ " " + "Connection page opened successfully"); 
				}
				 else
				 {
					 BaseSuite.reportFailLog("After clicked on the connection button page not opened", "connectionTabsClickableOrNotOnNewConnectionPage");
				 }
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to check to connection repo home link on breadcrum - tested
		public void homeLinkValidate(String Connection_search)
		{
			try
			{
				BaseSuite.reportLog("Verify home link clickable and functioning correctly or not");
				searchConnectionFunctionality(Connection_search);
				displayAndClick(driver, returnElement(clickonSearchConnection, "$title", Connection_search));
				BaseSuite.reportLog("Clicked on connection: " + Connection_search);
				//Thread.sleep(1000);
				waitForElement(driver,popUpClose);
				captureToastMsg(driver,toastMsg,popUpClose, connectionRetriveMsg, "Connection retrived");				
				BaseSuite.reportLog("Connection Details retrieved successfully for connections " + Connection_search);	
				BaseSuite.reportLog("Clicking on home link");
				connectionHomeLink();
				BaseSuite.reportLog("Verify landing page title for home link click");
				Thread.sleep(1000);
				if(isDisplayed(driver,landingPageTitle))
				{
				BaseSuite.validationReportLog("Navigating to Connection Home page from connection is working successfully");
				}
				else
				{
					BaseSuite.reportFailLog("Landing page title not getting displayed", "homeLinkValidate");
				}
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to check search functionality on new connection page - tested
		public void searchConnectionNameOnNewConnectionPage(String searchNewconnectionName)
		{
			try
			{
				//clickOnNewConnectionBtn();
				BaseSuite.reportLog("Searching for connection:" + searchNewconnectionName);

				BaseSuite.reportLog("Entering connection Name in search bar");				
				
				clear_Click_SendKeys(driver, 10, newConnectionNameSearch, searchNewconnectionName.trim());

				BaseSuite.reportLog("Connection name entered successfuly");

				WebElement element = driver.findElement(newConnectionNameSearch);
				Thread.sleep(1000);
				element.sendKeys(Keys.ENTER);				 				
				isDisplayedInLoop(driver, 30, connectionNameClick);
				BaseSuite.reportLog("Verifying entered rule searched or not");
				String name = driver.findElement(connectionNameClick).getText();
				if(name.equalsIgnoreCase(searchNewconnectionName))
				{
					BaseSuite.validationReportLog("Connection searched successfully :" + name);
				}
				else
				{
					BaseSuite.reportFailLog("Connection not getting searched or wrong connection searched", "searchConnectionNameOnNewConnectionPage");
				}				
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		
		//method to check visiblity of labels and buttons and image on new connection page - tested 
		public void labelsAndButtonsOnNewConnectionPage()
		{
			try
			{
				//clickOnNewConnectionBtn();
				Thread.sleep(1000);
				BaseSuite.reportLog("Verifying search text box is available and able to enter data or not");
				verifyIndividualLabel(driver,newConnectionNameSearch, "SearchBox");
				isClickable(driver, newConnectionNameSearch, "SearchBox", true);				 
				BaseSuite.reportLog("Verify connections button are visible and enabled or not on the new connection page.");
				BaseSuite.reportLog("Verify img of connections are available on the page according to the connection or not");
				List<WebElement> connImg= driver.findElements(connectionImg);
				List<WebElement> connectionList = driver.findElements(connectionNameClick);
				List<String> connName = connectionList.stream().map(s->s.getText()).collect(Collectors.toList());
				List<String> imgName = connImg.stream().map(s->s.getAttribute("src")).collect(Collectors.toList());
				//int j = 0;
				for(int i=0;i<connName.size();i++)
				{
				 boolean dis = connectionList.get(i).isDisplayed();	
				 String name = connName.get(i);				
				 boolean imgDis = imgName.get(i).isEmpty();
				 if(!imgDis)
				 {
					 BaseSuite.validationReportLog(name + " image is visible in the page"); 
				 }
				 else
				 {
					 BaseSuite.reportFailLog(name + "image is not visible in the page", "labelsAndButtonsOnNewConnectionPage");
				 }
				 
				 if(dis)
				 {
					 BaseSuite.validationReportLog(name + " button is displaying in the page");
				 }
				 else
				 {
					 BaseSuite.reportFailLog(name + " button is not displaying in the page", "connectionTabsClickableOrNotOnNewConnectionPage");
				 }
				 boolean ena = connectionList.get(i).isEnabled();
				 if(ena)
				 {
					 BaseSuite.validationReportLog(name + " button is enabled and clickable on the page");
				 }
				 else
				 {
					 BaseSuite.reportFailLog(name + " button is not enabled and not clickable on the page", "connectionTabsClickableOrNotOnNewConnectionPage");
				 }				
				
				}
				BaseSuite.reportLog("Verify page is scrolling or not");
				newConnectionRulepageScroll();
				BaseSuite.validationReportLog("Page scrolled successfully");
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		public String value(WebElement s)
		{
			String pricevalue = s.findElement(listOfConnName).getText();
			return pricevalue;
		}
		
		//now working - need to change logic or -need to remove this method
		public void connectionPagination()
		{
			try
			{
				List<String> page;
				int i=1;
				do
				{
					BaseSuite.reportLog("Verifying pagingation function");
					List<WebElement> row = driver.findElements(listOfConnName);
					List<WebElement> pageNumber = driver.findElements(connPaginationNumber);
					
					page=row.stream().filter(s->s.getText().contains("AutomationTesting_MySql1")).map(s->value(s)).collect(Collectors.toList());
					if(page.size()<1)
					{
						BaseSuite.reportLog("Clicking on the next icon button");
						displayAndClick(driver, connPaginationIcon);
						inVisible(driver, paginationSpinner, Constant.ruleWait);
						BaseSuite.validationReportLog("User navigated on the page :" + pageNumber.get(i).getText());
					}
					else
					{
						BaseSuite.validationReportLog("Connection found using pagination function on page :" + pageNumber.get(i).getText());
					}
					i++;
					
				}while(page.size()<1);
			}
			catch (Exception e) {
				throw new AssertionError("Error occured in this method", e);
			}
		}
		//not working - -need to remove this method
		public boolean ConnectionRowsAndColumns() {

			isDisplayed(driver, clickonConnectionMenu);
			click(driver, clickonConnectionMenu);

			// No.of Columns
			List col = driver.findElements(By.xpath("//span[@class='e-headertext']"));

			System.out.println("No of cols are : " + col.size());

			// No.of rows
			List rows = driver.findElements(By.xpath("//tr//span[@class='e-frame e-icons']"));

			System.out.println("No of rows are : " + rows.size());

			return true;

		}
		//not working --need to remove this method
		public void ConnectionSideBar() {
			isDisplayed(driver, sideBarclick);
			click(driver, sideBarclick);
			BaseSuite.reportLog("Click on the side bar to close the side bar!");
			if ((isDisplayed(driver, clickonConnectionMenu)) && (isDisplayed(driver, sideBarUser)))
			{
				BaseSuite.reportLog("Side bar details are displayed properly in the Connection Page!");
				click(driver, sideBarclick);
				BaseSuite.reportLog("Click on the side bar to open the side bar!");

				if ((isDisplayed(driver, clickonConnectionMenu)) && (isDisplayed(driver, sideBarUser))) {
					BaseSuite.validationReportLog("Side Bar of user page!");
					BaseSuite.reportLog("Opening and closing of side bar is working and displaying the Users/Groups/Roles/Accounts/Workspace Menus!");
				}

			} else {
				BaseSuite.reportFailLog("Side bar details are not displayed properly in the User Page!", "ConnectionSideBar");
			}
		}
		//method to click on connections home page link - tested
		public void connectionHomeLink() {
			isDisplayedInLoop(driver,10,clickonHomeLink);
			if (isDisplayed(driver, clickonHomeLink)) {
				click(driver, clickonHomeLink);					
				BaseSuite.validationReportLog("Home link is displayed successfully and clickable");
			} else {
				BaseSuite.reportFailLog("Home Link is not displayed and clickable", "ConnectionHomeLink");
			}
		}

		//not working -need to remove this method
		public void numberOfConnectionsAndPagination() throws InterruptedException
		{
						
			isDisplayedInLoop(driver, 10, NumberofConnections);
			Thread.sleep(3000);
			String numbers = getText(driver, NumberofConnections);
			
			System.out.println("Number of connections in the list are "+numbers);
			BaseSuite.validationReportLog("Number of connections are displaying in the User Page!");
			BaseSuite.reportLog("Available connections " +numbers );
			
			paginationInsearchfield(driver, PaginationCount);
					
		}
		
		//method to close connection repo left side bar window panel 
		public void closeConnRepoLeftSideBarPanel() {

			isDisplayedInLoop(driver, 10, leftArrow_connection);
			BaseSuite.reportLog("verifying left side arrow to close sidebar panel is visible or not");
			if(isDisplayed(driver, leftArrow_connection)) {

				BaseSuite.validationReportLog("Sidebar close arrow is visible on connection repository home page");
				BaseSuite.reportLog("Clicking on sidebar arrow to close left sidebar window");
				displayAndClick(driver, leftArrow_connection);
				BaseSuite.validationReportLog("Clicked on sidebar arrow to close left sidebar window successfully");
			}else {
				BaseSuite.reportFailLog("sidebar arrow not visible on home page", "closeConnRepoLeftSideBarPanel");
			}
		}


		//method to close connection repo left side bar window panel
		public void openConnRepoLeftSideBarPanel() {

			isDisplayedInLoop(driver, 10, leftArrowOpen_connection);
			BaseSuite.reportLog("verifying left side arrow to open sidebar panel is visible or not");
			if(isDisplayed(driver, leftArrowOpen_connection)) {

				BaseSuite.validationReportLog("Sidebar arrow is visible on connection repository home page");
				BaseSuite.reportLog("Clicking on sidebar arrow to Open left sidebar window panel");
				displayAndClick(driver, leftArrowOpen_connection);
				BaseSuite.validationReportLog("Clicked on sidebar arrow to Open left sidebar window panel successfully");
			}else {
				BaseSuite.reportFailLog("sidebar arrow not visible on home page", "openConnRepoLeftSideBarPanel");
			}
		}
	}
