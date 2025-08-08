package nextgen.automation.workflow.service.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.pageclasses.otherpages.HomePage;

public class InstancesServicePage extends PageUtil {

	WebDriver driver;

	public InstancesServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(InstancesServicePage.class);

	/** ----------------------  By locators ---------------------------------- **/
	
	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));
	By welcomeText=getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));

	By instancesPageTitle = getElementLocator(prop.getProperty("instances.pagetitle"));  
	By instancesFilterApplied = getElementLocator(prop.getProperty("instances.filterApplied")); 
	By instancesFilterAppliedRemove = getElementLocator(prop.getProperty("instances.filterApplied.remove")); 
	
	By breadcrumbHome = getElementLocator(prop.getProperty("instances.listing.breadcrumb.home"));  
	By breadcrumbDataTesting = getElementLocator(prop.getProperty("instances.listing.breadcrumb.datatesting"));
	By breadcrumbInstancesLabel = getElementLocator(prop.getProperty("instances.listing.breadcrumb.Instances"));
	By listingSearchbar = getElementLocator(prop.getProperty("instances.listing.search.bar"));
	By listingSearchButton = getElementLocator(prop.getProperty("instances.listing.search.button"));
	By listingSearchClear = getElementLocator(prop.getProperty("instances.listing.search.clear"));
	By listingButtonCount = getElementLocator(prop.getProperty("instances.listing.button.count"));
	By listingButtonRefresh = getElementLocator(prop.getProperty("instances.listing.button.refresh"));
	
	By listingInstanceIDCount = getElementLocator(prop.getProperty("instances.listing.static.instanceid.count"));
	
	By listingNoRecordsToDisplay = getElementLocator(prop.getProperty("instances.listing.norecordstodisplay"));
	
	By listingPaginationBar = getElementLocator(prop.getProperty("instances.listing.paginationbar"));
	By listingPaginationInfo = getElementLocator(prop.getProperty("instances.listing.paginationinfo"));
	By listingPageNextPageArrow = getElementLocator(prop.getProperty("instances.listing.nextpagearrow"));
	
	
	By advanceSearchTitle = getElementLocator(prop.getProperty("instances.listing.advancesearch.title"));
	By advanceSearchOpen = getElementLocator(prop.getProperty("instances.listing.advancesearch.sidebar.open"));
	By advanceSearchClose = getElementLocator(prop.getProperty("instances.listing.advancesearch.sidebar.close"));
	
	By advanceSearchStatusTitle = getElementLocator(prop.getProperty("instances.advancedSearch.status.label"));
	By advanceSearchStatusOpen = getElementLocator(prop.getProperty("instances.advancedSearch.status.expandButton"));
	By advanceSearchStatusClose = getElementLocator(prop.getProperty("instances.advancedSearch.status.collapseButton"));
	By advanceSearchStatusList = getElementLocator(prop.getProperty("instances.advancedSearch.status.list"));
	
	By advanceSearchTriggeredByTitle = getElementLocator(prop.getProperty("instances.advancedSearch.TriggeredBy.label"));
	By advanceSearchTriggeredByOpen = getElementLocator(prop.getProperty("instances.advancedSearch.TriggeredBy.expandButton"));
	By advanceSearchTriggeredByClose = getElementLocator(prop.getProperty("instances.advancedSearch.TriggeredBy.collapseButton"));
	By advanceSearchTriggeredByList = getElementLocator(prop.getProperty("instances.advancedSearch.TriggeredBy.list"));
	By advanceSearchTriggeredBySearchbar = getElementLocator(prop.getProperty("instances.advancedSearch.TriggeredBy.searchbar"));
	By advanceSearchTriggeredBySearchButton = getElementLocator(prop.getProperty("instances.advancedSearch.TriggeredBy.searchBtn"));
	
	By advanceSearchContextTitle = getElementLocator(prop.getProperty("instances.advancedSearch.context.label"));
	By advanceSearchContextOpen = getElementLocator(prop.getProperty("instances.advancedSearch.context.expandButton"));
	By advanceSearchContextClose = getElementLocator(prop.getProperty("instances.advancedSearch.context.collapseButton"));
	By advanceSearchContextList = getElementLocator(prop.getProperty("instances.advancedSearch.context.list"));
	By advanceSearchContextCheckbox = getElementLocator(prop.getProperty("instances.advancedSearch.context.checkbox"));
	
	By advanceSearchModeTitle = getElementLocator(prop.getProperty("instances.advancedSearch.mode.label"));
	By advanceSearchModeOpen = getElementLocator(prop.getProperty("instances.advancedSearch.mode.expandButton"));
	By advanceSearchModeClose = getElementLocator(prop.getProperty("instances.advancedSearch.mode.collapseButton"));
	By advanceSearchModeList = getElementLocator(prop.getProperty("instances.advancedSearch.mode.list"));
	By advanceSearchModeCheckbox = getElementLocator(prop.getProperty("instances.advancedSearch.mode.checkbox"));
	
	
	String listingStaticColumns = prop.getProperty("instances.listing.column.dynamic");
		
	String listingStaticKillIcon = prop.getProperty("instances.listing.static.killicon");
	String listingStaticDownloadERIcon = prop.getProperty("instances.listing.static.downloadicon");
	String listingStaticExecutionDetailsIcon = prop.getProperty("instances.listing.static.executiondetailsicon");
	
	String listingStaticInstanceId = prop.getProperty("instances.listing.static.instanceid");
	String listingStaticType = prop.getProperty("instances.listing.static.type");
	String listingStaticName = prop.getProperty("instances.listing.static.name");
	String listingStaticId = prop.getProperty("instances.listing.static.id");
	String listingStaticStatus = prop.getProperty("instances.listing.static.status");
	String listingStaticExitCode = prop.getProperty("instances.listing.static.exitcode");
	String listingStaticElapsedTime = prop.getProperty("instances.listing.static.elapsedtime");
	String listingStaticTriggeredDate = prop.getProperty("instances.listing.static.triggereddate");
	String listingStaticTriggeredBy = prop.getProperty("instances.listing.static.triggeredby");
	
	String advanceSearchStatusDynamic = prop.getProperty("instances.advancedSearch.status.dynamic");
	String advanceSearchTriggeredByDynamicCheckbox = prop.getProperty("instances.advancedSearch.TriggeredBy.checkbox.dynamic");
	String advanceSearchContextDynamicCheckbox = prop.getProperty("instances.advancedSearch.context.checkbox.dynamic");
	String advanceSearchModeDynamicCheckbox = prop.getProperty("instances.advancedSearch.mode.checkbox.dynamic");
	
	
	
	/** ----------------------  String locators ---------------------------------- **/

	String modulePageTitle=prop.getProperty("module.pagetitle");
	String moduleTab=prop.getProperty("nextgen.hamberger.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String subModuleHeadingName=prop.getProperty("nextgenmodule.submodule.headingDynamic");
	String dynamicStateElement="$State";
	String dynamicName=prop.getProperty("DynName");
	String dynamicFolderName=prop.getProperty("string.dynamicFolderName");
	String nextgenSubModuleDynamic=prop.getProperty("nextgenmodule.submodule.dynamic");
	String refreshContent=prop.getProperty("string.refreshContent");
	String attributeClass=prop.getProperty("string.attributeClass");
	String attrcheck=prop.getProperty("string.attrcheck");
	String attrUncheck=prop.getProperty("string.attrUncheck");
	String attributeValue=prop.getProperty("string.attributeValue");
	String attributeTextContent=prop.getProperty("string.attributeTextContent");
	String attributeContent="content";
	String attributeTitle=prop.getProperty("string.attributeTitle");
	String attributePlaceholder=prop.getProperty("string.attributePlaceholder");
	String attributeAriaLabel=prop.getProperty("string.attributeAriaLabel");
	String disableContent=prop.getProperty("string.disableContent");
	String descriptionContent=prop.getProperty("string.descriptionContent");
	String copyContent=prop.getProperty("string.copyContent");
	String moveContent=prop.getProperty("string.moveContent");
	String deleteContent=prop.getProperty("string.deleteContent");
	String advanceSearchContent=prop.getProperty("string.AdvanceSearchContent");
	String executorContent=prop.getProperty("string.executorContent");
	String readerContent=prop.getProperty("string.readerContent");
	String ownerContent=prop.getProperty("string.ownerContent");
	String contributorContent=prop.getProperty("string.contributorContent");
	String saveContent=prop.getProperty("string.saveContent");
	String duplicateContent=prop.getProperty("string.duplicate");
	String checkContent=prop.getProperty("string.attrcheck");
	String uncheckContent=prop.getProperty("string.attrUncheck");
	String errorLogTitle=prop.getProperty("string.Error.Log.Title");
	String regexToRemoveBracess=prop.getProperty("regex.bracess");
	String scrollToElementArg=prop.getProperty("ScrollToElementArgument");
	String searchBoxLabel=prop.getProperty("string.searchBox");
	String discardContent=prop.getProperty("string.discardContent");
	String cancelButtonContent=prop.getProperty("string.cancelButtonContent");
	String administrationContent=prop.getProperty("String.administrationContent");
	String dataTestingContent=prop.getProperty("String.dataTestingContent");
	String schedulerContent=prop.getProperty("String.schedulerContent");
	String connectionsContent=prop.getProperty("String.connectionsContent");
	String connectorsContent=prop.getProperty("String.connectorsContent");
	String groupsContent=prop.getProperty("String.groupsContent");
	String usersContent=prop.getProperty("String.usersContent");
	String accountsContent=prop.getProperty("String.accountsContent");
	String workspacesContent=prop.getProperty("String.workspacesContent");
	String rolesContent=prop.getProperty("String.rolesContent");
	String federationsContent=prop.getProperty("String.fedetationsContent");
	String identityProvidersContent=prop.getProperty("String.identityProvidersContent");
	String vaultContent=prop.getProperty("String.vaultContent");
	String fieldContent=prop.getProperty("String.fieldContent");
	String calendarsContent=prop.getProperty("String.calendarsContent");
	String settingsContent=prop.getProperty("String.settingsContent");
	String integrationsContent=prop.getProperty("String.integrationsContent");
	String librariesContent=prop.getProperty("String.librariesContent");
	String configurationsContent=prop.getProperty("String.configurationContent");
	String securityContent=prop.getProperty("String.securityContent");
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String columnContent=prop.getProperty("String.columnContent");
	String tabContent=prop.getProperty("String.tabContent");
	String iconContent=prop.getProperty("String.iconContent");
	String newScheduleContent="New Schedule";
	String hyperlinkContent=prop.getProperty("String.hyperlinkContent");
	String labelContent=prop.getProperty("String.labelContent");
	String masterContent=prop.getProperty("String.masterContent");
	String checkboxContent=prop.getProperty("String.checkboxContent");
	String adminContent=prop.getProperty("String.adminContent");
	String noRecordsToDisplayContent=prop.getProperty("String.noRecordsToDisplayContent");
	String assignAdminAccessContent=prop.getProperty("String.assignAdminAccessContent");
	String revokeAdminAccessContent=prop.getProperty("String.revokeAdminAccessContent");
	String groupNameContent=prop.getProperty("String.groupNameContent");
	String groupContent=prop.getProperty("String.groupContent");
	String scopeContent=prop.getProperty("string.scopeContent");
	String roleContent=prop.getProperty("String.roleContent");
	String typeContent=prop.getProperty("String.typeContent");
	String avatarContent=prop.getProperty("String.avatarContent");
	String adminsContent=prop.getProperty("String.adminsContent");
	String hyphenContent=prop.getProperty("String.hyphenContent");
	String breadcrumbContent=prop.getProperty("String.breadcrumbContent");
	String homeContent=prop.getProperty("String.homeContent");
	String whiteSpace=" ";
	
	String instancesContent="Instances";
	
	String schedulesSubModules = prop.getProperty("instances.submodule.tab");
	
	
	String placeholderSearchInstances = prop.getProperty("placeholder.search.instances");
	
	List<String> instancesColumnNames = Arrays.asList("Instance ID", "Name", "ID", "Status","Exit Code", "Elapsed Time", "Triggered Date", "Triggered By");
	
	
	public boolean clickOnRefreshOnInstancesListingPage() {

		return clickOnButton(driver, listingButtonRefresh, refreshContent, true);
	}
	
	public List<String> validateInstancesTabListingPage() {

		
		HomePage hp=new HomePage(driver);
		List<String> list = new ArrayList<>();
		try {

			BaseSuite.reportLog(hyphenContent+" Validating Instances listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenModuleAndDataTestingSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Instances listing page "+hyphenContent);

			validateElement(driver, breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver, breadcrumbDataTesting, dataTestingContent, hyperlinkContent);

			validateElement(driver, breadcrumbInstancesLabel, instancesContent, labelContent);
			
			validateElement(driver, instancesPageTitle, instancesContent, attributeTitle);

			BaseSuite.reportLog(hyphenContent+" Verifying Search field Instances listing page "+hyphenContent);

			verifySearchField(driver, listingSearchbar, placeholderSearchInstances, placeholderSearchInstances);

			validateElement(driver,listingSearchButton, placeholderSearchInstances, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Instances listing page "+hyphenContent);

			validateButtons(driver, listingButtonCount, 1);

			verifyVisibilityOfButtons(driver, listingButtonRefresh, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on Instances listing page "+hyphenContent);

			List<String> columnNames = instancesColumnNames;

			for (String columnName : columnNames) {
				 validateElement(driver, returnElement(listingStaticColumns, dynamicName, columnName), columnName, columnContent);
			}
				
			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Instances listing page "+hyphenContent);

			list=getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, instancesContent+" listing page");

			BaseSuite.reportLog(hyphenContent+" Validated Instances listing page successfully "+hyphenContent);
			
			clickOnRefreshOnInstancesListingPage();
			
		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateInstancesTabListingPage :: "+e.toString());
			

		}

		return list;

	}
	
	
	public boolean clickOnAdvanceSearchSidebarPanelOpenOrClose(boolean expected) {
		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String action = expected ? "open" : "close";

			BaseSuite.reportLog("Advance search sidebar panel open/close button is visible");

			boolean isSidebarOpen = isDisplayed(driver, advanceSearchTitle);

			if (isSidebarOpen == expected) {

				BaseSuite.validationReportLog("Advance search sidebar panel is already in the expected state "+action);

			} else {
				
				By locator = expected ? advanceSearchClose: advanceSearchOpen;

				BaseSuite.reportLog("Clicking on Advance search sidebar panel to " + action);

				displayAndClick(driver, locator);

				BaseSuite.reportLog("Clicked on Advance search sidebar panel to " + action);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportFailLog("Advance search sidebar panel not properly "+locator, "clickOnFolderSidebarPanelOpen");
					flag = false;
				}else {
					BaseSuite.validationReportLog("Advance search sidebar panel is properly "+action);
				}
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnFolderSidebarPanelOpen :: " + e.toString());
			flag = false;
		}

		return flag;
	}
	
	public boolean searchNameOnInstancesListingPage(String name) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchInstances, placeholderSearchInstances, name);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, listingNoRecordsToDisplay)) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+" is visible ","searchNameOnInstancesListingPage");
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchNameOnInstancesListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}
	
	public String validateNGetValue(By locator, String label, String type, String attribute, boolean checkInput) {

		String actualValue="";
		try {
			
			actualValue=getAttribute(driver, locator, attribute);
			
			actualValue=checkNullValue(actualValue);
			
			if(actualValue.isEmpty() && checkInput) {
				BaseSuite.reportFailLog(label+" "+type+" value not visible : "+attribute, "validateNGetValue");
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateNGetValue :: "+e.toString());

		}
		return actualValue;
	}
	
	public List<String> validateInstacesDetails(List<String> list, int rowNum) {
		
		List<String> columnNames = instancesColumnNames;

		try {
			String num=Integer.toString(rowNum+1);

			String instanceid = validateNGetValue(returnElement(listingStaticInstanceId, dynamicName, num), columnNames.get(0), hyperlinkContent, attributeTextContent, true);

			String type = validateNGetValue(returnElement(listingStaticType, dynamicName, num), "type", iconContent, attributeTitle, true);

			String name = validateNGetValue(returnElement(listingStaticName, dynamicName, num), columnNames.get(1), hyperlinkContent, attributeTextContent, true);

			String wkflid = validateNGetValue(returnElement(listingStaticId, dynamicName, num), columnNames.get(2),  attributeTextContent, attributeTextContent, true);

			String status = validateNGetValue(returnElement(listingStaticStatus, dynamicName, num), columnNames.get(3), attributeTextContent, attributeTextContent, true);

			String exitcode = validateNGetValue(returnElement(listingStaticExitCode, dynamicName, num), columnNames.get(4), attributeTextContent, attributeTextContent, status.equalsIgnoreCase("success"));

			String elapsedtime = validateNGetValue(returnElement(listingStaticElapsedTime, dynamicName, num), columnNames.get(5), attributeTextContent, attributeTextContent, status.equalsIgnoreCase("success"));

			String trdate = validateNGetValue(returnElement(listingStaticTriggeredDate, dynamicName, num), columnNames.get(6), attributeTextContent, attributeTextContent, true);
			
			String trby = validateNGetValue(returnElement(listingStaticTriggeredBy, dynamicName, num), columnNames.get(7), attributeTextContent, attributeTextContent, true);

			trdate = trdate.contains(",") ? trdate.replace(",", " |") : trdate;
			
			list.add(num+","+instanceid+","+type+","+name+","+wkflid+","+status+","+exitcode+","+elapsedtime+","+trdate+","+trby);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateInstacesDetails :: "+e.toString());
		}

		return list;

	}
	
	public void getTableForInstances(List<String> list) {

		try {

			if(!list.isEmpty()) {

				String [][] table = new String[list.size()+1][4];

				String[] header = { "No.", "Instance Id","Type", "Name", "Id", "Status","Exit Code", "Elapsed Time", "Triggered Date", "Triggered By"};

				table[0] = header;

				for (int i = 0; i < list.size(); i++) {

					String num = Integer.toString(i + 1);

					String instanceid = list.get(i).split(",")[1];

					String type = list.get(i).split(",")[2];

					String name = list.get(i).split(",")[3];

					String wkflid = list.get(i).split(",")[4];

					String status = list.get(i).split(",")[5];

					String exitcode = list.get(i).split(",")[6];

					String elapsedtime = list.get(i).split(",")[7];

					String trdate = list.get(i).split(",")[8];
					
					String trby = list.get(i).split(",")[9];

					String[] data = { num, instanceid, type, name, wkflid, status, exitcode, elapsedtime, trdate, trby};

					table[i + 1] = data;

				}

				BaseSuite.reportLog(createHtmlTable1(table,instancesContent));

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("error observed while getTableForScheduleMonitor :: " + e.toString());
		}
	}
	
	
	public boolean getInstancesTable(int totalCount, int tillPage) {
		boolean flag = true;
		
		try {
			
			int totalPages = (int) Math.ceil(totalCount / 20.0);  // Calculate total number of pages

			for (int pn = 1; pn <= totalPages; pn++) {
				
				List<String> list = new ArrayList<>();
				
				BaseSuite.reportLog("Checking records on page : "+pn);

				// Calculate the number of records to process on this page
				int size = driver.findElements(listingInstanceIDCount).size();
				
				BaseSuite.reportLog("# of records on page : "+pn+ " is :: "+size);
				
				if(pn != totalPages && size!=20) {
					flag=false;
					BaseSuite.reportFailLog("Actual record count not equal to 20 : "+size, "getInstancesTable");
				}

				for (int i = 0; i < size; i++) {
					list = validateInstacesDetails(list, i);
				}
				
				getTableForInstances(list);
				
				if(pn==tillPage) { break;}
				// Click next page if not on the last page
				if (pn < totalPages) {
					displayAndClick(driver, listingPageNextPageArrow, "next page"); 
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
				getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, instancesContent+" listing page");
				
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
			
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "error observed while getInstancesTable :: " + e.toString());
			flag=false;
		} 
		return flag;

	}
	
	public boolean validateInstancesOnListingPage() {
	    try {
	        List<String> paginationInfo = validateInstancesTabListingPage();
	        
	        if (paginationInfo == null || paginationInfo.size() < 4) {
	            BaseSuite.reportErrorLog(null, "Invalid pagination info received.");
	            return false;
	        }

	        int totalRecords = Integer.parseInt(paginationInfo.get(1));
	        int totalPages = Integer.parseInt(paginationInfo.get(3));

	        if (totalRecords == 0) {
	        	BaseSuite.reportFailLog("Zero instance are displayed ", "validateInstancesOnListingPage");
	            return true;
	        }
	        
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

	        return getInstancesTable(totalRecords, Math.min(totalPages, 1));

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(e, "Error observed while validateInstancesOnListingPage : " + e.toString());
	        return false;
	    }
	}
	
	/**----------------------------- Instance Code --------------------------**/

	By intanceTabButton=getElementLocator(prop.getProperty("Instance.tab.button"));
	By intanceFilterRunningStateButton=getElementLocator(prop.getProperty("Instance.filter.runningState.button"));
	By instanceGridRunningStatus=getElementLocator(prop.getProperty("Instance.grid.status.running"));
	By instanceGridRefreshButton=getElementLocator(prop.getProperty("Instance.grid.refresh.button"));
	By instanceGridRunningStateStopIcon=getElementLocator(prop.getProperty("Instance.grid.running.state.stopIcon"));

	By workflowDetailsRecentRunsStopExecutionPopUpTitle=getElementLocator(prop.getProperty("workflow.details.stop.execution.title"));
	By workflowDetailsRecentRunsStopExecutionPopUpContent=getElementLocator(prop.getProperty("workflow.details.stop.execution.content"));
	By workflowDetailsRecentRunsStopExecutionPopUpStopBtn=getElementLocator(prop.getProperty("workflow.details.stop.execution.stopbtn"));
	By workflowDetailsRecentRunsStopExecutionPopUpCancelBtn=getElementLocator(prop.getProperty("workflow.details.stop.execution.cancelbtn"));
	
	String stringRunning=prop.getProperty("string.running");
	String cancelContent=prop.getProperty("string.cancelContent");
	String stopContent=prop.getProperty("string.StopContent");

	public boolean stopAllRunningStateExecutionOnInstanceTab(boolean flag) {

		
		try {
			clickOnButton(driver, intanceTabButton, "Instance Tab", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, intanceFilterRunningStateButton, stringRunning, flag);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			while (isDisplayed(driver, instanceGridRunningStatus)) {

				isDisplayedInLoop(driver, 3, instanceGridRunningStatus);
				if (isDisplayed(driver, instanceGridRunningStatus)) {

					clickOnButton(driver, instanceGridRunningStateStopIcon, "Stop Icon", true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isDisplayedInLoop(driver, 3, workflowDetailsRecentRunsStopExecutionPopUpTitle);

					if (isDisplayed(driver, workflowDetailsRecentRunsStopExecutionPopUpTitle)) {

						BaseSuite.reportLog("Stop Execution popup window is visible on instance tab");

						flag = new WorkflowPage(driver).validatePopupWindowContent(flag, workflowDetailsRecentRunsStopExecutionPopUpTitle,
								workflowDetailsRecentRunsStopExecutionPopUpContent, "Stop Execution",
								"Are you sure, you want to stop the execution?");

						if (flag) {

							verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsStopExecutionPopUpCancelBtn,
									cancelContent, true);

							verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsStopExecutionPopUpStopBtn,
									stopContent, true);

							flag = clickOnButton(driver, workflowDetailsRecentRunsStopExecutionPopUpStopBtn,
									stopContent, true);
						}
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					} else {
						BaseSuite.reportFailLog("Stop Execution popup window is not visible on instance tab",
								"stopAllRunningStateExecutionOnInstanceTab");
					}
				} 

				clickOnButton(driver, instanceGridRefreshButton, "Refresh Icon", true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" stopAllRunningStateExecutionOnInstanceTab ");

			flag=false;
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
