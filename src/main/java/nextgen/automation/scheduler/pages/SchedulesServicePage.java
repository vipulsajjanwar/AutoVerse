package nextgen.automation.scheduler.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.CustomTimeUtil;
import nexgen.automation.framework.util.DataIntegrityUtils;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.workflow.service.pages.DataTestingParameters;
import nextgen.automation.workflow.service.pages.InstancesServicePage;
import nextgen.automation.workflow.service.pages.ParametersServicePage;
import nextgen.automation.workflow.service.pages.WorkflowPage;

public class SchedulesServicePage extends PageUtil {

	WebDriver driver;

	public SchedulesServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(SchedulesServicePage.class);

	String excelPath = Constant.NEXTGEN_SCHEDULER_REG_TESTDATA_EXCEL_PATH;
	public final String sCHEDULEEXCELFILEPATH = System.getProperty("user.dir")+ excelPath;



	/** ----------------------  By locators ---------------------------------- **/
	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By icedqLogo = getElementLocator(prop.getProperty("Home.icedq_Logo"));
	By userProfile = getElementLocator(prop.getProperty("Home.userProfile"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));
	By welcomeText=getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));

	By configFieldsDetailsDiscardPoupupTitle=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.title"));
	By configFieldsDetailsDiscardPoupupContent=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.content"));
	By configFieldsDetailsDiscardPoupupDiscardButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.discardbutton"));
	By configFieldsDetailsDiscardPoupupCancelButton=getElementLocator(prop.getProperty("configurations.fields.details.popup.discard.cancelbutton"));

	By schedulePageTitle = getElementLocator(prop.getProperty("schedules.pagetitle"));  
	By breadcrumbHome = getElementLocator(prop.getProperty("schedules.listing.breadcrumb.home"));  
	By breadcrumbscheduler = getElementLocator(prop.getProperty("schedules.listing.breadcrumb.scheduler"));
	By breadcrumbschedules = getElementLocator(prop.getProperty("schedules.listing.breadcrumb.schedules"));
	By listingSearchbar = getElementLocator(prop.getProperty("schedules.listing.search.bar"));
	By listingSearchButton = getElementLocator(prop.getProperty("schedules.listing.search.button"));
	By listingSearchClear = getElementLocator(prop.getProperty("schedules.listing.search.clear"));
	By listingButtonCount = getElementLocator(prop.getProperty("schedules.listing.button.count"));
	By listingButtonNewSchedule = getElementLocator(prop.getProperty("schedules.listing.button.newschedule"));
	By listingButtonRefresh = getElementLocator(prop.getProperty("schedules.listing.button.refresh"));
	By listingButtonDelete = getElementLocator(prop.getProperty("schedules.listing.button.delete"));
	By listingMasterCheckbox = getElementLocator(prop.getProperty("schedules.listing.column.mastercheckbox"));
	By listingColumnName = getElementLocator(prop.getProperty("schedules.listing.column.name"));
	By listingColumndesc = getElementLocator(prop.getProperty("schedules.listing.column.description"));
	By listingColumnFolder = getElementLocator(prop.getProperty("schedules.listing.column.folder"));
	By listingColumnNoOfJob = getElementLocator(prop.getProperty("schedules.listing.column.noofjobs"));
	By listingColumnLastUpdated = getElementLocator(prop.getProperty("schedules.listing.column.lastupdated"));
	By listingNoRecordsToDisplay = getElementLocator(prop.getProperty("schedules.listing.norecordstodisplay"));
	By listingFolderSearchTitle = getElementLocator(prop.getProperty("schedules.listing.foldersearch.title"));
	By listingFolderSearchRefresh = getElementLocator(prop.getProperty("schedules.listing.foldersearch.refresh"));
	By listingFolderSearchExpand = getElementLocator(prop.getProperty("schedules.listing.foldersearch.expand"));
	By listingFolderSearchCollapse = getElementLocator(prop.getProperty("schedules.listing.foldersearch.collapse"));
	By listingFolderSearchbar = getElementLocator(prop.getProperty("schedules.listing.foldersearch.search"));
	By listingFolderSearchbutton = getElementLocator(prop.getProperty("schedules.listing.foldersearch.button"));
	By listingFolderSearchclear = getElementLocator(prop.getProperty("schedules.listing.foldersearch.clear"));

	By listingPaginationBar = getElementLocator(prop.getProperty("schedules.listing.paginationbar"));
	By listingPaginationInfo = getElementLocator(prop.getProperty("schedules.listing.paginationinfo"));
	By listingPageNextPageArrow = getElementLocator(prop.getProperty("schedules.listing.nextpagearrow"));

	By addnewScheTitle = getElementLocator(prop.getProperty("schedules.addnewsche.title"));
	By addnewScheCross = getElementLocator(prop.getProperty("schedules.addnewsche.cross"));
	By addnewScheFolderLabel = getElementLocator(prop.getProperty("schedules.addnewsche.folder.label"));
	By addnewScheFolderField = getElementLocator(prop.getProperty("schedules.addnewsche.folder.field"));
	By addnewScheNameLabel = getElementLocator(prop.getProperty("schedules.addnewsche.name.label"));
	By addnewScheNameField = getElementLocator(prop.getProperty("schedules.addnewsche.name.field"));
	By addnewScheNameValidation = getElementLocator(prop.getProperty("schedules.addnewsche.name.validation"));
	By addnewScheChooseLabel = getElementLocator(prop.getProperty("schedules.addnewsche.choosetemp.label"));
	By addnewScheChooseButtons = getElementLocator(prop.getProperty("schedules.addnewsche.choosetemp.button"));
	By addnewScheCancelButton = getElementLocator(prop.getProperty("schedules.addnewsche.cancel.button"));

	By detailsPageButtonCount = getElementLocator(prop.getProperty("schedules.details.button.count"));
	By detailsPageButtonRun = getElementLocator(prop.getProperty("schedules.details.button.run"));
	By detailsPageButtonSave = getElementLocator(prop.getProperty("schedules.details.button.save"));
	By detailsPageButtonDiscard = getElementLocator(prop.getProperty("schedules.details.button.discard"));
	By detailsPageButtonDelete = getElementLocator(prop.getProperty("schedules.details.button.delete"));
	By detailsPageButtonRecentRuns = getElementLocator(prop.getProperty("schedules.details.button.recentruns"));
	By detailsPageButtonPause = getElementLocator(prop.getProperty("schedules.details.button.pause"));
	By detailsPageButtonResume = getElementLocator(prop.getProperty("schedules.details.button.resume"));

	By detailsPageOverviewTab = getElementLocator(prop.getProperty("schedules.details.tab.overview"));
	By detailsPageJobsTab = getElementLocator(prop.getProperty("schedules.details.tab.jobs"));
	By detailsPageDescriptionField = getElementLocator(prop.getProperty("schedules.details.description.field"));
	By detailsPageDescriptionValidation = getElementLocator(prop.getProperty("schedules.details.description.validation"));
	By detailsPageHolidayCalendarLabel = getElementLocator(prop.getProperty("schedules.details.holidaycalender.label"));
	By detailsPageHolidayCalendarCheckbox = getElementLocator(prop.getProperty("schedules.details.holidaycalender.checkbox"));

	By detailsPageHolidayCalendarField = getElementLocator(prop.getProperty("schedules.details.holidaycalender.field"));
	By detailsPageHolidayCalendarDD = getElementLocator(prop.getProperty("schedules.details.holidaycalender.field.dd"));
	By detailsPageHolidayCalendarInput = getElementLocator(prop.getProperty("schedules.details.holidaycalender.input"));

	By detailsPageStartDateLabel = getElementLocator(prop.getProperty("schedules.details.startdate.label"));
	By detailsPageStartDateField = getElementLocator(prop.getProperty("schedules.details.startdate.field"));
	By detailsPageStartDateClear = getElementLocator(prop.getProperty("schedules.details.startdate.clear"));

	By detailsPageStartDateDateIcon = getElementLocator(prop.getProperty("schedules.details.startdate.dateicon"));
	By detailsPageStartDateTimeIcon = getElementLocator(prop.getProperty("schedules.details.startdate.timeicon"));
	By detailsPageStartDateTimeList = getElementLocator(prop.getProperty("schedules.details.startdate.timeList"));

	By detailsPageEndDateLabel = getElementLocator(prop.getProperty("schedules.details.enddate.label"));
	By detailsPageEndDateField = getElementLocator(prop.getProperty("schedules.details.enddate.field"));
	By detailsPageEndDateClear = getElementLocator(prop.getProperty("schedules.details.enddate.clear"));

	By detailsPageEndDateDateIcon = getElementLocator(prop.getProperty("schedules.details.enddate.dateicon"));
	By detailsPageEndDateTimeIcon = getElementLocator(prop.getProperty("schedules.details.enddate.timeicon"));
	By detailsPageEndDateTimeList = getElementLocator(prop.getProperty("schedules.details.enddate.timeList"));

	By detailsPageHoursField = getElementLocator(prop.getProperty("schedules.details.hours.field"));
	By detailsPageMinutesField = getElementLocator(prop.getProperty("schedules.details.minute.field"));
	By detailsPageDaysField = getElementLocator(prop.getProperty("schedules.details.days.field"));

	By detailsPageHoursFieldClear = getElementLocator(prop.getProperty("schedules.details.hours.field.clear"));
	By detailsPageMinutesFieldClear = getElementLocator(prop.getProperty("schedules.details.minute.field.clear"));
	By detailsPageDaysFieldClear = getElementLocator(prop.getProperty("schedules.details.days.field.clear"));

	By detailsPageReoccurFieldValue = getElementLocator(prop.getProperty("schedules.details.reoccur.field.value"));
	By detailsPageHoursFieldValue = getElementLocator(prop.getProperty("schedules.details.hours.field.value"));
	By detailsPageMinutesFieldValue = getElementLocator(prop.getProperty("schedules.details.minute.field.value"));
	By detailsPageDaysFieldValue = getElementLocator(prop.getProperty("schedules.details.days.field.value"));

	By detailsPageHolidayCalenderEnable=getElementLocator(prop.getProperty("schedules.details.holidaycalender.checkbox.enable"));
	By detailsPageHolidayCalenderDisable=getElementLocator(prop.getProperty("schedules.details.holidaycalender.checkbox.disable"));

	By detailsPageJobSearchBar = getElementLocator(prop.getProperty("schedules.details.job.searchbar"));
	By detailsPageJobSearchBtn = getElementLocator(prop.getProperty("schedules.details.job.searchbutton"));
	By detailsPageJobSearchClr = getElementLocator(prop.getProperty("schedules.details.job.searchclear"));
	By detailsPageJobDeleteButton = getElementLocator(prop.getProperty("schedules.details.job.delete.button"));
	By detailsPageJobHashofJobs = getElementLocator(prop.getProperty("schedules.details.job.hashofjobs"));
	By detailsPageJobMasterCheckbox = getElementLocator(prop.getProperty("schedules.details.job.mastercheckbox"));
	By detailsPageJobColumnJobName = getElementLocator(prop.getProperty("schedules.details.job.column.jobname"));
	By detailsPageJobColumnActive = getElementLocator(prop.getProperty("schedules.details.job.column.active"));
	By detailsPageJobColumnFolder = getElementLocator(prop.getProperty("schedules.details.job.column.folder"));

	By detailsPageStaticJobCount = getElementLocator(prop.getProperty("schedules.details.job.static.jobname.count"));

	By detailsPageJobNoRecordsToDisplay = getElementLocator(prop.getProperty("schedules.details.job.norecordstodisplay"));

	By folderSidebarTitle = getElementLocator(prop.getProperty("schedules.details.folder.title"));
	By folderSidebarSearchBar =getElementLocator(prop.getProperty("schedules.details.folder.searchbar"));
	By folderSidebarSearchBtn =getElementLocator(prop.getProperty("schedules.details.folder.searchbtn"));
	By folderSidebarSearchClr =getElementLocator(prop.getProperty("schedules.details.folder.searchclr"));
	By folderSidebarFolderList =getElementLocator(prop.getProperty("schedules.details.folder.list"));

	By workflowSidebarTitle = getElementLocator(prop.getProperty("schedules.details.workflow.title"));
	By workflowSidebarSearchBar =getElementLocator(prop.getProperty("schedules.details.workflow.searchbar"));
	By workflowSidebarSearchBtn =getElementLocator(prop.getProperty("schedules.details.workflow.searchbtn"));
	By workflowSidebarSearchClr =getElementLocator(prop.getProperty("schedules.details.workflow.searchclr"));
	By workflowSidebarMastercheckbox = getElementLocator(prop.getProperty("schedules.details.workflow.mastercheckbox"));
	By workflowSidebarcolumnName = getElementLocator(prop.getProperty("schedules.details.workflow.column.name"));
	By workflowSidebarColumnFolder = getElementLocator(prop.getProperty("schedules.details.workflow.column.folder"));
	By workflowSidebarAddButton = getElementLocator(prop.getProperty("schedules.details.workflow.addbtn"));
	By workflowSidebarNoRecordsTodisplay = getElementLocator(prop.getProperty("schedules.details.workflow.norecordstodisplay"));
	By workflowSidebarPaginationBar = getElementLocator(prop.getProperty("schedules.details.workflow.pagination.bar"));
	By workflowSidebarPaginationInfo = getElementLocator(prop.getProperty("schedules.details.workflow.pagination.info"));
	By workflowSidebarNameCount = getElementLocator(prop.getProperty("schedules.details.workflow.static.name.list"));

	By folderSidebarPanelOpenIcon = getElementLocator(prop.getProperty("schedules.details.folder.panel.close"));
	By workflowSidebarPanelOpenIcon = getElementLocator(prop.getProperty("schedules.details.workflow.panel.close"));

	By workflowSidebarPanelNextPageArrow = getElementLocator(prop.getProperty("schedules.details.workflow.page.next.arrow"));
	By workflowSidebarPanelFirstPageArrow = getElementLocator(prop.getProperty("schedules.details.workflow.page.first.arrow"));

	By recentRunsTitle = getElementLocator(prop.getProperty("schedules.details.recentruns.title"));
	By recentRunsRefresh = getElementLocator(prop.getProperty("schedules.details.recentruns.refresh"));

	By recentRunsSearchBar =getElementLocator(prop.getProperty("schedules.details.recentruns.searchbar"));
	By recentRunsSearchBtn =getElementLocator(prop.getProperty("schedules.details.recentruns.searchbtn"));
	By recentRunsSearchClr =getElementLocator(prop.getProperty("schedules.details.recentruns.searchclr"));

	By recentRunsColumnId = getElementLocator(prop.getProperty("schedules.details.recentruns.column.instanceid"));
	By recentRunsColumnStatus = getElementLocator(prop.getProperty("schedules.details.recentruns.column.status"));
	By recentRunsColumnStarttime = getElementLocator(prop.getProperty("schedules.details.recentruns.column.starttime"));
	By recentRunsColumnEndtime = getElementLocator(prop.getProperty("schedules.details.recentruns.column.endtime"));
	By recentRunsColumnElapsedtime = getElementLocator(prop.getProperty("schedules.details.recentruns.column.elapsedtime"));
	By recentRunsColumnInstances = getElementLocator(prop.getProperty("schedules.details.recentruns.column.instances"));

	By recentRunsValueId = getElementLocator(prop.getProperty("schedules.details.recentruns.value.instanceid"));
	By recentRunsValueStatus = getElementLocator(prop.getProperty("schedules.details.recentruns.value.status"));
	By recentRunsValueStarttime = getElementLocator(prop.getProperty("schedules.details.recentruns.value.starttime"));
	By recentRunsValueEndtime = getElementLocator(prop.getProperty("schedules.details.recentruns.value.endtime"));
	By recentRunsValueElapsedtime = getElementLocator(prop.getProperty("schedules.details.recentruns.value.elapsedtime"));
	By recentRunsValueInstances = getElementLocator(prop.getProperty("schedules.details.recentruns.value.instances"));

	By recentRunsPaginationBar = getElementLocator(prop.getProperty("schedules.details.recentruns.paginationbar"));
	By recentRunsPaginationInfo = getElementLocator(prop.getProperty("schedules.details.recentruns.paginationinfo"));
	By recentRunsNoRecordsTodisplay = getElementLocator(prop.getProperty("schedules.details.recentruns.norecordstodisplay"));

	By poupUpJobDeleteTitle = getElementLocator(prop.getProperty("schedules.details.job.delete.popup.title"));
	By poupUpJobDeleteContent = getElementLocator(prop.getProperty("schedules.details.job.delete.popup.content"));
	By poupUpJobDeleteButtonDelete = getElementLocator(prop.getProperty("schedules.details.job.delete.popup.delete"));
	By poupUpJobDeleteButtonCancel = getElementLocator(prop.getProperty("schedules.details.job.delete.popup.cancel"));

	By popUpScheduleDeleteTitle = getElementLocator(prop.getProperty("schedules.details.schedule.delete.popup.title"));
	By popUpScheduleDeleteContent = getElementLocator(prop.getProperty("schedules.details.schedule.delete.popup.content"));
	By popUpScheduleDeleteButtonDelete = getElementLocator(prop.getProperty("schedules.details.schedule.delete.popup.delete"));
	By popUpScheduleDeleteButtonCancel = getElementLocator(prop.getProperty("schedules.details.schedule.delete.popup.cancel"));

	By listingPageStaticCount = getElementLocator(prop.getProperty("schedules.listing.static.count"));
	By listingPageStaticNameList = getElementLocator(prop.getProperty("schedules.listing.static.name.list"));
	By listingPageStaticLastUpdatedList =getElementLocator(prop.getProperty("schedules.listing.static.lastupdate.list"));

	By listingPageallAvatar = getElementLocator(prop.getProperty("schedules.listing.all.avatar"));
	By listingPageallFolder = getElementLocator(prop.getProperty("schedules.listing.all.folder"));
	By listingPageallUpdatedBy = getElementLocator(prop.getProperty("schedules.listing.all.lastupdateby"));


	By nextgenTabDataTesting=getElementLocator(prop.getProperty("nextgenmodule.datatesting.tab"));
	By nextgenTabDashboardandReporting=getElementLocator(prop.getProperty("nextgenmodule.dashboard.tab"));
	By nextgenTabScheduler=getElementLocator(prop.getProperty("nextgenmodule.scheduler.tab"));
	By nextgenTabConnector=getElementLocator(prop.getProperty("nextgenmodule.connector.tab"));
	By nextgenTabAdmin=getElementLocator(prop.getProperty("nextgenmodule.admin.tab"));
	By breadcrumbDashboardAndReporting=getElementLocator(prop.getProperty("breadcrumb.dashboardandreporting"));
	By moduleUserPageTitle=getElementLocator(prop.getProperty("module.pagetitle.users"));
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

	public static final String ENABLED = "Enabled";
	public static final String DISABLED = "Disabled";
	public static final String FALSE = "false";
	public static final String TRUE = "true";

	String schedulesContent="Schedules";
	String scheduleMonitorContent="Schedule Monitor";
	String clickingOnContent="Clicking on ";
	String clickedOnContent="Clicked on ";
	String verifyingContent="Verifying ";
	String isVisibleContent=" is visible";
	String scheduleListingContent= "Schedules listing page";

	String scheduleNameContent = "Schedule Name";
	String folderContent ="Folder";

	public static final String ONETIME = "Onetime";
	public static final String DAILY = "Daily";
	public static final String WEEKLY = "Weekly";
	public static final String ADVANCED = "Advanced";

	String advanceString="Advance";
	String startDateLabel = "Start Date (MM/dd/yyyy hh:mm)";
	String endDateLabel = "End Date (MM/dd/yyyy hh:mm)";
	String reoccurLabel = "Reoccur";
	String daysLabel = "Days";
	String hoursLabel = "Hours";
	String minuteLabel = "Minutes";
	String cronExpressionLabel = "Cron Expression";
	String nextExecutionLabel = "Next Execution";
	String timezoneLabel = "Time Zone";
	String holidayCalanderLabel = "Holiday Calendar";
	String hashOfJobsLabel = "# of Jobs:";
	String startTimestampLabel=" Start Timestamp";
	String runLabel = "Run";
	String pauseLabel ="Pause";
	String resumeLabel = "Resume";
	String startLabel = "Start";
	String endLabel = "End";
	String clearContent= "clear";

	String stimeStampFormat ="MM/dd/yyyy hh:mm a";
	public static final String RRTIMESTAMPFORMAT ="M/d/yyyy, h:mm:ss a";

	String scheduleStatusProcessing="processing";
	String scheduleStatusSuccessed="succeeded";

	String jobContent = "Job";
	String dynamicPlaceHolde="$placehold";
	String yearContent= "year";
	
	String stateContent="state";
	String nextPageContent="next page";
	String disableTContent = "disable";
	String listingContent=" listing";

	String instancesContent="Instances";

	String recentRunsContent="Recent Runs ";
	String lastUpdatedContent="Last Updated";

	String eActiveContent="e-active";


	String schedulesSubModules = prop.getProperty("schedules.submodule.tab");
	String listingFolderNameDynamiccheckbox = prop.getProperty("schedules.listing.foldersearch.dynamic.checkbox");

	String listingScheduleNameDynamicLink = prop.getProperty("schedules.listing.dynamic.namelink.withfolder");
	String listingScheduleCheckboxDynamicLink = prop.getProperty("schedules.listing.dynamic.checkbox.withfolder");
	String listingScheduleAvatarDynamicLink = prop.getProperty("schedules.listing.dynamic.avatar.withfolder");
	String listingScheduleDescriptionDynamicLink = prop.getProperty("schedules.listing.dynamic.description.withfolder");
	String listingScheduleFolderDynamicLink = prop.getProperty("schedules.listing.dynamic.folder.withfolder");
	String listingScheduleNoOfJobDynamicLink = prop.getProperty("schedules.listing.dynamic.noofjob.withfolder");
	String listingScheduleUpdateByDynamicLink = prop.getProperty("schedules.listing.dynamic.updateby.withfolder");
	String listingScheduleUpdateDateDynamicLink = prop.getProperty("schedules.listing.dynamic.updatedate.withfolder");

	String addnewScheDynamicEnabled = prop.getProperty("schedules.addnewsche.choosetemp.dynamic.enabled");
	String addnewScheDynamicDisabled = prop.getProperty("schedules.addnewsche.choosetemp.dynamic.disabled");
	String addnewScheChooseDynamicTemp = prop.getProperty("schedules.addnewsche.choosetemp.dynamic.button");

	String detailsPageDynamicTitle = prop.getProperty("schedules.details.page.title");
	String detailsPageDynamicAvatar = prop.getProperty("schedules.details.page.avatar");
	String detailsPageJobTitle = prop.getProperty("job.details.page.title");

	String detailsPageDynamicLabel = prop.getProperty("schedules.details.dynamic.label");
	String detailsPageDynamicField = prop.getProperty("schedules.details.dynamic.field");
	String detailsPageDynamicValidation = prop.getProperty("schedules.details.dynamic.validation");

	String detailsPageDynamicFieldEnabled = prop.getProperty("schedules.details.dynamic.field.enabled");
	String detailsPageDynamicFieldDisabled = prop.getProperty("schedules.details.dynamic.field.disabled");

	String detailsPageJobDynamicCheckbox = prop.getProperty("schedules.details.job.dynamic.checkbox");
	String detailsPageJobDynamicAvatar = prop.getProperty("schedules.details.job.dynamic.avatar");
	String detailsPageJobDynamicJobName = prop.getProperty("schedules.details.job.dynamic.jobname");
	String detailsPageJobDynamicActive = prop.getProperty("schedules.details.job.dynamic.active");
	String detailsPageJobDynamicFolder = prop.getProperty("schedules.details.job.dynamic.folder");

	String detailsPageJobStaticCheckbox = prop.getProperty("schedules.details.job.static.checkbox");
	String detailsPageJobStaticAvatar = prop.getProperty("schedules.details.job.static.avatar");
	String detailsPageJobStaticJobName = prop.getProperty("schedules.details.job.static.jobname");
	String detailsPageJobStaticActive = prop.getProperty("schedules.details.job.static.active");
	String detailsPageJobStaticFolder = prop.getProperty("schedules.details.job.static.folder");

	String folderSidebarDynamicName = prop.getProperty("schedules.details.folder.dynamic.foldername");
	String folderSidebarDynamicCheckbox = prop.getProperty("schedules.details.folder.dynamic.checkbox");

	String workflowSidebarDynamicCheckbox = prop.getProperty("schedules.details.workflow.dynamic.checkbox");
	String workflowSidebarDynamicAvatar = prop.getProperty("schedules.details.workflow.dynamic.avatar");
	String workflowSidebarDynamicName = prop.getProperty("schedules.details.workflow.dynamic.name");
	String workflowSidebarDynamicFolder = prop.getProperty("schedules.details.workflow.dynamic.folder");

	String recentRunsDynamicInstanceId = prop.getProperty("schedules.details.recentruns.dynamic.instanceid");
	String recentRunsDynamicStatus = prop.getProperty("schedules.details.recentruns.dynamic.status");
	String recentRunsDynamicStarttime = prop.getProperty("schedules.details.recentruns.dynamic.starttime");
	String recentRunsDynamicEndtime = prop.getProperty("schedules.details.recentruns.dynamic.endtime");
	String recentRunsDynamicElapsedtime = prop.getProperty("schedules.details.recentruns.dynamic.elapsedtime");
	String recentRunsDynamicInstnaces = prop.getProperty("schedules.details.recentruns.dynamic.instances");

	String dynamicFieldLabel = prop.getProperty("schedules.details.fielddynamic.label");
	String dynamicFieldInput = prop.getProperty("schedules.details.fielddynamic.field");
	String dynamicFieldSelect = prop.getProperty("schedules.details.fielddynamic.select");

	String dynamicHolidayCalenderStateField = prop.getProperty("schedules.details.holidaycalender.field.state");


	String placeholderSearchSchedule = prop.getProperty("placeholder.search.schedule");
	String placeholderSearchFolder = prop.getProperty("placeholder.search.folder");
	String placeholderScheduleName = prop.getProperty("placeholder.schedule.name");
	String placeholderSearchJob = prop.getProperty("placeholder.search.job");
	String placeholderSearchWorkflow = prop.getProperty("placeholder.search.workflow");
	String placeholderSearch = prop.getProperty("placeholder.search");
	String placeholderDescription=prop.getProperty("parameters.placeholder.description");
	String placeholderSearchRecentRun=prop.getProperty("placeholder.search.recentruns");
	String placeholderSelectStartDate=prop.getProperty("placeholder.select.startdate");
	String placeholderSelectEndDate=prop.getProperty("placeholder.select.enddate");
	String placeholderSelectHours=prop.getProperty("placeholder.select.hours");
	String placeholderSelectMinute=prop.getProperty("placeholder.select.minutes");
	String placeholderSelectReoccur=prop.getProperty("placeholder.enter.reoccur");
	String placeholderSelectDays=prop.getProperty("placeholder.select.days");
	String placeholderEnterCronExp=prop.getProperty("placeholder.enter.cronexpression");
	String placeholderSelectCalendar=prop.getProperty("placeholder.select.calendar");

	String fieldValidationEmptyName = prop.getProperty("field.validation.empty.schedule.name");

	String toastMessageScheduleCreated = prop.getProperty("toast.created.schedule");
	String toastMessageScheduleDeleted = prop.getProperty("toast.deleted.schedule");
	String toastMessageSchedulesDeleted = prop.getProperty("toast.deleted.schedules");

	String popupTitleSingleJobDelete= prop.getProperty("popup.single.job.delete.title");
	String popupContentSingleJobDelete= prop.getProperty("popup.single.job.delete.content");
	String popupTitleMultipleJobDelete= prop.getProperty("popup.multiple.job.delete.title");
	String popupContentMultipleJobDelete= prop.getProperty("popup.multiple.job.delete.content");

	String popupTitleSingleScheduleDelete= prop.getProperty("popup.single.schedule.delete.title");
	String popupContentSingleScheduleDelete= prop.getProperty("popup.single.schedule.delete.content");
	String popupTitleMultipleScheduleDelete= prop.getProperty("popup.multiple.schedule.delete.title");
	String popupContentMultipleScheduleDelete= prop.getProperty("popup.multiple.schedule.delete.content");

	String detailsPageStartDateTimeDynamicSelect = prop.getProperty("schedules.details.startdate.dynamic.time");
	String detailsPageEndDateTimeDynamicSelect = prop.getProperty("schedules.details.enddate.dynamic.time");

	String detailsPageHolidayCalendarDynamicSelect = prop.getProperty("schedules.details.holidaycalender.dynamic.select");

	String listingStaticAvatar = prop.getProperty("schedules.listing.static.avatar");
	String listingStaticName = prop.getProperty("schedules.listing.static.name");
	String listingStaticDesc = prop.getProperty("schedules.listing.static.desc");
	String listingStaticFolder = prop.getProperty("schedules.listing.static.folder");
	String listingStaticJobsCount = prop.getProperty("schedules.listing.static.hashofjob");
	String listingStaticlastUpdate = prop.getProperty("schedules.listing.static.lastupdate");

	String workflowlistingStaticAvatar = prop.getProperty("schedules.details.workflow.static.type");
	String workflowlistingStaticName = prop.getProperty("schedules.details.workflow.static.name");
	String workflowlistingStaticCheckbox = prop.getProperty("schedules.details.workflow.static.checkbox");
	String workflowlistingStaticFolder = prop.getProperty("schedules.details.workflow.static.folderpath");

	/** ---------------------- Methods  ---------------------------------- **/

	public static String[] getDynamicSuffix(boolean useSuffix, String icedqUser) {
		if (!useSuffix) return new String[]{"", ""};

		if (icedqUser.isEmpty()) {
			return new String[]{System.getProperty("schedulesuffix", ""), System.getProperty("updateschedulesuffix", "")};
		}

		if (icedqUser.contains("owner") || icedqUser.contains("contributor")) {
			return new String[]{"_"+icedqUser, "_" + icedqUser};
		}

		if(icedqUser.contains("pre") || icedqUser.contains("execu") || icedqUser.contains("read")) {
			return new String[]{"", ""};
		}

		return new String[]{"_Lead", "_Lead"};
	}


	public static SchedulerServiceParameters setSchedulerServiceParamUsingExcel(String filePath, String sheetName, int rowNumber, boolean useSuffix, String icedqUser) {

		SchedulerServiceParameters param = new SchedulerServiceParameters();
		XLUtils xl = new XLUtils();

		try {

			String [] sns=getDynamicSuffix(useSuffix, icedqUser);

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setExecutionstate(xl.readUsingColName(filePath,sheetName, rowNumber, "execute"));
			// Setting values using setter methods

			param.setFolderName(ParametersServicePage.folderPath(xl.readUsingColName(filePath,sheetName, rowNumber, "foldername")));
			param.setScheduleName(xl.readUsingColName(filePath,sheetName, rowNumber, "name")+sns[0]);
			param.setType(xl.readUsingColName(filePath,sheetName, rowNumber, "type"));
			param.setDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "description"));
			param.setTemplete(xl.readUsingColName(filePath,sheetName, rowNumber, "templete"));
			param.setRunAs(xl.readUsingColName(filePath,sheetName, rowNumber, "runas"));
			param.setStartDate(xl.readUsingColName(filePath,sheetName, rowNumber, "startdate"));
			param.setEndDate(xl.readUsingColName(filePath,sheetName, rowNumber, "enddate"));
			/**	param.setJobCount(xl.readUsingColName(filePath,sheetName, rowNumber, "jobcount"));*/
			param.setJobs(xl.readUsingColName(filePath,sheetName, rowNumber, "jobs"));
			param.setJobCount(Integer.toString(getSplitCount(param.getJobs(),",")));
			param.setTimezone(xl.readUsingColName(filePath,sheetName, rowNumber, "timezone"));
			param.setUseHolidayCalender(xl.readUsingColName(filePath,sheetName, rowNumber, "useholidaycalender"));
			param.setUseDefault(xl.readUsingColName(filePath,sheetName, rowNumber, "usedefault"));
			param.setIsActive(xl.readUsingColName(filePath,sheetName, rowNumber, "isactive"));
			param.setCalenderId(xl.readUsingColName(filePath,sheetName, rowNumber, "calenderid"));
			param.setReoccur(xl.readUsingColName(filePath,sheetName, rowNumber, "reoccur"));
			param.setHours(xl.readUsingColName(filePath,sheetName, rowNumber, "hours"));
			param.setMinutes(xl.readUsingColName(filePath,sheetName, rowNumber, "minutes"));
			param.setDays(xl.readUsingColName(filePath,sheetName, rowNumber, "days"));
			param.setCronExpression(xl.readUsingColName(filePath,sheetName, rowNumber, "cronexpression"));
			param.setUpdateName(xl.readUsingColName(filePath,sheetName, rowNumber, "name")+sns[1]);
			param.setRemoveJobs(xl.readUsingColName(filePath,sheetName, rowNumber, "removejobs"));
			param.setAdvanceSearch(xl.readUsingColName(filePath,sheetName, rowNumber, "advancesearch"));
			param.setOrder(xl.readUsingColName(filePath,sheetName, rowNumber, "order"));

			param.setFieldValidation(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidation(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));
			param.setStatus("SUCCEEDED");

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,  "error occurs while setSchedulerServiceParamUsingExcel "+e.toString());
		}

		return param;

	}

	public static DataTestingParameters setJobsParamUsingExcel(String filePath, String job) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="ref";
		String usersheet="jobs";
		try {

			param.setWorkflowName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"Name"));
			param.setWorkflowType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"type"));
			param.setFolderName(ParametersServicePage.folderPath(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"folderPath")));
			param.setWorkflowState(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"state"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,  "error occurs while setJobsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setAdvanceSearchParamUsingExcel(String filePath, String job) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="ref";
		String usersheet="advance";
		try {

			param.setUserName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"username"));
			param.setFullName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"fullname"));
			param.setType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"type"));
			param.setInstanceId(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"instancetype"));
			param.setUpdatedBy(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"updatedBy"));
			param.setLastUpdatedFrom(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"from"));
			param.setLastUpdatedTo(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"to"));

			param.setCount(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"nooffilter"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,  "error occurs while setJobsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setScheduleSearchParamUsingExcel(String filePath, String name, String icedqUser) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="ref";
		String usersheet="schedules";
		try {
			String [] sns=getDynamicSuffix(true, icedqUser);
			param.setFullName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, name,"name")+sns[0]);
			param.setFolderName(ParametersServicePage.folderPath(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, name,"folder")));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,  "error occurs while setScheduleSearchParamUsingExcel "+e.toString());
		}
		return param;

	}

	public static SchedulerServiceParameters setSchedulerServiceParamUsingExcel() {

		SchedulerServiceParameters param = new SchedulerServiceParameters();

		try {


			param.setReoccur("2");
			param.setHours("1,3,5");
			param.setMinutes("12,2,22");
			param.setDays("0,1,2,3,4");
			param.setCronExpression("0 23 12 ? * 1 2025-2099");

			param.setStatus("SUCCEEDED");

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,  "error occurs while setSchedulerServiceParamUsingExcel "+e.toString());
		}

		return param;

	}


	public boolean clickOnRefreshOnScheduleListingPage() {

		return clickOnButton(driver, listingButtonRefresh, refreshContent, true);
	}


	public boolean clickOnRefreshOnScheduleListingPageWithValidation() {
		boolean flag=true;

		try {
			clickOnButton(driver, listingButtonRefresh, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
						"Schedules tab refresh authorization message");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnRefreshOnScheduleListingPageWithValidation :: "+e.toString());
		}

		return flag;
	}


	public boolean clickOnSchedulesTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, schedulePageTitle);
			
			BaseSuite.reportLog("Clicking on Schedules tab");

			if(isDisplayed(driver, addnewScheCancelButton)) { clickOnButton(driver, addnewScheCancelButton, cancelButtonContent, true);}
			
			if(isDisplayed(driver, toastMsgClosedBtn)) { displayAndClick(driver, toastMsgClosedBtn);}

			if(!isDisplayed(driver, listingButtonNewSchedule)) {

				isDisplayedInLoop(driver, 3, returnElement(schedulesSubModules, dynamicName, schedulesContent));

				if(isDisplayed(driver, returnElement(schedulesSubModules, dynamicName, schedulesContent))) {

					flag = isClickable(driver, returnElement(schedulesSubModules, dynamicName, schedulesContent), schedulesContent+whiteSpace+tabContent, true);

					if(flag) {

						BaseSuite.reportLog(clickingOnContent+schedulesContent+whiteSpace+tabContent);

						displayAndClick(driver,  returnElement(schedulesSubModules, dynamicName, schedulesContent));

						handleDiscardWindow(driver, configFieldsDetailsDiscardPoupupDiscardButton, discardContent);

						BaseSuite.validationReportLog(clickedOnContent+schedulesContent+whiteSpace+tabContent);

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, schedulePageTitle, schedulesContent, attributeTitle);
							
					}

				}else {
					BaseSuite.reportFailLog(schedulesContent+" tab not visible", "clickOnSchedulesTab");
				}
			}else {
				BaseSuite.reportLog(schedulesContent+" listing page is visible");
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnSchedulesTab :: "+e.toString());
			flag=false;
		}
		finally{
			
			removeAppliedFilterofParameter();
		}

		return flag;

	}

	public boolean checkDiscardPopupAppearsOrNot() {

		displayAndClick(driver,  breadcrumbscheduler);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(isDisplayed(driver, configFieldsDetailsDiscardPoupupDiscardButton)) {
			BaseSuite.reportFailLog("Discard popup window is displayed", "checkDiscardPopupAppearsOrNot");
			return false;
		}else {
			BaseSuite.reportLog("Discard popup window is not appeared");
			return true;
		}
	}

	public boolean validateSchedulesTabListingPage() {

		boolean flag = true;
		HomePage hp=new HomePage(driver);
		try {

			BaseSuite.reportLog(hyphenContent+" Validating schedules listing page "+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenIcedqModuleAndSchedulerSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on schedules listing page "+hyphenContent);

			validateElement(driver, breadcrumbHome, homeContent, hyperlinkContent);

			validateElement(driver, breadcrumbscheduler, schedulerContent, hyperlinkContent);

			validateElement(driver, breadcrumbschedules, schedulesContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Search field schedules listing page "+hyphenContent);

			verifySearchField(driver, listingSearchbar, placeholderSearchSchedule, placeholderSearchSchedule);

			validateElement(driver,listingSearchButton, placeholderSearchSchedule, iconContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on schedules listing page "+hyphenContent);

			validateButtons(driver, listingButtonCount, 3);

			verifyVisibilityOfButtons(driver, listingButtonNewSchedule, newScheduleContent, true);
			verifyVisibilityOfButtons(driver, listingButtonRefresh, refreshContent, true);
			verifyVisibilityOfButtons(driver, listingButtonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+"  Verifying Columns on schedules listing page "+hyphenContent);

			validateElement(driver, listingMasterCheckbox, "Master", checkboxContent);
			validateElement(driver, listingColumnName, "Name",columnContent);
			validateElement(driver, listingColumndesc, descriptionContent, columnContent);
			validateElement(driver, listingColumnFolder, folderContent, columnContent);
			validateElement(driver, listingColumnNoOfJob, "# of Jobs", columnContent);
			validateElement(driver, listingColumnLastUpdated, lastUpdatedContent, columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on schedules listing page "+hyphenContent);

			getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleListingContent);

			validateElement(driver, listingFolderSearchTitle, "Folder Search", attributeTitle);

			validateElement(driver, listingFolderSearchRefresh, "Folder Search Refresh", iconContent);

			verifySearchField(driver, listingFolderSearchbar, placeholderSearchFolder, placeholderSearchFolder);

			validateElement(driver,listingFolderSearchbutton, placeholderSearchFolder, iconContent);

			BaseSuite.reportLog(hyphenContent+" Validated schedules listing page successfully "+hyphenContent);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateSchedulesTabListingPage :: "+e.toString());
			flag=false;

		}

		return flag;

	}

	public boolean clickOnNewScheduleButton(String icedqUser) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, listingButtonNewSchedule);

			if(isDisplayed(driver, listingButtonNewSchedule)) {

				clickOnButton(driver, listingButtonNewSchedule, newScheduleContent, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

					String pgTitle=getAttribute(driver, addnewScheTitle, attributeTextContent);

					flag = stringOutput(pgTitle.trim(), "Add New Schedule", true);

				}else{

					flag = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Schedule authorization message");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnNewScheduleButton :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean checkChooseTemplateIsEnabledOrNot(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of choose templete is enabled or not for field  : "+label);

			String elementToCheck = expected ? addnewScheDynamicEnabled : addnewScheDynamicDisabled;

			validateElement(driver, returnElement(elementToCheck, dynamicName, label), label, "Template");

			if (isDisplayed(driver, returnElement(elementToCheck, dynamicName, label))) {

				BaseSuite.validationReportLog(label + " field is  " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " field is  " + (expected ? DISABLED : ENABLED) + " not matched with expected condition. ", "checkChooseTemplateIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " checkChooseTemplateIsEnabledOrNot :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean chooseTemplateOfSchedule(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of choose templete is enabled or not  for field  : "+label);

			String elementToCheck = expected ? addnewScheDynamicEnabled : addnewScheDynamicDisabled;

			if (isDisplayed(driver, returnElement(elementToCheck, dynamicName, label))) {

				validateElement(driver, returnElement(elementToCheck, dynamicName, label), label, "Template");

				BaseSuite.validationReportLog(label + " choose templete field is " + (expected ? ENABLED : DISABLED));

				flag=clickOnButton(driver, returnElement(elementToCheck, dynamicName, label), label, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(label + " choose templete field is " + (expected ? DISABLED : ENABLED) + " not matched with expected condition. ", "chooseTemplateOfSchedule");
				flag = false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " chooseTemplateOfSchedule :: " + e.toString());
			flag = false;
		}
		return flag;
	}


	public boolean validateAddNewScheduleSidebar() {

		boolean flag = true;

		try {

			validateElement(driver, addnewScheTitle, "Add New Schedule", attributeTitle);

			validateElement(driver, addnewScheCross, "Cross", iconContent);

			validateElement(driver, addnewScheFolderLabel, folderContent, labelContent);

			validateField(driver, addnewScheFolderField, folderContent, "", "dropdown", "", "", true);

			validateElement(driver, addnewScheNameLabel, scheduleNameContent, labelContent);

			validateField(driver, addnewScheNameField, scheduleNameContent, placeholderScheduleName, "dropdown", "", "", true);

			validateElement(driver, addnewScheChooseLabel, "Choose Template", labelContent);

			checkChooseTemplateIsEnabledOrNot(ONETIME, true);

			checkChooseTemplateIsEnabledOrNot(DAILY, true);

			checkChooseTemplateIsEnabledOrNot(WEEKLY, true);

			checkChooseTemplateIsEnabledOrNot(ADVANCED, true);

			verifyVisibilityOfButtons(driver, addnewScheCancelButton, cancelButtonContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateAddNewScheduleSidebar :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public void clickOnCancelButtonOfAddNewScheduleSidebar() {
		clickOnButton(driver, addnewScheCancelButton, cancelButtonContent, true);
	}

	public boolean selectFolderOnAddNewSchedule(String folderPath) {

		boolean flag = true;
		ParametersServicePage pg = new ParametersServicePage(driver);
		try {

			pg.searchAndSelectFolderOnAddNewPane(folderPath, "schedule");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" selectFolderOnAddNewSchedule :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean addNewScheduleDetails(String folderpath, String scheduleName, String tempName) {

		boolean flag = true;

		try {

			selectFolderOnAddNewSchedule(folderpath);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatAndeEnterValueToTextField(driver, addnewScheNameLabel, addnewScheNameField,addnewScheNameValidation, scheduleNameContent, placeholderScheduleName, scheduleName, fieldValidationEmptyName);

			chooseTemplateOfSchedule(tempName, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" addNewScheduleDetails :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnOverviewTab() {

		boolean flag = true;
		int a=0;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, detailsPageOverviewTab);

			if(isDisplayed(driver, detailsPageOverviewTab)) {

				String cls = getAttribute(driver, detailsPageOverviewTab, attributeClass);

				if(!cls.contains(eActiveContent)) {

					BaseSuite.reportLog("Clicking on overview tab");

					displayAndClick(driver, detailsPageOverviewTab);

					BaseSuite.validationReportLog("Clicked on overview tab");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(isDisplayed(driver, returnElement(detailsPageDynamicLabel, dynamicName, scheduleNameContent))) {
					
						validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, scheduleNameContent), scheduleNameContent, labelContent);
					
					}else if(a<1) {
						clickOnOverviewTab();
						a++;
					}else {
						validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, scheduleNameContent), scheduleNameContent, labelContent);
						
					}
				}else {

					BaseSuite.reportLog("Overview tab is already active.");
				}

			}else {

				BaseSuite.reportFailLog("Overview tab not visible, kindly check", "clickOnOverviewTab");
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnOverviewTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnJobsTab() {

		boolean flag = true;
		int a=0;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 0, detailsPageJobsTab);

			if(isDisplayed(driver, detailsPageJobsTab)) {

				String cls = getAttribute(driver, detailsPageJobsTab, attributeClass);

				if(!cls.contains(eActiveContent)) {

					BaseSuite.reportLog("Clicking on jobs tab");

					displayAndClick(driver, detailsPageJobsTab);

					BaseSuite.validationReportLog("Clicked on jobs tab");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					
					isDisplayedInLoop(driver, 0, detailsPageJobSearchBar);

					if(isDisplayed(driver, detailsPageJobSearchBar)) {
						
						flag=validateElement(driver, detailsPageJobSearchBar, placeholderSearchJob, fieldContent);
					
					}else if(a<1) {
						clickOnJobsTab();
						a++;
					}else {
						flag=validateElement(driver, detailsPageJobSearchBar, placeholderSearchJob, fieldContent);
					}
					

				}else {

					BaseSuite.reportLog("Jobs tab is already active.");
				}

			}else {

				BaseSuite.reportFailLog("Jobs tab not visible, kindly check", "clickOnJobsTab");
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnJobsTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnFolderSidebarPanelOpenOrClose(boolean expected) {
		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, folderSidebarPanelOpenIcon);

			if (!isDisplayed(driver, folderSidebarPanelOpenIcon)) {
				return false; 
			}

			BaseSuite.reportLog("Folder sidebar panel open/close button is visible");

			boolean isSidebarOpen = isDisplayed(driver, folderSidebarTitle);

			if (isSidebarOpen == expected) {

				BaseSuite.reportLog("Folder sidebar panel is already in the expected state "+expected);
			} else {

				String action = expected ? "open" : "close";

				BaseSuite.reportLog("Clicking on Folder sidebar panel to " + action);

				displayAndClick(driver, folderSidebarPanelOpenIcon);

				BaseSuite.reportLog("Clicked on Folder sidebar panel to " + action);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnFolderSidebarPanelOpen :: " + e.toString());
			flag = false;
		}

		return flag;
	}


	public boolean clickOnWorkflowSidebarPanelOpenOrClose(boolean expected) {
		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, workflowSidebarPanelOpenIcon);

			if (!isDisplayed(driver, workflowSidebarPanelOpenIcon)) {
				return false; 
			}

			BaseSuite.reportLog("workflow sidebar panel open/close button is visible");

			boolean isSidebarOpen = isDisplayed(driver, folderSidebarTitle);

			if (isSidebarOpen == expected) {

				BaseSuite.reportLog("workflow sidebar panel is already in the expected state "+expected);
			} else {

				String action = expected ? "open" : "close";

				BaseSuite.reportLog("Clicking on workflow sidebar panel to " + action);

				displayAndClick(driver, workflowSidebarPanelOpenIcon);

				BaseSuite.reportLog("Clicked on workflow sidebar panel to " + action);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnWorkflowSidebarPanelOpenOrClose :: " + e.toString());
			flag = false;
		}

		return flag;
	}


	public boolean searchAndSelectFolder(String folderPath) {

		boolean flag = true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(folderPath.isEmpty()) {
				return flag;
			}

			if(folderPath.startsWith("/")) {
				folderPath=folderPath.substring(1);

			}

			if(folderPath.contains("/")) {

				String[] folders=folderPath.split("/");

				String childFolder = folders[2];

				searchFunctionalityMethod(driver, flag, folderSidebarSearchBar, folderSidebarSearchBtn, placeholderSearch, placeholderSearch, childFolder);

			}else {

				searchFunctionalityMethod(driver, flag, folderSidebarSearchBar, folderSidebarSearchBtn, placeholderSearch, placeholderSearch, folderPath);
			}
			folderPath=ParametersServicePage.folderPath(folderPath);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnFolderNameCheckboxOnScheduleDetailsPage(folderPath, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " searchAndSelectFolder :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean clickOnFolderNameCheckboxOnScheduleDetailsPage(String folderName, boolean state) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			By checkboxElement = returnElement(folderSidebarDynamicCheckbox, dynamicName, folderName);

			if (!isDisplayed(driver, checkboxElement)) {
				BaseSuite.reportFailLog(folderName + " Folder name checkbox not visible", "clickOnFolderNameCheckboxOnScheduleDetailsPage");
				return false;
			}

			String chkStatus = getAttribute(driver, checkboxElement, attributeClass);

			if (!chkStatus.contains(attrcheck) && state) {

				flag=clickOnButton(driver, checkboxElement, folderName, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			} else if (chkStatus.contains(attrcheck)) {
				BaseSuite.reportLog("Folder name " + folderName + " checkbox already checked");
				return true;
			}

			chkStatus = getAttribute(driver, checkboxElement, attributeClass);

			if (state && chkStatus.contains(attrcheck)) {
				BaseSuite.reportLog("Folder name " + folderName + " checkbox checked");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnFolderNameCheckboxOnScheduleDetailsPage :: " + e);
			return false;
		}

		return flag;
	}

	public boolean searchAndSelectWorkflow(String workflowName, String folderPath) {

		boolean flag = true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(folderPath.isEmpty()) {
				return flag;
			}

			folderPath=ParametersServicePage.folderPath(folderPath);

			searchFunctionalityMethod(driver, flag, workflowSidebarSearchBar, workflowSidebarSearchBtn, placeholderSearchWorkflow, placeholderSearchWorkflow, workflowName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnWorkflowNameCheckboxOnScheduleDetailsPage(workflowName, folderPath);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " searchAndSelectFolder :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean clickOnWorkflowNameCheckboxOnScheduleDetailsPage(String workflowName, String folderName, boolean state) {

		boolean flag = true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			By checkboxElement = returnTwoElements(workflowSidebarDynamicCheckbox, dynamicFolderName, folderName, dynamicName, workflowName);

			if (isDisplayed(driver, checkboxElement)) {
				BaseSuite.reportFailLog(folderName + " Workflow name checkbox not visible", "clickOnWorkflowNameCheckboxOnScheduleDetailsPage");
				return false;
			}

			String chkStatus = getAttribute(driver, checkboxElement, attributeClass);

			if (!chkStatus.contains(attrcheck) && state) {

				flag=clickOnButton(driver, checkboxElement, folderName, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			} else if (chkStatus.contains(attrcheck)) {
				BaseSuite.reportLog("Workflow name " + folderName + " checkbox already checked");
				return true;
			}

			chkStatus = getAttribute(driver, checkboxElement, attributeClass);

			if (state && chkStatus.contains(attrcheck)) {
				BaseSuite.reportLog("Workflow name " + folderName + " checkbox checked");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnWorkflowNameCheckboxOnScheduleDetailsPage :: " + e);
			return false;
		}

		return flag;
	}

	public boolean clickOnWorkflowNameCheckboxOnScheduleDetailsPage(String workflowName, String folderName) {

		boolean flag=true;
		boolean nextpageFlag=true;
		By locator=null;
		int pn=0;
		boolean isSelected=false;
		try {
			locator = returnTwoElements(workflowSidebarDynamicCheckbox, dynamicName, workflowName, dynamicFolderName, folderName);

			do {

				BaseSuite.reportLog("searching workflow name : "+workflowName+" on page number : "+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("Workflow name : "+workflowName+" found on page number : "+(pn+1));

					flag=selectcheckbox(driver, locator, workflowName);

					/**flag=clickOnButton(driver, locator, ruleName, true);*/

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isSelected=true;


					break;
				}
				if(isDisplayed(driver, workflowSidebarPanelNextPageArrow)) {

					String status = getAttribute(driver, workflowSidebarPanelNextPageArrow, attributeClass);

					if (!status.contains(disableTContent) && !isDisplayed(driver, locator)) {

						clickOnButton(driver, workflowSidebarPanelNextPageArrow, nextPageContent, true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled ");
						nextpageFlag=false;
						flag=false;
					}

				}

			}while(nextpageFlag);

			if(!isSelected) {
				BaseSuite.reportFailLog(workflowName+" workflow checkbox not selected", "clickOnWorkflowNameCheckboxOnScheduleDetailsPage");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  "Error occurs  while clickOnWorkflowNameCheckboxOnScheduleDetailsPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	//click on add rule button 
	public boolean clickOnAddWorkflowsButton(boolean state) {

		try {

			state=clickOnButton(driver, workflowSidebarAddButton, "Add", state);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {
				state=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, "", "Unexcepted toast message");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnAddWorkflowsButton :: "+e.toString());
			state=false;
		}

		return state;
	}


	public boolean selectWorkflowToAddSchedule(String folderPath, String workflowName) {

		boolean flag=true;

		try {

			flag = searchAndSelectFolder(folderPath);

			if(flag) {
				flag = searchAndSelectWorkflow(workflowName, folderPath);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" selectWorkflowToAddSchedule :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean addJobsToSchedule(String jobs) {

		String [] job = null;
		int count = 0;
		boolean flag=true;

		try {

			clickOnFolderSidebarPanelOpenOrClose(true);

			clickOnWorkflowSidebarPanelOpenOrClose(true);
			
			clickOnWorkflowTabOnSchedulesDetailsPage();

			if(!jobs.isEmpty()) {

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Adding jobs to schedule "+hyphenContent+hyphenContent);

				if(jobs.contains(",")) {

					job = jobs.split(","); 

					for(int i=0;i<job.length;i++) {

						DataTestingParameters param = setJobsParamUsingExcel(sCHEDULEEXCELFILEPATH, job[i]);

						selectWorkflowToAddSchedule(param.getFolderName(), param.getWorkflowName());

						count++;
					}

				}else {

					DataTestingParameters param = setJobsParamUsingExcel(sCHEDULEEXCELFILEPATH, jobs);

					selectWorkflowToAddSchedule(param.getFolderName(), param.getWorkflowName());

					count++;
				}

				flag= clickOnAddWorkflowsButton(count>0);

				clickOnWorkflowSidebarPanelOpenOrClose(false);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" addJobsToSchedule :: "+e.toString());
			flag=false;
		}

		return flag;	

	}

	public boolean clickOnSaveButtonAndValidateToast(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=verifyVisibilityOfButtons(driver, detailsPageButtonSave, saveContent, true);
			
			if(!flag) {return flag;}
			
			flag=clickOnButton(driver, detailsPageButtonSave, saveContent, true);

			if(!flag) {return flag;}

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Schedule Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Schedule Created");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnButtonAndValidateToast(By localor , String label, String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			flag=verifyVisibilityOfButtons(driver, localor, label, true);
			
			if(!flag) {return flag;}

			flag=clickOnButton(driver, localor, label, true);

			if(!flag) {return flag;}

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Schedule "+label);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Schedule "+label);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}



	public boolean checkFieldIsEnabledOrNot(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of input is enabled or not  for field  : "+label);

			String elementToCheck = expected ? detailsPageDynamicFieldEnabled : detailsPageDynamicFieldDisabled;

			if (isDisplayed(driver, returnElement(elementToCheck, dynamicName, label))) {

				BaseSuite.validationReportLog(label + " field is " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " field is " + (expected ? DISABLED : ENABLED) + " not matched with expected condition ", "checkFieldIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " checkFieldIsEnabledOrNot :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean validateField(String label, String placeholder, String defaultValue, boolean enabled) {
		boolean flag = true;
		try {

			javascript(driver, scrollToElementArg, returnElement(detailsPageDynamicLabel, dynamicName, label));

			validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, label), label, labelContent);
			validateElement(driver, returnElement(detailsPageDynamicField, dynamicName, label), label, fieldContent);

			checkFieldIsEnabledOrNot(label, enabled);

			verifyPlaceHolderValue(driver, returnElement(detailsPageDynamicField, dynamicName, label), label, placeholder);

			verifyDefaultValue(driver, returnElement(detailsPageDynamicField, dynamicName, label), label, defaultValue, attributeValue);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " validateField :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean validateFieldForDesc(String label, String placeholder, String defaultValue, boolean enabled) {
		boolean flag = true;
		try {
			log.info(enabled);
			javascript(driver, scrollToElementArg, returnElement(detailsPageDynamicLabel, dynamicName, label));

			validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, label), label, labelContent);
			validateElement(driver, detailsPageDescriptionField, label, fieldContent);

			/**	checkFieldIsEnabledOrNot(label, enabled);**/

			verifyPlaceHolderValue(driver, detailsPageDescriptionField, label, placeholder);

			verifyDefaultValue(driver,detailsPageDescriptionField, label, defaultValue, attributeValue);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " validateFieldForDesc :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	private boolean selectCheckboxOfSchedule(By locator, String label, String input) {

		boolean flag = true;

		if(Boolean.parseBoolean(input)) {

			flag=selectcheckbox1(driver,locator, label);

		}else {
			flag= unselectcheckbox1(driver,locator, label);
		}

		return flag;
	}

	// Helper method to log failure and return false
	private boolean logAndFail(String message, String methodName) {
		BaseSuite.reportFailLog(message + ", kindly check", methodName);
		return false;
	}

	public boolean selectCalendar(String calendarName) {
		boolean flag=true;
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); // Get current method name
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			BaseSuite.reportLog("Verifying Holiday calendar field visibility");

			isDisplayedInLoop(driver, 0, detailsPageHolidayCalendarField);

			if (!isDisplayed(driver, detailsPageHolidayCalendarField)) {
				return logAndFail("Holiday calendar field not visible", methodName);
			}

			BaseSuite.validationReportLog("Holiday calendar field is visible");

			isDisplayedInLoop(driver, 0, detailsPageHolidayCalendarDD);

			BaseSuite.reportLog("Clicking on holiday calendar dropdown icon");

			displayAndClick(driver, detailsPageHolidayCalendarDD);
			BaseSuite.validationReportLog("Clicked on Holiday calendar dropdown");

			isDisplayedInLoop(driver, 0, detailsPageHolidayCalendarInput);

			if (!isDisplayed(driver, detailsPageHolidayCalendarInput)) {
				return logAndFail("Holiday calendar input not visible", methodName);
			}

			BaseSuite.validationReportLog("Holiday calendar input is visible");
			sendKeys(driver, detailsPageHolidayCalendarInput, calendarName);

			By calendarElement = returnElement(detailsPageHolidayCalendarDynamicSelect, dynamicName, calendarName);

			if (!isDisplayed(driver, calendarElement)) {
				return logAndFail("Holiday calendar name " + calendarName + " not visible ", methodName);
			}

			BaseSuite.validationReportLog("Holiday calendar name " + calendarName + " is visible");
			BaseSuite.reportLog("Clicking on holiday calendar name: " + calendarName);

			displayAndClick(driver, calendarElement);
			BaseSuite.validationReportLog("Clicked on Holiday calendar name: " + calendarName);

			return true;
		} catch (NoSuchElementException e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " selectCalendar :: Element not found - " + e.getMessage());
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " selectCalendar :: " + e.toString());
		}
		return flag;
	}



	public boolean enterValues(String label, String placeholder, String inputValue, String validation, String enabled) {
		boolean flag=true;

		try {
			switch (label.toLowerCase().trim()) {

			case "type":
			case "time zone":

				flag= validateField(label, placeholder, inputValue,Boolean.parseBoolean(enabled));
				break;

			case "description":

				flag = validatAndeEnterValueToTextField(driver, returnElement(detailsPageDynamicLabel, dynamicName, label), 
						detailsPageDescriptionField, 
						detailsPageDescriptionValidation, 
						label, placeholder, inputValue, validation);
				break ; 

			case "holiday calendar":

				flag = selectCheckboxOfSchedule(detailsPageHolidayCalendarCheckbox, label, inputValue);

				break;
			default:

				flag = validatAndeEnterValueToTextField(driver, returnElement(detailsPageDynamicLabel, dynamicName, label), 
						returnElement(detailsPageDynamicField, dynamicName, label), 
						returnElement(detailsPageDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, validation);
				break;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " enterValues :: " + e.toString());
			flag = false;
		}

		return flag;
	}

	public boolean enterValues(String label, String placeholder, String inputValue) {

		boolean flag=true;

		try {
			switch (label.trim().toUpperCase()) {

			case "DAYS":

				BaseSuite.reportLog(hyphenContent+ "Selecting Days : "+inputValue +whiteSpace+hyphenContent);

				flag=selectDropdowns(detailsPageDaysField, inputValue, label, placeholder, true);

				break;

			case "HOURS":

				BaseSuite.reportLog(hyphenContent+ "Selecting Hours : "+inputValue +whiteSpace+hyphenContent);

				flag=selectDropdowns(detailsPageHoursField, inputValue, label, placeholder, true);

				break;
			case "MINUTES":

				BaseSuite.reportLog(hyphenContent+ "Selecting Minutes : "+inputValue+whiteSpace+hyphenContent);

				flag=selectDropdowns(detailsPageMinutesField, inputValue, label, placeholder, true);

				break;

			default :

				flag=validatAndeEnterValueToTextField(driver, returnElement(dynamicFieldLabel, dynamicName, label), 
						returnTwoElements(dynamicFieldInput, dynamicName, label, dynamicPlaceHolde, placeholder), 
						returnElement(detailsPageDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");

				break;

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " enterValues :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean updateValues(String label, String placeholder, String inputValue) {

		boolean flag=true;
		boolean task=true;
		try {

			if(inputValue.isEmpty()) {
				return true;
			}

			if(inputValue.equalsIgnoreCase(clearContent)) {
				task=false;
			}

			switch (label.trim().toUpperCase()+3) {

			case "DAYS3":

				displayAndClick(driver, detailsPageDaysField);

				displayAndClick(driver, detailsPageDaysFieldClear);

				BaseSuite.reportLog(hyphenContent+ "Selecting Days : "+inputValue +whiteSpace+hyphenContent);

				flag=task ? selectDropdowns(detailsPageDaysField, inputValue, label, placeholder, false) : displayAndClick(driver, detailsPageDaysField, label);

				break;

			case "HOURS3":

				displayAndClick(driver, detailsPageHoursField);

				displayAndClick(driver, detailsPageHoursFieldClear);

				BaseSuite.reportLog(hyphenContent+ "Selecting Hours : "+inputValue +whiteSpace+hyphenContent);

				flag=task ? selectDropdowns(detailsPageHoursField, inputValue, label, placeholder, false) : displayAndClick(driver, detailsPageHoursField, label);

				break;
			case "MINUTES3":

				displayAndClick(driver, detailsPageMinutesField);

				displayAndClick(driver, detailsPageMinutesFieldClear);

				BaseSuite.reportLog(hyphenContent+ "Selecting Minutes : "+inputValue+whiteSpace+hyphenContent);

				flag=task ? selectDropdowns(detailsPageMinutesField, inputValue, label, placeholder, false) : displayAndClick(driver, detailsPageMinutesField, label);

				break;

			default :

				flag=validatAndeEnterValueToTextField(driver, returnElement(dynamicFieldLabel, dynamicName, label), 
						returnTwoElements(dynamicFieldInput, dynamicName, label, dynamicPlaceHolde, placeholder), 
						returnElement(detailsPageDynamicValidation, dynamicName, label), 
						label, placeholder, inputValue, "");

				break;

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " updateValues :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean selectDropdownValues(By locator, By locator2, String label, String value) {

		boolean flag=true;

		try {

			if(!isDisplayed(driver, locator)){

				return false;
			}

			displayAndClick(driver, locator, label+ " dropdown");

			isDisplayedInLoop(driver, 0, locator2);

			if(!isDisplayed(driver, locator2)){

				displayAndClick(driver, locator, label+ " dropdown");
			}

			displayAndClick(driver, locator2, value+ whiteSpace+attributeValue);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " selectDropdownValues :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean selectDropdowns(By fieldlocator, String input, String label, String placeholder, boolean checklabel) {
		boolean flag=true;

		try {

			javascript(driver, scrollToElementArg, fieldlocator);

			if(checklabel) { validateElement(driver, returnElement(dynamicFieldLabel, dynamicName, label), label, labelContent);}

			verifyPlaceHolderValue(driver, fieldlocator, label, placeholder);

			if (input == null || input.isEmpty()) {
				return false;
			}

			// Splitting by comma and trimming spaces
			String[] values = input.split(",");

			for (String value : values) {

				BaseSuite.reportLog(hyphenContent+ "Selecting value from dropdown : "+value +whiteSpace+hyphenContent);

				flag=selectDropdownValues(fieldlocator,  returnElement(dynamicFieldSelect, dynamicName, value.trim()), label, value.trim());
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " selectDropdowns :: " + e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean enterStartDateAndEndDate(String type, String runTime) {
		boolean flag=true;

		if(runTime.isEmpty()) {
			return true;
		}
		BaseSuite.reportLog(hyphenContent+" Selecting "+type+whiteSpace+"as value : "+runTime +whiteSpace+hyphenContent);


		if(type.equalsIgnoreCase(endDateLabel)) {

			flag= validatAndeEnterValueToTextField(driver, detailsPageEndDateLabel, 
					detailsPageEndDateField, 
					returnElement(detailsPageDynamicValidation, dynamicName, endDateLabel), 
					endDateLabel, placeholderSelectEndDate, runTime, "");
		}else {

			flag= validatAndeEnterValueToTextField(driver, detailsPageStartDateLabel, 
					detailsPageStartDateField, 
					returnElement(detailsPageDynamicValidation, dynamicName, startDateLabel), 
					startDateLabel, placeholderSelectStartDate, runTime, "");
		}

		javascript(driver, scrollToElementArg, detailsPageOverviewTab);

		displayAndClick(driver, detailsPageOverviewTab, "Overview");

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		return flag;
	}

	public boolean updateStartDateAndEndDate(String type, String runTime) {
		boolean flag=true;

		if(runTime.isEmpty()) {
			return true;
		}

		if(runTime.equalsIgnoreCase(clearContent) && type.equalsIgnoreCase(endDateLabel)) {

			displayAndClick(driver, detailsPageEndDateField, endDateLabel);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			displayAndClick(driver, detailsPageEndDateClear, endDateLabel+" clear");
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String getDate = getAttribute(driver, type.equalsIgnoreCase(endDateLabel) ? detailsPageEndDateField :detailsPageStartDateField, attributeValue);

			return stringOutput(getDate, "", true);

		}
		for(int x=0; x<2; x++) {

			enterStartDateAndEndDate(type, runTime);

			String getDate = getAttribute(driver, type.equalsIgnoreCase(endDateLabel) ? detailsPageEndDateField :detailsPageStartDateField, attributeValue);

			/**flag = CustomTimeUtil.compareTimeDate(getDate, runTime, stimeStampFormat, stimeStampFormat);*/
			flag = CustomTimeUtil.compareFlexibleTimeDate(getDate, runTime);

			if(flag) {	
				break; 
			}
		}

		return flag;
	}

	public boolean updateOverviewDetailsForInvalid(SchedulerServiceParameters param, String name, String type,  String startRunTime, String endDate) {

		boolean flag=true;
		try {

			enterValues(scheduleNameContent, placeholderScheduleName, name, fieldValidationEmptyName, TRUE);

			enterValues(descriptionContent, placeholderDescription, param.getDescription(), "", TRUE);

			enterValues(typeContent, "", type, "", FALSE);

			enterValues(timezoneLabel, "", param.getTimezone(), "", FALSE);

			enterValues(holidayCalanderLabel, "", param.getUseHolidayCalender(), "", TRUE);

			updateValuesAccordingToTemplateInvalid(param, type, startRunTime, endDate, false);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" updateOverviewDetailsForInvalid :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean updateValuesAccordingToTemplateInvalid(SchedulerServiceParameters param, String templateType, String startRunTime, String endDate, boolean useDateTimeIcon) {

		boolean flag=true;
		try {

			flag = useDateTimeIcon && !templateType.trim().equalsIgnoreCase("onetime") && getSelectFromCalanderFlag(startRunTime) ?  selectDateAndTimeFromUI(startLabel, startRunTime) :updateStartDateAndEndDate(startDateLabel,startRunTime);

			if(Boolean.parseBoolean(param.getUseHolidayCalender())) {selectCalendar(param.getCalenderId());}

			switch(templateType.toUpperCase().trim()+2) {

			case "ONETIME2":

				break;
			case "DAILY2":

				/**	flag = useDateTimeIcon ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);*/

				updateStartDateAndEndDate(endDateLabel, endDate);

				updateValues(reoccurLabel, placeholderSelectReoccur, param.getReoccur());

				updateValues(hoursLabel, placeholderSelectHours, param.getHours());

				updateValues(minuteLabel, placeholderSelectMinute, param.getMinutes());

				break;
			case "WEEKLY2":

				/**	flag = useDateTimeIcon ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);*/

				updateStartDateAndEndDate(endDateLabel, endDate);

				updateValues(daysLabel, placeholderSelectDays, param.getDays().equalsIgnoreCase(clearContent) ? param.getDays() : CustomTimeUtil.getDayOfWeekString(param.getDays()));

				updateValues(hoursLabel, placeholderSelectHours, param.getHours());

				updateValues(minuteLabel, placeholderSelectMinute, param.getMinutes());

				break;
			case "ADVANCE2":
			case "ADVANCED2":
				/**	flag = useDateTimeIcon ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);*/

				updateStartDateAndEndDate(endDateLabel, endDate);

				updateValues(cronExpressionLabel, placeholderEnterCronExp, param.getCronExpression());

				break;

			default :

				break;

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" updateValuesAccordingToTemplateInvalid :: "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean selectDateAndTimeFromUI(String type, String dateTime) {
		WorkflowPage wp = new WorkflowPage(driver);
		boolean flag = true;

		try {
			if(dateTime.isEmpty()) { return true; } 

			BaseSuite.reportLog(hyphenContent+" Selecting "+type+whiteSpace+"as value : "+dateTime+whiteSpace+hyphenContent);			

			String[] parts = dateTime.split(" ", 2);
			String date = parts[0];
			String time = parts[1];

			time = time.trim().startsWith("0") ? time.substring(1) : time;

			By dateIcon = type.equalsIgnoreCase(startLabel) ? detailsPageStartDateDateIcon : detailsPageEndDateDateIcon;
			By timeIcon = type.equalsIgnoreCase(startLabel) ? detailsPageStartDateTimeIcon : detailsPageEndDateTimeIcon;
			String timeDynamicSelect = type.equalsIgnoreCase(startLabel) ? detailsPageStartDateTimeDynamicSelect : detailsPageEndDateTimeDynamicSelect;

			// Select date
			wp.selectDate(flag, dateIcon, date);
			isDisplayedInLoop(driver, 0, timeIcon);
			BaseSuite.reportLog("Verifying time icon is visible or not");
			if (isDisplayed(driver, timeIcon)) {
				BaseSuite.validationReportLog("Time icon is visible");
				BaseSuite.reportLog("Clicking on time icon");
				displayAndClick(driver, timeIcon);
				BaseSuite.validationReportLog("Clicked on time icon");
				By timeElement = returnElement(timeDynamicSelect, dynamicName, time);
				BaseSuite.reportLog("Verifying time is visible or not");
				isDisplayedInLoop(driver, 0, timeElement);
				if (isDisplayed(driver, timeElement)) {
					BaseSuite.validationReportLog("Time is visible :: "+time);
					BaseSuite.reportLog("Clicking on time from dropdown list");
					displayAndClick(driver, timeElement);
					BaseSuite.validationReportLog("Clicked on time :: "+time);
				}else {
					BaseSuite.reportFailLog("Expected time not visible in list kindly check "+time , "selectDateAndTimeFromUI");
					flag = false;
				}
			}else {
				BaseSuite.reportFailLog("Expected time icon not visible in list kindly check "+timeIcon , "selectDateAndTimeFromUI");
				flag = false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " selectDateAndTimeFromUI :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean getSelectFromCalanderFlag(String time) {

		if(time.isEmpty()) {
			return false;
		}
		return time.contains(":00") ||  time.contains(":30");
	}


	public boolean enterValuesAccordingToTemplate(SchedulerServiceParameters param, String templateType, String startRunTime, String endDate, boolean useDateTimeIcon) {

		boolean flag=true;
		try {

			flag = useDateTimeIcon && !templateType.trim().equalsIgnoreCase(ONETIME) && getSelectFromCalanderFlag(startRunTime) ?  selectDateAndTimeFromUI(startLabel, startRunTime) : enterStartDateAndEndDate(startDateLabel,startRunTime);

			if(Boolean.parseBoolean(param.getUseHolidayCalender())) {selectCalendar(param.getCalenderId());}

			switch(templateType.toUpperCase().trim()+1) {

			case "ONETIME1":

				break;
			case "DAILY1":

				flag = useDateTimeIcon && getSelectFromCalanderFlag(endDate) ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);

				enterValues(reoccurLabel, placeholderSelectReoccur, param.getReoccur());

				enterValues(hoursLabel, placeholderSelectHours, param.getHours());

				enterValues(minuteLabel, placeholderSelectMinute, param.getMinutes());

				break;
			case "WEEKLY1":

				flag = useDateTimeIcon && getSelectFromCalanderFlag(endDate) ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);

				enterValues(daysLabel, placeholderSelectDays, CustomTimeUtil.getDayOfWeekString(param.getDays()));

				enterValues(hoursLabel, placeholderSelectHours, param.getHours());

				enterValues(minuteLabel, placeholderSelectMinute, param.getMinutes());

				break;
			case "ADVANCE1":
			case "ADVANCED1":

				flag = useDateTimeIcon && getSelectFromCalanderFlag(endDate) ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);

				enterValues(cronExpressionLabel, placeholderEnterCronExp, param.getCronExpression());

				break;

			default :

				break;

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" enterValuesAccordingToTemplate :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean updateValuesAccordingToTemplate(SchedulerServiceParameters param, String templateType, String startRunTime, String endDate, boolean useDateTimeIcon) {

		boolean flag=true;
		try {

			flag = useDateTimeIcon && !templateType.trim().equalsIgnoreCase("onetime") && getSelectFromCalanderFlag(startRunTime) ?  selectDateAndTimeFromUI(startLabel, startRunTime) :enterStartDateAndEndDate(startDateLabel,startRunTime);

			if(Boolean.parseBoolean(param.getUseHolidayCalender())) {selectCalendar(param.getCalenderId());}

			switch(templateType.toUpperCase().trim()+2) {

			case "ONETIME2":

				break;
			case "DAILY2":

				/**	flag = useDateTimeIcon ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);*/

				enterStartDateAndEndDate(endDateLabel, endDate);

				updateValues(reoccurLabel, placeholderSelectReoccur, param.getReoccur());

				updateValues(hoursLabel, placeholderSelectHours, param.getHours());

				updateValues(minuteLabel, placeholderSelectMinute, param.getMinutes());

				break;
			case "WEEKLY2":

				/**	flag = useDateTimeIcon ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);*/

				enterStartDateAndEndDate(endDateLabel, endDate);

				updateValues(daysLabel, placeholderSelectDays, CustomTimeUtil.getDayOfWeekString(param.getDays()));

				updateValues(hoursLabel, placeholderSelectHours, param.getHours());

				updateValues(minuteLabel, placeholderSelectMinute, param.getMinutes());

				break;
			case "ADVANCE2":
			case "ADVANCED2":
				/**	flag = useDateTimeIcon ?  selectDateAndTimeFromUI(endLabel, endDate) : enterStartDateAndEndDate(endDateLabel, endDate);*/

				enterStartDateAndEndDate(endDateLabel, endDate);

				updateValues(cronExpressionLabel, placeholderEnterCronExp, param.getCronExpression());

				break;

			default :

				break;

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" updateValuesAccordingToTemplate :: "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean enterOverviewDetails(SchedulerServiceParameters param, String name,  String startRunTime, String endDate) {

		boolean flag=true;
		try {

			enterValues(scheduleNameContent, placeholderScheduleName, name, fieldValidationEmptyName, TRUE);

			enterValues(descriptionContent, placeholderDescription, param.getDescription(), "", TRUE);

			enterValues(typeContent, "", param.getType(), "", FALSE);

			enterValues(timezoneLabel, "", param.getTimezone(), "", FALSE);

			enterValues(holidayCalanderLabel, "", param.getUseHolidayCalender(), "", TRUE);

			enterValuesAccordingToTemplate(param, param.getType(), startRunTime, endDate, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" enterOverviewDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean updateOverviewDetails(SchedulerServiceParameters param, String name, String type,  String startRunTime, String endDate) {

		boolean flag=true;
		try {

			enterValues(scheduleNameContent, placeholderScheduleName, name, fieldValidationEmptyName, TRUE);

			enterValues(descriptionContent, placeholderDescription, param.getDescription(), "", TRUE);

			enterValues(typeContent, "", type, "", FALSE);

			enterValues(timezoneLabel, "", param.getTimezone(), "", FALSE);

			enterValues(holidayCalanderLabel, "", param.getUseHolidayCalender(), "", TRUE);

			updateValuesAccordingToTemplate(param, type, startRunTime, endDate, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" updateOverviewDetails :: "+e.toString());
			flag=false;
		}
		return flag;

	}



	public boolean validateRecentRunsOfSchedule(int records) {

		boolean flag=true;
		try {

			validateElement(driver, recentRunsTitle, recentRunsContent, attributeTitle);

			javascript(driver, scrollToElementArg, recentRunsTitle);

			verifyVisibilityOfButtons(driver, recentRunsRefresh, refreshContent, true);

			verifySearchField(driver, recentRunsSearchBar, placeholderSearchRecentRun, placeholderSearchRecentRun);

			validateElement(driver, recentRunsColumnId, "Schedule Instance ID", columnContent);
			validateElement(driver, recentRunsColumnStatus, "Status", columnContent);
			validateElement(driver, recentRunsColumnStarttime, "Start Timestamp", columnContent);
			validateElement(driver, recentRunsColumnEndtime, "End Timestamp", columnContent);
			validateElement(driver, recentRunsColumnElapsedtime, "Elapsed Time", columnContent);
			validateElement(driver, recentRunsColumnInstances, instancesContent, columnContent);

			javascript(driver, scrollToElementArg, recentRunsPaginationBar);

			List<String> pageinfo = getPaginationDetails(driver, recentRunsPaginationInfo, recentRunsPaginationBar, recentRunsNoRecordsTodisplay, recentRunsContent+" Details  ");

			if(records>0) {
				compareValues(records, Integer.parseInt(pageinfo.get(1)), recentRunsContent+" count  ");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateRecentRunsOfSchedule :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickonrefreshbuttonOfRecentRuns() {

		isDisplayedInLoop(driver, 3, recentRunsRefresh);

		javascript(driver, scrollToElementArg, recentRunsRefresh);

		return clickOnButton(driver, recentRunsRefresh, refreshContent, true);

	}

	public void refreshInLoop() {

		isDisplayedInLoop(driver, 3, recentRunsRefresh);

		javascript(driver, scrollToElementArg, recentRunsRefresh);

		displayAndClick(driver, recentRunsRefresh);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

	}

	public String clickOnRefreshIconToGetStatus(int countToRefresh) {

		String state = null;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickonrefreshbuttonOfRecentRuns();

			waitForTime(1);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			for(int i=1; i<countToRefresh; i++) {

				refreshInLoop();

				state = isDisplayed(driver, recentRunsValueStatus) ? getAttribute(driver, recentRunsValueStatus, attributeTextContent) : null;

				state = checkNullValue(state);

				if(state.equalsIgnoreCase(scheduleStatusProcessing)) {

					refreshInLoop();

					waitForTime(1);

				}else if(state.trim().equalsIgnoreCase(scheduleStatusSuccessed)){

					break;
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnRefreshIconToGetStatus :: "+e.toString());

		}

		return state;
	}

	public String getValueOfField(By locator, String label) {

		String value = null;
		isDisplayedInLoop(driver, 2, locator);

		if(isDisplayed(driver, locator)) {

			javascript(driver, scrollToElementArg, locator);

			BaseSuite.reportLog(label+isVisibleContent);

			value = getAttribute(driver, locator, attributeTextContent);

			if(!value.isEmpty()) {

				BaseSuite.validationReportLog(label+"  is :: "+value);
			}

		}else {
			BaseSuite.reportFailLog(label+whiteSpace+" not visible", "getValueOfField1");
		}
		return value;
	}

	public String getValueOfField(By locator, String label, String attribute, boolean flag) {

		String value = null;
		isDisplayedInLoop(driver, 2, locator);

		BaseSuite.reportLog("Verifying value in "+label+"field ");

		if(isDisplayed(driver, locator)) {

			javascript(driver, scrollToElementArg, locator);

			BaseSuite.reportLog(label+isVisibleContent);

			value = getAttribute(driver, locator, attribute);

			if(!value.isEmpty()) {

				BaseSuite.validationReportLog(label+"  is :: "+value);
			}else if(flag && value.trim().isEmpty()) {

				BaseSuite.reportFailLog(label+"  field value is empty :: "+value, "getValueOfField");
			}

		}else {
			BaseSuite.reportFailLog(label+whiteSpace+" not visible", "getValueOfField");
		}
		return value;
	}

	//validate workflow recent run info
	public String validateScheduleRecentRunInfo(String expectedStatus) {
		String instanceId=null;
		String sch ="Schedule recent run";
		try {
			instanceId=getValueOfField(recentRunsValueId, sch+" Instance ID");

			String acs = getValueOfField(recentRunsValueStatus, sch+" Status");

			if(expectedStatus.isEmpty()){stringOutput(acs, expectedStatus, true);}

			getValueOfField(recentRunsValueStarttime, sch+startTimestampLabel);

			getValueOfField(recentRunsValueEndtime, sch+" End Timestamp");

			getValueOfField(recentRunsValueElapsedtime, sch+" Elapsed Time");

			getValueOfField(recentRunsValueInstances, sch+" Instances");

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateScheduleRecentRunInfo :: "+e.toString());

		}
		return instanceId;
	}

	//search recent run on recent runs 
	public boolean searchRecentRunOnRecentRunsField(boolean flag, String instanceid) {

		return searchFunctionalityMethod(driver, flag, recentRunsSearchBar, recentRunsSearchBtn, recentRunsContent+" "+searchBoxLabel, placeholderSearchRecentRun, instanceid);
	}

	public void getScheduleInstanceTable() {

		try {

			String [][] table = new String[2][4];

			String [] header = {"Seq","Schedule Instance ID","Status","Start Timestamp", "End Timestamp","Elapsed Time",instancesContent};
			table[0] = header;

			String id=getValue(driver, recentRunsValueId);

			String name=getValue(driver, recentRunsValueStatus);

			String status=getValue(driver, recentRunsValueStarttime);

			String type=getValue(driver, recentRunsValueEndtime);

			String code=getValue(driver, recentRunsValueElapsedtime);

			String time=getValue(driver, recentRunsValueInstances);

			String [] data = {"1",id, name,status,type,code,time};

			table[1] = data;

			BaseSuite.reportLog(createHtmlTable1(table,"Schedule Recent Runs Details"));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" getScheduleInstanceTable :: "+e.toString());
		}

	}

	public String verifyInstanceID() {

		String preinstanceid="";

		try {
			if(isDisplayed(driver, recentRunsValueId)) {

				preinstanceid=getAttribute(driver, recentRunsValueId, attributeTextContent);

				if(preinstanceid==null) {
					preinstanceid="";
				}else {
					BaseSuite.reportLog("Previous execution instance id : "+preinstanceid);
				}
			}else {
				BaseSuite.reportLog("No Previous execution instance id "+preinstanceid);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" verifyInstanceID :: "+e.toString());

		}
		return preinstanceid;
	}

	public boolean validateScheduleInstanceAfterRun(String templateType, String expectedTime, int runAfterMinute, String scheduleName, String folderName, String expectedStatus, int rrcount) {
		boolean flag=true;
		String instanceid ="";

		try {

			BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying recent runs section of schedule "+hyphenContent+hyphenContent);

			validateRecentRunsOfSchedule(rrcount);

			flag=clickonrefreshbuttonOfRecentRuns();

			if(!templateType.equalsIgnoreCase(ONETIME)) {return true;}

			if(!flag) {return false;}

			String preinstanceid=verifyInstanceID();

			CustomTimeUtil.waitForExecution(stimeStampFormat, expectedTime);

			String status = clickOnRefreshIconToGetStatus(100);

			for(int i=0;i<400; i++) {

				clickOnRefreshIconToGetStatus(100);

				instanceid = verifyInstanceID();

				if(instanceid.isEmpty() || instanceid.equalsIgnoreCase(preinstanceid)) {
					status=clickOnRefreshIconToGetStatus(400);
					instanceid = validateScheduleRecentRunInfo(expectedStatus);
					waitForTime(runAfterMinute);
				}else if(!instanceid.equalsIgnoreCase(preinstanceid)){

					break;
				}

			}

			flag=searchRecentRunOnRecentRunsField(flag, instanceid);

			if(!flag) {return false;}

			if(status.equalsIgnoreCase(scheduleStatusProcessing)) { return flag;}

			getScheduleInstanceTable();

			String acTime = getValueOfField(recentRunsValueStarttime, startTimestampLabel);

			flag=CustomTimeUtil.compareTimeStamp(expectedTime, acTime, stimeStampFormat, RRTIMESTAMPFORMAT);

			validateScheduleJobsOnInstancesTab(recentRunsValueInstances, scheduleName, folderName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateScheduleInstanceAfterRun :: "+e.toString());
			flag=false;
		}
		return flag;


	}

	//CREATE
	public boolean createScheduleFunctionality(SchedulerServiceParameters param, String icedqUser, boolean validateOnMonitor) {
		String runTime="";
		String endTime="";
		boolean flag=true;

		int runAfterMinute = 3;
		try {

			flag = clickOnNewScheduleButton(icedqUser);

			if(flag && (icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent))) {

				validateAddNewScheduleSidebar();

				addNewScheduleDetails(param.getFolderName(), param.getScheduleName(), param.getTemplete());

				clickOnOverviewTab();

				runTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, param.getTemplete().equalsIgnoreCase(ONETIME) ? runAfterMinute : 30), param.getStartDate());

				endTime=param.getEndDate();

				enterOverviewDetails(param, param.getScheduleName(), runTime, endTime);

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				flag=clickOnSaveButtonAndValidateToast(toastMessageScheduleCreated);
				
				if(!flag) { return false;}

				validateAndActivateOrDisactivate1(Boolean.parseBoolean(param.getIsActive()));

				validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

				viewJobDetailsPane(Integer.parseInt(param.getJobCount()));

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying overview tab details after creating new schedule  "+hyphenContent+hyphenContent);

				clickOnOverviewTab();

				viewValuesAccordingToTemplate(param, param.getTemplete(), runTime, endTime);

				List<String> pageinfo = getPaginationDetails(driver, recentRunsPaginationInfo, recentRunsPaginationBar, recentRunsNoRecordsTodisplay, recentRunsContent+" Details ");

				compareValues(0, Integer.parseInt(pageinfo.get(1)), recentRunsContent+" count ");

				flag=validateScheduleInstanceAfterRun(param.getTemplete(), runTime, runAfterMinute, param.getScheduleName(), param.getFolderName(), param.getStatus(), 0);

				if(param.getTemplete().equalsIgnoreCase(ONETIME)) { 
					String acTime = getValueOfField(recentRunsValueStarttime, startTimestampLabel);
					validateScheduleOnMonitor(validateOnMonitor, param.getScheduleName(), param.getFolderName(), param.getType(), acTime, getUserFullName(icedqUser), "Auto");

				}
				clickOnSchedulesTab();

				validateSchedulesOnListingPage(param, param.getScheduleName());

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" createScheduleFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean searchScheduleNameAndClickOnLinkOnListingPage(String scheduleName, String folderPath) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, scheduleName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, listingNoRecordsToDisplay)) {

				By locator = returnTwoElements(listingScheduleNameDynamicLink, dynamicFolderName, folderPath, dynamicName, scheduleName);

				flag=searchScheduleNameOnEachPageAndClickOn(locator, scheduleName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+" is visible ","searchScheduleNameAndClickOnLinkOnListingPage");
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			if(!flag) { 
				
				BaseSuite.reportFailLog("Searched schedule name not found kindly check", "searchScheduleNameAndClickOnLinkOnListingPage");
				BaseSuite.skipReportLog("Searched schedule name not found kindly check");
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchScheduleNameAndClickOnLinkOnListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean searchScheduleNameOnListingPage(String scheduleName, String folderPath) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, scheduleName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, listingNoRecordsToDisplay)) {

				By locator = returnTwoElements(listingScheduleNameDynamicLink, dynamicFolderName, folderPath, dynamicName, scheduleName);

				flag=searchScheduleNameOnEachPage(locator, scheduleName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				/**	BaseSuite.reportFailLog(noRecordsToDisplayContent+" is visible ","searchScheduleNameOnListingPage");*/
				BaseSuite.reportLog("Searched name not found.");
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchScheduleNameOnListingPage :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean searchScheduleNameOnEachPageAndClickOn(By locator, String name) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching schedule name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("schedule name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, listingPageNextPageArrow)) {

					String status = getAttribute(driver, listingPageNextPageArrow, attributeClass);

					if (!status.contains(disableTContent)) {

						clickOnButton(driver, listingPageNextPageArrow, nextPageContent, true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchScheduleNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchScheduleNameOnEachPage(By locator, String name) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching schedule name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("schedule name : "+name+" found on page number :"+(pn+1));

					flag=true;

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, listingPageNextPageArrow)) {

					String status = getAttribute(driver, listingPageNextPageArrow, attributeClass);

					if (!status.contains(disableTContent)) {

						List<String> as= getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleListingContent);	
						if(Integer.parseInt(as.get(1))==0) {
							nextpageFlag=false;
						}

						clickOnButton(driver, listingPageNextPageArrow, nextPageContent, true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;

					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchScheduleNameOnEachPage :: "+e.toString());
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

	public boolean validateSchedulesOnListingPage(SchedulerServiceParameters param, String name) {

		boolean flag=true;

		try {

			BaseSuite.reportLog(hyphenContent+hyphenContent+" verifying schedule details on listing page "+hyphenContent+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, name);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				validateValues(getDynamicLocator(listingScheduleCheckboxDynamicLink, param.getFolderName(), name), scheduleNameContent, "", checkboxContent, attributeTextContent, false);

				validateValues(getDynamicLocator(listingScheduleAvatarDynamicLink, param.getFolderName(), name), typeContent, param.getType(), iconContent, attributeTextContent, false);

				validateValues(getDynamicLocator(listingScheduleNameDynamicLink, param.getFolderName(), name), scheduleNameContent, name, hyperlinkContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingScheduleDescriptionDynamicLink, param.getFolderName(), name), descriptionContent, param.getDescription(), attributeTextContent, attributeTextContent, true);

				validateValues(getDynamicLocator(listingScheduleFolderDynamicLink, param.getFolderName(), name), folderContent, param.getFolderName(), attributeTextContent, attributeTitle, true);

				validateValues(getDynamicLocator(listingScheduleNoOfJobDynamicLink, param.getFolderName(), name), "# of Jobs", param.getJobCount(), attributeTextContent, attributeTextContent, true);

				String updatedBy=getAttribute(driver, getDynamicLocator(listingScheduleUpdateByDynamicLink, param.getFolderName(), name), attributeTitle);

				if(!updatedBy.isEmpty()) {
					BaseSuite.reportLog("Schedule last updated by :: "+updatedBy);
				}else {
					BaseSuite.reportFailLog("Schedule last updated by not visible", "validateSchedulesOnListingPage");
				}

				String lastUpdated=getAttribute(driver, getDynamicLocator(listingScheduleUpdateDateDynamicLink, param.getFolderName(), name), attributeTextContent);

				if(!lastUpdated.isEmpty()) {
					BaseSuite.reportLog("Schedule last updated date :: "+lastUpdated);
				}else {
					BaseSuite.reportFailLog("Schedule last updated date not visible", "validateSchedulesOnListingPage");
				}

				getSchedulesListingPageTable("1", true,"");

				getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleListingContent);	

			}

			clickOnRefreshOnScheduleListingPage();

		}catch (Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateSchedulesOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateScheduleOnListingPageAfterDeleting(SchedulerServiceParameters param, String name) {

		boolean flag=true;

		try {

			BaseSuite.reportLog(hyphenContent+hyphenContent+" verifying schedule details on listing page "+hyphenContent+hyphenContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, name);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, getDynamicLocator(listingScheduleNameDynamicLink, param.getFolderName(), name))) {

				validateElement(driver, listingNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);

				/**	getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleListingContent);	
				 */

			}else if(isDisplayed(driver, getDynamicLocator(listingScheduleNameDynamicLink, param.getFolderName(), name))){

				BaseSuite.reportFailLog("Schedule is visible on listing page kindly check, "+name,"validateScheduleOnListingPageAfterDeleting");
			}

		}catch (Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateScheduleOnListingPageAfterDeleting :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	//verify select folder UI 
	public boolean validateFolderSearchSideBar() {
		boolean flag=true;
		try {

			clickOnFolderSidebarPanelOpenOrClose(true);

			isDisplayedInLoop(driver, 3, folderSidebarTitle);

			verifyIndividualLabel(driver, folderSidebarTitle, folderContent);

			verifySearchField(driver, folderSidebarSearchBar, searchBoxLabel, placeholderSearch);

			List<WebElement> foldersList =getElements(driver, folderSidebarFolderList);

			BaseSuite.reportLog("verifying list of folders ");

			for(int i= 0 ;i<foldersList.size();i++) {

				String folder = foldersList.get(i).getAttribute(attributeTitle);

				BaseSuite.reportLog((i+1)+"."+folder+" folder is visible");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateFolderSearchSideBar :: "+e.toString());
			flag=false;
		}

		return flag;

	}
	
	public void clickOnWorkflowTabOnSchedulesDetailsPage() {
		
		displayAndClick(driver, workflowSidebarTitle);
		
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);	
	}

	//verify rule side bar
	public List<String> validateWorkflowOnSchedulesDetailsPage() {

		List<String> list = new ArrayList<>();
		try {

			clickOnWorkflowSidebarPanelOpenOrClose(true);
			
			isDisplayedInLoop(driver, 3, workflowSidebarTitle);

			verifyIndividualLabel(driver, workflowSidebarTitle, "Workflows");
			
			clickOnWorkflowTabOnSchedulesDetailsPage();
			
			verifySearchField(driver, workflowSidebarSearchBar, "Workflow name search", placeholderSearchWorkflow);

			verifyVisibilityOfButtons(driver, workflowSidebarAddButton, "Add", false);

			validateElement(driver, workflowSidebarMastercheckbox, masterContent, checkboxContent);

			validateElement(driver, workflowSidebarcolumnName, "Name", columnContent);

			validateElement(driver, workflowSidebarColumnFolder, folderContent, columnContent);

			list=getPaginationDetails(driver, workflowSidebarPaginationInfo, workflowSidebarPaginationBar, workflowSidebarNoRecordsTodisplay, "Workflow side panel");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateWorkflowOnSchedulesDetailsPage :: "+e.toString());

		}

		return list;	
	}

	public boolean checkCheckboxIsEnabledOrNot(String label, boolean expected) {
		boolean flag = true;
		try {

			BaseSuite.reportLog("Verifying state of checkbox is enabled or not for : "+label);

			By elementToCheck = expected ? detailsPageHolidayCalenderEnable : detailsPageHolidayCalenderDisable;

			if (isDisplayed(driver, elementToCheck)) {

				BaseSuite.validationReportLog(label + " checkbox is " + (expected ? ENABLED : DISABLED));

			} else {
				BaseSuite.reportFailLog(label + " checkbox is " + (expected ? DISABLED : ENABLED) + " not matched with expected condition ", "checkCheckboxIsEnabledOrNot");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " checkCheckboxIsEnabledOrNot :: " + e.toString());
			flag = false;
		}
		return flag;
	}

	public boolean viewValues(String label, String placeholder, String inputValue, String enabled) {
		boolean flag=true;

		try {
			switch (label.toLowerCase().trim()+1) {

			case "description1":

				flag = validateFieldForDesc(label, placeholder, inputValue, Boolean.parseBoolean(enabled));
				break ; 

			case "holiday calendar1":

				flag = checkCheckboxIsEnabledOrNot(label, true);

				checkboxStatus(detailsPageHolidayCalendarCheckbox, label, Boolean.parseBoolean(inputValue));

				break;
			default:

				flag= validateField(label, placeholder, inputValue,Boolean.parseBoolean(enabled));
				break;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " viewValues :: " + e.toString());
			flag = false;
		}

		return flag;
	}

	public boolean viewValuesAccordingToTemplate(SchedulerServiceParameters param, String templateType, String startRunTime, String endDate) {

		boolean flag=true;
		try {

			String syr= startRunTime.isEmpty() ? CustomTimeUtil.getCurrentDateInfo(yearContent) : CustomTimeUtil.getDatePart(stimeStampFormat, startRunTime, yearContent);

			String eyr= endDate.isEmpty() ? "2099" : CustomTimeUtil.getDatePart(stimeStampFormat, endDate, yearContent);

			validateElement(driver, detailsPageStartDateLabel, startDateLabel, labelContent);

			viewAndValidateField(driver, detailsPageStartDateField, startDateLabel, "", true);

			String sDate = getValueOfField(detailsPageStartDateField, startDateLabel, attributeValue, true);

			String hours = param.getHours().isEmpty() ? param.getHours() :  param.getHours().replace(",", ", ");

			String minutes = param.getMinutes().isEmpty() ? param.getMinutes() : param.getMinutes().replace(",", ", ");

			By hourLocator = hours.isEmpty() ? returnTwoElements(dynamicFieldInput, dynamicName, hoursLabel, dynamicPlaceHolde, placeholderSelectHours) : detailsPageHoursFieldValue;

			By minuteLocator = minutes.isEmpty() ? returnTwoElements(dynamicFieldInput, dynamicName, minuteLabel, dynamicPlaceHolde, placeholderSelectMinute) : detailsPageMinutesFieldValue;

			String crHour = param.getHours().isEmpty() && !startRunTime.isEmpty() ? CustomTimeUtil.getDatePart(stimeStampFormat, startRunTime, "hour") : param.getHours();

			String crMinute =  param.getMinutes().isEmpty() && !startRunTime.isEmpty() ? CustomTimeUtil.getDatePart(stimeStampFormat, startRunTime, "minute") : param.getMinutes();

			switch(templateType.toUpperCase().trim()) {

			case "ONETIME":

				break;
			case "DAILY":

				validateElement(driver, detailsPageEndDateLabel, endDateLabel, labelContent);

				viewAndValidateField(driver, detailsPageEndDateField, endDateLabel, "", true);

				getValueOfField(detailsPageEndDateField, endDateLabel, attributeValue, !endDate.isEmpty());

				validateElementWithAll(fieldContent, detailsPageReoccurFieldValue, reoccurLabel, param.getReoccur(), attributeValue);

				validateElementWithAll(fieldContent, hourLocator, hoursLabel, hours, attributeTextContent);

				validateElementWithAll(fieldContent, minuteLocator, minuteLabel, minutes, attributeTextContent);

				String dailycron = CustomTimeUtil.getCronExpression(templateType, param.getReoccur(), crHour, crMinute,  "", syr, eyr, sDate, stimeStampFormat);

				validateElementWithAll(fieldContent, returnTwoElements(dynamicFieldInput, dynamicName, cronExpressionLabel, dynamicPlaceHolde, placeholderEnterCronExp), cronExpressionLabel, dailycron, attributeValue);

				javascript(driver, scrollToElementArg, returnElement(detailsPageDynamicLabel, dynamicName, nextExecutionLabel));

				validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, nextExecutionLabel), nextExecutionLabel, labelContent);

				viewAndValidateField(driver, returnElement(detailsPageDynamicField, dynamicName, nextExecutionLabel), nextExecutionLabel, CustomTimeUtil.getNextExecution2(dailycron,  param.getTimezone(), sDate), false);

				break;
			case "WEEKLY":

				validateElement(driver, detailsPageEndDateLabel, endDateLabel, labelContent);

				viewAndValidateField(driver, detailsPageEndDateField, endDateLabel, "", true);

				getValueOfField(detailsPageEndDateField, endDateLabel, attributeValue, !endDate.isEmpty());

				validateElementWithAll(fieldContent, detailsPageDaysFieldValue, daysLabel, CustomTimeUtil.getDayOfWeekString(param.getDays()), attributeTextContent);

				validateElementWithAll(fieldContent, hourLocator, hoursLabel, hours, attributeTextContent);

				validateElementWithAll(fieldContent, minuteLocator, minuteLabel, minutes, attributeTextContent);

				String weeklycron = CustomTimeUtil.getCronExpression(templateType, param.getReoccur(),  crHour, crMinute,  CustomTimeUtil.getCronDayOfWeek(CustomTimeUtil.getDayOfWeekString(param.getDays())), syr, eyr, sDate, stimeStampFormat);

				validateElementWithAll(fieldContent, returnTwoElements(dynamicFieldInput, dynamicName, cronExpressionLabel, dynamicPlaceHolde, placeholderEnterCronExp), cronExpressionLabel, weeklycron, attributeValue);

				javascript(driver, scrollToElementArg, returnElement(detailsPageDynamicLabel, dynamicName, nextExecutionLabel));

				validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, nextExecutionLabel), nextExecutionLabel, labelContent);

				viewAndValidateField(driver, returnElement(detailsPageDynamicField, dynamicName, nextExecutionLabel), nextExecutionLabel, CustomTimeUtil.getNextExecution2(weeklycron,  param.getTimezone(), sDate), false);

				break;
			case "ADVANCE":
			case "ADVANCED":

				validateElement(driver, detailsPageEndDateLabel, endDateLabel, labelContent);

				viewAndValidateField(driver, detailsPageEndDateField, endDateLabel, "", true);

				getValueOfField(detailsPageEndDateField, endDateLabel, attributeValue, !endDate.isEmpty());

				validateElementWithAll(fieldContent, returnTwoElements(dynamicFieldInput, dynamicName, cronExpressionLabel, dynamicPlaceHolde, placeholderEnterCronExp), cronExpressionLabel, param.getCronExpression(), attributeValue);

				checkFieldEnabledOrNot(driver, returnTwoElements(dynamicFieldInput, dynamicName, cronExpressionLabel, dynamicPlaceHolde, placeholderEnterCronExp), cronExpressionLabel, true);

				javascript(driver, scrollToElementArg, returnElement(detailsPageDynamicLabel, dynamicName, nextExecutionLabel));

				validateElement(driver, returnElement(detailsPageDynamicLabel, dynamicName, nextExecutionLabel), nextExecutionLabel, labelContent);

				viewAndValidateField(driver, returnElement(detailsPageDynamicField, dynamicName, nextExecutionLabel), nextExecutionLabel, CustomTimeUtil.getNextExecution2(param.getCronExpression(),  param.getTimezone(), sDate), false);

				break;

			default :

				break;

			}



		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" viewValuesAccordingToTemplate :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean validateHolidayCalendarField(String label, By field,String placeholder, String input, boolean state) {

		boolean flag=true;
		try {
			javascript(driver, scrollToElementArg, field);

			validateElement(driver, field, label, fieldContent);

			checkFieldIsEnabledOrNot(driver, label, dynamicHolidayCalenderStateField, dynamicStateElement, state);

			verifyPlaceHolderValue(driver, field, label, placeholder);

			verifyDefaultValue(driver, field, label, input, attributeValue);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateHolidayCalendarField :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateOverviewTabFields(SchedulerServiceParameters param, String icedqUser) {
		boolean flag=true;
		try {

			BaseSuite.reportLog(hyphenContent+ " verifying overview tab section "+hyphenContent);

			clickOnOverviewTab();

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			viewValues(scheduleNameContent, placeholderScheduleName, param.getScheduleName(), TRUE);

			viewValues(descriptionContent, placeholderDescription, param.getDescription(), TRUE);

			viewValues(typeContent, "", param.getType(), FALSE);

			viewValues(timezoneLabel, "", param.getTimezone(), FALSE);

			viewValues(holidayCalanderLabel, "", param.getUseHolidayCalender(), TRUE);

			if(Boolean.parseBoolean(param.getUseHolidayCalender())){
				validateHolidayCalendarField(holidayCalanderLabel, detailsPageHolidayCalendarField, placeholderSelectCalendar, param.getCalenderId(), true);
			}

			viewValuesAccordingToTemplate(param, param.getType(), param.getStartDate(), param.getEndDate());

			if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) { viewValues("RunAs", "", getUserFullName(icedqUser), FALSE);}

			BaseSuite.reportLog(hyphenContent+ " verified overview tab section "+hyphenContent);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateOverviewTabFields :: "+e.toString());
			flag = false;
		}
		return flag;

	}

	public boolean checkboxStatus(By locator, String label, boolean expectedState) {
		boolean flag=true;

		try {

			isDisplayedInLoop(driver, 0, locator);

			if(isDisplayed(driver, locator)) {

				BaseSuite.reportLog("validating "+label+" checkbox status");

				String actual = getAttribute(driver, locator, attributeClass);

				if(expectedState) {

					BaseSuite.reportLog("Expected checkbox status is checked");

					if(actual.contains("e-"+attrcheck)) {

						BaseSuite.validationReportLog(label+" checkbox is checked as expected");

					}else {

						BaseSuite.reportFailLog(label+" checkbox is unchecked kindly check", "checkboxStatus");
						flag=false;
					}
				}else {

					BaseSuite.reportLog("Expected checkbox status is unchecked");

					if(!actual.contains("e-"+attrcheck)) {

						BaseSuite.validationReportLog(label+" checkbox is unchecked as expected");

					}else {

						BaseSuite.reportFailLog(label+" checkbox is checked kindly check", "checkboxStatus");
						flag=false;
					}
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" checkboxStatus "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateElementWithAll(String type, By locator, String label, String input, String attribute) {
		boolean flag=true;

		try {

			javascript(driver, scrollToElementArg, locator);

			validateElement(driver, locator, label, type);

			if(type.trim().equalsIgnoreCase(checkboxContent)) {

				checkboxStatus(locator, label, Boolean.parseBoolean(input));

			}else {
				validateValueWithActual(driver, locator, label, input, attribute);

			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateElementWithAll :: "+e.toString());
			flag = false;

		}
		return flag;

	}

	public boolean checkcssOfElement(By locator, String label, String attribute, String expected) {
		boolean flag=true;

		try {
			BaseSuite.reportLog("checking css style of " + label);

			String color = driver.findElement(locator).getCssValue(attribute);
			String hex = Color.fromString(color).asHex();

			flag = expected.trim().equalsIgnoreCase("yes") ? 
					hex.equalsIgnoreCase("#0da96f") : 
						hex.equalsIgnoreCase("#f05050");

			if(flag) {

				BaseSuite.validationReportLog("Css style of "+label+ " is correctly visible as "+hex);
			}else {
				BaseSuite.reportFailLog("Css style of "+label+ " is not as expected, showing as "+hex, "checkcssOfElement");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" checkcssOfElement :: "+e.toString());
			flag = false;
		}

		return flag;

	}

	public boolean validateAddedJobInSchedule(String jobs) {
		boolean flag=true;
		try {

			if(jobs.isEmpty()) { return flag;}

			if(jobs.contains(",")) {

				String [] job = jobs.split(",");

				for(String j : job ) {

					DataTestingParameters param = setJobsParamUsingExcel(sCHEDULEEXCELFILEPATH, j);

					flag=searchFunctionalityMethod(driver, flag, detailsPageJobSearchBar, detailsPageJobSearchBtn, placeholderSearchJob, placeholderSearchJob, param.getWorkflowName());

					if(flag) {

						validateElementWithAll(checkboxContent, returnTwoElements(detailsPageJobDynamicCheckbox, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()), 
								jobContent+whiteSpace+checkboxContent , FALSE, attributeTextContent);
						validateElementWithAll(avatarContent, returnTwoElements(detailsPageJobDynamicAvatar, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()), 
								jobContent+whiteSpace+avatarContent, param.getWorkflowType(), attributeTitle);
						validateElementWithAll(hyperlinkContent, returnTwoElements(detailsPageJobDynamicJobName, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()),
								jobContent+whiteSpace+hyperlinkContent, param.getWorkflowName(), attributeTextContent);
						validateElementWithAll(labelContent, returnTwoElements(detailsPageJobDynamicActive, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()),
								jobContent+whiteSpace+stateContent, param.getWorkflowState(), attributeTextContent);

					/**	checkcssOfElement(returnTwoElements(detailsPageJobDynamicActive, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()), jobContent+whiteSpace+activeContent, "color", param.getWorkflowState());
 					*	due to DAT-7079
*/
						validateElementWithAll(labelContent, returnTwoElements(detailsPageJobDynamicFolder, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()),
								jobContent+whiteSpace+folderContent, param.getFolderName(), attributeTitle);
					}

				}

			}else {

				DataTestingParameters param = setJobsParamUsingExcel(sCHEDULEEXCELFILEPATH, jobs);

				flag=searchFunctionalityMethod(driver, flag, detailsPageJobSearchBar, detailsPageJobSearchBtn, placeholderSearchJob, placeholderSearchJob, param.getWorkflowName());

				if(flag) {

					validateElementWithAll(checkboxContent, returnTwoElements(detailsPageJobDynamicCheckbox, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()), 
							jobContent+whiteSpace+checkboxContent ,FALSE, attributeTextContent);
					validateElementWithAll(avatarContent, returnTwoElements(detailsPageJobDynamicAvatar, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()), 
							jobContent+whiteSpace+avatarContent, param.getWorkflowType(), attributeTitle);
					validateElementWithAll(hyperlinkContent, returnTwoElements(detailsPageJobDynamicJobName, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()),
							jobContent+whiteSpace+hyperlinkContent, param.getWorkflowName(), attributeTextContent);
					validateElementWithAll(labelContent, returnTwoElements(detailsPageJobDynamicActive, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()),
							jobContent+whiteSpace+stateContent, param.getWorkflowState(), attributeTextContent);

				/**	checkcssOfElement(returnTwoElements(detailsPageJobDynamicActive, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()), jobContent+whiteSpace+activeContent, "color", param.getWorkflowState());
				 * due to DAT-7079
*/
					validateElementWithAll(labelContent, returnTwoElements(detailsPageJobDynamicFolder, dynamicFolderName, param.getFolderName(), dynamicName, param.getWorkflowName()),
							jobContent+whiteSpace+folderContent, param.getFolderName(), attributeTitle);
				}

			}

			searchFunctionalityMethod(driver, flag, detailsPageJobSearchBar, detailsPageJobSearchBtn, placeholderSearchJob, placeholderSearchJob, "");


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateAddedJobInSchedule :: "+e.toString());
			flag = false;

		}
		return flag;
	}

	public boolean validateJobsTabFields(SchedulerServiceParameters param) {
		boolean flag=true;
		try {

			BaseSuite.reportLog(hyphenContent+ " verifying jobs tab section "+hyphenContent);

			clickOnJobsTab();

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			verifySearchField(driver, detailsPageJobSearchBar, placeholderSearchJob, placeholderSearchJob);

			validateElementWithAll(labelContent, detailsPageJobHashofJobs, hashOfJobsLabel, "# of Jobs: "+param.getJobCount(), attributeTextContent);

			validateElementWithAll(checkboxContent, detailsPageJobMasterCheckbox, masterContent, FALSE, attributeTextContent);

			validateElementWithAll(columnContent, detailsPageJobColumnJobName, "Job Name", "Job Name", attributeTextContent);

			validateElementWithAll(columnContent, detailsPageJobColumnActive, typeContent, typeContent, attributeTextContent);

			validateElementWithAll(columnContent, detailsPageJobColumnFolder, folderContent, folderContent, attributeTextContent);

			verifyVisibilityOfButtons(driver, detailsPageJobDeleteButton, deleteContent, false);

			validateAddedJobInSchedule(param.getJobs());

			viewJobDetailsPane(Integer.parseInt(param.getJobCount()));

			BaseSuite.reportLog(hyphenContent+ " verified jobs tab section "+hyphenContent);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateJobsTabFields :: "+e.toString());
			flag = false;
		}
		return flag;

	}

	public boolean viewScheduleFunctionality(SchedulerServiceParameters param,String scheduleName,  String icedqUser) {
		boolean flag=true;
		log.info(icedqUser);
		try {

			BaseSuite.reportLog(hyphenContent+" verifying breadcrumbs on schedule details page "+hyphenContent);

			validateValues(breadcrumbHome, homeContent,"", hyperlinkContent, attributeTextContent, false);
			validateValues(breadcrumbscheduler, schedulerContent, "", hyperlinkContent, attributeTextContent, false);
			validateValues(breadcrumbschedules, schedulesContent, "", hyperlinkContent, attributeTextContent, false);

			BaseSuite.reportLog(hyphenContent+" verifying title and avatar on schedule details page "+hyphenContent);

			validateValues(returnElement(detailsPageDynamicAvatar, dynamicName, scheduleName),param.getType()+whiteSpace+iconContent, param.getType(), attributeTitle,attributeTitle, true );
			validateValues(returnElement(detailsPageDynamicTitle, dynamicName, scheduleName),param.getType()+whiteSpace+attributeTitle, scheduleName, attributeTitle, attributeTextContent, true );

			validateButtons(driver, detailsPageButtonCount, 6);

			validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

			validateFolderSearchSideBar();

			validateWorkflowOnSchedulesDetailsPage();

			validateOverviewTabFields(param, icedqUser);

			validateJobsTabFields(param);

			validateRecentRunsOfSchedule(0);

		}catch (Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" viewScheduleFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateScheduleFunctionality(SchedulerServiceParameters param, String icedqUser, boolean validateOnMonitor) {
		boolean flag=true;
		String runTime="";
		String endTime="";
		int runAfterMinute = 3;
		try {

			runTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, param.getTemplete().equalsIgnoreCase(ONETIME) ? runAfterMinute : 30), param.getStartDate());

			endTime=param.getEndDate();

			updateOverviewDetails(param, param.getUpdateName(), param.getType(), runTime, endTime);

			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) {

				return clickOnSaveButtonAndValidateToast(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

			clickOnJobsTab();

			if(param.getRemoveJobs().isEmpty() ) { removeAllJobsFromJobSection(true); }else { removeSpecificJobFromSchedule(param.getRemoveJobs());}

			addJobsToSchedule(param.getJobs());

			flag=clickOnSaveButtonAndValidateToast("");

			validateAndActivateOrDisactivate1(Boolean.parseBoolean(param.getIsActive()));

			validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

			viewJobDetailsPane(Integer.parseInt(param.getJobCount()));

			if(!flag) { return false;}

			BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying overview tab details after updating schedule "+hyphenContent+hyphenContent);

			clickOnOverviewTab();

			viewValuesAccordingToTemplate(param, param.getTemplete(), runTime, endTime);

			flag=validateScheduleInstanceAfterRun(param.getTemplete(), runTime, runAfterMinute, param.getUpdateName(), param.getFolderName(), param.getStatus(), 0);

			if(param.getTemplete().equalsIgnoreCase(ONETIME)) { 

				String acTime = getValueOfField(recentRunsValueStarttime, startTimestampLabel);
				validateScheduleOnMonitor(validateOnMonitor, param.getUpdateName(), param.getFolderName(), param.getType(), acTime, getUserFullName(icedqUser), "Auto");
			}
			clickOnSchedulesTab();

			validateSchedulesOnListingPage(param, param.getUpdateName());


		}catch (Exception e) {

			BaseSuite.reportErrorLog(e,  errorLogTitle+" viewScheduleFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public String getAddedJobCount() {

		String count = "";

		isDisplayedInLoop(driver, 0, detailsPageJobHashofJobs);

		if(isDisplayed(driver, detailsPageJobHashofJobs)) {

			BaseSuite.reportLog("Checking # of jobs count.");

			count = getAttribute(driver, detailsPageJobHashofJobs, attributeTextContent);

			BaseSuite.reportLog(hashOfJobsLabel+whiteSpace+count);

			if (count == null || !count.contains(hashOfJobsLabel)) {
				return "0";
			}

			String[] parts = count.split(":");

			count = parts[1].trim();

		}

		return count;
	}

	public boolean clickOnDeleteJobAndHandlePopupWindow(int excount) {
		boolean flag=true;
		String title = "";
		String content = "";
		try {

			title = excount==1 ? popupTitleSingleJobDelete : popupTitleMultipleJobDelete;

			content = excount==1 ? popupContentSingleJobDelete : popupContentMultipleJobDelete;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, detailsPageJobDeleteButton, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, poupUpJobDeleteTitle, poupUpJobDeleteContent, title, content);

			verifyVisibilityOfButtons(driver, poupUpJobDeleteButtonCancel, cancelButtonContent, true);

			clickOnButton(driver, poupUpJobDeleteButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnDeleteJobAndHandlePopupWindow :: "+e.toString());
			flag=false;

		}

		return flag;
	}

	public boolean clickOnDeleteScheduleAndHandlePopupWindow(int excount, String toastMessage) {
		boolean flag=true;
		boolean tag=true;
		String title = "";
		String content = "";
		try {

			title = excount==1 ? popupTitleSingleScheduleDelete : popupTitleMultipleScheduleDelete;

			content = excount==1 ? popupContentSingleScheduleDelete : popupContentMultipleScheduleDelete;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, detailsPageButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popUpScheduleDeleteTitle, popUpScheduleDeleteContent, title, content);

			verifyVisibilityOfButtons(driver, popUpScheduleDeleteButtonCancel, cancelButtonContent, true);

			clickOnButton(driver, popUpScheduleDeleteButtonDelete, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMessage, "Delete Schedule");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !toastMessage.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, toastMessage,"Delete Schedule");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnDeleteScheduleAndHandlePopupWindow :: "+e.toString());
			flag=false;

		}

		return flag;
	}



	public boolean removeAllJobsFromJobSection(boolean wantToRemove) {
		boolean flag=true;

		try {

			isDisplayedInLoop(driver, 0, detailsPageJobDeleteButton);

			verifyVisibilityOfButtons(driver, detailsPageJobDeleteButton, deleteContent, false);

			String excount= getAddedJobCount().trim();

			if(!wantToRemove) {	return true; }

			BaseSuite.reportLog(hyphenContent+hyphenContent+" Removing all jobs from schedule "+hyphenContent+hyphenContent);

			if(isDisplayed(driver, detailsPageJobMasterCheckbox)) {

				selectcheckbox(driver, detailsPageJobMasterCheckbox, masterContent+whiteSpace+checkboxContent);

				clickOnDeleteJobAndHandlePopupWindow(Integer.parseInt(excount));

				excount= getAddedJobCount().trim();

				stringContainsOutput(excount, "0", true);

				if(Integer.parseInt(excount)==0) {

					validateElement(driver, detailsPageJobNoRecordsToDisplay, noRecordsToDisplayContent, labelContent);
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" removeAllJobsFromJobSection :: "+e.toString());
			flag=false;

		}

		return flag;
	}

	public boolean searchAndSelectJob(String folderPath, String workflowName) {

		boolean flag=true;

		try {

			flag=searchFunctionalityMethod(driver, flag, detailsPageJobSearchBar, detailsPageJobSearchBtn, placeholderSearchJob, placeholderSearchJob, workflowName);

			if(flag) {

				flag=selectcheckbox(driver, returnTwoElements(detailsPageJobDynamicCheckbox, dynamicFolderName, folderPath, dynamicName, workflowName), workflowName+whiteSpace+checkboxContent);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" selectJob :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean removeSpecificJobFromSchedule(String jobs) {

		String [] job = null;
		int count = 0;
		boolean flag=true;

		try {

			if(!jobs.isEmpty()) {

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Removing jobs from schedule "+hyphenContent+hyphenContent);

				if(jobs.contains(",")) {

					job = jobs.split(","); 

					for(int i=0;i<job.length;i++) {

						DataTestingParameters param = setJobsParamUsingExcel(sCHEDULEEXCELFILEPATH, job[i]);

						flag=searchAndSelectJob(param.getFolderName(), param.getWorkflowName());

						if(flag) {count++;}
					}

				}else {

					DataTestingParameters param = setJobsParamUsingExcel(sCHEDULEEXCELFILEPATH, jobs);

					flag=searchAndSelectJob(param.getFolderName(), param.getWorkflowName());

					if(flag) {count++;}
				}

				searchFunctionalityMethod(driver, true, detailsPageJobSearchBar, detailsPageJobSearchBtn, placeholderSearchJob, placeholderSearchJob, "");

				flag=clickOnDeleteJobAndHandlePopupWindow(count);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" removeSpecificJobFromSchedule :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void validateScheduleDetailsPageButton(boolean isActive, boolean save, boolean discard, boolean recentRun, boolean delete) {

		BaseSuite.reportLog(hyphenContent+hyphenContent+" verifying button state on schedule details page "+hyphenContent+hyphenContent);

		verifyVisibilityOfButtons(driver, detailsPageButtonRun, runLabel, isActive);
		verifyVisibilityOfButtons(driver, detailsPageButtonSave, saveContent, save);
		verifyVisibilityOfButtons(driver, detailsPageButtonDiscard, discardContent, discard);
		verifyVisibilityOfButtons(driver, detailsPageButtonRecentRuns, recentRunsContent, recentRun);
		verifyVisibilityOfButtons(driver, detailsPageButtonDelete, deleteContent, delete);

		// Choose between pauseLabel and resumeLabel based on isActive
		String actionLabel = isActive ? pauseLabel : resumeLabel;
		By actionButton = isActive ? detailsPageButtonPause : detailsPageButtonResume;

		verifyVisibilityOfButtons(driver, actionButton, actionLabel, true);

	}

	public boolean validateAndActivateOrDisactivate(boolean isActive) {

		// Choose between pauseLabel and resumeLabel based on isActive
		String actionLabel = !isActive ? pauseLabel : resumeLabel;
		By actionButton = !isActive ? detailsPageButtonPause : detailsPageButtonResume;
		isDisplayedInLoop(driver, 2, actionButton);
		return clickOnButton(driver, actionButton, actionLabel, true);
	}

	public boolean validateAndActivateOrDisactivate1(boolean isActive) {

		boolean flag=true;

		// Check which button is currently displayed
		boolean isPauseVisible = isDisplayed(driver, detailsPageButtonPause); 
		boolean isResumeVisible = isDisplayed(driver, detailsPageButtonResume); 

		if(isActive) {

			flag = isResumeVisible ? clickOnButton(driver, detailsPageButtonResume, pauseLabel, true) : flag;
		}else {
			flag = isPauseVisible  ? clickOnButton(driver, detailsPageButtonPause, resumeLabel, true) : flag;
		}

		return flag;
	}

	public boolean validateScheduleOnMonitor(boolean validateOnMonitor, String name, String folder, String stype, String lasttime, String userName, String ttype) {
		boolean flag=true;

		ScheduleMonitorServicePage sm = new ScheduleMonitorServicePage(driver);

		try {
			if(!validateOnMonitor) { return flag; }


			ArrayList<String> inputs = new ArrayList<>();

			inputs.add(stype);
			inputs.add(lasttime);
			inputs.add(userName);
			inputs.add(ttype);

			sm.clickOnScheduleMonitorTab();

			flag=sm.validateSchedulesOnMonitorListingPage(name, folder, inputs);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateScheduleOnMonitor :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public String[] refreshInLoop(String instanceid, String preinstanceid, String status) {

		String[] output= {"",""};
		for(int i=0;i<400; i++) {

			clickOnRefreshIconToGetStatus(100);

			instanceid = verifyInstanceID();

			if(instanceid.isEmpty() || instanceid.equalsIgnoreCase(preinstanceid)) {
				status=clickOnRefreshIconToGetStatus(400);
				instanceid = validateScheduleRecentRunInfo("");
				waitForTime(1);
			}else if(!instanceid.equalsIgnoreCase(preinstanceid)){

				break;
			}

		}
		output[0]=status;
		output[1]=instanceid;
		return output;
	}

	public boolean executeSchedule(SchedulerServiceParameters param, String scheduleName,  String icedqUser, boolean validateOnMonitor) {
		boolean flag=true;
		String instanceid ="";
		String status = "";

		try {

			if(icedqUser.contains(readerContent)) { return clickOnButtonAndValidateToast( detailsPageButtonRun, runLabel, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);}

			validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

			String runTime = CustomTimeUtil.getCurrentTime(RRTIMESTAMPFORMAT, param.getTimezone());

			if(Boolean.parseBoolean(param.getIsActive())) {

				clickOnButton(driver, detailsPageButtonRun, runLabel, Boolean.parseBoolean(param.getIsActive()));

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying recent runs section of schedule "+hyphenContent+hyphenContent);

				validateRecentRunsOfSchedule(0);

				String preinstanceid=verifyInstanceID();

				CustomTimeUtil.waitForExecution(RRTIMESTAMPFORMAT, runTime);

				String[] out= refreshInLoop(instanceid, preinstanceid, status);

				status = out[0];
				instanceid = out[1];

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if(!flag) {return false;}

				if(status.equalsIgnoreCase(scheduleStatusProcessing)) { return flag;}

				getScheduleInstanceTable();

				String acTime = getValueOfField(recentRunsValueStarttime, startTimestampLabel);

				flag=CustomTimeUtil.compareTimeStamp(runTime, acTime, RRTIMESTAMPFORMAT, RRTIMESTAMPFORMAT);

				validateScheduleJobsOnInstancesTab(recentRunsValueInstances, scheduleName, param.getFolderName());

				validateScheduleOnMonitor(validateOnMonitor, scheduleName, param.getFolderName(), param.getType(), acTime, getUserFullName(icedqUser), "Manual");



			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" executeSchedule :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean deleteScheduleFromDetailsPage(SchedulerServiceParameters param, String scheduleName, String icedqUser) {
		boolean flag=true;

		try {
			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) 
			{ 
				return clickOnButtonAndValidateToast( detailsPageButtonDelete, deleteContent, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

			clickOnDeleteScheduleAndHandlePopupWindow(1, toastMessageScheduleDeleted);

			clickOnRefreshOnScheduleListingPage();

			flag=validateScheduleOnListingPageAfterDeleting(param, scheduleName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" deleteScheduleFromDetailsPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean pauseOrResumeScheduleFromDetailsPage(SchedulerServiceParameters param, String icedqUser) {

		boolean flag=true;

		try {

			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) 
			{ 
				// Choose between pauseLabel and resumeLabel based on isActive
				/**	String actionLabel = !Boolean.parseBoolean(param.getIsActive()) ? pauseLabel : resumeLabel;
				By actionButton = !Boolean.parseBoolean(param.getIsActive()) ? detailsPageButtonPause : detailsPageButtonResume;
				 */	
				return clickOnButtonAndValidateToast( detailsPageButtonPause, pauseLabel, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

			if(param.getScenarioType().equalsIgnoreCase(resumeLabel)) {

				validateScheduleDetailsPageButton(false, false, false, true, true);

				validateAndActivateOrDisactivate(true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

				//need to add recent run table


			}else {

				validateScheduleDetailsPageButton(true, false, false, true, true);

				validateAndActivateOrDisactivate(false);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" pauseOrResumeScheduleFromDetailsPage :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateRefreshButtonFunctionalityOnScheduleScreen() {

		boolean flag = true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, BaseClassUtil.generateRandomString(5));

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> before = getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, scheduleMonitorContent+" listing ");

			flag=clickOnRefreshOnScheduleListingPage();

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
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateRefreshButtonFunctionalityOnScheduleScreen :: " + e.toString());
			return false;
		}

		return flag;
	}

	public boolean validateSearchFunctionalityOnScheduleListing(String searchName, boolean checkAll) {

		boolean flag = true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, searchName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> after = getPaginationDetails(driver,listingPaginationInfo, listingPaginationBar,listingNoRecordsToDisplay, schedulesContent+" listing");

			if(Integer.parseInt(after.get(1))==0) {
				return flag;
			}
			getSchedulesListingPageTable(after.get(1), checkAll,"");

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSearchFunctionalityOnScheduleListing :: " + e.toString());
			return false;
		}

		return flag;
	}

	public List<String> getSchedulesListingPageTable(String totalCount, boolean checkAll, String type) {

		List<String> list = new ArrayList<>();
		List<String> columnTextValues = new ArrayList<>();
		int total = Integer.parseInt(totalCount);

		int totalPages = (int) Math.ceil(total / 20.0);  // Calculate total number of pages

		for (int pn = 1; pn <= totalPages; pn++) {
			BaseSuite.reportLog("Checking records on page  : "+pn);

			// Fetch table contents
			List<String> columnData;
			if(!type.isEmpty()) {
				if (type.equalsIgnoreCase("Name")) {
					columnData = getElements(driver, listingPageStaticNameList).stream()
							.map(WebElement::getText)
							.collect(Collectors.toList());
				} else {
					columnData = getElements(driver, listingPageStaticLastUpdatedList).stream()
							.map(e -> e.getText().replaceFirst("^[^0-9]+", "").trim())
							.collect(Collectors.toList());
				}
				columnTextValues.addAll(columnData);
			}
			// Calculate the number of records to process on this page
			int size = driver.findElements(listingPageStaticCount).size();

			for (int i = 0; i < size; i++) {
				list = validateScheduleDetails(list, i);
			}
			if(!checkAll) { break;}
			// Click next page if not on the last page
			if (pn < totalPages) {
				displayAndClick(driver, listingPageNextPageArrow, nextPageContent); 
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		}

		getTableForSchedules(list);

		clickOnRefreshOnScheduleListingPage();

		return columnTextValues;
	}
	
	public List<String> validateScheduleDetails(List<String> list, int rowNum) {

		String num=Integer.toString(rowNum+1);

		String type = getValueUsingAttribute(driver, returnElement(listingStaticAvatar, dynamicName, num), attributeTitle);

		String name = getValueUsingAttribute(driver, returnElement(listingStaticName, dynamicName, num), attributeTextContent);

		String desc = getValueUsingAttribute(driver, returnElement(listingStaticDesc, dynamicName, num), attributeTextContent);

		String fold = getValueUsingAttribute(driver, returnElement(listingStaticFolder, dynamicName, num), attributeTitle);

		String jobs = getValueUsingAttribute(driver, returnElement(listingStaticJobsCount, dynamicName, num), attributeTextContent);

		String lupd = getValueUsingAttribute(driver, returnElement(listingStaticlastUpdate, dynamicName, num), attributeTextContent);

		lupd = lupd.contains(",") ? lupd.replace(",", " |") : lupd;

		list.add(num+","+type+","+name+","+desc+","+fold+","+jobs+","+lupd);

		return list;

	}

	public void getTableForSchedules(List<String> list) {

		try {

			if(!list.isEmpty()) {

				String [][] table = new String[list.size()+1][4];

				String[] header = { "No.", "Type", "Name", descriptionContent, folderContent, hashOfJobsLabel, lastUpdatedContent};

				table[0] = header;

				for (int i = 0; i < list.size(); i++) {

					String num = Integer.toString(i + 1);

					String type = list.get(i).split(",")[1];

					String name = list.get(i).split(",")[2];

					String desc = list.get(i).split(",")[3];

					String fold = list.get(i).split(",")[4];

					String jc = list.get(i).split(",")[5];

					String lu = list.get(i).split(",")[6];

					String[] data = { num, type, name, desc, fold, jc, lu};

					table[i + 1] = data;

				}

				BaseSuite.reportLog(createHtmlTable1(table,scheduleListingContent));

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "error observed while getTableForSchedules :: " + e.toString());
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

		case "schedules":

			clickOnButton(driver, breadcrumbschedules, schedulesContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateTitle(driver, schedulePageTitle, schedulesContent);

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

			clickOnSchedulesTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(errorLogTitle+" navigateToDataTestingTabs :: "+e.toString());
		}

	}

	public boolean validateNagivationOnSchedule(String folderName, String type, String scheduleNAme, String jobName, String icedqUser) {
		boolean flag = true;
		String jobn = "Workflow-R001-Sanity";
		try {


			clickOnBreadcrumbLinks("Home");

			new HomePage(driver).clickOnSchedulerTab();

			clickOnSchedulesTab();

			clickOnNewScheduleButton(icedqUser);

			addNewScheduleDetails(folderName, "Sche-navigation-check", type);

			clickOnBreadcrumbLinks(schedulesContent);

			clickOnNewScheduleButton(icedqUser);

			addNewScheduleDetails(folderName, "Sche-navigation-check", type);

			clickOnBreadcrumbLinks(schedulerContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, schedulesContent), returnElement(modulePageTitle, dynamicName,schedulesContent), schedulesContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, scheduleMonitorContent), returnElement(modulePageTitle, dynamicName, scheduleMonitorContent),
					scheduleMonitorContent, subModuleContent);

			navigateToDataTestingTabs(nextgenTabDashboardandReporting, breadcrumbDashboardAndReporting, "Dashboard and Reporting", moduleContent);

			navigateToDataTestingTabs(nextgenTabDataTesting,  returnElement(modulePageTitle, dynamicName, "Rules"), "Data Testing", moduleContent);

			navigateToDataTestingTabs(nextgenTabConnector, returnElement(modulePageTitle, dynamicName, connectionsContent), "Connectors", moduleContent);

			navigateToDataTestingTabs(nextgenTabAdmin, moduleUserPageTitle, "Administration", moduleContent);

			folderName=ParametersServicePage.folderPath(folderName);

			flag= searchScheduleNameAndClickOnLinkOnListingPage(scheduleNAme, folderName);

			if(!flag) { return false ;}

			clickOnJobsTab();

			navigateToDataTestingTabs(returnTwoElements(detailsPageJobDynamicJobName, dynamicFolderName, "/Sanity", dynamicName, jobName), returnElement(detailsPageJobTitle, dynamicName, jobName),
					jobName, jobContent+ " " +attributeTitle);
			
			flag= searchScheduleNameAndClickOnLinkOnListingPage(scheduleNAme, ParametersServicePage.folderPath(folderName));

			if(!flag) { return false ;}
			
			clickOnJobsTab();

			navigateToDataTestingTabs(returnTwoElements(detailsPageJobDynamicJobName, dynamicFolderName, "/Sanity", dynamicName, jobn), returnElement(detailsPageJobTitle, dynamicName, jobn),
					jobn, jobContent+ " " +attributeTitle);

			flag= searchScheduleNameAndClickOnLinkOnListingPage(scheduleNAme, ParametersServicePage.folderPath(folderName));

			if(!flag) { return false ;}

			navigateToDataTestingTabs(recentRunsValueInstances, returnElement(detailsPageDynamicTitle, dynamicName, instancesContent), instancesContent, tabContent);


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateNagivationOnSchedule :: " + e.toString());
			return false;
		}

		return flag;
	}

	public boolean sortListByColumn(String type, String order, int totalRecords) {
		boolean isSorted = true;

		try {
			By locator = type.contains("Name") ? listingColumnName : listingColumnLastUpdated;
			boolean isAscending = order.equalsIgnoreCase("ascending");

			BaseSuite.reportLog("Verifying schedules after sorting by " + type + " in " + order + " order");

			// Perform sort click
			displayAndClick(driver, locator, type + columnContent);

			if (!isAscending) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				displayAndClick(driver, locator, type + columnContent);  // Click again for descending
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> columnData=getSchedulesListingPageTable(Integer.toString(totalRecords), true, type);

			// Validate sorting
			isSorted = type.equalsIgnoreCase("Name")
					? DataIntegrityUtils.isSorted(columnData, isAscending)
							: DataIntegrityUtils.isDateSorted(columnData, RRTIMESTAMPFORMAT, isAscending);

			BaseSuite.reportLog("Verifying sorting functionality worked or not on "+ type + " column");
			if (isSorted) {
				BaseSuite.validationReportLog("Sorting functionality working properly on " + type + " column.");
			} else {
				BaseSuite.reportFailLog("Sorting functionality not working on " + type + " column.", "sortListByColumn");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " sortListByColumn :: " + e.toString());
			return false;
		}

		return isSorted;
	}


	public boolean validateSortingFunctionalityOnSchedule(String type , String order) {
		boolean isSortedCorrectly = true;

		try {
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Verifying existing schedules displayed on listing page : 1 before sorting");

			List<String> paginationInfo = getPaginationDetails(driver, listingPaginationInfo, listingPaginationBar, listingNoRecordsToDisplay, schedulesContent + listingContent);

			int totalRecords = Integer.parseInt(paginationInfo.get(1));
			if (totalRecords == 0) {
				return true;
			}

			getSchedulesListingPageTable(Integer.toString(totalRecords), true, type);

			isSortedCorrectly = sortListByColumn(type, order, totalRecords);

			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSortingFunctionalityOnSchedule :: " + e.toString());
			return false;
		}

		return isSortedCorrectly;
	}

	public boolean deleteScheduleFromListingPage(int count,  String icedqUser) {
		boolean flag=true;

		try {

			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) 
			{ 
				return clickOnButtonAndValidateToast( detailsPageButtonDelete, deleteContent, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

			clickOnDeleteScheduleAndHandlePopupWindow(count);

			clickOnRefreshOnScheduleListingPage();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" deleteScheduleFromDetailsPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteScheduleAndHandlePopupWindow(int excount) {
		boolean flag=true;
		boolean tag=true;
		String title = "";
		String content = "";
		try {

			title = excount==1 ? popupTitleSingleScheduleDelete : popupTitleMultipleScheduleDelete;

			content = excount==1 ? popupContentSingleScheduleDelete : popupContentMultipleScheduleDelete;

			String toastMessage = excount==1 ? toastMessageScheduleDeleted : toastMessageSchedulesDeleted;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, listingButtonDelete, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popUpScheduleDeleteTitle, popUpScheduleDeleteContent, title, content);

			verifyVisibilityOfButtons(driver, popUpScheduleDeleteButtonCancel, cancelButtonContent, true);

			clickOnButton(driver, popUpScheduleDeleteButtonDelete, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMessage, "Delete Schedule ");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !toastMessage.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, toastMessage,"Delete Schedule ");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnDeleteScheduleAndHandlePopupWindow :: "+e.toString());
			flag=false;

		}

		return flag;
	}

	public boolean searchAndSelectAndDeleteSchedulesOnListingPage(SchedulerServiceParameters xparam, String icedqUser) {

		boolean flag=true;
		String[] iceuserName=null;
		int numberOfSchedules=1;
		try {
			if(xparam.getScheduleName().contains(",")) {

				iceuserName= xparam.getScheduleName().split(","); 

				numberOfSchedules = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setScheduleSearchParamUsingExcel(sCHEDULEEXCELFILEPATH, iceuserName[i], "");

					searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, param.getFullName());

					By locator = returnTwoElements(listingScheduleCheckboxDynamicLink, dynamicFolderName, param.getFolderName(), dynamicName, param.getFullName());

					searchScheduleNameOnEachPage(locator, param.getFullName());

					selectcheckbox(driver, locator, param.getFullName()+" "+checkboxContent);

					searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, "");

				}

			}else {

				numberOfSchedules = 1;

				DataTestingParameters param = setScheduleSearchParamUsingExcel(sCHEDULEEXCELFILEPATH, xparam.getScheduleName(), "");

				searchFunctionalityMethod(driver, flag, listingSearchbar, listingSearchButton, placeholderSearchSchedule, placeholderSearchSchedule, param.getFullName());

				By locator = returnTwoElements(listingScheduleCheckboxDynamicLink, dynamicFolderName, param.getFolderName(), dynamicName, param.getFullName());

				searchScheduleNameOnEachPage(locator, param.getFullName());

				selectcheckbox(driver, locator, param.getFullName()+" "+checkboxContent);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=deleteScheduleFromListingPage(numberOfSchedules, icedqUser);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchAndSelectAndDeleteSchedulesOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean verifyAndCreatePreRequisiteData(String filePath, String sheetName, String icedqUser, String datapre) {
		XLUtils xl = new XLUtils();
		List<String> list = new ArrayList<>();

		int rowNumber =0;
		boolean state = false;
		boolean flag = true;

		try {
						
			int rowCount = BaseSuite.getCount(xl, filePath, sheetName, "3");

			for (int rowNum = 4; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				SchedulerServiceParameters param = 	SchedulesServicePage.setSchedulerServiceParamUsingExcel(filePath, sheetName, rowNumber, true, datapre);

				if(param.getExecutionstate().trim().equalsIgnoreCase("yes")) {

					BaseSuite.reportLog("=================== Test Scenario :"+rowNumber+" : "+param.getTestScenarioName()+" =========================");

					clickOnSchedulesTab();

					state=searchScheduleNameOnListingPage(param.getScheduleName(), param.getFolderName());

					if(!state) {

						flag = createScheduleFunctionality(param, icedqUser, false);

						String tsstatus=BaseSuite.getTestResult(flag);

						list.add(param.getTestScenarioName()+","+tsstatus);
					}else {
						list.add(param.getTestScenarioName()+","+"Already exist");
					}
				}
			}

			getTableForTestScenario(driver, list);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" verifyAndCreatePreRequisiteData :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean verifyAddNewSchedulePaneWithInvalidData(SchedulerServiceParameters param, String icedqUser) {
		boolean flag = true;

		try {

			flag=clickOnNewScheduleButton(icedqUser);

			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) {
				return flag;
			}

			validateAddNewScheduleSidebar();

			selectFolderOnAddNewSchedule(param.getFolderName());

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=enterValueToFieldForInvalidDetails(driver, addnewScheNameField, addnewScheNameValidation, scheduleNameContent, param.getScheduleName(), param.getFieldValidation());

			checkChooseTemplateIsEnabledOrNot(ONETIME, false);

			checkChooseTemplateIsEnabledOrNot(DAILY, false);

			checkChooseTemplateIsEnabledOrNot(WEEKLY, false);

			checkChooseTemplateIsEnabledOrNot(ADVANCED, false);

			clickOnButton(driver, addnewScheCancelButton, cancelButtonContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" verifyAddNewSchedulePaneWithInvalidData :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean verifyToCreateScheduleWithInvalidData(SchedulerServiceParameters param, String icedqUser) {
		boolean flag = true;

		try {

			flag=clickOnNewScheduleButton(icedqUser);

			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) {
				return flag;
			}

			validateAddNewScheduleSidebar();

			addNewScheduleDetails(param.getFolderName(), "", param.getTemplete());

			clickOnOverviewTab();


			switch(param.getType()) {

			case "s-name":

				flag=enterValueToFieldForInvalidDetails(driver, returnElement(detailsPageDynamicField, dynamicName, scheduleNameContent), 
						returnElement(detailsPageDynamicValidation, dynamicName, scheduleNameContent), scheduleNameContent, param.getScheduleName(), param.getFieldValidation());

				break;
			case "s-description":

				flag=enterValueToFieldForInvalidDetails(driver, detailsPageDescriptionField, 
						detailsPageDescriptionValidation, descriptionContent, param.getDescription(), param.getFieldValidation());

				break;
			case "s-cronexpression":

				String crunTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 30), param.getStartDate());

				enterValuesAccordingToTemplate(param, param.getTemplete(), crunTime, "", true);

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				clickOnOverviewTab();

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;

			case "s-startdate":

				String sdate=getExpectedInput(param.getStartDate(), CustomTimeUtil.getPastTime(stimeStampFormat, 30), param.getStartDate());

				enterValuesAccordingToTemplate(param, param.getTemplete(), sdate, "", false);

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				clickOnOverviewTab();

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;

			case "s-enddate":

				String edate=getExpectedInput(param.getEndDate(), CustomTimeUtil.getPastTime(stimeStampFormat, 30), param.getEndDate());

				enterValuesAccordingToTemplate(param, param.getTemplete(), "", edate, false);

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				clickOnOverviewTab();

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;
			case "s-startenddate":

				String runTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 30), param.getStartDate());

				enterValuesAccordingToTemplate(param, param.getTemplete(), runTime, runTime, false);

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				clickOnOverviewTab();

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;
			case "s-exist":

				enterValues(scheduleNameContent, placeholderScheduleName, param.getScheduleName(), fieldValidationEmptyName, TRUE);

				String srunTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 30), param.getStartDate());

				enterValuesAccordingToTemplate(param, param.getTemplete(), srunTime, "", false);

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				clickOnOverviewTab();

				flag=clickOnSaveButtonAndValidateToast("Schedule name '"+param.getScheduleName()+"' already exists.");

				break;
			default:
				break;
			}



		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" verifyToCreateScheduleWithInvalidData :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean verifyToUpdateScheduleWithInvalidData(SchedulerServiceParameters param, String icedqUser) {
		boolean flag = true;

		try {

			if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) {

				enterValueToFieldForInvalidDetails(driver, returnElement(detailsPageDynamicField, dynamicName, scheduleNameContent), 
						returnElement(detailsPageDynamicValidation, dynamicName, scheduleNameContent), scheduleNameContent, param.getScheduleName(), param.getFieldValidation());

				return clickOnSaveButtonAndValidateToast(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

			clickOnOverviewTab();

			String type = param.getTemplete().contains(ADVANCED) ? advanceString : param.getTemplete();

			switch(param.getType()) {

			case "s-name":

				flag=enterValueToFieldForInvalidDetails(driver, returnElement(detailsPageDynamicField, dynamicName, scheduleNameContent), 
						returnElement(detailsPageDynamicValidation, dynamicName, scheduleNameContent), scheduleNameContent, param.getScheduleName(), param.getFieldValidation());

				break;
			case "s-description":

				flag=enterValueToFieldForInvalidDetails(driver, detailsPageDescriptionField, 
						detailsPageDescriptionValidation, descriptionContent, param.getDescription(), param.getFieldValidation());

				break;
			case "s-cronexpression":

				updateOverviewDetailsForInvalid(param, param.getScheduleName(),type, "", "");

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;

			case "s-startdate":

				String sdate=getExpectedInput(param.getStartDate(), CustomTimeUtil.getPastTime(stimeStampFormat, 30), param.getStartDate());

				updateOverviewDetailsForInvalid(param, param.getScheduleName(),type, sdate, "");

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;

			case "s-enddate":

				String edate=getExpectedInput(param.getStartDate(), CustomTimeUtil.getPastTime(stimeStampFormat, 30), param.getStartDate());

				updateOverviewDetailsForInvalid(param, param.getScheduleName(),type, "", edate);

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;
			case "s-startenddate":

				String runTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 30), param.getStartDate());

				updateOverviewDetailsForInvalid(param, param.getScheduleName(),type, runTime, runTime);

				flag=clickOnSaveButtonAndValidateToast(param.getToastValidation());

				break;

			case "s-exist":

				String xrunTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 30), param.getStartDate());

				updateOverviewDetailsForInvalid(param, param.getScheduleName(),type, xrunTime, "");

				flag=clickOnSaveButtonAndValidateToast("Schedule name '"+param.getScheduleName()+"' already exists.");

				break;

			default:
				break;
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" verifyToUpdateScheduleWithInvalidData :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	//

	public String verifyTextVisibleOrNot(String text, boolean expected) {

		text=checkNullValue(text);

		if(expected && text.isEmpty()) {
			BaseSuite.reportFailLog("Field text not visible "+text, "verifyTextVisibleOrNot");
		}
		return text;
	}

	public List<String> validateWorkflowDetails(List<String> list, int rowNum) {

		try {
			String num=Integer.toString(rowNum+1);

			String checkbox = getAttribute(driver, returnElement(workflowlistingStaticCheckbox, dynamicName, num), attributeClass);

			String type = verifyTextVisibleOrNot(getAttribute(driver, returnElement(workflowlistingStaticAvatar, dynamicName, num), attributeTitle), true);

			String name = verifyTextVisibleOrNot(getAttribute(driver, returnElement(workflowlistingStaticName, dynamicName, num), attributeTextContent), true);

			String fold = verifyTextVisibleOrNot(getAttribute(driver, returnElement(workflowlistingStaticFolder, dynamicName, num), attributeTitle), true);

			checkbox = checkbox.contains(checkContent) ? checkContent : "Uncheck";

			verifyTextVisibleOrNot(checkbox, true);

			list.add(num+","+checkbox+","+type+","+name+","+fold);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateWorkflowDetails :: "+e.toString());
		}

		return list;

	}

	public void getTableForWorkflows(List<String> list) {

		try {

			if(!list.isEmpty()) {

				String [][] table = new String[list.size()+1][4];

				String[] header = { "No.", "Checkbox state", "Type", "Name", folderContent};

				table[0] = header;

				for (int i = 0; i < list.size(); i++) {

					String num = Integer.toString(i + 1);

					String checkbox = list.get(i).split(",")[1];

					String type = list.get(i).split(",")[2];

					String name = list.get(i).split(",")[3];

					String fold = list.get(i).split(",")[4];

					String[] data = { num, checkbox, type, name, fold};

					table[i + 1] = data;

				}

				BaseSuite.reportLog(createHtmlTable1(table,"Workflow Sidebar Pane Details"));

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getTableForWorkflows :: " + e.toString());
		}
	}

	public boolean getWorkflowPaneTable(int totalCount, int tillPage) {
		boolean flag = true;

		try {

			int totalPages = (int) Math.ceil(totalCount / 20.0);  // Calculate total number of pages

			for (int pn = 1; pn <= totalPages; pn++) {

				List<String> list = new ArrayList<>();

				BaseSuite.reportLog("Checking records on page : "+pn);

				// Calculate the number of records to process on this page
				int size = driver.findElements(workflowSidebarNameCount).size();

				BaseSuite.reportLog("# of records on page : "+pn+ " is : "+size);

				if(pn != totalPages && size!=20) {
					flag=false;
					BaseSuite.reportFailLog("Actual record count not equal to 20 : "+size, "getWorkflowPaneTable");
				}

				for (int i = 0; i < size; i++) {
					list = validateWorkflowDetails(list, i);
				}

				getTableForWorkflows(list);

				if(pn==tillPage) { break;}
				// Click next page if not on the last page
				if (pn < totalPages) {
					displayAndClick(driver, workflowSidebarPanelNextPageArrow, nextPageContent); 
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
				getPaginationDetails(driver, workflowSidebarPaginationInfo, workflowSidebarPaginationBar, workflowSidebarNoRecordsTodisplay, "Workflow side panel ");
			}

			displayAndClick(driver, workflowSidebarPanelFirstPageArrow, "first page");
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getWorkflowPaneTable :: " + e.toString());
			flag=false;
		} 
		return flag;

	}

	public boolean validateWorkflowPaneOfScheduleDetailsPage() {
		try {
			List<String> paginationInfo = validateWorkflowOnSchedulesDetailsPage();

			if (paginationInfo == null || paginationInfo.size() < 4) {
				BaseSuite.reportErrorLog(null, "Invalid pagination info received.");
				return false;
			}

			int totalRecords = Integer.parseInt(paginationInfo.get(1));
			int totalPages = Integer.parseInt(paginationInfo.get(3));

			if (totalRecords == 0) {
				return true;
			}

			return getWorkflowPaneTable(totalRecords, Math.min(totalPages, 5));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validating workflow pane of schedule details page: " + e.toString());
			return false;
		}
	}

	public boolean validateScheduleJobsOnInstancesTab(By locator, String scheduleName, String folderName) {

		InstancesServicePage ip = new InstancesServicePage(driver);

		try {
			clickOnButton(driver, locator, "view", true);

			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			ip.validateInstancesOnListingPage();

			clickOnButton(driver, nextgenTabScheduler, schedulerContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnSchedulesTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchScheduleNameAndClickOnLinkOnListingPage(scheduleName, folderName);

			return true;
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateScheduleJobsOnInstancesTab :: " + e.toString());
			return false;
		}	
	}

	public List<String> validateJobsDetails(List<String> list, int rowNum) {

		try {
			String num=Integer.toString(rowNum+1);

			String checkbox = getAttribute(driver, returnElement(detailsPageJobStaticCheckbox, dynamicName, num), attributeClass);

			String type = verifyTextVisibleOrNot(getAttribute(driver, returnElement(detailsPageJobStaticAvatar, dynamicName, num), attributeTitle), true);

			String name = verifyTextVisibleOrNot(getAttribute(driver, returnElement(detailsPageJobStaticJobName, dynamicName, num), attributeTextContent), true);

			String active = verifyTextVisibleOrNot(getAttribute(driver, returnElement(detailsPageJobStaticActive, dynamicName, num), attributeTextContent), true);

			String fold = verifyTextVisibleOrNot(getAttribute(driver, returnElement(detailsPageJobStaticFolder, dynamicName, num), attributeTitle), true);

			checkbox = checkbox.contains(uncheckContent) ?  uncheckContent: checkContent;

			verifyTextVisibleOrNot(checkbox, true);

			list.add(num+","+checkbox+","+type+","+name+","+active+","+fold);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateJobsDetails :: "+e.toString());
		}

		return list;

	}

	public void getTableForJobDetails(List<String> list) {

		try {

			if(!list.isEmpty()) {

				String [][] table = new String[list.size()+1][4];

				String[] header = { "No.", "Checkbox state", "Icon", "Name", "Type", folderContent};

				table[0] = header;

				for (int i = 0; i < list.size(); i++) {

					String num = Integer.toString(i + 1);

					String checkbox = list.get(i).split(",")[1];

					String type = list.get(i).split(",")[2];

					String name = list.get(i).split(",")[3];

					String act = list.get(i).split(",")[4];

					String fold = list.get(i).split(",")[5];

					String[] data = { num, checkbox, type, name,act, fold};

					table[i + 1] = data;

				}

				BaseSuite.reportLog(createHtmlTable1(table,"Schedule jobs Details"));

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getTableForJobDetails :: " + e.toString());
		}
	}

	public void viewJobDetailsPane(int size) {

		try {
			List<String> list = new ArrayList<>();

			clickOnJobsTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			// Calculate the number of records to process on this page
			int acsize = driver.findElements(detailsPageStaticJobCount).size();

			compareValues(acsize, size, "job count");

			for (int i = 0; i < size; i++) {
				list = validateJobsDetails(list, i);
			}

			getTableForJobDetails(list);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewJobDetailsPane :: " + e.toString());
		}
	}


	//CREATE
	public boolean createAndUpdateScheduleFunctionality(SchedulerServiceParameters param, String icedqUser) {
		String runTime="";
		String endTime="";
		boolean flag=true;
		try {

			flag = clickOnNewScheduleButton(icedqUser);

			if(flag && (icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent))) {

				validateAddNewScheduleSidebar();

				addNewScheduleDetails(param.getFolderName(), param.getScheduleName(), param.getTemplete());

				clickOnOverviewTab();

				runTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 1, 0, 30), param.getStartDate());

				endTime=getExpectedInput(param.getEndDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 7, 0, 30), param.getEndDate());

				enterOverviewDetails(param, param.getScheduleName(), runTime, "");

				clickOnJobsTab();

				addJobsToSchedule(param.getJobs());

				flag=clickOnSaveButtonAndValidateToast(toastMessageScheduleCreated);

				if(!flag) { return false;}

				validateAndActivateOrDisactivate1(Boolean.parseBoolean(param.getIsActive()));

				validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

				viewJobDetailsPane(Integer.parseInt(param.getJobCount()));			

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying overview tab details after creating new schedule "+hyphenContent+hyphenContent);

				clickOnOverviewTab();

				viewValuesAccordingToTemplate(param, param.getTemplete(), runTime, endTime);

				validateRecentRunsOfSchedule(0);

				List<String> pageinfo = getPaginationDetails(driver, recentRunsPaginationInfo, recentRunsPaginationBar, recentRunsNoRecordsTodisplay, recentRunsContent+" Details ");

				compareValues(0, Integer.parseInt(pageinfo.get(1)), recentRunsContent+" count ");

				clickOnSchedulesTab();

				flag=searchScheduleNameAndClickOnLinkOnListingPage(param.getScheduleName(), param.getFolderName());

				if(!flag) { return false;}

				SchedulerServiceParameters upparam = setSchedulerServiceParamUsingExcel();

				updateValuesAccordingToTemplate(upparam, param.getType(), param.getType().equalsIgnoreCase(ONETIME) ? runTime : "", endTime, false);

				if(icedqUser.contains(readerContent) || icedqUser.contains(executorContent)) {

					return clickOnSaveButtonAndValidateToast(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				}

				flag=clickOnSaveButtonAndValidateToast("");

				validateAndActivateOrDisactivate1(Boolean.parseBoolean(param.getIsActive()));

				validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

				viewJobDetailsPane(Integer.parseInt(param.getJobCount()));

				if(!flag) { return false;}

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying overview tab details after updating schedule "+hyphenContent+hyphenContent);

				validateRecentRunsOfSchedule(0);

				List<String> upageinfo = getPaginationDetails(driver, recentRunsPaginationInfo, recentRunsPaginationBar, recentRunsNoRecordsTodisplay, recentRunsContent+" Details");

				compareValues(0, Integer.parseInt(upageinfo.get(1)), recentRunsContent+" count");

				clickOnSchedulesTab();

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" createScheduleFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	public boolean addAllJobs() {

		List<String> pageinfo =getPaginationDetails(driver, workflowSidebarPaginationInfo, workflowSidebarPaginationBar, workflowSidebarNoRecordsTodisplay, "Workflow side panel ");

		int total = Integer.parseInt(pageinfo.get(1));

		if(total==0) { return false;}

		int size =0;
		for(int x=0;x<2;x++) {

			size = size + driver.findElements(workflowSidebarNameCount).size();

			isDisplayedInLoop(driver, 0, detailsPageJobMasterCheckbox);

			selectcheckbox(driver, detailsPageJobMasterCheckbox, "Workflow jobs");

			clickOnAddWorkflowsButton(true);

			displayAndClick(driver, workflowSidebarPanelNextPageArrow, nextPageContent); 
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}

		clickOnWorkflowSidebarPanelOpenOrClose(false);

		return true;
	}

	public boolean createAndViewScheduleFunctionality(SchedulerServiceParameters param, String icedqUser) {
		String runTime="";
		String endTime="";
		boolean flag=true;
		try {

			flag = clickOnNewScheduleButton(icedqUser);

			if(flag && (icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent))) {

				validateAddNewScheduleSidebar();

				addNewScheduleDetails(param.getFolderName(), param.getScheduleName(), param.getTemplete());

				clickOnOverviewTab();

				runTime=getExpectedInput(param.getStartDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 1, 0, 30), param.getStartDate());

				endTime=getExpectedInput(param.getEndDate(), CustomTimeUtil.getFutureTime(stimeStampFormat, 7, 0, 30), param.getEndDate());

				enterOverviewDetails(param, param.getScheduleName(), runTime, "");

				clickOnJobsTab();

				flag=clickOnSaveButtonAndValidateToast(toastMessageScheduleCreated);

				if(!flag) { return false;}

				validateAndActivateOrDisactivate1(Boolean.parseBoolean(param.getIsActive()));

				validateScheduleDetailsPageButton(Boolean.parseBoolean(param.getIsActive()), false, false, true, true);

				viewJobDetailsPane(Integer.parseInt(param.getJobCount()));			

				BaseSuite.reportLog(hyphenContent+hyphenContent+" Verifying overview tab details after creating new schedule "+hyphenContent+hyphenContent);

				clickOnOverviewTab();

				viewValuesAccordingToTemplate(param, param.getTemplete(), runTime, endTime);

				validateRecentRunsOfSchedule(0);

				List<String> pageinfo = getPaginationDetails(driver, recentRunsPaginationInfo, recentRunsPaginationBar, recentRunsNoRecordsTodisplay, recentRunsContent+" Details");

				compareValues(0, Integer.parseInt(pageinfo.get(1)), recentRunsContent+" count");

				clickOnSchedulesTab();

				flag=searchScheduleNameAndClickOnLinkOnListingPage(param.getScheduleName(), param.getFolderName());

				if(!flag) { return false;}


			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" createAndViewScheduleFunctionality :: "+e.toString());
			flag=false;
		}
		return flag;

	}

	//----------------------------------

	By advancedSearchTitle=getElementLocator(prop.getProperty("workflow.AdvancedSearch.title"));
	By advancedSearchExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.expand"));
	By advancedSearchCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.collapse"));
	By parameteApplied=getElementLocator(prop.getProperty("schedules.applied.filter"));
	By parametersAppliedFilterCross=getElementLocator(prop.getProperty("schedules.applied.filter.cross.icon"));
	By advancedSearchUpdatedByLabel=getElementLocator(prop.getProperty("schedules.advancedSearch.TriggeredBy.lable"));
	By advancedSearchUpdatedByExpand=getElementLocator(prop.getProperty("schedules.advancedSearch.TriggeredBy.expandButton"));
	By advancedSearchUpdatedByCollapse=getElementLocator(prop.getProperty("schedules.advancedSearch.TriggeredBy.collapseButton"));
	By advancedSearchUpdatedByList=getElementLocator(prop.getProperty("schedules.advancedSearch.TriggeredBy.list"));
	By advancedSearchUpdatedBySearchBar=getElementLocator(prop.getProperty("schedules.advancedSearch.TriggeredBy.searchbar"));
	By advancedSearchLastUpdatedLabel=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.lable"));
	By advancedSearchLastUpdatedExpand=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.expandButton"));
	By advancedSearchLastUpdatedCollapse=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.collapseButton"));
	By advancedSearchLastUpdatedFrom=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.fromField"));
	By advancedSearchLastUpdatedFromDateIcon=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.fromField.dateicon"));
	By advancedSearchLastUpdatedTo=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.toField"));
	By advancedSearchLastUpdatedToDateIcon=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.toField.dateicon"));
	By advancedSearchLastUpdatedCalanderDatePopup=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.datePopup"));
	By advancedSearchLastUpdatedCalanderCurrentValue=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.currentYearMon"));
	By advancedSearchLastUpdatedCalanderPreviousBtn=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.previousMonBtn"));
	By advancedSearchLastUpdatedCalanderNextBtn=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.nextMonBtn"));
	By advancedSearchLastUpdatedCalanderTodayBtn=getElementLocator(prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.todayBtn"));

	By advancedSearchTypeLabel=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.lable"));
	By advancedSearchTypeExpand=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.expandButton"));
	By advancedSearchTypeCollapse=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.collapseButton"));
	By advancedSearchTypeList=getElementLocator(prop.getProperty("monitor.advancedSearch.Type.list"));

	String placeholderSearchUser=prop.getProperty("parameters.placeholder.search.user");

	String advanceSearchUpdatedByCheckbox=prop.getProperty("schedules.advancedSearch.TriggeredBy.checkbox");
	String advanceSearchLastUpdatedCalanderSelectMon=prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.selectMonYear");
	String advanceSearchLastUpdatedCalanderSelectDate=prop.getProperty("schedules.advancedSearch.LastTriggeredTime.calander.selectdate");
	String updatedbynameOnListing=prop.getProperty("parameters.listingpage.updatedbyname");
	String advanceSearchTypeCheckbox=prop.getProperty("monitor.advancedSearch.Type.checkbox");
	String advanceInstanceTypeChip=prop.getProperty("monitor.advancedSearch.InstanceType.dynamicchip");
	String advanceInstanceTypeChipState=prop.getProperty("monitor.advancedSearch.InstanceType.dynamicchip.state");


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
				
				acs = checkNullValue(acs);
				
				if(!acs.contains(checkContent) || acs.contains(uncheckContent)) {

					BaseSuite.reportLog(" Clicking on checkbox "+label);

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
				
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

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

			verifyIndividualLabel(driver, advancedSearchLastUpdatedLabel, lastUpdatedContent);

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

		if(isActive.contains(eActiveContent)) {

			BaseSuite.reportLog(label+" is Active/Selected");
			return true;
		}else {

			BaseSuite.reportLog(label+" is not Active/Selected");
			return false;
		}

	}

	public boolean advanceSearchFunctionalityOnSchedulesListingPage(boolean clearAll, String advanceSearchRef) {

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

				DataTestingParameters param = SchedulesServicePage.setAdvanceSearchParamUsingExcel(sCHEDULEEXCELFILEPATH, rf);

				validateNSelectTypeInAdvanceSearch(param.getType(), true);

				validateNSelectUpdatedByUserInAdvanceSearch(param.getFullName(), param.getFullName(), true);

				validateNSelectLastUpdatedInAdvanceSearch(param.getLastUpdatedFrom(), param.getLastUpdatedTo());

				count++; // increment counter
			}

			getSchedulesListingPageTable(false);

			BaseSuite.reportLog(hyphenContent + " Applied advance search filter " + hyphenContent);
			
			

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " advanceSearchFunctionalityOnSchedulesListingPage :: " + e.toString());
			return false;
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

			List<String> types = Arrays.asList("One Time", DAILY, WEEKLY, advanceString);

			for (String type : types) {

				removeAppliedFilterofParameter();

				validateNSelectTypeInAdvanceSearch(type, true);

				validateListOfRecordsAsPerType(listingPageallAvatar, "Schedule type", type, attributeTitle);


			}

			removeAppliedFilterofParameter();

			validateNSelectUpdatedByUserInAdvanceSearch("account_owner", "Account Owner", true);

			validateListOfRecordsAsPerType(listingPageallUpdatedBy, "Updated by", "Account Owner", attributeTitle);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" advanceSearchValidateForAllTypes :: "+e.toString());
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

				acstr = acstr.equalsIgnoreCase(ONETIME) ? "One Time" : acstr ;

				compareValues(input, acstr, label);
			}

			getSchedulesListingPageTable(false);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" validateListOfRecordsAsPerType :: "+e.toString());
			flag=false;
		}

		return flag;	
	}


	public void validateUnexpectedToast(String method) {

		if(isDisplayed(driver, toastMsg)) {
			BaseSuite.reportFailLog("Unexpected toast message appeared", method);
		}
	}

	public boolean getSchedulesListingPageTable(boolean checkAll) {
		boolean flag=true;

		try {
			List<String> list = new ArrayList<>();

			List<String> paginationInfo = getPaginationDetails(driver, listingPaginationInfo, listingPaginationBar, listingNoRecordsToDisplay, scheduleListingContent);

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

					validateUnexpectedToast("getSchedulesListingPageTable");
				}
			}

			getTableForSchedules(list);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" getSchedulesListingPageTable :: "+e.toString());
			flag=false;
		}

		return flag;
	}
}
