package nextgen.automation.workflow.service.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;

public class FunctionsServicePage extends PageUtil{

	WebDriver driver;

	public FunctionsServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(FunctionsServicePage.class);

	static String functionsTestData=System.getProperty("user.dir")+Constant.NEXTGEN_FUNCTIONS_TESTDATA_EXCEL_PATH;

	/** ----------------------  By locators ---------------------------------- **/

	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));

	By discardButtons=getElementLocator(prop.getProperty("workflow.details.discard.window"));

	By functionsTab=getElementLocator(prop.getProperty("functions.tab.button"));
	By functionsTitle=getElementLocator(prop.getProperty("functions.tab.title"));

	By functionsBreadCrumbHomeLink=getElementLocator(prop.getProperty("functions.listing.breadcrumb.home"));
	By functionsBreadCrumbDataTestingLink=getElementLocator(prop.getProperty("functions.listing.breadcrumb.datatesting"));
	By functionsBreadCrumbFunctionsLabel=getElementLocator(prop.getProperty("functions.listing.breadcrumb.functions.label"));
	By functionsBreadCrumbFunctionsLink=getElementLocator(prop.getProperty("functions.listing.breadcrumb.functions.link"));
	By functionsBreadCrumbFunctionsNewClass=getElementLocator(prop.getProperty("functions.listing.breadcrumb.functions.newclass"));
	By functionsListingButtonNewClass=getElementLocator(prop.getProperty("functions.listing.button.newclass"));
	By functionsListingButtonNewClassDropdown=getElementLocator(prop.getProperty("functions.listing.button.newclassdropdown"));
	By functionsListingButtonRefresh=getElementLocator(prop.getProperty("functions.listing.button.refresh"));
	By functionsListingButtonDelete=getElementLocator(prop.getProperty("functions.listing.button.delete"));
	By fucntionsListingButtonFunction=getElementLocator(prop.getProperty("functions.listing.button.dropdown.function"));
	By functionsListingSearchFunctionField=getElementLocator(prop.getProperty("functions.listing.search.field"));
	By functionsListingSearchFunctionClear=getElementLocator(prop.getProperty("functions.listing.search.clear"));
	By functionsListingSearchFunctionButton=getElementLocator(prop.getProperty("functions.listing.search.button"));
	By functionsListingColumnMasterCheckbox=getElementLocator(prop.getProperty("functions.listing.column.mastercheckbox"));
	By functionsListingColumnName=getElementLocator(prop.getProperty("functions.listing.column.name"));
	By functionsListingColumnState=getElementLocator(prop.getProperty("functions.listing.column.state"));
	By functionsListingColumnHashFunctions=getElementLocator(prop.getProperty("functions.listing.column.hashfunctions"));
	By functionsListingColumnType=getElementLocator(prop.getProperty("functions.listing.column.type"));
	By functionsListingColumnDescription=getElementLocator(prop.getProperty("functions.listing.column.description"));
	By functionsListingColumnLastUpdated=getElementLocator(prop.getProperty("functions.listing.column.lastupdated"));
	By functionsListingNoRecordsToDisplay=getElementLocator(prop.getProperty("functions.listing.function.norecordstodisplay"));
	By functionsListingPaginationBar=getElementLocator(prop.getProperty("functions.listing.paginationbar"));
	By functionsListingPaginationMsg=getElementLocator(prop.getProperty("functions.listing.paginationmsg"));
	By functionsListingNextPageArrow=getElementLocator(prop.getProperty("functions.listing.pagination.nextarrow"));
	By functionsListingClassNameList=getElementLocator(prop.getProperty("functions.listing.classname.list"));
	By functionsListingClassDescList=getElementLocator(prop.getProperty("functions.listing.description.list"));
	By functionsDetailsSaveButton=getElementLocator(prop.getProperty("functions.details.button.save"));
	By functionsDetailsDiscardButton=getElementLocator(prop.getProperty("functions.details.button.discard"));
	By functionsDetailsDeleteButton=getElementLocator(prop.getProperty("functions.details.button.delete"));
	By functionsDetailsNameFieldLabel=getElementLocator(prop.getProperty("functions.details.field.name.label"));
	By functionsDetailsNameFieldInput=getElementLocator(prop.getProperty("functions.details.field.name.input"));
	By functionsDetailsNameFieldValidation=getElementLocator(prop.getProperty("functions.details.field.name.validation"));
	By functionsDetailsDescriptionFieldLabel=getElementLocator(prop.getProperty("functions.details.field.description.label"));
	By functionsDetailsDescriptionFieldInput=getElementLocator(prop.getProperty("functions.details.field.description.input"));
	By functionsDetailsDescriptionFieldValidation=getElementLocator(prop.getProperty("functions.details.field.description.validation"));
	By functionsDetailsClassTypeFieldLabel=getElementLocator(prop.getProperty("functions.details.field.classtype.label"));
	By functionsDetailsClassTypeFieldInput=getElementLocator(prop.getProperty("functions.details.field.classtype.input"));
	By functionsDetailsClassTypeDropDownList=getElementLocator(prop.getProperty("functions.details.field.classtype.dropdownlist"));
	By functionsDetailsScriptCodeHeading=getElementLocator(prop.getProperty("functions.details.script.heading"));
	By functionsDetailsScriptCodeFullScreenIcon=getElementLocator(prop.getProperty("functions.details.script.fullscreen.icon"));
	By functionsDetailsScriptPane=getElementLocator(prop.getProperty("functions.details.script.pane"));
	By functionsDetailsFunctionTab=getElementLocator(prop.getProperty("functions.details.functions.tab"));
	By functionsDetailsClassState=getElementLocator(prop.getProperty("functions.details.title.state"));
	By functionTabAddFunctionButton=getElementLocator(prop.getProperty("functions.details.functions.button.addfunction"));
	By functionTabRemoveFunctionButton=getElementLocator(prop.getProperty("functions.details.functions.button.delete"));
	By functionTabSearchField=getElementLocator(prop.getProperty("functions.details.functions.search.field"));
	By functionTabSearchClear=getElementLocator(prop.getProperty("functions.details.functions.search.clear"));
	By functionTabSearchButton=getElementLocator(prop.getProperty("functions.details.functions.search.button"));
	By functionTabMasterCheckbox=getElementLocator(prop.getProperty("functions.details.functions.column.mastercheckbox"));
	By functionTabColumnFunctionname=getElementLocator(prop.getProperty("functions.details.functions.column.functionname"));
	By functionTabColumnState=getElementLocator(prop.getProperty("functions.details.functions.column.state"));
	By functionTabColumnDescription=getElementLocator(prop.getProperty("functions.details.functions.column.description"));
	By functionTabColumnMethod=getElementLocator(prop.getProperty("functions.details.functions.column.method"));
	By functionTabColumnParamerters=getElementLocator(prop.getProperty("functions.details.functions.column.parameters"));
	By functionTabColumnReturnType=getElementLocator(prop.getProperty("functions.details.functions.column.returntype"));
	By functionTabColumnActions=getElementLocator(prop.getProperty("functions.details.functions.column.actions"));
	By functionTabNoRecordsToDisplay=getElementLocator(prop.getProperty("functions.details.functions.norecordstodisplay"));
	By functionsTabPaginationBar=getElementLocator(prop.getProperty("functions.details.functions.paginationbar"));
	By functionsTabPaginationMsg=getElementLocator(prop.getProperty("functions.details.functions.paginationmsg"));
	By functionsTabNextPageArrow=getElementLocator(prop.getProperty("functions.details.functions.pagination.nextarrow"));
	By functionsSidebarAddFunctionTitle=getElementLocator(prop.getProperty("functions.details.add.function.title"));
	By functionsSidebarAddFunctionDiscard=getElementLocator(prop.getProperty("functions.details.add.function.discard"));
	By functionsSidebarUpdateFunctionTitle=getElementLocator(prop.getProperty("functions.details.update.function.title"));
	By functionsSidebarUpdateFunctionDiscard=getElementLocator(prop.getProperty("functions.details.update.function.discard"));
	By functionsSidebarAddFunctionSaveButton=getElementLocator(prop.getProperty("functions.details.add.function.savebutton"));
	By functionsSidebarAddFunctionCancelButton=getElementLocator(prop.getProperty("functions.details.add.function.cancelbutton"));
	By functionsSidebarAddFunctionAliasLabel=getElementLocator(prop.getProperty("functions.details.add.function.alias.label"));
	By functionsSidebarAddFunctionAliasField=getElementLocator(prop.getProperty("functions.details.add.function.alias.field"));
	By functionsSidebarAddFunctionAliasValidation=getElementLocator(prop.getProperty("functions.details.add.function.alias.validation"));
	By functionsSidebarAddFunctionDescriptionLabel=getElementLocator(prop.getProperty("functions.details.add.function.description.label"));
	By functionsSidebarAddFunctionDescriptionField=getElementLocator(prop.getProperty("functions.details.add.function.description.field"));
	By functionsSidebarAddFunctionDescriptionValidation=getElementLocator(prop.getProperty("functions.details.add.function.description.validation"));
	By functionsSidebarAddFunctionMethodLabel=getElementLocator(prop.getProperty("functions.details.add.function.method.label"));
	By functionsSidebarAddFunctionMethodField=getElementLocator(prop.getProperty("functions.details.add.function.method.field"));
	By functionsSidebarAddFunctionParameterLabel=getElementLocator(prop.getProperty("functions.details.add.function.parameters.label"));
	By functionsSidebarAddFunctionParameterField=getElementLocator(prop.getProperty("functions.details.add.function.parameters.field"));
	By functionsSidebarAddFunctionReturnTypeLabel=getElementLocator(prop.getProperty("functions.details.add.function.returntype.label"));
	By functionsSidebarAddFunctionReturnTypeField=getElementLocator(prop.getProperty("functions.details.add.function.returntype.field"));
	By functionsPopupDeleteTitle=getElementLocator(prop.getProperty("functions.details.popup.deletefunction.title"));
	By functionsPopupDeleteContent=getElementLocator(prop.getProperty("functions.details.popup.deletefunction.content"));
	By functionsPopupDeleteButton=getElementLocator(prop.getProperty("functions.details.popup.deletefunction.deletebutton"));
	By functionsPopupDeleteCancel=getElementLocator(prop.getProperty("functions.details.popup.deletefunction.cancelbutton"));
	By classPopupDeleteTitle=getElementLocator(prop.getProperty("class.details.popup.deleteclass.title"));
	By classPopupDeleteContent=getElementLocator(prop.getProperty("class.details.popup.deleteclass.content"));
	By classPopupDeleteButton=getElementLocator(prop.getProperty("class.details.popup.deleteclass.deletebutton"));
	By classPopupDeleteCancel=getElementLocator(prop.getProperty("class.details.popup.deleteclass.cancelbutton"));
	By functionsListingAddFunctionTitle=getElementLocator(prop.getProperty("functions.listing.add.function.title"));
	By functionsListingAddFunctionDiscard=getElementLocator(prop.getProperty("functions.listing.add.function.discard"));
	By functionsListingAddFunctionClassNameLabel=getElementLocator(prop.getProperty("functions.listing.add.function.classname.label"));
	By functionsListingAddFunctionClassNameField=getElementLocator(prop.getProperty("functions.listing.add.function.classname.field"));
	By functionsListingAddFunctionMethodField=getElementLocator(prop.getProperty("functions.listing.add.function.method.field"));
	By functionsListingBulkDeleteTitle=getElementLocator(prop.getProperty("functions.bulk.delete.title"));
	By functionsListingBulkDeleteDiscard=getElementLocator(prop.getProperty("functions.bulk.delete.discard"));
	By functionsListingBulkSingleDeleteTitle=getElementLocator(prop.getProperty("functions.bulk.singledelete.title"));
	By functionsListingBulkSingleDeleteDiscard=getElementLocator(prop.getProperty("functions.bulk.singledelete.discard"));
	By functionsListingBulkDeleteWarningIcon=getElementLocator(prop.getProperty("functions.bulk.delete.warningicon"));
	By functionsListingBulkDeleteContent=getElementLocator(prop.getProperty("functions.bulk.delete.content"));
	By functionsListingBulkDeleteButtonDelete=getElementLocator(prop.getProperty("functions.bulk.delete.deletebutton"));
	By functionsListingBulkDeleteButtonCancel=getElementLocator(prop.getProperty("functions.bulk.delete.cancelbutton"));
	By functionsListingBulkDeleteLogsLabel=getElementLocator(prop.getProperty("functions.bulk.delete.logs.label"));
	By functionsListingBulkDeleteLogsProgressbar=getElementLocator(prop.getProperty("functions.bulk.delete.logs.progressbar"));
	By functionsListingBulkDeleteLogsRefresh=getElementLocator(prop.getProperty("functions.bulk.delete.logs.refresh"));
	By functionsListingBulkDeleteLogsCopytoclipboard=getElementLocator(prop.getProperty("functions.bulk.delete.logs.copytoclipboard"));
	By functionsListingBulkDeleteLogslog=getElementLocator(prop.getProperty("functions.bulk.delete.logs.log"));
	By functionsListingBulkDeleteLogsDoneButton=getElementLocator(prop.getProperty("functions.bulk.delete.logs.donebutton"));

	By functionsAdvancedSearchTitle=getElementLocator(prop.getProperty("functions.listing.advancedsearch.title"));
	By advancedSearchUpdatedByLabel=getElementLocator(prop.getProperty("functions.advancedSearch.UpdatedBy.lable"));
	By advancedSearchUpdatedByExpand=getElementLocator(prop.getProperty("functions.advancedSearch.UpdatedBy.expandButton"));
	By advancedSearchUpdatedByCollapse=getElementLocator(prop.getProperty("functions.advancedSearch.UpdatedBy.collapseButton"));
	By advancedSearchUpdatedByList=getElementLocator(prop.getProperty("functions.advancedSearch.UpdatedBy.list"));
	By advancedSearchUpdatedBySearchBar=getElementLocator(prop.getProperty("functions.advancedSearch.UpdatedBy.searchbar"));
	By advancedSearchLastUpdatedLabel=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.lable"));
	By advancedSearchLastUpdatedExpand=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.expandButton"));
	By advancedSearchLastUpdatedCollapse=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.collapseButton"));
	By advancedSearchLastUpdatedFrom=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.fromField"));
	By advancedSearchLastUpdatedFromDateIcon=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.fromField.dateicon"));
	By advancedSearchLastUpdatedTo=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.toField"));
	By advancedSearchLastUpdatedToDateIcon=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.toField.dateicon"));
	By advancedSearchLastUpdatedCalanderDatePopup=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.calander.datePopup"));
	By advancedSearchLastUpdatedCalanderCurrentValue=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.calander.currentYearMon"));
	By advancedSearchLastUpdatedCalanderPreviousBtn=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.calander.previousMonBtn"));
	By advancedSearchLastUpdatedCalanderNextBtn=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.calander.nextMonBtn"));
	By advancedSearchLastUpdatedCalanderTodayBtn=getElementLocator(prop.getProperty("functions.advancedSearch.LastUpdated.calander.todayBtn"));

	By advancedSearchTypeLabel=getElementLocator(prop.getProperty("functions.advancedSearch.Type.label"));
	By advancedSearchTypeExpand=getElementLocator(prop.getProperty("functions.advancedSearch.Type.expandButton"));
	By advancedSearchTypeCollapse=getElementLocator(prop.getProperty("functions.advancedSearch.Type.collapseButton"));
	By advancedSearchTypeList=getElementLocator(prop.getProperty("functions.advancedSearch.Type.list"));

	By advancedSearchStateLabel=getElementLocator(prop.getProperty("functions.advancedSearch.state.label"));
	By advancedSearchStateExpand=getElementLocator(prop.getProperty("functions.advancedSearch.state.expandButton"));
	By advancedSearchStateCollapse=getElementLocator(prop.getProperty("functions.advancedSearch.state.collapseButton"));
	By advancedSearchStateList=getElementLocator(prop.getProperty("functions.advancedSearch.state.list"));

	By advancedSearchAppliedFilerCrossIcon=getElementLocator(prop.getProperty("functions.applied.filter.cross.icon"));

	By classPopupDiscardTitle=getElementLocator(prop.getProperty("class.details.popup.discardclass.title"));
	By classPopupDiscardContent=getElementLocator(prop.getProperty("class.details.popup.discardclass.content"));
	By classPopupDiscardButton=getElementLocator(prop.getProperty("class.details.popup.discardclass.discardbutton"));
	By classPopupDiscardCancel=getElementLocator(prop.getProperty("class.details.popup.discardclass.cancelbutton"));

	By classCodePopupPaneTitle=getElementLocator(prop.getProperty("class.code.popup.title"));
	By classCodePopupPaneMinimizeicon=getElementLocator(prop.getProperty("class.code.popup.minimizeicon"));
	By classCodePopupPaneCode=getElementLocator(prop.getProperty("class.code.popup.codepane"));
	By classCodePopupPaneSavebutton=getElementLocator(prop.getProperty("class.code.popup.savebutton"));
	By classCodePopupPaneCancelbutton=getElementLocator(prop.getProperty("class.code.popup.cancelbutton"));

	By functionsListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.functions"));
	By functionsDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.functions"));

	By nextgenTabDataTesting=getElementLocator(prop.getProperty("nextgenmodule.datatesting.tab"));
	By nextgenTabDashboardandReporting=getElementLocator(prop.getProperty("nextgenmodule.dashboard.tab"));
	By nextgenTabScheduler=getElementLocator(prop.getProperty("nextgenmodule.scheduler.tab"));
	By nextgenTabConnector=getElementLocator(prop.getProperty("nextgenmodule.connector.tab"));
	By nextgenTabAdmin=getElementLocator(prop.getProperty("nextgenmodule.admin.tab"));
	By breadcrumbDashboardAndReporting=getElementLocator(prop.getProperty("breadcrumb.dashboardandreporting"));
	By moduleUserPageTitle=getElementLocator(prop.getProperty("module.pagetitle.users"));
	By welcomeText=getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));
	By dataTesting=getElementLocator(prop.getProperty("DataTestingTab"));
	/** ----------------------  String variables ---------------------------------- **/

	String functionsListingFunctionExpandArrowDynamic=prop.getProperty("functions.listing.function.expandarrow");
	String functionsListingFunctionCollapseArrowDynamic=prop.getProperty("functions.listing.function.collapsearrow");
	String functionsListingFunctionCheckboxDynamic=prop.getProperty("functions.listing.function.checkbox");
	String functionsListingFunctionAvatarDynamic=prop.getProperty("functions.listing.function.avatar");
	String functionsListingFunctionNameDynamic=prop.getProperty("functions.listing.function.namehyperlink.dynamic");
	String functionsListingFunctionStateDynamic=prop.getProperty("functions.listing.function.state");
	String functionsListingFunctionHashFunctionsDynamic=prop.getProperty("functions.listing.function.hashfunctions");
	String functionsListingFunctionTypeDynamic=prop.getProperty("functions.listing.function.type");
	String functionsListingFunctionDecriptionDynamic=prop.getProperty("functions.listing.function.description");
	String functionsListingFunctionLastUpdatedByDynamic=prop.getProperty("functions.listing.function.lastupdatedby");
	String functionsListingFunctionLastUpdatedDateDynamic=prop.getProperty("functions.listing.function.lastupdateddate");
	String functionBreadcrumbNameDynamic=prop.getProperty("functions.breadcrumb.functions.name.dynamic");
	String functionBreadcrumbFunctionIdDynamic=prop.getProperty("functions.breadcrumb.functions.id");
	String functionsDetailsFunctionAvatar=prop.getProperty("functions.details.title.avatar.dynamic");
	String functionsDetailsFunctionNameTitle=prop.getProperty("functions.details.title.name.dynamic");
	String functionsDetailsFunctionState=prop.getProperty("functions.details.title.state.dynamic");
	String functionsDetailsClassTypeSelect=prop.getProperty("functions.details.field.classtype.select");
	String functionsDetailsFunctionCheckboxDynamic=prop.getProperty("functions.details.dynamic.function.checkbox");
	String functionsDetailsFunctionAvatarDynamic=prop.getProperty("functions.details.dynamic.function.avatar");
	String functionsDetailsFunctionNameDynamic=prop.getProperty("functions.details.dynamic.function.name");
	String functionsDetailsFunctionStateDynamic=prop.getProperty("functions.details.dynamic.function.state");
	String functionsDetailsFunctionDescriptionDynamic=prop.getProperty("functions.details.dynamic.function.description");
	String functionsDetailsFunctionMethodDynamic=prop.getProperty("functions.details.dynamic.function.method");
	String functionsDetailsFunctionParametersDynamic=prop.getProperty("functions.details.dynamic.function.parameters");
	String functionsDetailsFunctionReturnTypeDynamic=prop.getProperty("functions.details.dynamic.function.returntype");
	String functionsDetailsFunctionActionEditDynamic=prop.getProperty("functions.details.dynamic.function.action.edit");
	String functionsSidebarAddFunctionMethodSelect=prop.getProperty("functions.details.add.function.method.dropdown.dynamic");
	String functionsListingAddFunctionClassNameDropdownListDynamic=prop.getProperty("functions.listing.add.function.classname.dropdown.dynamic");
	String functionsListingAddFunctionMethodNameDyanmic=prop.getProperty("functions.listing.add.function.method.dropdown.dynamic");
	String functionsListingClassChildList=prop.getProperty("functions.listing.function.child.name.list.dynamic");
	String functionsListingClassChildName=prop.getProperty("functions.listing.function.child.name.dynamic");
	String functionsListingClassChildIcon=prop.getProperty("functions.listing.function.child.icon.dynamic");
	String functionsListingClassChildState=prop.getProperty("functions.listing.function.child.state.dynamic");
	String functionsListingClassChildDescription=prop.getProperty("functions.listing.function.child.description.dynamic");
	String functionsListingClassChildUpdatedBy=prop.getProperty("functions.listing.function.child.updatedby.dynamic");
	String functionsListingClassChildUpdatedDate=prop.getProperty("functions.listing.function.child.updateddate.dynamic");
	String placeholderSearchFunction=prop.getProperty("functions.placeholder.searchfunction");
	String placeholderSearch=prop.getProperty("functions.placeholder.searchclass");
	String placeholderDescription=prop.getProperty("parameters.placeholder.description");
	String placeholderClassType=prop.getProperty("functions.placeholder.classtype");
	String placeholderFunctionAlias=prop.getProperty("functions.placeholder.functionalias");
	String placeholderMethodName=prop.getProperty("functions.placeholder.methodname");
	String placeholderClassName=prop.getProperty("functions.placeholder.classname");
	String toastMsgClassCreated=prop.getProperty("functions.toast.msg.class.created");
	String toastMsgFunctionCreated=prop.getProperty("functions.toast.msg.function.created");
	String toastMsgFunctionDeleted=prop.getProperty("functions.toast.msg.function.deleted");
	String toastMsgFunctionDeletedMultiple=prop.getProperty("functions.toast.msg.multiple.function.deleted");
	String toastMsgClassDeleted=prop.getProperty("functions.toast.msg.class.deleted");
	String defaultValueclassType=prop.getProperty("functions.defaultvalue.classtype");
	String defaultReturnType=prop.getProperty("functions.defaultvalue.returntype");
	String functionDeletePopupTitle=prop.getProperty("functions.popup.deletefunction.title");
	String functionDeletePopupContent=prop.getProperty("functions.popup.deletefunction.content");
	String functionMultipleDeletePopupTitle=prop.getProperty("functions.popup.mutiple.deletefunction.title");
	String functionMultipleDeletePopupContent=prop.getProperty("functions.popup.mutiple.deletefunction.content");
	String classDeletePopupTitle=prop.getProperty("class.popup.deleteclass.title");
	String classDeletePopupContent=prop.getProperty("class.popup.deleteclass.content");

	String advanceSearchUpdatedByCheckbox=prop.getProperty("functions.advancedSearch.UpdatedBy.checkbox");
	String advanceSearchLastUpdatedCalanderSelectMon=prop.getProperty("functions.advancedSearch.LastUpdated.calander.selectMonYear");
	String advanceSearchLastUpdatedCalanderSelectDate=prop.getProperty("functions.advancedSearch.LastUpdated.calander.selectdate");
	String updatedbynameOnListing=prop.getProperty("functions.listingpage.updatedbyname");

	String advancedSearchTypeCheckboxDynamic=prop.getProperty("functions.advancedSearch.Type.checkbox.dynamic");
	String advancedSearchStateCheckboxDynamic=prop.getProperty("functions.advancedSearch.state.checkbox.dynamic");

	String functionListingTypeDynamicCheck=prop.getProperty("functions.listingpage.type.check");
	String functionListingStateDynamicCheck=prop.getProperty("functions.listingpage.state.check");

	String classDiscardPopupTitle=prop.getProperty("class.popup.discardclass.title");
	String classDiscardPopupContent=prop.getProperty("class.popup.discardclass.content");

	String moduleTab=prop.getProperty("nextgenmodule.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String modulePageTitle=prop.getProperty("module.pagetitle");

	/** ----------------------  String values ---------------------------------- **/
	String dynamicName=prop.getProperty("DynName");
	String discardContent=prop.getProperty("string.discardContent");
	String cancelButtonContent=prop.getProperty("string.cancelButtonContent");
	String nextContent=prop.getProperty("string.nextContent");
	String refreshContent=prop.getProperty("string.refreshContent");
	String attributeClass=prop.getProperty("string.attributeClass");
	String attrcheck=prop.getProperty("string.attrcheck");
	String attrUncheck=prop.getProperty("string.attrUncheck");
	String attributeValue=prop.getProperty("string.attributeValue");
	String attributeTextContent=prop.getProperty("string.attributeTextContent");
	String attributeInnerText="innerText";
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
	String parametersContent=prop.getProperty("string.parameters");
	String folderContent=prop.getProperty("string.folderContent");
	String rulesContent=prop.getProperty("string.rulesContent");
	String homeContent=prop.getProperty("String.homeContent");
	String moduleContent=prop.getProperty("String.moduleContent");
	String subModuleContent=prop.getProperty("String.subModuleContent");
	String hyphenContent=prop.getProperty("String.hyphenContent");
	String scrollToElementArg=prop.getProperty("ScrollToElementArgument");	

	String functionsContent="Functions";
	String labelContent="label";
	String hyperLinkContent="Hyperlink";
	String columnContent="column";
	String newClassContent="New Class";
	String createNewClassContent="Create New Class";
	String fieldContent="field";
	String monacoEditorScript=prop.getProperty("monaco.editor.javascript");
	String scrollToElement=prop.getProperty("ScrollToElementArgument");
	String noRecordsToDisplayContent="No records to display";
	String minimizeContent="Minimize";

	String iconContent=" icon";
	String editContent=" edit";
	String methodNameContent="Method Name";
	String returnTypeContent="Return Type";
	String addFunctionContent="Add function";
	String dataTestingContent="Data Testing";
	String buttonContent="button";
	String masterContent="Master";
	String checkboxContent="Checkbox";
	String stateContent="State";
	String classTypeContent="Class Type";
	String avatarContent="Avatar";
	String functionNameContent="Function Name";
	String functionAliasContent="Function Alias";
	String classNameContent="Class Name";
	String lastUpdatedContent="Last Updated";
	String functionSheetName="functions";
	String updatefunctionSheetName="updatefunctions";
	static String classNameColumn="className";
	static String functionNameColumn="functionName";
	String timeFormat="yyyy-MM-dd-HH-mm-ss";
	String content1="Function name '";
	String content2="' already exists.";
	String workflowsContent="Workflows";
	String instancesContent="Instances";
	
	String connectionsContent="Connections";
	String schedulerContent="Scheduler";
	
	String sanity="sanity";
	
	/** ----------------------  Generic methods ---------------------------------- **/

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayed(driver, discardButtons, 50);
			if (isDisplayed(driver, discardButtons, 50)) {
				clickOnButton(driver, discardButtons, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			if(isDisplayed(driver, functionsListingBulkDeleteButtonCancel)) {
				clickOnButton(driver, functionsListingBulkDeleteButtonCancel, cancelButtonContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			if(isDisplayed(driver, functionsSidebarAddFunctionCancelButton)) {
				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
			
			if(isDisplayed(driver, functionsPopupDeleteCancel)) {
				clickOnButton(driver, functionsPopupDeleteCancel, cancelButtonContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public boolean clickOnFunctionsTab() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, functionsListingButtonNewClass);

			if(elementNotVisible(driver, functionsListingButtonNewClass)) {

				handleDiscardWindow();

				isDisplayedInLoop(driver, 3, functionsTab);

				if(isDisplayed(driver, functionsTab, 5)) {

					flag = isClickable(driver, functionsTab, functionsContent+" tab", true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+functionsContent+" tab");

						displayAndClick(driver, functionsTab);

						BaseSuite.validationReportLog("Clicked on "+functionsContent+" tab");

						handleDiscardWindow();

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateElement(driver, functionsTitle, functionsContent, attributeTitle);

						clickOnButton(driver, functionsListingButtonRefresh, refreshContent, true);

						waitForExecution(2000);

					}

				}else {
					BaseSuite.reportFailLog(functionsContent+" tab not visible", "clickOnFunctionsTab");

					displayAndClick(driver, functionsTab);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnFunctionsTab :: "+e.toString());
			flag=false;
		}
		return flag;

	}


	public boolean validateFunctionsListingPage() {
		boolean flag =true;
		HomePage hp=new HomePage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, functionsSidebarAddFunctionCancelButton)) {
				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
			}

			hp.validateNextgenModuleAndDataTestingSubModules();

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Functions listing page "+hyphenContent);

			validateElement(driver,functionsBreadCrumbHomeLink, homeContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbDataTestingLink, dataTestingContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbFunctionsLabel, functionsContent, labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying Title and Search field Functions listing page "+hyphenContent);

			verifyIndividualLabel(driver, functionsTitle, functionsContent);

			verifySearchField(driver, functionsListingSearchFunctionField, placeholderSearch, placeholderSearch);

			validateElement(driver, functionsListingSearchFunctionButton, placeholderSearch,buttonContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Functions listing page "+hyphenContent);

			validateButtons(driver, functionsListingButtonsCount, 4);

			verifyVisibilityOfButtons(driver, functionsListingButtonNewClass, newClassContent, true);
			verifyVisibilityOfButtons(driver, functionsListingButtonNewClassDropdown, newClassContent+" dropdown", true);

			verifyVisibilityOfButtons(driver, functionsListingButtonRefresh, refreshContent, true);
			verifyVisibilityOfButtons(driver, functionsListingButtonDelete, deleteContent, false);

			BaseSuite.reportLog(hyphenContent+" Verifying Columns on Functions listing page "+hyphenContent);

			validateElement(driver, functionsListingColumnMasterCheckbox, masterContent,checkboxContent);
			validateElement(driver, functionsListingColumnName, "Name",columnContent);
			validateElement(driver, functionsListingColumnState, stateContent,columnContent);
			validateElement(driver, functionsListingColumnHashFunctions, "# Functions",columnContent);
			validateElement(driver, functionsListingColumnType, "Type",columnContent);
			validateElement(driver, functionsListingColumnDescription, descriptionContent,columnContent);
			validateElement(driver, functionsListingColumnLastUpdated, lastUpdatedContent,columnContent);

			BaseSuite.reportLog(hyphenContent+" Verifying pagination on Functions listing page "+hyphenContent);

			getPaginationDetails(driver, functionsListingPaginationMsg, functionsListingPaginationBar, functionsListingNoRecordsToDisplay, "Functions listing");

			BaseSuite.validationReportLog(hyphenContent+" Functions listing page validated successfully "+hyphenContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionsListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateNewClassPrivilege(boolean flag,String icedqUser) {

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, functionsBreadCrumbFunctionsNewClass);

			if (isDisplayed(driver, returnElement(functionsDetailsFunctionNameTitle, dynamicName, createNewClassContent)) && (icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				verifyIndividualLabel(driver, functionsBreadCrumbFunctionsNewClass, newClassContent+labelContent);

				BaseSuite.validationReportLog("New Class button is clicked "+ConstantProperty.SUCCESSSTRING);


			}else{
				BaseSuite.reportFailLog("New Class button not clicked properly, kindly check", "validateNewClassPrivilege");
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNewClassPrivilege :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean clickOnNewClassButton(String icedqUser) {
		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, functionsListingButtonNewClass, newClassContent, true);

			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 1, toastMsg);

				if (isDisplayed(driver, toastMsg) || icedqUser.toLowerCase().contains(executorContent) || icedqUser.toLowerCase().contains(readerContent)) {

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Class authorization message");

				}else {

					flag=validateNewClassPrivilege(flag, icedqUser);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnNewClassButton :: "+e.toString());
			flag=false;
		}


		return flag;
	}


	public boolean validateNewClassPageBeforeCreating() {

		boolean flag =true;

		try {

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Functions Details page "+hyphenContent);

			validateElement(driver,functionsBreadCrumbHomeLink, homeContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbDataTestingLink, dataTestingContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbFunctionsLink, functionsContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbFunctionsNewClass, newClassContent, labelContent);

			validateElementVisibility(driver, returnElement(functionsDetailsFunctionAvatar, dynamicName, createNewClassContent), createNewClassContent, avatarContent, true);

			validateElementVisibility(driver, returnElement(functionsDetailsFunctionNameTitle, dynamicName, createNewClassContent), createNewClassContent, attributeTitle, true);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Functions Details page "+hyphenContent);

			validateButtons(driver, functionsDetailsBeforeCreateButtonsCount, 5);

			verifyVisibilityOfButtons(driver, functionsDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, false);

			validateElement(driver,functionsDetailsNameFieldLabel, "Name", attributeTitle);
			validateField(driver, functionsDetailsNameFieldInput, "Name", "", fieldContent, "", attributeTextContent,false);

			validateElement(driver,functionsDetailsDescriptionFieldLabel, descriptionContent, attributeTitle);
			validateField(driver, functionsDetailsDescriptionFieldInput, descriptionContent, placeholderDescription, fieldContent, "", attributeTextContent,true);

			validateElement(driver,functionsDetailsClassTypeFieldLabel, classTypeContent, attributeTitle);
			validateField(driver, functionsDetailsClassTypeFieldInput, classTypeContent, placeholderClassType, fieldContent, defaultValueclassType, attributeTextContent,true);

			validateElement(driver, functionsDetailsScriptCodeHeading, "Code", labelContent);
			verifyVisibilityOfButtons(driver, functionsDetailsScriptCodeFullScreenIcon, "Full screen", true);
			validateField(driver, functionsDetailsScriptPane, "Script pane", "", fieldContent, "", attributeTextContent,true);

			validateElement(driver,functionsDetailsFunctionTab, functionsContent, "tab");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Functions tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, functionTabAddFunctionButton, addFunctionContent, false);
			verifyVisibilityOfButtons(driver, functionTabRemoveFunctionButton, deleteContent, false);

			verifySearchField(driver, functionTabSearchField, placeholderSearchFunction, placeholderSearchFunction);
			validateElement(driver,functionTabSearchButton, placeholderSearchFunction, buttonContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns on Functions tab "+hyphenContent);

			validateElement(driver,functionTabMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver,functionTabColumnFunctionname, functionNameContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, stateContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, descriptionContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, "Method", columnContent);
			validateElement(driver,functionTabColumnFunctionname, parametersContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, "Return type", columnContent);
			validateElement(driver,functionTabColumnFunctionname, "Actions", columnContent);

			getPaginationDetails(driver, functionsTabPaginationMsg, functionsTabPaginationBar, functionTabNoRecordsToDisplay, "Functions tab listing");


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNewClassPageBeforeCreating :: "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean validateNewClassPageAfterCreated(DataTestingParameters param) {

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verifying breadcrumb on Functions Details page "+hyphenContent);

			validateElement(driver,functionsBreadCrumbHomeLink, homeContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbDataTestingLink, dataTestingContent, hyperLinkContent);

			validateElement(driver,functionsBreadCrumbFunctionsLink, functionsContent, hyperLinkContent);

			validateElement(driver,returnElement(functionBreadcrumbNameDynamic, dynamicName, param.getClassName()), param.getClassName(), labelContent);

			getFunctionIdOnFunctionsDetailsPage(param.getClassName());

			validateElementVisibility(driver, returnElement(functionsDetailsFunctionAvatar, dynamicName, param.getClassName()), param.getClassName(), avatarContent, true);

			validateElementVisibility(driver, returnElement(functionsDetailsFunctionNameTitle, dynamicName, param.getClassName()), param.getClassName(), attributeTitle, true);

			validateElement(driver,returnElement(functionsDetailsFunctionState, dynamicName, param.getClassName()), param.getClassState(), labelContent);

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Functions Details page "+hyphenContent);

			validateButtons(driver, functionsDetailsBeforeCreateButtonsCount, 5);

			verifyVisibilityOfButtons(driver, functionsDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, true);

			validateElement(driver,functionsDetailsNameFieldLabel, "Name", attributeTitle);
			validateField(driver, functionsDetailsNameFieldInput, "Name", "", fieldContent, param.getClassName(), attributeValue,false);

			validateElement(driver,functionsDetailsDescriptionFieldLabel, descriptionContent, attributeTitle);
			validateField(driver, functionsDetailsDescriptionFieldInput, descriptionContent, placeholderDescription, fieldContent, param.getClassDescription(), attributeValue,true);

			validateElement(driver,functionsDetailsClassTypeFieldLabel, classTypeContent, attributeTitle);
			validateField(driver, functionsDetailsClassTypeFieldInput, classTypeContent, placeholderClassType, fieldContent, param.getClassType(), attributeTextContent,true);

			validateElement(driver, functionsDetailsScriptCodeHeading, "Code", labelContent);
			verifyVisibilityOfButtons(driver, functionsDetailsScriptCodeFullScreenIcon, "Full screen", true);

			validateElement(driver,functionsDetailsFunctionTab, functionsContent, "tab");

			BaseSuite.reportLog(hyphenContent+" Verifying buttons on Functions tab "+hyphenContent);

			verifyVisibilityOfButtons(driver, functionTabAddFunctionButton, addFunctionContent, true);
			verifyVisibilityOfButtons(driver, functionTabRemoveFunctionButton, deleteContent, false);

			verifySearchField(driver, functionTabSearchField, placeholderSearchFunction, placeholderSearchFunction);
			validateElement(driver,functionTabSearchButton, placeholderSearchFunction, buttonContent);

			BaseSuite.reportLog(hyphenContent+" Verifying columns on Functions tab "+hyphenContent);

			validateElement(driver,functionTabMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver,functionTabColumnFunctionname, functionNameContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, stateContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, descriptionContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, "Method", columnContent);
			validateElement(driver,functionTabColumnFunctionname, parametersContent, columnContent);
			validateElement(driver,functionTabColumnFunctionname, "Return type", columnContent);
			validateElement(driver,functionTabColumnFunctionname, "Actions", columnContent);

			getPaginationDetails(driver, functionsTabPaginationMsg, functionsTabPaginationBar, functionTabNoRecordsToDisplay, "Functions tab listing");


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNewClassPageBeforeCreating :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public String getFunctionIdOnFunctionsDetailsPage(String className) {
		String id =null;
		try {
			isDisplayedInLoop(driver, 3, returnElement(functionBreadcrumbFunctionIdDynamic, dynamicName, className));

			if(isDisplayed(driver, returnElement(functionBreadcrumbFunctionIdDynamic, dynamicName, className))) {

				id = getText(driver, returnElement(functionBreadcrumbFunctionIdDynamic, dynamicName, className));

				id = id.replaceAll(regexToRemoveBracess, "");

				BaseSuite.reportLog("Function/Class id is :: "+id);
			}else {
				BaseSuite.reportFailLog("User id is not visible ", "getFunctionIdOnFunctionsDetailsPage");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getFunctionIdOnFunctionsDetailsPage :: "+e.toString());

		}
		return id;
	}

	public boolean searchClassNameOnEachPageAndClickOn(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching class name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("class name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, functionsListingNextPageArrow)) {

					String status = getAttribute(driver, functionsListingNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, functionsListingNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchClassNameOnEachPageAndClickOn :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchFunctionNameOnEachPage(By locator,String name) {

		boolean flag=true;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching function name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("function name : "+name+" found on page number :"+(pn+1));

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, functionsTabNextPageArrow)) {

					String status = getAttribute(driver, functionsTabNextPageArrow, attributeClass);

					if (!status.contains("disable")) {

						clickOnButton(driver, functionsTabNextPageArrow, "next page", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchFunctionNameOnEachPage :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean searchClassNameAndClickOnClassName(String className) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, className);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, functionsListingNoRecordsToDisplay)) {

				flag=searchClassNameOnEachPageAndClickOn(returnElement(functionsListingFunctionNameDynamic, dynamicName, className), className);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+" is visible ","searchClassNameAndClickOnClassName");
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchClassNameAndClickOnClassName "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchClassNameAndValidate(String className) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, className);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && elementNotVisible(driver, functionsListingNoRecordsToDisplay)) {

				flag=searchFunctionNameOnEachPage(returnElement(functionsListingFunctionNameDynamic, dynamicName, className), className);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportLog(noRecordsToDisplayContent+" is visible ");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchClassNameAndValidate "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchFunctionNameInClassDetails(String functionName) {
		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, functionTabSearchField, functionTabSearchButton, placeholderSearchFunction, placeholderSearchFunction, functionName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			javascript(driver, scrollToElementArg, functionsTabPaginationMsg);

			if(flag && elementNotVisible(driver, functionTabNoRecordsToDisplay)) {

				flag=searchFunctionNameOnEachPage(returnElement(functionsDetailsFunctionNameDynamic, dynamicName, functionName), functionName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				BaseSuite.reportFailLog(noRecordsToDisplayContent+" is visible","searchFunctionNameInClassDetails");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchFunctionNameInClassDetails "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnClassSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionsDetailsSaveButton, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Class Created");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Class Created ");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnClassSaveButtonAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnClassSaveButtonAndValidateToastInvalid(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionsDetailsSaveButton, saveContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Class Created ", false);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag) {
				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Class Created", false);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnClassSaveButtonAndValidateToastInvalid :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnDeleteClassAndValidateToast(String expectedToastMessage) {
		boolean tag =true;
		boolean flag=true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, classPopupDeleteButton, deleteContent, true);

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Class Delete");
			if(flag) {
				tag=false;
			}
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Class Delete");
			}
			
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteClassAndValidateToast :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean clickOnAddFunctionButtonAndValidate(String expectedToastMessage) {

		boolean flag =true;
		boolean tag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, functionsSidebarAddFunctionCancelButton)) {
				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
			}

			javascript(driver, scrollToElement, functionTabAddFunctionButton);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionTabAddFunctionButton, addFunctionContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, functionsSidebarAddFunctionTitle)) {

				clickOnButton(driver, functionTabAddFunctionButton, addFunctionContent, true);

			}

			if(isDisplayed(driver, toastMsg)) {
				BaseSuite.reportLog("Checking toast for first attempt.");
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, addFunctionContent);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				BaseSuite.reportLog("Checking toast for second attempt");
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,addFunctionContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnAddFunctionButtonAndValidate :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnAddFunctionButtonAndValidateInvalid(String expectedToastMessage) {

		boolean flag =true;
		boolean tag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, functionsSidebarAddFunctionCancelButton)) {
				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
			}

			javascript(driver, scrollToElement, functionTabAddFunctionButton);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionTabAddFunctionButton, addFunctionContent, true);

			if(isDisplayed(driver, toastMsg)) {
				BaseSuite.reportLog("Checking toast for first attempt.");
				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, addFunctionContent, false);
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				BaseSuite.reportLog("Checking toast for second attempt.");
				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,addFunctionContent, false);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnAddFunctionButtonAndValidate :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnSaveButtonToAddFunctionAndValidate(String expectedToastMessage) {

		boolean flag =true;
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionsSidebarAddFunctionSaveButton, saveContent, true);

			if(!expectedToastMessage.isEmpty()) {
				BaseSuite.reportLog("Checking toast for first attempt");
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, addFunctionContent);
				
				tag=!flag;
				
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				BaseSuite.reportLog("Checking toast for second attempt");
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,addFunctionContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnSaveButtonToAddFunctionAndValidate :: "+e.toString());
			flag=false;
		}finally {

			if(isDisplayed(driver, classPopupDeleteButton)) {
				displayAndClick(driver, functionsSidebarAddFunctionCancelButton);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		}

		return flag;
	}

	public boolean clickOnFunctionButtonOnListingAndValidate(String expectedToastMessage) {

		boolean flag =true;
		boolean tag =false;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, functionsSidebarAddFunctionCancelButton)) {
				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
			}

			javascript(driver, scrollToElement, functionsListingButtonNewClassDropdown);

			clickOnButton(driver, functionsListingButtonNewClassDropdown, newClassContent+" dropdown", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, fucntionsListingButtonFunction, functionsContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, addFunctionContent);
				
			}else {
					tag=true;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,addFunctionContent);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnFunctionButtonOnListingAndValidate :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteClassButtonAndValidate(String expectedToastMessage) {

		boolean flag =true;
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionsListingButtonDelete, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, deleteContent+" class");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,deleteContent+" class ");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteClassButtonAndValidate :: "+e.toString());
			flag=false;
		}finally {

			if(isDisplayed(driver, classPopupDeleteButton)) {
				displayAndClick(driver, functionsSidebarAddFunctionCancelButton);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		}

		return flag;
	}

	public boolean clickOnDeleteClassDetailspageButtonAndValidate(String expectedToastMessage) {

		boolean flag =true;
		boolean tag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, functionsListingButtonDelete, deleteContent, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, deleteContent+" class ");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !expectedToastMessage.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,deleteContent+" class");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteClassDetailspageButtonAndValidate :: "+e.toString());
			flag=false;
		}finally {

			if(isDisplayed(driver, classPopupDeleteButton)) {
				displayAndClick(driver, functionsSidebarAddFunctionCancelButton);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		}

		return flag;
	}

	public boolean validateFunctionSidebar(String functionName, String description, String methodName, String parameters, String returnType, int type){

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verifying Functions Sidebar page "+hyphenContent);

			if(type==1) {
				validateElement(driver,functionsSidebarAddFunctionTitle, "Add Function", attributeTitle);

				validateElement(driver,functionsSidebarAddFunctionDiscard, discardContent, "icon");
			}else {
				validateElement(driver,functionsSidebarUpdateFunctionTitle, "Function", attributeTitle);

				validateElement(driver,functionsSidebarUpdateFunctionDiscard, discardContent, "icon");
			}
			verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

			validateElement(driver,functionsSidebarAddFunctionAliasLabel, functionAliasContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionAliasField, functionAliasContent, placeholderFunctionAlias, fieldContent, functionName, attributeValue,true);

			validateElement(driver,functionsSidebarAddFunctionDescriptionLabel, descriptionContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionDescriptionField, descriptionContent, placeholderDescription, fieldContent, description, attributeTextContent,true);

			validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionMethodField, methodNameContent, placeholderMethodName, fieldContent, methodName, attributeTextContent,true);

			validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, parameters, attributeValue,false);

			validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, returnType, attributeValue,false);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionSidebar :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateFunctionSidebarOnListing(String className, String functionName, String description, String methodName, String parameters, String returnType){

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog(hyphenContent+" Verifying Add Function Sidebar page "+hyphenContent);

			validateElement(driver,functionsListingAddFunctionTitle, "Add Function", attributeTitle);

			validateElement(driver,functionsListingAddFunctionDiscard, discardContent, "icon");

			verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

			validateElement(driver,functionsListingAddFunctionClassNameLabel, classNameContent, labelContent);
			validateField(driver, functionsListingAddFunctionClassNameField, classNameContent, placeholderClassName, fieldContent, className, attributeValue,true);

			validateElement(driver,functionsSidebarAddFunctionAliasLabel, functionAliasContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionAliasField, functionAliasContent, placeholderFunctionAlias, fieldContent, functionName, attributeValue,true);

			validateElement(driver,functionsSidebarAddFunctionDescriptionLabel, descriptionContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionDescriptionField, descriptionContent, placeholderDescription, fieldContent, description, attributeTextContent,true);

			validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
			validateField(driver, functionsListingAddFunctionMethodField, methodNameContent, placeholderMethodName, fieldContent, methodName, attributeTextContent,true);

			validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, parameters, attributeValue,false);

			validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, returnType, attributeValue,false);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionSidebarOnListing :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean addFunctionOnListing(DataTestingParameters xparam, DataTestingParameters param){

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			selectClassNameOnListing(xparam.getClassName());

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
					descriptionContent, placeholderFunctionAlias, param.getFunctionName(), "");

			validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
					descriptionContent, placeholderDescription, param.getFunctionDescription(), "");

			validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
			selectMethodNameOnListing(param.getFunctionMethodName());

			validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, param.getFunctionParameters(), attributeValue,false);

			validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, param.getFunctionReturnType(), attributeValue,false);

			flag=clickOnSaveButtonToAddFunctionAndValidate(toastMsgFunctionCreated);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" addFunctionOnListing :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createFunction(DataTestingParameters param){

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
					functionAliasContent, placeholderFunctionAlias, param.getFunctionName(), "");

			validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
					descriptionContent, placeholderDescription, param.getFunctionDescription(), "");

			validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
			selectMethodName(param.getFunctionMethodName());

			validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, param.getFunctionParameters(), attributeValue,false);

			validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, param.getFunctionReturnType(), attributeValue,false);

			flag=clickOnSaveButtonToAddFunctionAndValidate(toastMsgFunctionCreated);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createFunction :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateFunction(DataTestingParameters param){

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
					descriptionContent, placeholderFunctionAlias, param.getFunctionName(), "");

			validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
					descriptionContent, placeholderDescription, param.getFunctionDescription(), "");

			validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
			selectMethodName(param.getFunctionMethodName());

			validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, param.getFunctionParameters(), attributeValue,false);

			validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
			validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, param.getFunctionReturnType(), attributeValue,false);

			flag=clickOnSaveButtonToAddFunctionAndValidate("");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateFunction :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void selectMethodName(String methodName) {

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, functionsSidebarAddFunctionMethodField);

			waitForExecution(1000);

			BaseSuite.reportLog("Searching for method name : "+methodName);

			isDisplayedInLoop(driver,2, returnElement(functionsSidebarAddFunctionMethodSelect, dynamicName, methodName));

			if(isDisplayed(driver, returnElement(functionsSidebarAddFunctionMethodSelect, dynamicName, methodName))) {

				BaseSuite.reportLog("Selecting method name : "+methodName);

				displayAndClick(driver, returnElement(functionsSidebarAddFunctionMethodSelect, dynamicName, methodName));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Method is selected");

				String getAcc=getAttribute(driver, functionsSidebarAddFunctionMethodField, attributeTextContent);

				stringOutput(getAcc.trim(), methodName, true);

			}else {
				BaseSuite.reportFailLog("Method is not visible", "selectMethodName");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectMethodName :: "+e.toString());
		}
	}



	public void selectMethodNameOnListing(String methodName) {

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, functionsListingAddFunctionMethodField);

			waitForExecution(1000);

			BaseSuite.reportLog("Searching for method name : "+methodName);

			isDisplayedInLoop(driver,2, returnElement(functionsListingAddFunctionMethodNameDyanmic, dynamicName, methodName));

			if(isDisplayed(driver, returnElement(functionsListingAddFunctionMethodNameDyanmic, dynamicName, methodName))) {

				BaseSuite.reportLog("Selecting method name : "+methodName);

				displayAndClick(driver, returnElement(functionsListingAddFunctionMethodNameDyanmic, dynamicName, methodName));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Method is selected");

				String getAcc=getAttribute(driver, functionsListingAddFunctionMethodField, attributeTextContent);

				stringOutput(getAcc.trim(), methodName, true);

			}else {
				BaseSuite.reportFailLog("Method is not visible", "selectMethodNameOnListing");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectMethodNameOnListing :: "+e.toString());
		}
	}

	public void selectClassNameOnListing(String className) {

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, functionsListingAddFunctionClassNameField);

			waitForExecution(1000);

			BaseSuite.reportLog("Searching for class name : "+className);

			isDisplayedInLoop(driver,2, returnElement(functionsListingAddFunctionClassNameDropdownListDynamic, dynamicName, className));

			if(isDisplayed(driver, returnElement(functionsListingAddFunctionClassNameDropdownListDynamic, dynamicName, className))) {

				BaseSuite.reportLog("Selecting class name : "+className);

				displayAndClick(driver, returnElement(functionsListingAddFunctionClassNameDropdownListDynamic, dynamicName, className));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("class is selected");

				String getAcc=getAttribute(driver, functionsListingAddFunctionClassNameField, attributeTextContent);

				stringOutput(getAcc.trim(), className, true);

			}else {
				BaseSuite.reportFailLog("class is not visible", "selectClassNameOnListing");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectClassNameOnListing :: "+e.toString());
		}
	}

	public void selectClassType(String classtype) {

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, functionsDetailsClassTypeFieldInput);

			waitForExecution(1000);

			isDisplayedInLoop(driver,2, returnElement(functionsDetailsClassTypeSelect, dynamicName, classtype));

			if(isDisplayed(driver, returnElement(functionsDetailsClassTypeSelect, dynamicName, classtype))) {

				BaseSuite.reportLog("Selecting Class type : "+classtype);

				displayAndClick(driver, returnElement(functionsDetailsClassTypeSelect, dynamicName, classtype));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Class type is selected");

				String getAcc=getAttribute(driver, functionsDetailsClassTypeFieldInput, attributeTextContent);

				stringOutput(getAcc.trim(), classtype, true);

			}else {
				BaseSuite.reportFailLog("Class type is not visible", "selectClassType");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectClassType :: "+e.toString());
		}
	}

	public boolean createFunctionUsingExcelData(DataTestingParameters param, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;

		try {
			if (!param.getFunctionName().isEmpty()) {

				if (param.getFunctionName().contains(",")) {

					functionName = param.getFunctionName().split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionName[i], icedqUser, state);

						BaseSuite.reportLog(hyphenContent+" Adding "+(i+1)+" function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

						clickOnAddFunctionButtonAndValidate("");

						if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

						flag=createFunction(fparam);
					}

				} else {

					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, state);

					BaseSuite.reportLog(hyphenContent+" Adding function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

					clickOnAddFunctionButtonAndValidate("");

					if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

					flag=createFunction(fparam);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createFunctionUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean createFunctionOnListingUsingExcelData(DataTestingParameters param, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;

		try {
			if (!param.getFunctionName().isEmpty()) {

				if (param.getFunctionName().contains(",")) {

					functionName = param.getFunctionName().split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionName[i], icedqUser, state);

						BaseSuite.reportLog(hyphenContent+" creating "+(i+1)+" function into the class : "+fparam.getFunctionName()+" "+hyphenContent);

						clickOnFunctionButtonOnListingAndValidate("");

						if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebarOnListing("","fn_", "", "", "", "");}

						flag=addFunctionOnListing(param,fparam);
					}

				} else {

					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, state);

					BaseSuite.reportLog(hyphenContent+" creating function into the class : "+fparam.getFunctionName()+" "+hyphenContent);

					clickOnFunctionButtonOnListingAndValidate("");

					if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebarOnListing("","fn_", "", "", "", "");}

					flag=addFunctionOnListing(param,fparam);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createFunctionUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public String[][] getClassTableOnListingPage(String className){
		String [][] table =null;
		int row=0;

		try {

			table = new String[2][9];

			String[] header = {"Seq","icon", "Name", stateContent,"#Functions","Type", descriptionContent,"Updated by",lastUpdatedContent};

			table[0] =header;

			String num=Integer.toString(row+1);

			String icon = getAttribute(driver, returnElement(functionsListingFunctionAvatarDynamic, dynamicName, className),attributeTitle);

			String name= getValue(driver,returnElement(functionsListingFunctionNameDynamic, dynamicName, className));

			String state= getAttribute(driver, returnElement(functionsListingFunctionStateDynamic, dynamicName, className),attributeTitle);

			String func= getValue(driver, returnElement(functionsListingFunctionHashFunctionsDynamic, dynamicName, className));

			String type= getValue(driver, returnElement(functionsListingFunctionTypeDynamic, dynamicName, className));

			String desc= getValue(driver, returnElement(functionsListingFunctionDecriptionDynamic, dynamicName, className));

			String by= getAttribute(driver, returnElement(functionsListingFunctionLastUpdatedByDynamic, dynamicName, className),attributeTitle);

			String date= getValue(driver, returnElement(functionsListingFunctionLastUpdatedDateDynamic, dynamicName, className));

			String [] data = {num, icon, name, state, func, type, desc, by, date};

			table[row+1] = data;


			BaseSuite.reportLog(createHtmlTable1(table,"Class Table"));
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getClassTableOnListingPage :: "+e.toString());

		}

		return table;
	}

	public String[][] getFunctionsTableOnListingPage(String className){
		String [][] table =null;
		int row=0;
		String dynamicChild="$child";
		try {
			List<WebElement> functions = getElements(driver, returnElement(functionsListingClassChildList, dynamicName, className));

			table = new String[functions.size()+1][5];

			String[] header = {"Seq","icon", "Name", stateContent,descriptionContent,"Updated by",lastUpdatedContent};

			table[0] =header;

			for(int i = 0; i<functions.size();i++) {

				String num=Integer.toString(row+1);

				String functionName = functions.get(i).getAttribute(attributeTextContent).trim();

				String icon=getAttribute(driver,returnTwoElements(functionsListingClassChildIcon, dynamicName, className, dynamicChild, functionName),attributeTitle);

				String state=getAttribute(driver,returnTwoElements(functionsListingClassChildState, dynamicName, className, dynamicChild, functionName),attributeTitle);

				String desc=getValue(driver, returnTwoElements(functionsListingClassChildDescription, dynamicName, className, dynamicChild, functionName));

				String by=getAttribute(driver, returnTwoElements(functionsListingClassChildUpdatedBy, dynamicName, className, dynamicChild, functionName),attributeTitle);

				String date=getValue(driver, returnTwoElements(functionsListingClassChildUpdatedDate, dynamicName, className, dynamicChild, functionName));

				String [] data = {num, icon, functionName,state,desc,by,date};

				table[row+1] = data;

				row++;
			}

			BaseSuite.reportLog(createHtmlTable1(table,"Functions Table"));
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" getFunctionsTableOnListingPage :: "+e.toString());

		}

		return table;
	}

	public boolean viewFunctionOnListingUsingExcelData(DataTestingParameters param, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;

		try {
			if (!param.getFunctionName().isEmpty()) {

				if (param.getFunctionName().contains(",")) {

					functionName = param.getFunctionName().split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionName[i], icedqUser, state);

						BaseSuite.reportLog(hyphenContent+" verifying "+(i+1)+" function of the class : "+fparam.getFunctionName()+" "+hyphenContent);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassName());

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						getFunctionsTableOnListingPage(param.getClassName());

					}

				} else {

					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, state);

					BaseSuite.reportLog(hyphenContent+" verifying function of the class : "+fparam.getFunctionName()+" "+hyphenContent);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassName());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					getFunctionsTableOnListingPage(param.getClassName());

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewFunctionOnListingUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean addFunctionUsingExcelData(String functionsName, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;

		try {
			if (!functionsName.isEmpty()) {

				if (functionsName.contains(",")) {

					functionName = functionsName.split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionName[i], icedqUser, state);

						BaseSuite.reportLog(hyphenContent+" Adding "+(i+1)+" function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

						clickOnAddFunctionButtonAndValidate("");

						if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", "",1);}

						flag=createFunction(fparam);
					}

				} else {

					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionsName, icedqUser, state);

					BaseSuite.reportLog(hyphenContent+" Adding function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

					clickOnAddFunctionButtonAndValidate("");

					if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", "",1);}

					flag=createFunction(fparam);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" addFunctionUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateFunctionDetails(DataTestingParameters fparam,DataTestingParameters sparam, int i, String icedqUser) {
		boolean flag =true;

		try {
			BaseSuite.reportLog(hyphenContent+" updating "+(i+1)+" function in the class : "+sparam.getFunctionName()+" "+hyphenContent);

			searchFunctionNameInClassDetails(sparam.getFunctionName());

			javascript(driver, scrollToElement, functionTabAddFunctionButton);

			clickOnButton(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, sparam.getFunctionName()), sparam.getFunctionName()+editContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				flag=updateFunction(fparam);
			}else {

				flag= captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, "update function");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateFunctionDetails :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean clickOnDeleteFunctionAndValidateToast(boolean flag, int numberOfUsers) {
		String toastMsgContent="";
		try {

			if(numberOfUsers==1) {
				validatePopupWindowContent(driver, flag, functionsPopupDeleteTitle, functionsPopupDeleteContent, functionDeletePopupTitle, functionDeletePopupContent);
				toastMsgContent=toastMsgFunctionDeleted;
			}else {
				validatePopupWindowContent(driver,flag, functionsPopupDeleteTitle, functionsPopupDeleteContent, functionMultipleDeletePopupTitle, functionMultipleDeletePopupContent);
				toastMsgContent=toastMsgFunctionDeletedMultiple;
			}

			verifyVisibilityOfButtons(driver, functionsPopupDeleteButton, deleteContent, true);
			verifyVisibilityOfButtons(driver, functionsPopupDeleteCancel, cancelButtonContent, true);

			clickOnButton(driver, functionsPopupDeleteButton, deleteContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, toastMsgContent, functionDeletePopupTitle);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnDeleteFunctionAndValidateToast :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteFunction(DataTestingParameters fparam, int i) {
		boolean flag =true;

		try {
			BaseSuite.reportLog(hyphenContent+" deleting "+(i+1)+" function from the class : "+fparam.getFunctionName()+" "+hyphenContent);

			if(isDisplayed(driver, returnElement(functionsDetailsFunctionNameDynamic, dynamicName, fparam.getFunctionName()))) {

				javascript(driver, scrollToElementArg, returnElement(functionsDetailsFunctionNameDynamic, dynamicName, fparam.getFunctionName()));

				BaseSuite.reportLog(fparam.getFunctionName()+" function is visible ");

				BaseSuite.reportLog("Clicking on functions checkbox");

				isDisplayedInLoop(driver, 2, returnElement(functionsDetailsFunctionCheckboxDynamic, dynamicName, fparam.getFunctionName()));

				displayAndClick(driver,  returnElement(functionsDetailsFunctionCheckboxDynamic, dynamicName, fparam.getFunctionName()));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.reportLog("Clicked on functions checkbox");

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteFunction :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateFunctionUsingExcelData(String updateFunctions, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;

		try {
			if (!updateFunctions.isEmpty()) {

				if (updateFunctions.contains(",")) {

					functionName = updateFunctions.split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters sparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionName[i], icedqUser, state);
						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,updatefunctionSheetName, functionName[i], icedqUser, state);

						flag=updateFunctionDetails(fparam,sparam, i, icedqUser);

					}

				} else {
					DataTestingParameters sparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, updateFunctions, icedqUser, state);
					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,updatefunctionSheetName, updateFunctions, icedqUser, state);

					flag=updateFunctionDetails(fparam, sparam, 0, icedqUser);

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateFunctionUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean deleteFunctionUsingExcelData(String deleteFunctions,String sheetName, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;
		int count=0;
		try {
			if (!deleteFunctions.isEmpty()) {

				if (deleteFunctions.contains(",")) {

					functionName = deleteFunctions.split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,sheetName, functionName[i], icedqUser, state);

						searchFunctionNameInClassDetails(fparam.getFunctionName());

						deleteFunction(fparam, i);

						count++;
					}

				} else {

					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,sheetName, deleteFunctions, icedqUser, state);

					searchFunctionNameInClassDetails(fparam.getFunctionName());

					deleteFunction(fparam, 0);

					count++;

				}
				javascript(driver, scrollToElement, functionTabRemoveFunctionButton);
				clickOnButton(driver, functionTabRemoveFunctionButton, deleteContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

					flag=clickOnDeleteFunctionAndValidateToast(flag, count);

				}else {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, "Delete functions");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteFunctionUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateFunctionClassCode(String scriptCode) {
		boolean flag =true;

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			String editorContent = (String) js.executeScript("return monaco.editor.getModels()[0].getValue();");

			flag=stringOutput(scriptCode, editorContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionClassCode :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateFunctionClassCodeOnFullScreen(String scriptCode) {
		boolean flag =true;

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			String editorContent = (String) js.executeScript("return monaco.editor.getModels()[1].getValue();");

			flag=stringOutput(scriptCode, editorContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionClassCodeOnFullScreen :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateFunctionsDetailsInDetailsPage(DataTestingParameters param) {
		boolean flag =true;
		try {

			validateElement(driver, returnElement(functionsDetailsFunctionCheckboxDynamic, dynamicName, param.getFunctionName()), param.getFunctionName(), checkboxContent);

			validateElement(driver, returnElement(functionsDetailsFunctionAvatarDynamic, dynamicName, param.getFunctionName()), param.getFunctionName(), avatarContent);

			validateValueWithActual(driver,returnElement(functionsDetailsFunctionNameDynamic, dynamicName, param.getFunctionName()), functionNameContent, param.getFunctionName(),attributeTextContent);

			validateValueWithActual(driver,returnElement(functionsDetailsFunctionStateDynamic, dynamicName, param.getFunctionName()), stateContent, param.getFunctionState(),attributeTextContent);

			validateValueWithActual(driver,returnElement(functionsDetailsFunctionDescriptionDynamic, dynamicName, param.getFunctionName()), stateContent, param.getFunctionDescription(),attributeTextContent);

			validateValueWithActual(driver,returnElement(functionsDetailsFunctionMethodDynamic, dynamicName, param.getFunctionName()), stateContent, param.getFunctionMethodName(),attributeTextContent);

			validateValueWithActual(driver,returnElement(functionsDetailsFunctionParametersDynamic, dynamicName, param.getFunctionName()), stateContent, param.getFunctionParameters(),attributeTextContent);

			validateValueWithActual(driver,returnElement(functionsDetailsFunctionReturnTypeDynamic, dynamicName, param.getFunctionName()), stateContent, param.getFunctionReturnType(),attributeTextContent);

			verifyVisibilityOfButtons(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, param.getFunctionName()), "Edit", true);

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionsDetailsInDetailsPage :: "+e.toString());
			flag=false;
		}	
		return flag;
	}

	public boolean viewFunctionUsingExcelData(DataTestingParameters param, String icedqUser, boolean state) {
		String [] functionName=null;
		boolean flag =true;

		try {
			if (!param.getFunctionName().isEmpty()) {

				if (param.getFunctionName().contains(",")) {

					functionName = param.getFunctionName().split(",");

					for (int i = 0; i < functionName.length; i++) {

						DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, functionName[i], icedqUser, state);

						BaseSuite.reportLog(hyphenContent+" verifying "+(i+1)+" function in the class : "+fparam.getFunctionName()+" "+hyphenContent);

						searchFunctionNameInClassDetails(fparam.getFunctionName());

						validateFunctionsDetailsInDetailsPage(fparam);

					}

				} else {

					DataTestingParameters fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, state);

					BaseSuite.reportLog(hyphenContent+" verifying function in the class : "+fparam.getFunctionName()+" "+hyphenContent);

					searchFunctionNameInClassDetails(fparam.getFunctionName());

					validateFunctionsDetailsInDetailsPage(fparam);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewFunctionUsingExcelData :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public static String getName(String icedqUser) {
		String name =null;
		switch(icedqUser){

		case"account_owner":
			name="_AO";
			break;
		case"account_contributor":
			name="_AC";
			break;

		case"account_executor":
			name="";
			break;
		case"account_reader":
			name="";
			break;
		case"workspace_owner":
			name="_WO";
			break;
		case"workspace_contributor":
			name="_WC";
			break;
		case"workspace_executor":
			name="";
			break;
		case"workspace_reader":
			name="";
			break;
		default:
			name="";
			break;
		}

		return name; 

	}


	public static DataTestingParameters setFunctionsParameters(String filePath, String sheetName, int rowNumber, String icedqUser, boolean flag) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setClassName(xl.readUsingColName(filePath,sheetName, rowNumber, classNameColumn));
			param.setClassDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "classDescription"));
			param.setClassState(xl.readUsingColName(filePath,sheetName, rowNumber, "classState"));
			param.setClassType(xl.readUsingColName(filePath,sheetName, rowNumber, "classType"));
			param.setFunctionScript(xl.readUsingColName(filePath,sheetName, rowNumber, "script"));
			param.setFunctionName(xl.readUsingColName(filePath,sheetName, rowNumber, functionNameColumn));
			param.setSearchName(xl.readUsingColName(filePath,sheetName, rowNumber, "searchfunction"));
			param.setFunctionAdd(xl.readUsingColName(filePath,sheetName, rowNumber, "addfunction"));
			param.setFunctionUpdate(xl.readUsingColName(filePath,sheetName, rowNumber, "updatefunction"));
			param.setFunctionDelete(xl.readUsingColName(filePath,sheetName, rowNumber, "deletefunction"));

			param.setFullName(xl.readUsingColName(filePath,sheetName, rowNumber, "fullname"));
			param.setUpdatedBy(xl.readUsingColName(filePath,sheetName, rowNumber, "updatedby"));
			param.setLastUpdatedFrom(xl.readUsingColName(filePath,sheetName, rowNumber, "lastupdatedfrom"));
			param.setLastUpdatedTo(xl.readUsingColName(filePath,sheetName, rowNumber, "lastupdatedto"));

			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));

			if (flag) {

				if (!param.getClassName().isEmpty()) {

					param.setClassName(
							xl.readUsingColName(filePath, sheetName, rowNumber, classNameColumn) + getName(icedqUser));
				}
				if (!param.getSearchName().isEmpty()) {

					param.setSearchName(
							xl.readUsingColName(filePath,sheetName, rowNumber, "searchfunction") + getName(icedqUser));
				}
				if (!param.getFunctionScript().isEmpty()) {

					String sc = param.getFunctionScript();

					sc = sc.replaceAll(xl.readUsingColName(filePath, sheetName, rowNumber, classNameColumn),
							param.getClassName());

					param.setFunctionScript(sc);
				} 
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setFunctionsParameters "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setFunctionsParamUsingExcel(String filePath,String sheetName, String user, String icedqUser, boolean flag) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="refColumn";
		try {

			param.setFunctionName(xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,functionNameColumn));
			param.setFunctionDescription(xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,"description"));
			param.setFunctionState(xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,"state"));
			param.setFunctionMethodName(xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,"methodName"));
			param.setFunctionParameters(xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,"parameters"));
			param.setFunctionReturnType(xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,"returnType"));

			if (flag && !param.getFunctionName().isEmpty()) {

				param.setFunctionName(
						xl.readUsingColNameAndCellContains(filePath, sheetName, userNameColumn, user,functionNameColumn) + getName(icedqUser));
			}


		} catch (Exception e) {

			BaseSuite.reportErrorLog("error occurs while setFunctionsParamUsingExcel "+e.toString());
		}
		return param;

	}

	public boolean createClass(DataTestingParameters param, String icedqUser, boolean state) {

		boolean flag =true;

		try {

			flag=clickOnNewClassButton(icedqUser);

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription(), "");

				selectClassType(param.getClassType());

				waitForExecution(1000);

				BaseSuite.reportCodeLog(param.getFunctionScript());

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript(monacoEditorScript, param.getFunctionScript());

				waitForExecution(1000);

				validateFunctionClassCode(param.getFunctionScript());

				flag=clickOnClassSaveButtonAndValidateToast(flag, toastMsgClassCreated);

				if(flag) {

					verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, false);
					verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, true);

					flag=createFunctionUsingExcelData(param,icedqUser, state);
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createClass :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean viewClassAndFunctionDetails(DataTestingParameters param, String icedqUser, boolean state) {

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateNewClassPageAfterCreated(param);

			BaseSuite.reportLog(hyphenContent+" validating functions class code in details page "+hyphenContent);

			validateFunctionClassCode(param.getFunctionScript());

			clickOnButton(driver, functionsDetailsScriptCodeFullScreenIcon, "Full Screen", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(driver, classCodePopupPaneTitle, "Code", attributeTitle);

			verifyVisibilityOfButtons(driver, classCodePopupPaneMinimizeicon, minimizeContent, true);

			verifyVisibilityOfButtons(driver, classCodePopupPaneSavebutton, saveContent, false);

			verifyVisibilityOfButtons(driver, classCodePopupPaneCancelbutton, cancelButtonContent, true);

			BaseSuite.reportLog(hyphenContent+" validating functions class code in full screen pane "+hyphenContent);

			validateFunctionClassCodeOnFullScreen(param.getFunctionScript());

			clickOnButton(driver, classCodePopupPaneMinimizeicon, minimizeContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			viewFunctionUsingExcelData(param, icedqUser, state);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" viewClass :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateMethodsForFunctions(DataTestingParameters param, String icedqUser, boolean state) {
		boolean flag =true;
		try {
			verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, true);

			if(!param.getFunctionAdd().isEmpty()) {
				flag=addFunctionUsingExcelData(param.getFunctionAdd(), icedqUser, state);
			}

			if(!param.getFunctionUpdate().isEmpty()) {
				flag=updateFunctionUsingExcelData(param.getFunctionUpdate(), icedqUser, state);
			}
			if(!param.getFunctionDelete().isEmpty()) {
				flag=deleteFunctionUsingExcelData(param.getFunctionDelete(),updatefunctionSheetName, icedqUser, state);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateMethodsForFunctions :: "+e.toString());
			flag=false;
		}

		return flag;
	}
	public boolean updateClass(DataTestingParameters param, String icedqUser, boolean state) {

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription(), "");

				validateElement(driver,functionsDetailsClassTypeFieldLabel, classTypeContent, attributeTitle);
				validateField(driver, functionsDetailsClassTypeFieldInput, classTypeContent, placeholderClassType, fieldContent, param.getClassType(), attributeTextContent,true);

				waitForExecution(1000);

				BaseSuite.reportCodeLog(param.getFunctionScript());

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript(monacoEditorScript, param.getFunctionScript());

				waitForExecution(1000);

				validateFunctionClassCode(param.getFunctionScript());

				flag=clickOnClassSaveButtonAndValidateToast(flag, "");

				updateMethodsForFunctions(param, icedqUser, state);

			}else {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription(), "");

				flag= clickOnClassSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);

				if(!param.getFunctionAdd().isEmpty()) {

					waitForExecution(2000);
					clickOnAddFunctionButtonAndValidate(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				}

				if(!param.getFunctionUpdate().isEmpty()) {
					flag=updateFunctionUsingExcelData(param.getFunctionName(), icedqUser, state);
				}

				if(!param.getFunctionDelete().isEmpty()) {
					flag=deleteFunctionUsingExcelData(param.getFunctionName(),functionSheetName,  icedqUser, state);
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateClass :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean updateFunctionsAndClass(DataTestingParameters param, String icedqUser, boolean state) {

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				switch(param.getScenarioType().toLowerCase().trim()) {

				case "update":

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
							descriptionContent, placeholderDescription, param.getClassDescription(), "");

					validateElement(driver,functionsDetailsClassTypeFieldLabel, classTypeContent, attributeTitle);
					validateField(driver, functionsDetailsClassTypeFieldInput, classTypeContent, placeholderClassType, fieldContent, param.getClassType(), attributeTextContent,true);

					waitForExecution(1000);

					BaseSuite.reportCodeLog(param.getFunctionScript());

					JavascriptExecutor js = (JavascriptExecutor) driver;

					js.executeScript(monacoEditorScript, param.getFunctionScript());

					waitForExecution(1000);

					validateFunctionClassCode(param.getFunctionScript());

					flag=clickOnClassSaveButtonAndValidateToast(flag, "");

					break;

				case "addfn":
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					flag=addFunctionUsingExcelData(param.getFunctionAdd(), icedqUser, state);

					break;

				case "updatefn":
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					flag=updateFunctionUsingExcelData(param.getFunctionUpdate(), icedqUser, state);

					break;

				case "deletefn":
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					flag=deleteFunctionUsingExcelData(param.getFunctionDelete(),updatefunctionSheetName, icedqUser, state);

					break;

				default:

					break;

				}

			}else {

				switch(param.getScenarioType().toLowerCase().trim()) {

				case "update":

					validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
							descriptionContent, placeholderDescription, param.getClassDescription(), "");

					flag= clickOnClassSaveButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);

					break;

				case "addfn":

					waitForExecution(2000);
					clickOnAddFunctionButtonAndValidate(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);

					break;

				case "updatefn":

					flag=updateFunctionUsingExcelData(param.getFunctionName(), icedqUser, state);

					break;

				case "deletefn":

					flag=deleteFunctionUsingExcelData(param.getFunctionName(),functionSheetName,  icedqUser, state);

					break;

				default:

					break;

				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateFunctionsAndClass :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean addNewFunctionOnListingPage(DataTestingParameters param, String icedqUser, boolean state) {

		boolean flag =true;

		log.info(icedqUser);

		try {
			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				validateFunctionsListingPage();

				searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				getClassTableOnListingPage(param.getClassName());

				getFunctionsTableOnListingPage(param.getClassName());

				flag=createFunctionOnListingUsingExcelData(param, icedqUser, state);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				getClassTableOnListingPage(param.getClassName());

				getFunctionsTableOnListingPage(param.getClassName());

			}else {

				flag= clickOnFunctionButtonOnListingAndValidate(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" addNewFunctionOnListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean selectClassCheckbox(boolean flag, String classname) {

		try {
			By namelocator = returnElement(functionsListingFunctionNameDynamic, dynamicName, classname);
			By checkboxlocator = returnElement(functionsListingFunctionCheckboxDynamic, dynamicName, classname);

			isDisplayedInLoop(driver, 3, namelocator);

			if(isDisplayed(driver, namelocator)) {

				BaseSuite.reportLog("Class name is visible as "+classname);

				if(isDisplayed(driver, checkboxlocator)) {

					BaseSuite.reportLog("Class name checkbox is visible");

					flag=selectcheckbox(driver, checkboxlocator, classname);

				}else {
					BaseSuite.reportFailLog("Class name checkbox is not visible "+classname, "selectClassCheckbox");
				}
			}else {
				BaseSuite.reportFailLog("Class name is not visible", "selectClassCheckbox");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectClassCheckbox "+e.toString());
		}
		return flag;
	}

	public void clickOnCopyToClipboard() {
		isDisplayedInLoop(driver, 3, functionsListingBulkDeleteLogsCopytoclipboard);
		if(isDisplayed(driver, functionsListingBulkDeleteLogsCopytoclipboard)) {

			clickOnButton(driver, functionsListingBulkDeleteLogsCopytoclipboard, "Copy to clipboard", true);

			captureToastMsgWithOutWait(driver,toastMsg, toastMsgClosedBtn, "Copied to clipboard.", attributeAriaLabel);

		}else {
			BaseSuite.reportFailLog("Copy to clipboard icon not visible", "clickOnCopyToClipboard");
		}

	}
	
	public void validateProgressBarOfFunctions() {
		
		try {
			
			BaseSuite.reportLog("-------------- checking bulk changes logs... ");

			String progCon = getAttribute(driver, functionsListingBulkDeleteLogslog, attributeInnerText);
			
			if(!progCon.isEmpty()) {

				String [] bulklog = progCon.split("\n");

				for(int i=0;i<bulklog.length;i++) {

					BaseSuite.reportLog(bulklog[i]);

				}

			}else {

				clickOnButton(driver, functionsListingBulkDeleteLogsRefresh, refreshContent, true);

				String progConq = getAttribute(driver, functionsListingBulkDeleteLogslog, attributeInnerText);

				if(!progConq.isEmpty()) {

					String [] bulklog = progConq.split("\n");

					for(int i=0;i<bulklog.length;i++) {

						BaseSuite.reportLog(bulklog[i]);

					}

				}else {

					BaseSuite.reportFailLog("Progress logs not visible, https://icedqsoft.atlassian.net/browse/DAT-7343", "validateBulkDeleteSideBar");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateProgressBarOfFunctions "+e.toString());
		}
	}

	public boolean validateBulkDeleteSideBar(int count) {

		boolean flag =true;
		String excont="";
		By locator1=null;
		By locator2=null;
		String title="";
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(3000);
			if(count==1) {
				excont="You will be deleting 1 class.";
				locator1 = functionsListingBulkSingleDeleteTitle;
				locator2 = functionsListingBulkSingleDeleteDiscard;
				title="Delete Class";
			}else if(count>1) {
				excont="You will be deleting "+count+" classes.";
				locator1 = functionsListingBulkDeleteTitle;
				locator2 = functionsListingBulkDeleteDiscard;
				title="Delete Classes";
			}

			isDisplayedInLoop(driver, 2, locator1);

			if(isDisplayed(driver, locator1)) {

				validateElement(driver, locator1, title, attributeTitle);

				validateElement(driver, locator2, discardContent, "icon");

				validateElement(driver, functionsListingBulkDeleteWarningIcon, "Warning", "icon");

				verifyVisibilityOfButtons(driver, functionsListingBulkDeleteButtonCancel, cancelButtonContent, true);

				verifyVisibilityOfButtons(driver, functionsListingBulkDeleteButtonDelete, deleteContent, true);

				String content = getValue(driver, functionsListingBulkDeleteContent);

				flag=stringOutput(content, excont, true);

				clickOnButton(driver, functionsListingBulkDeleteButtonDelete, deleteContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateElement(driver, functionsListingBulkDeleteLogsLabel, "Logs:", labelContent);

				validateElement(driver, functionsListingBulkDeleteLogsRefresh, refreshContent, "icon");

				clickOnButton(driver, functionsListingBulkDeleteLogsRefresh, refreshContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(2000);

				validateProgressBarOfFunctions();

				clickOnCopyToClipboard();

				clickOnButton(driver, functionsListingBulkDeleteLogsDoneButton, "Done", true);
			}else {
				BaseSuite.reportFailLog("Title not visible, "+locator1, "validateBulkDeleteSideBar");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, errorLogTitle+" validateBulkDeleteSideBar "+e.toString());
			flag =false;
		}

		return flag;
	}

	public boolean deleteFunctionValid(DataTestingParameters param, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;
		int numberOfClass=1;
		log.info(icedqUser);
		try {

			if(param.getClassName().contains(",")) {

				iceuserName= param.getClassName().split(","); 

				numberOfClass = iceuserName.length;

				for(int i=0;i<iceuserName.length;i++) {
					String suffix = getName(icedqUser);

					if(!iceuserName[i].endsWith(suffix)) {
						iceuserName[i]=iceuserName[i]+getName(icedqUser);
					}

					flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, iceuserName[i]);

					selectClassCheckbox(flag, iceuserName[i]);

					/**	searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, "");*/

				}

			}else {

				numberOfClass = 1;

				searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassName());

				selectClassCheckbox(flag, param.getClassName());

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, "");

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				waitForExecution(2000);

				flag=clickOnButton(driver, functionsListingButtonDelete, deleteContent, true);

				validateBulkDeleteSideBar(numberOfClass);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}else {
				flag=clickOnDeleteClassButtonAndValidate(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteFunctionValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean deleteClassFromDetailsPage(DataTestingParameters param, String icedqUser) {

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				flag= clickOnButton(driver, functionsDetailsDeleteButton, deleteContent, true);

				if(flag) {

					validatePopupWindowContent(driver, flag, classPopupDeleteTitle, classPopupDeleteContent, classDeletePopupTitle, classDeletePopupContent);

					verifyVisibilityOfButtons(driver, classPopupDeleteCancel, cancelButtonContent, true);

					flag=clickOnDeleteClassAndValidateToast(toastMsgClassDeleted);
				}

				clickOnFunctionsTab();

				searchFunctionalityMethod(driver, true, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getSearchName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(elementNotVisible(driver, returnElement(functionsListingFunctionNameDynamic, dynamicName, param.getSearchName()))) {

					BaseSuite.validationReportLog("Class name not found on listing page.");

				}else {
					BaseSuite.reportFailLog(param.getSearchName()+" Class is visible on listing page.", "deleteClass");
					flag=false;
				}

				searchFunctionalityMethod(driver, true, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, "");

			}else {
				flag= clickOnDeleteClassDetailspageButtonAndValidate(ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" deleteClassFromDetailsPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void selectUncheckbox(By locator, String label) {

		isDisplayedInLoop(driver, 2, locator);

		if(isDisplayed(driver, locator)) {

			String acs=getAttribute(driver,locator, attributeClass);

			if(acs.contains("e-check") && !acs.contains("e-uncheck")) {
				BaseSuite.reportLog("checkbox is visible as selected for "+label);
				BaseSuite.reportLog("Clicking on checkbox "+label);

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label+" checkbox is unchecked");
			}else if(acs.contains("e-stop")){
				BaseSuite.reportLog("checkbox is visible as stop sign for "+label);
				BaseSuite.reportLog("Clicking on checkbox "+label);

				displayAndClick(driver, locator);
				waitForExecution(2000);
				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label+" checkbox is unchecked");

			}else if(acs.contains("e-uncheck")){

				BaseSuite.reportLog(label+" type is checkbox already unchecked");
			}
		}
	}

	public boolean validateNSelectUpdatedByUserInAdvanceSearch(boolean flag, String userNAme,String fullName,boolean checkstatus) {
		ParametersServicePage ps = new ParametersServicePage(driver);
		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchUpdatedByLabel, "Updated By");

				if(isDisplayed(driver, advancedSearchUpdatedByExpand)) {

					displayAndClick(driver, advancedSearchUpdatedByExpand);
				}

				if(!userNAme.isEmpty()) {

					ps.searchUser(advancedSearchUpdatedBySearchBar, userNAme);

					By locator = returnElement(advanceSearchUpdatedByCheckbox, dynamicName, fullName);

					isDisplayedInLoop(driver, 4, locator);

					if(isDisplayed(driver, locator)) {
						if(checkstatus) {

							ps.selectcheckbox(locator, userNAme);

							waitForExecution(2000);
							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							validateElement(driver, returnElement(updatedbynameOnListing, dynamicName, fullName), fullName, iconContent);
						}else {
							selectUncheckbox(locator, userNAme);
							waitForExecution(2000);
							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						}
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog(userNAme+" User not found kindly check", "validateNSelectUpdatedByUserInAdvanceSearch");
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNSelectUpdatedByUserInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	//validate and select last updated dates in advanced search
	public boolean validateNSelectLastUpdatedInAdvanceSearch(boolean flag, String startDate, String endDate) {
		WorkflowPage wp = new WorkflowPage(driver);
		try {
			if(flag) {
				javascript(driver, scrollToElementArg, advancedSearchLastUpdatedLabel);

				verifyIndividualLabel(driver, advancedSearchLastUpdatedLabel, "Last Updated");

				if(isDisplayed(driver, advancedSearchLastUpdatedExpand)) {

					displayAndClick(driver, advancedSearchLastUpdatedExpand);
				}

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
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNSelectLastUpdatedInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void printlist(By locator, String label , String attribute) {
		List<WebElement> types = getElements(driver, locator);

		for(int i =0;i<types.size();i++) {

			String typename = types.get(i).getAttribute(attribute);

			BaseSuite.reportLog(typename+" "+label+" is visible");

		}
	}

	public boolean validateNSelectFunctionsTypeInAdvanceSearch(boolean flag, String typeValue,boolean checkstatus) {
		ParametersServicePage ps = new ParametersServicePage(driver);
		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchTypeLabel, "Type");

				if(isDisplayed(driver, advancedSearchTypeExpand)) {

					displayAndClick(driver, advancedSearchTypeExpand);
				}

				printlist(advancedSearchTypeList, "type", attributeTextContent);

				if(!typeValue.isEmpty()) {

					By locator = returnElement(advancedSearchTypeCheckboxDynamic, dynamicName, typeValue);

					isDisplayedInLoop(driver, 3, locator);

					if(isDisplayed(driver, locator)) {

						if(checkstatus) {

							ps.selectcheckbox(locator, typeValue);

							waitForExecution(1000);

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							validateIsDisplayedOrNot(driver, returnElement(functionListingTypeDynamicCheck, dynamicName, typeValue), typeValue+iconContent+" on listing page ", true);


						}else {

							selectUncheckbox(locator, typeValue);
						}

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog(typeValue+" type not found kindly check", "validateNSelectFunctionsTypeInAdvanceSearch");
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNSelectFunctionsTypeInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateNSelectFunctionsStateInAdvanceSearch(boolean flag, String typeValue,boolean checkstatus) {
		ParametersServicePage ps = new ParametersServicePage(driver);
		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchStateLabel, "State");

				if(isDisplayed(driver, advancedSearchStateExpand)) {

					displayAndClick(driver, advancedSearchStateExpand);
				}

				printlist(advancedSearchStateList, "type", attributeTextContent);

				if(!typeValue.isEmpty()) {

					By locator = returnElement(advancedSearchStateCheckboxDynamic, dynamicName, typeValue);

					isDisplayedInLoop(driver, 3, locator);

					if(isDisplayed(driver, locator)) {

						if(checkstatus) {

							ps.selectcheckbox(locator, typeValue);

							waitForExecution(1000);

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							validateIsDisplayedOrNot(driver, returnElement(functionListingStateDynamicCheck, dynamicName, typeValue), typeValue+iconContent+" on listing page ", true);


						}else {

							selectUncheckbox(locator, typeValue);
						}

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog(typeValue+" type not found kindly check", "validateNSelectFunctionsStateInAdvanceSearch");
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateNSelectFunctionsStateInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean updatedBySection(String updatedBy, String fullName) {
		boolean flag=true;
		try {
			if(updatedBy.contains(",")) {

				String [] userN = updatedBy.split(",");
				String [] fN = fullName.split(",");

				for(int i=0;i<userN.length;i++) {

					flag=validateNSelectUpdatedByUserInAdvanceSearch(flag, userN[i],fN[i], true);
				}
			}else {

				flag=validateNSelectUpdatedByUserInAdvanceSearch(flag, updatedBy,fullName, true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updatedBySection :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean classTypeSection(String classtype) {
		boolean flag=true;
		try {
			if(classtype.contains(",")) {

				String [] type = classtype.split(",");

				for(int i=0;i<type.length;i++) {

					flag=validateNSelectFunctionsTypeInAdvanceSearch(flag, type[i],true);

					flag=validateNSelectFunctionsTypeInAdvanceSearch(flag, type[i],false);
				}

			}else {

				flag=validateNSelectFunctionsTypeInAdvanceSearch(flag, classtype,true);

				flag=validateNSelectFunctionsTypeInAdvanceSearch(flag, classtype,false);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" classTypeSection :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean classStateSection(String classState) {
		boolean flag=true;
		try {

			if(classState.contains(",")) {


				String [] state = classState.split(",");

				for(int i=0;i<state.length;i++) {

					flag=validateNSelectFunctionsStateInAdvanceSearch(flag, state[i],true);

					flag=validateNSelectFunctionsStateInAdvanceSearch(flag, state[i],false);
				}
			}else {
				flag=validateNSelectFunctionsStateInAdvanceSearch(flag, classState,true);

				flag=validateNSelectFunctionsStateInAdvanceSearch(flag, classState,false);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" classStateSection :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean advancedSearchFunctionalityForFunctions(DataTestingParameters param, String scenarioType) {

		boolean flag =true;

		try {

			verifyIndividualLabel(driver, functionsAdvancedSearchTitle, advanceSearchContent);

			isDisplayedInLoop(driver, 3, advancedSearchAppliedFilerCrossIcon);

			if(isDisplayed(driver, advancedSearchAppliedFilerCrossIcon)) {

				displayAndClick(driver, advancedSearchAppliedFilerCrossIcon);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			switch(scenarioType.toLowerCase()) {

			case "updatedby":

				flag=updatedBySection(param.getUpdatedBy(), param.getFullName());

				break;

			case "lastupdated":

				flag=validateNSelectLastUpdatedInAdvanceSearch(flag, param.getLastUpdatedFrom(), param.getLastUpdatedTo());

				break;

			case "type":

				flag=classTypeSection(param.getClassType());

				break;

			case "state":

				flag=classStateSection(param.getClassState());

				break;

			default:

				break;
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" advancedSearchFunctionalityForFunctions :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean discardFunctionalityCheckForFunctions(DataTestingParameters param,DataTestingParameters upparam, String scenarioType, String icedqUser) {

		boolean flag =true;
		boolean state =true;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			switch(scenarioType.toLowerCase()) {

			case "createfun":

				flag=clickOnNewClassButton(icedqUser);

				if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
							descriptionContent, placeholderDescription, param.getClassDescription(), "");

					selectClassType(param.getClassType());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					BaseSuite.reportCodeLog(param.getFunctionScript());

					js.executeScript(monacoEditorScript, param.getFunctionScript());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validateFunctionClassCode(param.getFunctionScript());

					flag= clickOnButton(driver, functionsDetailsDiscardButton, discardContent, true);

					validatePopupWindowContent(driver, flag, classPopupDiscardTitle, classPopupDiscardContent, classDiscardPopupTitle, classDiscardPopupContent);

					verifyVisibilityOfButtons(driver, classPopupDiscardCancel, cancelButtonContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					clickOnButton(driver, classPopupDiscardButton, discardContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=validateNewClassPageBeforeCreating();

				}

				break;
			case "updatefun":

				state=searchClassNameAndClickOnClassName(param.getSearchName());

				if (state) {

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(3000);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
							descriptionContent, placeholderDescription, upparam.getClassDescription(), "");

					validateElement(driver,functionsDetailsClassTypeFieldLabel, classTypeContent, attributeTitle);
					validateField(driver, functionsDetailsClassTypeFieldInput, classTypeContent, placeholderClassType, fieldContent, upparam.getClassType(), attributeTextContent,true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					BaseSuite.reportCodeLog(upparam.getFunctionScript());

					js.executeScript(monacoEditorScript, upparam.getFunctionScript());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validateFunctionClassCode(upparam.getFunctionScript());

					flag= clickOnButton(driver, functionsDetailsDiscardButton, discardContent, true);

					validatePopupWindowContent(driver, flag, classPopupDiscardTitle, classPopupDiscardContent, classDiscardPopupTitle, classDiscardPopupContent);

					verifyVisibilityOfButtons(driver, classPopupDiscardCancel, cancelButtonContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					clickOnButton(driver, classPopupDiscardButton, discardContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=validateNewClassPageAfterCreated(param);
				}

				break;

			default:

				break;
			}

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e, errorLogTitle+" discardFunctionalityCheckForFunctions :: "+e.toString());
			flag=false;

		}

		return flag;
	}

	public boolean searchFunctionalityCheckForClassFromListing(DataTestingParameters param, String icedqUser) {
		boolean flag =true;
		log.info(icedqUser);
		int count =1;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			switch(param.getScenarioType().trim().toLowerCase()) {

			case "fn_classname":

				flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassName());

				List<WebElement> classes = getElements(driver, functionsListingClassNameList);

				BaseSuite.reportLog("# of classes found : "+classes.size());

				for(WebElement cname :  classes) {

					BaseSuite.reportLog("verifying class : "+ count);

					String className = cname.getAttribute(attributeTextContent);

					flag=stringContainsOutput(className, param.getClassName(), true);

					count++;
				}

				break;

			case "fn_classdesc":

				flag=searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, param.getClassDescription());

				List<WebElement> descs = getElements(driver, functionsListingClassDescList);

				BaseSuite.reportLog("# of classes found : "+descs.size());

				for(WebElement cdesc :  descs) {

					BaseSuite.reportLog("verifying class description : "+ count);

					String classdesc = cdesc.getAttribute(attributeTextContent);

					flag=stringContainsOutput(classdesc, param.getClassDescription(), true);

					count++;
				}

				break;

			default:

				break;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			searchFunctionalityMethod(driver, flag, functionsListingSearchFunctionField, functionsListingSearchFunctionButton, placeholderSearch, placeholderSearch, "");
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" searchFunctionalityCheckForClassFromListing :: "+e.toString());
			flag=false;
		}

		return flag;
	}



	public boolean createClassWithInvalidScript(DataTestingParameters param, String icedqUser) {

		boolean flag =true;

		try {

			flag=clickOnNewClassButton(icedqUser);

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription(), "");

				selectClassType(param.getClassType());

				waitForExecution(1000);

				BaseSuite.reportCodeLog(param.getFunctionScript());

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript(monacoEditorScript, param.getFunctionScript());

				waitForExecution(1000);

				validateFunctionClassCode(param.getFunctionScript());

				flag=clickOnClassSaveButtonAndValidateToastInvalid(flag, "");

				verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, true);
				verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, true);

				String classstate = getAttribute(driver, functionsDetailsClassState, attributeTitle);

				stringOutput(classstate, param.getClassState(), true);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createClassWithInvalidScript :: "+e.toString());
			flag=false;
		}

		return flag;
	}


	public boolean createScenarioOfFunctionsForInvalidInputs(DataTestingParameters param, String icedqUser) {

		boolean flag =true;

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			DataTestingParameters fparam =null;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			switch(param.getScenarioType().toLowerCase()+1) {

			case "classname1":

				flag=createClassWithInvalidScript(param, icedqUser);

				break;

			case "classdesc1":

				clickOnNewClassButton(icedqUser);

				flag=enterValueToFieldForInvalidDetails(driver, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, param.getClassDescription(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsDetailsSaveButton, saveContent, false);

				break;

			case "fn_name1":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  Adding invalid function to the class :  "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				flag=enterValueToFieldForInvalidDetails(driver, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, fparam.getFunctionName(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "fn_desc1":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" Adding invalid function to the class :: "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				flag=enterValueToFieldForInvalidDetails(driver,  functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, fparam.getFunctionDescription(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "existfunction1":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  Adding invalid function to the class :  "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, placeholderFunctionAlias, fparam.getFunctionName(), "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodName(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(content1+fparam.getFunctionName()+content2);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "addfunc1":

				String timeStamp = new SimpleDateFormat(timeFormat).format(new Date());// time stamp

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  Adding  invalid function to the class : "+fparam.getFunctionName()+"_"+timeStamp+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, placeholderFunctionAlias, fparam.getFunctionName()+"_"+timeStamp, "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodName(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(param.getToastValidationMessage());

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "existclass1":

				clickOnNewClassButton(icedqUser);

				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription(), "");

				selectClassType(param.getClassType());

				waitForExecution(1000);

				BaseSuite.reportCodeLog(param.getFunctionScript());

				js.executeScript(monacoEditorScript, param.getFunctionScript());

				waitForExecution(1000);

				validateFunctionClassCode(param.getFunctionScript());

				flag=clickOnClassSaveButtonAndValidateToast(flag, "Class name '"+param.getClassName()+content2);

				break;

			default:

				break;
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createScenarioOfFunctionsForInvalidInputs :: "+e.toString());
			flag=false;

		}

		return flag;
	}
/**
	public boolean updateScenarioOfFunctionsForInvalidInputs(DataTestingParameters param, String icedqUser) {

		boolean flag =true;

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			DataTestingParameters fparam =null;
			DataTestingParameters sparam =null;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(3000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			switch(param.getScenarioType().toLowerCase()) {

			case "classname":

				String timeStamp1 = new SimpleDateFormat(timeFormat).format(new Date());// time stamp

				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription()+" "+timeStamp1, "");

				BaseSuite.reportCodeLog(param.getFunctionScript());

				js.executeScript(monacoEditorScript, param.getFunctionScript());

				waitForExecution(1000);

				validateFunctionClassCode(param.getFunctionScript());

				flag=clickOnClassSaveButtonAndValidateToastInvalid(flag, "");

				verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, true);
				verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, true);

				String classstate = getAttribute(driver, functionsDetailsClassState, attributeTitle);

				stringOutput(classstate, param.getClassState(), true);

				break;

			case "classdesc":

				flag=enterValueToFieldForInvalidDetails(driver, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, param.getClassDescription(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsDetailsSaveButton, saveContent, false);

				break;

			case "fn_name":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" Adding invalid function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				flag=enterValueToFieldForInvalidDetails(driver, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, fparam.getFunctionName(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "fn_desc":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" Adding invalid function description to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				flag=enterValueToFieldForInvalidDetails(driver,  functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, fparam.getFunctionDescription(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "existfunction":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  Adding invalid function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, placeholderFunctionAlias, fparam.getFunctionName(), "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodName(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(content1+fparam.getFunctionName()+content2);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "addfunc":

				String timeStamp = new SimpleDateFormat(timeFormat).format(new Date());// time stamp

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  Adding invalid function to the class : "+fparam.getFunctionName()+"_"+timeStamp+" "+hyphenContent);

				clickOnAddFunctionButtonAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebar("fn_", "", "", "", defaultReturnType,1);}

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, placeholderFunctionAlias, fparam.getFunctionName()+"_"+timeStamp, "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodName(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(param.getToastValidationMessage());

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "existclass":

				validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel, functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation, 
						descriptionContent, placeholderDescription, param.getClassDescription(), "");

				waitForExecution(1000);

				BaseSuite.reportCodeLog(param.getFunctionScript());

				js.executeScript(monacoEditorScript, param.getFunctionScript());

				waitForExecution(1000);

				validateFunctionClassCode(param.getFunctionScript());

				flag=clickOnClassSaveButtonAndValidateToast(flag, "Class name '"+param.getClassName()+content2);

				break;

			case "up_fn_name":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);
				sparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getSearchName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" updating invalid function to the class : "+sparam.getFunctionName()+" "+hyphenContent);

				searchFunctionNameInClassDetails(sparam.getFunctionName());

				javascript(driver, scrollToElement, functionTabAddFunctionButton);

				clickOnButton(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, sparam.getFunctionName()), sparam.getFunctionName()+editContent, true);

				waitForExecution(1000);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=enterValueToFieldForInvalidDetails(driver, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, fparam.getFunctionName(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "up_fn_desc":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);
				sparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getSearchName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" updating invalid function description to the class : "+param.getSearchName()+" "+hyphenContent);

				searchFunctionNameInClassDetails(sparam.getFunctionName());

				javascript(driver, scrollToElement, functionTabAddFunctionButton);

				clickOnButton(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, sparam.getFunctionName()), sparam.getFunctionName()+editContent, true);

				waitForExecution(1000);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=enterValueToFieldForInvalidDetails(driver,  functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, fparam.getFunctionDescription(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "up_existfunction":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);
				sparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getSearchName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  updating invalid function as existing name to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				searchFunctionNameInClassDetails(sparam.getFunctionName());

				javascript(driver, scrollToElement, functionTabAddFunctionButton);

				clickOnButton(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, sparam.getFunctionName()), sparam.getFunctionName()+editContent, true);

				waitForExecution(1000);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, placeholderFunctionAlias, fparam.getFunctionName(), "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodName(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(content1+fparam.getFunctionName()+content2);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "up_addfunc":

				String stimeStamp = new SimpleDateFormat(timeFormat).format(new Date());// time stamp

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);
				sparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getSearchName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  updating invalid function with same method to the class : "+fparam.getFunctionName()+"_"+stimeStamp+" "+hyphenContent);

				searchFunctionNameInClassDetails(sparam.getFunctionName());

				javascript(driver, scrollToElement, functionTabAddFunctionButton);

				clickOnButton(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, sparam.getFunctionName()), sparam.getFunctionName()+editContent, true);

				waitForExecution(1000);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						functionAliasContent, placeholderFunctionAlias, fparam.getFunctionName()+"_"+stimeStamp, "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodName(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(param.getToastValidationMessage());

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			default:

				break;
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" updateScenarioOfFunctionsForInvalidInputs :: "+e.toString());
			flag=false;

		}

		return flag;
	}
*/
	public boolean createFunctionScenarioForInvalidInputs(DataTestingParameters param, String icedqUser) {

		boolean flag =true;

		try {

			DataTestingParameters fparam =null;

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			switch(param.getScenarioType().toLowerCase()) {

			case "fn_name":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" create invalid function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnFunctionButtonOnListingAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebarOnListing("","fn_", "", "", "", "");}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=enterValueToFieldForInvalidDetails(driver,  functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						descriptionContent, fparam.getFunctionName(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "fn_desc":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+" create invalid function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnFunctionButtonOnListingAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebarOnListing("","fn_", "", "", "", "");}

				flag=enterValueToFieldForInvalidDetails(driver,  functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent,  fparam.getFunctionDescription(), param.getFieldValidationMessage());

				verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton, saveContent, false);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "existfunction":

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  create invalid function to the class : "+fparam.getFunctionName()+" "+hyphenContent);

				clickOnFunctionButtonOnListingAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebarOnListing("","fn_", "", "", "", "");}

				selectClassNameOnListing(param.getClassName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						descriptionContent, placeholderFunctionAlias, fparam.getFunctionName(), "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);

				selectMethodNameOnListing(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(content1+fparam.getFunctionName()+content2);

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			case "addfunc":

				String timeStamp = new SimpleDateFormat(timeFormat).format(new Date());// time stamp

				fparam = setFunctionsParamUsingExcel(functionsTestData,functionSheetName, param.getFunctionName(), icedqUser, false);

				BaseSuite.reportLog(hyphenContent+"  create invalid function to the class : "+fparam.getFunctionName()+"_"+timeStamp+" "+hyphenContent);

				clickOnFunctionButtonOnListingAndValidate("");

				if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateFunctionSidebarOnListing("","fn_", "", "", "", "");}

				selectClassNameOnListing(param.getClassName());

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation, 
						descriptionContent, placeholderFunctionAlias, fparam.getFunctionName()+"_"+timeStamp, "");

				validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation, 
						descriptionContent, placeholderDescription, fparam.getFunctionDescription(), "");

				validateElement(driver,functionsSidebarAddFunctionMethodLabel, methodNameContent, labelContent);
				selectMethodNameOnListing(fparam.getFunctionMethodName());

				validateElement(driver,functionsSidebarAddFunctionParameterLabel, parametersContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent, fparam.getFunctionParameters(), attributeValue,false);

				validateElement(driver,functionsSidebarAddFunctionReturnTypeLabel, returnTypeContent, labelContent);
				validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent, fparam.getFunctionReturnType(), attributeValue,false);

				flag=clickOnSaveButtonToAddFunctionAndValidate(param.getToastValidationMessage());

				clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);

				break;

			default:

				break;
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" createFunctionScenarioForInvalidInputs :: "+e.toString());
			flag=false;

		}

		return flag;
	}

	public boolean clickOnFullScreenIconOfCode(boolean isSaveEnable) {

		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= clickOnButton(driver, functionsDetailsScriptCodeFullScreenIcon, "Full Screen", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateElement(driver, classCodePopupPaneTitle, "Code", attributeTitle);

			verifyVisibilityOfButtons(driver, classCodePopupPaneMinimizeicon, minimizeContent, true);

			verifyVisibilityOfButtons(driver, classCodePopupPaneSavebutton, saveContent, isSaveEnable);

			verifyVisibilityOfButtons(driver, classCodePopupPaneCancelbutton, cancelButtonContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickOnFullScreenIconOfCode :: "+e.toString());
			flag=false;
		}


		return flag;
	}

	public boolean validateFunctionsNavigationFunctionality(String functionName, String icedqUser) {

		boolean flag =true;

		try {

			validateFunctionsBreadcrumbLinkNavigation(icedqUser);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName,rulesContent), returnElement(modulePageTitle, dynamicName,rulesContent), rulesContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, functionsContent), returnElement(modulePageTitle, dynamicName, functionsContent), functionsContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, workflowsContent), returnElement(modulePageTitle, dynamicName, workflowsContent), workflowsContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, instancesContent), returnElement(modulePageTitle, dynamicName, instancesContent), instancesContent, subModuleContent);

			navigateToDataTestingTabs(nextgenTabDashboardandReporting, breadcrumbDashboardAndReporting, "Dashboard", moduleContent);

			/**navigateToDataTestingTabs(nextgenTabDataTesting,  returnElement(modulePageTitle, dynamicName, rulesContent), dataTestingContent, moduleContent);*/

			navigateToDataTestingTabs(nextgenTabScheduler,  returnElement(modulePageTitle, dynamicName, "Schedules"), schedulerContent, moduleContent);

			navigateToDataTestingTabs(nextgenTabConnector, returnElement(modulePageTitle, dynamicName, connectionsContent), "Connectors", moduleContent);

			navigateToDataTestingTabs(nextgenTabAdmin, moduleUserPageTitle, "Administration", moduleContent);
			
			validateFunctionsBreadcrumbLinkNavigationForExistingFunctions(functionName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionsNavigationFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void validateFunctionsBreadcrumbLinkNavigation(String icedqUser ) {
		HomePage hp=new HomePage(driver);
		try {

			BaseSuite.reportLog("Validating Hyperlink of breadcrumb while creating new class/functions");
			
			clickOnNewClassButton(icedqUser);

			validateNewClassPageBeforeCreating();

			BaseSuite.reportLog("Navigating to Functions link on breadcrumb");

			clickOnBreadcrumbLink(functionsContent);

			clickOnNewClassButton(icedqUser);

			validateNewClassPageBeforeCreating();

			BaseSuite.reportLog("Navigating to data testing link on breadcrumb");

			clickOnBreadcrumbLink(dataTestingContent);

			clickOnFunctionsTab();

			clickOnNewClassButton(icedqUser);

			validateNewClassPageBeforeCreating();

			BaseSuite.reportLog("Navigating to home link on breadcrumb ");

			clickOnBreadcrumbLink("Home");

			hp.clickOnDataTestingTab();
			
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
			
			waitForExecution(2000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnFunctionsTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionsBreadcrumbLinkNavigation :: "+e.toString());
		}
	}

	public void navigateToDataTestingTabs(By linklocator, By validateLocator, String label, String type) {

		try {
			navigateToLink(driver,linklocator, validateLocator, label+" "+type);

			clickOnButton(driver, nextgenTabDataTesting, dataTestingContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnFunctionsTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" navigateToDataTestingTabs :: "+e.toString());
		}

	}

	public void dataTesting() {

		isDisplayedInLoop(driver,2,dataTesting);
		if(isDisplayed(driver, dataTesting)) {
			displayAndClick(driver,dataTesting);
			BaseSuite.validationReportLog("Clicked on the Data Testing service!!");

		}

	}

	public void clickOnBreadcrumbLink(String link) {

		switch(link.toLowerCase().trim()) {

		case "home":

			clickOnButton(driver, functionsBreadCrumbHomeLink, "Home", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			waitForExecution(1000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 5, welcomeText);

			if(isDisplayed(driver, welcomeText)) {

				String name = getText(driver, welcomeText);

				BaseSuite.reportLog("Home page is visible"+name);

			}else {
				BaseSuite.reportFailLog("Home page not visible", "clickOnBreadcrumbLink");
			}

			break;

		case "data testing":

			clickOnButton(driver, functionsBreadCrumbDataTestingLink, dataTestingContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			waitForExecution(1000);

			validateTitle(driver, returnElement(modulePageTitle, dynamicName,rulesContent), rulesContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			break;	

		case "functions":

			clickOnButton(driver, functionsBreadCrumbFunctionsLink, functionsContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateTitle(driver, returnElement(modulePageTitle, dynamicName,functionsContent), functionsContent);


			break;	

		default:

			break;
		}
	}
	
	public void validateFunctionsBreadcrumbLinkNavigationForExistingFunctions(String functionClassName) {
		HomePage hp=new HomePage(driver);
		try {
			
			BaseSuite.reportLog("Validating Hyperlink of breadcrumb for existing class/functions");
			
			searchClassNameAndClickOnClassName(functionClassName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		
			BaseSuite.reportLog("Navigating to Functions link on breadcrumb");

			clickOnBreadcrumbLink(functionsContent);
			
			searchClassNameAndClickOnClassName(functionClassName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			BaseSuite.reportLog("Navigating to data testing link on breadcrumb");

			clickOnBreadcrumbLink(dataTestingContent);

			clickOnFunctionsTab();

			searchClassNameAndClickOnClassName(functionClassName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Navigating to home link on breadcrumb ");

			clickOnBreadcrumbLink("Home");

			hp.clickOnDataTestingTab();
			
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
			
			waitForExecution(2000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnFunctionsTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" validateFunctionsBreadcrumbLinkNavigation :: "+e.toString());
		}
	}
	
	public boolean updateScenarioOfFunctionsForInvalidInputs(DataTestingParameters param, String icedqUser) {
	    boolean flag = true;
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        DataTestingParameters fparam = null;
	        DataTestingParameters sparam = null;

	        waitUntilNotDisplayed(dataTSpinner, Constant.ruleWait);
	        waitForExecution(3000);
	        waitUntilNotDisplayed(dataTSpinner, Constant.ruleWait);

	        String scenario = param.getScenarioType().toLowerCase();
	        String timeStamp = new SimpleDateFormat(timeFormat).format(new Date());

	        switch (scenario) {
	            case "classname":
	                enterClassDescription(param.getClassDescription(), timeStamp);
	                logAndExecuteScript(param.getFunctionScript(), js);
	                validateFunctionClassCode(param.getFunctionScript());
	                flag = clickOnClassSaveButtonAndValidateToastInvalid(flag, "");
	                validateClassButtonsAndState(param.getClassState());
	                break;

	            case "classdesc":
	                flag = enterInvalidField(functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation,
	                        descriptionContent, param.getClassDescription(), param.getFieldValidationMessage());
	                verifySaveButtonNotVisible(functionsDetailsSaveButton);
	                break;

	            case "fn_name":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                BaseSuite.reportLog("Adding invalid function to the class : " + fparam.getFunctionName());
	                addFunctionAndValidateAlias(fparam.getFunctionName(), param.getFieldValidationMessage());
	                break;

	            case "fn_desc":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                BaseSuite.reportLog("Adding invalid function description to the class : " + fparam.getFunctionName());
	                addFunctionAndValidateDescription(fparam.getFunctionDescription(), param.getFieldValidationMessage());
	                break;

	            case "existfunction":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                BaseSuite.reportLog("Adding existing function to the class : " + fparam.getFunctionName());
	                flag = fillCompleteFunctionForm(fparam);
	                break;

	            case "addfunc":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                BaseSuite.reportLog("Adding function with invalid params: " + fparam.getFunctionName() + "_" + timeStamp);
	                fparam.setFunctionName(fparam.getFunctionName() + "_" + timeStamp);
	                flag = fillCompleteFunctionForm(fparam, param.getToastValidationMessage());
	                break;

	            case "existclass":
	                enterClassDescription(param.getClassDescription(), null);
	                logAndExecuteScript(param.getFunctionScript(), js);
	                validateFunctionClassCode(param.getFunctionScript());
	                flag = clickOnClassSaveButtonAndValidateToast(flag, "Class name '" + param.getClassName() + content2);
	                break;

	            case "up_fn_name":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                sparam = fetchFunctionParam(param.getSearchName(), icedqUser);
	                editFunctionAlias(sparam.getFunctionName(), fparam.getFunctionName(), param.getFieldValidationMessage());
	                break;

	            case "up_fn_desc":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                sparam = fetchFunctionParam(param.getSearchName(), icedqUser);
	                editFunctionDescription(sparam.getFunctionName(), fparam.getFunctionDescription(), param.getFieldValidationMessage());
	                break;

	            case "up_existfunction":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                sparam = fetchFunctionParam(param.getSearchName(), icedqUser);
	                flag = updateFullFunction(sparam.getFunctionName(), fparam);
	                break;

	            case "up_addfunc":
	                fparam = fetchFunctionParam(param.getFunctionName(), icedqUser);
	                sparam = fetchFunctionParam(param.getSearchName(), icedqUser);
	                fparam.setFunctionName(fparam.getFunctionName() + "_" + timeStamp);
	                flag = updateFullFunction(sparam.getFunctionName(), fparam, param.getToastValidationMessage());
	                break;

	            default:
	                break;
	        }

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog("updateScenarioOfFunctionsForInvalidInputs :: " + e.toString());
	        flag = false;
	    }

	    return flag;
	}
	
	private void waitUntilNotDisplayed(By element, int timeout) {
	    isNotDisplayed(driver, element, timeout);
	}

	private void enterClassDescription(String classDesc, String timeStamp) {
	    String desc = (timeStamp != null) ? classDesc + " " + timeStamp : classDesc;
	    validatAndeEnterValueToTextField(driver, functionsDetailsDescriptionFieldLabel,
	        functionsDetailsDescriptionFieldInput, functionsDetailsDescriptionFieldValidation,
	        descriptionContent, placeholderDescription, desc, "");
	}

	private void logAndExecuteScript(String script, JavascriptExecutor js) {
	    BaseSuite.reportCodeLog(script);
	    js.executeScript(monacoEditorScript, script);
	    waitForExecution(1000);
	}

	private void validateClassButtonsAndState(String expectedState) {
	    verifyVisibilityOfButtons(driver, functionsDetailsDiscardButton, discardContent, true);
	    verifyVisibilityOfButtons(driver, functionsDetailsDeleteButton, deleteContent, true);
	    String actualState = getAttribute(driver, functionsDetailsClassState, attributeTitle);
	    stringOutput(actualState, expectedState, true);
	}

	private boolean enterInvalidField(By field, By validationField, String label,
	                                  String value, String validationMessage) {
	    return enterValueToFieldForInvalidDetails(driver, field, validationField, label, value, validationMessage);
	}

	private void verifySaveButtonNotVisible(By functionsSidebarAddFunctionSaveButton2) {
	    verifyVisibilityOfButtons(driver, functionsSidebarAddFunctionSaveButton2, saveContent, false);
	}

	private DataTestingParameters fetchFunctionParam(String name, String user) {
	    return setFunctionsParamUsingExcel(functionsTestData, functionSheetName, name, user, false);
	}

	private void addFunctionAndValidateAlias(String alias, String validationMsg) {
	    clickOnAddFunctionButtonAndValidate("");
	    if (!BaseSuite.suiteType.equalsIgnoreCase(sanity)) validateFunctionSidebar("fn_", "", "", "", defaultReturnType, 1);
	    enterInvalidField(functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation,
	            functionAliasContent, alias, validationMsg);
	    verifySaveButtonNotVisible(functionsSidebarAddFunctionSaveButton);
	    clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
	}

	private void addFunctionAndValidateDescription(String desc, String validationMsg) {
	    clickOnAddFunctionButtonAndValidate("");
	    if (!BaseSuite.suiteType.equalsIgnoreCase(sanity)) validateFunctionSidebar("fn_", "", "", "", defaultReturnType, 1);
	    enterInvalidField(functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation,
	            descriptionContent, desc, validationMsg);
	    verifySaveButtonNotVisible(functionsSidebarAddFunctionSaveButton);
	    clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
	}

	private boolean fillCompleteFunctionForm(DataTestingParameters param) {
	    return fillCompleteFunctionForm(param, content1 + param.getFunctionName() + content2);
	}

	private boolean fillCompleteFunctionForm(DataTestingParameters param, String toastMessage) {
	    clickOnAddFunctionButtonAndValidate("");
	    if (!BaseSuite.suiteType.equalsIgnoreCase(sanity)) validateFunctionSidebar("fn_", "", "", "", defaultReturnType, 1);

	    validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionAliasLabel, functionsSidebarAddFunctionAliasField,
	            functionsSidebarAddFunctionAliasValidation, functionAliasContent, placeholderFunctionAlias, param.getFunctionName(), "");

	    validatAndeEnterValueToTextField(driver, functionsSidebarAddFunctionDescriptionLabel, functionsSidebarAddFunctionDescriptionField,
	            functionsSidebarAddFunctionDescriptionValidation, descriptionContent, placeholderDescription, param.getFunctionDescription(), "");

	    selectMethodName(param.getFunctionMethodName());
	    validateField(driver, functionsSidebarAddFunctionParameterField, parametersContent, "", fieldContent,
	            param.getFunctionParameters(), attributeValue, false);
	    validateField(driver, functionsSidebarAddFunctionReturnTypeField, returnTypeContent, "", fieldContent,
	            param.getFunctionReturnType(), attributeValue, false);

	    boolean flag = clickOnSaveButtonToAddFunctionAndValidate(toastMessage);
	    clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
	    return flag;
	}

	private void editFunctionAlias(String searchName, String newAlias, String validationMsg) {
	    searchFunctionNameInClassDetails(searchName);
	    editFunction(searchName);
	    enterInvalidField(functionsSidebarAddFunctionAliasField, functionsSidebarAddFunctionAliasValidation,
	            functionAliasContent, newAlias, validationMsg);
	    verifySaveButtonNotVisible(functionsSidebarAddFunctionSaveButton);
	    clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
	}

	private void editFunctionDescription(String searchName, String newDesc, String validationMsg) {
	    searchFunctionNameInClassDetails(searchName);
	    editFunction(searchName);
	    enterInvalidField(functionsSidebarAddFunctionDescriptionField, functionsSidebarAddFunctionDescriptionValidation,
	            descriptionContent, newDesc, validationMsg);
	    verifySaveButtonNotVisible(functionsSidebarAddFunctionSaveButton);
	    clickOnButton(driver, functionsSidebarAddFunctionCancelButton, cancelButtonContent, true);
	}

	private boolean updateFullFunction(String searchName, DataTestingParameters param) {
	    return updateFullFunction(searchName, param, content1 + param.getFunctionName() + content2);
	}

	private boolean updateFullFunction(String searchName, DataTestingParameters param, String toastMessage) {
	    searchFunctionNameInClassDetails(searchName);
	    editFunction(searchName);
	    return fillCompleteFunctionForm(param, toastMessage);
	}

	private void editFunction(String functionName) {
	    javascript(driver, scrollToElement, functionTabAddFunctionButton);
	    clickOnButton(driver, returnElement(functionsDetailsFunctionActionEditDynamic, dynamicName, functionName),
	            functionName + editContent, true);
	    waitForExecution(1000);
	    waitUntilNotDisplayed(dataTSpinner, Constant.ruleWait);
	}


}
