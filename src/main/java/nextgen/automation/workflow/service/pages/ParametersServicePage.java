package nextgen.automation.workflow.service.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.CustomTimeUtil;
import nexgen.automation.framework.util.DataIntegrityUtils;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.pageclasses.otherpages.LoginPage;

public class ParametersServicePage extends PageUtil {

	WebDriver driver;

	public ParametersServicePage(WebDriver driver) {
		this.driver = driver;
	}

	protected static final Logger log = Logger.getLogger(ParametersServicePage.class);
	static String dirPath=System.getProperty("user.dir");

	public static final String PARAMETEREXCELFILEPATH = dirPath+ Constant.NEXTGEN_PARAMETERS_TESTDATA_EXCEL_PATH;
	public static final String PARAMETERPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");

	/** ----------------------  By locators ---------------------------------- **/

	By parametersTab=getElementLocator(prop.getProperty("parameters.tab"));
	By parametersPageTitle=getElementLocator(prop.getProperty("parameters.pagetitle"));
	By breadcrumbHomeLink=getElementLocator(prop.getProperty("parameters.breadcrumb.homelink"));
	By breadcrumbDataTestingLink=getElementLocator(prop.getProperty("parameters.breadcrumb.datatestinglink"));
	By breadcrumbParametersLink=getElementLocator(prop.getProperty("parameters.breadcrumb.parameterslink"));
	By breadcrumbParameterId=getElementLocator(prop.getProperty("parameters.breadcrumb.parameterId"));
	By parametersSearchField=getElementLocator(prop.getProperty("parameters.parameter.searchfield"));
	By parametersSearchIcon=getElementLocator(prop.getProperty("parameters.parameter.searchicon"));
	By parametersSearchClearIcon=getElementLocator(prop.getProperty("parameters.parameter.searchclearicon"));
	By newParameterButton=getElementLocator(prop.getProperty("parameters.listingpage.button.newparameter"));
	By refreshButton=getElementLocator(prop.getProperty("parameters.listingpage.button.refresh"));
	By moreOptionButton=getElementLocator(prop.getProperty("parameters.listingpage.button.more"));
	By copyButton=getElementLocator(prop.getProperty("parameters.listingpage.button.copy"));
	By moveButton=getElementLocator(prop.getProperty("parameters.listingpage.button.move"));
	By deleteButton=getElementLocator(prop.getProperty("parameters.listingpage.button.delete"));
	By parameterMasterCheckbox=getElementLocator(prop.getProperty("parameters.listingpage.mastercheckbox"));
	By parameterNameColumn=getElementLocator(prop.getProperty("parameters.listingpage.column.parametername"));
	By folderColumn=getElementLocator(prop.getProperty("parameters.listingpage.column.folder"));
	By keysColumn=getElementLocator(prop.getProperty("parameters.listingpage.column.keys"));
	By descriptionColumn=getElementLocator(prop.getProperty("parameters.listingpage.column.description"));
	By noRecordsToDisplayOnListingPage=getElementLocator(prop.getProperty("parameters.listingpage.NoRecordsToDisplay"));
	By parameterListingPageBar=getElementLocator(prop.getProperty("parameters.listingpage.paginationBar"));
	By parameterListingPageMsg=getElementLocator(prop.getProperty("parameters.listingpage.paginationMsg"));
	By parameterListingNextPageArrow=getElementLocator(prop.getProperty("parameters.listingpage.nextpagearrow"));
	By folderSearchLabel=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.label"));
	By folderSearchRefresh=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.refreshicon"));
	By folderSearchExpand=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.expand"));
	By folderSearchCollapse=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.collapse"));
	By folderSearchField=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.searchfield"));
	By folderSearchIcon=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.searchicon"));
	By folderSearchClearIcon=getElementLocator(prop.getProperty("parameters.listingpage.sidebar.foldersearch.clearicon"));
	By addNewParameterTitle=getElementLocator(prop.getProperty("parameters.addnewparameter.title"));
	By addNewParameterNameTitle=getElementLocator(prop.getProperty("parameters.addnewparameter.parametertitle"));
	By addNewParameterNameField=getElementLocator(prop.getProperty("parameters.addnewparameter.parameterfield"));
	By addNewParameterNameValidation=getElementLocator(prop.getProperty("parameters.name.field.validation"));
	By addNewParameterCancelButton=getElementLocator(prop.getProperty("parameters.addnewparameter.button.cancel"));
	By addNewParameterNextButton=getElementLocator(prop.getProperty("parameters.addnewparameter.button.next"));
	By addNewParameterCrossIcon=getElementLocator(prop.getProperty("parameters.addnewparameter.discard.icon"));
	By addNewParameterFolderValidation=getElementLocator(prop.getProperty("parameters.addnewparameter.folder.validation"));
	By parameterFieldValidation=getElementLocator(prop.getProperty("parameters.field.validation"));
	By paramerterDetailsIcon=getElementLocator(prop.getProperty("parameters.details.parameter.icon"));
	By paramerterDetailsNameTitle=getElementLocator(prop.getProperty("paramerers.details.parametername.title"));
	By paramerterDetailsNameField=getElementLocator(prop.getProperty("paramerers.details.parametername.field"));
	By parameterDetailsNameFieldValidation=getElementLocator(prop.getProperty("parameters.overview.name.field.validation"));
	By paramerterDetailsDescTitle=getElementLocator(prop.getProperty("paramerers.details.description.title"));
	By paramerterDetailsDescField=getElementLocator(prop.getProperty("paramerers.details.description.field"));
	By parameterDetailsDescValidation=getElementLocator(prop.getProperty("parameters.overview.desc.field.validation"));
	By parameterDetailsSaveButton=getElementLocator(prop.getProperty("paramerers.details.button.save"));
	By parameterDetailsDiscardButton=getElementLocator(prop.getProperty("paramerers.details.button.discard"));
	By parameterDetailsDuplicateButton=getElementLocator(prop.getProperty("paramerers.details.button.duplicate"));
	By parameterDetailsDeleteButton=getElementLocator(prop.getProperty("paramerers.details.button.delete"));
	By parameterDetailsAddFieldButton=getElementLocator(prop.getProperty("paramerers.details.button.addfield"));
	By parameterDetailsRemoveFieldButton=getElementLocator(prop.getProperty("paramerers.details.button.removefield"));
	By parameterDetailsImportButton=getElementLocator(prop.getProperty("paramerers.details.button.import"));
	By parameterDetailsTab=getElementLocator(prop.getProperty("paramerers.details.tab"));
	By parameterDetailsSearchkeyField=getElementLocator(prop.getProperty("paramerers.details.searchfield"));
	By parameterDetailsSearchkeyIcon=getElementLocator(prop.getProperty("paramerers.details.searchicon"));
	By parameterDetailsSearchkeyClear=getElementLocator(prop.getProperty("paramerers.details.searchclearicon"));
	By parameterDetailsMasterCheckbox=getElementLocator(prop.getProperty("parameters.details.property.mastercheckbox"));
	By parameterDetailsKeyColumn=getElementLocator(prop.getProperty("parameters.details.property.column.key"));
	By parameterDetailsValueColumn=getElementLocator(prop.getProperty("parameters.details.property.column.value"));
	By parameterDetailsNotesColumn=getElementLocator(prop.getProperty("parameters.details.property.column.notes"));
	By parameterDetailsActionsColumn=getElementLocator(prop.getProperty("parameters.details.property.column.actions"));
	By parameterDetailsNoRecordsToDisplay=getElementLocator(prop.getProperty("parameters.details.property.norecordstodisplay"));
	By parameterDetailsKeyField=getElementLocator(prop.getProperty("parameters.details.property.keyfield1"));
	By parameterDetailsValueField=getElementLocator(prop.getProperty("parameters.details.property.valuefield1"));
	By parameterDetailsNotesField=getElementLocator(prop.getProperty("parameters.details.property.notesfield1"));
	By parameterDetailsActionSaveButton=getElementLocator(prop.getProperty("parameters.details.property.button.save"));
	By parameterDetailsActionCancelButton=getElementLocator(prop.getProperty("parameters.details.property.button.cancel"));
	By parameterDetailsActionEditButton=getElementLocator(prop.getProperty("parameters.details.property.button.edit"));
	By parameterDetailsActionDeleteButton=getElementLocator(prop.getProperty("parameters.details.property.button.delete"));
	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By discardButtons=getElementLocator(prop.getProperty("workflow.details.discard.window"));
	By datatestingSubModuleTabs=getElementLocator(prop.getProperty("datatesting.subModule.tabs"));
	By datatestingSubModuleTabs1=getElementLocator(prop.getProperty("datatesting.subModule.tabs1"));
	By workflowAdvancedSearchTitle=getElementLocator(prop.getProperty("workflow.AdvancedSearch.title"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));
	By pathTree=getElementLocator(prop.getProperty("DataTesting.PathTree"));
	By pathSelect=getElementLocator(prop.getProperty("DataTesting.PathSelect"));
	By addNewSearchBar=getElementLocator(prop.getProperty("DataTesting.AddNewPanSearchBar"));
	By addNewPanSearchBarButton=getElementLocator(prop.getProperty("DataTesting.AddNewPanSearchBarButton"));
	By popupDeleteAllKeyTitle=getElementLocator(prop.getProperty("parameters.details.popup.title.deleteAllKey"));
	By popupDeleteAllKeyContent=getElementLocator(prop.getProperty("parameters.details.popup.content.deleteAllKey"));
	By popupDeleteAllKeyCancel=getElementLocator(prop.getProperty("parameters.details.popup.cancelbutton.deleteAllKey"));
	By popupDeleteAllKeyDelete=getElementLocator(prop.getProperty("parameters.details.popup.deletebutton.deleteAllKey"));
	By popupDeleteKeyTitle=getElementLocator(prop.getProperty("parameters.details.popup.title.deleteKey"));
	By popupDeleteKeyContent=getElementLocator(prop.getProperty("parameters.details.popup.content.deleteKey"));
	By popupDeleteKeyCancel=getElementLocator(prop.getProperty("parameters.details.popup.cancelbutton.deleteKey"));
	By popupDeleteKeyDelete=getElementLocator(prop.getProperty("parameters.details.popup.deletebutton.deleteKey"));
	By popupDeleteParameterTitle=getElementLocator(prop.getProperty("parameters.details.popup.title.deleteParameter"));
	By popupDeleteParameterContent=getElementLocator(prop.getProperty("parameters.details.popup.content.deleteParameter"));
	By popupDeleteParameterCancel=getElementLocator(prop.getProperty("parameters.details.popup.cancelbutton.deleteParameter"));
	By popupDeleteParameterDelete=getElementLocator(prop.getProperty("parameters.details.popup.deletebutton.deleteParameter"));	
	By popupDiscardParameterTitle=getElementLocator(prop.getProperty("parameters.details.popup.title.discardParameter"));
	By popupDiscardParameterContent=getElementLocator(prop.getProperty("parameters.details.popup.content.discardParameter"));
	By popupDiscardParameterCancel=getElementLocator(prop.getProperty("parameters.details.popup.cancelbutton.discardParameter"));
	By popupDiscardParameterDiscard=getElementLocator(prop.getProperty("parameters.details.popup.discardbutton.discardParameter"));
	By popupCopyParameterTitle=getElementLocator(prop.getProperty("parameters.details.popup.title.copyParameter"));
	By popupCopyParameterContent=getElementLocator(prop.getProperty("parameters.details.popup.content.copyParameter"));
	By popupCopyParameterCancelButton=getElementLocator(prop.getProperty("parameters.details.popup.cancelbutton.copyParameter"));
	By popupCopyParameterCopyButton=getElementLocator(prop.getProperty("parameters.details.popup.copybutton.copyParameter"));
	By popupCopyParameterWarningIcon=getElementLocator(prop.getProperty("parameters.details.popup.warningIcon.copyParameter"));
	By popupMoveParameterTitle=getElementLocator(prop.getProperty("parameters.details.popup.title.moveParameter"));
	By popupMoveParameterContent=getElementLocator(prop.getProperty("parameters.details.popup.content.moveParameter"));
	By popupMoveParameterCancelButton=getElementLocator(prop.getProperty("parameters.details.popup.cancelbutton.moveParameter"));
	By popupMoveParameterMoveButton=getElementLocator(prop.getProperty("parameters.details.popup.movebutton.moveParameter"));
	By popupMoveParameterWarningIcon=getElementLocator(prop.getProperty("parameters.details.popup.warningIcon.moveParameter"));
	By popupFolderDropDown=getElementLocator(prop.getProperty("parameters.details.popup.folderDropdown"));
	By popupFolderSearchField=getElementLocator(prop.getProperty("parameters.details.popup.folderSearchfield"));
	By popupFolderSearchButton=getElementLocator(prop.getProperty("parameters.details.popup.folderSearchbutton"));
	By popupFolderSearchClear=getElementLocator(prop.getProperty("parameters.details.popup.folderSearchClear"));
	By parameterKeysCountOnListing=getElementLocator(prop.getProperty("parameters.listingpage.KeyCount"));
	By parameterDescriptionOnListing=getElementLocator(prop.getProperty("parameters.listingpage.description"));
	By parameterUpdatedByOnListing=getElementLocator(prop.getProperty("parameters.listingpage.updatedBy"));
	By parameterLastUpdatedOnListing=getElementLocator(prop.getProperty("parameters.listingpage.lastUpdated"));
	By folderList=getElementLocator(prop.getProperty("RuleRepo.FolderList"));
	By addNewFolderSearchButton=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.folder.search.button"));
	By folderDownArrow=getElementLocator(prop.getProperty("parameters.addnewparameter.folderdropdown"));
	By addfolderSearchField=getElementLocator(prop.getProperty("parameters.addnewparameter.searchfolderfield"));
	By folderSearchButton=getElementLocator(prop.getProperty("parameters.addnewparameter.searchfolderbutton"));
	By folderSearchClear=getElementLocator(prop.getProperty("parameters.addnewparameter.searchfolderclear"));	
	By breadcrumbDashboardAndReporting=getElementLocator(prop.getProperty("breadcrumb.dashboardandreporting"));
	By moduleUserPageTitle=getElementLocator(prop.getProperty("module.pagetitle.users"));
	By welcomeText=getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));
	By dataTesting=getElementLocator(prop.getProperty("DataTestingTab"));
	By advancedSearchExpand=getElementLocator(prop.getProperty("parameters.advancedSearch.expand"));
	By advancedSearchCollapse=getElementLocator(prop.getProperty("workflow.advancedSearch.collapse"));
	By parametersAppliedFilterCross=getElementLocator(prop.getProperty("parameters.applied.filter.cross.icon"));
	By advancedSearchUpdatedByLabel=getElementLocator(prop.getProperty("parameters.advancedSearch.UpdatedBy.lable"));
	By advancedSearchUpdatedByExpand=getElementLocator(prop.getProperty("parameters.advancedSearch.UpdatedBy.expandButton"));
	By advancedSearchUpdatedByCollapse=getElementLocator(prop.getProperty("parameters.advancedSearch.UpdatedBy.collapseButton"));
	By advancedSearchUpdatedByList=getElementLocator(prop.getProperty("parameters.advancedSearch.UpdatedBy.list"));
	By advancedSearchUpdatedBySearchBar=getElementLocator(prop.getProperty("parameters.advancedSearch.UpdatedBy.searchbar"));
	By advancedSearchLastUpdatedLabel=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.lable"));
	By advancedSearchLastUpdatedExpand=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.expandButton"));
	By advancedSearchLastUpdatedCollapse=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.collapseButton"));
	By advancedSearchLastUpdatedFrom=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.fromField"));
	By advancedSearchLastUpdatedFromDateIcon=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.fromField.dateicon"));
	By advancedSearchLastUpdatedTo=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.toField"));
	By advancedSearchLastUpdatedToDateIcon=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.toField.dateicon"));
	By advancedSearchLastUpdatedCalanderDatePopup=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.calander.datePopup"));
	By advancedSearchLastUpdatedCalanderCurrentValue=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.calander.currentYearMon"));
	By advancedSearchLastUpdatedCalanderPreviousBtn=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.calander.previousMonBtn"));
	By advancedSearchLastUpdatedCalanderNextBtn=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.calander.nextMonBtn"));
	By advancedSearchLastUpdatedCalanderTodayBtn=getElementLocator(prop.getProperty("parameters.advancedSearch.LastUpdated.calander.todayBtn"));

	By copyParametersSidebarTitle=getElementLocator(prop.getProperty("parameters.details.sidebar.title.copyParameter"));
	By copyParametersSidebarDiscardIcon=getElementLocator(prop.getProperty("parameters.details.sidebar.discardicon.copyParameter"));
	By copyParametersSidebarCopyButton=getElementLocator(prop.getProperty("parameters.details.sidebar.copyButton.copyParameter"));
	By copyParametersSidebarCancelButton=getElementLocator(prop.getProperty("parameters.details.sidebar.cancelButton.copyParameter"));
	By copyParametersSidebariconNotify=getElementLocator(prop.getProperty("parameters.details.sidebar.copymsg"));
	By deleteParametersSidebariconNotify=getElementLocator(prop.getProperty("parameters.details.sidebar.delmsg"));
	By moveParametersSidebarTitle=getElementLocator(prop.getProperty("parameters.details.sidebar.title.moveParameter"));
	By moveParametersSidebarDiscardIcon=getElementLocator(prop.getProperty("parameters.details.sidebar.discardicon.moveParameter"));
	By moveParametersSidebarMoveButton=getElementLocator(prop.getProperty("parameters.details.sidebar.moveButton.moveParameter"));
	By moveParametersSidebarCancelButton=getElementLocator(prop.getProperty("parameters.details.sidebar.cancelButton.moveParameter"));
	By deleteParametersSidebarTitle=getElementLocator(prop.getProperty("parameters.details.sidebar.title.deleteParameter"));
	By deleteParametersSidebarDiscardIcon=getElementLocator(prop.getProperty("parameters.details.sidebar.discardicon.deleteParameter"));
	By deleteParametersSidebardeleteButton=getElementLocator(prop.getProperty("parameters.details.sidebar.deleteButton.deleteParameter"));
	By deleteParametersSidebarCancelButton=getElementLocator(prop.getProperty("parameters.details.sidebar.cancelButton.deleteParameter"));
	By bulkChangesRefreshLogs=getElementLocator(prop.getProperty("parameters.details.sidebar.refreshlogs"));
	By bulkChangesLogs=getElementLocator(prop.getProperty("parameters.details.sidebar.logs"));
	By bulkChangesCopyToClipboard=getElementLocator(prop.getProperty("parameters.details.sidebar.copytoclipboard"));
	By bulkChangesDoneButton=getElementLocator(prop.getProperty("parameters.details.sidebar.donebutton"));
	By nextgenTabDataTesting=getElementLocator(prop.getProperty("nextgenmodule.datatesting.tab"));
	By nextgenTabDashboardandReporting=getElementLocator(prop.getProperty("nextgenmodule.dashboard.tab"));
	By nextgenTabScheduler=getElementLocator(prop.getProperty("nextgenmodule.scheduler.tab"));
	By nextgenTabConnector=getElementLocator(prop.getProperty("nextgenmodule.connector.tab"));
	By nextgenTabAdmin=getElementLocator(prop.getProperty("nextgenmodule.admin.tab"));

	By parametersListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.parameters"));
	By parametersDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.parameters"));

	By upsertparameterImportButton = getElementLocator(prop.getProperty("parameters.upsertparameter.button.import"));
	By upsertparameterCancelButton = getElementLocator(prop.getProperty("parameters.upsertparameter.button.cancel"));

	String importParametersFileTypeInfo=prop.getProperty("parameters.addnewparam.uploadfile.filetypetext");
	String importParametersSecureIcon=prop.getProperty("parameters.addnewparam.uploadfile.secureicon");
	String importParametersChooseFileBtn=prop.getProperty("parameters.addnewparam.uploadfile.choosefilebutton");
	String importParametersChooseFileInput=prop.getProperty("parameters.addnewparam.uploadfile.choosefileInput");
	String importParametersNoteText=prop.getProperty("parameters.addnewparam.uploadfile.notetext");

	String dynamictype="$type";
	/** ----------------------  String variables ---------------------------------- **/

	String moduleTab=prop.getProperty("nextgenmodule.tab");
	String subModuleTab=prop.getProperty("nextgenmodule.submodule.tab");
	String modulePageTitle=prop.getProperty("module.pagetitle");
	String dynamicName=prop.getProperty("DynName");
	String breadcrumbFolderName=prop.getProperty("parameters.breadcrumb.foldername");
	String breadcrumbParameterName=prop.getProperty("parameters.breadcrumb.parametersname");
	String parameterFolderName=prop.getProperty("workflow.folderSearch.folder.name");
	String parameterFolderNameCheckbox=prop.getProperty("parameters.listingpage.sidebar.foldersearch.foldernamecheckbox");
	String parameterDetailsDymanicKeyField=prop.getProperty("parameters.details.property.keyField");
	String parameterDetailsDymanicValueField=prop.getProperty("parameters.details.property.valueField");
	String parameterDetailsDymanicNotesField=prop.getProperty("parameters.details.property.notesField");
	String parameterDetailsKeyEditButton=prop.getProperty("parameters.details.property.editbutton");
	String parameterDetailsKeyDeleteButton=prop.getProperty("parameters.details.property.deletebutton");
	String parameterDetailsKeySaveButton=prop.getProperty("parameters.details.property.savebutton");
	String parameterDetailsKeyCancelButton=prop.getProperty("parameters.details.property.cancelbutton");
	String placeholderSearchParameter=prop.getProperty("parameters.placeholder.search.parameter");
	String placeholderSearchFolder=prop.getProperty("parameters.placeholder.search.folder");
	String placeholderName=prop.getProperty("parameters.placeholder.name");
	String placeholderDescription=prop.getProperty("parameters.placeholder.description");
	String placeholderSearchKey=prop.getProperty("parameters.placeholder.search.key");
	String placeholderSearchUser=prop.getProperty("parameters.placeholder.search.user");
	String parameterNameHyperLinkUsingFolderPath=prop.getProperty("parameters.listingpage.parameterNameUsingFolderPath");
	String parameterNameHyperLinkUsingFolderPathStartWith=prop.getProperty("parameters.listingpage.parameterNameUsingFolderPath.startwith");
	String parameterDescUsingFolderPath=prop.getProperty("parameters.listingpage.parameterDescriptionUsingFolderPath");
	String parameterFolderNameOnListing=prop.getProperty("parameters.listingpage.parameterFolderName");
	String parameterCheckboxOnListing=prop.getProperty("parameters.listingpage.parametercheckbox");
	String popupFolderSearchFolderName=prop.getProperty("parameters.details.popup.foldername");
	String popupFolderSearchSelectArrow=prop.getProperty("parameters.details.popup.folderSelectArrow");
	String toastMessageSaveParameter=prop.getProperty("parameters.toast.message.save");
	String toastMessageDeleteParameter=prop.getProperty("parameters.toast.message.delete");
	String toastMessageDuplicateParameter=prop.getProperty("parameters.toast.message.duplicate");
	String toastMessageCopyParameter=prop.getProperty("parameters.toast.message.copy");
	String toastMessageMoveParameter=prop.getProperty("parameters.toast.message.move");
	String toastMessagefileUploaded = prop.getProperty("parameters.toast.message.fileupload");
	String fieldValidationForEmptyParamName=prop.getProperty("parameters.field.message.emptyname");
	String validScrollFolder=prop.getProperty("parameters.addNewParameter.foldername");
	String scrollToElementArg=prop.getProperty("ScrollToElementArgument");	
	String folderselectBtn=prop.getProperty("parameters.addNewParameter.foldernameselect");
	String folderselectbtnNew =prop.getProperty("parameters.addNewParameter.foldernameselect.new");
	String advanceSearchUpdatedByCheckbox=prop.getProperty("parameters.advancedSearch.UpdatedBy.checkbox");
	String advanceSearchLastUpdatedCalanderSelectMon=prop.getProperty("parameters.advancedSearch.LastUpdated.calander.selectMonYear");
	String advanceSearchLastUpdatedCalanderSelectDate=prop.getProperty("parameters.advancedSearch.LastUpdated.calander.selectdate");
	String updatedbynameOnListing=prop.getProperty("parameters.listingpage.updatedbyname");

	String importParametersFileDetailsLocator=prop.getProperty("parameters.addnewparam.uploadfile.filedetails");




	/** ----------------------  String values ---------------------------------- **/

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

	String columnContent="Column";
	String jscriptToClick="arguments[0].click();";	
	String jscriptToMouseHover="arguments[0].dispatchEvent(new Event('mouseover'));";
	String paramNameContent="Parameter name";
	String paramSearchContent="Parameter search";
	String checkboxContent="checkbox";
	String masterContent="Master";
	String searchContent="Search";
	String keyContent="Key";
	String valueContents="Value";
	String notesContent="Notes";
	String fieldContent=" field";	
	String functionsContent="Functions";
	String workflowsContent="Workflows";
	String instancesContent="Instances";
	String datatestingContent="Data Testing";
	String connectionsContent="Connections";
	String schedulerContent="Scheduler";
	String dynamicFolderName="$foldername";
	String moreOptionContent="More";
	String labelContent="label";
	String parameterContent="Parameter";
	String rightClickArrowContent="Right tick arrow";
	String clickContent="click";
	String tabContent= " tab";

	String jsonPathParameterkeyList="$.info.parameters..key";
	String jsonPathParameterKey="$.info.parameters[";
	String jsonPathKey="].key";
	String jsonPathValue="].value";
	String jsonPathRemark="].remark";

	static String parameterTestCaseSheet ="testcases";
	static String parameterTestCaseColumn="testCaseId";

	String sanity ="sanity";
	String nextPageArrowContent="next page arrow";
	String calanderDateFormat="M/d/yyyy";

	String parameterListingContent="Parameters listing";

	String addNewParameterContent="Add New Parameter";
	String upsertParameterContent="Upsert Parameter";
	String importContent ="Import";
	String noRecordsTodisplayContentp = "No records to display";

	double numberOfRecordsPerPage = 20.0;

	String importParametersTestDataFolderPath = "/src/main/resources/testdata/importdata/";

	/** ----------------------  Generic methods ---------------------------------- **/

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayed(driver, discardButtons, 50);
			if (isDisplayed(driver, discardButtons, 50)) {
				clickOnButton(driver, discardButtons, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" handleDiscardWindow :: "+e.toString());

		}
	}

	public void clickOnAddNewParameterDiscardButton() {

		if(isDisplayed(driver, addNewParameterTitle, 10)) {
			clickOnButton(driver, addNewParameterCancelButton, cancelButtonContent, true);
		}
	}

	public boolean clickOnRefreshOnParameterListingPage() {

		return clickOnButton(driver, refreshButton, refreshContent, true);
	}


	public boolean clickOnParametersTab() {

		boolean flag = false;
		HomePage hp=new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, newParameterButton);

			if(elementNotVisible(driver, newParameterButton)) {

				if(isDisplayed(driver, hp.datatestingtab)) {

					hp.clickOnDataTestingTab();

					driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
					waitForExecution(2000);

					lp.chooseWorkspaceWithToast(BaseSuite.WorkspaceName,"","owner", true);

				}

				handleDiscardWindow();

				if(isDisplayed(driver, addNewParameterTitle, 5)) {
					clickOnButton(driver, addNewParameterCancelButton, cancelButtonContent, true);
				}

				isDisplayedInLoop(driver, 2, parametersTab);

				if(isDisplayed(driver, parametersTab, 5)) {

					flag = isClickable(driver, parametersTab, parametersContent+tabContent, true);

					if(flag) {

						BaseSuite.reportLog("Clicking on "+parametersContent+tabContent);

						displayAndClick(driver, parametersTab);

						BaseSuite.validationReportLog("Clicked on "+parametersContent+tabContent);

						handleDiscardWindow();

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

						flag=validateTitle(driver, parametersPageTitle, parametersContent);

						clickOnButton(driver, refreshButton, refreshContent, true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}

				}else {
					BaseSuite.reportFailLog(parametersContent+" tab not visible", "clickOnParametersTab");
				}
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnParametersTab :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateAppliedFilterOnListingPage(String folderName) {

		boolean flag=true;
		String checkboxstate="";
		String methodName="validateAppliedFilterOnListingPage";
		try {

			BaseSuite.reportLog("-------------- Verifying Applied Filter functionality on parameters listing page ------------- ");

			flag=searchFunctionalityMethod(driver, flag, folderSearchField, folderSearchIcon, placeholderSearchFolder, placeholderSearchFolder, folderName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Checking visibility of searched folder checkbox ");

			By locator= returnElement(parameterFolderNameCheckbox, dynamicName, folderName);

			isDisplayedInLoop(driver, 2, locator);

			if(flag && isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog("searched folder checkbox is visible :"+folderName);

				BaseSuite.reportLog("Clicking on folder checkbox");

				displayAndClick(driver, locator);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.reportLog("Clicked on folder checkbox");

				BaseSuite.reportLog("Verifying folder checkbox is selected or not");

				checkboxstate=getAttribute(driver, locator, attributeClass);

				if(checkboxstate.contains("check")) {

					BaseSuite.validationReportLog("Folder checkbox is selected");

				}else {
					BaseSuite.reportFailLog("Folder checkbox is not selected",methodName);
					flag=false;
				}

				BaseSuite.validationReportLog("Verifying applied filter on listing page");

				isDisplayedInLoop(driver, 2, parametersAppliedFilterCross);

				if(isDisplayed(driver, parametersAppliedFilterCross)) {

					BaseSuite.validationReportLog("Applied filter is visible");

					BaseSuite.reportLog("Clicking on cross icon of applied filter");

					displayAndClick(driver, parametersAppliedFilterCross);

					BaseSuite.validationReportLog("Clicked on cross icon of applied filter");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					searchFunctionalityMethod(driver, true, folderSearchField, folderSearchIcon, placeholderSearchFolder, placeholderSearchFolder, folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					BaseSuite.reportLog("Verifying folder checkbox is unselected or not");

					checkboxstate=getAttribute(driver, locator, attributeClass);

					if(!checkboxstate.contains("check")) {

						BaseSuite.validationReportLog("Folder checkbox is unselected");

					}else {
						BaseSuite.reportFailLog("Folder checkbox is selected",methodName);
						flag=false;
					}

				}else {
					flag=false;
					BaseSuite.reportFailLog("Applied filter on listing page not visible",methodName);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+methodName+" :: "+e.toString());
			flag=false;
		}finally {

			searchFunctionalityMethod(driver, true, folderSearchField, folderSearchIcon, placeholderSearchFolder, placeholderSearchFolder, "");
		}

		return flag;

	}

	public boolean validateParameterListingPage() {
		boolean flag =true;
		HomePage hp=new HomePage(driver);
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenModuleAndDataTestingSubModules();

			BaseSuite.reportLog("----------- Verifying breadcrumb on Parameters listing page -----------");

			validateElement(driver, breadcrumbHomeLink, homeContent, "Hyperlink");

			validateElement(driver, breadcrumbDataTestingLink, datatestingContent, "Hyperlink");

			validateElement(driver, breadcrumbParametersLink, parametersContent, labelContent);

			BaseSuite.reportLog("-----------  Verifying Title and Search field Parameters listing page ---------");

			verifyIndividualLabel(driver, parametersPageTitle, parametersContent);

			verifySearchField(driver,parametersSearchField, placeholderSearchParameter, placeholderSearchParameter);

			BaseSuite.reportLog("-----------  Verifying buttons on Parameters listing page ---------");

			validateButtons(driver, parametersListingButtonsCount, 3);

			verifyVisibilityOfButtons(driver, newParameterButton, "New Parameter", true);
			verifyVisibilityOfButtons(driver, refreshButton, refreshContent, true);
			verifyVisibilityOfButtons(driver, moreOptionButton, moreOptionContent, false);

			BaseSuite.reportLog("-----------  Verifying Columns on Parameters listing page ---------");

			validateElement(driver, parameterMasterCheckbox, masterContent,checkboxContent);
			validateElement(driver, parameterNameColumn, "Name", columnContent);
			validateElement(driver, folderColumn, folderContent, columnContent);
			validateElement(driver, keysColumn, "# Of Keys", columnContent);
			validateElement(driver, descriptionColumn, descriptionContent, columnContent);

			if(isDisplayed(driver, folderSearchExpand)) {

				displayAndClick(driver, folderSearchExpand);

				waitForExecution(1000);
			}

			BaseSuite.reportLog("-----------  Verifying Folder Search pane on Parameters listing page ---------");

			verifyIndividualLabel(driver, folderSearchLabel, "Folder Search");

			verifySearchField(driver, folderSearchField, placeholderSearchFolder, placeholderSearchFolder);

			validateElement(driver, folderSearchIcon, searchContent, "icon");

			validateElement(driver, folderSearchRefresh, "Folder Refresh", "icon");

			clickOnButton(driver, folderSearchRefresh, "Folder Refresh", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("-----------  Verifying Advanced Search pane on Parameters listing page ---------");

			verifyIndividualLabel(driver, workflowAdvancedSearchTitle, advanceSearchContent);

			BaseSuite.reportLog("-----------  Verifying pagination on Parameters listing page ---------");

			getPaginationDetails(driver, parameterListingPageMsg, parameterListingPageBar, noRecordsToDisplayOnListingPage, parameterListingContent);

			BaseSuite.validationReportLog("-------------------- Parameters listing page validated successfully -------------");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateParameterListingPage :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean searchFolderFunctionality(String searchFoldername) {

		boolean flag=true;
		try {

			flag=searchFunctionalityMethod(driver, flag, folderSearchField, folderSearchIcon, placeholderSearchFolder, placeholderSearchFolder, searchFoldername);

			if(flag && isDisplayed(driver, returnElement(parameterFolderName, dynamicName, searchFoldername))) {
				flag=true;
			}else {
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchFolderFunctionality :: "+e.toString());

			flag=false;
		}
		return flag;
	}

	public void clickOnFolderSearchClearICon() {

		isDisplayedInLoop(driver, 2, folderSearchField);

		if(isDisplayed(driver, folderSearchField) && isDisplayed(driver, folderSearchClearIcon)) {

			displayAndClick(driver, folderSearchClearIcon);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}
	}

	public boolean validateAddNewParameterPrivilege(String icedqUser) {
		boolean flag=true;
		try {
			isDisplayedInLoop(driver, 2, addNewParameterTitle);
			if (isDisplayed(driver, addNewParameterTitle) && (icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				flag=verifyIndividualLabel(driver, addNewParameterTitle, addNewParameterContent);

				BaseSuite.validationReportLog("New Parameter button is clicked "+ConstantProperty.SUCCESSSTRING+" and Add new Parameter title is visible");


			}else{
				BaseSuite.reportFailLog("New Parameter button not clicked properly , create new Parameter page not visible", "validateAddNewParameterPrivilege");
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddNewParameterPrivilege :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateAddNewParameterPane() {

		boolean flag = true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, addNewParameterTitle);

			if(isDisplayed(driver, addNewParameterTitle)) {

				verifyIndividualLabel(driver, addNewParameterTitle, addNewParameterContent);

				validateElement(driver, addNewParameterCrossIcon, discardContent, "icon");

				verifyIndividualLabel(driver, addNewParameterNameTitle, paramNameContent);

				isEditable(driver, addNewParameterNameTitle, paramNameContent+fieldContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				String defName = getAttribute(driver, addNewParameterNameField, attributeValue);

				if(!defName.isEmpty()) {

					BaseSuite.reportLog("Default Parameter name is "+defName);
				}else {
					BaseSuite.reportFailLog("Default Parameter name not visible", "validateAddNewParameterPane");
				}

				validateImportParameterUI(addNewParameterContent);

				verifyVisibilityOfButtons(driver, addNewParameterCancelButton, cancelButtonContent, true);

				verifyVisibilityOfButtons(driver, addNewParameterNextButton, nextContent, !isDisplayed(driver, addNewParameterFolderValidation));

			}else {
				BaseSuite.reportFailLog("Add new parameter title not visible ", "validateAddNewParameterPane");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddNewParameterPane :: "+e.toString());
			flag=false;
			clickOnButton(driver, addNewParameterCancelButton, cancelButtonContent, true);
		}

		return flag;
	}

	public boolean clickOnNewParameterButton(String icedqUser) {
		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, newParameterButton, "New Parameter", true);

			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 1, toastMsg);

				if (isDisplayed(driver, toastMsg) || icedqUser.toLowerCase().contains(executorContent) || icedqUser.toLowerCase().contains(readerContent)) {

					flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
							"New Parameter authorization message");

				}else {

					flag=validateAddNewParameterPrivilege(icedqUser);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnNewParameterButton :: "+e.toString());
			flag=false;
		}


		return flag;
	}

	public void selectFolderOfAddNewParameterPane(boolean flag,String folderName) {
		WorkflowPage wp = new WorkflowPage(driver);

		try {
			if(!folderName.isEmpty()) {
				javascript(driver, jscriptToClick, pathSelect);

				BaseSuite.validationReportLog(" Folder field clicked successfully ");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(folderName.contains("/")) {

					wp.selectFolderOnAddNewWorkflowPane(folderName);

				}else {
					createOrSelectExistingFolder(flag, folderName);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectFolderOfAddNewParameterPane :: "+e.toString());
		}
	}


	public void createOrSelectExistingFolder(boolean flag, String folderName) {

		try {
			if (isDisplayed(driver, pathTree) && flag) {

				String str = folderName.replace("/", "");

				String str1 = str.trim();

				int count = getcount(str1, ' ');

				String[] result = str1.split(" ");

				for (int colNum = 0; colNum <= count; colNum++) {

					String folder = result[colNum];

					List<WebElement> ele = driver.findElements(folderList);

					for (WebElement e : ele) {

						String val = e.getText();

						folder=folder.replace("\\","" );

						if (val.equalsIgnoreCase(folder)) {

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							waitForElement(driver, (returnElement(validScrollFolder, dynamicName, folder)));

							javascript(driver, scrollToElementArg, returnElement(validScrollFolder, dynamicName, folder));

							BaseSuite.reportLog("Entering folder name in search box - "+folder);

							sendKeys(driver, addNewSearchBar, folder);

							click(driver, addNewFolderSearchButton);

							BaseSuite.reportLog("Entered folder name in search box ");

							waitForExecution(2000);

							displayAndClick(driver, returnElement(validScrollFolder, dynamicName, folder));

							/**	action.moveByOffset(90, 0).perform();**/

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							displayAndClick(driver,returnElement(folderselectBtn, dynamicName, folder) );

							BaseSuite.validationReportLog(folder+" Folder Clicked successfully");						

							BaseSuite.validationReportLog(folder+" Folder selected ");

							break;
						}
					}

				}

			} else {
				BaseSuite.reportFailLog(folderName + " is fail to display", "createOrSelectExistingFolder");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" createOrSelectExistingFolder :: "+e.toString());

		}

	}

	public boolean validateAndEnterParameterOverview(boolean flag,String parameterName,String description) {


		try {
			isDisplayedInLoop(driver, 2, parametersPageTitle);

			if(isDisplayed(driver, parametersPageTitle)) {

				String paramName = getAttribute(driver, parametersPageTitle, attributeTextContent);

				stringContainsOutput(paramName, parameterName, true);

				validateElement(driver, paramerterDetailsIcon, parameterContent, "icon");

				validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField,parameterDetailsNameFieldValidation, paramNameContent, placeholderName, parameterName, fieldValidationForEmptyParamName);

				validatAndeEnterValueToTextField(driver, paramerterDetailsDescTitle, paramerterDetailsDescField,parameterDetailsDescValidation, descriptionContent, placeholderDescription, description, "");

			}else {
				BaseSuite.reportFailLog("Parameter title is not visible ", "validateAndEnterParameterOverview");
			}
		} catch (NoSuchElementException e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndEnterParameterOverview "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void enterKeyAndValueOfParameters(String parameterJson) {

		try {
			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			for(int i=0;i<keyList.size();i++) {

				String key=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathKey);
				String value=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathValue);
				String notes=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathRemark);

				notes=checkNullValue(notes);

				BaseSuite.reportLog("---------- Adding "+(i+1)+" parameter  "+keyContent+" : "+key+" & "+valueContents+" : "+value+" & remark :  "+notes  );

				clickOnButton(driver, parameterDetailsAddFieldButton, "Add", true);

				waitForExecution(500);

				enterValueToTextField(driver, parameterDetailsKeyField,  keyContent+" "+fieldContent, key);

				enterValueToTextField(driver, parameterDetailsValueField,  valueContents+" "+fieldContent, value);

				enterValueToTextField(driver, parameterDetailsNotesField,  notesContent+" "+fieldContent, notes);

				verifyVisibilityOfButtons(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

				clickOnButton(driver, parameterDetailsActionSaveButton, rightClickArrowContent, true);

				waitForExecution(1000);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" enterKeyAndValueOfParameters "+e.toString());
		}
	}

	public void enterKeyAndValueOfParametersUsingExcel(int keyno, String keyName ) {

		try {


			DataTestingParameters param = ParametersServicePage.setParametersKeysAndValue(keyName);
			String key = param.getParameterKey();
			String value = param.getParameterValue();
			String notes = param.getParameterRemark();

			notes=checkNullValue(notes);

			BaseSuite.reportLog("---------- Adding "+(keyno)+" parameter "+keyContent+" : "+key+" & "+valueContents+" : "+value+" & remark :  "+notes  );

			clickOnButton(driver, parameterDetailsAddFieldButton, "Add", true);

			waitForExecution(500);

			enterValueToTextField(driver, parameterDetailsKeyField,  keyContent+" "+fieldContent, key);

			enterValueToTextField(driver, parameterDetailsValueField,  valueContents+" "+fieldContent, value);

			enterValueToTextField(driver, parameterDetailsNotesField,  notesContent+" "+fieldContent, notes);

			verifyVisibilityOfButtons(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

			clickOnButton(driver, parameterDetailsActionSaveButton, rightClickArrowContent, true);

			waitForExecution(1000);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" enterKeyAndValueOfParametersUsingExcel "+e.toString());
		}
	}

	public boolean enterKeyAndValueOfParametersForInvalid(String parameterJson) {

		boolean flag =true;
		try {
			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			for(int i=0;i<keyList.size();i++) {

				String key=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathKey);
				/**			String value=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPath+i+jsonPathValue);
				String notes=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPath+i+jsonPathRemark);

				notes=checkNullValue(notes);

				 **/
				BaseSuite.reportLog("----------- Adding "+(i+1)+" parameter key : "+key);

				clickOnButton(driver, parameterDetailsAddFieldButton, "Add", true);

				waitForExecution(500);

				enterValueToTextField(driver, parameterDetailsKeyField, keyContent+" "+fieldContent, key);

				waitForExecution(500);

				displayAndClick(driver, parameterDetailsValueField);

				flag=getCSSColorOfElement(driver, parameterDetailsKeyField, keyContent+" "+fieldContent, "border-top-color", "red");

				/**
				enterValueToTextField(driver, parameterDetailsValueField, "Value field", value);

				enterValueToTextField(driver, parameterDetailsNotesField, "Notes field", notes);

				verifyVisibilityOfButtons(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

				clickOnButton(driver, parameterDetailsActionSaveButton, rightClickArrowContent, true);
				 **/

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" enterKeyAndValueOfParametersForInvalid "+e.toString());
		}
		return flag;
	}

	public boolean validateToastMessage(Boolean flag,String label, String toastValidation) {
		boolean tag =true;
		try {
			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastValidation, label);
				tag=false;

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(tag && !toastValidation.isEmpty()) {
				flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, toastValidation,label);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateToastMessage "+e.toString());
		}
		return flag;
	}

	public boolean searchAndEditParameterKeyValue(Boolean flag, String searchKey, String updatekey, String updateValue, String updateNote, String toastValidation) {

		/**		boolean searchflag=false;*/
		try {
			BaseSuite.reportLog("----------- Updating parameter key : "+searchKey);

			/**	
				flag = searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon,
						searchContent + " key", placeholderSearchKey, searchKey);
			 */
			javascript(driver, scrollToElementArg, returnElement(parameterDetailsKeyEditButton, dynamicName, searchKey));

			flag=clickOnButton(driver, returnElement(parameterDetailsKeyEditButton, dynamicName, searchKey), "Edit", true);

			waitForExecution(1000);

			if(Boolean.TRUE.equals(flag) && isDisplayed(driver, parameterDetailsKeyField)) {

				enterValueToTextField(driver, parameterDetailsKeyField, keyContent+fieldContent, updatekey);

				if(!updateValue.isEmpty()) {

					enterValueToTextField(driver, parameterDetailsValueField, valueContents+fieldContent, updateValue);
				}

				if(!updateNote.isEmpty()) {

					enterValueToTextField(driver, parameterDetailsNotesField, notesContent+fieldContent, updateNote);
				}

				verifyVisibilityOfButtons(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

				clickOnButton(driver, parameterDetailsActionSaveButton, "Right arrow", true);

				validateToastMessage(flag, "Repeated key", toastValidation);

			}else {
				BaseSuite.reportFailLog("Parameter "+keyContent+fieldContent+" is not visible ", "searchAndEditParameterKeyValue");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndEditParameterKeyValue "+e.toString());
		}
		return flag;

	}

	public boolean searchAndEditParameterKeyValueForInvalid(Boolean flag, String searchKey, String updatekey) {

		/**	boolean searchflag=false;*/

		try {
			BaseSuite.reportLog("----------- Updating parameter key : "+searchKey);

			/**	
				flag = searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon,
						searchContent + " key", placeholderSearchKey, searchKey);
			 */
			javascript(driver, scrollToElementArg, returnElement(parameterDetailsKeyEditButton, dynamicName, searchKey));

			flag=clickOnButton(driver, returnElement(parameterDetailsKeyEditButton, dynamicName, searchKey), "Edit", true);

			waitForExecution(1000);

			if(Boolean.TRUE.equals(flag) && isDisplayed(driver, parameterDetailsKeyField)) {

				enterValueToTextField(driver, parameterDetailsKeyField, keyContent+fieldContent, updatekey);

				waitForExecution(500);

				displayAndClick(driver, parameterDetailsValueField);

				flag=getCSSColorOfElement(driver, parameterDetailsKeyField, keyContent+" "+fieldContent, "border-top-color", "red");

				verifyVisibilityOfButtons(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

				clickOnButton(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

			}else {
				BaseSuite.reportFailLog("Parameter key field is not visible ", "searchAndEditParameterKeyValue");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndEditParameterKeyValue "+e.toString());
		}
		return flag;

	}

	public boolean searchAndDeleteParameterKeyValue(Boolean flag, String searchKey) {

		/**		boolean searchflag=false;*/

		try {
			BaseSuite.reportLog("----------- Deleting parameter key : "+searchKey);
			/**
			if (searchflag) {
				flag = searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon,
						searchContent + " key", placeholderSearchKey, searchKey);
			}
			 */
			javascript(driver, scrollToElementArg, returnElement(parameterDetailsKeyDeleteButton, dynamicName, searchKey));

			flag=clickOnButton(driver, returnElement(parameterDetailsKeyDeleteButton, dynamicName, searchKey), deleteContent, true);

			waitForExecution(1000);

			if(Boolean.TRUE.equals(flag) && isDisplayed(driver, popupDeleteKeyTitle)) {

				validateAndHandleRemoveParameterKeyPopupWindow(false, deleteContent);

			}else {
				BaseSuite.reportFailLog("Parameter key field is not visible ", "searchAndDeleteParameterKeyValue");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndDeleteParameterKeyValue "+e.toString());
		}
		return flag;

	}

	public boolean clickOnDeleteParameterButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		clickOnButton(driver, parameterDetailsDeleteButton, deleteContent, true);

		validateAndHandleDeleteParameterPopupWindow(flag, deleteContent);

		if(isDisplayed(driver, toastMsg)) {

			flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, parametersContent+" "+deleteContent);
			tag=false;
		}

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(tag && !expectedToastMessage.isEmpty()) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,parametersContent+" "+deleteContent);
		}
		return flag;
	}

	public boolean clickOnDeleteParameterButtonAndValidateToast(boolean flag, int count, String expectedToastMessage) {
		boolean tag =true;

		clickOnButton(driver, parameterDetailsDeleteButton, deleteContent, true);

		if(count==1) {
			validateAndHandleDeleteParameterPopupWindow(flag, deleteContent);

		}else {
			validateAndHandleDeleteParametersPopupWindow(flag, deleteContent);
			expectedToastMessage="Parameters deleted successfully.";
		}
		if(isDisplayed(driver, toastMsg)) {

			flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, parametersContent+" "+deleteContent);
			tag=false;
		}

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(tag && !expectedToastMessage.isEmpty()) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,parametersContent+" "+deleteContent);
		}
		return flag;
	}

	private boolean clickButtonAndValidateToast(By buttonLocator, String actionContent, String expectedToastMessage, String successMessagePrefix, boolean flag) {
		boolean tag = true;

		try {
			clickOnButton(driver, buttonLocator, actionContent, true);

			if (isDisplayed(driver, toastMsg)) {
				flag = captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, successMessagePrefix);
				tag = false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (tag && !expectedToastMessage.isEmpty()) {
				flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, successMessagePrefix);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" clickButtonAndValidateToast "+buttonLocator);
			return false;
		}

		return flag;
	}

	public boolean clickOnSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		return clickButtonAndValidateToast(parameterDetailsSaveButton, saveContent, expectedToastMessage, "Parameter Created/updated", flag);
	}

	public boolean clickOnDuplicateButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		return clickButtonAndValidateToast(parameterDetailsDuplicateButton, duplicateContent, expectedToastMessage, "Parameter duplicated", flag);
	}

	public boolean clickOnImportButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		return clickButtonAndValidateToast(upsertparameterImportButton, importContent, expectedToastMessage, upsertParameterContent, flag);
	}

	public boolean clickOnImportButtonAndValidateToastOnParameterPage(boolean flag, String expectedToastMessage) {
		return clickButtonAndValidateToast(parameterDetailsImportButton, importContent, expectedToastMessage, upsertParameterContent, flag);
	}

	public boolean clickOnNextButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		return clickButtonAndValidateToast(addNewParameterNextButton, nextContent, expectedToastMessage, "New Parameter create", flag);
	}

	public boolean clickOnCopyParameterButtonAndValidateToast(boolean flag,String folderName,int count) {
		boolean tag =true;

		validateCopyParametersSidebar();

		searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

		validateBulkChangesNotify(count, "copy", folderName);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		clickOnButton(driver, popupCopyParameterCopyButton, copyContent, tag);

		if(isDisplayed(driver, toastMsg)) {

			flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMessageCopyParameter, parametersContent+" "+copyContent);
			tag=false;
		}

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(tag) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, toastMessageCopyParameter,parametersContent+" "+copyContent);
		}
		return flag;
	}

	public boolean clickOnMoveParameterButtonAndValidateToast(boolean flag,String folderName) {
		boolean tag =true;

		selectFolderFromPopupWindow(folderName);

		validateAndHandleMoveParameterPopupWindow(folderName);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		clickOnButton(driver, popupMoveParameterMoveButton, moveContent, tag);

		if(isDisplayed(driver, toastMsg)) {

			flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, toastMessageMoveParameter, parametersContent+" "+moveContent);
			tag=false;
		}

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(tag) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, toastMessageMoveParameter,parametersContent+" "+moveContent);
		}
		return flag;
	}

	public boolean clickOnDiscardParameterOnDetailsPage() {
		boolean flag=true;

		clickOnButton(driver, parameterDetailsDiscardButton, discardContent, true);

		flag=validateAndHandleDiscardParametersPopupWindow(flag, discardContent);

		return flag;
	}

	public static DataTestingParameters setParametersServiceParam(String jsonEntity) {

		DataTestingParameters param = new DataTestingParameters();

		try {

			param.setParameterName(WorkflowPage.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name"));
			param.setParameterDescription(WorkflowPage.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.info.description"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,"error occurs while setParametersServiceParam "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setParametersServiceParamUsingId(String testcaseId) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setParameterName(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, parameterTestCaseSheet, parameterTestCaseColumn, testcaseId,"ParameterName"));
			param.setParameterDescription(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, parameterTestCaseSheet, parameterTestCaseColumn, testcaseId,"parameterDescription"));
			param.setParameterJson(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, parameterTestCaseSheet, parameterTestCaseColumn, testcaseId,"parameterJson"));
			param.setParameterUpdateJson(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, parameterTestCaseSheet, parameterTestCaseColumn, testcaseId,"parameterUpdateJson"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,"error occurs while setParametersServiceParamUsingId "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setParametersKeysAndValue(String refKey) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String sheetName="keyvalue";
		String refColumn="refcol";
		try {

			param.setParameterKey(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"key"));
			param.setParameterValue(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"value"));
			param.setParameterRemark(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"note"));
			param.setParameterUpdateKey(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"updatekey"));
			param.setParameterUpdateValue(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"updatevalue"));
			param.setParameterUpdateRemark(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"updatenote"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,"error occurs while setParametersKeysAndValue "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setParametersService(String refKey) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String sheetName="parameters";
		String refColumn="refcol";
		try {

			param.setParameterName(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"parametername"));
			param.setParameterDescription(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"parameterdesc"));
			param.setParameterUpdateName(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"updateparameter"));
			param.setParameterUpdateDescription(xl.readUsingColNameAndCellContains(PARAMETEREXCELFILEPATH, sheetName, refColumn, refKey,"updatedesc"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,"error occurs while setParametersService "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setParametersServiceParamUsingExcel(String filePath, String sheetName, int rowNumber, boolean suffix) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String sf ="";
		try {

			if(suffix) {
				sf=System.getProperty("foldersuffix", "") ;
			}

			param.setTestScenarioName(xl.readUsingColName(filePath,sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(filePath,sheetName, rowNumber, "scenarioType"));
			param.setParameterName(xl.readUsingColName(filePath,sheetName, rowNumber, "ParameterName")+sf);
			param.setParameterDescription(xl.readUsingColName(filePath,sheetName, rowNumber, "parameterDescription"));
			param.setParameterJson(xl.readUsingColName(filePath,sheetName, rowNumber, "parameterJson"));
			param.setParameterUpdateJson(xl.readUsingColName(filePath,sheetName, rowNumber, "parameterUpdateJson"));
			param.setFieldValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(filePath,sheetName, rowNumber, "toastValidation"));
			param.setParameterKey(xl.readUsingColName(filePath,sheetName, rowNumber, "searchkey"));
			param.setFolderName(xl.readUsingColName(filePath,sheetName, rowNumber, "folderName"));
			param.setParameterValue(xl.readUsingColName(filePath,sheetName, rowNumber, "searchvalue"));
			param.setParameterRemark(xl.readUsingColName(filePath,sheetName, rowNumber, "searchremark"));
			param.setParameterType(xl.readUsingColName(filePath,sheetName, rowNumber, "parameterkeys"));
			param.setParameterFilename(xl.readUsingColName(filePath,sheetName, rowNumber, "fileName"));
			param.setExecutionstate(xl.readUsingColName(filePath,sheetName, rowNumber, "execute"));
			param.setUpdateParameterName(xl.readUsingColName(filePath,sheetName, rowNumber, "updateName"));
			param.setUpdateParameterDesc(xl.readUsingColName(filePath,sheetName, rowNumber, "updateDesc"));
			param.setTestType(xl.readUsingColName(filePath,sheetName, rowNumber, "testType"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,"error occurs while setParametersServiceParamUsingExcel "+e.toString());
		}
		return param;

	}

	public void validateParameterDetailsPageBeforeCreate(String parameterName, String folderName ) {


		try {
			BaseSuite.reportLog("---------- validating parameter details page before creating ------- ");

			BaseSuite.reportLog("-----------  Verifying breadcrumbs  ---------");

			validateElement(driver, breadcrumbHomeLink, "Home", "link");
			validateElement(driver, breadcrumbDataTestingLink, datatestingContent, "link");
			validateElement(driver, breadcrumbParametersLink, parametersContent, "link");
			validateElement(driver, returnElement(breadcrumbFolderName, dynamicName, folderName), folderName, " foldern name");
			validateElement(driver, returnElement(breadcrumbParameterName, dynamicName, parameterName), parameterName, " parameter name");

			validateElement(driver, paramerterDetailsIcon, parameterContent, "icon");
			validateElement(driver, returnElement(modulePageTitle, dynamicName, parameterName),parameterName, parametersContent+" "+attributeTitle);

			BaseSuite.reportLog("-----------  Verifying buttons  ---------");

			validateButtons(driver, parametersDetailsBeforeCreateButtonsCount, 8);

			verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, parameterDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, parameterDetailsDuplicateButton, duplicateContent, false);
			verifyVisibilityOfButtons(driver, parameterDetailsDeleteButton, deleteContent, false);

			verifyVisibilityOfButtons(driver, parameterDetailsAddFieldButton, "Add Keys", true);
			/**	verifyVisibilityOfButtons(driver, parameterDetailsImportButton, importContent, true);*/
			verifyVisibilityOfButtons(driver, parameterDetailsRemoveFieldButton, "Remove Keys", false);

			verifySearchField(driver, parameterDetailsSearchkeyField, placeholderSearchKey, placeholderSearchKey);

			validateElement(driver, parameterDetailsSearchkeyIcon, searchContent, "icon");

			BaseSuite.reportLog("-----------  Verifying columns  ---------");

			validateElement(driver, parameterDetailsMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver, parameterDetailsKeyColumn, keyContent, columnContent);
			validateElement(driver, parameterDetailsValueColumn, valueContents, columnContent);
			validateElement(driver, parameterDetailsNotesColumn, notesContent, columnContent);
			validateElement(driver, parameterDetailsActionsColumn, "Actions", columnContent);

			validateElement(driver, parameterDetailsNoRecordsToDisplay, noRecordsTodisplayContentp, labelContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateParameterDetailsPageBeforeCreate :: "+e.toString());
		}

	}

	public void validateParameterDetailsPageAfterCreate(String parameterName, String folderName ) {


		try {
			BaseSuite.reportLog("---------- validating parameter details page after creating ------- ");

			BaseSuite.reportLog("-----------  Verifying breadcrumbs  ---------");

			validateElement(driver, breadcrumbHomeLink, "Home", "link");
			validateElement(driver, breadcrumbDataTestingLink, datatestingContent, "link");
			validateElement(driver, breadcrumbParametersLink, parametersContent, "link");
			validateElement(driver, returnElement(breadcrumbFolderName, dynamicName, folderName), folderName, " folder name");
			validateElement(driver, returnElement(breadcrumbParameterName, dynamicName, parameterName), parameterName, " parameter name");
			getParameterIdOnParametersDetailsPage();

			validateElement(driver, paramerterDetailsIcon, parameterContent, "icon");
			validateElement(driver, returnElement(modulePageTitle, dynamicName, parameterName),parameterName, parametersContent+" "+attributeTitle);

			BaseSuite.reportLog("-----------  Verifying buttons  ---------");

			validateButtons(driver, parametersDetailsBeforeCreateButtonsCount, 8);

			verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);
			verifyVisibilityOfButtons(driver, parameterDetailsDiscardButton, discardContent, false);
			verifyVisibilityOfButtons(driver, parameterDetailsDuplicateButton, duplicateContent, true);
			verifyVisibilityOfButtons(driver, parameterDetailsDeleteButton, deleteContent, true);

			verifyVisibilityOfButtons(driver, parameterDetailsAddFieldButton, "Add Keys", true);
			verifyVisibilityOfButtons(driver, parameterDetailsImportButton, importContent, true);
			verifyVisibilityOfButtons(driver, parameterDetailsRemoveFieldButton, "Remove Keys", false);

			verifySearchField(driver, parameterDetailsSearchkeyField, placeholderSearchKey, placeholderSearchKey);

			validateElement(driver, parameterDetailsSearchkeyIcon, searchContent, "icon");

			BaseSuite.reportLog("-----------  Verifying columns  ---------");

			validateElement(driver, parameterDetailsMasterCheckbox, masterContent, checkboxContent);
			validateElement(driver, parameterDetailsKeyColumn, keyContent, columnContent);
			validateElement(driver, parameterDetailsValueColumn, valueContents, columnContent);
			validateElement(driver, parameterDetailsNotesColumn, notesContent, columnContent);
			validateElement(driver, parameterDetailsActionsColumn, "Actions", columnContent);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateParameterDetailsPageBeforeCreate :: "+e.toString());
		}

	}

	public String getParameterIdOnParametersDetailsPage() {
		String id =null;
		try {
			isDisplayedInLoop(driver, 3, breadcrumbParameterId);

			if(isDisplayed(driver, breadcrumbParameterId)) {

				id = getText(driver, breadcrumbParameterId);

				id = id.replaceAll(regexToRemoveBracess, "");

				BaseSuite.reportLog("Parameter id is :: "+id);
			}else {
				BaseSuite.reportFailLog("Parameter id is not visible ", "getParameterIdOnParametersDetailsPage");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getWorkflowIdOnWorkflowDetailsPage :: "+e.toString());

		}
		return id;
	}

	public boolean searchAndClickOnParameterNameOnParametersListingPage(String paramName, String folderName) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, paramName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, noRecordsToDisplayOnListingPage)) {

				if(flag) {

					folderName=folderPath(folderName);

					By paramLocator = returnTwoElements(parameterNameHyperLinkUsingFolderPath, dynamicFolderName, folderName, dynamicName, paramName);

					flag=searchParameterAndAct(paramLocator, paramName, folderName, clickContent);

					waitForExecution(1000);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Searched parameter name not found.","searchAndClickOnParameterNameOnParametersListingPage");

					flag=false;
				}
			}else {
				BaseSuite.skipReportLog("No parameter found for searched value : "+paramName);
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndClickOnParameterNameOnParametersListingPage "+e.toString());

			flag=false;
		}finally {

			if(!flag) {
				BaseSuite.reportFailLog("Searched parameter name not found.","searchAndClickOnParameterNameOnParametersListingPage");
			}
		}


		return flag;
	} 

	public boolean searchContainsAndClickOnParameterNameOnParametersListingPage(String paramName, String folderName) {
		boolean flag=true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, paramName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, noRecordsToDisplayOnListingPage)) {

				if(flag) {

					folderName=folderPath(folderName);

					By paramLocator = returnTwoElements(parameterNameHyperLinkUsingFolderPathStartWith, dynamicFolderName, folderName, dynamicName, paramName);

					flag=searchParameterAndAct(paramLocator, paramName, folderName, clickContent);

					waitForExecution(1000);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Searched parameter name not found..","searchContainsAndClickOnParameterNameOnParametersListingPage");

					flag=false;
				}
			}else {
				BaseSuite.skipReportLog("No parameter found for searched value :: "+paramName);
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchContainsAndClickOnParameterNameOnParametersListingPage "+e.toString());

			flag=false;
		}finally {

			if(!flag) {
				BaseSuite.reportFailLog("Searched parameter name not found..","searchContainsAndClickOnParameterNameOnParametersListingPage");
			}
		}


		return flag;
	} 

	public boolean searchParameterNameOnParametersListingPage(String paramName, String folderName) {
		boolean flag=true;

		try {
			flag=searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, paramName);

			if(elementNotVisible(driver, noRecordsToDisplayOnListingPage)) {

				if(flag) {

					folderName=folderPath(folderName);

					By paramLocator = returnTwoElements(parameterNameHyperLinkUsingFolderPath, dynamicFolderName, folderName, dynamicName, paramName);

					flag=searchParameterAndAct(paramLocator, paramName, folderName, "view");

					waitForExecution(1000);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Searched parameter name not found ","searchParameterNameOnParametersListingPage");

				}
			}else {
				BaseSuite.skipReportLog("Not found for searched value : "+paramName);
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchParameterNameOnParametersListingPage "+e.toString());

			flag=false;
		}finally {

			if(!flag) {
				BaseSuite.reportFailLog("Searched parameter name not found","searchParameterNameOnParametersListingPage");
			}
		}

		return flag;
	} 

	public boolean searchParameterNameOnParametersListingPageForCheck(String paramName, String folderName) {
		boolean flag=true;

		try {
			flag=searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, paramName);

			if(elementNotVisible(driver, noRecordsToDisplayOnListingPage)) {

				if(flag) {

					folderName=folderPath(folderName);

					By paramLocator = returnTwoElements(parameterNameHyperLinkUsingFolderPath, dynamicFolderName, folderName, dynamicName, paramName);

					flag=searchParameterAndAct(paramLocator, paramName, folderName, "view");

					waitForExecution(1000);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					flag=false;
				}
			}else {
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchParameterNameOnParametersListingPageForCheck "+e.toString());

			flag=false;
		}

		return flag;
	}

	public boolean searchParameterDescriptionOnParametersListingPage(String description) {
		boolean flag=true;

		try {
			flag=searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, description);

			if(elementNotVisible(driver, noRecordsToDisplayOnListingPage)) {

				if(flag) {

					/**			folderName=folderPath(folderName);

					By paramLocator = returnTwoElements(parameterDescUsingFolderPath, dynamicFolderName, folderName, dynamicName, paramName);**/

					String desc= getAttribute(driver, parameterDescriptionOnListing, attributeTextContent);

					flag=stringContainsOutput(desc, description, true);

					waitForExecution(1000);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Searched parameter Description not found ","searchParameterDescriptionOnParametersListingPage");

				}
			}else {
				BaseSuite.skipReportLog("No parameter found for searched value : "+description);
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchParameterDescriptionOnParametersListingPage "+e.toString());

			flag=false;
		}

		return flag;
	} 

	public boolean validateSearchFunctionality(String type, String paramName, String folderName, String description) {
		boolean flag=true;

		try {
			switch(type.toLowerCase()) {

			case "pname" :
				flag=searchParameterNameOnParametersListingPage(paramName, folderName);
				searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, "");
				break;

			case"pdescription" :
				flag=searchParameterDescriptionOnParametersListingPage( description);
				searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, "");
				break;

			default:

				break;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateSearchFunctionality "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateSearchFunctionalityOnDetailsPage(String type, String key, String value, String note) {
		boolean flag=true;

		try {
			switch(type.toLowerCase()) {

			case "pkey" :
				searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" "+keyContent, placeholderSearchKey, key);

				flag=viewAndValidateField(driver, returnElement(parameterDetailsDymanicKeyField, dynamicName, key), keyContent, key, true);

				searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" "+keyContent, placeholderSearchKey, "");
				break;

			case"pvalue" :
				searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" "+valueContents, placeholderSearchKey, value);

				flag=viewAndValidateField(driver, returnElement(parameterDetailsDymanicValueField, dynamicName, value), valueContents, value, true);

				searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" "+valueContents, placeholderSearchKey, "");
				break;
			case"pnote" :
				searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" "+notesContent, placeholderSearchKey, note);

				flag=viewAndValidateField(driver, returnElement(parameterDetailsDymanicNotesField, dynamicName, note), notesContent, note, true);

				searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" "+notesContent, placeholderSearchKey, "");
				break;
			default:

				break;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateSearchFunctionalityOnDetailsPage "+e.toString());
			flag=false;
		}

		return flag;
	}

	public static String folderPath(String folderName) {

		folderName=checkNullValue(folderName);

		if(!folderName.startsWith("/")) {
			folderName="/"+folderName;
		}
		return folderName;
	}

	public boolean searchAndSelectParameterCheckboxOnParametersListingPage(String paramName, String folderName) {
		boolean flag=true;

		try {
			flag=searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, paramName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(elementNotVisible(driver, noRecordsToDisplayOnListingPage)) {

				if(flag) {

					folderName=folderPath(folderName);

					By paramLocator = returnTwoElements(parameterCheckboxOnListing, dynamicFolderName, folderName, dynamicName, paramName);

					searchParameterAndAct(paramLocator, paramName, folderName, checkboxContent);

					/**selectcheckbox(paramLocator, "Name : "+paramName+" from folder : "+folderName);*/

					waitForExecution(1000);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}else {
					BaseSuite.reportFailLog("Searched parameter name not found","searchAndSelectParameterCheckboxOnParametersListingPage");

				}
			}else {
				BaseSuite.skipReportLog("No Parameter found for searched value : "+paramName);
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndSelectParameterCheckboxOnParametersListingPage "+e.toString());

			flag=false;
		}

		return flag;
	} 

	public void validateKeyAndValueOfParameters(String parameterJson) {


		/**	boolean flag=true;*/

		try {
			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			for(int i=0;i<keyList.size();i++) {

				String key=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathKey);
				String value=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathValue);
				String notes=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+i+jsonPathRemark);

				BaseSuite.reportLog("----------- verifying "+(i+1)+" parameter key : "+key+" & value : "+value+" & remark : "+notes  );

				/**			flag=searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" key", placeholderSearchKey, key);*/

				if(elementNotVisible(driver, parameterDetailsNoRecordsToDisplay)) {

					viewAndValidateField(driver, returnElement(parameterDetailsDymanicKeyField, dynamicName, key), keyContent, key, true);

					viewAndValidateField(driver, returnElement(parameterDetailsDymanicValueField, dynamicName, value), valueContents, value, true);

					viewAndValidateField(driver, returnElement(parameterDetailsDymanicNotesField, dynamicName, notes), notesContent, notes, true);

					verifyVisibilityOfButtons(driver, returnElement(parameterDetailsKeyEditButton, dynamicName, key), "Edit"+" "+keyContent, true);

					verifyVisibilityOfButtons(driver, returnElement(parameterDetailsKeyDeleteButton, dynamicName, key), deleteContent+" "+keyContent, true);

				}

				waitForExecution(1000);
			}

			/**		searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" key", placeholderSearchKey, "");*/

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateKeyAndValueOfParameters :: "+e.toString());

		}
	}

	public boolean viewParameterFunctionalityForValid(String parameterJson, String folderName) {

		boolean flag =true;

		try {

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);
			String parameterName=paramP.getParameterName();
			String description=paramP.getParameterDescription();

			validateParameterDetailsPageAfterCreate(parameterName, folderName);

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			viewAndValidateField(driver, paramerterDetailsDescField, paramNameContent, description, true);

			validateKeyAndValueOfParameters(parameterJson);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" viewParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateAndHandleRemoveAllParameterKeyPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeleteAllKeyTitle, popupDeleteAllKeyContent, "Delete Keys", "Do you want to delete the keys?");

			verifyVisibilityOfButtons(driver, popupDeleteAllKeyCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteAllKeyDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteAllKeyDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteAllKeyCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleRemoveWorkflowPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleRemoveParameterKeyPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeleteKeyTitle, popupDeleteKeyContent, "Delete Key", "Do you want to delete the key?");

			verifyVisibilityOfButtons(driver, popupDeleteKeyCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteKeyDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteKeyDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteKeyCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleRemoveWorkflowPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleDeleteParameterPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeleteParameterTitle, popupDeleteParameterContent, "Delete Parameter", "Do you want to delete the parameter?");

			verifyVisibilityOfButtons(driver, popupDeleteParameterCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteParameterDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteParameterDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteParameterCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleDeleteParameterPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleDeleteParametersPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDeleteParameterTitle, popupDeleteParameterContent, "Delete Parameters", "Do you want to delete the parameters?");

			verifyVisibilityOfButtons(driver, popupDeleteParameterCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDeleteParameterDelete, deleteContent, true);

			if(buttonName.equalsIgnoreCase(deleteContent)) {
				clickOnButton(driver, popupDeleteParameterDelete, buttonName, true);
			}else {
				clickOnButton(driver, popupDeleteParameterCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleDeleteParameterPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleDiscardParametersPopupWindow(boolean flag,String buttonName) {

		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validatePopupWindowContent(driver, flag, popupDiscardParameterTitle, popupDiscardParameterContent, "Discard Changes", "Do you want to discard the changes?");

			verifyVisibilityOfButtons(driver, popupDiscardParameterCancel, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupDiscardParameterDiscard, discardContent, true);

			if(buttonName.equalsIgnoreCase(discardContent)) {
				clickOnButton(driver, popupDiscardParameterDiscard, buttonName, true);
			}else {
				clickOnButton(driver, popupDiscardParameterCancel, cancelButtonContent, true);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleDiscardParametersPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleCopyParameterPopupWindow(String folderName) {
		boolean flag=true;
		try {

			waitForExecution(500);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String removetitle = getText(driver, popupCopyParameterTitle);

			flag = stringContainsOutput(removetitle, "Copy Parameter", true);

			if(flag) {

				String removecontents = getAttribute(driver, popupCopyParameterContent,attributeInnerText);

				flag = stringContainsOutput(removecontents, "You will be copying the parameter to the folder "+folderName, true);

			}

			verifyVisibilityOfButtons(driver, popupCopyParameterCancelButton, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupCopyParameterCopyButton, copyContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleCopyParameterPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public boolean validateAndHandleMoveParameterPopupWindow(String folderName) {
		boolean flag=true;
		try {
			waitForExecution(500);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String removetitle = getText(driver, popupMoveParameterTitle);

			flag = stringContainsOutput(removetitle, "Move Parameter", true);

			if(flag) {

				String removecontents = getAttribute(driver, popupMoveParameterContent,attributeInnerText);

				flag = stringContainsOutput(removecontents, "You will be moving the parameter to the folder "+folderName, true);

			}

			verifyVisibilityOfButtons(driver, popupMoveParameterCancelButton, cancelButtonContent, true);
			verifyVisibilityOfButtons(driver, popupMoveParameterMoveButton, moveContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleMoveParameterPopupWindow :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public boolean validateValueWithActual(By locator,String label,  String expected, String attribute) {

		boolean flag=true;

		try {
			if(!expected.isEmpty()) {
				BaseSuite.reportLog("verifying "+label+" with expected value");	
				if(isDisplayed(driver, locator)) {

					String actualValue=getAttribute(driver, locator, attribute);

					flag=stringOutput(actualValue, expected, flag);
				}else {
					BaseSuite.reportFailLog(label+" is not visible", "validateValueWithActual");

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateValueWithActual :: "+e.toString());
			flag=false;
		}


		return flag;
	}

	public void validateParameterDetailsOnListingPage(String parameterName, String folderName, String keyCount, String description) {

		try {
			folderName=folderPath(folderName); 

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("----------  Validating parameter details on listing page  ----------");

			validateElement(driver, returnTwoElements(parameterNameHyperLinkUsingFolderPath, dynamicFolderName, folderName, dynamicName, parameterName),parameterName,"hyperlink");

			validateElement(driver, returnElement(parameterFolderNameOnListing, dynamicFolderName, folderName),folderName," folder name");

			if(!keyCount.isEmpty()) {
				validateValueWithActual(parameterKeysCountOnListing, "# Of Keys", keyCount, attributeTextContent);
			}
			validateValueWithActual(parameterDescriptionOnListing, descriptionContent, description, attributeTextContent);

			String lastUpdated=getAttribute(driver, parameterLastUpdatedOnListing, attributeTextContent);

			if(!lastUpdated.isEmpty()) {
				BaseSuite.reportLog("Parameter last updated on :: "+lastUpdated);
			}else {
				BaseSuite.reportFailLog("Parameter last updated time not visible", "validateParameterDetailsOnListingPage");
			}

			String updatedBy=getAttribute(driver, parameterUpdatedByOnListing, attributeTitle);

			if(!updatedBy.isEmpty()) {
				BaseSuite.reportLog("Parameter last updated by :: "+updatedBy);
			}else {
				BaseSuite.reportFailLog("Parameter last updated by not visible", "validateParameterDetailsOnListingPage");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateParameterDetailsOnListingPage :: "+e.toString());
		}
	}


	public boolean searchFolderOrCreateNewFolder(String folderName, String icedqUser) {
		WorkflowServicePage wp = new WorkflowServicePage(driver);
		boolean state = true;
		try {
			if(isDisplayed(driver, folderSearchExpand)) {

				displayAndClick(driver, folderSearchExpand);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
			state = searchFolderFunctionality(folderName);

			if(!state) {
				wp.clickOnWorkflowTab();
				state=wp.searchAndCreateFolderHierarchy(folderName, icedqUser);
				clickOnParametersTab();
			}else {
				clickOnFolderSearchClearICon();
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchFolderOrCreateNewFolder :: "+e.toString());
		}
		return state;
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
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectcheckbox :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public int searchAndSelectParameters(int count, String parameterName ,String folderName) {

		try {
			if(parameterName.contains(";")) {

				String[] paramName = parameterName.split(";");

				count=paramName.length;

				for(int i=0;i<paramName.length;i++) {

					searchAndSelectParameterCheckboxOnParametersListingPage(paramName[i], folderName);
				}		

			}else {
				count=1;
				searchAndSelectParameterCheckboxOnParametersListingPage(parameterName, folderName);
			}

			searchFunctionalityMethod(driver, true, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, "");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndSelectParameters :: "+e.toString());
		}

		return count;
	}

	public int getLocatorIsDisplayCount(int x,By locator) {

		if(isDisplayed(driver, locator)) {

			x++;
		}
		return x;
	}

	public int searchAndSelectParameterFromFolder(boolean flag, String parameterNAme) {

		int x=0;
		try {
			String [] paramNAme = parameterNAme.split(";");

			for(int i=0;i<paramNAme.length;i++) {

				String value = paramNAme[i];
				String [] wkfl = value.split(",");
				String  pName = wkfl[0];
				String  fName = wkfl[1];

				searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, pName);

				fName=folderPath(fName);

				By paramLocator = returnTwoElements(parameterCheckboxOnListing, dynamicFolderName, fName, dynamicName, pName);

				flag=selectcheckbox(paramLocator, "Name : "+pName+" from folder : "+fName);

				if(flag) {
					x++;
				}
				waitForExecution(1000);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndSelectWorkflowFromFolder :: "+e.toString());
		}

		return x;
	}

	public void selectFolderFromPopupWindow(String folderName) {


		Actions action = new Actions(driver);
		try {
			BaseSuite.reportLog("Clicking on folder dropdown arrow...");

			javascript(driver, jscriptToClick, popupFolderDropDown);

			BaseSuite.validationReportLog("Clicked on folder dropdown arrow...");

			searchFunctionalityMethod(driver, true, popupFolderSearchField, popupFolderSearchButton,
					searchContent, searchContent, folderName);

			folderName=folderPath(folderName);

			isDisplayedInLoop(driver, 4, returnElement(popupFolderSearchFolderName, dynamicName, folderName));

			if(isDisplayed(driver, returnElement(popupFolderSearchFolderName, dynamicName, folderName))) {

				BaseSuite.reportLog("Clicking on folder name "+folderName);

				WebElement ele = driver.findElement(returnElement(popupFolderSearchFolderName, dynamicName, folderName));
				WebElement ele1 = driver.findElement(returnElement(popupFolderSearchSelectArrow, dynamicName, folderName));

				action.moveToElement(ele).click().perform();

				BaseSuite.validationReportLog("Clicked on folder name ");

				action.moveByOffset(60, 0).perform();

				BaseSuite.reportLog("Clicking on folder select icon "+folderName);

				action.moveToElement(ele1).click().build().perform();

				waitForExecution(1000);

				BaseSuite.validationReportLog("Clicked on folder select icon ");

			}else {
				BaseSuite.reportFailLog("Searched folder not found ","selectFolderFromPopupWindow");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectFolderFromPopupWindow :: "+e.toString());
		}
	}

	public boolean searchParameterFunctionality(boolean flag, String parameterName, String folderName, boolean expectedCondition) {
		try {

			flag = searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, parameterName);


			folderName = folderPath(folderName);

			By paramLocator = returnTwoElements(parameterNameHyperLinkUsingFolderPath, dynamicFolderName, folderName, dynamicName, parameterName);

			boolean isParamVisible = isDisplayed(driver, paramLocator);
			String logMessage = "Parameter " + parameterName + (isParamVisible ? " is" : " is not") + " displayed on listing page";


			if (isParamVisible == expectedCondition) {
				BaseSuite.validationReportLog(logMessage);
			} else {
				BaseSuite.reportFailLog(logMessage, "searchParameterFunctionality");
				flag = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " searchParameterFunctionality :: " + e.toString());
		}

		return flag;
	}


	public boolean checkParameterVisibilityOnListingPage(boolean flag,String parameterName, String folderName, boolean expectedCondition) {

		try {
			if(parameterName.contains(";")) {

				String[] paramName = parameterName.split(";");

				for(int i=0;i<paramName.length;i++) {

					searchParameterFunctionality(flag, paramName[i], folderName, expectedCondition);
				}
			}else {

				searchParameterFunctionality(flag, parameterName, folderName, expectedCondition);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkParameterVisibilityOnListingPage :: "+e.toString());
		}

		return flag;
	}

	public int searchAndSelectParameter(boolean flag, int count, String parameterName, String folderName) {

		if(parameterName.contains(";")) {
			return searchAndSelectParameters(count, parameterName, folderName);
		}else {
			return searchAndSelectParameterFromFolder(flag, parameterName);
		}
	}

	public boolean addNewKeyAndValueInParameter(boolean flag, String parameterJson,int num, String toastValidation) {

		try {
			String key1=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+num+jsonPathKey);
			String value=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+num+jsonPathValue);
			String notes=WorkflowPage.getJsonValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterKey+num+jsonPathRemark);

			notes=checkNullValue(notes);

			BaseSuite.reportLog("----------- Adding "+(num+1)+" parameter "+keyContent+" : "+key1+" & "+valueContents+" : "+value+" & remark : "+notes  );

			clickOnButton(driver, parameterDetailsAddFieldButton, "Add", true);

			waitForExecution(500);

			enterValueToTextField(driver, parameterDetailsKeyField,  keyContent+" "+fieldContent, key1);

			enterValueToTextField(driver, parameterDetailsValueField,  valueContents+" "+fieldContent, value);

			enterValueToTextField(driver, parameterDetailsNotesField,  notesContent+" "+fieldContent, notes);

			verifyVisibilityOfButtons(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

			clickOnButton(driver, parameterDetailsActionSaveButton, rightClickArrowContent, true);

			validateToastMessage(flag, "Repeated key", toastValidation);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" addNewKeyAndValueInParameter :: "+e.toString());
		}
		return flag;
	}

	public void searchAndSelectFolderOnAddNewPane(String folderPath , String module) {
		/**String release ="6.2";*/
		try {

			isDisplayedInLoop(driver, 2, folderDownArrow);

			displayAndClick(driver, folderDownArrow);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if(!isDisplayed(driver, addfolderSearchField)) {

				displayAndClick(driver, folderDownArrow);
			}

			if(folderPath.startsWith("/")) {
				folderPath=folderPath.substring(1);
			}
			if(folderPath.contains("/")) {

				String[] folders=folderPath.split("/");

				String childFolder = folders[folders.length - 1];

				searchFunctionalityMethod(driver, true, addfolderSearchField, folderSearchButton, searchContent, placeholderSearchFolder, childFolder);

			}else {

				searchFunctionalityMethod(driver, true, addfolderSearchField, folderSearchButton, searchContent, placeholderSearchFolder, folderPath);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(folderPath.startsWith("/")) {
				folderPath=folderPath.substring(1);
			}

			if(isDisplayed(driver, returnElement(validScrollFolder, dynamicName, folderPath))) {

				BaseSuite.reportLog("folder is visible : "+folderPath);

				displayAndClick(driver, returnElement(validScrollFolder, dynamicName, folderPath));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.reportLog("clicking on folder select icon");

				if(module.equalsIgnoreCase("parameter") || module.equalsIgnoreCase("schedule")) {

					displayAndClick(driver,returnElement(folderselectBtn, dynamicName, folderPath) );
				}else {
					displayAndClick(driver,returnElement(folderselectbtnNew, dynamicName, folderPath) );
				}
				BaseSuite.validationReportLog(folderPath+" Folder Clicked successfully");						

			}else {
				BaseSuite.reportFailLog("folder not visible : "+ folderPath,"searchAndSelectFolderOnAddNewPane");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndSelectFolderOnAddNewPane :: "+e.toString());
		}finally {
			isDisplayedInLoop(driver, 0, addfolderSearchField);
			if(isDisplayed(driver, addfolderSearchField)) {

				displayAndClick(driver, folderDownArrow);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

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

			waitForExecution(2000);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchUser "+e.toString());

		}		
	}
	public boolean validateNSelectUpdatedByUserInAdvanceSearch(boolean flag, String userNAme,String fullName,boolean checkstatus) {
		WorkflowPage wp = new WorkflowPage(driver);
		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchUpdatedByLabel, "Updated By");

				if(isDisplayed(driver, advancedSearchUpdatedByExpand)) {

					displayAndClick(driver, advancedSearchUpdatedByExpand);
				}

				if(!userNAme.isEmpty()) {

					searchUser(advancedSearchUpdatedBySearchBar, userNAme);

					By locator = returnElement(advanceSearchUpdatedByCheckbox, dynamicName, fullName);

					isDisplayedInLoop(driver, 4, locator);

					if(isDisplayed(driver, locator)) {
						if(checkstatus) {

							selectcheckbox(locator, userNAme);

							waitForExecution(2000);
							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							validateElement(driver, returnElement(updatedbynameOnListing, dynamicName, fullName), fullName, " icon");
						}else {
							wp.selectUncheckbox(locator, userNAme);
							waitForExecution(2000);
							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						}
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog(userNAme+" username not found kindly check", "validateNSelectUpdatedByUserInAdvanceSearch");
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectUpdatedByUserInAdvanceSearch :: "+e.toString());
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

				wp.compareTwoDates(flag, calanderDateFormat, startDate, endDate);

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
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectLastUpdatedInAdvanceSearch :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public void removeAppliedFilterofParameter() {

		isDisplayedInLoop(driver, 2, parametersAppliedFilterCross);

		if(isDisplayed(driver, parametersAppliedFilterCross)) {

			displayAndClick(driver, parametersAppliedFilterCross);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		}
	}

	public boolean advancedSearchFunctionalityForParameters( String userName,String fullName, String startdate, String enddate) {

		boolean flag =true;

		try {

			verifyIndividualLabel(driver, workflowAdvancedSearchTitle, advanceSearchContent);

			if(isDisplayed(driver, advancedSearchExpand)) {

				displayAndClick(driver, advancedSearchExpand);
			}

			removeAppliedFilterofParameter();

			String [] userN = userName.split(",");
			String [] fN = fullName.split(",");

			for(int i=0;i<userN.length;i++) {

				validateNSelectUpdatedByUserInAdvanceSearch(flag, userN[i],fN[i], true);
			}

			validateNSelectLastUpdatedInAdvanceSearch(flag, startdate, enddate);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" advancedSearchFunctionalityForParameters :: "+e.toString());
			flag=false;
		}

		return flag;
	}



	public void clickOnBreadcrumbLink(String link) {

		switch(link.toLowerCase().trim()) {

		case "home":

			clickOnButton(driver, breadcrumbHomeLink, "Home", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			waitForExecution(1000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 10, welcomeText);

			if(isDisplayed(driver, welcomeText)) {

				String name = getText(driver, welcomeText);

				BaseSuite.reportLog("Home page is visible "+name);

			}else {
				BaseSuite.reportFailLog("Home page not visible", "clickOnBreadcrumbLink");
			}

			break;

		case "data testing":

			clickOnButton(driver, breadcrumbDataTestingLink, datatestingContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			waitForExecution(1000);

			validateTitle(driver, returnElement(modulePageTitle, dynamicName,rulesContent), rulesContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			break;	

		case "parameters":

			clickOnButton(driver, breadcrumbParametersLink, parametersContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateTitle(driver, returnElement(modulePageTitle, dynamicName,parametersContent), parametersContent);


			break;	

		default:

			break;
		}
	}

	public boolean enterDetailsOfNewParameter(String parameterName, String folderName, String icedqUser ) {

		clickOnNewParameterButton(icedqUser);

		validateAddNewParameterPane();

		searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

		validatAndeEnterValueToTextField(driver, addNewParameterNameTitle, addNewParameterNameField,addNewParameterNameValidation, paramNameContent, placeholderName, parameterName, fieldValidationForEmptyParamName);

		boolean flag= clickOnButton(driver, addNewParameterNextButton, nextContent, true);

		if(!flag) { return false;}

		validateParameterDetailsPageBeforeCreate(parameterName, folderName);

		return flag;
	}

	public void dataTesting() {

		isDisplayedInLoop(driver,2,dataTesting);
		if(isDisplayed(driver, dataTesting)) {
			displayAndClick(driver,dataTesting);
			BaseSuite.validationReportLog("Clicked on the Data Testing service!!");}

	}
	public boolean  validateParametersBreadcrumbLinkNavigation(String parameterName, String folderName, String icedqUser ) {
		boolean flag=true;
		try {

			enterDetailsOfNewParameter(parameterName, folderName, icedqUser);

			BaseSuite.reportLog("Navigating to Parameters link on breadcrumb");

			clickOnBreadcrumbLink(parametersContent);

			flag=enterDetailsOfNewParameter( parameterName, folderName, icedqUser);

			if(!flag) { return false;}

			BaseSuite.reportLog("Navigating to data testing link on breadcrumb");

			clickOnBreadcrumbLink(datatestingContent);

			clickOnParametersTab();

			flag=enterDetailsOfNewParameter( parameterName, folderName, icedqUser);

			if(!flag) { return false;}

			BaseSuite.reportLog("Navigating to home link on breadcrumb ");

			clickOnBreadcrumbLink("Home");

			dataTesting();

			waitForExecution(3000);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnParametersTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateParametersBreadcrumbLinkNavigation :: "+e.toString());
		}

		return flag;
	}

	public void navigateToDataTestingTabs(By linklocator, By validateLocator, String label, String type) {

		try {
			navigateToLink(driver,linklocator, validateLocator, label+" "+type);

			clickOnButton(driver, nextgenTabDataTesting, datatestingContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnParametersTab();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" navigateToDataTestingTabs :: "+e.toString());
		}

	}

	public boolean validateParametersNavigationFunctionality(String parameterName, String folderName, String icedqUser) {

		boolean flag =true;

		try {

			validateParametersBreadcrumbLinkNavigation(parameterName, folderName, icedqUser);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName,rulesContent), returnElement(modulePageTitle, dynamicName,rulesContent), rulesContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, functionsContent), returnElement(modulePageTitle, dynamicName, functionsContent), functionsContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, workflowsContent), returnElement(modulePageTitle, dynamicName, workflowsContent), workflowsContent, subModuleContent);

			navigateToDataTestingTabs(returnElement(subModuleTab, dynamicName, instancesContent), returnElement(modulePageTitle, dynamicName, instancesContent), instancesContent, subModuleContent);

			navigateToDataTestingTabs(nextgenTabDashboardandReporting, breadcrumbDashboardAndReporting, "Dashboard and Reporting", moduleContent);

			navigateToDataTestingTabs(nextgenTabDataTesting,  returnElement(modulePageTitle, dynamicName, rulesContent), datatestingContent, moduleContent);

			navigateToDataTestingTabs(nextgenTabScheduler,  returnElement(modulePageTitle, dynamicName, "Schedules"), schedulerContent, moduleContent);

			navigateToDataTestingTabs(nextgenTabConnector, returnElement(modulePageTitle, dynamicName, connectionsContent), "Connectors", moduleContent);

			navigateToDataTestingTabs(nextgenTabAdmin, moduleUserPageTitle, "Administration", moduleContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateParametersNavigationFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateCopyParametersSidebar() {
		boolean flag =true;
		try {

			validateElement(driver, copyParametersSidebarTitle, "Copy Parameters", labelContent);

			validateElement(driver, copyParametersSidebarDiscardIcon, discardContent, "Icon");

			verifyVisibilityOfButtons(driver, copyParametersSidebarCopyButton, moveContent, false);

			verifyVisibilityOfButtons(driver, copyParametersSidebarCancelButton, cancelButtonContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateCopyParametersSidebar :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateMoveParametersSidebar() {
		boolean flag =true;
		try {

			validateElement(driver, moveParametersSidebarTitle, "Move Parameters", labelContent);

			validateElement(driver, moveParametersSidebarDiscardIcon, discardContent, "Icon");

			verifyVisibilityOfButtons(driver, moveParametersSidebarMoveButton, moveContent, false);

			verifyVisibilityOfButtons(driver, moveParametersSidebarCancelButton, cancelButtonContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateMoveParametersSidebar :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateDeleteParametersSidebar() {
		boolean flag =true;
		try {

			validateElement(driver, deleteParametersSidebarTitle, "Delete Parameters", labelContent);

			validateElement(driver, deleteParametersSidebarDiscardIcon, discardContent, "Icon");

			verifyVisibilityOfButtons(driver, deleteParametersSidebardeleteButton, deleteContent, true);

			verifyVisibilityOfButtons(driver, deleteParametersSidebarCancelButton, cancelButtonContent, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateDeleteParametersSidebar :: "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean validateBulkChangesNotify(int numberOfEntity,String changesType, String folderName) {
		String notify ="";
		String getMsg="";
		String foldersContent=" folder.";
		boolean flag=true;
		try {

			if (numberOfEntity==1) {

				if (changesType.equalsIgnoreCase("copy")) {

					notify = "You will be Copying " + numberOfEntity + " parameter to " + folderName + foldersContent;
					getMsg = getAttribute(driver, copyParametersSidebariconNotify, attributeTextContent);

				} else if (changesType.equalsIgnoreCase("move")) {
					notify = "You will be Moving " + numberOfEntity + " parameter to " + folderName + foldersContent;
					getMsg = getAttribute(driver, copyParametersSidebariconNotify, attributeTextContent);

				} else if (changesType.isEmpty()) {
					notify = "You will be deleting " + numberOfEntity + " parameter.";
					getMsg = getAttribute(driver, deleteParametersSidebariconNotify, attributeTextContent);
				} 
			}else if (numberOfEntity>1) {

				if (changesType.equalsIgnoreCase("copy")) {

					notify = "You will be Copying " + numberOfEntity + " parameters to " + folderName + foldersContent;
					getMsg = getAttribute(driver, copyParametersSidebariconNotify, attributeTextContent);

				} else if (changesType.equalsIgnoreCase("move")) {
					notify = "You will be Moving " + numberOfEntity + " parameters to " + folderName + foldersContent;
					getMsg = getAttribute(driver, copyParametersSidebariconNotify, attributeTextContent);

				} else if (changesType.isEmpty()) {
					notify = "You will be deleting " + numberOfEntity + " parameters.";
					getMsg = getAttribute(driver, deleteParametersSidebariconNotify, attributeTextContent);
				} 
			}
			flag=stringOutput(getMsg.trim(), notify.trim(), true);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateBulkChangesNotify :: "+e.toString());
			flag=false;

		}
		return flag;
	}

	public void clickOnCopyToClipboard() {
		isDisplayedInLoop(driver, 2, bulkChangesCopyToClipboard);
		if(isDisplayed(driver, bulkChangesCopyToClipboard)) {

			clickOnButton(driver, bulkChangesCopyToClipboard, "Copy to clipboard", true);

			captureToastMsg(driver,toastMsg, toastMsgClosedBtn, "Copied to clipboard.", attributeAriaLabel);

		}else {
			BaseSuite.reportFailLog("Copy to clipboard icon not visible", "clickOnCopyToClipboard");
		}

	}

	public boolean validateProgressOfBulkChanges(boolean flag) {
		String methodName = "validateProgressOfBulkChanges";
		int a=0;
		try {
			isDisplayedInLoop(driver, 2, bulkChangesRefreshLogs);

			if(isDisplayed(driver, bulkChangesRefreshLogs)) {

				clickOnButton(driver, bulkChangesRefreshLogs, "Refresh logs", true);

				while(!isDisplayed(driver, bulkChangesCopyToClipboard) && a<=10) {
					displayAndClick(driver, bulkChangesRefreshLogs);
					a++;
				}

				clickOnCopyToClipboard();

				BaseSuite.reportLog("-------------- checking bulk changes logs... ");

				String progCon = getAttribute(driver, bulkChangesLogs, attributeInnerText);

				if(!progCon.isEmpty()) {

					String [] bulklog = progCon.split("\n");

					for(int i=0;i<bulklog.length;i++) {

						BaseSuite.reportLog(bulklog[i]);

					}

				}else {

					BaseSuite.reportFailLog("Progress logs not visible, https://icedqsoft.atlassian.net/browse/DAT-7343", methodName);
				}

			}else {
				BaseSuite.reportFailLog("Refresh logs icon not visible", methodName);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+methodName+" :: "+e.toString());
			flag=false;
		}finally {

			isDisplayedInLoop(driver, 2, bulkChangesDoneButton);
			if(isDisplayed(driver, bulkChangesDoneButton)) {
				clickOnButton(driver, bulkChangesDoneButton, "Done", true);
			}
		}
		return flag;


	}

	//main methods

	public boolean createParameterFunctionalityForValid(String parameterJson, String folderName, String icedqUser) {

		boolean flag =true;

		try {

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);
			String parameterName=paramP.getParameterName();
			String description=paramP.getParameterDescription();

			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			flag=clickOnNewParameterButton(icedqUser);

			if(flag && (icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=validateAddNewParameterPane();

				if(!flag) { return false;}

				/**	selectFolderOfAddNewParameterPane(flag, folderName);**/

				searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(!parameterName.isEmpty()) {

					flag = validatAndeEnterValueToTextField(driver, addNewParameterNameTitle, addNewParameterNameField,addNewParameterNameValidation, paramNameContent, placeholderName, parameterName, fieldValidationForEmptyParamName);

					if(flag) {

						flag= clickOnButton(driver, addNewParameterNextButton, nextContent, true);

						if(!flag) { return false;}

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						waitForExecution(1000);

						validateParameterDetailsPageBeforeCreate(parameterName, folderName);

						validateAndEnterParameterOverview(flag, parameterName, description);

						enterKeyAndValueOfParameters(parameterJson);

						flag=clickOnSaveButtonAndValidateToast(flag, toastMessageSaveParameter);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateParameterDetailsPageAfterCreate(parameterName, folderName);

						clickOnParametersTab();

						validateParameterDetailsOnListingPage(parameterName,folderName, String.valueOf(keyList.size()), description);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createParameterFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean createParameterFunctionalityUsingExcel(DataTestingParameters xparam, DataTestingParameters param, String folderName, String icedqUser) {

		boolean flag =true;
		int keys =1;
		try {
			String keyslist = xparam.getParameterType();
			if(keyslist.contains(",")) {
				String [] key= keyslist.split(","); 

				keys = key.length;
			}else {
				keys = 1;
			}
			flag=clickOnNewParameterButton(icedqUser);

			if(flag && (icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=validateAddNewParameterPane();

				/**	selectFolderOfAddNewParameterPane(flag, folderName);**/

				searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(!param.getParameterName().isEmpty()) {

					flag = validatAndeEnterValueToTextField(driver, addNewParameterNameTitle, addNewParameterNameField,addNewParameterNameValidation, paramNameContent, placeholderName, param.getParameterName(), fieldValidationForEmptyParamName);

					if(flag) {

						flag=clickOnButton(driver, addNewParameterNextButton, nextContent, true);

						if(!flag) { return false;}

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						waitForExecution(1000);

						validateParameterDetailsPageBeforeCreate(param.getParameterName(), folderName);

						validateAndEnterParameterOverview(flag, param.getParameterName(), param.getParameterDescription());

						addParameterKeyAndValueValid(keyslist);

						flag=clickOnSaveButtonAndValidateToast(flag, toastMessageSaveParameter);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateParameterDetailsPageAfterCreate(param.getParameterName(), folderName);

						clickOnParametersTab();

						removeAppliedFilterofParameter(true);

						validateParameterDetailsOnListingPage(param.getParameterName(),folderName, String.valueOf(keys), param.getParameterDescription());
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createParameterFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean createParameterValid(DataTestingParameters xparam,String folderName, String icedqUser) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(xparam.getParameterName().contains(",")) {

				iceuserName= xparam.getParameterName().split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setParametersService(iceuserName[i]);

					createParameterFunctionalityUsingExcel(xparam, param, folderName,icedqUser);

				}

			}else {

				DataTestingParameters param = setParametersService(xparam.getParameterName());

				createParameterFunctionalityUsingExcel(xparam, param, folderName,icedqUser);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createParameterValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean addParameterKeyAndValueValid(String  parameterKeys) {
		String[] iceuserName=null;
		boolean flag =true;

		try {

			if(parameterKeys.contains(",")) {

				iceuserName= parameterKeys.split(","); 

				for(int i=0;i<iceuserName.length;i++) {

					DataTestingParameters param = setParametersKeysAndValue(iceuserName[i]);

					enterKeyAndValueOfParametersUsingExcel(i+1, param.getParameterKey());

				}

			}else {

				DataTestingParameters param = setParametersKeysAndValue(parameterKeys);

				enterKeyAndValueOfParametersUsingExcel(1, param.getParameterKey());

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" addParameterKeyAndValueValid "+e.toString());
			flag =false;
		}

		return flag;

	}

	public boolean viewParameterFunctionality(String parameterName, String parameterJson, String folderName) {

		boolean flag =true;

		try {

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);
			String description=paramP.getParameterDescription();

			validateParameterDetailsPageAfterCreate(parameterName, folderName);

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			viewAndValidateField(driver, paramerterDetailsDescField, paramNameContent, description, true);

			validateKeyAndValueOfParameters(parameterJson);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" viewParameterFunctionality :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean updateParameterFunctionalityForValid(String parameterJson,String updateParameterJson, String folderName, String icedqUser) {

		boolean flag =true;

		try {

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);
			String parameterName=paramP.getParameterName();
			String description=paramP.getParameterDescription();

			DataTestingParameters updateparamP = setParametersServiceParam(updateParameterJson);
			String upParameterName=updateparamP.getParameterName();
			String upDescription=updateparamP.getParameterDescription();

			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(updateParameterJson, jsonPathParameterkeyList);

			/**	validateNextgenIcedqModuleAndSubModules();**/

			if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateParameterDetailsPageAfterCreate(parameterName, folderName);}

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField,parameterDetailsNameFieldValidation, paramNameContent, placeholderName, upParameterName, fieldValidationForEmptyParamName);

			viewAndValidateField(driver, paramerterDetailsDescField, paramNameContent, description, true);

			validatAndeEnterValueToTextField(driver, paramerterDetailsDescTitle, paramerterDetailsDescField,parameterDetailsDescValidation, descriptionContent, placeholderDescription, upDescription, "");

			selectcheckbox(parameterDetailsMasterCheckbox, masterContent+" "+checkboxContent+" "+keyContent);

			clickOnButton(driver, parameterDetailsRemoveFieldButton, "Remove "+keyContent, true);

			validateAndHandleRemoveAllParameterKeyPopupWindow(flag, deleteContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			validateElement(driver, parameterDetailsNoRecordsToDisplay, noRecordsTodisplayContentp, labelContent);

			verifyVisibilityOfButtons(driver, parameterDetailsDiscardButton, discardContent, true);

			enterKeyAndValueOfParameters(updateParameterJson);

			if((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=clickOnSaveButtonAndValidateToast(flag, "");

				clickOnParametersTab();

				validateParameterDetailsOnListingPage(upParameterName,folderName, String.valueOf(keyList.size()), upDescription);

			}else {
				flag=clickOnSaveButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}	

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean duplicateParameterFunctionalityForValid(String parameterJson, String folderName, String icedqUser) {
		boolean useExcel = false;
		boolean flag =true;
		XLUtils xl = new XLUtils();
		try {
			/**	validateNextgenIcedqModuleAndSubModules();**/

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);

			String description=paramP.getParameterDescription();

			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			if(icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent)){

				flag=clickOnDuplicateButtonAndValidateToast(flag, toastMessageDuplicateParameter);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				String duplicatedParamName = getValue(driver, paramerterDetailsNameField);

				viewParameterFunctionality(duplicatedParamName, parameterJson, folderName);

				clickOnParametersTab();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateParameterDetailsOnListingPage(duplicatedParamName,folderName, String.valueOf(keyList.size()), description);

				if(useExcel) { 
					xl.writeToExcel(duplicatedParamName, PARAMETEREXCELFILEPATH, "duplicateParam", 1, icedqUser);
				}else { 
					System.setProperty(icedqUser+"dupP", duplicatedParamName);
				}


			}else {
				clickOnDuplicateButtonAndValidateToast(flag, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" duplicateParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean editParameterKeyFunctionalityForValid(String parameterJson,String parameterName, String updateKeyValue, String folderName, String icedqUser) {

		boolean flag =true;


		try {
			/**	validateNextgenIcedqModuleAndSubModules();**/

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);

			String description=paramP.getParameterDescription();

			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateParameterDetailsPageAfterCreate(parameterName, folderName);}

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if(updateKeyValue.contains(";")) {

				String[] keyValueList = updateKeyValue.split(";");

				for(int i=0;i<keyValueList.length;i++) {

					String [] keyValue = keyValueList[i].split(",");

					searchAndEditParameterKeyValue(flag, keyValue[0], keyValue[1], keyValue[2], keyValue[3],"");

				}		

			}else {
				if(updateKeyValue.contains(",")) {

					String [] keyValue = updateKeyValue.split(",");

					searchAndEditParameterKeyValue(flag, keyValue[0], keyValue[1], keyValue[2], keyValue[3],"");
				}
			}
			if((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=clickOnSaveButtonAndValidateToast(flag, "");

				clickOnParametersTab();

				validateParameterDetailsOnListingPage(parameterName,folderName, String.valueOf(keyList.size()), description);

			}else {
				flag=clickOnSaveButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}	

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" editParameterKeyFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean deleteParameterKeyFunctionalityForValid(String parameterJson,String parameterName, String deleteKeyValue, String folderName, String icedqUser) {

		boolean flag =true;

		int deleteCount=0;		
		try {

			/**	validateNextgenIcedqModuleAndSubModules();**/

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);

			String description=paramP.getParameterDescription();

			List<String> keyList = WorkflowPage.getJsonArrayValueUsingJsonPathExpreesion(parameterJson, jsonPathParameterkeyList);

			if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateParameterDetailsPageAfterCreate(parameterName, folderName);}

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if(deleteKeyValue.contains(",")) {

				String[] keyValueList = deleteKeyValue.split(",");
				deleteCount=keyValueList.length;
				for(int i=0;i<keyValueList.length;i++) {

					searchAndDeleteParameterKeyValue(flag, keyValueList[i]);
				}		

			}else {
				deleteCount=1;
				searchAndDeleteParameterKeyValue(flag, deleteKeyValue);
			}
			if((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=clickOnSaveButtonAndValidateToast(flag, "");

				clickOnParametersTab();

				deleteCount=keyList.size()-deleteCount;

				validateParameterDetailsOnListingPage(parameterName,folderName, String.valueOf(deleteCount), description);

			}else {
				flag=clickOnSaveButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}	

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteParameterKeyFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean deleteParameterFunctionalityForValid(String parameterJson,String parameterName, String folderName, String icedqUser) {

		boolean flag =true;

		try {
			log.info(parameterJson);
			/**	validateNextgenIcedqModuleAndSubModules();**/

			if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateParameterDetailsPageAfterCreate(parameterName, folderName);}

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=clickOnDeleteParameterButtonAndValidateToast(flag, toastMessageDeleteParameter);

				clickOnParametersTab();

				checkParameterVisibilityOnListingPage(flag, parameterName, folderName, false);

			}else {

				clickOnButton(driver, parameterDetailsDeleteButton, deleteContent, true);

				flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, parametersContent+" "+deleteContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnParametersTab();

				checkParameterVisibilityOnListingPage(flag, parameterName, folderName, true);
			}

			clickOnButton(driver, refreshButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}


	public boolean copyParameterFunctionalityForValid(String parameterName, String folderName, String anotherFolder, String icedqUser) {
		boolean tag =true;
		boolean flag =true;
		int count=1;
		try {

			validateParameterListingPage();

			count=searchAndSelectParameters(count, parameterName, folderName);

			clickOnButton(driver, moreOptionButton, moreOptionContent, true);

			moveToElementFieldByJavaScript(moreOptionButton, moreOptionContent);

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				/**		flag=clickOnButton(driver, copyButton, copyContent, true);**/

				clickOnFieldByJavaScript(copyButton, copyContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				validateCopyParametersSidebar();

				searchAndSelectFolderOnAddNewPane(anotherFolder, parameterContent);

				validateBulkChangesNotify(count, copyContent, anotherFolder);

				clickOnButton(driver, copyParametersSidebarCopyButton, copyContent, true);

				validateProgressOfBulkChanges(flag);

				if (!folderName.equalsIgnoreCase(anotherFolder)) {

					checkParameterVisibilityOnListingPage(flag, parameterName, folderName, true);
				} 

			}else {

				/**	clickOnButton(driver, copyButton, copyContent, true);**/

				clickOnFieldByJavaScript(copyButton, copyContent);

				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, parametersContent+" "+copyContent);
					tag=false;
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(tag) {
					flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,parametersContent+" "+copyContent);
				}

			}
			clickOnButton(driver, refreshButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" copyParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}finally {


			isDisplayedInLoop(driver, 2, popupCopyParameterCancelButton);
			if(isDisplayed(driver, popupCopyParameterCancelButton)) {
				clickOnButton(driver, popupCopyParameterCancelButton, cancelButtonContent, true);
			}

			clickOnRefreshOnParameterListingPage();
		}

		return flag;

	}

	public boolean moveParameterFunctionalityForValid(String parameterName, String folderName, String anotherFolder, String icedqUser) {
		boolean tag =true;
		boolean flag =true;
		int count=1;
		try {

			validateParameterListingPage();

			count=searchAndSelectParameters(count, parameterName, folderName);

			clickOnButton(driver, moreOptionButton, moreOptionContent, true);

			moveToElementFieldByJavaScript(moreOptionButton, moreOptionContent);

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				/**	flag=clickOnButton(driver, moveButton, moveContent, true);**/

				clickOnFieldByJavaScript(moveButton, moveContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);


				validateMoveParametersSidebar();

				searchAndSelectFolderOnAddNewPane(anotherFolder, parameterContent);

				validateBulkChangesNotify(count, moveContent, anotherFolder);

				clickOnButton(driver, moveParametersSidebarMoveButton, moveContent, true);

				validateProgressOfBulkChanges(flag);

				if (!folderName.equalsIgnoreCase(anotherFolder)) {

					checkParameterVisibilityOnListingPage(flag, parameterName, anotherFolder, true);
				} 

			}else {

				/**	clickOnButton(driver, moveButton, moveContent, true);**/
				clickOnFieldByJavaScript(moveButton, moveContent);

				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, parametersContent+" "+copyContent);
					tag=false;
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(tag) {
					flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,parametersContent+" "+copyContent);
				}

			}

			clickOnButton(driver, refreshButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" moveParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}finally {

			isDisplayedInLoop(driver, 2, popupMoveParameterCancelButton);
			if(isDisplayed(driver, popupMoveParameterCancelButton)) {
				clickOnButton(driver, popupMoveParameterCancelButton, cancelButtonContent, true);
			}

			clickOnRefreshOnParameterListingPage();
		}

		return flag;

	}

	public void clickOnFieldByJavaScript(By locator, String label) {

		BaseSuite.reportLog("Clicking on "+label);
		javascript(driver, jscriptToClick, locator);
		BaseSuite.validationReportLog("Clicked on "+label);
	}

	public void moveToElementFieldByJavaScript(By locator, String label) {

		BaseSuite.reportLog("Mouse hovoring on "+label);
		javascript(driver, jscriptToMouseHover, locator);
		BaseSuite.validationReportLog("Mouse hovored on "+label);
	}

	public boolean deleteParameterFromListingPageFunctionalityForValid(String parameterName, String folderName, String icedqUser) {
		boolean tag =true;
		boolean flag =true;
		int count=1;
		try {

			validateParameterListingPage();

			count=searchAndSelectParameters( count, parameterName, folderName);

			clickOnButton(driver, moreOptionButton, moreOptionContent, true);

			moveToElementFieldByJavaScript(moreOptionButton, moreOptionContent);

			if ((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				/**	flag=clickOnButton(driver, deleteButton, deleteContent, true);**/

				clickOnFieldByJavaScript(deleteButton, deleteContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				validateDeleteParametersSidebar();

				validateBulkChangesNotify(count, "", folderName);

				clickOnButton(driver, deleteParametersSidebardeleteButton, deleteContent, true);

				validateProgressOfBulkChanges(flag);

				checkParameterVisibilityOnListingPage(flag, parameterName, folderName, false);

			}else {

				/**	clickOnButton(driver, deleteButton, deleteContent, true);**/

				clickOnFieldByJavaScript(deleteButton, deleteContent);

				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, parametersContent+" "+copyContent);
					tag=false;
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(tag) {
					flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,parametersContent+" "+copyContent);
				}

			}

			clickOnButton(driver, refreshButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteParameterFromListingPageFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean discardParameterFunctionalityForValid(String parameterJson, String folderName, String icedqUser) {

		boolean flag =true;

		try {

			DataTestingParameters paramP = setParametersServiceParam(parameterJson);
			String parameterName=paramP.getParameterName();
			String description=paramP.getParameterDescription();

			flag=clickOnNewParameterButton(icedqUser);

			if(flag && (icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=validateAddNewParameterPane();

				/**selectFolderOfAddNewParameterPane(flag, folderName);*/

				searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(!parameterName.isEmpty()) {

					flag = validatAndeEnterValueToTextField(driver, addNewParameterNameTitle, addNewParameterNameField,addNewParameterNameValidation, paramNameContent, placeholderName, parameterName, fieldValidationForEmptyParamName);

					if(flag) {

						flag=clickOnButton(driver, addNewParameterNextButton, nextContent, true);

						if(!flag) { return false;}

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						waitForExecution(1000);

						validateParameterDetailsPageBeforeCreate(parameterName, folderName);

						validateAndEnterParameterOverview(flag, parameterName, description);

						enterKeyAndValueOfParameters(parameterJson);

						flag=clickOnDiscardParameterOnDetailsPage();

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" discardParameterFunctionalityForValid :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public boolean validateNoRecordsToDisplay(By locator) {
		boolean flag =true;
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		if(isDisplayed(driver, locator)) {

			BaseSuite.validationReportLog("No records to display is visible");

		}else {
			BaseSuite.reportFailLog("No records to display is not visible","validateNoRecordsToDisplay");
			flag=false;
		}
		return flag;
	}

	public boolean updateParameterWithInvalidConfiguration(DataTestingParameters params, String folderName, String icedqUser) {
		boolean flag =true;


		try {

			DataTestingParameters paramP = setParametersServiceParam(params.getParameterUpdateJson());
			String parameterName=params.getParameterName();
			String description=params.getParameterDescription();
			String fieldValidation=params.getFieldValidationMessage();
			String toastValidation=params.getToastValidationMessage();

			if ((icedqUser.toLowerCase().contains(ownerContent)
					|| icedqUser.toLowerCase().contains(contributorContent))) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				switch (params.getScenarioType().toLowerCase()) {

				case "overviewname":

					searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					flag=enterValueToFieldForInvalidDetails(driver, paramerterDetailsNameField, parameterDetailsNameFieldValidation, parameterContent,  paramP.getParameterName(), fieldValidation);

					/**
					 * flag=wp.validatAndeEnterValueToTextFieldForValidation(flag,
					 * paramerterDetailsNameTitle, paramerterDetailsNameField, paramNameContent,
					 * placeholderName, paramP.getParameterName(), fieldValidation);
					 **/

					verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);

					if(paramP.getParameterName().length()<20) {
						getParameterIdOnParametersDetailsPage();
					}
					break;

				case "overviewdesc":

					searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					flag=enterValueToFieldForInvalidDetails(driver, paramerterDetailsDescField, parameterDetailsDescValidation, descriptionContent, paramP.getParameterDescription(), fieldValidation);

					/**
					 * flag=wp.validatAndeEnterValueToTextFieldForValidation(flag,
					 * paramerterDetailsDescTitle, paramerterDetailsDescField, descriptionContent,
					 * placeholderDescription, paramP.getParameterDescription(), fieldValidation);
					 **/
					verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);

					break;

				case "invalidkey" :

					searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					flag=enterKeyAndValueOfParametersForInvalid(params.getParameterUpdateJson());

					verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);

					break;

				case "invalidkeyupdate" :

					searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					String key=WorkflowPage.getJsonValueUsingJsonPathExpreesion(params.getParameterUpdateJson(), jsonPathParameterKey+0+jsonPathKey);

					flag=searchAndEditParameterKeyValueForInvalid(true, params.getParameterKey(), key);

					verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);

					break;	

				case "searchparameter" :

					searchFunctionalityMethod(driver, flag, parametersSearchField, parametersSearchIcon, paramSearchContent, placeholderSearchParameter, parameterName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					flag=validateNoRecordsToDisplay(noRecordsToDisplayOnListingPage);

					break;	

				case "searchkey" :

					searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon,
							searchContent + " key", placeholderSearchKey, params.getParameterKey());

					flag=validateNoRecordsToDisplay(parameterDetailsNoRecordsToDisplay);

					break;

				case "existing" :

					flag=searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

					validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField, parameterDetailsNameFieldValidation,paramNameContent, placeholderName, paramP.getParameterName(), fieldValidationForEmptyParamName);

					viewAndValidateField(driver, paramerterDetailsDescField, descriptionContent, description, true);

					validatAndeEnterValueToTextField(driver, paramerterDetailsDescTitle, paramerterDetailsDescField, parameterDetailsDescValidation,descriptionContent, placeholderDescription,  paramP.getParameterDescription(), "");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					enterKeyAndValueOfParameters(params.getParameterUpdateJson());

					flag=clickOnSaveButtonAndValidateToast(flag, "Parameter name '"+paramP.getParameterName()+"' already exists.");

					clickOnParametersTab();

					break;

				case "addexistingkey" :

					flag=searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					flag=addNewKeyAndValueInParameter(flag, params.getParameterUpdateJson(), 0, toastValidation);

					clickOnButton(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);

					waitForExecution(1000);

					clickOnParametersTab();

					break;

				case "editexistingkey" :

					flag=searchAndClickOnParameterNameOnParametersListingPage(parameterName,folderName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					String key1=WorkflowPage.getJsonValueUsingJsonPathExpreesion(params.getParameterUpdateJson(), jsonPathParameterKey+0+jsonPathKey);
					String value=WorkflowPage.getJsonValueUsingJsonPathExpreesion(params.getParameterUpdateJson(), jsonPathParameterKey+0+jsonPathValue);
					String notes=WorkflowPage.getJsonValueUsingJsonPathExpreesion(params.getParameterUpdateJson(), jsonPathParameterKey+0+jsonPathRemark);

					notes=checkNullValue(notes);

					flag=searchAndEditParameterKeyValue(flag, params.getParameterKey(), key1, value, notes, toastValidation);

					clickOnButton(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);	

					clickOnParametersTab();

					break;

				default:

					break;
				}
			} 

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateParameterWithInvalidConfiguration :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	String disableTContent = "disable";

	private void waitForSpinnerToDisappear() {
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	}

	private void waitForElementToBePresent(By locator, int timeout) {
		isDisplayedInLoop(driver, timeout, locator);
	}

	private boolean isElementPresent(By locator) {
		return isDisplayed(driver, locator);
	}

	private boolean canNavigateToNextPage() {
		if (!isDisplayed(driver, parameterListingNextPageArrow)) return false;

		String status = getAttribute(driver, parameterListingNextPageArrow, attributeClass);
		if (status.contains(disableTContent)) {
			BaseSuite.reportLog("Next page arrow is disabled.");
			return false;
		}

		List<String> pagination = getPaginationDetails(driver, parameterListingPageMsg, parameterListingPageBar, noRecordsToDisplayOnListingPage, parameterListingContent);
		return Integer.parseInt(pagination.get(1)) != 0;
	}

	private void clickNextPage() {
		clickOnButton(driver, parameterListingNextPageArrow, nextContent + " page", true);
		waitForSpinnerToDisappear();
	}

	public boolean searchParameterAndAct(By locator, String name, String folderName, String type) {
		boolean isFound = false;
		boolean hasNextPage = true;
		int pageNumber = 1;

		try {
			while (hasNextPage) {
				BaseSuite.reportLog("Searching parameter name: " + name + " on page number: " + pageNumber);

				waitForSpinnerToDisappear();
				waitForElementToBePresent(locator, 3);

				if (isElementPresent(locator)) {
					BaseSuite.reportLog("Parameter name: " + name + " found on page number: " + pageNumber);

					switch (type.toLowerCase()) {
					case "checkbox":
						isFound = selectcheckbox(locator, "Name: " + name + " from folder: " + folderName);
						break;
					case "view":
						isFound = validateElement(driver, locator, name, "hyperlink");
						break;
					case "click":
						BaseSuite.reportLog("Clicking on parameter hyperlink: " + name);
						displayAndClick(driver, locator);
						BaseSuite.reportLog("Clicked on parameter hyperlink: " + name);
						isFound = true;
						break;
					default : 

						break;
					}

					waitForSpinnerToDisappear();
					break;
				}

				if (!canNavigateToNextPage()) {
					hasNextPage = false;
				} else {
					clickNextPage();
					pageNumber++;
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " searchParameterAndAct :: " + e.toString());
		}

		return isFound;
	}

	public boolean createParameterWithInvalidConfiguration(DataTestingParameters params, String folderName, String icedqUser) {
		boolean flag = true;

		try {
			DataTestingParameters paramP = setParametersServiceParam(params.getParameterJson());
			String parameterName = params.getParameterName();
			String description = params.getParameterDescription();
			String fieldValidation = params.getFieldValidationMessage();
			String toastValidation = params.getToastValidationMessage();

			flag = clickOnNewParameterButton(icedqUser);

			if (!flag || (!icedqUser.toLowerCase().contains(ownerContent) && !icedqUser.toLowerCase().contains(contributorContent))) {
				return false;
			}

			flag = validateAddNewParameterPane();
			searchAndSelectFolderOnAddNewPane(folderName, parameterContent);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			String scenario = params.getScenarioType().toLowerCase();

			// Shared logic for most scenarios
			if (!scenario.equals("addnewparameter")) {
				flag = clickOnButton(driver, addNewParameterNextButton, nextContent, true);
				if (!flag) return false;

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
			}

			switch (scenario) {
			case "addnewparameter":
				flag = enterValueToFieldForInvalidDetails(driver, addNewParameterNameField, addNewParameterNameValidation, parameterContent, parameterName, fieldValidation);
				verifyVisibilityOfButtons(driver, addNewParameterNextButton, nextContent, false);
				clickOnButton(driver, addNewParameterCancelButton, cancelButtonContent, true);
				break;

			case "overviewname":
				flag = enterValueToFieldForInvalidDetails(driver, paramerterDetailsNameField, parameterDetailsNameFieldValidation, parameterContent, parameterName, fieldValidation);
				verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);
				break;

			case "overviewdesc":
				flag = enterValueToFieldForInvalidDetails(driver, paramerterDetailsDescField, parameterDetailsDescValidation, descriptionContent, description, fieldValidation);
				verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);
				break;

			case "invalidkey":
				flag = enterKeyAndValueOfParametersForInvalid(params.getParameterJson());
				verifyVisibilityOfButtons(driver, parameterDetailsSaveButton, saveContent, false);
				break;

			case "existing":
				validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField, parameterDetailsNameFieldValidation, paramNameContent, placeholderName, paramP.getParameterName(), fieldValidationForEmptyParamName);
				validatAndeEnterValueToTextField(driver, paramerterDetailsDescTitle, paramerterDetailsDescField, parameterDetailsDescValidation, descriptionContent, placeholderDescription, paramP.getParameterDescription(), "");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);

				enterKeyAndValueOfParameters(params.getParameterJson());

				flag = clickOnSaveButtonAndValidateToast(flag, "Parameter name '" + paramP.getParameterName() + "' already exists.");
				clickOnParametersTab();
				break;

			case "addexistingkey":
				flag = addNewKeyAndValueInParameter(flag, params.getParameterJson(), 0, "");
				flag = addNewKeyAndValueInParameter(flag, params.getParameterJson(), 1, toastValidation);
				clickOnButton(driver, parameterDetailsActionCancelButton, cancelButtonContent, true);
				waitForExecution(1000);
				clickOnParametersTab();
				break;

			default:
				BaseSuite.reportLog("Test Scenario type not mentioned :: " + params.getScenarioType());
				break;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " createParameterWithInvalidConfiguration :: " + e.toString());
			flag = false;
		}

		return flag;
	}

	String hyphenContent=prop.getProperty("String.hyphenContent");
	String lastUpdatedContent="Last Updated";

	By listingPageStaticCount = getElementLocator(prop.getProperty("parameters.listing.static.count"));
	By workflowFolderSearchTitle=getElementLocator(prop.getProperty("worflow.folderSearch.title"));

	By folderSearchExpandIcon = getElementLocator(prop.getProperty("Workflows.listing.folderpath.expand"));
	String folderCheckboxOnListingPage = prop.getProperty("Workflows.listing.folderpath.checkbox");

	By listingPageStaticNameList = getElementLocator(prop.getProperty("parameters.listing.static.name.list"));
	By listingPageStaticLastUpdatedList =getElementLocator(prop.getProperty("parameters.listing.static.lastupdate.list"));

	By listingColumnName = getElementLocator(prop.getProperty("parameters.listing.column.name"));
	By listingColumnLastUpdated = getElementLocator(prop.getProperty("parameters.listing.column.lastupdated"));

	String listingStaticAvatar = prop.getProperty("parameters.listing.static.avatar");
	String listingStaticName = prop.getProperty("parameters.listing.static.name");
	String listingStaticKeys = prop.getProperty("parameters.listing.static.keys");
	String listingStaticDesc = prop.getProperty("parameters.listing.static.desc");
	String listingStaticFolder = prop.getProperty("parameters.listing.static.folder");
	String listingStaticlastUpdate = prop.getProperty("parameters.listing.static.lastupdate");

	String labelFolderSearch="Folder search";

	public static final String RRTIMESTAMPFORMAT ="M/d/yyyy, h:mm:ss a";

	// set workflow parameters using API
	public DataTestingParameters setParametersDetailsUsingExcelData(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			param.setTestScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, "testScenario"));
			param.setScenarioType(xl.readUsingColName(fileName, sheetName, rowNumber, "scenarioType"));
			param.setExecutionstate(xl.readUsingColName(fileName, sheetName, rowNumber, "execute"));
			param.setAdvanceSearch(xl.readUsingColName(fileName, sheetName, rowNumber, "advanceSearch"));
			param.setIsActive(xl.readUsingColName(fileName, sheetName, rowNumber, "removeExistingFilter"));
			param.setOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "order"));
			param.setType(xl.readUsingColName(fileName,sheetName, rowNumber, "type"));			
			param.setChkCheckType(xl.readUsingColName(fileName,sheetName, rowNumber, "checkAll"));
			return param;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  "error occurs while setParametersDetailsUsingExcelData "+e.toString());
		}
		return param;

	}

	public static DataTestingParameters setAdvanceSearchParamUsingExcel(String filePath, String job) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String userNameColumn="ref";
		String usersheet="advancesearch";
		try {

			param.setUserName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"username"));
			param.setFullName(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"fullname"));
			param.setType(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"type"));
			param.setFolder(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"folderpath"));
			param.setUpdatedBy(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"updatedBy"));
			param.setLastUpdatedFrom(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"lastupdatedfrom"));
			param.setLastUpdatedTo(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"lastupdatedto"));
			param.setWorkflowState(xl.readUsingColNameAndCellContains(filePath, usersheet, userNameColumn, job,"state"));


		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,  "error occurs while setJobsParamUsingExcel "+e.toString());
		}
		return param;

	}



	public void removeAppliedFilterofParameter(boolean clearAll) {
		Actions action = new Actions(driver);
		try {

			if(!clearAll) { return ;}

			BaseSuite.reportLog("Removing applied filters...");

			isDisplayedInLoop(driver, 2, parametersAppliedFilterCross);

			if(isDisplayed(driver, parametersAppliedFilterCross)) {

				BaseSuite.validationReportLog("Applied filters cross icon is visible");

				BaseSuite.reportLog("Clicking on Applied filters cross icon");

				action.moveToElement(driver.findElement(parametersAppliedFilterCross)).click().build().perform();

				BaseSuite.validationReportLog("Clicked on Applied filters cross icon");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				// Retry once if still displayed
				if (isDisplayed(driver, parametersAppliedFilterCross)) {
					waitForExecution(2000);
				}

				// Final check
				if (!isDisplayed(driver, parametersAppliedFilterCross)) {
					BaseSuite.validationReportLog("Successfully removed applied filters");
				} else {
					BaseSuite.reportFailLog("Applied filters cross icon still visible", "removeAppliedFilter");
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "removeAppliedFilterofParameter");
		}
	}


	public boolean applyFilterUsingFolderSearch(String folderPath) {

		boolean flag = true;
		String searchFolder = "";
		try {

			verifyIndividualLabel(driver, workflowFolderSearchTitle, labelFolderSearch);

			clickOnButton(driver, refreshButton, folderContent+" "+refreshContent, true);

			expandFilterSidebar(folderSearchExpandIcon);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(folderPath.isEmpty()) { return true;}

			String [] ref = !folderPath.isEmpty() ? folderPath.split(",") : new String [] {""};

			int count = 1;

			for(String rf : ref) {

				BaseSuite.reportLog(hyphenContent +" "+count+" Selecting folder path : " + rf + hyphenContent);

				if(rf.startsWith("/")) { rf = rf.substring(1);}

				String [] folder = rf.split("/");

				searchFolder = folder.length > 1 ? folder[1] : folder[0];

				searchFunctionalityMethod(driver, true, folderSearchField, folderSearchIcon, placeholderSearchFolder, placeholderSearchFolder, searchFolder);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				selectcheckbox(driver, returnElement(folderCheckboxOnListingPage, dynamicName, rf), rf);

				count++;
			}


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, "applyFilterUsingFolderSearch");
			flag=false;
		}

		return flag;

	}

	public void expandFilterSidebar(By locator) {

		if(isDisplayed(driver, locator)) {

			displayAndClick(driver, locator);
		}

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	}

	public boolean advanceSearchFunctionalityOnParametersListingPage(boolean clearAll, String advanceSearchRef, String filePath) {

		boolean flag = true;
		try {

			removeAppliedFilterofParameter(clearAll);

			String [] ref = !advanceSearchRef.isEmpty() ? advanceSearchRef.split(",") : new String [] {""};

			int count = 1;

			for(String rf : ref) {

				BaseSuite.reportLog(hyphenContent + " Applying advance search filter - Iteration : " + count + hyphenContent);

				DataTestingParameters param = setAdvanceSearchParamUsingExcel(filePath, rf);

				applyFilterUsingFolderSearch(param.getFolder());

				validateNSelectUpdatedByUserInAdvanceSearch(param.getFullName(), true);

				validateNSelectLastUpdatedInAdvanceSearch(param.getLastUpdatedFrom(), param.getLastUpdatedTo());

				count++; // increment counter
			}

			geParametersListingPageTable(false);

			BaseSuite.reportLog(hyphenContent + " Applied advance search filter " + hyphenContent);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " advanceSearchFunctionalityOnParametersListingPage :: " + e.toString());
			return false;
		}

		return flag;

	}

	public boolean validateNSelectUpdatedByUserInAdvanceSearch(String fullName,boolean checkstatus) {

		boolean flag=true;
		try {

			expandFilterSidebar(advancedSearchExpand);

			verifyIndividualLabel(driver, advancedSearchUpdatedByLabel, "Updated By");

			expandFilterSidebar(advancedSearchUpdatedByExpand);

			String [] ref = !fullName.isEmpty() ? fullName.split(",") : new String [] {""};

			int count = 1;

			for(String rf : ref) {

				rf = rf.trim();
				BaseSuite.reportLog(hyphenContent+" "+count+" Selecting user : "+rf+" "+hyphenContent);

				searchUser(advancedSearchUpdatedBySearchBar, rf);

				By locator = returnElement(advanceSearchUpdatedByCheckbox, dynamicName, rf);

				isDisplayedInLoop(driver, 4, locator);

				if(isDisplayed(driver, locator)) {
					if(checkstatus) {

						selectcheckbox(driver, locator, rf);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}else {
						selectUncheckbox(driver, locator, rf);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog(rf+" username not found kindly check", "validateNSelectUpdatedByUserInAdvanceSearch");
					flag=false;
				}

				count++; // increment counter
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

			expandFilterSidebar(advancedSearchExpand);

			javascript(driver, scrollToElementArg, advancedSearchLastUpdatedLabel);

			verifyIndividualLabel(driver, advancedSearchLastUpdatedLabel, lastUpdatedContent);

			expandFilterSidebar(advancedSearchLastUpdatedExpand);

			BaseSuite.reportLog(hyphenContent+"Selecting date from : "+startDate+" to : "+endDate+hyphenContent);

			CustomTimeUtil.compareTwoDates(flag, calanderDateFormat, startDate, endDate);

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

	public void validateUnexpectedToast(String method) {

		if(isDisplayed(driver, toastMsg)) {
			BaseSuite.reportFailLog("Unexpected toast message appeared", method);
		}
	}

	public void getTableForParameters(List<String> list) {

		try {

			if(list.isEmpty()) { return ; }

			String [][] table = new String[list.size()+1][4];

			String[] header = { "No.", "Type", "Name", "Folder", "# of keys", descriptionContent, lastUpdatedContent};

			table[0] = header;

			for (int i = 0; i < list.size(); i++) {

				String num = Integer.toString(i + 1);

				String type = list.get(i).split(",")[1];

				String name = list.get(i).split(",")[2];

				String fold = list.get(i).split(",")[3];

				String keys = list.get(i).split(",")[4];

				String desc = list.get(i).split(",")[5];

				String lu = list.get(i).split(",")[6];

				String[] data = { num, type, name, fold, keys, desc, lu};

				table[i + 1] = data;

			}

			BaseSuite.reportLog(createHtmlTable1(table,parameterListingContent));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "error observed while getTableForParameters :: " + e.toString());
		}
	}

	public List<String> validateParametersDetails(List<String> list, int rowNum) {

		String num=Integer.toString(rowNum+1);

		String type = getAttribute(driver, returnElement(listingStaticAvatar, dynamicName, num), attributeTitle);

		String name = getAttribute(driver, returnElement(listingStaticName, dynamicName, num), attributeTextContent);

		String fold = getAttribute(driver, returnElement(listingStaticFolder, dynamicName, num), attributeTitle);

		String keys = getAttribute(driver, returnElement(listingStaticKeys, dynamicName, num), attributeTextContent);

		String desc = getAttribute(driver, returnElement(listingStaticDesc, dynamicName, num), attributeTitle);

		String lupd = getAttribute(driver, returnElement(listingStaticlastUpdate, dynamicName, num), attributeTextContent);

		lupd = lupd.contains(",") ? lupd.replace(",", " |") : lupd;

		list.add(num+","+type+","+name+","+fold+","+keys+","+desc+","+lupd);

		return list;

	}

	public boolean geParametersListingPageTable(boolean checkAll) {
		boolean flag=true;

		try {
			List<String> list = new ArrayList<>();

			List<String> paginationInfo = getPaginationDetails(driver, parameterListingPageMsg, parameterListingPageBar, noRecordsToDisplayOnListingPage, parameterListingContent);

			int total = Integer.parseInt(paginationInfo.get(1));
			if (total == 0) {
				return true;
			}

			int totalPages = (int) Math.ceil(total / numberOfRecordsPerPage);  // Calculate total number of pages

			for (int pn = 1; pn <= totalPages; pn++) {
				BaseSuite.reportLog("Checking records on page : "+pn);

				// Calculate the number of records to process on this page
				int size = driver.findElements(listingPageStaticCount).size();		        

				for (int i = 0; i < size; i++) {
					list = validateParametersDetails(list, i);
				}
				if(!checkAll) { break;}

				clickOnNextPageArrow(pn < totalPages, pn);
			}

			getTableForParameters(list);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" geParametersListingPageTable :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean validateSortingFunctionalityOnParameters(String type , String order, boolean checkAllRecords) {
		boolean isSortedCorrectly = true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Verifying existing parameters displayed on listing page : 1 before sorting");

			List<String> paginationInfo = getPaginationDetails(driver, parameterListingPageMsg, parameterListingPageBar, noRecordsToDisplayOnListingPage, parameterListingContent);

			int totalRecords = Integer.parseInt(paginationInfo.get(1));
			if (totalRecords == 0) {
				BaseSuite.reportLog("Unable to perform sorting as no records found.");
				return true;
			}

			getParametersListingPageTable(Integer.toString(totalRecords), checkAllRecords, type);

			isSortedCorrectly = sortListByColumn(type, order, totalRecords, checkAllRecords);

			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSortingFunctionalityOnParameters :: " + e.toString());
			return false;
		}

		return isSortedCorrectly;
	}

	public void clickOnNextPageArrow(boolean click, int pageNumber) {

		try {
			// Click next page if not on the last page
			if (!click) { return ; } 

			BaseSuite.reportLog("Clicking on next arrow to go on page : "+pageNumber);
			displayAndClick(driver, parameterListingNextPageArrow, nextPageArrowContent); 
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Clicked on page : "+pageNumber);
			validateUnexpectedToast("clickOnNextPageArrow");
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnNextPageArrow");
		}

	}


	public List<String> getParametersListingPageTable(String totalCount, boolean checkAll, String type) {

		List<String> list = new ArrayList<>();
		List<String> columnTextValues = new ArrayList<>();
		try {
			int total = Integer.parseInt(totalCount);

			int totalPages = (int) Math.ceil(total / numberOfRecordsPerPage);  // Calculate total number of pages

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
					list = validateParametersDetails(list, i);
				}
				if(!checkAll) { break;}

				clickOnNextPageArrow(pn < totalPages, pn);

			}

			getTableForParameters(list);

			clickOnButton(driver, refreshButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSortingFunctionalityOnWorkflow :: " + e.toString());
		}

		return columnTextValues;
	}

	public boolean sortListByColumn(String type, String order, int totalRecords, boolean checkAllRecords) {
		boolean isSorted = true;

		try {
			By locator = type.contains("Name") ? listingColumnName : listingColumnLastUpdated;
			boolean isAscending = order.equalsIgnoreCase("ascending");

			BaseSuite.reportLog("Verifying parameters after sorting by " + type + " in " + order + " order");

			// Perform sort click
			displayAndClick(driver, locator, type + " column");

			if (!isAscending) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				displayAndClick(driver, locator, type + " column");  // Click again for descending
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> columnData=getParametersListingPageTable(Integer.toString(totalRecords), checkAllRecords, type);

			// Validate sorting
			isSorted = type.equalsIgnoreCase("Name")
					? DataIntegrityUtils.isSorted(columnData, isAscending)
							: DataIntegrityUtils.isDateSorted(columnData, RRTIMESTAMPFORMAT, isAscending);

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

	public boolean updateParameterNameFunctionalityForWorkflow(String parameterName,String updateparameterName, String icedqUser) {

		boolean flag =true;

		try {

			isDisplayedInLoop(driver, 60, paramerterDetailsNameField);
			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField,parameterDetailsNameFieldValidation, paramNameContent, placeholderName, updateparameterName, fieldValidationForEmptyParamName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				flag=clickOnSaveButtonAndValidateToast(flag, "");

			}else {
				flag=clickOnSaveButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}	

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateParameterNameFunctionalityForWorkflow :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	public void validateImportParameterUI(String type) {


		validateElement(driver, returnElement(importParametersFileTypeInfo, dynamictype, type), "Accepted File Types: .xlsx, .csv", labelContent);

		validateElement(driver, returnElement(importParametersSecureIcon, dynamictype, type), "Secure", "icon");

		verifyVisibilityOfButtons(driver, returnElement(importParametersChooseFileBtn, dynamictype, type), "Choose file", true);

		validateElement(driver, returnElement(importParametersNoteText, dynamictype, type), "Note: The sample file is available for download from the documentation portal.", "Note");

	}



	public boolean validateFile(String type, String attribute, String expectedValue, String scenario) {

		boolean flag =true;

		BaseSuite.reportLog("Verifying file "+type);

		By fl = returnTwoElements(importParametersFileDetailsLocator, dynamicName, type.toLowerCase().trim(), dynamictype, scenario);

		isDisplayedInLoop(driver, 2, fl);

		if(isDisplayed(driver, fl)) {

			String acValue = getAttribute(driver, fl, attribute);

			if (acValue == null) {
				BaseSuite.reportFailLog("Attribute " + attribute + " not found for " + type, "validateFile");
				return false;
			}

			flag=stringOutput(acValue.trim(), expectedValue, true);

		}else {

			BaseSuite.reportFailLog("file "+type+" not visible kindly check ", "validateFile");
			return false;
		}

		return flag;
	}

	public void validateFileDetails(String filePath, String fileStatus, String scenario) {

		try {

			BaseSuite.reportLog(hyphenContent+" Verifying file details "+hyphenContent);

			File file = new File(filePath);

			String fileName = file.getName(); // e.g., testfile.pdf
			String fileType = "";

			int dotIndex = fileName.lastIndexOf('.');
			if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
				fileType = fileName.substring(dotIndex + 1); // e.g., pdf
			}

			String fileSize = DataIntegrityUtils.humanReadableByteCountSI(file.length());

			validateFile("name", attributeTitle, fileName, scenario);
			validateFile("type", attributeTextContent, "."+fileType, scenario);
			validateFile("size", attributeTextContent, fileSize, scenario);
			validateFile("status", attributeTextContent, fileStatus, scenario);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateFileDetails :: "+e.toString());
		}

	}


	public void importParameterFile(By locator, String filePath) {

		BaseSuite.reportLog(hyphenContent+" Uploading/ importing parameters file "+hyphenContent);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		BaseSuite.reportLog("File ready to upload :: "+filePath);

		javascript(driver, "arguments[0].style.display = 'block'; arguments[0].style.opacity = 1;", driver.findElement(locator));

		driver.findElement(locator).sendKeys(filePath);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		BaseSuite.reportLog("File uploaded successfully");
	}


	public boolean importParametersFile(By locator, String filePath, boolean isValid, String scenario) {

		boolean flag =true;

		try {

			importParameterFile(locator, filePath);

			validateFileDetails(filePath, isValid ? "Ready to upload" : " ", scenario);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" importParametersFile :: "+e.toString());
			flag=false;
		}
		return flag;
	}

	public String getImportFilePath(String fileName) {

		if(fileName==null) return null;

		return DIR_PATH+importParametersTestDataFolderPath+fileName;

	}

	public static String getFileExtension(String filename) {
		if (filename != null && filename.contains(".")) {
			return filename.substring(filename.lastIndexOf(".") + 1);  // Extract extension after the last dot
		}
		return "";  // Return empty if there's no extension
	}

	public static int getFileRowCount(String fileType, String fileName, String sheetName) {

		XLUtils xl = new XLUtils();

		int rowCount=0;
		try {

			rowCount = fileType.contains("csv") ? xl.getCSVRowCount(fileName) : xl.getRowCount(fileName, sheetName);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,"error occurs while getFileRowCount :: "+e.toString());
		}

		return rowCount;
	}

	public boolean createParameterUsingImportFileValid(DataTestingParameters param, String folderName, String icedqUser) {

		boolean flag =true;

		try {

			flag=clickOnNewParameterButton(icedqUser);

			if(flag && hasPermission(icedqUser)){

				String newParameterName = param.getParameterName();

				flag=validateAddNewParameterPane();

				searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField,parameterDetailsNameFieldValidation, paramNameContent, placeholderName, newParameterName, fieldValidationForEmptyParamName);

				importParametersFile(returnElement(importParametersChooseFileInput, dynamictype, addNewParameterContent), getImportFilePath(param.getParameterFilename()), true, addNewParameterContent);

				flag=clickOnButton(driver, addNewParameterNextButton, nextContent, true);

				if(!flag) { return false;}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				/**	validateParameterDetailsPageBeforeCreate(param.getParameterName(), folderName);*/

				validateAndEnterParameterOverview(flag, newParameterName, param.getParameterDescription());

				flag=clickOnSaveButtonAndValidateToast(flag, toastMessageSaveParameter);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateParameterDetailsPageAfterCreate(newParameterName, folderName);

				validateKeyAndValueOfParametersForExcel(getFileExtension(param.getParameterFilename()), getImportFilePath(param.getParameterFilename()));

				clickOnParametersTab();

				int pcount = getFileRowCount(getFileExtension(param.getParameterFilename()), getImportFilePath(param.getParameterFilename()), "sheet1");

				validateParameterDetailsOnListingPage(newParameterName,folderName, Integer.toString(pcount), param.getParameterDescription());


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createParameterUsingImportFileValid :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public void upsertParameters(boolean importParamFromFile, String importFileName, String icedqUser) {

		try {
			if(!importParamFromFile) return ;

			if(hasPermission(icedqUser)) {

				clickOnButton(driver, parameterDetailsImportButton, importContent, true);
			}else {

				clickOnImportButtonAndValidateToastOnParameterPage(true, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
				return;

			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			verifyVisibilityOfButtons(driver,  upsertparameterImportButton, importContent, false);

			importParametersFile(returnElement(importParametersChooseFileInput, dynamictype, upsertParameterContent), getImportFilePath(importFileName), true, upsertParameterContent);

			verifyVisibilityOfButtons(driver, upsertparameterCancelButton, cancelButtonContent, true);

			clickOnImportButtonAndValidateToast(true, toastMessagefileUploaded);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" upsertParameters :: "+e.toString());
		}

	}

	public void removeExistingParametersKeys(boolean removeOldParam) {

		try {
			if(!removeOldParam) return ;

			selectcheckbox(parameterDetailsMasterCheckbox, masterContent+" "+checkboxContent+" "+keyContent);

			clickOnButton(driver, parameterDetailsRemoveFieldButton, "Remove "+keyContent, true);

			validateAndHandleRemoveAllParameterKeyPopupWindow(true, deleteContent);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(500);

			validateElement(driver, parameterDetailsNoRecordsToDisplay, noRecordsTodisplayContentp, labelContent);

			verifyVisibilityOfButtons(driver, parameterDetailsDiscardButton, discardContent, true);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeExistingParametersKeys :: "+e.toString());
		}

	}

	public boolean updateParameterUsingImportFileValid(DataTestingParameters param, DataTestingParameters sparam, String folderName, String icedqUser) {

		boolean flag =true;
		boolean removeOldParam = false;
		boolean addNewParamFromJson = false;
		boolean importParamFromFile = true;
		try {

			String parameterJson=sparam.getParameterJson();
			String updateParameterJson =sparam.getParameterUpdateJson();

			String parameterName=param.getParameterName();
			String description=param.getParameterDescription();

			if(!hasPermission(icedqUser)) {
				DataTestingParameters paramP = setParametersServiceParam(parameterJson);
				parameterName=paramP.getParameterName();
				description=paramP.getParameterDescription();
			}

			/**		DataTestingParameters updateparamP = setParametersServiceParam(updateParameterJson);*/
			String upParameterName=param.getUpdateParameterName()+"_"+ BaseClassUtil.generateRandomString(5);
			String upDescription=param.getUpdateParameterDesc();

			if(!BaseSuite.suiteType.equalsIgnoreCase(sanity)) {validateParameterDetailsPageAfterCreate(parameterName, folderName);}

			viewAndValidateField(driver, paramerterDetailsNameField, paramNameContent, parameterName, true);

			validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField,parameterDetailsNameFieldValidation, paramNameContent, placeholderName, upParameterName, fieldValidationForEmptyParamName);

			viewAndValidateField(driver, paramerterDetailsDescField, paramNameContent, description, true);

			validatAndeEnterValueToTextField(driver, paramerterDetailsDescTitle, paramerterDetailsDescField,parameterDetailsDescValidation, descriptionContent, placeholderDescription, upDescription, "");

			removeExistingParametersKeys(removeOldParam);

			if(addNewParamFromJson) enterKeyAndValueOfParameters(updateParameterJson);

			upsertParameters(importParamFromFile, param.getParameterFilename(), icedqUser);

			if(hasPermission(icedqUser)){

				flag=clickOnSaveButtonAndValidateToast(flag, "");

				validateKeyAndValueOfParametersForExcel(getFileExtension(param.getParameterFilename()), getImportFilePath(param.getParameterFilename()));

				clickOnParametersTab();

				validateParameterDetailsOnListingPage(upParameterName,folderName, "", upDescription);

			}else {
				flag=clickOnSaveButtonAndValidateToast(flag,ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG);
			}	

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateParameterUsingImportFileValid :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	// set workflow parameters using API
	public DataTestingParameters setImportFilekeysUsingExcelData(String fileType, String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			if(fileType.contains("csv")) {

				param.setParameterKey(xl.readUsingColNameFromCSV(fileName, rowNumber, "parameter_key"));
				param.setParameterValue(xl.readUsingColNameFromCSV(fileName, rowNumber, "parameter_value"));
				param.setParameterType(xl.readUsingColNameFromCSV(fileName, rowNumber, "parameter_type"));
				param.setParameterRemark(xl.readUsingColNameFromCSV(fileName, rowNumber, "parameter_notes"));

				return param;
			}

			param.setParameterKey(xl.readUsingColName(fileName, sheetName, rowNumber, "parameter_key"));
			param.setParameterValue(xl.readUsingColName(fileName, sheetName, rowNumber, "parameter_value"));
			param.setParameterType(xl.readUsingColName(fileName, sheetName, rowNumber, "parameter_type"));
			param.setParameterRemark(xl.readUsingColName(fileName, sheetName, rowNumber, "parameter_notes"));

			return param;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  "error occurs while setImportFilekeysUsingExcelData "+e.toString());
		}

		return param;

	}

	public boolean validateKeyAndValueOfParametersForExcel(String fileType, String filePath) {

		XLUtils xl = new XLUtils();
		boolean flag=true;
		int rowNumber=0;
		String sheetName="sheet1";
		List<String> plist = new ArrayList<>();
		try {

			int rowCount = fileType.contains("csv") ? xl.getCSVRowCount(filePath) : xl.getRowCount(filePath, sheetName);

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				DataTestingParameters param = setImportFilekeysUsingExcelData(fileType, filePath, sheetName, rowNumber);

				String key=param.getParameterKey();
				String value=param.getParameterValue();
				String notes=param.getParameterRemark();

				BaseSuite.reportLog("----------- Verifying ("+rowNumber+") parameter key : "+key+" & value : "+value+" & notes : "+notes);

				plist.add(rowNumber+","+key+","+value+","+notes);
				/**
				flag=searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" key", placeholderSearchKey, key);
				 */
				if(!isDisplayed(driver, parameterDetailsNoRecordsToDisplay)) {

					javascript(driver, scrollToElementArg, returnElement(parameterDetailsDymanicKeyField, dynamicName, key));

					viewAndValidateField(driver, returnElement(parameterDetailsDymanicKeyField, dynamicName, key), keyContent, key, true);

					viewAndValidateField(driver, returnElement(parameterDetailsDymanicValueField, dynamicName, value), valueContents, value, true);

					viewAndValidateField(driver, returnElement(parameterDetailsDymanicNotesField, dynamicName, notes), notesContent, notes, true);

					verifyVisibilityOfButtons(driver, returnElement(parameterDetailsKeyEditButton, dynamicName, key), "Edit"+" "+keyContent, true);

					verifyVisibilityOfButtons(driver, returnElement(parameterDetailsKeyDeleteButton, dynamicName, key), deleteContent+" "+keyContent, true);

				}else {
					BaseSuite.reportFailLog(key+" key not found ", "validateKeyAndValueOfParameters");
				}

			}
			/**
			searchFunctionalityMethod(driver, true, parameterDetailsSearchkeyField, parameterDetailsSearchkeyIcon, searchContent+" key", placeholderSearchKey, "");
			 */
			getTableForParameterkeys(plist);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateKeyAndValueOfParameters :: "+e.toString());
			flag=false;
		}
		return flag;
	}


	public void getTableForParameterkeys(List<String> list) {

		try {

			if(list.isEmpty()) { return ; }

			String [][] table = new String[list.size()+1][4];

			String[] header = { "No.", "Key", "Value", "Notes"};

			table[0] = header;

			for (int i = 0; i < list.size(); i++) {

				String num = Integer.toString(i + 1);

				String type = list.get(i).split(",")[1];

				String name = list.get(i).split(",")[2];

				String stat = list.get(i).split(",")[3];

				String[] data = { num, type, name, stat};

				table[i + 1] = data;

			}

			BaseSuite.reportLog(createHtmlTable1(table,"Parameter keys"));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "error observed while getTableForParameterkeys :: " + e.toString());
		}
	}

	public boolean hasPermission(String icedqUser) {
		if (icedqUser == null) return false;
		String userLower = icedqUser.toLowerCase();
		return userLower.contains(ownerContent) || userLower.contains(contributorContent);
	}


	public boolean createParameterUsingImportFileInValid(DataTestingParameters param, String folderName, String icedqUser) {

		boolean flag =true;

		try {

			flag=clickOnNewParameterButton(icedqUser);

			if(flag && hasPermission(icedqUser)){

				String newParameterName = param.getParameterName();

				flag=validateAddNewParameterPane();

				searchAndSelectFolderOnAddNewPane(folderName, parameterContent);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatAndeEnterValueToTextField(driver, paramerterDetailsNameTitle, paramerterDetailsNameField,parameterDetailsNameFieldValidation, paramNameContent, placeholderName, newParameterName, fieldValidationForEmptyParamName);

				switch(param.getTestType().toLowerCase().trim()) {

				case "field":

					importParameterFile(returnElement(importParametersChooseFileInput, dynamictype, addNewParameterContent), getImportFilePath(param.getParameterFilename()));

					validateFileDetails(getImportFilePath(param.getParameterFilename()), param.getFieldValidationMessage(), addNewParameterContent);

					verifyVisibilityOfButtons(driver, addNewParameterNextButton, nextContent, false);

					flag=clickOnButton(driver, addNewParameterCancelButton, cancelButtonContent, true);

					break;

				case "toast":

					importParameterFile(returnElement(importParametersChooseFileInput, dynamictype, addNewParameterContent), getImportFilePath(param.getParameterFilename()));

					flag=clickOnNextButtonAndValidateToast(true, param.getToastValidationMessage());
					break;

				case "save":

					importParametersFile(returnElement(importParametersChooseFileInput, dynamictype, addNewParameterContent), getImportFilePath(param.getParameterFilename()), true, addNewParameterContent);

					flag=clickOnButton(driver, addNewParameterNextButton, nextContent, true);

					if(!flag) { return false;}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					validateAndEnterParameterOverview(flag, newParameterName, param.getParameterDescription());

					flag=clickOnSaveButtonAndValidateToast(flag, param.getToastValidationMessage());

					break;

				default : 

					BaseSuite.reportErrorLog("Test type is not defined, kindly check : "+param.getTestType());

					break;
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createParameterUsingImportFileInValid :: "+e.toString());
			flag=false;
		}

		return flag;
	}

	public boolean updateParameterUsingImportFileInValid(DataTestingParameters param, String icedqUser) {

		boolean flag =true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(hasPermission(icedqUser)){

				clickOnButton(driver, parameterDetailsImportButton, importContent, true);

				switch(param.getTestType().toLowerCase().trim()) {

				case "field":

					importParameterFile(returnElement(importParametersChooseFileInput, dynamictype, upsertParameterContent), getImportFilePath(param.getParameterFilename()));

					validateFileDetails(getImportFilePath(param.getParameterFilename()), param.getFieldValidationMessage(), upsertParameterContent);

					verifyVisibilityOfButtons(driver, upsertparameterImportButton, importContent, false);

					flag=clickOnButton(driver, upsertparameterCancelButton, cancelButtonContent, true);

					break;

				case "toast":

					importParametersFile(returnElement(importParametersChooseFileInput, dynamictype, upsertParameterContent), getImportFilePath(param.getParameterFilename()), true, upsertParameterContent);

					verifyVisibilityOfButtons(driver, upsertparameterCancelButton, cancelButtonContent, true);

					flag=clickOnImportButtonAndValidateToast(true, param.getToastValidationMessage());

					clickOnButton(driver, upsertparameterCancelButton, cancelButtonContent, true);

					break;

				case "save":

					importParametersFile(returnElement(importParametersChooseFileInput, dynamictype, upsertParameterContent), getImportFilePath(param.getParameterFilename()), true, upsertParameterContent);

					flag=clickOnImportButtonAndValidateToast(true, toastMessagefileUploaded);

					if(!flag) { return false;}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(1000);

					flag=clickOnSaveButtonAndValidateToast(flag, param.getToastValidationMessage());

					break;

				default : 

					BaseSuite.reportErrorLog("Test type is not defined, kindly check : "+param.getTestType());

					break;
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateParameterUsingImportFileInValid :: "+e.toString());
			flag=false;
		}

		return flag;
	}
}
