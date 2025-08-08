package nextgen.automation.workflow.service.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.connectionRepo.ConnectionRepoCommonPage;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.CustomTimeUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nextgen.automation.RuleRepo.pages.DataTestingPage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WorkflowPage extends PageUtil {

	WebDriver driver;

	public WorkflowPage(WebDriver driver) {
		this.driver = driver;
	}

	static ReadConfig readconfig = new ReadConfig();
	protected static final Logger log = Logger.getLogger(WorkflowPage.class);
	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	private static final String CLIENTID = readconfig.clientIdOnPremInstance();
	private static final String CLIENTSECRET = readconfig.clientSecreOnPremInstancet();
	private static final String AUTH = CLIENTID + ":" + CLIENTSECRET;
	private static final String AUTHENTICATION = Base64.getEncoder().encodeToString(AUTH.getBytes());
	static final String USERNAME = readconfig.userName();
	static final String PASSWORD = readconfig.password();
	static final String HTTPCLIENT = null;
	static String authetication = prop.getProperty("Authetication");
	static String basic = prop.getProperty("Basic");
	static String contentType = prop.getProperty("ContentType");
	static String contentTypeText="content-type";

	static String dirPath=System.getProperty("user.dir");
	public static final String WORKFLOWEXCELFILEPATH = dirPath+ Constant.NEXTGEN_WORKFLOW_TESTDATA_EXCEL_PATH;
	public static final String WORKFLOWPRIVILEGEFORBIDDENMESSAGE=prop.getProperty("workflow.toast.forbidden.Message");

	static final String LINUXFOLDERPATH="/home/seluser/";

	/** ----------------------  By locators ---------------------------------- **/

	By datatestingSubModuleTabs=getElementLocator(prop.getProperty("datatesting.subModule.tabs"));
	By datatestingSubModuleTabs1=getElementLocator(prop.getProperty("datatesting.subModule.tabs1"));
	By noRecordsFound=getElementLocator(prop.getProperty("noRecondsFound"));
	By dataTSpinner=getElementLocator(prop.getProperty("dataT.spinner"));
	By toastMsg=getElementLocator(prop.getProperty("Workflow.Toast.Message"));
	By toastMsgClosedBtn=getElementLocator(prop.getProperty("Workflow.Toast.Close"));
	By workflowTab=getElementLocator(prop.getProperty("workflow.Tab"));
	By workflowTitle=getElementLocator(prop.getProperty("workflow.title"));
	By workflowAppliedFilterMessage=getElementLocator(prop.getProperty("workflow.applied.filter.message"));
	By workflowAppliedFilterCross=getElementLocator(prop.getProperty("workflow.applied.filter.cross.icon"));
	By workflowSearchField=getElementLocator(prop.getProperty("workflow.search.field"));
	By workflowSearchButton=getElementLocator(prop.getProperty("workflow.search.button"));
	By newWorkflowButton=getElementLocator(prop.getProperty("workflow.newWorkflow.button"));
	By refreshWorkflowButton=getElementLocator(prop.getProperty("workflow.refresh.button"));
	By moreOptionButton=getElementLocator(prop.getProperty("workflow.more.button"));
	By addNewWorkflowTitle=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.title"));
	By workflowNameFieldLabel=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.workflow.name.title"));
	By workflowNameFieldInput=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.workflow.name.field"));
	By chooseTemplateLabel=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.chooseTemplate.title"));
	By chooseTemplateButton=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.chooseTemplate.button"));
	By addNewWorkflowCancelButton=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.cancel.button"));
	By addNewWorkflowCrossButton=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.cancel.cross.button"));
	By workflowListingPageColumns=getElementLocator(prop.getProperty("workflow.listing.columns"));
	By workflowFolderSearchTitle=getElementLocator(prop.getProperty("worflow.folderSearch.title"));
	By workflowFolderSearchField=getElementLocator(prop.getProperty("workflow.folder.search.field"));
	By workflowFolderSearchButton=getElementLocator(prop.getProperty("workflow.folder.search.button"));
	By workflowAdvancedSearchTitle=getElementLocator(prop.getProperty("workflow.AdvancedSearch.title"));
	By workflowFolderSearchNewFolderButton=getElementLocator(prop.getProperty("workflow.folderSearch.newFolder.button"));
	By workflowFolderSearchNewFolderActiveField=getElementLocator(prop.getProperty("workflow.folderSearch.newFolder.activeField"));
	By folderList=getElementLocator(prop.getProperty("RuleRepo.FolderList"));
	By addNewFolderButton=getElementLocator(prop.getProperty("dataT.AddNewFolderButton"));
	By enterNewFolderName=getElementLocator(prop.getProperty("DataTesting.EnterNewFolderName"));
	By pathSelect=getElementLocator(prop.getProperty("DataTesting.PathSelect"));
	By pathTree=getElementLocator(prop.getProperty("DataTesting.PathTree"));
	By addNewSearchBar=getElementLocator(prop.getProperty("DataTesting.AddNewPanSearchBar"));
	By addNewPanSearchBarButton=getElementLocator(prop.getProperty("DataTesting.AddNewPanSearchBarButton"));
	By addNewFolderSearchButton=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.folder.search.button"));
	By addNewWorkflowFolderList=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.folder.list"));
	By addNewFolderButtonOnAddPane=getElementLocator(prop.getProperty("workflow.AddNewWorkflow.folder.newFolder.button"));	
	By workflowDetailsfolderLabel=getElementLocator(prop.getProperty("workflow.details.folder.label"));
	By workflowDetailsfolderSearchBar=getElementLocator(prop.getProperty("workflow.details.folder.search.bar"));
	By workflowDetailsfolderSearchbtn=getElementLocator(prop.getProperty("workflow.details.folder.search.button"));
	By workflowDetailsRuleTabs=getElementLocator(prop.getProperty("workflow.details.rules.label"));
	By workflowDetailsRuleTabRefreshIcon=getElementLocator(prop.getProperty("workflow.details.rules.tab.refresh.icon"));
	By workflowDetailsRuleSearchbar=getElementLocator(prop.getProperty("workflow.details.rules.search.bar"));
	By workflowDetailsRuleSearchbtn=getElementLocator(prop.getProperty("workflow.details.rules.search.button"));
	By workflowDetailsRuleNameColumn=getElementLocator(prop.getProperty("workflow.details.rules.ruleNameColumn"));
	By workflowDetailsFolderColumn=getElementLocator(prop.getProperty("workflow.details.rules.FolderColumn"));
	By workflowDetailsRuleList=getElementLocator(prop.getProperty("workflow.details.rulename.list"));
	By workflowDetailsRuleCheckboxList=getElementLocator(prop.getProperty("workflow.details.rulename.checkboxList"));
	By workflowDetailsRuleMasterCheckbox=getElementLocator(prop.getProperty("workflow.details.rules.mastercheckbox"));
	By worfklowDetailsRuleAddButton=getElementLocator(prop.getProperty("workflow.details.rules.addButton"));
	By workflowDetailsPublishDropDown=getElementLocator(prop.getProperty("workflow.details.publish.dropdown"));
	By workflowDetailsPublishButton=getElementLocator(prop.getProperty("workflow.details.publish.button"));
	By workflowDetailsValidateButton=getElementLocator(prop.getProperty("workflow.details.validate.button"));
	By workflowDetailsDraftButton=getElementLocator(prop.getProperty("workflow.details.draft.button"));
	By workflowDetailsRunButton=getElementLocator(prop.getProperty("workflow.details.run.button"));
	By workflowDetailsDiscardButton=getElementLocator(prop.getProperty("workflow.details.discard.button"));
	By workflowDetailsDeleteButton=getElementLocator(prop.getProperty("workflow.details.delete.button"));
	By workflowDetailsMoreOptionButton=getElementLocator(prop.getProperty("workflow.details.moreOpt.button"));
	By workflowDetailsPublishIcon=getElementLocator(prop.getProperty("workflow.details.status.publish.icon"));
	By workflowDetailsValidateIcon=getElementLocator(prop.getProperty("workflow.details.status.validate.icon"));
	By workflowDetailsDraftIcon=getElementLocator(prop.getProperty("workflow.details.status.draft.icon"));	
	By workflowDetailsNewWindowAddNewRuleTitle=getElementLocator(prop.getProperty("workflow.details.newWindlow.addNewRuleTitle"));
	By workflowBreadcrumbHomeLink=getElementLocator(prop.getProperty("workflow.breadcrumb.HomeLink"));
	By workflowBreadcrumbDataTestingLink=getElementLocator(prop.getProperty("workflow.breadcrumb.DataTestingLink"));
	By workflowBreadcrumbWorkflowsLink=getElementLocator(prop.getProperty("workflow.breadcrumb.workflowsLink"));
	By workflowBreadcrumbWorkflowId=getElementLocator(prop.getProperty("workflow.breadcrum.workflowId"));
	By discardButtons=getElementLocator(prop.getProperty("workflow.details.discard.window"));
	By workflowDetailsSlidePanelIcon=getElementLocator(prop.getProperty("workflow.details.sidePanel.icon"));
	By workflowDetailsOverviewTab=getElementLocator(prop.getProperty("workflow.details.OverviewTab"));
	By workflowDetailsRuleAndDatasetsTab=getElementLocator(prop.getProperty("workflow.details.RuleAndDatasetsTab"));	
	By workflowDetailsWorkflowNameLabel=getElementLocator(prop.getProperty("workflow.details.workflowName.Label"));
	By workflowDetailsWorkflowCodeLabel=getElementLocator(prop.getProperty("workflow.details.workflowCode.Label"));
	By workflowDetailsDescriptionLabel=getElementLocator(prop.getProperty("workflow.details.workflowDescription.Label"));
	By workflowDetailsWorkflowNameField=getElementLocator(prop.getProperty("workflow.details.workflowName.field"));
	By workflowDetailsWorkflowNameValidation=getElementLocator(prop.getProperty("workflow.details.workflowName.validation"));
	By workflowDetailsWorkflowCodeField=getElementLocator(prop.getProperty("workflow.details.workflowCode.field"));
	By workflowDetailsWorkflowCodeValidation=getElementLocator(prop.getProperty("workflow.details.workflowCode.validation"));
	By workflowDetailsDescriptionField=getElementLocator(prop.getProperty("workflow.details.workflowDescription.field"));
	By workflowDetailsDescriptionValidation=getElementLocator(prop.getProperty("workflow.details.workflowDescription.validation"));
	By workflowDetailsUpdatedBy=getElementLocator(prop.getProperty("workflow.details.workflowCreatedUpdatedBy"));
	By workflowDetailsUpdatedDate=getElementLocator(prop.getProperty("workflow.details.workflowCreatedUpdateddate"));
	By workflowDetailsFolderList=getElementLocator(prop.getProperty("workflow.details.folder.list"));
	By workflowDetailsNewRuleButton=getElementLocator(prop.getProperty("workflow.details.rules.newRuleButton"));
	By workflowDetailsCurrentStatus=getElementLocator(prop.getProperty("workflow.details.title.current.status"));
	By rulesDatasetsSearchBar=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.searchbar"));
	By rulesDatasetsSearchButton=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.searchbtn"));
	By rulesDatasetsRuleNameColumns=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.ruleNameColumn"));
	By rulesDatasetsRunButton=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.runBtn"));
	By rulesDatasetsSourceConnOverrideButton=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.srcConnOverride"));
	By rulesDatasetsTargetConnOverrideButton=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.trgConnOverride"));
	By rulesDatasetsParameterConnOverrideButton=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.paramConnOverride"));
	By rulesDatasetsDeleteButton=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.deleteBtn"));
	By rulesNoRecordsToDisplay=getElementLocator(prop.getProperty("workflow.details.rules.noRecordsFound"));
	By rulesListOnRulesTab=getElementLocator(prop.getProperty("workflow.details.rules.tab.list"));
	By rulesCheckboxListOnRulesTab=getElementLocator(prop.getProperty("workflow.details.rules.tab.checkbox.list"));
	By ruleDatasetDeletePopupTitle=getElementLocator(prop.getProperty("workflow.details.deleteRule.popupWindow.title"));
	By ruleDatasetDeletePopupContent=getElementLocator(prop.getProperty("workflow.details.deleteRule.popupWindow.message"));
	By ruleDatasetDeletePopupCancelButton=getElementLocator(prop.getProperty("workflow.details.deleteRule.popupWindow.cancelButton"));
	By ruleDatasetDeletePopupDeleteButton=getElementLocator(prop.getProperty("workflow.details.deleteRule.popupWindow.deleteButton"));
	By deleteWorkflowPopupTitle=getElementLocator(prop.getProperty("workflow.details.deleteWorkflow.popupWindow.title"));
	By deleteWorkflowPopupContent=getElementLocator(prop.getProperty("workflow.details.deleteWorkflow.popupWindow.message"));
	By deleteWorkflowPopupCancelButton=getElementLocator(prop.getProperty("workflow.details.deleteWorkflow.popupWindow.cancelButton"));
	By deleteWorkflowPopupDeleteButton=getElementLocator(prop.getProperty("workflow.details.deleteWorkflow.popupWindow.deleteButton"));
	By workflowDetailsRecentRunRefreshButton=getElementLocator(prop.getProperty("workflow.details.recentRuns.refresh.button"));
	By workflowDetailsRecentRunSearchBar=getElementLocator(prop.getProperty("workflow.details.recentRuns.searchbar"));
	By workflowDetailsRecentRunSearchBtn=getElementLocator(prop.getProperty("workflow.details.recentRuns.searchbutton"));
	By workflowDetailsRecentRunStatus=getElementLocator(prop.getProperty("workflow.details.recentRuns.status.latest"));
	By workflowDetailsRecentRunInstanceId=getElementLocator(prop.getProperty("workflow.details.recentRuns.instanceID"));
	By workflowDetailsRecentRunInstanceIdHyperlink=getElementLocator(prop.getProperty("workflow.details.recentRuns.instanceID.hyperlink"));
	By workflowDetailsRecentRunName=getElementLocator(prop.getProperty("workflow.details.recentRuns.name"));
	By workflowDetailsRecentRunInstanceType=getElementLocator(prop.getProperty("workflow.details.recentRuns.instanceType"));
	By workflowDetailsRecentRunExitCode=getElementLocator(prop.getProperty("workflow.details.recentRuns.exitcode"));
	By workflowDetailsRecentRunElapsedTime=getElementLocator(prop.getProperty("workflow.details.recentRuns.elapsedTime"));
	By workflowDetailsRecentRunTriggeredDate=getElementLocator(prop.getProperty("workflow.details.recentRuns.TriggedDate"));
	By workflowDetailsRecentRunTriggeredBy=getElementLocator(prop.getProperty("workflow.details.recentRuns.TriggedBy"));

	By workflowListingPagearrow=getElementLocator(prop.getProperty("workflow.listing.pageArrow"));
	By workflowListingPageMsg=getElementLocator(prop.getProperty("workflow.listing.PaginationMsg"));
	By listingPageStaticNameList = getElementLocator(prop.getProperty("Workflows.listing.static.name.list"));
	By listingPageStaticLastUpdatedList =getElementLocator(prop.getProperty("Workflows.listing.static.lastupdate.list"));
	By listingPageNextPageArrow = getElementLocator(prop.getProperty("Workflows.listing.nextpagearrow"));

	By workflowDetailsRecentRunContext=getElementLocator(prop.getProperty("workflow.details.recentRuns.context"));
	By workflowDetailsRecentRunMode=getElementLocator(prop.getProperty("workflow.details.recentRuns.mode"));
	By workflowDetailsRecentRunExecutionDetailsBtn=getElementLocator(prop.getProperty("workflow.details.recentRuns.executionDetails"));
	By workflowDetailsRecentRunStopButton=getElementLocator(prop.getProperty("workflow.details.recentRuns.stopButton"));
	By workflowDetailsRecentRunDownloadButton=getElementLocator(prop.getProperty("workflow.details.recentRuns.download"));
	By workflowDetailsDiagramContent=getElementLocator(prop.getProperty("workflow.details.diagramContainer.text"));
	By workflowDetailsZoomInButton=getElementLocator(prop.getProperty("workflow.details.button.ZoomIn"));
	By workflowDetailsZoomOutButton=getElementLocator(prop.getProperty("workflow.details.button.ZoomOut"));
	By workflowDetailsZoomToFitButton=getElementLocator(prop.getProperty("workflow.details.button.ZoomToFit"));
	By workflowExecutionDetailsTitle=getElementLocator(prop.getProperty("workflow.details.executionDetails.title"));
	By workflowExecutionDetailsLogs=getElementLocator(prop.getProperty("workflow.details.executionDetails.logs"));
	By workflowExecutionDetailsCancelBtn=getElementLocator(prop.getProperty("workflow.details.executionDetails.cancelButton"));
	By workflowExecutionDetailsDownloadBtn=getElementLocator(prop.getProperty("workflow.details.executionDetails.downloadButton"));
	By workflowExecutionDetailsCopyBtn=getElementLocator(prop.getProperty("workflow.details.executionDetails.copyButton"));
	By sourceConnOverrideTitle=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.title"));
	By overrideDiscardIcon=getElementLocator(prop.getProperty("workflow.details.rules.override.cross.icon"));
	By overrideRefreshIcon=getElementLocator(prop.getProperty("workflow.details.rules.override.refresh.icon"));
	By sourceConnOverrideFindConnLabel=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.findconnection.label"));
	By sourceConnOverrideReplaceConnLabel=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.overrideconnection.label"));
	By sourceConnOverrideFindConnDD=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.findconn.dd"));
	By sourceConnOverrideReplaceConnDD=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.replaceconn.dd"));
	By sourceConnOverrideReplaceConnClearIcon=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.replaceconn.clearIcon"));
	By sourceConnOverrideFindConnName=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.findconn.name"));
	By targetConnOverrideReplaceConnName=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.replaceconn.name"));
	By targetConnOverrideFindConnName=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.findconn.name"));
	By sourceConnOverrideReplaceConnName=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.replaceconn.name"));
	By sourceConnOverrideFindConnEdit=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.findconn.editbutton"));
	By sourceConnOverrideReplaceConnEdit=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.replaceconn.editbutton"));
	By sourceConnOverrideReplaceConnbtn=getElementLocator(prop.getProperty("workflow.details.rules.sourceOverride.replaceSourceConn.button"));
	By sourceConnOverrideSearchBar=getElementLocator(prop.getProperty("workflow.details.rules.searchBar"));
	By sourceConnectionName=getElementLocator(prop.getProperty("workflow.details.sourceConnection"));
	By targetConnOverrideFindConnDD=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.findconn.dd"));
	By targetConnOverrideReplaceConnDD=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.replaceconn.dd"));
	By targetConnOverrideReplaceConnClearIcon=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.replaceconn.clearIcon"));
	By targetConnOverrideFindConnEdit=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.findconn.editbutton"));
	By targetConnOverrideReplaceConnEdit=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.replaceconn.editbutton"));
	By targetConnOverrideReplaceConnbtn=getElementLocator(prop.getProperty("workflow.details.rules.targetOverride.replaceTargetConn.button"));
	By targetConnectionName=getElementLocator(prop.getProperty("workflow.details.targetConnection"));
	By workflowDetailsSidePanelOpen=getElementLocator(prop.getProperty("workflow.details.sidepanel.open"));
	By workflowDetailsSidePanelClose=getElementLocator(prop.getProperty("workflow.details.sidepanel.close"));
	By parameterOverrideCross=getElementLocator(prop.getProperty("workflow.details.rules.parameter.cross"));
	By parameterOverrideTitle=getElementLocator(prop.getProperty("workflow.details.rules.parameter.title"));
	By parameterOverrideFindConnLabel=getElementLocator(prop.getProperty("workflow.details.rules.parameter.findparameter.label"));
	By parameterOverrideReplaceConnLabel=getElementLocator(prop.getProperty("workflow.details.rules.parameter.overrideparameter.label"));
	By parameterOverrideFindConnDD=getElementLocator(prop.getProperty("workflow.details.rules.parameter.findparameter.dd"));
	By parameterOverrideFindParamName=getElementLocator(prop.getProperty("workflow.details.rules.parameter.findparameter.name"));
	By parameterOverrideReplaceParamName=getElementLocator(prop.getProperty("workflow.details.rules.parameter.replaceparameter.name"));
	By parameterOverrideReplaceConnDD=getElementLocator(prop.getProperty("workflow.details.rules.parameter.replaceparameter.dd"));
	By parameterOverrideReplaceConnClearIcon=getElementLocator(prop.getProperty("workflow.details.rules.parameter.replaceparameter.clearIcon"));
	By parameterOverrideFindConnEdit=getElementLocator(prop.getProperty("workflow.details.rules.parameter.findparameter.editbutton"));
	By parameterOverrideReplaceConnEdit=getElementLocator(prop.getProperty("workflow.details.rules.parameter.replaceparameter.editbutton"));
	By parameterOverrideReplaceConnbtn=getElementLocator(prop.getProperty("workflow.details.rules.parameter.replaceparameter.button"));
	By parameterOverName=getElementLocator(prop.getProperty("workflow.details.parameter"));	
	By ruleDatasetsSelectedRuleBtn=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.runBtn.selectedBtn"));
	By ruleDatasetsRunFromHereBtn=getElementLocator(prop.getProperty("workflow.details.rulesAndDatasets.runBtn.ruleFromHereBtn"));
	By discardWorkflowPopupTitle=getElementLocator(prop.getProperty("workflow.details.dicardWorkflow.popupWindow.title"));
	By discardWorkflowPopupContent=getElementLocator(prop.getProperty("workflow.details.dicardWorkflow.popupWindow.message"));
	By discardWorkflowPopupCancelButton=getElementLocator(prop.getProperty("workflow.details.dicardWorkflow.popupWindow.cancelButton"));
	By discardWorkflowPopupDiscardButton=getElementLocator(prop.getProperty("workflow.details.dicardWorkflow.popupWindow.discardButton"));
	By moreOptionPopupWindow=getElementLocator(prop.getProperty("workflow.details.moreOption.PopupWIndow"));
	By moreOptionSubscriptionButton=getElementLocator(prop.getProperty("workflow.details.moreOption.subscriptionButton"));
	By moreOptionDuplicateButton=getElementLocator(prop.getProperty("workflow.details.moreOption.duplicateButton"));
	By moreOptionShareButton=getElementLocator(prop.getProperty("workflow.details.moreOption.shareButton"));
	By moreOptionDeactivateButton=getElementLocator(prop.getProperty("workflow.details.moreOption.deactivateButton"));
	By moreOptionActivateButton=getElementLocator(prop.getProperty("workflow.details.moreOption.activateButton"));
	By subscriptionSidePanelTitle=getElementLocator(prop.getProperty("workflow.details.subscriber.title"));
	By subscriptionSidePanelCrossIcon=getElementLocator(prop.getProperty("workflow.details.subscriber.crossIcon"));
	By subscriptionSidePanelSaveButton=getElementLocator(prop.getProperty("workflow.details.subscriber.SaveButton"));
	By subscriptionSidePanelCancelButton=getElementLocator(prop.getProperty("workflow.details.subscriber.CancelButton"));
	By subscriptionSidePanelOnSuccessLabel=getElementLocator(prop.getProperty("workflow.details.subscriber.OnSuccess.label"));
	By subscriptionSidePanelOnSuccessField=getElementLocator(prop.getProperty("workflow.details.subscriber.OnSuccess.field"));
	By subscriptionSidePanelOnFailureLabel=getElementLocator(prop.getProperty("workflow.details.subscriber.OnFailure.label"));
	By subscriptionSidePanelOnFailureField=getElementLocator(prop.getProperty("workflow.details.subscriber.OnFailure.field"));
	By subscriptionSidePanelOnErrorLabel=getElementLocator(prop.getProperty("workflow.details.subscriber.OnError.label"));
	By subscriptionSidePanelOnErrorField=getElementLocator(prop.getProperty("workflow.details.subscriber.OnError.field"));
	By subscriptionSidePanelUserDropDown=getElementLocator(prop.getProperty("workflow.details.subscriber.title"));
	By subscriptionSidepaneEmailExpand=getElementLocator(prop.getProperty("workflow.details.subscriber.email.expand"));
	By advancedSearchTitle=getElementLocator(prop.getProperty("workflow.advancedSearch.title"));
	By advancedSearchExpand=getElementLocator(prop.getProperty("workflow.advancedSearch.expand"));
	By advancedSearchCollapse=getElementLocator(prop.getProperty("workflow.advancedSearch.collapse"));
	By advancedSearchTypeLabel=getElementLocator(prop.getProperty("workflow.advancedSearch.Type.lable"));
	By advancedSearchTypeExpand=getElementLocator(prop.getProperty("workflow.advancedSearch.Type.expandButton"));
	By advancedSearchTypeCollapse=getElementLocator(prop.getProperty("workflow.advancedSearch.Type.collapseButton"));
	By advancedSearchTypeList=getElementLocator(prop.getProperty("workflow.advancedSearch.Type.list"));
	By advancedSearchStateLabel=getElementLocator(prop.getProperty("workflow.advancedSearch.State.lable"));
	By advancedSearchStateExpand=getElementLocator(prop.getProperty("workflow.advancedSearch.State.expandButton"));
	By advancedSearchStateCollapse=getElementLocator(prop.getProperty("workflow.advancedSearch.State.collapseButton"));
	By advancedSearchStateList=getElementLocator(prop.getProperty("workflow.advancedSearch.State.list"));
	By advancedSearchUpdatedByLabel=getElementLocator(prop.getProperty("workflow.advancedSearch.UpdatedBy.lable"));
	By advancedSearchUpdatedByExpand=getElementLocator(prop.getProperty("workflow.advancedSearch.UpdatedBy.expandButton"));
	By advancedSearchUpdatedByCollapse=getElementLocator(prop.getProperty("workflow.advancedSearch.UpdatedBy.collapseButton"));
	By advancedSearchUpdatedByList=getElementLocator(prop.getProperty("workflow.advancedSearch.UpdatedBy.list"));
	By advancedSearchUpdatedBySearchBar=getElementLocator(prop.getProperty("workflow.advancedSearch.UpdatedBy.searchbar"));
	By advancedSearchUpdatedBySearchButton=getElementLocator(prop.getProperty("workflow.advancedSearch.UpdatedBy.searchBtn"));
	By advancedSearchLastUpdatedLabel=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.lable"));
	By advancedSearchLastUpdatedExpand=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.expandButton"));
	By advancedSearchLastUpdatedCollapse=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.collapseButton"));
	By advancedSearchLastUpdatedFrom=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.fromField"));
	By advancedSearchLastUpdatedFromDateIcon=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.fromField.dateicon"));
	By advancedSearchLastUpdatedTo=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.toField"));
	By advancedSearchLastUpdatedToDateIcon=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.toField.dateicon"));
	By advancedSearchLastUpdatedCalanderDatePopup=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.calander.datePopup"));
	By advancedSearchLastUpdatedCalanderCurrentValue=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.calander.currentYearMon"));
	By advancedSearchLastUpdatedCalanderPreviousBtn=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.calander.previousMonBtn"));
	By advancedSearchLastUpdatedCalanderNextBtn=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.calander.nextMonBtn"));
	By advancedSearchLastUpdatedCalanderTodayBtn=getElementLocator(prop.getProperty("workflow.advancedSearch.LastUpdated.calander.todayBtn"));
	By bulkCopyChangesTitle=getElementLocator(prop.getProperty("workflow.bulk.copy.changes.title"));
	By bulkMoveChangesTitle=getElementLocator(prop.getProperty("workflow.bulk.move.changes.title"));
	By bulkDeleteChangesTitle=getElementLocator(prop.getProperty("workflow.bulk.delete.changes.title"));
	By bulkChangesChooseWorkflowTab=getElementLocator(prop.getProperty("workflow.bulk.chooseworklfow.tab"));
	By bulkChangesChooseWorkflowSearchbar=getElementLocator(prop.getProperty("workflow.bulk.chooseworklfow.SearchBar"));
	By bulkChangesChooseWorkflowSearchbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseworklfow.Searchbutton"));	
	By bulkChangesChooseWorkflowRemovebutton=getElementLocator(prop.getProperty("workflow.bulk.chooseworklfow.removeButton"));
	By bulkChangesChooseWorkflowNextbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseworklfow.nextbutton"));
	By bulkChangesChooseWorkflowCancelbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseworklfow.cancelbutton"));
	By bulkChangesChooseDestinationTab=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.tab"));
	By bulkChangesChooseDestinationFolderTitle=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.foldertitle"));
	By bulkChangesChooseDestinationSearchbar=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.folderSearchbar"));
	By bulkChangesChooseDestinationSearchbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.folderSearchButton"));	
	By bulkChangesChooseDestinationPreviousbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.previousbutton"));
	By bulkChangesChooseDestinationNextbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.nextbutton"));
	By bulkChangesChooseDestinationCancelbutton=getElementLocator(prop.getProperty("workflow.bulk.chooseDestination.cancelbutton"));
	By bulkChangesReviewTab=getElementLocator(prop.getProperty("workflow.bulk.review.tab"));
	By bulkChangesReviewContent=getElementLocator(prop.getProperty("workflow.bulk.review.content"));
	By bulkChangesReviewPreviousbutton=getElementLocator(prop.getProperty("workflow.bulk.review.previousbutton"));
	By bulkChangesReviewNextbutton=getElementLocator(prop.getProperty("workflow.bulk.review.nextbutton"));
	By bulkChangesReviewCancelbutton=getElementLocator(prop.getProperty("workflow.bulk.review.cancelbutton"));
	By bulkChangesProgressTab=getElementLocator(prop.getProperty("workflow.bulk.pregress.tab"));
	By bulkChangesProgressPercentage=getElementLocator(prop.getProperty("workflow.bulk.pregress.percentageCompleted"));
	By bulkChangesProgressLogDetailsTitle=getElementLocator(prop.getProperty("workflow.bulk.pregress.logdetails.title"));
	By bulkChangesProgressLogContent=getElementLocator(prop.getProperty("workflow.bulk.pregress.logDetailscontent"));
	By bulkChangesProgressShareIcon=getElementLocator(prop.getProperty("workflow.bulk.pregress.shareicon"));
	By bulkChangesProgressRefreshIcon=getElementLocator(prop.getProperty("workflow.bulk.pregress.refreshicon"));
	By bulkChangesProgressDoneButton=getElementLocator(prop.getProperty("workflow.bulk.pregress.donebutton"));
	By bulkChangesRemoveWorkflowPopupTitle=getElementLocator(prop.getProperty("workflow.bulk.remove.workflow.popup.title"));
	By bulkChangesRemoveWorkflowPopupContent=getElementLocator(prop.getProperty("workflow.bulk.remove.workflow.popup.content"));
	By bulkChangesRemoveWorkflowPopupRemovebtn=getElementLocator(prop.getProperty("workflow.bulk.remove.workflow.popup.removebutton"));
	By bulkChangesRemoveWorkflowPopupCancelbtn=getElementLocator(prop.getProperty("workflow.bulk.remove.workflow.popup.cancelbutton"));
	By workflowDetailsRecentRunsStopExecutionPopUpTitle=getElementLocator(prop.getProperty("workflow.details.stop.execution.title"));
	By workflowDetailsRecentRunsStopExecutionPopUpContent=getElementLocator(prop.getProperty("workflow.details.stop.execution.content"));
	By workflowDetailsRecentRunsStopExecutionPopUpStopBtn=getElementLocator(prop.getProperty("workflow.details.stop.execution.stopbtn"));
	By workflowDetailsRecentRunsStopExecutionPopUpCancelBtn=getElementLocator(prop.getProperty("workflow.details.stop.execution.cancelbtn"));
	By workflowExecutionReportRuleName=getElementLocator(prop.getProperty("workflow.executionReport.ruleName"));
	By workflowExecutionReportNotRecords=getElementLocator(prop.getProperty("workflow.execution.report.noRecordsDisplay"));
	By workflowFolderExpand=getElementLocator(prop.getProperty("worflow.folderSearch.expand"));
	By workflowListingFolderRefreshIcon=getElementLocator(prop.getProperty("workflow.folderSearch.folder.refresh.icon"));
	By workflowFolderFilterSearchBar=getElementLocator(prop.getProperty("workflow.folderSearch.folder.searchbar"));
	By workflowFolderFilterSearchButton=getElementLocator(prop.getProperty("workflow.folderSearch.folder.searchbutton"));
	By workflowFolderDeletePopupTitle=getElementLocator(prop.getProperty("workflow.folderSearch.folder.delete.popup.title"));
	By workflowFolderDeletePopupContent=getElementLocator(prop.getProperty("workflow.folderSearch.folder.delete.popup.content"));
	By workflowFolderDeletePopupSubContent=getElementLocator(prop.getProperty("workflow.folderSearch.folder.delete.popup.subcontent"));
	By workflowFolderDeletePopupCancelButton=getElementLocator(prop.getProperty("workflow.folderSearch.folder.delete.popup.cancelButton"));
	By workflowFolderDeletePopupDeleteButton=getElementLocator(prop.getProperty("workflow.folderSearch.folder.delete.popup.deleteButton"));
	By workfloeDetailsRulesTab=getElementLocator(prop.getProperty("workflow.details.rules.tab"));
	By workflowDetailsRecentRunsReloadButton=getElementLocator(prop.getProperty("workflow.details.recentRuns.reload.button"));
	By subscribeButton=getElementLocator(prop.getProperty("workflow.details.moreOption.subscribe.button"));
	By unsubscribeButton=getElementLocator(prop.getProperty("workflow.details.moreOption.unsubscribe.button"));
	By unsubscribeDropdownButton=getElementLocator(prop.getProperty("workflow.details.moreOption.unsubscribe.dropdown"));
	By unsubscribeOnSuccessCheckbox=getElementLocator(prop.getProperty("workflow.details.moreOption.unsubscribe.onsuccess.checkbox"));
	By unsubscribeOnFailureCheckbox=getElementLocator(prop.getProperty("workflow.details.moreOption.unsubscribe.onfailure.checkbox"));
	By unsubscribeOnErrorCheckbox=getElementLocator(prop.getProperty("workflow.details.moreOption.unsubscribe.onerror.checkbox"));
	By workflowFolderRefreshIcon=getElementLocator(prop.getProperty("workflow.folder.refresh.icon"));
	By workflowDetailsRulesMasterCheckbox=getElementLocator(prop.getProperty("workflow.details.rules.masterCheckbox"));
	By paginationMsg=getElementLocator(prop.getProperty("Common.PaginationMsg"));
	By paginationBar=getElementLocator(prop.getProperty("Common.PaginationBar"));
	By pagearrow=getElementLocator(prop.getProperty("Common.PageArrow"));
	By workflowDetailsRulesPaginationMsg=getElementLocator(prop.getProperty("workflow.details.rules.PaginationMsg"));
	By workflowDetailsRulesPaginationBar=getElementLocator(prop.getProperty("workflow.details.rules.PaginationBar"));
	By workflowDetailsRulesPagearrow= getElementLocator(prop.getProperty("workflow.details.rules.PageArrow"));
	By workflowDetailsRecentRunsPaginationMsg=getElementLocator(prop.getProperty("workflow.details.recentRuns.PaginationMsg"));
	By workflowDetailsRecentRunsPaginationBar=getElementLocator(prop.getProperty("workflow.details.recentRuns.PaginationBar"));
	By workflowDetailsRecentRunsPagearrow=getElementLocator(prop.getProperty("workflow.details.recentRuns.PageArrow"));
	By workflowListingPageNoRecordDisplay=getElementLocator(prop.getProperty("workflow.listing.page.noRecords"));
	By workflowDetailsPageRulesNoRecordDisplay=getElementLocator(prop.getProperty("workflow.details.page.rules.noRecords"));
	By workflowDetailsPageAddedRulesNoRecordDisplay=getElementLocator(prop.getProperty("workflow.details.page.addedRules.noRecords"));
	By workflowDetailsPageRecentRunsNoRecordDisplay=getElementLocator(prop.getProperty("workflow.details.page.recentRuns.noRecords"));
	By workflowDetailsRulesTabSequenceMasterCheckbox=getElementLocator(prop.getProperty("workflow.details.rulesTab.sequence.masterCheckbox"));
	By welcomeText=getElementLocator(prop.getProperty("LandingPage.WelcomeTextnew"));
	By dataTesting=getElementLocator(prop.getProperty("DataTestingTab"));
	By workflowDetailsRulesUseFlags=getElementLocator(prop.getProperty("workflow.details.rules.use.flag.BySequence"));
	By workflowDetailsRulesNoRecordFound=getElementLocator(prop.getProperty("workflow.details.rules.noRecondsFound"));
	By workflowDetailsRecentRunsNoRecordFound=getElementLocator(prop.getProperty("workflow.details.recentRuns.noRecondsFound"));
	By workflowDetailsAddRulesNoRecordFound=getElementLocator(prop.getProperty("workflow.details.addrules.noRecondsFound"));
	By defaultWorkflowRuleSeq=getElementLocator(prop.getProperty("default.workflow.details.rule.sequence"));
	By defaultWorkflowRuleName=getElementLocator(prop.getProperty("default.workflow.details.rule.name"));
	By defaultWorkflowRuleSourceConn=getElementLocator(prop.getProperty("default.workflow.details.sourceConn.name"));
	By defaultWorkflowRuleTargetConn=getElementLocator(prop.getProperty("default.workflow.details.targetConn.name"));
	By defaultWorkflowRuleParameter=getElementLocator(prop.getProperty("default.workflow.details.parameter.name"));
	By defaultWorkflowRuleFolder=getElementLocator(prop.getProperty("default.workflow.details.folder.name"));
	By workflowFieldValidation=getElementLocator(prop.getProperty("workflow.field.validation"));
	By workflowCreatedByName=getElementLocator(prop.getProperty("workflow.details.createdByName"));
	By workflowCreatedByDate=getElementLocator(prop.getProperty("workflow.details.createdByDate"));
	By workflowRecentRunsChildMsg=getElementLocator(prop.getProperty("workflow.details.recentRuns.ChildPageMsg"));
	By workflowRecentRunsChildPageArrow=getElementLocator(prop.getProperty("workflow.details.recentRuns.ChildPageArrow"));
	By workflowDetailsRulesTabLists=getElementLocator(prop.getProperty("workflow.details.rules.tab.lists"));

	By connectionsTab=getElementLocator(prop.getProperty("Connection.ConnectionTab"));
	By userconnectionsTab=getElementLocator(prop.getProperty("Connection.UserConnectionTab"));
	By connectionNameTitle=getElementLocator(prop.getProperty("connection.name.title"));
	By connectionType=getElementLocator(prop.getProperty("connection.type"));
	By deleteDelBtn = getElementLocator(prop.getProperty("rules.delete.popup.deletebtn"));
	By nameRule = getElementLocator(prop.getProperty("DataTesting.RuleName"));
	By engineType = getElementLocator(prop.getProperty("DataTesting.EngineType"));
	By datasetSpinner = getElementLocator(prop.getProperty("DataTesting.DatasetSpinner"));
	By dataTestingRuleNameField=getElementLocator(prop.getProperty("DataTesting.RuleNameField"));
	By dataTestingSearchBox = getElementLocator(prop.getProperty("dataT.SearchBox"));
	By dataTestingSearchButton = getElementLocator(prop.getProperty("dataT.SearchButton"));
	By dataTestingmoreOptionButton = getElementLocator(prop.getProperty("DataTesting.MoreOptionButton"));
	By dataTestingmoreOptionDropDownButton = getElementLocator(prop.getProperty("DataTesting.MoreOptionDropDownButton"));
	By deleteHeader = getElementLocator(prop.getProperty("rules.delete.popup.title"));
	By deleteText = getElementLocator(prop.getProperty("rules.delete.popup.content"));
	By deleteCancelBtn = getElementLocator(prop.getProperty("rules.delete.popup.cancelbtn"));

	By bulkChangesFolderTitle=getElementLocator(prop.getProperty("new.workflow.bulk.changes.folder.field.title"));
	By bulkChangesFolderField=getElementLocator(prop.getProperty("new.workflow.bulk.changes.folder.field"));
	By bulkChangesFolderFieldDropIcon=getElementLocator(prop.getProperty("new.workflow.bulk.changes.folder.field.dropIcon"));
	By bulkChangesFolderFieldSearchBar=getElementLocator(prop.getProperty("new.workflow.bulk.changes.folder.field.searchBar"));
	By bulkChangesFolderFieldSearchIcon=getElementLocator(prop.getProperty("new.workflow.bulk.changes.folder.field.searchIcon"));
	By bulkChangesFolderNotifyMsg=getElementLocator(prop.getProperty("new.workflow.bulk.changes.notify.msg"));
	By bulkChangesNotifyMsg=getElementLocator(prop.getProperty("new.workflow.bulk.changes.delete.notify.msg"));
	By bulkChangesRefreshLogs=getElementLocator(prop.getProperty("new.workflow.bulk.changes.refreshLog"));
	By bulkChangesCopyToClipboard=getElementLocator(prop.getProperty("new.workflow.bulk.changes.copyToClipboard"));
	By bulkChangesLogs=getElementLocator(prop.getProperty("new.workflow.bulk.changes.logs"));
	By bulkChangesCopyButton=getElementLocator(prop.getProperty("new.workflow.bulk.changes.copy.button"));
	By bulkChangesDoneButton=getElementLocator(prop.getProperty("new.workflow.bulk.changes.done.button"));
	By bulkChangesMoveButton=getElementLocator(prop.getProperty("new.workflow.bulk.changes.move.button"));
	By bulkChangesDeleteButton=getElementLocator(prop.getProperty("new.workflow.bulk.changes.delete.button"));
	By bulkChangesCancelButton=getElementLocator(prop.getProperty("new.workflow.bulk.changes.cancel.button"));
	By bulkChangesCancelCrossIcon=getElementLocator(prop.getProperty("new.workflow.bulk.changes.cancel.crossIcon"));

	By workflowAppliedFilter=getElementLocator(prop.getProperty("Workflow.default.Applied.filter"));
	By workflowListingNextPageArrow=getElementLocator(prop.getProperty("workflow.listing.nextPageArrow"));
	By workflowDetailsRulesNextPageArrow=getElementLocator(prop.getProperty("workflow.details.rules.nextPageArrow"));

	By workflowListingButtonsCount=getElementLocator(prop.getProperty("button.count.listing.workflows"));
	By workflowDetailsBeforeCreateButtonsCount=getElementLocator(prop.getProperty("button.count.details.workflows"));

	By folderSidebarTitle = getElementLocator(prop.getProperty("schedules.details.folder.title"));
	By folderSidebarPanelOpenIcon = getElementLocator(prop.getProperty("workflow.details.folder.panel.close"));
	By ruleSidebarPanelOpenIcon = getElementLocator(prop.getProperty("workflow.details.workflow.panel.close"));

	By workflowTypeIcon = getElementLocator(prop.getProperty("workflow.details.workflow.type.icon"));

	/** ----------------------  String variables ---------------------------------- **/

	String connCommonFieldValidation=prop.getProperty("conn.field.validation");
	String dynamicName=prop.getProperty("DynName");
	String scrollToElementArg=prop.getProperty("ScrollToElementArgument");
	String attributeBorder=prop.getProperty("Attribute.borderToColor");
	String workflowNamelink=prop.getProperty("workflow.name.link.using.folder");
	String workflowNameCheckbox=prop.getProperty("workflow.name.checkbox");
	String workflowNameFieldPlaceHolder=prop.getProperty("workflow.workflowName.field.placeholder");
	String workflowFolderSearchFolderNameCheckbox=prop.getProperty("workflow.folderSearch.folderName.checkbox");
	String selectExistingFolder=prop.getProperty("DataTesting.SelectExistingFolder");
	String folderCreatedToastMsg=prop.getProperty("workflow.toast.folder.created");
	String validScrollFolder=prop.getProperty("parameters.addNewParameter.foldername");
	String addNewWorkflowfolderPath=prop.getProperty("workflow.AddNewWorkflow.folderpath");
	String addNewWorkflowFolderSelect=prop.getProperty("workflow.AddNewWorkflow.folderselect");
	String folderNameValue=prop.getProperty("workflow.AddNewWorkflow.folder.namevalue");
	String folderNameSelect=prop.getProperty("workflow.AddNewWorkflow.folder.nameselect");
	String folderselectBtn=prop.getProperty("parameters.addNewParameter.foldernameselect");
	String workflowNameTitle=prop.getProperty("workflow.details.workflow.title");
	String workflowTypeInDetailsPage=prop.getProperty("workflow.details.workflow.type");
	String workflowDefaultFilterContent=prop.getProperty("workflow.default.filter.content");
	String workflowBreadcrumbFolderName=prop.getProperty("workflow.breadcrumb.folderName");
	String workflowDetailsFolderNameCheckbox=prop.getProperty("workflow.details.folder.name.checkbox");
	String workflowFolderSearchPlaceholder=prop.getProperty("workflow.folder.placeholder");
	String workflowSearchPlaceholder=prop.getProperty("workflow.search.placeholder");
	String workflowListingPageColumn=prop.getProperty("workflow.listing.page.columns");
	String workflowCreatedToastMsg=prop.getProperty("workflow.toast.Created");
	String workflowCodePlaceholder=prop.getProperty("workflow.code.placeholder");
	String workflowDescriptionPlaceholder=prop.getProperty("workflow.description.placeholder");
	String rulesSearchBarPlaceholder=prop.getProperty("workflow.search.rulesAndDataset.placeholder");
	String workflowNameIsEmptyValidationMsg=prop.getProperty("workflow.workflowName.field.validation.empty");
	String ruleDeletePopupWindowContent=prop.getProperty("workflow.ruleDelete.popup.window.content");
	String deleteWorkflowPopupWindowContent=prop.getProperty("workflow.deleteWorkflow.popup.window.content");
	String workflowDeletedToastMessage=prop.getProperty("workflow.toast.Deleted");
	String workflowDetailsRuleSuccessFlag=prop.getProperty("workflow.details.rules.success.flag");
	String workflowDetailsRuleFailureFlag=prop.getProperty("workflow.details.rules.failure.flag");
	String workflowDetailsRuleErrorFlag=prop.getProperty("workflow.details.rules.error.flag");
	String workflowDetailsRuleUseFlag=prop.getProperty("workflow.details.rules.use.flag");
	String workflowDetailsRuleUseFlagBySequence=prop.getProperty("workflow.details.rules.use.flag.BySequence");
	String workflowDetailsRuleActiveFlag=prop.getProperty("workflow.details.rules.active.flag");
	String workflowDetailsSourceConnOverrideButton=prop.getProperty("workflow.details.rules.sourceOverride.button");
	String workflowDetailsSourceConnOverrideButton1=prop.getProperty("workflow.details.rules.sourceOverride.button1");
	String workflowDetailsTargetConnOverrideButton=prop.getProperty("workflow.details.rules.targetOverride.button");
	String workflowDetailsParameterOverrideButton=prop.getProperty("workflow.details.rules.parameterOverride.button");
	String sourceConnectionNameLink=prop.getProperty("workflow.details.rules.searchConnectionName");
	String parameterNameForOverride=prop.getProperty("workflow.details.rules.searchParameterName");
	String workflowSingleSourceConnectionOverrideToastMsg=prop.getProperty("workflow.toast.singleSourceConnection.override");
	String workflowSingleTargetConnectionOverrideToastMsg=prop.getProperty("workflow.toast.singleTargetConnection.override");
	String workflowSingleParameterOverrideToastMsg=prop.getProperty("workflow.toast.singleParameter.override");
	String workflowMultiSourceConnectionOverrideToastMsg=prop.getProperty("workflow.toast.MutipleSourceConnection.override");
	String worklfowAddedRuleNameLink=prop.getProperty("workflow.details.rules.ruleNameLink");
	String workflowDetailsAddedRuleType=prop.getProperty("workflow.details.rules.ruleTypeForRule");
	String worklfowAddedRuleSourceConnLink=prop.getProperty("workflow.details.rules.sourceConnLink");
	String worklfowAddedRuleTargetConnLink=prop.getProperty("workflow.details.rules.targetConnLink");
	String worklfowAddedRuleParameterLink=prop.getProperty("workflow.details.rules.parameterLink");
	String worklfowAddedRuleFolderLink=prop.getProperty("workflow.details.rules.folderLink");
	String discardWorkflowPopupWindowContent=prop.getProperty("workflow.discardWorkflow.popup.window.content");
	String subscriberNameSelect=prop.getProperty("workflow.details.subscriber.name");
	String workflowDuplicateToastMsg=prop.getProperty("workflow.toast.Duplicate");
	String advanceSearchTypeCheckbox=prop.getProperty("workflow.advancedSearch.Type.checkbox");
	String advanceSearchStateCheckbox=prop.getProperty("workflow.advancedSearch.State.checkbox");
	String advanceSearchUpdatedByCheckbox=prop.getProperty("workflow.advancedSearch.UpdatedBy.checkbox");
	String advanceSearchLastUpdatedCalanderSelectMon=prop.getProperty("workflow.advancedSearch.LastUpdated.calander.selectMonYear");
	String advanceSearchLastUpdatedCalanderSelectDate=prop.getProperty("workflow.advancedSearch.LastUpdated.calander.selectdate");
	String moreOptionSelect=prop.getProperty("workflow.more.select");
	String selectWorkflowCheckboxUsingFolder=prop.getProperty("workflow.workflowName.checkbox.using.folder");
	String bulkChangesChooseWorkflowColumn=prop.getProperty("workflow.bulk.chooseworklfow.columns");
	String bulkChangesChooseWorkflowNameCheckbox=prop.getProperty("workflow.bulk.chooseworklfow.workflownameCheckbox");
	String bulkChangesChooseDestinationFolderName=prop.getProperty("workflow.bulk.chooseDestination.folderNamelink");
	String bulkChangesChooseDestinationFolderSelect=prop.getProperty("workflow.bulk.chooseDestination.folderNameSelectButton");
	String bulkChangesSingleWorkflowRemoveTitle=prop.getProperty("workflow.bulk.remove.singleWorkflow.title");
	String bulkChangesSingleWorkflowRemoveContent=prop.getProperty("workflow.bulk.remove.singleWorkflow.content");
	String bulkChangesMultipleWorkflowRemoveTitle=prop.getProperty("workflow.bulk.remove.multipleWorkflow.title");
	String bulkChangesMultipleWorkflowRemoveContent=prop.getProperty("workflow.bulk.remove.multipleWorkflow.content");
	String recentRunsDownloadIconbyInstanceId=prop.getProperty("workflow.details.recentRuns.instanceId.downloadIcon");
	String recentRunsStopExecutionIconbyInstanceId=prop.getProperty("workflow.details.recentRuns.instanceId.stopExecutionIcon");
	String recentRunsSearchPlaceholder=prop.getProperty("workflow.recentRun.search.placeholder");
	String workflowDetailsRuleCheckbox=prop.getProperty("workflow.details.rulename.checkbox");
	String ruleDatasetRuleNameCheckbox=prop.getProperty("workflow.details.ruleDataset.rulename.checkbox");
	String ruleNameHyperlinkUsingFolder=prop.getProperty("workflow.details.ruleName.hyperlink.using.folder");
	String recentRunsStopExecutionPopupTitle=prop.getProperty("workflow.stop.execution.title");
	String recentRunsStopExecutionPopupContent=prop.getProperty("workflow.stop.execution.content");
	String recentRunsStatusByInstanceId=prop.getProperty("workflow.details.recentRuns.instanceId.status");
	String workflowDetailsShareToastMsg=prop.getProperty("workflow.toast.shareWorkflow");
	String overrideConnectionFailedToastMsg=prop.getProperty("workflow.toast.FailedOverrideConnection");
	String overrideParameterFailedToastMsg=prop.getProperty("workflow.toast.FailedOverrideParameter");
	String workflowExecutionExpandArrow=prop.getProperty("workflow.execution.details.dropdown.expand");
	String workflowExecutionCollapseArrow=prop.getProperty("workflow.execution.details.dropdown.collapse");
	String workflowExecutionRuleInstanceIdList=prop.getProperty("workflow.execution.details.ruleInstanceIdList");
	String workflowExecutionRuleInstanceAction=prop.getProperty("workflow.execution.details.ruleInstanceId.action");
	String workflowExecutionRuleInstanceId=prop.getProperty("workflow.execution.details.ruleInstanceId");
	String workflowExecutionRuleInstanceIdHyperLink=prop.getProperty("workflow.execution.details.ruleInstanceId.hyperLink");
	String workflowExecutionRuleInstanceIdRuleType=prop.getProperty("workflow.execution.details.ruleInstanceId.ruleType");
	String workflowExecutionRuleInstanceIdName=prop.getProperty("workflow.execution.details.ruleInstanceId.Name");
	String workflowExecutionRuleInstanceStatus=prop.getProperty("workflow.execution.details.ruleInstanceId.status");
	String workflowExecutionRuleInstanceInstacetype=prop.getProperty("workflow.execution.details.ruleInstanceId.Instancetype");
	String workflowExecutionRuleInstanceExitCode=prop.getProperty("workflow.execution.details.ruleInstanceId.exitcode");
	String workflowExecutionRuleInstanceElapsedTime=prop.getProperty("workflow.execution.details.ruleInstanceId.elapsedtime");
	String workflowExecutionRuleInstanceTriggeredDate=prop.getProperty("workflow.execution.details.ruleInstanceId.triggeredDate");
	String workflowExecutionRuleInstanceTriggeredBy=prop.getProperty("workflow.execution.details.ruleInstanceId.triggeredBy"); 
	String workflowExecutionRuleExpand=prop.getProperty("workflow.execution.details.ruleddetailsExpand");
	String workflowExecutionRuleCollapse=prop.getProperty("workflow.execution.details.ruleddetailsCollapse");	
	String workflowExecutionRuleName=prop.getProperty("workflow.execution.rulename");
	String workflowExecutionRuleType=prop.getProperty("workflow.execution.ruletype");
	String workflowExecutionRuleSrcConn=prop.getProperty("workflow.execution.ruleSourceConn");
	String workflowExecutionRuleTrgConn=prop.getProperty("workflow.execution.ruleTargetConn");
	String workflowExecutionRuleErrDesc=prop.getProperty("workflow.execution.ruleErrorDescription");
	String workflowExecutionRuleExecutionDetails=prop.getProperty("workflow.execution.ruleExecutionDetails");
	String workflowNameBreadcrumbLink=prop.getProperty("workflow.executionReport.breadcrumb.workflowName");
	String workflowToastSFEUncheck=prop.getProperty("workflow.toast.AllSFEFlagUncheck");
	String workflowToastSFELastSequence=prop.getProperty("workflow.toast.SFELastSequence");
	String workflowToastUseColumnEnabled=prop.getProperty("workflow.toast.USEColumnEnabled");
	String workflowToastActiveColumnEnabled=prop.getProperty("workflow.toast.ActiveColumnEnabled");
	String workflowSequenceNumCheckbox=prop.getProperty("workflow.details.ruleDataset.sequence.checkbox");
	String workflowRecentRunsTableCSSStyle=prop.getProperty("workflow.recentRuns.Details.Table.cssStyle");
	String workflowFolderName=prop.getProperty("workflow.folderSearch.folder.name");
	String workflowFolderNameAddButton=prop.getProperty("workflow.folderSearch.folder.addbutton");
	String workflowFolderNameEditButton=prop.getProperty("workflow.folderSearch.folder.editbutton");
	String workflowFolderNameDeleteButton=prop.getProperty("workflow.folderSearch.folder.deletebutton");
	String workflowFolderDeleteToastmsg=prop.getProperty("workflow.toast.deleteFolder");
	String workflowFolderDeletePopupWindContent=prop.getProperty("workflow.deleteFolder.popup.window.content");
	String workflowFolderDeletePopupWindSubContent=prop.getProperty("workflow.deleteFolder.popup.window.subcontent");
	String workflowListingPageFolderName=prop.getProperty("workflow.listing.page.foldername");
	String workflowRuleDragIcon=prop.getProperty("workflow.details.rules.dragicon");
	String folderName=prop.getProperty("workflow.folderSearch.folder.path");
	String workflowNameLinkUsingFolderPath=prop.getProperty("workflow.name.link.using.folderPath");
	String workflowDetailsDiagramContentMessage=prop.getProperty("workflow.details.Diagram.Content.Message");	
	String workflowDetailsRulesTabColumns=prop.getProperty("workflow.details.rulestab.columnNames");
	String workflowDetailsRulesTabColumnLocator=prop.getProperty("workflow.details.rulestab.columnLocator");
	String workflowDetailsRecentRunsTabColumns=prop.getProperty("workflow.details.recentRuns.columnNames");
	String workflowDetailsRecentRunsTabColumnLocator=prop.getProperty("workflow.details.recentRuns.columnLocator");
	String workflowListingPageColumnList=prop.getProperty("workflow.listing.page.column.list");
	String workflowListingTypeIcon=prop.getProperty("workflow.listing.workflowType.icon");
	String workflowListingStatusIcon=prop.getProperty("workflow.listing.workflowStatus.icon");
	String workflowListingUpdatedByIcon=prop.getProperty("workflow.listing.updatedBy.icon");
	String workflowListingPageArrowold=prop.getProperty("workflow.listing.page.arrow");
	String workflwoRecentRunsChildPageArrow=prop.getProperty("workflow.details.recentRuns.ChildArrow");
	String workflowDetailsRecentRunRuleInstanceIdStopIcon=prop.getProperty("workflow.details.recentRuns.ruleInstanceID.StopIcon");
	String workflowDetailsRecentRunRuleInstanceIdStatus=prop.getProperty("workflow.details.recentRuns.ruleInstanceID.status");
	String workflowDetailsRecentRunRuleExitCodeList=prop.getProperty("workflow.execution.details.ruleInstanceIdExitCodeList");
	String workflowDetailsRecentRunRuleStatusList=prop.getProperty("workflow.execution.details.ruleInstanceIdStatusList");
	static String testDataWorkflowJSONColumnNameForDB=prop.getProperty("Workflow.DB.WorkflowJson");
	String workflowDetailsRulesNameList=prop.getProperty("workflow.details.rules.name.list");
	String workflowDetailsRulesSuccessList=prop.getProperty("workflow.details.rules.success.list");
	String workflowDetailsRulesFailureList=prop.getProperty("workflow.details.rules.failure.list");
	String workflowDetailsRulesErrorList=prop.getProperty("workflow.details.rules.error.list");
	String workflowDetailsRulesUseList=prop.getProperty("workflow.details.rules.use.list");
	String workflowDetailsRulesActiveList=prop.getProperty("workflow.details.rules.active.list");
	String workflowExecutionRuleResultType=prop.getProperty("workflow.execution.rule.resultType");
	String workflowExecutionRuleEngineType=prop.getProperty("workflow.execution.rule.engineType");
	String workflowExecutionRuleContext=prop.getProperty("workflow.execution.rule.context");
	String workflowExecutionRuleMode=prop.getProperty("workflow.execution.rule.mode");
	String workflowDetailsRuleFolderNameOnRuleTab=prop.getProperty("workflow.details.ruleDataset.rulename.folderName");
	String workflowDetailsSourceCheck=prop.getProperty("workflow.details.rules.source");
	String workflowDetailsTargetCheck=prop.getProperty("workflow.details.rules.target");
	String workflowDetailsParameterCheck=prop.getProperty("workflow.details.rules.parameter");
	String workflowDetailsOverrideSourceCheck=prop.getProperty("workflow.details.rules.override.source");
	String workflowDetailsOverrideTargetCheck=prop.getProperty("workflow.details.rules.override.target");
	String workflowDetailsOverrideParameterCheck=prop.getProperty("workflow.details.rules.override.parameter");

	String bulkChangesFolderName=prop.getProperty("new.workflow.bulk.changes.folder.name");
	String bulkChangesFolderNameSelect=prop.getProperty("new.workflow.bulk.changes.folder.name.selectIcon");

	String newParameterOverrideWithFolderPath=prop.getProperty("workflow.details.rules.searchParameterName.using.folderpath");
	String newSourceOverrideWithFolderPath=prop.getProperty("workflow.details.rules.sourceOverride.button.using.folderpath");
	String newTargetOverrideWithFolderPath=prop.getProperty("workflow.details.rules.targetOverride.button.using.folderpath");
	String newParameterFolderPath=prop.getProperty("workflow.details.rules.paramOverride.button.using.folderpath");

	String newworkflowDetailsRuleSuccessFlag=prop.getProperty("workflow.details.rules.success.flag.using.folderpath");
	String newworkflowDetailsRuleFailureFlag=prop.getProperty("workflow.details.rules.failure.flag.using.folderpath");
	String newworkflowDetailsRuleErrorFlag=prop.getProperty("workflow.details.rules.error.flag.using.folderpath");
	String newworkflowDetailsRuleUseFlag=prop.getProperty("workflow.details.rules.use.flag.using.folderpath");
	String newworkflowDetailsRuleActiveFlag=prop.getProperty("workflow.details.rules.active.flag.using.folderpath");
	String newworklfowAddedRuleNameLink=prop.getProperty("workflow.details.rules.ruleNameLink.using.folderpath");
	String newworkflowDetailsAddedRuleType=prop.getProperty("workflow.details.rules.ruleTypeForRule.using.folderpath");
	String newworklfowAddedRuleSourceConnLink=prop.getProperty("workflow.details.rules.sourceConnLink.using.folderpath");
	String newworklfowAddedRuleTargetConnLink=prop.getProperty("workflow.details.rules.targetConnLink.using.folderpath");
	String newworklfowAddedRuleParameterLink=prop.getProperty("workflow.details.rules.parameterLink.using.folderpath");
	String newworklfowAddedRuleFolderLink=prop.getProperty("workflow.details.rules.folderLink.using.folderpath");


	String connectionTestMess = prop.getProperty("connectionTestMess");
	String deleteToastMsg = prop.getProperty("rules.toast.deleteRule");
	String deleteRuleContent = prop.getProperty("rules.delete.content");
	String engineTypeSelectOption = prop.getProperty("DataTesting.EngineTypeSelectOption");
	String formatTypeSelectOption = prop.getProperty("DataTesting.FormatTypeSelectOption");
	String chooseTemplate = prop.getProperty("DataTesting.ChooseTemplate");
	String dataTestingmoreValueOption = prop.getProperty("DataTesting.MoreValueOption");
	String ruleDuplicateMess = prop.getProperty("DataTesting.RuleDuplicateMess");
	String ruleCopyMess = prop.getProperty("DataTesting.RuleCopyMess");
	String searchRuleLabel="Search rule";
	String deleteRuleTitle=prop.getProperty("rules.delete.title");
	String placeholderSearchUser=prop.getProperty("parameters.placeholder.search.user");
	String placeholderSearchParameter="Search parameter";

	String workflowTypeUsingName=prop.getProperty("workflow.details.workflow.type.using.name");

	/**---------------- common strings --------------------**/

	String searchBoxLabel=prop.getProperty("string.searchBox");
	String attributeClass=prop.getProperty("string.attributeClass");
	String attrcheck=prop.getProperty("string.attrcheck");
	String attrUncheck=prop.getProperty("string.attrUncheck");
	String attributeValue=prop.getProperty("string.attributeValue");
	String attributeTextContent=prop.getProperty("string.attributeTextContent");
	String attributeTitle=prop.getProperty("string.attributeTitle");
	String attributePlaceholder=prop.getProperty("string.attributePlaceholder");
	String attributeAriaLabel=prop.getProperty("string.attributeAriaLabel");
	String workflowPublish=prop.getProperty("string.workflowPublish");
	String workflowValidate=prop.getProperty("string.workflowValidate");
	String workflowDraft=prop.getProperty("string.workflowDraft");
	String workflowRuleListJsonPath=prop.getProperty("string.workflowRuleListJsonPath");
	String workflowNameTimeStampFormat=prop.getProperty("string.workflowNameTimeStampFormat");
	String fieldWorkflowName=prop.getProperty("string.fieldWorkflowName");
	String deleteButtonContent= prop.getProperty("string.deleteButtonContent");
	String searchPlaceholder=prop.getProperty("string.searchPlaceholder");
	String cancelButtonContent=prop.getProperty("string.cancelButtonContent");
	String runningStatus=prop.getProperty("string.runningStatus");
	String readerFlag=prop.getProperty("string.readerFlag");
	String sourceConnectionOverrideField=prop.getProperty("String.sourceConnectionOverrideField");
	String targetConnectionOverrideField=prop.getProperty("String.targetConnectionOverrideField");
	String parameterOverrideField=prop.getProperty("String.parameterOverrideField");
	String runOptionField=prop.getProperty("String.runOptionField");
	String deleteField=prop.getProperty("String.deleteField");
	String sourceConnectionField=prop.getProperty("String.sourceConnectionField");
	String findConnectionField=prop.getProperty("String.findConnectionField");
	String overrideConnectionField=prop.getProperty("String.overrideConnectionField");
	String findConnectionEditField=prop.getProperty("String.findConnectionEditField");
	String replaceConnectionEditField=prop.getProperty("String.replaceConnectionEditField");
	String replaceSourceConnectionField=prop.getProperty("String.replaceSourceConnectionField");
	String targetConnectionField=prop.getProperty("String.targetConnectionField");
	String replaceTargetConnectioField=prop.getProperty("String.replaceTargetConnectioField");
	String parameterField=prop.getProperty("String.parameterField");
	String findParameterField=prop.getProperty("String.findParameterField");
	String overrideParameterField=prop.getProperty("String.overrideParameterField");
	String findParameterEditField=prop.getProperty("String.findParameterEditField");
	String replaceParameterEditField=prop.getProperty("String.replaceParameterEditField");
	String replaceParameterField=prop.getProperty("String.replaceParameterField");
	String workflowsTitle=prop.getProperty("string.workflowsTitle");
	String continueString=prop.getProperty("string.continueString");
	String terminateString=prop.getProperty("string.terminateString");
	String discardContent=prop.getProperty("string.discardContent");
	String cancelContent=prop.getProperty("string.cancelContent");
	String nextContent=prop.getProperty("string.nextContent");
	String previousContent=prop.getProperty("string.previousContent");
	String folderContent=prop.getProperty("string.folderContent");
	String copyContent=prop.getProperty("string.copyContent");
	String moveContent=prop.getProperty("string.moveContent");
	String deleteContent=prop.getProperty("string.deleteContent");
	String removeContent=prop.getProperty("string.removeContent");
	String dynamicMonth=prop.getProperty("string.dynamicMonth");
	String dynamicDate=prop.getProperty("string.dynamicDate");
	String dynamicFolderName=prop.getProperty("string.dynamicFolderName");
	String regexToRemoveBracess=prop.getProperty("regex.bracess");
	String successContent=prop.getProperty("string.successContent");
	String failureContent=prop.getProperty("string.failureContent");
	String errorContent=prop.getProperty("string.errorContent");
	String useContent=prop.getProperty("string.useContent");
	String activeContent=prop.getProperty("string.activeContent");
	String todayContent=prop.getProperty("string.todayContent");
	String saveContent=prop.getProperty("string.saveContent");
	String runContent=prop.getProperty("string.runContent");
	String overviewContent=prop.getProperty("string.overviewContent");
	String homeContent=prop.getProperty("string.homeContent");
	String dataTestingContent=prop.getProperty("string.dataTestingContent");
	String workflowContent=prop.getProperty("string.workflowContent");
	String workflowCodeContent=prop.getProperty("string.workflowCodeContent");
	String descriptionContent=prop.getProperty("string.descriptionContent");
	String checksumContent=prop.getProperty("string.checksumContent");
	String reconContent=prop.getProperty("string.reconContent");
	String validationContent=prop.getProperty("string.validationContent");
	String pushdownContent=prop.getProperty("string.pushdownContent");
	String scriptContent=prop.getProperty("string.scriptContent");
	String successStatusContent=prop.getProperty("string.successStatusContent");
	String warningStatusContent=prop.getProperty("string.warningStatusContent");
	String errorStatusContent=prop.getProperty("string.errorStatusContent");
	String skippedStatusContent=prop.getProperty("string.skippedStatusContent");
	String runningStatusContent=prop.getProperty("string.runningStatusContent");
	String trueContent=prop.getProperty("string.trueContent");
	String falseContent=prop.getProperty("string.falseContent");
	String notVisibleContent="is not visible";
	String visibleContent=" is visible";
	String workflowRunContent="Workflow Run";
	String stateContent="State";
	String advanceSearchContent=prop.getProperty("string.AdvanceSearchContent");
	String searchFolderContent=prop.getProperty("string.searchFolderContent");
	public String publishContent=prop.getProperty("string.publishContent");
	String validateContent=prop.getProperty("string.validateContent");
	String draftContent=prop.getProperty("string.draftContent");
	String activateContent=prop.getProperty("string.activateContent");
	String deactivateContent=prop.getProperty("string.deactivateContent");
	String executorContent=prop.getProperty("string.executorContent");
	String readerContent=prop.getProperty("string.readerContent");
	String recentRunsContent=prop.getProperty("string.recentRunsContent");
	String moreOptionContent=prop.getProperty("string.moreOptionContent");
	String workflowSaveContentLog=prop.getProperty("string.workflowSaveContentLog");
	String ownerContent=prop.getProperty("string.ownerContent");
	String contributorContent=prop.getProperty("string.contributorContent");
	String refreshContent=prop.getProperty("string.refreshContent");
	String workflowLongRunMessage=prop.getProperty("workflow.LongRun.Message");
	String createdContent=prop.getProperty("workflow.Created");
	String shareContent=prop.getProperty("string.shareContent");
	String pageArrowContent=prop.getProperty("string.pageArrowContent");
	String disableContent=prop.getProperty("string.disableContent");
	String dynamicNumber=prop.getProperty("string.dynamicNumber");
	String paginationNumberLink=prop.getProperty("Common.PageNumberLink");
	static String errorLogTitle=prop.getProperty("string.Error.Log.Title");
	String rulesContent=prop.getProperty("string.rulesContent");
	String columnContent=prop.getProperty("string.columnContent");
	public String ruleNameContent=prop.getProperty("string.ruleName");
	String ruleTypeContent=prop.getProperty("string.ruleType");
	String sourceConnectionContent=prop.getProperty("string.sourceConnection");
	String targetConnectionContent=prop.getProperty("string.targetConnection");
	String customContent=prop.getProperty("string.custom");
	String checkContent="check";
	String uncheckContent="uncheck";
	String excelContent="excel";
	String sheetContent="sheet";
	String clickedOn="Clicked on ";
	String addedRuleLog="----------------------- Adding rule :";
	String workflowLog="  to workflow -----------------------";
	String logString="--------------";
	String overrideRuleContent="Overriding Rule";
	String workflowExitCodeContent="Workflow Exit Code";
	String workflowSaveLog="Saving the workflow...";
	String workflowExecutionStuckLog="Workflow Execution is in running state for long time, kindly check";
	String workflowInstanceIdNotLog="Workflow instance id not generated";
	String previousIdLog=" Previous id: ";
	String currentIdLog=" & Current id: ";
	String allContent="ALL";
	String zipContent="zip";
	String workflowSuccessExitCode="0";
	String workflowErrorExitCode="-37";
	String ruleConfigurationContent="Rules flags configuration";
	String workflowDescriptionContent="Workflow Description";
	String duplicateContent="Duplicate";
	String saveOptionContent="Save option";
	String defaultContent="Default";
	String stopContent=prop.getProperty("string.StopContent");
	String sourceColumnName=prop.getProperty("workflow.source.Column");
	String targetColumnName=prop.getProperty("workflow.target.Column");
	String parameterColumnName=prop.getProperty("workflow.parameter.Column");
	String workflowDetailsRulesPaginationNumberLink=prop.getProperty("workflow.details.rules.PageNumberLink");
	String workflowDetailsRecentRunsPaginationNumberLink=prop.getProperty("workflow.details.recentRuns.PageNumberLink");
	String overrideFunctionalityErrorLog=" override window is not visible";
	String workflowExecutionLog="Verifying Workflow Execution status.....";
	String enteringValueContent=" Entering value : ";
	String runFromHereContent="Rule from here";
	String attributeInnertext="innerText";
	String folderDotContent=" folder.";
	String instanceIdContent=" Instance ID";
	String checkingContent="checking ";
	String iconContent=" icon ";
	String flagContent=" flag ";
	String onSuccessContent="On Success";
	String onFailureContent="On Failure";
	String onErrorContent="On Error";

	String singleContent="single";
	String bulkContent="bulk";

	String labelFolderSearch="Folder search";
	String labelWorkflowName="Workflow name";
	String unexpectedContent="Unexpected";
	static String httpsProtocalContent="https";
	String parameterNameContent="parameter name";

	String nextPageArrowContent="next page arrow";
	String calanderDateFormat="M/d/yyyy";

	String stringSkipped=prop.getProperty("string.skipped");
	String stringsuccess=prop.getProperty("string.success");
	String stringWarning=prop.getProperty("string.warning");
	String stringCritical=prop.getProperty("string.critical");
	String stringBlocker=prop.getProperty("string.blocker");
	String stringError=prop.getProperty("string.error");
	String stringRunning=prop.getProperty("string.running");
	String stringSubmitted=prop.getProperty("string.submittedContent");

	String placeholderSearchWorkflow="Search workflow";
	String listingContent = " listing";
	String adminContent="admin";

	String jscriptToClick="arguments[0].click();";
	String jscriptToMouseHover="arguments[0].dispatchEvent(new Event('mouseover'));";

	String [] ruleInstanceHeader = ConstantProperty.RECENTRUNSCOLUMNTABLEHEADER;

	//	String [] ruleInstanceHeader = {"Seq","Instance ID","Status","Instance Type", "Exit Code","Elapsed Time"};// UI changed for release 3

	String lastContent="last";
	String preContent="previous";
	String wkflsheetName="config";
	String keyColumn="key";
	String valueColumn="value";

	String sourceConnection="";
	String targetConnection="";
	String parameter="";
	String overrideSourceConnection="";
	String overrideTargetConnection="";
	String overrideParameter="";
	String overrideChangeSourceConnection="";
	String overrideChangeTargetConnection="";
	String overrideChangeParameter="";

	String incompleteConnection="";
	String brokenConnection="";

	String connectionUsername="";
	String connectionPassword="";
	String connectionUsernameInvalid="";
	String connectionPasswordInvalid="";

	String keyRuleFolder="RuleFolder";
	String keyRuleSourceConnection="RuleSourceConnection";
	String keyRuleTargetConnection="RuleTargetConnection";
	String keyRuleParameter="RuleParameter";
	String keyRuleOverrideSource="RuleOverrideSource";
	String keyRuleOverridetarget="RuleOverridetarget";
	String keyRuleOverrideParameter="RuleOverrideParameter";
	String keyChangeOverrideSource="ChangeOverrideSource";
	String keyChangeOverrideTarget="ChangeOverrideTarget";
	String keyChangeOverrideParameter="ChangeOverrideParameter";

	static String keyWorkflowUpdateJson="workflow_update_json";
	static String keyRuleInfo="rule_info";

	static String keyworkflowName="workflowName";
	static String keyfolderName="folderName";
	static String keyworkflowJson="workflowJson";
	static String keyexecutionStatus="executionStatus";
	static String keyexitCode="exitCode";
	static String keysequence="sequence";
	static String keytestResult="testResult";
	static String keyisOverride="isOverride";
	static String keyrunType="runType";
	static String ketTestScenario="testScenario";
	static String keyScenarioName="scenarioName";
	static String keyScenarioType="scenarioType";

	static boolean workflowExecutionDynamicDataFlag=System.getProperty("wkflDynamicData") != null && Boolean.parseBoolean(System.getProperty("wkflDynamicData"));
	static String workflowExecutionConfigColumnName=System.getProperty("wkflConfigColumn") != null ? System.getProperty("wkflConfigColumn") : "";
	String workflowFolderNameForSanity="";
	String workflowParamFolder="";

	/* ---------- JSON path -------------*/

	static String jsonPathWorkflowType=prop.getProperty("JsonPath.workflowType");
	static String jsonPathIsActive=prop.getProperty("jsonPathIsActive");
	static String jsonPathFolderId=prop.getProperty("jsonPathFolderId");
	static String jsonPathFolderName=prop.getProperty("jsonPathFolderName");
	static String jsonPathState=prop.getProperty("jsonPathState");
	static String jsonPathCode=prop.getProperty("jsonPathCode");
	static String jsonPathDescription=prop.getProperty("jsonPathDescription");
	static String jsonPathStatus=prop.getProperty("jsonPathStatus");
	static String jsonPathEngineType=prop.getProperty("jsonPathEngineType");
	static String jsonPathTemplate=prop.getProperty("jsonPathTemplate");
	static String activityJsonPath=prop.getProperty("ActivityJsonPath");
	static String overrideJsonPath=prop.getProperty("jsonPathOverride");
	static String jsonPathSubcriptionSuccess=prop.getProperty("jsonPathSubcriptionSuccess");
	static String jsonPathSubcriptionFailure=prop.getProperty("jsonPathSubcriptionFailure");
	static String jsonPathSubcriptionError=prop.getProperty("jsonPathSubcriptionError");
	static String jsonPathOverrideTypeList="$.overrides..type";
	static String jsonPathActivity="$.activities[";
	static String jsonPathOverrideSubtypes="].overrides..subType";
	static String jsonPathSubtype="].subType";
	static String jsonPathOverride="].overrides[";
	static String jsonPathReplace="].replace";

	/* ---------- API Variables -------------*/

	static String authorization=prop.getProperty("api.authorization");
	static String apibasic=prop.getProperty("api.apibasic");
	static String apicontentType=prop.getProperty("api.apicontentType");
	static String applicationJSonContentType=prop.getProperty("api.applicationJSonContentType");
	static String apiworkspaceId=prop.getProperty("api.apiworkspaceId");
	static String apiorgId=prop.getProperty("api.apiorgId");
	static String apiBearer=prop.getProperty("api.apiBearer");
	static String jsonPathName=prop.getProperty("ConnName.JsonPath");
	static String jsonPathGetId=prop.getProperty("jsonPathGetId");

	int workflowRefreshCount = Integer.parseInt(prop.getProperty("workflow.refresh.count"));
	protected List<String> ruleSequenceUseFlagList = null;
	protected String [][] rulesConfigurationtable =null;

	protected String ruleSourceConnectionOverride=null;
	protected String ruleTargetConnectionOverride=null;
	protected String ruleParameterOverride=null;

	/* ------------ excel column names ----------- */

	static String columnWorkflowName="workflow_name";

	/** -------------------------------------------- Workflow Common Methods -------------------------------------------- **/

	public String getWorkflowCommonFolderNameForExecution() {
		String readColumnName="";
		if(workflowExecutionConfigColumnName.isEmpty()) {
			readColumnName=valueColumn;
		}else {
			readColumnName=workflowExecutionConfigColumnName;
		}
		return readColumnName;
	}

	public void handleDiscardWindow() {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayed(driver, discardButtons, 10);
			/**	isDisplayedInLoop(driver, 1, discardButtons); **/
			if (isDisplayed(driver, discardButtons, 10)) {
				clickOnButton(driver, discardButtons, discardContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" handleDiscardWindow ");

		}
	}

	public void clickOnButtonIfVisible(By locator, String label) {

		if(isDisplayed(driver, locator, 20)) {
			clickOnButton(driver, locator, label, true);
		}
	}

	public boolean clickOnWorkflowsTabNew() {

		boolean flag = false;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 1, workflowTitle);

			if(isDisplayed(driver, newWorkflowButton)) { BaseSuite.reportLog(workflowContent+" listing page is visible"); return true; }

			if(isDisplayed(driver, addNewWorkflowCancelButton)) { clickOnButton(driver, addNewWorkflowCancelButton, cancelButtonContent, true);}

			isDisplayedInLoop(driver, 1, workflowTab);

			if(!isDisplayed(driver, workflowTab)) { BaseSuite.reportFailLog(workflowContent+" tab not visible", "clickOnWorkflowsTabNew"); return false; }

			flag = isClickable(driver, workflowTab, workflowContent+ " tab", true);

			if(!flag) { return false ; }

			BaseSuite.validationReportLog("Clicking on  "+workflowContent+" tab");

			displayAndClick(driver,  workflowTab);

			handleDiscardWindow();

			BaseSuite.validationReportLog("Clicked on "+workflowContent+" tab");

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			flag=validateElement(driver, workflowTitle, workflowContent, attributeTitle);

			clickOnButton(driver, refreshWorkflowButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" clickOnWorkflowsTabNew ");
			flag=false;
		}

		return flag;

	}

	//click on workflow tab
	public boolean clickOnWorkflowTab() {
		boolean flag = false;
		int i=0;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			handleDiscardWindow();

			clickOnButtonIfVisible(addNewWorkflowCancelButton, cancelButtonContent);

			isDisplayedInLoop(driver, 2, workflowTab);

			if(isDisplayed(driver, workflowTab, 50)) {

				flag = isClickable(driver, workflowTab, "Workflows tab", true);

				if(flag) {

					BaseSuite.reportLog("Clicking on Workflows tab");

					displayAndClick(driver, workflowTab);

					BaseSuite.validationReportLog("Clicked on Workflows tab");

					handleDiscardWindow();

					clickOnButtonIfVisible(workflowExecutionDetailsCancelBtn, cancelButtonContent);

					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					do{
						i++;

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}while(i==2);

					handleDiscardWindow();

					visible(driver, workflowTitle, 60);

					flag=validateTitle(driver, workflowTitle, workflowsTitle);

					if(!flag) {

						BaseSuite.reportFailLog("Workflow tab not visible", "clickOnWorkflowTab");

						driver.navigate().refresh();

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					}
					clickOnButton(driver, refreshWorkflowButton, refreshContent, true);

				}
			}else {
				BaseSuite.reportFailLog("Workflow tab not visible", "clickOnWorkflowTab");
				handleDiscardWindow();

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowTab ");

			throw new AssertionError(ConstantProperty.TESTCASE_FAILED);
		}
		finally {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			waitTillDisplayed(driver, dataTSpinner, 1000);
			isDisplayedInLoop(driver, 2, dataTSpinner);
			if(isDisplayed(driver, dataTSpinner)) {
				BaseSuite.reportLog("Failed due to Spinner Didn't stop/invisible ");
				driver.navigate().refresh();
				BaseSuite.reportLog("Hence Refreshing the current webpage");
				driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		}

		return flag;	

	}

	public boolean searchWorkflowNameAndClickOnLinkOnListingPage(String workflowName, String folderPath) {

		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, placeholderSearchWorkflow, placeholderSearchWorkflow, workflowName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !isDisplayed(driver, workflowListingPageNoRecordDisplay)) {

				By locator = returnTwoElements(workflowNamelink, dynamicName, workflowName, dynamicFolderName,folderPath);

				flag=searchWorkflowNameOnEachPageAndClickOn(locator, workflowName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog("no records to display is visible ","searchScheduleNameAndClickOnLinkOnListingPage");
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchWorkflowNameAndClickOnLinkOnListingPage ");
			flag=false;
		}
		return flag;

	}

	public boolean searchWorkflowNameOnEachPageAndClickOn(By locator, String name) {

		boolean flag=false;
		boolean nextpageFlag=true;
		int pn=0;

		try {

			do {

				BaseSuite.reportLog("searching workflow name : "+name+" on page number ::"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("workflow name : "+name+" found on page number ::"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					break;
				}
				if(isDisplayed(driver, workflowListingNextPageArrow)) {

					String status = getAttribute(driver, workflowListingNextPageArrow, attributeClass);

					if (!status.contains(disableContent)) {

						clickOnButton(driver, workflowListingNextPageArrow, "next page arrow", true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled ");
						nextpageFlag=false;
					}

				}

			}while(nextpageFlag);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" searchWorkflowNameOnEachPageAndClickOn ");
			flag=false;
		}
		return flag;
	}

	//click on workflow name on workflow listing page
	public boolean clickOnWorkflowNameOnWorkflowListingPage(String name, String folderName) {
		boolean flag=true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, returnTwoElements(workflowNamelink, dynamicName, name, dynamicFolderName,folderName));

			if(isDisplayed(driver, returnTwoElements(workflowNamelink, dynamicName, name, dynamicFolderName,folderName))) {

				clickOnButton(driver, returnTwoElements(workflowNamelink, dynamicName, name, dynamicFolderName,folderName), name, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog("Workflow name not visible name:"+name+" folder : "+folderName, "clickOnWorkflowNameOnWorkflowListingPage");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowNameOnWorkflowListingPage ");
			flag=false;

		}
		return flag;
	}

	public boolean searchWorkflowOnEachPageAndClickOn(String name, String folderName) {

		boolean flag=true;
		boolean nextpageFlag=true;
		By locator=null;
		int pn=0;

		try {
			if(folderName.contains("/")) {
				locator=returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, name, dynamicFolderName,folderName);
			}else {
				locator=returnTwoElements(workflowNamelink, dynamicName, name, dynamicFolderName,folderName);
			}

			do {

				BaseSuite.reportLog("searching workflow name : "+name+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("workflow name : "+name+" found on page number :"+(pn+1));

					flag=clickOnButton(driver, locator, name, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					checkUnexpectedToast();

					break;
				}
				if(isDisplayed(driver, workflowListingNextPageArrow)) {

					String status = getAttribute(driver, workflowListingNextPageArrow, attributeClass);

					if (!status.contains("disable") && !isDisplayed(driver, locator)) {

						clickOnButton(driver, workflowListingNextPageArrow, nextPageArrowContent, true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
						flag=false;
					}

				}

			}while(nextpageFlag);

			if(!flag) {
				BaseSuite.reportFailLog("Searched value not found kindly check", "searchWorkflowOnEachPageAndClickOn");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchWorkflowOnEachPageAndClickOn ");
			flag=false;
		}
		return flag;
	}

	public boolean searchAndClickOnWorkflowNameOnWorkflowListingPage(String name, String folderName) {
		boolean flag = true;

		try {

			new WorkflowServicePage(driver).removeAppliedFilterofParameter(true);

			BaseSuite.reportLog("Searching for workflow on listing page : Name = " + name + ", Folder = " + folderName);
			
			new WorkflowServicePage(driver).applyFilterUsingFolderSearch(folderName);

			// Search by name
			flag = searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton,
					placeholderSearchWorkflow, placeholderSearchWorkflow, name);

			// Check for results
			if (isDisplayed(driver, noRecordsFound)) {
				BaseSuite.reportFailLog("Workflow not found", "searchAndClickOnWorkflowNameOnWorkflowListingPage");
				BaseSuite.skipReportLog("No workflow found for: " + name+ ", Folder = " + folderName);
				return false;
			}

			// Search across pagination and click
			flag = searchWorkflowOnEachPageAndClickOn(name, folderName);
			waitForSpinnerToDisappear();

			return flag;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " searchAndClickOnWorkflowNameOnWorkflowListingPage: " + e.toString());
			return false;
		}
	}


	//click on workflow name on workflow listing page
	public boolean clickOnWorkflowNameOnWorkflowListingPageUsingFolderPath(String name, String folderName) {
		boolean flag=true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 5, returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, name, dynamicFolderName,folderName));

			if(isDisplayed(driver, returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, name, dynamicFolderName,folderName))) {

				clickOnButton(driver, returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, name, dynamicFolderName,folderName), name, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog("Workflow name not visible name:"+name+" folder path :"+folderName, "clickOnWorkflowNameOnWorkflowListingPageUsingFolderPath");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowNameOnWorkflowListingPageUsingFolderPath ");
			flag=false;

		}
		return flag;
	}

	//search workflow functionality on workflow listing page
	public boolean searchAndClickOnWorkflowNameOnWorkflowListingPageUsingFolderPath(String name, String folderpath) {
		boolean flag=true;

		try {
			flag=searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, placeholderSearchWorkflow, placeholderSearchWorkflow, name);

			if(elementNotVisible(driver, noRecordsFound)) {

				if(flag) {

					flag=clickOnNameOnListingPage(name,folderpath,labelWorkflowName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					checkUnexpectedToast();
				}else {
					BaseSuite.reportFailLog("Searched workflow name not found","searchAndClickOnWorkflowNameOnWorkflowListingPageUsingFolderPath");

				}
			}else {
				BaseSuite.reportFailLog("No workflow found for searched value : "+name,"searchAndClickOnWorkflowNameOnWorkflowListingPageUsingFolderPath");
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndClickOnWorkflowNameOnWorkflowListingPageUsingFolderPath "+e.toString());

			flag=false;
		}

		return flag;
	}

	//click on workflow name check-box 
	public boolean clickOnWorkflowNameCheckbox(boolean flag, String name, boolean state) {
		String chkstatus =null;

		try {
			if(flag) {
				isDisplayedInLoop(driver, 5, returnElement(workflowNameCheckbox, dynamicName, name));

				if(isDisplayed(driver, returnElement(workflowNameCheckbox, dynamicName, name))) {

					chkstatus = getAttribute(driver, returnElement(workflowNameCheckbox, dynamicName, name), attributeClass);

					if(chkstatus.contains(attrUncheck) && state) {

						clickOnButton(driver, returnElement(workflowNameCheckbox, dynamicName, name), name, true);

					}else if(chkstatus.contains(attrcheck)) {

						BaseSuite.reportLog("Workflow name "+name+" checkbox already checked ");
					}

					chkstatus = getAttribute(driver, returnElement(workflowNameCheckbox, dynamicName, name), attributeClass);

					if(state && !chkstatus.contains(attrUncheck)) {

						BaseSuite.reportLog("Workflow name "+name+" checkbox checked ");
					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Workflow name checkbox not visible ", "clickOnWorkflowNameOnWorkflowListingPage");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowNameOnWorkflowListingPage");
			flag=false;

		}
		return flag;		
	}

	public boolean checkPrivilegeWhileNewWorkflow(boolean flag,String icedqUser) {

		try {
			if((icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))){

				log.info(icedqUser+" has privileage to create new custom workflow");

			}else {
				isDisplayedInLoop(driver, 2, addNewWorkflowCrossButton);
				if(isDisplayed(driver, addNewWorkflowCrossButton)) {

					BaseSuite.reportFailLog("New Workflow button not working properly , add new Workflow page not visible", "checkPrivilegeWhileNewWorkflow");
					flag=false;
					displayAndClick(driver, addNewWorkflowCrossButton);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkPrivilegeWhileNewWorkflow");
			flag=false;
		}
		return flag;
	}


	public boolean validateNewWorkflowButtonFunctionality(boolean flag,String icedqUser) {

		try {
			isDisplayedInLoop(driver, 2, addNewWorkflowTitle);
			if (isDisplayed(driver, addNewWorkflowTitle) && (icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent))) {

				verifyIndividualLabel(driver, addNewWorkflowTitle, "Add New Workflow");

				BaseSuite.validationReportLog("New Workflow button is clicked "+ConstantProperty.SUCCESSSTRING+" and Add new workflow title is visible");

			}else{
				BaseSuite.reportFailLog("New Workflow button not clicked properly , create new Workflow page not visible", "validateNewWorkflowButtonFunctionality");
				flag=false;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNewWorkflowButtonFunctionality");
			flag=false;
		}
		return flag;
	}

	//click on new workflow button
	public boolean clickOnNewWorkflowButton(boolean flag,String icedqUser) {

		try {
			if(flag) {
				flag=clickOnButton(driver, newWorkflowButton, "New Workflow", true);

				if(flag) {

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 1, toastMsg);

					if (isDisplayed(driver, toastMsg) || icedqUser.toLowerCase().contains(executorContent) || icedqUser.toLowerCase().contains(readerContent)) {

						flag = captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG,
								"New workflow authorization message");

					}else {

						flag=validateNewWorkflowButtonFunctionality(flag, icedqUser);

					}

					flag=checkPrivilegeWhileNewWorkflow(flag, icedqUser);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportLog(errorLogTitle+" clickOnNewWorkflowButton ");
			flag=false;

		}
		return flag;
	}

	//validate add new workflow side-bar fields and buttons
	public boolean validateAddNewWorkflowSideBar() {

		boolean flag = true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, addNewWorkflowTitle);

			if(isDisplayed(driver, addNewWorkflowTitle)) {

				verifyIndividualLabel(driver, addNewWorkflowTitle, "Add New Workflow");

				isClickable(driver, addNewWorkflowTitle, "Folder field", true);

				verifyIndividualLabel(driver, workflowNameFieldLabel, fieldWorkflowName);

				isEditable(driver, workflowNameFieldInput, "Workflow Name field");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				String defName = getValue(driver, workflowNameFieldInput);

				if(!defName.isEmpty()) {

					BaseSuite.reportLog("Default workflow name is "+defName);
				}else {
					BaseSuite.reportFailLog("Default workflow name not visible", "validateAddNewWorkflowSideBar");
				}

				verifyIndividualLabel(driver, chooseTemplateLabel, "Choose Template");

				isClickable(driver, chooseTemplateButton, "Custom Template", true);

				verifyVisibilityOfButtons(driver, addNewWorkflowCancelButton, cancelButtonContent, true);

				verifyVisibilityOfButtons(driver, addNewWorkflowCrossButton, discardContent, true);

			}else {
				BaseSuite.reportFailLog("Add new workflow title not visible ", "validateAddNewWorkflowSideBar");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddNewWorkflowSideBar ");

		}

		return flag;
	}

	//validate workflow listing page UI buttons
	public void validateWorkflowListingPageButtons(boolean newWorkflow, boolean refresh, boolean moreOption) {

		validateButtons(driver, workflowListingButtonsCount, 3);

		verifyVisibilityOfButtons(driver, newWorkflowButton, "New Workflow", newWorkflow);
		verifyVisibilityOfButtons(driver, refreshWorkflowButton, refreshContent, refresh);
		verifyVisibilityOfButtons(driver, moreOptionButton, "More Option", moreOption);


	}

	//validate workflow listing page UI 
	public boolean validateWorkflowListingPageUI(boolean ui) {
		boolean flag =true;
		String methodName="validateWorkflowListingPageUI";
		HomePage hp=new HomePage(driver);
		try {

			clickOnButton(driver, refreshWorkflowButton, refreshContent, true);
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!ui) {return true;}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenModuleAndDataTestingSubModules();

			BaseSuite.reportLog("-----------  Verifying Workflow listing page ---------");

			verifyIndividualLabel(driver, workflowTitle, workflowsTitle);

			verifySearchField(driver, workflowSearchField, workflowSearchPlaceholder, workflowSearchPlaceholder);

			validateWorkflowListingPageButtons(true, true, false);

			BaseSuite.reportLog("Validate workflow listing page columns");

			List<WebElement> columns = getElements(driver, workflowListingPageColumns);

			for(int i=0;i<columns.size();i++) {

				String column = columns.get(i).getAttribute(attributeTextContent);

				if(!column.isEmpty() && !column.contains("ID")) {

					BaseSuite.reportLog(column+" Column is visible");

				}
			}

			validateElement(driver, workflowAppliedFilter, "Workflow 1 Filter(s) Applied", "filter");

			if(isDisplayed(driver, workflowFolderExpand)) {

				displayAndClick(driver, workflowFolderExpand);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			verifyIndividualLabel(driver, workflowFolderSearchTitle, labelFolderSearch);

			verifyVisibilityOfButtons(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);

			verifySearchField(driver, workflowFolderSearchField, labelFolderSearch, workflowFolderSearchPlaceholder);

			verifyVisibilityOfButtons(driver, workflowFolderSearchNewFolderButton, "New Folder", true);

			verifyIndividualLabel(driver, workflowAdvancedSearchTitle, advanceSearchContent);

			getPaginationDetails(driver,workflowListingPageMsg,workflowListingPagearrow,workflowListingPageNoRecordDisplay,workflowContent+listingContent);

			BaseSuite.validationReportLog("-------------------- Workflow listing page validated successfully -------------");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+methodName+" ");

			flag=false;
		}	
		return flag;
	}

	//search folder functionality on folder search side-bar
	public boolean searchFolderOnWorkflowListingPage(boolean flag,String folderName) {

		return searchFunctionalityMethod(driver, flag, workflowFolderSearchField, workflowFolderSearchButton, labelFolderSearch, workflowFolderSearchPlaceholder, folderName);

	}

	public boolean createFolderIfNotCreated(String folderNAme) {
		boolean flag = true;

		try {

			BaseSuite.reportLog("Reattempting folder creation...");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			wait.until(ExpectedConditions.elementToBeClickable(workflowFolderSearchNewFolderButton)).click();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			sendKeys(driver, enterNewFolderName, folderNAme);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, folderCreatedToastMsg, folderContent+" "+createdContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createFolderIfNotCreated ");
			flag=false;
		}
		return flag;

	}

	public boolean createNewFolderOrSelectExistingOnFolderSearchSideBar(String folderName) {
		boolean isFolderNew = true;

		try {
			isDisplayedInLoop(driver, 5, folderList);
			List<WebElement> folders = driver.findElements(folderList);

			for (WebElement folder : folders) {
				if (folder.getText().equals(folderName)) {
					// Folder already exists
					BaseSuite.validationReportLog("Folder Already exist : " + folderName);
					isFolderNew = false;
					break;
				}
			}

			if (isFolderNew) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				displayAndClick(driver, workflowFolderSearchNewFolderButton);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Clicked on New Folder button");

				if (folderName.contains(executorContent) || folderName.contains(readerContent) || isDisplayed(driver, toastMsg)) {
					return captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Privilege ");
				}

				BaseSuite.reportLog("Entering folder name: " + folderName);

				sendKeys(driver, enterNewFolderName, folderName);

				BaseSuite.validationReportLog("Entered folder name: " + folderName);

				waitForExecution(1000);

				driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if (isDisplayed(driver, toastMsg)) {
					isFolderNew = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, folderCreatedToastMsg, folderContent + " " + createdContent);
				} else {
					isFolderNew = createFolderIfNotCreated(folderName);
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			} else {
				isFolderNew = true; 
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " createNewFolderOnFolderSearchSideBar :: " + e.toString());
			isFolderNew = false;
		}

		return isFolderNew;
	}

	// Create new folder or select existing from folder search side-bar
	public boolean createNewFolderOrSelectExistingOnFolderSearchSideBar(String folderName, String icedqUser) {
		boolean result = true;

		try {
			isDisplayedInLoop(driver, 5, folderList);
			List<WebElement> folderElements = driver.findElements(folderList);

			for (WebElement folder : folderElements) {
				if (folder.getText().equals(folderName)) {

					BaseSuite.validationReportLog("Existing folder found: " + folderName);

					result = true;
					return result;
				}
			}

			// Folder does not exist, create a new one
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			BaseSuite.reportLog("Clicking on New Folder button");

			displayAndClick(driver, workflowFolderSearchNewFolderButton);

			BaseSuite.validationReportLog("Clicked on New Folder button");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (icedqUser.contains(executorContent) || icedqUser.contains(readerContent) || isDisplayed(driver, toastMsg)) {
				return captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Privilege");
			}

			BaseSuite.reportLog("Entering folder name: " + folderName);
			sendKeys(driver, enterNewFolderName, folderName);
			BaseSuite.validationReportLog("Entered folder name: " + folderName);

			waitForExecution(1000);
			driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);
			BaseSuite.validationReportLog("Pressed ENTER to create folder");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (isDisplayed(driver, toastMsg)) {
				result = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, folderCreatedToastMsg, folderContent + " " + createdContent);
			} else {
				result = createFolderIfNotCreated(folderName);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " createNewFolderOnFolderSearchSideBar :: " + e.toString());
			result = false;
		}

		return result;
	}

	//click on folder name on folder search side-bar
	public boolean clickOnFolderNameCheckbox(boolean flag,String name, boolean state) {
		String chkstatus =null;

		try {
			if(flag) {
				isDisplayedInLoop(driver, 5, returnElement(workflowFolderSearchFolderNameCheckbox, dynamicName, name));

				if(isDisplayed(driver, returnElement(workflowFolderSearchFolderNameCheckbox, dynamicName, name))) {

					chkstatus = getAttribute(driver, returnElement(workflowFolderSearchFolderNameCheckbox, dynamicName, name), attributeClass);

					if(!chkstatus.contains(attrcheck) && state) {

						clickOnButton(driver, returnElement(workflowFolderSearchFolderNameCheckbox, dynamicName, name), name, true);

					}else if(chkstatus.contains(attrcheck)) {

						BaseSuite.reportLog(" Folder name "+name+" checkbox already checked");
					}

					chkstatus = getAttribute(driver, returnElement(workflowFolderSearchFolderNameCheckbox, dynamicName, name), attributeClass);

					if(state && chkstatus.contains(attrcheck)) {

						BaseSuite.reportLog(" Folder name "+name+" checkbox checked");
					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Folder name checkbox not visible ", "clickOnFolderNameCheckbox");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error occurs  while clickOnFolderNameCheckbox ");
			flag=false;

		}
		return flag;	


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

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							displayAndClick(driver, returnElement(validScrollFolder, dynamicName, folder));

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							displayAndClick(driver,returnElement(folderselectBtn, dynamicName, folder) );

							BaseSuite.validationReportLog(folder+" Folder clicked successfully");						

							BaseSuite.validationReportLog(folder+" Folder selected ");

							break;
						}
					}

				}

			} else {
				BaseSuite.reportFailLog(folderName + " is fail to display", "selectpathRule");
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" createOrSelectExistingFolder ");

		}

	}

	//Enter details to add new workflow pane
	public boolean enterDetailsToAddNewWorkflowPane(boolean flag,String folderName, String workflowName, String templateName) {

		ParametersServicePage ps = new ParametersServicePage(driver);
		try {

			if(flag) {

				validateAddNewWorkflowSideBar();

				ps.searchAndSelectFolderOnAddNewPane(folderName, "workflow");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				String rulenamecapture =getAttribute(driver, workflowNameFieldInput, attributeValue);

				BaseSuite.reportLog("Default "+rulenamecapture + " Workflow Name is visible ");

				flag = enterValueToTextField(driver, workflowNameFieldInput, fieldWorkflowName, workflowName);

				if(flag) {

					String wkflName = getAttribute(driver, workflowNameFieldInput, attributeValue);

					clickOnButton(driver, chooseTemplateButton, customContent, true);log.info(templateName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					checkUnexpectedToast();

					isDisplayedInLoop(driver, 1, returnElement(workflowNameTitle, dynamicName, wkflName));

					if(isDisplayed(driver, returnElement(workflowNameTitle, dynamicName, wkflName))) {

						BaseSuite.reportLog("Workflow name title is visible as :: "+wkflName);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}
				}
			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" enterDetailsToAddNewWorkflowPane ");
			flag=false;

		}
		return flag;
	}

	//validate and search folder on workflow details page
	public boolean validateAndSearchFolderOnWorkflowDetailsPage(boolean flag,String folderName) {

		return searchFunctionalityMethod(driver, flag, workflowDetailsfolderSearchBar, workflowDetailsfolderSearchbtn, labelFolderSearch, workflowFolderSearchPlaceholder, folderName);

	}

	//click on folder name check-box on workflow details page
	public boolean clickOnFolderNameCheckboxOnWorkflowDetailsPage(boolean flag,String folderName, boolean state) {
		String chkstatus =null;
		if(flag) {
			try {isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 5, returnElement(workflowDetailsFolderNameCheckbox, dynamicName, folderName));

			if(isDisplayed(driver, returnElement(workflowDetailsFolderNameCheckbox, dynamicName, folderName))) {

				chkstatus = getAttribute(driver, returnElement(workflowDetailsFolderNameCheckbox, dynamicName, folderName), attributeClass);

				if(!chkstatus.contains(attrcheck) && state) {

					clickOnButton(driver, returnElement(workflowDetailsFolderNameCheckbox, dynamicName, folderName), folderName, true);

				}else if(chkstatus.contains(attrcheck)) {

					BaseSuite.reportLog("Folder name "+folderName+" checkbox already checked");
				}

				chkstatus = getAttribute(driver, returnElement(workflowDetailsFolderNameCheckbox, dynamicName, folderName), attributeClass);

				if(state && chkstatus.contains(attrcheck)) {

					BaseSuite.reportLog("Folder name "+folderName+" checkbox checked");
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog(folderName+" Folder name checkbox not visible ", "clickOnFolderNameCheckboxOnWorkflowDetailsPage");
				flag=false;
			}
			} catch (Exception e) {
				BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnFolderNameCheckboxOnWorkflowDetailsPage ");
				flag=false;

			}
		}
		return flag;	
	}

	//validate and search rule on workflow details page 
	public boolean validateAndSearchRuleOnWorkflowDetailsPage(boolean flag, String ruleName) {

		return searchFunctionalityMethod(driver, flag, workflowDetailsRuleSearchbar, workflowDetailsRuleSearchbtn, "Rule name search ", rulesSearchBarPlaceholder, ruleName);

	}

	//click on rule name check-box on workflow details page
	public boolean clickOnRuleNameCheckboxOnWorkflowDetailsPage(boolean flag, String ruleName, String folderName) {

		String methodName = "clickOnRuleNameCheckboxOnWorkflowDetailsPage";
		if(!flag) { return true; }
		try {

			By locator = returnTwoElements(workflowDetailsRuleCheckbox, dynamicName, ruleName, dynamicFolderName, folderName);

			isDisplayedInLoop(driver, 0, locator);

			if(isDisplayed(driver, locator)) {

				javascript(driver, scrollToElementArg, locator);

				selectcheckbox(driver, locator, ruleName);

			}else {
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error occurs  while "+methodName+" ");
			flag=false;
		}

		return flag;
	}

	public boolean clickOnRuleCheckboxOnWorkflowDetailsPage(String ruleName, String folderName) {

		boolean flag=true;
		boolean nextpageFlag=true;
		By locator=null;
		int pn=0;
		boolean isSelected=false;
		try {
			
			if(folderName.startsWith("/")) { folderName = folderName.substring(1);}
			
			locator = returnTwoElements(workflowDetailsRuleCheckbox, dynamicName, ruleName, dynamicFolderName, folderName);

			do {

				BaseSuite.reportLog("searching rule name : "+ruleName+" on page number :"+(pn+1));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("Rule name : "+ruleName+" found on page number :"+(pn+1));

					flag=selectcheckbox(driver, locator, ruleName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isSelected=true;
					checkUnexpectedToast();

					break;
				}
				if(isDisplayed(driver, workflowDetailsRulesNextPageArrow)) {

					String status = getAttribute(driver, workflowDetailsRulesNextPageArrow, attributeClass);

					if (!status.contains("disable") && !isDisplayed(driver, locator)) {

						clickOnButton(driver, workflowDetailsRulesNextPageArrow, nextPageArrowContent, true);
						pn++;
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					} else {
						BaseSuite.reportLog("Page arrow :: next page is disabled");
						nextpageFlag=false;
						flag=false;
					}

				}

			}while(nextpageFlag);

			if(!isSelected) {
				BaseSuite.reportFailLog(ruleName+" Rule checkbox not selected", "clickOnRuleCheckboxOnWorkflowDetailsPage");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error occurs  while clickOnRuleCheckboxOnWorkflowDetailsPage ");
			flag=false;
		}

		return flag;
	}

	//click on add rule button 
	public boolean clickOnAddRulesButtonOnWorkflowDetailsPage(boolean state) {
		if(state) {
			try {

				state=clickOnButton(driver, worfklowDetailsRuleAddButton, "Add", state);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(isDisplayed(driver, toastMsg)) {
					state=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "", "UnExcepted toast message");
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			} catch (Exception e) {
				BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnAddRulesButtonOnWorkflowDetailsPage ");
				state=false;
			}
		}else {
			state=true;
		}
		return state;
	}

	//click on workflow save button as per workflow state
	public boolean clickOnWorkflowSaveOption(boolean flag, String saveOption, String expectedToast,String icedqUser) {
		boolean tag=true;
		try {
			if(flag) {

				if(saveOption.toLowerCase().trim().equalsIgnoreCase(publishContent)) {

					flag=clickOnButton(driver, workflowDetailsPublishButton, workflowPublish, true);
				}
				else if(saveOption.toLowerCase().trim().equalsIgnoreCase(validateContent)) {

					clickOnButton(driver, workflowDetailsPublishDropDown, saveOptionContent, true);

					javascript(driver, jscriptToMouseHover, workflowDetailsPublishDropDown);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					javascript(driver, jscriptToClick, workflowDetailsValidateButton);

				}else if(saveOption.toLowerCase().trim().equalsIgnoreCase(draftContent)) {

					clickOnButton(driver, workflowDetailsPublishDropDown, saveOptionContent, true);

					javascript(driver, jscriptToMouseHover, workflowDetailsPublishDropDown);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);				

					javascript(driver, jscriptToClick, workflowDetailsDraftButton);

				}

				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Workflow Save");
					tag=false;
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(!expectedToast.isEmpty() && tag) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Workflow Save ");
				}
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validatestatusofWorkflow(saveOption);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);				
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				validateButtonsForWorkflowDetails(true,saveOption,icedqUser);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowSaveOption ");

			flag=false;
		}

		return flag;

	}

	public boolean validatestatusofWorkflow(String exStatus) {
		boolean flag1 =true;
		try {
			BaseSuite.reportLog("verifying state of workflow ");

			String acStatus = getAttribute(driver, workflowDetailsCurrentStatus, attributeTitle);

			if(exStatus.toLowerCase().contains(validateContent.toLowerCase())) {
				exStatus=exStatus+"d";
			}else if(exStatus.toLowerCase().contains(publishContent.toLowerCase())){
				exStatus=exStatus+"ed";
			}

			flag1=stringContainsOutput(acStatus, exStatus, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validatestatusofWorkflow ");

			flag1=false;
		}

		return flag1;

	}

	//click on workflow on bread-crumbs
	public boolean clickOnWorkflowsLinkOnWorkflowDetailsPage() {

		boolean flag =true;

		try {

			BaseSuite.reportLog("Verifying workflows breadcrumbs link");

			verifyVisibilityOfButtons(driver, workflowBreadcrumbHomeLink, homeContent, flag);

			verifyVisibilityOfButtons(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, flag);

			flag =clickOnButton(driver, workflowBreadcrumbWorkflowsLink, workflowContent, true);

			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {
				clickOnButton(driver, discardButtons, " Discard ", true);
			}

			isDisplayedInLoop(driver, 4, workflowTitle);
			String str = getValue(driver, workflowTitle);

			BaseSuite.reportLog("Expected Title : Workflows");
			BaseSuite.reportLog("Actual Title : "+str);

			if(str.equalsIgnoreCase(workflowsTitle)) {
				BaseSuite.validationReportLog("Expected Title and Actual Title matched  "+ConstantProperty.SUCCESSSTRING+"");
			}else {
				BaseSuite.reportFailLog("Expected Title and Actual Title not matched ", "clickOnWorkflowsLinkOnWorkflowDetailsPage");
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowsLinkOnWorkflowDetailsPage ");
			flag=false;
		}

		return flag;
	}

	//validate and enter workflow overview details
	public boolean clickonWorkflowOverviewAndEnterDetails(boolean flag,String workflowName,String workflowCode,String workflowDescription) {

		String methodName="clickonWorkflowOverviewAndEnterDetails";
		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 0, workflowDetailsOverviewTab);

				if(isDisplayed(driver, workflowDetailsOverviewTab)) {

					BaseSuite.reportLog("Workflow Overview tab is visible");

					BaseSuite.reportLog("Clicking on Workflow Overview tab");

					javascript(driver, scrollToElementArg, workflowDetailsOverviewTab);

					displayAndClick(driver, workflowDetailsOverviewTab);

					BaseSuite.reportLog("Clicked on Workflow Overview tab");

					if(isDisplayed(driver, workflowDetailsWorkflowNameLabel)) {

						BaseSuite.validationReportLog("Workflow overview tab fields visible ");

						validatAndeEnterValueToTextField(driver,workflowDetailsWorkflowNameLabel, workflowDetailsWorkflowNameField,workflowDetailsWorkflowNameValidation, fieldWorkflowName,"", workflowName, workflowNameIsEmptyValidationMsg);

						validatAndeEnterValueToTextField(driver,workflowDetailsWorkflowCodeLabel, workflowDetailsWorkflowCodeField,workflowDetailsWorkflowCodeValidation, workflowCodeContent, workflowCodePlaceholder, workflowCode, "");

						validatAndeEnterValueToTextField(driver,workflowDetailsDescriptionLabel, workflowDetailsDescriptionField,workflowDetailsDescriptionValidation, descriptionContent, workflowDescriptionPlaceholder, workflowDescription, "");

					}else {
						BaseSuite.reportFailLog("Workflow overview fields not visible", methodName);
						flag=false;
					}

				}

			}else {
				BaseSuite.reportFailLog("Workflow overview tab not visible", methodName);
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+methodName+" ");
			flag=false;
		}
		return flag;

	}

	//click on rules and data-sets tab 
	public boolean clickonWorkflowRulesAndDatasetTab(boolean flag) {

		String methodName="clickonWorkflowRulesAndDatasetTab";
		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 1, workflowDetailsRuleAndDatasetsTab);

				if(isDisplayed(driver, workflowDetailsRuleAndDatasetsTab)) {

					BaseSuite.reportLog("Rules tab is visible");

					BaseSuite.reportLog("Clicking on Rules tab");

					javascript(driver, scrollToElementArg, workflowDetailsRuleAndDatasetsTab);

					displayAndClick(driver, workflowDetailsRuleAndDatasetsTab);

					BaseSuite.reportLog("Clicked on Rules tab");

					isDisplayedInLoop(driver, 1, rulesDatasetsSearchBar);

					if(isDisplayed(driver,	rulesDatasetsSearchBar )) {

						BaseSuite.validationReportLog("Rules field are visible");

					}else {
						BaseSuite.reportFailLog("Rules fields not visible", methodName);
						flag=false;
					}

				}else {
					BaseSuite.reportFailLog("Rules tab not visible", methodName);
					flag=false;
				}
			}
		} catch (NoSuchElementException e) {
			BaseSuite.reportErrorLog(e, "Error occurs  while "+methodName+" ");
			flag=false;
		}
		return flag;

	}

	public void validateButton(By locator, String label) {

		isDisplayedInLoop(driver, 1, locator);

		if(isDisplayed(driver, locator)) {

			BaseSuite.validationReportLog(label+" button is visible");

		}else {
			BaseSuite.reportFailLog(label+" button not visible", "validateButton");
		}
	}

	//verify select folder UI 
	public boolean validateFolderSearchSideBar(boolean flag) {

		if(flag) {
			String methodName = "validateAndSearchFolderOnWorkflowDetailsPage";
			try {

				isDisplayedInLoop(driver, 3, workflowDetailsfolderLabel);

				verifyIndividualLabel(driver, workflowDetailsfolderLabel, folderContent);

				if(isDisplayed(driver, workflowDetailsfolderSearchBar)) {

					if(isEditable(driver, workflowDetailsfolderSearchBar, searchBoxLabel)) {

						isClickable(driver, workflowDetailsfolderSearchBar, searchBoxLabel, flag);

						verifySearchField(driver, workflowDetailsfolderSearchBar, labelFolderSearch, searchPlaceholder);

						validateButton(workflowDetailsfolderSearchbtn, labelFolderSearch);

						List<WebElement> foldersList =getElements(driver, workflowDetailsFolderList);

						BaseSuite.reportLog("verifying list of folders ");

						for(int i= 0 ;i<foldersList.size();i++) {

							String folder = foldersList.get(i).getAttribute(attributeTextContent);

							BaseSuite.reportLog((i+1)+". "+folder+" folder is visible");

						}

					}else {
						BaseSuite.reportFailLog("Search box not editable", methodName);
						flag=false;
					}

				}else {
					BaseSuite.reportFailLog("Search box not displayed", methodName);
					flag=false;
				}
			} catch (Exception e) {
				BaseSuite.reportErrorLog(e, " Error occurs while "+methodName+" ");
				flag=false;
			}
		}
		return flag;

	}

	//verify rule side bar
	public boolean validateRuleOnWorkflowDetailsPage(boolean flag) {

		String methodName = "validateRuleOnWorkflowDetailsPage";
		if(flag) {
			try {

				isDisplayedInLoop(driver, 3, workflowDetailsfolderLabel);

				verifyIndividualLabel(driver, workflowDetailsRuleTabs, "Rules ");

				if(isDisplayed(driver, workflowDetailsRuleSearchbar)) {

					if(isEditable(driver, workflowDetailsRuleSearchbar, searchBoxLabel)) {

						isClickable(driver, workflowDetailsRuleSearchbar, searchBoxLabel, flag);

						verifySearchField(driver, workflowDetailsRuleSearchbar, "Rule name search", searchPlaceholder);

						isDisplayedInLoop(driver, 2, workflowDetailsRuleSearchbtn);

						if(isDisplayed(driver, workflowDetailsRuleSearchbtn)) {

							BaseSuite.reportLog("Search button is visible");

						}else {
							BaseSuite.reportFailLog("Search button not visible", methodName);
							flag=false;
						}


					}else {
						BaseSuite.reportFailLog("Search box not editable", methodName);
						flag=false;
					}


				}else {
					BaseSuite.reportFailLog("Search box not displayed", methodName);
					flag=false;
				}

				verifyVisibilityOfButtons(driver, worfklowDetailsRuleAddButton, "Add", false);

				verifyVisibilityOfButtons(driver, workflowDetailsNewRuleButton, "New Rule", true);

				getPaginationDetails(driver, workflowDetailsRulesPaginationMsg, workflowDetailsRulesPagearrow,workflowDetailsPageRulesNoRecordDisplay, rulesContent);

			} catch (Exception e) {
				BaseSuite.reportErrorLog(e, " Error occurs while "+methodName+" ");
				flag=false;
			}
		}
		return flag;	
	}

	//validate field 
	public boolean viewAndValidateField(By locator, String label, String expectedValue, boolean state) {

		boolean flag = true;
		String methodName="viewAndValidateField";
		try {
			isDisplayedInLoop(driver, 5, locator);

			javascript(driver, scrollToElementArg, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, locator)) {			

				checkFieldEnabledOrNot(driver, locator, label, state);

				checkExpectedValueWithActual(driver, flag, locator, label,expectedValue,true);

			}else {
				BaseSuite.reportFailLog(label+" "+notVisibleContent+"  ", methodName);
				flag=false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.toString());
			flag=false;
		}

		return flag;
	}

	//validate rule and data set fields 
	public boolean validateRulesAndDatasetsFields() {
		boolean flag = true;
		try {
			verifySearchField(driver, rulesDatasetsSearchBar, searchPlaceholder, rulesSearchBarPlaceholder);

			isDisplayedInLoop(driver, 1, rulesNoRecordsToDisplay);

			if(isDisplayed(driver, rulesNoRecordsToDisplay)) {

				BaseSuite.reportLog("No Records to display message is visible");

				verifyVisibilityOfButtons(driver, rulesDatasetsRunButton, runOptionField, false);

				verifyVisibilityOfButtons(driver, rulesDatasetsSourceConnOverrideButton,sourceConnectionOverrideField, false);

				verifyVisibilityOfButtons(driver, rulesDatasetsTargetConnOverrideButton, targetConnectionOverrideField, false);

				verifyVisibilityOfButtons(driver, rulesDatasetsParameterConnOverrideButton, parameterOverrideField, false);

				verifyVisibilityOfButtons(driver, rulesDatasetsRunButton, deleteField, false);

			}else {

				verifyVisibilityOfButtons(driver, rulesDatasetsRunButton, runOptionField, false);

				verifyVisibilityOfButtons(driver, rulesDatasetsSourceConnOverrideButton, sourceConnectionOverrideField, true);

				verifyVisibilityOfButtons(driver, rulesDatasetsTargetConnOverrideButton,targetConnectionOverrideField, true);

				verifyVisibilityOfButtons(driver, rulesDatasetsParameterConnOverrideButton, parameterOverrideField, true);

				verifyVisibilityOfButtons(driver, rulesDatasetsRunButton, deleteField, false);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRulesAndDatasetsFields ");
			flag=false;
		}
		return flag;
	}

	//search rule/ data set on rules and data-set tab
	public boolean searchRuleOnRulesAndDatasetTab(String ruleName) {

		return searchFunctionalityMethod(driver, true, rulesDatasetsSearchBar, rulesDatasetsSearchButton, "Rule name search", rulesSearchBarPlaceholder, ruleName);

	}

	//click on rule name on rules/data-set tab 
	public boolean clickOnRuleNameCheckboxOnRuleAnddatasetTab(String ruleName, String folderName) {
		boolean flag = true;
		String methodName = "clickOnRuleNameCheckboxOnRuleAnddatasetTab";

		try {

			BaseSuite.reportLog("clicking on rule checkbox ");

			By locator = returnTwoElements(ruleDatasetRuleNameCheckbox, dynamicName, ruleName, dynamicFolderName, folderName);

			isDisplayedInLoop(driver, 3, locator);

			if(isDisplayed(driver, locator)) {

				javascript(driver, scrollToElementArg, locator);

				selectcheckbox(driver, locator, ruleName);

			}else {
				BaseSuite.reportFailLog("Rule checkbox not visible for: " + ruleName, methodName);
				flag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+methodName);
			flag=false;
		}

		return flag;
	}

	// Remove rule from added Rules & Datasets tab
	public boolean removeAddedRuleFromRulesAndDatasetsTab(boolean flag, String ruleName, String folderName) {
		String methodName = "removeAddedRuleFromRulesAndDatasetsTab";

		try {
			if (!flag) return false;

			BaseSuite.reportLog("----- Removing Rule: " + ruleName + " from custom workflow");

			// Step 1: Search the rule
			if (!searchRuleOnRulesAndDatasetTab(ruleName)) {
				BaseSuite.reportFailLog("Rule not found on Rules and Dataset tab: " + ruleName, methodName);
				return false;
			}

			// Step 2: Select the rule
			if (!clickOnRuleNameCheckboxOnRuleAnddatasetTab(ruleName, folderName)) {
				BaseSuite.reportFailLog("Failed to select rule checkbox: " + ruleName, methodName);
				return false;
			}

			// Step 3: Click on delete button
			if (!clickOnButton(driver, rulesDatasetsDeleteButton, deleteField, true)) {
				BaseSuite.reportFailLog("Failed to click delete button for rule: " + ruleName, methodName);
				return false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			// Step 4: Handle delete popup
			if (!validateAndHandleRuleDeletePopupWindow(deleteButtonContent)) {
				BaseSuite.reportFailLog("Delete confirmation popup not handled properly", methodName);
				return false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " " + methodName);
			flag = false;
		}

		return flag;
	}


	//validate and handle rule delete pop up window
	public boolean validateAndHandleRuleDeletePopupWindow(String buttonName) {

		boolean flag = true;

		try {
			isDisplayedInLoop(driver, 3, ruleDatasetDeletePopupTitle);

			if(isDisplayed(driver, ruleDatasetDeletePopupTitle)) {

				BaseSuite.reportLog("Delete Rule popup window is visible");

				String content = getText(driver, ruleDatasetDeletePopupContent);

				flag = stringContainsOutput(content, ruleDeletePopupWindowContent, true);

				if (!flag) {
					BaseSuite.reportFailLog("Unexpected popup content: " + content, "validateAndHandleRuleDeletePopupWindow");

				}

				switch (buttonName.toUpperCase().trim()) {

				case "DELETE":

					flag=clickOnButton(driver, ruleDatasetDeletePopupDeleteButton, deleteButtonContent, true);

					break;

				case "CANCEL":

					flag=clickOnButton(driver, ruleDatasetDeletePopupCancelButton, cancelButtonContent, true);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleRuleDeletePopupWindow ");
			flag=false;
		}
		return flag;
	}

	//validate and handle delete workflow pop up window
	public boolean validateAndHandleDeleteWorkflowPopupWindow(String buttonName) {
		boolean flag = true;
		String methodName = "validateAndHandleDeleteWorkflowPopupWindow";
		try {
			isDisplayedInLoop(driver, 3, deleteWorkflowPopupTitle);

			// Wait for popup title
			if (!isDisplayed(driver, deleteWorkflowPopupTitle)) {
				BaseSuite.reportFailLog("Delete Workflow popup window not displayed", methodName);
				return false;
			}

			BaseSuite.reportLog("Delete Rule/Dataset popup window is visible");

			String content = getText(driver, deleteWorkflowPopupContent);

			flag = stringContainsOutput(content, deleteWorkflowPopupWindowContent, true);

			if (!flag) {
				BaseSuite.reportFailLog("Popup content mismatch: " + content, methodName);
				return false;
			}

			verifyVisibilityOfButtons(driver, deleteWorkflowPopupDeleteButton, deleteButtonContent, true);
			verifyVisibilityOfButtons(driver, deleteWorkflowPopupCancelButton, cancelButtonContent, true);
			// Handle button click
			switch (buttonName.trim().toLowerCase()+1) {
			case "delete1":
				flag = clickOnButton(driver, deleteWorkflowPopupDeleteButton, deleteButtonContent, true);
				break;

			case "cancel1":
				flag = clickOnButton(driver, deleteWorkflowPopupCancelButton, cancelButtonContent, true);
				break;

			default:
				BaseSuite.reportFailLog("Invalid button name: " + buttonName, methodName);
				flag = false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleDeleteWorkflowPopupWindow ");
			flag=false;
		}
		return flag;
	}

	//delete workflow method
	public boolean deleteWorkflowOnWorkflowDetailsPage(String expectedToastMsg) {
		boolean flag = true;

		try {

			flag=clickOnButton(driver, workflowDetailsDeleteButton, deleteField, true);

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMsg, "Workflow Deleted ");

			}else {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {
					validateAndHandleDeleteWorkflowPopupWindow(deleteButtonContent);
				}

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMsg, "Workflow Deleted");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(isDisplayed(driver, deleteWorkflowPopupCancelButton) && expectedToastMsg.contains(WORKFLOWPRIVILEGEFORBIDDENMESSAGE)) {

					flag=clickOnButton(driver, deleteWorkflowPopupCancelButton, cancelButtonContent, true);

				}else if(isDisplayed(driver, deleteWorkflowPopupCancelButton))
				{
					BaseSuite.reportFailLog("Delete popup window is visible","deleteWorkflowOnWorkflowDetailsPage");

					flag=clickOnButton(driver, deleteWorkflowPopupCancelButton, cancelButtonContent, true);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteWorkflowOnWorkflowDetailsPage ");
			flag=false;
		}

		return flag;
	}	


	public String refreshInloop(String state, int count) {

		try {
			for(int i =1;i<count;i++) {

				displayAndClick(driver, workflowDetailsRecentRunRefreshButton);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);	

				if (i>5 && isDisplayed(driver, workflowDetailsRecentRunStatus)) {

					state = getAttribute(driver, workflowDetailsRecentRunStatus,
							attributeTextContent);

					state= checkNullValue(state);

					if ((!state.toLowerCase().contains(runningStatus))){

						break;
					}else if(state.isEmpty() && i==1) {
						clickOnButton(driver, workflowDetailsRunButton, runContent, true);
					}

				}
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);	
				isDisplayedInLoop(driver, 1, dataTSpinner);
				if(isDisplayed(driver, dataTSpinner)) {
					BaseSuite.reportLog("Failed due to Spinner Didn't stop/invisible ");
					driver.navigate().refresh();
					BaseSuite.reportLog("Hence Refreshing the current webpage");
					driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" refreshInloop ");

		}
		return state;
	}

	public String clickOnRefreshButtonOnRecentRuns(int count) {
		String state = "";

		try {
			isDisplayedInLoop(driver, 2, workflowDetailsRecentRunRefreshButton);

			javascript(driver, scrollToElementArg, workflowDetailsRecentRunRefreshButton);

			if(isDisplayed(driver, workflowDetailsRecentRunRefreshButton)) {

				BaseSuite.reportLog("Clicking on refresh button");

				if(count==1) {

					displayAndClick(driver, workflowDetailsRecentRunRefreshButton);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}else {

					refreshInloop(state, count);
				}

				if(isDisplayed(driver, workflowDetailsRecentRunStatus)) {
					state = getAttribute(driver, workflowDetailsRecentRunStatus,
							attributeTextContent);
				}else {
					state ="";
				}


				if (!state.toLowerCase().contains(runningStatus)) {

					BaseSuite.validationReportLog("Workflow run status is :: "+state);

				}else if(state.isEmpty() && count>1){

					BaseSuite.reportFailLog("Workflow Execute status is not visible ", "clickOnRefreshButtonOnRecentRuns");

				}else {

					BaseSuite.validationReportLog("Workflow run status is :: "+state +" Takes time more than default time kindly check manually ");

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnRefreshButtonOnRecentRuns ");

		}

		return state;
	}

	public void checkUnexpectedToast() {
		if(isDisplayed(driver, toastMsg)) {
			captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "",unexpectedContent);
		}
	}

	//click on run button and return status
	public String clickOnRunButtonOnWorkflowAndGetStatus(int count, String expectedToastMsg) {

		boolean flag = true;
		String state = "";
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, workflowDetailsRunButton);

			flag=clickOnButton(driver, workflowDetailsRunButton, runContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				if(isDisplayed(driver, toastMsg)) {

					captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMsg, workflowRunContent);

				}else {

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);	

					state=clickOnRefreshButtonOnRecentRuns(count);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(state.isEmpty()) {

						clickOnButton(driver, workflowDetailsRunButton, runContent, true);

						state=clickOnRefreshButtonOnRecentRuns(count);
					}
				}	
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnRunButtonOnWorkflowAndGetStatus ");


		}

		return state;

	}

	public String getValueOfField(By locator, String label) {
		String value = "";

		try {
			// Wait until element is displayed
			isDisplayedInLoop(driver, 2, locator);

			if (isDisplayed(driver, locator)) {
				javascript(driver, scrollToElementArg, locator);
				BaseSuite.reportLog(label + visibleContent);

				// Get text content or any attribute
				value = getAttribute(driver, locator, attributeTextContent);
				value = checkNullValue(value);

				if (!value.isEmpty()) {
					BaseSuite.validationReportLog(label + " is : " + value);
				} else {
					BaseSuite.reportLog(label + " is empty or null.");
				}
			} else {
				BaseSuite.reportFailLog(label + " " + notVisibleContent, "getValueOfField");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error in getValueOfField() for " + label + " - " + e.getMessage());
		}

		return value;
	}

	//validate workflow recent run info
	public String validateWorkflowRecentRunInfo() {
		String instanceId=null;
		String workflow ="Workflow recent run";
		try {
			instanceId=getValueOfField(workflowDetailsRecentRunInstanceId, workflow+instanceIdContent);

			getValueOfField(workflowDetailsRecentRunInstanceType, workflow+" Instance Type");

			getValueOfField(workflowDetailsRecentRunExitCode, workflow+" Exit Code");

			getValueOfField(workflowDetailsRecentRunElapsedTime, workflow+" Elapsed Time");

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateWorkflowRecentRunInfo ");

		}
		return instanceId;
	}

	public boolean executionDeletailsLogOfWorkflow(boolean flag) {

		try {
			if(flag && isDisplayed(driver, workflowExecutionDetailsLogs)) {

				String logs = getAttribute(driver, workflowExecutionDetailsLogs, attributeValue);

				String [] exlog = logs.split("\n");

				StringBuilder codeBlock = new StringBuilder();

				for (String line : exlog) {
					codeBlock.append(line).append("\n");
				}

				BaseSuite.reportLog("------------------------Workflow Execution Logs ------------------------");
				BaseSuite.reportCodeLog(codeBlock.toString()); // Logs the full block as code
				BaseSuite.reportLog("-----------------------------------------------------------------");


				verifyVisibilityOfButtons(driver, workflowExecutionDetailsDownloadBtn, "Download", true);

				verifyVisibilityOfButtons(driver, workflowExecutionDetailsCopyBtn, copyContent, true);

				flag=clickOnButton(driver, workflowExecutionDetailsCancelBtn, cancelButtonContent, true);


			}else {
				BaseSuite.reportFailLog("Workflow execution details not visible", "executionDeletailsLogOfWorkflow");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" executionDeletailsLogOfWorkflow ");
			flag=false;
		}
		return flag;
	}

	//click on workflow execution details button
	public boolean clickOnExecutionDetails() {
		boolean flag=true;
		try {

			BaseSuite.reportLog("------------- Workflow execution logs -------------");

			flag=clickOnButton(driver, workflowDetailsRecentRunExecutionDetailsBtn, "Execution Details", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				isDisplayedInLoop(driver, 3, workflowExecutionDetailsTitle);
				if(isDisplayed(driver, workflowExecutionDetailsTitle)) {

					verifyIndividualLabel(driver, workflowExecutionDetailsTitle, "Execution Details title");

					flag=executionDeletailsLogOfWorkflow(flag);

				}else {
					BaseSuite.reportFailLog("Workflow execution details title not visible", "clickOnExecutionDetails");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnExecutionDetails ");

			flag=false;
		}

		return flag;
	}

	//check check-box state of field and select 
	public void checkCheckboxOfField(By locator, String flagLabel, String acFlagState, String flagState) {

		if(acFlagState.contains(attrcheck) && flagState.contains(terminateString) ) {

			BaseSuite.reportLog(flagLabel+" is checked");

			displayAndClick(driver, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			acFlagState = getAttribute(driver, locator, attributeClass);
			if(!acFlagState.contains(attrcheck)) {

				BaseSuite.validationReportLog(flagLabel+" is unchecked successfully");
			}

		}else if(!acFlagState.contains(attrcheck) && flagState.contains(continueString) ) {
			BaseSuite.reportLog(flagLabel+" is unchecked");

			displayAndClick(driver, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			acFlagState = getAttribute(driver, locator, attributeClass);

			if(!acFlagState.contains(attrcheck)) {
				BaseSuite.validationReportLog(flagLabel+" is checked successfully");
			}
		}else if(!acFlagState.contains(attrcheck) && flagState.equalsIgnoreCase(terminateString)) {

			BaseSuite.validationReportLog(flagLabel+" is already unchecked ");

		}else if(acFlagState.contains(attrcheck) && flagState.equalsIgnoreCase(continueString) ) {

			BaseSuite.validationReportLog(flagLabel+" is already checked ");
		}

	}

	//select rule flag state 
	public boolean selectRuleFlags(boolean flag,String ruleName, String flagLocator, String flagLabel, String flagState,String expectedToast) {

		String methodName = "selectRuleFlags";
		try {
			if(flag) {
				BaseSuite.reportLog(checkingContent+flagLabel+flagContent);

				By locator = returnElement(flagLocator, dynamicName, ruleName);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.validationReportLog(flagLabel+flagContent+visibleContent);

					String acFlagState = getAttribute(driver, locator, attributeClass);

					checkCheckboxOfField(locator, flagLabel, acFlagState, flagState);

				}else {

					BaseSuite.reportFailLog(flagLabel+" "+notVisibleContent+"  ", methodName);
					flag=false;
				}
				isDisplayedInLoop(driver, 0, toastMsg);
				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "SFE Unchecked");

				}
			}
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectRuleFlags ");

			flag=false;
		}

		return flag;
	}

	//check check-box state of flag field and select 
	public void checkCheckboxOfFlag(By locator, String flagLabel, String acFlagState, String flagState) {

		try {
			if(acFlagState.contains(attrcheck) && flagState.equalsIgnoreCase(falseContent) ) {

				BaseSuite.reportLog(flagLabel+" checkbox is checked");

				displayAndClick(driver, locator);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				acFlagState = getAttribute(driver, locator, attributeClass);
				if(!acFlagState.contains(attrcheck)) {

					BaseSuite.validationReportLog(flagLabel+" checkbox is unchecked successfully");
				}

			}else if(!acFlagState.contains(attrcheck) && flagState.equalsIgnoreCase(trueContent) ) {
				BaseSuite.reportLog(flagLabel+" checkbox is unchecked ");

				displayAndClick(driver, locator);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				acFlagState = getAttribute(driver, locator, attributeClass);

				if(acFlagState.contains(attrcheck)) {
					BaseSuite.validationReportLog(flagLabel+" checkbox is checked successfully");
				}else {
					BaseSuite.reportFailLog(flagLabel+" checkbox is not checked","checkCheckboxOfFlag");
				}
			}else if(!acFlagState.contains(attrcheck) && flagState.equalsIgnoreCase(falseContent)) {

				BaseSuite.validationReportLog(flagLabel+" checkbox is already unchecked ");

			}else if(acFlagState.contains(attrcheck) && flagState.equalsIgnoreCase(trueContent) ) {

				BaseSuite.validationReportLog(flagLabel+" checkbox is already checked ");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkCheckboxOfFlag ");
		}
	}

	//select rule use and active flag state 
	public boolean selectRuleUseAndActiveFlags(boolean flag, String ruleName, String flagLocator, String flagLabel, String flagState, String expectedToast) {

		String methodName = "selectRuleFlags";
		try {
			if(flag) {
				BaseSuite.reportLog(checkingContent+flagLabel+" flag  ");

				By locator = returnElement(flagLocator, dynamicName, ruleName);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.validationReportLog(flagLabel+flagContent+visibleContent);

					String acFlagState = getAttribute(driver, locator, attributeClass);

					checkCheckboxOfFlag(locator, flagLabel, acFlagState, flagState);

				}else {

					BaseSuite.reportFailLog(flagLabel+" "+notVisibleContent, methodName);
					flag=false;
				}
				if(isDisplayed(driver, toastMsg) && flagState.equalsIgnoreCase(falseContent)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, flagLabel+" Unchecked");

				}
			}
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectRuleFlags ");

			flag=false;
		}

		return flag;

	}

	public boolean clickOnChildFolderCheckbox(String folderPath, String ruleName) {
		boolean flag=true;

		try {
			folderPath = folderPath.substring(1);

			String [] folder = folderPath.split("/");

			String childFolder = folder[1];

			validateAndSearchFolderOnWorkflowDetailsPage(flag, childFolder);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnFolderNameCheckboxOnWorkflowDetailsPage(flag,folderPath, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateAndSearchRuleOnWorkflowDetailsPage(flag,ruleName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnRuleCheckboxOnWorkflowDetailsPage(ruleName,folderPath);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" addRulesToWorkflowDetails ");

			flag=false;
		}

		return flag;
	}

	//add rules to workflow 
	public boolean addRulesToWorkflowDetails(boolean flag, List<String> ruleList, String workflowJsonEntity){
		int x=0;
		try {
			if(flag) {

				clickOnWorkflowSidebarPanelOpenOrClose(flag);

				clickOnButton(driver, workflowDetailsRuleTabRefreshIcon, "Rules Tab Refresh", flag);

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog(addedRuleLog+ruleParam.getRuleName()+workflowLog);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					if(!ruleParam.getRuleFolderName().contains("/")) {

						flag=validateAndSearchFolderOnWorkflowDetailsPage(flag,ruleParam.getRuleFolderName());

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=clickOnFolderNameCheckboxOnWorkflowDetailsPage(flag,ruleParam.getRuleFolderName(), true);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateAndSearchRuleOnWorkflowDetailsPage(flag,ruleParam.getRuleName());

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=clickOnRuleCheckboxOnWorkflowDetailsPage(ruleParam.getRuleName(),ruleParam.getRuleFolderName());

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}else {

						flag=clickOnChildFolderCheckbox(ruleParam.getRuleFolderName(),ruleParam.getRuleName());
					}
					x++;
				}

				if(x!=0) {
					flag=clickOnAddRulesButtonOnWorkflowDetailsPage(true);
				}else {
					flag=clickOnAddRulesButtonOnWorkflowDetailsPage(false);
				}
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 1, workfloeDetailsRulesTab);

				displayAndClick(driver, workfloeDetailsRulesTab);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(isDisplayed(driver, workflowDetailsRuleMasterCheckbox)) {
					displayAndClick(driver, workflowDetailsRuleMasterCheckbox);
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" addRulesToWorkflowDetails ");

			flag=false;
		}
		return flag;
	}

	public DataTestingParameters setOverrideParametersForRuleUsingExcel(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String readColumnName="";
		try {
			if(workflowExecutionDynamicDataFlag) {

				readColumnName=getRuleFolderColumnName(workflowFolderNameForSanity);

				param.setSourceConnection(xl.readUsingColNameAndCellContains(fileName, wkflsheetName, keyColumn, keyRuleSourceConnection, readColumnName));
				param.setTargetConnection(xl.readUsingColNameAndCellContains(fileName, wkflsheetName, keyColumn, keyRuleTargetConnection, readColumnName));
				param.setRuleParameterName(xl.readUsingColNameAndCellContains(fileName, wkflsheetName, keyColumn, keyRuleParameter, readColumnName));

				param.setOverrideSourceConnection(xl.readUsingColNameAndCellContains(fileName, wkflsheetName, keyColumn, keyRuleOverrideSource, readColumnName));
				param.setOverrideTargetConnection(xl.readUsingColNameAndCellContains(fileName, wkflsheetName, keyColumn, keyRuleOverridetarget, readColumnName));
				param.setOverrideParameter(xl.readUsingColNameAndCellContains(fileName, wkflsheetName, keyColumn, keyRuleOverrideParameter, readColumnName));

				sourceConnection=param.getSourceConnection();
				targetConnection=param.getTargetConnection();
				parameter=param.getRuleParameterName();

				overrideSourceConnection=param.getOverrideSourceConnection();
				overrideTargetConnection=param.getOverrideTargetConnection();
				overrideParameter=param.getOverrideParameter();

				overrideChangeSourceConnection=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyChangeOverrideSource,readColumnName);
				overrideChangeTargetConnection=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyChangeOverrideTarget,readColumnName);
				overrideChangeParameter=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH,wkflsheetName, keyColumn, keyChangeOverrideParameter,readColumnName);

				incompleteConnection=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, "IncompleteConnection",readColumnName);
				brokenConnection=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, "BrokenConnection",readColumnName);


			}else if(ConstantProperty.OVERRIDE_SOURCE_CONNECTION.isEmpty()) {	

				param.setOverrideSourceConnection(xl.readUsingColName(fileName, sheetName, rowNumber, sourceColumnName));
				param.setOverrideTargetConnection(xl.readUsingColName(fileName, sheetName, rowNumber, targetColumnName));
				param.setOverrideParameter(xl.readUsingColName(fileName, sheetName, rowNumber, parameterColumnName));

			}

			else {
				param.setOverrideSourceConnection(ConstantProperty.OVERRIDE_SOURCE_CONNECTION);
				param.setOverrideTargetConnection(ConstantProperty.OVERRIDE_TARGET_CONNECTION);
				param.setOverrideParameter(ConstantProperty.OVERRIDE_PARAMETER);
			}
		}  catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowOverrideParameterUsingExcelData "+e.toString());
		}

		return param;
	}

	public boolean validateAndSingleOverrideFunctionality(boolean flag,String workflowJsonEntity ,List<String> ruleList, int i, boolean isOverride) {

		int row;
		String subtype="";
		try {
			List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

			if(isOverride) {
				row=1;
			}else {
				row=3;
			}

			DataTestingParameters ruleOverrideParam=setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, row);

			for(int j=0;j<override.size();j++) {

				subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

				subtype=checkNullValue(subtype);

				if(!subtype.isEmpty()) {

					switch(subtype.trim()+"xyz") {

					case "sourcexyz":
						flag=singleSourceConnectionOverrideUsingConnectionName(flag, ruleList.get(i), ruleOverrideParam.getOverrideSourceConnection(),workflowSingleSourceConnectionOverrideToastMsg);
						break;

					case "targetxyz":
						flag=singleTargetConnectionOverrideUsingConnectionName(flag,ruleList.get(i), ruleOverrideParam.getOverrideTargetConnection(),workflowSingleTargetConnectionOverrideToastMsg);
						break;

					case "rulexyz":
						flag=singleParameterOverride(flag,ruleList.get(i), ruleOverrideParam.getOverrideParameter(), workflowSingleParameterOverrideToastMsg);
						break;

					default:


						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "error occurs while validateAndSingleOverrideFunctionality kindly check ");
		}
		return flag;
	}

	public void validateFolderNameOnRuleDatasetTab(String ruleName, String folderpath) {

		String foldername = "";
		String forwardSlash="/";
		try {
			if(folderpath.startsWith(forwardSlash)) {
				foldername = folderpath.substring(1);
			}else {
				foldername=folderpath;
				folderpath=forwardSlash+folderpath;
			}

			By locator = returnTwoElements(workflowDetailsRuleFolderNameOnRuleTab, dynamicName, ruleName, dynamicFolderName, foldername);	

			if(isDisplayed(driver, locator)) {
				BaseSuite.reportLog("verifying folder path ");
				String path=driver.findElement(locator).getAttribute(attributeTitle);

				stringOutput(path, folderpath, true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateFolderNameOnRuleDatasetTab ");
		}

	}

	public void checkConnectionAndParameterOnAddedRules(Boolean flag, DataTestingParameters ruleParam) {

		try {
			isDisplayedInLoop(driver, 5,returnElement(workflowDetailsAddedRuleType, dynamicName, ruleParam.getRuleName()));

			javascript(driver, scrollToElementArg, returnElement(workflowDetailsAddedRuleType, dynamicName, ruleParam.getRuleName()));

			String ruleType=getAttribute(driver, returnElement(workflowDetailsAddedRuleType, dynamicName, ruleParam.getRuleName()), attributeTitle);

			if(!ruleType.equalsIgnoreCase(scriptContent)) {

				viewAndValidateField(returnElement(worklfowAddedRuleSourceConnLink, dynamicName, ruleParam.getRuleName()), sourceConnectionField, ruleParam.getRuleSourceConnectionName(), true);

				if(ruleType.equalsIgnoreCase(reconContent) || ruleType.equalsIgnoreCase(checksumContent)) {

					checkExpectedValueWithActual(driver, flag, returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleParam.getRuleName()),targetConnectionField, ruleParam.getRuleTargetConnectionName(),true);
				}else {
					checkExpectedValueWithActual(driver, flag, returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleParam.getRuleName()),targetConnectionField, "",true);
				}

				checkExpectedValueWithActual(driver, flag, returnElement(worklfowAddedRuleParameterLink, dynamicName, ruleParam.getRuleName()),parameterField, ruleParam.getRuleParameterName(),true);

			}else {

				viewAndValidateField(returnElement(worklfowAddedRuleSourceConnLink, dynamicName, ruleParam.getRuleName()), sourceConnectionField, "", true);

				checkExpectedValueWithActual(driver,flag, returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleParam.getRuleName()),targetConnectionField, "",true);

				checkExpectedValueWithActual(driver,flag, returnElement(worklfowAddedRuleParameterLink, dynamicName, ruleParam.getRuleName()),parameterField, ruleParam.getRuleParameterName(),false);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkConnectionAndParameterOnAddedRules ");
		}
	}


	//select workflow rules flag
	public boolean selectWorkflowRulesFlag(boolean flag, List<String> ruleList, String workflowJsonEntity,boolean isOverride) {
		ruleSequenceUseFlagList=null;
		rulesConfigurationtable=null;
		try {
			if(!ruleList.isEmpty() && flag) {

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("----------------------- validating added rule : "+ruleParam.getRuleName()+" and configuring features of workflow -----------------------");

					/**	flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());*/

					if(i<(ruleList.size()-1)){
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFEUncheck);	
					}else {
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFELastSequence);	
					}

					checkConnectionAndParameterOnAddedRules(flag, ruleParam);

					validateAndSingleOverrideFunctionality(flag, workflowJsonEntity, ruleList, i,isOverride);

					if(i<(ruleList.size()-1)){

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),"");

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),"");

					}else {

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),workflowToastUseColumnEnabled);

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),workflowToastActiveColumnEnabled);

					}
					validateFolderNameOnRuleDatasetTab(ruleParam.getRuleName(), ruleParam.getRuleFolderName());


				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();

				rulesConfigurationtable=getRulesTable(ruleList);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectWorkflowRulesFlag ");

			flag=false;
		}

		return flag;
	}

	public void clearOverrideConnectionOrParameterField(By clearField) {

		isDisplayedInLoop(driver, 2, clearField);
		if(isDisplayed(driver, clearField)) {
			displayAndClick(driver, clearField);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		}
	}

	//single source connection override
	public boolean singleSourceConnectionOverrideUsingConnectionName(boolean flag ,String ruleName, String connectionName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog(logString+overrideRuleContent+" : "+ruleName+"  with source Connection : "+connectionName+logString);
					isDisplayedInLoop(driver, 3, returnElement(worklfowAddedRuleSourceConnLink, dynamicName, ruleName));
					WebElement ele = driver.findElement(returnElement(worklfowAddedRuleSourceConnLink, dynamicName, ruleName));isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					WebElement ele1 = driver.findElement(returnElement(workflowDetailsSourceConnOverrideButton, dynamicName, ruleName));
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					action.moveToElement(ele1).click().build().perform();

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						clearOverrideConnectionOrParameterField(sourceConnOverrideReplaceConnClearIcon);

						verifyIndividualLabel(driver, overrideDiscardIcon, discardContent+" icon  ");

						verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, true);
						/**
						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, false);
						 */
						String connName=getAttribute(driver, sourceConnOverrideFindConnName, attributeValue);

						clickOnEditButtonOfConnection(sourceConnOverrideFindConnEdit, findConnectionEditField, connName);

						BaseSuite.reportLog(" Clicking on replace connection dropdown ");

						displayAndClick(driver, sourceConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog(" Clicked on replace connection dropdown");
						
						action.moveToElement(driver.findElement(sourceConnOverrideSearchBar)).click().perform();

						sendkeysToField(driver, sourceConnOverrideSearchBar, "Search connection ", connectionName);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, connectionName), connectionName+" connection name");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnEditButtonOfConnection(sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, connectionName);

						clickOnButton(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, sourceConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog(sourceConnectionField+overrideFunctionalityErrorLog, "singleSourceConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" singleSourceConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}



	//single target connection override
	public boolean singleTargetConnectionOverrideUsingConnectionName(boolean flag ,String ruleName, String connectionName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog(logString+overrideRuleContent+" : "+ruleName+" with target  Connection : "+connectionName+logString);
					isDisplayedInLoop(driver, 3, returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleName));
					WebElement ele = driver.findElement(returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleName));isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					WebElement ele1 = driver.findElement(returnElement(workflowDetailsTargetConnOverrideButton, dynamicName, ruleName));
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					action.moveToElement(ele1).click().build().perform();

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						clearOverrideConnectionOrParameterField(targetConnOverrideReplaceConnClearIcon);

						verifyIndividualLabel(driver, overrideDiscardIcon, discardContent+iconContent);

						verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, true);
						/**
						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, false);
						 */
						BaseSuite.reportLog(" Clicking on replace connection dropdown");

						displayAndClick(driver, targetConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace connection dropdown ");
						
						action.moveToElement(driver.findElement(sourceConnOverrideSearchBar)).click().perform();

						sendkeysToField(driver, sourceConnOverrideSearchBar, " Search connection", connectionName);

						clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, connectionName), connectionName+"connection name ");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, targetConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog(targetConnectionField+overrideFunctionalityErrorLog, "singleTargetConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" singleTargetConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//single parameter override
	public boolean singleParameterOverride(boolean flag,String ruleName, String parameterName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				parameterName=checkNullValue(parameterName);

				if(!parameterName.isEmpty()) {

					BaseSuite.reportLog(logString+overrideRuleContent+" : "+ruleName+" with  parameter : "+parameterName+logString);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isDisplayedInLoop(driver, 5, returnElement(worklfowAddedRuleParameterLink, dynamicName, ruleName));
					WebElement ele = driver.findElement(returnElement(worklfowAddedRuleParameterLink, dynamicName, ruleName));isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					WebElement ele1 = driver.findElement(returnElement(workflowDetailsParameterOverrideButton, dynamicName, ruleName));
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					action.moveToElement(ele1).click().build().perform();
					isDisplayedInLoop(driver, 3, parameterOverrideTitle);

					if(isDisplayed(driver, parameterOverrideTitle)) {

						clearOverrideConnectionOrParameterField(parameterOverrideReplaceConnClearIcon);

						verifyIndividualLabel(driver, overrideDiscardIcon, discardContent+"  icon");

						verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

						verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

						verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

						verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, true);
						/**
						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, false);
						 */
						BaseSuite.reportLog("Clicking on replace parameter dropdown ");

						displayAndClick(driver, parameterOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog(" Clicked on replace parameter dropdown ");
						
						action.moveToElement(driver.findElement(sourceConnOverrideSearchBar)).click().perform();

						sendkeysToField(driver, sourceConnOverrideSearchBar, placeholderSearchParameter, parameterName);

						if(workflowParamFolder.isEmpty()) {

							clickOnFieldOrButton(driver, returnElement(parameterNameForOverride, dynamicName, parameterName), parameterNameContent);
						}else {
							clickOnFieldOrButton(driver, returnTwoElements(newParameterOverrideWithFolderPath, dynamicName, parameterName, dynamicFolderName, workflowParamFolder), parameterNameContent);
						}
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, parameterOverrideField);

					}else {
						BaseSuite.reportFailLog(parameterField+overrideFunctionalityErrorLog, "singleParameterOverride");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" singleParameterOverride ");

			flag=false;
		}

		return flag;

	}

	//set parameters for workflow rule override
	public DataTestingParameters setWorkflowRuleOverRideParameter(int ruleIndex, int overrideIndex, String jsonEntity) {

		DataTestingParameters param = new DataTestingParameters();

		param.setOverrideType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
				activityJsonPath + ruleIndex + overrideJsonPath +overrideIndex+"].type"));
		param.setOverrideSubType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
				activityJsonPath + ruleIndex +  overrideJsonPath +overrideIndex+jsonPathSubtype));
		param.setOverrideVariable(getJsonValueUsingJsonPathExpreesion(jsonEntity,
				activityJsonPath + ruleIndex +  overrideJsonPath +overrideIndex+"].variable"));
		param.setOverrideReplace(getJsonValueUsingJsonPathExpreesion(jsonEntity,
				activityJsonPath + ruleIndex +  overrideJsonPath +overrideIndex+jsonPathReplace));

		return param;
	}

	public void selectOverrideConnection(By locator, String sourceconnectionName) {

		try {

			isDisplayedInLoop(driver, 8, locator); 

			displayAndClick(driver, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!isDisplayed(driver, sourceConnOverrideSearchBar)) {
				displayAndClick(driver, locator);
			}

			sendkeysToField(driver, sourceConnOverrideSearchBar, "Search Connection", sourceconnectionName);

			clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, sourceconnectionName), "name");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectOverrideConnection ");
		}

	}

	public void selectOverrideParameter(By locator, String sourceconnectionName) {

		try {

			isDisplayedInLoop(driver, 8, locator); 

			displayAndClick(driver, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!isDisplayed(driver, sourceConnOverrideSearchBar)) {
				displayAndClick(driver, locator);
			}

			sendkeysToField(driver, sourceConnOverrideSearchBar, "Search Parameter", sourceconnectionName);

			clickOnFieldOrButton(driver, returnElement(parameterNameForOverride, dynamicName, sourceconnectionName), "name");

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectOverrideParameter ");
		}

	}

	//multiple source connection override
	public boolean multipleSourceConnectionOverrideUsingConnectionName(boolean flag , String findconnectionName, String replaceconnectionName, String expectedToast) {

		try {
			if(flag) {
				findconnectionName=checkNullValue(findconnectionName);
				replaceconnectionName=checkNullValue(replaceconnectionName);

				if(!findconnectionName.isEmpty()|| !replaceconnectionName.isEmpty()) {

					BaseSuite.reportLog("--------- Overriding bulk source connections with : "+replaceconnectionName+logString);

					clickOnButton(driver, rulesDatasetsSourceConnOverrideButton, sourceConnectionOverrideField, flag);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, false);

						selectOverrideConnection(sourceConnOverrideFindConnDD, findconnectionName);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						selectOverrideConnection(sourceConnOverrideReplaceConnDD, replaceconnectionName);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);

						flag=captureToastMsgContainsWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, sourceConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog("source connection override window is not visible DAT-6520", "multipleSourceConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" multipleSourceConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//multiple target connection override
	public boolean multipleTargetConnectionOverrideUsingConnectionName(boolean flag , String findconnectionName, String replaceconnectionName, String expectedToast) {

		try {
			if(flag) {
				findconnectionName=checkNullValue(findconnectionName);
				replaceconnectionName=checkNullValue(replaceconnectionName);

				if(!findconnectionName.isEmpty()|| !replaceconnectionName.isEmpty()) {

					BaseSuite.reportLog("--------- Overriding bulk target connections with : "+replaceconnectionName+logString);

					clickOnButton(driver, rulesDatasetsTargetConnOverrideButton, targetConnectionOverrideField, flag);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, false);

						selectOverrideConnection(targetConnOverrideFindConnDD, findconnectionName);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						selectOverrideConnection(targetConnOverrideReplaceConnDD, replaceconnectionName);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);

						flag=captureToastMsgContainsWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, targetConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog("target connection override window is not visible DAT-6520", "multipleTargetConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" multipleTargetConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//multiple parameter override
	public boolean multipleParameterOverride(boolean flag, String findparameterName,String replaceparameterName, String expectedToast) {

		try {
			if(flag) {
				findparameterName=checkNullValue(findparameterName);

				if(!findparameterName.isEmpty()) {

					BaseSuite.reportLog("--------- Overriding bulk parameters with : "+replaceparameterName+logString);

					clickOnButton(driver, rulesDatasetsParameterConnOverrideButton, parameterOverrideField, flag);

					isDisplayedInLoop(driver, 3, parameterOverrideTitle);

					if(isDisplayed(driver, parameterOverrideTitle)) {

						verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

						verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

						verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

						verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, false);

						selectOverrideParameter(parameterOverrideFindConnDD, findparameterName);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						selectOverrideParameter(parameterOverrideReplaceConnDD, replaceparameterName);

						clickOnButton(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);

						flag=captureToastMsgContainsWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, parameterOverrideField);

					}else {
						BaseSuite.reportFailLog("parameter override window is not visible DAT-6520", "multipleParameterOverride");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" multipleParameterOverride ");

			flag=false;
		}

		return flag;

	}

	//check flag status
	public boolean checkFlagStatus(boolean flag, String ruleName, String flagLocator, String flagLabel, String expected) {

		String methodName = "checkFlagStatus";

		By locator = returnElement(flagLocator, dynamicName, ruleName);

		isDisplayedInLoop(driver, 3, locator);

		if(isDisplayed(driver, locator)) {

			BaseSuite.reportLog("validating "+flagLabel+flagContent);

			String actual = getAttribute(driver, locator, attributeClass);

			if(expected.contains(continueString)) {

				if(actual.contains(attrcheck)) {
					BaseSuite.validationReportLog(flagLabel+" flag is checked as expected");
				}else {
					BaseSuite.reportFailLog(flagLabel+" flag is unchecked kindly check", methodName);
				}

			}else {

				if(!actual.contains(attrcheck)) {

					BaseSuite.validationReportLog(flagLabel+" flag is unchecked as expected");
				}else {
					BaseSuite.reportFailLog(flagLabel+" flag is checked kindly check", methodName);
				}

			}

		}else {
			BaseSuite.reportFailLog(flagLabel+" flag not visible kindly check", methodName);
		}
		return flag;
	}

	//check rule flag status
	public void checkRuleFlagStatus(boolean flag, String ruleName, String flagLocator, String flagLabel, String expected) {

		String methodName = "checkRuleFlagStatus";

		By locator = returnElement(flagLocator, dynamicName, ruleName);

		isDisplayedInLoop(driver, 3, locator);

		if(flag && isDisplayed(driver, locator)) {

			BaseSuite.reportLog("validating "+flagLabel+flagContent);

			String actual = getAttribute(driver, locator, attributeClass);

			if(expected.contains(trueContent)) {

				if(actual.contains(attrcheck)) {
					BaseSuite.validationReportLog(flagLabel+" flag is checked as expected");
				}else {
					BaseSuite.reportFailLog(flagLabel+" flag is unchecked kindly check", methodName);
				}

			}else {

				if(!actual.contains(attrcheck)) {

					BaseSuite.validationReportLog(flagLabel+" flag is unchecked as expected");
				}else {
					BaseSuite.reportFailLog(flagLabel+" flag is checked kindly check", methodName);
				}

			}

		}else {
			BaseSuite.reportFailLog(flagLabel+" flag not visible kindly check", methodName);
		}	
	}

	//validate added rules in workflow
	public boolean validateAddedRuleInWorkflow(boolean flag, List<String> ruleList, String workflowJsonEntity) {

		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				for(int i=0;i<ruleList.size();i++) {

					/**			DataTestingParameters rulesParam = getDataTestingInfoFromDataBase("",ruleList.get(i)); **/

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("---------  Validate added rule : "+ruleParam.getRuleName()+" in workflow --------");

					/**	flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());*/

					if(elementNotVisible(driver, workflowDetailsRulesNoRecordFound)) {

						viewAndValidateField(returnElement(worklfowAddedRuleNameLink, dynamicName, ruleParam.getRuleName()), ruleParam.getRuleName(), ruleParam.getRuleName(), true);

						checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess());

						checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleFailureFlag,failureContent, ruleParam.getOnFailure());

						checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError());

						checkConnectionAndParameterOnAddedRules(flag, ruleParam);

						checkRuleFlagStatus(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode());

						checkRuleFlagStatus(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive());

						checkExpectedValueWithActual(driver, flag, returnElement(worklfowAddedRuleFolderLink, dynamicName, ruleParam.getRuleName()),folderContent, ruleParam.getRuleFolderName(),true);

					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

				javascript(driver, scrollToElementArg, rulesDatasetsSearchBar);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddedRuleInWorkflow ");

			flag=false;
		}
		return flag;



	}

	//run workflow selected rule
	public boolean runSelectedRule(boolean flag, boolean expectedbtnState, int count) {

		try {
			if(flag) {
				isDisplayedInLoop(driver, 3, rulesDatasetsRunButton);
				javascript(driver, scrollToElementArg, rulesDatasetsRunButton);

				flag=clickOnButton(driver, rulesDatasetsRunButton, "Run Option", true);

				if(flag) {

					isDisplayedInLoop(driver, 3, ruleDatasetsSelectedRuleBtn);

					verifyVisibilityOfButtons(driver, ruleDatasetsRunFromHereBtn, runFromHereContent, count == 1);

					flag=clickOnButton(driver, ruleDatasetsSelectedRuleBtn, "Rule Selected", expectedbtnState);

				}
			}		
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" runSelectedRule ");
			flag=false;
		}

		return flag;
	}

	//run workflow from rule from here 
	public boolean runRuleFromHere(boolean flag, boolean expectedbtnState) {

		try {
			if(flag) {
				javascript(driver, scrollToElementArg, rulesDatasetsRunButton);

				flag=clickOnButton(driver, rulesDatasetsRunButton, "Run Option", true);

				if(flag) {

					isDisplayedInLoop(driver, 3, ruleDatasetsRunFromHereBtn);

					flag=clickOnButton(driver, ruleDatasetsRunFromHereBtn, runFromHereContent, expectedbtnState);

				}
			}		
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" runRuleFromHere ");
			flag=false;
		}

		return flag;
	}

	//discard workflow functionality
	public boolean discardWorkflowDetails(boolean flag) {

		try {
			if(flag) {

				flag=clickOnButton(driver, workflowDetailsDiscardButton, discardContent, true);

				if(flag) {

					isDisplayedInLoop(driver, 5, discardWorkflowPopupTitle);

					if(isDisplayed(driver, discardWorkflowPopupTitle)) {

						verifyIndividualLabel(driver, discardWorkflowPopupTitle, "Discard Changes");

						String acDiscardMsg = getAttribute(driver, discardWorkflowPopupContent, attributeTextContent);

						BaseSuite.reportLog("Retrieved : "+acDiscardMsg.trim());
						BaseSuite.reportLog("Expected : "+discardWorkflowPopupWindowContent);

						if(acDiscardMsg.trim().equals(discardWorkflowPopupWindowContent)) {
							BaseSuite.validationReportLog("Expected discard workflow content matched successfully");
						}else {
							BaseSuite.reportFailLog("Expected discard workflow content not matched", "discardWorkflowDetails");
						}

						verifyVisibilityOfButtons(driver, discardWorkflowPopupCancelButton, cancelContent, true);

						flag=clickOnButton(driver, discardWorkflowPopupDiscardButton, discardContent, true);
					}else {
						BaseSuite.reportFailLog("Discard Changes not matched", "discardWorkflowDetails");
					}

				}


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" runSelectedRule ");
			flag=false;
		}

		return flag;

	}

	public boolean validateWorkflowDuplicate(String expectedToastMsg ) {
		boolean state=true;
		boolean tag=true;
		try {
			/**	state=clickOnButton(driver, moreOptionDuplicateButton, duplicateContent, true);**/

			javascript(driver, jscriptToClick, moreOptionDuplicateButton);

			if(isDisplayed(driver, toastMsg)) {
				state=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMsg, "Workflow Duplicate");
				tag=false;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if(state && tag) {
				state=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMsg, "Workflow Duplicate");
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateWorkflowDuplicate ");

			state=false;
		}

		return state;
	}

	//duplicate workflow functionality
	public boolean duplicateWorkflow(boolean flag, String expectedToastMsg) {

		try {

			if(flag) {

				flag = clickOnButton(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);
				javascript(driver, jscriptToMouseHover, workflowDetailsMoreOptionButton);


				isDisplayedInLoop(driver, 3, moreOptionPopupWindow);

				if(isDisplayed(driver, moreOptionPopupWindow)) {

					flag=validateWorkflowDuplicate(expectedToastMsg);

				}else {
					BaseSuite.reportFailLog("More Option window not visible kindly check", "duplicateWorkflow");
				}


			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" duplicateWorkflow ");

			flag=false;
		}

		return flag;

	}

	public boolean clickOnActivateOrDeactivateButton(boolean flag,String expected) {

		try {
			if(expected.equalsIgnoreCase(deactivateContent)) {

				/**	flag=clickOnButton(driver, moreOptionDeactivateButton, deactivateContent, true);**/
				javascript(driver, jscriptToClick, moreOptionDeactivateButton);

			}else if(expected.equalsIgnoreCase(activateContent)){

				/**	flag=clickOnButton(driver, moreOptionActivateButton, activateContent, true);**/
				javascript(driver, jscriptToClick, moreOptionActivateButton);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnActivateOrDeactivateButton ");	
			flag=false;
		}
		return flag;
	}

	//activate or deactivate workflow functionality
	public boolean activateOrDeactivateWorkflow(boolean flag, String expected, String icedqUser, String expectedMsg) {

		try {

			if(flag) {

				flag = clickOnButton(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);
				javascript(driver, jscriptToMouseHover, workflowDetailsMoreOptionButton);


				isDisplayedInLoop(driver, 3, moreOptionPopupWindow);

				if(isDisplayed(driver, moreOptionPopupWindow)) {

					flag=clickOnActivateOrDeactivateButton(flag, expected);

					if(icedqUser.toLowerCase().contains(readerContent) || icedqUser.toLowerCase().contains(executorContent)) {

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedMsg, "activateOrDeactivateWorkflow");	
					}

				}else {
					BaseSuite.reportFailLog("More Option not visible kindly check", "activateOrDeactivateWorkflow");
				}

			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" activateOrDeactivateWorkflow ");
			flag=false;
		}

		return flag;

	}

	public String checkclipBoardContents() {

		String result = "";

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		boolean hasStringText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasStringText) {
			try {
				result = (String)contents.getTransferData(DataFlavor.stringFlavor);
			} catch (Exception ex) {
				BaseSuite.reportErrorLog(ex, "Exception Occurs  :: "+ex.toString());
			}
		}

		return result;
	}

	//share workflow functionality
	public boolean shareWorkflow(boolean flag) {
		String result ;
		try {

			if(flag) {

				flag = clickOnButton(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);
				javascript(driver, jscriptToMouseHover, workflowDetailsMoreOptionButton);

				isDisplayedInLoop(driver, 3, moreOptionPopupWindow);

				if(isDisplayed(driver, moreOptionPopupWindow)) {

					/**	flag=clickOnButton(driver, moreOptionShareButton, shareContent, true);**/

					javascript(driver, jscriptToClick, moreOptionShareButton);

					captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, workflowDetailsShareToastMsg, "Workflow share");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					result=checkclipBoardContents();

					String url = driver.getCurrentUrl();

					BaseSuite.reportLog("Workflow shared link on clipboard is :: "+result);

					stringContainsOutput(result, url, true);


				}else {
					BaseSuite.reportFailLog("More Option not visible kindly check", "shareWorkflow");
				}
			}

		}catch(IllegalStateException ex) {

			BaseSuite.reportLog("Clipboard is not accessable due to screen lock :"+ex.toString());
			flag=true;
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" shareWorkflow ");
			flag=false;
		}

		return flag;

	}

	//select subscribers workflow functionality
	public boolean selectSubcriberForWorkflow(boolean flag, By locatorlabel, By locatorField, String label,String expected) {

		try {

			if(flag) {

				BaseSuite.reportLog("---------------- subscription for user/group : "+expected+"--------------- ");

				verifyIndividualLabel(driver, locatorlabel, label);

				isDisplayedInLoop(driver, 2, locatorField);

				if(isDisplayed(driver, locatorField)) {

					BaseSuite.reportLog(label+" field is visible");

					click(driver, locatorField);

					sendKeys(driver, locatorField, expected);

					BaseSuite.reportLog("Entered User name : "+expected);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(isDisplayed(driver, returnElement(subscriberNameSelect, dynamicName, expected))) {

						WebElement ele = driver.findElement(returnElement(subscriberNameSelect, dynamicName, expected));

						ele.click();

						BaseSuite.validationReportLog("selected User name : "+expected+" successfully");
					}else {
						BaseSuite.reportFailLog("Subscriber name not visible","selectSubcriberForWorkflow");
					}


				}else {
					BaseSuite.reportFailLog("Subscriber "+label+" field not visible","selectSubcriberForWorkflow");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectSubcriberForWorkflow ");
			flag=false;
		}
		return flag;
	}

	public boolean selectSubscriberWorkflowList(boolean flag, String notifyJsonEntity) {

		List<String> onSuccessUser = getJsonArrayValueUsingJsonPathExpreesion(notifyJsonEntity, jsonPathSubcriptionSuccess);
		List<String> onFailureUser = getJsonArrayValueUsingJsonPathExpreesion(notifyJsonEntity, jsonPathSubcriptionFailure);
		List<String> onErrorUser = getJsonArrayValueUsingJsonPathExpreesion(notifyJsonEntity, jsonPathSubcriptionError);

		if(isDisplayed(driver, subscriptionSidepaneEmailExpand)) {

			clickOnButton(driver, subscriptionSidepaneEmailExpand, "email expand", true);
		}

		for(int i=0;i<onSuccessUser.size();i++) {

			flag=selectSubcriberForWorkflow(flag,subscriptionSidePanelOnSuccessLabel, subscriptionSidePanelOnSuccessField, "On Success ", onSuccessUser.get(i));
		}

		for(int i=0;i<onFailureUser.size();i++) {

			flag=selectSubcriberForWorkflow(flag,subscriptionSidePanelOnFailureLabel, subscriptionSidePanelOnFailureField, "On Failure ", onFailureUser.get(i));
		}

		for(int i=0;i<onErrorUser.size();i++) {

			flag=selectSubcriberForWorkflow(flag,subscriptionSidePanelOnErrorLabel, subscriptionSidePanelOnErrorField, "On Error ", onErrorUser.get(i));
		}
		return flag;
	}

	//validate and enter subscriber details functionality
	public boolean validateAndEnterSubscriberDetails(boolean flag, String notifyJsonEntity) {

		try {
			if(flag && !notifyJsonEntity.isEmpty()) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				verifyIndividualLabel(driver, subscriptionSidePanelTitle, "Subscribers");

				if(isDisplayed(driver, subscriptionSidePanelCrossIcon)) {

					BaseSuite.reportLog("Subscriber discard icon is visible");

				}else {
					BaseSuite.reportFailLog("Subscriber discard icon not visible","validateAndEnterSubscriberDetails");
				}

				flag=selectSubscriberWorkflowList(flag, notifyJsonEntity);

				if(flag) {

					verifyVisibilityOfButtons(driver, subscriptionSidePanelCancelButton, cancelContent, true);

					flag=clickOnButton(driver, subscriptionSidePanelSaveButton, saveContent, true);

					if(isDisplayed(driver, toastMsg)) {

						captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "", "Save Workflow Subscription");
						clickOnButton(driver, subscriptionSidePanelCancelButton, cancelContent, true);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndEnterSubscriberDetails ");
			flag=false;
		}

		return flag;

	}

	public void selectSubscribeOption(String notifyJsonEntity) {

		String onsuccess=getJsonValueUsingJsonPathExpreesion(notifyJsonEntity, "$.events[0].subscriptions[?(@.status=='success')].status");
		String onfailure=getJsonValueUsingJsonPathExpreesion(notifyJsonEntity, "$.events[0].subscriptions[?(@.status=='failure')].status");
		String onerror=getJsonValueUsingJsonPathExpreesion(notifyJsonEntity, "$.events[0].subscriptions[?(@.status=='error')].status");

		String s = getAttribute(driver, unsubscribeOnSuccessCheckbox, attributeClass);
		String f = getAttribute(driver, unsubscribeOnFailureCheckbox, attributeClass);
		String e = getAttribute(driver, unsubscribeOnErrorCheckbox, attributeClass);

		onsuccess=checkNullValue(onsuccess);
		onfailure=checkNullValue(onfailure);
		onerror=checkNullValue(onerror);

		boolean s1=false;
		boolean f1=false;
		boolean e1=false;

		if(!onsuccess.isEmpty() ) {
			s1=true;
		}
		if(!onfailure.isEmpty()) {	
			f1=true;		
		}
		if(!onerror.isEmpty()) {	
			e1=true;	
		}

		if(s1) {
			checkCheckboxOfFlag(unsubscribeOnSuccessCheckbox, onSuccessContent, s, falseContent);
			checkCheckboxOfFlag(unsubscribeOnSuccessCheckbox, onSuccessContent, s, trueContent);
		}else {
			checkCheckboxOfFlag(unsubscribeOnSuccessCheckbox, onSuccessContent, s, falseContent);
		}
		if(f1) {
			checkCheckboxOfFlag(unsubscribeOnFailureCheckbox, onFailureContent, f, falseContent);
			checkCheckboxOfFlag(unsubscribeOnFailureCheckbox, onFailureContent, f, trueContent);
		}else {
			checkCheckboxOfFlag(unsubscribeOnFailureCheckbox, onFailureContent, f, falseContent);
		}
		if(e1) {
			checkCheckboxOfFlag(unsubscribeOnErrorCheckbox, onErrorContent, e, falseContent);
			checkCheckboxOfFlag(unsubscribeOnErrorCheckbox, onErrorContent, e, trueContent);
		}else {
			checkCheckboxOfFlag(unsubscribeOnErrorCheckbox, onErrorContent, e, falseContent);
		}



	}

	public boolean clickOnSubscribeButton(boolean flag) {

		try {
			if(!isDisplayed(driver, unsubscribeButton)) {

				javascript(driver, jscriptToClick, subscribeButton);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnSubscribeButton ");
			flag=false;
		}
		return flag;
	}

	public boolean validateUnsunscribeButton(String notifyJsonEntity) {
		boolean flag=true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, subscribeButton);

			if(isDisplayed(driver, subscribeButton)) {

				clickOnButton(driver, subscribeButton, "Subscribe", true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				selectSubscribeOption(notifyJsonEntity);

				verifyVisibilityOfButtons(driver, subscriptionSidePanelCancelButton, cancelContent, true);

				flag=clickOnButton(driver, subscriptionSidePanelSaveButton, saveContent, true);

				if(isDisplayed(driver, toastMsg)) {

					captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "", "Save Workflow Subscription");
					clickOnButton(driver, subscriptionSidePanelCancelButton, cancelContent, true);
				}

			}else {
				BaseSuite.reportFailLog("Unsubscribe button not visible kindly check", "selectSubcribeFunctionality");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateUnsunscribeButton ");
			flag=false;
		}
		return flag;
	}

	public boolean selectSubcribeFunctionality(boolean flag,String notifyJsonEntity, String icedqUser) {
		try {
			if(flag) {

				isDisplayedInLoop(driver, 3, moreOptionPopupWindow);
				if(isDisplayed(driver, moreOptionPopupWindow)) {

					if(icedqUser.contains(ownerContent)) {
						BaseSuite.reportLog("---------------- Adding subscription --------------- ");

						javascript(driver, jscriptToClick, moreOptionSubscriptionButton);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						checkUnexpectedToast();

						if(isDisplayed(driver, subscriptionSidepaneEmailExpand)) {

							clickOnButton(driver, subscriptionSidepaneEmailExpand, "email expand", true);
						}

						flag=validateAndEnterSubscriberDetails(flag, notifyJsonEntity);

					}else {
						BaseSuite.reportLog("---------------- selecting subscription --------------- ");

						checkUnexpectedToast();

						flag=validateUnsunscribeButton(notifyJsonEntity);
					}
				}else {
					BaseSuite.reportFailLog("More Option window not visible kindly check", "selectSubcribeFunctionality");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectSubcribeFunctionality ");
			flag=false;
		}
		return flag;

	}

	//subscription functionality
	public boolean subscriptionWorkflow(boolean flag, String notifyJsonEntity,String icedqUser) {

		try {
			notifyJsonEntity=checkNullValue(notifyJsonEntity);

			if(flag && !notifyJsonEntity.isEmpty()) {

				flag = clickOnButton(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

				javascript(driver, jscriptToMouseHover, workflowDetailsMoreOptionButton);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=selectSubcribeFunctionality(flag, notifyJsonEntity, icedqUser);

			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" subscriptionWorkflow ");
			flag=false;
		}

		return flag;

	}
	/**
	public boolean selectcheckbox(By locator, String label) {
	    boolean isSuccess = true;

	    try {
	        // Wait for any loading spinners
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

	        // Retry visibility check
	        isDisplayedInLoop(driver, 5, locator);
	        if (!isDisplayed(driver, locator)) {
	            BaseSuite.reportFailLog("Checkbox not visible for " + label, "selectCheckbox");
	            return false;
	        }

	        // Get checkbox class attribute
	        String checkboxClass = getAttribute(driver, locator, attributeClass);

	        // Check if already selected
	        boolean isAlreadySelected = checkboxClass.contains(checkContent) && !checkboxClass.contains(uncheckContent);

	        if (isAlreadySelected) {
	            BaseSuite.reportLog(label + " checkbox is already selected.");
	            return false;
	        }

	        // Attempt to click
	        BaseSuite.reportLog("Clicking on checkbox: " + label);
	        displayAndClick(driver, locator);
	        isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

	        // Verify checkbox state post-click
	        String updatedClass = getAttribute(driver, locator, attributeClass);
	        boolean isNowSelected = updatedClass.contains(checkContent) && !updatedClass.contains(uncheckContent);

	        if (isNowSelected) {
	            BaseSuite.validationReportLog("Successfully selected checkbox: " + label);
	        } else {
	            BaseSuite.reportFailLog("Failed to select checkbox: " + label, "selectCheckbox");
	            isSuccess = false;
	        }

	    } catch (Exception e) {
	        BaseSuite.reportErrorLog(e, errorLogTitle + " :: selectCheckbox - " + e.getMessage());
	        isSuccess = false;
	    }

	    return isSuccess;
	}
	 */
	public void selectUncheckbox(By locator, String label) {

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

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
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label+" checkbox is unchecked");

			}else if(acs.contains("e-uncheck")){

				BaseSuite.reportLog(label+" type is checkbox already unchecked");
			}
		}
	}

	public void printlist(By locator, String label , String attribute) {

		try {
			BaseSuite.reportLog("Checking List of "+label);

			List<WebElement> types = getElements(driver, locator);

			for(int i =0;i<types.size();i++) {

				String typename = types.get(i).getAttribute(attribute);

				BaseSuite.reportLog((i+1)+" "+typename+" "+label+visibleContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " :: printlist - ");
		}
	}



	public boolean validateNSelectWorkflowTypeInAdvanceSearch(boolean flag, String typeValue,boolean checkstatus) {

		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchTypeLabel, "Type");

				if(isDisplayed(driver, advancedSearchTypeExpand)) {

					displayAndClick(driver, advancedSearchTypeExpand);
				}

				printlist(advancedSearchTypeList, "type", attributeTextContent);

				if(!typeValue.isEmpty()) {

					By locator = returnElement(advanceSearchTypeCheckbox, dynamicName, typeValue);

					isDisplayedInLoop(driver, 3, locator);

					if(isDisplayed(driver, locator)) {

						if(checkstatus) {

							selectcheckbox(driver, locator, typeValue);

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						}else {

							selectUncheckbox(locator, typeValue);
						}

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog(typeValue+" type not found kindly check", "validateNSelectWorkflowTypeInAdvanceSearch");
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectWorkflowTypeInAdvanceSearch ");
			flag=false;
		}
		return flag;
	}

	public boolean validateNSelectWorkflowStateInAdvanceSearch( String stateValue,boolean checkstatus) {
		boolean flag=true;
		try {

			verifyIndividualLabel(driver, advancedSearchStateLabel, stateContent);

			if(isDisplayed(driver, advancedSearchStateExpand)) {

				displayAndClick(driver, advancedSearchStateExpand);
			}

			printlist(advancedSearchStateList, stateContent, attributeTextContent);

			if(!stateValue.isEmpty()) {

				By locator = returnElement(advanceSearchStateCheckbox, dynamicName, stateValue);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {
					if(checkstatus) {	

						selectcheckbox(driver, locator, stateValue);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateIsDisplayedOrNot(driver, returnElement(workflowListingStatusIcon, dynamicName, stateValue), stateValue+" icon", true);

					}else {

						selectUncheckbox(locator, stateValue);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}else {
					BaseSuite.reportFailLog(stateValue+" State not found kindly check", "validateNSelectWorkflowStateInAdvanceSearch");
					flag=false;
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectWorkflowStateInAdvanceSearch ");
			flag=false;
		}
		return flag;
	}

	public void searchUser(By searchLocator,String userName) {

		try {
			verifySearchField(driver, searchLocator, placeholderSearchUser, placeholderSearchUser);

			BaseSuite.reportLog(enteringValueContent+userName);

			displayAndClick(driver, searchLocator);

			clear_Click_SendKeys(driver, 4, searchLocator, userName);

			BaseSuite.reportLog(" Entered value : "+userName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchUser "+e.toString());

		}		
	}

	public boolean validateNSelectUpdatedByUserInAdvanceSearch(boolean flag, String userNAme, String fullName, boolean checkstatus) {

		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchUpdatedByLabel, "Updated By");

				if(isDisplayed(driver, advancedSearchUpdatedByExpand)) {

					displayAndClick(driver, advancedSearchUpdatedByExpand);
				}

				if(!userNAme.isEmpty()) {

					searchUser(advancedSearchUpdatedBySearchBar, userNAme);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					By locator = returnElement(advanceSearchUpdatedByCheckbox, dynamicName, fullName);

					isDisplayedInLoop(driver, 4, locator);

					if(isDisplayed(driver, locator)) {
						if(checkstatus) {

							selectcheckbox(driver, locator, userNAme);

							isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

							validateIsDisplayedOrNot(driver, returnElement(workflowListingUpdatedByIcon, dynamicName, fullName), fullName+" icon", true);


						}else {
							selectUncheckbox(locator, userNAme);
						}
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog(userNAme+" Username not found kindly check", "validateNSelectUpdatedByUserInAdvanceSearch");
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectUpdatedByUserInAdvanceSearch ");
			flag=false;
		}
		return flag;
	}

	public boolean selectYearMonthFromCalender(boolean flag, String inputValue, String valueType) {

		try {
			isDisplayedInLoop(driver, 3, returnElement(advanceSearchLastUpdatedCalanderSelectMon, dynamicName,inputValue));

			if(isDisplayed(driver, returnElement(advanceSearchLastUpdatedCalanderSelectMon, dynamicName, inputValue))) {

				flag=isClickable(driver, returnElement(advanceSearchLastUpdatedCalanderSelectMon, dynamicName, inputValue), inputValue, flag);

				if(flag) {
					displayAndClick(driver, returnElement(advanceSearchLastUpdatedCalanderSelectMon, dynamicName, inputValue));

					BaseSuite.reportLog(inputValue+" "+valueType+" is selected");
				}

				waitForExecution(300);

				String currentValues = getText(driver, advancedSearchLastUpdatedCalanderCurrentValue);

				if(!currentValues.contains(inputValue)) {
					BaseSuite.reportFailLog("Failed to select : "+inputValue, "selectYearMonthFromCalender");
					flag=false;
				}

			}else {
				BaseSuite.reportFailLog(inputValue+" "+valueType+" is not selected", "selectYearMonthFromCalender");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle+" selectYearMonthFromCalender ");
		}
		return flag;
	}

	public boolean selectDateFromCalenderUsingMonth(boolean flag, String month, String date) {

		isDisplayedInLoop(driver, 3, returnTwoElements(advanceSearchLastUpdatedCalanderSelectDate,dynamicMonth,month,dynamicDate,date));

		if(isDisplayed(driver, returnTwoElements(advanceSearchLastUpdatedCalanderSelectDate,dynamicMonth,month,dynamicDate,date))) {

			flag=isClickable(driver, returnTwoElements(advanceSearchLastUpdatedCalanderSelectDate,dynamicMonth,month,dynamicDate,date),date, flag);
			if(flag) {
				displayAndClick(driver,returnTwoElements(advanceSearchLastUpdatedCalanderSelectDate,dynamicMonth,month,dynamicDate,date));

				BaseSuite.reportLog(date+" date is selected");
			}
		}else {
			BaseSuite.reportFailLog(date+" date is not selected", "selectDateFromCalenderUsingMonth");
			flag=false;
		}
		return flag;
	}

	//validate year on calendar
	public boolean validateYearOnCalendar(int expectedYear) {
		boolean flag=true;
		try {

			isDisplayedInLoop(driver, 10, advancedSearchLastUpdatedCalanderCurrentValue);

			String currentValues = getText(driver, advancedSearchLastUpdatedCalanderCurrentValue);

			String [] value = currentValues.split("-");

			int year1=Integer.parseInt(value[0].trim());
			int year2=Integer.parseInt(value[1].trim());

			if(expectedYear>year1 && expectedYear<year2 ||expectedYear==year1 && expectedYear==year2 ) {

				BaseSuite.reportLog(expectedYear+" year is visible");

				flag=false;

			}else if(expectedYear<year1) {

				clickOnButton(driver, advancedSearchLastUpdatedCalanderPreviousBtn, "Previous", true);

			}else if(expectedYear>year2) {

				clickOnButton(driver, advancedSearchLastUpdatedCalanderNextBtn, "Next", true);

			}

		}  catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateYearOnCalendar ");
			flag=false;

		}
		waitForExecution(300);
		return flag;
	}

	//select date from calendar
	public boolean selectDateFromCalendar(boolean flag, By locator, String date) {

		try {
			if(flag && !date.isEmpty()) {
				BaseSuite.reportLog("Selecting date : "+date);
				String [] datevalue = date.split("/");
				String mon = CustomTimeUtil.returnMonthName(datevalue[0].trim());
				String day = CustomTimeUtil.returnDay(datevalue[1].trim());
				String exyear = datevalue[2].trim();
				int year = Integer.parseInt(datevalue[2].trim());

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog("clicking on calender icon");

					displayAndClick(driver, locator);

					BaseSuite.reportLog("clicked on calender icon");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, advancedSearchLastUpdatedCalanderDatePopup);

					if(isDisplayed(driver, advancedSearchLastUpdatedCalanderDatePopup)) {

						displayAndClick(driver, advancedSearchLastUpdatedCalanderCurrentValue);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, advancedSearchLastUpdatedCalanderCurrentValue);

						waitForExecution(300);

						boolean s=true;
						while(s) {
							s=validateYearOnCalendar(year);
						}

						flag=selectYearMonthFromCalender(flag, exyear, "year");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=selectYearMonthFromCalender(flag, mon, "month");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=selectDateFromCalenderUsingMonth(flag, mon, day);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


					}else {
						BaseSuite.reportFailLog("Calender is not visible", "selectDateFromCalendar");
						flag=false;
					}

				}else {
					BaseSuite.reportFailLog("locator is not visible", "selectDateFromCalendar");
					flag=false;
				}


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectDateFromCalendar ");

			flag=false;
		}
		return flag;
	}

	//select today's date
	public boolean selectTodaydate(boolean flag,By locator) {

		try {
			BaseSuite.reportLog("Selecting Today's date");

			BaseSuite.reportLog("clicking on calender icon");

			displayAndClick(driver, locator);

			BaseSuite.reportLog("clicked on calender icon");

			isDisplayedInLoop(driver, 3, advancedSearchLastUpdatedCalanderDatePopup);

			if(isDisplayed(driver, advancedSearchLastUpdatedCalanderDatePopup)) {

				flag=clickOnButton(driver, advancedSearchLastUpdatedCalanderTodayBtn, todayContent, true);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectTodaydate ");

			flag=false;
		}
		return flag;
	}

	//select date 
	public boolean selectDate(boolean flag, By locator, String date) {

		if(!date.equalsIgnoreCase(todayContent)) {
			flag=selectDateFromCalendar(flag, locator, date);
		}else {
			flag=selectTodaydate(flag, locator);
		}
		return flag;
	}

	//validate selected last updated date 
	public boolean validateLastUpdateDateSelected(boolean flag, By locator, String expected) {

		String selectedDate = getAttribute(driver, locator, attributeValue);

		if(expected.equalsIgnoreCase(todayContent)) {

			String timestamp = new SimpleDateFormat(calanderDateFormat).format(new Date());

			expected = timestamp;
		}else {

			String [] datevalue = expected.split("/");
			String mon = CustomTimeUtil.returnDay(datevalue[0].trim());
			String day = CustomTimeUtil.returnDay(datevalue[1].trim());
			String exyear = datevalue[2].trim();

			expected = mon+"/"+day+"/"+exyear;
		}


		BaseSuite.reportLog("Retrieved Date : "+selectedDate);

		BaseSuite.reportLog("Expected Date : "+expected);

		if(selectedDate.equalsIgnoreCase(expected)) {

			BaseSuite.validationReportLog("Expected Date is selected ");

		}else {
			BaseSuite.reportFailLog("Expected Date is not selected ", "validateLastUpdateDateSelected");
			flag=false;
		}
		return flag;
	}

	//validate and select last updated dates in advanced search
	public boolean validateNSelectLastUpdatedInAdvanceSearch(boolean flag, String startDate, String endDate) {

		try {
			if(flag) {
				javascript(driver, scrollToElementArg, advancedSearchLastUpdatedLabel);

				verifyIndividualLabel(driver, advancedSearchLastUpdatedLabel, "Last Updated");

				if(isDisplayed(driver, advancedSearchLastUpdatedExpand)) {

					displayAndClick(driver, advancedSearchLastUpdatedExpand);
				}

				compareTwoDates(flag, calanderDateFormat, startDate, endDate);

				javascript(driver, scrollToElementArg, advancedSearchLastUpdatedFrom);

				if(!startDate.isEmpty() && isDisplayed(driver, advancedSearchLastUpdatedFrom) ) {

					BaseSuite.validationReportLog("From field is visible");

					verifyPlaceHolderValue(driver, advancedSearchLastUpdatedFrom, "From", "From");

					isEditable(driver, advancedSearchLastUpdatedFrom, "From");

					flag=selectDate(flag, advancedSearchLastUpdatedFromDateIcon, startDate);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=validateLastUpdateDateSelected(flag, advancedSearchLastUpdatedFrom, startDate);

				}
				if(flag) {
					javascript(driver, scrollToElementArg, advancedSearchLastUpdatedTo);

					if(!endDate.isEmpty() && isDisplayed(driver, advancedSearchLastUpdatedTo) ) {

						BaseSuite.validationReportLog("To field is visible");

						verifyPlaceHolderValue(driver, advancedSearchLastUpdatedTo, "To", "To");

						isEditable(driver, advancedSearchLastUpdatedTo, "To");

						flag=selectDate(flag, advancedSearchLastUpdatedToDateIcon, endDate);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateLastUpdateDateSelected(flag, advancedSearchLastUpdatedTo, endDate);

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectLastUpdatedInAdvanceSearch ");
			flag=false;
		}
		return flag;
	}

	//compare two dates
	public boolean compareTwoDates(boolean flag, String dateformat, String startDate,String endDate) {

		try {
			if(!startDate.isEmpty() || !endDate.isEmpty()) {

				if(startDate.equalsIgnoreCase(todayContent)) {
					String timestamp = new SimpleDateFormat(dateformat).format(new Date());

					startDate = timestamp;
				}
				if(endDate.equalsIgnoreCase(todayContent)) {
					String timestamp = new SimpleDateFormat(dateformat).format(new Date());

					endDate = timestamp;
				}

				SimpleDateFormat sdformat = new SimpleDateFormat(dateformat);
				Date d1 = sdformat.parse(startDate);
				Date d2 = sdformat.parse(endDate);
				log.info("The date 1 is: " + sdformat.format(d1));
				log.info("The date 2 is: " + sdformat.format(d2));
				if(d1.compareTo(d2) > 0) {
					BaseSuite.reportFailLog("start date occurs after end date ", "compareTwoDates");
					log.info("Date 1 occurs after Date 2");
					flag=false;
				} else if(d1.compareTo(d2) < 0) {
					log.info("Date 1 occurs before Date 2");
				} else if(d1.compareTo(d2) == 0) {
					log.info("Both dates are equal");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" compareTwoDates ");
		}
		return flag;
	}

	//advance search functionality
	public boolean advanceSearchFunctionality(boolean flag, String typeValue, String stateValue, String userName,String fullName, String startdate, String enddate) {

		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchTitle, advanceSearchContent);

				if(isDisplayed(driver, advancedSearchExpand)) {

					displayAndClick(driver, advancedSearchExpand);
				}

				isDisplayedInLoop(driver, 3, workflowAppliedFilterCross);

				if(isDisplayed(driver, workflowAppliedFilterCross)) {

					displayAndClick(driver, workflowAppliedFilterCross);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

				validateNSelectWorkflowTypeInAdvanceSearch(flag, typeValue,true);

				flag=validateNSelectWorkflowStateInAdvanceSearch(stateValue,true);

				flag=validateNSelectUpdatedByUserInAdvanceSearch(flag, userName,fullName, true);

				flag=validateNSelectLastUpdatedInAdvanceSearch(flag, startdate, enddate);


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" advanceSearchFunctionality ");
			flag=false;
		}

		return flag;

	}

	public boolean validateMoreOptionButtonFunctionality(boolean flag, By locator, String label, String icedqUser) {

		if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent) || isDisplayed(driver, toastMsg)) {

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Bulk operation Privilege");

		}else {

			if(flag && isDisplayed(driver, locator)) {

				verifyIndividualLabel(driver, locator, label);

			}else {
				BaseSuite.reportFailLog("Bulk changes title "+label+" not visible ", "validateMoreOptionButtonFunctionality");
			}
		}
		return flag;
	}

	//click on more option on workflow listing page and select excepted option button
	public boolean clickOnMoreOptionAndSelectOption(boolean flag, String option, String icedqUser) {

		String label = null;
		By locator=null;
		try {
			if(flag) {
				javascript(driver, jscriptToMouseHover, moreOptionButton);
				clickOnButton(driver, moreOptionButton, moreOptionContent, true);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				javascript(driver, jscriptToMouseHover, returnElement(moreOptionSelect, dynamicName, copyContent));

				switch(option.toLowerCase()+"1") {

				case "copy1":

					/**		flag=clickOnButton(driver, returnElement(moreOptionSelect, dynamicName, copyContent), copyContent, flag);
					//	javascript(driver, jscriptToClick, returnElement(moreOptionSelect, dynamicName, copyContent));**/
					displayAndClick(driver, returnElement(moreOptionSelect, dynamicName, copyContent));
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					/**		isDisplayedInLoop(driver, 3, bulkCopyChangesTitle);	**/

					label="Copy Workflow/s";

					locator=bulkCopyChangesTitle;

					break;
				case "move1":

					/**	flag=clickOnButton(driver, returnElement(moreOptionSelect, dynamicName, moveContent), moveContent, flag);
					//	javascript(driver, jscriptToClick, returnElement(moreOptionSelect, dynamicName, moveContent));**/
					displayAndClick(driver, returnElement(moreOptionSelect, dynamicName, moveContent));
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					/**		isDisplayedInLoop(driver, 3, bulkMoveChangesTitle); **/

					label="Move Workflow/s";

					locator=bulkMoveChangesTitle;

					break;
				case "delete1":

					/**	flag=clickOnButton(driver, returnElement(moreOptionSelect, dynamicName, deleteContent), deleteContent, flag);
					//	javascript(driver, jscriptToClick, returnElement(moreOptionSelect, dynamicName, deleteContent));**/
					displayAndClick(driver, returnElement(moreOptionSelect, dynamicName, deleteContent));
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					/** 	isDisplayedInLoop(driver, 3, bulkDeleteChangesTitle); **/

					label="Delete Workflow/s";

					locator=bulkDeleteChangesTitle;

					break;

				default: 

					flag=false;
					break;

				}

				flag=validateMoreOptionButtonFunctionality(flag, locator, label, icedqUser);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnMoreOptionAndSelectOption ");
			flag=false;
		}
		return flag;
	}

	//choose workflow's tab in bulk changes
	public boolean chooseWorkflowsInBulkChanges(boolean flag, String workflowName) {

		try {isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		isDisplayedInLoop(driver, 3, bulkChangesChooseWorkflowTab);

		if(flag && isDisplayed(driver, bulkChangesChooseWorkflowTab) && !workflowName.isEmpty()) {

			BaseSuite.reportLog("Choose Workflows tab is visible");

			javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowNextbutton);

			verifyVisibilityOfButtons(driver, bulkChangesChooseWorkflowRemovebutton, removeContent, false);
			verifyVisibilityOfButtons(driver, bulkChangesChooseWorkflowCancelbutton, cancelContent, true);
			verifyVisibilityOfButtons(driver, bulkChangesChooseWorkflowNextbutton, nextContent, true);

			javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowTab);

			verifyIndividualLabel(driver, returnElement(bulkChangesChooseWorkflowColumn, dynamicName, "Workflow Name"), "Workflow Name column");
			verifyIndividualLabel(driver, returnElement(bulkChangesChooseWorkflowColumn, dynamicName, descriptionContent), "Description column");
			verifyIndividualLabel(driver,  returnElement(bulkChangesChooseWorkflowColumn, dynamicName, folderContent), "Folder column");

			String [] workflow=workflowName.split(";");

			for(int i=0;i<workflow.length;i++) {

				String [] wkfl = workflow[i].split(",");
				String  wkflName = wkfl[0];
				String  wkflFolderName = wkfl[1];

				flag=searchFunctionalityMethod(driver, flag, bulkChangesChooseWorkflowSearchbar, bulkChangesChooseWorkflowSearchbutton, searchBoxLabel, workflowSearchPlaceholder, wkflName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName));

				if(isDisplayed(driver, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName))) {

					BaseSuite.reportLog("clicking on workflow name checkbox !!");

					selectcheckbox(driver, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName),wkflName);

				}else {
					BaseSuite.reportFailLog("Expected workflow not found kindly check ","chooseWorkflowsInBulkChanges");
				}
			}

			javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowSearchbar);

			displayAndClick(driver, bulkChangesChooseWorkflowSearchbar);

			clear_Click_SendKeys(driver, 0, bulkChangesChooseWorkflowSearchbar, "");

			displayAndClick(driver, bulkChangesChooseWorkflowSearchbutton);


			javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowNextbutton);

			flag=clickOnButton(driver, bulkChangesChooseWorkflowNextbutton, nextContent, true);


		}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" chooseWorkflowsInBulkChanges ");
			flag=false;
		}
		return flag;
	}

	//choose destination tab in bulk changes
	public boolean chooseDestinationInBulkChanges(boolean flag, String folderPath) {
		Actions action = new Actions(driver);
		try {isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		isDisplayedInLoop(driver, 3, bulkChangesChooseDestinationTab);

		if(flag && isDisplayed(driver, bulkChangesChooseDestinationTab) && !folderPath.isEmpty()) {

			BaseSuite.reportLog("Choose Destination tab is visible");

			javascript(driver, scrollToElementArg, bulkChangesChooseDestinationNextbutton);

			verifyVisibilityOfButtons(driver, bulkChangesChooseDestinationCancelbutton, cancelContent, true);
			verifyVisibilityOfButtons(driver, bulkChangesChooseDestinationPreviousbutton, previousContent, true);
			verifyVisibilityOfButtons(driver, bulkChangesChooseDestinationNextbutton, nextContent, false);

			javascript(driver, scrollToElementArg, bulkChangesChooseDestinationTab);

			verifyIndividualLabel(driver, bulkChangesChooseDestinationFolderTitle, "Folder");

			flag=searchFunctionalityMethod(driver, flag, bulkChangesChooseDestinationSearchbar, bulkChangesChooseDestinationSearchbutton, searchBoxLabel, searchPlaceholder, folderPath);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {

				WebElement ele = driver.findElement(returnElement(bulkChangesChooseDestinationFolderName, dynamicName, folderPath));
				WebElement ele1 = driver.findElement(returnElement(bulkChangesChooseDestinationFolderSelect, dynamicName, folderPath));
				if(ele.isDisplayed()) {
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					action.moveToElement(ele1).click().perform();

					javascript(driver, scrollToElementArg, bulkChangesChooseDestinationNextbutton);

					flag=clickOnButton(driver, bulkChangesChooseDestinationNextbutton, nextContent, true);
				}else {
					BaseSuite.reportFailLog("Expected folder not found kindly check ","chooseDestinationInBulkChanges");
				}
			}

		}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" chooseDestinationInBulkChanges ");

			flag=false;
		}
		return flag;
	}

	//review tab in bulk changes
	public boolean reviewInBulkChanges(boolean flag, String expectedMsg,String icedqUser) {

		try {isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		isDisplayedInLoop(driver, 3, bulkChangesReviewTab);

		if(flag && isDisplayed(driver, bulkChangesReviewTab)) {

			BaseSuite.reportLog("Review tab is visible");

			javascript(driver, scrollToElementArg, bulkChangesReviewCancelbutton);

			verifyVisibilityOfButtons(driver, bulkChangesReviewCancelbutton, cancelContent, true);
			verifyVisibilityOfButtons(driver, bulkChangesReviewPreviousbutton, previousContent, true);
			verifyVisibilityOfButtons(driver, bulkChangesReviewNextbutton, nextContent, true);

			javascript(driver, scrollToElementArg, bulkChangesReviewTab);

			if(!expectedMsg.isEmpty()) {

				String reviewCon=getAttribute(driver, bulkChangesReviewContent, attributeTextContent);

				flag=stringContainsOutput(reviewCon, expectedMsg, flag);

			}
			if(flag) {
				javascript(driver, scrollToElementArg, bulkChangesReviewNextbutton);

				flag=clickOnButton(driver, bulkChangesReviewNextbutton, nextContent, true);

				if(icedqUser.toLowerCase().contains("executor") || icedqUser.toLowerCase().contains("reader") ) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "bulk operation");
				}
				else if(isDisplayed(driver, toastMsg)) {
					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "Not expected", "bulk operation");
				}
			}
		}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" reviewInBulkChanges ");
			flag=false;
		}
		return flag;
	}

	//progress tab in bulk changes
	public boolean progressInBulkChanges(boolean flag) {

		try {isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		isDisplayedInLoop(driver, 3, bulkChangesProgressTab);

		if(flag && isDisplayed(driver, bulkChangesProgressTab)) {

			BaseSuite.reportLog("Review tab is visible");

			javascript(driver, scrollToElementArg, bulkChangesProgressDoneButton);

			verifyVisibilityOfButtons(driver, bulkChangesProgressDoneButton, "Done", true);

			javascript(driver, scrollToElementArg, bulkChangesProgressTab);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver, bulkChangesProgressRefreshIcon)) {

				displayAndClick(driver, bulkChangesProgressRefreshIcon);
			}

			verifyVisibilityOfButtons(driver, bulkChangesProgressShareIcon, "Share icon", true);

			verifyVisibilityOfButtons(driver, bulkChangesProgressRefreshIcon, "Refresh icon", true);

			BaseSuite.reportLog("checking bulk changes progress percentage... ");

			if(isDisplayed(driver, bulkChangesProgressPercentage)) {

				String percent = getAttribute(driver, bulkChangesProgressPercentage, attributeTextContent);

				BaseSuite.reportLog("Bulk changes Percentage is :: "+percent);

			}

			verifyIndividualLabel(driver, bulkChangesProgressLogDetailsTitle, "Logs Details");

			BaseSuite.reportLog("-------------- checking bulk changes logs... ");

			String progCon = getAttribute(driver, bulkChangesProgressLogContent, attributeInnertext);

			if(!progCon.isEmpty()) {

				String [] bulklog = progCon.split("\n");

				for(int i=0;i<bulklog.length;i++) {

					BaseSuite.reportLog(bulklog[i]);

				}

			}else {

				BaseSuite.reportFailLog("Progress logs not visible, https://icedqsoft.atlassian.net/browse/DAT-7343", "progressInBulkChanges");

			}

			javascript(driver, scrollToElementArg, bulkChangesProgressDoneButton);

			flag=clickOnButton(driver, bulkChangesProgressDoneButton, "Done", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" progressInBulkChanges ");

			flag=false;
		}
		return flag;
	}

	public int getLocatorIsDisplayCount(int x,By locator) {

		if(isDisplayed(driver, locator)) {

			x++;
		}
		return x;
	}


	public int searchAndSelectWorkflowFromFolder(boolean flag, String workflowName, int x) {

		try {
			String [] workflow = workflowName.split(";");

			for(int i=0;i<workflow.length;i++) {

				String value = workflow[i];
				String [] wkfl = value.split(",");
				String  wkflName = wkfl[0];
				String  wkflFolderName = wkfl[1];

				flag=searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, searchBoxLabel, workflowSearchPlaceholder, wkflName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForLoaderToDisapper(driver);

				selectcheckbox(driver, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, wkflFolderName),  "Name:-"+wkflName+"& folder:-"+wkflFolderName);

				x = getLocatorIsDisplayCount(x, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, wkflFolderName));
			}

			/**		searchFunctionalityMethod(flag, workflowSearchField, workflowSearchButton, searchBoxLabel, workflowSearchPlaceholder, "");**/

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndSelectWorkflowFromFolder ");
		}

		return x;
	}

	public boolean searchAndValidateWorkflowFromFolder(boolean flag, String workflowName, String operationType,String folderPath) {

		try {
			String [] workflow = workflowName.split(";");

			for(int i=0;i<workflow.length;i++) {

				String value = workflow[i];
				String [] wkfl = value.split(",");
				String  wkflName = wkfl[0];
				String  wkflFolderName = wkfl[1];

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, searchBoxLabel, workflowSearchPlaceholder, wkflName);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				switch(operationType.toLowerCase().trim()) {

				case "copy":
				case "move":	

					isDisplayedInLoop(driver, 2, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, folderPath));

					if(isDisplayed(driver, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, folderPath))) {

						BaseSuite.validationReportLog("Workflow "+operationType+" successfully to folder : "+folderPath+",Name : "+wkflName+"  Folder : "+folderPath);
					}else {
						BaseSuite.reportFailLog("Workflow not "+operationType+" to folder : "+folderPath+",Name : "+wkflName+"  Folder : "+folderPath, "searchAndValidateWorkflowFromFolder");
						flag=false;
					}

					break;

				case "delete":	

					isDisplayedInLoop(driver, 2, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, wkflFolderName));

					if(!isDisplayed(driver, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, wkflFolderName))) {

						BaseSuite.validationReportLog("Workflow deleted successfully, Name : "+wkflName+" Folder : "+wkflFolderName);
					}else {
						BaseSuite.reportFailLog("Workflow not deleted , Name : "+wkflName+" Folder : "+wkflFolderName, "searchAndValidateWorkflowFromFolder");
						flag=false;
					}

					break;

				default :
					break;
				}

				searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, searchBoxLabel, workflowSearchPlaceholder, "");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchAndValidateWorkflowFromFolder ");
			flag=false;
		}

		return flag;
	}




	//bulk copy workflow
	public boolean bulkCopyWorkflowFunctionality(boolean flag, String workflowName, String folderPath, String reviewContent, String icedqUser) {
		int x=0;
		log.info(reviewContent);
		try {
			if(flag && !workflowName.isEmpty()) {
				BaseSuite.reportLog("------- Copying Workflows to folder : "+folderPath);

				x=searchAndSelectWorkflowFromFolder(flag, workflowName, x);

				if(x>0) {

					flag=clickOnMoreOptionAndSelectOption(flag, copyContent,icedqUser);

					if(!icedqUser.toLowerCase().contains(executorContent) && !icedqUser.toLowerCase().contains(readerContent)) {

						selectFolderToBulkChanges(flag, folderPath);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateBulkChangesNotify(x, copyContent, folderPath);

						clickOnButton(driver, bulkChangesCopyButton, copyContent, true);

						validateProgressOfBulkChanges(flag);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, bulkChangesDoneButton, "Done", true);

						flag=searchAndValidateWorkflowFromFolder(true, workflowName, "copy", folderPath);


					}
				}else if(x==0) {
					throw new SkipException(ConstantProperty.TESTCASE_SKIP+"bulkCopyWorkflowFunctionality");
				}


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkCopyWorkflowFunctionality ");
			flag=false;
		}

		return flag;
	}

	//bulk more workflow
	public boolean bulkMoveWorkflowFunctionality(boolean flag, String workflowName, String folderPath, String reviewContent, String icedqUser) {
		int x=0;
		log.info(reviewContent);
		try {
			if(flag && !workflowName.isEmpty()) {
				BaseSuite.reportLog("------- Moving Workflows to folder : "+folderPath);

				x=searchAndSelectWorkflowFromFolder(flag, workflowName, x); 

				if(x>0 ) {

					flag=clickOnMoreOptionAndSelectOption(flag, moveContent,icedqUser);

					if(!icedqUser.toLowerCase().contains(executorContent) && !icedqUser.toLowerCase().contains(readerContent)) {

						selectFolderToBulkChanges(flag, folderPath);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateBulkChangesNotify(x, moveContent, folderPath);

						clickOnButton(driver, bulkChangesMoveButton, moveContent, true);

						validateProgressOfBulkChanges(flag);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, bulkChangesDoneButton, "Done", true);

						flag=searchAndValidateWorkflowFromFolder(true, workflowName, "move", folderPath);

					}
				}else if(x==0) {
					throw new SkipException(ConstantProperty.TESTCASE_SKIP+"bulkMoveWorkflowFunctionality");
				}


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkMoveWorkflowFunctionality ");
			flag=false;
		}

		return flag;
	}

	//bulk more workflow
	public boolean bulkDeleteWorkflowFunctionality(boolean flag, String workflowName, String reviewContent,String icedqUser) {
		int x=0;
		log.info(reviewContent);
		try {
			if(flag && !workflowName.isEmpty()) {
				BaseSuite.reportLog("------- Deleting Workflows  : ");

				x=searchAndSelectWorkflowFromFolder(flag, workflowName, x);

				if(x>0) {

					flag=clickOnMoreOptionAndSelectOption(flag, deleteContent,icedqUser);

					if(!icedqUser.toLowerCase().contains(executorContent) && !icedqUser.toLowerCase().contains(readerContent)) {

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						validateBulkChangesNotify( x, deleteContent, "");

						clickOnButton(driver, bulkChangesDeleteButton, deleteContent, true);

						validateProgressOfBulkChanges(flag);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, bulkChangesDoneButton, "Done", true);

						flag=searchAndValidateWorkflowFromFolder(true, workflowName, deleteContent, "");


					}
				}else if(x==0) {
					throw new SkipException(ConstantProperty.TESTCASE_SKIP+"bulkDeleteWorkflowFunctionality");
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkDeleteWorkflowFunctionality ");
			flag=false;
		}

		return flag;
	}

	public boolean validatePopupWindowContent(boolean flag, By titleLocator, By contentLocator, String title, String content) {

		if(flag) {
			String removetitle = getText(driver, titleLocator);

			flag = stringContainsOutput(removetitle, title, true);

			if(flag) {

				String removecontents = getText(driver, contentLocator);

				flag = stringContainsOutput(removecontents, content, true);

			}
		}
		return flag;
	}

	//validate and handle delete workflow pop up window
	public boolean validateAndHandleRemoveWorkflowPopupWindow(boolean flag, int count, String buttonName) {

		try {
			isDisplayedInLoop(driver, 3, bulkChangesRemoveWorkflowPopupTitle);

			if(flag && isDisplayed(driver, bulkChangesRemoveWorkflowPopupTitle)) {

				BaseSuite.reportLog("Remove popup window is visible");

				if(count>1) {
					validatePopupWindowContent(flag, bulkChangesRemoveWorkflowPopupTitle, bulkChangesRemoveWorkflowPopupContent, bulkChangesMultipleWorkflowRemoveTitle, bulkChangesMultipleWorkflowRemoveContent);
				}else {
					validatePopupWindowContent(flag, bulkChangesRemoveWorkflowPopupTitle, bulkChangesRemoveWorkflowPopupContent, bulkChangesSingleWorkflowRemoveTitle, bulkChangesSingleWorkflowRemoveContent);
				}		
				switch (buttonName.toLowerCase().trim()) {
				case "remove":

					flag=clickOnButton(driver, bulkChangesRemoveWorkflowPopupRemovebtn, removeContent, true);

					break;

				case "cancel":

					flag=clickOnButton(driver, bulkChangesRemoveWorkflowPopupCancelbtn, cancelButtonContent, true);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleRemoveWorkflowPopupWindow ");
			flag=false;
		}
		return flag;
	}

	//remove workflow from bulk changes
	public boolean removeWorkflowOnWorkflowDetailsPage(boolean flag, int count) {

		try {
			if(flag) {
				flag=clickOnButton(driver, bulkChangesChooseWorkflowRemovebutton, removeContent, true);

				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "", "Remove Workflow");

				}else {

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(flag) {
						validateAndHandleRemoveWorkflowPopupWindow(flag, count ,removeContent);
					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeWorkflowOnWorkflowDetailsPage ");
			flag=false;
		}

		return flag;
	}	

	// Handles clicking the "New Rule" button inside workflow details
	public String clickOnNewRuleInWorkflowDetails(boolean flag, boolean addRule, String icedqUser) {
		String mainWindow = null;
		boolean state = true;
		final String methodName = "clickOnNewRuleInWorkflowDetails";

		try {
			// Wait for New Rule button
			isDisplayedInLoop(driver, 3, workflowDetailsNewRuleButton);

			if (!flag || !isDisplayed(driver, workflowDetailsNewRuleButton)) {
				return null;
			}

			// Click on New Rule button
			flag = clickOnButton(driver, workflowDetailsNewRuleButton, "New Rule", true);
			if (!flag) return null;

			mainWindow = getWindowHandle(driver);
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			// Wait for any background spinners
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 0, toastMsg);

			// Handle different UI conditions based on user role
			if (isDisplayed(driver, toastMsg) || isRestrictedUser(icedqUser)) {
				
				state = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Add New Rule");

				closeCurrentTabAndSwitchToMain(driver, mainWindow);
				
			} else if (isDisplayed(driver, workflowDetailsNewWindowAddNewRuleTitle)) {
				BaseSuite.validationReportLog("Add New Rule pane is visible");

			} else {
				BaseSuite.reportFailLog("Add New Rule pane is not visible", methodName);
			}

			// If rule shouldn't be added, close the tab and return
			if (!addRule) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				closeCurrentTabAndSwitchToMain(driver, mainWindow);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " " + methodName);
		} finally {
			setStatus(state);
		}

		return mainWindow;
	}

	private boolean isRestrictedUser(String icedqUser) {
		String user = icedqUser.toLowerCase();
		return user.contains(readerContent) || user.contains(executorContent);
	}

	public static void setStatus(boolean state) {
		ConstantProperty.fLAG=state;
	}

	//verify workflow exception report downloaded file location
	public boolean verifyWorkflowExceptionReportDownloadedFile(boolean flag, String workflowId, String instanceId, String downloadType, String exportFormat) {
		try {String path="";
		if(flag) {
			BaseSuite.reportLog("Getting Downloaded Exception Report File path... ");

			waitForExecution(3000);

			if(BaseSuite.browserName.equalsIgnoreCase("remote")) {
				path=LINUXFOLDERPATH;

			}else {
				path=dirPath + File.separator + "src" + File.separator + "Downloads" + File.separator;
			}
			String fileName="R_" + workflowId + "_" + instanceId.trim() + "_" + downloadType + "." + exportFormat.trim().toLowerCase();
			File f = new File(path + fileName);
			if (f.exists()) {
				BaseSuite.validationReportLog("Downloaded Exception report file location  : " + f.getAbsolutePath());

			} else if(!BaseSuite.browserName.equalsIgnoreCase("remote")){
				BaseSuite.reportFailLog("File not found kindly check path : " + f.getAbsolutePath(), "verifyWorkflowExceptionReportDownloadedFile");
			}
		}
		} catch (Exception e) {	
			BaseSuite.reportErrorLog(e,errorLogTitle+" verifyWorkflowExceptionReportDownloadedFile ");

			flag=false;
		}
		return flag;
	}

	//download workflow exception report ZIP folder 
	public boolean downloadExceptionReportInWorkflow(boolean flag, String workflowId, String instanceId, String downloadType, String exportFormat,boolean download) {

		try {
			By locator = returnElement(recentRunsDownloadIconbyInstanceId, dynamicName, instanceId);
			isDisplayedInLoop(driver, 1, locator);
			if(flag && isDisplayed(driver, locator)) {

				String dercls = getAttribute(driver, locator, attributeClass);

				if(dercls.contains("dis_icon")) {
					BaseSuite.reportLog("Download Exception report icon is disabled");
				}

				flag=isClickable(driver, locator, "Download Exception Report", flag);

				if(flag && download) {
					BaseSuite.reportLog("Clicking on download icon...");

					displayAndClick(driver, locator);

					BaseSuite.reportLog("Clicked on download icon successfully");

					flag=verifyWorkflowExceptionReportDownloadedFile(flag, workflowId, instanceId, downloadType, exportFormat);

				}

			}
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" downloadExceptionReportInWorkflow ");
			flag=false;
		}
		return flag;

	}

	//get workflow id from workflow details page
	public String getWorkflowIdOnWorkflowDetailsPage() {
		String id =null;
		try {
			isDisplayedInLoop(driver, 3, workflowBreadcrumbWorkflowId);

			if(isDisplayed(driver, workflowBreadcrumbWorkflowId)) {

				id = getText(driver, workflowBreadcrumbWorkflowId);

				id = id.replaceAll(regexToRemoveBracess, "");

				BaseSuite.reportLog("Workflow id is :: "+id);
			}else {
				BaseSuite.reportFailLog("Workflow id is not visible ", "getWorkflowIdOnWorkflowDetailsPage");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getWorkflowIdOnWorkflowDetailsPage ");

		}
		return id;
	}


	//search recent run on recent runs 
	public boolean searchRecentRunOnRecentRunsField(boolean flag, String instanceid) {

		return searchFunctionalityMethod(driver, flag, workflowDetailsRecentRunSearchBar, workflowDetailsRecentRunSearchBtn, "Recent Runs "+searchBoxLabel, recentRunsSearchPlaceholder, instanceid);
	}

	//click on stop execution and validate stop execution window
	public boolean clickOnStopExecution(boolean flag, String instaceId) {

		try {
			By locator = returnElement(recentRunsStopExecutionIconbyInstanceId, dynamicName, instaceId);

			isDisplayedInLoop(driver, 3, locator);

			if(flag && isDisplayed(driver, locator)) {

				BaseSuite.reportLog("clicking on stop execution icon of instance id : "+instaceId);

				javascript(driver, scrollToElementArg, locator);

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog("clicked on stop execution icon");

				isDisplayedInLoop(driver, 3, workflowDetailsRecentRunsStopExecutionPopUpTitle);

				if(isDisplayed(driver, workflowDetailsRecentRunsStopExecutionPopUpTitle)) {

					BaseSuite.reportLog("Stop Execution popup window is visible");

					flag=validatePopupWindowContent(flag, workflowDetailsRecentRunsStopExecutionPopUpTitle, workflowDetailsRecentRunsStopExecutionPopUpContent, recentRunsStopExecutionPopupTitle, recentRunsStopExecutionPopupContent);

					if(flag) {
						verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsStopExecutionPopUpCancelBtn, cancelContent, true);
						verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsStopExecutionPopUpStopBtn, stopContent, true);

						flag=clickOnButton(driver, workflowDetailsRecentRunsStopExecutionPopUpStopBtn, stopContent, true);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(isDisplayed(driver, toastMsg)) {
						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "","Stop execution");
					}
				}else {
					BaseSuite.reportFailLog("Stop Execution popup window is not visible ", "clickOnStopExecution");

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnStopExecution ");
			flag=false;

		}
		return flag;

	}

	public String getExecutionStatusByInstanceId(String instaceId) {

		String state =null;

		try {
			isDisplayedInLoop(driver, 3, returnElement(recentRunsStatusByInstanceId, dynamicName, instaceId));
			if(isDisplayed(driver, returnElement(recentRunsStatusByInstanceId, dynamicName, instaceId))) {

				state = getText(driver, returnElement(recentRunsStatusByInstanceId, dynamicName, instaceId));

				BaseSuite.reportLog("Execution status of Instance ID : "+instaceId+" is :: "+state);


			}else {
				BaseSuite.reportFailLog("Status not visible ", "getExecutionStatusByInstanceId");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getExecutionStatusByInstanceId ");

		}
		return state;
	}

	public String getExecutionStatusByRuleInstanceId(String instaceId) {

		String state =null;

		try {

			By locator = returnElement(workflowDetailsRecentRunRuleInstanceIdStatus, dynamicName, instaceId);

			isDisplayedInLoop(driver, 3, locator);
			if(isDisplayed(driver, locator)) {

				state = getText(driver, locator);

				BaseSuite.reportLog("Execution status of Rule Instance ID : "+instaceId+" is :: "+state);


			}else {
				BaseSuite.reportFailLog("Rule Status not visible ", "getExecutionStatusByRuleInstanceId");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getExecutionStatusByRuleInstanceId ");

		}
		return state;
	}

	public void checkRunButtonOfWorkflow(boolean isActive) {

		verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, isActive);

	}

	//view workflow and validate fields
	public boolean viewWorkflowDetailsWithStatus(String workflowJsonEntity, boolean isActive, String icedqUser) {

		boolean flag =true;

		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbHomeLink, homeContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbWorkflowsLink, workflowContent, flag);

			verifyIndividualLabel(driver, returnElement(workflowBreadcrumbFolderName, dynamicName, workflowParam.getWorkflowfolderName()), workflowParam.getWorkflowfolderName()+"folder name breadcrumb");

			verifyIndividualLabel(driver, returnElement(workflowNameTitle, dynamicName, workflowParam.getWorkflowName()), workflowParam.getWorkflowName());

			flag=validateFolderSearchSideBar(flag);

			validateRuleOnWorkflowDetailsPage(flag);

			if(!icedqUser.contains(readerFlag)) {

				if(workflowParam.getWorkflowState().equalsIgnoreCase("Published")) {

					checkRunButtonOfWorkflow(isActive);

					verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, false);

					verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

					verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

					verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);
				}else {

					verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

					verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, true);

					verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

					verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

					verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);


				}
			}

			verifyVisibilityOfButtons(driver, workflowDetailsOverviewTab, overviewContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsRuleAndDatasetsTab, rulesContent, true);

			clickOnButton(driver, workflowDetailsOverviewTab, overviewContent, true);

			viewAndValidateField(workflowDetailsWorkflowNameField, fieldWorkflowName, workflowParam.getWorkflowName(), true);

			viewAndValidateField(workflowDetailsWorkflowCodeField, workflowCodeContent, workflowParam.getWorkflowCode(), true);

			viewAndValidateField(workflowDetailsDescriptionField, workflowDescriptionContent, workflowParam.getWorkflowDescription(), true);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickonWorkflowRulesAndDatasetTab(flag);

			validateRulesAndDatasetsFields();

			List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

			validateAddedRuleInWorkflow(flag, ruleList, workflowJsonEntity);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(true);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" viewWorkflowDetailsWithStatus ");

			flag=false;
		}
		return flag;
	}


	//workflow execution details expand 
	public boolean clickOnExpandArrowToWorkflowInstanceId(boolean flag,String instanceId) {

		Actions action = new Actions(driver);
		try {

			/**	isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);**/
			isDisplayedInLoop(driver,3, returnElement(workflowExecutionCollapseArrow, dynamicName, instanceId));
			if(isDisplayed(driver, returnElement(workflowExecutionCollapseArrow, dynamicName, instanceId))) {
				BaseSuite.reportLog("Expanded workflow execution details pane");
			}else {
				javascript(driver, scrollToElementArg, returnElement(workflowExecutionExpandArrow,  dynamicName, instanceId));

				isDisplayedInLoop(driver, 3, returnElement(workflowExecutionExpandArrow, dynamicName, instanceId));

				if(isDisplayed(driver, returnElement(workflowExecutionExpandArrow, dynamicName, instanceId))) {

					javascript(driver, scrollToElementArg, returnElement(workflowExecutionExpandArrow,  dynamicName, instanceId));

					action.moveToElement(driver.findElement(returnElement(workflowExecutionExpandArrow,  dynamicName, instanceId))).click().perform();

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Workflow Execution details expand arrow not visible", "clickOnExpandArrowToWorkflowInstanceId");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnExpandArrowToWorkflowInstanceId ");

			flag=false;
		}
		return flag;
	}

	//workflow execution details collapse 
	public boolean clickOnCollapseArrowToWorkflowInstanceId(boolean flag,String instanceId) {
		Actions action = new Actions(driver);
		try {
			isDisplayedInLoop(driver,5,  returnElement(workflowExecutionExpandArrow, dynamicName, instanceId));
			if(isDisplayed(driver, returnElement(workflowExecutionExpandArrow, dynamicName, instanceId))) {
				BaseSuite.reportLog(" ");
			}else {

				isDisplayedInLoop(driver, 3, returnElement(workflowExecutionCollapseArrow, dynamicName, instanceId));

				if(isDisplayed(driver, returnElement(workflowExecutionCollapseArrow, dynamicName, instanceId))) {

					javascript(driver, scrollToElementArg, returnElement(workflowExecutionCollapseArrow,  dynamicName, instanceId));

					/**					BaseSuite.reportLog("Collapsing workflow execution details pane of instance id : "+instanceId);**/

					action.moveToElement(driver.findElement(returnElement(workflowExecutionCollapseArrow,  dynamicName, instanceId))).click().perform();

					/**					BaseSuite.reportLog("Collapsed workflow execution details pane");**/

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Workflow Execution details collapse arrow not visible", "clickOnCollapseArrowToWorkflowInstanceId");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnCollapseArrowToWorkflowInstanceId ");

			flag=false;
		}
		return flag;
	}

	//workflow execution details expand 
	public boolean clickOnExpandArrowToRuleInstanceId(boolean flag,String instanceId) {
		Actions action = new Actions(driver);
		try {
			waitForElement(driver, returnElement(workflowExecutionRuleExpand, dynamicName, instanceId));
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 3, returnElement(workflowExecutionRuleExpand, dynamicName, instanceId));

			javascript(driver, scrollToElementArg, returnElement(workflowExecutionRuleExpand,  dynamicName, instanceId));

			isDisplayedInLoop(driver, 3, returnElement(workflowExecutionRuleExpand, dynamicName, instanceId));

			if(isDisplayed(driver, returnElement(workflowExecutionRuleExpand, dynamicName, instanceId))) {

				javascript(driver, scrollToElementArg, returnElement(workflowExecutionRuleExpand,  dynamicName, instanceId));

				/**		BaseSuite.reportLog("Expanding rule execution details pane of instance id : "+instanceId);**/

				action.moveToElement(driver.findElement(returnElement(workflowExecutionRuleExpand,  dynamicName, instanceId))).click().perform();
				/**		BaseSuite.reportLog("Expanded rule execution details pane"); **/

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog(instanceId+" instance id of rule Execution details expand arrow not visible", "clickOnExpandArrowToRuleInstanceId");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnExpandArrowToRuleInstanceId ");

			flag=false;
		}
		return flag;
	}

	//workflow execution details collapse 
	public boolean clickOnCollapseArrowToRuleInstanceId(boolean flag,String instanceId) {
		Actions action = new Actions(driver);
		try {
			isDisplayedInLoop(driver, 3, returnElement(workflowExecutionRuleCollapse, dynamicName, instanceId));

			if(isDisplayed(driver, returnElement(workflowExecutionRuleCollapse, dynamicName, instanceId))) {

				javascript(driver, scrollToElementArg, returnElement(workflowExecutionRuleCollapse,  dynamicName, instanceId));

				BaseSuite.reportLog("Collapsing rule execution details pane of instance id : "+instanceId);

				action.moveToElement(driver.findElement(returnElement(workflowExecutionRuleCollapse,  dynamicName, instanceId))).click().perform();

				BaseSuite.reportLog("Collapsed rule execution details pane");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}else {
				BaseSuite.reportFailLog("rule Execution details collapse arrow not visible", "clickOnCollapseArrowToRuleInstanceId");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnCollapseArrowToRuleInstanceId ");

			flag=false;
		}
		return flag;
	}

	//get list of rule execution instance id
	public List<String> getRuleExecutionInstaceIdListFromWorkflow(boolean flag,String instanceId) {
		ArrayList<String> list = new ArrayList<>();
		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isDisplayedInLoop(driver, 3, returnElement(workflowExecutionRuleInstanceIdList, dynamicName, instanceId));

				List<WebElement> ruleInstanceId = getElements(driver, returnElement(workflowExecutionRuleInstanceIdList, dynamicName, instanceId));

				for(int i = 0;i<ruleInstanceId.size();i++) {

					String ruleinstanceid= ruleInstanceId.get(i).getText();

					list.add(ruleinstanceid);

				}
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				Collections.reverse(list);
				BaseSuite.reportLog("Rules instance Id List :: "+list);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRuleExecutionInstaceIdListFromWorkflow ");

		}
		return list;
	}


	public String getvaluefromField(By locator, String label, String attribute) {

		String value ="";
		try {
			isDisplayedInLoop(driver, 3, locator);

			scrollToElement(driver, locator);

			if(isDisplayed(driver, locator) || driver.findElement(locator).isDisplayed()) {

				javascript(driver, scrollToElementArg, locator);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				/**	value = getAttribute(driver, locator, attribute);**/

				value = driver.findElement(locator).getAttribute(attribute);

				value=checkNullValue(value);

				if(!value.isEmpty()) {
					BaseSuite.reportLog(label+" : "+value +visibleContent);
				}else {
					BaseSuite.reportLog(label+" : "+value);
				}
			}else {
				BaseSuite.reportFailLog(label+" not visible", "getvaluefromField");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getvaluefromField ");
		}
		return value.trim();

	}

	public boolean validateExecutionDetailsWindow(boolean flag) {
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 2, workflowExecutionDetailsTitle);
			if(isDisplayed(driver, workflowExecutionDetailsTitle)) {

				verifyIndividualLabel(driver, workflowExecutionDetailsTitle, "Execution Details title");

				if(isDisplayed(driver, workflowExecutionDetailsLogs)) {


					String logs = getAttribute(driver, workflowExecutionDetailsLogs, attributeValue);

					String [] exlog = logs.split("\n");

					StringBuilder codeBlock = new StringBuilder();

					for (String line : exlog) {
						codeBlock.append(line).append("\n");
					}

					BaseSuite.reportLog("------------------------ Execution Logs ------------------------");
					BaseSuite.reportCodeLog(codeBlock.toString()); // Logs the full block as code
					BaseSuite.reportLog("-----------------------------------------------------------------");


					flag=clickOnButton(driver, workflowExecutionDetailsCancelBtn, cancelButtonContent, true);


				}else {
					BaseSuite.reportFailLog("Rule execution details not visible", "validateExecutionDetailsWindow");
				}

			}else {
				BaseSuite.reportFailLog("Rule execution details title not visible", "validateExecutionDetailsWindow");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateExecutionDetailsWindow ");

			flag=false;
		}
		return flag;
	}


	//click on workflow execution details button
	public boolean clickOnRuleExecutionDetails(String ruleinstaceId) {
		boolean flag=true;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);waitForExecution(1000);

			BaseSuite.reportLog("------------------------ Rule execution logs ------------------------");

			javascript(driver, scrollToElementArg, returnElement(workflowExecutionRuleExecutionDetails, dynamicName, ruleinstaceId));

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, returnElement(workflowExecutionRuleExecutionDetails, dynamicName, ruleinstaceId), "Execution Details", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=validateExecutionDetailsWindow(flag);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnRuleExecutionDetails ");

			flag=false;
		}

		return flag;
	}

	public boolean clickOnRuleInstaceIdOnWorkflow(boolean flag, String ruleInstance, String ruleName, String rulestatus) {


		try {

			BaseSuite.reportLog("------------ verifying exception report of rule instance id : "+ruleInstance+" -------------");
			isDisplayedInLoop(driver, 1, returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstance));

			if(flag && isDisplayed(driver, returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstance))) {

				flag=clickOnButton(driver, returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstance),ruleInstance, flag);

				String mainWindow = getWindowHandle(driver);

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);waitForExecution(2000);

				isDisplayedInLoop(driver, 3, workflowExecutionReportRuleName);

				if(flag && isDisplayed(driver, workflowExecutionReportRuleName)) {

					String getRuleName = getAttribute(driver, workflowExecutionReportRuleName, attributeTextContent);

					BaseSuite.reportLog("Verifying name on execution report... ");

					stringContainsOutput(getRuleName, ruleName, flag);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(elementNotVisible(driver, workflowExecutionReportNotRecords)) {
						BaseSuite.reportLog("Exception report data is visible");
					}else if(rulestatus.trim().equalsIgnoreCase(successContent)){
						BaseSuite.reportLog("No Records to display is visible ");
					}else {
						BaseSuite.reportFailLog("No Records to display is visible for instance id :"+ruleInstance+" and rule name : "+ruleName, "clickOnRuleInstaceIdOnWorkflow");
					}

				}
				closeCurrentTabAndSwitchToMain(driver, mainWindow);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnRuleInstaceIdOnWorkflow ");

			flag=false;
		}

		return flag;
	}

	public void checkRuleExceptionReportDetailsAsPerStatus(List<String> ruleInstanceId, int i, String rulename, String ruletype, String rulestatus, String workflowName, boolean exceptionReport) {
		try {
			log.info(workflowName);

			boolean isNotChecksumOrScript = 
					!ruletype.equalsIgnoreCase(checksumContent) &&
					!ruletype.equalsIgnoreCase(scriptContent);

			boolean isNotErrorSkippedRunning = 
					!rulestatus.equalsIgnoreCase(errorStatusContent) &&
					!rulestatus.equalsIgnoreCase(skippedStatusContent) &&
					!rulestatus.equalsIgnoreCase(runningStatusContent);

			if (exceptionReport && isNotChecksumOrScript && isNotErrorSkippedRunning) {
				clickOnRuleInstaceIdOnWorkflow(true, ruleInstanceId.get(i), rulename, rulestatus);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " checkRuleExceptionReportDetailsAsPerStatus :: " + e.toString());
		}
	}

	//UI release 2.0
	public List<String> validateRuleDetailsOfRuleInstanceID(String ruleInstanceId) {
		List<String> infoList =new ArrayList<>();
		infoList.add(getvaluefromField(returnElement(workflowExecutionRuleName, dynamicName, ruleInstanceId),ruleNameContent,attributeTextContent));

		infoList.add(getvaluefromField(returnElement(workflowExecutionRuleType, dynamicName, ruleInstanceId), ruleTypeContent,attributeTitle));

		infoList.add(getvaluefromField(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId), sourceConnectionContent,attributeTextContent));

		infoList.add(getvaluefromField(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId), targetConnectionContent,attributeTextContent));

		infoList.add(getvaluefromField(returnElement(workflowExecutionRuleErrDesc, dynamicName, ruleInstanceId), "Error Description ",attributeTextContent));

		return infoList;
	}

	//new UI release 3.0
	public List<String> validateRecentRunForRuleInfo(String ruleInstanceId) {
		List<String> infoList =new ArrayList<>();

		BaseSuite.reportLog("-------- Rule instance id :: "+ruleInstanceId+"------------------");
		String infoLog="[RULE instance: "+ruleInstanceId+"] ";
		try {
			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstanceId), infoLog+" Instace ID "));

			infoList.add(getAttribute(driver, returnElement(workflowExecutionRuleInstanceIdRuleType, dynamicName, ruleInstanceId), attributeTitle));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceIdName, dynamicName, ruleInstanceId), infoLog+" Name "));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceStatus, dynamicName, ruleInstanceId), infoLog+"Status"));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceInstacetype, dynamicName, ruleInstanceId), infoLog+"Instace Type"));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceExitCode, dynamicName, ruleInstanceId), infoLog+"Exit Code"));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceElapsedTime, dynamicName, ruleInstanceId), infoLog+"Elapsed Time"));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceTriggeredDate, dynamicName, ruleInstanceId), infoLog+"Triggered Date"));

			infoList.add(getValueOfField(returnElement(workflowExecutionRuleInstanceTriggeredBy, dynamicName, ruleInstanceId),infoLog+ "Triggered By"));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRecentRunForRuleInfo ");
		}

		return infoList;

	}

	public void resultTypeOfRuleInstanceId(String ruleInstanceId) {
		if (ruleInstanceId == null || ruleInstanceId.trim().isEmpty()) {
			BaseSuite.reportLog("Provided ruleInstanceId is null or empty.");
			return;
		}

		List<String> resultTypes = new ArrayList<>();
		String resultSummary = "";

		try {
			By locator = returnElement(workflowExecutionRuleResultType, dynamicName, ruleInstanceId);

			if (isDisplayed(driver, locator)) {
				List<WebElement> elements = getElements(driver, locator);

				for (WebElement element : elements) {
					String title = element.getAttribute(attributeTitle);
					if (title != null && !title.isEmpty()) {
						resultTypes.add(title);
					}
				}

				if (!resultTypes.isEmpty()) {
					resultSummary = String.join(", ", resultTypes);
					BaseSuite.reportLog("Result Type: " + resultSummary + " " + visibleContent);
				} else {
					BaseSuite.reportLog("No result type titles found for ruleInstanceId: " + ruleInstanceId);
				}
			} else {
				BaseSuite.reportLog("result type not displayed for ruleInstanceId: " + ruleInstanceId);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error while getting resultTypeOfRuleInstanceId: " + e.toString());
		}
	}


	public void validateConnectionOnRecentRunsDetails(String ruleType, String seqNum,String ruleInstanceId) {

		BaseSuite.reportLog("------------ Validating Connections for Rule sequence : "+seqNum+" ------------");

		javascript(driver, scrollToElementArg, returnElement(workflowDetailsOverrideSourceCheck, dynamicNumber, seqNum));

		String sconnValue=getAttribute(driver, returnElement(workflowDetailsOverrideSourceCheck, dynamicNumber, seqNum), attributeTextContent);

		if(sconnValue.trim().isEmpty()) {
			sconnValue=getAttribute(driver, returnElement(workflowDetailsSourceCheck, dynamicNumber, seqNum), attributeTextContent);
		}

		String tconnValue=getAttribute(driver, returnElement(workflowDetailsOverrideTargetCheck, dynamicNumber, seqNum), attributeTextContent);

		if(tconnValue.trim().isEmpty()) {
			tconnValue=getAttribute(driver, returnElement(workflowDetailsTargetCheck, dynamicNumber, seqNum), attributeTextContent);
		}

		javascript(driver, scrollToElementArg, returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId));

		String actualSourceConnValue=driver.findElement(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId)).getAttribute(attributeTextContent);

		String actualTConnValue=driver.findElement(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId)).getAttribute(attributeTextContent);

		if(!ruleType.trim().equalsIgnoreCase(scriptContent)) {
			BaseSuite.reportLog("Validating Source connection");
			stringOutput(actualSourceConnValue, sconnValue, true);

			if(ruleType.trim().equalsIgnoreCase(reconContent) || ruleType.trim().equalsIgnoreCase(checksumContent)) {
				BaseSuite.reportLog("Validating Target connection");
				stringOutput(actualTConnValue, tconnValue, true);
			}else {
				stringOutput(actualTConnValue, "", true);
			}

		}else {
			stringOutput(actualSourceConnValue, "", true);
			stringOutput(actualTConnValue, "", true);
		}
	}

	public void validateErrorDescriptionOnInstanceRecentRuns(String ruleInstanceId, String ruleStatus, String expectedError) {
		String errMsg = "";

		try {
			BaseSuite.reportLog("Validating error description for rule instance id: " + ruleInstanceId);

			By locator = returnElement(workflowExecutionRuleErrDesc, dynamicName, ruleInstanceId);

			if (isDisplayed(driver, locator)) {
				errMsg = getAttribute(driver, locator, attributeTextContent);
			} else {
				BaseSuite.reportLog("Error description not found for rule instance: " + ruleInstanceId);
			}

			if (ruleStatus != null && ruleStatus.equalsIgnoreCase(successStatusContent)) {
				if (errMsg != null) {
					stringOutput(errMsg.trim(), expectedError, true);
				} else {
					BaseSuite.reportLog("No error message present to validate.");
				}
			} else {
				BaseSuite.reportLog("Rule not in success status (" + ruleStatus + "), skipping validation. Error description: " + errMsg);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "validateErrorDescriptionOnInstanceRecentRuns :: " + e.toString());
		}
	}


	public void validateConnectionOnInstanceRecentRuns(By locator, String ruleInstanceId,String label) {
		String value="";

		BaseSuite.reportLog("Validating "+label+" for rule instance id : "+ruleInstanceId);

		if(isDisplayed(driver, locator)) {
			value=getAttribute(driver, locator, attributeTextContent);
		}

		value=checkNullValue(value);

		if(!value.isEmpty()) {
			BaseSuite.reportLog(label+" : "+value +visibleContent);
		}else {
			BaseSuite.reportLog(label+" : "+value);
		}

	}

	public void validateRuleDetailsUsingInstanceId(String ruleInstanceId,String ruleStatus) {

		resultTypeOfRuleInstanceId(ruleInstanceId);

		getvaluefromField(returnElement(workflowExecutionRuleEngineType, dynamicName, ruleInstanceId), "Engine Type",attributeTextContent);

		validateConnectionOnInstanceRecentRuns(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId),ruleInstanceId, sourceConnectionContent);

		validateConnectionOnInstanceRecentRuns(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId),ruleInstanceId, targetConnectionContent);

		getvaluefromField(returnElement(workflowExecutionRuleContext, dynamicName, ruleInstanceId), "Context",attributeTextContent);

		getvaluefromField(returnElement(workflowExecutionRuleMode, dynamicName, ruleInstanceId), "Mode",attributeTextContent);

		validateErrorDescriptionOnInstanceRecentRuns(ruleInstanceId, ruleStatus, "");

	}

	public void checkHyperLinkOrNot(By locator, String label, boolean state) {

		try {
			isDisplayedInLoop(driver, 3, locator);

			if(state) {

				if(isDisplayed(driver, locator)) {

					BaseSuite.validationReportLog(label+" is has hyperlink");
				}else {

					BaseSuite.reportFailLog(label+" is not a hyperlink","checkHyperLinkOrNot");

				}
			}else {

				if(!isDisplayed(driver, locator)) {

					BaseSuite.validationReportLog(label+" is not a hyperlink");
				}else {

					BaseSuite.reportFailLog(label+" is has hyperlink","checkHyperLinkOrNot");

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkHyperLinkOrNot ");
		}

	}

	public void validateInstanceIdHyperlink(String ruleType, String ruleInstanceId, String ruleStatus) {
		String ruleLog="Rule instance id : ";
		try {
			BaseSuite.reportLog("Checking rule instance id hyperlink for rule type : "+ruleType);

			if ((!ruleStatus.trim().equalsIgnoreCase(stringSubmitted) && !ruleStatus.trim().equalsIgnoreCase(skippedStatusContent) && !ruleStatus.trim().equalsIgnoreCase(runningStatusContent))) {


				checkHyperLinkOrNot(
						returnElement(workflowExecutionRuleInstanceIdHyperLink, dynamicName, ruleInstanceId),
						ruleLog + ruleInstanceId, !(ruleType.equalsIgnoreCase(checksumContent) || ruleType.equalsIgnoreCase(scriptContent)));

			}else {
				checkHyperLinkOrNot(
						returnElement(workflowExecutionRuleInstanceIdHyperLink, dynamicName, ruleInstanceId),
						ruleLog + ruleInstanceId, false);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateInstanceIdHyperlink ");
		}
	}


	public boolean validateRecentRunsForSinglePage(String pageNum,Boolean flag,String instaceId,String logs,String workflowName,boolean exceptionReport) {
		String ruletype="";
		String rulename="";
		String status="";
		List<String> ruleInfo=null;

		try {

			BaseSuite.reportLog(" ------------- Validating Rule instances on page number : "+pageNum+" --------------- ");

			List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(flag, instaceId);

			/**	getInstanceTable(ruleInstanceId);**/

			rulesConfigurationtable=null;

			/**	clickOnRefreshButtonOnRecentRuns(1);**/

			clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);

			for(int i =0;i<ruleInstanceId.size();i++) {

				clickOnWorkflowSidebarPanelOpenOrClose(false);

				BaseSuite.reportLog(logString+logs+" : "+ruleInstanceId.get(i)+logString);

				if(i>0) {
					flag=clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				ruleInfo=validateRecentRunForRuleInfo(ruleInstanceId.get(i));

				status=ruleInfo.get(3).trim();
				rulename=ruleInfo.get(2).trim();
				ruletype=ruleInfo.get(1).trim();

				validateInstanceIdHyperlink(ruletype, ruleInstanceId.get(i), status);

				if(!status.trim().equalsIgnoreCase(skippedStatusContent)) {

					flag=clickOnExpandArrowToRuleInstanceId(flag, ruleInstanceId.get(i));

					if(Boolean.TRUE.equals(flag)) {

						validateRuleDetailsUsingInstanceId(ruleInstanceId.get(i),status);

						validateConnectionOnRecentRunsDetails(ruletype, Integer.toString((i+1)), ruleInstanceId.get(i));

					}
				}
				flag=clickOnRuleExecutionDetails(ruleInstanceId.get(i));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				checkRuleExceptionReportDetailsAsPerStatus(ruleInstanceId, i, rulename, ruletype, status, workflowName, exceptionReport);

				BaseSuite.reportLog("------------------ End Validation for Instance: "+ruleInstanceId.get(i)+" ------------------");

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRecentRunsForSinglePage ");
			flag=false;
		}		
		return flag;
	}

	public String currentPageNumber(By locator) {
		String currentpage=null; 

		try {

			isDisplayedInLoop(driver, 5, locator);

			javascript(driver, scrollToElementArg, locator);

			String pageinfo = getAttribute(driver, locator, attributeInnertext);

			currentpage = pageinfo.split(" ")[0];

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" currentPageNumber ");
		}

		return currentpage;
	}

	public String totalPageNumber(By locator) {
		String totalpage=null; 

		try {

			isDisplayedInLoop(driver, 5, locator);

			javascript(driver, scrollToElementArg, locator);

			String pageinfo = getAttribute(driver, locator, attributeInnertext);

			totalpage = pageinfo.split(" ")[2];

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" totalPageNumber ");
		}

		return totalpage;
	}


	public boolean validateWorkflowExecutionDetailsInRecentRuns(boolean flag, String instaceId, String workflowName,boolean exceptionReport) {
		String logs="Validating Rule execution details of Instance Id ";
		String method="validateWorkflowExecutionDetailsInRecentRuns ";
		/**List<String> newList =null;**/
		String currentPage;
		boolean exReportFlag=exceptionReport;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);

			if(rulesConfigurationtable==null) {
				rulesConfigurationtable=getRulesTable();
			}

			BaseSuite.reportLog(createHtmlTable1(getRulesConnectionAndParameterTable(), "Rules Connection and Parameter configuration"));

			BaseSuite.reportLog(createHtmlTable1(rulesConfigurationtable,ruleConfigurationContent));

			getWorkflowInstanceTable();

			getAllRuleInstanceTable(instaceId);

			if(BaseSuite.suiteType.equalsIgnoreCase("sanity")) {BaseSuite.reportPassLog("Workflow rule configuration and results");}

			verifyWorkflowExecutionExitCodeCalculation(instaceId);

			/**		clickOnRefreshButtonOnRecentRuns(1);searchRecentRunOnRecentRunsField(flag, instaceId);clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);**/

			int rrtp=Integer.parseInt(totalPageNumber(workflowRecentRunsChildMsg));

			if(1<rrtp) {
				clickOnPage(workflwoRecentRunsChildPageArrow, lastContent);
				exReportFlag=false;
			}

			for(int i =rrtp;i>=1;i--) {

				validateRecentRunsForSinglePage(Integer.toString(i),flag, instaceId, logs, workflowName, exReportFlag);

				if(!exReportFlag) {

					currentPage=currentPageNumber(workflowRecentRunsChildMsg);

					if(Integer.parseInt(currentPage)!=1) {

						clickOnPage(workflwoRecentRunsChildPageArrow, preContent);
					}
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+method+" ");

			flag=false;
		}
		return flag;
	}

	//validate workflow recent run info
	public String validateRuleDetailsRecentRunInfo(String ruleInstanceId) {
		String status=null;
		try {
			getValueOfField(returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstanceId), " Rule run Instace ID ");

			status=getValueOfField(returnElement(workflowExecutionRuleInstanceStatus, dynamicName, ruleInstanceId), " Rule run Status ");

			getValueOfField(returnElement(workflowExecutionRuleInstanceInstacetype, dynamicName, ruleInstanceId), " Rule run Instace Type ");

			getValueOfField(returnElement(workflowExecutionRuleInstanceExitCode, dynamicName, ruleInstanceId), " Rule run Exit Code ");

			getValueOfField(returnElement(workflowExecutionRuleInstanceElapsedTime, dynamicName, ruleInstanceId), " Rule run Elapsed Time ");


		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRuleDetailsRecentRunInfo ");

		}
		return status;
	}

	public void validateRuleDetailsUsingRuleInstanceId(boolean flag, String ruleStatus, String instanceID) {

		try {
			if(flag && !ruleStatus.trim().equalsIgnoreCase(skippedStatusContent)) {

				clickOnExpandArrowToRuleInstanceId(flag, instanceID);

				getvaluefromField(returnElement(workflowExecutionRuleName, dynamicName, instanceID),ruleNameContent,attributeTextContent);

				String ruletype=getvaluefromField(returnElement(workflowExecutionRuleType, dynamicName, instanceID), ruleTypeContent,attributeTitle);

				if(!ruletype.equalsIgnoreCase(scriptContent)) {

					getvaluefromField(returnElement(workflowExecutionRuleSrcConn, dynamicName, instanceID), sourceConnectionContent,attributeTextContent);

					if(ruletype.equalsIgnoreCase("Recon") || ruletype.equalsIgnoreCase("checksum")) {

						getvaluefromField(returnElement(workflowExecutionRuleTrgConn, dynamicName,instanceID), targetConnectionContent,attributeTextContent);

					}
				}
				if(ruleStatus.trim().equalsIgnoreCase(errorStatusContent)) {

					getvaluefromField(returnElement(workflowExecutionRuleErrDesc, dynamicName, instanceID), "Error Description",attributeTitle);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRuleDetailsUsingRuleInstanceId ");

		}

	}


	/** -------------------------------------------- Workflow API Methods -------------------------------------------- **/

	//If single user login flag is true in XML file than pass double quote for role name(EX-role name = "")
	//If single user login flag is false in XML file than pass ICEDQ role name on parameter(EX-role name = Wprkspace_Owner)
	public static String getOAuthBearerTokenBasedOnIcedqRole(String roleName) {
		String uN;
		String pW;
		String orgid;
		XLUtils xlReader = new XLUtils();

		if(BaseSuite.singleUserLogin) {

			uN = BaseSuite.username;
			pW = BaseSuite.password;

		}else {
			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(roleName);

			uN = loginDetails[0];

			pW = loginDetails[1];	
		}
		String content = "grant_type=password&username=" + uN + "&password=" + pW;

		BufferedReader reader = null;

		HttpURLConnection connection = null;

		String returnValue = "";

		if(BaseSuite.baseURL.contains("api")) {
			orgid="iam.icedq";

		}else {
			orgid="icedq.qa";
		}
		if(BaseSuite.baseURL.contains(httpsProtocalContent)) {
			/**BaseSuite.baseURL=BaseSuite.baseURL.replace(httpsProtocalContent, "http");*/
		}
		if(!BaseSuite.baseURL.endsWith("/")) {
			BaseSuite.baseURL=BaseSuite.baseURL+"/";
		}


		try {

			URL url = new URL(BaseSuite.baseURL+"auth/realms/"+orgid+"/protocol/openid-connect/token");

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");

			connection.setDoOutput(true);

			connection.setRequestProperty(authorization, apibasic + AUTHENTICATION);

			connection.setRequestProperty(apicontentType, "application/x-www-form-urlencoded");

			connection.setRequestProperty("Accept", applicationJSonContentType);

			try (PrintStream os = new PrintStream(connection.getOutputStream());) {

				os.print(content);

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String line = null;

				StringWriter out = new StringWriter(
						connection.getContentLength() > 0 ? connection.getContentLength() : 2048);

				while ((line = reader.readLine()) != null) {

					out.append(line);
				}
				String response = out.toString();

				Matcher matcher = pat.matcher(response);

				if (matcher.matches() && matcher.groupCount() > 0) {

					returnValue = matcher.group(1);
				}
			}
		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (reader != null) {

				try {

					reader.close();

					connection.disconnect();

				} catch (IOException e) {
					e.getMessage();
				}
			}


		}

		return returnValue;
	}
	/**
	public static  List<String> getJsonArrayValueUsingJsonPathExpreesion1(String jsonEntity, String expression) {
		ArrayList<String> list = new ArrayList<>();

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				String value1 = o.toString().replace("\"", "");

				list.add(value1);

			}

		} catch (Exception e) {

			e.getMessage();
		}

		return list;

	}
	 */
	public static String getJsonValueUsingJsonPathExpreesion1(String jsonEntity, String expression) {
		String value = "";

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			log.info(jsonContent);

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				value = o.toString().replace("\"", "");
			}

			value=checkNullValue(value);

		} catch (Exception e) {

			e.getMessage();
		}

		return value;

	}

	// get list of custom workflow id from workspace

	public static List<String> getCustomWorkflowIdFromWorkspace(String workspaceId,String icedqRole) {
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse(contentType);

			RequestBody body = RequestBody.create(mediaType,
					"{\"filter\":[{\"attribute\":\"workflowType\",\"operator\":\"In\",\"datatype\":\"string\",\"value\":\"Custom\"}]}");

			Request request = new Request.Builder()

					.url(readconfig.workflowListApiUrl()).method("POST", body)

					.addHeader(contentTypeText, contentType)

					.addHeader(apiworkspaceId, workspaceId)

					.addHeader(apiorgId, "org-iam.icedq")

					.addHeader(authetication, apiBearer + auto)

					// .addHeader("Cookie", "JSESSIONID=864D9BE317797369277797E49EED9043")

					.build();

			Response response = client.newCall(request).execute();

			String r = response.body().string();

			return getJsonArrayValueUsingJsonPathExpreesion(r, "$.items..id");

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	// get workflow info from workflow id and workspace id
	public static String getWorkflowInfoFromWorkflowID(String workflowID, String workspaceId,String icedqRole) {
		String jsonEntity = null;
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(readconfig.AppicationBaseURL() + "api/v1/workflows/" + workflowID);

			getRequest.setHeader(apicontentType, applicationJSonContentType);

			getRequest.setHeader(apiworkspaceId, workspaceId);

			getRequest.setHeader(authorization, apiBearer + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response---------------- " + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues ----------- " + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);


		} catch (Exception e) {

			e.getMessage();
		}
		return jsonEntity;
	}

	// set workflow parameters using api
	public static DataTestingParameters setWorkflowParametersForApi(String jsonEntity) {

		DataTestingParameters param = new DataTestingParameters();

		try {

			param.setWorkflowName(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathName));
			param.setWorkflowType(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathWorkflowType));
			param.setIsActive(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathIsActive));
			param.setWorkflowFolderID(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathFolderId));
			param.setWorkflowfolderName(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathFolderName));
			param.setWorkflowState(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathState));
			param.setWorkflowCode(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathCode));
			param.setWorkflowDescription(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathDescription));
			param.setWorkflowStatus(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathStatus));
			param.setWorkflowEngineType(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathEngineType));
			param.setWorkflowTemplate(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathTemplate));
			return param;

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowParametersForApi "+e.toString());
		}
		return param;

	}

	// set workflow parameters using api
	public DataTestingParameters setWorkflowParametersForApi(String jsonEntity, String icedqUser) {

		DataTestingParameters param = new DataTestingParameters();

		try {

			param.setWorkflowName(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathName)+"_"+icedqUser);
			param.setWorkflowType(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathWorkflowType));
			param.setIsActive(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathIsActive));
			param.setWorkflowFolderID(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathFolderId));
			param.setWorkflowfolderName(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathFolderName));
			param.setWorkflowState(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathState));
			param.setWorkflowCode(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathCode));
			param.setWorkflowDescription(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathDescription));
			param.setWorkflowStatus(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathStatus));
			param.setWorkflowEngineType(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathEngineType));
			param.setWorkflowTemplate(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathTemplate));
			return param;

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowParametersForApi "+e.toString());
		}
		return param;

	}

	public String getRuleFolderColumnName(String folderName) {

		String name ="";

		if(!folderName.isEmpty()) {

			name =folderName;

		}else if(!workflowExecutionConfigColumnName.isEmpty()) {

			name=workflowExecutionConfigColumnName;
		}else {
			name=valueColumn;

		}


		return name; 

	}

	// set workflow rules details parameters using API
	public DataTestingParameters setWorkflowRulesParametersForApi(int row, String jsonEntity)
	{

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		String iceWorkflowExcelFile = dirPath+ Constant.NEXTGEN_WORKFLOW_TESTDATA_EXCEL_PATH;	

		try {

			param.setRuleName(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].name"));
			param.setRuleEngineType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].properties.engineType"));
			param.setOnSuccess(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].dependency.onSuccess"));
			param.setOnFailure(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].dependency.onFailure"));
			param.setOnError(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].dependency.onError"));
			param.setUseExitCode(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].properties.useExitCode"));
			param.setIsRuleActive(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].properties.isActive"));
			param.setRuleObjectId(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].objectId"));
			param.setOverrideSourceType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[0].type"));
			param.setOverrideSourceConnID(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[0].replace"));
			param.setOverrideTargetConnID(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[1].replace"));
			param.setOverrideTargetType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[1].type"));
			param.setOverrideParamConnID(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[2].replace"));
			param.setOverrideParamType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[2].type"));

			if(ConstantProperty.RULEAPITESTDATA.trim().equalsIgnoreCase("api")) {

				param.setRuleFolderName(getJsonValueUsingJsonPathExpreesion(jsonEntity,
						activityJsonPath + row + "].folderName"));
				param.setRuleParameterName(getJsonValueUsingJsonPathExpreesion(jsonEntity,
						activityJsonPath + row + "].parameterName"));
				param.setRuleSourceConnectionName(getJsonValueUsingJsonPathExpreesion(jsonEntity,
						activityJsonPath + row + "].sourceConnection"));
				param.setRuleTargetConnectionName(getJsonValueUsingJsonPathExpreesion(jsonEntity,
						activityJsonPath + row + "].targetConnection"));

			}else if(workflowExecutionDynamicDataFlag) {

				String readColumnName="";

				readColumnName=getRuleFolderColumnName(workflowFolderNameForSanity);

				param.setRuleFolderName(xl.readUsingColNameAndCellContains(iceWorkflowExcelFile, wkflsheetName, keyColumn, keyRuleFolder, readColumnName));
				param.setRuleParameterName(xl.readUsingColNameAndCellContains(iceWorkflowExcelFile, wkflsheetName, keyColumn, keyRuleParameter, readColumnName));
				param.setRuleSourceConnectionName(xl.readUsingColNameAndCellContains(iceWorkflowExcelFile, wkflsheetName, keyColumn, keyRuleSourceConnection, readColumnName));
				param.setRuleTargetConnectionName(xl.readUsingColNameAndCellContains(iceWorkflowExcelFile, wkflsheetName, keyColumn, keyRuleTargetConnection, readColumnName));
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return param;
	}

	public static String getRuleJsonEntityUsingRuleID(String workspaceID,String ruleID,String icedqRole)
	{
		String jsonEntity = null;

		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(readconfig.AppicationBaseURL()+"api/v1/rules/" + ruleID);

			getRequest.setHeader(apicontentType, applicationJSonContentType);

			getRequest.setHeader(apiworkspaceId, workspaceID);

			getRequest.setHeader(apiorgId, "org-iam.icedq");

			getRequest.setHeader(authorization, apiBearer + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);
		} catch (Exception e) {

			e.getMessage();
		}
		return jsonEntity; 

	}

	public static DataTestingParameters getDataTestingInfoFromDataBase(String workflowName, String ruleName, String testcaseid){

		DataTestingParameters param = new DataTestingParameters();

		String sqlQuery = null;

		try {

			if(Boolean.TRUE.equals(Constant.READWORKFLOWDATAFROMEXCEL)) {

				log.info("--------- Reading from Excel data --------------");

				String iceWorkflowExcelFile = dirPath+ Constant.NEXTGEN_WORKFLOW_TESTDATA_EXCEL_PATH;

				String iceWorkflowExcelSheet=ConstantProperty.WORKFLOW_EXCEL_SHEET_TESTCASEID;

				param = setWorkflowParametersUsingTestCaseId(iceWorkflowExcelFile, iceWorkflowExcelSheet, testcaseid);

				return param;

			}
			conn=setUpConnectionAndTest(Constant.DATABASEURL, Constant.DATABASEUSERNAME,Constant.DATABASEPASSWORD);

			stmt = conn.createStatement();

			if(!workflowName.isEmpty() || !testcaseid.isEmpty()) {

				if(!workflowName.isEmpty()) {

					sqlQuery=ConstantProperty.SQL_WORKFLOW_DETAILS+workflowName+"\'";
				}else {
					sqlQuery="select * from workflows.ice_workflows where testcase_id like \'%"+testcaseid+"%\'";
				}
				resultSet = stmt.executeQuery(sqlQuery);

				while (resultSet .next()) {

					param.setWorkflowJsonValue(resultSet.getString(testDataWorkflowJSONColumnNameForDB));//dummy_json/workflow_json
					param.setWorkflowfolderName(resultSet.getString("wkfl_folder_name"));
					param.setWorkflowName(resultSet.getString(columnWorkflowName));
					param.setWorkflowSubscriptionJsonValue(resultSet.getString("workflow_notification_json"));
					param.setWorkflowExecutionStatus(resultSet.getString("execution_status"));
					param.setWorkflowExecutionExitCode(resultSet.getString("execution_exitcode"));
					param.setWorkflowOverrideJsonValue(resultSet.getString("override_json"));
					param.setWorkflowUpdateJsonValue(resultSet.getString(keyWorkflowUpdateJson));
					param.setWorkflowSaveMode(resultSet.getString("save_mode"));
					param.setWorkflowDownloadZip(resultSet.getString("download_zip"));
					param.setWorkflowExceptionReportCheck(resultSet.getString("exception_report_check"));

				}

			}else if(!ruleName.isEmpty()) {

				sqlQuery=ConstantProperty.SQL_RULE_DETAILS+ruleName+"\'";

				resultSet = stmt.executeQuery(sqlQuery);

				while (resultSet .next()) {

					param.setRuleJsonValue(resultSet.getString("rule_json"));
					param.setRuleFolderName(resultSet.getString("rule_folder_name"));

				}

			}else {
				BaseSuite.reportErrorLog("no input provided");
			}

		}catch(Exception e ) {
			BaseSuite.reportErrorLog(e, "Error while retriving data from database kindly check , "+e.toString());
		}finally {

			try {
				if (conn != null) {
					conn.close();
					log.info("Database connection is closed.");
				}
			} catch (SQLException e) {
				// Handle any exceptions related to closing the connection
				e.printStackTrace();
				log.error("getDataTestingInfoFromDataBase ");
			}
		}

		return param;
	}

	public static String getWorkflowIDFromWorkflowName(String workflowName, String workspaceId,String icedqUser) {
		String workflowID =null;

		try {
			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqUser);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse(applicationJSonContentType);


			body = RequestBody.create(mediaType,
					"{    \"search\": [    {  \"attribute\": \"name\",   \"operator\": \"Equals\", \"value\": \""+workflowName+" \"  } ]}");

			Request request = new Request.Builder()

					.url(readconfig.AppicationBaseURL()+readconfig.workflowListApiUrl()).method("POST", body)

					.addHeader(contentTypeText, applicationJSonContentType)

					.addHeader(apiworkspaceId, workspaceId)

					.addHeader("Cookie", "JSESSIONID=F76D501BBC7C4FBF2D064CA25CB7AC51")

					.addHeader(authorization, apiBearer+auto)

					.build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			workflowID = getJsonValueUsingJsonPathExpreesion(jsonBody, jsonPathGetId);


		} catch (Exception e) {
			e.getMessage();
			BaseSuite.reportFailLog("Search Workflow API not returning rule id kindly check exception", "getWorkflowIDFromWorkflowName");

		}

		return workflowID;

	}

	public static String getFolderNameFromWorkflowFolderId(String workflowFolderID, String workspaceId,String icedqRole) {
		String folderName = null;
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(readconfig.AppicationBaseURL() + "api/v1/folders/" + workflowFolderID);

			getRequest.setHeader(apicontentType, applicationJSonContentType);

			getRequest.setHeader(apiworkspaceId, workspaceId);

			getRequest.setHeader(authorization, apiBearer + auto);

			getRequest.setHeader(apiorgId, "org-icedq.qa");

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			String jsonEntity = EntityUtils.toString(entity1);

			folderName = getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathName);

		} catch (Exception e) {

			e.getMessage();
		}
		return folderName;
	}

	public String getFolderNameFromRuleId(String ruleId, String workspaceId,String icedqRole) {
		String folderName1 = null;
		try {

			String ruleJsonEntity = getRuleJsonEntityUsingRuleID(workspaceId, ruleId, icedqRole);

			String folderid = getJsonValueUsingJsonPathExpreesion(ruleJsonEntity, jsonPathFolderId);

			folderName1 = getFolderNameFromWorkflowFolderId(folderid, workspaceId, icedqRole);


		} catch (Exception e) {

			e.getMessage();
		}
		return folderName1;
	}

	public DataTestingParameters setWorkflowParametersUsingAPI(String jsonEntity , String workspaceId) {

		DataTestingParameters param = new DataTestingParameters();

		try {

			param.setWorkflowName(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathName));
			param.setWorkflowType(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathWorkflowType));
			param.setIsActive(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathIsActive));
			param.setWorkflowFolderID(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathFolderId));
			param.setWorkflowfolderName(getFolderNameFromWorkflowFolderId(param.getWorkflowFolderID(), workspaceId, ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER));
			param.setWorkflowState(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathState));
			param.setWorkflowCode(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathCode));
			param.setWorkflowDescription(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathDescription));
			param.setWorkflowStatus(getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.isActive"));
			param.setWorkflowEngineType(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathEngineType));
			param.setWorkflowTemplate(getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPathTemplate));


		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+e.toString());
		}
		return param;

	}

	public DataTestingParameters setWorkflowRulesParametersUsingAPI(int row, String jsonEntity, String workspaceID)
	{

		DataTestingParameters param = new DataTestingParameters();

		try {

			param.setRuleName(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].name"));
			param.setRuleEngineType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].properties.engineType"));
			param.setOnSuccess(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].dependency.onSuccess"));
			param.setOnFailure(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].dependency.onFailure"));
			param.setOnError(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].dependency.onError"));
			param.setUseExitCode(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].properties.useExitCode"));
			param.setIsRuleActive(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].properties.isActive"));
			param.setRuleObjectId(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].objectId"));
			param.setOverrideSourceType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[0].type"));
			param.setOverrideSourceConnID(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[0].replace"));
			param.setOverrideTargetConnID(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[1].replace"));
			param.setOverrideTargetType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[1].type"));
			param.setOverrideParamConnID(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[2].replace"));
			param.setOverrideParamType(getJsonValueUsingJsonPathExpreesion(jsonEntity,
					activityJsonPath + row + "].overrides[2].type"));


			param.setFolderName(getFolderNameFromRuleId(param.getRuleObjectId(), workspaceID, ConstantProperty.ICEDQ_ACCOUNT_OWNERUSER));



		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error "+e.toString());
		}
		return param;
	}

	public boolean addRulesToWorkflowUsingApi(boolean flag, DataTestingParameters workflowParam,  List<String> ruleList, String workflowJsonEntity ,String workspaceID) {

		try {
			for(int i=0;i<ruleList.size();i++) {


				DataTestingParameters ruleParam = setWorkflowRulesParametersUsingAPI(i,workflowJsonEntity, workspaceID);

				BaseSuite.reportLog(addedRuleLog+ruleParam.getRuleName()+workflowLog);

				flag=validateAndSearchFolderOnWorkflowDetailsPage(flag,workflowParam.getFolderName());

				flag=clickOnFolderNameCheckboxOnWorkflowDetailsPage(flag,workflowParam.getFolderName(), true);

				flag=validateAndSearchRuleOnWorkflowDetailsPage(flag,ruleParam.getRuleName());

				flag=clickOnRuleCheckboxOnWorkflowDetailsPage(ruleParam.getRuleName(),ruleParam.getRuleFolderName());

				flag=clickOnAddRulesButtonOnWorkflowDetailsPage(flag);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" addRulesToWorkflowUsingApi ");

		}
		return flag;
	}

	//view workflow and validate fields
	public boolean viewWorkflow(String workflowJsonEntity, String icedqUser) {

		boolean flag =true;
		log.info(icedqUser);
		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbHomeLink, homeContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbWorkflowsLink, workflowContent, flag);

			flag=validateFolderSearchSideBar(flag);

			validateRuleOnWorkflowDetailsPage(flag);

			verifyVisibilityOfButtons(driver, workflowDetailsOverviewTab, overviewContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsRuleAndDatasetsTab, rulesContent, true);

			clickOnButton(driver, workflowDetailsOverviewTab, overviewContent, true);

			viewAndValidateField(workflowDetailsWorkflowNameField, fieldWorkflowName, workflowParam.getWorkflowName(), true);

			viewAndValidateField(workflowDetailsWorkflowCodeField, workflowCodeContent, workflowParam.getWorkflowCode(), true);

			viewAndValidateField(workflowDetailsDescriptionField, workflowDescriptionContent, workflowParam.getWorkflowDescription(), true);

			getvaluefromField(workflowDetailsUpdatedBy, "Created by", attributeTextContent);

			getvaluefromField(workflowDetailsUpdatedDate, "Updated by", attributeTextContent);

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, workflowDetailsCurrentStatus);

			String acStatus = getAttribute(driver, workflowDetailsCurrentStatus, attributeTitle);

			if(!acStatus.toLowerCase().contains(draftContent)) {

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				validateRulesAndDatasetsFields();

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				validateAddedRuleInWorkflow(flag, ruleList, workflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(true);

				flag=searchRecentRunOnRecentRunsField(flag, "");
			}

			validateButtonsForWorkflowDetailsOnRevisit(acStatus);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" viewWorkflow ");

			flag=false;
		}
		return flag;
	}

	public boolean updateWorkflow(String oldWorkflowJson, String newWorkflowJson, String user) {
		try {
			if (!viewWorkflow(oldWorkflowJson, user)) return false;
			if (!clickonWorkflowRulesAndDatasetTab(true)) return false;

			// Remove existing rules
			if (!removeAllRulesFromWorkflow(oldWorkflowJson)) return false;

			// Update overview details
			DataTestingParameters workflowParam = setWorkflowParametersForApi(newWorkflowJson);
			if (!clickonWorkflowOverviewAndEnterDetails(
					true,
					workflowParam.getWorkflowName() + "_" + user,
					workflowParam.getWorkflowCode(),
					workflowParam.getWorkflowDescription())) return false;

			validateWorkflowCreateUpdatedFormat();

			// Add updated rules
			if (!clickonWorkflowRulesAndDatasetTab(true)) return false;
			if (!addRulesToWorkflow(newWorkflowJson, workflowParam.getWorkflowfolderName())) return false;

			// Save workflow
			if (!clickOnWorkflowSaveOption(true, workflowPublish, "", user)) return false;

			String status = clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount, "");
			validateWorkflowRecentRunInfo();

			return !status.toLowerCase().contains(runningStatus) || clickOnExecutionDetails();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " updateWorkflow :: " + e.getMessage());
			return false;
		}
	}

	private boolean removeAllRulesFromWorkflow(String jsonEntity) {
		List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, workflowRuleListJsonPath);
		for (int i = 0; i < ruleList.size(); i++) {
			DataTestingParameters rule = setWorkflowRulesParametersForApi(i, jsonEntity);
			if (!removeAddedRuleFromRulesAndDatasetsTab(true, rule.getRuleName(), rule.getRuleFolderName())) {
				BaseSuite.reportLog("Failed to remove rule: " + rule.getRuleName());
				return false;
			}
		}
		return true;
	}

	private boolean addRulesToWorkflow(String jsonEntity, String folderName) {
		if (!validateAndSearchFolderOnWorkflowDetailsPage(true, folderName)) return false;
		if (!clickOnFolderNameCheckboxOnWorkflowDetailsPage(true, folderName, true)) return false;

		List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, workflowRuleListJsonPath);
		for (int i = 0; i < ruleList.size(); i++) {
			DataTestingParameters rule = setWorkflowRulesParametersForApi(i, jsonEntity);
			BaseSuite.reportLog("Adding Rule: " + rule.getRuleName());

			validateAndSearchRuleOnWorkflowDetailsPage(true, rule.getRuleName());
			if (!clickOnRuleCheckboxOnWorkflowDetailsPage(rule.getRuleName(), rule.getRuleFolderName())) return false;
			if (!clickOnAddRulesButtonOnWorkflowDetailsPage(true)) return false;
		}
		return true;
	}


	public boolean deleteWorkflow(String workflowJsonEntity, String workflowName, String folderName, String icedqUser) {
		try {
			BaseSuite.reportLog("Initiating deletion for workflow: " + workflowName);
			log.info(workflowJsonEntity);
			waitForSpinnerToDisappear();

			if (isPrivilegedUser(icedqUser)) {
				// Attempt deletion
				if (!deleteWorkflowOnWorkflowDetailsPage(workflowDeletedToastMessage)) return false;
			} else {
				// Non-privileged user should see forbidden message
				deleteWorkflowOnWorkflowDetailsPage(WORKFLOWPRIVILEGEFORBIDDENMESSAGE);
				BaseSuite.reportLog("User " + icedqUser + " has no privilege to delete workflows.");
				return false;
			}

			waitForSpinnerToDisappear();
			clickOnButton(driver, refreshWorkflowButton, refreshContent, true);

			// Verify deletion
			searchFunctionalityMethod(driver, true, workflowSearchField, workflowSearchButton, placeholderSearchWorkflow, placeholderSearchWorkflow, workflowName);
			waitForSpinnerToDisappear();
			getPaginationDetails(driver, workflowListingPageMsg, workflowListingPagearrow, workflowListingPageNoRecordDisplay, workflowContent + listingContent);

			if (isWorkflowPresentInList(workflowName, folderName)) {
				BaseSuite.reportErrorLog(null, "Workflow still visible after deletion: " + workflowName);
				return false;
			}

			BaseSuite.reportLog("Workflow deleted successfully: " + workflowName);
			return true;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " deleteWorkflow :: Error while deleting " + workflowName);
			return false;
		}
	}

	private boolean isPrivilegedUser(String icedqUser) {
		String user = icedqUser.toLowerCase();
		return !(user.contains(readerContent) || user.contains(executorContent));
	}

	private void waitForSpinnerToDisappear() {
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	}

	private boolean isWorkflowPresentInList(String workflowName, String folderName) {
		By locator = returnTwoElements(workflowNamelink, dynamicName, workflowName, dynamicFolderName, folderName);
		return isDisplayed(driver, locator);
	}



	public boolean validateWorkflowExecutionProcess(boolean flag, String status,String workflowName,String workflowid,String instanceid, boolean download, boolean exceptionReport) {

		try {
			searchRecentRunOnRecentRunsField(flag, instanceid);

			flag=clickOnExecutionDetails();

			status=checkNullValue(status);
			if ((!status.toLowerCase().contains(runningStatus))){
				String type=getworkflowtype(workflowName);
				if(type.equalsIgnoreCase(customContent)) {
					flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,download); 
				}
				flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowName, exceptionReport);

			}else if ((status.toLowerCase().contains(runningStatus))) {
				BaseSuite.reportFailLog("Workflow run taking more time than constant time", "validateWorkflowExecutionProcess");
				flag=false;

				clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

				List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

				getWorkflowInstanceTable();

				getInstanceTable(ruleInstanceId);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateWorkflowExecutionProcess ");
			flag=false;
		}
		return flag;
	}

	//run workflow
	public boolean runWorkflow(String workflowJsonEntity,boolean download, boolean exceptionReport, String icedqUser,String workflowType) {
		String workflowid=null;
		String instanceid=null;
		String preinstanceid ="";
		String status="";
		boolean flag = true;
		try {

			/**	viewWorkflow(workflowJsonEntity, icedqUser);**/

			String workflowName=getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathName);

			if(!icedqUser.contains(readerFlag)) {
				if(workflowType.contains(customContent)){
					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);
				}
				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				preinstanceid=verifyInstanceID();

				status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				instanceid = validateWorkflowRecentRunInfo();

				if(instanceid.contains(preinstanceid)) {
					status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");
					instanceid = validateWorkflowRecentRunInfo();
				}

				if(!instanceid.equals(preinstanceid) || preinstanceid.isEmpty()) {

					flag=validateWorkflowExecutionProcess(flag, status, workflowName, workflowid, instanceid, download, exceptionReport);

				}else {
					BaseSuite.reportFailLog(workflowInstanceIdNotLog+previousIdLog+preinstanceid+" & current id:  "+instanceid, "runWorkflow");
					flag=false;
				}
			}else  {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, workflowDetailsRunButton);

				flag=clickOnButton(driver, workflowDetailsRunButton, runContent, true);

				if(flag) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,workflowRunContent);

				}
			}		

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" runWorkflow ");

			flag=false;

		}

		return flag;

	}

	public String verifyInstanceID() {

		String preinstanceid="";

		try {
			if(isDisplayed(driver, workflowDetailsRecentRunInstanceId)) {

				preinstanceid=getAttribute(driver, workflowDetailsRecentRunInstanceId, attributeTextContent);

				preinstanceid= checkNullValue(preinstanceid);

				BaseSuite.reportLog("Previous execution instance id : "+preinstanceid);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" verifyInstanceID ");

		}
		return preinstanceid;
	}


	public boolean runForReaderGrantUser() {
		boolean flag = true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, workflowDetailsRunButton);

			flag=clickOnButton(driver, workflowDetailsRunButton, runContent, true);

			if(flag) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,workflowRunContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" runForReaderGrantUser ");

			flag=false;
		}
		return flag;
	}

	public boolean validateRecentRuns(boolean flag,String instanceid) {

		if(flag) {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag = searchRecentRunOnRecentRunsField(flag, instanceid);

			if(!flag) { return false; }

			String wkflExitCode = getValueOfField(workflowDetailsRecentRunExitCode, workflowExitCodeContent);

			flag=verifyWorkflowExecutionStatusCalculation(wkflExitCode, instanceid);
		}
		return flag;
	}

	//run workflow and kill workflow functionality
	public boolean runAndStopExecutionWorkflow(String workflowJsonEntity, String icedqUser) {

		String instanceId=null;
		boolean flag = true;
		String preinstanceid ="";
		try {
			log.info("Workflow Json :: "+workflowJsonEntity);
			/**	flag=viewWorkflow(workflowJsonEntity, icedqUser);**/

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			if(!icedqUser.contains(readerFlag)) {

				preinstanceid=verifyInstanceID();

				String status=clickOnRunButtonOnWorkflowAndGetStatus(2,"");

				/**	instanceId = validateWorkflowRecentRunInfo();**/
				instanceId=getValueOfField(workflowDetailsRecentRunInstanceId, instanceIdContent);

				if(instanceId.contains(preinstanceid)) {
					status=clickOnRunButtonOnWorkflowAndGetStatus(2,"");
					/**	instanceId = validateWorkflowRecentRunInfo();**/
					instanceId=getValueOfField(workflowDetailsRecentRunInstanceId, instanceIdContent);
				}

				if(!instanceId.contains(preinstanceid)) {

					/**		flag=searchRecentRunOnRecentRunsField(flag, instanceTd);**/

					if ((status.toLowerCase().contains(runningStatus))){

						flag=clickOnStopExecution(flag, instanceId);

						clickOnRefreshButtonOnRecentRuns(10);

						validateRecentRuns(flag, instanceId);

					}else if(status.isEmpty()) {
						BaseSuite.reportFailLog(workflowInstanceIdNotLog+" status is empty kindly check", "runAndStopExecutionWorkflow");
					}
				}else {
					BaseSuite.reportFailLog(workflowInstanceIdNotLog+" Previous id:: "+preinstanceid+" & current id:: "+instanceId, "runAndStopExecutionWorkflow");
					flag=false;
				}
			}else {

				flag=runForReaderGrantUser();

			}		


		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" runAndStopExecutionWorkflow ");

			flag=false;

		}

		return flag;

	}


	public boolean activateOrDeactivateCustomWorkflow(String scenario,String workflowJsonEntity, String icedqUser ) {
		boolean flag = false;

		if(scenario.trim().equalsIgnoreCase(deactivateContent)) {

			flag=deactivateWorkflow(workflowJsonEntity, icedqUser);

		}else if(scenario.trim().equalsIgnoreCase(activateContent)) {

			flag=activateWorkflow(workflowJsonEntity, icedqUser);
		}

		return flag;
	}

	public boolean validateWorkflowDetails(boolean view, String workflowJsonEntity, String icedqUser) {
		boolean flag = true;
		if(view) {
			flag=viewWorkflowDetailsWithStatus(workflowJsonEntity, true, icedqUser);
		}
		return flag;
	}


	//deactivate workflow
	public boolean deactivateWorkflow(String workflowJsonEntity, String icedqUser) {

		boolean flag = true;
		boolean view=false;
		try {

			flag=validateWorkflowDetails(view, workflowJsonEntity, icedqUser);

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag=activateOrDeactivateWorkflow(flag, deactivateContent,icedqUser,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					flag=verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);
				}

			}else {

				flag=activateOrDeactivateWorkflow(flag, deactivateContent,icedqUser,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);


			}		

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" deactivateWorkflow ");

			flag=false;

		}

		return flag;

	}


	//Activate workflow
	public boolean activateWorkflow(String workflowJsonEntity, String icedqUser) {

		boolean flag = true;
		boolean view=false;
		try {

			flag=validateWorkflowDetails(view, workflowJsonEntity, icedqUser);

			if(!icedqUser.contains(readerContent) && !icedqUser.contains(executorContent)) {

				flag=activateOrDeactivateWorkflow(flag, activateContent,icedqUser,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(flag) {

					flag=verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, true);
				}

			}else {

				flag=activateOrDeactivateWorkflow(flag, activateContent,icedqUser,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);

			}		

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" activateWorkflow ");

			flag=false;

		}

		return flag;

	}

	public boolean viewWorkflow(boolean view, String workflowJsonEntity, String icedqUser) {
		boolean flag = true;
		if(view) {
			flag=viewWorkflow(workflowJsonEntity, icedqUser);
		}
		return flag;
	}

	//share workflow
	public boolean shareWorkflow(String workflowJsonEntity, String icedqUser) {

		boolean flag = true;
		boolean view=false;
		try {
			flag=viewWorkflow(view, workflowJsonEntity, icedqUser);

			flag=shareWorkflow(flag);

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" shareWorkflow ");

			flag=false;

		}

		return flag;

	}

	public boolean createWorkflowUsingAPI(String workflowJsonEntity,String workspaceID, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		try {
			DataTestingParameters workflowParam = setWorkflowParametersUsingAPI(workflowJsonEntity,workspaceID);

			newWorkflowName = workflowParam.getWorkflowName()+"_"+icedqUser;

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(workflowParam.getWorkflowfolderName());

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag) {

					enterDetailsToAddNewWorkflowPane(flag,workflowParam.getWorkflowfolderName(), newWorkflowName, workflowParam.getWorkflowType());

					clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowUsingApi(flag, workflowParam, ruleList, workflowJsonEntity, workspaceID);

					flag = clickOnWorkflowSaveOption(flag,workflowPublish, workflowCreatedToastMsg,icedqUser);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(flag) {

						String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

						validateWorkflowRecentRunInfo();

						if ((!status.toLowerCase().contains(runningStatus))){
							flag=clickOnExecutionDetails();
						}
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowUsingAPI ");

			flag=false;
		}

		return flag;

	}

	//create workflow using automation database details
	public boolean createWorkflowUsingAutomationDatabase(String workflowJsonEntity, String workflowSubscriptionJSon,boolean downloadZip, boolean exceptionReport,boolean isOverride, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		String instanceid=null;
		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(workflowParam.getWorkflowfolderName());

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag) {

					flag=enterDetailsToAddNewWorkflowPane(flag,workflowParam.getWorkflowfolderName(), newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	

					flag = clickOnWorkflowSaveOption(flag,workflowPublish, workflowCreatedToastMsg,icedqUser);

					workflowid = getWorkflowIdOnWorkflowDetailsPage();

					flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(flag && !icedqUser.contains(readerFlag)) {

						String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

						instanceid = validateWorkflowRecentRunInfo();

						flag=searchRecentRunOnRecentRunsField(flag, instanceid);

						if ((flag && !status.toLowerCase().contains(runningStatus))){

							flag=clickOnExecutionDetails();

							flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

							flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, newWorkflowName, exceptionReport);
						}else {
							BaseSuite.reportFailLog(" Workflows Execution is in running state for long time kindly check" , "createWorkflowUsingAutomationDatabase");
							flag=false;
						}

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowUsingAutomationDatabase ");

			flag=false;
		}

		return flag;

	}

	//create workflow using automation database details
	public boolean updateWorkflowUsingAutomationDatabase(String workflowJsonEntity,String updateWorkflowJsonEntity,boolean downloadZip, boolean exceptionReport,boolean isOverride, String icedqUser){

		boolean flag = true;
		String workflowid=null;
		String instanceid=null;
		try {

			viewWorkflow(workflowJsonEntity, icedqUser);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(updateWorkflowJsonEntity);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			validateWorkflowCreateUpdatedFormat();

			clickonWorkflowRulesAndDatasetTab(flag);

			List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

			for(int i=0;i<ruleList.size();i++) {

				DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i,workflowJsonEntity);

				flag=removeAddedRuleFromRulesAndDatasetsTab(flag,ruleParam.getRuleName(),ruleParam.getRuleFolderName());

			}
			flag=clickOnWorkflowSidebarPanelOpenOrClose(true);

			List<String> updateruleList = getJsonArrayValueUsingJsonPathExpreesion(updateWorkflowJsonEntity, workflowRuleListJsonPath);

			addRulesToWorkflowDetails(flag,updateruleList, updateWorkflowJsonEntity);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

			flag=selectWorkflowRulesFlag(flag,updateruleList, updateWorkflowJsonEntity,isOverride);	

			flag = clickOnWorkflowSaveOption(flag,workflowPublish, "",icedqUser);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag)) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				instanceid = validateWorkflowRecentRunInfo();

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if (flag && (!status.toLowerCase().contains(runningStatus))){

					flag=clickOnExecutionDetails();
					String type=getworkflowtype(workflowParam.getWorkflowName());
					if(type.equalsIgnoreCase(customContent)) {
						flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 
					}
					flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowParam.getWorkflowName(),exceptionReport);
				}else {
					BaseSuite.reportFailLog(" Workflow Execution is in running state for long time kindly check " , "updateWorkflowUsingAutomationDatabase");
					flag=false;
				}

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowUsingAutomationDatabase ");

			flag=false;
		}

		return flag;

	}

	public boolean validateDuplicateWorkflowButton(String foldername,boolean downloadZip, boolean exceptionReport,String saveMode, String icedqUser) {

		boolean flag=true;

		try {
			displayAndClick(driver, workflowDetailsOverviewTab);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 1, workflowDetailsWorkflowNameField);

			String newWorkflowName = getAttribute(driver, workflowDetailsWorkflowNameField, attributeValue);

			BaseSuite.validationReportLog("Duplicated workflow name : "+newWorkflowName);

			clickOnWorkflowsLinkOnWorkflowDetailsPage();

			flag=searchAndClickOnWorkflowNameOnWorkflowListingPageUsingFolderPath(newWorkflowName,foldername);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag)) {

				validatestatusofWorkflow(saveMode);

				if(saveMode.toLowerCase().contains(publishContent.toLowerCase())) {

					clickOnWorkflowSidebarPanelOpenOrClose(false);

					ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();

					String workflowid = getWorkflowIdOnWorkflowDetailsPage();

					String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

					String instanceid = validateWorkflowRecentRunInfo();

					if ((!status.toLowerCase().contains(runningStatus))){

						flag=clickOnExecutionDetails();
						String type=getworkflowtype(newWorkflowName);
						if(type.equalsIgnoreCase(customContent)) {
							flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 
						}
						flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, newWorkflowName,exceptionReport);
					}else {
						BaseSuite.reportFailLog(" Workflow Execution is in running state for long time kindly check " , "duplicateWorkflows");
						flag=false;
						clickOnExecutionDetails();

						clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

						List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

						getWorkflowInstanceTable();

						getInstanceTable(ruleInstanceId);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateDuplicateWorkflowButton ");
			flag=false;
		}

		return flag;
	}

	//duplicate workflow 
	public boolean duplicateWorkflow(String workflowJsonEntity,String foldername,boolean downloadZip, boolean exceptionReport,String saveMode ,String icedqUser) {

		boolean flag = true;
		boolean dnd=true;
		boolean view=false;
		try {
			flag = viewWorkflow(view, workflowJsonEntity, icedqUser);

			if(flag) {

				if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {
					flag=duplicateWorkflow(flag, workflowDuplicateToastMsg);
				}else {
					flag=duplicateWorkflow(flag, WORKFLOWPRIVILEGEFORBIDDENMESSAGE);
					dnd=false;
				}
				if(flag && dnd) {

					flag=validateDuplicateWorkflowButton(foldername, downloadZip, exceptionReport, saveMode, icedqUser);

				}
			}

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" duplicateWorkflows ");

			flag=false;

		}

		return flag;
	}

	public boolean validateWorkflowExecutionDetails(boolean flag, String workflowid, String instanceid,boolean downloadZip) {
		if(flag) {
			flag=clickOnExecutionDetails();

			flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

			flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid,"",false);
		}
		return flag;
	}


	public boolean workflowZeroExitCodeStatus( int actual) {
		boolean flag=true;

		if(actual==0) {
			BaseSuite.reportLog("Exit code is zero");
		}else {
			BaseSuite.reportFailLog("Exit code is not zero :: "+actual,"workflowZeroExitCodeStatus");
			flag=false;
		}
		return flag;
	}

	public boolean workflowPositiveExitCodeStatus( int actual) {
		boolean flag=true;
		if(actual>0) {
			BaseSuite.reportLog("Exit code is positive");
		}else {
			BaseSuite.reportFailLog("Exit code is not positive :: "+actual,"workflowPositiveExitCodeStatus");
			flag=false;
		}
		return flag;
	}

	public boolean workflowNegativeExitCodeStatus( int actual) {
		boolean flag=true;
		if(actual<0) {
			BaseSuite.reportLog("Exit code is negative");
		}else {
			BaseSuite.reportFailLog("Exit code is not negative :: "+actual,"workflowNegativeExitCodeStatus");
			flag=false;
		}
		return flag;
	}

	public boolean validateWorkflowExitCode(boolean flag, int actual , String expected) {

		String methodName = "validateWorkflowExitCode";

		BaseSuite.reportLog("Validating Workflow execution exit code...");

		BaseSuite.reportLog("Exit Code is expected as "+expected);

		try {
			if(flag && expected.equalsIgnoreCase("zero")) {

				flag=workflowZeroExitCodeStatus(actual);

			}else if(flag && expected.equalsIgnoreCase("positive")) {

				flag=workflowPositiveExitCodeStatus(actual);
			}else if(flag && expected.equalsIgnoreCase("negative")) {

				flag=	workflowNegativeExitCodeStatus(actual);
			}else {

				BaseSuite.reportFailLog(" :: "+actual,methodName);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateWorkflowExitCode ");
		}

		return flag;

	}


	//create workflow using automation database details
	public boolean createWorkflowForSFE(DataTestingParameters param,String foldername,String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		String instanceid=null;
		try {
			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String expectedStatus=param.getWorkflowExecutionStatus();
			String exitcode=param.getWorkflowExecutionExitCode();
			boolean downloadZip=Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean isOverride=Boolean.parseBoolean(param.getOverrideType());

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag) {

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity, isOverride);	

					BaseSuite.reportLog(workflowSaveLog);

					flag = clickOnWorkflowSaveOption(flag,workflowPublish, workflowCreatedToastMsg,icedqUser);

					workflowid = getWorkflowIdOnWorkflowDetailsPage();

					flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(flag && !icedqUser.contains(readerFlag)) {

						String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

						instanceid = validateWorkflowRecentRunInfo();

						if ((!status.toLowerCase().contains(runningStatus))){

							BaseSuite.reportLog("Validating Workflow execution status....");

							flag=stringContainsOutput(status, expectedStatus, flag);

							String acexitcode = getValueOfField(workflowDetailsRecentRunExitCode, workflowExitCodeContent);

							int ec = Integer.parseInt(acexitcode);

							flag=validateWorkflowExitCode(flag, ec, exitcode);

							flag=validateWorkflowExecutionDetails(flag, workflowid, instanceid, downloadZip);
						}else {
							BaseSuite.reportFailLog("Workflow Execution is in running states for long time kindly check", "createWorkflowForSFE");
							flag=false;
						}


					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowForSFE ");

			flag=false;
		}

		return flag;

	}

	public String getValue(By locator, String label) {

		String value = "";
		isDisplayedInLoop(driver, 2, locator);

		if(isDisplayed(driver, locator)) {

			javascript(driver, scrollToElementArg, locator);

			value = getAttribute(driver, locator, attributeTextContent);

		}else {
			BaseSuite.reportFailLog(label+" "+notVisibleContent, "getValueOfField");
		}
		return value;
	}

	public int getInstanceidCount(String instaceId) {

		int count=0;
		try {
			int rrtp=Integer.parseInt(totalPageNumber(workflowRecentRunsChildMsg));

			if(1<rrtp) {

				isDisplayedInLoop(driver, rrtp, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  lastContent));
				javascript(driver, scrollToElementArg,returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  lastContent));
				displayAndClick(driver, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  lastContent));
			}

			for(int x =rrtp;x>=1;x--) {

				List<String> list = getRuleExecutionInstaceIdListFromWorkflow(true, instaceId);

				String currentPage=currentPageNumber(workflowRecentRunsChildMsg);

				if(Integer.parseInt(currentPage)!=1) {

					isDisplayedInLoop(driver, rrtp, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  preContent));
					javascript(driver, scrollToElementArg,returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  preContent));
					displayAndClick(driver, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  preContent));
				}
				count=count+list.size();
			}
		} catch (NumberFormatException e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getInstanceidCount ");
		}

		return count;
	}


	public String [][] getAllRuleInstanceTable(String instaceId) {
		String [][] table =null;
		int rsize=0;
		int row=0;
		try {

			int rrtp=Integer.parseInt(totalPageNumber(workflowRecentRunsChildMsg));

			rsize=getInstanceidCount(instaceId);

			table = new String[rsize+1][4];

			table[0] = ruleInstanceHeader;

			if(1<rrtp) {

				isDisplayedInLoop(driver, rrtp, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  lastContent));
				javascript(driver, scrollToElementArg,returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  lastContent));
				displayAndClick(driver, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  lastContent));
			}


			for(int x =rrtp;x>=1;x--) {

				List<String> list = getRuleExecutionInstaceIdListFromWorkflow(true, instaceId);

				for(int i =0;i<list.size();i++) {

					String num=Integer.toString(row+1);

					String id=getValue(returnElement(workflowExecutionRuleInstanceId, dynamicName, list.get(i)), "Rule run Instace ID");

					String name =getValue(returnElement(workflowExecutionRuleInstanceIdName, dynamicName, list.get(i)), "Rule Name ");

					String status=getValue(returnElement(workflowExecutionRuleInstanceStatus, dynamicName, list.get(i)), "Rule run Status");

					String type=getValue(returnElement(workflowExecutionRuleInstanceInstacetype, dynamicName, list.get(i)), "Rule run Instace Type");

					String code=getValue(returnElement(workflowExecutionRuleInstanceExitCode, dynamicName, list.get(i)), "Rule run Exit Code");

					String time=getValue(returnElement(workflowExecutionRuleInstanceElapsedTime, dynamicName, list.get(i)), "Rule run Elapsed Time");

					String tdate=getValue(returnElement(workflowExecutionRuleInstanceTriggeredDate, dynamicName, list.get(i)), "Rule run Triggered Date");

					String tby=getValue(returnElement(workflowExecutionRuleInstanceTriggeredBy, dynamicName, list.get(i)), "Rule run Triggered By");

					String [] data = {num,id, name,status,type,code,time,tdate,tby};

					table[row+1] = data;
					row++;
				}

				String currentPage=currentPageNumber(workflowRecentRunsChildMsg);

				if(Integer.parseInt(currentPage)!=1) {

					isDisplayedInLoop(driver, rrtp, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  preContent));
					javascript(driver, scrollToElementArg,returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  preContent));
					displayAndClick(driver, returnElement(workflwoRecentRunsChildPageArrow, dynamicName,  preContent));
				}
			}

			/**	BaseSuite.reportTableLog(table); **/
			BaseSuite.reportLog(createHtmlTable1(table,"Rule Recent Runs Details"));
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getAllRuleInstanceTable ");
		}
		return table;
	}

	public String [][] getInstanceTable(List<String> list) {
		String [][] table =null;
		try {

			/**	BaseSuite.reportLog("------------------------------- Rules Recent Runs Details -------------------------------");**/

			table = new String[list.size()+1][4];

			table[0] = ruleInstanceHeader;

			for(int i =0;i<list.size();i++) {

				String num=Integer.toString(i+1);

				String id=getValue(returnElement(workflowExecutionRuleInstanceId, dynamicName, list.get(i)), "Rule run Instace ID");

				String name =getValue(returnElement(workflowExecutionRuleInstanceIdName, dynamicName, list.get(i)), " Rule Name");

				String status=getValue(returnElement(workflowExecutionRuleInstanceStatus, dynamicName, list.get(i)), "Rule run Status");

				String type=getValue(returnElement(workflowExecutionRuleInstanceInstacetype, dynamicName, list.get(i)), "Rule run Instace Type");

				String code=getValue(returnElement(workflowExecutionRuleInstanceExitCode, dynamicName, list.get(i)), "Rule run Exit Code");

				String time=getValue(returnElement(workflowExecutionRuleInstanceElapsedTime, dynamicName, list.get(i)), "Rule run Elapsed Time");

				String tdate=getValue(returnElement(workflowExecutionRuleInstanceTriggeredDate, dynamicName, list.get(i)), "Rule run Triggered Date");

				String tby=getValue(returnElement(workflowExecutionRuleInstanceTriggeredBy, dynamicName, list.get(i)), "Rule run Triggered By");

				String [] data = {num,id, name,status,type,code,time,tdate,tby};

				table[i+1] = data;

			}
			/**	BaseSuite.reportTableLog(table); **/
			BaseSuite.reportLog(createHtmlTable1(table,"Rule Recent Runs Details"));
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getInstanceTable ");
		}
		return table;
	}

	public void getWorkflowInstanceTable() {

		try {

			/**		BaseSuite.reportLog("-------------------------------- Workflow Recent Runs Details --------------------------------");**/

			String [][] table = new String[2][4];

			String [] header = {"Seq","Instance ID","Name", "Status","Instance Type", "Exit Code","Elapsed Time","Triggered Date","Triggered By"};

			//		String [] header = {"Seq","Instance ID","Status","Instance Type", "Exit Code","Elapsed Time"};// UI changed for release 3

			table[0] = header;

			String id=getValue(workflowDetailsRecentRunInstanceId, "Workflow run Instace ID");

			String name=getValue(workflowDetailsRecentRunName, labelWorkflowName);

			String status=getValue(workflowDetailsRecentRunStatus, "Workflow Status");

			String type=getValue(workflowDetailsRecentRunInstanceType, "Workflow run Instace Type");

			String code=getValue(workflowDetailsRecentRunExitCode, "Workflow run Exit Code");

			String time=getValue(workflowDetailsRecentRunElapsedTime, "Workflow run Elapsed Time");

			String date=getValue(workflowDetailsRecentRunTriggeredDate, "Workflow run Triggered date");

			String tby=getValue(workflowDetailsRecentRunTriggeredBy, "Workflow run Triggered by");

			String [] data = {"1",id, name,status,type,code,time,date,tby};

			table[1] = data;

			BaseSuite.reportLog(createHtmlTable1(table,"Workflow Recent Runs Details"));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getWorkflowInstanceTable ");
		}

	}

	//select workflow rules flag
	public boolean selectWorkflowAddedRulesFlag(boolean flag, List<String> ruleList, String workflowJsonEntity) {

		try {
			if(!ruleList.isEmpty() && flag) {

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());

					if(i<(ruleList.size()-1)){
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFEUncheck);	
					}else {
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFELastSequence);	
					}

					if(i<(ruleList.size()-1)){
						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),"");

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),"");

					}else {

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),workflowToastUseColumnEnabled);

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),workflowToastActiveColumnEnabled);
					}
				}

				displayAndClick(driver, rulesDatasetsSearchBar);

				clear_Click_SendKeys(driver, 0, rulesDatasetsSearchBar, "");

				displayAndClick(driver, rulesDatasetsSearchButton);

			}
		} catch (Exception e) { 
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectWorkflowAddedRulesFlag ");

			flag=false;
		}

		return flag;
	}


	public boolean bulkOverrideFunctionality(boolean flag, String workflowOverrideJson) {


		try {
			if(flag) {
				List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowOverrideJson, jsonPathOverrideTypeList);

				/**	DataTestingParameters ruleOverrideParam=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH, ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);**/
				DataTestingParameters ruleOverrideParam=setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);

				for(int i =0;i<override.size();i++) {

					DataTestingParameters param =setWorkflowBulkOverrideParameters(workflowOverrideJson);

					switch(param.getOverrideType().toLowerCase()+"over1") {

					case "sourceover1":

						flag=multipleSourceConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getSourceConnection(), ruleOverrideParam.getOverrideSourceConnection(), "Override source connection ");

						break;

					case "targetover1":

						flag=multipleTargetConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getTargetConnection(), ruleOverrideParam.getOverrideTargetConnection(), "Override target connection ");
						break;

					case "ruleover1":

						flag=multipleParameterOverride(flag,  ruleOverrideParam.getRuleParameterName(), ruleOverrideParam.getOverrideParameter(), "Override parameter ");

						break;

					default:

						BaseSuite.reportErrorLog("override type not found kindly check "+param.getOverrideType());
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}

	public boolean changebulkOverrideFunctionality(boolean flag, String workflowOverrideJson) {


		try {
			if(flag) {
				List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowOverrideJson, jsonPathOverrideTypeList);

				/**	DataTestingParameters ruleOverrideParam=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH, ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);**/
				DataTestingParameters ruleOverrideParam=setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);

				for(int i =0;i<override.size();i++) {

					DataTestingParameters param =setWorkflowBulkOverrideParameters(workflowOverrideJson);

					switch(param.getOverrideType().toLowerCase()+"over") {

					case "sourceover":

						flag=multipleSourceConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getSourceConnection(), overrideChangeSourceConnection, "Override source connection");

						break;

					case "targetover":

						flag=multipleTargetConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getTargetConnection(), overrideChangeTargetConnection, "Override target connection");
						break;

					case "ruleover":

						flag=multipleParameterOverride(flag,  ruleOverrideParam.getRuleParameterName(), overrideChangeParameter, "Override parameter");

						break;

					default:

						BaseSuite.reportErrorLog("expected override type not found kindly check "+param.getOverrideType());
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" changebulkOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}
	public DataTestingParameters setWorkflowBulkOverrideParameters(String workflowOverrideJson) {

		DataTestingParameters param = new DataTestingParameters();

		try {

			param.setOverrideType(getJsonValueUsingJsonPathExpreesion(workflowOverrideJson, "$.overrides[0].subType"));
			param.setOverrideReplace(getJsonValueUsingJsonPathExpreesion(workflowOverrideJson, "$.overrides[?(@.subType==\'"+param.getOverrideType()+"\')].replace"));
			param.setOverrideFind(getJsonValueUsingJsonPathExpreesion(workflowOverrideJson, "$.overrides[?(@.subType==\'"+param.getOverrideType()+"\')].find"));

			return param;

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, "Error "+e.toString());
		}
		return param;

	}

	//create workflow using automation database details
	public boolean createWorkflowWithBulkOverrideFunctionality(DataTestingParameters param,String foldername, boolean downloadZip,String icedqUser){

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;

		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJson=param.getWorkflowSubscriptionJsonValue();
			String workflowOverrideJson=param.getWorkflowOverrideJsonValue();
			String expectedStatus= param.getWorkflowExecutionStatus();
			String exitcode=param.getWorkflowExecutionExitCode();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag) {

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowAddedRulesFlag(flag,ruleList, workflowJsonEntity);

					flag=bulkOverrideFunctionality(flag, workflowOverrideJson);

					BaseSuite.reportLog(workflowSaveContentLog);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag = clickOnWorkflowSaveOption(flag,workflowPublish, workflowCreatedToastMsg,icedqUser);

					workflowid = getWorkflowIdOnWorkflowDetailsPage();

					flag=subscriptionWorkflow(flag, workflowSubscriptionJson,icedqUser); 

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=runWorkflowAndValidateExecution(flag, workflowid, expectedStatus, exitcode, downloadZip, icedqUser);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowWithBulkOverrideFunctionality ");

			flag=false;
		}

		return flag;

	}

	public boolean runWorkflowAndValidateExecution(boolean flag,String workflowid,String expectedStatus,String exitcode, boolean downloadZip,String icedqUser) {
		String instanceid=null;
		try {
			if(flag && !icedqUser.contains(readerFlag)) {

				String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				instanceid = validateWorkflowRecentRunInfo();

				if ((!status.toLowerCase().contains(runningStatus))){

					BaseSuite.reportLog(workflowExecutionLog);

					flag=stringContainsOutput(status, expectedStatus, flag);

					String acexitcode = getValueOfField(workflowDetailsRecentRunExitCode, "Workflow run Exit Code");

					int ec = Integer.parseInt(acexitcode);

					flag=validateWorkflowExitCode(flag, ec, exitcode);

					flag=validateWorkflowExecutionDetails(flag, workflowid, instanceid, downloadZip);
				}else {
					BaseSuite.reportFailLog("Workflow Execution is in running state for long time kindly check " , "runWorkflowAndValidateExecution");
					flag=false;
					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

					getWorkflowInstanceTable();

					getInstanceTable(ruleInstanceId);
				}
			}else if(icedqUser.contains(readerFlag)) {

				clickOnButton(driver ,workflowDetailsRunButton, runContent, true);

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,workflowRunContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" runWorkflowAndValidateExecution ");

			flag=false;
		}

		return flag;
	}

	public String runWorkflowUsingRunOptions(String runType, String state,int count, String icedqUser) {

		if(runType.equalsIgnoreCase("Run Selected")) {

			runSelectedRule(true, true,count);

			if( icedqUser.contains(readerFlag)) {

				captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,workflowRunContent);

			}else {

				state=clickOnRefreshButtonOnRecentRuns(workflowRefreshCount);
			}
		}else if(runType.equalsIgnoreCase("Run from here")){

			runRuleFromHere(true, true);

			if( icedqUser.contains(readerFlag)) {

				captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,workflowRunContent);

			}else {

				state=clickOnRefreshButtonOnRecentRuns(workflowRefreshCount);
			}
		}

		return state;
	}


	public String selectAddedRulesSequenceAndExecute(String sequence, String runType, String icedqUser) {
		String state="";
		String [] seq;
		String seqLabel="Sequence ";
		String methodName="selectAddedRulesSequenceAndExecute";
		int seqCount=0;
		try {

			selectUncheckbox(workflowDetailsRulesTabSequenceMasterCheckbox, "Sequences Master");

			if(sequence.contains(",")) {

				seq = sequence.split(",");
				seqCount=seq.length;
				for(int i = 0 ;i<seq.length;i++) {

					By locator = returnElement(workflowSequenceNumCheckbox, dynamicName, seq[i]);

					isDisplayedInLoop(driver, 5, locator);

					javascript(driver, scrollToElementArg, locator);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					if(isDisplayed(driver, locator)) {

						selectcheckbox(driver, locator, seqLabel+Integer.toString(i+1));

					}else {
						BaseSuite.reportFailLog(seqLabel+Integer.toString(i+1)+" "+notVisibleContent, methodName);
					}

				}

			}else {
				By locator = returnElement(workflowSequenceNumCheckbox, dynamicName, sequence);
				seqCount=1;
				isDisplayedInLoop(driver, 5, locator);

				javascript(driver, scrollToElementArg, locator);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				if(isDisplayed(driver, locator)) {

					selectcheckbox(driver, locator, seqLabel+sequence);

				}else {
					BaseSuite.reportFailLog(seqLabel+sequence+" "+notVisibleContent, methodName);
				}
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			state=runWorkflowUsingRunOptions(runType, state,seqCount, icedqUser);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+methodName+" ");
		}
		return state;

	}

	//create workflow using automation database details
	public boolean createWorkflowAndExecuteSequence(String workflowJsonEntity, String workflowSubscriptionJSon,String sequence,String runType,boolean downloadZip,boolean isOverride,String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		String instanceid=null;
		String state="";
		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(workflowParam.getWorkflowfolderName());

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag) {

					flag=enterDetailsToAddNewWorkflowPane(flag,workflowParam.getWorkflowfolderName(), newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity, isOverride);	

					BaseSuite.reportLog(workflowSaveLog);

					flag = clickOnWorkflowSaveOption(flag,workflowPublish, workflowCreatedToastMsg,icedqUser);

					workflowid = getWorkflowIdOnWorkflowDetailsPage();

					flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(flag && !icedqUser.contains(readerFlag)) {

						state=selectAddedRulesSequenceAndExecute(sequence, runType,icedqUser);

						instanceid = validateWorkflowRecentRunInfo();

						if ((!state.toLowerCase().contains(runningStatus))){

							flag=validateWorkflowExecutionDetails(flag, workflowid, instanceid, downloadZip);

						}else {
							BaseSuite.reportFailLog(workflowLongRunMessage, "createWorkflowAndExecuteSequence");
							flag=false;
						}
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowAndExecuteSequence ");

			flag=false;
		}

		return flag;

	}

	public boolean validateAdvanceSearchField(boolean flag, String typeValue, String stateValue, String userName, String fullName) {

		String [] type = typeValue.split(",");

		for(int i=0;i<type.length;i++) {

			flag=validateNSelectWorkflowTypeInAdvanceSearch(flag, type[i],true);

			flag=validateNSelectWorkflowTypeInAdvanceSearch(flag, type[i],false);
		}


		String [] state = stateValue.split(",");

		for(int i=0;i<state.length;i++) {

			flag=validateNSelectWorkflowStateInAdvanceSearch(state[i],true);

			flag=validateNSelectWorkflowStateInAdvanceSearch(state[i],false);
		}

		String [] userN = userName.split(",");
		String [] fn = fullName.split(",");

		for(int i=0;i<userN.length;i++) {

			flag=validateNSelectUpdatedByUserInAdvanceSearch(flag, userN[i],fn[i],true);

			flag=validateNSelectUpdatedByUserInAdvanceSearch(flag, userN[i],fn[i],false);
		}
		return flag;
	}

	//advance search functionality
	public boolean advanceSearchForFunctional(boolean flag, String typeValue, String stateValue, String userName,String fullName, String startdate, String enddate) {

		try {
			if(flag) {

				verifyIndividualLabel(driver, advancedSearchTitle, advanceSearchContent);

				if(isDisplayed(driver, advancedSearchExpand)) {

					displayAndClick(driver, advancedSearchExpand);
				}

				isDisplayedInLoop(driver, 3, workflowAppliedFilterCross);

				if(isDisplayed(driver, workflowAppliedFilterCross)) {

					displayAndClick(driver, workflowAppliedFilterCross);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}


				validateAdvanceSearchField(flag, typeValue, stateValue, userName,fullName);

				flag=validateNSelectLastUpdatedInAdvanceSearch(flag, startdate, enddate);

				isDisplayedInLoop(driver, 3, workflowAppliedFilterCross);

				if(isDisplayed(driver, workflowAppliedFilterCross)) {

					displayAndClick(driver, workflowAppliedFilterCross);	
				}
				if(isDisplayed(driver, workflowFolderExpand)) {

					displayAndClick(driver, workflowFolderExpand);
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" advanceSearchFunctionality ");
			flag=false;
		}

		return flag;

	}

	//create workflow using automation database details
	public boolean createWorkflowToDiscardFunctionality(String workflowJsonEntity,String folderName, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;

		try {

			if(icedqUser.contains(readerFlag) || icedqUser.contains(executorContent) || icedqUser.contains(adminContent) ) {
				return clickOnNewWorkflowButton(flag,icedqUser);
			}

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(folderName);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag) {

					flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=discardWorkflowDetails(flag);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowToDiscardFunctionality ");

			flag=false;
		}

		return flag;

	}

	//create workflow using automation database details
	public boolean updateWorkflowToDiscardFunctionality(String workflowJsonEntity) {

		boolean flag = true;

		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());
			validateWorkflowCreateUpdatedFormat();
			flag=discardWorkflowDetails(flag);		

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowToDiscardFunctionality ");
			flag=false;
		}

		return flag;
	}

	//create workflow using automation database details
	public boolean updateWorkflowWithDeleteSequnceFunctionality(String updateWorkflowJsonEntity,boolean downloadZip, boolean exceptionReport,String removeSequence,String icedqUser){

		boolean flag = true;
		boolean dnd = true;
		String workflowid=null;
		String instanceid=null;
		String [] sequence = null;
		List<String> ruleList =null;
		int seqNum=0;
		try {

			sequence =removeSequence.split(",");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(updateWorkflowJsonEntity);

			ruleList = getJsonArrayValueUsingJsonPathExpreesion(updateWorkflowJsonEntity, workflowRuleListJsonPath);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			validateWorkflowCreateUpdatedFormat();

			clickonWorkflowRulesAndDatasetTab(flag);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

			for(int i=0;i<sequence.length;i++) {

				seqNum=Integer.parseInt(sequence[i])-1;

				DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(seqNum,updateWorkflowJsonEntity);

				flag=removeAddedRuleFromRulesAndDatasetsTab(flag,ruleParam.getRuleName(),ruleParam.getRuleFolderName());

			}

			searchRuleOnRulesAndDatasetTab("");

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowPublish, "",icedqUser);
			}else {
				flag = clickOnWorkflowSaveOption(flag,workflowPublish, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
				dnd=false;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && dnd) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				instanceid = validateWorkflowRecentRunInfo();

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if (flag && (!status.toLowerCase().contains(runningStatus))){

					flag=clickOnExecutionDetails();

					flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

					flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowParam.getWorkflowName(),exceptionReport);
				}else {
					BaseSuite.reportFailLog(workflowLongRunMessage , "updateWorkflowWithDeleteSequnceFunctionality");
					flag=false;
					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

					getWorkflowInstanceTable();

					getInstanceTable(ruleInstanceId);
				}

				removeAllAddedRulesFromWorkflow();

				flag=addRulesToWorkflowDetails(flag,ruleList, updateWorkflowJsonEntity);

				flag = clickOnWorkflowSaveOption(flag,"publish", "",icedqUser);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowWithDeleteSequnceFunctionality ");

			flag=false;
		}

		return flag;

	}


	public void continueNext(String methodName, ExtentTest test, String errorMsg, String fileName, String sheetName,
			int ruleNumber, String columnName){

		try {

			BaseClassUtil util = new BaseClassUtil();
			XLUtils xl = new XLUtils();

			// sheet
			xl.writeToExcel("Fail", fileName, sheetName, ruleNumber, columnName);// write the excel as fail into the
			// status
			// column
			test.error(" Test scenario :: " + ruleNumber + " failed");// log the error in
			// extent
			// report

			test.error(errorMsg);// Log the exception in extent report

			String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen
			// shot
			test.log(Status.FAIL, methodName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

			log.debug(errorMsg);// also log this error into application log

			/**	waitForElement(driver, workflowTab);

			//	displayAndClick(driver, workflowTab);**/

			if (isDisplayed(driver, discardWorkflowPopupDiscardButton)) {

				displayAndClick(driver, discardWorkflowPopupDiscardButton);// we have to click on yes button to discard
				// changed if
				// this message appears

			}

			log.debug(" Test scenario ::  " + ruleNumber + " failed");// log the rule number into log

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" continueNext ");

		}
	}


	// set workflow parameters using API
	public DataTestingParameters setWorkflowParametersUsingExcelData(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			param.setWorkflowName(xl.readUsingColName(fileName, sheetName, rowNumber, keyworkflowName));
			param.setFolderName(xl.readUsingColName(fileName, sheetName, rowNumber, keyfolderName));
			param.setWorkflowJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, keyworkflowJson));
			param.setWorkflowExecutionStatus(xl.readUsingColName(fileName, sheetName, rowNumber, keyexecutionStatus));
			param.setWorkflowExecutionExitCode(xl.readUsingColName(fileName, sheetName, rowNumber, keyexitCode));
			param.setSourceInput(xl.readUsingColName(fileName, sheetName, rowNumber, keysequence));

			param.setTestScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, ketTestScenario));
			param.setTestScenarioResult(xl.readUsingColName(fileName, sheetName, rowNumber, keytestResult));
			param.setOverviewContent(xl.readUsingColName(fileName, sheetName, rowNumber, "overviewContent"));
			param.setBulkOperationType(xl.readUsingColName(fileName, sheetName, rowNumber, "bulkOperation"));
			param.setRemoveWorkflowName(xl.readUsingColName(fileName, sheetName, rowNumber, "removeworkflowName"));
			param.setOverrideType(xl.readUsingColName(fileName, sheetName, rowNumber, keyisOverride));
			param.setExecutionstate(xl.readUsingColName(fileName, sheetName, rowNumber, keyrunType));
			param.setWorkflowStatus(xl.readUsingColName(fileName, sheetName, rowNumber, stateContent));
			return param;

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowParametersUsingExcelData "+e.toString());
		}
		return param;

	}

	public boolean runWorkflowAndValidateResults(boolean flag, String workflowid, String expectedStatus, String exitcode, boolean downloadZip) {

		try {
			if(flag) {

				String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				String instanceid = validateWorkflowRecentRunInfo();

				if ((!status.toLowerCase().contains(runningStatus))){

					BaseSuite.reportLog(workflowExecutionLog);

					flag=stringContainsOutput(status, expectedStatus, flag);

					String acexitcode = getValueOfField(workflowDetailsRecentRunExitCode, workflowExitCodeContent);

					int ec = Integer.parseInt(acexitcode);

					flag=validateWorkflowExitCode(flag, ec, exitcode);

					flag=validateWorkflowExecutionDetails(flag, workflowid, instanceid, downloadZip);
				}else {
					BaseSuite.reportFailLog(workflowLongRunMessage, "runWorkflowAndValidateResults");
					flag=false;

					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

					getWorkflowInstanceTable();

					getInstanceTable(ruleInstanceId);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" runWorkflowAndValidateResults ");

			flag=false;
		}
		return flag;
	}


	//create workflow using automation database details
	public boolean createWorkflowForSFEUsingExcel(DataTestingParameters param, String foldername,boolean isOverride,String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;

		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String expectedStatus=param.getWorkflowExecutionStatus();
			String exitcode=param.getWorkflowExecutionExitCode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			if(!icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

				flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

				if(!flag) { return flag;}

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(!flag) { return flag;}

				flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

				flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	

				BaseSuite.reportLog(workflowSaveContentLog);

				flag = clickOnWorkflowSaveOption(flag,workflowPublish, workflowCreatedToastMsg,icedqUser);

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=runWorkflowAndValidateResults(flag, workflowid, expectedStatus, exitcode, downloadZip);

			}else {
				flag= clickOnNewWorkflowButton(flag,icedqUser);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowForSFEUsingExcel ");

			flag=false;
		}

		return flag;

	}


	public boolean searchFolderFunctionality(String searchFoldername) {

		boolean flag=true;
		try {

			flag=searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, workflowFolderSearchPlaceholder, searchFoldername);

			return flag && isDisplayed(driver, returnElement(workflowFolderName, dynamicName, searchFoldername));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" searchFolderFunctionality ");

			return false;
		}

	}

	public boolean filterFolderFunctionality(String searchFoldername) {

		boolean flag=true;
		try {

			flag=searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, searchFolderContent, searchFoldername);

			if(!flag && !isDisplayed(driver, returnElement(workflowFolderName, dynamicName, searchFoldername))) {

				return false;
			}
			BaseSuite.reportLog("Clicking on folder checkbox "+searchFoldername);

			displayAndClick(driver, returnElement(selectExistingFolder, dynamicName, searchFoldername));

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Clicked on folder checkbox ");

			isDisplayedInLoop(driver, 5, returnElement(workflowListingPageFolderName, dynamicName, searchFoldername));

			BaseSuite.reportLog("verifying filtered list of workflows for folder : "+searchFoldername);

			new WorkflowServicePage(driver).getWorkflowsListingPageTable(false);

			if(isDisplayed(driver, returnElement(workflowListingPageFolderName, dynamicName, searchFoldername))) {

				flag=true;
				BaseSuite.validationReportLog("Folder filtered list of workflows are visible");

			}else {
				BaseSuite.reportFailLog("Folder filtered list of workflows are not visible","filterFolderFunctionality");
				flag=false;
			}

			displayAndClick(driver, returnElement(selectExistingFolder, dynamicName, searchFoldername));

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" filterFolderFunctionality ");

			flag=false;
		}
		return flag;
	}

	public boolean updateFolderFunctionality(String searchFolderName, String updatefolderName, String icedqUser) {

		Actions action = new Actions(driver);

		boolean flag=true;

		try {

			flag=searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, workflowFolderSearchPlaceholder, searchFolderName);

			isDisplayedInLoop(driver, 3,  returnElement(workflowFolderName, dynamicName, searchFolderName));

			if(flag && isDisplayed(driver, returnElement(workflowFolderName, dynamicName, searchFolderName))) {

				WebElement ele = driver.findElement(returnElement(workflowFolderName, dynamicName, searchFolderName));

				action.moveToElement(ele).click().perform();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				By locator = returnElement(workflowFolderNameEditButton, dynamicName, searchFolderName);

				isDisplayedInLoop(driver, 5, locator);

				if(isDisplayed(driver, locator)) {

					WebElement ele1 = driver.findElement(locator);

					action.moveToElement(ele1).click().perform();

					if(!isDisplayed(driver, enterNewFolderName)) {

						action.moveToElement(ele1).click().perform();
					}
				}
				BaseSuite.reportLog("Entering name : "+updatefolderName);
				sendKeys(driver,  enterNewFolderName, updatefolderName);

				BaseSuite.reportLog("Entered name : "+updatefolderName);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				waitForExecution(1000);

				driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent) || isDisplayed(driver, toastMsg)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Forbidden ");

				}else {
					BaseSuite.validationReportLog("Folder updated successfully");
				}

				clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateFolderFunctionality ");			
			flag=false;
		}
		return flag;
	}

	public boolean verifyFolderDelete(Boolean flag, String folderName) {

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, workflowFolderRefreshIcon);

			BaseSuite.reportLog("Refreshing folder list");

			for(int i=0;i<5;i++) {
				if(isDisplayed(driver, workflowFolderRefreshIcon)) {

					displayAndClick(driver, workflowFolderRefreshIcon);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
			}

			searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, searchFolderContent, folderName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(4000);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(isDisplayed(driver,  returnElement(workflowFolderName, dynamicName, folderName))) {
				flag=false;
				BaseSuite.reportFailLog("Searched folder is visible", "verifyFolderDelete");
			}else {
				BaseSuite.validationReportLog("Searched folder not found");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" verifyFolderDelete ");	
			flag=false;
		}

		return flag;
	}

	public boolean deleteFolderForSanity(String folderName, String icedqUser) {
		boolean flag=true;
		boolean state=true;
		Actions action = new Actions(driver);

		try {
			flag= searchFunctionalityMethod(driver, true, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, searchFolderContent, folderName);

			isDisplayedInLoop(driver, 3,  returnElement(workflowFolderName, dynamicName, folderName));
			if(flag && isDisplayed(driver, returnElement(workflowFolderName, dynamicName, folderName))) {

				WebElement ele = driver.findElement(returnElement(workflowFolderName, dynamicName, folderName));

				action.moveToElement(ele).click().perform();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				By locator = returnElement(workflowFolderNameDeleteButton, dynamicName, folderName);

				isDisplayedInLoop(driver, 5, locator);

				WebElement ele1 = driver.findElement(locator);

				action.moveToElement(ele).perform();

				ele1.click();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 5, workflowFolderDeletePopupTitle);

				if(isDisplayed(driver, workflowFolderDeletePopupTitle)) {

					verifyIndividualLabel(driver, workflowFolderDeletePopupTitle, "Delete Folder : ");

					String acDiscardMsg = getAttribute(driver, workflowFolderDeletePopupContent, attributeTextContent);

					stringContainsOutput(acDiscardMsg, workflowFolderDeletePopupWindContent, true);

					String acdeleteMsg = getAttribute(driver, workflowFolderDeletePopupSubContent, attributeTextContent);

					stringContainsOutput(acdeleteMsg, workflowFolderDeletePopupWindSubContent, true);

					verifyVisibilityOfButtons(driver, workflowFolderDeletePopupCancelButton, cancelContent, true);

					clickOnButton(driver, workflowFolderDeletePopupDeleteButton, deleteContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent)) {

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Forbidden");
						state=false;
					}else {

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, workflowFolderDeleteToastmsg, "Folder Delete");	

					}
					if(state) {
						flag=verifyFolderDelete(flag, folderName);
					}
				}else {
					BaseSuite.reportLog("Delete folder title not displayed");
				}		
			}

			clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteFolderForSanity ");
			flag=false;
		}
		return flag;
	}





	public boolean deleteFolderFunctionality(String folderName, String icedqUser) {

		Actions action = new Actions(driver);

		boolean flag=true;
		boolean state=true;
		try {
			flag= searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, searchFolderContent, folderName);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 3,  returnElement(workflowFolderName, dynamicName, folderName));
			if(flag && isDisplayed(driver, returnElement(workflowFolderName, dynamicName, folderName))) {

				WebElement ele = driver.findElement(returnElement(workflowFolderName, dynamicName, folderName));

				action.moveToElement(ele).click().perform();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				By locator = returnElement(workflowFolderNameDeleteButton, dynamicName, folderName);

				isDisplayedInLoop(driver, 5, locator);

				WebElement ele1 = driver.findElement(locator);

				ele1.click();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 5, workflowFolderDeletePopupTitle);

				if(isDisplayed(driver, workflowFolderDeletePopupTitle)) {

					verifyIndividualLabel(driver, workflowFolderDeletePopupTitle, "Delete Folder : ");

					String acDiscardMsg = getAttribute(driver, workflowFolderDeletePopupContent, attributeTextContent);

					stringContainsOutput(acDiscardMsg, workflowFolderDeletePopupWindContent, true);

					String acdeleteMsg = getAttribute(driver, workflowFolderDeletePopupSubContent, attributeTextContent);

					stringContainsOutput(acdeleteMsg, workflowFolderDeletePopupWindSubContent, true);

					verifyVisibilityOfButtons(driver, workflowFolderDeletePopupCancelButton, cancelContent, true);

					clickOnButton(driver, workflowFolderDeletePopupDeleteButton, deleteContent, true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent)) {

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Privilege");
						state=false;
					}else {

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, workflowFolderDeleteToastmsg, "Folder Delete");	

					}
					if(state) {
						flag=verifyFolderDelete(flag, folderName);
					}
				}else {
					BaseSuite.reportFailLog("Delete folder title not displayed", "deleteFolderFunctionality");
				}

				clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteFolderFunctionality ");

			flag=false;
		}
		return flag;
	}

	public boolean validateAfterWorkflowSave(String workflowid, String newWorkflowName,String workflowStatus, boolean downloadZip, boolean exceptionReport,String workflowExecutionStatus, String icedqUser) {

		boolean flag=true;
		String instanceid=null;
		try {
			if(workflowStatus.toLowerCase().contains(publishContent)) {

				if(!icedqUser.contains(readerFlag)) {

					String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

					instanceid = validateWorkflowRecentRunInfo();

					flag=searchRecentRunOnRecentRunsField(flag, instanceid);

					if ((flag && !status.toLowerCase().contains(runningStatus))){

						BaseSuite.reportLog(workflowExecutionLog);

						checkHyperLinkOrNot(workflowDetailsRecentRunInstanceIdHyperlink, "Workflow Instance Id", true);

						stringContainsOutput(status, workflowExecutionStatus, true);

						flag=clickOnExecutionDetails();isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

						flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, newWorkflowName, exceptionReport);
					}else {
						BaseSuite.reportFailLog(" Workflows Execution is in running state for long time kindly check" , "validateAfterWorkflowSave");
						flag=false;
						clickOnExecutionDetails();

						clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

						List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

						getWorkflowInstanceTable();

						getInstanceTable(ruleInstanceId);
					}

				}
			}else if(workflowStatus.toLowerCase().contains(validateContent) || workflowStatus.toLowerCase().contains(draftContent)) {

				verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

				verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, true);

				verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

				verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

				verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAfterWorkflowSave ");

			flag=false;
		}
		return flag;
	}


	//create workflow using automation database details
	public boolean createWorkflowInSpecifiedMode(DataTestingParameters param,String foldername,boolean isOverride, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;

		try {

			if(icedqUser.contains(readerFlag) || icedqUser.contains(executorContent) || icedqUser.contains(adminContent) ) {
				return clickOnNewWorkflowButton(flag,icedqUser);
			}

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername,icedqUser);

			if(!flag) {	return flag;}

			flag= clickOnNewWorkflowButton(flag,icedqUser);

			flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

			flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			if(!workflowMode.toLowerCase().contains(draftContent)) {

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	
			}
			flag = clickOnWorkflowSaveOption(flag,workflowMode, workflowCreatedToastMsg,icedqUser);

			if(!flag) {	return flag;}

			workflowid = getWorkflowIdOnWorkflowDetailsPage();

			subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport,workflowExecutionStatus, icedqUser);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowInSpecifiedMode ");

			flag=false;
		}

		return flag;

	}


	//create workflow using automation database details
	public boolean createWorkflowInSpecifiedModeAndPath(DataTestingParameters param,String foldername,boolean isOverride, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		log.info("validating csm workflow");
		try {

			if(icedqUser.contains(readerFlag) || icedqUser.contains(executorContent) || icedqUser.contains(adminContent) ) {
				return clickOnNewWorkflowButton(flag,icedqUser);
			}
			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					if(!workflowMode.toLowerCase().contains(draftContent)) {

						flag=clickonWorkflowRulesAndDatasetTab(flag);

						List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

						addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

						flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

						flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	
					}
					flag = clickOnWorkflowSaveOption(flag,workflowMode, workflowCreatedToastMsg,icedqUser);

					if(flag) {

						workflowid = getWorkflowIdOnWorkflowDetailsPage();

						subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport,workflowExecutionStatus, icedqUser);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowInSpecifiedModeAndPath ");

			flag=false;
		}

		return flag;

	}


	public boolean shuffleRulesInWorkflows(boolean flag, String sequence) {
		Actions act = new Actions(driver);
		try {
			if(!sequence.isEmpty()) {

				String[] seqs = sequence.split(";");

				for (int i = 0; i < seqs.length; i++) {

					String[] seq = seqs[i].split(",");

					if (flag) {
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Shuffling rules sequence from " + seq[0] + " to " + seq[1]);

						WebElement from = driver.findElement(returnElement(workflowRuleDragIcon, "$num", seq[0]));

						WebElement to = driver.findElement(returnElement(workflowRuleDragIcon, "$num", seq[1]));

						/**	act.dragAndDrop(from, to).build().perform();**/

						act.clickAndHold(from).moveToElement(to).release(to).build().perform();
						BaseSuite.reportLog("Shuffling rules sequence successfully ");
						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle + " shuffleRulesInWorkflows :: " + e.toString());

			flag = false;
		} 
		return flag;
	}

	public boolean removeAddedRulesFromWorkflow(boolean removeAll, String workflowJsonEntity) {
		boolean flag = true;
		try {
			clickonWorkflowRulesAndDatasetTab(true);

			List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

			if(removeAll) {
				removeAllAddedRulesFromWorkflow();
			}else {

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i,workflowJsonEntity);

					flag=removeAddedRuleFromRulesAndDatasetsTab(flag,ruleParam.getRuleName(),ruleParam.getRuleFolderName());

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle + " removeAddedRulesFromWorkflow :: " + e.toString());

			flag = false;
		}

		return flag;
	}

	//update workflow using automation database details
	public boolean updateWorkflowInSpecifiedMode(DataTestingParameters param,String sequenceShuffle,boolean isOverride ,String icedqUser){

		boolean flag = true;
		String workflowid=null;
		String instanceid=null;

		try {
			String workflowJsonEntity=param.getWorkflowJsonValue();
			/**		String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();**/
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String updateWorkflowJsonEntity= param.getWorkflowUpdateJsonValue();
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			/**	viewWorkflow(workflowJsonEntity, icedqUser);*/

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(updateWorkflowJsonEntity);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			validateWorkflowCreateUpdatedFormat();

			if(!workflowMode.toLowerCase().contains(draftContent) && !icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				removeAddedRulesFromWorkflow(BaseSuite.suiteType.equalsIgnoreCase("Sanity"), workflowJsonEntity);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(true);

				List<String> updateruleList = getJsonArrayValueUsingJsonPathExpreesion(updateWorkflowJsonEntity, workflowRuleListJsonPath);

				addRulesToWorkflowDetails(flag,updateruleList, updateWorkflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowRulesFlag(flag,updateruleList, updateWorkflowJsonEntity, isOverride);	

				flag=shuffleRulesInWorkflows(flag, sequenceShuffle);
			}

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);
			}else {
				return clickOnWorkflowSaveOption(flag,workflowMode, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);

			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag) && workflowMode.toLowerCase().contains(publishContent)) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				instanceid = validateWorkflowRecentRunInfo();

				BaseSuite.reportLog(workflowExecutionLog);
				stringContainsOutput(status, workflowExecutionStatus, true);

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if (flag && (!status.toLowerCase().contains(runningStatus))){

					flag=clickOnExecutionDetails();

					flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

					flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowParam.getWorkflowName(),exceptionReport);
				}else {
					BaseSuite.reportFailLog(workflowLongRunMessage , "updateWorkflowInSpecifiedMode");
					flag=false;
					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

					getWorkflowInstanceTable();

					getInstanceTable(ruleInstanceId);
				}
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowInSpecifiedMode ");

			flag=false;
		}

		return flag;

	}

	public boolean validateBulkOperationField( boolean flag,String overContent,String icedqUser) {

		if(!icedqUser.toLowerCase().contains(executorContent) && !icedqUser.toLowerCase().contains(readerContent) ) {

			flag=reviewInBulkChanges(flag, overContent,icedqUser);

			flag=progressInBulkChanges(flag);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		}
		return flag;
	}

	public boolean bulkOperationFunctionality(boolean flag, String bulkOperationType, String workflowName, String folderPath,String removeWorkflowName, String overContent,String icedqUser) {

		try {
			switch(bulkOperationType.toLowerCase().trim()) {

			case "copy":

				flag=clickOnMoreOptionAndSelectOption(flag, copyContent,icedqUser);

				if(flag && (!icedqUser.contains(executorContent) && !icedqUser.contains(readerContent))) {

					flag=chooseWorkflowsInBulkChangesWithRemove(flag, workflowName,removeWorkflowName);

					flag=chooseDestinationInBulkChanges(flag, folderPath);

				}

				break;
			case "move":

				flag=clickOnMoreOptionAndSelectOption(flag, moveContent,icedqUser);

				if(flag && (!icedqUser.contains(executorContent) && !icedqUser.contains(readerContent))) {

					flag=chooseWorkflowsInBulkChangesWithRemove(flag, workflowName,removeWorkflowName);

					flag=chooseDestinationInBulkChanges(flag, folderPath);

				}

				break;	
			case "delete":	

				flag=clickOnMoreOptionAndSelectOption(flag, deleteContent,icedqUser);

				if(flag && (!icedqUser.contains(executorContent) && !icedqUser.contains(readerContent))) {

					flag=chooseWorkflowsInBulkChangesWithRemove(flag, workflowName,removeWorkflowName);

				}

				break;

			default: 
				BaseSuite.reportErrorLog("bulk operation type not mentioned kindly check");
				break;
			}

			flag=validateBulkOperationField(flag, overContent, icedqUser);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkOperationFunctionality ");

			flag=false;
		}
		return flag;
	}

	public boolean selectCheckboxOfWorkflowAddedInBulkOperation(boolean flag, String [] workflow) {

		for(int i=0;i<workflow.length-1;i++) {

			String [] wkfl = workflow[i].split(",");
			String  wkflName = wkfl[0];
			String  wkflFolderName = wkfl[1];

			flag=searchFunctionalityMethod(driver, flag, bulkChangesChooseWorkflowSearchbar, bulkChangesChooseWorkflowSearchbutton, searchBoxLabel, workflowSearchPlaceholder, wkflName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName));

			if(flag && isDisplayed(driver, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName))) {

				BaseSuite.reportLog("clicking on workflow name checkbox");

				selectcheckbox(driver, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName),wkflName);

			}
		}

		return flag;
	}



	//choose workflow's tab in bulk changes
	public boolean chooseWorkflowsInBulkChangesWithRemove(boolean flag, String workflowName, String removeWorkflow) {

		try {
			isDisplayedInLoop(driver, 3, bulkChangesChooseWorkflowTab);

			if(flag && isDisplayed(driver, bulkChangesChooseWorkflowTab) && !workflowName.isEmpty()) {

				BaseSuite.reportLog("Choose Workflows tab is visible");

				javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowNextbutton);

				verifyVisibilityOfButtons(driver, bulkChangesChooseWorkflowRemovebutton, removeContent, false);
				verifyVisibilityOfButtons(driver, bulkChangesChooseWorkflowCancelbutton, cancelContent, true);
				verifyVisibilityOfButtons(driver, bulkChangesChooseWorkflowNextbutton, nextContent, true);

				javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowTab);

				verifyIndividualLabel(driver, returnElement(bulkChangesChooseWorkflowColumn, dynamicName, "Workflow Name"), "Workflow Name column");
				verifyIndividualLabel(driver, returnElement(bulkChangesChooseWorkflowColumn, dynamicName, descriptionContent), "Description column");
				verifyIndividualLabel(driver,  returnElement(bulkChangesChooseWorkflowColumn, dynamicName, folderContent), "Folder column");

				String [] workflow=workflowName.split(";");
				String [] removeWkfl=removeWorkflow.split(";");
				for(int i=0;i<removeWkfl.length;i++) {

					String [] wkfl = removeWkfl[i].split(",");
					String  wkflName = wkfl[0];
					String  wkflFolderName = wkfl[1];

					flag=searchFunctionalityMethod(driver, flag, bulkChangesChooseWorkflowSearchbar, bulkChangesChooseWorkflowSearchbutton, searchBoxLabel, workflowSearchPlaceholder, wkflName);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName));

					if(flag && isDisplayed(driver, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName))) {

						BaseSuite.reportLog("clicking on workflow name checkbox");

						selectcheckbox(driver, returnTwoElements(bulkChangesChooseWorkflowNameCheckbox,  dynamicName, wkflName, dynamicFolderName, wkflFolderName),wkflName);

						clickOnButton(driver,bulkChangesChooseWorkflowRemovebutton, removeContent, true);

						validateAndHandleWorkflowRemovePopupWindow(removeContent);

					}else {
						BaseSuite.reportFailLog("Expected workflow not found kindly check ","chooseWorkflowsInBulkChanges");
					}
				}

				selectCheckboxOfWorkflowAddedInBulkOperation(flag, workflow);

				javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowSearchbar);

				isDisplayedInLoop(driver, 3, bulkChangesChooseWorkflowSearchbar);

				displayAndClick(driver, bulkChangesChooseWorkflowSearchbar);

				clear_Click_SendKeys(driver, 0, bulkChangesChooseWorkflowSearchbar, "");

				isDisplayedInLoop(driver, 3, bulkChangesChooseWorkflowSearchbutton);

				displayAndClick(driver, bulkChangesChooseWorkflowSearchbutton);

				isDisplayedInLoop(driver, 3, bulkChangesChooseWorkflowNextbutton);

				javascript(driver, scrollToElementArg, bulkChangesChooseWorkflowNextbutton);

				flag=clickOnButton(driver, bulkChangesChooseWorkflowNextbutton, nextContent, true);


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" chooseWorkflowsInBulkChanges ");
			flag=false;
		}
		return flag;
	}

	//validate and handle rule delete pop up window
	public boolean validateAndHandleWorkflowRemovePopupWindow(String buttonName) {

		boolean flag = true;

		try {
			isDisplayedInLoop(driver, 3, bulkChangesRemoveWorkflowPopupTitle);

			if(isDisplayed(driver, bulkChangesRemoveWorkflowPopupTitle)) {

				BaseSuite.reportLog("Remove workflow window is visible");

				String content = getText(driver, bulkChangesRemoveWorkflowPopupContent);

				flag = stringContainsOutput(content, "Do you want to remove the workflow?", true);

				if(flag) {

					switch (buttonName.toUpperCase().trim()) {

					case "REMOVE":

						flag=clickOnButton(driver, bulkChangesRemoveWorkflowPopupRemovebtn, removeContent, true);

						break;

					case "CANCEL":

						flag=clickOnButton(driver, bulkChangesRemoveWorkflowPopupCancelbtn, cancelButtonContent, true);
						break;
					default:
						break;
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndHandleRuleDeletePopupWindow ");
			flag=false;
		}
		return flag;
	}

	public boolean bulkOperationOfCustomWorkflow(String bulkOperationType, String workflowName , String folderPath, String removeWorkflowName, String overContent, String icedqUser) {
		boolean flag = true;
		int x=0;
		try {

			if(!workflowName.isEmpty()) {

				String [] workflow = workflowName.split(";");

				for(int i=0;i<workflow.length;i++) {

					String value = workflow[i];
					String [] wkfl = value.split(",");
					String  wkflName = wkfl[0];
					String  wkflFolderName = wkfl[1];

					flag=searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, searchBoxLabel, workflowSearchPlaceholder, wkflName);

					selectcheckbox(driver, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, wkflFolderName), "Name:"+wkflName+" folder:"+wkflFolderName);

					x = getLocatorIsDisplayCount(x, returnTwoElements(selectWorkflowCheckboxUsingFolder, dynamicName, wkflName, dynamicFolderName, wkflFolderName));
				}

				if(flag && x>0) {

					flag=bulkOperationFunctionality(flag, bulkOperationType, workflowName, folderPath,removeWorkflowName, overContent,icedqUser);
				}else {
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkOperationOfCustomWorkflow ");

			flag=false;
		}
		return flag;
	}

	public void validateButtonsForWorkflowDetails(boolean flag,String workflowStatus,String icedqUser) {

		if(flag && !icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {
			switch (workflowStatus.toLowerCase().trim()) {

			case "draft":
			case "validate":	
				verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

				verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, true);

				verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

				verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsReloadButton, recentRunsContent, true);

				verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

				verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

				break;

			case "publish":

				verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, true);

				verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, false);

				verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

				verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsReloadButton, recentRunsContent, true);

				verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

				verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

				break;	

			default:
				break;
			}
		}
	}

	public void validateButtonsForWorkflowDetailsOnRevisit(String workflowStatus) {

		switch (workflowStatus.toLowerCase().trim()) {

		case "draft":
		case "validated":	

			verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, true);

			verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsReloadButton, recentRunsContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

			break;

		case "published":

			verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, false);

			verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsReloadButton, recentRunsContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

			break;	

		default:
			break;
		}
	}


	public boolean validateAndUpdateSubscription(String workflowJsonEntity,String workflowSubscriptionJson,String expectedStatus,String exitcode,boolean downloadZip, String icedqUser) {
		boolean flag=false;
		String workflowid;

		try {
			flag=viewWorkflow(workflowJsonEntity, icedqUser);

			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=subscriptionWorkflow(flag, workflowSubscriptionJson,icedqUser); 

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=runWorkflowAndValidateExecution(flag, workflowid, expectedStatus, exitcode, downloadZip, icedqUser);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndUpdateSubscription ");
			flag=false;
		}

		return flag;
	}



	//create workflow using automation database details
	public boolean updateWorkflowWithBulkOverrideFunctionality(DataTestingParameters param,String icedqUser){

		boolean flag = true;
		String workflowid=null;
		boolean dnd=true;
		try {
			String workflowJsonEntity=param.getWorkflowJsonValue();

			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();

			String workflowMode=param.getWorkflowSaveMode();

			String expectedStatus = param.getWorkflowExecutionStatus();

			String exitcode = param.getWorkflowExecutionExitCode();

			String workflowOverrideJson = param.getWorkflowOverrideJsonValue();

			String updateWorkflowJsonEntity = param.getWorkflowUpdateJsonValue();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(updateWorkflowJsonEntity);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			validateWorkflowCreateUpdatedFormat();

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				clickonWorkflowRulesAndDatasetTab(flag);

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowAddedRulesFlag(flag,ruleList, workflowJsonEntity);

				flag=bulkOverrideFunctionality(flag, workflowOverrideJson);

				BaseSuite.reportLog(workflowSaveContentLog);
			}
			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);
			}else {
				flag = clickOnWorkflowSaveOption(flag,workflowMode, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
				dnd=false;
			}

			if(flag && dnd) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				flag=runWorkflowAndValidateExecution(flag, workflowid, expectedStatus, exitcode, true, icedqUser);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowWithBulkOverrideFunctionality ");

			flag=false;
		}

		return flag;

	}


	public boolean toastMessageValidationForGrant(boolean hasPrivilege,String expectedToastMessage, String label, String icedqUser) {

		boolean flag = true;

		if(icedqUser.toLowerCase().trim().contains(ownerContent) && hasPrivilege && !expectedToastMessage.isEmpty() ) {

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, label);	

		}else if(icedqUser.toLowerCase().trim().contains(contributorContent) && hasPrivilege  && !expectedToastMessage.isEmpty()) {

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, label);	

		}else if(icedqUser.toLowerCase().trim().contains(executorContent) && hasPrivilege  && !expectedToastMessage.isEmpty()) {

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, label);	

		}else if(icedqUser.toLowerCase().trim().contains(readerContent) && hasPrivilege  && !expectedToastMessage.isEmpty()) {

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, label);	

		}else if(!hasPrivilege){

			flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, label);
		}


		return flag;
	}


	// set workflow parameters using api
	public DataTestingParameters setWorkflowOverrideParameterUsingExcelData(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			if(ConstantProperty.OVERRIDE_SOURCE_CONNECTION.isEmpty()) {	

				param.setOverrideSourceConnection(xl.readUsingColName(fileName, sheetName, rowNumber, sourceColumnName));
				param.setOverrideTargetConnection(xl.readUsingColName(fileName, sheetName, rowNumber, targetColumnName));
				param.setOverrideParameter(xl.readUsingColName(fileName, sheetName, rowNumber, parameterColumnName));

			}else {
				param.setOverrideSourceConnection(ConstantProperty.OVERRIDE_SOURCE_CONNECTION);
				param.setOverrideTargetConnection(ConstantProperty.OVERRIDE_TARGET_CONNECTION);
				param.setOverrideParameter(ConstantProperty.OVERRIDE_PARAMETER);
			}
			return param;

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowOverrideParameterUsingExcelData "+e.toString());
		}
		return param;

	}

	//update workflow 
	public boolean updateWorkflowAndExecuteSequenceForExcel(DataTestingParameters param,String icedqUser) {

		boolean flag = true;
		String workflowid=null;
		String instanceid=null;
		String preinstanceid="";
		String state="";
		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String sequence=param.getSourceInput();
			String runType=param.getExecutionstate();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean isOverride=	Boolean.parseBoolean(param.getOverrideType());	

			if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

				clickonWorkflowRulesAndDatasetTab(flag);	

				flag=removeAllAddedRulesFromWorkflow();

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity, isOverride);	

				BaseSuite.reportLog(workflowSaveLog);

				flag = clickOnWorkflowSaveOption(flag,workflowPublish, "",icedqUser);

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag)) {

				preinstanceid=verifyInstanceID();

				state=selectAddedRulesSequenceAndExecute(sequence, runType,icedqUser);

				instanceid = validateWorkflowRecentRunInfo();

				if(!instanceid.contains(preinstanceid)) {

					flag=searchRecentRunOnRecentRunsField(flag, instanceid);

					if ((!state.toLowerCase().contains(runningStatus))){

						flag=validateWorkflowExecutionDetails(flag, workflowid, instanceid, downloadZip);

					}else {
						BaseSuite.reportFailLog(workflowExecutionStuckLog, "updateWorkflowAndExecuteSequenceForExcel");
						flag=false;

						clickOnExecutionDetails();

						clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

						List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

						getWorkflowInstanceTable();

						getInstanceTable(ruleInstanceId);
					}
					searchRecentRunOnRecentRunsField(true, "");
				}
				else {
					BaseSuite.reportFailLog(workflowInstanceIdNotLog+previousIdLog+preinstanceid+currentIdLog+instanceid, "updateWorkflowAndExecuteSequenceForExcel");
					flag=false;	
				}
			}else if(flag && icedqUser.contains(readerFlag)) {

				selectAddedRulesSequenceAndExecute(sequence, runType,icedqUser);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowAndExecuteSequenceForExcel ");

			flag=false;
		}

		return flag;

	}	

	public boolean removeAllAddedRulesFromWorkflow() {
		boolean flag=true;
		try {

			javascript(driver, scrollToElementArg, workflowDetailsRulesMasterCheckbox);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			selectcheckbox(driver, workflowDetailsRulesMasterCheckbox, "Rules Master checkbox");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnButton(driver, rulesDatasetsDeleteButton, deleteField, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!flag) { return false;}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Clicking on rule remove popup window delete button");

			isDisplayedInLoop(driver, 1, ruleDatasetDeletePopupDeleteButton);
			if(!isDisplayed(driver, ruleDatasetDeletePopupDeleteButton)){

				BaseSuite.reportLog("Reattempting to click on delete icon as popup not appears");

				flag=clickOnButton(driver, rulesDatasetsDeleteButton, deleteField, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			flag=clickOnButton(driver, ruleDatasetDeletePopupDeleteButton, deleteButtonContent, true);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeAllAddedRulesFromWorkflow ");
			flag=false;
		}
		return flag;
	}

	public boolean validateRunButtonFunctionality() {

		boolean flag=false;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, workflowDetailsRunButton);

			flag=clickOnButton(driver, workflowDetailsRunButton, runContent, true);

			if(flag) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,workflowRunContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRunButtonFunctionality ");
			flag=false;
		}

		return flag;
	}

	//update workflow using automation database details
	public boolean updateWorkflowWithSameInSpecifiedMode(DataTestingParameters param,String sequenceShuffle,boolean isOverride ,String icedqUser){

		boolean flag = true;
		String workflowid=null;
		String instanceid=null;
		boolean dnd=true;
		List<String> updateruleList =null;
		List<String> ruleList =null;
		try {
			String workflowJsonEntity=param.getWorkflowJsonValue();
			/**		String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();**/
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String updateWorkflowJsonEntity= param.getWorkflowJsonValue();

			/**		viewWorkflow(workflowJsonEntity, icedqUser);**/

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(updateWorkflowJsonEntity);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			validateWorkflowCreateUpdatedFormat();

			if(!workflowMode.toLowerCase().contains(draftContent) && !icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				clickonWorkflowRulesAndDatasetTab(flag);

				ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				clickOnWorkflowSidebarPanelOpenOrClose(false);

				removeAllAddedRulesFromWorkflow();

				flag=clickOnWorkflowSidebarPanelOpenOrClose(true);

				updateruleList = getJsonArrayValueUsingJsonPathExpreesion(updateWorkflowJsonEntity, workflowRuleListJsonPath);

				addRulesToWorkflowDetails(flag,updateruleList, updateWorkflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowRulesFlag(flag,updateruleList, updateWorkflowJsonEntity, isOverride);	

				flag=shuffleRulesInWorkflows(flag, sequenceShuffle);
			}

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);
			}else {
				flag = clickOnWorkflowSaveOption(flag,workflowMode, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
				dnd=false;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag) && workflowMode.toLowerCase().contains(publishContent) && dnd) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				String status=clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");

				instanceid = validateWorkflowRecentRunInfo();

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if (flag && (!status.toLowerCase().contains(runningStatus))){

					flag=clickOnExecutionDetails();

					flag=downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

					flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowParam.getWorkflowName(),exceptionReport);
				}else {
					BaseSuite.reportFailLog(workflowLongRunMessage , "updateWorkflowInSpecifiedMode");
					flag=false;
					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					/**	List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);**/

					getWorkflowInstanceTable();

					getAllRuleInstanceTable(instanceid);
				}

				removeAllAddedRulesFromWorkflow();

				flag=addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowWithSameInSpecifiedMode ");

			flag=false;
		}

		return flag;

	}



	public boolean createChildFolder(String folderPath) {

		Actions action = new Actions(driver);

		String [] folder = folderPath.split("/");

		String parent=folder[1];

		String childFolder = folder[2];

		boolean flag=true;

		BaseSuite.reportLog("Searching for folder path : "+folderPath);

		searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, searchFolderContent, childFolder);

		isDisplayedInLoop(driver, 3,  returnElement(folderName, dynamicName, folderPath));

		if(!isDisplayed(driver,  returnElement(folderName, dynamicName, folderPath))) {

			BaseSuite.reportLog("Searching for parent folder : "+parent);

			searchFunctionalityMethod(driver, flag, workflowFolderFilterSearchBar, workflowFolderFilterSearchButton, searchFolderContent, searchFolderContent, parent);

			isDisplayedInLoop(driver, 3,  returnElement(folderName, dynamicName, "/"+parent));

			if(isDisplayed(driver, returnElement(folderName, dynamicName, "/"+parent))) {

				BaseSuite.reportLog("Creating child folder : "+childFolder);

				WebElement ele = driver.findElement(returnElement(folderName, dynamicName, "/"+parent));

				action.moveToElement(ele).click().perform();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				By locator = returnElement(workflowFolderNameAddButton, dynamicName, parent);

				isDisplayedInLoop(driver, 5, locator);

				if(isDisplayed(driver, locator)) {

					WebElement ele1 = driver.findElement(locator);

					action.moveToElement(ele1).click().perform();

					if(!isDisplayed(driver, enterNewFolderName)) {

						action.moveToElement(ele1).click().perform();
					}

					sendKeys(driver,  enterNewFolderName, childFolder);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, folderCreatedToastMsg, folderContent+createdContent);
				}
			}
		}
		return flag;
	}	


	public void selectFolderOnAddNewWorkflowPane(String folderPath) {

		Actions action = new Actions(driver);

		String [] folder = folderPath.split("/");

		/**		String parent=folder[1];**/

		String childFolder = folder[2];

		boolean flag=true;

		BaseSuite.reportLog("Searching for folder path : "+folderPath);

		searchFunctionalityMethod(driver, flag, addNewSearchBar, addNewFolderSearchButton, searchFolderContent, searchPlaceholder, childFolder);

		isDisplayedInLoop(driver, 3, returnElement(addNewWorkflowfolderPath, dynamicName, folderPath));

		if(isDisplayed(driver, returnElement(addNewWorkflowfolderPath, dynamicName, folderPath))) {

			WebElement ele = driver.findElement( returnElement(addNewWorkflowfolderPath, dynamicName, folderPath));

			action.moveToElement(ele).click().perform();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, returnElement(addNewWorkflowFolderSelect, dynamicName, folderPath));

		}

	}


	//Workflow UI 



	public void validatePageArrow() {

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			BaseSuite.reportLog("Verifying pagination arrows");

			List<WebElement> arrows = getElements(driver, pagearrow);

			for (int j = 0; j < arrows.size(); j++) {

				String arrow = arrows.get(j).getAttribute(attributeTitle).replace("Go to", "");

				BaseSuite.reportLog("Checking page arrow :: " + arrow);

				String status = arrows.get(j).getAttribute("class");

				if(arrow.toLowerCase().contains("next") || arrow.toLowerCase().contains(lastContent)) {

					if (status.contains(disableContent)) {

						BaseSuite.validationReportLog(pageArrowContent + arrow + " is disabled");

					} else {
						BaseSuite.reportFailLog(pageArrowContent + arrow + " is enabled","validatePageArrow");
					}
				}else {

					if (status.contains(disableContent)) {

						BaseSuite.reportFailLog(pageArrowContent + arrow + " is disabled","validatePageArrow");

					} else {
						BaseSuite.validationReportLog(pageArrowContent + arrow + " is enabled");
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"validatePageArrow ");
		}
	}


	public void clickOnPageNumber(int pageNum ) {

		String pageinfo; 
		int totalpage;
		int currentpage;

		try {
			pageinfo = getAttribute(driver, paginationMsg, attributeAriaLabel);

			totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

			currentpage = Integer.parseInt(pageinfo.split(" ")[0]);

			if(pageNum!=currentpage) {

				if(isDisplayed(driver, returnElement(paginationNumberLink, dynamicNumber, String.valueOf(pageNum)))) {

					BaseSuite.reportLog("Clicking on Page :: "+pageNum);

					displayAndClick(driver, returnElement(paginationNumberLink, dynamicNumber, String.valueOf(pageNum)));


				}else {
					BaseSuite.reportFailLog("Page number not visible :: "+pageNum,"clickOnPageNumber");
				}
			}
			if(pageNum==totalpage) {

				validatePageArrow();

			}
		} catch (NumberFormatException e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"clickOnPageNumber ");
		}

	}

	public void checkWorkflowAppliedFilterText(String expected) {

		try {
			isDisplayedInLoop(driver, 3, workflowAppliedFilterMessage);

			if(isDisplayed(driver, workflowAppliedFilterMessage)) {

				String text = getAttribute(driver, workflowAppliedFilterMessage, attributeTextContent);

				stringContainsOutput(text, expected, true);

			}else {
				BaseSuite.reportFailLog("Workflow Applied Filter text not visible", "checkWorkflowAppliedFilterText");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"checkWorkflowAppliedFilterText ");
		}
	}


	//validate workflow listing page UI 
	public boolean validateWorkflowsListingPageUI() {
		boolean flag =true;
		String methodName="validateWorkflowsListingPageUI";
		HomePage hp=new HomePage(driver);
		try {

			clickOnButton(driver, refreshWorkflowButton, refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			hp.validateNextgenModuleAndDataTestingSubModules();

			verifyIndividualLabel(driver, workflowTitle, workflowsTitle);

			verifySearchField(driver, workflowSearchField, "Search Workflow", workflowSearchPlaceholder);

			validateWorkflowListingPageButtons(true, true, false);

			validateColumnsListForWorkflowService(workflowListingPageColumnList, workflowListingPageColumn, "Workflow Listing page");

			if(isDisplayed(driver, workflowFolderExpand)) {

				displayAndClick(driver, workflowFolderExpand);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			verifyIndividualLabel(driver, workflowFolderSearchTitle, labelFolderSearch);

			validateIsDisplayedOrNot(driver, workflowFolderRefreshIcon, "Folder refresh icon", flag);

			verifySearchField(driver, workflowFolderSearchField, labelFolderSearch, workflowFolderSearchPlaceholder);

			verifyVisibilityOfButtons(driver, workflowFolderSearchNewFolderButton, "New Folder", true);

			verifyIndividualLabel(driver, workflowAdvancedSearchTitle, advanceSearchContent);

			getPaginationDetails(driver, workflowListingPageMsg, workflowListingPagearrow,workflowListingPageNoRecordDisplay, workflowContent+listingContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+methodName+" ");

			flag=false;
		}	
		return flag;
	}


	public void clickOnPageArrow(String slocator, String arrow ) {
		String logs1=" Page Arrow ";
		String logs2="Clicking on ";
		try {

			By locator = returnElement(slocator, dynamicName, arrow.toLowerCase().trim());

			isDisplayedInLoop(driver, 3, locator);

			if(isDisplayed(driver, locator)) {

				BaseSuite.reportLog(logs2+arrow+logs1);

				displayAndClick(driver, locator);

				BaseSuite.reportLog(clickedOn+arrow+logs1);

			}else {
				BaseSuite.reportFailLog("Page not visible :: "+arrow,"clickOnPageArrow");
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(arrow.equalsIgnoreCase(lastContent)) {

				validatePageArrow();

			}
		} catch (NumberFormatException e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"clickOnPageArrow"+" ");
		}

	}

	public void clickOnPage(String slocator, String arrow ) {
		String logs1=" Page Arrow ";
		String logs2="Clicking on ";
		try {

			By locator = returnElement(slocator, dynamicName, arrow.toLowerCase().trim());

			isDisplayedInLoop(driver, 3, locator);

			if(isDisplayed(driver, locator)) {

				BaseSuite.reportLog(logs2+arrow+logs1);

				javascript(driver, scrollToElementArg,locator);

				displayAndClick(driver, locator);

				BaseSuite.reportLog(clickedOn+arrow+logs1);

			}else {
				BaseSuite.reportFailLog("Page not visible :: "+arrow,"clickOnPage");
			}

		} catch (NumberFormatException e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"clickOnPage"+" ");
		}

	}



	public boolean validateWorkflowsTabLandingPage() {

		boolean flag=true;
		try {

			validateWorkflowsListingPageUI();

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+"validateWorkflowsTabLandingPage ");

			flag=false;

		}
		return flag;
	}


	public void validateColumnsListForWorkflowService(String columnsList, String columnLocator, String label) {

		try {

			BaseSuite.reportLog("Verifying columns of "+label);

			String [] columnName = columnsList.split(",");

			for(int i=0;i<columnName.length;i++) {

				By locator = returnElement(columnLocator, dynamicName, columnName[i]);

				/**	javaScript(driver, scrollToElementArg, locator);**/

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.reportLog((i+1)+". "+columnContent+columnName[i]+visibleContent);
				}else {
					BaseSuite.reportFailLog((i+1)+". "+columnContent+columnName[i]+notVisibleContent, "validateColumnsListForWorkflowService");
				}	
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateColumnsListForWorkflowService ");

		}

	}


	public boolean validateGUIOfWorkflowDetailsPage(DataTestingParameters param, String foldername, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowJsonEntity=param.getWorkflowJsonValue();

		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, customContent);

					verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

					verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, true);

					verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

					verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, false);

					verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, false);

					validateFolderSearchSideBar(true);

					validateRuleOnWorkflowDetailsPage(true);

					clickOnWorkflowSidebarPanelOpenOrClose(false);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					clickOnWorkflowSidebarPanelOpenOrClose(true);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					clickOnWorkflowSidebarPanelOpenOrClose(false);

					verifyIndividualLabel(driver, workflowDetailsDiagramContent, workflowDetailsDiagramContentMessage);

					validateIsDisplayedOrNot(driver, workflowDetailsZoomInButton, "Zoom In", true);

					validateIsDisplayedOrNot(driver, workflowDetailsZoomOutButton, "Zoom Out", true);

					validateIsDisplayedOrNot(driver, workflowDetailsZoomToFitButton, "Zoom To Fit", true);

					verifyVisibilityOfButtons(driver, workflowDetailsOverviewTab, overviewContent, true);

					verifyVisibilityOfButtons(driver, workflowDetailsRuleAndDatasetsTab, rulesContent, true);

					validateRulesAndDatasetsFields();

					validateColumnsListForWorkflowService(workflowDetailsRulesTabColumns, workflowDetailsRulesTabColumnLocator, "Rules tab on workflow details page");

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"validateGUIOfWorkflowDetailsPage ");

			flag=false;
		}
		return flag;
	}

	//multiple source connection override
	public boolean validateBulkSourceConnectionOverride(boolean flag) {

		try {
			if(flag) {

				waitForExecution(3000); 

				javascript(driver, scrollToElementArg, rulesDatasetsSourceConnOverrideButton);

				clickOnButton(driver, rulesDatasetsSourceConnOverrideButton, sourceConnectionOverrideField, flag);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

				if(isDisplayed(driver, sourceConnOverrideTitle)) {

					verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

					verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

					verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

					verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, false);

					verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

					verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, false);

				}else {
					BaseSuite.reportFailLog(sourceConnectionField+overrideFunctionalityErrorLog, "validateBulkSourceConnectionOverride");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateBulkSourceConnectionOverride ");

			flag=false;
		}

		return flag;

	}

	//multiple target connection override
	public boolean validateBulkTargetConnectionOverride(boolean flag) {

		try {
			if(flag) {

				javascript(driver, scrollToElementArg, rulesDatasetsTargetConnOverrideButton);

				clickOnButton(driver, rulesDatasetsTargetConnOverrideButton, targetConnectionOverrideField, flag);

				isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

				if(isDisplayed(driver, sourceConnOverrideTitle)) {

					verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

					verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

					verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

					verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, false);

					verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

					verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, false);	
				}else {
					BaseSuite.reportFailLog(targetConnectionField+overrideFunctionalityErrorLog, "validateBulkTargetConnectionOverride");
					flag=false;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateBulkTargetConnectionOverride ");

			flag=false;
		}

		return flag;

	}

	//multiple parameter override
	public boolean validateBulkParameterOverride(boolean flag) {

		try {
			if(flag) {

				javascript(driver, scrollToElementArg, rulesDatasetsParameterConnOverrideButton);

				clickOnButton(driver, rulesDatasetsParameterConnOverrideButton, parameterOverrideField, flag);

				isDisplayedInLoop(driver, 3, parameterOverrideTitle);

				if(isDisplayed(driver, parameterOverrideTitle)) {

					verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

					verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

					verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

					verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, false);

					verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, false);

					verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, false);

				}else {
					BaseSuite.reportFailLog(parameterField+overrideFunctionalityErrorLog, "validateBulkParameterOverride");
					flag=false;
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateBulkParameterOverride ");

			flag=false;
		}

		return flag;

	}

	//view workflow and validate fields
	public boolean validateExisitingCustomWorkflowDetailsPage(String workflowJsonEntity) {

		boolean flag =true;

		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			verifyVisibilityOfButtons(driver, workflowBreadcrumbHomeLink, homeContent, true);

			verifyVisibilityOfButtons(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, true);

			verifyVisibilityOfButtons(driver, workflowBreadcrumbWorkflowsLink, workflowContent, true);

			verifyIndividualLabel(driver, returnElement(workflowNameTitle, dynamicName, workflowParam.getWorkflowName()), workflowParam.getWorkflowName());

			validateFolderSearchSideBar(true);

			validateRuleOnWorkflowDetailsPage(true);

			verifyVisibilityOfButtons(driver, workflowDetailsOverviewTab, overviewContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsRuleAndDatasetsTab, rulesContent, true);

			clickOnButton(driver, workflowDetailsOverviewTab, overviewContent, true);

			viewAndValidateField(workflowDetailsWorkflowNameField, fieldWorkflowName, workflowParam.getWorkflowName(), true);

			viewAndValidateField(workflowDetailsWorkflowCodeField, workflowCodeContent, workflowParam.getWorkflowCode(), true);

			viewAndValidateField(workflowDetailsDescriptionField, "Workflow "+descriptionContent, workflowParam.getWorkflowDescription(), true);

			validateWorkflowCreateUpdatedFormat();

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, workflowDetailsCurrentStatus);

			String acStatus = getAttribute(driver, workflowDetailsCurrentStatus, attributeTitle);

			validateButtonsForWorkflowDetailsOnRevisit(acStatus);

			flag=clickonWorkflowRulesAndDatasetTab(true);

			validateRulesAndDatasetsFields();

			validateBulkSourceConnectionOverride(true);

			validateBulkTargetConnectionOverride(true);

			validateBulkParameterOverride(true);

			if(isDisplayed(driver, parameterOverrideCross)) {clickOnButton(driver, parameterOverrideCross, "parameter override cross", true);}

			validateColumnsListForWorkflowService(workflowDetailsRulesTabColumns, workflowDetailsRulesTabColumnLocator, "Rules tab on workflow details page");

			List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

			validateAddedRuleInWorkflow(true, ruleList, workflowJsonEntity);

			searchRecentRunOnRecentRunsField(true, "");

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunRefreshButton, refreshContent, true);

			validateColumnsListForWorkflowService(workflowDetailsRecentRunsTabColumns, workflowDetailsRecentRunsTabColumnLocator, "Recent Runs tab on workflow details page");

			getPaginationDetails(driver, workflowDetailsRecentRunsPaginationMsg, workflowDetailsRecentRunsPagearrow, workflowDetailsPageRecentRunsNoRecordDisplay,recentRunsContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateExisitingCustomWorkflowDetailsPage ");

			flag=false;
		}
		return flag;
	}



	public void clickOnBreadcrumbLink(String link) {

		switch(link.toLowerCase().trim()) {

		case "home":

			clickOnButton(driver, workflowBreadcrumbHomeLink, homeContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 5, welcomeText);

			if(isDisplayed(driver, welcomeText)) {

				String name = getText(driver, welcomeText);

				BaseSuite.reportLog("Home page is visible "+name);

			}else {
				BaseSuite.reportFailLog("Home page not visible", "clickOnBreadcrumbLink");
			}

			break;

		case "data testing":

			clickOnButton(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			break;	

		case "workflows":

			clickOnButton(driver, workflowBreadcrumbWorkflowsLink, workflowContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateTitle(driver,workflowTitle, workflowsTitle);


			break;	

		default:

			break;
		}


	}



	public void dataTesting() {

		isDisplayedInLoop(driver,2,dataTesting);
		if(isDisplayed(driver, dataTesting)) {
			displayAndClick(driver,dataTesting);
			BaseSuite.validationReportLog("Clicked on the Data Testing service!!");}

	}


	public void validateWorkflowBreadcrumbLinkNavigation(boolean flag,String newWorkflowName, String foldername, String icedqUser ) {
		HomePage hp=new HomePage(driver);
		try {
			BaseSuite.reportLog("Navigating to workflows link on breadcrumb");

			clickOnBreadcrumbLink("workflows");

			clickOnNewWorkflowButton(flag,icedqUser);

			enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, customContent);

			BaseSuite.reportLog("Navigating to data testing link on breadcrumb");

			clickOnBreadcrumbLink("Data testing");

			clickOnWorkflowsTabNew();

			clickOnNewWorkflowButton(flag,icedqUser);

			enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, customContent);

			BaseSuite.reportLog("Navigating to home link on breadcrumb ");

			clickOnBreadcrumbLink("Home");

			hp.clickOnDataTestingTab();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnWorkflowsTabNew();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateWorkflowBreadcrumbLinkNavigation ");
		}
	}


	public boolean validateNavigationFunctionality(DataTestingParameters param,String foldername, String icedqUser) {

		boolean flag=true;
		String newWorkflowName=null;
		String workflowJsonEntity=param.getWorkflowJsonValue();
		String instanceid=null;
		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

			flag= clickOnNewWorkflowButton(flag,icedqUser);

			if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

				enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, customContent);

				validateWorkflowBreadcrumbLinkNavigation(flag, newWorkflowName, foldername, icedqUser);

				searchAndClickOnWorkflowNameOnWorkflowListingPage(newWorkflowName,foldername);

				DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(0, workflowJsonEntity);

				viewAndValidateField(returnElement(worklfowAddedRuleNameLink, dynamicName, ruleParam.getRuleName()), ruleParam.getRuleName(), ruleParam.getRuleName(), true);

				navigateToLinkForNewTab(returnElement(worklfowAddedRuleNameLink, dynamicName, ruleParam.getRuleName()), returnElement(workflowNameTitle, dynamicName,  ruleParam.getRuleName()), ruleParam.getRuleName());

				searchRecentRunOnRecentRunsField(true, "");

				verifyVisibilityOfButtons(driver, workflowDetailsRecentRunRefreshButton, refreshContent, true);

				validateColumnsListForWorkflowService(workflowDetailsRecentRunsTabColumns, workflowDetailsRecentRunsTabColumnLocator, "Recent Runs tab on workflow details page");

				List<String> rrDetails = getPaginationDetails(driver, workflowDetailsRecentRunsPaginationMsg, workflowDetailsRecentRunsPagearrow, workflowDetailsPageRecentRunsNoRecordDisplay,recentRunsContent);

				int total = Integer.parseInt(rrDetails.get(1));

				if(total>0) { 

					instanceid = validateWorkflowRecentRunInfo();

					flag=searchRecentRunOnRecentRunsField(flag, instanceid);

					validateWorkflowExecutionDetailsInRecentRunsNavigation(flag, instanceid, newWorkflowName);
				}

				clickOnNewRuleInWorkflowDetails(true,false,icedqUser);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNavigationFunctionality ");

		}
		return flag;
	}



	public void navigateToLink(By linkLocator,By validateLocator, String label) {

		try {

			if(!label.isEmpty()) {
				BaseSuite.reportLog("-------------- Navigating to link "+label+" ---------------");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnButton(driver, linkLocator, label, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				/**	handleDiscardWindow();**/

				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				validateIsDisplayedOrNot(driver, validateLocator, label, true);

				BaseSuite.reportLog("-------------- Navigating to previous page  -----------------");

				driver.navigate().back();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				for (int i=0;i<5;i++) {

					if(isDisplayed(driver, validateLocator)) {
						waitForExecution(5000);
						driver.navigate().back();
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" navigateToLink ");
		}

	}

	public void navigateToLinkForNewTab(By linkLocator, By validateLocator, String label) {
		if (label == null || label.trim().isEmpty()) {
			BaseSuite.reportLog("Label is empty. Skipping navigation.");
			return;
		}

		String mainWindow = null;
		try {
			BaseSuite.reportLog("-------------- Navigating to link: " + label + " ---------------");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnButton(driver, linkLocator, label, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			mainWindow = getWindowHandle(driver);

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateIsDisplayedOrNot(driver, validateLocator, label, true);

			BaseSuite.reportLog("-------------- Navigating to previous page  ---------------");

			closeCurrentTabAndSwitchToMain(driver, mainWindow);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle + " navigateToLinkForNewTab :: " + e.getMessage());
			log.error("Exception in navigateToLinkForNewTab", e);
		}
	}

	public void validateRuleNameAndConnectionNameNavigationFromWorkflowRecentRuns(boolean flag,String ruleInstanceId, String rulename, String ruletype) {

		flag=clickOnExpandArrowToRuleInstanceId(flag, ruleInstanceId);

		if(flag) {

			navigateToLinkForNewTab(returnElement(workflowExecutionRuleInstanceIdName, dynamicName, ruleInstanceId), returnElement(workflowNameTitle, dynamicName,  rulename), rulename);

			if(!ruletype.trim().equalsIgnoreCase(scriptContent)) {

				String source=getvaluefromField(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId), sourceConnectionContent,attributeTextContent);

				navigateToLinkForNewTab(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId), returnElement(workflowNameTitle, dynamicName,  source), source);

				if(ruletype.equalsIgnoreCase(reconContent) || ruletype.equalsIgnoreCase(checksumContent)) {

					String target=getvaluefromField(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId), targetConnectionContent,attributeTextContent);

					navigateToLinkForNewTab(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId), returnElement(workflowNameTitle, dynamicName,  target), target);

				}	
			}
		}
	}


	public boolean validateWorkflowExecutionDetailsInRecentRunsNavigation(boolean flag, String instaceId, String workflowName) {
		String ruletype="";
		String rulename="";
		String status="";
		List<String> ruleInfo=null;
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);

			List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(flag, instaceId);

			BaseSuite.reportLog(createHtmlTable1(getRulesConnectionAndParameterTable(), "Rules Connection and Parameter configuration"));

			BaseSuite.reportLog(createHtmlTable1(rulesConfigurationtable,ruleConfigurationContent));

			getWorkflowInstanceTable();

			getAllRuleInstanceTable(instaceId);

			clickOnRefreshButtonOnRecentRuns(1);searchRecentRunOnRecentRunsField(flag, instaceId);clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);

			for(int i =0;i<ruleInstanceId.size();i++) {

				BaseSuite.reportLog("------------------------  Validating Rule execution details of Instance Id : "+ruleInstanceId.get(i)+" ------------------------");

				if(i>0) {
					flag=clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				ruleInfo=validateRecentRunForRuleInfo(ruleInstanceId.get(i));

				status=ruleInfo.get(3);
				rulename=ruleInfo.get(2);
				ruletype=ruleInfo.get(1);

				if(!status.trim().equalsIgnoreCase(skippedStatusContent) || !status.trim().equalsIgnoreCase(stringSubmitted)) {

					validateRuleNameAndConnectionNameNavigationFromWorkflowRecentRuns(flag, ruleInstanceId.get(i), rulename, ruletype);

					flag=clickOnRuleExecutionDetails(ruleInstanceId.get(i));

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					checkRuleExceptionReportDetailsAsPerStatus(ruleInstanceId, i, rulename, ruletype, status, workflowName, true);

					clickOnRefreshButtonOnRecentRuns(1);searchRecentRunOnRecentRunsField(flag, instaceId);clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateWorkflowExecutionDetailsInRecentRuns ");

			flag=false;
		}
		return flag;
	}

	public boolean clickOnScriptAndChecksumRuleInstaceIdOnWorkflow(boolean flag, String ruleInstance, String ruletype) {


		try {
			if(ruletype.trim().toLowerCase().equalsIgnoreCase(scriptContent) || ruletype.trim().toLowerCase().equalsIgnoreCase(checksumContent) ) {

				isDisplayedInLoop(driver, 3, returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstance));

				if(flag && isDisplayed(driver, returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstance))) {

					flag=clickOnButton(driver, returnElement(workflowExecutionRuleInstanceId, dynamicName, ruleInstance),ruleInstance, flag);

					handleDiscardWindow();

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					validateIsDisplayedOrNot(driver, returnElement(workflowNameTitle, dynamicName,  "Instances"), "Instances", true);

					BaseSuite.reportLog("-------------- Navigating to previous page  ---------------");

					driver.navigate().back();

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					waitForExecution(5000);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+""+" ");

			flag=false;
		}

		return flag;
	}


	//create workflow using automation database details
	public boolean createNewRuleFromCustomWorkflowDetailsPage(DataTestingParameters param,String foldername,String ruleType, boolean isOverride, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		/**		DataTestingPage dp = new DataTestingPage(driver); */
		String mainWindow=null;
		log.info(ruleType);
		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			/**		String ruleJson=param.getRuleJsonValue();*/
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					mainWindow=clickOnNewRuleInWorkflowDetails(flag, true,icedqUser);

					/**	dp.createRuleForWorkflow(ruleJson, foldername, ruleType,downloadZip, icedqUser);*/

					closeCurrentTabAndSwitchToMain(driver, mainWindow);
					/**
					driver.navigate().refresh();

					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					clickOnWorkflowTab();

					flag= clickOnNewWorkflowButton(flag,icedqUser);

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

					 **/

					if(!workflowMode.toLowerCase().contains(draftContent)) {

						flag=clickonWorkflowRulesAndDatasetTab(flag);

						List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

						addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

						flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

						flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	
					}
					flag = clickOnWorkflowSaveOption(flag,workflowMode, workflowCreatedToastMsg,icedqUser);

					if(flag) {

						workflowid = getWorkflowIdOnWorkflowDetailsPage();

						subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport,workflowExecutionStatus, icedqUser);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createNewRuleFromCustomWorkflowDetailsPage ");

			flag=false;
		}

		return flag;

	}


	// set workflow parameters using excel
	public DataTestingParameters setWorkflowParameters(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			param.setTestScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, "testScenarioName"));
			param.setTestScenarioResult(xl.readUsingColName(fileName, sheetName, rowNumber, keytestResult));
			param.setWorkflowfolderName(xl.readUsingColName(fileName, sheetName, rowNumber, "folderPath"));
			param.setWorkflowName(xl.readUsingColName(fileName, sheetName, rowNumber, keyworkflowName));
			param.setWorkflowJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, keyworkflowJson));
			param.setWorkflowUpdateJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, keyWorkflowUpdateJson));//workflow_update_json/workflowUpdateJson
			param.setWorkflowSubscriptionJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "subscriptionJson"));
			param.setWorkflowOverrideJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "overrideJson"));
			param.setWorkflowExecutionStatus(xl.readUsingColName(fileName, sheetName, rowNumber, keyexecutionStatus));
			param.setWorkflowExecutionExitCode(xl.readUsingColName(fileName, sheetName, rowNumber, keyexitCode));
			param.setWorkflowSaveMode(xl.readUsingColName(fileName, sheetName, rowNumber, "saveMode"));
			param.setWorkflowDownloadZip(xl.readUsingColName(fileName, sheetName, rowNumber, "downloadZip"));
			param.setWorkflowExceptionReportCheck(xl.readUsingColName(fileName, sheetName, rowNumber, "exceptionReportCheck"));

			param.setIsOverride(xl.readUsingColName(fileName, sheetName, rowNumber, keyisOverride));
			param.setRunType(xl.readUsingColName(fileName, sheetName, rowNumber, keyrunType));
			param.setSequenceSelect(xl.readUsingColName(fileName, sheetName, rowNumber, "sequenceSelect"));
			param.setSequenceShuffle(xl.readUsingColName(fileName, sheetName, rowNumber, "sequenceShuffle"));
			param.setSequenceDelete(xl.readUsingColName(fileName, sheetName, rowNumber, "sequenceDelete"));

			param.setFunctionality(xl.readUsingColName(fileName, sheetName, rowNumber, "functionality"));
			param.setSourceInput(xl.readUsingColName(fileName, sheetName, rowNumber, "input"));

			param.setOverrideReplace(xl.readUsingColName(fileName, sheetName, rowNumber, "overrideParameter"));
			param.setRuleJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, keyRuleInfo));
			param.setRuleType(xl.readUsingColName(fileName, sheetName, rowNumber, "ruleType"));		
			param.setRuleUpdateJson(xl.readUsingColName(fileName, sheetName, rowNumber, "update_rule_info"));

			param.setSourceConnection(xl.readUsingColName(fileName, sheetName, rowNumber, "sourceConnection"));
			param.setTargetConnection(xl.readUsingColName(fileName, sheetName, rowNumber, "targetConnection"));
			param.setParameterFilename(xl.readUsingColName(fileName, sheetName, rowNumber, "parameterName"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowParametersUsingExcelData "+e.toString());
		}
		return param;

	}


	//stop or kill rule sequence of workflow execution 

	//click on stop execution and validate stop execution window
	public boolean clickOnStopRuleSequenceOfExecution(boolean flag, String instaceId, String workflowInstanceID) {
		int a=0;
		try {
			By locator = returnElement(workflowDetailsRecentRunRuleInstanceIdStopIcon, dynamicName, instaceId);

			isDisplayedInLoop(driver, 3, locator);

			while(!isDisplayed(driver, locator) || a==4 ) {

				clickOnRefreshButtonOnRecentRuns(1);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnExpandArrowToWorkflowInstanceId(flag, workflowInstanceID);

				a++;
				BaseSuite.reportLog("----------------- a : "+a);
			}


			if(flag && isDisplayed(driver, locator)) {

				BaseSuite.reportLog("clicking on stop execution icon of instance id : "+instaceId);

				javascript(driver, scrollToElementArg, locator);

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog("clicked on stop execution icon");

				isDisplayedInLoop(driver, 3, workflowDetailsRecentRunsStopExecutionPopUpTitle);

				if(isDisplayed(driver, workflowDetailsRecentRunsStopExecutionPopUpTitle)) {

					BaseSuite.reportLog("Stop Execution popup window is visible");

					flag=validatePopupWindowContent(flag, workflowDetailsRecentRunsStopExecutionPopUpTitle, workflowDetailsRecentRunsStopExecutionPopUpContent, recentRunsStopExecutionPopupTitle, recentRunsStopExecutionPopupContent);

					if(flag) {

						verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsStopExecutionPopUpCancelBtn, cancelContent, true);

						verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsStopExecutionPopUpStopBtn, stopContent, true);

						flag=clickOnButton(driver, workflowDetailsRecentRunsStopExecutionPopUpStopBtn, stopContent, true);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}else {
					BaseSuite.reportFailLog("Stop Execution popup window is not visible ", "clickOnStopRuleSequenceOfExecution");

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnStopRuleSequenceOfExecution ");
			flag=false;

		}
		return flag;

	}


	public boolean stopExecution(boolean flag,String workflowStatus, String ruleInstnaceID, String workflowInstanceID, List<String> ruleInstanceId) {
		String status=workflowStatus;
		List<String> ids= ruleInstanceId;
		try {
			flag=clickOnStopRuleSequenceOfExecution(flag, ruleInstnaceID,workflowInstanceID);

			clickOnRefreshButtonOnRecentRuns(10);

			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnExpandArrowToWorkflowInstanceId(flag, workflowInstanceID);

				String rulestatus=getExecutionStatusByRuleInstanceId(ruleInstnaceID);

				stringContainsOutput(rulestatus, errorContent, true);

				status=clickOnRefreshButtonOnRecentRuns(workflowRefreshCount);

				stringContainsOutput(status, errorContent, true);

				clickOnExpandArrowToWorkflowInstanceId(true, workflowInstanceID);

				ids = getRuleExecutionInstaceIdListFromWorkflow(true, workflowInstanceID);

				getWorkflowInstanceTable();

				getInstanceTable(ids);

				verifyWorkflowExecutionExitCodeCalculation(workflowInstanceID);

				clickOnExpandArrowToRuleInstanceId(true, ruleInstnaceID);

				validateRuleDetailsUsingInstanceId(ruleInstnaceID,errorContent);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" stopExecution ");
			flag=false;
		}
		return flag;
	}



	//run workflow and kill workflow functionality
	public boolean runAndStopRuleSequenceExecutionWorkflow(String workflowJsonEntity,int sequenceKillIndex, String icedqUser) {

		String instanceid=null;
		boolean flag = true;
		String preinstanceid ="";
		try {
			log.info("Workflow Json :: "+workflowJsonEntity);

			if(!icedqUser.contains(readerFlag)) {

				preinstanceid=verifyInstanceID();

				String status = clickOnRunButtonOnWorkflowAndGetStatus(1,"");

				instanceid=getValueOfField(workflowDetailsRecentRunInstanceId, instanceIdContent);

				if(instanceid.contains(preinstanceid)) {

					status=clickOnRunButtonOnWorkflowAndGetStatus(2,"");

					instanceid=getValueOfField(workflowDetailsRecentRunInstanceId, instanceIdContent);
				}

				if(!instanceid.contains(preinstanceid) || preinstanceid.isEmpty()) {


					if ((status.toLowerCase().contains(runningStatus))){

						clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

						List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

						flag= stopExecution(flag, status, ruleInstanceId.get(sequenceKillIndex), instanceid, ruleInstanceId);

						getWorkflowInstanceTable();

						getInstanceTable(ruleInstanceId);



					}	
				}else {
					BaseSuite.reportFailLog(workflowInstanceIdNotLog+previousIdLog+preinstanceid+currentIdLog+instanceid, "runAndStopRuleSequenceExecutionWorkflow");
					flag=false;
				}
			}else if(icedqUser.contains(readerFlag)) {

				flag=runForReaderGrantUser();

			}		


		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" runAndStopRuleSequenceExecutionWorkflow ");

			flag=false;

		}

		return flag;

	}


	//get list of rule execution instance id
	public List<String> getRuleExecutionExitCodeListFromWorkflow(boolean flag,String instanceId) {
		List<String> list = new ArrayList<>();
		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				int rrtp=Integer.parseInt(totalPageNumber(workflowRecentRunsChildMsg));

				if(1<rrtp) {
					clickOnPage(workflwoRecentRunsChildPageArrow, lastContent);
				}

				for(int x =rrtp;x>=1;x--) {

					isDisplayedInLoop(driver, 3, returnElement(workflowDetailsRecentRunRuleExitCodeList, dynamicName, instanceId));

					List<WebElement> ruleInstanceId = getElements(driver, returnElement(workflowDetailsRecentRunRuleExitCodeList, dynamicName, instanceId));

					for(int i = 0;i<ruleInstanceId.size();i++) {

						String ruleinstanceid= ruleInstanceId.get(i).getText();

						list.add(ruleinstanceid);

					}

					String currentPage=currentPageNumber(workflowRecentRunsChildMsg);

					if(Integer.parseInt(currentPage)!=1) {

						clickOnPage(workflwoRecentRunsChildPageArrow, preContent);
					}
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				Collections.reverse(list);

				BaseSuite.reportLog("Rule Sequence instance exit code List :: "+list);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRuleExecutionInstaceIdListFromWorkflow ");

		}
		return list;
	}


	public List<String> getRulesSequenceUseFlagStatus() {

		List<String> status=null;
		try {

			List<WebElement> ruleInstanceId = getElements(driver, workflowDetailsRulesUseFlags);

			status = new ArrayList<>();

			for(int i=0;i<ruleInstanceId.size();i++) {

				String state = ruleInstanceId.get(i).getAttribute("className");

				if(!state.contains(checkContent)) {
					status.add(uncheckContent);
				}else {
					status.add(checkContent);
				}			
			}

			BaseSuite.reportLog(" Rule Sequence Use flag List :: "+status);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRulesSequenceUseFlagStatus ");
		}

		return status;

	}

	public void compareExitCode(String wkflExitCode, int totalExitCode ) {

		if(!wkflExitCode.isEmpty() && Integer.parseInt(wkflExitCode)>=0) {

			int wkflExitcode=Integer.parseInt(wkflExitCode);

			if(totalExitCode==wkflExitcode) {

				BaseSuite.validationReportLog("Calculation of exit code is correct");

			}else {

				BaseSuite.reportFailLog("Calculation of exit code is incorrect", "verifyWorkflowExecutionExitCodeCalculation");
			}

		}else if(Integer.parseInt(wkflExitCode)<0){

			BaseSuite.reportLog("Workflow exit code is negative : "+wkflExitCode);

		}else if(wkflExitCode.isEmpty()) {

			BaseSuite.reportLog("Workflow exit code is not visible ");
		}
	}

	//calculate exit code 

	public void verifyWorkflowExecutionExitCodeCalculation(String workflowInstanceId) {

		int totalExitCode=0;
		String wkflExitCode ;
		BaseSuite.reportLog("----------------- Calculating Exit code -----------------");

		List<String> useFlags =ruleSequenceUseFlagList;

		try {
			wkflExitCode = getValueOfField(workflowDetailsRecentRunExitCode, workflowExitCodeContent);

			if(useFlags!=null) {

				BaseSuite.reportLog("Rule Sequence Use flag List :: "+useFlags);
				if(useFlags.isEmpty()) {
					ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();
					useFlags =ruleSequenceUseFlagList;
					BaseSuite.reportLog("Rule Sequence Use flag List :: "+useFlags);
				}

				List<String> list = getRuleExecutionExitCodeListFromWorkflow(true, workflowInstanceId);

				List<Integer> exitcodes=new ArrayList<>();

				for(int i = 0;i<list.size();i++) {

					if(useFlags.get(i).equalsIgnoreCase(checkContent)) {
						exitcodes.add(Integer.parseInt(list.get(i)));
					}
				}

				for(int i = 0;i<exitcodes.size();i++) {

					if(exitcodes.get(i)>0 || exitcodes.get(i)==0) {

						totalExitCode +=exitcodes.get(i);
					}

				}

				BaseSuite.reportLog("Sum of rule instances exit code is : "+totalExitCode);

				compareExitCode(wkflExitCode, totalExitCode);

			}

			verifyWorkflowExecutionStatusCalculation(wkflExitCode, workflowInstanceId);

			ruleSequenceUseFlagList=null;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" verifyWorkflowExecutionExitCodeCalculation ");
		}

	}


	//get list of rule execution instance id
	public List<String> getRuleExecutionStatusListFromWorkflow(boolean flag,String instanceId) {
		List<String> list = new ArrayList<>();
		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isDisplayedInLoop(driver, 3, returnElement(workflowDetailsRecentRunRuleStatusList, dynamicName, instanceId));

				List<WebElement> ruleInstanceId = getElements(driver, returnElement(workflowDetailsRecentRunRuleStatusList, dynamicName, instanceId));

				for(int i = 0;i<ruleInstanceId.size();i++) {

					String ruleinstanceid= ruleInstanceId.get(i).getText();

					list.add(ruleinstanceid);

				}
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				Collections.reverse(list);
				BaseSuite.reportLog("Rule instances status List :: "+list);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRuleExecutionStatusListFromWorkflow ");

		}
		return list;
	}

	public List<Integer> getListOfRuleStatusPriority(List<String> list, List<Integer> numericStatus) {

		for(int i=0;i<list.size();i++) {


			switch(list.get(i).toLowerCase().trim()) {

			case "skipped":				
				numericStatus.add(0);				
				break;			
			case "success":		
				numericStatus.add(1);		
				break;
			case "warning":				
				numericStatus.add(2);				
				break;			
			case "critical":		
				numericStatus.add(3);		
				break;
			case "blocker":				
				numericStatus.add(4);				
				break;			
			case "error":		
				numericStatus.add(5);		
				break;
			case "submitted":		
				numericStatus.add(-1);		
				break;
			default:
				numericStatus.add(0);		
				break;

			}

		}

		return numericStatus;

	}


	public String getStatusUsingPriorityNumber(int maxnum) {

		String status=null;
		switch(maxnum) {

		case 0:				
			status=stringSkipped;		
			break;			
		case 1:		
			status=stringsuccess;		
			break;
		case 2:				
			status=stringWarning;			
			break;			
		case 3:		
			status=stringCritical;		
			break;
		case 4:				
			status=stringBlocker;				
			break;			
		case 5:		
			status=stringError;	
			break;
		case -1:		
			status=stringRunning;	
			break;
		default:
			status=stringRunning;	
			break;

		}

		return status;

	}

	public boolean checkStatusOfWorkflow(boolean flag, List<Integer> numericStatus,String workflowStatus) {

		try {
			int max = numericStatus.get(0);

			for(int i=0;i<numericStatus.size();i++) {

				if(max<numericStatus.get(i)) {

					max=numericStatus.get(i);

				}
			}

			String maxRuleStatus =getStatusUsingPriorityNumber(max);

			flag=stringContainsOutput(workflowStatus, maxRuleStatus, true);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkStatusOfWorkflow ");
		}

		return flag;
	}

	public boolean checkStatusOfWorkflowForSubmittedRules(boolean flag,List<Integer> numericStatus,String workflowStatus) {
		boolean check=true;
		try {
			for(int i=0;i<numericStatus.size();i++) {

				if(numericStatus.get(i)<0) {
					check=false;
					break;
				}
			}
			if(check) {

				checkStatusOfWorkflow(flag, numericStatus, workflowStatus);

			}else {

				flag=stringContainsOutput(workflowStatus, runningStatus, true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkStatusOfWorkflowForSubmittedRules ");
		}
		return flag;
	}


	public boolean verifyWorkflowExecutionStatusCalculation(String exitcode, String workflowInstanceId) {

		boolean flag=true;


		BaseSuite.reportLog("----------------- Verifying Workflow execution status -----------------");
		try {

			String workflowStatus = getAttribute(driver, workflowDetailsRecentRunStatus, attributeTextContent);

			if(!workflowStatus.isEmpty()) {

				BaseSuite.reportLog("Workflow execution status is :"+workflowStatus);

				if(Integer.parseInt(exitcode)==0) {

					stringContainsOutput(exitcode, workflowSuccessExitCode, true);

					flag=stringContainsOutput(workflowStatus, successContent, true);

				}else if(Integer.parseInt(exitcode)>0) {

					List<String> list = getRuleExecutionStatusListFromWorkflow(true, workflowInstanceId);

					List<Integer> numericStatus=new ArrayList<>();

					numericStatus= getListOfRuleStatusPriority(list, numericStatus);

					checkStatusOfWorkflow(flag, numericStatus, workflowStatus);

				}else if(Integer.parseInt(exitcode)<0) {

					stringContainsOutput(exitcode, workflowErrorExitCode, true);

					flag=stringContainsOutput(workflowStatus, errorContent, true);

				}else if(exitcode.isEmpty()) {

					List<String> list = getRuleExecutionStatusListFromWorkflow(true, workflowInstanceId);

					List<Integer> numericStatus=new ArrayList<>();

					numericStatus= getListOfRuleStatusPriority(list, numericStatus);

					flag=checkStatusOfWorkflowForSubmittedRules(flag, numericStatus, workflowStatus);

				}
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" verifyWorkflowExecutionStatusCalculation ");
			flag=false;
		}
		return flag;
	}


	public String removeAddedRulesAndAddRulesInWorkflow(boolean flag,String workflowid,String workflowJsonEntity,String workflowSubscriptionJSon,boolean isOverride,String icedqUser) {

		try {

			clickonWorkflowRulesAndDatasetTab(flag);	

			flag=removeAllAddedRulesFromWorkflow();

			List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

			addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

			flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

			flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity, isOverride);	

			BaseSuite.reportLog(workflowSaveLog);

			if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowPublish, "",icedqUser);

			}else {
				flag = clickOnWorkflowSaveOption(flag,workflowPublish, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
			}


			workflowid = getWorkflowIdOnWorkflowDetailsPage();

			subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeAddedRulesAndAddRulesInWorkflow ");
		} 

		return workflowid;
	}


	public String executeWorkflowWithRunType(String runType,String sequence, String icedqUser) {

		if(!runType.trim().equalsIgnoreCase("run")) {

			return selectAddedRulesSequenceAndExecute(sequence, runType,icedqUser);

		}else {
			if(icedqUser.contains(readerContent)) {

				return clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);

			}else {

				return clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount,"");
			}
		}

	}


	public boolean validateRecentRun(boolean flag, String instanceid,String preinstanceid,String workflowid,String state, boolean downloadZip) {


		if(!instanceid.contains(preinstanceid) || preinstanceid.isEmpty()) {

			flag=searchRecentRunOnRecentRunsField(flag, instanceid);

			if ((!state.toLowerCase().contains(runningStatus))){

				flag=validateWorkflowExecutionDetails(flag, workflowid, instanceid, downloadZip);

			}else {
				BaseSuite.reportFailLog(workflowExecutionStuckLog, "validateRecentRun");
				flag=false;

				clickOnExecutionDetails();

				clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

				getWorkflowInstanceTable();

				getAllRuleInstanceTable(instanceid);
			}
			searchRecentRunOnRecentRunsField(true, "");


		}
		else {
			BaseSuite.reportFailLog(workflowInstanceIdNotLog+previousIdLog+preinstanceid+currentIdLog+instanceid, "validateRecentRun");
			flag=false;	
		}

		return flag;
	}




	//update workflow 
	public boolean updateCustomWorkflowSequencesAndExecute(DataTestingParameters param,String icedqUser) {

		boolean flag = true;
		String workflowid="";
		String instanceid="";
		String preinstanceid="";
		String state="";
		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String sequence=param.getSourceInput();
			String runType=param.getRunType();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean isOverride=	Boolean.parseBoolean(param.getOverrideType());	
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

				workflowid=removeAddedRulesAndAddRulesInWorkflow(flag, workflowid, workflowJsonEntity, workflowSubscriptionJSon, isOverride, icedqUser);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				preinstanceid=verifyInstanceID();

				state=executeWorkflowWithRunType(runType, sequence, icedqUser);

				BaseSuite.reportLog(workflowExecutionLog);
				stringContainsOutput(state, workflowExecutionStatus, true);

				instanceid = validateWorkflowRecentRunInfo();

				flag=validateRecentRun(flag, instanceid, preinstanceid, workflowid, state, downloadZip);

			}else{

				rulesConfigurationtable=null;

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				rulesConfigurationtable=getRulesTable(ruleList);

				preinstanceid=verifyInstanceID();

				state=executeWorkflowWithRunType(runType, sequence, icedqUser);

				if(icedqUser.contains(executorContent)) {
					BaseSuite.reportLog(workflowExecutionLog);
					stringContainsOutput(state, workflowExecutionStatus, true);

					instanceid = validateWorkflowRecentRunInfo();

					flag=validateRecentRun(flag, instanceid, preinstanceid, workflowid, state, downloadZip);
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateCustomWorkflowSequencesAndExecute ");

			flag=false;
		}

		return flag;

	}	

	public void validateRuleDetailsInWorkflow(Boolean flag, DataTestingParameters ruleParam,List<String> ruleList,int i) {

		viewAndValidateField(returnElement(worklfowAddedRuleNameLink, dynamicName, ruleParam.getRuleName()), ruleParam.getRuleName(), ruleParam.getRuleName(), true);

		checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess());

		checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleFailureFlag,failureContent, ruleParam.getOnFailure());

		checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError());

		checkConnectionAndParameterOnAddedRules(flag, ruleParam);

		checkRuleFlagStatus(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode());

		checkRuleFlagStatus(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive());

		checkExpectedValueWithActual(driver, flag, returnElement(worklfowAddedRuleFolderLink, dynamicName, ruleParam.getRuleName()),folderContent, ruleParam.getRuleFolderName(),true);

	}

	//single source connection override
	public boolean removeSingleSourceConnectionOverrideUsingConnectionName(boolean flag ,String ruleName, String connectionName) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog("---------- Removing source override : "+ruleName+" with source Connection : "+connectionName+logString);

					WebElement ele = driver.findElement(sourceConnectionName);

					action.moveToElement(ele).click().perform();

					WebElement ele1 = driver.findElement(returnElement(workflowDetailsSourceConnOverrideButton, dynamicName, ruleName));

					ele1.click();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, true);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, true);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						viewAndValidateField(sourceConnOverrideReplaceConnDD, sourceConnectionField, connectionName, true);

						BaseSuite.reportLog("Clicking on replace connection cross icon");

						displayAndClick(driver, sourceConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, sourceConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, sourceConnOverrideReplaceConnClearIcon);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace connection cross icon");

						/**		verifySearchField(sourceConnOverrideReplaceConnDD, "Override Connection","Replace connection");**/

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, false);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=clickonWorkflowRulesAndDatasetTab(flag);

					}else {
						BaseSuite.reportFailLog(sourceConnectionField+overrideFunctionalityErrorLog, "removeSingleSourceConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeSingleSourceConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}



	//single target connection override
	public boolean removeSingleTargetConnectionOverrideUsingConnectionName(boolean flag ,String ruleName, String connectionName) {

		Actions action = new Actions(driver);

		try {
			if(flag) {

				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog("---------- Removing target override : "+ruleName+" with target Connection : "+connectionName+logString);

					WebElement ele = driver.findElement(targetConnectionName);

					action.moveToElement(ele).click().perform();

					WebElement ele1 = driver.findElement(returnElement(workflowDetailsTargetConnOverrideButton, dynamicName, ruleName));

					ele1.click();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, true);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, true);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						viewAndValidateField(targetConnOverrideReplaceConnDD, targetConnectionField, connectionName, true);

						BaseSuite.reportLog("Clicking on replace connection dropdown");

						displayAndClick(driver, targetConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, targetConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, targetConnOverrideReplaceConnClearIcon);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace connection cross icon ");

						/**		verifySearchField(targetConnOverrideReplaceConnDD, "Override Connection","Replace connection");**/

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, false);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=clickonWorkflowRulesAndDatasetTab(flag);

					}else {
						BaseSuite.reportFailLog(targetConnectionField+overrideFunctionalityErrorLog, "removeSingleTargetConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeSingleTargetConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//single parameter override
	public boolean removeSingleParameterOverride(boolean flag,String ruleName, String parameterName) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				parameterName=checkNullValue(parameterName);

				if(!parameterName.isEmpty()) {

					BaseSuite.reportLog("---------- Removing parameter override : "+ruleName+" with parameter : "+parameterName+logString);

					WebElement ele = driver.findElement(parameterOverName);

					action.moveToElement(ele).click().perform();

					WebElement ele1 = driver.findElement(returnElement(workflowDetailsParameterOverrideButton, dynamicName, ruleName));

					ele1.click();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, parameterOverrideTitle);

					if(isDisplayed(driver, parameterOverrideTitle)) {

						verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

						verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

						verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

						verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, true);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, true);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);

						viewAndValidateField(parameterOverrideReplaceConnDD, parameterField, parameterName, true);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicking on replace parameter dropdown");

						displayAndClick(driver, parameterOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, parameterOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						displayAndClick(driver, parameterOverrideReplaceConnClearIcon);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace parameter cross icon");

						/**		verifySearchField(parameterOverrideReplaceConnDD, "Override Parameter","Replace parameter");**/

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, false);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=clickonWorkflowRulesAndDatasetTab(flag);

					}else {
						BaseSuite.reportFailLog(parameterField+overrideFunctionalityErrorLog, "removeSingleParameterOverride");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeSingleParameterOverride ");

			flag=false;
		}

		return flag;

	}

	public boolean validateAndRemoveSingleOverrideFunctionality(boolean flag,String workflowJsonEntity ,List<String> ruleList, int i) {

		String sourceConnectionOverride=null;
		String targetConnectionOverride=null;
		String parameterOverride=null;
		String subtype="";
		XLUtils xl = new XLUtils();
		String inputData="";
		List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

		if(inputData.trim().equalsIgnoreCase(excelContent)) {
			DataTestingParameters ruleOverride=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);
			sourceConnectionOverride=ruleOverride.getOverrideSourceConnection();
			targetConnectionOverride=ruleOverride.getOverrideTargetConnection();
			parameterOverride=ruleOverride.getOverrideParameter();

		}else if(inputData.trim().equalsIgnoreCase(sheetContent)) {
			/**
			sourceConnectionOverride=param.getOverrideReplace();
			targetConnectionOverride=param.getOverrideReplace();
			parameterOverride=param.getOverrideReplace();
			 **/
		}else {
			String readColumnName="";
			if(workflowExecutionConfigColumnName.isEmpty()) {
				readColumnName=valueColumn;
			}else {
				readColumnName=workflowExecutionConfigColumnName;
			}
			sourceConnectionOverride=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyChangeOverrideSource,readColumnName);
			targetConnectionOverride=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyChangeOverrideTarget,readColumnName);
			parameterOverride=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH,wkflsheetName, keyColumn, keyChangeOverrideParameter,readColumnName);
		}
		for(int j=0;j<override.size();j++) {

			DataTestingParameters ruleOverrideParam =setWorkflowRuleOverRideParameter(i, j, workflowJsonEntity);

			subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

			subtype=checkNullValue(subtype);

			if(!subtype.isEmpty()) {

				switch(subtype+"1") {

				case "source1":

					flag=removeSingleSourceConnectionOverrideUsingConnectionName(flag, ruleList.get(i), sourceConnectionOverride);
					break;

				case "target1":

					flag=removeSingleTargetConnectionOverrideUsingConnectionName(flag,ruleList.get(i), targetConnectionOverride);
					break;

				case "rule1":
					flag=removeSingleParameterOverride(flag,ruleList.get(i), parameterOverride);
					break;

				default:

					BaseSuite.reportErrorLog("error occurs while validateAndRemoveSingleOverrideFunctionality kindly check "+ruleOverrideParam.getOverrideSubType());
					flag=false;
					break;

				}
			}
		}
		return flag;
	}

	public void validateConnectionsInRecentRuns(String workflowJsonEntity, String ruleInstanceId, String ruletype, boolean isOverride, int i) {
		String sourceConnection1;
		String targetConnection1;

		try {
			if(isOverride) {

				DataTestingParameters ruleParam = setWorkflowRuleOverRideParameter(i, 0, workflowJsonEntity);
				sourceConnection1=ruleParam.getOverrideReplace();
				targetConnection1=ruleParam.getOverrideReplace();

			}else {

				DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);
				sourceConnection1=ruleParam.getRuleSourceConnectionName();
				targetConnection1=ruleParam.getRuleTargetConnectionName();
			}

			if(!ruletype.equalsIgnoreCase(scriptContent)) {

				String actualSource=getvaluefromField(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId), sourceConnectionContent,attributeTextContent);

				stringContainsOutput(actualSource, sourceConnection1, true);

				if(ruletype.equalsIgnoreCase(reconContent) || ruletype.equalsIgnoreCase(checksumContent)) {

					String actualTarget=getvaluefromField(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId), targetConnectionContent,attributeTextContent);

					stringContainsOutput(actualTarget, targetConnection1, true);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateConnectionsInRecentRuns ");


		}	
	}




	public boolean validateWorkflowExecutionDetailsInRecentRunsAndRuleDetails(boolean flag,String workflowJsonEntity, boolean isOverride, String instaceId, String workflowName,boolean exceptionReport) {
		String ruletype="";
		String rulename="";
		String logs="Validating Rule execution details of Instance Id";
		String method="validateWorkflowExecutionDetailsInRecentRuns";
		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);

			List<String> ruleInstanceId = getRuleExecutionInstaceIdListFromWorkflow(flag, instaceId);

			BaseSuite.reportLog(createHtmlTable1(rulesConfigurationtable,ruleConfigurationContent));

			getWorkflowInstanceTable();

			getInstanceTable(ruleInstanceId);

			verifyWorkflowExecutionExitCodeCalculation(instaceId);

			for(int i =0;i<ruleInstanceId.size();i++) {

				BaseSuite.reportLog("----------------  "+logs+" : "+ruleInstanceId.get(i)+" --------------");

				if(i>0) {
					flag=clickOnExpandArrowToWorkflowInstanceId(flag, instaceId);
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				String status=validateRuleDetailsRecentRunInfo(ruleInstanceId.get(i));

				if(!status.trim().equalsIgnoreCase(skippedStatusContent)) {

					flag=clickOnExpandArrowToRuleInstanceId(flag, ruleInstanceId.get(i));

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					if(flag) {

						rulename=getvaluefromField(returnElement(workflowExecutionRuleName, dynamicName, ruleInstanceId.get(i)),ruleNameContent,attributeTextContent);

						stringContainsOutput(rulename, ruleParam.getRuleName(), true);

						ruletype=getvaluefromField(returnElement(workflowExecutionRuleType, dynamicName, ruleInstanceId.get(i)), ruleTypeContent,attributeTitle);

						validateConnectionsInRecentRuns(workflowJsonEntity, ruleInstanceId.get(i), ruletype, isOverride, i);
					}
				}
				flag=clickOnRuleExecutionDetails(ruleInstanceId.get(i));

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				checkRuleExceptionReportDetailsAsPerStatus(ruleInstanceId, i, rulename, ruletype, status, workflowName, exceptionReport);

			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+method+" ");

			flag=false;
		}
		return flag;
	}

	//update workflow using automation database details
	public boolean updateCustomWorkflowForOverride(DataTestingParameters param,String inputData,String overrideType,String icedqUser){

		boolean flag = true;
		String workflowid=null;
		String instanceid=null;
		boolean dnd=true;
		try {
			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();
			String sequenceSelect=param.getSequenceSelect();
			String runType=param.getRunType();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			if(!workflowMode.toLowerCase().contains(draftContent) && !icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				clickonWorkflowRulesAndDatasetTab(flag);

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				if(overrideType.trim().equalsIgnoreCase(singleContent)) {

					flag=selectRulesFlagAndOverrideFunctionality(param,inputData,flag, ruleList,workflowJsonEntity);

				}else if(overrideType.trim().equalsIgnoreCase(bulkContent)){

					flag=bulkOverrideFunctionalityCheck(param,inputData,flag);
				}
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);

			}else {

				clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

				flag = clickOnWorkflowSaveOption(flag,workflowMode, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
				dnd=false;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag) && workflowMode.toLowerCase().contains(publishContent) && dnd) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				String status=executeWorkflowWithRunType(runType, sequenceSelect, icedqUser);

				BaseSuite.reportLog(workflowExecutionLog);
				stringContainsOutput(status, workflowExecutionStatus, true);

				instanceid = validateWorkflowRecentRunInfo();

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if (flag && (!status.toLowerCase().contains(runningStatus))){

					flag=clickOnExecutionDetails();

					downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

					flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowParam.getWorkflowName(), exceptionReport);

					clickOnRefreshButtonOnRecentRuns(1);

				}else {
					BaseSuite.reportFailLog(workflowLongRunMessage , "updateCustomWorkflowForOverride");
					flag=false;

					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

					getWorkflowInstanceTable();

					getAllRuleInstanceTable(instanceid);
				}
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateCustomWorkflowForOverride ");

			flag=false;
		}

		return flag;

	}



	public boolean validateSingleOverrideFunctionality(DataTestingParameters param, String inputData,boolean flag,String workflowJsonEntity ,List<String> ruleList, int i) {


		String sourceConnectionOverride=null;
		String targetConnectionOverride=null;
		String parameterOverride=null;
		String subtype="";

		try {
			if(inputData.trim().equalsIgnoreCase(excelContent)) {

				DataTestingParameters ruleOverride=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);
				sourceConnectionOverride=ruleOverride.getOverrideSourceConnection();
				targetConnectionOverride=ruleOverride.getOverrideTargetConnection();
				parameterOverride=ruleOverride.getOverrideParameter();

			}else if(inputData.trim().equalsIgnoreCase(sheetContent)) {

				sourceConnectionOverride=param.getOverrideReplace();
				targetConnectionOverride=param.getOverrideReplace();
				parameterOverride=param.getOverrideReplace();
			}

			List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

			for(int j=0;j<override.size();j++) {

				if(!inputData.trim().equalsIgnoreCase(excelContent) && !inputData.trim().equalsIgnoreCase(sheetContent)) {

					DataTestingParameters ruleOverride=setWorkflowRuleOverRideParameter(i, j, workflowJsonEntity);
					sourceConnectionOverride=ruleOverride.getOverrideReplace();
					targetConnectionOverride=ruleOverride.getOverrideReplace();
					parameterOverride=ruleOverride.getOverrideReplace();
				}

				subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

				subtype=checkNullValue(subtype);
				if(!subtype.isEmpty()) {

					switch("v"+subtype) {

					case "vsource":

						flag=singleSourceConnectionOverrideUsingConnectionName(flag, ruleList.get(i), sourceConnectionOverride,workflowSingleSourceConnectionOverrideToastMsg);
						break;

					case "vtarget":

						flag=singleTargetConnectionOverrideUsingConnectionName(flag,ruleList.get(i), targetConnectionOverride,workflowSingleTargetConnectionOverrideToastMsg);
						break;

					case "vrule":
						flag=singleParameterOverride(flag,ruleList.get(i), parameterOverride, workflowSingleParameterOverrideToastMsg);
						break;

					default:

						BaseSuite.reportErrorLog("error occurs while validateSingleOverrideFunctionality kindly check "+subtype);
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateSingleOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}


	public boolean validateRemoveSingleOverrideFunctionality(DataTestingParameters param, String inputData,boolean flag,String workflowJsonEntity ,List<String> ruleList, int i) {


		String sourceConnectionOverride=null;
		String targetConnectionOverride=null;
		String parameterOverride=null;
		String subtype="";
		XLUtils xl = new XLUtils();
		try {
			if(inputData.trim().equalsIgnoreCase(excelContent)) {

				DataTestingParameters ruleOverride=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);
				sourceConnectionOverride=ruleOverride.getOverrideSourceConnection();
				targetConnectionOverride=ruleOverride.getOverrideTargetConnection();
				parameterOverride=ruleOverride.getOverrideParameter();

			}else if(inputData.trim().equalsIgnoreCase(sheetContent)) {

				sourceConnectionOverride=param.getOverrideReplace();
				targetConnectionOverride=param.getOverrideReplace();
				parameterOverride=param.getOverrideReplace();
			}else {
				String readColumnName="";

				readColumnName=getRuleFolderColumnName(workflowFolderNameForSanity);

				sourceConnectionOverride=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyChangeOverrideSource,readColumnName);
				targetConnectionOverride=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyChangeOverrideTarget,readColumnName);
				parameterOverride=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH,wkflsheetName, keyColumn, keyChangeOverrideParameter,readColumnName);
			}


			List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

			for(int j=0;j<override.size();j++) {

				subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

				subtype=checkNullValue(subtype);

				if(!subtype.isEmpty()) {

					switch("a"+subtype) {

					case "asource":

						flag=removeSingleSourceConnectionOverrideUsingConnectionName(flag, ruleList.get(i), sourceConnectionOverride);
						break;

					case "atarget":
						flag=removeSingleTargetConnectionOverrideUsingConnectionName(flag,ruleList.get(i), targetConnectionOverride);
						break;

					case "arule":
						flag=removeSingleParameterOverride(flag,ruleList.get(i), parameterOverride);
						break;


					default:

						BaseSuite.reportErrorLog("error occurs while validateRemoveSingleOverrideFunctionality kindly check "+subtype);
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRemoveSingleOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}

	//single source connection override
	public boolean changeSourceConnectionOverrideUsingConnectionName(boolean flag ,String ruleName,String previousConn, String connectionName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog("---------- Changing source override of Rule : "+ruleName+" from "+previousConn+" with Connection : "+connectionName+logString);

					WebElement ele = driver.findElement(sourceConnectionName);

					action.moveToElement(ele).click().perform();

					WebElement ele1 = driver.findElement(returnElement(workflowDetailsSourceConnOverrideButton, dynamicName, ruleName));

					ele1.click();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, true);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, true);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						viewAndValidateField(sourceConnOverrideReplaceConnDD, "Override connection", previousConn, true);

						BaseSuite.reportLog("Clicking on replace connection dropdown ");

						displayAndClick(driver, sourceConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace connection dropdown");
						
						action.moveToElement(driver.findElement(sourceConnOverrideSearchBar)).click().perform();

						sendkeysToField(driver, sourceConnOverrideSearchBar, "Search connection", connectionName);

						clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, connectionName), "connection name");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, sourceConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog(sourceConnectionField+overrideFunctionalityErrorLog, "changeSourceConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" changeSourceConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}



	//single target connection override
	public boolean changeTargetConnectionOverrideUsingConnectionName(boolean flag ,String ruleName,String previousConn, String connectionName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog("---------- Changing target override of Rule : "+ruleName+" from "+previousConn+" with Connection : "+connectionName+logString);

					WebElement ele = driver.findElement(targetConnectionName);

					action.moveToElement(ele).click().perform();

					WebElement ele1 = driver.findElement(returnElement(workflowDetailsTargetConnOverrideButton, dynamicName, ruleName));

					ele1.click();

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, true);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, true);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						viewAndValidateField(targetConnOverrideReplaceConnDD, "Override connection", previousConn, true);

						BaseSuite.reportLog("Clicking on replace connection dropdown");

						displayAndClick(driver, targetConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace connection dropdown");
						
						action.moveToElement(driver.findElement(sourceConnOverrideSearchBar)).click().perform();

						sendkeysToField(driver, sourceConnOverrideSearchBar, "Search connection", connectionName);

						clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, connectionName), "connection name");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, targetConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog(targetConnectionField+overrideFunctionalityErrorLog, "changeTargetConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" changeTargetConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//single parameter override
	public boolean changesingleParameterOverride(boolean flag,String ruleName,String previousParameter, String parameterName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				parameterName=checkNullValue(parameterName);

				if(!parameterName.isEmpty()) {

					BaseSuite.reportLog("---------- Changing parameter override : "+ruleName+" with parameter : "+parameterName+logString);

					WebElement ele = driver.findElement(parameterOverName);

					action.moveToElement(ele).click().perform();

					WebElement ele1 = driver.findElement(returnElement(workflowDetailsParameterOverrideButton, dynamicName, ruleName));

					ele1.click();

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isDisplayedInLoop(driver, 3, parameterOverrideTitle);

					if(isDisplayed(driver, parameterOverrideTitle)) {

						verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

						verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

						verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

						verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, true);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, true);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						viewAndValidateField(parameterOverrideReplaceConnDD, "Override Parameter", previousParameter, true);

						BaseSuite.reportLog("Clicking on replace parameter dropdown");

						displayAndClick(driver, parameterOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace parameter dropdown");
						
						action.moveToElement(driver.findElement(sourceConnOverrideSearchBar)).click().perform();

						sendkeysToField(driver, sourceConnOverrideSearchBar, placeholderSearchParameter, parameterName);

						clickOnFieldOrButton(driver, returnElement(parameterNameForOverride, dynamicName, parameterName), parameterNameContent);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, parameterOverrideField);

					}else {
						BaseSuite.reportFailLog(parameterField+overrideFunctionalityErrorLog, "changesingleParameterOverride");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" changesingleParameterOverride ");

			flag=false;
		}

		return flag;

	}

	public boolean validateChangeSingleOverrideFunctionality(DataTestingParameters param, String inputData,boolean flag,String workflowJsonEntity ,List<String> ruleList, int i) {

		String subtype="";
		log.info(param);
		try {
			if(inputData.trim().equalsIgnoreCase(excelContent)) {
				setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);


			}else if(inputData.trim().equalsIgnoreCase(sheetContent)) {
				setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);

			}else {

				setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);

			}

			List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

			for(int j=0;j<override.size();j++) {

				subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

				subtype=checkNullValue(subtype);

				if(!subtype.isEmpty()) {

					switch(subtype) {

					case "source":

						flag=changeSourceConnectionOverrideUsingConnectionName(flag, ruleList.get(i),overrideSourceConnection, overrideChangeSourceConnection,workflowSingleSourceConnectionOverrideToastMsg);
						break;

					case "target":

						flag=changeTargetConnectionOverrideUsingConnectionName(flag,ruleList.get(i),overrideTargetConnection, overrideChangeTargetConnection,workflowSingleTargetConnectionOverrideToastMsg);
						break;

					case "rule":

						flag=changesingleParameterOverride(flag,ruleList.get(i),overrideParameter, overrideChangeParameter, workflowSingleParameterOverrideToastMsg);
						break;

					default:

						BaseSuite.reportErrorLog("error occurs while validateChangeSingleOverrideFunctionality kindly check "+subtype);
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateChangeSingleOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}

	//updateRulesConfiguration
	public boolean selectRulesFlagAndOverrideFunctionality(DataTestingParameters param, String inputData, boolean flag, List<String> ruleList,String workflowJsonEntity) {
		ruleSequenceUseFlagList=null;
		rulesConfigurationtable=null;
		try {
			if(!ruleList.isEmpty() && flag) {

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("----------------------- validating added rule :"+ruleParam.getRuleName()+" and configuring features of workflow -----------------------");
/**
					flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());

					validateRuleDetailsInWorkflow(flag, ruleParam, ruleList, i);
*/
					if(i<(ruleList.size()-1)){

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFEUncheck);	
					}else {
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFELastSequence);	
					}

					flag=singleOverrideFunctionality(param,inputData,flag, workflowJsonEntity, ruleList, i);

					if(i<(ruleList.size()-1)){

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),"");

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),"");

					}else {

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),workflowToastUseColumnEnabled);

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),workflowToastActiveColumnEnabled);


					}
				}

				displayAndClick(driver, rulesDatasetsSearchBar);

				clear_Click_SendKeys(driver, 0, rulesDatasetsSearchBar, "");

				displayAndClick(driver, rulesDatasetsSearchButton);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();

				rulesConfigurationtable=getRulesTable(ruleList);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectRulesFlagAndOverrideFunctionality ");

			flag=false;
		}

		return flag;
	}

	public boolean singleOverrideFunctionality(DataTestingParameters param, String inputData, boolean flag,String workflowJsonEntity, List<String> ruleList, int i) {

		if(param.getSourceInput().trim().equalsIgnoreCase(removeContent)) {

			flag=validateRemoveSingleOverrideFunctionality(param, inputData, flag, workflowJsonEntity, ruleList, i);

		}else if(param.getSourceInput().equalsIgnoreCase("add")) {

			/**flag=validateSingleOverrideFunctionality(param, inputData, flag, workflowJsonEntity, ruleList, i);**/

			flag=validateAndSingleOverrideFunctionality(flag, workflowJsonEntity, ruleList, i,true);

		}else if(param.getSourceInput().equalsIgnoreCase("change")) {

			flag=validateChangeSingleOverrideFunctionality(param,inputData, flag, workflowJsonEntity, ruleList, i);
		}
		return flag;
	}


	public List<String> getConnectionName(DataTestingParameters param,String inputData){

		String sourceConnection1=null;
		String targetConnection1=null;
		List<String> list =new ArrayList<>();

		if(inputData.trim().equalsIgnoreCase(excelContent)) {

			DataTestingParameters ruleOverride=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 1);
			sourceConnection1=ruleOverride.getOverrideSourceConnection();
			targetConnection1=ruleOverride.getOverrideTargetConnection();


		}else if(inputData.trim().equalsIgnoreCase(sheetContent)) {

			sourceConnection1=param.getOverrideReplace();
			targetConnection1=param.getOverrideReplace();

		}
		list.add(0, sourceConnection1);
		list.add(1, targetConnection1);

		return list;
	}

	public void validateConnectionForWorkflowOnRecentRun(String workflowJsonEntity, int i,String actualSource, String actualTarget) {
		try {

			DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);
			String sourceConn=ruleParam.getRuleSourceConnectionName();
			String targetConn=ruleParam.getRuleTargetConnectionName();

			if(!actualSource.isEmpty()) {

				stringContainsOutput(actualSource, sourceConn, true);}
			if(!actualTarget.isEmpty()) {

				stringContainsOutput(actualTarget, targetConn, true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateConnectionsInRecentRun ");

		}
	}

	public void validateConnectionAsPerType(String workflowJsonEntity ,String subtype,String actualSource,String actualTarget,String sourceConnection,String targetConnection, int i) {
		log.info(subtype);
		List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

		for(int j=0;j<override.size();j++) {

			String subtype1 = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

			subtype1=checkNullValue(subtype1);

			if(!subtype1.isEmpty()) {

				switch(subtype1) {

				case "source":

					stringContainsOutput(actualSource, sourceConnection, true);
					break;

				case "target":

					stringContainsOutput(actualTarget, targetConnection, true);
					break;

				case "rule":


					break;

				default:
					DataTestingParameters ruleOverride=setWorkflowRuleOverRideParameter(i, j, workflowJsonEntity);
					sourceConnection=ruleOverride.getOverrideReplace();
					targetConnection=ruleOverride.getOverrideReplace();

					stringContainsOutput(actualSource, sourceConnection, true);
					stringContainsOutput(actualTarget, targetConnection, true);
					break;

				}
			}
		}
	}


	public boolean validateConnectionsInRecentRun(DataTestingParameters param, String inputData, String workflowJsonEntity , String ruleInstanceId, String ruletype,int i) {

		boolean flag=true;
		String sourceConn=null;
		String targetConn=null;
		String subtype="";
		String actualSource="";
		String actualTarget="";
		try {

			if(!ruletype.equalsIgnoreCase(scriptContent)) {

				actualSource=getvaluefromField(returnElement(workflowExecutionRuleSrcConn, dynamicName, ruleInstanceId), sourceConnectionContent,attributeTextContent);

				if(ruletype.equalsIgnoreCase(reconContent) || ruletype.equalsIgnoreCase(checksumContent)) {

					actualTarget=getvaluefromField(returnElement(workflowExecutionRuleTrgConn, dynamicName, ruleInstanceId), targetConnectionContent,attributeTextContent);		
				}
			}

			List<String> list=getConnectionName(param, inputData);

			sourceConn=list.get(0);
			targetConn=list.get(1);

			if(!param.getSourceInput().trim().equalsIgnoreCase(removeContent)) {

				validateConnectionAsPerType(workflowJsonEntity, subtype, actualSource, actualTarget, sourceConn, targetConn, i);

			}else{
				validateConnectionForWorkflowOnRecentRun(workflowJsonEntity, i, actualSource, actualTarget);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateConnectionsInRecentRun ");

			flag=false;
		}
		return flag;
	}


	public String getcheckboxStatus(By locator) {

		String status=null;
		try {

			isDisplayedInLoop(driver, 3, locator);
			if(isDisplayed(driver, locator)) {

				String state = getAttribute(driver, locator, "className");

				status = !state.contains(checkContent) ? uncheckContent : checkContent;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getcheckboxStatus ");
		}

		return status;

	}


	public String [][] getRulesTable(List<String> list) {
		String [][] table =null;
		try {

			table = new String[list.size()+1][4];

			String [] header = {"Seq","Name", "Success","Failure", "Error","Use","Active"};

			table[0] = header;

			for(int i =0;i<list.size();i++) {

				String num=Integer.toString(i+1);

				String name=getText(driver, returnElement(workflowDetailsRulesNameList, dynamicNumber, num));

				String success=getcheckboxStatus(returnElement(workflowDetailsRulesSuccessList, dynamicNumber, num));

				String failure=getcheckboxStatus(returnElement(workflowDetailsRulesFailureList, dynamicNumber, num));

				String error=getcheckboxStatus(returnElement(workflowDetailsRulesErrorList, dynamicNumber, num));

				String use=getcheckboxStatus(returnElement(workflowDetailsRulesUseList, dynamicNumber, num));

				String active=getcheckboxStatus(returnElement(workflowDetailsRulesActiveList, dynamicNumber, num));

				String [] data = {num,name, success,failure,error,use,active};

				table[i+1] = data;

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRulesTable ");
		}
		return table;
	}

	public String [][] getRulesTable() {
		String [][] table =null;
		try {

			List<WebElement> ruleInstanceId = getElements(driver, workflowDetailsRulesUseFlags);

			table = new String[ruleInstanceId.size()+1][4];

			String [] header = {"Seq","Name", "Success","Failure", "Error","Use","Active"};

			table[0] = header;

			for(int i =0;i<ruleInstanceId.size();i++) {

				String num=Integer.toString(i+1);

				String name=getText(driver, returnElement(workflowDetailsRulesNameList, dynamicNumber, num));

				String success=getcheckboxStatus(returnElement(workflowDetailsRulesSuccessList, dynamicNumber, num));

				String failure=getcheckboxStatus(returnElement(workflowDetailsRulesFailureList, dynamicNumber, num));

				String error=getcheckboxStatus(returnElement(workflowDetailsRulesErrorList, dynamicNumber, num));

				String use=getcheckboxStatus(returnElement(workflowDetailsRulesUseList, dynamicNumber, num));

				String active=getcheckboxStatus(returnElement(workflowDetailsRulesActiveList, dynamicNumber, num));

				String [] data = {num,name, success,failure,error,use,active};

				table[i+1] = data;

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRulesTable ");
		}
		return table;
	}

	public String [][] getRulesConnectionAndParameterTable() {
		String [][] table =null;
		try {
			List<WebElement> ruleList= getElements(driver, workflowDetailsRulesTabLists);
			table = new String[ruleList.size()+1][4];

			String [] header = {"Seq","Name", "Source","Override Source", "Target","Override Target","Parameter","Override Parameter"};

			table[0] = header;

			for(int i =0;i<ruleList.size();i++) {

				String num=Integer.toString(i+1);

				String name=getText(driver, returnElement(workflowDetailsRulesNameList, dynamicNumber, num));

				String rsource=getAttribute(driver, returnElement(workflowDetailsSourceCheck, dynamicNumber, num), attributeTextContent);

				String roverridesource=getAttribute(driver, returnElement(workflowDetailsOverrideSourceCheck, dynamicNumber, num), attributeTextContent);

				String rtarget=getAttribute(driver, returnElement(workflowDetailsTargetCheck, dynamicNumber, num), attributeTextContent);

				String roverridetarget=getAttribute(driver, returnElement(workflowDetailsOverrideTargetCheck, dynamicNumber, num), attributeTextContent);

				String rparameter=getAttribute(driver, returnElement(workflowDetailsParameterCheck, dynamicNumber, num), attributeTextContent);

				String roverrideparameter=getAttribute(driver, returnElement(workflowDetailsOverrideParameterCheck, dynamicNumber, num), attributeTextContent);

				String [] data = {num,name,rsource,roverridesource,rtarget,roverridetarget,rparameter,roverrideparameter};

				table[i+1] = data;

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getRulesConnectionAndParameterTable ");
		}
		return table;
	}

	public boolean removeBulkOverrideFunctionality(boolean flag, String workflowOverrideJson) {


		try {
			if(flag) {
				List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowOverrideJson, jsonPathOverrideTypeList);

				/**		DataTestingParameters ruleOverrideParam=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH, ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);**/

				DataTestingParameters ruleOverrideParam=setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);

				for(int i =0;i<override.size();i++) {

					DataTestingParameters param =setWorkflowBulkOverrideParameters(workflowOverrideJson);

					switch(param.getOverrideType().toLowerCase()+"check") {

					case "sourcecheck":

						flag=rbulkSourceConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getSourceConnection(), overrideChangeSourceConnection);

						break;

					case "targetcheck":

						flag=rbulkTargetConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getTargetConnection(), overrideChangeTargetConnection);
						break;

					case "rulecheck":

						flag=rbulkParameterOverride(flag,  ruleOverrideParam.getRuleParameterName(), overrideChangeParameter);

						break;

					default:

						BaseSuite.reportErrorLog("expected override type not found kindly check "+param.getOverrideType());
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" removeBulkOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}


	//multiple source connection override
	public boolean rbulkSourceConnectionOverrideUsingConnectionName(boolean flag , String findconnectionName, String replaceconnectionName) {

		try {
			if(flag) {
				findconnectionName=checkNullValue(findconnectionName);
				replaceconnectionName=checkNullValue(replaceconnectionName);

				if(!findconnectionName.isEmpty()|| !replaceconnectionName.isEmpty()) {

					BaseSuite.reportLog("--------- Overriding source connections with : "+replaceconnectionName+logString);

					clickOnButton(driver, rulesDatasetsSourceConnOverrideButton, sourceConnectionOverrideField, flag);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, false);

						selectOverrideConnection(sourceConnOverrideFindConnDD, findconnectionName);

						selectOverrideConnection(sourceConnOverrideReplaceConnDD, replaceconnectionName);

						displayAndClick(driver, sourceConnOverrideReplaceConnClearIcon);

						BaseSuite.reportLog("Clicked on replace connection cross icon ");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						/**
						//	clickOnButton(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);

						//	flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToast, sourceConnectionOverrideField);
						 **/	
						flag=clickonWorkflowRulesAndDatasetTab(flag);

					}else {
						BaseSuite.reportFailLog(" source connection override window is not visible DAT-6520", "bulkSourceConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkSourceConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//multiple target connection override
	public boolean rbulkTargetConnectionOverrideUsingConnectionName(boolean flag , String findconnectionName, String replaceconnectionName) {

		try {
			if(flag) {
				findconnectionName=checkNullValue(findconnectionName);
				replaceconnectionName=checkNullValue(replaceconnectionName);

				if(!findconnectionName.isEmpty()|| !replaceconnectionName.isEmpty()) {

					BaseSuite.reportLog("--------- Overriding target connections with : "+replaceconnectionName+logString);

					clickOnButton(driver, rulesDatasetsTargetConnOverrideButton, targetConnectionOverrideField, flag);

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, false);

						selectOverrideConnection(targetConnOverrideFindConnDD, findconnectionName);

						selectOverrideConnection(targetConnOverrideReplaceConnDD, replaceconnectionName);

						displayAndClick(driver, targetConnOverrideReplaceConnClearIcon);

						BaseSuite.reportLog(" Clicked on replace connection cross icon");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
						/**
						//	clickOnButton(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);

						//	flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToast, targetConnectionOverrideField);
						 **/	
						flag=clickonWorkflowRulesAndDatasetTab(flag);

					}else {
						BaseSuite.reportFailLog(" target connection override window is not visible DAT-6520", "bulkTargetConnectionOverrideUsingConnectionName");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkTargetConnectionOverrideUsingConnectionName ");

			flag=false;
		}

		return flag;

	}

	//multiple parameter override
	public boolean rbulkParameterOverride(boolean flag, String findparameterName,String replaceparameterName) {

		try {
			if(flag) {
				findparameterName=checkNullValue(findparameterName);

				if(!findparameterName.isEmpty()) {

					BaseSuite.reportLog("--------- Overriding parameters with : "+replaceparameterName+logString);

					clickOnButton(driver, rulesDatasetsParameterConnOverrideButton, parameterOverrideField, flag);

					isDisplayedInLoop(driver, 3, parameterOverrideTitle);

					if(isDisplayed(driver, parameterOverrideTitle)) {

						verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

						verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

						verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

						verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, false);

						selectOverrideParameter(parameterOverrideFindConnDD, findparameterName);

						selectOverrideParameter(parameterOverrideReplaceConnDD, replaceparameterName);

						displayAndClick(driver, parameterOverrideReplaceConnClearIcon);

						BaseSuite.reportLog("Clicked on replace parameter cross icon");

						flag=clickonWorkflowRulesAndDatasetTab(flag);

					}else {
						BaseSuite.reportFailLog(" parameter override window is not visible DAT-6520", "bulkParameterOverride");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkParameterOverride ");

			flag=false;
		}

		return flag;

	}

	public boolean bulkOverrideFunctionalityCheck(DataTestingParameters param, String inputData, boolean flag) {
		log.info(inputData);
		if(param.getSourceInput().trim().equalsIgnoreCase(removeContent)) {

			flag=removeBulkOverrideFunctionality(flag, param.getOverrideReplace());

		}else if(param.getSourceInput().trim().equalsIgnoreCase("add")) {

			flag=bulkOverrideFunctionality(flag, param.getOverrideReplace());
		}else {
			flag=changebulkOverrideFunctionality(flag,  param.getOverrideReplace());
		}
		return flag;
	}

	public String validateTextContent(By locator, String label) {
		String value="" ;
		try {
			isDisplayedInLoop(driver, 3, locator);

			javascript(driver, scrollToElementArg, locator);

			if(isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog(label+visibleContent);

				value = getAttribute(driver, locator, attributeTextContent);

				if(value!=null) {
					BaseSuite.validationReportLog(value);
				}else {
					BaseSuite.reportFailLog(label+" value is not visible","validateTextContent");
				}
			}else {
				BaseSuite.reportFailLog(label+" is not visible","validateTextContent");
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateTextContent ");
		}
		return value;
	}

	public void validateWorkflowCreateUpdatedFormat() {

		validateTextContent(workflowDetailsUpdatedBy, "Created by");

		validateTextContent(workflowDetailsUpdatedDate, "Updated by");

	}

	//New Bulk changes 
	public boolean selectFolderToBulkChanges(boolean flag,String folderPath) {
		Actions action = new Actions(driver);
		String [] folder;
		String bfolderName="";
		try {
			if(flag && !folderPath.isEmpty()){

				verifyIndividualLabel(driver, bulkChangesFolderTitle, folderContent);

				isDisplayedInLoop(driver, 3, bulkChangesFolderField);

				if(isDisplayed(driver, bulkChangesFolderField)) {

					displayAndClick(driver, bulkChangesFolderFieldDropIcon);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					if(folderPath.contains("/")) {
						folderPath = folderPath.substring(1);

						if(folderPath.contains("/")) {

							folder = folderPath.split("/");
							bfolderName=folder[2];
						}
					}else {
						bfolderName=folderPath;
					}

					searchFunctionalityMethod(driver, flag, bulkChangesFolderFieldSearchBar, bulkChangesFolderFieldSearchIcon, searchFolderContent, workflowFolderSearchPlaceholder, bfolderName);

					WebElement ele = driver.findElement(returnElement(bulkChangesFolderName, dynamicName, folderPath));
					WebElement ele1 = driver.findElement(returnElement(bulkChangesFolderNameSelect, dynamicName, folderPath));

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					action.moveToElement(ele1).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectFolderToBulkChanges ");
			flag=false;
		}
		return flag;
	}

	public boolean validateBulkChangesNotify(int numberOfEntity,String changesType, String folderName) {
		String notify ="";
		String getMsg="";
		boolean flag=true;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			if (numberOfEntity==1) {
				if (changesType.equalsIgnoreCase("copy")) {

					notify = "You will be Copying " + numberOfEntity + " workflow to " + folderName + folderDotContent;
					getMsg = getAttribute(driver, bulkChangesFolderNotifyMsg, attributeTextContent);

				} else if (changesType.equalsIgnoreCase("move")) {
					notify = "You will be Moving " + numberOfEntity + " workflow to " + folderName + folderDotContent;
					getMsg = getAttribute(driver, bulkChangesFolderNotifyMsg, attributeTextContent);

				} else if (changesType.isEmpty()) {
					notify = "You will be deleting " + numberOfEntity + " workflow.";
					getMsg = getAttribute(driver, bulkChangesNotifyMsg, attributeTextContent);
				} 
			}else if(numberOfEntity>1) {

				if (changesType.equalsIgnoreCase("copy")) {

					notify = "You will be Copying " + numberOfEntity + " workflows to " + folderName + folderDotContent;
					getMsg = getAttribute(driver, bulkChangesFolderNotifyMsg, attributeTextContent);

				} else if (changesType.equalsIgnoreCase("move")) {
					notify = "You will be Moving " + numberOfEntity + " workflows to " + folderName + folderDotContent;
					getMsg = getAttribute(driver, bulkChangesFolderNotifyMsg, attributeTextContent);

				} else if (changesType.isEmpty()) {
					notify = "You will be deleting " + numberOfEntity + " workflows.";
					getMsg = getAttribute(driver, bulkChangesNotifyMsg, attributeTextContent);
				}
			}
			flag=stringOutput(getMsg, notify, true);

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateBulkChangesNotify ");
			flag=false;

		}
		return flag;
	}


	public boolean validateProgressOfBulkChanges(boolean flag) {
		String methodName = "validateProgressOfBulkChanges";
		int a=0;
		try {
			isDisplayedInLoop(driver, 3, bulkChangesRefreshLogs);

			if(isDisplayed(driver, bulkChangesRefreshLogs)) {

				clickOnButton(driver, bulkChangesRefreshLogs, "Refresh logs", true);

				while(!isDisplayed(driver, bulkChangesCopyToClipboard) && a<=5) {
					displayAndClick(driver, bulkChangesRefreshLogs);
					a++;
				}

				isDisplayedInLoop(driver, 3, bulkChangesCopyToClipboard);
				if(isDisplayed(driver, bulkChangesCopyToClipboard)) {

					clickOnButton(driver, bulkChangesCopyToClipboard, "Copy to clipboard", true);

					captureToastMsgWithOutWait(driver,toastMsg, toastMsgClosedBtn, "Copied to clipboard.", attributeAriaLabel);

				}else {
					BaseSuite.reportFailLog("Copy to clipboard icon not visible", methodName);
				}

				BaseSuite.reportLog("-------------- checking bulk changes logs... ");

				String progCon = getAttribute(driver, bulkChangesLogs, attributeInnertext);

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
			BaseSuite.reportErrorLog(e,errorLogTitle+" "+methodName+" ");
			flag=false;
		}
		return flag;
	}


	/****************************************************************** Default Workflow code ***********************************************************************************/	

	//view default workflow and validate fields
	public boolean viewDefaultWorkflow(String workflowJsonEntity,boolean workflowState, String icedqUser) {

		boolean flag =true;

		try {

			BaseSuite.reportLog("Verifying for user "+icedqUser);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbHomeLink, homeContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbWorkflowsLink, workflowContent, flag);
			/**
				verifyIndividualLabel(driver, returnElement(workflowBreadcrumbFolderName, dynamicName, workflowParam.getWorkflowfolderName()), workflowParam.getWorkflowfolderName()+"folder name bread-crumb");
			 **/
			verifyIndividualLabel(driver, returnElement(workflowNameTitle, dynamicName, workflowParam.getWorkflowName()), workflowParam.getWorkflowName());

			verifyIndividualLabel(driver, returnElement(workflowTypeInDetailsPage, dynamicName, workflowParam.getWorkflowType()), workflowParam.getWorkflowType()+" type");

			verifyVisibilityOfButtons(driver, workflowDetailsOverviewTab, overviewContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsRuleAndDatasetsTab, rulesContent, true);

			clickOnButton(driver, workflowDetailsOverviewTab, overviewContent, true);

			viewAndValidateField(workflowDetailsWorkflowNameField, fieldWorkflowName, workflowParam.getWorkflowName(), false);

			viewAndValidateField(workflowDetailsWorkflowCodeField, workflowCodeContent, workflowParam.getWorkflowCode(), false);

			viewAndValidateField(workflowDetailsDescriptionField, workflowDescriptionContent, workflowParam.getWorkflowDescription(), false);

			isDisplayedInLoop(driver, 3, workflowDetailsCurrentStatus);

			String acStatus = getAttribute(driver, workflowDetailsCurrentStatus, attributeTitle);

			BaseSuite.reportLog("Workflow state is "+acStatus);

			validateButtonsForDefaultWorkflowDetailsOnRevisit(acStatus,workflowState);

			validateMoreOptionButtons(workflowParam.getWorkflowType(), workflowState,icedqUser);

			if(!acStatus.toLowerCase().contains(draftContent)) {

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				validateDefaultWorkflowRuleFields();

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				flag=validateAddedRuleInDefalutWorkflow(flag, ruleList, workflowJsonEntity,Boolean.toString(workflowState));

			}

			searchRecentRunOnRecentRunsField(true, "");

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunRefreshButton, refreshContent, true);

			validateColumnsListForWorkflowService(workflowDetailsRecentRunsTabColumns, workflowDetailsRecentRunsTabColumnLocator, "Recent Runs tab on workflow details page ");

			getPaginationDetails(driver, workflowDetailsRecentRunsPaginationMsg, workflowDetailsRecentRunsPagearrow, workflowDetailsPageRecentRunsNoRecordDisplay,recentRunsContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" viewDefaultWorkflow ");

			flag=false;
		}
		return flag;
	}


	//validate rule and data set fields 
	public boolean validateDefaultWorkflowRuleFields() {
		boolean flag = true;
		try {
			verifySearchField(driver,rulesDatasetsSearchBar, searchPlaceholder, rulesSearchBarPlaceholder);

			isDisplayedInLoop(driver, 1, rulesNoRecordsToDisplay);

			verifyVisibilityOfButtons(driver, rulesDatasetsRunButton, runOptionField, false);

			verifyVisibilityOfButtons(driver, rulesDatasetsSourceConnOverrideButton, sourceConnectionOverrideField, false);

			verifyVisibilityOfButtons(driver, rulesDatasetsTargetConnOverrideButton,targetConnectionOverrideField, false);

			verifyVisibilityOfButtons(driver, rulesDatasetsParameterConnOverrideButton, parameterOverrideField, false);

			verifyVisibilityOfButtons(driver, rulesDatasetsRunButton, deleteField, false);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateDefaultWorkflowRuleFields ");
			flag=false;
		}
		return flag;
	}


	//validate added rules in workflow
	public boolean validateAddedRuleInDefalutWorkflow(boolean flag, List<String> ruleList, String workflowJsonEntity,String isActive) {

		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				for(int i=0;i<ruleList.size();i++) {

					/**			DataTestingParameters rulesParam = getDataTestingInfoFromDataBase("",ruleList.get(i)); **/

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("--------  Validate added rule : "+ruleParam.getRuleName()+" in workflow  ");

					flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());

					if(flag && elementNotVisible(driver, workflowDetailsRulesNoRecordFound)) {

						checkExpectedValueWithActualValue(flag, defaultWorkflowRuleSeq, "Sequence", Integer.toString(i+1));

						checkExpectedValueWithActualValue(flag, defaultWorkflowRuleName, "Name", ruleParam.getRuleName());

						checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess());

						checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleFailureFlag,failureContent, ruleParam.getOnFailure());

						checkFlagStatus(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError());

						checkConnectionAndParameterOnAddedRulesForDefault(flag, ruleParam, "");

						checkRuleFlagStatus(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode());

						checkRuleFlagStatus(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, isActive);

						checkExpectedValueWithActualValue(flag, defaultWorkflowRuleFolder, folderContent, ruleParam.getRuleFolderName());

					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

				javascript(driver, scrollToElementArg, rulesDatasetsSearchBar);

				displayAndClick(driver, rulesDatasetsSearchBar);

				clear_Click_SendKeys(driver, 0, rulesDatasetsSearchBar, "");

				displayAndClick(driver, rulesDatasetsSearchButton);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddedRuleInDefalutWorkflow ");

			flag=false;
		}
		return flag;
	}


	public void validateButtonsForDefaultWorkflowDetailsOnRevisit(String workflowStatus, boolean workflowState) {

		switch (workflowStatus.toUpperCase().trim()) {

		case "DRAFT":
		case "VALIDATED":	

			verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, false);

			verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsReloadButton, recentRunsContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

			break;

		case "PUBLISHED":

			verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, workflowState);

			verifyVisibilityOfButtons(driver, workflowDetailsPublishButton, workflowPublish, false);

			verifyVisibilityOfButtons(driver, workflowDetailsDiscardButton, discardContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunsReloadButton, recentRunsContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsDeleteButton, deleteContent, false);

			verifyVisibilityOfButtons(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);

			break;	

		default:
			break;
		}
	}


	public void verifyElementValue(By locator, String label, String expectedValue) {


		try {
			isDisplayedInLoop(driver, 2, locator);

			if(isDisplayed(driver, locator)) {

				checkExpectedValueWithActualValue(false, locator, label, expectedValue);

			}else {
				BaseSuite.reportFailLog("", "verifyElementValue");
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" verifyElementValue ");
		}


	}

	//check expected and actual values
	public boolean checkExpectedValueWithActualValue(boolean flag, By locator,String label, String expectedValue) {

		expectedValue=checkNullValue(expectedValue);

		if(!expectedValue.isEmpty()) {

			BaseSuite.reportLog("Validating "+label+" field value");

			isDisplayedInLoop(driver, 5, locator);

			String ac="";
			try {
				ac = getAttribute(driver, locator, attributeValue);
			} catch (Exception e) {

				ac = getAttribute(driver, locator, attributeTextContent);

			}finally {
				if(ac==null) {
					ac = getAttribute(driver, locator, attributeTextContent);
				}
			}

			flag=stringOutput(ac, expectedValue, true);
		}
		return flag;
	}


	public void validateMoreOptionButtons(String workflowType, boolean workflowState, String icedqUser) {

		boolean duplicate=false;
		boolean deactivate=false;
		boolean activate=false;
		boolean subscription=false;
		try {
			boolean flag = clickOnButton(driver, workflowDetailsMoreOptionButton, moreOptionContent, true);
			javascript(driver, jscriptToMouseHover, workflowDetailsMoreOptionButton);
			if(flag) {

				if(workflowType.trim().equalsIgnoreCase("custom")) {
					duplicate=true;
					deactivate=true;
					activate=true;
					subscription=true;
				}

				checkFieldIsEnabledOrNotUsingAttribute(driver, moreOptionDuplicateButton, duplicateContent, attributeClass, duplicate);
				checkFieldIsEnabledOrNotUsingAttribute(driver, moreOptionShareButton, shareContent, attributeClass, true);

				if(workflowState) {

					checkFieldIsEnabledOrNotUsingAttribute(driver, moreOptionDeactivateButton, deactivateContent, attributeClass, deactivate);
				}else {

					checkFieldIsEnabledOrNotUsingAttribute(driver, moreOptionActivateButton, activateContent, attributeClass, activate);
				}

				if(icedqUser.contains(ownerContent)) {

					checkFieldIsEnabledOrNotUsingAttribute(driver, moreOptionSubscriptionButton, "Subscription", attributeClass, subscription);
				}else {

					checkFieldIsEnabledOrNotUsingAttribute(driver, subscribeButton, "Subscribe", attributeClass, subscription);
				}


			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateMoreOptionButtons ");
		}
	}


	//update workflow using automation database details
	public boolean updateNewRuleFromCustomWorkflowDetailsPage(DataTestingParameters param,String workflowName, String folderName,String ruleType, boolean isOverride, String icedqUser) {

		boolean flag = true;
		boolean status=true;
		String newWorkflowName=null;
		String workflowid=null;
		/**		DataTestingPage dp = new DataTestingPage(driver); **/
		String mainWindow=null;
		try {
			log.info(ruleType);
			String workflowJsonEntity=param.getWorkflowJsonValue();
			/**		String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue(); **/
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			/**			String ruleJson=param.getRuleJsonValue();**/
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			status=searchAndClickOnWorkflowNameOnWorkflowListingPage(workflowName,folderName);

			if(status) {

				if(!icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

					mainWindow=clickOnNewRuleInWorkflowDetails(flag, true,icedqUser);

					/**		dp.createRuleForWorkflow(ruleJson, folderName, ruleType,downloadZip, icedqUser);**/

					closeCurrentTabAndSwitchToMain(driver, mainWindow);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					validateWorkflowCreateUpdatedFormat();

					if(!workflowMode.toLowerCase().contains(draftContent)) {

						flag=clickonWorkflowRulesAndDatasetTab(flag);

						List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

						addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

						flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

						flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	
					}
					flag = clickOnWorkflowSaveOption(flag,workflowMode, workflowCreatedToastMsg,icedqUser);

					if(flag) {

						workflowid = getWorkflowIdOnWorkflowDetailsPage();

						/**	flag=subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); **/

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport,workflowExecutionStatus, icedqUser);
					}
				}else if(icedqUser.contains(readerFlag) || icedqUser.contains(executorContent)){

					mainWindow=clickOnNewRuleInWorkflowDetails(flag, true,icedqUser);

					closeCurrentTabAndSwitchToMain(driver, mainWindow);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=ConstantProperty.fLAG;
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createNewRuleFromCustomWorkflowDetailsPage ");

			flag=false;
		}

		return flag;

	}

	//create workflow using automation database details
	public boolean updateAddedRuleFromCustomWorkflowDetailsPage(DataTestingParameters param,String searchWorkflowName,String folderName, boolean isOverride, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		/**			DataTestingPage dp = new DataTestingPage(driver); **/
		List<String> ruleList=null;
		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowUpdateJson=param.getWorkflowUpdateJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);
			DataTestingParameters upworkflowParam = setWorkflowParametersForApi(workflowUpdateJson);
			newWorkflowName = workflowParam.getWorkflowName();

			flag=searchAndClickOnWorkflowNameOnWorkflowListingPage(searchWorkflowName,folderName);

			if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

				flag=clickonWorkflowOverviewAndEnterDetails(flag,upworkflowParam.getWorkflowName(), upworkflowParam.getWorkflowCode(), upworkflowParam.getWorkflowDescription());

				validateWorkflowCreateUpdatedFormat();

				ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				for(int i=0; i<ruleList.size();i++) {

					clickonWorkflowRulesAndDatasetTab(flag);

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("----------------------- updating added rule :"+ruleParam.getRuleName()+" ------------------------");

					flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());

					clickOnButton(driver, returnElement(worklfowAddedRuleNameLink, dynamicName, ruleParam.getRuleName()), ruleParam.getRuleName(), true);

					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					/**			dp.updateRuleForWorkflow(ruleUpdateJson, exceptionReport,sourceConnection,targetConnection,parameterName, icedqUser);	**/

					driver.navigate().back();

				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(!workflowMode.toLowerCase().contains(draftContent)) {

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					driver.navigate().refresh();

					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowUpdateJson, workflowRuleListJsonPath);

					//validate rule details

					flag=selectWorkflowRulesFlag(flag,ruleList, workflowUpdateJson,isOverride);	
				}

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);

				if(flag) {

					workflowid = getWorkflowIdOnWorkflowDetailsPage();

					subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport, workflowExecutionStatus,icedqUser);
				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateAddedRuleFromCustomWorkflowDetailsPage ");

			flag=false;
		}

		return flag;

	}



	/**----------------------------- Workflow Invalid Scenario code --------------------------**/


	// set workflow parameters using excel
	public DataTestingParameters setWorkflowParametersForInvalid(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			param.setTestScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, "testScenarioName"));
			param.setTestScenarioResult(xl.readUsingColName(fileName, sheetName, rowNumber, keytestResult));
			param.setWorkflowfolderName(xl.readUsingColName(fileName, sheetName, rowNumber, "folderPath"));
			param.setWorkflowName(xl.readUsingColName(fileName, sheetName, rowNumber, keyworkflowName));
			param.setWorkflowJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, keyworkflowJson));
			param.setWorkflowUpdateJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "workflowUpdateJson"));
			param.setWorkflowSubscriptionJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "subscriptionJson"));
			param.setWorkflowOverrideJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, "overrideJson"));
			param.setWorkflowExecutionStatus(xl.readUsingColName(fileName, sheetName, rowNumber, keyexecutionStatus));
			param.setWorkflowExecutionExitCode(xl.readUsingColName(fileName, sheetName, rowNumber, keyexitCode));
			param.setWorkflowSaveMode(xl.readUsingColName(fileName, sheetName, rowNumber, "saveMode"));
			param.setWorkflowDownloadZip(xl.readUsingColName(fileName, sheetName, rowNumber, "downloadZip"));
			param.setWorkflowExceptionReportCheck(xl.readUsingColName(fileName, sheetName, rowNumber, "exceptionReportCheck"));

			param.setIsOverride(xl.readUsingColName(fileName, sheetName, rowNumber, keyisOverride));
			param.setRunType(xl.readUsingColName(fileName, sheetName, rowNumber, keyrunType));
			param.setSequenceSelect(xl.readUsingColName(fileName, sheetName, rowNumber, "sequenceSelect"));
			param.setSequenceShuffle(xl.readUsingColName(fileName, sheetName, rowNumber, "sequenceShuffle"));
			param.setSequenceDelete(xl.readUsingColName(fileName, sheetName, rowNumber, "sequenceDelete"));

			param.setFunctionality(xl.readUsingColName(fileName, sheetName, rowNumber, "functionality"));
			param.setSourceInput(xl.readUsingColName(fileName, sheetName, rowNumber, "input"));

			param.setOverrideReplace(xl.readUsingColName(fileName, sheetName, rowNumber, "overrideParameter"));
			param.setRuleJsonValue(xl.readUsingColName(fileName, sheetName, rowNumber, keyRuleInfo));
			param.setRuleType(xl.readUsingColName(fileName, sheetName, rowNumber, "ruleType"));		

			param.setScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, keyScenarioName));
			param.setScenarioType(xl.readUsingColName(fileName, sheetName, rowNumber, keyScenarioType));
			param.setFieldValidationMessage(xl.readUsingColName(fileName, sheetName, rowNumber, "fieldValidation"));
			param.setToastValidationMessage(xl.readUsingColName(fileName, sheetName, rowNumber, "toastValidation"));

			param.setFind(xl.readUsingColName(fileName, sheetName, rowNumber, "find"));
			param.setReplace(xl.readUsingColName(fileName, sheetName, rowNumber, "replace"));

			param.setSearchName(xl.readUsingColName(fileName, sheetName, rowNumber, "searchWorkflowName"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" setWorkflowParametersForInvalid "+e.toString());
		}
		return param;

	}

	//validate and enter workflow overview details
	public boolean clickonWorkflowOverviewAndEnterDetailsForInvalid(boolean flag,String workflowName,String workflowCode,String workflowDescription,String field, String fieldValidation) {

		String methodName="clickonWorkflowOverviewAndEnterDetails";
		try {
			if(flag) {

				isDisplayedInLoop(driver, 3, workflowDetailsOverviewTab);

				if(isDisplayed(driver, workflowDetailsOverviewTab)) {

					BaseSuite.reportLog("Workflow Overview tab is visible");

					BaseSuite.reportLog("Clicking on Workflow Overview tab");

					displayAndClick(driver, workflowDetailsOverviewTab);

					BaseSuite.reportLog("Clicked on Workflow Overview tab");

					if(isDisplayed(driver, workflowDetailsWorkflowNameLabel)) {

						BaseSuite.validationReportLog("Workflow overview tab fields visible ");

						switch(field.toLowerCase()) {

						case "name":
							validatAndEnterValueToTextFieldForValidation(driver, workflowDetailsWorkflowNameLabel, workflowDetailsWorkflowNameField,workflowDetailsWorkflowNameValidation, fieldWorkflowName,"", workflowName, fieldValidation);
							break;
						case "code":
							validatAndEnterValueToTextFieldForValidation(driver, workflowDetailsWorkflowCodeLabel, workflowDetailsWorkflowCodeField, workflowDetailsWorkflowCodeValidation, workflowCodeContent, workflowCodePlaceholder, workflowCode, fieldValidation);
							break;	
						case "description":
							validatAndEnterValueToTextFieldForValidation(driver, workflowDetailsDescriptionLabel, workflowDetailsDescriptionField,workflowDetailsDescriptionValidation, descriptionContent, workflowDescriptionPlaceholder, workflowDescription, fieldValidation);
							break;

						default:
							break;
						}
					}else {
						BaseSuite.reportFailLog("Workflow overview fields not visible", methodName);
						flag=false;
					}
				}

			}else {
				BaseSuite.reportFailLog("Workflow overview tab not visible", methodName);
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+methodName+" ");
			flag=false;
		}
		return flag;

	}

	public boolean validateAddWorkflowDetails(boolean flag,String workflowName,String folderName, String fieldValidation) {
		ParametersServicePage ps = new ParametersServicePage(driver);
		try {
			validateAddNewWorkflowSideBar();

			ps.searchAndSelectFolderOnAddNewPane(folderName, "workflow");

			enterValueToTextField(driver, workflowNameFieldInput, fieldWorkflowName, workflowName);	

			String acmesg = validationMessageOfField(driver, workflowFieldValidation, fieldWorkflowName, fieldValidation, true);

			if(!fieldValidation.equalsIgnoreCase(acmesg)) {
				flag=false;
			}

			clickOnButton(driver, addNewWorkflowCancelButton, cancelButtonContent, true);
		} catch (Exception e) {
			flag=false;
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddWorkflowDetails ");
		}

		return flag;
	}

	public boolean validateSFEFlagDetails(DataTestingParameters workflowParam, String newWorkflowName,String folderName, String workflowJsonEntity,List<String> ruleList,boolean isOverride,String icedqUser) {
		boolean flag=true;
		try {
			List<String> list=null;
			log.info(ruleList);
			if(!icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

				flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName, workflowParam.getWorkflowType());

				/**			flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());**/

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				list = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				flag=addRulesToWorkflowDetails(flag,list, workflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowRulesFlag(flag,list, workflowJsonEntity,isOverride);	

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateSFEFlagDetails ");
		}
		return flag;
	}

	public boolean validateSingleOverrideForInvalid(boolean flag,String rulename,String scenarioName,String input,String toastValidation) {
		XLUtils xl = new XLUtils();
		String connName="";
		String readColumnName="";
		try {
			log.info(input);
			if(workflowExecutionConfigColumnName.isEmpty()) {
				readColumnName=valueColumn;
			}else {
				readColumnName=workflowExecutionConfigColumnName;
			}
			switch(scenarioName) {

			case "src":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleSourceConnection, readColumnName);
				flag=singleSourceConnectionOverrideUsingConnectionName(flag, rulename, connName,toastValidation);
				break;

			case "trg":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleTargetConnection, readColumnName);
				flag=singleTargetConnectionOverrideUsingConnectionName(flag,rulename,connName,toastValidation);
				break;

			case "param":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleParameter, readColumnName);
				flag=singleParameterOverride(flag,rulename, connName, toastValidation);
				break;

			default:

				BaseSuite.reportErrorLog("error occurs while updateCustomWorkflowForInvalidScenario kindly check "+scenarioName);
				flag=false;
				break;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"validateSingleOverrideForInvalid ");
			flag=false;
		}
		return flag;
	}

	public boolean validateMultipleOverrideForInvalid(boolean flag,String scenarioName,String find,String replace,String toastValidation) {
		XLUtils xl = new XLUtils();
		String connName1="";
		String connName="";
		String readColumnName="";
		try {
			log.info(find+replace);
			if(workflowExecutionConfigColumnName.isEmpty()) {
				readColumnName=valueColumn;
			}else {
				readColumnName=workflowExecutionConfigColumnName;
			}
			switch(scenarioName) {

			case "src":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleSourceConnection, readColumnName);

				flag=multipleSourceConnectionOverrideUsingConnectionName(flag, connName,connName,toastValidation);
				break;

			case "trg":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleTargetConnection, readColumnName);

				flag=multipleTargetConnectionOverrideUsingConnectionName(flag,connName, connName,toastValidation);
				break;

			case "param":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleParameter, readColumnName);

				flag=multipleParameterOverride(flag,connName, connName, toastValidation);
				break;

			case "src0":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleOverrideSource,readColumnName);
				connName1=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleOverridetarget,readColumnName);

				flag=multipleSourceConnectionOverrideUsingConnectionName(flag, connName,connName1,toastValidation);
				break;

			case "trg0":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleOverrideSource,readColumnName);
				connName1=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, keyRuleOverridetarget,readColumnName);


				flag=multipleTargetConnectionOverrideUsingConnectionName(flag,connName, connName1,toastValidation);
				break;

			case "param0":
				connName=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, "RuleOverrideParameter",readColumnName);
				connName1=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, "RuleParameter",readColumnName);


				flag=multipleParameterOverride(flag,connName, connName1, toastValidation);
				break;
			default:

				BaseSuite.reportErrorLog("error occurs while multipleOverrideFunctionality kindly check "+scenarioName);
				flag=false;
				break;

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"validateMultipleOverrideForInvalid ");
			flag=false;
		}
		return flag;
	}


	public boolean createCustomWorkflowForInvalidScenario(DataTestingParameters param, String folderName, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		List<String> ruleList=null;
		try {
			String workflowName=param.getWorkflowName();
			String workflowJsonEntity=param.getWorkflowJsonValue();				
			String fieldValidation=param.getFieldValidationMessage();
			String toastValidation=param.getToastValidationMessage();
			String scenarioName=param.getScenarioName();
			String scenarioType=param.getScenarioType();	
			boolean isOverride=Boolean.parseBoolean(param.getIsOverride());
			String workflowMode=param.getWorkflowSaveMode();
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			createNewFolderOrSelectExistingOnFolderSearchSideBar(folderName);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= clickOnNewWorkflowButton(flag,icedqUser);

			if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent)) {

				switch(scenarioType.toLowerCase()) {

				case "addworkflowname":

					flag=validateAddWorkflowDetails(flag, workflowName,folderName, fieldValidation);

					break;

				case "workflowcode":
				case "wfdescription":
				case "workflowname":

					flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetailsForInvalid(flag, workflowName, workflowName, workflowName, scenarioName, fieldValidation);

					break;

				case "sfe":

					flag=validateSFEFlagDetails(workflowParam, newWorkflowName,folderName, workflowJsonEntity, ruleList, isOverride, icedqUser);

					break;

				case "singleoverride":

					flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName, workflowParam.getWorkflowType());

					/**		flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());**/

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					/**		flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	**/

					flag=validateSingleOverrideForInvalid(flag, ruleList.get(0), scenarioName, param.getReplace(), toastValidation);

					break;

				case "bulkoverride":

					flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName, workflowParam.getWorkflowType());

					/**		flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());**/

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					/**		flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	**/

					flag=validateMultipleOverrideForInvalid(flag, scenarioName, param.getFind(),param.getReplace(), toastValidation);

					break;

				case "workflowexist":

					flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag = clickOnWorkflowSaveOptionForInvalid(flag,workflowMode, toastValidation);

					break;

				case "activity":

					String timestamp = new SimpleDateFormat(ConstantProperty.CONNECTIONNAME_TIMESTAMPFORMAT).format(new Date());

					flag=enterDetailsToAddNewWorkflowPane(flag,folderName, newWorkflowName+ConstantProperty.SIGN_UNDERSCORE+timestamp, workflowParam.getWorkflowType());

					clickonWorkflowRulesAndDatasetTab(flag);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag = clickOnWorkflowSaveOptionForInvalid(flag,workflowMode, toastValidation);

					break;
				default:

					break;
				}

			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+"createCustomWorkflowForInvalidScenario ");
			flag=false;
		}

		return flag;
	}

	public boolean updateCustomWorkflowForInvalidScenario(DataTestingParameters param,String searchWorkflowName, String folderName, String icedqUser) {

		boolean flag = true;
		boolean status=true;
		log.info(icedqUser);
		List<String> ruleList=null;
		try {
			String workflowName = param.getWorkflowName();
			String workflowJsonEntity=param.getWorkflowJsonValue();				
			String fieldValidation=param.getFieldValidationMessage();
			String toastValidation=param.getToastValidationMessage();
			String scenarioName=param.getScenarioName();
			String scenarioType=param.getScenarioType();	
			boolean isOverride=Boolean.parseBoolean(param.getIsOverride());
			String workflowMode=param.getWorkflowSaveMode();
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			status=searchAndClickOnWorkflowNameOnWorkflowListingPage(searchWorkflowName,folderName);

			if(status) {

				switch(scenarioType.toLowerCase()) {

				case "workflowcode":
				case "wfdescription":
				case "workflowname":

					flag=clickonWorkflowOverviewAndEnterDetailsForInvalid(flag, workflowName, workflowName, workflowName, scenarioName, fieldValidation);
					validateWorkflowCreateUpdatedFormat();
					break;

				case "sfe":


					clickonWorkflowRulesAndDatasetTab(flag);

					ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	


					break;

				case "singleoverride":

					clickonWorkflowRulesAndDatasetTab(flag);

					ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=validateSingleOverrideForInvalid(flag, ruleList.get(0), scenarioName, param.getReplace(), toastValidation);

					break;

				case "bulkoverride":

					clickonWorkflowRulesAndDatasetTab(flag);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=validateMultipleOverrideForInvalid(flag, scenarioName, param.getFind(),param.getReplace(), toastValidation);

					break;

				case "workflowexist":

					flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());
					validateWorkflowCreateUpdatedFormat();
					clickonWorkflowRulesAndDatasetTab(flag);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag = clickOnWorkflowSaveOptionForInvalid(flag,workflowMode, toastValidation);

					break;

				case "activity":


					clickonWorkflowRulesAndDatasetTab(flag);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag = clickOnWorkflowSaveOptionForInvalid(flag,workflowMode, toastValidation);

					break;
				default:

					break;
				}

			}else {
				flag=false;
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateCustomWorkflowForInvalidScenario ");
			flag=false;
		}

		return flag;
	}


	public boolean validateAndSingleOverrideFunctionalityForInvalid(boolean flag,String workflowJsonEntity ,List<String> ruleList, int i, boolean isOverride, String invalidConnection) {

		int row;
		String subtype="";
		List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

		if(isOverride) {
			row=1;
		}else {
			row=3;
		}

		DataTestingParameters ruleOverrideParam=setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, row);

		for(int j=0;j<override.size();j++) {

			/**	DataTestingParameters ruleOverrideParam =setWorkflowRuleOverRideParameter(i, j, workflowJsonEntity);**/

			subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

			subtype=checkNullValue(subtype);

			if(!subtype.isEmpty()) {

				switch(subtype.trim()+"xyz1") {

				case "sourcexyz1":
					flag=singleSourceConnectionOverrideUsingConnectionName(flag, ruleList.get(i), invalidConnection,workflowSingleSourceConnectionOverrideToastMsg);
					break;

				case "targetxyz1":
					flag=singleTargetConnectionOverrideUsingConnectionName(flag,ruleList.get(i), invalidConnection,workflowSingleTargetConnectionOverrideToastMsg);
					break;

				case "rulexyz1":
					flag=singleParameterOverride(flag,ruleList.get(i), ruleOverrideParam.getOverrideParameter(), workflowSingleParameterOverrideToastMsg);
					break;

				default:

					BaseSuite.reportErrorLog("error occurs while validateAndSingleOverrideFunctionalityForInvalid kindly check "+ruleOverrideParam.getOverrideSubType());
					flag=false;
					break;

				}}
		}
		return flag;
	}

	public boolean bulkOverrideFunctionalityForInvalid(boolean flag, String workflowOverrideJson, String invalidConnection) {


		try {
			if(flag) {
				List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowOverrideJson, jsonPathOverrideTypeList);

				/**	DataTestingParameters ruleOverrideParam=setWorkflowOverrideParameterUsingExcelData(WORKFLOWEXCELFILEPATH, ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);**/
				DataTestingParameters ruleOverrideParam=setOverrideParametersForRuleUsingExcel(WORKFLOWEXCELFILEPATH,ConstantProperty.WORKFLOW_EXCEL_SHEET_OVERRIDE, 2);

				for(int i =0;i<override.size();i++) {

					DataTestingParameters param =setWorkflowBulkOverrideParameters(workflowOverrideJson);

					switch(param.getOverrideType().toLowerCase()+"over") {

					case "sourceover":

						flag=multipleSourceConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getSourceConnection(), invalidConnection, "Override source connection");

						break;

					case "targetover":

						flag=multipleTargetConnectionOverrideUsingConnectionName(flag, ruleOverrideParam.getTargetConnection(), invalidConnection, "Override target connection");
						break;

					case "ruleover":

						flag=multipleParameterOverride(flag,  ruleOverrideParam.getRuleParameterName(), ruleOverrideParam.getOverrideParameter(), "Override parameter");

						break;

					default:

						BaseSuite.reportErrorLog("override type not found kindly check "+param.getOverrideType());
						flag=false;
						break;

					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" bulkOverrideFunctionality ");

			flag=false;
		}
		return flag;
	}

	//select workflow rules flag
	public boolean selectWorkflowRulesFlagForInvalid(boolean flag, List<String> ruleList, String workflowJsonEntity,boolean isOverride,String invalidConnection) {
		ruleSequenceUseFlagList=null;
		rulesConfigurationtable=null;
		try {
			if(!ruleList.isEmpty() && flag) {

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("----------------------- validating added rule :"+ruleParam.getRuleName()+" and configuring features of workflow ------------------------");

					flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());

					if(i<(ruleList.size()-1)){
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFEUncheck);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFEUncheck);	
					}else {
						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), workflowToastSFELastSequence);

						flag=selectRuleFlags(flag,ruleList.get(i), workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), workflowToastSFELastSequence);	
					}

					checkConnectionAndParameterOnAddedRules(flag, ruleParam);

					flag=validateAndSingleOverrideFunctionalityForInvalid(flag, workflowJsonEntity, ruleList, i,isOverride,invalidConnection);

					if(i<(ruleList.size()-1)){

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),"");

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),"");

					}else {

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),workflowToastUseColumnEnabled);

						flag=selectRuleUseAndActiveFlags(flag,ruleList.get(i), workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),workflowToastActiveColumnEnabled);

					}
					validateFolderNameOnRuleDatasetTab(ruleParam.getRuleName(), ruleParam.getRuleFolderName());


				}

				displayAndClick(driver, rulesDatasetsSearchBar);

				clear_Click_SendKeys(driver, 0, rulesDatasetsSearchBar, "");

				displayAndClick(driver, rulesDatasetsSearchButton);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();

				rulesConfigurationtable=getRulesTable(ruleList);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectWorkflowRulesFlagForInvalid ");

			flag=false;
		}

		return flag;
	}


	public String getConnectionNameForExcel(String invalidConnection) {
		XLUtils xl = new XLUtils();
		String readColumnName="";
		if(workflowExecutionConfigColumnName.isEmpty()) {
			readColumnName=valueColumn;
		}else {
			readColumnName=workflowExecutionConfigColumnName;
		}
		if(invalidConnection.trim().equalsIgnoreCase("incomplete")) {
			invalidConnection=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, "IncompleteConnection",readColumnName);

		}else if(invalidConnection.trim().equalsIgnoreCase("broken")) {
			invalidConnection=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, keyColumn, "BrokenConnection",readColumnName);
		}
		return invalidConnection;
	}

	public boolean overrideFunctionalityForWorkflow(boolean flag, String scenarioType, List<String> updateruleList,String updateWorkflowJsonEntity,boolean isOverride,String invalidConnection,String bulkOverrideJson) {

		if(scenarioType.trim().equalsIgnoreCase(singleContent)) {

			flag=selectWorkflowRulesFlagForInvalid(flag,updateruleList, updateWorkflowJsonEntity, isOverride,invalidConnection);

		}else if(scenarioType.trim().equalsIgnoreCase(bulkContent)) {

			flag=bulkOverrideFunctionalityForInvalid(flag, bulkOverrideJson, invalidConnection);
		}
		return flag;
	}




	//update workflow using automation database details
	public boolean updateWorkflowInSpecifiedModeForInvalidConnection(DataTestingParameters param,String searchWorkflowName,String folderName,String sequenceShuffle,boolean isOverride, String icedqUser){

		boolean flag = true;
		boolean dnd=true;

		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();

			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();
			String updateWorkflowJsonEntity= param.getWorkflowUpdateJsonValue();
			String invalidConnection=param.getReplace();
			String scenarioType=param.getScenarioType();
			String bulkOverrideJson=param.getOverrideReplace();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (!searchAndClickOnWorkflowNameOnWorkflowListingPage(searchWorkflowName, folderName)) {
				return false;
			}

			boolean isEditorUser = !icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent);

			invalidConnection=getConnectionNameForExcel(invalidConnection);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(updateWorkflowJsonEntity);

			flag=clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			validateWorkflowCreateUpdatedFormat();

			if(!workflowMode.toLowerCase().contains(draftContent) && isEditorUser) {

				removeAddedRulesFromWorkflow(BaseSuite.suiteType.equalsIgnoreCase("Sanity"), workflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(true);

				List<String> updateruleList = getJsonArrayValueUsingJsonPathExpreesion(updateWorkflowJsonEntity, workflowRuleListJsonPath);

				addRulesToWorkflowDetails(flag,updateruleList, updateWorkflowJsonEntity);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=overrideFunctionalityForWorkflow(flag, scenarioType, updateruleList, updateWorkflowJsonEntity, isOverride, invalidConnection, bulkOverrideJson);

				flag=shuffleRulesInWorkflows(flag, sequenceShuffle);
			}

			if(isEditorUser) {

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);
			}else {
				flag = clickOnWorkflowSaveOption(flag,workflowMode, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
				dnd=false;
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag) && workflowMode.toLowerCase().contains(publishContent) && dnd) {

				new WorkflowServicePage(driver).executeWorkflow(flag, searchWorkflowName,downloadZip, exceptionReport, workflowExecutionStatus, icedqUser);

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateWorkflowInSpecifiedModeForInvalidConnection ");

			flag=false;
		}

		return flag;

	}

	//click on workflow save button as per workflow state
	public boolean clickOnWorkflowSaveOptionForInvalid(boolean flag, String saveOption, String expectedToast) {
		boolean tag=true;
		try {
			if(flag) {

				if(saveOption.toLowerCase().trim().equalsIgnoreCase(publishContent)) {

					flag=clickOnButton(driver, workflowDetailsPublishButton, workflowPublish, true);
				}
				else if(saveOption.toLowerCase().trim().equalsIgnoreCase(validateContent)) {

					/**		//	clickOnButton(driver, workflowDetailsPublishDropDown, saveOptionContent, true);**/

					javascript(driver, jscriptToMouseHover, workflowDetailsPublishDropDown);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					verifyVisibilityOfButtons(driver, workflowDetailsValidateButton, workflowValidate, true);

					verifyVisibilityOfButtons(driver, workflowDetailsDraftButton,workflowDraft, true);

					/**				//	flag=clickOnButton(driver, workflowDetailsValidateButton,workflowValidate, true);**/

					javascript(driver, jscriptToClick, workflowDetailsValidateButton);

				}else if(saveOption.toLowerCase().trim().equalsIgnoreCase(draftContent)) {

					/**			//		clickOnButton(driver, workflowDetailsPublishDropDown, saveOptionContent, true);**/

					javascript(driver, jscriptToMouseHover, workflowDetailsPublishDropDown);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					verifyVisibilityOfButtons(driver, workflowDetailsValidateButton, workflowValidate, true);

					verifyVisibilityOfButtons(driver, workflowDetailsDraftButton, workflowDraft, true);

					/**			//		flag=clickOnButton(driver, workflowDetailsDraftButton, workflowDraft, true);**/

					javascript(driver, jscriptToClick, workflowDetailsDraftButton);

				}

				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Workflow Save");
					tag=false;
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(!expectedToast.isEmpty() && tag) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Workflow Save ");
				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowSaveOption ");

			flag=false;
		}

		return flag;

	}

	public void setUserNamePasswordOfConnectionUsingConnectionName(String connectionName, int scenarioType) {
		XLUtils xl = new XLUtils();
		if(scenarioType==0) {
			connectionUsername=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, valueColumn, connectionName, "valid_username");
			connectionPassword=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, valueColumn, connectionName, "valid_password");
		}else {
			connectionUsername=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, valueColumn, connectionName, "invalid_username");
			connectionPassword=xl.readUsingColNameAndCellContains(WORKFLOWEXCELFILEPATH, wkflsheetName, valueColumn, connectionName, "invalid_password");
		}
	}




	public String clickOnEditButton(By locator, String label) {
		String mainWindow=null;
		isDisplayedInLoop(driver, 3, locator);

		if(isDisplayed(driver, locator)) {

			clickOnButton(driver,  locator, label, true);

			mainWindow=getWindowHandle(driver);

		}else {
			BaseSuite.reportFailLog("Edit button not visible", "clickOnEditButton");
		}

		return mainWindow;
	}





	public boolean validateConnectionPage(String connectionName, boolean save, boolean test , int scenarioType) {

		ConnectionRepoCommonPage cp = new ConnectionRepoCommonPage(driver);
		String connName="";
		/**		String connType="";**/
		boolean flag=true;		
		try {
			isDisplayedInLoop(driver, 5, connectionType);

			javascript(driver, scrollToElementArg, connectionType);

			isDisplayedInLoop(driver, 5, connectionType);

			/**		connType=getAttribute(driver, connectionType, attributeValue);**/

			connName=getAttribute(driver, connectionNameTitle, attributeTextContent);

			stringContainsOutput(connName, connectionName, true);

			setUserNamePasswordOfConnectionUsingConnectionName(connectionName, scenarioType);

			if(save) {

				cp.enterUsername(connectionUsername);

				cp.enterPassword(connectionPassword);

				flag=cp.saveConnection();

				if(flag && test ) {

					flag=cp.testConnection(connectionTestMess);

				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateConnectionPage ");
			flag=false;
		}
		return flag;
	}


	public void clickOnEditButtonOfConnection(By locator, String label, String connectionName) {
		String mainWindow=null;

		try {

			if(ConstantProperty.eDITBUTTONFUNCTIONALITYCONNECTION==1) {

				mainWindow=clickOnEditButton(locator, label);

				validateConnectionPage(connectionName, true, true, ConstantProperty.editButtonScenarioType);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				closeCurrentTabAndSwitchToMain(driver, mainWindow);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnEditButtonOfConnection ");

			mainWindow=getWindowHandle(driver);

			closeCurrentTabAndSwitchToMain(driver, mainWindow);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		}

	}

	//update workflow using automation database details
	public boolean updateCustomWorkflowForOverrideEditButtonFunctionality(DataTestingParameters param,String inputData,String overrideType,String icedqUser){

		boolean flag = true;
		String workflowid=null;
		String instanceid=null;
		boolean dnd=true;
		try {
			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String sequenceSelect=param.getSequenceSelect();
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();
			String runType=param.getRunType();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			if(!workflowMode.toLowerCase().contains(draftContent)) {

				clickonWorkflowRulesAndDatasetTab(flag);

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				if(overrideType.trim().equalsIgnoreCase(singleContent)) {

					flag=selectRulesFlagAndOverrideFunctionality(param,inputData,flag, ruleList,workflowJsonEntity);

				}else if(overrideType.trim().equalsIgnoreCase(bulkContent)){

					flag=bulkOverrideFunctionalityCheck(param,inputData,flag);
				}
			}

			if(!icedqUser.toLowerCase().contains(readerContent) && !icedqUser.toLowerCase().contains(executorContent)) {

				flag = clickOnWorkflowSaveOption(flag,workflowMode, "",icedqUser);

			}else {

				clickonWorkflowOverviewAndEnterDetails(flag,workflowParam.getWorkflowName(), workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

				flag = clickOnWorkflowSaveOption(flag,workflowMode, WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);
				dnd=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(flag && !icedqUser.contains(readerFlag) && workflowMode.toLowerCase().contains(publishContent) && dnd) {

				workflowid = getWorkflowIdOnWorkflowDetailsPage();

				String status=executeWorkflowWithRunType(runType, sequenceSelect, icedqUser);

				BaseSuite.reportLog(workflowExecutionLog);
				stringContainsOutput(status, workflowExecutionStatus, true);

				instanceid = validateWorkflowRecentRunInfo();

				flag=searchRecentRunOnRecentRunsField(flag, instanceid);

				if (flag && (!status.toLowerCase().contains(runningStatus))){

					flag=clickOnExecutionDetails();

					downloadExceptionReportInWorkflow(flag, workflowid, instanceid, allContent, zipContent,downloadZip); 

					/**	flag=validateWorkflowExecutionDetailsInRecentRunsRuleDetails(param, inputData, workflowJsonEntity,instanceid, workflowParam.getWorkflowName(),exceptionReport);**/

					flag=validateWorkflowExecutionDetailsInRecentRuns(flag, instanceid, workflowParam.getWorkflowName(), exceptionReport);

					clickOnRefreshButtonOnRecentRuns(1);

				}else {
					BaseSuite.reportFailLog(workflowLongRunMessage , "updateCustomWorkflowForOverride");
					flag=false;

					clickOnExecutionDetails();

					clickOnExpandArrowToWorkflowInstanceId(flag, instanceid);

					getRuleExecutionInstaceIdListFromWorkflow(true, instanceid);

					getWorkflowInstanceTable();

					getAllRuleInstanceTable(instanceid);
				}
			}


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateCustomWorkflowForOverride ");

			flag=false;
		}

		return flag;

	}

	// set workflow parameters using excel
	public static DataTestingParameters setWorkflowParametersUsingTestCaseId(String fileName, String sheetName, String testCaseId) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		String testCaseColumnName="testcaseid";

		try {

			param.setWorkflowName(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,columnWorkflowName));
			param.setWorkflowJsonValue(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"workflow_json"));
			param.setWorkflowUpdateJsonValue(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,keyWorkflowUpdateJson));
			param.setWorkflowSubscriptionJsonValue(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"workflow_notification_json"));
			param.setWorkflowOverrideJsonValue(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"override_json"));
			param.setWorkflowExecutionStatus(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"execution_status"));
			param.setWorkflowExecutionExitCode(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"execution_exitcode"));
			param.setWorkflowSaveMode(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"save_mode"));
			param.setWorkflowDownloadZip(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"download_zip"));
			param.setWorkflowExceptionReportCheck(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId,"exception_report_check"));

			param.setRuleJsonValue(xl.readUsingColNameAndCellContains(fileName, sheetName, testCaseColumnName, testCaseId, keyRuleInfo));

			return param;

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, " setWorkflowParametersUsingTestCaseId "+e.toString());
		}
		return param;

	}


	/** ---------------------------------------------------------------------    Data testing --------------------------------------------------------------------------**/

	//Enter details to add new workflow pane
	public boolean enterDetailsToAddNewRulePane(boolean flag,String folderName, String ruleName, String enginetype, String ruleType) {
		try {

			if(flag) {

				/**	validateAddNewWorkflowSideBar();**/

				javascript(driver, jscriptToClick, pathSelect);

				BaseSuite.validationReportLog(" Folder field clicked successfully ");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(folderName.contains("/")) {
					selectFolderOnAddNewWorkflowPane(folderName);
				}else {
					createOrSelectExistingFolder(flag, folderName);
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				String rulenamecapture =getAttribute(driver, nameRule, attributeValue);

				BaseSuite.reportLog("Default "+rulenamecapture + " Rule Name is visible ");

				flag = enterValueToTextField(driver, nameRule, "Rule Name", ruleName);

				if(flag) {

					BaseSuite.reportLog("Click on Engine Type option");

					isNotDisplayed(driver, datasetSpinner, Constant.ruleWait);

					displayAndClick(driver, engineType);

					javascript(driver, jscriptToClick, engineType);

					BaseSuite.validationReportLog("Engine Type option Clicked successfully");

					BaseSuite.reportLog("Engine Type option clicked");

					javascript(driver, jscriptToClick,
							returnElement(engineTypeSelectOption, dynamicName, enginetype));

					BaseSuite.validationReportLog("Engine Type option clearly visible");

					BaseSuite.reportLog("Choosed Template");

					javascript(driver, scrollToElementArg,
							returnElement(chooseTemplate, dynamicName, ruleType.toLowerCase()));

					displayAndClick(driver, returnElement(chooseTemplate, dynamicName, ruleType.toLowerCase()));

					isNotDisplayed(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog(ruleType + " Template Selected successfully");
				}
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" enterDetailsToAddNewWorkflowPane ");
			flag=false;

		}
		return flag;
	}



	/**-------------------- Default workflow code -------------------- **/

	//validate added rules in workflow
	public boolean validateAddedRuleInDefalutWorkflowForDuplicate(boolean flag, List<String> ruleList,String ruleName,String ruleFolderName, String workflowJsonEntity) {

		try {
			if(flag) {

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				for(int i=0;i<ruleList.size();i++) {

					/**			DataTestingParameters rulesParam = getDataTestingInfoFromDataBase("",ruleList.get(i)); **/

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("--------  Validate added rule : "+ruleName+" in workflow  ");

					flag=searchRuleOnRulesAndDatasetTab(ruleName);

					if(flag && elementNotVisible(driver, workflowDetailsRulesNoRecordFound)) {

						checkExpectedValueWithActualValue(flag, defaultWorkflowRuleSeq, "Sequence", Integer.toString(i+1));

						checkExpectedValueWithActualValue(flag, defaultWorkflowRuleName, "Name", ruleName);

						checkFlagStatus(flag,ruleName, workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess());

						checkFlagStatus(flag,ruleName, workflowDetailsRuleFailureFlag,failureContent, ruleParam.getOnFailure());

						checkFlagStatus(flag,ruleName, workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError());

						checkConnectionAndParameterOnAddedRulesForDefault(flag, ruleParam,ruleName);

						checkRuleFlagStatus(flag,ruleName, workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode());

						checkRuleFlagStatus(flag,ruleName, workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive());

						checkExpectedValueWithActualValue(flag, defaultWorkflowRuleFolder, folderContent, ruleFolderName);

					}

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

				javascript(driver, scrollToElementArg, rulesDatasetsSearchBar);

				displayAndClick(driver, rulesDatasetsSearchBar);

				clear_Click_SendKeys(driver, 0, rulesDatasetsSearchBar, "");

				displayAndClick(driver, rulesDatasetsSearchButton);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAddedRuleInDefalutWorkflow ");

			flag=false;
		}
		return flag;
	}

	public void checkConnectionAndParameterOnAddedRulesForDefault(Boolean flag, DataTestingParameters ruleParam, String ruleName) {

		if(ruleName.isEmpty()) {
			ruleName=ruleParam.getRuleName();
		}

		isDisplayedInLoop(driver, 5,returnElement(workflowDetailsAddedRuleType, dynamicName, ruleName));

		javascript(driver, scrollToElementArg, returnElement(workflowDetailsAddedRuleType, dynamicName, ruleName));

		String ruleType=getAttribute(driver, returnElement(workflowDetailsAddedRuleType, dynamicName, ruleName), attributeTitle);

		if(!ruleType.equalsIgnoreCase(scriptContent)) {

			viewAndValidateField(defaultWorkflowRuleSourceConn, sourceConnectionField, ruleParam.getRuleSourceConnectionName(), true);

			if(ruleType.equalsIgnoreCase(reconContent) || ruleType.equalsIgnoreCase(checksumContent)) {

				checkExpectedValueWithActual(driver,flag,defaultWorkflowRuleTargetConn,targetConnectionField, ruleParam.getRuleTargetConnectionName(),true);
			}else {
				checkExpectedValueWithActual(driver,flag, defaultWorkflowRuleTargetConn,targetConnectionField, "",true);
			}

			checkExpectedValueWithActual(driver,flag, defaultWorkflowRuleParameter,parameterField, ruleParam.getRuleParameterName(),true);
		}else {

			viewAndValidateField(defaultWorkflowRuleSourceConn, sourceConnectionField, "", true);

			checkExpectedValueWithActual(driver,flag, defaultWorkflowRuleTargetConn,targetConnectionField, "",true);

			checkExpectedValueWithActual(driver,flag, defaultWorkflowRuleParameter,parameterField, "",true);
		}
	}
	//view default workflow and validate fields
	public boolean viewDefaultWorkflow(String workflowJsonEntity,String workflowName, String ruleName, String ruleFolderName,String icedqUser) {

		boolean flag =true;

		try {

			BaseSuite.reportLog("verifying for user "+icedqUser);

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbHomeLink, homeContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbDataTestingLink, dataTestingContent, flag);

			flag=verifyVisibilityOfButtons(driver, workflowBreadcrumbWorkflowsLink, workflowContent, flag);
			/**
					verifyIndividualLabel(driver, returnElement(workflowBreadcrumbFolderName, dynamicName, workflowParam.getWorkflowfolderName()), workflowParam.getWorkflowfolderName()+"folder name bread-crumb");
			 **/
			verifyIndividualLabel(driver, returnElement(workflowNameTitle, dynamicName, workflowName), workflowName);

			verifyVisibilityOfButtons(driver, workflowDetailsOverviewTab, overviewContent, true);

			verifyVisibilityOfButtons(driver, workflowDetailsRuleAndDatasetsTab, rulesContent, true);

			clickOnButton(driver, workflowDetailsOverviewTab, overviewContent, true);

			viewAndValidateField(workflowDetailsWorkflowNameField, fieldWorkflowName, workflowName, false);

			viewAndValidateField(workflowDetailsWorkflowCodeField, workflowCodeContent, workflowParam.getWorkflowCode(), false);

			viewAndValidateField(workflowDetailsDescriptionField, workflowDescriptionContent, workflowParam.getWorkflowDescription(), false);

			isDisplayedInLoop(driver, 3, workflowDetailsCurrentStatus);

			String acStatus = getAttribute(driver, workflowDetailsCurrentStatus, attributeTitle);

			BaseSuite.reportLog("Default Workflow state is "+acStatus);

			validateButtonsForDefaultWorkflowDetailsOnRevisit(acStatus,Boolean.parseBoolean(workflowParam.getIsActive()));

			validateMoreOptionButtons(workflowParam.getWorkflowType(), Boolean.parseBoolean(workflowParam.getIsActive()),icedqUser);

			if(!acStatus.toLowerCase().contains(draftContent)) {

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				validateDefaultWorkflowRuleFields();

				List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

				flag=validateAddedRuleInDefalutWorkflowForDuplicate(flag, ruleList,ruleName, ruleFolderName,workflowJsonEntity);

			}

			searchRecentRunOnRecentRunsField(true, "");

			verifyVisibilityOfButtons(driver, workflowDetailsRecentRunRefreshButton, refreshContent, true);

			validateColumnsListForWorkflowService(workflowDetailsRecentRunsTabColumns, workflowDetailsRecentRunsTabColumnLocator, "Recent Runs tab on workflow details page ");

			getPaginationDetails(driver, workflowDetailsRecentRunsPaginationMsg, workflowDetailsRecentRunsPagearrow, workflowDetailsPageRecentRunsNoRecordDisplay,recentRunsContent);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" viewDefaultWorkflow ");
			flag=false;
		}
		return flag;
	}

	//click on name on listing page
	public boolean clickOnNameOnListingPage(String name, String folderName, String label) {
		boolean flag=true;
		By locator=null;
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(folderName.contains("/")) {
				locator=returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, name, dynamicFolderName,folderName);
			}else {
				locator=returnTwoElements(workflowNamelink, dynamicName, name, dynamicFolderName,folderName);
			}

			isDisplayedInLoop(driver, 3, locator);

			if(isDisplayed(driver, locator)) {

				clickOnButton(driver, locator, name, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				checkUnexpectedToast();
			}else {
				BaseSuite.reportFailLog(label+" name not visible name:"+name+" folder :"+folderName, "clickOnNameOnListingPage");
				flag=false;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnNameOnListingPage ");
			flag=false;

		}
		return flag;
	}

	public boolean dataTestingRulesMoreOption(String value, String expectedToast)
	{
		boolean flag=true;
		try {
			BaseSuite.reportLog("Clicking on more option button");

			javascript(driver, "arguments[0].click();", dataTestingmoreOptionButton);
			javascript(driver, jscriptToMouseHover, dataTestingmoreOptionButton);

			if (isDisplayed(driver, dataTestingmoreOptionDropDownButton)) {

				BaseSuite.validationReportLog("more option drop down list is visible");

				javascript(driver, jscriptToMouseHover, dataTestingmoreOptionButton);

				BaseSuite.reportLog("Clicking on button "+value);

				displayAndClick(driver, returnElement(dataTestingmoreValueOption, "$name", value));

				javascript(driver, jscriptToClick, returnElement(dataTestingmoreValueOption, "$name", value));

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Clicked on button "+value);

				if(!expectedToast.isEmpty()) {
					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Rule " + value);
				}

			} else {
				BaseSuite.reportFailLog("Drop down list is not open after click on More button", "dataTestingRulesMoreOption");
				flag=false;
			}

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" dataTestingRulesMoreOption ");
			flag=false;
		}
		return flag;
	}


	public int checkFailCount(boolean flag, int failCount) {

		if(!flag) {
			failCount++;
		}
		return  failCount;
	}



	public boolean duplicateRuleOnCheckDefaultWorkflow(String workflowJsonEntity, String icedqUser, int rowNumber) {
		boolean flag = true;
		DataTestingPage dp = new DataTestingPage(driver);
		XLUtils xl = new XLUtils();
		int failCount=0;
		String iceWorkflowExcelFile = dirPath+ Constant.NEXTGEN_WORKFLOW_TESTDATA_EXCEL_PATH;
		try {

			DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(0, workflowJsonEntity);

			String ruleName = ruleParam.getRuleName();
			String ruleFolderName=ruleParam.getRuleFolderName();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			dp.clickOnRulesTab();

			flag=searchFunctionalityMethod(driver, flag, dataTestingSearchBox, dataTestingSearchButton, searchRuleLabel, searchRuleLabel, ruleName);

			if(flag) {

				flag=clickOnNameOnListingPage(ruleName, ruleFolderName, "Rule");

				checkFailCount(flag, failCount);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

					dataTestingRulesMoreOption(duplicateContent,ruleDuplicateMess);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					ruleName=getvaluefromField(dataTestingRuleNameField, "Rule Name", attributeValue);

					flag=clickOnWorkflowsTabNew();
					checkFailCount(flag, failCount);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					new WorkflowServicePage(driver).validateNSelectTypeInAdvanceSearch(defaultContent, true);

					checkFailCount(flag, failCount);

					String defaultWorkflowName="Workflow-"+ruleName;
					xl.writeToExcel(ruleName, iceWorkflowExcelFile, "duplicateData", rowNumber,icedqUser);
					/**			xl.writeToExcel(defaultWorkflowName, iceWorkflowExcelFile, "duplicateData", 2,icedqUser);**/

					flag=searchAndClickOnWorkflowNameOnWorkflowListingPage(defaultWorkflowName,ruleFolderName);
					checkFailCount(flag, failCount);

					flag=viewDefaultWorkflow(workflowJsonEntity,defaultWorkflowName,ruleName,ruleFolderName, icedqUser);
					checkFailCount(flag, failCount);

					flag=runWorkflow(workflowJsonEntity, false, false, icedqUser, defaultContent);
					checkFailCount(flag, failCount);

				}else if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent)){

					flag=dataTestingRulesMoreOption(duplicateContent,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
			}


		} catch (Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" duplicateRuleOnCheckDefaultWorkflow ");

			flag=false;
		}

		return flag;

	}


	public boolean activateAndDeactivateCheckForDefaultWorkflow(String workflowJsonEntity, String scenario,String icedqUser) {
		boolean flag = true;
		DataTestingPage dp = new DataTestingPage(driver);

		int failCount=0;

		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);
			DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(0, workflowJsonEntity);

			String ruleName = ruleParam.getRuleName();
			String ruleFolderName=ruleParam.getRuleFolderName();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			dp.clickOnRulesTab();

			flag=searchFunctionalityMethod(driver, flag, dataTestingSearchBox, dataTestingSearchButton, searchRuleLabel, searchRuleLabel, ruleName);

			if(flag) {

				flag=clickOnNameOnListingPage(ruleName, ruleFolderName, "Rule");

				checkFailCount(flag, failCount);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

					dataTestingRulesMoreOption(scenario,"");

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickOnWorkflowsTabNew();
					checkFailCount(flag, failCount);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					new WorkflowServicePage(driver).validateNSelectTypeInAdvanceSearch(defaultContent, true);

					checkFailCount(flag, failCount);

					flag=searchAndClickOnWorkflowNameOnWorkflowListingPage(workflowParam.getWorkflowName(),ruleFolderName);
					checkFailCount(flag, failCount);

					if(scenario.trim().equalsIgnoreCase("activate")) {

						flag=viewDefaultWorkflow(workflowJsonEntity,true, icedqUser);
					}else {
						flag=viewDefaultWorkflow(workflowJsonEntity,false, icedqUser);
					}
					checkFailCount(flag, failCount);

				}else if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent)){

					flag=dataTestingRulesMoreOption(scenario,WORKFLOWPRIVILEGEFORBIDDENMESSAGE);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
			}

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" activateAndDeactivateCheckForDefaultWorkflow ");

			flag=false;
		}

		return flag;

	}


	public boolean deleteRuleAndVerifyDefaultWorkflow(String workflowJsonEntity, String folderName,String icedqUser) {
		boolean flag = true;
		DataTestingPage dp = new DataTestingPage(driver);

		int failCount=0;

		try {
			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);
			DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(0, workflowJsonEntity);

			String ruleName = ruleParam.getRuleName();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			dp.clickOnRulesTab();

			searchFunctionalityMethod(driver, flag, dataTestingSearchBox, dataTestingSearchButton, searchRuleLabel, searchRuleLabel, ruleName);

			flag=clickOnNameOnListingPage(ruleName, folderName, "Rule");

			if(flag) {

				checkFailCount(flag, failCount);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

					deleteRuleFromDataTestingRuleDetails(deleteToastMsg,icedqUser);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=clickOnWorkflowsTabNew();
					checkFailCount(flag, failCount);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					new WorkflowServicePage(driver).validateNSelectTypeInAdvanceSearch(defaultContent, true);

					checkFailCount(flag, failCount);

					flag=searchFunctionalityMethod(driver, flag, workflowSearchField, workflowSearchButton, placeholderSearchWorkflow, placeholderSearchWorkflow, workflowParam.getWorkflowName());

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					getPaginationDetails(driver,workflowListingPageMsg,workflowListingPagearrow,workflowListingPageNoRecordDisplay,workflowContent+listingContent);

					isDisplayedInLoop(driver, 3, returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, workflowParam.getWorkflowName(), dynamicFolderName,folderName));

					if(!isDisplayed(driver,returnTwoElements(workflowNameLinkUsingFolderPath, dynamicName, workflowParam.getWorkflowName(), dynamicFolderName,folderName))) {

						BaseSuite.validationReportLog("Workflow name not visible ");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					}else {
						BaseSuite.reportFailLog("Workflow name visible name:"+workflowParam.getWorkflowName()+" folder :"+folderName, "deleteRuleAndVerifyDefaultWorkflow");
						flag=false;
					}

				}else if(icedqUser.contains(executorContent) || icedqUser.contains(readerContent)){

					flag=deleteRuleFromDataTestingRuleDetails(WORKFLOWPRIVILEGEFORBIDDENMESSAGE,icedqUser);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}
			}

		}catch(Exception e) {

			BaseSuite.reportErrorLog(e,errorLogTitle+" activateAndDeactivateCheckForDefaultWorkflow ");

			flag=false;
		}

		return flag;

	}

	public boolean deleteRuleFromDataTestingRuleDetails(String expectedToast, String icedqUser ) {
		boolean flag = true;
		DataTestingPage dp = new DataTestingPage(driver);

		try {

			dp.clickOnDeleteButton();

			if(icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent)) {

				verifyIndividualLabel(driver, deleteHeader, deleteRuleTitle);
				String acDeleleMsg = getAttribute(driver, deleteText, attributeTextContent);
				stringContainsOutput(acDeleleMsg, deleteRuleContent, true);

				verifyVisibilityOfButtons(driver, deleteDelBtn, deleteContent, true);
				verifyVisibilityOfButtons(driver, deleteCancelBtn, cancelContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnButton(driver, deleteDelBtn, deleteContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			if(!expectedToast.isEmpty()) {
				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Rule delete");
			}

		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" deleteRules ");
		}

		return flag;
	}

	/**------------------------------ API Methods -----------------**/

	public static String getOAuthBearerTokenBasedOnIcedqRole(String appURL,String orgid,String userName, String passWord) {

		String content = "grant_type=password&username=" + userName + "&password=" + passWord;

		BufferedReader reader = null;

		HttpURLConnection connection = null;

		String returnValue = "";

		try {

			if(appURL.contains(httpsProtocalContent)) {
				appURL=appURL.replace(httpsProtocalContent, "http");
			}
			if(orgid.contains("org-")) {
				orgid=orgid.replace("org-", "");
			}

			URL url = new URL(appURL+"auth/realms/"+orgid+"/protocol/openid-connect/token");

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");

			connection.setDoOutput(true);

			connection.setRequestProperty(authorization, apibasic + AUTHENTICATION);

			connection.setRequestProperty(apicontentType, "application/x-www-form-urlencoded");

			connection.setRequestProperty("Accept", applicationJSonContentType);

			try (PrintStream os = new PrintStream(connection.getOutputStream());){

				os.print(content);

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String line = null;

				StringWriter out = new StringWriter(
						connection.getContentLength() > 0 ? connection.getContentLength() : 2048);

				while ((line = reader.readLine()) != null) {

					out.append(line);
				}
				String response = out.toString();

				Matcher matcher = pat.matcher(response);

				if (matcher.matches() && matcher.groupCount() > 0) {

					returnValue = matcher.group(1);
				}
			}

		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (reader != null) {

				try {

					reader.close();

					connection.disconnect();

				} catch (IOException e) {
					e.getMessage();
				}
			}


		}

		return returnValue;
	}

	// get workflow info from workflow id and workspace id
	public static String getEntityInfoUsingID(String workspaceid, String urlPath, String getid) {
		String jsonEntity = null;
		try {

			if(ConstantProperty.apiReadURL.contains(httpsProtocalContent)) {
				ConstantProperty.apiReadURL=ConstantProperty.apiReadURL.replace(httpsProtocalContent, "http");
			}

			String auto = getOAuthBearerTokenBasedOnIcedqRole(ConstantProperty.apiReadURL, ConstantProperty.apiReadOrgID, ConstantProperty.API_READ_USERNAME, ConstantProperty.API_READ_PASSWORD);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(ConstantProperty.apiReadURL + urlPath+"/" + getid);

			getRequest.setHeader(apicontentType, applicationJSonContentType);

			getRequest.setHeader(apiworkspaceId, workspaceid);

			getRequest.setHeader(apiorgId, ConstantProperty.apiReadOrgID);

			getRequest.setHeader(authorization, apiBearer + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response---------------- " + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues ----------- " + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);


		} catch (Exception e) {

			e.getMessage();
		}
		return jsonEntity;
	}


	public static  List<String> getJsonArrayValueUsingJsonPathExpreesion(String jsonEntity, String expression) {
		List<String> list = new ArrayList<>();

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				String value1 = o.toString().replace("\"", "");

				list.add(value1);

			}

		} catch (Exception e) {

			e.getMessage();
		}

		return list;

	}

	public static String getJsonValueUsingJsonPathExpreesion(String jsonEntity, String expression) {
		String value = null;

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			log.info(jsonContent);

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				value = o.toString().replace("\"", "");
			}

		} catch (Exception e) {

			e.getMessage();
		}

		return value;

	}


	public static String getJsonValueFromAPI(String workspaceid, String urlPath, String getid, String jsonPath) {

		String jsonValue="";

		if(getid!=null) {

			String jsonEntity = getEntityInfoUsingID(workspaceid, urlPath, getid);

			jsonValue= getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonPath);
		}

		return jsonValue;
	}


	public static String addKeyPairValueInJson(String jsonEntity, String objectName,int index, String newKey, String newValue) {

		if(!newKey.isEmpty()) {
			// Parse JSON string to JsonObject
			Gson gson = new Gson();
			JsonObject jsonObject = JsonParser.parseString(jsonEntity).getAsJsonObject();

			// Retrieve the "activities" array
			JsonObject firstActivity = jsonObject.getAsJsonArray(objectName).get(index).getAsJsonObject();

			// Add the new key-value pair to the first activity
			if(newKey.contains(",")) {
				String[] newKeys= newKey.split(",");
				String[] newValues= newValue.split(",");

				for (int j = 0; j < newKeys.length; j++) {
					firstActivity.addProperty(newKeys[j], newValues[j]);
				}
			}else {
				firstActivity.addProperty(newKey, newValue);
			}

			// Convert JsonObject back to JSON string
			jsonEntity = gson.toJson(jsonObject);
			log.info("addKeyPairValueInJson, Responce--- "+jsonEntity);
		}
		return jsonEntity;
	}

	public static String addKeyPairValueInJson(String jsonEntity, String newKey, String newValue) {

		if(!newKey.isEmpty()) {
			// Parse the JSON response into a JSONObject
			JSONObject jsonObject = new JSONObject(jsonEntity);

			// Add a new key-value pair
			jsonObject.put(newKey, newValue);

			// Convert the JSONObject back to a JSON string
			String updatedJsonResponse = jsonObject.toString();

			jsonEntity = updatedJsonResponse;

			log.info("addKeyPairValueInJson, Responce--- "+jsonEntity);
		}
		return jsonEntity;
	}

	// get list of custom workflow id from workspace

	public static List<String> getListRestAssuredPostRequest(String token, String workspaceId,String requestURL, String folderId, String jsonPath) {
		try {

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse(contentType);

			// Prepare JSON body
			JSONObject filterObj = new JSONObject();
			filterObj.put("attribute", "folderId");
			filterObj.put("operator", "In");
			filterObj.put("datatype", "string");
			filterObj.put("value", folderId);

			JSONArray filterArray = new JSONArray();
			filterArray.put(filterObj);

			JSONObject requestBodyJson = new JSONObject();
			requestBodyJson.put("filter", filterArray);

			RequestBody body = RequestBody.create(mediaType, requestBodyJson.toString());

			Request request = new Request.Builder()

					.url(requestURL).method("POST", body)

					.addHeader(contentTypeText, contentType)

					.addHeader(apiworkspaceId, workspaceId)

					.addHeader(apiorgId, ConstantProperty.apiReadOrgID)

					.addHeader(authetication, apiBearer + token)

					.build();

			Response response = client.newCall(request).execute();

			String r = response.body().string();

			return getJsonArrayValueUsingJsonPathExpreesion(r, jsonPath);

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	public static List<String> getWorkflowIdsFromFolder(String workspaceId, String folderId){

		if(ConstantProperty.apiReadURL.contains(httpsProtocalContent)) {
			ConstantProperty.apiReadURL=ConstantProperty.apiReadURL.replace(httpsProtocalContent, "http");
		}

		String auto = getOAuthBearerTokenBasedOnIcedqRole(ConstantProperty.apiReadURL, ConstantProperty.apiReadOrgID, ConstantProperty.API_READ_USERNAME, ConstantProperty.API_READ_PASSWORD);

		return getListRestAssuredPostRequest(auto, workspaceId, ConstantProperty.apiReadURL+workflowApiPath+"/search",	folderId, "$.items..id");

	}

	static String workflowApiPath="api/v1/workflows";
	static String folderApiPath="api/v1/folders";
	static String ruleApiPath="api/v1/rules";
	static String parameterApiPath="api/v1/parameters";
	static String connectionApiPath="api/v1/connections";

	static String workflowSearchUsingFolderId=prop.getProperty("workflow.search.using.folderid");

	public static String getWorkflowInfo(String workspaceId, String workflowId) {

		String jsonPathName= "$.name";
		String jsonPathActivities="activities";
		String workflowJson=null;

		try {
			workflowJson= getEntityInfoUsingID(workspaceId, workflowApiPath, workflowId);

			String wkflfolderId = getJsonValueUsingJsonPathExpreesion(workflowJson, "$.folderId");

			String wkflfolderName = getJsonValueFromAPI(workspaceId, folderApiPath, wkflfolderId, jsonPathName);

			workflowJson=addKeyPairValueInJson(workflowJson,keyfolderName, wkflfolderName);

			List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJson, "$.activities..objectId");

			for(int i=0;i<ruleList.size();i++) {

				String ruleJson = getEntityInfoUsingID(workspaceId, ruleApiPath, ruleList.get(i));

				String rulefolderId = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.folderId");

				String ruleParameterId = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.properties.parameterId");

				String ruleSourceConnection = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.objects[0].connectionId");

				String ruleTargetConnection = getJsonValueUsingJsonPathExpreesion(ruleJson, "$.objects[1].connectionId");

				String folderName = getJsonValueFromAPI(workspaceId, folderApiPath, rulefolderId, jsonPathName);

				String parameterName = getJsonValueFromAPI(workspaceId, parameterApiPath, ruleParameterId, jsonPathName);

				String soureConn = getJsonValueFromAPI(workspaceId, connectionApiPath, ruleSourceConnection, jsonPathName);

				String targetConn = getJsonValueFromAPI(workspaceId, connectionApiPath, ruleTargetConnection, jsonPathName);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, keyfolderName, folderName);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "parameterName", parameterName);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "sourceConnection", soureConn);

				workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,i, "targetConnection", targetConn);

				workflowJson=getOverrideConnectionAndParameterInfo(workspaceId, workflowJson, i);

			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return workflowJson;
	}

	public static String getOverrideConnectionAndParameterInfo(String workspaceId, String workflowJson, int index) {
		String jsonPathActivities="activities";

		try {
			List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJson, jsonPathActivity+index+jsonPathOverrideSubtypes);

			for(int i=0;i<override.size();i++) {

				String subtype = getJsonValueUsingJsonPathExpreesion(workflowJson, jsonPathActivity+index+jsonPathOverride+i+jsonPathSubtype);

				subtype=checkNullValue(subtype);

				if(!subtype.isEmpty()) {

					switch(subtype.trim()+"api") {

					case "sourceapi":

						String sid = getJsonValueUsingJsonPathExpreesion(workflowJson, jsonPathActivity+index+jsonPathOverride+i+jsonPathReplace);

						String sname = getJsonValueFromAPI(workspaceId, connectionApiPath, sid, jsonPathName);

						workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,index, "sourceOverride", sname);

						break;

					case "targetapi":

						String tid = getJsonValueUsingJsonPathExpreesion(workflowJson, jsonPathActivity+index+jsonPathOverride+i+jsonPathReplace);

						String tname = getJsonValueFromAPI(workspaceId, connectionApiPath, tid, jsonPathName);

						workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,index, "targetOverride", tname);

						break;

					case "ruleapi":

						String pid = getJsonValueUsingJsonPathExpreesion(workflowJson, jsonPathActivity+index+jsonPathOverride+i+jsonPathReplace);

						String pname = getJsonValueFromAPI(workspaceId, parameterApiPath, pid, jsonPathName);

						workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,index, "parameterOverride", pname);

						String pjson = getEntityInfoUsingID(workspaceId, parameterApiPath, pid);

						String pfid = getJsonValueUsingJsonPathExpreesion(pjson, jsonPathFolderId);

						String fpname = getJsonValueFromAPI(workspaceId, folderApiPath, pfid, "$.path");

						workflowJson=addKeyPairValueInJson(workflowJson,jsonPathActivities,index, "parameterOverrideFolderPath", fpname);

						break;

					default:

						BaseSuite.reportErrorLog("error occurs while getOverrideConnectionAndParameterInfo kindly check ");

						break;

					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}


		return workflowJson;
	}


	//select workflow rules flag
	public boolean selectWorkflowRulesFlagForAPI(boolean flag, List<String> ruleList, String workflowJsonEntity) {
		ruleSequenceUseFlagList=null;
		rulesConfigurationtable=null;
		try {
			if(!ruleList.isEmpty() && flag) {

				for(int i=0;i<ruleList.size();i++) {

					DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(i, workflowJsonEntity);

					BaseSuite.reportLog("----------------------- validating added rule : "+ruleParam.getRuleName()+" and configuring features of workflow ------------------------");

					flag=searchRuleOnRulesAndDatasetTab(ruleParam.getRuleName());

					if(i<(ruleList.size()-1)){
						flag=selectRuleFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleSuccessFlag, ruleParam.getRuleFolderName(), successContent, ruleParam.getOnSuccess(), workflowToastSFEUncheck);

						flag=selectRuleFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleFailureFlag, ruleParam.getRuleFolderName(), failureContent, ruleParam.getOnFailure(), workflowToastSFEUncheck);

						flag=selectRuleFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleErrorFlag, ruleParam.getRuleFolderName(), errorContent, ruleParam.getOnError(), workflowToastSFEUncheck);	
					}else {
						flag=selectRuleFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleSuccessFlag, ruleParam.getRuleFolderName(), successContent, ruleParam.getOnSuccess(), workflowToastSFELastSequence);

						flag=selectRuleFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleFailureFlag, ruleParam.getRuleFolderName(), failureContent, ruleParam.getOnFailure(), workflowToastSFELastSequence);

						flag=selectRuleFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleErrorFlag, ruleParam.getRuleFolderName(), errorContent, ruleParam.getOnError(), workflowToastSFELastSequence);	
					}

					checkConnectionAndParameterOnAddedRulesForAPI(flag, ruleParam);

					flag=validateAndSingleOverrideFunctionalityForAPI(flag, workflowJsonEntity, ruleList,ruleParam.getRuleFolderName(), i);

					if(i<(ruleList.size()-1)){

						flag=selectRuleUseAndActiveFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleUseFlag, ruleParam.getRuleFolderName(), useContent, ruleParam.getUseExitCode(),"");

						flag=selectRuleUseAndActiveFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleActiveFlag, ruleParam.getRuleFolderName(), activeContent, ruleParam.getIsRuleActive(),"");

					}else {

						flag=selectRuleUseAndActiveFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleUseFlag, ruleParam.getRuleFolderName(), useContent, ruleParam.getUseExitCode(),workflowToastUseColumnEnabled);

						flag=selectRuleUseAndActiveFlagsForAPI(flag,ruleList.get(i), newworkflowDetailsRuleActiveFlag, ruleParam.getRuleFolderName(), activeContent, ruleParam.getIsRuleActive(),workflowToastActiveColumnEnabled);

					}
					validateFolderNameOnRuleDatasetTab(ruleParam.getRuleName(), ruleParam.getRuleFolderName());


				}

				displayAndClick(driver, rulesDatasetsSearchBar);

				clear_Click_SendKeys(driver, 0, rulesDatasetsSearchBar, "");

				displayAndClick(driver, rulesDatasetsSearchButton);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();

				rulesConfigurationtable=getRulesTable(ruleList);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectWorkflowRulesFlagForAPI ");

			flag=false;
		}

		return flag;
	}

	//select rule flag state 
	public boolean selectRuleFlagsForAPI(boolean flag,String ruleName, String flagLocator,String ruleFolder, String flagLabel, String flagState,String expectedToast) {

		String methodName = "selectRuleFlagsForAPI";
		try {
			if(flag) {
				BaseSuite.reportLog(checkingContent+flagLabel+flagContent);

				By locator = returnTwoElements(flagLocator, dynamicName, ruleName, dynamicFolderName, ruleFolder);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.validationReportLog(flagLabel+" flag  is visible");

					String acFlagState = getAttribute(driver, locator, attributeClass);

					checkCheckboxOfField(locator, flagLabel, acFlagState, flagState);

				}else {

					BaseSuite.reportFailLog(flagLabel+" "+notVisibleContent+"  ", methodName);
					flag=false;
				}
				isDisplayedInLoop(driver, 0, toastMsg);
				if(isDisplayed(driver, toastMsg)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "SFE Unchecked");

				}
			}
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectRuleFlagsForAPI ");

			flag=false;
		}

		return flag;
	}

	//select rule use and active flag state 
	public boolean selectRuleUseAndActiveFlagsForAPI(boolean flag, String ruleName, String flagLocator,String ruleFolder, String flagLabel, String flagState, String expectedToast) {

		String methodName = "selectRuleUseAndActiveFlagsForAPI";
		try {
			if(flag) {
				BaseSuite.reportLog(checkingContent+flagLabel+" flag  ");

				By locator = returnTwoElements(flagLocator, dynamicName, ruleName, dynamicFolderName, ruleFolder);

				isDisplayedInLoop(driver, 3, locator);

				if(isDisplayed(driver, locator)) {

					BaseSuite.validationReportLog(flagLabel+" flag  is visible");

					String acFlagState = getAttribute(driver, locator, attributeClass);

					checkCheckboxOfFlag(locator, flagLabel, acFlagState, flagState);

				}else {

					BaseSuite.reportFailLog(flagLabel+" "+notVisibleContent, methodName);
					flag=false;
				}
				if(isDisplayed(driver, toastMsg) && flagState.equalsIgnoreCase(falseContent)) {

					flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, flagLabel+" Unchecked");

				}
			}
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectRuleUseAndActiveFlagsForAPI ");

			flag=false;
		}

		return flag;

	}

	public void checkConnectionAndParameterOnAddedRulesForAPI(Boolean flag, DataTestingParameters ruleParam) {

		try {
			isDisplayedInLoop(driver, 5,returnTwoElements(newworkflowDetailsAddedRuleType, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()));

			javascript(driver, scrollToElementArg, returnTwoElements(newworkflowDetailsAddedRuleType, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()));

			String ruleType=getAttribute(driver, returnTwoElements(newworkflowDetailsAddedRuleType, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()), attributeTitle);

			if(!ruleType.equalsIgnoreCase(scriptContent)) {

				viewAndValidateField(returnTwoElements(newworklfowAddedRuleSourceConnLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()), sourceConnectionField, ruleParam.getRuleSourceConnectionName(), true);

				if(ruleType.equalsIgnoreCase(reconContent) || ruleType.equalsIgnoreCase(checksumContent)) {

					checkExpectedValueWithActual(driver,flag, returnTwoElements(newworklfowAddedRuleTargetConnLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()),targetConnectionField, ruleParam.getRuleTargetConnectionName(),true);
				}else {
					checkExpectedValueWithActual(driver,flag, returnTwoElements(newworklfowAddedRuleTargetConnLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()),targetConnectionField, "",true);
				}

				checkExpectedValueWithActual(driver,flag, returnTwoElements(newworklfowAddedRuleParameterLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()),parameterField, ruleParam.getRuleParameterName(),true);
			}else {

				viewAndValidateField(returnTwoElements(newworklfowAddedRuleSourceConnLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()), sourceConnectionField, "", true);

				checkExpectedValueWithActual(driver,flag, returnTwoElements(newworklfowAddedRuleTargetConnLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()),targetConnectionField, "",true);

				checkExpectedValueWithActual(driver,flag, returnTwoElements(newworklfowAddedRuleParameterLink, dynamicName, ruleParam.getRuleName(),dynamicFolderName,ruleParam.getRuleFolderName()),parameterField, "",true);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" checkConnectionAndParameterOnAddedRulesForAPI ");
		}
	}

	public boolean validateAndSingleOverrideFunctionalityForAPI(boolean flag,String workflowJsonEntity ,List<String> ruleList,String ruleFolder, int i) {


		String subtype="";

		try {
			List<String> override = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverrideSubtypes);

			String sourceOverride= getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+"].sourceOverride");
			String targetOverride= getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+"].targetOverride");
			String parameterOverride= getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+"].parameterOverride");
			String parameterOverrideFolderPath= getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+"].parameterOverrideFolderPath");

			for(int j=0;j<override.size();j++) {

				/**	DataTestingParameters ruleOverrideParam =setWorkflowRuleOverRideParameter(i, j, workflowJsonEntity);**/

				subtype = getJsonValueUsingJsonPathExpreesion(workflowJsonEntity, jsonPathActivity+i+jsonPathOverride+j+jsonPathSubtype);

				subtype=checkNullValue(subtype);

				if(!subtype.isEmpty()) {

					switch(subtype.trim()+"api") {

					case "sourceapi":
						flag=singleSourceConnectionOverrideUsingConnectionNameForAPI(flag, ruleList.get(i),ruleFolder, sourceOverride,workflowSingleSourceConnectionOverrideToastMsg);
						break;

					case "targetapi":
						flag=singleTargetConnectionOverrideUsingConnectionNameForAPI(flag,ruleList.get(i),ruleFolder, targetOverride,workflowSingleTargetConnectionOverrideToastMsg);
						break;

					case "ruleapi":
						flag=singleParameterOverrideForAPI(flag,ruleList.get(i),ruleFolder, parameterOverride,parameterOverrideFolderPath, workflowSingleParameterOverrideToastMsg);
						break;

					default:

						BaseSuite.reportErrorLog("error occurs while validateAndSingleOverrideFunctionalityForAPI kindly check "+subtype);
						flag=false;
						break;

					}}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateAndSingleOverrideFunctionalityForAPI ");
		}

		return flag;
	}

	//single source connection override
	public boolean singleSourceConnectionOverrideUsingConnectionNameForAPI(boolean flag ,String ruleName,String folderName, String connectionName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog(logString+overrideRuleContent+" : "+ruleName+"  with source Connection : "+connectionName+logString);
					isDisplayedInLoop(driver, 3, returnTwoElements(newworklfowAddedRuleSourceConnLink, dynamicName, ruleName,dynamicFolderName,folderName));
					WebElement ele = driver.findElement(returnTwoElements(newworklfowAddedRuleSourceConnLink, dynamicName, ruleName,dynamicFolderName,folderName));isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					WebElement ele1 = driver.findElement(returnTwoElements(newSourceOverrideWithFolderPath, dynamicName, ruleName,dynamicFolderName,folderName));
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


					action.moveToElement(ele1).click().build().perform();

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, overrideDiscardIcon, discardContent+" icon  ");

						verifyIndividualLabel(driver, sourceConnOverrideTitle, sourceConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, sourceConnOverrideFindConnEdit, findConnectionEditField, true);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, false);

						String connName=getAttribute(driver, sourceConnOverrideFindConnName, attributeValue);

						clickOnEditButtonOfConnection(sourceConnOverrideFindConnEdit, findConnectionEditField, connName);

						BaseSuite.reportLog("Clicking on replace connection dropdown ");

						displayAndClick(driver, sourceConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog(" Clicked on replace connection dropdown");

						sendkeysToField(driver, sourceConnOverrideSearchBar, "Search connection ", connectionName);

						clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, connectionName), " connection name");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnEditButtonOfConnection(sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, connectionName);

						clickOnButton(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, sourceConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog(sourceConnectionField+overrideFunctionalityErrorLog, "singleSourceConnectionOverrideUsingConnectionNameForAPI");
						flag=false;
					}

				}

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" singleSourceConnectionOverrideUsingConnectionNameForAPI ");

			flag=false;
		}

		return flag;

	}



	//single target connection override
	public boolean singleTargetConnectionOverrideUsingConnectionNameForAPI(boolean flag ,String ruleName,String folderName, String connectionName, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				connectionName=checkNullValue(connectionName);

				if(!connectionName.isEmpty()) {

					BaseSuite.reportLog(logString+overrideRuleContent+" : "+ruleName+" with target  Connection : "+connectionName+logString);
					isDisplayedInLoop(driver, 3, returnTwoElements(newworklfowAddedRuleTargetConnLink, dynamicName, ruleName,dynamicFolderName,folderName));
					WebElement ele = driver.findElement(returnTwoElements(newworklfowAddedRuleTargetConnLink, dynamicName, ruleName,dynamicFolderName,folderName));isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					WebElement ele1 = driver.findElement(returnTwoElements(newTargetOverrideWithFolderPath, dynamicName, ruleName,dynamicFolderName,folderName));
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					action.moveToElement(ele1).click().build().perform();

					isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);

					if(isDisplayed(driver, sourceConnOverrideTitle)) {

						verifyIndividualLabel(driver, overrideDiscardIcon, discardContent+iconContent);

						verifyIndividualLabel(driver, sourceConnOverrideTitle, targetConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideFindConnLabel, findConnectionField);

						verifyIndividualLabel(driver, sourceConnOverrideReplaceConnLabel, overrideConnectionField);

						verifyVisibilityOfButtons(driver, targetConnOverrideFindConnEdit, findConnectionEditField, true);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnEdit, replaceConnectionEditField, false);

						verifyVisibilityOfButtons(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, false);

						BaseSuite.reportLog(" Clicking on replace connection dropdown");

						displayAndClick(driver, targetConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace connection dropdown ");

						sendkeysToField(driver, sourceConnOverrideSearchBar, " Search connection", connectionName);

						clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, connectionName), "connection name ");

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, targetConnectionOverrideField);

					}else {
						BaseSuite.reportFailLog(targetConnectionField+overrideFunctionalityErrorLog, "singleTargetConnectionOverrideUsingConnectionNameForAPI");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" singleTargetConnectionOverrideUsingConnectionNameForAPI ");

			flag=false;
		}

		return flag;

	}

	//single parameter override
	public boolean singleParameterOverrideForAPI(boolean flag,String ruleName,String ruleFolder, String parameterName, String folderPath, String expectedToast) {

		Actions action = new Actions(driver);

		try {
			if(flag) {
				parameterName=checkNullValue(parameterName);

				if(!parameterName.isEmpty()) {

					BaseSuite.reportLog(logString+overrideRuleContent+" : "+ruleName+" with  parameter : "+parameterName+logString);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					isDisplayedInLoop(driver, 5, returnTwoElements(newworklfowAddedRuleParameterLink, dynamicName, ruleName,dynamicFolderName,ruleFolder));
					WebElement ele = driver.findElement(returnTwoElements(newworklfowAddedRuleParameterLink, dynamicName, ruleName,dynamicFolderName,ruleFolder));isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
					WebElement ele1 = driver.findElement(returnTwoElements(newParameterFolderPath, dynamicName, ruleName, dynamicFolderName,ruleFolder));
					action.moveToElement(ele).click().perform();
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					action.moveToElement(ele1).click().build().perform();
					isDisplayedInLoop(driver, 3, parameterOverrideTitle);

					if(isDisplayed(driver, parameterOverrideTitle)) {

						verifyIndividualLabel(driver, overrideDiscardIcon, discardContent+"  icon");

						verifyIndividualLabel(driver, parameterOverrideTitle, parameterField);

						verifyIndividualLabel(driver, parameterOverrideFindConnLabel, findParameterField);

						verifyIndividualLabel(driver, parameterOverrideReplaceConnLabel, overrideParameterField);

						verifyVisibilityOfButtons(driver, parameterOverrideFindConnEdit, findParameterEditField, true);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnEdit, replaceParameterEditField, false);

						verifyVisibilityOfButtons(driver, parameterOverrideReplaceConnbtn, replaceParameterField, false);

						BaseSuite.reportLog("Clicking on replace parameter dropdown ");

						displayAndClick(driver, parameterOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.reportLog("Clicked on replace parameter dropdown");

						sendkeysToField(driver, sourceConnOverrideSearchBar, placeholderSearchParameter, parameterName);

						clickOnFieldOrButton(driver, returnTwoElements(newParameterOverrideWithFolderPath, dynamicName, parameterName, dynamicFolderName, folderPath), parameterNameContent);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						clickOnButton(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);

						flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, parameterOverrideField);

					}else {
						BaseSuite.reportFailLog(parameterField+overrideFunctionalityErrorLog, "singleParameterOverrideForAPI");
						flag=false;
					}

				}
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" singleParameterOverrideForAPI ");

			flag=false;
		}

		return flag;

	}

	//create workflow using automation database details using apis
	public boolean createWorkflowInSpecifiedModeUsingAPI(DataTestingParameters param,String foldername,String workflowJsonEntity, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;

		try {

			String workflowSubscriptionJSon="";
			String workflowMode=param.getWorkflowState();
			boolean downloadZip =true;
			boolean exceptionReport=false;
			String workflowExecutionStatus="success";

			if(workflowMode.contains("ed")) {
				if(workflowMode.toLowerCase().contains(publishContent)) {
					workflowMode=publishContent;
				}else if(workflowMode.toLowerCase().contains(validateContent)) {
					workflowMode=validateContent;
				}
			}

			DataTestingParameters workflowParam = param;

			newWorkflowName = workflowParam.getWorkflowName();

			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(foldername,icedqUser);

			if(flag) {

				flag= clickOnNewWorkflowButton(flag,icedqUser);

				if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

					flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

					flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowRulesFlagForAPI(flag,ruleList, workflowJsonEntity);	

					flag = clickOnWorkflowSaveOption(flag,workflowMode, workflowCreatedToastMsg,icedqUser);

					if(flag) {

						workflowid = getWorkflowIdOnWorkflowDetailsPage();

						subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

						flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport,workflowExecutionStatus, icedqUser);
					}
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowInSpecifiedModeUsingAPI ");

			flag=false;
		}

		return flag;

	}


	public String getworkflowtype(String workflowName) {
		String getType = null;

		try {
			log.info(workflowName);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 2, workflowTypeIcon);

			if(isDisplayed(driver, workflowTypeIcon)) {

				getType=getAttribute(driver, workflowTypeIcon, attributeTitle);

				getType=checkNullValue(getType);

				if(!getType.isEmpty()) {

					BaseSuite.reportLog("Workflow type is : "+getType);

				}else {

					getType="Custom";
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" getworkflowtype ");
		}
		return getType;
	}

	//create workflow using automation database details
	public boolean createCustomWorkflow(DataTestingParameters param,String rulefoldername,String paramFolder,String wkflFolder,boolean useFolderForRule,boolean isOverride, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String workflowid=null;
		String name="";
		try {

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=param.getWorkflowExecutionStatus();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = workflowParam.getWorkflowName();

			/**			flag=createNewFolderOrSelectExistingOnFolderSearchSideBar(wkflFolder,icedqUser);*/
			if(useFolderForRule) {
				workflowFolderNameForSanity=rulefoldername;
				workflowParamFolder=paramFolder;
				if(wkflFolder.contains("/")) {
					String[] n = wkflFolder.split("/"); 
					name = n[2];
				}else {
					name = wkflFolder;
				}
			}

			flag= clickOnNewWorkflowButton(flag,icedqUser);

			if(flag && !icedqUser.contains(readerFlag) && !icedqUser.contains(executorContent) ) {

				flag=enterDetailsToAddNewWorkflowPane(flag,wkflFolder, newWorkflowName, workflowParam.getWorkflowType());

				flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription()+" for "+name);

				if(!workflowMode.toLowerCase().contains(draftContent)) {

					flag=clickonWorkflowRulesAndDatasetTab(flag);

					List<String> ruleList = getJsonArrayValueUsingJsonPathExpreesion(workflowJsonEntity, workflowRuleListJsonPath);

					addRulesToWorkflowDetails(flag,ruleList, workflowJsonEntity);

					flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

					flag=selectWorkflowRulesFlag(flag,ruleList, workflowJsonEntity,isOverride);	
				}
				flag = clickOnWorkflowSaveOption(flag,workflowMode, workflowCreatedToastMsg,icedqUser);

				if(flag) {

					workflowid = getWorkflowIdOnWorkflowDetailsPage();

					subscriptionWorkflow(flag, workflowSubscriptionJSon,icedqUser); 

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					flag=validateAfterWorkflowSave(workflowid, newWorkflowName, workflowMode, downloadZip, exceptionReport,workflowExecutionStatus, icedqUser);
				}
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" createWorkflowInSpecifiedMode ");

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

				javascript(driver, scrollToElementArg, folderSidebarPanelOpenIcon);

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
			isDisplayedInLoop(driver, 0, ruleSidebarPanelOpenIcon);
			javascript(driver, scrollToElementArg, ruleSidebarPanelOpenIcon);
			if (!isDisplayed(driver, ruleSidebarPanelOpenIcon)) {

				return false; 
			}

			BaseSuite.reportLog("rules sidebar panel open/close button is visible");

			boolean isSidebarOpen = isDisplayed(driver, folderSidebarTitle);

			if (isSidebarOpen == expected) {

				BaseSuite.reportLog("rules sidebar panel is already in the expected state "+expected);
			} else {

				String action = expected ? "open" : "close";

				BaseSuite.reportLog("Clicking on rules sidebar panel to " + action);

				javascript(driver, scrollToElementArg, ruleSidebarPanelOpenIcon);

				displayAndClick(driver, ruleSidebarPanelOpenIcon);

				BaseSuite.reportLog("Clicked on rules sidebar panel to " + action);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle + " clickOnWorkflowSidebarPanelOpenOrClose :: " + e.toString());
			flag = false;
		}

		return flag;
	}

}
