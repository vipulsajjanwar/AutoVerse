package nextgen.automation.scheduler.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.DataIntegrityUtils;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.workflow.service.pages.DataTestingParameters;
import nextgen.automation.workflow.service.pages.WorkflowPage;

public class ScheduleMonitorServicePage extends PageUtil {

	WebDriver driver;

	public ScheduleMonitorServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(ScheduleMonitorServicePage.class);

	public static final String SCHEDULEEXCELFILEPATH = DIR_PATH+ Constant.NEXTGEN_SCHEDULER_TESTDATA_EXCEL_PATH;

	/** ----------------------  By locators ---------------------------------- **/

	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));
	By welcomeText=getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));

	By schedulePageTitle = getElementLocator(prop.getProperty("schedules.pagetitle"));  
	By monitorPageTitle = getElementLocator(prop.getProperty("monitor.pagetitle"));  
	By breadcrumbHome = getElementLocator(prop.getProperty("monitor.listing.breadcrumb.home"));  
	By breadcrumbscheduler = getElementLocator(prop.getProperty("monitor.listing.breadcrumb.scheduler"));
	By breadcrumbscheduleMonitor = getElementLocator(prop.getProperty("monitor.listing.breadcrumb.schedulesmonitor"));

	By listingSearchbar = getElementLocator(prop.getProperty("monitor.listing.search.bar"));
	By listingSearchButton = getElementLocator(prop.getProperty("monitor.listing.search.button"));
	By listingSearchClear = getElementLocator(prop.getProperty("monitor.listing.search.clear"));

	By listingButtonCount = getElementLocator(prop.getProperty("schedules.listing.button.count"));
	By listingButtonRefresh = getElementLocator(prop.getProperty("monitor.listing.button.refresh"));

	By listingNoRecordsToDisplay = getElementLocator(prop.getProperty("schedules.listing.norecordstodisplay"));

	By listingColumnName = getElementLocator(prop.getProperty("monitor.listing.column.name"));
	By listingColumnFolder = getElementLocator(prop.getProperty("monitor.listing.column.folder"));
	By listingColumnInstanceType = getElementLocator(prop.getProperty("monitor.listing.column.instancetype"));
	By listingColumnLastTriggeredTime = getElementLocator(prop.getProperty("monitor.listing.column.lasttriggeredtime"));
	By listingColumnMissedTriggeredTime = getElementLocator(prop.getProperty("monitor.listing.column.missedtriggerdtime"));
	By listingColumnTriggeredBy = getElementLocator(prop.getProperty("monitor.listing.column.triggedby"));
	By listingColumnTriggeredType = getElementLocator(prop.getProperty("monitor.listing.column.triggedtype"));

	By listingFolderSearchTitle = getElementLocator(prop.getProperty("monitor.listing.foldersearch.title"));
	By listingFolderSearchRefresh = getElementLocator(prop.getProperty("monitor.listing.foldersearch.refresh"));
	By listingFolderSearchExpand = getElementLocator(prop.getProperty("monitor.listing.foldersearch.expand"));
	By listingFolderSearchCollapse = getElementLocator(prop.getProperty("monitor.listing.foldersearch.collapse"));
	By listingFolderSearchbar = getElementLocator(prop.getProperty("monitor.listing.foldersearch.search"));
	By listingFolderSearchbutton = getElementLocator(prop.getProperty("monitor.listing.foldersearch.button"));
	By listingFolderSearchclear = getElementLocator(prop.getProperty("monitor.listing.foldersearch.clear"));

	By listingPaginationBar = getElementLocator(prop.getProperty("monitor.listing.paginationbar"));
	By listingPaginationInfo = getElementLocator(prop.getProperty("monitor.listing.paginationinfo"));
	By listingPageNextPageArrow = getElementLocator(prop.getProperty("monitor.listing.nextpagearrow"));

	By addnewScheCancelButton = getElementLocator(prop.getProperty("schedules.addnewsche.cancel.button"));
	By configFieldsDetailsDiscardPoupupTitle=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.title"));
	By configFieldsDetailsDiscardPoupupContent=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.content"));
	By configFieldsDetailsDiscardPoupupDiscardButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.discardbutton"));
	By configFieldsDetailsDiscardPoupupCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.cancelbutton"));

	By advancedSearchTitle=getElementLocator(prop.getProperty("workflow.AdvancedSearch.title"));
	By advancedSearchExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.expand"));
	By advancedSearchCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.collapse"));
	By parametersAppliedFilterCross=getElementLocator(prop.getProperty("monitor.applied.filter.cross.icon"));
	By advancedSearchUpdatedByLabel=getElementLocator(prop.getProperty("monitor.advancedSearch.TriggeredBy.lable"));
	By advancedSearchUpdatedByExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.TriggeredBy.expandButton"));
	By advancedSearchUpdatedByCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.TriggeredBy.collapseButton"));
	By advancedSearchUpdatedByList=getElementLocator(prop.getProperty("monitor.advancedSearch.TriggeredBy.list"));
	By advancedSearchUpdatedBySearchBar=getElementLocator(prop.getProperty("monitor.advancedSearch.TriggeredBy.searchbar"));
	By advancedSearchLastUpdatedLabel=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.lable"));
	By advancedSearchLastUpdatedExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.expandButton"));
	By advancedSearchLastUpdatedCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.collapseButton"));
	By advancedSearchLastUpdatedFrom=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.fromField"));
	By advancedSearchLastUpdatedFromDateIcon=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.fromField.dateicon"));
	By advancedSearchLastUpdatedTo=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.toField"));
	By advancedSearchLastUpdatedToDateIcon=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.toField.dateicon"));
	By advancedSearchLastUpdatedCalanderDatePopup=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.datePopup"));
	By advancedSearchLastUpdatedCalanderCurrentValue=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.currentYearMon"));
	By advancedSearchLastUpdatedCalanderPreviousBtn=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.previousMonBtn"));
	By advancedSearchLastUpdatedCalanderNextBtn=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.nextMonBtn"));
	By advancedSearchLastUpdatedCalanderTodayBtn=getElementLocator(prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.todayBtn"));

	By advancedSearchTypeLabel=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.lable"));
	By advancedSearchTypeExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.expandButton"));
	By advancedSearchTypeCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.collapseButton"));
	By advancedSearchTypeList=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.list"));

	By advancedInstanceTypeLabel=getElementLocator(prop.getProperty("monitor.advancedSearch.InstanceType.lable"));
	By advancedInstanceTypeExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.InstanceType.expandButton"));
	By advancedInstanceTypeCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.InstanceType.collapseButton"));
	By advancedInstanceTypeeList=getElementLocator(prop.getProperty("monitor.advancedSearch.InstanceType.list"));

	By listingPageStaticCount = getElementLocator(prop.getProperty("schedules.listing.static.count"));
	By listingPageStaticNameList = getElementLocator(prop.getProperty("schedules.listing.static.name.list"));
	By listingPageStaticLastriggeredTimeList =getElementLocator(prop.getProperty("monitor.listing.static.lasttriggeredtimeList"));


	By nextgenTabDataTesting=getElementLocator(prop.getProperty("nextgenmodule.datatesting.tab"));
	By nextgenTabDashboardandReporting=getElementLocator(prop.getProperty("nextgenmodule.dashboard.tab"));
	By nextgenTabScheduler=getElementLocator(prop.getProperty("nextgenmodule.scheduler.tab"));
	By nextgenTabConnector=getElementLocator(prop.getProperty("nextgenmodule.connector.tab"));
	By nextgenTabAdmin=getElementLocator(prop.getProperty("nextgenmodule.admin.tab"));
	By breadcrumbDashboardAndReporting=getElementLocator(prop.getProperty("breadcrumb.dashboardandreporting"));
	By moduleUserPageTitle=getElementLocator(prop.getProperty("module.pagetitle.users"));

	String advanceSearchUpdatedByCheckbox=prop.getProperty("monitor.advancedSearch.TriggeredBy.checkbox");
	String advanceSearchLastUpdatedCalanderSelectMon=prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.selectMonYear");
	String advanceSearchLastUpdatedCalanderSelectDate=prop.getProperty("monitor.advancedSearch.LastTriggeredTime.calander.selectdate");
	String updatedbynameOnListing=prop.getProperty("parameters.listingpage.updatedbyname");
	String advanceSearchTypeCheckbox=prop.getProperty("monitor.advancedSearch.Type.checkbox");
	String advanceInstanceTypeChip=prop.getProperty("monitor.advancedSearch.InstanceType.dynamicchip");
	String advanceInstanceTypeChipState=prop.getProperty("monitor.advancedSearch.InstanceType.dynamicchip.state");

	String schedulesSubModules = prop.getProperty("monitor.submodule.tab");
	String listingFolderNameDynamiccheckbox = prop.getProperty("monitor.listing.foldersearch.dynamic.checkbox");
	String listingFolderPaneOpenCloseDynamicIcon = prop.getProperty("monitor.listing.folderpanel.openclosebutton");

	String listingDynamicAvatar = prop.getProperty("monitor.listing.dynamic.avatar");
	String listingDynamicName = prop.getProperty("monitor.listing.dynamic.name");
	String listingDynamicFolder = prop.getProperty("monitor.listing.dynamic.folder");
	String listingDynamicInstanceType = prop.getProperty("monitor.listing.dynamic.instancetype");
	String listingDynamicLastTriggeredTime = prop.getProperty("monitor.listing.dynamic.lasttriggeredtime");
	String listingDynamicMissedTriggeredTime = prop.getProperty("monitor.listing.dynamic.missedtriggerdtime");
	String listingDynamicTriggeredBy = prop.getProperty("monitor.listing.dynamic.triggedby");
	String listingDynamicTriggeredType = prop.getProperty("monitor.listing.dynamic.triggedtype");

	String listingStaticAvatar = prop.getProperty("monitor.listing.static.avatar");
	String listingStaticName = prop.getProperty("monitor.listing.static.name");
	String listingStaticFolder = prop.getProperty("monitor.listing.static.folder");
	String listingStaticInstanceType = prop.getProperty("monitor.listing.static.instancetype");
	String listingStaticLastTriggeredTime = prop.getProperty("monitor.listing.static.lasttriggeredtime");
	String listingStaticMissedTriggeredTime = prop.getProperty("monitor.listing.static.missedtriggerdtime");
	String listingStaticTriggeredBy = prop.getProperty("monitor.listing.static.triggedby");
	String listingStaticTriggeredType = prop.getProperty("monitor.listing.static.triggedtype");

	By listingAllAvatar = getElementLocator(prop.getProperty("monitor.listing.all.avatar"));
	By listingAllName = getElementLocator(prop.getProperty("monitor.listing.all.name"));
	By listingAllFolder = getElementLocator(prop.getProperty("monitor.listing.all.folder"));
	By listingAllInstanceType = getElementLocator(prop.getProperty("monitor.listing.all.instancetype"));
	By listingAllLastTriggeredTime = getElementLocator(prop.getProperty("monitor.listing.all.lasttriggeredtime"));
	By listingAllMissedTriggeredTime = getElementLocator(prop.getProperty("monitor.listing.all.missedtriggerdtime"));
	By listingAllTriggeredBy = getElementLocator(prop.getProperty("monitor.listing.all.triggedby"));
	By listingAllTriggeredType = getElementLocator(prop.getProperty("monitor.listing.all.triggedtype"));

	String placeholderSearchSchedule=prop.getProperty("monitor.placeholder.search.schedule");
	String placeholderSearchFolder=prop.getProperty("monitor.placeholder.search.folder");
	String placeholderSearchUser=prop.getProperty("parameters.placeholder.search.user");

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

	String schedulesContent="Schedules";
	String scheduleMonitorContent="Schedule Monitor";
	String clickingOnContent="Clicking on ";
	String clickedOnContent="Clicked on ";
	String verifyingContent="Verifying ";
	String isVisibleContent=" is visible";
	String folderContent ="Folder";
	String instanceTypeContent="Instance Type";
	String lastTriggerTimeContent="Last Triggered Time";
	String missTriggerTimeContent="Missed Triggered Time";
	String triggerByContent="Triggered By";
	String triggerTypeContent="Triggered Type" ;
	String listingContent=" listing";

	public boolean clickOnRefreshOnScheduleMonitorListingPage() {

		return clickOnButton(driver, listingButtonRefresh, refreshContent, true);
	}

	public boolean clickOnRefreshOnScheduleMonitorListingPageWithValidation() {
		boolean flag=true;

		try {
			clickOnButton(driver, listingButtonRefresh, refreshContent, true);

			waitForExecution(100);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
						scheduleMonitorContent+" tab refresh authorization message");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnRefreshOnScheduleMonitorListingPageWithValidation :: "+e.toString());
		}

		return flag;
	}

	public boolean clickOnScheduleMonitorTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, monitorPageTitle);

			if(isDisplayed(driver, addnewScheCancelButton)) { clickOnButton(driver, addnewScheCancelButton, cancelButtonContent, true);}

			if(elementNotVisible(driver, monitorPageTitle)) {

				isDisplayedInLoop(driver, 3, returnElement(schedulesSubModules, dynamicName, scheduleMonitorContent));

				if(isDisplayed(driver, returnElement(schedulesSubModules, dynamicName, scheduleMonitorContent))) {

					flag = isClickable(driver, returnElement(schedulesSubModules, dynamicName, scheduleMonitorContent), scheduleMonitorContent+whiteSpace+tabContent, true);

					if(flag) {

						BaseSuite.reportLog(clickingOnContent+scheduleMonitorContent+whiteSpace+tabContent);

						displayAndClick(driver,  returnElement(schedulesSubModules, dynamicName, scheduleMonitorContent));

						handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);

						BaseSuite.validationReportLog(clickedOnContent+scheduleMonitorContent+whiteSpace+tabContent);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, monitorPageTitle, scheduleMonitorContent, attributeTitle);
					}

				}else {
					BaseSuite.reportFailLog(scheduleMonitorContent+" tab not visible", "clickOnScheduleMonitorTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnScheduleMonitorTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateScheduleMonitorTabListingPage() {

		boolean flag = true;
		HomePage hp=new HomePage(driver);
		String pageContent= " listing page ";
		try {

			BaseSuite.reportLog(hyphenContent+" Validating "+scheduleMonitorContent+pageContent+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndSchedulerSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on "+scheduleMonitorContent+pageContent+hyphenContent);

			validateElement(driver, breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver, breadcrumbscheduler, schedulerContent, hyperlinkContent);

			validateElement(driver, breadcrumbscheduleMonitor, scheduleMonitorContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Search field "+scheduleMonitorContent+pageContent+hyphenContent);

			verifySearchField(driver, listingSearchbar, placeholderSearchSchedule, placeholderSearchSchedule);

			validateElement(driver,listingSearchButton, placeholderSearchSchedule, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on "+scheduleMonitorContent+pageContent+hyphenContent);

			validateButtons(driver, listingButtonCount, 1);

			verifyVisibilityOfButtons(driver, listingButtonRefresh, refreshContent, true);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on "+scheduleMonitorContent+pageContent+hyphenContent);

			validateElement(driver, listingColumnName, "Name",columnContent);
			validateElement(driver, listingColumnFolder, folderContent, columnContent);
			validateElement(driver, listingColumnInstanceType, instanceTypeContent,columnContent);
			validateElement(driver, listingColumnLastTriggeredTime, lastTriggerTimeContent,columnContent);
			validateElement(driver, listingColumnMissedTriggeredTime, missTriggerTimeContent,columnContent);
			validateElement(driver, listingColumnTriggeredBy, triggerByContent,columnContent);
			validateElement(driver, listingColumnTriggeredType, triggerTypeContent,columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on "+scheduleMonitorContent+pageContent+hyphenContent);

			getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleMonitorContent+pageContent);

			validateElement(driver, listingFolderSearchTitle, "Folder Search", attributeTitle);

			validateElement(driver, listingFolderSearchRefresh, "Folder Search Refresh", iconContent);

			clickOnRefreshFolderIcon();

			verifySearchField(driver, listingFolderSearchbar, placeholderSearchFolder, placeholderSearchFolder);

			validateElement(driver,listingFolderSearchbutton, placeholderSearchFolder, iconContent);

			BaseSuite.reportLog(hyphenContent+" Validated "+scheduleMonitorContent+pageContent+" successfully "+hyphenContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateScheduleMonitorTabListingPage :: "+e.toString());
			flag=false;

		}

		return flag;

	}

	public boolean clickOnFolderSidebarPanelOpenOrClose(boolean expected) {
		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String action = expected ? "open" : "close";

			BaseSuite.reportLog("Folder sidebar panel open/close button is visible");

			boolean isSidebarOpen = isDisplayed(driver, listingFolderSearchTitle);

			if (isSidebarOpen == expected) {

				BaseSuite.validationReportLog("Folder sidebar panel is already in the expected state "+action);

			} else {
				String dyamicVal =  expected ? "close" : "open";

				BaseSuite.reportLog("Clicking on Folder sidebar panel to " + action);

				displayAndClick(driver, returnElement(listingFolderPaneOpenCloseDynamicIcon, dynamicName, dyamicVal));

				BaseSuite.reportLog("Clicked on Folder sidebar panel to " + action);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(isDisplayed(driver, returnElement(listingFolderPaneOpenCloseDynamicIcon, dynamicName, dyamicVal))) {

					BaseSuite.reportFailLog("Folder sidebar panel not properly "+dyamicVal, "clickOnFolderSidebarPanelOpen");
					flag = false;
				}else {
					BaseSuite.validationReportLog("Folder sidebar panel is properly "+action);
				}
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnFolderSidebarPanelOpen :: " + e.toString());
			flag = false;
		}

		return flag;
	}

	public boolean searchScheduleNameOnMonitorListingPage(String scheduleName) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, scheduleName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, listingNoRecordsToDisplay)) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+" is visible ","searchScheduleNameOnMonitorListingPage");
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchScheduleNameOnMonitorListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public By getDynamicLocator(String locator, String folderPath, String name) {

		return returnTwoElements(locator, dynamicFolderName, folderPath, dynamicName, name);
	}

	public boolean validateValues(By locator, String label, String input, String type, String attribute, boolean checkInput) {
		boolean flag=true;
		try {

			flag=validateElement(driver, locator, label, type);

			if(!checkInput) { return flag;}

			flag=validateValueWithActual(driver, locator, label, input, attribute);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateValues :: "+e.toString());
			flag=false;

		}
		return flag;
	}

	public String validateNGetValue(By locator, String label, String input, String type, String attribute, boolean checkInput) {

		String actualValue="";
		try {
			log.info(label+input+type+checkInput);
			/**validateElement(driver, locator, label, type);*/

			actualValue=getAttribute(driver, locator, attribute);
			
			actualValue=checkNullValue(actualValue);
			
			actualValue=actualValue.isEmpty() ? " " : actualValue;

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateNGetValue :: "+e.toString());

		}
		return actualValue;
	}

	public boolean validateSchedulesOnMonitorListingPage(String name, String folder, List<String> inputs) {

		boolean flag=true;

		try {

			BaseSuite.reportLog(hyphenContent+hyphenContent+" verifying schedule details on "+scheduleMonitorContent+" listing page "+hyphenContent+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, name);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateValues(getDynamicLocator(listingDynamicAvatar, folder, name), typeContent, inputs.get(0), iconContent, attributeTextContent, false);

				validateValues(getDynamicLocator(listingDynamicName, folder, name), "Name", name, hyperlinkContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingDynamicFolder, folder, name), folderContent, folder, attributeTextContent, attributeTitle, true);

				validateValues(getDynamicLocator(listingDynamicInstanceType, folder, name), instanceTypeContent, "Fired", attributeTextContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingDynamicLastTriggeredTime, folder, name), lastTriggerTimeContent, inputs.get(1), attributeTextContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingDynamicMissedTriggeredTime, folder, name), missTriggerTimeContent, "", attributeTextContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingDynamicTriggeredBy, folder, name), triggerByContent, inputs.get(2), attributeTextContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingDynamicTriggeredType, folder, name), triggerTypeContent, inputs.get(3), attributeTextContent, attributeTextContent, true);

			}

			getScheduleMonitorListingPageTable("1", false, "");

			clickOnRefreshOnScheduleMonitorListingPage();

		}catch (Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateSchedulesOnMonitorListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	/** Advance Search */

	public void removeAppliedFilterofParameter() {

		isDisplayedInLoop(driver, 2, parametersAppliedFilterCross);

		if(isDisplayed(driver, parametersAppliedFilterCross)) {

			displayAndClick(driver, parametersAppliedFilterCross);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		}
	}

	public void searchUser(By searchLocator,String userName) {

		try {
			verifySearchField(driver, searchLocator, placeholderSearchUser, placeholderSearchUser);

			BaseSuite.reportLog(" Entering value : "+userName);

			displayAndClick(driver, searchLocator);

			clear_Click_SendKeys(driver, 4, searchLocator, userName);

			BaseSuite.reportLog(" Entered value : "+userName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" searchUser "+e.toString());

		}		
	}

	public boolean selectcheckbox(By locator, String label) {
		boolean flag=true;

		try {
			isDisplayedInLoop(driver, 10, locator);

			if(isDisplayed(driver, locator)) {

				String acs=getAttribute(driver,locator, attributeClass);

				if(!acs.contains(checkContent) || acs.contains(uncheckContent)) {

					BaseSuite.reportLog(" Clicking on checkbox "+label);

					isDisplayedInLoop(driver, 10, locator);

					displayAndClick(driver, locator);

					BaseSuite.validationReportLog(label+" checkbox is selected");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportLog(label+" type is checkbox already selected");
					flag=false;
				}
			}else {
				BaseSuite.reportFailLog("Checkbox not visible for "+label, "selectcheckbox");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" selectcheckbox :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateNSelectUpdatedByUserInAdvanceSearch(String userNAme,String fullName,boolean checkstatus) {
		WorkflowPage wp = new WorkflowPage(driver);
		boolean flag=true;
		try {


			verifyIndividualLabel(driver, advancedSearchUpdatedByLabel, "Updated By");

			if(isDisplayed(driver, advancedSearchUpdatedByExpand)) {

				displayAndClick(driver, advancedSearchUpdatedByExpand);
			}

			if(!userNAme.isEmpty()) {

				BaseSuite.reportLog(hyphenContent+"Selecting user : "+userNAme+" "+hyphenContent);

				searchUser(advancedSearchUpdatedBySearchBar, userNAme);

				By locator = returnElement(advanceSearchUpdatedByCheckbox, dynamicName, fullName);

				isDisplayedInLoop(driver, 4, locator);

				if(isDisplayed(driver, locator)) {
					if(checkstatus) {

						selectcheckbox(locator, userNAme);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}else {
						wp.selectUncheckbox(locator, userNAme);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog(userNAme+" username not found kindly check", "validateNSelectUpdatedByUserInAdvanceSearch");
					flag=false;
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectUpdatedByUserInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	//validate and select last updated dates in advanced search
	public boolean validateNSelectLastUpdatedInAdvanceSearch(String startDate, String endDate) {
		WorkflowPage wp = new WorkflowPage(driver);
		boolean flag=true;
		try {

			javascript(driver, scrollToElementArg, advancedSearchLastUpdatedLabel);

			verifyIndividualLabel(driver, advancedSearchLastUpdatedLabel, "Last Updated");

			if(isDisplayed(driver, advancedSearchLastUpdatedExpand)) {

				displayAndClick(driver, advancedSearchLastUpdatedExpand);
			}

			BaseSuite.reportLog(hyphenContent+"Selecting date from : "+startDate+" to : "+endDate+hyphenContent);

			wp.compareTwoDates(flag, "M/d/yyyy", startDate, endDate);

			javascript(driver, scrollToElementArg, advancedSearchLastUpdatedFrom);

			if(!startDate.isEmpty() && isDisplayed(driver, advancedSearchLastUpdatedFrom) ) {

				BaseSuite.validationReportLog("From field is visible");

				verifyPlaceHolderValue(driver,advancedSearchLastUpdatedFrom, "From", "From");

				isEditable(driver, advancedSearchLastUpdatedFrom, "From");

				flag=wp.selectDate(flag, advancedSearchLastUpdatedFromDateIcon, startDate);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=wp.validateLastUpdateDateSelected(flag, advancedSearchLastUpdatedFrom, startDate);

			}
			if(flag) {
				javascript(driver, scrollToElementArg, advancedSearchLastUpdatedTo);

				if(!endDate.isEmpty() && isDisplayed(driver, advancedSearchLastUpdatedTo) ) {

					BaseSuite.validationReportLog("To field is visible");

					verifyPlaceHolderValue(driver, advancedSearchLastUpdatedTo, "To", "To");

					isEditable(driver, advancedSearchLastUpdatedTo, "To");

					flag=wp.selectDate(flag, advancedSearchLastUpdatedToDateIcon, endDate);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=wp.validateLastUpdateDateSelected(flag, advancedSearchLastUpdatedTo, endDate);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectLastUpdatedInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void printlist(By locator, String label , String attribute) {
		List<WebElement> types = getElements(driver, locator);

		for(int i =0;i<types.size();i++) {

			String typename = types.get(i).getAttribute(attribute);

			BaseSuite.reportLog((i+1)+". "+typename+" "+label+" "+isVisibleContent);

		}
	}

	public boolean validateNSelectTypeInAdvanceSearch(String typeValue, boolean checkStatus) {
		WorkflowPage wp = new WorkflowPage(driver);

		try {
			verifyIndividualLabel(driver, advancedSearchTypeLabel, "Type");

			if (isDisplayed(driver, advancedSearchTypeExpand)) {
				displayAndClick(driver, advancedSearchTypeExpand);
			}

			printlist(advancedSearchTypeList, "type", attributeTextContent);

			if (typeValue.isEmpty()) return true;

			BaseSuite.reportLog(hyphenContent+" Selecting Schedule type : "+typeValue+" "+hyphenContent);

			By locator = returnElement(advanceSearchTypeCheckbox, dynamicName, typeValue);

			isDisplayedInLoop(driver, 0, locator);

			if (!isDisplayed(driver, locator)) {
				BaseSuite.reportFailLog(typeValue + " type not found kindly check", "validateNSelectTypeInAdvanceSearch");
				return false;
			}

			if (checkStatus) {
				selectcheckbox(locator, typeValue);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			} else {
				wp.selectUncheckbox(locator, typeValue);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle + " validateNSelectTypeInAdvanceSearch :: " + e.toString());
			return false;
		}

		return true;
	}

	public boolean checkFieldActiveOrNot(By locator, String label, String attribute) {

		String isActive = getAttribute(driver, locator, attribute);

		if(isActive.contains("e-active")) {

			BaseSuite.reportLog(label+" is Active/Selected");
			return true;
		}else {

			BaseSuite.reportLog(label+" is not Active/Selected");
			return false;
		}

	}

	public boolean validateNSelectInstanceTypeInAdvanceSearch(String typeValue, boolean checkStatus) {

		try {
			verifyIndividualLabel(driver, advancedInstanceTypeLabel, instanceTypeContent);

			if (isDisplayed(driver, advancedInstanceTypeExpand)) {
				displayAndClick(driver, advancedInstanceTypeExpand);
			}

			printlist(advancedInstanceTypeeList, instanceTypeContent, attributeTextContent);

			if (typeValue.isEmpty()) return true;

			BaseSuite.reportLog(hyphenContent+" Selecting Instance type : "+typeValue+" "+hyphenContent);

			By locator = returnElement(advanceInstanceTypeChip, dynamicName, typeValue);
			By locatorState = returnElement(advanceInstanceTypeChipState, dynamicName, typeValue);

			isDisplayedInLoop(driver, 0, locator);

			if (!isDisplayed(driver, locator)) {
				BaseSuite.reportFailLog(typeValue + " Instance type not found kindly check", "validateNSelectInstanceTypeInAdvanceSearch");
				return false;
			}

			boolean isActive = checkFieldActiveOrNot(locatorState, typeValue, attributeClass);

			if (isActive != checkStatus) {
				displayAndClick(driver, locator, typeValue);
			} else {
				BaseSuite.reportLog(typeValue + " Instance type is already in expected condition : " + (checkStatus ? "Selected" : "Not Selected"));
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle + " validateNSelectInstanceTypeInAdvanceSearch :: " + e.toString());
			return false;
		}

		return true;
	}


	public boolean advanceSearchFunctionalityOnScheduleMonitorScreen(boolean clearAll, String advanceSearchRef) {

		boolean flag = true;
		try {

			if(clearAll) {removeAppliedFilterofParameter();}

			verifyIndividualLabel(driver, advancedSearchTitle, advanceSearchContent);

			if(isDisplayed(driver, advancedSearchExpand)) {

				displayAndClick(driver, advancedSearchExpand);
			}

			String [] ref = !advanceSearchRef.isEmpty() ? advanceSearchRef.split(",") : new String [] {""};

			int count = 1;

			for(String rf : ref) {

				BaseSuite.reportLog(hyphenContent + " Applying advance search filter - Iteration : " + count + hyphenContent);

				DataTestingParameters param = SchedulesServicePage.setAdvanceSearchParamUsingExcel(SCHEDULEEXCELFILEPATH, rf);

				validateNSelectTypeInAdvanceSearch(param.getType(), true);

				validateNSelectInstanceTypeInAdvanceSearch(param.getInstanceId(), true);

				validateNSelectUpdatedByUserInAdvanceSearch(param.getUserName(), param.getFullName(), true);

				validateNSelectLastUpdatedInAdvanceSearch(param.getLastUpdatedFrom(), param.getLastUpdatedTo());

				count++; // increment counter
			}

			getScheduleMonitorListingPageTable(false);

			BaseSuite.reportLog(hyphenContent + " Applied advance search filter " + hyphenContent);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " advanceSearchFunctionalityOnScheduleMonitorScreen :: " + e.toString());
			return false;
		}

		return flag;

	}

	public boolean validateRefreshButtonFunctionalityOnMonitorScreen() {

		boolean flag = true;
		try {

			removeAppliedFilterofParameter();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, BaseClassUtil.generateRandomString(5));

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> before = getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleMonitorContent+" listing ");

			flag=clickOnRefreshOnScheduleMonitorListingPage();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> after = getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleMonitorContent+listingContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Totol records count before refreshing page is : "+before.get(1));
			BaseSuite.reportLog("Totol records count after refreshing page is : "+after.get(1));

			if(Integer.parseInt(after.get(1))==0) {
				return flag;
			}

			flag=stringOutput(after.get(1), before.get(1), false);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateRefreshButtonFunctionalityOnMonitorScreen :: " + e.toString());
			return false;
		}

		return flag;


	}

	public List<String> validateScheduleDetails(List<String> list, int rowNum) {

		String num=Integer.toString(rowNum+1);

		String type = validateNGetValue(returnElement(listingStaticAvatar, dynamicName, num), typeContent, "", iconContent, attributeTitle, false);

		String name = validateNGetValue(returnElement(listingStaticName, dynamicName, num), "Name", "", hyperlinkContent, attributeTextContent, true);

		String fold = validateNGetValue(returnElement(listingStaticFolder, dynamicName, num), folderContent, "", attributeTextContent, attributeTitle, true);

		String inty = validateNGetValue(returnElement(listingStaticInstanceType, dynamicName, num), instanceTypeContent, "", attributeTextContent, attributeTextContent, true);

		String ltti = validateNGetValue(returnElement(listingStaticLastTriggeredTime, dynamicName, num), lastTriggerTimeContent, "", attributeTextContent, attributeTextContent, true);

		String mtti = validateNGetValue(returnElement(listingStaticMissedTriggeredTime, dynamicName, num), missTriggerTimeContent, "", attributeTextContent, attributeTextContent, true);

		String trby = validateNGetValue(returnElement(listingStaticTriggeredBy, dynamicName, num), triggerByContent, "", attributeTextContent, attributeTextContent, true);

		String trty = validateNGetValue(returnElement(listingStaticTriggeredType, dynamicName, num), triggerTypeContent, "", attributeTextContent, attributeTextContent, true);

		ltti = ltti.contains(",") ? ltti.replace(",", " |") : ltti;
		mtti = mtti.contains(",") ? mtti.replace(",", " |") : mtti;

		list.add(num+","+type+","+name+","+fold+","+inty+","+ltti+","+mtti+","+trby+","+trty);

		return list;

	}

	public boolean validateSearchFunctionalityOnMonitorScreen(String searchName, boolean checkAll) {

		boolean flag = true;
		try {

			removeAppliedFilterofParameter();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, searchName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> after = getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleMonitorContent+listingContent);

			if(Integer.parseInt(after.get(1))==0) {
				return flag;
			}						
			getScheduleMonitorListingPageTable(after.get(1),checkAll, "");

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSearchFunctionalityOnMonitorScreen :: " + e.toString());
			return false;
		}

		return flag;
	}

	public List<String> getScheduleMonitorListingPageTable(String totalCount, boolean checkAll, String type) {

		List<String> list = new ArrayList<>();
		List<String> columnTextValues = new ArrayList<>();

		int total = Integer.parseInt(totalCount);

		int totalPages = (int) Math.ceil(total / 20.0);  // Calculate total number of pages

		for (int pn = 1; pn <= totalPages; pn++) {
			BaseSuite.reportLog("Checking records on page : "+pn);

			// Fetch table contents
			// Extract column values
			List<String> pageData;
			if(!type.isEmpty()) {
				if (type.equalsIgnoreCase("Name")) {
					pageData  = getElements(driver, listingPageStaticNameList).stream()
							.map(WebElement::getText)
							.collect(Collectors.toList());
				} else {
					pageData  = getElements(driver, listingPageStaticLastriggeredTimeList).stream()
							.map(e -> e.getText().replaceFirst("^[^0-9]+", "").trim())
							.collect(Collectors.toList());
				}

				columnTextValues.addAll(pageData);
			}
			// Calculate the number of records to process on this page
			int size = driver.findElements(listingPageStaticCount).size();		        

			for (int i = 0; i < size; i++) {
				list = validateScheduleDetails(list, i);
			}
			if(!checkAll) { break;}
			// Click next page if not on the last page
			if (pn < totalPages) {
				BaseSuite.reportLog("Clicking on next arrow to go on page : "+pn);
				displayAndClick(driver, listingPageNextPageArrow, "next page"); 
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateUnexpectedToast("getScheduleMonitorListingPageTable");
			}
		}

		getTableForScheduleMonitor(list);

		clickOnRefreshOnScheduleMonitorListingPage();
		
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		return columnTextValues;
	}

	public void getTableForScheduleMonitor(List<String> list) {

		try {

			if(!list.isEmpty()) {

				String [][] table = new String[list.size()+1][4];

				String[] header = { "No.", "Type", "Name", folderContent, instanceTypeContent, lastTriggerTimeContent, missTriggerTimeContent, triggerByContent, triggerTypeContent };

				table[0] = header;

				for (int i = 0; i < list.size(); i++) {

					String num = Integer.toString(i + 1);

					String type = list.get(i).split(",")[1];

					String name = list.get(i).split(",")[2];

					String fold = list.get(i).split(",")[3];

					String inty = list.get(i).split(",")[4];

					String ltti = list.get(i).split(",")[5];

					String mtti = list.get(i).split(",")[6];

					String trby = list.get(i).split(",")[7];

					String trty = list.get(i).split(",")[8];

					String[] data = { num, type, name,fold, inty, ltti, mtti, trby, trty};

					table[i + 1] = data;

				}

				BaseSuite.reportLog(createHtmlTable1(table,"Schedule Monitor"));

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("error observed while getTableForScheduleMonitor :: " + e.toString());
		}
	}

	public void clickOnBreadcrumbLinks(String link) {

		BaseSuite.reportLog(hyphenContent+"Navigationg on Link : "+link+hyphenContent);
		switch(link.toLowerCase().trim()) {

		case "home":

			clickOnButton(driver, breadcrumbHome, "Home", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 10, welcomeText);

			if(isDisplayed(driver, welcomeText)) {

				String name = getText(driver, welcomeText);

				BaseSuite.reportLog("Home page is visible "+name);

			}else {
				BaseSuite.reportFailLog("Home page not visible", "clickOnBreadcrumbLink");
			}

			break;

		case "scheduler":

			clickOnButton(driver, breadcrumbscheduler, schedulerContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateTitle(driver, schedulePageTitle, schedulesContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			break;	

		default:

			break;
		}

	}

	public void navigateToDataTestingTabs(By linklocator, By validateLocator, String label, String type) {

		try {
			navigateToLink(driver,linklocator, validateLocator, label+" "+type);

			clickOnButton(driver, nextgenTabScheduler, schedulerContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnScheduleMonitorTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToDataTestingTabs :: "+e.toString());
		}

	}
	public boolean validateNagivationOnSchedule() {
		boolean flag = true;

		try {


			clickOnBreadcrumbLinks("Home");

			new HomePage(driver).clickOnSchedulerTab();

			clickOnScheduleMonitorTab();

			clickOnBreadcrumbLinks(schedulerContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, schedulesContent), returnElement(modulePageTitle, dynamicName,schedulesContent), schedulesContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, scheduleMonitorContent), returnElement(modulePageTitle, dynamicName, scheduleMonitorContent), scheduleMonitorContent, subModuleContent);

			navigateToDataTestingTabs(nextgenTabDashboardandReporting, breadcrumbDashboardAndReporting, "Dashboard and Reporting", moduleContent);

			navigateToDataTestingTabs(nextgenTabDataTesting,  returnElement(modulePageTitle, dynamicName, "Rules"), "Data Testing", moduleContent);

			navigateToDataTestingTabs(nextgenTabConnector, returnElement(modulePageTitle, dynamicName, connectionsContent), "Connectors", moduleContent);

			navigateToDataTestingTabs(nextgenTabAdmin, moduleUserPageTitle, "Administration", moduleContent);


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateNagivationOnSchedule :: " + e.toString());
			return false;
		}

		return flag;
	}

	public boolean sortListByColumn(String type, String order, int totalRecords) {
		boolean isSorted = true;

		try {
			By locator = type.contains("Name") ? listingColumnName : listingColumnLastTriggeredTime;
			boolean isAscending = order.equalsIgnoreCase("ascending");

			BaseSuite.reportLog("Verifying schedules after sorting by " + type + " in " + order + " order");

			// Perform sort click
			displayAndClick(driver, locator, type + columnContent);

			if (!isAscending) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				displayAndClick(driver, locator, type + columnContent);  // Click again for descending
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> columnData= getScheduleMonitorListingPageTable(Integer.toString(totalRecords), false, type);

			// Validate sorting
			isSorted = type.equalsIgnoreCase("Name")
					? DataIntegrityUtils.isSorted(columnData, isAscending)
							: DataIntegrityUtils.isDateSorted(columnData, SchedulesServicePage.RRTIMESTAMPFORMAT, isAscending);

			BaseSuite.reportLog("Verifying sorting functionality worked or not on "+ type + " column");
			if (isSorted) {
				BaseSuite.validationReportLog("Sorting functionality working properly on " + type + " column.");
			} else {
				BaseSuite.reportFailLog("Sorting functionality not working on " + type + " column.", "validateSortingFunctionalityOnSchedule");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " sortListByColumn :: " + e.toString());
			return false;
		}

		return isSorted;
	}


	public boolean validateSortingFunctionalityOnScheduleMonitor(String type , String order) {
		boolean isSortedCorrectly = true;

		try {

			BaseSuite.reportLog("Verifying existing schedules displayed on listing page : 1 before sorting");

			List<String> paginationInfo = getPaginationDetails(driver, listingPaginationInfo, listingPaginationBar, listingNoRecordsToDisplay, scheduleMonitorContent + listingContent);

			int totalRecords = Integer.parseInt(paginationInfo.get(1));
			if (totalRecords == 0) {
				return true;
			}

			getScheduleMonitorListingPageTable(Integer.toString(totalRecords), false, "");

			isSortedCorrectly = sortListByColumn(type, order, totalRecords);

			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSortingFunctionalityOnScheduleMonitor :: " + e.toString());
			return false;
		}

		return isSortedCorrectly;
	}

	public void validateUnexpectedToast(String method) {

		if(isDisplayed(driver, toastMsg)) {
			BaseSuite.reportFailLog("Unexpected toast message appeared", method);
		}
	}

	public boolean clickOnRefreshFolderIcon() {

		boolean flag=true;

		try {
			clickOnButton(driver, listingFolderSearchRefresh, refreshContent+" "+folderContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateUnexpectedToast("clickOnRefreshFolderIcon");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnRefreshFolderIcon :: "+e.toString());
			flag=false;
		}

		return flag;	

	}

	public boolean validateListOfRecordsAsPerType(By listlocator, String label, String input, String attribute) {

		boolean flag=true;

		try {


			List<String> paginationInfo = getPaginationDetails(driver, listingPaginationInfo, listingPaginationBar, listingNoRecordsToDisplay, scheduleMonitorContent + listingContent);

			int totalRecords = Integer.parseInt(paginationInfo.get(1));
			if (totalRecords == 0) {
				return true;
			}

			isDisplayedInLoop(driver, 0, listlocator);

			if(!isDisplayed(driver, listlocator)) {
				return false;
			}

			int size = driver.findElements(listlocator).size();

			List<WebElement> webeles = getElements(driver, listlocator);

			for(int a=0; a<size;a++) {

				BaseSuite.reportLog("checking "+label+" for record : "+(a+1));

				String acstr = webeles.get(a).getAttribute(attribute).trim();

				acstr = acstr.equalsIgnoreCase("Onetime") ? "One Time" : acstr ;

				compareValues(input, acstr, label);
			}

			getScheduleMonitorListingPageTable(false);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateListOfRecordsAsPerType :: "+e.toString());
			flag=false;
		}

		return flag;	
	}



	public boolean advanceSearchValidateForAllTypes() {
		boolean flag=true;

		try {

			verifyIndividualLabel(driver, advancedSearchTitle, advanceSearchContent);

			if(isDisplayed(driver, advancedSearchExpand)) {

				displayAndClick(driver, advancedSearchExpand);
			}

			List<String> types = Arrays.asList("One Time", "Daily", "Weekly", "Advance");

			for (String type : types) {

				removeAppliedFilterofParameter();

				validateNSelectTypeInAdvanceSearch(type, true);

				validateListOfRecordsAsPerType(listingAllAvatar, "Schedule type", type, attributeTitle);


			}

			List<String> instance = Arrays.asList("Fired", "Misfired");

			for (String type : instance) {

				removeAppliedFilterofParameter();

				validateNSelectInstanceTypeInAdvanceSearch(type, true);

				validateListOfRecordsAsPerType(listingAllInstanceType, "Instance type", type, attributeTextContent);

			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" advanceSearchValidateForAllTypes :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean getScheduleMonitorListingPageTable(boolean checkAll) {
		boolean flag=true;

		try {
			List<String> list = new ArrayList<>();

			List<String> paginationInfo = getPaginationDetails(driver, listingPaginationInfo, listingPaginationBar, listingNoRecordsToDisplay, scheduleMonitorContent + listingContent);

			int total = Integer.parseInt(paginationInfo.get(1));
			if (total == 0) {
				return true;
			}

			int totalPages = (int) Math.ceil(total / 20.0);  // Calculate total number of pages

			for (int pn = 1; pn <= totalPages; pn++) {
				BaseSuite.reportLog("Checking records on page : "+pn);

				// Calculate the number of records to process on this page
				int size = driver.findElements(listingPageStaticCount).size();		        

				for (int i = 0; i < size; i++) {
					list = validateScheduleDetails(list, i);
				}
				if(!checkAll) { break;}
				// Click next page if not on the last page
				if (pn < totalPages) {
					BaseSuite.reportLog("Clicking on next arrow to go on page : "+pn);
					displayAndClick(driver, listingPageNextPageArrow, "next page"); 
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validateUnexpectedToast("getScheduleMonitorListingPageTable");
				}
			}

			getTableForScheduleMonitor(list);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" getScheduleMonitorListingPageTable :: "+e.toString());
			flag=false;
		}

		return flag;
	}
}
