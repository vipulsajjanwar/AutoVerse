package nextgen.automation.RuleRepo.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.python.antlr.PythonParser.while_stmt_return;
import org.python.core.exceptions;
import org.python.modules.thread.thread;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;
import com.jayway.jsonpath.internal.Path;
import com.tigervnc.rdr.Exception;

import gnu.cajo.invoke.Client;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.connectionRepo.ConnectionPoJO;
import nexgen.automation.framework.connectionRepo.NewConnectionRepoPage;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.HomePage;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataTestingPage extends PageUtil {

	WebDriver driver;

	public DataTestingPage(WebDriver driver) {
		this.driver = driver;
	}

	static ReadConfig readconfig = new ReadConfig();

	// *************************************** UI
	// Elements***********************************************************************************/
	// *************************************** UI
	By checkAddColumnSidebarAddBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.AddBtn"));
	By checkAddColumnSidebarCancelBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.CancelBtn"));

	By calculatedCheck = getElementLocator(prop.getProperty("DataTesting.CalculatedCheck"));
	By sourceTargetColumnList = getElementLocator(prop.getProperty("DataTesting.SourceTargetColumnList"));

	By rangeCheck = getElementLocator(prop.getProperty("DataTesting.RangeCheck"));
	By dateCheck = getElementLocator(prop.getProperty("DataTesting.DateCheck"));

	By toastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	public String runErrorMsgtintative = prop.getProperty("dataT.RunErrorMsgtintative");
	By advanceSearchButton = getElementLocator(prop.getProperty("AdvancedSearchButton"));
	By mainHeading = getElementLocator(prop.getProperty("dataT.MainHeading"));
	By folderPanel = getElementLocator(prop.getProperty("dataT.FolderPanel"));
	By folderLabel = getElementLocator(prop.getProperty("dataT.FoldersLabel"));
	By clearAllButton = getElementLocator(prop.getProperty("dataT.ClearAllButton"));
	By foldersList = getElementLocator(prop.getProperty("dataT.FoldersList"));
	By addNewFolderButton = getElementLocator(prop.getProperty("dataT.AddNewFolderButton"));
	By foldersNote = getElementLocator(prop.getProperty("dataT.FolderNote"));
	By filterButton = getElementLocator(prop.getProperty("dataT.FilterButton"));
	By filterCloseArrow = getElementLocator(prop.getProperty("dataT.FilterCloseArrow"));
	By newRuleButton = getElementLocator(prop.getProperty("dataT.NewRuleButton"));
	By refreshButton = getElementLocator(prop.getProperty("dataT.RefreshButton"));
	By deleteButton = getElementLocator(prop.getProperty("dataT.DeleteButton"));
	By moreOpButton = getElementLocator(prop.getProperty("dataT.MoreOptionButton"));
	By searchBox = getElementLocator(prop.getProperty("dataT.SearchBox"));
	By searchButton = getElementLocator(prop.getProperty("dataT.SearchButton"));
	By pageBar = getElementLocator(prop.getProperty("dataT.PaginationBar"));
	By pageMsg = getElementLocator(prop.getProperty("dataT.PaginationMsg"));
	By pageArrows = getElementLocator(prop.getProperty("dataT.PageArrows"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By dataTSpinner = getElementLocator(prop.getProperty("dataT.spinner"));
	By columnList = getElementLocator(prop.getProperty("dataT.ColumnList"));
	By ruleList = getElementLocator(prop.getProperty("dataT.RulesList"));
	By noRecondsFound = getElementLocator(prop.getProperty("dataT.NoRecords"));
	By addNewRuleTitle = getElementLocator(prop.getProperty("dataT.AddNewRulePanelTitle"));
	By brdCrumsHomeLink = getElementLocator(prop.getProperty("Connection.HomeLink1"));
	By brdCrumsDataTesting = getElementLocator(prop.getProperty("dataT.DataTestingBrCrum"));
	By brdCrumsTestRules = getElementLocator(prop.getProperty("dataT.TestRulesBrCrum"));
	By brdCrumsworkspaceName = getElementLocator(prop.getProperty("dataT.WorkspaceNameBrCrum"));
	By scrollDown = getElementLocator(prop.getProperty("dataT.scrollDown"));
	By scrollUp = getElementLocator(prop.getProperty("dataT.scrollUp"));
	By ruleRunButton = getElementLocator(prop.getProperty("dataT.Rule.RunBtn"));
	By ruleBtnListMenuIcon = getElementLocator(prop.getProperty("dataT.Rule.SaveBtnList"));
	By ruleDraftButton = getElementLocator(prop.getProperty("dataT.Rule.DarftMenu"));
	By ruleValidateButton = getElementLocator(prop.getProperty("dataT.Rule.ValidateMenu"));
	By rulePublishButton = getElementLocator(prop.getProperty("dataT.Rule.PublishMenu"));
	By ruleCurrentStatus = getElementLocator(prop.getProperty("dataT.Rule.StatusLabel"));
	By spinner = getElementLocator(prop.getProperty("dataT.Rule.Save.Spinner"));
	By saveMenuOptionsList = getElementLocator(prop.getProperty("dataT.Rule.saveMenuDiv"));
	By saveListOption = getElementLocator(prop.getProperty("DataTesting.SaveListOption"));
	By recentRunButton = getElementLocator(prop.getProperty("DataTesting.RecentRunButton"));
	By sourceXmlTableNameEdit = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceXmlTableNameEdit"));
	By targetXmlTableNameEdit = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetXmlTableNameEdit"));
	By ruleTitle = getElementLocator(prop.getProperty("Rule.title"));
	By refreshRuleButton = getElementLocator(prop.getProperty("Rule.refresh.button"));
	By defaultPropertyList = getElementLocator(prop.getProperty("DataTesting.Rule.DefaultPropertyList"));
	By targetDefaultPropertyList = getElementLocator(prop.getProperty("DataTesting.Rule.TargetDefaultPropertyList"));

	
	
	By sourceSchemaText = getElementLocator(prop.getProperty("DataTesting.SourceSchemaText"));
	By targetSchemaText = getElementLocator(prop.getProperty("DataTesting.TargetSchemaText"));
	By ruleIcon = getElementLocator(prop.getProperty("DataTesting.RuleIcon"));
	By ruleNameHeadline = getElementLocator(prop.getProperty("DataTesting.RuleNameHeadline"));
	By ruleSateChip = getElementLocator(prop.getProperty("DataTesting.RuleSateChip"));
	By addedCheckName = getElementLocator(prop.getProperty("DataTesting.AddedCheckName"));
	By addedCheckExpression = getElementLocator(prop.getProperty("DataTesting.AddedCheckExpression"));
	By addedCheckStatus = getElementLocator(prop.getProperty("DataTesting.AddedCheckStatus"));
	By SourceFileGetSchema = getElementLocator(prop.getProperty("DataTesting.Rule.SourceFileGetSchema"));
	By targetFileGetSchema = getElementLocator(prop.getProperty("DataTesting.Rule.TargetFileGetSchema"));
	By sourceXmlTableNameText = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceXmlTableNameText"));
	By targetXmlTableNameText = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetXmlTableNameText"));
	By recentRunSearchBar = getElementLocator(prop.getProperty("DataT.RecentRunSearchBar"));
	By toastMsgCon = getElementLocator(prop.getProperty("Commontoastmsg"));
	By popUpClose = getElementLocator(prop.getProperty("PopUpClose"));
	By exceptionReportNode = getElementLocator(prop.getProperty("dataT.RuleNode.exceptionReport"));
	By recentRubTab = getElementLocator(prop.getProperty("dataT.RecentRun.tabDiv"));
	By recent_RefreshBtn = getElementLocator(prop.getProperty("dataT.RecentRun.tab.RefreshBtn"));
	By recentRun_SearchInputbox = getElementLocator(prop.getProperty("dataT.RecentRun.tab.SearchInputBox"));
	By recentRun_SeachBtn = getElementLocator(prop.getProperty("dataT.RecentRun.tab.SearchBtn"));
	By recentRun_NoRecordToDisplay = getElementLocator(prop.getProperty("dataT.RecentRun.table.Norecordtodisplay"));
	By recentRun_totalitems = getElementLocator(prop.getProperty("dataT.RecentRun.Label.TotalItems"));
	By diagramNode_Check = getElementLocator(prop.getProperty("dataT.diagram.Node.Check"));
	By checksTab = getElementLocator(prop.getProperty("dataT.Check.checksTab"));
	By check_resultType_rowLabel = getElementLocator(prop.getProperty("dataT.check.resultType"));
	By check_add_button = getElementLocator(prop.getProperty("dataT.check.expression.addbtn"));
	By check_add_NewChkbutton = getElementLocator(prop.getProperty("dataT.check.expression.addbtn.NewCheck"));
	By check_add_NewCustCheckbutton = getElementLocator(prop.getProperty("dataT.check.expression.addbtn.NewCustCheck"));
	By check_add_AddColbutton = getElementLocator(prop.getProperty("dataT.check.expression.addbtn.AddCol"));
	By check_addbtn_optionMenu = getElementLocator(prop.getProperty("dataT.check.expression.addbtn.options"));
	By check_NewChecks_Panel = getElementLocator(
			prop.getProperty("dataT.check.expression.addbtn.NewCheck.chooseCheckPanel"));
	By check_NewCustChecks_TreeView = getElementLocator(
			prop.getProperty("dataT.check.expression.addbtn.NewCustCheck.treeview"));
	By check_AddColumn_Sidebar = getElementLocator(prop.getProperty("dataT.check.expression.addbtn.AddCol.sidebar"));
	By check_AddColumn_Sidebar_AddBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.AddBtn"));
	By check_AddColumn_Sidebar_CancelBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.CancelBtn"));
	By check_AddCol_Sidebar_searchBox = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.Searchbox"));
	By check_AddCol_Sidebar_searchBtn = getElementLocator(prop.getProperty("dataT.check.AddCol.sidebar.SearchBtn"));
	By check_AddCol_Sidebar_srch_noRecord = getElementLocator(
			prop.getProperty("dataT.check.AddCol.sidebar.Search.NoRecord"));
	By check_AddCol_Sidebar_srch_noOfCol = getElementLocator(
			prop.getProperty("dataT.check.AddCol.sidebar.Search.NoOfCol"));
	By check_nCustChk_NoOfExpAvail = getElementLocator(prop.getProperty("dataT.check.AddCustChk.noOfCusExpAvail"));
	By check_CustCheck_AddExpBtn = getElementLocator(prop.getProperty("dataT.check.custCheck.addedExpBtn"));
	By check_CustCheck_Expressions = getElementLocator(prop.getProperty("dataT.check.CustChek.validateExp"));
	By check_NoOfExp_node_text = getElementLocator(prop.getProperty("dataT.check.stat.NoOfExp.text"));
	By check_Node_click = getElementLocator(prop.getProperty("dataT.check.NodeClick"));
	By check_footer_label = getElementLocator(prop.getProperty("dataT.check.footer.lowerLabel"));
	By sourceDatasetClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetClick"));
	By sourceDatasetClick1 = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetClick1"));
	By sourceDatasetSourceName = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSourceName"));
	By sourceDatasetConnectionType = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionType"));
	By sourceDatasetConnectionClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionClick"));
	By sourceDatasetConnectionSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionSearch"));
	By sourceDatasetConnection = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnection"));
	By propertyDropdownList = getElementLocator(prop.getProperty("DataTesting.Rule.PropertyDropdownList"));

	By SourceDatasetSchemaSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSchemaSearch"));
	public By sourceDatasetSchemaClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSchemaClick"));
	By targetDatasetSchemaClick = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetSchemaClick"));
	public By sourceDatasetTableClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetTableClick"));
	By targetDatasetTableClick = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetTableClick"));
	By sourceDatasetTableSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetTableSearch"));
	By sourceDatasetTestButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetTestButton"));
	public By sourceDatasetEditButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetEditButton"));
	public By targetDatasetEditButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetEditButton"));

	public By connections = getElementLocator(prop.getProperty("RuleRepo.Connections"));
	public By connection = getElementLocator(prop.getProperty("RuleRepo.Connection"));
	By fileLayoutJson = getElementLocator(prop.getProperty("DataTesting.FileLayoutJson"));
	By exceptionReportCheckList = getElementLocator(prop.getProperty("DataTesting.ExceptionReportCheckList"));
	By summaryExitcode = getElementLocator(prop.getProperty("DataTesting.SummaryExitcode"));
	By summaryPane = getElementLocator(prop.getProperty("DataTesting.SummaryPane"));
	By sourceDeferredSort = getElementLocator(prop.getProperty("DataTesting.SourceDeferredSort"));
	By targetDeferredSort = getElementLocator(prop.getProperty("DataTesting.TargetDeferredSort"));
	By sourceTargetJoinMess = getElementLocator(prop.getProperty("DataTesting.SourceTargetJoinMess"));
	By connect = getElementLocator(prop.getProperty("DataTesting.Connect"));
	By addAllExpression = getElementLocator(prop.getProperty("DataTesting.AddAllExpression"));
	By disconnectAll = getElementLocator(prop.getProperty("DataTesting.DisconnectAll"));
	By checkActiveStatus = getElementLocator(prop.getProperty("DataTesting.CheckActiveStatus"));
	By checkInactiveStatus = getElementLocator(prop.getProperty("DataTesting.CheckInactiveStatus"));
	By sourceSchemaTab = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceSchemaTab"));
	By targetSchemaTab = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetSchemaTab"));

	By targetDatasetSetSQLButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetSetSQLButton"));
	By sourceDatasetSetSQLButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSetSQLButton"));
	By sourceDatasetSetFileButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSetFileButton"));
	By targetDatasetSetFileButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetSetFileButton"));
	By sourceFilterConditionLable = getElementLocator(prop.getProperty("RuleRepo.SourceFilterConditionLable"));
	By targetFilterConditionLable = getElementLocator(prop.getProperty("RuleRepo.TargetFilterConditionLable"));
	By addPropertyButton = getElementLocator(prop.getProperty("DataTesting.Rule.AddPropertyButton"));
	By targetAddPropertyButton = getElementLocator(prop.getProperty("DataTesting.Rule.TargetAddPropertyButton"));

	String xmlTypeDetectionSchemeEdit = prop.getProperty("DataTesting.Ruel.XmlTypeDetectionSchemeEdit");
	String targetXmlTypeDetectionSchemeEdit = prop.getProperty("DataTesting.Ruel.TargetXmlTypeDetectionSchemeEdit");

	By typeDetectionSchemeDefaultValue = getElementLocator(
			prop.getProperty("DataTesting.Rule.TypeDetectionSchemeDefaultValue"));
	By typeDetectionSchemeDefaultText = getElementLocator(
			prop.getProperty("DataTesting.Rule.TypeDetectionSchemeDefaultText"));
	String defaultPropertyText = prop.getProperty("DataTesting.Rule.DefaultPropertyText");
	String targetDefaultPropertyText = prop.getProperty("DataTesting.Rule.TargetDefaultPropertyText");

	String defaultPropertyValueText = prop.getProperty("DataTesting.Rule.DefaultPropertyValueText");
	String targetDefaultPropertyValueText = prop.getProperty("DataTesting.Rule.TargetDefaultPropertyValueText");

	String xmlTypeDetectionSchemeDelete = prop.getProperty("DataTesting.Ruel.XmlTypeDetectionSchemeDelete");
	String targetXmlTypeDetectionSchemeDelete = prop.getProperty("DataTesting.Ruel.TargetXmlTypeDetectionSchemeDelete");

	By sourceDatasetSetFileType = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSetFileType"));
	By targetDatasetSetFileType = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetSetFileType"));
	By sourceDatasetSpinner = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetSpinner"));
	public By sourceDatasetDataQueryBox = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetDataQueryBox"));
	By targetDatasetDataQueryBox = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetDataQueryBox"));
	public By sourcegetData = getElementLocator(prop.getProperty("RuleRepo.SourceGetData"));
	By targetgetdata = getElementLocator(prop.getProperty("RuleRepo.TargetGetData"));
	By targetDatasetButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetButton"));
	public By sourceDatasetButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetButton"));
	By cancleButton = getElementLocator(prop.getProperty("RuleRepo.CancleButton"));
	By sourceDataCancelBtn = getElementLocator(prop.getProperty("DataTesting.sourceDataCancelBtn"));
	By sourceData = getElementLocator(prop.getProperty("RuleRepo.Data"));
	By getFile = getElementLocator(prop.getProperty("RuleRepo.GetFile"));
	By selectBottom = getElementLocator(prop.getProperty("RuleRepo.SelectBottom"));
	By propertiesBtn = getElementLocator(prop.getProperty("propertiesBtn"));
	By appendOrderBy = getElementLocator(prop.getProperty("RuleRepo.AppendOrderBy"));
	By tableList = getElementLocator(prop.getProperty("RuleRepo.TableList"));
	By fileTableList = getElementLocator(prop.getProperty("RuleRepo.FileTableList"));
	By dataQualityDimensionBox = getElementLocator(prop.getProperty("DataTesting.DataQualityDimensionBox"));
	By preview = getElementLocator(prop.getProperty("RuleRepo.Preview"));
	By filePreview = getElementLocator(prop.getProperty("RuleRepo.FilePreview"));
	By completenessCheck = getElementLocator(prop.getProperty("DataTesting.CompletenessCheck"));
	By lengthCheck = getElementLocator(prop.getProperty("DataTesting.LengthCheck"));
	By conditionalAttribute = getElementLocator(prop.getProperty("DataTesting.ConditionalAttribute"));
	By conditionalOperator = getElementLocator(prop.getProperty("DataTesting.ConditionalOperator"));
	By conditionalValue = getElementLocator(prop.getProperty("DataTesting.ConditionalValue"));
	By containsCheck = getElementLocator(prop.getProperty("DataTesting.ContainsCheck"));
	By datatTypeCheck = getElementLocator(prop.getProperty("DataTesting.DatatTypeCheck"));
	By patternCheck = getElementLocator(prop.getProperty("DataTesting.PatternCheck"));
	By caseInsensitiveCheckbox = getElementLocator(prop.getProperty("DataTesting.CaseInsensitiveCheckbox"));
	By targetDatasetConnectionType = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetConnectionType"));
	By targetDatasetConnectionClick = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetConnectionClick"));
	By targetData = getElementLocator(prop.getProperty("RuleRepo.TargetData"));
	By targetDatasetTestButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetTestButton"));
	By diffJoinButton = getElementLocator(prop.getProperty("RuleRepo.DiffJoinButton"));
	By diffJoinConnectAll = getElementLocator(prop.getProperty("RuleRepo.DiffJoinConnectAll"));
	By diffJoinDisConnectAll = getElementLocator(prop.getProperty("RuleRepo.DiffJoinDisConnectAll"));
	By diffJoinAddAllAsExpression = getElementLocator(prop.getProperty("RuleRepo.DiffJoinAddAllAsExpression"));
	By targetDatasetTargetName = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetTargetName"));
	By source = getElementLocator(prop.getProperty("RuleRepo.Source"));
	By target = getElementLocator(prop.getProperty("RuleRepo.Target"));
	By newCheckTitle = getElementLocator(prop.getProperty("dataT.NewCheckTitle"));
	By chooseCheckTitle = getElementLocator(prop.getProperty("dataT.ChooseCheckSubHeading"));
	By checksList = getElementLocator(prop.getProperty("dataT.ChecksList"));
	By newCheckCloseButton = getElementLocator(prop.getProperty("dataT.CheckCloseButtton"));
	By checkNameLabel = getElementLocator(prop.getProperty("dataT.NameTitle"));
	By pushdownCheckList = getElementLocator(prop.getProperty("DataTesting.PushdownCheckList"));
	By sourceAppendOrderBy = getElementLocator(prop.getProperty("RuleRepo.SourceAppendOrderBy"));
	By targetAppendOrderBy = getElementLocator(prop.getProperty("RuleRepo.TargetAppendOrderBy"));
	By copyFromTargetButton = getElementLocator(prop.getProperty("DataTesting.CopyFromTargetButton"));
	By copyFromSourceButton = getElementLocator(prop.getProperty("DataTesting.CopyFromSourceButton"));
	By chooseAttribute = getElementLocator(prop.getProperty("DataTesting.ChooseAttribute"));
	By checkNameField = getElementLocator(prop.getProperty("dataT.CheckNameField"));
	By checkList = getElementLocator(prop.getProperty("dataT.CheckList"));
	By chk_addCol_SourceTab = getElementLocator(prop.getProperty("dataT.AddCol.SourceTab"));
	By chk_addCol_TargetTab = getElementLocator(prop.getProperty("dataT.AddCol.TargetTab"));
	By chk_addButton_SideMenuBtn = getElementLocator(prop.getProperty("dataT.Addoptions.sidemenu"));
	By metadata_ruleId = getElementLocator(prop.getProperty("dataT.MetaData.RuleID"));
	By copyPath = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.Copypath"));
	By summaryTitle = getElementLocator(prop.getProperty("dataT.ExceptionReport.SummaryTitle"));
	By SummaryClose = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.close"));
	By downloadButton = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.DownloadButton"));
	By exportButton = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.ExportButton"));
	By CopyUrlButton = getElementLocator(prop.getProperty("dataT.CopuUrlButton"));
	By breadCrumbExceptionReport = getElementLocator(prop.getProperty("DataTesting.BreadCrumbExceptionReport"));
	By checkActiveButton = getElementLocator(prop.getProperty("DataTesting.CheckActiveButton"));
	By checkDeactiveButton = getElementLocator(prop.getProperty("DataTesting.CheckDeactiveButton"));
	By checkDeleteButton = getElementLocator(prop.getProperty("DataTesting.CheckDeleteButton"));

	By instanceStatus = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.InstanceStatus"));
	By norecordsOnSummary = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.NoRecords"));
	By exceptioncolumnList = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.headerList"));
	By summary_CheckNameList = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.CheckNameList"));
	By summary_SearchBar = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.SearchBar"));
	By searchBarClear = getElementLocator(prop.getProperty("DataT.ExceptionReport.Summary.SearchBarClear"));
	By selectAllCheckBox = getElementLocator(prop.getProperty("DataT.ExceptionReport.Summary.SelectAllCheckBox"));
	By listOfCheckNames = getElementLocator(prop.getProperty("DataT.ExceptionReport.Summary.ListOfCheckNames"));
	By summary_SearchBtn = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.SearchButton"));
	By summary_pagination = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.Pagination"));
	By summary_pagedetails = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.PaginationDetails"));
	By summary_exportTypeList = getElementLocator(prop.getProperty("dataT.ExceptionReport.Summary.ExportTypeList"));
	By dataTestingOpen = getElementLocator(prop.getProperty("dataT.DataTestingSidePanelOpenArrow"));
	By dataTestingClose = getElementLocator(prop.getProperty("dataT.DataTestingSidePanelCloseArrow"));
	By dataTestingSubModuleList = getElementLocator(prop.getProperty("dataT.DataTesting.SubModuleList"));
	By recentRun_ExecutionLog_CancelBtn = getElementLocator(prop.getProperty("dataT.recentLog.cancelBtn"));
	By recentRun_ExecutionLog_closeBtn = getElementLocator(prop.getProperty("dataT.recentLog.closeBtn"));

	By recentRun_ExecutionLog_DownloadBtn = getElementLocator(prop.getProperty("dataT.recentLog.downloadBtn"));
	By recentRun_ExecutionLog_CopyBtn = getElementLocator(prop.getProperty("dataT.recentLog.copyBtn"));

	By sourceContainer = getElementLocator(prop.getProperty("DataTesting.SourceContainer"));
	By targetContainer = getElementLocator(prop.getProperty("DataTesting.TargetContainer"));
	By sourceFilePath = getElementLocator(prop.getProperty("DataTesting.SourceFilePath"));
	By targetFilePath = getElementLocator(prop.getProperty("DataTesting.TargetFilePath"));
	By sourceRowDelimiter = getElementLocator(prop.getProperty("DataTesting.SourceRowDelimiter"));
	By targetRowDelimiter = getElementLocator(prop.getProperty("DataTesting.TargetRowDelimiter"));
	By sourceColumnDelimiter = getElementLocator(prop.getProperty("DataTesting.SourceColumnDelimiter"));
	By targetColumnDelimiter = getElementLocator(prop.getProperty("DataTesting.targetColumnDelimiter"));
	By sourceTextQualifier = getElementLocator(prop.getProperty("DataTesting.SourceTextQualifier"));
	By targetTextQualifier = getElementLocator(prop.getProperty("DataTesting.TargetTextQualifier"));
	By sourceSkipRowTop = getElementLocator(prop.getProperty("DataTesting.SourceSkipRowTop"));
	By targetSkipRowTop = getElementLocator(prop.getProperty("DataTesting.TargetSkipRowTop"));
	By sourceHeaderRow = getElementLocator(prop.getProperty("DataTesting.SourceHeaderRow"));
	By targetHeaderRow = getElementLocator(prop.getProperty("DataTesting.TargetHeaderRow"));
	By sourceSkipRowBottom = getElementLocator(prop.getProperty("DataTesting.SourceSkipRowBottom"));
	By targetSkipRowBottom = getElementLocator(prop.getProperty("DataTesting.TargetSkipRowBottom"));
	By sourceTrimData = getElementLocator(prop.getProperty("DataTesting.SourceTrimData"));
	By targetTrimData = getElementLocator(prop.getProperty("DataTesting.TargetTrimData"));
	By targetTrimDataCheckBox = getElementLocator(prop.getProperty("DataTesting.TargetTrimDataCheckBox"));
	By xmlTableName = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlTableName"));
	By xmlTableNameText = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlTableNameText"));

	By xmlXpath = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlXpath"));
	By sourceGetSchema = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceGetSchema"));
	By targetGetSchema = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetGetSchema"));
	By veiwSchema = getElementLocator(prop.getProperty("DataTesting.Ruel.VeiwSchema"));
	By schemaID = getElementLocator(prop.getProperty("DataTesting.Ruel.SchemaID"));
	By setSqlButton = getElementLocator(prop.getProperty("DataTesting.Ruel.SetSqlButton"));
	By resetButton = getElementLocator(prop.getProperty("DataTesting.Ruel.ResetButton"));
	By schemaText = getElementLocator(prop.getProperty("DataTesting.Ruel.SchemaText"));
	By buttonAB = getElementLocator(prop.getProperty("DataTesting.ButtonA-B"));
	By buttonBA = getElementLocator(prop.getProperty("DataTesting.ButtonB-A"));
	By buttonAnB = getElementLocator(prop.getProperty("DataTesting.ButtonAnB"));
	By buttonExp = getElementLocator(prop.getProperty("DataTesting.ButtonExp"));
	By buttonRowCount = getElementLocator(prop.getProperty("DataTesting.ButtonRowCount"));
	By sourceRefreshSchema = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceRefreshSchema"));
	By targetRefreshSchema = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetRefreshSchema"));

	By sourceEmptyStringisNULL = getElementLocator(prop.getProperty("DataTesting.SourceEmptyStringisNULL"));
	By targetEmptyStringisNULL = getElementLocator(prop.getProperty("DataTesting.TargetEmptyStringisNULL"));
	By targetEmptyStringisNULLCheckbox = getElementLocator(
			prop.getProperty("DataTesting.TargetEmptyStringisNULLCheckbox"));
	By sourceWhiteSpaceisNULL = getElementLocator(prop.getProperty("DataTesting.SourceWhiteSpaceisNULL"));
	By targetWhiteSpaceisNULL = getElementLocator(prop.getProperty("DataTesting.TargetWhiteSpaceisNULL"));
	By targetWhiteSpaceisNULLCheckbox = getElementLocator(
			prop.getProperty("DataTesting.TargetWhiteSpaceisNULLCheckbox"));
	By expressionArea = getElementLocator(prop.getProperty("DataTesting.ExpressionArea"));
	By testColCheck = getElementLocator(prop.getProperty("DataTesting.TestColCheck"));
	By testColCheckInputBox = getElementLocator(prop.getProperty("DataTesting.TestColCheckInputBox"));
	By sourceFileLayout = getElementLocator(prop.getProperty("DataTesting.SourceFileLayout"));
	By sourceFixedFileTextArea = getElementLocator(prop.getProperty("DataTesting.SourceFixedFileTextArea"));
	By targetFixedFileTextArea = getElementLocator(prop.getProperty("DataTesting.TargetFixedFileTextArea"));
	By sourceFixedFileTextAreaClear = getElementLocator(prop.getProperty("DataTesting.SourceFixedFileTextAreaClear"));
	By targetFixedFileTextAreaClear = getElementLocator(prop.getProperty("DataTesting.TargetFixedFileTextAreaClear"));
	By sourceFixedString = getElementLocator(prop.getProperty("DataTesting.SourceFixedString"));
	By targetFixedString = getElementLocator(prop.getProperty("DataTesting.TargetFixedString"));
	public By sourceFileDataButton = getElementLocator(prop.getProperty("DataTesting.SourceFileDataButton"));
	By targetFileDataButton = getElementLocator(prop.getProperty("DataTesting.TargetFileDataButton"));
	By sourceRefereshDataButton = getElementLocator(prop.getProperty("DataTesting.SourceRefereshDataButton"));
	By targetRefereshDataButton = getElementLocator(prop.getProperty("DataTesting.TargetRefereshDataButton"));
	By sourceFixedStringValue = getElementLocator(prop.getProperty("DataTesting.SourceFixedStringValue"));
	By targetFixedStringValue = getElementLocator(prop.getProperty("DataTesting.TargetFixedStringValue"));
	By targetOverrideLayout = getElementLocator(prop.getProperty("DataTesting.TargetOverrideLayout"));
	By getFileButton = getElementLocator(prop.getProperty("DataTesting.GetFile"));
	By sourceFilterConditionExpressions = getElementLocator(
			prop.getProperty("DataTesting.SourceFilterConditionExpressions"));
	By targetFilterConditionExpressions = getElementLocator(
			prop.getProperty("DataTesting.TargetFilterConditionExpressions"));
	By sourceSingleFileCheckbox = getElementLocator(prop.getProperty("DataTesting.SourceSingleFileCheckbox"));
	By sourceParameterisedCheckbox = getElementLocator(prop.getProperty("DataTesting.SourceParameterisedCheckbox"));

	By targetSingleFileCheckbox = getElementLocator(prop.getProperty("DataTesting.TargetSingleFileCheckbox"));
	By targetParameterisedCheckbox = getElementLocator(prop.getProperty("DataTesting.TargetParameterisedCheckbox"));
	By sourceSingleFile = getElementLocator(prop.getProperty("DataTesting.SourceSingleFile"));
	By targetSingleFile = getElementLocator(prop.getProperty("DataTesting.TargetSingleFile"));
	By dafaultInput = getElementLocator(prop.getProperty("DataTesting.DafaultInput"));
	By sQLInput = getElementLocator(prop.getProperty("DataTesting.SQLInput"));
	By wizardInput = getElementLocator(prop.getProperty("DataTesting.WizardInput"));
	By noRecordOnCheck = getElementLocator(prop.getProperty("DataTesting.NoRecordOnCheck"));

	By checkSearchBar = getElementLocator(prop.getProperty("DataTesting.CheckSearchBar"));
	By checkSearchButton = getElementLocator(prop.getProperty("DataTesting.CheckSearchButton"));
	By checkSearchClearButton = getElementLocator(prop.getProperty("DataTesting.CheckSearchClearButton"));
	By searchCheckName = getElementLocator(prop.getProperty("DataTesting.SearchCheckName"));

	By summaryCheckSearchBar = getElementLocator(prop.getProperty("DataTesting.SummaryCheckSearchBar"));
	By summaryCheckSearchClearButton = getElementLocator(prop.getProperty("DataTesting.SummaryCheckSearchClearButton"));
	By summaryCheckSearchBarButton = getElementLocator(prop.getProperty("DataTesting.SummaryCheckSearchBarButton"));
	By searchSummaryName = getElementLocator(prop.getProperty("DataTesting.SearchSummaryName"));

	By targetDafaultInput = getElementLocator(prop.getProperty("DataTesting.TargetDafaultInput"));
	By targetSQLInput = getElementLocator(prop.getProperty("DataTesting.TargetSQLInput"));
	By targetWizardInput = getElementLocator(prop.getProperty("DataTesting.TargetWizardInput"));

	By sourceDefaultRadioButton = getElementLocator(prop.getProperty("DataTesting.SourceDefaultRadioButton"));
	By sourceWizardRadioButton = getElementLocator(prop.getProperty("DataTesting.SourceWizardRadioButton"));
	By sourceSqlRadioButton = getElementLocator(prop.getProperty("DataTesting.SourceSqlRadioButton"));
	By targetDefaultRadioButton = getElementLocator(prop.getProperty("DataTesting.TargetDefaultRadioButton"));
	By targetWizardRadioButton = getElementLocator(prop.getProperty("DataTesting.TargetWizardRadioButton"));
	By targetSqlRadioButton = getElementLocator(prop.getProperty("DataTesting.TargetSqlRadioButton"));

	By sourceParameterisedPath = getElementLocator(prop.getProperty("DataTesting.SourceParameterisedPath"));
	By targetParameterisedPath = getElementLocator(prop.getProperty("DataTesting.TargetParameterisedPath"));

	By sourceSelectFile = getElementLocator(prop.getProperty("DataTesting.SourceSelectFile"));
	By targetSelectFile = getElementLocator(prop.getProperty("DataTesting.TargetSelectFile"));

	By setProperties = getElementLocator(prop.getProperty("DataTesting.SourceSetProperties"));

	By searchRuleSpinner = getElementLocator(prop.getProperty("searchRuleSpinner"));

	By sourceFilterConditionColumnList = getElementLocator(
			prop.getProperty("RuleRepo.SourceFilterConditionColumnList"));
	By targetFilterConditionColumnList = getElementLocator(
			prop.getProperty("RuleRepo.TargetFilterConditionColumnList"));
	By sourceFilterColumnOperator = getElementLocator(prop.getProperty("DataTesting.SourceFilterColumnOperator"));
	By targetFilterColumnOperator = getElementLocator(prop.getProperty("DataTesting.TargetFilterColumnOperator"));
	By sourceAddColumn = getElementLocator(prop.getProperty("DataTesting.SourceAddColumn"));
	By targetAddColumn = getElementLocator(prop.getProperty("DataTesting.TargetAddColumn"));
	By sourceColumnName = getElementLocator(prop.getProperty("DataTesting.SourceColumnName"));
	By targetColumnName = getElementLocator(prop.getProperty("DataTesting.TargetColumnName"));
	By targetStartPoint = getElementLocator(prop.getProperty("DataTesting.TargetStartPoint"));
	By targetEndPoint = getElementLocator(prop.getProperty("DataTesting.TargetEndPoint"));
	By sourceStartPoint = getElementLocator(prop.getProperty("DataTesting.SourceStartPoint"));
	By sourceEndPoint = getElementLocator(prop.getProperty("DataTesting.SourceEndPoint"));
	By checkStatusbutton = getElementLocator(prop.getProperty("dataT.StatusCheckbox"));
	By checkStatusDD = getElementLocator(prop.getProperty("dataT.StatusTitle"));
	By discardPopupBtn = getElementLocator(prop.getProperty("dataT.DiscardPupupButton"));
	By discardPopupMsg = getElementLocator(prop.getProperty("dataT.DiscardPopupMsg"));
	By dtresultTypes = getElementLocator(prop.getProperty("dataT.RuleResultTypes"));
	By showDownloadExpetionUrl = getElementLocator(prop.getProperty("dataT.ShowDownloadExpetionUrl"));
	By metadataTitle = getElementLocator(prop.getProperty("dataT.CheckSubHeader"));
	By dimensionField = getElementLocator(prop.getProperty("dataT.CheckDimensionField"));
	By dimensionDropdownBtn = getElementLocator(prop.getProperty("dataT.CheckDimensionDropdown"));
	By dimensionDDlist = getElementLocator(prop.getProperty("dataT.DimensionDropdownList"));
	By dimensiondropdownPopup = getElementLocator(prop.getProperty("dataT.DimensionDropdown"));
	By checkstatusLabel = getElementLocator(prop.getProperty("dataT.StatusTitle"));
	By checkstatusCheckbox = getElementLocator(prop.getProperty("dataT.StatusCheckbox"));
	By chooseAttrTitle = getElementLocator(prop.getProperty("dataT.ChooseAttribute"));
	By chooseAttrInput = getElementLocator(prop.getProperty("dataT.AttributeSearchinput"));
	By attributeList = getElementLocator(prop.getProperty("dataT.Checks_ColumnList"));
	By attributeValue = getElementLocator(prop.getProperty("dataT.AttributeValue"));
	By propertiesTitle = getElementLocator(prop.getProperty("dataT.PropertiesTitle"));
	By trimDataCheckbox = getElementLocator(prop.getProperty("dataT.TrimDataCheckbox"));
	By emptyStringCheckbox = getElementLocator(prop.getProperty("dataT.EmptyStringCheckbox"));
	By whiteSpaceCheckbox = getElementLocator(prop.getProperty("dataT.WhiteSpaceCheckbox"));
	By fixedStringTitle = getElementLocator(prop.getProperty("dataT.FixedStringTitle"));
	By fixedStringInput = getElementLocator(prop.getProperty("dataT.FixedStringInput"));
	By checkInfotitle = getElementLocator(prop.getProperty("dataT.CheckInfoTitle"));
	By checkInfoDetails = getElementLocator(prop.getProperty("dataT.CheckInfoDetails"));
	By backToChecksButton = getElementLocator(prop.getProperty("dataT.BackToChecksButton"));
	By cancelCheckButton = getElementLocator(prop.getProperty("dataT.CancelCheckButton"));
	By testCheckButton = getElementLocator(prop.getProperty("dataT.TestCheckButton"));
	By addNewCheckButton = getElementLocator(prop.getProperty("dataT.AddCheckButton"));
	By checknode = getElementLocator(prop.getProperty("dataT.Checknode"));
	By addButtonchecktab = getElementLocator(prop.getProperty("dataT.AddCheck_Checktab"));
	By newCheckButtonchecktab = getElementLocator(prop.getProperty("dataT.NewCheckButton_Checktab"));
	By testTitle = getElementLocator(prop.getProperty("dataT.TestTitle"));
	By testColumnHeader = getElementLocator(prop.getProperty("dataT.TestColumn"));
	By testValueHeader = getElementLocator(prop.getProperty("dataT.TestValue"));
	By testColumnInput = getElementLocator(prop.getProperty("dataT.TestColumnInput"));
	By testValueInput = getElementLocator(prop.getProperty("dataT.TestValueInput"));
	By testExecuteButton = getElementLocator(prop.getProperty("dataT.TestExecuteButton"));
	By testClearButtonBy = getElementLocator(prop.getProperty("dataT.TestClearButton"));
	By testOutput = getElementLocator(prop.getProperty("dataT.TestOutput"));
	By attributeInput = getElementLocator(prop.getProperty("dataT.AttributeColumnInput"));
	By attributeOperatorInput = getElementLocator(prop.getProperty("dataT.AttributeOperatorInput"));
	By attributeOperatorDD = getElementLocator(prop.getProperty("dataT.OperatorDropDown"));
	By operatorValue1 = getElementLocator(prop.getProperty("dataT.Value1Input"));
	By operatorValue2 = getElementLocator(prop.getProperty("dataT.Value2Input"));
	By ignorenulls = getElementLocator(prop.getProperty("dataT.IgnoreNullsCheckbox"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By exceptionReportNode1 = getElementLocator(prop.getProperty("dataT.ExceptionReportNode"));
	By tabTitle = getElementLocator(prop.getProperty("dataT.ExceptionReportTab"));
	By exportfiletitle = getElementLocator(prop.getProperty("dataT.ExportFileformatTitle"));
	By exportfileFieldBox = getElementLocator(prop.getProperty("datT.ExportFileField"));
	By exportFileDropdownArrow = getElementLocator(prop.getProperty("dataT.ExportfileDropdown"));
	By exportFileDrowdownList = getElementLocator(prop.getProperty("dataT.ExportFileList"));
	By enableStoreFailureErrorsOnly = getElementLocator(prop.getProperty("dataT.EnableStoreFailureNErrors"));
	By enableStoreExportedFileOnly = getElementLocator(prop.getProperty("dataT.EnableStoreCheckbox"));
	By storeOnlyTitle = getElementLocator(prop.getProperty("dataT.StoreOnlyTitle"));
	By storeOnlyLabel = getElementLocator(prop.getProperty("DataTesting.StoreOnlyLabel"));
	By storeExportedFileCheckboxDisabeEnable = getElementLocator(
			prop.getProperty("DataTesting.StoreExportedFileCheckboxDisabeEnable"));

	By storeOnlyField = getElementLocator(prop.getProperty("dataT.StoreOnlyField"));
	By rowsTitle = getElementLocator(prop.getProperty("dataT.Rowstitle"));
	By exceptionReportRows = getElementLocator(prop.getProperty("dataT.exceptionReportRows"));
	By head = getElementLocator(prop.getProperty("dataT.exceptionColHead"));
	By expressionTypeList = getElementLocator(prop.getProperty("datT.ExpressionTypeList"));
	By diffJoinDetails = getElementLocator(prop.getProperty("dataT.DiffJoinDetails"));
	By discardButtons = getElementLocator(prop.getProperty("dataT.discardButton"));
	By numOfEx = getElementLocator(prop.getProperty("dataT.numOfex"));
	By chksum_target_colHeader = getElementLocator(prop.getProperty("dataT.Checksum.target.data.columnHeader"));
	By chksum_source_colHeader = getElementLocator(prop.getProperty("dataT.Checksum.Source.data.columnHeader"));
	By chksum_chk_deafultExp = getElementLocator(prop.getProperty("dataT.Checksum.check.defaultExp"));
	By sourceNodeClick = getElementLocator(prop.getProperty("dataT.Source.NodeClick"));
	By targetNodeClick = getElementLocator(prop.getProperty("dataT.Target.NodeClick"));
	By checksum_checkNode_click = getElementLocator(prop.getProperty("dataT.checkNode.checksum.Click"));
	By check_custCol_textarea = getElementLocator(prop.getProperty("dataT.check.AddCustChk.Textarea"));
	By check_AddCheck_btn = getElementLocator(prop.getProperty("dataT.CustCheck.AddChk.paneBtn"));
	By check_UpdateCheck_btn = getElementLocator(prop.getProperty("dataT.CustCheck.UpdateChk.paneBtn"));
	By ruleTab = getElementLocator(prop.getProperty("Rule.Tab"));

	By check_CustChk_Test_btn = getElementLocator(prop.getProperty("dataT.CustCheck.AddChk.TestBtn"));
	By check_CustChk_headerlbl = getElementLocator(prop.getProperty("dataT.CustCheck.AddPane.labelHeader"));
	By custom_Check_pane_inputBox = getElementLocator(prop.getProperty("dataT.CustCheck.CustomCheckPane.Input"));
	By recentRun_firstrun_status = getElementLocator(prop.getProperty("dataT.RecentRun.table.status.firstRun"));
	By recentrun_latest_statusofrule = getElementLocator(prop.getProperty("dataT.recentRun.topRow.status"));
	By recentrun_latest_instanceId = getElementLocator(prop.getProperty("dataT.recentRun.topRow.instanceID"));
	By recentrun_latest_instanceId_link = getElementLocator(prop.getProperty("dataT.recentRun.topRow.instanceID.link"));
	By recentrun_latest_exitCode = getElementLocator(prop.getProperty("dataT.recentRun.topRow.ExitCode"));
	By recentRunSourceCount = getElementLocator(prop.getProperty("dataT.recentRun.topRow.sourceCount"));
	By recentRunTartgetCount = getElementLocator(prop.getProperty("dataT.recentRun.topRow.targetCount"));
	By recentRunExitCode = getElementLocator(prop.getProperty("dataT.recentRun.topRow.ExitCode"));
	By recentRunElapsedTime = getElementLocator(prop.getProperty("dataT.recentRun.topRow.ElapsedTime"));

	By choosePatternLabel = getElementLocator(prop.getProperty("dataT.ChoosePatternLabel"));
	By listOfPatternChip = getElementLocator(prop.getProperty("dataT.ChoosePatternChipValues"));
	By choosePatternRegexlabel = getElementLocator(prop.getProperty("dataT.ChoosePatternRegexLabel"));
	By choosePatternRegexStar = getElementLocator(prop.getProperty("dataT.ChoosePatternRegexStar"));
	By choosePatternCustomInput = getElementLocator(prop.getProperty("dataT.ChoosePatternCustomInput"));
	By chooseFormatlabel = getElementLocator(prop.getProperty("dataT.ChooseFormat"));
	By chooseFormatInput = getElementLocator(prop.getProperty("dataT.ChooseFormatInput"));
	By chooseFormatDropdown = getElementLocator(prop.getProperty("dataT.ChooseFormatDropDown"));
	By chooseFormatDropdownlist = getElementLocator(prop.getProperty("dataT.ChooseFormatDropDownList"));
	By customFormatLabel = getElementLocator(prop.getProperty("dataT.CustomFormatlabel"));
	By customFormatInput = getElementLocator(prop.getProperty("dataT.CustomFormatInput"));
	By newCustomChecklabel = getElementLocator(prop.getProperty("dataT.NewCustomCheckLabel"));
	By checkTestValue1 = getElementLocator(prop.getProperty("dataT.TestValueInput1"));
	By checkTestValue2 = getElementLocator(prop.getProperty("datT.TestValueInput2"));
	By deleteHeader = getElementLocator(prop.getProperty("dataT.DeleteHeader"));
	By deleteText = getElementLocator(prop.getProperty("dataT.DeleteText"));
	By deleteCancelBtn = getElementLocator(prop.getProperty("dataT.DeleteCancelButton"));
	By deleteDelBtn = getElementLocator(prop.getProperty("dataT.DeleteDelButton"));
	By sourceSchemaSaveButton = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceSchemaSaveButton"));
	By targetSchemaSaveButton = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetSchemaSaveButton"));
	By checkboxs = getElementLocator(prop.getProperty("dataT.checkbox"));
	By deleteButtoninsideRule = getElementLocator(prop.getProperty("dataT.DeleteButtonInsideRuleDetails"));
	By choosedataTypeLabel = getElementLocator(prop.getProperty("dataT.ChooseDatatypeLabel"));
	By choosedatatypeField = getElementLocator(prop.getProperty("dataT.ChooseDatatypeInputField"));
	By choosedatatypeDDlist = getElementLocator(prop.getProperty("dataT.ChooseDatatypeList"));
	By choosedatatypeDateFormatDD = getElementLocator(prop.getProperty("dataT.ChooseDatatypeDateFormatDD"));
	By chooseDatatypeDateFormatDDlist = getElementLocator(
			prop.getProperty("dataT.ChooseDatatypeDateFormatDropDownList"));
	By choosedatatypeDateCustomFormatlabel = getElementLocator(
			prop.getProperty("dataT.ChooseDatatypeCustomDateFormatLabel"));
	By choosedatatypedateCustomFormatInput = getElementLocator(
			prop.getProperty("dataT.ChooseDatatypeCustomDateFormatInput"));
	By chooseAttributeSearchField = getElementLocator(prop.getProperty("dataT.ChooseAttributeSearchField"));
	By chooseAttributeExpressionSection = getElementLocator(prop.getProperty("dataT.ChooseAttributeExpressionSection"));
	By chooseAttributeOperatorSymbolButton = getElementLocator(
			prop.getProperty("dataT.ChooseAttributeOperatorSymbolButton"));
	By chooseAttributeTextArea = getElementLocator(prop.getProperty("dataT.ChooseAttributeTextArea"));
	By simpleFormatLabel = getElementLocator(prop.getProperty("dataT.SimpleFormatLabel"));
	By selectColumnDDForIF = getElementLocator(prop.getProperty("dataT.SelectColumnDDForIF"));
	By selectColumnDDForThen = getElementLocator(prop.getProperty("dataT.SelectColumnDDForThen"));
	By selectColumnDDForElse = getElementLocator(prop.getProperty("dataT.SelectColumnDDForElse"));
	By selectOperatorDDForIF = getElementLocator(prop.getProperty("dataT.SelectOperatorDDForIF"));
	By selectOperatorDDForThen = getElementLocator(prop.getProperty("dataT.SelectOperatorDDForThen"));
	By selectOperatorDDForElse = getElementLocator(prop.getProperty("dataT.SelectOperatorDDForElse"));
	By selectValueForIF = getElementLocator(prop.getProperty("dataT.SelectValueForIF"));
	By selectValueForThen = getElementLocator(prop.getProperty("dataT.SelectValueForThen"));
	By selectValueForElse = getElementLocator(prop.getProperty("dataT.SelectValueForElse"));
	By folderList = getElementLocator(prop.getProperty("RuleRepo.FolderList"));
	By dropDownBox = getElementLocator(prop.getProperty("RuleRepo.DropDownBox"));
	public By dropDownBox1 = getElementLocator(prop.getProperty("RuleRepo.DropDownBox1"));
	By publishButton = getElementLocator(prop.getProperty("DataTesting.PublishButton"));
	By discardButton = getElementLocator(prop.getProperty("dataT.discardButton"));
	By moreButton = getElementLocator(prop.getProperty("DataTesting.MoreButton"));
	By discardDetailButton = getElementLocator(prop.getProperty("DataTesting.DiscardDetailButton"));

	By addConditionPlusSignIF = getElementLocator(prop.getProperty("dataT.AddConditionPlusSignIF"));
	By addConditionPlusSignThen = getElementLocator(prop.getProperty("dataT.AddConditionPlusSignThen"));
	By addConditionPlusSignElse = getElementLocator(prop.getProperty("dataT.AddConditionPlusSignElse"));
	By recentrun_ExecutionLogBtn = getElementLocator(prop.getProperty("dataT.recentrun.executionLog.btn"));
	By recentrun_ExecutionLog_recentlogbox = getElementLocator(
			prop.getProperty("dataT.recentrun.executionLog.dialogBox"));
	By recentrun_ExecutionLog_Summary = getElementLocator(prop.getProperty("dataT.recentrun.executionLog.textarea"));
	By resultTypeDetailsInException = getElementLocator(prop.getProperty("dataT.ResultTypeInException"));
	By scolVal_NoRecord = getElementLocator(prop.getProperty("dataT.source.dataTab.table.column.nodata"));
	By scolVal_ColName = getElementLocator(prop.getProperty("dataT.source.dataTab.table.columnName"));
	By scolVal_Coldatatype = getElementLocator(prop.getProperty("dataT.source.dataTab.table.column.Datatype"));
	By tcolVal_NoRecord = getElementLocator(prop.getProperty("dataT.target.dataTab.table.column.nodata"));
	By tcolVal_ColName = getElementLocator(prop.getProperty("dataT.target.dataTab.table.columnName"));
	By tcolVal_Coldatatype = getElementLocator(prop.getProperty("dataT.target.dataTab.table.column.Datatype"));
	By scolVal_ColName_chk = getElementLocator(prop.getProperty("dataT.source.dataTab.table.columnName.checksum"));
	By scolVal_ColDataType_chk = getElementLocator(
			prop.getProperty("dataT.source.dataTab.table.columnDataType.checksum"));
	By tcolVal_ColName_chk = getElementLocator(prop.getProperty("dataT.tource.dataTab.table.columnName.checksum"));
	By tcolVal_ColDataType_chk = getElementLocator(
			prop.getProperty("dataT.tource.dataTab.table.columnDataType.checksum"));
	By source_tablePreview = getElementLocator(prop.getProperty("dataT.source.tablePreview"));
	By checksum_default_expName = getElementLocator(prop.getProperty("dataT.Checksum.check.defaultExp.Name"));
	By checksum_default_expType = getElementLocator(prop.getProperty("dataT.Checksum.check.defaultExp.Type"));

	// new add column elements
	By recentRun_Search_rowCount = getElementLocator(prop.getProperty("dataT.recentRun.search.Multiresult.rowCount"));
	By recentRun_search_multi_instanceIDs = getElementLocator(
			prop.getProperty("dataT.recentRun.search.Multiresult.insID"));
	By ruleExecutionState = getElementLocator(prop.getProperty("dataT.DataTesting.summaryExecutionState"));
	By ruleExecutionStateTitle = getElementLocator(prop.getProperty("dataT.DataTesting.summaryExecutionStatetitle"));
	By checksum_default_expStatus = getElementLocator(prop.getProperty("dataT.Checksum.check.defaultExp.Status"));
	By checksTitle = getElementLocator(prop.getProperty("dataT.ChecksTabTitle"));
	By scriptTextAreaField = getElementLocator(prop.getProperty("dataT.ScriptRule.Textarea"));
	By scriptAddConnBtn = getElementLocator(prop.getProperty("dataT.ScriptRule.AddConnectionButton"));
	By connVarNameInput = getElementLocator(prop.getProperty("dataT.ScriptRule.ConnVarNameInput"));
	By scriptParseButton = getElementLocator(prop.getProperty("dataT.ScriptRule.ParseButton"));
	By pushdown_allExpName = getElementLocator(prop.getProperty("dataT.check.pushdown.allcol.exp"));
	By pushdown_allChkName = getElementLocator(prop.getProperty("dataT.check.pushdown.allcol.chkname"));
	By ruleNameText = getElementLocator(prop.getProperty("DataTesting.RuleNameText"));
	By connectionTabOnScript = getElementLocator(prop.getProperty("DataTesting.ConnectionTabOnScript"));

	By publishBtn = getElementLocator(prop.getProperty("dataT.Rule.PublishBtn"));
	By validateBtn = getElementLocator(prop.getProperty("dataT.Rule.ValidateBtn"));
	By draftBtn = getElementLocator(prop.getProperty("dataT.Rule.DraftBtn"));
	By saveOptionDropDown = getElementLocator(prop.getProperty("dataT.Rule.SaveListDDBtn"));
	By checksStatusList = getElementLocator(prop.getProperty("dataT.Checks.ActivePopUpList"));
	By newRuleCancelBtn = getElementLocator(prop.getProperty("dataT.NewRuleSideBar.CancelButton"));
	public By checkNameNoRecord = getElementLocator(
			prop.getProperty("dataT.ExceptionReport.Summary.CheckNameNoRecord"));
	By sidebarCloseIcon = getElementLocator(prop.getProperty("dataT.Sidebars.CloseIcon"));
	By checks_SaveAndNextBtn = getElementLocator(prop.getProperty("dataT.SaveAndNextButton.Checks"));
	By discardPopUpCancelButton = getElementLocator(prop.getProperty("dataT.DiscardPupupCancelButton"));
	By checkNameLocator = getElementLocator(prop.getProperty("dataT.Checks.Sidebar.On.LandingPage"));
	By fileLayout = getElementLocator(prop.getProperty("DataTesting.FileLayout"));
	By deletePopupDeleteBtn = getElementLocator(prop.getProperty("dataT.Checks.DeletePopup.DeleteBtn"));
	By sourceSettingTab = getElementLocator(prop.getProperty("dataT.sourceSetting.tab"));
	By targetSettingTab = getElementLocator(prop.getProperty("dataT.targetSetting.tab"));
	By sourcecolumnclearbtn = getElementLocator(prop.getProperty("dataTesting.sourcecolumnclearbtn"));
	By calculatedcolumnsearchBar = getElementLocator(prop.getProperty("DataTesting.calculatedcolumnsearchBar"));
	By calculatedcolumnsearchbtn = getElementLocator(prop.getProperty("DataTesting.calculatedcolumnsearchbtn"));
	By calculatedChangecolumnbtn = getElementLocator(prop.getProperty("dataTesting.calculatedChangecolumnbtn"));
	By CloseIcon = getElementLocator(prop.getProperty("dataT.Sidebars.CloseIcon"));
	By calculatedcolumnsavebtn = getElementLocator(prop.getProperty("dataTesting.calculatedcolumnsavebtn"));
	By calculatedcolumnsaveandNextbtn = getElementLocator(
			prop.getProperty("dataTesting.calculatedcolumnsaveandNextbtn"));
	By xmlTableNameEdit = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlTableNameEdit"));
	By xmlTableCancelButton = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlTableCancelButton"));

	By listOfActiveResultType = getElementLocator(prop.getProperty("DataTesting.ListOfActiveResultType"));
	By noRecordToDisplayMess = getElementLocator(prop.getProperty("DataTesting.NoRecordToDisplayMess"));

	By doneBtn = getElementLocator(prop.getProperty("DataTesting.DoneBtn"));
	By folderCopyMoveNoteMess = getElementLocator(prop.getProperty("DataT.FolderCopyMoveNoteMess"));
	By copyButton = getElementLocator(prop.getProperty("DataT.CopyButton"));
	By moveButton = getElementLocator(prop.getProperty("DataT.MoveButton"));
	By bulkDeleteButton = getElementLocator(prop.getProperty("DataTesting.BulkDeleteButton"));
	By bulkDeletePane = getElementLocator(prop.getProperty("DataTesting.BulkDeletePane"));
	By bulkDeleteLog = getElementLocator(prop.getProperty("DataTesting.BulkDeleteLog"));
	By landingPageRefreshButton = getElementLocator(prop.getProperty("DataTesting.LandingPageRefreshButton"));

	By buttonCancel = getElementLocator(prop.getProperty("DataT.CancelButton"));
	By copyMoveFolderSearchClick = getElementLocator(prop.getProperty("DataT.CopyMoveFolderSearchClick"));
	By copyMoveFolderSearchSendKey = getElementLocator(prop.getProperty("DataT.CopyMoveFolderSearchSendKey"));
	By copyMoveFolderSearchBarClick = getElementLocator(prop.getProperty("DataT.CopyMoveFolderSearchBarClick"));
	By selectedFolderGetText = getElementLocator(prop.getProperty("DataT.SelectedFolderGetText"));
	By copyMoveLogText = getElementLocator(prop.getProperty("DataT.CopyMoveLogText"));
	By copyMoveLogCopyToClipboard = getElementLocator(prop.getProperty("DataTesting.CopyMoveLogCopyToClipboard"));
	By copyMoveLogReferesh = getElementLocator(prop.getProperty("DataTesting.CopyMoveLogReferesh"));
	By removeAppliedFilter = getElementLocator(prop.getProperty("DataTesting.RemoveAppliedFilter"));

	By lengthOperatorField = getElementLocator(prop.getProperty("dataT.OperatorField"));
	By deleteChecksButton = getElementLocator(prop.getProperty("dataT.Checks.DeleteButton"));
	By checksDeletePopupTitle = getElementLocator(prop.getProperty("dataT.Checks.DeletePopup.title"));
	By checksDeletePopupContent = getElementLocator(prop.getProperty("dataT.Checks.DeletePopup.content"));
	By checksDeletePopupDeleteBtn = getElementLocator(prop.getProperty("dataT.Checks.DeletePopup.DeleteBtn"));
	By checksDeletePopupCancelBtn = getElementLocator(prop.getProperty("dataT.Checks.DeletePopup.CancelBtn"));
	By checksCrossIcon = getElementLocator(prop.getProperty("dataT.Checks.CrossIcon"));
	By checksTestAttribute = getElementLocator(prop.getProperty("dataT.Checks.Test.AttributeName"));
	By checksTestValueField = getElementLocator(prop.getProperty("dataT.Checks.Test.ValueField"));
	By checksTestExecuteButton = getElementLocator(prop.getProperty("dataT.Checks.Test.ExecuteButton"));
	By checksTestClearButton = getElementLocator(prop.getProperty("dataT.Checks.Test.ClearButton"));
	By checksTestOutputTitle = getElementLocator(prop.getProperty("dataT.Checks.Test.TestOutputTitle"));
	By checksTestOutputValue = getElementLocator(prop.getProperty("dataT.Checks.Test.TestOutputValue"));
	By discardPopupTitle = getElementLocator(prop.getProperty("dataT.DiscardPopupTitle"));
	By checksHeadingTitle = getElementLocator(prop.getProperty("dataT.Checks.Sidebar.Heading"));
	By sourceTrimDataCheckBox = getElementLocator(prop.getProperty("DataTesting.SourceTrimDataCheckBox"));
	By sourceOverrideLayoutCheckBox = getElementLocator(prop.getProperty("DataTesting.SourceOverrideLayoutCheckBox"));
	By targetOverrideLayoutCheckBox = getElementLocator(prop.getProperty("DataTesting.TargetOverrideLayoutCheckBox"));
	By sourceOverrideLayout = getElementLocator(prop.getProperty("DataTesting.SourceOverrideLayout"));
	By sourceEmptyStringisNULLCheckbox = getElementLocator(
			prop.getProperty("DataTesting.SourceEmptyStringisNULLCheckbox"));
	By sourceWhiteSpaceisNULLCheckbox = getElementLocator(
			prop.getProperty("DataTesting.SourceWhiteSpaceisNULLCheckbox"));
	By sourceFixedStringCheckbox = getElementLocator(prop.getProperty("DataTesting.SourceFixedStringCheckbox"));
	By targetFixedStringCheckbox = getElementLocator(prop.getProperty("DataTesting.TargetFixedStringCheckbox"));
	By sourceIsSortedCheckBox = getElementLocator(prop.getProperty("DataTesting.SourceIsSortedCheckBox"));
	By sourceIsSorted = getElementLocator(prop.getProperty("DataTesting.SourceIsSorted"));
	By sourceCaseSensitiveCheckBox = getElementLocator(prop.getProperty("DataTesting.SourceCaseSensitiveCheckBox"));
	By sourceCaseSensitive = getElementLocator(prop.getProperty("DataTesting.SourceCaseSensitive"));
	By checkPaneOpenSection = getElementLocator(prop.getProperty("DataTesting.CheckPaneOpenSection"));
	By checkPaneNameSection = getElementLocator(prop.getProperty("DataTesting.CheckPaneNameSection"));
	By sourceDropdown = getElementLocator(prop.getProperty("DataTesting.SourceDropdown"));
	By functionDropdown = getElementLocator(prop.getProperty("DataTesting.FunctionDropdown"));
	By checkTableEditButton = getElementLocator(prop.getProperty("DataTesting.CheckTableEditButton"));
	By checkTableDeactiveButton = getElementLocator(prop.getProperty("DataTesting.CheckTableDeactiveButton"));
	By checkTableDeleteButton = getElementLocator(prop.getProperty("DataTesting.CheckTableDeleteButton"));
	By exportFileRowLimit = getElementLocator(prop.getProperty("DataTesting.ExportFileRowLimit"));

	By sourceIncludeHeadersCheckbox = getElementLocator(prop.getProperty("DataTesting.SourceIncludeHeadersCheckbox"));
	By sourceIncludeHeaders = getElementLocator(prop.getProperty("DataTesting.SourceIncludeHeaders"));
	By targetIncludeHeaders = getElementLocator(prop.getProperty("DataTesting.TargetIncludeHeaders"));
	By targetIncludeHeadersCheckbox = getElementLocator(prop.getProperty("DataTesting.TargetIncludeHeadersCheckbox"));

	By summaryVariableTex = getElementLocator(prop.getProperty("DataTesting.SummaryVariableText"));
	By summaryFormulaText = getElementLocator(prop.getProperty("DataTesting.SummaryFormulaText"));
	By summaryOverrideExitCode = getElementLocator(prop.getProperty("DataTesting.SummaryOverrideExitCode"));
	By summaryEditButton = getElementLocator(prop.getProperty("DataTesting.SummaryEditButton"));
	By summaryDeleteButton = getElementLocator(prop.getProperty("DataTesting.SummaryDeleteButton"));

	By propertyDropdown = getElementLocator(prop.getProperty("DataTesting.Rule.PropertyDropdown"));
	String propertyDropdownValue = prop.getProperty("DataTesting.Rule.PropertyDropdownValue");

	By xmlTableSaveButton = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlTableSaveButton"));
	By rowCountButton = getElementLocator(prop.getProperty("DataTesting.RowCountButton"));
	By targetIsSortedCheckBox = getElementLocator(prop.getProperty("DataTesting.TargetIsSortedCheckBox"));
	By targetIsSorted = getElementLocator(prop.getProperty("DataTesting.TargetIsSorted"));
	By targetCaseSensitiveCheckBox = getElementLocator(prop.getProperty("DataTesting.TargetCaseSensitiveCheckBox"));
	By targetCaseSensitive = getElementLocator(prop.getProperty("DataTesting.TargetCaseSensitive"));
	By targetDropdown = getElementLocator(prop.getProperty("DataTesting.TargetDropdown"));
	By sourceTableList = getElementLocator(prop.getProperty("RuleRepo.SourceTableList"));
	By targetTableList = getElementLocator(prop.getProperty("RuleRepo.TargetTableList"));
	By checksAndClumnsLabel = getElementLocator(prop.getProperty("DataTesting.ChecksAndClumnsLabel"));
	By downloadingLoader = getElementLocator(prop.getProperty("DataTesting.DownloadingLoader"));
	By resultTypeList = getElementLocator(prop.getProperty("DataTesting.ResultTypeList"));
	By folderMoveHover = getElementLocator(prop.getProperty("DataT.FolderMoveHover"));
	By checkNoRecordCheckMess = getElementLocator(prop.getProperty("DataTesting.CheckNoRecordCheckMess"));

	// **************************************String
	// Variables************************************************************************************

	String ruleIdText = prop.getProperty("DataTesting.RuleIdText");
	String checksumSourceColumnName = prop.getProperty("DataTesting.ChecksumSourceColumnName");
	String sourceFunction = prop.getProperty("DataTesting.SourceFunction");
	String targetFunction = prop.getProperty("DataTesting.TargetFunction");

	String checksumTargetColumnName = prop.getProperty("DataTesting.ChecksumTargetColumnName");
	String scriptConnectionVariableName = prop.getProperty("DataTesting.ScriptConnectionVariableName");
	String scriptConnectionName = prop.getProperty("DataTesting.ScriptConnectionName");
	String scriptConnectionId = prop.getProperty("DataTesting.ScriptConnectionId");

	String sourceJoinApplied = prop.getProperty("DataTesting.SourceJoinApplied");
	String targetJoinApplied = prop.getProperty("DataTesting.TargetJoinApplied");

	String breadCrumbNameExceptionReport = prop.getProperty("DataTesting.BreadCrumbNameExceptionReport");
	String clickOnCheckName = prop.getProperty("dataT.ClickOnCheckName");
	String updateResultType = prop.getProperty("DataTesting.UpdateResultType");
	String ruleType = prop.getProperty("DataTesting.JsonExpression.RuleType");
	String workspaceId = prop.getProperty("DataTesting.JsonExpression.WorkspaceId");
	String folderCheckBox = prop.getProperty("DataTesting.FolderCheckBox");
	String ruleFolderText = prop.getProperty("DataTesting.RuleFolderText");
	String folderNameClick = prop.getProperty("DataT.FolderNameClick");
	String folderNameClickSelectButton = prop.getProperty("DataT.FolderNameClickSelectButton");
	String advanceFolderNameClick = prop.getProperty("DataTesting.AdvanceFolderNameClick");
	String discardContent = prop.getProperty("string.discardContent");

	String checkNameOnExceptionReportTab = prop.getProperty("DataTesting.CheckNameOnExceptionReportTab");
	String expressionNameOnExceptionReportTab = prop.getProperty("DataTesting.ExpressionNameOnExceptionReportTab");
	String expressionStatusOnExceptionReportTab = prop.getProperty("DataTesting.ExpressionStatusOnExceptionReportTab");
	String expressionShowOnExceptionReportTab = prop.getProperty("DataTesting.ExpressionShowOnExceptionReportTab");
	String refreshContent = prop.getProperty("string.refreshContent");
	String ruleDuplicateMess = prop.getProperty("DataTesting.RuleDuplicateMess");
	String ruleCopyMess = prop.getProperty("DataTesting.RuleCopyMess");
	String sourceTargetJoinText = prop.getProperty("DataTesting.SourceTargetJoinText");
	String datasetInput = prop.getProperty("DataTesting.DatasetInput");
	String operatorOption = prop.getProperty("DataTesting.OperatorOption");
	String customTargetColumnName = prop.getProperty("DataTesting.CustomTargetColumnName");
	String customSorceColumnName = prop.getProperty("DataTesting.CustomSorceColumnName");

	String customSorceColumnNameTranslate = prop.getProperty("DataTesting.CustomSorceColumnNameTranslate");
	String customTargetColumnNameTranslate = prop.getProperty("DataTesting.CustomTargetColumnNameTranslate");

	String dataQualityDimensionValue = prop.getProperty("DataTesting.DataQualityDimensionValue");
	String selectButton = prop.getProperty("DataTesting.SelectButton");
	String checkColumnCheck = prop.getProperty("DataT.ExceptionReport.Summary.CheckColumnCheck");
	String folderCreatedMessText = prop.getProperty("DataTesting.FolderCreatedMessText");
	String note = prop.getProperty("dataT.Note");
	String ruleListMsg = prop.getProperty("dataT.RuleListMsg");
	String ruleNameLink = prop.getProperty("dataT.RuleNameLink");
	String ruleNameLinkWithoutFolder = prop.getProperty("dataT.RuleNameLinkWithoutFolder");

	String ruleNameCheckbox = prop.getProperty("dataT.RuleNameCheckbox");
	String nextGenMenuTab = prop.getProperty("dataT.NextGenTab");
	String ruleDetailsMsg = prop.getProperty("dataT.RuleDetailMsg");
	String status_Draft = prop.getProperty("darftStatus");
	String status_Validate = prop.getProperty("validateStatus");
	String status_Publish = prop.getProperty("publishedStatus");
	public String toastMessageAfterSaveListOptions = prop.getProperty("dataT.MessageAfterSaveMenuOption");
	public String errorMessage = prop.getProperty("dataT.RunErrorMsg");
	String toastMessageAfterRunBtnClicked = prop.getProperty("dataT.MessageAfterRunBtnClick");
	String recentRun_getStatus_usingInstanceId = prop.getProperty("dataT.RecentRun.table.row.getStatusInst");
	String recentRun_SearchusingInstanceId = prop.getProperty("dataT.RecentRun.table.row.instanceId");
	String recentRun_GetExistCodeusingInstanceId = prop.getProperty("dataT.RecentRun.table.row.getExistCodeInst");
	String recentRun_GetInstanceIdUsingStatus = prop.getProperty("dataT.RecentRun.table.status");
	String ruleResultType = prop.getProperty("dataT.check.resultType.comman");
	String check_addCol_sidebar_columToChoose_chkbox = prop.getProperty("dataT.check.AddCol.sidebar.column.checkbox");
	String check_addCol_sidebar_columToChoose = prop.getProperty("dataT.check.AddCol.sidebar.column");
	String check_addedCol_expression = prop.getProperty("dataT.check.AddCol.Expression");
	String check_addedCol_colName = prop.getProperty("dataT.check.AddCol.ColName");
	String check_custCol_sourceExp = prop.getProperty("dataT.check.AddCustChk.sourceExpandIcon");
	String check_custCol_targetExp = prop.getProperty("dataT.check.AddCustChk.targetExpandIcon");
	String check_custCol_source_col = prop.getProperty("dataT.check.AddCustChk.Source.colSelection");
	String check_custCol_target_col = prop.getProperty("dataT.check.AddCustChk.Target.colSelection");
	String check_custCol_addedExp = prop.getProperty("dataT.check.custCheck.addedExp");
	String check_added_customExpression = prop.getProperty("dataT.check.custChek.AddedExpCheck");
	String check_CustCheck_CloseBtn = prop.getProperty("dataT.check.AddCustChk.CloseBtn");
	String sourceDatasetConnectionTypeSelect = prop.getProperty("RuleRepo.SourceDatasetConnectionTypeSelect");
	String sourceDatasetInput = prop.getProperty("RuleRepo.SourceDatasetInput");
	String targetDatasetInput = prop.getProperty("RuleRepo.TargetDatasetInput");
	String sourceDatasetConnectionSelect = prop.getProperty("RuleRepo.SourceDatasetConnectionSelect");
	String sourceDatasetSchemaSelect = prop.getProperty("RuleRepo.SourceDatasetSchemaSelect");
	String sourceDatasetTableSelect = prop.getProperty("RuleRepo.SourceDatasetTableSelect");
	String sourceDatasetSetFileTypeSelect = prop.getProperty("RuleRepo.SourceDatasetSetFileTypeSelect");
	String connectionTypeMess = prop.getProperty("RuleRepo.ConnectionTypeMess");
	String connectionMess = prop.getProperty("RuleRepo.ConnectionMess");
	String schemaMess = prop.getProperty("RuleRepo.SchemaMess");
	String selectFileFolder = prop.getProperty("RuleRepo.SelectFileFolder");
	String selectFile = prop.getProperty("RuleRepo.SelectFile");
	String connectionTestMess = prop.getProperty("RuleRepo.ConnectionTestMess");
	String joinSourceColName = prop.getProperty("RuleRepo.JoinSourceColName");
	String joinTargetColName = prop.getProperty("RuleRepo.JoinTargetColName");
	String joinSourceColNameTranslate = prop.getProperty("RuleRepo.JoinSourceColNameTranslate");
	String joinTargetColNameTranslate = prop.getProperty("RuleRepo.JoinTargetColNameTranslate");

	String newCheckNamebutton = prop.getProperty("dataT.NewCheckName");
	String checkTitleLabel = prop.getProperty("dataT.CheckTitle");
	String selectdimansion = prop.getProperty("dataT.SelectDimension");
	String ruleProcessedmsg = prop.getProperty("dataT.RuleProcessMsg");
	String checkNametable = prop.getProperty("dataT.CheckNameIntable");
	String checkdetails = prop.getProperty("dataT.CheckRow");
	String chooseOperator = prop.getProperty("dataT.OperatorDropdownlist");
	String tdxpath = prop.getProperty("dataT.tdsXpaths");
	String spanxpath = prop.getProperty("dataT.spans");
	String visiblecheckbox = prop.getProperty("dataT.visibleCheckbox");
	String statusOfCheck = prop.getProperty("dataT.CheckNameList");
	String expressionDetails = prop.getProperty("dataT.ExpressionDetails");
	String getDataMess = prop.getProperty("RuleRepo.GetDataMess");
	String check_CustCheck_addedExp = prop.getProperty("dataT.CustCheck.Added.exp");
	String check_CustCheck_addedExp_checkType = prop.getProperty("dataT.CustCheck.Added.exp.addedType");
	String check_CustCheck_addedExp_checkName = prop.getProperty("dataT.CustCheck.Added.exp.addedChkName");
	String check_CustCheck_addedExp_checkStatus = prop.getProperty("dataT.CustCheck.Added.exp.addedChkStatus");
	String chooseDatatypeDateFormatInput = prop.getProperty("dataT.ChooseDatatypeDateFormatSelect");
	String selectChooseDatatype = prop.getProperty("dataT.ChooseDatatypeInputValue");
	String selectColumnFormat = prop.getProperty("dataT.SelectColumnFormat");
	String selectOperatorFormat = prop.getProperty("dataT.SelectOperatorFormat");
	String newPredefineTitle = prop.getProperty("dataT.NewPredefineCheckTitle");
	String selectColumnDDForIF1 = prop.getProperty("dataT.SelectColumnDDForIF1");
	String selectColumnDDForThen1 = prop.getProperty("dataT.SelectColumnDDForThen1");
	String selectColumnDDForElse1 = prop.getProperty("dataT.SelectColumnDDForElse1");
	String selectOperatorDDForIF1 = prop.getProperty("dataT.SelectOperatorDDForIF1");
	String selectOperatorDDForThen1 = prop.getProperty("dataT.SelectOperatorDDForThen1");
	String selectOperatorDDForElse1 = prop.getProperty("dataT.SelectOperatorDDForElse1");
	String selectValueForIF1 = prop.getProperty("dataT.SelectValueForIF1");
	String selectValueForThen1 = prop.getProperty("dataT.SelectValueForThen1");
	String selectValueForElse1 = prop.getProperty("dataT.SelectValueForElse1");
	String selectConditionType = prop.getProperty("dataT.SelectConditionType");
	String addConditionTypeIF = prop.getProperty("dataT.AddConditionTypeIF");
	String addConditionTypeThen = prop.getProperty("dataT.AddConditionTypeThen");
	String addConditionTypeElse = prop.getProperty("dataT.AddConditionTypeElse");
	String exportFileType = prop.getProperty("dataT.ExportFileType");
	String cfilter = prop.getProperty("dataT.Filter");
	String coperator = prop.getProperty("dataT.Operator");
	String cvalue = prop.getProperty("dataT.value");
	String addAndCondition = prop.getProperty("dataT.AddANDConditionType");
	String addORCondition = prop.getProperty("dataT.AddORConditionType");
	String addGrp = prop.getProperty("dataT.AddGrp");
	String checkNameChecckBox = prop.getProperty("dataT.ExceptionReport.Summary.CheckNameChecckBox");
	String summaryDetails = prop.getProperty("dataT.ExceptionReport.Summary.Details");
	String ruleStatusOnExceptionReport = prop.getProperty("DataTesting.RuelStatusOnExceptionReport");
	String successUsersAdded = prop.getProperty("RuleRepo.SuccessUsersAdded");
	String failureUsersAdded = prop.getProperty("RuleRepo.FailureUsersAdded");
	String errorUsersAdded = prop.getProperty("RuleRepo.ErrorUsersAdded");
	String ruleNameCheckBox = prop.getProperty("DataTesting.RuleNameCheckBox");

	String summaryRulename = prop.getProperty("dataT.ExceptionReport.Summary.RuleNameLink");
	String summaryCheckname = prop.getProperty("dataT.ExceptionReport.Summary.CheckName");
	String summaryCheckDetails = prop.getProperty("dataT.ExceptionReport.Summary.CheckDetails");
	String summaryDiffjoin = prop.getProperty("dataT.ExceptionReport.Summary.DiffJoin");
	String summaryExportType = prop.getProperty("dataT.ExceptionReport.Summary.ExportType");
	String dataTestingSubModuleName = prop.getProperty("dataT.DataTesting.SubModuleName");
	String sourceNtSelectedMsg = prop.getProperty("DataTesting.sourceNotSeleted.msg");
	public String expNtAddedMsg = prop.getProperty("DataTesting.CheckExpNotAdded.msg");
	String connType = prop.getProperty("scripting.testdata.NRR549.ConnectionType");
	String connName = prop.getProperty("scripting.testdata.NRR549.ConnectionName");
	String customQuery = prop.getProperty("scripting.testdata.NRR549.CustomQuery");
	String sqlQueryDynamicSchemaReg = prop.getProperty("dataTesting.SqlQuery.SchemaChange.Regex");
	String dataTestingSubMenuTab = prop.getProperty("dataT.dataTesting.SubMenu.Tabs");
	String ruleRecentRunsTableCSSStyle = prop.getProperty("rule.recentRuns.Details.Table.cssStyle");
	String successStatusContent = prop.getProperty("string.successStatusContent");
	String warningStatusContent = prop.getProperty("string.warningStatusContent");
	String errorStatusContent = prop.getProperty("string.errorStatusContent");
	String skippedStatusContent = prop.getProperty("string.skippedStatusContent");
	String runningStatusContent = prop.getProperty("string.runningStatusContent");
	public String connectionsName = prop.getProperty("RuleRepo.ConnectionsName");
	By enableStoreExportedOnly = getElementLocator(prop.getProperty("DataT.EnableStoreExportedOnly"));
	By ruleNameOnExceptionReport = getElementLocator(prop.getProperty("DataTesting.RuelNameOnExceptionReport"));

	// Rahul's locators
	// for pushdown & validation rule
	By rulenameinnertext = getElementLocator(prop.getProperty("DataTesting.Rulenameinnertext"));
	By engineTypeinnerText = getElementLocator(prop.getProperty("DataTesting.EngineTypeinnerText"));
	By checksNameValidationError1 = getElementLocator(
			prop.getProperty("DataTesting.checks.checksNameValidationError1"));
	By checksNameValidationError2 = getElementLocator(
			prop.getProperty("DataTesting.checks.checksNameValidationError2"));
	By checksNameValidationError3 = getElementLocator(
			prop.getProperty("DataTesting.checks.checksNameValidationError3"));
	By addNewRuleText = getElementLocator(prop.getProperty("DataTesting.AddNewRuleText"));
	By workspacefolder = getElementLocator(prop.getProperty("DataTesting.Workspacefolder"));
	By engineTypeText = getElementLocator(prop.getProperty("DataTesting.EngineTypeText"));
	By chooseTemplateText = getElementLocator(prop.getProperty("DataTesting.ChooseTemplateText"));
	By cancelButton = getElementLocator(prop.getProperty("DataTesting.CancelButton"));
	By wksfoldertext = getElementLocator(prop.getProperty("DataTesting.wksfoldertext"));
	By enableOverrideExitCode = getElementLocator(prop.getProperty("DataTesting.EnableOverrideExitCode"));

	///////////////// ---------------------------/////////////////////////////////
	// new UI changes(overview)
	By overviewlabel = getElementLocator(prop.getProperty("DataTesting.Overviewlabel"));
	By rulenameLabel = getElementLocator(prop.getProperty("DataTesting.RulenameLabel"));
	By rulecodeLabel = getElementLocator(prop.getProperty("DataTesting.RulecodeLabel"));
	By descriptionLabel = getElementLocator(prop.getProperty("DataTesting.DescriptionLabel"));
	By purposeLabel = getElementLocator(prop.getProperty("DataTesting.PurposeLabel"));
	By criticalityLabel = getElementLocator(prop.getProperty("DataTesting.CriticalityLabel"));
	By advanceSettingLabel = getElementLocator(prop.getProperty("DataTesting.AdvanceSettingLabel"));
	By dopLabel = getElementLocator(prop.getProperty("DataTesting.DopLabel"));
	By stopAtRowLabel = getElementLocator(prop.getProperty("DataTesting.StopAtRowLabel"));
	By stopAtErrorLabel = getElementLocator(prop.getProperty("DataTesting.StopAtErrorLabel"));
	By stopAtAfterTimeLabel = getElementLocator(prop.getProperty("DataTesting.StopAtAfterTimeLabel"));
	By parameterLabel = getElementLocator(prop.getProperty("DataTesting.ParameterLabel"));
	By switchbtnLabel = getElementLocator(prop.getProperty("DataTesting.SwitchbtnLabel"));
	By ruleNameField = getElementLocator(prop.getProperty("DataTesting.RuleNameField"));
	By rulecodeField = getElementLocator(prop.getProperty("DataTesting.RulecodeField"));
	By descriptionField = getElementLocator(prop.getProperty("DataTesting.DescriptionField"));
	By purposeField = getElementLocator(prop.getProperty("DataTesting.PurposeField"));
	By criticalityclick = getElementLocator(prop.getProperty("DataTesting.Criticalityclick"));
	String criticalityselect = prop.getProperty("DataTesting.Criticalityselect");
	By dopField = getElementLocator(prop.getProperty("DataTesting.DopField"));
	By stopAtRowField = getElementLocator(prop.getProperty("DataTesting.StopAtRowField"));
	By stopAtErrorField = getElementLocator(prop.getProperty("DataTesting.StopAtErrorField"));
	By stopAfterTimeField = getElementLocator(prop.getProperty("DataTesting.StopAfterTimeField"));
	By switchbtn = getElementLocator(prop.getProperty("DataTesting.Switchbtn"));
	By parameterclick = getElementLocator(prop.getProperty("DataTesting.Parameterclick"));
	String parameterSelect = (prop.getProperty("DataTesting.ParameterSelect"));
	By parameterSearch = getElementLocator(prop.getProperty("DataTesting.ParameterSearch"));
	By srccolumnSearchbox = getElementLocator(prop.getProperty("dataTesting.srccolumnSearchbox"));
	By srccolumnSearchBtn = getElementLocator(prop.getProperty("dataTesting.srccolumnSearchBtn"));
	By closeCursor = getElementLocator(prop.getProperty("DataTesting.closeCursor"));
	By calculatedcolumnCancelbtn = getElementLocator(prop.getProperty("dataTesting.calculatedcolumnCancelbtn"));
	By sourceColumnLabel = getElementLocator(prop.getProperty("DataTesting.sourceColumnLabel"));
	By sourcecolumnaddbtn = getElementLocator(prop.getProperty("dataTesting.sourcecolumnaddbtn"));
	By changeColumnbtn = getElementLocator(prop.getProperty("DataTesting.changeColumnbtn"));
	By pageArrows1 = getElementLocator(prop.getProperty("dataTesting.pageArrows1"));
	By pageMsg1 = getElementLocator(prop.getProperty("dataTesting.pageMsg1"));
	By sourceColumnCheckbox = getElementLocator(prop.getProperty("dataTesting.sourceColumnCheckbox"));
	By xmlTableText = getElementLocator(prop.getProperty("DataTesting.Ruel.XmlTableText"));
	By targetXmlTableText = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetXmlTableText"));

	By criticalityValueGet = getElementLocator(prop.getProperty("DataTesting.CriticalityValueGet"));
	By connectionTypeValueGet = getElementLocator(prop.getProperty("DataTesting.ConnectionTypeValueGet"));
	By connectionValueGet = getElementLocator(prop.getProperty("DataTesting.ConnectionValueGet"));
	By schemaValueGet = getElementLocator(prop.getProperty("DataTesting.SchemaValueGet"));
	By tableValueGet = getElementLocator(prop.getProperty("DataTesting.TableValueGet"));
	By parameterValue = getElementLocator(prop.getProperty("DataTesting.ParameterValue"));
	By sourceFilePathText = getElementLocator(prop.getProperty("DataTesting.File.SourceFilePath"));
	By targetFilePathText = getElementLocator(prop.getProperty("DataTesting.File.TargetFilePath"));
	By criticalityText = getElementLocator(prop.getProperty("DataTesting.CriticalityText"));

	By targetConnectionTypeValueGet = getElementLocator(prop.getProperty("DataTesting.TargetConnectionTypeValueGet"));
	By targetConnectionValueGet = getElementLocator(prop.getProperty("DataTesting.TargetConnectionValueGet"));
	By targetSchemaValueGet = getElementLocator(prop.getProperty("DataTesting.TargetSchemaValueGet"));
	By targetTableValueGet = getElementLocator(prop.getProperty("DataTesting.TargetTableValueGet"));

	// for pushdown & validation rule

	// String wksfoldertext = prop.getProperty("DataTesting.wksfoldertext");
	String rulelanding_buttons = prop.getProperty("RuleRepo.rulelanding_buttons");

	By sourcedataset_buttons = getElementLocator(prop.getProperty("RuleRepo.sourcedataset_buttons"));

	By targetDataset_buttons = getElementLocator(prop.getProperty("RuleRepo.targetDataset_buttons"));

	By checks_buttons = getElementLocator(prop.getProperty("RuleRepo.checks_buttons"));

	By exceptionReport_buttons = getElementLocator(prop.getProperty("RuleRepo.exceptionReport_buttons"));

	By diffJoin_buttons = getElementLocator(prop.getProperty("RuleRepo.diffJoin_buttons"));

	By summary_buttons = getElementLocator(prop.getProperty("RuleRepo.summary_buttons"));

	String rulelandingpage_Disable_buttons = prop.getProperty("RuleRepo.rulelandingpage_Disable_buttons");

	By rulelandingpage_discard_button = getElementLocator(prop.getProperty("RuleRepo.rulelandingpage_discard_button"));

	By addNewFolder = getElementLocator(prop.getProperty("DataTesting.AddNewFolder"));
	By enterNewFolderName = getElementLocator(prop.getProperty("DataTesting.EnterNewFolderName"));
	By noteText = getElementLocator(prop.getProperty("DataTesting.NoteText"));
	By clearAll = getElementLocator(prop.getProperty("DataTesting.ClearAll"));
	By datasetSpinner = getElementLocator(prop.getProperty("DataTesting.DatasetSpinner"));
	By addsubFolder = getElementLocator(prop.getProperty("DataTesting.AddsubFolder"));
	By newRuleBtn = getElementLocator(prop.getProperty("DataTesting.NewRuleClickBtn"));
	By pathSelect = getElementLocator(prop.getProperty("DataTesting.PathSelect"));
	By pathTree = getElementLocator(prop.getProperty("DataTesting.PathTree"));
	By pathScroll = getElementLocator(prop.getProperty("DataTesting.PathScroll"));
	By addNewFolderPath = getElementLocator(prop.getProperty("DataTesting.AddNewFolderPath"));
	String folderselectBtn = prop.getProperty("DataTesting.FolderSelectbtn");
	By nameRule = getElementLocator(prop.getProperty("DataTesting.RuleName"));
	By engineType = getElementLocator(prop.getProperty("DataTesting.EngineType"));
	By chooseTemplateChecksum = getElementLocator(prop.getProperty("DataTesting.ChooseTemplateChecksum"));
	By chooseTemplatehtValidation = getElementLocator(prop.getProperty("DataTesting.ChooseTemplatehtValidation"));
	By chooseTemplatehthtrecon = getElementLocator(prop.getProperty("DataTesting.ChooseTemplatehthtrecon"));
	By chooseTemplatescript = getElementLocator(prop.getProperty("DataTesting.ChooseTemplatescript"));
	By nextButton = getElementLocator(prop.getProperty("DataTesting.NextButton"));
	By DatasetSpinner = getElementLocator(prop.getProperty("DataTesting.DatasetSpinner"));
	By propertiesCriticality = getElementLocator(prop.getProperty("DataTesting.PropertiesCriticality"));
	By propertiesPane = getElementLocator(prop.getProperty("DataTesting.PropertiesPane"));
	By propertiesTab = getElementLocator(prop.getProperty("DataTesting.PropertiesTab"));
	By propertiesWksFolder = getElementLocator(prop.getProperty("DataTesting.PropertiesWksFolder"));
	By propertiesRuleType = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleType"));
	By propertiesRuleName = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleName"));
	By propertiesRuleCode = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleCode"));
	By propertiesRuleDescription = getElementLocator(prop.getProperty("DataTesting.PropertiesRuleDescription"));
	By propertiesRulepurpose = getElementLocator(prop.getProperty("DataTesting.propertiesRulepurpose"));
	By propertiesActiveOption = getElementLocator(prop.getProperty("DataTesting.PropertiesActiveOption"));
	By propertiesAtRowClick = getElementLocator(prop.getProperty("DataTesting.PropertiesAtRowClick"));
	By propertiesAtErrorClick = getElementLocator(prop.getProperty("DataTesting.PropertiesAtErrorClick"));
	By propertiesAtTimeClick = getElementLocator(prop.getProperty("DataTesting.PropertiesAtTimeClick"));
	By doptext = getElementLocator(prop.getProperty("DataTesting.doptext"));
	By stoprowtext = getElementLocator(prop.getProperty("DataTesting.stoprowtext"));
	By stoperrortext = getElementLocator(prop.getProperty("DataTesting.stoperrortext"));
	By stopAftertimetext = getElementLocator(prop.getProperty("DataTesting.stopAftertimetext"));
	public By sourceDatasetNextButton = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetNextButton"));
	By targetDatasetNextButton = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetNextButton"));
	By severityLabel = getElementLocator(prop.getProperty("DataTesting.SeverityLabel"));
	By severityclick = getElementLocator(prop.getProperty("DataTesting.Severityclick"));
	By targetColName = getElementLocator(prop.getProperty("DataTesting.TargetColName"));
	By targetDataType = getElementLocator(prop.getProperty("DataTesting.TargetDataType"));
	By expressionButton = getElementLocator(prop.getProperty("DataTesting.ExpressionButton"));
	By propertiesSearchParameter = getElementLocator(prop.getProperty("DataTesting.propertiesSearchParameter"));
	By propertiesParameter = getElementLocator(prop.getProperty("DataTesting.PropertiesParameter"));
	By propertiesclosecursor = getElementLocator(prop.getProperty("DataTesting.Propertiesclosecursor"));
	By Propertiesdop = getElementLocator(prop.getProperty("DataTesting.Propertiesdop"));
	By customExp_dropdownlist_dimension = getElementLocator(prop.getProperty("dataT.customExp.dimension.dropdown"));
	By sourceColName = getElementLocator(prop.getProperty("DataTesting.SourceColName"));
	By metatab = getElementLocator(prop.getProperty("DataTesting.Metatab"));
	By metatabClose = getElementLocator(prop.getProperty("DataTesting.MetatabClose"));
	By newCheckClose = getElementLocator(prop.getProperty("dataT.NewCheckClose"));
	By dataTestingBreadCrumbs = getElementLocator(prop.getProperty("DataTesting.DataTestingBreadCrumbs"));
	By dataTestingTab = getElementLocator(prop.getProperty("DataTestingTab"));
	By sourceDataType = getElementLocator(prop.getProperty("DataTesting.SourceDataType"));
	By sourceTable = getElementLocator(prop.getProperty("DataTesting.SourceTable"));
	By targetTable = getElementLocator(prop.getProperty("DataTesting.TargetTable"));
	By downloadExceptionReport = getElementLocator(prop.getProperty("DataTesting.DownloadExceptionReport"));
	By summaryUpdateBtn = getElementLocator(prop.getProperty("dataT.Summary.UpdateBtn"));
	By clickonsummary = getElementLocator(prop.getProperty("DataTesting.clickonsummary"));
	By clicknewvariable = getElementLocator(prop.getProperty("DataTesting.clicknewvariable"));
	By addvariable = getElementLocator(prop.getProperty("DataTesting.addvariable"));
	By newvariablecancel = getElementLocator(prop.getProperty("DataTesting.newvariablecancel"));
	By advanceFolderSearch = getElementLocator(prop.getProperty("DataTesting.AdvanceFolderSearch"));
	By advanceFolderSearchBarButton = getElementLocator(prop.getProperty("DataTesting.AdvanceFolderSearchBarButton"));
	By clickDeletevariable = getElementLocator(prop.getProperty("DataTesting.clickDeletevariable"));

	// By
	// selectformula=getElementLocator(prop.getProperty("DataTesting.selectformula"));
	By formulaoptions1 = getElementLocator(prop.getProperty("DataTesting.formulaoptions1"));
	By formulaoptions2 = getElementLocator(prop.getProperty("DataTesting.formulaoptions2"));
	By searchformulavalue = getElementLocator(prop.getProperty("DataTesting.searchformulavalue"));
	By formulaexpression = getElementLocator(prop.getProperty("DataTesting.formulaexpression"));
	By variablename = getElementLocator(prop.getProperty("DataTesting.variablename"));
	By subscriptionButton = getElementLocator(prop.getProperty("RuleRepo.SubscriptionButton"));
	By subscriptionPane = getElementLocator(prop.getProperty("RuleRepo.SubscriptionPane"));
	By subscriptionSaveButton = getElementLocator(prop.getProperty("RuleRepo.SubscriptionSaveButton"));
	By subscriptionCancelButton = getElementLocator(prop.getProperty("RuleRepo.SubscriptionCancelButton"));
	By subscribersTitle = getElementLocator(prop.getProperty("RuleRepo.SubscribersTitle"));
	By onSuccessTitle = getElementLocator(prop.getProperty("RuleRepo.OnSuccessTitle"));
	By onFailureTitle = getElementLocator(prop.getProperty("RuleRepo.OnFailureTitle"));
	By onErrorTitle = getElementLocator(prop.getProperty("RuleRepo.OnErrorTitle"));
	By successUsers = getElementLocator(prop.getProperty("RuleRepo.SuccessUsers"));
	By failureUsers = getElementLocator(prop.getProperty("RuleRepo.FailureUsers"));
	By errorUsers = getElementLocator(prop.getProperty("RuleRepo.ErrorUsers"));

	// By selectRule =getElementLocator(prop.getProperty("DataTesting.SelectRule"));
	By sercheditem = getElementLocator(prop.getProperty("DataTesting.sercheditem"));
	By addNewSearchBar = getElementLocator(prop.getProperty("DataTesting.AddNewPanSearchBar"));
	By addNewPanSearchBarButton = getElementLocator(prop.getProperty("DataTesting.AddNewPanSearchBarButton"));
	By checkColumnDataList = getElementLocator(prop.getProperty("DataT.ExceptionReport.Summary.CheckColumnDataList"));
	By ruleListFirstChk = getElementLocator(prop.getProperty("dataT.RuleListingFirstCheck"));
	By executedExceptionReportCheckName = getElementLocator(
			prop.getProperty("DataTesting.ExecutedExceptionReportCheckName"));
	By executedExceptionReportDiffJoinName = getElementLocator(
			prop.getProperty("DataTesting.ExecutedExceptionReportDiffJoinName"));
	By downloadExceptionReport1 = getElementLocator(prop.getProperty("DataTesting.DownloadExceptionReport1"));
	By moreOptionButton = getElementLocator(prop.getProperty("DataTesting.MoreOptionButton"));
	By moreOptionDropDownButton = getElementLocator(prop.getProperty("DataTesting.MoreOptionDropDownButton"));
	By connVarNamefield = getElementLocator(prop.getProperty("dataT.ScriptRule.ConnVarNameField"));
	By scriptConnectionVariableSaveButton = getElementLocator(
			prop.getProperty("DataTesting.ScriptConnectionVariableSaveButton"));
	By scriptConnectionVariableCancelButton = getElementLocator(
			prop.getProperty("DataTesting.ScriptConnectionVariableCancelButton"));
	By downloadExceptionReportButton = getElementLocator(prop.getProperty("DataTesting.DownloadExceptionReportButton"));
	By copyUrlButton = getElementLocator(prop.getProperty("DataTesting.CopyUrlButton"));
	By highlightButton = getElementLocator(prop.getProperty("DataTesting.HighlightButton"));
	By showPercentageButton = getElementLocator(prop.getProperty("DataTesting.ShowPercentageButton"));
	By severityValueGet = getElementLocator(prop.getProperty("DataTesting.SeverityValueGet"));
	By dataTestingSchemaLabel = getElementLocator(prop.getProperty("DataTesting.DataTestingSchemaLabel"));
	By dataTestingTargetSchemaLabel = getElementLocator(prop.getProperty("DataTesting.DataTestingTargetSchemaLabel"));
	By targetSettingLable = getElementLocator(prop.getProperty("DataTesting.TargetSettingLable"));

	By fileSourceAdvanceButton = getElementLocator(prop.getProperty("dataT.FileSourceAdvanceButton"));
	By fileTargetAdvanceButton = getElementLocator(prop.getProperty("dataT.FileTargetAdvanceButton"));
	By fileSourceSourceButton = getElementLocator(prop.getProperty("dataT.FileSourceSourceButton"));
	By fileTargetTargetButton = getElementLocator(prop.getProperty("dataT.FileTargetTargetButton"));
	By sourceSchemaID = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceSchemaID"));
	By targetSchemaID = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetSchemaID"));

	By sourceFileSchemaText = getElementLocator(prop.getProperty("DataTesting.Ruel.SourceFileSchemaText"));
	By targetFileSchemaText = getElementLocator(prop.getProperty("DataTesting.Ruel.TargetFileSchemaText"));

	String executedExceptionReportDiffSuccessCount = prop
			.getProperty("DataTesting.ExecutedExceptionReportDiffSuccessCount");
	String executedExceptionReportSuccessCount = prop.getProperty("DataTesting.ExecutedExceptionReportSuccessCount");

	String executedExceptionReportDiffFailureCount = prop
			.getProperty("DataTesting.ExecutedExceptionReportDiffFailureCount");
	String executedExceptionReportFailureCount = prop.getProperty("DataTesting.ExecutedExceptionReportFailureCount");

	String executedExceptionReportDiffErrorCount = prop
			.getProperty("DataTesting.ExecutedExceptionReportDiffErrorCount");
	String executedExceptionReportErrorCount = prop.getProperty("DataTesting.ExecutedExceptionReportErrorCount");

	String executedExceptionReportColumnName = prop.getProperty("DataTesting.ExecutedExceptionReportColumnName");
	String sourceOperator = prop.getProperty("DataTesting.SourceOperator");
	String targetOperator = prop.getProperty("DataTesting.TargetOperator");

	String moreValueOption = prop.getProperty("DataTesting.MoreValueOption");
	String chooseFileHover = prop.getProperty("DataTesting.ChooseFileHover");
	String severitySelect = prop.getProperty("DataTesting.SeveritySelect");
	String subscribersNameList = prop.getProperty("RuleRepo.SubscribersNameList");
	String subscribersNameAddMessage = prop.getProperty("RuleRepo.SubscribersNameAddMessage");
	String selectExistingFolder = prop.getProperty("DataTesting.SelectExistingFolder");
	String chooseFile = prop.getProperty("DataTesting.ChooseFile");
	String validScrollFolder = prop.getProperty("DataTesting.ValidScrollFolder");
	String engineTypeSelectOption = prop.getProperty("DataTesting.EngineTypeSelectOption");
	String formatTypeSelectOption = prop.getProperty("DataTesting.FormatTypeSelectOption");
	String chooseTemplate = prop.getProperty("DataTesting.ChooseTemplate");
	String pathText = prop.getProperty("DataTesting.PathText");
	String propertiescriticalityOption = prop.getProperty("DataTesting.PropertiescriticalityOption");
	String propertiesselectParameter = prop.getProperty("DataTesting.propertiesselectParameter");
	String selectPatternChip = prop.getProperty("dataT.ChoosePatternChip");
	String selectChooseFormat = prop.getProperty("dataT.ChooseFormatSelect");
	String expressionReportCheckName = prop.getProperty("dataT.ExceptionReportCheckName");
	String exceptionReportCheckDetails = prop.getProperty("dataT.ExceptionReportCheckDetails");
	String exceptionReporExpShowCheckbox = prop.getProperty("dataT.ExceptionReport.ExpShow");
	String deleteMsg1 = prop.getProperty("dataT.DeleteMessage1");
	String deleteToastMsg = prop.getProperty("dataT.DeleteToastmsg");
	String checkNameInExReport = prop.getProperty("dataT.CheckNameInException");
	String checkDetailInExReport = prop.getProperty("dataT.CheckDetailInException");
	String pageArrowName = prop.getProperty("dataT.PageArrowName");
	String pageNumber = prop.getProperty("dataT.PageNumber");
	String deleteMsg2 = prop.getProperty("dataT.DeleteMessage2");
	String selectformula = prop.getProperty("DataTesting.selectformula");
	// String formulaoptions= prop.getProperty("DataTesting.formulaoptions");
	String selectoperator = prop.getProperty("DataTesting.selectoperator");
	String selectvalue = prop.getProperty("DataTesting.selectvalue");
	String formulavalueclick = prop.getProperty("DataTesting.formulavalueclick");
	String checksJsonPath = prop.getProperty("ChecksJsonPath");
	String reconCheckJsonPAth = prop.getProperty("ReconCheckJsonPAth");
	String summarycheckSuccessCount = prop.getProperty("dataT.ExceptionReport.Summary.checkSuccess");
	String summarycheckFailureCount = prop.getProperty("dataT.ExceptionReport.Summary.checkFailure");
	String summarycheckErrorCount = prop.getProperty("dataT.ExceptionReport.Summary.checkError");
	String vsummaryReportChecksPath = prop.getProperty("ValidationSummaryReportChecksPath");
	String rsummaryReportChecksPath = prop.getProperty("ReconSummaryReportChecksPath");
	String valSummaryExpIndexList = prop.getProperty("ValSummaryExpIndexList");
	String reconSummaryExpIndexList = prop.getProperty("ReconSummaryExpIndexList");
	String summarycheckType = prop.getProperty("dataT.ExceptionReport.Summary.checkType");
	String summarycheckCheckBox = prop.getProperty("dataT.ExceptionReport.Summary.checkbox");
	String columnCheckBox = prop.getProperty("DataTesting.ExceptionReport.ColumnCheckBox");

	String summarycheckName = prop.getProperty("dataT.ExceptionReport.Summary.checkName");
	String noRecondToDownloadMsg = prop.getProperty("dataT.NoReportToDownloadMsg");
	public String ruleSuccessMsg = prop.getProperty("DataTesting.ruleSuccess.msg");
	String scriptTestConnectionBtn = prop.getProperty("dataT.ScriptRule.ConnTestButton");
	String connectionDropdown = prop.getProperty("dataT.ScriptRule.Conndropdownbutton");
	String connectionSearchInput = prop.getProperty("dataT.ScriptRule.ConnpopupSearchInput");
	String selectconnName = prop.getProperty("dataT.ScriptRule.ConnpopupSearchValue");
	String connDynamicVar = prop.getProperty("dataT.ScriptRule.connDynamicVar");
	String connVarName = prop.getProperty("dataT.ScriptRule.ConnVarName");
	String colHeaderName = prop.getProperty("dataT.ScriptRule.ColHeaderName");
	String connVarTestButton = prop.getProperty("dataT.ScriptRule.ConnTestButton");
	String connEditButton = prop.getProperty("dataT.ScriptRule.ConnEditButton");
	String scriptConnectionPenEdit = prop.getProperty("DataTesting.ScriptConnectionPenEdit");
	String scriptConnectionDelete = prop.getProperty("DataTesting.ScriptConnectionDelete");

	String scriptParseMsg = prop.getProperty("dataT.ScriptRuleParseMsg");
	String foldername = prop.getProperty("testdata.vFolderName");
	String vengineType = prop.getProperty("testdata.vEngineType");
	String valTemplate = prop.getProperty("testdata.vTemplateType");
	String valRuleName = prop.getProperty("testdata.vRuleName");
	String checksStatusBtn = prop.getProperty("dataT.Checks.ActiveStatusBtn");
	String userPrivilegeMsg = prop.getProperty("");
	String expressionCheckbox = prop.getProperty("dataT.Checks.ExpressionCheckbox");
	String listOfVariables = prop.getProperty("	DataTesting.ListOfVariables");

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public String colName = prop.getProperty("testdata.ColumnName");
	public String colExp = prop.getProperty("testdata.ColumnExp");
	public String colState = prop.getProperty("testdata.ColumnStatus");
	public String runClickErrorMsg = prop.getProperty("dataT.RunErrorMsg");
	public String invalidtestValue = prop.getProperty("testdata.InvalidTestValue");
	public String invalidtextOutput = prop.getProperty("testdata.InvalidTestOutput");
	public String validtestValue = prop.getProperty("testdata.ValidTestValue");
	public String validtextOutput = prop.getProperty("testdata.ValidTestOutput");

	// Json Expression
	String jsonExpressionSourceColumnDelimiter = prop.getProperty("DataTesting.JsonExpression.SourceColumnDelimiter");
	String jsonExpressionSourceRowDelimiter = prop.getProperty("DataTesting.JsonExpression.SourceRowDelimiter");
	String jsonExpressionSourceTextQualifier = prop.getProperty("DataTesting.JsonExpression.SourceTextQualifier");
	String jsonExpressionSourceSkipRowTop = prop.getProperty("DataTesting.JsonExpression.SourceSkipRowTop");
	String jsonExpressionSourceSkipRowBottom = prop.getProperty("DataTesting.JsonExpression.SourceSkipRowBottom");
	String jsonExpressionSourceHeaderRow = prop.getProperty("DataTesting.JsonExpression.SourceHeaderRow");
	String jsonExpressionSourceTrimData = prop.getProperty("DataTesting.JsonExpression.SourceTrimData");
	String jsonExpressionSourceEmptyString = prop.getProperty("DataTesting.JsonExpression.SourceEmptyString");
	String jsonExpressionSourceWhiteSpace = prop.getProperty("DataTesting.JsonExpression.SourceWhiteSpace");
	String jsonExpressionSourceFixedString = prop.getProperty("DataTesting.JsonExpression.SourceFixedString");
	String jsonExpressionSourceFixedStringValue = prop.getProperty("DataTesting.JsonExpression.SourcefixedStringValue");
	String jsonExpressionSourceSingleFile = prop.getProperty("DataTesting.JsonExpression.SourceSingleFile");
	String jsonExpressionSourceParameterisedPath = prop
			.getProperty("DataTesting.JsonExpression.SourceParameterisedPath");
	String jsonExpressionSourceFilePath = prop.getProperty("DataTesting.JsonExpression.SourceFilePath");
	String jsonExpressionSourceIncludeHeaders = prop.getProperty("DataTesting.JsonExpression.SourceIncludeHeaders");

	String jsonExpressionSourceXmlFileTable = prop.getProperty("DataTesting.JsonExpression.SourceXmlFileTable");
	String jsonExpressionTargetXmlFileTable = prop.getProperty("DataTesting.JsonExpression.TargetXmlFileTable");

	String jsonExpressionRuleType = prop.getProperty("DataTesting.JsonExpression.RuleType");
	String jsonExpressionSourceXmlTableName = prop.getProperty("DataTesting.JsonExpression.SourceXmlTableName");
	String jsonExpressionSourceXmlFileSchemaId = prop.getProperty("DataTesting.JsonExpression.SourceXmlFileSchemaId");
	String jsonExpressionSourceXmlFileQuery = prop.getProperty("DataTesting.JsonExpression.SourceXmlFileQuery");
	String jsonExpressionTargetXmlFileQuery = prop.getProperty("DataTesting.JsonExpression.TargetXmlFileQuery");
	String jsonExpressionTargetXmlFileSchemaId = prop.getProperty("DataTesting.JsonExpression.TargetXmlFileSchemaId");
	String jsonExpressionTargetXmlTableName = prop.getProperty("DataTesting.JsonExpression.TargetXmlTableName");
	String jsonExpressionTargetSingleFile = prop.getProperty("DataTesting.JsonExpression.TargetSingleFile");
	String jsonExpressionTargetParameterisedPath = prop
			.getProperty("DataTesting.JsonExpression.TargetParameterisedPath");
	String jsonExpressionTargetTargetFilePath = prop.getProperty("DataTesting.JsonExpression.TargetFilePath");
	String jsonExpressionTargetColumnDelimiter = prop.getProperty("DataTesting.JsonExpression.TargetColumnDelimiter");
	String jsonExpressionTargetRowDelimiter = prop.getProperty("DataTesting.JsonExpression.TargetRowDelimiter");
	String jsonExpressionTargetTextQualifier = prop.getProperty("DataTesting.JsonExpression.TargetTextQualifier");
	String jsonExpressionTargetSkipRowTop = prop.getProperty("DataTesting.JsonExpression.TargetSkipRowTop");
	String jsonExpressionTargetSkipRowBottom = prop.getProperty("DataTesting.JsonExpression.TargetSkipRowBottom");
	String jsonExpressionTargetHeaderRow = prop.getProperty("DataTesting.JsonExpression.TargetHeaderRow");
	String jsonExpressionTargetTrimData = prop.getProperty("DataTesting.JsonExpression.TargetTrimData");
	String jsonExpressionTargetEmptyString = prop.getProperty("DataTesting.JsonExpression.TargetEmptyString");
	String jsonExpressionTargetWhiteSpace = prop.getProperty("DataTesting.JsonExpression.TargetWhiteSpace");
	String jsonExpressionTargetFixedString = prop.getProperty("DataTesting.JsonExpression.TargetFixedString");
	String jsonExpressionTargetfixedStringValue = prop.getProperty("DataTesting.JsonExpression.TargetfixedStringValue");
	String jsonExpressionSourceOverrideLayout = prop.getProperty("DataTesting.JsonExpression.SourceOverrideLayout");
	String jsonExpressionSourceDeferredSort = prop.getProperty("DataTesting.JsonExpression.SourceDeferredSort");
	String jsonExpressionTargetDeferredSort = prop.getProperty("DataTesting.JsonExpression.TargetDeferredSort");
	String jsonExpressionTargetIncludeHeaders = prop.getProperty("DataTesting.JsonExpression.TargetIncludeHeaders");

	String jsonExpressionSourceCaseSensitive = prop.getProperty("DataTesting.JsonExpression.SourceCaseSensitive");
	String jsonExpressionTargetCaseSensitive = prop.getProperty("DataTesting.JsonExpression.TargetCaseSensitive");
	String jsonExpressionSourceIsSorte = prop.getProperty("DataTesting.JsonExpression.SourceIsSorte");
	String jsonExpressionTargetIsSorted = prop.getProperty("DataTesting.JsonExpression.TargetIsSorted");

	// **************************** Comman methods for data
	// testing************************************************************

	// -------------------Vipul's Method
	// starts--------------------------------------
	// methods for data testing us per new ui
	public void verifyDataTestingLandingPage() {

		try {
			HomePage home = new HomePage(driver);

			BaseSuite.reportLog("Validating Data Testing Landing Page");

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, ruleListMsg, "Rule(s)
			// List");
			verifyIndividualLabel(driver, mainHeading, "Rules");

			home.validateNextGenTabs();

			BaseSuite.reportLog("validating breadcrums link on Data Testing landing page");

			verifyVisibilityOfButtons(driver, brdCrumsHomeLink, "Home Link", true);
			verifyVisibilityOfButtons(driver, brdCrumsDataTesting, "Data Testing Link", true);
			verifyIndividualLabel(driver, brdCrumsTestRules, "Rules");
			// verifyIndividualLabel(driver, brdCrumsworkspaceName, "Workspace Name");
			BaseSuite.reportLog("verifying Folder left side panel...");

			isDisplayed(driver, folderPanel);

			if (isDisplayed(driver, folderPanel)) {

				BaseSuite.validationReportLog("Folders side panel is visible");

				verifyIndividualLabel(driver, folderLabel, "Folder Search ");

				// verifyVisibilityOfButtons(driver, clearAllButton, "Clear all ", true);

				// verifyVisibilityOfButtons(driver, filterCloseArrow, "Filter close ", true);

				if (isDisplayed(driver, foldersList)) {

					List<WebElement> folders = getElements(driver, foldersList);

					int count = folders.size();

					BaseSuite.reportLog("Total Folders available in workspace :: " + count);

					for (int j = 0; j < count; j++) {

						String fname = folders.get(j).getText();
						BaseSuite.validationReportLog((j + 1) + ". " + fname + " Folder is visible");

					}
				} else {
					BaseSuite.reportLog("No folders available");
				}
				verifyVisibilityOfButtons(driver, addNewFolderButton, "New Folder", true);

				// verifyText(driver, foldersNote, note);

			} else {
				BaseSuite.reportFailLog("Folders side panel is not visible", "verifyDataTestingLandingPage");
			}

			// verifyVisibilityOfButtons(driver, advanceSearchButton, "Advance Search",
			// true);

			// isClickable(driver, advanceSearchButton, "Advance Search", true);

			verifyVisibilityOfButtons(driver, newRuleButton, "New Rule ", true);

			isClickable(driver, newRuleButton, "New Rule ", true);

			verifyVisibilityOfButtons(driver, refreshButton, "Refresh ", true);

			isClickable(driver, refreshButton, "Refresh ", true);

			verifyVisibilityOfButtons(driver, deleteButton, "Delete ", false);

			isClickable(driver, deleteButton, "Delete ", false);

			// verifyVisibilityOfButtons(driver, moreOpButton, "More Options ", true);

			// isClickable(driver, moreOpButton, "More Options ", true);

			BaseSuite.reportLog("verifying search bar and search button");

			isDisplayed(driver, searchBox);

			if (isDisplayed(driver, searchBox)) {

				isClickable(driver, searchBox, "Search", true);
				String a = getAttribute(driver, searchBox, "placeholder");
				BaseSuite.validationReportLog("Search box placeholder value :: " + a);

				isClickable(driver, searchButton, "Search button", true);
			} else {
				BaseSuite.reportFailLog("Search box not visible", "verifyDataTestingLandingPage");
			}
			BaseSuite.reportLog("verifying column of Data testing rules listing...");

			isDisplayed(driver, columnList);

			List<WebElement> colList = getElements(driver, columnList);

			int colCount = colList.size() - 2;

			for (int k = 0; k <= colCount; k++) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colList.get(k));
				String name = colList.get(k).getAttribute("textContent");
				if (!name.isEmpty()) {
					BaseSuite.validationReportLog(name + " column is visible");
				}
			}
			javascript(driver, "arguments[0].scrollIntoView(true);", ruleListFirstChk);
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// driver.findElement(ruleListFirstChk));
			List<WebElement> rules = getElements(driver, ruleList);
			if (rules.size() > 0) {
				boolean rulen = rules.get(0).isDisplayed();
				if (rulen) {
					BaseSuite.validationReportLog("rule is visible");
				} else {
					BaseSuite.reportFailLog("rule not displayed", "verifyDataTestingLandingPage");
				}
			}
			BaseSuite.validationReportLog("Number of rules present on current page :: " + rules.size());

			BaseSuite.reportLog("checking Pagination on Data testing page");

			getPaginationDetails(pageMsg, pageArrows);

			BaseSuite.validationReportLog("====  Data Testing landing page verified successfully  ====");
		} catch (Exception e) {
			BaseSuite.reportFailLog("Exception occurs while validating data testing landing page kindly check",
					"verifyDataTestingLandingPage");
			throw new AssertionError("Assertion Exception occurs while validating data testing landing page");
		}
	}

	// method to validate pagination arrows and return page and record details
	public List<String> getPaginationDetails(By PageMsglocator, By pageArrowslocator) {

		String pageinfo, totalRecords, currentpage;
		int totalpage;

		isDisplayed(driver, PageMsglocator);

		pageinfo = getAttribute(driver, PageMsglocator, "aria-label");

		BaseSuite.validationReportLog("Page details displayed :: " + pageinfo);

		totalpage = Integer.parseInt(pageinfo.split(" ")[2]);

		BaseSuite.validationReportLog("Total page available are :: " + totalpage);

		totalRecords = pageinfo.split(" ")[4].replace("(", "");

		BaseSuite.validationReportLog("Total Records available are :: " + totalRecords);

		currentpage = pageinfo.split(" ")[0];

		BaseSuite.validationReportLog("Current page number is :: " + currentpage);

		List<WebElement> arrows = getElements(driver, pageArrowslocator);

		for (int j = 0; j < arrows.size(); j++) {

			String arrow = arrows.get(j).getAttribute("aria-label").replaceAll("Go to", "");

			BaseSuite.reportLog("Checking page arrow :: " + arrow);

			String status = arrows.get(j).getAttribute("class");

			if (status.contains("disable")) {
				BaseSuite.validationReportLog("Page arrow :: " + arrow + " is disabled");
			} else {
				BaseSuite.validationReportLog("Page arrow :: " + arrow + " is enabled");
			}
		}
		return Arrays.asList(pageinfo, totalRecords, currentpage);
	}

	// method to search rule on data testing landing page
	public boolean searchRuleOnDataTestingLandingPage(String folderName, String ruleName, SoftAssert soft)
			throws java.lang.Exception {
		boolean flag = false;
		try {
			BaseSuite.reportLog("Searching for rule on Data testing landing page ");

			isDisplayed(driver, searchBox);

			Thread.sleep(2000);

			if (isDisplayed(driver, searchBox)) {
				BaseSuite.reportLog("Search box is visible");

				BaseSuite.reportLog("Clicking on search box...");

				displayAndClick(driver, searchBox);

				BaseSuite.reportLog("Clicked on search box");

				BaseSuite.reportLog("Entering Rule name in search box :: " + ruleName);

				clear_Click_SendKeys(driver, 10, searchBox, ruleName);

				BaseSuite.validationReportLog("Entered Rule name :: " + ruleName);

				clickOnButton(driver, searchButton, "Search button", true);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				isDisplayed(driver, ruleList);

				if (!(isDisplayed(driver, noRecondsFound))) {

					List<WebElement> rules = getElements(driver, ruleList);

					flag = isDisplayed(driver,
							returnTwoElements(ruleNameLink, "$folderName", folderName, "$name", ruleName.trim()));

					if (flag) {

						String name = getText(driver,
								returnTwoElements(ruleNameLink, "$folderName", folderName, "$name", ruleName.trim()));

						soft.assertTrue(name.equalsIgnoreCase(ruleName), "test1");

						BaseSuite.validationReportLog("Searched Rule found in the list :" + ruleName);

						BaseSuite.validationReportLog("Search functionality working properly");

					} else {

						soft.assertTrue(flag, "test2");

						BaseSuite.validationReportLog("Searched Rule not available in the list :" + ruleName);
					}

				} else {

					BaseSuite.validationReportLog("No Result found for searched value ");
				}

			}

			else {
				BaseSuite.reportFailLog("Search box not visible", "searchRuleOnDataTestingLandingPage");
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	// method to search rule on data testing landing page
	public boolean searchRuleOnDataTestingLandingPage(String ruleName, SoftAssert soft) throws java.lang.Exception {
		boolean flag = false;
		try {
			BaseSuite.reportLog("Searching for rule on Data testing landing page ");

			isDisplayed(driver, searchBox);

			Thread.sleep(2000);

			if (isDisplayed(driver, searchBox)) {
				BaseSuite.reportLog("Search box is visible");

				BaseSuite.reportLog("Clicking on search box...");

				displayAndClick(driver, searchBox);

				BaseSuite.reportLog("Clicked on search box");

				BaseSuite.reportLog("Entering Rule name in search box :: " + ruleName);

				clear_Click_SendKeys(driver, 10, searchBox, ruleName);

				BaseSuite.validationReportLog("Entered Rule name :: " + ruleName);

				clickOnButton(driver, searchButton, "Search button", true);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				isDisplayed(driver, ruleList);

				if (!(isDisplayed(driver, noRecondsFound))) {

					List<WebElement> rules = getElements(driver, ruleList);

					flag = isDisplayed(driver, returnElement(ruleNameLinkWithoutFolder, "$name", ruleName.trim()));

					if (flag) {

						String name = getText(driver,
								returnElement(ruleNameLinkWithoutFolder, "$name", ruleName.trim()));

						soft.assertTrue(name.equalsIgnoreCase(ruleName), "test1");

						BaseSuite.validationReportLog("Searched Rule found in the list :" + ruleName);

						BaseSuite.validationReportLog("Search functionality working properly");

					} else {

						soft.assertTrue(flag, "test2");

						BaseSuite.validationReportLog("Searched Rule not available in the list :" + ruleName);
					}

				} else {

					BaseSuite.validationReportLog("No Result found for searched value ");
				}

			}

			else {
				BaseSuite.reportFailLog("Search box not visible", "searchRuleOnDataTestingLandingPage");
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	// method to click on search rule name on data testing landing page
	public boolean clickOnSearchedRuleNameOnDataTestingPage(String folderName, String ruleName, SoftAssert soft) {
		try {
			boolean flag = false;

			flag = searchRuleOnDataTestingLandingPage(folderName, ruleName.trim(), soft);

			if (flag) {

				displayAndClick(driver,
						returnTwoElements(ruleNameLink, "$folderName", folderName, "$name", ruleName.trim()));

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			} else {

				BaseSuite.reportLog("Searched rule not found kindly check - Rule : " + ruleName);
			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
		return false;
	}

	// method to click on search rule name on data testing landing page
	public boolean clickOnSearchedRuleNameOnDataTestingPage(String ruleName, SoftAssert soft) {
		try {
			boolean flag = false;

			flag = searchRuleOnDataTestingLandingPage(ruleName.trim(), soft);

			if (flag) {

				displayAndClick(driver, returnElement(ruleNameLinkWithoutFolder, "$name", ruleName.trim()));

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				Thread.sleep(2000);

			} else {

				BaseSuite.reportLog("Searched rule not found kindly check - Rule : " + ruleName);
			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
		return false;
	}

	// method to click on refresh button on data testing landing page
	public void clickOnRefreshButtonOnDataTestingPage() throws java.lang.Exception {

		clickOnButton(driver, refreshButton, "Refresh", true);

		inVisible(driver, dataTSpinner, Constant.ruleWait);

		captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, ruleListMsg, "Rule(s) List");

	}

	// method to click on rule checkbox on data testing landing page
	public boolean clickOnRuleCheckbox(String ruleName) {
		boolean s = false;
		try {
			BaseSuite.reportLog("checking checkbox of rule : " + ruleName);

			isDisplayed(driver, returnElement(ruleNameCheckbox, "$name", ruleName));

			if (isDisplayed(driver, returnElement(ruleNameCheckbox, "$name", ruleName))) {

				BaseSuite.reportLog(ruleName + "'s checkbox is visible ");

				String status = getAttribute(driver, returnElement(ruleNameCheckbox, "$name", ruleName), "class");

				if (status.contains("uncheck") || !(status.contains("check"))) {

					isClickable(driver, returnElement(ruleNameCheckbox, "$name", ruleName), ruleName + "'s checkbox",
							true);

					BaseSuite.reportLog("Clicking on " + ruleName + "'s checkbox...");

					displayAndClick(driver, returnElement(ruleNameCheckbox, "$name", ruleName));

					BaseSuite.validationReportLog("Clicked on " + ruleName + "'s checkbox successfully");

					s = true;
				} else {
					BaseSuite.reportLog(ruleName + "'s Checkbox is already selected");
				}

			} else {
				BaseSuite.reportFailLog(ruleName + "'s Checkbox not visible ", "clickOnRuleCheckbox");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return s;
	}

	// method to scroll to locator -common method
	public void scrollToLocator(By locator, String elementName) throws InterruptedException {

		try {
			BaseSuite.reportLog("scrolling to " + elementName + "...");
			Thread.sleep(2000);
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", locator);

			BaseSuite.validationReportLog("Scrolled to " + elementName + " successfully");

			isDisplayed(driver, locator);
			if (isDisplayed(driver, locator)) {

				BaseSuite.validationReportLog(elementName + " is visible ");
			} else {
				BaseSuite.reportFailLog(elementName + " element not visible", "scrollToLocator");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to verify scrollbar on data testing landing page
	public void verifyScrollBarOnDataTestingPage() throws InterruptedException {

		try {
			BaseSuite.reportLog("verifying scroll bar on data testing page");
			scrollToLocator(scrollDown, "Last Row of lising page");

			scrollToLocator(scrollUp, "First Row of listing page");

			scrollToLocator(By.xpath("//table[@class=\"e-table\"]/tbody//tr[1]//td[8]"), "Last Column of listing page");

			scrollToLocator(By.xpath("//table[@class=\"e-table\"]/tbody//tr[1]//td[1]"),
					"First Column of listing page");
			BaseSuite.validationReportLog("Scroll bar verified successfully");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on next gen menu tab
	public void clickOnNextGenMenuTab(String moduleName) throws java.lang.Exception {

		try {
			isDisplayed(driver, deletePopupDeleteBtn);
			if (isDisplayed(driver, deletePopupDeleteBtn)) {

				clickOnButton(driver, deletePopupDeleteBtn, "Delete popup", true);
			}

			isDisplayed(driver, sidebarCloseIcon);
			if (isDisplayed(driver, sidebarCloseIcon)) {

				clickOnButton(driver, sidebarCloseIcon, "Sidebar close icon ", true);
			}

			isDisplayed(driver, returnElement(nextGenMenuTab, "$name", moduleName.trim()));

			if (isDisplayed(driver, returnElement(nextGenMenuTab, "$name", moduleName.trim()))) {

				clickOnButton(driver, returnElement(nextGenMenuTab, "$name", moduleName.trim()), moduleName + " menu ",
						true);

				isDisplayed(driver, sidebarCloseIcon);

				if (isDisplayed(driver, sidebarCloseIcon)) {

					clickOnButton(driver, sidebarCloseIcon, "Sidebar close icon ", true);
				}

				isDisplayed(driver, discardButtons);

				if (isDisplayed(driver, discardButtons)) {

					clickOnButton(driver, discardButtons, " Discard ", true);
				}

				getWindowHandler(driver);
				// checkElement(driver, checkNameLocator, "Column name", "refer issue
				// -DAT-2766");
			} else {
				BaseSuite.reportFailLog(moduleName + " menu tab not visible kindly check", "clickOnNextGenMenuTab");
				throw new AssertionError(moduleName + " menu tab not visible kindly check");
			}
		} catch (Exception e) {

			e.getMessage();
			BaseSuite.reportFailLog(moduleName + " menu tab not visible kindly check ", "clickOnNextGenMenuTab");
			throw new AssertionError(moduleName + " menu tab not visible kindly check :: " + e.getMessage());
		}
	}

	// method to validate new check side pane public void

	// method to validate new check side pane
	public void validateNewCheckPane() {

		try {
			BaseSuite.reportLog("Validating Check Side Panel");

			verifyIndividualLabel(driver, newCheckTitle, "Check");

			// verifyIndividualLabel(driver, chooseCheckTitle, "Choose a template");
			isDisplayed(driver, checksList);

			List<WebElement> checkTypes = getElements(driver, checksList);

			int count = checkTypes.size();

			for (int i = 0; i < count - 2; i++) {

				String checkName = checkTypes.get(i).getText();

				if (!checkName.isEmpty()) {

					if (checkTypes.get(i).isDisplayed()) {

						BaseSuite.validationReportLog(checkName + " check button is visible");

					} else {

						BaseSuite.reportFailLog(checkName + " not visible ", "validateNewCheckPane");
					}
				}
			}

			verifyVisibilityOfButtons(driver, newCheckCloseButton, "Close", true);

			isClickable(driver, newCheckCloseButton, "Close", true);

			BaseSuite.validationReportLog("Validated New Check Side Panel successfully");
		} catch (Exception e) {

			BaseSuite.reportFailLog("Expected field not found ", "validateNewCheckPane");

		}
	}

	public String selectCheckEnableStatus(String expectedStatus) throws Exception {
		String checkStatus = null;
		try {
			BaseSuite.reportLog("checking out of expression status");

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checkStatusbutton);

			isDisplayed(driver, checkStatusbutton);

			if (isDisplayed(driver, checkStatusbutton)) {

				String actualStatus1 = getText(driver, checkStatusbutton);

				switch (expectedStatus.trim().toLowerCase()) {

				case "true":
					if (actualStatus1.trim().equalsIgnoreCase("Active")) {

						BaseSuite.validationReportLog("check status selected as per expected condition : Active");

					} else if (actualStatus1.trim().equalsIgnoreCase("Inactive")) {

						BaseSuite.reportLog("selecting check status as Active");

						displayAndClick(driver, checkStatusbutton);

						isDisplayed(driver, checkActiveStatus);

						displayAndClick(driver, checkActiveStatus);

						BaseSuite.validationReportLog("selected as per expected condition as Active");
					} else {
						BaseSuite.reportFailLog("Not able to get actual status  kindly check",
								"selectCheckEnableStatus ");
					}
					checkStatus = "Active";
					break;
				case "false":

					if (actualStatus1.trim().equalsIgnoreCase("Inctive")) {

						BaseSuite.validationReportLog("check status selected as per expected condition : Inactive");

					} else if (actualStatus1.trim().equalsIgnoreCase("Active")) {

						BaseSuite.reportLog("selecting check status as Inactive");

						displayAndClick(driver, checkStatusbutton);

						isDisplayed(driver, checkInactiveStatus);

						displayAndClick(driver, checkInactiveStatus);

						BaseSuite.validationReportLog(
								"click on check status to select as per expected condition as Inactive");
					} else {
						BaseSuite.reportFailLog("Not able to get actual status  kindly check",
								"selectCheckEnableStatus");
					}
					checkStatus = "Inactive";
					break;

				default:

					break;
				}
			} else {
				BaseSuite.reportFailLog("Check status button not visible kindly check", "selectCheckEnableStatus");
			}

		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException("");
		}
		return checkStatus;
	}

//method to click on specific check type
	public void clickOnCheckType(String checkType) throws java.lang.Exception {

		try {
			if (!checkType.isEmpty()) {
				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
						returnElement(newCheckNamebutton, "$name", checkType.trim()));
				isDisplayed(driver, returnElement(newCheckNamebutton, "$name", checkType.trim()));
				clickOnButton(driver, returnElement(newCheckNamebutton, "$name", checkType.trim()), checkType, true);
				/*
				 * if (!checkType.equalsIgnoreCase("custom")) { isDisplayedInLoop(driver, 6,
				 * returnElement(newPredefineTitle, "$name", checkType.trim())); if
				 * (isDisplayed(driver, returnElement(newPredefineTitle, "$name",
				 * checkType.trim()))) { verifyIndividualLabel(driver,
				 * returnElement(newPredefineTitle, "$name", checkType.trim()), "Check Title");
				 * 
				 * } else { BaseSuite.reportFailLog(checkType +
				 * " check button not clicked kindly check", "clickOnCheckType"); } } else {
				 * 
				 * isDisplayedInLoop(driver, 6, newCustomChecklabel);
				 * 
				 * verifyIndividualLabel(driver, newCustomChecklabel, "New Custom Check Title");
				 * 
				 * verifyIndividualLabel(driver, returnElement(checkTitleLabel, "$checkName",
				 * checkType.trim()), checkType + " check title ");
				 * 
				 * verifyIndividualLabel(driver, metadataTitle, "Metadata Title"); }
				 */
				isDisplayed(driver, custom_Check_pane_inputBox);
				if (!isDisplayed(driver, custom_Check_pane_inputBox)) {
					BaseSuite.reportFailLog("Check Details pane not visible kindly check", "clickOnCheckType");
					throw new AssertionError("Check Details pane not visible properly,  kindly check");
					// clickOnButton(driver, returnElement(newCheckNamebutton, "$name",
					// checkType.trim()), checkType, true);
				}
			} else {
				BaseSuite.reportFailLog("Check type not provided kindly check", "clickOnCheckType");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to enter check name in name field
	public String enterCheckName(String checkName) throws java.lang.Exception {

		String cname = null;
		try {

			BaseSuite.reportLog("checking Name field is displayed or not");

			isDisplayed(driver, checkNameLabel);

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checkNameLabel);

			displayAndClick(driver, checkNameLabel);

			if (isDisplayed(driver, checkNameField)) {
				// BaseSuite.validationReportLog("Name field is visible on page");

				if (!checkName.isEmpty()) {

					BaseSuite.reportLog("entering check name as : " + checkName);

					clear_Click_SendKeys(driver, 10, checkNameField, checkName.trim());

					BaseSuite.reportLog("entered check name : " + checkName);

					cname = getAttribute(driver, checkNameField, "value");

					displayAndClick(driver, chooseAttribute);

				} else {

					cname = getAttribute(driver, checkNameField, "value");

					BaseSuite.reportLog("Default Check name is : " + cname);
				}
			} else {

				BaseSuite.reportFailLog("Check Name field not visible on current page", "enterCheckName");
			}
		} catch (Exception e) {

			clickOnCancelCheckButton();

			throw new Exception("Name field not found kindly check");
		}
		return cname;
	}

	// method to choose dimension of check from dropdown
	public String chooseDimensionOfCheck(String dName) {
		String dimensionname = null;
		try {

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", dimensionField);
			isDisplayed(driver, dimensionField);
			Actions action = new Actions(driver);
			if (isDisplayed(driver, dimensionField)) {

				BaseSuite.validationReportLog("Dimension field is visible");
				if (!dName.isEmpty()) {

					BaseSuite.reportLog("Checking on Dimension dropdown button");

					displayAndClick(driver, dimensionDropdownBtn);

					BaseSuite.validationReportLog("Checked on Dimension dropdown button");

					isDisplayed(driver, dimensiondropdownPopup);

					if (isDisplayed(driver, dimensiondropdownPopup)) {

						BaseSuite.reportLog("selecting dimension : " + dName);
						BaseSuite.reportLog("Clicking on dimesion: " + dName + " on dimension dropdown");
						action.click(driver.findElement(returnElement(selectdimansion, "$name", dName))).build()
								.perform();

						BaseSuite.validationReportLog("Clicked on dimension : " + dName);

						dimensionname = getAttribute(driver, dimensionField, "value");

						BaseSuite.validationReportLog("Dimesion :" + dimensionname + " is selected successfully");

					} else {
						BaseSuite.reportFailLog("Dimension dropdown window not visible", "chooseDimensionOfCheck");
					}
				} else {
					dimensionname = getAttribute(driver, dimensionField, "value");

					BaseSuite.reportLog("Default value for dimension is : " + dimensionname);
				}

			} else {
				BaseSuite.reportFailLog("Dimension field not visible on page", "chooseDimensionOfCheck");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return dimensionname;
	}

	// method to choose attribute
	public String chooseAttributeColumn(String columnName, SoftAssert soft) throws Exception, InterruptedException {
		String colName = null;

		String sname = null;
		try {
			if (!columnName.isEmpty()) {

				String type = columnName.split("\\.")[0];

				String colName1 = columnName.split("\\.")[1];

				if (colName1.contains("[")) {

					colName = colName1.replaceAll("\\[", "").replaceAll("\\]", "");

				} else {

					colName = colName1;
				}

				BaseSuite.reportLog("selecting Attribute column... " + columnName);

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", chooseAttrTitle);

				verifyIndividualLabel(driver, chooseAttrTitle, "Choose Attribute title");

				isDisplayed(driver, chooseAttrInput);

				if (isDisplayed(driver, chooseAttrInput)) {

					BaseSuite.reportLog("entering column name : " + colName + " in choose attribute field");

					Thread.sleep(1000);

					clear_Click_SendKeys(driver, 5, chooseAttrInput, colName.trim());

					BaseSuite.validationReportLog("Entered column name : " + colName);

					driver.findElement(chooseAttrInput).sendKeys(Keys.ENTER);

					Thread.sleep(2000);

					List<WebElement> columns = getElements(driver, attributeList);

					int count = columns.size();

					for (int i = 0; i < count; i++) {

						String columnname = columns.get(i).getAttribute("data-value");

						String atype = columnname.split("\\.")[0];

						String acolName = columnname.split("\\.")[1];

						isDisplayed(driver, chooseAttrInput);

						if (containsIgnoreCase(atype, type) && containsIgnoreCase(acolName, colName)) {

							// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
							// columns.get(i));

							BaseSuite.reportLog("Clicking on column : " + columnname);

							columns.get(i).click();

							BaseSuite.validationReportLog("Clicked on column : " + columnname);

							break;
						}
					}
					sname = getAttribute(driver, attributeValue, "data-value");

					if (!sname.isEmpty() || sname.trim().equalsIgnoreCase(columnName.trim())) {

						soft.assertTrue(true, "test4");

						BaseSuite.validationReportLog(sname + " column is selected");

					} else {

						soft.assertTrue(false, "test5");

						BaseSuite.reportFailLog("Column name not selected kindly check ", "chooseAttributeColumn");
					}

				}

			} else {
				soft.assertTrue(false, "test6");
				BaseSuite.reportFailLog("Choose attribute input field not visible", "chooseAttributeColumn");

			}
		} catch (Exception e) {
			e.getMessage();
			throw new NoSuchElementException("");
		}
		return sname;
	}

	// common method to validate and select expected check box checked or unchecked
	public boolean checkboxOfCheck(By locator, String label, String exstatus) throws java.lang.Exception {
		boolean acstatus = false;
		try {
			if (exstatus != null) {
				BaseSuite.reportLog("selecting " + label + " checkbox as : " + exstatus);
				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", locator);
				verifyIndividualLabel(driver, locator, label);

				isDisplayed(driver, locator);
				if (isDisplayed(driver, locator)) {

					switch (exstatus.toUpperCase()) {
					case "TRUE":
						String state = getAttribute(driver, locator, "class");
						acstatus = Boolean.parseBoolean(exstatus);

						if (state.contains("check")) {
							BaseSuite.reportLog(label + " checkbox is checked as expected");
						} else {
							clickOnButton(driver, locator, "Enable Status", acstatus);

							BaseSuite.validationReportLog(label + " checkbox is checked successfully");
						}
						break;
					case "FALSE":
						String sstate = getAttribute(driver, locator, "class");
						acstatus = Boolean.parseBoolean(sstate);

						if (!sstate.contains("check")) {
							BaseSuite.reportLog(label + " checkbox is checked as expected");
						} else {
							clickOnButton(driver, locator, "Enable Status", true);

							BaseSuite.validationReportLog(label + " checkbox is unchecked successfully");

						}
						break;
					default:
						BaseSuite.reportFailLog("Expected Condition not found kindly check input : " + exstatus,
								"checkboxOfCheck");
						break;
					}
				}
			} else {

				isDisplayed(driver, locator);
				String astate = getAttribute(driver, locator, "aria-checked");

				BaseSuite.reportLog(
						"expected input not provied hence , by default " + label + " checkbox is : " + astate);
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
		return acstatus;
	}

	// method to select enable status as true or false
	public String selectEnableStatusCheckbox(String exstatus) throws java.lang.Exception {
		String status1 = null;
		try {
			if (!exstatus.isEmpty()) {

				verifyIndividualLabel(driver, checkstatusLabel, "Status label");

				boolean st = checkboxOfCheck(checkstatusCheckbox, "Enable Status", exstatus);

				if (st) {
					status1 = "Active";

				} else {
					status1 = "Inactive";
				}

			} else {
				BaseSuite.reportFailLog("expected condition not found kindly check", "selectEnableStatusCheckbox");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}

		return status1;

	}

	// method to select trim data check box as true or false
	public boolean selectTrimDataCheckbox(String exstatus) throws java.lang.Exception {

		return checkboxOfCheck(trimDataCheckbox, "Trim Data ", exstatus);
	}

	// method to select empty string as null true or false
	public boolean selectEmptyStringCheckbox(String exstatus) throws java.lang.Exception {

		return checkboxOfCheck(emptyStringCheckbox, "Empty String as NULL", exstatus);
	}

	// method to select white space as null true or false
	public boolean selectWhiteSpaceCheckbox(String exstatus) throws java.lang.Exception {

		return checkboxOfCheck(whiteSpaceCheckbox, "White Space as NULL", exstatus);
	}

	public boolean selectIgnoreNullsCheckbox(String exstatus) throws java.lang.Exception {

		return checkboxOfCheck(ignorenulls, "Ignore NULLs", exstatus);
	}

	public boolean overrideExitCodeCheckbox(String exstatus) throws java.lang.Exception {

		return checkboxOfCheck(enableOverrideExitCode, "Override Exit Code", exstatus);
	}

	public boolean selectCaseInsensitive(String exstatus) throws Exception {
		boolean flag = false;

		try {
			return checkboxOfCheck(caseInsensitiveCheckbox, "Case Insensitive", exstatus);

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
		return flag;
	}

	// method to enter fixed string for completeness check
	public String enterFixedStringAsNullValue(String fixedstring) {

		String s = null;

		try {
			if (fixedstring != null) {

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", fixedStringTitle);

				verifyIndividualLabel(driver, fixedStringTitle, "Fixed Strig as Null");

				isDisplayed(driver, fixedStringInput);

				if (isDisplayed(driver, fixedStringInput)) {

					BaseSuite.validationReportLog("Fixed String as Null field is visible");

					BaseSuite.reportLog("Entering fixed string value : " + fixedstring);

					clear_Click_SendKeys(driver, 10, fixedStringInput, fixedstring);

					BaseSuite.validationReportLog("Entered fixed string value : " + fixedstring);

					s = getAttribute(driver, fixedStringInput, "value");

					if (s.equals(fixedstring)) {
						BaseSuite.validationReportLog("Excepted value and entered value matched successfully");
					} else {
						BaseSuite.reportFailLog("Excepted value and entered value not matched",
								"enterFixedStringAsNullValue");

					}

				} else {
					BaseSuite.reportFailLog("Fixed string as null field not visible kindly check",
							"enterFixedStringAsNullValue");
				}

			}
		} catch (Exception e) {
			e.getMessage();
		}
		return s;
	}

	// method to get check expression details on new check functionality
	public String getCheckInfoDetails() throws Exception {

		String cinfo = null;

		try {
			BaseSuite.reportLog("checking Check expression...");

			// javascript(driver,
			// "arguments[0].scrollIntoView({behavior:'smooth'});",checkInfotitle);

			// verifyIndividualLabel(driver, checkInfotitle, "Info label");
			isDisplayed(driver, checkInfoDetails);
			if (isDisplayed(driver, checkInfoDetails)) {

				BaseSuite.validationReportLog("Check expression field is visible");
				displayAndClick(driver, checkInfoDetails);
				BaseSuite.reportLog("verifying expression ");

				cinfo = getAttribute(driver, checkInfoDetails, "textContent");

				if (!cinfo.isEmpty()) {
					BaseSuite.validationReportLog(cinfo + " check expression is created");
				} else {
					BaseSuite.reportFailLog("Check expression not visible", "getCheckInfoDetails");
				}
			} else {
				BaseSuite.reportFailLog("Check expression details not visible", "getCheckInfoDetails");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}

		return cinfo;
	}

	// method to click on add button on check tab
	public void clickOnAddButton_checkTab() throws java.lang.Exception {

		try {
			BaseSuite.reportLog("Clicking on Add button on Check section");

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", addButtonchecktab);

			clickOnButton(driver, addButtonchecktab, "Add ", true);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// method to click on New check button on check tab
	public void clickOnNewCheckButtonOnCheckTab() throws java.lang.Exception {

		BaseSuite.reportLog("Clicking on New Check button on Check section");
		javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", newCheckButtonchecktab);
		clickOnButton(driver, newCheckButtonchecktab, "New Check ", true);
		isDisplayed(driver, chooseCheckTitle);
		if (!isDisplayed(driver, chooseCheckTitle)) {
			BaseSuite.reportFailLog("Getting Blank window on out of box expression", "clickOnNewCheckButtonOnCheckTab");
			isDisplayed(driver, newCheckClose);
			displayAndClick(driver, newCheckClose);
			clickOnAddButton_checkTab();
			clickOnNewCheckButtonOnCheckTab();
		}
	}

	/// method to click on test button on new check side pane
	public void clickOnTestButton() throws java.lang.Exception {

		BaseSuite.reportLog("Clicking on Test button on New Check pane");

		javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", testCheckButton);

		clickOnButton(driver, testCheckButton, " Test ", true);
	}

	/// method to click on Add check button on new check side pane
	public void clickOnAddNewCheckButton(SoftAssert soft) throws java.lang.Exception {
		try {
			BaseSuite.reportLog("Clicking on Save button on New Check pane");
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", addNewCheckButton);
			clickOnButton(driver, addNewCheckButton, "Save Check ", true);
			Thread.sleep(1000);
			if (isDisplayed(driver, checkNameLabel)) {
				BaseSuite.reportFailLog("Checks sidebar pane is open after clicking on save button kindly check",
						"clickOnAddNewCheckButton");
				throw new AssertionError("Checks sidebar pane is open after clicking on save button");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on Cancel button on new check side pane
	public void clickOnCancelCheckButton() throws java.lang.Exception {

		BaseSuite.reportLog("Clicking on Cancel button on New Check pane");

		clickOnButton(driver, cancelCheckButton, "Cancel Check ", true);
		isDisplayed(driver, checkNameLabel);
		if (isDisplayed(driver, checkNameLabel)) {
			BaseSuite.reportFailLog("Checks sidebar pane is open after clicking on cancel button kindly check",
					"clickOnAddNewCheckButton");
			throw new AssertionError("Checks sidebar pane is open after clicking on cancel button");
		}
	}

	// method to click on Back to checks button on new check side pane
	public void clickOnBackToChecksButton() throws java.lang.Exception {

		BaseSuite.reportLog("Clicking on Back to Checks button on New Check pane");

		clickOnButton(driver, backToChecksButton, "Back To Checks ", true);
	}

	// method to click on test execute button on new check functionality
	public void clickOnTestExecuteButton() throws java.lang.Exception {

		BaseSuite.reportLog("Clicking on Test Execute button on New Check pane");

		clickOnButton(driver, testExecuteButton, "Test Execute", true);
	}

	// method enter test value for check on new check functionality pane
	public void enterTestValue(String testvalue) {

		javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", testValueInput);
		BaseSuite.reportLog("entering test value : " + testvalue);
		clear_Click_SendKeys(driver, 10, testValueInput, testvalue);
		BaseSuite.validationReportLog("Entered test value : " + testvalue);
	}

	// method to get test output as true or false
	public String getTestOutput() throws InterruptedException {

		javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", testOutput);
		Thread.sleep(1000);
		String outputvalue = getAttribute(driver, testOutput, "value");
		BaseSuite.validationReportLog("test output value visible : " + outputvalue);

		return outputvalue;
	}

	// method to test check expression on new check pane
	public void testCheckExpression(String testdata, String expectedOutput, SoftAssert soft)
			throws java.lang.Exception {

		try {
			if (!testdata.isEmpty() && !expectedOutput.isEmpty()) {
				clickOnTestButton();

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", testTitle);

				verifyIndividualLabel(driver, testTitle, "Test ");
				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", testColumnInput);
				isDisplayed(driver, testColumnInput);
				String columnname = getAttribute(driver, testColumnInput, "value");

				enterTestValue(testdata);

				clickOnTestExecuteButton();
				Thread.sleep(2000);
				isDisplayed(driver, testOutput);
				String outputvalue = getTestOutput();

				soft.assertEquals(outputvalue, expectedOutput.toLowerCase(), "test8");
				BaseSuite.reportLog("For Column :" + columnname + " and entered test value : " + testdata);

				if (outputvalue.equalsIgnoreCase(expectedOutput)) {
					BaseSuite.validationReportLog("Expected test output : " + expectedOutput.toLowerCase()
							+ " and Actual : " + outputvalue + " matched");
				} else {

					BaseSuite.reportFailLog("Expected test output : " + expectedOutput.toLowerCase() + " and Actual : "
							+ outputvalue + " didn't matched", "testValueCheckExpression");

				}
			}
		} catch (InterruptedException e) {
			e.getMessage();
			throw new Exception("");
		}

	}

	public String setExpressionValue(DataTestingParameters p) {
		String xp1 = null;

		String xp = p.getChkExpression();

		if (xp.contains("\\")) {
			xp1 = xp.replaceAll("\\\\", "\"");
		} else {
			xp1 = xp;
		}

		return xp1;
	}

	// method to add new check of completeness for rule
	public void addCompletenessCheck(DataTestingParameters p, SoftAssert soft) throws java.lang.Exception {

		String checkName = p.getChkCheckName();
		String checkType = p.getChkCheckType();
		String checkStatus = p.getChkStatus();
		String checkColumnName = p.getChkColumnname();
		String checkTestValue = p.getChkTestValue1();
		String checkDimension = p.getChkDimension();
		String trimdata = p.getChkTrimData();
		String emptyString = p.getChkEmptyStringAsNull();
		String whiteSpace = p.getChkWhiteSpaceAsNull();
		String fixedString = p.getChkFixedStringAsNull();
		String chkTestOutput = p.getChkTestOutput();
		String chkExpression = setExpressionValue(p);
		try {
			// clickOnAddButton_checkTab();
			// clickOnCheck_AddButton();
			clickOnNewCheckButtonOnCheckTab();

			validateNewCheckPane();
			clickOnCheckType(checkType);
			String cname = enterCheckName(checkName);

			// chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
			// String st = selectEnableStatusCheckbox(checkStatus);

			String attrname = chooseAttributeColumn(checkColumnName, soft);

			selectTrimDataCheckbox(trimdata);

			selectEmptyStringCheckbox(emptyString);

			selectWhiteSpaceCheckbox(whiteSpace);

			enterFixedStringAsNullValue(fixedString);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

			// testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// // Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}

	}

	public void addCompletenessCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		String chkExpression = setExpressionValue(p);

		try {
			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(completenessCheck, "Completeness");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				selectTrimDataCheckbox(p.getChkTrimData());

				selectEmptyStringCheckbox(p.getChkEmptyStringAsNull());

				selectWhiteSpaceCheckbox(p.getChkWhiteSpaceAsNull());

				enterFixedStringAsNullValue(p.getChkFixedStringAsNull());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {
					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			} else {
				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");

			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	public void updateCompletenessCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		String chkExpression = setExpressionValue(p);

		boolean updateAddflag = false;

		try {
			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddflag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(check_add_NewCustCheckbutton, "Custom");

			} else {
				updateAddflag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {
				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddflag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);
				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				selectTrimDataCheckbox(p.getChkTrimData());

				selectEmptyStringCheckbox(p.getChkEmptyStringAsNull());

				selectWhiteSpaceCheckbox(p.getChkWhiteSpaceAsNull());

				enterFixedStringAsNullValue(p.getChkFixedStringAsNull());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {
					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddflag) {
						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");
					} else {
						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			} else {
				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");

			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	public String checkExpression(String checkType, String columnName1) {

		return checkType + "Check(\"" + columnName1 + "\")";

		// return s;

	}

	/* method to validate added check detail in checks section pane */
	public void validateAddedCheckDetails(String checkName, String expression, String checkType, String status,
			SoftAssert soft) throws Exception {

		try {
			BaseSuite.reportLog("Verifying Added check details in checks table");

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
					returnElement(checkNametable, "$name", checkName));

			isDisplayed(driver, returnElement(checkNametable, "$name", checkName.trim()));

			if (isDisplayed(driver, returnElement(checkNametable, "$name", checkName.trim()))) {

				BaseSuite.validationReportLog("Newly added check is visible in checks table :" + checkName);

				List<WebElement> details = getElements(driver, returnElement(checkdetails, "$name", checkName.trim()));

				List<String> list = new ArrayList<>();

				for (WebElement d : details) {
					list.add(d.getAttribute("textContent"));
				}

				String name = list.get(0).trim();
				String expressions = list.get(1).trim();
				// String type = list.get(2).trim();
				/** String dimensions=list.get(3); */
				String st1 = list.get(2).trim();
				if (!checkName.isEmpty()) {
					soft.assertEquals(name.trim(), checkName.trim(), "test9");
					if (name.trim().equalsIgnoreCase(checkName.trim())) {
						BaseSuite.validationReportLog(
								"Expected check name: " + checkName + " and Actual : " + name.trim());
					} else {
						BaseSuite.reportFailLog("Expression name not matched", "validateAddedCheckDetails");
					}
				}
				if (!expression.isEmpty()) {
					soft.assertEquals(expressions.trim(), expression.trim(), "test10");
					if (expressions.trim().equalsIgnoreCase(expression.trim())) {
						BaseSuite.validationReportLog(
								"Expected expression: " + expression + " and Actual : " + expressions.trim());
					} else {
						BaseSuite.reportFailLog("Expression not matched", "validateAddedCheckDetails");
					}
				}
				/*
				 * if (!checkType.isEmpty()) { soft.assertEquals(type.trim(), checkType.trim(),
				 * "test11"); if (type.trim().equalsIgnoreCase(checkType.trim())) {
				 * BaseSuite.validationReportLog( "Expected check type: " + checkType +
				 * " and Actual : " + type.trim()); } else {
				 * BaseSuite.reportFailLog("Expression type not matched",
				 * "validateAddedCheckDetails"); } }
				 */
				/**
				 * soft.assertEquals(dimensions.trim(), dimension.trim()); //
				 * BaseSuite.validationReportLog("Expected dimension: "+dimension+" and Actual :
				 * "+dimensions.trim());
				 */
				if (!status.isEmpty()) {
					soft.assertEquals(st1.trim(), status.trim(), "test12");
					if (st1.trim().equalsIgnoreCase(status.trim())) {
						BaseSuite.validationReportLog("Expected status : " + status + " and Actual : " + st1.trim());
					} else {
						BaseSuite.reportFailLog("Expected status : " + status + " and Actual : " + st1.trim(),
								"validateAddedCheckDetails");
					}
				}

			} else {
				BaseSuite.reportFailLog("Expected check name not found kindly check ", "validateAddedCheckDetails");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to select length check operator and value
	public void selectLengthOperatorAndValue(String checkOperator, String value1, String value2)
			throws Exception, InterruptedException {

		try {
			if (!checkOperator.isEmpty()) {

				BaseSuite.reportLog("Verifying attribute column ");

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", attributeInput);

				isDisplayed(driver, attributeInput);

				if (isDisplayed(driver, attributeInput)) {

					BaseSuite.validationReportLog("Attribute column is visible ");

					String cname = getAttribute(driver, attributeInput, "value");

					BaseSuite.validationReportLog("Selected column is : " + cname);

					BaseSuite.reportLog("Clicking on operator's drop down button");

					isDisplayed(driver, attributeOperatorDD);

					Thread.sleep(1000);

					displayAndClick(driver, attributeOperatorDD);

					Thread.sleep(2000);

					BaseSuite.validationReportLog("Checked on operator's drop down successfully");

					BaseSuite.reportLog("Clicking on operator name : " + checkOperator);

					displayAndClick(driver, returnElement(chooseOperator, "$name", checkOperator));

					isDisplayed(driver, lengthOperatorField);

					String op = getAttribute(driver, lengthOperatorField, "textContent");

					if (op.trim().equalsIgnoreCase(checkOperator.trim())) {

						BaseSuite.validationReportLog("Checked on operator name :" + checkOperator + " successfully");

					} else {

						BaseSuite.reportFailLog(checkOperator + " operator not selected kindly check ",
								"selectLengthOperatorAndValue");
						throw new AssertionError("");
					}
					if (checkOperator.equalsIgnoreCase("between")) {

						BaseSuite.reportLog("Entering last value : " + value2);

						isDisplayed(driver, operatorValue2);

						displayAndClick(driver, operatorValue2);

						clear_SendKeys(driver, operatorValue2, value2);

						BaseSuite.validationReportLog("Entered last value : " + value2 + " successfully");

						BaseSuite.reportLog("Entering first value : " + value1);

						isDisplayed(driver, operatorValue1);

						clear_Click_SendKeys(driver, 10, operatorValue1, value1);

						BaseSuite.validationReportLog("Entered first value : " + value1 + " successfully");

					} else {
						BaseSuite.reportLog("Entering value : " + value1);

						isDisplayed(driver, operatorValue1);

						clear_Click_SendKeys(driver, 10, operatorValue1, value1);

						BaseSuite.validationReportLog("Entered value : " + value1 + " successfully");
					}

				} else {
					BaseSuite.reportFailLog("Attribute Column not visible ", "selectLengthOperatorAndValue");
					throw new AssertionError();
				}
			} else {
				BaseSuite.reportErrorLog("Input value not provided kindly check");
				throw new AssertionError();
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to add length check out of box expression
	public void addLengthCheck(DataTestingParameters param, SoftAssert soft) throws java.lang.Exception {

		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkColumnName = param.getChkColumnname();
		String checkTestValue = param.getChkTestValue1();
		String checkDimension = param.getChkDimension();
		String ignoreNulls = param.getChkIgnoreNulls();
		String chkOperator = param.getChkOperator();
		String chkOpvalue1 = param.getChkOperatorValue1();
		String chkOpvalue2 = param.getChkOperatorValue2();
		String chkTestOutput = param.getChkTestOutput();
		String chkExpression = setExpressionValue(param);
		try {
			// clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab();
			// clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

			// chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
			// String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeColumn(checkColumnName, soft);

			selectLengthOperatorAndValue(chkOperator, chkOpvalue1, chkOpvalue2);

			selectIgnoreNullsCheckbox(ignoreNulls);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

			// testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to select contains check value
	public String selectContainsCheckValue(String containsValue) {

		String val = null;
		try {
			BaseSuite.reportLog("Entering value : " + containsValue);

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", operatorValue1);

			clear_Click_SendKeys(driver, 10, operatorValue1, containsValue);

			BaseSuite.validationReportLog("Entered value : " + containsValue + " successfully");

			val = getAttribute(driver, operatorValue1, "value");

		} catch (Exception e) {

			e.getMessage();
		}
		return val;

	}

	public void addLengthCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		String chkExpression = setExpressionValue(p);
		try {

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(lengthCheck, "Length");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				String attrname = chooseAttributeColumn(p.getChkColumnname(), soft);

				selectLengthOperatorAndValue(p.getChkOperator(), p.getChkOperatorValue1(), p.getChkOperatorValue2());

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");
					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());
					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");
					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));
					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}
				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {
					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			} else {
				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");
			}
		} catch (java.lang.Exception e) {

			throw new Exception("");
		}
	}

	public void updateLengthCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		String chkExpression = setExpressionValue(p);

		boolean updateAddFlag = false;
		try {

			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddFlag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(lengthCheck, "Length");
			} else {
				updateAddFlag = true;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddFlag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				String attrname = chooseAttributeColumn(p.getChkColumnname(), soft);

				selectLengthOperatorAndValue(p.getChkOperator(), p.getChkOperatorValue1(), p.getChkOperatorValue2());

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");
					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());
					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");
					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));
					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}
				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddFlag) {
						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");
					} else {
						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			} else {
				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");
			}
		} catch (java.lang.Exception e) {

			throw new Exception("");
		}
	}

	// method to add contains check out of box expression
	public void addContainsCheck(DataTestingParameters param, SoftAssert soft) throws Throwable {

		String containsvalue = null;
		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkColumnName = param.getChkColumnname();
		String checkTestValue = param.getChkTestValue1();
		String checkDimension = param.getChkDimension();
		String trimdata = param.getChkTrimData();
		String chkignorenulls = param.getChkIgnoreNulls();
		String chkTestOutput = param.getChkTestOutput();
		String chkExpression = setExpressionValue(param);
		if (param.getChkInputValue().contains("[")) {
			containsvalue = param.getChkInputValue().replaceAll("\\[", "").replaceAll("\\]", "");
		} else {
			containsvalue = param.getChkInputValue();
		}
		try {
			// clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab();
			// clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

			// chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
			// String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeColumn(checkColumnName, soft);

			selectContainsCheckValue(containsvalue);

			selectTrimDataCheckbox(trimdata);

			selectIgnoreNullsCheckbox(chkignorenulls);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

			// testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}

	}

	// method to add contains check out of box expression
	public void addContainsCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		try {
			String containsvalue = null;

			String chkExpression = setExpressionValue(p);

			if (p.getChkInputValue().trim().contains("[")) {

				containsvalue = p.getChkInputValue().replaceAll("\\[", "").replaceAll("\\]", "");

				containsvalue = containsvalue.replace("\\", "\"");

				containsvalue = containsvalue.replace(" ", "");

			} else {

				containsvalue = p.getChkInputValue();
			}

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(containsCheck, "Contains");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				selectContainsCheckValue(containsvalue);

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}

				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			}

			else {

				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");

			}

		} catch (java.lang.Exception e) {

			throw new Exception("");
		}

	}

	// method to update contains check out of box expression
	public void updateContainsCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		try {
			boolean updateAddFlag = false;

			String containsvalue = null;

			String chkExpression = setExpressionValue(p);

			if (p.getChkInputValue().trim().contains("[")) {

				containsvalue = p.getChkInputValue().replaceAll("\\[", "").replaceAll("\\]", "");

				containsvalue = containsvalue.replace("\\", "\"");

				containsvalue = containsvalue.replace(" ", "");

			} else {

				containsvalue = p.getChkInputValue();
			}

			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddFlag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(containsCheck, "Contains");
			} else {
				updateAddFlag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddFlag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				selectContainsCheckValue(containsvalue);

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}

				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddFlag) {
						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");
					} else {
						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			}

			else {

				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");

			}

		} catch (java.lang.Exception e) {

			throw new Exception("");
		}

	}

	// method to add new check out of box expression in checks section
	// note : here sheet name is for checks details excel sheet and CheckType name
	// should provide from rule details sheet
	public void addNewCheckUsingExcelData(String filename, String sheetname, String columnname, SoftAssert soft)
			throws Throwable {

		DataTestingPage dp = new DataTestingPage(driver);
		try {
			int row1;

			String[] ct = columnname.split(",");
			int count = getcount(columnname, ',');

			for (int i = 0; i <= count; i++) {

				if (!ct[i].isEmpty()) {
					row1 = findRow(filename, sheetname, ct[i]);
					if (row1 != 0) {
						BaseSuite.reportLog(
								"============   Adding check expression : " + ct[i] + "   ==================");
						// Thread.sleep(1000);

						DataTestingParameters p = setChecksParametersUsingExcel(filename, sheetname, row1);
						String ctype = p.getChkCheckType();
						BaseSuite.reportLog("---------------- Adding " + ctype + " check expression --------------");
						if (!ctype.isEmpty()) {
							switch (ctype.toLowerCase().trim()) {

							case "completeness": // adding completeness check expression
								addCompletenessCheck(p, soft);
								break;

							case "length": // adding Length check expression
								addLengthCheck(p, soft);
								break;

							case "contains": // adding contains check expression
								addContainsCheck(p, soft);
								break;

							case "range": // adding range check expression
								addRangeCheck(p, soft);
								break;

							case "pattern": // adding pattern check expression
								addPatternCheck(p, soft);
								break;

							case "date": // adding date check expression
								addDateCheck(p, soft);
								break;

							case "custom": // adding custom check expression from new check
								addCustomExpressionCheckFromNewCheck(p, soft);
								break;

							case "datatype": // adding datatype check expression
								addDatatypeCheck(p, soft);
								break;

							case "calculated": // adding calculated check expression
								addCalculatedCheck(p, soft);
								break;

							case "conditional": // adding condtional check expression
								// addConditionalCheck(p, soft);
								break;

							case "newcustom": // adding new custom check
								addCustomCheckExpression(p, soft);
								break;

							case "addcolumn": // add columns as check to rules.
								addColumnCheckToRule(p, soft);
								break;
							default:
								BaseSuite.reportFailLog("No Check type found kindly check ", "addNewCheck");
								break;
							}
						} else {
							BaseSuite.reportFailLog("Check type not found kindly check for : " + ct[i], "addNewCheck");
						}
					}
				} else {
					BaseSuite.reportFailLog("Check details not found kindly check for : " + ct[i], "addNewCheck");
				}
			}
		} catch (Exception e) {
			throw new Exception("");
		}
	}

	// Add check using json Api
	public void addNewCheckUsingJSONTestData(String ruleType, String jsonEntity, int expression, SoftAssert soft,
			String icedqRole, String workspaceId, String sourceQuery, String targetQuery) throws Throwable {
		String ctype = null;
		try {
			DataTestingParameters p = setChecksParametersUsingApi(jsonEntity, ruleType, expression);

			if (p.getChkCheckType() != null) {
				ctype = p.getChkCheckType();
			}
			BaseSuite.reportLog("---------------- Adding " + ctype + " check expression --------------");
			if (!ctype.isEmpty()) {
				switch (ctype.toLowerCase().trim()) {

				case "custom": // adding new custom check
					addCustomCheckExpression(p, ruleType, jsonEntity, expression, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "completeness": // adding completeness check expression
					addCompletenessCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "length": // adding Length check expression
					addLengthCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "contains": // adding contains check expression
					addContainsCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "datatype": // adding datatype check expression
					addDatatypeCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "pattern": // adding pattern check expression
					addPatternCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "range": // adding range check expression
					addRangeCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "date": // adding date check expression
					addDateCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "newcustom": // adding custom check expression from new check
					addCustomExpressionCheckFromNewCheck(p, soft);
					break;

				case "calculated": // adding calculated check expression
					addCalculatedCheck(p, ruleType, jsonEntity, expression, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "conditional": // adding condtional check expression
					// addConditionalCheck(p, soft);
					break;

				case "column": // add columns as check to rules.
					addColumnCheckToRuleApi(p, soft);
					break;

				default:
					BaseSuite.reportFailLog("No Check type found kindly check ", "addNewCheck");
					break;
				}
			} else {
				BaseSuite.reportFailLog("Check type not found kindly check for : ", "addNewCheck");
			}

		} catch (Exception e) {

			throw new NoSuchElementException("");
		}
	}

	// Update check using json Api
	public void updateCheckUsingJSONTestData(String ruleType, String jsonEntity, int expression, SoftAssert soft,
			String icedqRole, String workspaceId, String sourceQuery, String targetQuery) throws Throwable {
		String ctype = null;
		try {
			DataTestingParameters p = setChecksParametersUsingApi(jsonEntity, ruleType, expression);

			if (p.getChkCheckType() != null) {
				ctype = p.getChkCheckType();
			}
			BaseSuite.reportLog("---------------- Adding " + ctype + " check expression --------------");
			if (!ctype.isEmpty()) {
				switch (ctype.toLowerCase().trim()) {

				case "custom": // adding new custom check
					updateCustomCheckExpression(p, ruleType, jsonEntity, expression, icedqRole, workspaceId,
							sourceQuery, targetQuery);
					break;

				case "completeness": // adding completeness check expression
					updateCompletenessCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId,
							sourceQuery, targetQuery);
					break;

				case "length": // adding Length check expression
					updateLengthCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "contains": // adding contains check expression
					updateContainsCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "datatype": // adding datatype check expression
					updateDatatypeCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "pattern": // adding pattern check expression
					updatePatternCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "range": // adding range check expression
					updateRangeCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "date": // adding date check expression
					updateDateCheck(p, ruleType, jsonEntity, expression, soft, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "newcustom": // adding custom check expression from new check
					addCustomExpressionCheckFromNewCheck(p, soft);
					break;

				case "calculated": // adding calculated check expression
					updateCalculatedCheck(p, ruleType, jsonEntity, expression, icedqRole, workspaceId, sourceQuery,
							targetQuery);
					break;

				case "conditional": // adding condtional check expression
					// addConditionalCheck(p, soft);
					break;

				case "column": // add columns as check to rules.
					updateColumnCheckToRuleApi(p, soft);
					break;

				default:
					BaseSuite.reportFailLog("No Check type found kindly check ", "updateNewCheck");
					break;
				}
			} else {
				BaseSuite.reportFailLog("Check type not found kindly check for : ", "updateNewCheck");
			}

		} catch (Exception e) {

			throw new NoSuchElementException("");
		}
	}

	public void handleDiscardPopupWindowOnChecks() {

		isDisplayed(driver, discardPopupMsg);

		if (isDisplayed(driver, discardPopupMsg)) {

			BaseSuite.reportLog("Discard popup window is visible");

			String discardMsg = getText(driver, discardPopupMsg);
			if (!discardMsg.isEmpty()) {
				BaseSuite.reportLog("Discard message : " + discardMsg);
			} else {
				BaseSuite.reportFailLog("Discard message not found ", discardMsg);
			}
			BaseSuite.reportLog("Click on Discard button");

			displayAndClick(driver, discardPopupBtn);

			BaseSuite.reportLog("Clicked on Discard button successfully");
		}
	}

	public static int findRow(String file, String sheet, String value) throws IOException {
		// to find row number so we can search through that specific column
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);

		XLUtils xl = new XLUtils();
		int gotRow = 0;
		int rownum = 0;
		int rowCount = xl.getRowCount(file, sheet);

		for (int j = 0; j <= rowCount; j++) {
			rownum = j + 1;
			row = ws.getRow(rownum); // for(int i=0;i<row.getLastCellNum();i++) { cell =
			row.getCell((0));

			final DataFormatter df = new DataFormatter();
			final XSSFCell cellVal = cell;
			String valueAsString = df.formatCellValue(cellVal);
			if (valueAsString.equals(value)) {
				gotRow = row.getRowNum();
				break;
			}

		}
		return gotRow;
	}

	// method to click on exception report node on flow diagram
	public void clickOnExceptionReportNode() throws java.lang.Exception {
		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", exceptionReportNode1);
			clickOnButton(driver, exceptionReportNode1, "Exception Report Node", true);
		} catch (Exception e) {
			throw new Exception("Exception found at exception report tab kindly check :: " + e.getMessage());
		}
	}

	// method to validate exception report tab
	public void validateExceptionReportTab(String ruleType) {

		try {
			// validating exception report settings tab
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", tabTitle);

			verifyVisibilityOfButtons(driver, tabTitle, "Exception report Settings", true);

			// validating export file format
			verifyIndividualLabel(driver, exportfiletitle, "Export File Format");

			verifyVisibilityOfButtons(driver, exportfileFieldBox, "Export file format field ", true);

			verifyVisibilityOfButtons(driver, exportFileDropdownArrow, "Export file format dropdown", true);

			String text = getAttribute(driver, exportfileFieldBox, "value");

			if (text.equalsIgnoreCase("Excel")) {

				BaseSuite.validationReportLog("Default value for export file format is :: " + text);

			} else {

				BaseSuite.reportFailLog("Default value of export file format is :: " + text,
						"validateExceptionReportTab ");
			}
			// validating enable store failure and errors only field

			verifyIndividualLabel(driver, enableStoreFailureErrorsOnly, "Store Failure Error Only");

			isClickable(driver, enableStoreFailureErrorsOnly, "Store Failure Error Only", true);

			String checkbox = getAttribute(driver, enableStoreFailureErrorsOnly, "class");

			if (checkbox.contains("check")) {

				BaseSuite.validationReportLog("Store Failure Error Only field checkbox is checked");

			} else {

				if (ruleType.equalsIgnoreCase("pushdown")) {

					BaseSuite.validationReportLog(
							"Store Failure Error Only field checkbox  is not checked as field is disable for Pushdown rule");
				} else {
					BaseSuite.reportFailLog("Store Failure Error Only field checkbox  is not checked",
							" validateExceptionReportTab ");

				}
			}

			// validating enable storeExported file only field
			verifyIndividualLabel(driver, enableStoreExportedFileOnly, "Store Exported File Only");

			String disable = getAttribute(driver, enableStoreExportedFileOnly, "class");

			if (disable.contains("check")) {

				BaseSuite.reportFailLog("Store Exported File Only field checkbox  is checked",
						" validateExceptionReportTab ");

			} else {

				BaseSuite.validationReportLog("Store Exported File Only field checkbox is not checked");
			}
			// String checkbox1 = getAttribute(driver, enableStoreExportedFileOnly,
			// "class");
			// if (checkbox1.contains("check")) {
			// BaseSuite.validationReportLog("Enable Store Exported File Only field checkbox
			// is not checked");
			// } else {
			// BaseSuite.reportFailLog("Enable Store Exported File Only field checkbox is
			// checked","validateExceptionReportTab");

			// }

			verifyIndividualLabel(driver, showDownloadExpetionUrl, "Store Exported File Only");

			String disable1 = getAttribute(driver, showDownloadExpetionUrl, "class");

			if (disable1.contains("check")) {

				BaseSuite.validationReportLog("Show Download Eception Url field checkbox is checked");

			} else {

				BaseSuite.reportFailLog("Show Download Eception Url check box is not check",
						"validateExceptionReportTab");
			}

			// validating store only field
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", storeOnlyLabel);

			boolean flag = verifyIndividualLabel(driver, storeOnlyLabel, "Store Only");

			if (flag) {

				BaseSuite.validationReportLog("Store Only rowa is enable");

			} else {

				BaseSuite.reportFailLog("Store Only rowa is disable", "validateExceptionReportTab");
			}

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", rowsTitle);

			verifyIndividualLabel(driver, rowsTitle, "Rows");
			// validating exception report table
			BaseSuite.reportLog("checking exception report table's column visibility ");

			List<WebElement> headers = getElements(driver, head);

			BaseSuite.reportLog("Number of exception report column : " + headers.size());

			for (int a = 0; a < headers.size(); a++) {

				String colName = headers.get(a).getText();

				boolean state = headers.get(a).isDisplayed();

				if (state) {

					BaseSuite.validationReportLog(colName + " column is visible ");

				} else {

					BaseSuite.reportFailLog(colName + "column not visible", "validateExceptionReportTab");
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// method to validate exception report table in filtered check types
	public void verifyExceptionReportTable() {

		try {
			BaseSuite.reportLog("Verifying Exception report table ...");
			BaseSuite.reportLog("Checking number of expression");
			List<WebElement> rows = getElements(driver, expressionTypeList);
			BaseSuite.reportLog("Total number of expression displayed in exception report table : " + rows.size());

			List<String> types = new ArrayList<String>();
			for (WebElement t : rows) {
				types.add(t.getText().trim());
			}
			// getting count of specific expression type
			List<String> uniquetype = types.stream().distinct().collect(Collectors.toList());
			for (int i = 0; i < uniquetype.size(); i++) {
				int count = Collections.frequency(types, uniquetype.get(i));
				BaseSuite.validationReportLog("Number of expression for " + uniquetype.get(i) + " is  : " + count);

			}
			for (int j = 0; j < uniquetype.size(); j++) {

				int count = Collections.frequency(types, uniquetype.get(j));
				BaseSuite.reportLog("----------------------------------------");
				validateExceptionReportData(uniquetype.get(j).trim(), count);

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to validate exception report data for particular check type in a table
	public void validateExceptionReportData(String checkType, int size) {

		BaseSuite.reportLog("Verifying exception report expressions for : " + checkType + " type checks");
		// getting column names
		List<WebElement> headers = getElements(driver, head);
		List<String> head = new ArrayList<String>();
		for (WebElement t : headers) {
			head.add(t.getText().trim());
		}
		switch (checkType.toLowerCase()) {
		case "diffjoin":
			// getting details of diff join for recon
			BaseSuite.reportLog("Verifying diff join type for Recon in exception report");
			List<WebElement> dif = getElements(driver, diffJoinDetails);
			for (int i = 0; i < dif.size(); i++) {

				String col = head.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth'});",
						dif.get(i));
				String det = dif.get(i).getText();
				switch (col.toLowerCase()) {
				case "show":
				case "status":

					break;
				default:
					BaseSuite.validationReportLog(col + " : " + det);
					break;
				}
			}
			break;
		case "resulttype":

			BaseSuite.reportLog("Verifying ResultType for Validation in exception report");
			List<WebElement> exDetails = getElements(driver, returnElement(expressionDetails, "$name", "ResultType"));
			for (int i = 0; i < exDetails.size(); i++) {

				String col = head.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth'});",
						exDetails.get(i));
				String det = exDetails.get(i).getText();
				switch (col.toLowerCase()) {
				case "show":
				case "status":

					break;
				default:
					BaseSuite.validationReportLog(col + " : " + det);
					break;
				}

			}
			break;
		default:
			// getting exception report details of expression
			List<String> names = new ArrayList<String>();
			List<WebElement> exDetails1 = getElements(driver, returnElement(expressionDetails, "$name", checkType));
			int c = 0;
			for (int j = 0; j < size; j++) {
				BaseSuite.reportLog("Verifying " + (j + 1) + ". " + checkType + " check details");
				for (int k = 0; k < head.size(); k++) {

					String col = head.get(k);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth'});",
							exDetails1.get(k));
					String value = exDetails1.get(c).getText();
					BaseSuite.validationReportLog(col + " : " + value);
					if (col.equalsIgnoreCase("name")) {
						names.add(value);
					}
					if (col.equalsIgnoreCase("Show")) {

						String status = getAttribute(driver, returnElement(statusOfCheck, "$name", names.get(j)),
								"aria-checked");

						if (status.equalsIgnoreCase("true")) {
							BaseSuite.validationReportLog("Visible checkbox is selected ");
						} else {
							BaseSuite.validationReportLog("Visible checkbox is not selected");
						}
					}
					c++;
				}
			}
			break;
		}
		BaseSuite.validationReportLog("Verified exception report expressions for : " + checkType + " type checks");
	}

	// method to click on data testing link in breadcrumb
	public void clickOnDataTestingLink() throws java.lang.Exception {

		clickOnButton(driver, brdCrumsDataTesting, "Data Testing ", true);

		isDisplayed(driver, discardButtons);

		if (isDisplayed(driver, discardButtons)) {
			clickOnButton(driver, discardButtons, "Discard ", true);
		}

	}

	// method to click on exception report node on flow diagram
	public void clickOnCheckNode1() throws Exception {

		try {
			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			BaseSuite.reportLog("Clicking on  Check tab node in flow diagram ");
			javascript(driver, "arguments[0].scrollIntoView(true);", checknode);

			BaseSuite.reportLog("Clicking on Check tab node button/link/field");

			isDisplayed(driver, checknode);
			if (isDisplayed(driver, checknode)) {
				// wait = waitMethod(driver);
				int i = 0;
				do {
					displayAndClick(driver, checknode);
					i++;
				} while (i <= 2);

				BaseSuite.validationReportLog("Check tab node button clicked successfully");
			} else {
				BaseSuite.reportFailLog("Check tab node button not visible", "clickOnCheckNode1");
			}

			verifyVisibilityOfButtons(driver, checkActiveButton, "Activate Button", false);

			verifyVisibilityOfButtons(driver, checkDeactiveButton, "Deactivate Button", false);

			verifyVisibilityOfButtons(driver, checkDeleteButton, "Delete Button", false);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("Exection found for checks tab , kindly check :: " + e.getMessage());
		}
	}

	public boolean checkExpression(String actualExp, String expectedExp, SoftAssert soft) throws Exception {

		boolean flag = false;

		if (!expectedExp.isEmpty()) {

			BaseSuite.validationReportLog("Retrived Expression is :" + actualExp);

			BaseSuite.validationReportLog("Expected Expression is :" + expectedExp.trim());

			soft.assertEquals(actualExp.trim(), expectedExp.trim(), "test13");

			if (actualExp.trim().equalsIgnoreCase(expectedExp.trim())) {
				flag = true;
				BaseSuite.validationReportLog("Expressions matched successfully");
			} else {
				flag = false;
				BaseSuite.reportFailLog(" Messages didn't match", "checkExpression");
			}
		}
		return flag;

	}

	// method to validate result type of rule on exception report setting
	public void validateResultType(String resultType, SoftAssert soft) {
		try {
			BaseSuite.reportLog("Verifying Result type in exception report ");
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
					returnTwoElements(tdxpath, "$row", "1", "$name", "Expression"));

			isDisplayed(driver, returnTwoElements(tdxpath, "$row", "1", "$name", "Expression"));

			String rtype = getText(driver, returnTwoElements(tdxpath, "$row", "1", "$name", "Expression"));

			BaseSuite.validationReportLog("Retrived Result type  : " + rtype);
			BaseSuite.validationReportLog("Expected Result type  : " + resultType);
			soft.assertEquals(rtype, resultType, "test14");
			if (rtype.trim().equalsIgnoreCase(resultType.trim())) {
				BaseSuite.validationReportLog(
						"Expected result type :" + resultType + " and Actual result type : " + rtype + " are matched");
			} else {
				BaseSuite.reportFailLog("Expected and actual result type not matched", "validateResultType");

			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void checkExpressionsOnExceptionReport(DataTestingParameters param, SoftAssert soft) {
		int customCount = 0;
		int colCount = 0;
		int diffJoinCount = 0;
		try {
			BaseSuite.reportLog("Verifying exception report data");
			if (!param.getChk_CustExpressions().isEmpty()) {
				customCount = param.getChk_CustExpressions().trim().split(",").length;
			}
			if (!param.getChk_ColumnNames().isEmpty()) {
				colCount = param.getChk_ColumnNames().trim().split(",").length;
			}

			if (!param.getJoinColumnName().isEmpty()) {
				diffJoinCount = param.getJoinColumnName().trim().split(",").length;
			}
			List<WebElement> rows = getElements(driver, expressionTypeList);

			List<String> types = new ArrayList<String>();
			for (WebElement t : rows) {
				types.add(t.getText().trim());
			}

			if (customCount > 0) {
				int count1 = Collections.frequency(types, "Custom");
				soft.assertEquals(count1, customCount, "test15");
				BaseSuite.validationReportLog("Retrived number of Custom Expressions : " + count1);
				BaseSuite.validationReportLog("Expected number of Custom Expressions : " + customCount);

				if (count1 == customCount) {
					BaseSuite.validationReportLog("Custom expressions count matched successfully");
				} else {
					BaseSuite.reportFailLog("Custom Expression count not matched", "checkExpressionsOnExceptionReport");
				}

			}
			if (colCount > 0) {
				int count11 = Collections.frequency(types, "Column");
				soft.assertEquals(count11, colCount, "test16");
				BaseSuite.validationReportLog("Retrived number of Column Expressions : " + count11);
				BaseSuite.validationReportLog("Expected number of Column Expressions : " + colCount);

				if (count11 == colCount) {
					BaseSuite.validationReportLog("Column expressions count matched successfully");
				} else {
					BaseSuite.reportFailLog("Column Expression count not matched", "checkExpressionsOnExceptionReport");
				}

			}

			if (param.getRuleType().equalsIgnoreCase("Recon") || param.getRuleType().equalsIgnoreCase("HT Recon")) {
				if (diffJoinCount > 0) {

					int count11 = Collections.frequency(types, "DiffJoin");
					soft.assertEquals(count11, diffJoinCount, "Value didn't matched");
					BaseSuite.validationReportLog("Retrived number of DiffJoin Expressions : " + count11);
					BaseSuite.validationReportLog("Expected number of DiffJoin Expressions : " + diffJoinCount);

					if (count11 == diffJoinCount) {
						BaseSuite.validationReportLog("DiffJoin expressions count matched successfully");
					} else {
						BaseSuite.reportFailLog("DiffJoin Expression count not matched",
								"checkExpressionsOnExceptionReport");
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String setInputValue1(DataTestingParameters p) {
		String xp1 = null;

		String xp = p.getChkOperatorValue1();

		if (xp.contains("\\")) {
			xp1 = xp.replaceAll("\\\\", "'").replace('\'', '\"').replaceAll("\\[", "").replaceAll("\\]", "");
		} else {
			xp1 = xp.replaceAll("\\[", "").replaceAll("\\]", "");
		}

		return xp1;
	}

	public String setInputValue2(DataTestingParameters p) {
		String xp1 = null;

		String xp = p.getChkOperatorValue2();

		if (xp.contains("\\")) {
			xp1 = xp.replaceAll("\\\\", "'").replace('\'', '\"').replaceAll("\\[", "").replaceAll("\\]", "");
		} else {
			xp1 = xp.replaceAll("\\[", "").replaceAll("\\]", "");
		}

		return xp1;
	}

	// method to add new check for Range Check
	public void addRangeCheck(DataTestingParameters param, SoftAssert soft) throws java.lang.Exception {

		String checkName = param.getChkCheckName();// for entering check name
		String checkType = param.getChkCheckType();// selecting checktype for checkdetails
		String checkStatus = param.getChkStatus();// selecting exp status
		String checkColumnName = param.getChkColumnname();
		String checkTestValue = param.getChkTestValue1();
		String checkDimension = param.getChkDimension();
		String ignoreNulls = param.getChkIgnoreNulls();
		String chkOperator = param.getChkOperator();
		String chkOpvalue1 = setInputValue1(param);
		String chkOpvalue2 = setInputValue2(param);
		String chkTestOutput = param.getChkTestOutput();
		String chkExpression = setExpressionValue(param);// selecting expression

		try {
			// clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab();
			// clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

//			chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
//			String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeColumn(checkColumnName, soft);

			selectLengthOperatorAndValue(chkOperator, chkOpvalue1, chkOpvalue2);

			selectIgnoreNullsCheckbox(ignoreNulls);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

//			testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to add new check for Range Check
	public void addRangeCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws java.lang.Exception {

		String chkExpression = setExpressionValue(p);// selecting expression

		try {

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(rangeCheck, "Range");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				selectLengthOperatorAndValue(p.getChkOperator(), p.getChkOperatorValue1(), p.getChkOperatorValue2());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");
					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());
					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {

						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));
					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addRangeCheck");
				}
			} else {

				BaseSuite.reportFailLog("Range Check pane is displaye , but without UI content. Kindly check. ",
						"addRangeCheck");
			}

		} catch (Exception e) {

			throw new Exception("");
		}
	}

	// method to update new check for Range Check
	public void updateRangeCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws java.lang.Exception {

		String chkExpression = setExpressionValue(p);// selecting expression

		try {

			boolean updateAddFlag = false;

			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddFlag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(rangeCheck, "Range");
			} else {
				updateAddFlag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddFlag) {

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				} else {

					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				selectLengthOperatorAndValue(p.getChkOperator(), p.getChkOperatorValue1(), p.getChkOperatorValue2());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");
					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());
					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {

						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));
					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");
				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddFlag) {

						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");

					} else {

						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addRangeCheck");
				}
			} else {

				BaseSuite.reportFailLog("Range Check pane is displaye , but without UI content. Kindly check. ",
						"addRangeCheck");
			}

		} catch (Exception e) {

			throw new Exception("");
		}
	}

	// method to add new check for pattern check
	public void addPatternCheck(DataTestingParameters param, SoftAssert soft) throws java.lang.Exception {

		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkColumnName = param.getChkColumnname();
		// String checkTestValue = param.getChkTestValue1();
		// String checkDimension = param.getChkDimension();
		String checkPatternValue = param.getChkPatternType();
		String ignoreNulls = param.getChkIgnoreNulls();
		// String chkTestOutput = param.getChkTestOutput();
		String chkExpression = setExpressionValue(param);
		String chkOpvalue1 = param.getChkDateRegex();

		try {
			// clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab();
			// clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

			// chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
			// String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeColumn(checkColumnName, soft);

			choosePattern(checkPatternValue, soft);

			if (checkPatternValue.equalsIgnoreCase("custom")) {
				selectRegexForCustomPattern(chkOpvalue1, soft);
			}

			selectIgnoreNullsCheckbox(ignoreNulls);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

			// testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to choose pattern from choose pattern field
	public void choosePattern(String patternvalue, SoftAssert soft) {

		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", choosePatternLabel);

			isDisplayed(driver, choosePatternLabel);

			verifyIndividualLabel(driver, choosePatternLabel, "Choose Pattern");

			BaseSuite.reportLog("verifying available pattern list");

			List<WebElement> patternList = getElements(driver, listOfPatternChip);

			int count = patternList.size();

			for (int i = 0; i < count; i++) {

				String patternName = patternList.get(i).getText();

				if (!patternName.isEmpty()) {

					BaseSuite.validationReportLog((i + 1) + ". " + patternName + " pattern is visible");
				}

			}

			BaseSuite.reportLog("selecting pattern : " + patternvalue);

			isDisplayed(driver, returnElement(selectPatternChip, "$name", patternvalue.trim()));

			if (isDisplayed(driver, returnElement(selectPatternChip, "$name", patternvalue.trim()))) {

				String val = getAttribute(driver, returnElement(selectPatternChip, "$name", patternvalue.trim()),
						"aria-selected");

				if (!val.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(selectPatternChip, "$name", patternvalue.trim()));

					BaseSuite.validationReportLog("Pattern : " + patternvalue + " is selected successfully");
				} else {
					BaseSuite.validationReportLog("Pattern : " + patternvalue + " is already selected");
				}

			} else {
				BaseSuite.reportFailLog("Expected pattern value not visible kindly check " + patternvalue,
						"choosePattern");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add regex for custom pattern
	public void selectRegexForCustomPattern(String customPattern, SoftAssert soft) {

		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", choosePatternRegexlabel);

			isDisplayed(driver, choosePatternRegexlabel);

			verifyIndividualLabel(driver, choosePatternRegexlabel, "Custom Pattern Regex");

			javascript(driver, "arguments[0].scrollIntoView(true);", choosePatternRegexStar);

			isDisplayed(driver, choosePatternRegexStar);

			if (isDisplayed(driver, choosePatternRegexStar)) {

				BaseSuite.validationReportLog("Regex mandatory field star is visible");
			} else {
				BaseSuite.reportFailLog("Regex mandatory field star not visible", "selectRegexForCustomPattern");
			}

			isDisplayed(driver, choosePatternCustomInput);

			if (isDisplayed(driver, choosePatternCustomInput)) {

				String regexplace = getAttribute(driver, choosePatternCustomInput, "placeholder");

				BaseSuite.validationReportLog("Retrived Regex place holder is :" + regexplace);

				BaseSuite.validationReportLog(
						"Expected Regex place holder is : Ex:- /^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/");

				soft.assertEquals(regexplace, "Ex:- /^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/", "test17");

				if (regexplace.equalsIgnoreCase("Ex:- /^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")) {
					BaseSuite.validationReportLog("Regex place holder matched successfully");
				} else {
					BaseSuite.reportFailLog(" Regex place holder didn't match", "selectRegexForCustomPattern");
				}

				if (!customPattern.isEmpty()) {

					BaseSuite.reportLog("Entering Regex value : " + customPattern);

					clear_Click_SendKeys(driver, 10, choosePatternCustomInput, customPattern);

					String cp = getAttribute(driver, choosePatternCustomInput, "value");

					if (!cp.isEmpty()) {
						BaseSuite.validationReportLog("Entered Regex value : " + cp + " successfully");
					} else {
						BaseSuite.reportFailLog("Entered regex value not found kindly check",
								"selectRegexForCustomPattern");
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add new check for date out of box expression
	public void addDateCheck(DataTestingParameters param, SoftAssert soft) throws java.lang.Exception {

		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkColumnName = param.getChkColumnname();
		// String checkTestValue = param.getChkTestValue1();
		// String checkDimension = param.getChkDimension();
		String ignoreNulls = param.getChkIgnoreNulls();
		// String chkTestOutput = param.getChkTestOutput();
		String chkExpression = setExpressionValue(param);
		String chkDateFormat = param.getChkDateFormat();
		String chkDateRegex = param.getChkDateRegex();

		try {
			// clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab();
			// clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

//				chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
//				String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeColumn(checkColumnName, soft);

			chooseFormatForDateCheck(chkDateFormat);

			if (chkDateFormat.equalsIgnoreCase("custom")) {

				customDateFormat(chkDateRegex);

			}

			selectIgnoreNullsCheckbox(ignoreNulls);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

//				testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

//				captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to add new check for date out of box expression
	public void addDateCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws java.lang.Exception {

		try {

			String chkExpression = setExpressionValue(p);

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(dateCheck, "Date");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				chooseFormatForDateCheck(p.getChkDateFormat());

				if (p.getChkDateFormat().equalsIgnoreCase("custom")) {

					customDateFormat(p.getChkDateRegex());

				}

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(

							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(

							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {
					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {
					BaseSuite.reportFailLog("Actual and entered Date check value not match successfully,Kindly check!",
							"addDateCheck");
				}

			} else {
				BaseSuite.reportFailLog("Date Check pane is displayed,but without UI content. Kindly check. ",
						"addDateCheck");

			}
		} catch (Exception e) {

			throw new Exception("");
		}

	}

	// method to update new check for date out of box expression
	public void updateDateCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws java.lang.Exception {

		try {
			boolean updateAddFlag = false;

			String chkExpression = setExpressionValue(p);

			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddFlag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(dateCheck, "Date");
			} else {
				updateAddFlag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddFlag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				chooseFormatForDateCheck(p.getChkDateFormat());

				if (p.getChkDateFormat().equalsIgnoreCase("custom")) {

					customDateFormat(p.getChkDateRegex());

				}

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(

							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(

							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {
					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddFlag) {

						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");

					} else {

						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {
					BaseSuite.reportFailLog("Actual and entered Date check value not match successfully,Kindly check!",
							"addDateCheck");
				}

			} else {
				BaseSuite.reportFailLog("Date Check pane is displayed,but without UI content. Kindly check. ",
						"addDateCheck");

			}
		} catch (Exception e) {

			throw new Exception("");
		}

	}

	// method to choose format for date check from choose format field
	public void chooseFormatForDateCheck(String dateFormat) {

		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", chooseFormatlabel);

			isDisplayed(driver, chooseFormatlabel);

			verifyIndividualLabel(driver, chooseFormatlabel, "Choose Pattern");

			BaseSuite.reportLog("verifying available pattern list");

			BaseSuite.reportLog("Clicking on Choose Format input field dropdown button");

			isDisplayed(driver, chooseFormatDropdown);

			displayAndClick(driver, chooseFormatDropdown);

			BaseSuite.validationReportLog("Clicked on Choose Format field dropdown button successfully");

			BaseSuite.reportLog("verifying choose format list...");

			isDisplayed(driver, chooseFormatDropdownlist);

			List<WebElement> dateformatlist = getElements(driver, chooseFormatDropdownlist);

			int count = dateformatlist.size();

			for (int i = 0; i < count; i++) {

				String dateformat = dateformatlist.get(i).getText();

				if (!dateformat.isEmpty()) {

					BaseSuite.validationReportLog((i + 1) + ". " + dateformat + " format is visible");
				}
			}

			BaseSuite.reportLog("selecting Date Format : " + dateFormat);

			isDisplayed(driver, returnElement(selectChooseFormat, "$format", dateFormat.trim()));

			if (isDisplayed(driver, returnElement(selectChooseFormat, "$format", dateFormat.trim()))) {

				displayAndClick(driver, returnElement(selectChooseFormat, "$format", dateFormat.trim()));

				BaseSuite.validationReportLog("Date format : " + dateFormat + " is selected successfully");

			} else {
				BaseSuite.reportFailLog("Expected pattern value not visible kindly check " + dateFormat,
						"choosePattern");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add custom date format after selecting custom in choose format in
	// date check
	public void customDateFormat(String customformat) {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", customFormatInput);

			isDisplayed(driver, customFormatInput);

			if (isDisplayed(driver, customFormatInput)) {
				String regexplace = getAttribute(driver, customFormatInput, "placeholder");

				BaseSuite.validationReportLog("Retrived custom format placeholder is :" + regexplace);

				BaseSuite.validationReportLog("Expected custom format placeholder is : Ex:- dd-mm-yy");

				if (regexplace.equalsIgnoreCase("Ex:- dd-mm-yy")) {

					BaseSuite.validationReportLog("Custom format placeholder matched successfully");

				} else {

					BaseSuite.reportFailLog("Custom format placeholder didn't match", "selectRegexForCustomPattern");
				}
				if (!customformat.isEmpty()) {

					BaseSuite.reportLog("Entering custom format value : " + customformat);

					clear_Click_SendKeys(driver, 10, customFormatInput, customformat);

					String cp = getAttribute(driver, customFormatInput, "value");

					if (!cp.isEmpty()) {

						BaseSuite.validationReportLog("Entered custom format value : " + cp + " successfully");

					} else {

						BaseSuite.reportFailLog("Entered custom format value not found kindly check",
								"selectRegexForCustomPattern");
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add custom date format after selecting custom in choose format in
	// date check
	public void customDateFormat(String customformat, SoftAssert soft) {
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", customFormatLabel);

			isDisplayed(driver, customFormatLabel);

			verifyIndividualLabel(driver, customFormatLabel, "Custom Format");

			isDisplayed(driver, customFormatInput);

			if (isDisplayed(driver, customFormatInput)) {

				String regexplace = getAttribute(driver, customFormatInput, "placeholder");

				BaseSuite.validationReportLog("Retrived custom format placeholder is :" + regexplace);

				BaseSuite.validationReportLog("Expected custom format placeholder is : Ex:- dd-mm-yy");

				soft.assertEquals(regexplace, "Ex:- dd-mm-yy", "test18");

				if (regexplace.equalsIgnoreCase("Ex:- dd-mm-yy")) {
					BaseSuite.validationReportLog("Custom format placeholder matched successfully");
				} else {
					BaseSuite.reportFailLog("Custom format placeholder didn't match", "selectRegexForCustomPattern");
				}

				if (!customformat.isEmpty()) {

					BaseSuite.reportLog("Entering custom format value : " + customformat);

					clear_Click_SendKeys(driver, 10, customFormatInput, customformat);

					String cp = getAttribute(driver, customFormatInput, "value");

					if (!cp.isEmpty()) {
						BaseSuite.validationReportLog("Entered custom format value : " + cp + " successfully");
					} else {
						BaseSuite.reportFailLog("Entered custom format value not found kindly check",
								"selectRegexForCustomPattern");
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add new check for custom check out of box expression
	public void addCustomExpressionCheckFromNewCheck(DataTestingParameters param, SoftAssert soft)
			throws java.lang.Exception {

		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkDimension = param.getChkDimension();
		String chkExpression = setExpressionValue(param);
		String checkTestValue = param.getChkTestValue1();
		String checkTestValue2 = param.getChkTestValue2();
		String chkTestOutput = param.getChkTestOutput();

		try { // clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab(); // clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

			chooseDimensionOfCheck(checkDimension.trim());

			String st = selectEnableStatusCheckbox(checkStatus);

			String exp = enterExpressionInCustomField(chkExpression);

			// testValueCheckExpression(checkTestValue, checkTestValue2, chkTestOutput,
			// soft); testFunctionalityForChecks(checkTestValue, chkTestOutput, soft);
			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule Process");

			validateAddedCheckDetails(cname, exp, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to validate test functionality in check section using 2 test value
	public void testValueCheckExpression(String test1, String test2, String expectedOutput, SoftAssert soft)
			throws java.lang.Exception {

		try {
			if (!test1.isEmpty() && !expectedOutput.isEmpty()) {
				clickOnTestButton();

				javascript(driver, "arguments[0].scrollIntoView(true);", testTitle);

				verifyIndividualLabel(driver, testTitle, "Test ");
				javascript(driver, "arguments[0].scrollIntoView(true);", testColumnInput);
				String columnname = getAttribute(driver, testColumnInput, "value");

				javascript(driver, "arguments[0].scrollIntoView(true);", checkTestValue1);
				BaseSuite.reportLog("entering test value 1 : " + test1);
				clear_Click_SendKeys(driver, 10, checkTestValue1, test1);
				BaseSuite.validationReportLog("Entered test value 1 : " + test1);

				javascript(driver, "arguments[0].scrollIntoView(true);", checkTestValue2);
				BaseSuite.reportLog("entering test value 2 : " + test2);
				clear_Click_SendKeys(driver, 10, checkTestValue2, test2);
				BaseSuite.validationReportLog("Entered test value 2 : " + test2);

				clickOnTestExecuteButton();
				Thread.sleep(2000);
				isDisplayed(driver, testOutput);
				String outputvalue = getTestOutput();

				soft.assertEquals(outputvalue, expectedOutput.toLowerCase(), "test19");
				if (outputvalue.equalsIgnoreCase(expectedOutput.trim())) {
					BaseSuite.validationReportLog(
							"Expected test output : " + expectedOutput.toLowerCase() + " and Actual : " + outputvalue);
					BaseSuite.validationReportLog("Test output matched successfully");
				} else {
					BaseSuite.reportFailLog(" Test output didn't match", "testValueCheckExpression");

				}

			}
		} catch (InterruptedException e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to add expression in custom field for custom check
	public String enterExpressionInCustomField(String expression) {
		String cp = null;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", check_custCol_textarea);

			BaseSuite.reportLog("Entering Custom Expression value : " + expression);

			isDisplayed(driver, check_custCol_textarea);

			displayAndClick(driver, check_custCol_textarea);

			clear_Click_SendKeys(driver, 10, check_custCol_textarea, expression);

			cp = getAttribute(driver, check_custCol_textarea, "value");

			if (!cp.isEmpty()) {
				BaseSuite.validationReportLog("Entered custom Expression value : " + cp + " successfully");
			} else {
				BaseSuite.reportFailLog("Entered custom Expression value not found kindly check",
						"enterExpressionInCustomField");
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return cp;
	}

	public void selectShowDownloadExceptionUrl(String expStatus, SoftAssert soft) throws java.lang.Exception {

		try {

			if (!expStatus.isEmpty()) {

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", showDownloadExpetionUrl);

				BaseSuite.reportLog("selecting Show Download Exception URL as " + expStatus);

				isDisplayed(driver, showDownloadExpetionUrl);

				if (isDisplayed(driver, showDownloadExpetionUrl)) {

					String status = getAttribute(driver, showDownloadExpetionUrl, "class");

					if ((!status.contains("check") && expStatus.equalsIgnoreCase("true"))
							|| (status.contains("check") && expStatus.equalsIgnoreCase("false"))) {

						clickOnButton(driver, showDownloadExpetionUrl, "Show Download Exception URL", true);

						BaseSuite.validationReportLog("Show Download Exception URL field is checked as " + expStatus);

					} else if ((status.contains("check") && expStatus.equalsIgnoreCase("true"))
							|| (!status.contains("check") && expStatus.equalsIgnoreCase("false"))) {

						BaseSuite.validationReportLog(
								"Show Download Exception URL field is already selected as expected " + expStatus);
					} else {

						BaseSuite.reportFailLog("show download exception url not working kindly check",
								"selectShowDownloadExceptionUrl");
					}
				} else {

					soft.assertTrue(false, "test49");
					BaseSuite.reportFailLog("Show Download Exception URL field is not visible",
							"selectShowDownloadExceptionUrl");
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on delete button on data testing page
	public void clickOnDeleteButton() throws java.lang.Exception {

		clickOnButton(driver, deleteButton, "Delete", true);

	}

	// method to validate Delete alert pop up window -data testing landing page
	public void validateDeletePopUpWindow() {

		try {

			isDisplayed(driver, deleteHeader);

			if (isDisplayed(driver, deleteHeader)) {

				verifyIndividualLabel(driver, deleteHeader, "Delete Rule");
				verifyRetrivedValues(driver, deleteText, "Delete Rule message", deleteMsg1);
				verifyVisibilityOfButtons(driver, deleteDelBtn, "Delete", true);
				verifyVisibilityOfButtons(driver, deleteCancelBtn, "Cancel", true);
			} else {
				BaseSuite.reportFailLog("Delete pop up window not visible", "validateDeletePopUpWindow");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to delete rule on data testing landing page - single rule delete
	public void deleteRuleFromDataTestingLandingPage(DataTestingParameters param, SoftAssert soft) throws Throwable {
		boolean sstatus = false;

		sstatus = searchRuleOnDataTestingLandingPage(param.getFolderName(), param.getRuleName().trim(), soft);

		try {
			if (sstatus) {
				clickOnRuleCheckbox(param.getRuleName().trim());

				clickOnDeleteButton();

				validateDeletePopUpWindow();

				clickOnButton(driver, deleteDelBtn, "Delete", true);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				captureToastMsg(driver, toastMsg, toastMsgClosedBtn, deleteToastMsg, "Rule Delete");

				boolean sstatus1 = searchRuleOnDataTestingLandingPage(param.getFolderName(), param.getRuleName().trim(),
						soft);

				soft.assertEquals(sstatus1, false, "Not matched");
				if (sstatus1 == false) {
					BaseSuite.validationReportLog("Rule " + param.getRuleName() + " is deleted successfully");
				} else {
					BaseSuite.reportFailLog("Rule not deleted kindly check", checkDetailInExReport);
				}
				BaseSuite.validationReportLog("Verified Delete functionality");
			} else {

				soft.assertTrue(sstatus, "test25");

				BaseSuite.reportFailLog("No records found kindly check rule name : " + param.getRuleName(),
						"deleteRuleFromDataTestingLandingPage");

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to delete rule on data testing landing page - multiple rules delete
	public void deleteMultipleRulesFromDataTestingLandingPage(DataTestingParameters param, SoftAssert soft)
			throws Throwable {
		boolean sstatus = false;

		try {
			String[] ct = param.getRuleName().split(",");
			int count = getcount(param.getRuleName(), ',');

			for (int i = 0; i <= count; i++) {

				sstatus = searchRuleOnDataTestingLandingPage(param.getFolderName(), ct[i].trim(), soft);

				if (sstatus) {

					clickOnRuleCheckbox(param.getRuleName().trim());

				} else {
					soft.assertTrue(sstatus, "test26");
					BaseSuite.reportFailLog("No records found kindly check rule name : " + ct[i],
							"deleteRuleFromDataTestingLandingPage");
				}
			}

			clickOnDeleteButton();

			validateDeletePopUpWindow();

			clickOnButton(driver, deleteDelBtn, "Delete", true);

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			captureToastMsg(driver, toastMsg, toastMsgClosedBtn, deleteToastMsg, "Rule Delete");

			BaseSuite.validationReportLog("Verified Delete functionality");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to validate delete pop up window inside rule
	public void validateDeletePopUpWindowInsideRule() {

		try {
			isDisplayed(driver, deleteHeader);

			if (isDisplayed(driver, deleteHeader)) {

				verifyIndividualLabel(driver, deleteHeader, "Delete Rule");
				verifyRetrivedValues(driver, deleteText, "Delete Rule message", deleteMsg2);
				verifyVisibilityOfButtons(driver, deleteDelBtn, "Delete", true);
				verifyVisibilityOfButtons(driver, deleteCancelBtn, "Cancel", true);
			} else {
				BaseSuite.reportFailLog("Delete pop up window not visible", "validateDeletePopUpWindow");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on search rule name on data testing landing page
	public void search_And_clickOnRuleNameOnDataTestingPage(DataTestingParameters param, SoftAssert soft)
			throws Throwable {

		searchRuleOnDataTestingLandingPage(param.getFolderName(), param.getRuleName().trim(), soft);

		clickOnButton(driver, returnElement(ruleNameLink, "$name", param.getRuleName()), param.getRuleName(), true);
	}

	// method to delete rule on data testing landing page - single rule delete
	public void deleteRuleFromRuleDetailsPage(String ruleName, SoftAssert soft) throws Throwable {
		try { // boolean sstatus = false;

			clickOnButton(driver, deleteButtoninsideRule, "Delete", true);

			validateDeletePopUpWindowInsideRule();

			clickOnButton(driver, deleteDelBtn, "Delete", true);

			captureToastMsg(driver, toastMsg, toastMsgClosedBtn, deleteToastMsg, "Rule Delete");

			inVisible(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// method to click on page arrow using : next,last,previous,first value
	public void clickOnPageArrow(String pageArrow) {

		try {
			BaseSuite.reportLog("verifying Page arrow for " + pageArrow.toLowerCase() + " page");

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
					returnElement(pageArrowName, "$name", pageArrow.toLowerCase()));

			isDisplayed(driver, returnElement(pageArrowName, "$name", pageArrow.toLowerCase()));

			if (isDisplayed(driver, returnElement(pageArrowName, "$name", pageArrow.toLowerCase()))) {

				BaseSuite.reportLog(pageArrow + " page arrow is visible ");

				String status1 = getAttribute(driver, returnElement(pageArrowName, "$name", pageArrow.toLowerCase()),
						"class");

				if (status1.contains("disable")) {
					BaseSuite.reportFailLog("Page arrow :: " + pageArrow + " is disabled", "clickOnPageArrow");
				} else {
					BaseSuite.validationReportLog("Page arrow :: " + pageArrow + " is enabled");
				}

				BaseSuite.reportLog("Clicking on " + pageArrow + " page ");

				displayAndClick(driver, returnElement(pageArrowName, "$name", pageArrow.toLowerCase()));

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Clicked On " + pageArrow + " page successfully");

				BaseSuite.reportLog("Verifying page details after clicked on " + pageArrow.toLowerCase() + " page");

				getPaginationDetails(pageMsg, pageArrows);
			} else {
				BaseSuite.reportFailLog(pageArrow + " page arrow is not visible kindly check", "clickOnPageArrow");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on page number from pagination on data testing page
	public void clickOnPageNumberOnDataTestingPage(String pageNum) {

		try {
			BaseSuite.reportLog("verifying Page number : " + pageNum + " is visible or not");

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", pageBar);

			isDisplayed(driver, returnElement(pageNumber, "$num", pageNum.trim()));

			if (isDisplayed(driver, returnElement(pageNumber, "$num", pageNum.trim()))) {

				BaseSuite.reportLog("Page number : " + pageNum + " is visible");

				BaseSuite.reportLog("Clicking on page " + pageNum);

				displayAndClick(driver, returnElement(pageNumber, "$num", pageNum.trim()));

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Clicked On page number : " + pageNum + " successfully");

				BaseSuite.reportLog("Verifying page details after clicked on page " + pageNum);

				getPaginationDetails(pageMsg, pageArrows);
			} else {
				BaseSuite.reportFailLog("Page number " + pageNum + " is not visible kindly check",
						"clickOnPageNumberOnDataTestingPage");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to checked or unchecked enable store failure and errors only true for
	// checked false for unchecked
	public boolean enableStoreFailureAndErrorsOnly(String ruleType, String storeFailureStatus, SoftAssert soft)
			throws Throwable {
		boolean flag = false;
		try {
			if (ruleType.equalsIgnoreCase("pushdown")) {
				String status = getAttribute(driver, storeExportedFileCheckboxDisabeEnable, "class");

				if (status.contains("disabled")) {

					BaseSuite.validationReportLog("Store Failure & Errors Only check box is disable for pushdown rule");

					flag = false;

				} else {
					BaseSuite.validationReportLog("Store Failure & Errors Only check box is enable for pushdown rule");
				}
			} else {
				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", enableStoreFailureErrorsOnly);

				if (!storeFailureStatus.isEmpty()) {

					BaseSuite.reportLog("selecting Enable Store Failure & Errors only as " + storeFailureStatus);
					isDisplayed(driver, enableStoreFailureErrorsOnly);
					if (isDisplayed(driver, enableStoreFailureErrorsOnly)) {
						String status = getAttribute(driver, enableStoreFailureErrorsOnly, "class");

						if (!status.contains("check") && storeFailureStatus.equalsIgnoreCase("true")) {

							clickOnButton(driver, enableStoreFailureErrorsOnly, "Enable Store Failure & Errors only",
									true);

							BaseSuite.validationReportLog(
									"Enable Store Failure & Error only field is checked as " + storeFailureStatus);

							flag = true;

						} else if (status.contains("check") && storeFailureStatus.equalsIgnoreCase("false")) {

							clickOnButton(driver, enableStoreFailureErrorsOnly, "Enable Store Failure & Errors only",
									true);

							BaseSuite.validationReportLog(
									"Enable Store Failure & Error only field is checked as " + storeFailureStatus);

							flag = false;

						} else if (status.contains("check") && storeFailureStatus.equalsIgnoreCase("true")) {

							BaseSuite.validationReportLog(
									"Enable Store Failure & Error only field is checked as " + storeFailureStatus);

							flag = true;

						}

						else {

							BaseSuite.validationReportLog(
									"Enable Store Failure & Error only field is checked as " + storeFailureStatus);
							flag = false;
						}

					} else {
						soft.assertTrue(false, "test29");
						BaseSuite.reportFailLog("Enable store failure and errors only field is not visible",
								"enableStoreFailureAndErrorsOnly");
					}
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	// method to checked or unchecked store exported file only true for
	// checked false for unchecked
	public boolean enableStoreExportedFileOnly(String storeExportedFileStatus, SoftAssert soft) throws Throwable {
		boolean flag = false;
		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", enableStoreExportedOnly);

			if (!storeExportedFileStatus.isEmpty()) {

				BaseSuite.reportLog("selecting Enable Store Failure & Errors only as " + storeExportedFileStatus);

				isDisplayed(driver, enableStoreExportedOnly);

				if (isDisplayed(driver, enableStoreExportedOnly)) {

					String status = getAttribute(driver, enableStoreExportedOnly, "class");

					if (!status.contains("check") && storeExportedFileStatus.equalsIgnoreCase("true")) {

						clickOnButton(driver, enableStoreExportedOnly, "Enable Store Exported File only", true);

						BaseSuite.validationReportLog(
								"Enable Store Exported File only field is checked as " + storeExportedFileStatus);

						flag = true;

					} else if (status.contains("check") && storeExportedFileStatus.equalsIgnoreCase("false")) {

						clickOnButton(driver, enableStoreExportedOnly, "Enable Store Failure & Errors only", true);

						BaseSuite.validationReportLog(
								"Enable Store Exported File only field is checked as " + storeExportedFileStatus);

						flag = false;

					} else {

						BaseSuite.validationReportLog(
								"Store Exported File only field is checked as " + storeExportedFileStatus);
						flag = false;
					}

				} else {

					soft.assertTrue(false, "test29");

					BaseSuite.reportFailLog("Store Exported File only field is not visible",
							"enableStoreExportedFileOnly");
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	// method to choose datatype format in datatype check of out of box expression
	// choosedatypeformat ex. Date, Interger, float
	// Note choosedatatypeformat value should have capital first letter
	public void chooseDatatype(String choosedatypeformat) {

		try {
			if (!choosedatypeformat.isEmpty()) {
				BaseSuite.reportLog("selecting datatype format...");

				javascript(driver, "arguments[0].scrollIntoView(true);", choosedataTypeLabel);

				verifyIndividualLabel(driver, choosedataTypeLabel, "Choose Datatype");

				List<WebElement> dt = getElements(driver, choosedatatypeField);
				BaseSuite.reportLog("verifying default datype ...");
				for (int i = 0; i < dt.size(); i++) {

					String datatype = dt.get(i).getAttribute("aria-label");
					if (!datatype.isEmpty()) {
						BaseSuite.reportLog((i + 1) + ". " + datatype + " is visible");
					} else {
						BaseSuite.reportFailLog("Datatype name not found kindly check " + datatype, "chooseDatatype");
					}
				}
				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnElement(selectChooseDatatype, "$name", choosedatypeformat));

				isDisplayed(driver, returnElement(selectChooseDatatype, "$name", choosedatypeformat));

				if (isDisplayed(driver, returnElement(selectChooseDatatype, "$name", choosedatypeformat))) {

					BaseSuite.reportLog("selecting datatype as " + choosedatypeformat);

					displayAndClick(driver, returnElement(selectChooseDatatype, "$name", choosedatypeformat));

					BaseSuite.validationReportLog(choosedatypeformat + " is selected successfully");
				} else {
					BaseSuite.reportFailLog("Datatype not found kindly check " + choosedatypeformat, "chooseDatatype");
				}
			} else {
				BaseSuite.reportFailLog("Datatype not provied kindly check " + choosedatypeformat, "chooseDatatype");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to choose date format in datatype check of out of box expression
	// Note : need to pass dateformat and if dateformat is custom then customformat
	// need to pass
	public void chooseDatatypeDateFormat(String dateFormat, String customformat, SoftAssert soft) {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", choosedatatypeDateFormatDD);

			BaseSuite.reportLog("verifying available Date format list");

			BaseSuite.reportLog("Clicking on Choose Date Format input field dropdown button");

			isDisplayed(driver, choosedatatypeDateFormatDD);

			displayAndClick(driver, choosedatatypeDateFormatDD);

			BaseSuite.validationReportLog("Clicked on Choose Date Format field dropdown button successfully");

			BaseSuite.reportLog("verifying choose Date format list...");

			isDisplayed(driver, chooseDatatypeDateFormatDDlist);

			List<WebElement> dateformatlist = getElements(driver, chooseDatatypeDateFormatDDlist);

			int count = dateformatlist.size();

			for (int i = 0; i < count; i++) {

				String dateformat = dateformatlist.get(i).getText();

				if (!dateformat.isEmpty()) {

					BaseSuite.validationReportLog((i + 1) + ". " + dateformat + " format is visible");
				}
			}

			javascript(driver, "arguments[0].scrollIntoView(true);",
					returnElement(chooseDatatypeDateFormatInput, "$format", dateFormat.trim()));

			BaseSuite.reportLog("selecting Date Format : " + dateFormat);

			isDisplayed(driver, returnElement(chooseDatatypeDateFormatInput, "$format", dateFormat.trim()));

			if (isDisplayed(driver, returnElement(chooseDatatypeDateFormatInput, "$format", dateFormat.trim()))) {

				displayAndClick(driver, returnElement(chooseDatatypeDateFormatInput, "$format", dateFormat.trim()));

				BaseSuite.validationReportLog("Date format : " + dateFormat + " is selected successfully");

			} else {
				BaseSuite.reportFailLog("Expected pattern value not visible kindly check " + dateFormat,
						"chooseDatatypeDateFormat");
			}

			if (dateFormat.equalsIgnoreCase("custom")) {

				javascript(driver, "arguments[0].scrollIntoView(true);", choosedatatypeDateCustomFormatlabel);

				isDisplayed(driver, choosedatatypeDateCustomFormatlabel);

				verifyIndividualLabel(driver, choosedatatypeDateCustomFormatlabel, "Date Format");

				isDisplayed(driver, choosedatatypedateCustomFormatInput);

				if (isDisplayed(driver, choosedatatypedateCustomFormatInput)) {

					String regexplace = getAttribute(driver, choosedatatypedateCustomFormatInput, "placeholder");

					BaseSuite.validationReportLog("Retrived Date format placeholder is :" + regexplace);

					BaseSuite.validationReportLog("Expected Date format placeholder is : Ex:- dd-mm-yy");

					soft.assertEquals(regexplace, "Ex:- dd-mm-yy");

					if (regexplace.equalsIgnoreCase("Ex:- dd-mm-yy")) {
						BaseSuite.validationReportLog("Custom format placeholder matched successfully");
					} else {
						BaseSuite.reportFailLog("Custom format placeholder didn't match",
								"chooseDatatypeDateFormatDDlist");
					}

					if (!customformat.isEmpty()) {

						BaseSuite.reportLog("Entering custom Date format value : " + customformat);

						clear_Click_SendKeys(driver, 10, choosedatatypedateCustomFormatInput, customformat);

						String cp = getAttribute(driver, choosedatatypedateCustomFormatInput, "value");

						if (!cp.isEmpty()) {
							BaseSuite.validationReportLog("Entered custom date format value : " + cp + " successfully");
						} else {
							BaseSuite.reportFailLog("Entered custom format value not found kindly check",
									"chooseDatatypeDateFormatDDlist");
						}
					} else {
						BaseSuite.reportFailLog("custom format value not provided", "chooseDatatypeDateFormatDDlist");
					}
				} else {
					BaseSuite.reportFailLog("custom format Input field not visible", "chooseDatatypeDateFormatDDlist");
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add DataTypeCheck from new check of out of box expression
	public void addDatatypeCheck(DataTestingParameters param, SoftAssert soft) throws Throwable {
		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkColumnName = param.getChkColumnname();
		String checkTestValue = param.getChkTestValue1();
		String checkDimension = param.getChkDimension();
		String ignoreNulls = param.getChkIgnoreNulls();
		String chkTestOutput = param.getChkTestOutput();
		String chkExpression = setExpressionValue(param);
		String chkOpvalue1 = param.getChkDateRegex();
		String checkPatternValue = param.getChkDateFormat();
		String datatype = param.getChkDataType();

		try {
			// clickOnAddButton_checkTab();

			clickOnNewCheckButtonOnCheckTab();
			// clickOnCheck_AddButton();
			validateNewCheckPane();

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

			// chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
//				String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeColumn(checkColumnName, soft);

			chooseDatatype(datatype);

			if (datatype.equalsIgnoreCase("date")) {

				chooseDatatypeDateFormat(checkPatternValue, chkOpvalue1, soft);
			}

			selectIgnoreNullsCheckbox(ignoreNulls);

			String expression = getCheckInfoDetails();

			checkExpression(expression, chkExpression, soft);

			// testCheckExpression(checkTestValue, chkTestOutput, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// Process");

			validateAddedCheckDetails(cname, expression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to chooseAttributeFor Calculated Check out of box expression
	public void chooseAttributeForCalculatedCheck(String Expression, SoftAssert soft) {
		String newExpression = null;
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", chooseAttrTitle);
			verifyIndividualLabel(driver, chooseAttrTitle, "Choose Attribute title");
			isDisplayed(driver, chooseAttributeSearchField);
			if (isDisplayed(driver, chooseAttributeSearchField)) {

				BaseSuite.validationReportLog("Choose Attribute Search field is visible");

				isClickable(driver, chooseAttributeSearchField, "Choose Attribute Search", true);

			} else {
				BaseSuite.reportFailLog("Choose Attribute Search field not visible ",
						"chooseAttributeForCalculatedCheck");
			}

			List<WebElement> symbols = getElements(driver, chooseAttributeOperatorSymbolButton);

			if (isDisplayed(driver, chooseAttributeOperatorSymbolButton)) {
				for (int i = 0; i < symbols.size(); i++) {
					String symbol = symbols.get(i).getText();
					if (!symbol.isEmpty()) {
						if (symbols.get(i).isDisplayed()) {
							BaseSuite.validationReportLog((i + 1) + ". " + symbol + " operator symbol is visible");
						} else {
							BaseSuite.reportFailLog((i + 1) + ". " + symbol + " operator symbol not visible",
									"chooseAttributeForCalculatedCheck");
						}
					} else {
						BaseSuite.reportFailLog("operator symbol not found for " + (i + 1) + " value",
								"chooseAttributeForCalculatedCheck");
					}
				}
			} else {
				BaseSuite.reportFailLog("operator symbols list not visible", "chooseAttributeForCalculatedCheck");
			}

			javascript(driver, "arguments[0].scrollIntoView(true);", chooseAttributeTextArea);

			isDisplayed(driver, chooseAttributeTextArea);

			if (isDisplayed(driver, chooseAttributeTextArea)) {
				BaseSuite.validationReportLog("Choose Attribute textarea is visible");

				switch (BaseSuite.SourceConnection.toLowerCase()) {

				case "postgresql":
				case "redshift":
				case "mysql":

					newExpression = changeColumnCaseToLower(Expression);
					break;

				default:
					newExpression = Expression;
					break;
				}

				BaseSuite.reportLog("Entering Calculated check expression " + newExpression);

				clear_Click_SendKeys(driver, 10, chooseAttributeTextArea, newExpression);

				BaseSuite.validationReportLog("Entered Expression successfully " + newExpression);
			} else {
				BaseSuite.reportFailLog("Choose Attribute textarea is not visible",
						"chooseAttributeForCalculatedCheck");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to add Calculated check from new check of out of box expression -
	// note:: test functionality not added
	public void addCalculatedCheck(DataTestingParameters param, SoftAssert soft) throws Throwable {

		String checkName = param.getChkCheckName();
		String checkType = param.getChkCheckType();
		String checkStatus = param.getChkStatus();
		String checkDimension = param.getChkDimension();
		String chkExpression = setExpressionValue(param);
		String checkTestValue = param.getChkTestValue1();
		String chkTestOutput = param.getChkTestOutput();

		try {
			clickOnAddButton_checkTab();

			// clickOnNewCheckButtonOnCheckTab();
			clickOnAddColumnMenuOption();
			// validateNewCheckPane(soft);

			clickOnCheckType(checkType);

			String cname = enterCheckName(checkName);

			// chooseDimensionOfCheck(checkDimension.trim());
			String st = selectCheckEnableStatus(checkStatus);
			// String st = selectEnableStatusCheckbox(checkStatus);

			chooseAttributeForCalculatedCheck(chkExpression, soft);
			// testFunctionalityForChecks(checkTestValue, chkTestOutput, soft);
			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			// captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg, "Rule
			// Process");

			validateAddedCheckDetails(cname, chkExpression, checkType, st, soft);

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	// method to get value of if-then-else
	public List<String> getValues(String expression) {

		List<String> ss = new ArrayList<>();

		String[] value = expression.split("\\?");

		String ifvalue = value[0];

		String thenvalue = value[1].split("\\:")[0];

		String elsevalue = value[1].split("\\:")[1];

		ss.add(ifvalue);
		ss.add(thenvalue);
		ss.add(elsevalue);

		return ss;

	}

	// method to split condition value by and operator
	public List<String> getANDConditon(String condtionvalue) {
		List<String> addlist = new ArrayList<>();

		if (condtionvalue.contains("AND")) {
			int count = condtionvalue.split("AND").length;
			for (int j = 0; j < count; j++) {
				addlist.add(condtionvalue.split("AND")[j]);
			}
		}
		addlist.removeAll(Arrays.asList("", null));
		return addlist;
	}

	// method to split condition value by or operator
	public List<String> getORConditon(String condtionvalue) {
		List<String> orlist = new ArrayList<>();

		if (condtionvalue.contains("OR")) {
			int count = condtionvalue.split("OR").length;
			for (int j = 0; j < count; j++) {
				orlist.add(condtionvalue.split("OR")[j]);
			}
		}
		orlist.removeAll(Arrays.asList("", null));
		return orlist;
	}

	// method to split if-then-else condition into column name, operator and value

	public List<String> getexpressionvalue(String value) {

		List<String> ss1 = new ArrayList<>();

		String[] list = { "==", "!=", "> ", "< ", ">=", "<=", "=" };

		for (int i = 0; i < list.length; i++) {

			if (value.contains(list[i])) {
				if (value.split(list[i])[0].trim().contains("(")) {
					ss1.add(value.split(list[i])[0].trim().replaceAll("[\\[\\](){}]", ""));
				} else {
					ss1.add(value.split(list[i])[0].trim());
				}
				ss1.add(list[i]);

				if (value.split(list[i])[1].contains(")")) {
					String a = value.split(list[i])[1].replaceAll("[\\[\\](){}]", "");
					if (a.contains(" AND ") || a.contains(" OR ")) {
						ss1.add(a.replace("'", "").replace(" AND ", "").replace(" OR ", "").trim());
					} else {
						ss1.add(a.replace("'", "").trim());
					}
				} else {
					String b = value.split(list[i])[1];
					if (b.contains("AND") || b.contains("OR")) {

						ss1.add(b.replace("'", "").replace(" AND ", "").replace(" OR ", "").trim());
					} else {
						ss1.add(b.replace("'", "").trim());
					}
				}
				break;
			}
		}
		return ss1;
	}

	// method to get operator name for operator symbol
	public String getoperator(String s1) {
		String operator = null;
		switch (s1.trim()) {
		case "==":
			operator = "Equal";
			break;
		case "!=":
			operator = "Not equal";

			break;
		case ">":
			operator = "Greater than";
			break;
		case "<":
			operator = "Less than";
			break;
		case ">=":
			operator = "Greater than or equal";
			break;
		case "<=":
			operator = "Less than or equal";
			break;
		default:
			break;
		}
		return operator;
	}

	public void clickOnAddCondition(By locator, String condition) throws Throwable {

		try {
			clickOnButton(driver, locator, "Add Group / Condition", true);

			if (isDisplayed(driver, returnElement(selectConditionType, "$name", condition))) {

				BaseSuite.reportLog("Clicking on Condition : " + condition);

				displayAndClick(driver, returnElement(selectConditionType, "$name", condition));

				BaseSuite.validationReportLog("Clicked on Condition : " + condition + " successfully");

			} else {
				BaseSuite.reportFailLog("Condition type not visible kindly check", "clickOnAddCondition");
			}
		} catch (Exception e) {
			e.getMessage();

		}

	}

	public void clickOnAddConditionType(By locator, String type) {

		try {

			isDisplayed(driver, locator);
			if (isDisplayed(driver, locator)) {

				BaseSuite.reportLog("Clicking on condition type : " + type);

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog("Clicked on Condition type successfully");

			} else {
				BaseSuite.reportFailLog("Condition type field not visible kindly check", "clickOnAddConditionType");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addSimpleFormatConditionalCheck(String conditiontype, String expression) throws Throwable {

		try {
			// add if condition
			List<String> condition = getValues(expression);
			String ifvalue = condition.get(0);
			String thenvalue = condition.get(1);
			String elsevalue = condition.get(2);

			if (!ifvalue.isEmpty()) {
				BaseSuite.reportLog("Adding If Condition : " + ifvalue);

				List<String> ifCondValue = getANDConditon(ifvalue);
				List<String> ifOrvalue = getORConditon(ifvalue);

				if (!ifCondValue.isEmpty()) {

					int andcount = ifCondValue.size();

					for (int i = 0; i < andcount; i++) {

						List<String> values = getexpressionvalue(ifCondValue.get(i));

						if (!isDisplayed(driver, returnElement(selectColumnDDForIF1, "$num", Integer.toString(i)))) {
							// BaseSuite.reportFailLog("select a field not visible",
							// "addSimpleFormatConditionalCheck");
							clickOnAddCondition(addConditionPlusSignIF, conditiontype);

						}
						selectColumnForCondition(values,
								returnElement(selectColumnDDForIF1, "$num", Integer.toString(i)),
								returnElement(selectOperatorDDForIF1, "$num", Integer.toString(i)),
								returnElement(selectValueForIF1, "$num", Integer.toString(i)));

						if (i < andcount - 1 && !ifCondValue.get(i + 1).trim().isEmpty()) {
							clickOnAddCondition(addConditionPlusSignIF, conditiontype);
							clickOnAddConditionType(returnElement(addConditionTypeIF, "$name", "AND"), "AND");
						}
					}
				}
				if (!ifOrvalue.isEmpty()) {

					int orcount = ifOrvalue.size();

					for (int i = 0; i < orcount; i++) {

						List<String> values = getexpressionvalue(ifOrvalue.get(i));

						if (!isDisplayed(driver, returnElement(selectColumnDDForIF1, "$num", Integer.toString(i)))) {
							// BaseSuite.reportFailLog("select a field not visible",
							// "addSimpleFormatConditionalCheck");
							clickOnAddCondition(addConditionPlusSignIF, conditiontype);
						}
						selectColumnForCondition(values,
								returnElement(selectColumnDDForIF1, "$num", Integer.toString(i)),
								returnElement(selectOperatorDDForIF1, "$num", Integer.toString(i)),
								returnElement(selectValueForIF1, "$num", Integer.toString(i)));
						if (i < orcount - 1 && !ifOrvalue.get(i + 1).trim().isEmpty()) {
							clickOnAddCondition(addConditionPlusSignIF, conditiontype);
							clickOnAddConditionType(returnElement(addConditionTypeIF, "$name", "OR"), "OR");
						}
					}
				}
				if (ifCondValue.isEmpty() && ifOrvalue.isEmpty()) {
					List<String> values = getexpressionvalue(ifvalue);
					if (!isDisplayed(driver, returnElement(selectColumnDDForIF1, "$num", "0"))) {
						// BaseSuite.reportFailLog("select a field not visible",
						// "addSimpleFormatConditionalCheck");
						clickOnAddCondition(addConditionPlusSignIF, conditiontype);
					}
					selectColumnForCondition(values, selectColumnDDForIF, selectOperatorDDForIF, selectValueForIF);
				}

				BaseSuite.validationReportLog("Added If Condition successfully " + ifvalue);
			} else {
				BaseSuite.reportFailLog("If Condition value not found kindly check " + expression,
						"addSimpleFormatConditionalCheck");
			}
			if (!thenvalue.isEmpty()) {
				BaseSuite.reportLog("Adding Then Condition : " + thenvalue);
				// add then condition
				List<String> thenCondValue = getANDConditon(thenvalue);
				List<String> thenOrvalue = getORConditon(thenvalue);

				if (!thenCondValue.isEmpty()) {

					int andcount = thenCondValue.size();

					for (int i = 0; i < andcount; i++) {

						List<String> values = getexpressionvalue(thenCondValue.get(i));

						selectColumnForCondition(values,
								returnElement(selectColumnDDForThen1, "$num", Integer.toString(i)),
								returnElement(selectOperatorDDForThen1, "$num", Integer.toString(i)),
								returnElement(selectValueForThen1, "$num", Integer.toString(i)));

						if (i < andcount - 1 && !thenCondValue.get(i + 1).trim().isEmpty()) {
							clickOnAddCondition(addConditionPlusSignThen, conditiontype);
							clickOnAddConditionType(returnElement(addConditionTypeThen, "$name", "AND"), "AND");
						}
					}
				}
				if (!thenOrvalue.isEmpty()) {

					int orcount = thenOrvalue.size();

					for (int i = 0; i < orcount; i++) {

						List<String> values = getexpressionvalue(thenOrvalue.get(i));

						selectColumnForCondition(values,
								returnElement(selectColumnDDForThen1, "$num", Integer.toString(i)),
								returnElement(selectOperatorDDForThen1, "$num", Integer.toString(i)),
								returnElement(selectValueForThen1, "$num", Integer.toString(i)));
						if (i < orcount - 1 && !thenOrvalue.get(i + 1).trim().isEmpty()) {
							clickOnAddCondition(addConditionPlusSignThen, conditiontype);
							clickOnAddConditionType(returnElement(addConditionTypeThen, "$name", "OR"), "OR");
						}
					}
				}
				if (thenCondValue.isEmpty() && thenOrvalue.isEmpty()) {
					List<String> values = getexpressionvalue(thenvalue);

					selectColumnForCondition(values, selectColumnDDForThen, selectOperatorDDForThen,
							selectValueForThen);
				}
				BaseSuite.validationReportLog("Added Then Condition successfully " + thenvalue);
			} else {
				BaseSuite.reportFailLog("Then Condition value not found kindly check " + expression,
						"addSimpleFormatConditionalCheck");
			}
			if (!elsevalue.isEmpty()) {
				BaseSuite.reportLog("Adding Else Condition : " + elsevalue);
				// add else condition
				List<String> elseCondValue = getANDConditon(elsevalue);
				List<String> elseOrvalue = getORConditon(elsevalue);

				if (!elseCondValue.isEmpty()) {

					int andcount = elseCondValue.size();

					for (int i = 0; i < andcount; i++) {

						List<String> values = getexpressionvalue(elseCondValue.get(i));

						selectColumnForCondition(values,
								returnElement(selectColumnDDForElse1, "$num", Integer.toString(i)),
								returnElement(selectOperatorDDForElse1, "$num", Integer.toString(i)),
								returnElement(selectValueForElse1, "$num", Integer.toString(i)));

						if (i < andcount - 1 && !elseCondValue.get(i + 1).trim().isEmpty()) {
							clickOnAddCondition(addConditionPlusSignThen, conditiontype);
							clickOnAddConditionType(returnElement(addConditionTypeElse, "$name", "AND"), "AND");
						}
					}
				}
				if (!elseOrvalue.isEmpty()) {

					int orcount = elseOrvalue.size();

					for (int i = 0; i < orcount; i++) {

						List<String> values = getexpressionvalue(elseOrvalue.get(i));

						selectColumnForCondition(values,
								returnElement(selectColumnDDForElse1, "$num", Integer.toString(i)),
								returnElement(selectOperatorDDForElse1, "$num", Integer.toString(i)),
								returnElement(selectValueForElse1, "$num", Integer.toString(i)));
						if (i < orcount - 1 && !elseOrvalue.get(i + 1).trim().isEmpty()) {
							clickOnAddCondition(addConditionPlusSignElse, conditiontype);
							clickOnAddConditionType(returnElement(addConditionTypeElse, "$name", "OR"), "OR");
						}
					}
				}
				if (elseCondValue.isEmpty() && elseOrvalue.isEmpty()) {
					List<String> values = getexpressionvalue(elsevalue);

					selectColumnForCondition(values, selectColumnDDForElse, selectOperatorDDForElse,
							selectValueForElse);
				}
				BaseSuite.validationReportLog("Added Else Condition successfully " + elsevalue);
			} else {
				BaseSuite.reportFailLog("Else Condition value not found kindly check " + expression,
						"addSimpleFormatConditionalCheck");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// dynamic method to enter values for each step
	public void selectColumnForCondition(List<String> values, By locator1, By locator2, By locator3) {
		// Actions builder = new Actions(driver);
		try {
			if (!values.isEmpty()) {

				String column = values.get(0);
				String op = values.get(1);
				String value = values.get(2);
				String operator = getoperator(op);

				javascript(driver, "arguments[0].scrollIntoView(true);", locator1);

				isDisplayed(driver, locator1);

				if (isDisplayed(driver, locator1)) {

					BaseSuite.reportLog("Clicking on Column dropdown");

					displayAndClick(driver, locator1);

					BaseSuite.validationReportLog("Clicked on Column dropdown successfully");

					BaseSuite.reportLog("Selecting column : " + column);

					// javascript(driver, "arguments[0].scrollIntoView(true);",
					// returnElement(selectColumnFormat, "$name", column));
					isDisplayed(driver, returnElement(selectColumnFormat, "$name", column));

					displayAndClick(driver, returnElement(selectColumnFormat, "$name", column));
					// javaScriptClick(driver, returnElement(selectColumnFormat, "$name", column));

					// builder.click(driver.findElement(returnElement(selectColumnFormat, "$name",
					// column))).build().perform();

					BaseSuite.validationReportLog("Column " + column + " is selected successfully");
				} else {
					BaseSuite.reportFailLog("Column field not visible", "selectSimpleFormatForConditionalCheck");
				}

				javascript(driver, "arguments[0].scrollIntoView(true);", locator2);

				isDisplayed(driver, locator2);

				if (isDisplayed(driver, locator2)) {

					BaseSuite.reportLog("Clicking on operator dropdown");

					displayAndClick(driver, locator2);

					BaseSuite.validationReportLog("Clicked on Operator dropdown successfully");

					BaseSuite.reportLog("Selecting Operator : " + operator);

					// javascript(driver, "arguments[0].scrollIntoView(true);",
					// returnElement(selectOperatorFormat, "$name", operator));
					isDisplayed(driver, returnElement(selectOperatorFormat, "$name", operator));
					displayAndClick(driver, returnElement(selectOperatorFormat, "$name", operator));

					BaseSuite.validationReportLog("Operator " + operator + " is selected successfully");
				} else {
					BaseSuite.reportFailLog("Operator field not visible", "selectSimpleFormatForConditionalCheck");
				}
				javascript(driver, "arguments[0].scrollIntoView(true);", locator3);

				isDisplayed(driver, locator3);

				if (isDisplayed(driver, locator3)) {

					BaseSuite.reportLog("Entering on value : " + value);

					clear_Click_SendKeys(driver, 10, locator3, value);

					BaseSuite.validationReportLog("Entered value successfully : " + value);

				} else {
					BaseSuite.reportFailLog("Operator field not visible", "selectSimpleFormatForConditionalCheck");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/*
	 * public void addConditionalCheck(DataTestingParameters param, SoftAssert soft)
	 * throws Throwable {
	 * 
	 * String checkName = param.getChkCheckName(); String checkType =
	 * param.getChkCheckType(); String checkStatus = param.getChkStatus(); String
	 * checkDimension = param.getChkDimension(); String chkExpression =
	 * setExpressionValue(param); String checkTestValue = param.getChkTestValue1();
	 * String chkTestOutput = param.getChkTestOutput();
	 * 
	 * try { // clickOnAddButton_checkTab();
	 * 
	 * clickOnNewCheckButtonOnCheckTab(); // clickOnCheck_AddButton();
	 * validateNewCheckPane();
	 * 
	 * clickOnCheckType(checkType);
	 * 
	 * String cname = enterCheckName(checkName);
	 * 
	 * // chooseDimensionOfCheck(checkDimension.trim()); String st =
	 * selectCheckEnableStatus(checkStatus); // String st =
	 * selectEnableStatusCheckbox(checkStatus);
	 * 
	 * // addSimpleFormatConditionalCheck("Add Condition", chkExpression); boolean
	 * state = addConditionByGroupOrCondition(chkExpression); if (state == false) {
	 * String expression = getCheckInfoDetails();
	 * 
	 * checkExpression(expression, chkExpression, soft);
	 * 
	 * // testFunctionalityForChecks(checkTestValue, chkTestOutput, soft);
	 * 
	 * clickOnAddNewCheckButton(soft);
	 * 
	 * inVisible(driver, spinner, Constant.ruleWait);
	 * 
	 * // captureToastMsg(driver, toastMsg, toastMsgClosedBtn, ruleProcessedmsg,
	 * "Rule // Process");
	 * 
	 * validateAddedCheckDetails(cname, chkExpression, checkType, st, soft);
	 * 
	 * } } catch (Exception e) { e.getMessage(); throw new Exception(""); } }
	 */

	// method to select export file format
	public void selectExportFileFormat(String fileType, SoftAssert soft) throws java.lang.Exception {

		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", exportfiletitle);

			isDisplayed(driver, exportfiletitle);

			verifyIndividualLabel(driver, exportfiletitle, "Export file format");

			if (isDisplayed(driver, exportfileFieldBox)) {

				BaseSuite.validationReportLog("Export file format field box is visible");

				if (fileType.equalsIgnoreCase("xlsx")) {

					BaseSuite.reportLog("selecting export file format : EXCEL");
					fileType = "Excel";

				} else {

					BaseSuite.reportLog("selecting export file format : Comma Demiliter");
					fileType = "Comma Delimiter";
				}

				String ftype = getAttribute(driver, exportfileFieldBox, "value");

				if (!ftype.equalsIgnoreCase(fileType)) {

					clickOnButton(driver, exportFileDropdownArrow, "Export File format dropdown", true);

					Thread.sleep(2000);

					BaseSuite.reportLog("Clicking on export file format Type : " + fileType);

					displayAndClick(driver, returnElement(exportFileType, "$name", fileType));

					BaseSuite.validationReportLog("Clicked on export file format Type : " + fileType);

					BaseSuite.reportLog("verifying selected file type..");

					String text = getAttribute(driver, exportfileFieldBox, "value");

					soft.assertEquals(text, fileType);

					BaseSuite.validationReportLog("Expected : " + fileType + " and Actual : " + text + " are matched");

				} else {

					BaseSuite.reportLog("Expected export file format is already selected : " + ftype);
				}

			} else {

				soft.assertTrue(false);

				BaseSuite.reportFailLog("Export file Format field box not visible", "selectExportFileFormat");
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void validateResultTypeDetailsOnExceptionReport() {
		try {
			List<WebElement> headers = getElements(driver, head);
			List<WebElement> rows = getElements(driver, resultTypeDetailsInException);
			BaseSuite.reportLog("validating result Type details on Exception report");
			for (int i = 0; i < rows.size() - 2; i++) {
				String header = headers.get(i).getAttribute("textContent");
				String value = rows.get(i).getAttribute("textContent");

				if (!value.isEmpty()) {
					// BaseSuite.reportLog("verifying "+header);
					if (rows.get(i).isDisplayed()) {
						BaseSuite.validationReportLog(header + " : " + value + " is displayed");
					} else {
						BaseSuite.reportFailLog(value + " is not visible",
								"validateResultTypeDetailsOnExceptionReport");
					}
				} else {
					BaseSuite.reportFailLog(value + " value is not found",
							"validateResultTypeDetailsOnExceptionReport");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// test functionality for conditional , calculated and custom checks
	public void testFunctionalityForChecks(String testInputs, String testOutputs, SoftAssert soft) throws Throwable {

		try {
			if (!testInputs.isEmpty() && !testOutputs.isEmpty()) {

				String[] inputs = testInputs.split(",");

				int count = inputs.length;

				clickOnTestButton();

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", testTitle);

				verifyIndividualLabel(driver, testTitle, "Test ");
				List<WebElement> inputscolumns = getElements(driver, testColumnInput);
				List<WebElement> inputsfield = getElements(driver, testValueInput);
				if (!inputscolumns.isEmpty()) {
					for (int i = 0; i < count; i++) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth'});",
								inputscolumns.get(i));
						isDisplayed(driver, testColumnInput);
						String columnname = inputscolumns.get(i).getAttribute("value");
						BaseSuite.reportLog("For column : " + columnname);
						BaseSuite.reportLog("Entering test value : " + inputs[i]);
						inputsfield.get(i).click();
						inputsfield.get(i).clear();
						inputsfield.get(i).sendKeys(inputs[i]);
						BaseSuite.validationReportLog("Entered test value : " + inputs[i]);
					}
					clickOnTestExecuteButton();
					Thread.sleep(2000);
					isDisplayed(driver, testOutput);
					String outputvalue = getTestOutput();

					soft.assertEquals(outputvalue, testOutputs.toLowerCase(), "test8");

					if (outputvalue.equalsIgnoreCase(testOutputs)) {
						BaseSuite.validationReportLog(
								"Expected test output : " + testOutputs.toLowerCase() + " and Actual : " + outputvalue);
					} else {
						BaseSuite.reportFailLog("Test Output didn't matched", "testFunctionalityForChecks");
					}
				} else {
					BaseSuite.reportFailLog("Inputs for test functionality not provided", "testFunctionalityForChecks");
				}
			}
		} catch (InterruptedException e) {
			e.getMessage();
			throw new Exception("");
		}

	}

	/*
	 * public boolean addConditionByGroupOrCondition(String expression) throws
	 * Throwable { // int rule = 0; boolean status = false; try { List<String>
	 * condition = getValues(expression);// conditional check expression // for
	 * adding conditions by split groups
	 * 
	 * for (int c = 0; c < condition.size(); c++) { List<String> exp = new
	 * ArrayList<>(); // get count of groups int rule = 0; int grp = 0; if
	 * (condition.get(c).contains("(")) { int count = getcount(condition.get(c),
	 * ')');// get count of groups // int grp = 0; if (count > 1 &&
	 * !condition.get(c).contains("))")) {
	 * BaseSuite.skipReportLog("Unable to create conditional check as, " +
	 * expression);
	 * BaseSuite.reportLog("Proceeding further steps without above check");
	 * clickOnCancelCheckButton(); status = true; break;
	 * 
	 * } for (int a = 0; a <= count; a++) {
	 * 
	 * exp.add(condition.get(c).replace("(", "#(").split("#")[a]); // add groups
	 * condition in list System.out.println(condition.get(c).replace("(",
	 * "#(").split("#")[a]); } exp.removeAll(Arrays.asList("", null));// remove null
	 * value from list
	 * 
	 * for (int i1 = 0; i1 < exp.size(); i1++) { if (!exp.get(i1).isEmpty()) {
	 * 
	 * String s1 = exp.get(i1).trim().substring(0, exp.get(i1).length() - 3); //
	 * condition
	 * 
	 * if (!s1.isEmpty()) { if (s1.contains(")")) { s1.replace(")", ""); } if
	 * (s1.contains("(")) {
	 * 
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Group"); if (i1 != 0) { int x =
	 * exp.get(i1 - 1).length(); String s = exp.get(i1 - 1).substring((x - 5), x);
	 * if (s.contains("OR")) { clickOnAddConditionType(
	 * returnTwoElements(addORCondition, "$Name", Integer.toString((c + 1)), "$num",
	 * Integer.toString(grp)), "OR"); } else { clickOnAddConditionType(
	 * returnTwoElements(addAndCondition, "$Name", Integer.toString((c + 1)),
	 * "$num", Integer.toString(grp)), "AND"); } } grp++; } int a = s1.length();
	 * List<String> ifCondValue = getANDConditon(s1.replace("(", "")); List<String>
	 * ifOrvalue = getORConditon(s1.replace("(", ""));
	 * 
	 * if (s1.contains("AND") || s1.contains("OR")) {
	 * 
	 * System.out.println(Arrays.toString(ifCondValue.toArray()));
	 * System.out.println(Arrays.toString(ifOrvalue.toArray()));
	 * 
	 * if (!ifCondValue.isEmpty()) {
	 * 
	 * int andcount = ifCondValue.size();
	 * 
	 * for (int i = 0; i < andcount; i++) {
	 * 
	 * if (!ifCondValue.get(i).trim().isEmpty()) {
	 * 
	 * List<String> values = getexpressionvalue(ifCondValue.get(i)); if
	 * (!isDisplayed(driver, returnTwoElements(cfilter, "$num", Integer.toString((c
	 * + 1)), "$rule", Integer.toString(rule)))) { //
	 * BaseSuite.reportFailLog("select a field not //
	 * visible","addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; if (i <
	 * andcount - 1 && !ifCondValue.get(i + 1).trim().isEmpty()) {
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition");
	 * clickOnAddConditionType(returnTwoElements(addAndCondition, "$Name",
	 * Integer.toString((c + 1)), "$num", Integer.toString(grp)), "AND"); } } } } if
	 * (!ifOrvalue.isEmpty()) {
	 * 
	 * int orcount = ifOrvalue.size();
	 * 
	 * for (int i = 0; i < orcount; i++) {
	 * 
	 * if (!ifOrvalue.get(i).isEmpty()) {
	 * 
	 * List<String> values = getexpressionvalue(ifOrvalue.get(i)); if
	 * (!isDisplayed(driver, returnTwoElements(cfilter, "$num", Integer.toString((c
	 * + 1)), "$rule", Integer.toString(rule)))) { //
	 * BaseSuite.reportFailLog("select a field not //
	 * visible","addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; if (i <
	 * orcount - 1 && !ifOrvalue.get(i + 1).isEmpty()) {
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition");
	 * clickOnAddConditionType(returnTwoElements(addORCondition, "$Name",
	 * Integer.toString((c + 1)), "$num", Integer.toString(grp)), "OR"); } } } } }
	 * if (ifCondValue.isEmpty() && ifOrvalue.isEmpty()) { List<String> values =
	 * getexpressionvalue(s1.replace("(", "")); if (!isDisplayed(driver,
	 * returnTwoElements(cfilter, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)))) { // BaseSuite.reportFailLog("select a field not //
	 * visible","addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; } } } }
	 * } else { BaseSuite.reportLog("Adding Condition : " + condition.get(c));
	 * 
	 * List<String> ifCondValue = getANDConditon(condition.get(c)); List<String>
	 * ifOrvalue = getORConditon(condition.get(c));
	 * 
	 * if (!ifCondValue.isEmpty()) {
	 * 
	 * int andcount = ifCondValue.size();
	 * 
	 * for (int i = 0; i < andcount; i++) {
	 * 
	 * List<String> values = getexpressionvalue(ifCondValue.get(i)); if
	 * (!isDisplayed(driver, returnTwoElements(cfilter, "$num", Integer.toString((c
	 * + 1)), "$rule", Integer.toString(rule)))) { //
	 * BaseSuite.reportFailLog("select a field not visible", //
	 * "addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; if (i <
	 * andcount - 1) { clickOnAddCondition(addConditionPlusSignIF, "Add Condition");
	 * clickOnAddConditionType(returnTwoElements(addAndCondition, "$Name",
	 * Integer.toString((c + 1)), "$num", Integer.toString(grp)), "AND"); } } } } }
	 * } else { BaseSuite.reportLog("Adding Condition : " + condition.get(c));
	 * 
	 * List<String> ifCondValue = getANDConditon(condition.get(c)); List<String>
	 * ifOrvalue = getORConditon(condition.get(c));
	 * 
	 * if (!ifCondValue.isEmpty()) {
	 * 
	 * int andcount = ifCondValue.size();
	 * 
	 * for (int i = 0; i < andcount; i++) {
	 * 
	 * List<String> values = getexpressionvalue(ifCondValue.get(i)); if
	 * (!isDisplayed(driver, returnTwoElements(cfilter, "$num", Integer.toString((c
	 * + 1)), "$rule", Integer.toString(rule)))) { //
	 * BaseSuite.reportFailLog("select a field not visible", //
	 * "addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; if (i <
	 * andcount - 1) { clickOnAddCondition(addConditionPlusSignIF, "Add Condition");
	 * clickOnAddConditionType(returnTwoElements(addAndCondition, "$Name",
	 * Integer.toString((c + 1)), "$num", Integer.toString(grp)), "AND"); } } } if
	 * (!ifOrvalue.isEmpty()) {
	 * 
	 * int orcount = ifOrvalue.size();
	 * 
	 * for (int i = 0; i < orcount; i++) {
	 * 
	 * List<String> values = getexpressionvalue(ifOrvalue.get(i)); if
	 * (!isDisplayed(driver, returnTwoElements(cfilter, "$num", Integer.toString((c
	 * + 1)), "$rule", Integer.toString(rule)))) { //
	 * BaseSuite.reportFailLog("select a field not visible", //
	 * "addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; if (i <
	 * orcount - 1) { clickOnAddCondition(addConditionPlusSignIF, "Add Condition");
	 * clickOnAddConditionType(returnTwoElements(addORCondition, "$Name",
	 * Integer.toString((c + 1)), "$num", Integer.toString(grp)), "OR"); } } } if
	 * (ifCondValue.isEmpty() && ifOrvalue.isEmpty()) { List<String> values =
	 * getexpressionvalue(condition.get(c)); if (!isDisplayed(driver,
	 * returnTwoElements(cfilter, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)))) { //
	 * BaseSuite.reportFailLog("select a field not visible", //
	 * "addConditionByGroupOrCondition");
	 * clickOnAddCondition(returnTwoElements(addGrp, "$num", Integer.toString((c +
	 * 1)), "$rule", Integer.toString(grp)), "Add Condition"); }
	 * selectColumnForCondition(values, returnTwoElements(cfilter, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule)),
	 * returnTwoElements(coperator, "$num", Integer.toString((c + 1)), "$rule",
	 * Integer.toString(rule)), returnTwoElements(cvalue, "$num",
	 * Integer.toString((c + 1)), "$rule", Integer.toString(rule))); rule++; }
	 * 
	 * BaseSuite.validationReportLog("Added  Condition successfully " +
	 * condition.get(c)); }
	 * 
	 * } } catch (Exception e) { e.getMessage(); } return status; } } }
	 */

	// set exception report parameters using api
	public DataTestingParameters setExceptionReportParametersUsingApi(String jsonEntity, String ruleType)
			throws Exception {
		DataTestingParameters param = new DataTestingParameters();
		TestDataThroughApi vt = new TestDataThroughApi(driver);

		try {

			if (ruleType.toLowerCase().trim().contains("validation")
					|| ruleType.toLowerCase().trim().contains("pushdown")) {
				param.setExceptionReportFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.format[0]"));

				// param.setStoreXLSX(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// "$.objects[2].configuration.storeXlsx"));

				param.setStoreFailureAndErrors(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.storeOnlyException"));

				param.setResultTypes(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks[0].expression.values.*"));

				param.setStoreExportedFileOnly(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.storeOnlyExportedFile"));

				param.setShowDownloadExceptionurl(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.createExportDownloadLink"));

				param.setExportFileRowLimit(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.exportFileRowLimit"));

			} else {
				param.setExceptionReportFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.format[0]"));

				// param.setStoreXLSX(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// "$.objects[4].configuration.storeOnlyException"));

				param.setStoreFailureAndErrors(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.storeOnlyException"));

				param.setResultTypes(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks[0].expression.values.*"));

				param.setStoreExportedFileOnly(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.storeOnlyExportedFile"));

				param.setShowDownloadExceptionurl(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.createExportDownloadLink"));

				param.setExportFileRowLimit(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.exportFileRowLimit"));
			}
			return param;
		} catch (Exception e) {
			throw new Exception("");
		}

	}

	// method to validate exception report tab expression
	public void validateExpressionDetailsOnExceptionReportTab(String filename, String sheetname, String columnname,
			SoftAssert soft) throws InvalidFormatException, IOException, Throwable {
		try {
			int row1;
			String status;
			String[] ct = columnname.split(",");
			int count = getcount(columnname, ',');
			BaseSuite.reportLog("Verifying Added check expression on Exception report tab");

			for (int i = 0; i <= count; i++) {
				if (!ct[i].isEmpty()) {
					row1 = findRow(filename, sheetname, ct[i]);

					DataTestingParameters p = setChecksParametersUsingExcel(filename, sheetname, row1);
					String checkName = p.getChkCheckName();
					BaseSuite.reportLog(
							"============   Validating expression  : " + checkName + "   ==================");
					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(expressionReportCheckName, "$name", checkName));
					isDisplayed(driver, returnElement(expressionReportCheckName, "$name", checkName));
					List<WebElement> rowdata = getElements(driver,
							returnElement(exceptionReportCheckDetails, "$name", checkName));

					String chkname = rowdata.get(0).getAttribute("textContent");
					String chkExp = rowdata.get(1).getAttribute("textContent");
					String chktype = rowdata.get(2).getAttribute("textContent");
					String chkstatus = rowdata.get(3).getAttribute("textContent");
					String chkShow = rowdata.get(4).getAttribute("textContent");

					if (!chkname.isEmpty()) {
						BaseSuite.reportLog("Validating Expression Name...");
						BaseSuite.reportLog("Retrived Expression Name : " + chkname);
						BaseSuite.reportLog("Expected Expression Name : " + p.getChkCheckName());

						soft.assertEquals(chkname.trim(), p.getChkCheckName().trim(), "test20");

						if (chkname.trim().equalsIgnoreCase(p.getChkCheckName().trim())) {
							BaseSuite.validationReportLog("Expression name are matched successfully");
						} else {
							BaseSuite.reportFailLog("Expression name doesn't matched",
									"validateExpressionDetailsOnExceptionReportTab");
						}
					} else {
						BaseSuite.reportFailLog("Expression name not found kindly check",
								"validateExpressionDetailsOnExceptionReportTab");
					}

					if (!chkExp.isEmpty()) {
						BaseSuite.reportLog("Validating Expression...");
						BaseSuite.reportLog("Retrived Expression  : " + chkExp);
						BaseSuite.reportLog("Expected Expression  : " + p.getChkExpression());

						soft.assertEquals(chkExp.trim(), p.getChkExpression().trim(), "test21");

						if (chkExp.trim().equalsIgnoreCase(p.getChkExpression().trim())) {
							BaseSuite.validationReportLog("Expression matched successfully");
						} else {
							BaseSuite.reportFailLog("Expression doesn't matched",
									"validateExpressionDetailsOnExceptionReportTab");
						}
					} else {
						BaseSuite.reportFailLog("Expression not found kindly check",
								"validateExpressionDetailsOnExceptionReportTab");
					}

					if (!chktype.isEmpty()) {
						if (!p.getChkCheckType().equalsIgnoreCase("custom")) {
							BaseSuite.reportLog("Validating Expression Type...");
							BaseSuite.reportLog("Retrived Expression Type : " + chktype);
							BaseSuite.reportLog("Expected Expression Type : " + p.getChkCheckType());

							soft.assertEquals(chktype.trim(), p.getChkCheckType().trim(), "test22");

							if (chktype.trim().equalsIgnoreCase(p.getChkCheckType().trim())) {

								BaseSuite.validationReportLog("Expression Type matched successfully");
							} else {
								BaseSuite.reportFailLog("Expression Type doesn't matched",
										"validateExpressionDetailsOnExceptionReportTab");
							}
						} else {
							BaseSuite.reportLog("Validating Expression Type...");
							BaseSuite.reportLog("Retrived Expression Type : " + chktype);
							BaseSuite.reportLog("Expected Expression Type : Custom");

							soft.assertEquals(chktype.trim(), "Custom", "test21");

							if (chktype.trim().equalsIgnoreCase("Custom")) {
								BaseSuite.validationReportLog("Expression Type matched successfully");
							} else {
								BaseSuite.reportFailLog("Expression Type doesn't matched",
										"validateExpressionDetailsOnExceptionReportTab");
							}
						}
					} else {
						BaseSuite.reportFailLog("Expression Type not found kindly check",
								"validateExpressionDetailsOnExceptionReportTab");
					}

					if (!chkstatus.isEmpty()) {

						if (chkstatus.trim().equalsIgnoreCase("Active")) {
							status = "true";
						} else {
							status = "false";
						}
						BaseSuite.reportLog("Validating Expression Status...");
						BaseSuite.reportLog("Retrived Expression Status : " + status);
						BaseSuite.reportLog("Expected Expression Status : " + p.getChkStatus().toLowerCase());

						soft.assertEquals(status.trim(), p.getChkStatus().toLowerCase().trim(), "test23");

						if (status.trim().equalsIgnoreCase(p.getChkStatus().trim())) {
							BaseSuite.validationReportLog("Expression Status matched successfully");
						} else {
							BaseSuite.reportFailLog("Expression Status doesn't matched",
									"validateExpressionDetailsOnExceptionReportTab");
						}

						if (status.equalsIgnoreCase("true")) {

							if (!chkShow.isEmpty()) {

								String showstate = getAttribute(driver, returnElement(exceptionReporExpShowCheckbox,
										"$name", p.getChkCheckName().trim()), "aria-checked");
								BaseSuite.reportLog("Validating Expression Visible checkbox...");
								BaseSuite.reportLog("Retrived Expression visible checkbox : " + showstate);
								BaseSuite.reportLog("Expected Expression visible checkbox : " + status);

								soft.assertEquals(showstate.trim(), status, "test24");
								if (showstate.trim().equalsIgnoreCase(status.trim())) {
									BaseSuite.validationReportLog("Expression visible checkbox matched successfully");
								} else {
									BaseSuite.reportFailLog("Expression visible checkbox doesn't matched",
											"validateExpressionDetailsOnExceptionReportTab");
								}
							}
						} else {
							String showstate = getAttribute(driver,
									returnElement(exceptionReporExpShowCheckbox, "$name", p.getChkCheckName().trim()),
									"aria-checked");
							BaseSuite.reportLog("Validating Expression Visible checkbox...");
							BaseSuite.reportLog("Retrived Expression visible checkbox : " + showstate);
							BaseSuite.reportLog("Expected Expression visible checkbox : " + status);

							soft.assertEquals(showstate.trim(), status, "test24.1");
							if (showstate.trim().equalsIgnoreCase(status.trim())) {
								BaseSuite.validationReportLog("Expression visible checkbox matched successfully");
							} else {
								BaseSuite.reportFailLog("Expression visible checkbox doesn't matched",
										"validateExpressionDetailsOnExceptionReportTab");
							}
						}
					} else {
						BaseSuite.reportFailLog("Expression Status not found kindly check",
								"validateExpressionDetailsOnExceptionReportTab");
					}
				}
			}

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
	}

	public void validateExpression(ArrayList<String> checksdetails1, By locator)
			throws InvalidFormatException, IOException, Throwable {

		try {
			int count = checksdetails1.size();

			List<WebElement> list = getElements(driver, locator);

			if (list.size() > 0) {

				BaseSuite.validationReportLog(
						"FYI column list is display on exception report section for pushdown rule");
			} else {
				BaseSuite.reportFailLog("FYI column list is not display on exception report for pushdown rule", "");
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	// get rule id once rule saved
	public String getruleID() throws Throwable {
		String ruleID = null;

		try {
			clickOnButton(driver, metatab, "property", true);
			BaseSuite.reportLog("verifying visibility of rule id field");
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", metadata_ruleId);
			isDisplayed(driver, metadata_ruleId);
			if (isDisplayed(driver, metadata_ruleId)) {

				BaseSuite.validationReportLog("Rule ID field visible");
				isDisplayed(driver, metadata_ruleId);
				Thread.sleep(2000);
				ruleID = getAttribute(driver, metadata_ruleId, "textContent");
				if (!ruleID.isEmpty()) {
					BaseSuite.validationReportLog("Rule ID :: " + ruleID);
				} else {
					BaseSuite.reportFailLog("Rule id not found", "getruleID");
				}
				isDisplayed(driver, metatab);
				displayAndClick(driver, metatab);

			} else {
				BaseSuite.reportFailLog("Rule id field not visible", "getruleID");
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return ruleID;
	}

	// verify exception report summary header details
	public void verifyExceptionReportSummaryOfRule(DataTestingParameters param, String rulename, String ruleStatus,
			SoftAssert soft) throws InterruptedException {

		try {

			validateExceptionReportPage(rulename, param.getRuleType(), ruleStatus, soft);
			/*
			 * validateSummaryDetails(param.getWorkflowId(), "Workflow Id",
			 * returnElement(summaryDetails, "$name", " Workflow Id:"), soft);
			 * 
			 * validateSummaryDetails(param.getRuleType(), "Rule Type",
			 * returnElement(summaryDetails, "$name", " Rule type:"), soft);
			 * 
			 * validateSummaryDetails(param.getRuleName(), "Rule Name",
			 * returnElement(summaryDetails, "$name", " Rule name:"), soft);
			 * 
			 * validateSummaryDetails(param.getInstanceId(), "Instance Id",
			 * returnElement(summaryDetails, "$name", " Instance Id:"), soft);
			 * 
			 * validateSummaryDetails(param.getInstanceStatus(), "Instance Status",
			 * returnElement(summaryDetails, "$name", " Instance Status:"), soft);
			 */
			validateSummaryDetails(param.getExecutionstate(), "State", ruleExecutionState, soft); // getExecutionReportSummaryPath();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validateSummaryDetails(String expectedValue, String label, By locator, SoftAssert soft) {

		try {
			BaseSuite.reportLog("verifying " + label + " on summary report");

			String workflowid = getAttribute(driver, locator, "textContent").replace(label, "").trim();

			BaseSuite.reportLog("Retrieved " + label + " : " + workflowid);
			BaseSuite.reportLog("Expected " + label + " : " + expectedValue);

			soft.assertTrue(workflowid.equalsIgnoreCase(expectedValue.trim()), "SummaryDetails");

			if (workflowid.equalsIgnoreCase(expectedValue.trim())) {
				BaseSuite.validationReportLog("Expected " + label + " matched Successfully");
			} else {
				BaseSuite.reportFailLog("Expected " + label + " not matched", "validateSummaryDetails");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// set checks parameters using excel
	public DataTestingParameters setChecksParametersUsingExcel(String fileName, String sheetName, int rowNumber)
			throws Exception, Throwable, InvalidFormatException, IOException {
		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setChkExpression(xl.readUsingColName(fileName, sheetName, rowNumber, "Expression"));
			param.setChkCheckName(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckName"));
			param.setChkCheckType(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckType"));
			param.setChkColumnname(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckColumnName"));
			param.setChkDimension(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckDimension"));
			param.setChkStatus(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckStatus"));
			param.setChkTestValue1(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestValue1"));
			param.setChkTestValue2(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestValue2"));
			param.setChkTestOutput(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestOutput"));
			param.setChkOperator(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckOperator"));
			param.setChkOperatorValue1(xl.readUsingColName(fileName, sheetName, rowNumber, "InputValue1"));
			param.setChkOperatorValue2(xl.readUsingColName(fileName, sheetName, rowNumber, "InputValue2"));
			param.setChkTrimData(xl.readUsingColName(fileName, sheetName, rowNumber, "TrimData"));
			param.setChkEmptyStringAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "EmptyStringAsNull"));
			param.setChkWhiteSpaceAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "WhiteSpaceAsNull"));
			param.setChkFixedStringAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "FixedStringAsNull"));
			param.setChkIgnoreNulls(xl.readUsingColName(fileName, sheetName, rowNumber, "IgnoreNulls"));
			param.setNewCheckType(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckType"));
			param.setChkPatternType(xl.readUsingColName(fileName, sheetName, rowNumber, "SelectPattern"));

			param.setChkInputValue(xl.readUsingColName(fileName, sheetName, rowNumber, "InputValue1"));
			param.setChkDataType(xl.readUsingColName(fileName, sheetName, rowNumber, "DataType"));
			param.setChkDateFormat(xl.readUsingColName(fileName, sheetName, rowNumber, "Format"));
			param.setChkDateRegex(xl.readUsingColName(fileName, sheetName, rowNumber, "Regex"));
			param.setStoreFailureAndErrors(
					xl.readUsingColName(fileName, sheetName, rowNumber, "StoreFailureAndErrors"));
			param.setExceptionReportFormat(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ExceptionReportFormat"));
			param.setStoreXLSX(xl.readUsingColName(fileName, sheetName, rowNumber, "StoreXlsx"));

			param.setStoreFailureAndErrors(
					xl.readUsingColName(fileName, sheetName, rowNumber, "StoreFailureAndErrors"));
			param.setExceptionReportFormat(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ExceptionReportFormat"));
			param.setStoreXLSX(xl.readUsingColName(fileName, sheetName, rowNumber, "StoreXlsx"));

			return param;

		} catch (Exception e) {

			throw new Exception("");
		}
	}

	// set checks parameters using api json
	public DataTestingParameters setChecksParametersUsingApi(String jsonEntity, String ruleType, int rowNumber)
			throws RuntimeException {
		DataTestingParameters param = new DataTestingParameters();

		TestDataThroughApi vt = new TestDataThroughApi(driver);
		try {
			param.setSourceInput(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[0].input"));

			param.setTargetInput(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[1].input"));

			if (ruleType.toLowerCase().trim().contains("validation")) {
				String expression = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.comment");
				if (expression == null) {
					expression = "";
				}
				if (!expression.isEmpty()) {
					param.setChkExpression(expression);
				} else {

					param.setChkExpression(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							checksJsonPath + rowNumber + "].expression.value"));
				}
				param.setChkCheckName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].name"));
				param.setChkCheckType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].type"));
				param.setChkColumnname(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.column"));
				param.setChkDimension(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].dimension"));
				param.setChkStatus(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].isActive"));
				param.setCheckVisibility(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].isVisible"));

				param.setChkTestValue1("");
				param.setChkTestValue2("");
				param.setChkTestOutput("");
				param.setChkOperator(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.operator"));
				param.setChkOperatorValue1(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.inputValue[0]"));
				param.setChkOperatorValue2(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.inputValue[1]"));
				param.setChkTrimData(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.trimmingEnable"));
				param.setChkEmptyStringAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.emptyStringAsNull"));
				param.setChkWhiteSpaceAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.whiteSpaceAsNull"));
				param.setChkFixedStringAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.fixedStringAsNull"));
				param.setChkIgnoreNulls(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.ignoreNull"));
				param.setChkPatternType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.pattern"));
				// param.setStoreFailureAndErrors(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// "$.payload.info.objects[2].configuration.storeOnlyErrorRows"));

				param.setChkInputValue(TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.inputValue").toString());
				param.setChkDataType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.datatype"));
				param.setChkDateFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.format"));
				param.setChkDateRegex(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.regex"));

			} else if (ruleType.equalsIgnoreCase("recon")) {

				String expression = vt.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.comment");

				if (expression == null) {
					expression = "";
				}
				if (!expression.isEmpty()) {
					param.setChkExpression(expression);
				} else {

					param.setChkExpression(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							reconCheckJsonPAth + rowNumber + "].expression.value"));
				}
				param.setChkCheckName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].name"));

				param.setChkCheckType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "]..type"));
				// need to change logic for column
				param.setChkColumnname(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.column"));
				// dimension has been removed n bug is also raised.
				param.setChkDimension(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].dimension"));
				param.setChkStatus(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].isActive"));
				param.setCheckVisibility(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].isVisible"));

				param.setChkTestValue1("");
				param.setChkTestValue2("");
				param.setChkTestOutput("");

				param.setChkOperator(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "]..operator"));
				param.setChkOperatorValue1(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.inputValue[0]"));
				param.setChkOperatorValue2(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.inputValue[1]"));

				// Need to check code n then update path
				param.setChkTrimData(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.trimmingEnable"));
				param.setChkEmptyStringAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.emptyStringAsNull"));
				param.setChkWhiteSpaceAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.whiteSpaceAsNull"));
				param.setChkFixedStringAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.fixedStringAsNull"));
				param.setChkIgnoreNulls(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.ignoreNull"));

				param.setChkPatternType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.pattern"));
				// param.setStoreFailureAndErrors(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,"$.payload.info.objects[4].configuration.storeOnlyErrorRows"));
				param.setChkInputValue(TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.inputValue").toString());
				param.setChkDataType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.datatype"));
				param.setChkDateFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.format"));
				param.setChkDateRegex(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						reconCheckJsonPAth + rowNumber + "].expression.regex"));

				param.setExceptionReportFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.format[0]"));
				param.setStoreXLSX(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[4].configuration.storeXlsx"));
			} else if (ruleType.equalsIgnoreCase("checksum")) {
				param.setChkCheckType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.checks[0].type"));
				param.setChkCheckName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.checks[0].name"));
				param.setChkStatus(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.checks[0].isActive"));
				param.setChkExpression(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.checks[0].expression.value"));
				// dimension has been removed n bug is also raised.
				param.setChkDimension(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.info.objects[1].configuration.expressions..dimension"));

			} else {
				String expression = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.comment");
				if (expression == null) {
					expression = "";
				}
				if (!expression.isEmpty()) {
					param.setChkExpression(expression);
				} else {

					param.setChkExpression(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							checksJsonPath + rowNumber + "].expression.value"));
				}
				param.setChkCheckName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].name"));
				param.setChkCheckType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].type"));
				param.setChkColumnname(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.column"));
				param.setChkDimension(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].dimension"));
				param.setChkStatus(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].isActive"));
				param.setCheckVisibility(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].isVisible"));

				param.setChkTestValue1("");
				param.setChkTestValue2("");
				param.setChkTestOutput("");
				param.setChkOperator(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.operator"));
				param.setChkOperatorValue1(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.inputValue[0]"));
				param.setChkOperatorValue2(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.inputValue[1]"));
				param.setChkTrimData(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.trimmingEnable"));
				param.setChkEmptyStringAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.emptyStringAsNull"));
				param.setChkWhiteSpaceAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.whiteSpaceAsNull"));
				param.setChkFixedStringAsNull(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.fixedStringAsNull"));
				param.setChkIgnoreNulls(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.ignoreNull"));
				param.setChkPatternType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.pattern"));
				// param.setStoreFailureAndErrors(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// "$.payload.info.objects[2].configuration.storeOnlyErrorRows"));

				param.setChkInputValue(TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.inputValue").toString());
				param.setChkDataType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.datatype"));
				param.setChkDateFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.format"));
				param.setChkDateRegex(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + rowNumber + "].expression.regex"));

			}
			return param;

		} catch (Exception e) {

			throw new RuntimeException();
		}

	}

	public void validateResultTypeOnExceptionReport(String json, String exp) {

		if (!json.isEmpty()) {

			try {
				BaseSuite.reportLog("Verifying result types on exception report page ..");
				ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(json, exp);

				List<WebElement> ui = getElements(driver, dtresultTypes);

				int count = list.size();
				int jcount = ui.size();
				BaseSuite.reportLog("expected results type selected : " + list.toString());

				for (int i = 0; i < count; i++) {

					String a = list.get(i);

					for (int j = 0; j < jcount; j++) {

						String b = ui.get(i).getAttribute("title");
						if (a.trim().equalsIgnoreCase(b.trim())) {
							BaseSuite.validationReportLog("Result type selected : " + b);
							break;
						} else {
							BaseSuite.reportFailLog("Expected result type not matched kindly check : " + a + " : " + b,
									"validateResultTypeOnExceptionReport");
						}
					}
				}
			} catch (Exception e) {

			}
		}
	}

	// exception report methods // validateExceptionReportsummary page
	public void validateExceptionReportPage(String rulename, String ruleType, String ruleStatus, SoftAssert soft)
			throws InterruptedException {

		try {
			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.reportLog("===== Verifying Exception Report Summary after Executing a rule =====");

			// verifyIndividualLabel(driver, summaryTitle, "Summary");

			if (!ruleType.equalsIgnoreCase("Pushdown")) {
				verifyVisibilityOfButtons(driver, showPercentageButton, "Show Percentage Button", true);
			}

			if (ruleType.equalsIgnoreCase("Recon")) {
				verifyVisibilityOfButtons(driver, highlightButton, "Highlight Button", true);
			}

			verifyVisibilityOfButtons(driver, downloadButton, "Download", true);

			verifyVisibilityOfButtons(driver, CopyUrlButton, "Copy Url", true);

			List<WebElement> list = getElements(driver, breadCrumbExceptionReport);

			int count = list.size() - 1;

			for (int i = 0; i < count; i++) {
				String breadCrumbName = list.get(i).getText();

				String attributeVal = getAttribute(driver,
						returnElement(breadCrumbNameExceptionReport, "$colNum", Integer.toString(i + 1)), "class");

				if (attributeVal.contains("link")) {
					BaseSuite.validationReportLog(breadCrumbName + " breadcrumbs is clickable");
				} else {
					BaseSuite.validationReportLog(breadCrumbName + " breadcrumbs is not clickable");
				}
			}

			verifyIndividualLabel(driver, ruleNameOnExceptionReport, "Rule Name on exception report");

			Thread.sleep(2000);

			verifyIndividualLabel(driver, returnElement(ruleStatusOnExceptionReport, "$name", ruleStatus),
					"Rule Status");

			verifyIndividualLabel(driver, checksAndClumnsLabel, "Check and Columns");

			if (!isDisplayed(driver, norecordsOnSummary)) {

				isDisplayed(driver, summary_SearchBar);

				if (isDisplayed(driver, summary_SearchBar)) {

					BaseSuite.validationReportLog("Expression search bar is visible on summary page");

				} else {

					BaseSuite.reportFailLog("Expression search bar not visible", "validateExceptionReportPage");
				}

				isDisplayed(driver, summary_SearchBtn);

				if (isDisplayed(driver, summary_SearchBtn)) {

					BaseSuite.validationReportLog("Expression search button is visible on summary page");

				} else {

					BaseSuite.reportFailLog("Expression search button not visible", "validateExceptionReportPage");
				}

				BaseSuite.reportLog("verifying summary columns...");

				List<WebElement> colList = getElements(driver, exceptioncolumnList);

				BaseSuite.reportLog("Retrived summary columns count : " + (colList.size() - 1));

				BaseSuite.reportLog("Expected summary columns count : " + 2);

				soft.assertEquals((colList.size() - 1), 2);

				for (int i = 1; i < colList.size(); i++) {

					if (colList.get(i).isDisplayed()) {

						String name = colList.get(i).getAttribute("textContent");

						BaseSuite.validationReportLog(name + " column is visible");

					} else {

						BaseSuite.reportFailLog("Column not visible", "validateExceptionReportPage");
					}
				}

				isDisplayed(driver, summary_pagination);

				if (isDisplayed(driver, summary_pagination)) {

					BaseSuite.validationReportLog("Summary pagination is visible on summary page");

				} else {

					BaseSuite.reportFailLog("Summary pagination not visible", "validateExceptionReportPage");
				}

				isDisplayed(driver, summary_pagedetails);

				if (isDisplayed(driver, summary_pagedetails)) {

					String del = getText(driver, summary_pagedetails);

					// getAttribute(driver, summary_pagedetails, "text");

					BaseSuite.validationReportLog("Summary page Details is visible on summary page , " + del);

				} else {

					BaseSuite.reportFailLog("Summary page Details not visible", "validateExceptionReportPage");
				}
			} else {

				BaseSuite.reportLog("showing No Records to display on summary report");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// set parameters for exxception report
	public DataTestingParameters setExceptionSummaryParameters(String jsonEntity, int chkNum) throws Exception {
		DataTestingParameters param = new DataTestingParameters();

		try {
			param.setInstanceId(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].objectInstanceId"));
			param.setExecutionstate(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.items[0].instanceSummary.state"));
			param.setWorkflowId(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].workflowId"));
			param.setInstanceStatus(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].status"));
			param.setRuleName(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].ruleInfo.name"));
			param.setRuleType(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].ruleInfo.ruleType"));
			param.setCreateRuleID(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].objectId"));
			param.setWorkflowStatus(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].status"));
			param.setRuleObjectId(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].objectId"));

		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
		return param;
	}

	// click on instance ID
	public String clickOnInstanceIDOfRuleOnRecentRuns() throws Exception, Throwable {
		String instanceID = null;

		try {
			scrollToLocator(recentrun_latest_instanceId, "latest Instance Id");

			isDisplayed(driver, recentrun_latest_instanceId);

			String status = getText(driver, recentrun_latest_statusofrule);

			if (!status.contains("Running") || !status.contains("Submitted")) {

				instanceID = getText(driver, recentrun_latest_instanceId);

				BaseSuite.reportLog("Recent instance id to be clicked is :: " + instanceID);

				clickOnButton(driver, recentrun_latest_instanceId_link, "Recent Instance id", true);

				if (isDisplayed(driver, discardButtons)) {

					clickOnButton(driver, discardButtons, " Discard ", true);
				}

				inVisible(driver, spinner, Constant.ruleWait);

			} else {

				BaseSuite.reportFailLog("rule execution status is " + status + " kindly check",
						"clickOnInstanceIDOfRuleOnRecentRuns");
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
		return instanceID;
	}

	// exception report dir path
	public String getExecutionReportSummaryPath() throws Throwable {

		String path = null;

		try {
			clickOnButton(driver, copyPath, "Copy Path", true);

			isDisplayed(driver, toastMsg);
			path = getText(driver, toastMsg);
			BaseSuite.validationReportLog("Exception Report :: " + path);
			isDisplayed(driver, ToastMsgClosedBtn);
			displayAndClick(driver, ToastMsgClosedBtn);
		} catch (Exception e) {
			e.getMessage();
		}

		return path;
	}

	public void validateDiffJoinSummary(DataTestingParameters param, SoftAssert soft) throws InterruptedException {

		try {
			if (!isDisplayed(driver, norecordsOnSummary)) {

				BaseSuite.reportLog("Verifying Diff Join on exception report summary page ");

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
						returnElement(summaryCheckname, "$name", "DiffJoin"));

				isDisplayed(driver, returnElement(summaryCheckname, "$name", "DiffJoin"));

				if (isDisplayed(driver, returnElement(summaryCheckname, "$name", "DiffJoin"))) {

					BaseSuite.validationReportLog("DiffJoin is visible on summary page");

					if (isDisplayed(driver, returnElement(summaryDiffjoin, "$colNum", Integer.toString(1)))) {

						BaseSuite.validationReportLog("Diff join success value is visible ");

						validatecheckDetails(returnElement(summarycheckSuccessCount, "$name", "DiffJoin"),
								param.getDiffJoinSuccess(), "Diff join Success count", soft);

						validatecheckDetails(returnElement(summarycheckFailureCount, "$name", "DiffJoin"),
								param.getDiffJoinFailure(), "Diff join Failure count", soft);

						validatecheckDetails(returnElement(summarycheckErrorCount, "$name", "DiffJoin"),
								param.getDiffJoinError(), "Diff join Error count", soft);

					} else {

						BaseSuite.reportFailLog("Diff join value not matched",
								"validatechecksDetailsOnExceptionReportSummary");
					}

				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validatechecksDetailsOnExceptionReportSummary(DataTestingParameters param, SoftAssert soft) {

		try {
			if (!param.getChkCheckName().isEmpty() && !param.getChkCheckType().contains("Column")) {
				BaseSuite.reportLog("Verifying Expression on Exception report summary ");
				BaseSuite.reportLog(
						"================ validating expression : " + param.getChkCheckName() + " ===============");

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
						returnElement(summaryCheckname, "$name", param.getChkCheckName().trim()));

				if (isDisplayed(driver, returnElement(summaryCheckname, "$name", param.getChkCheckName().trim()))) {

					BaseSuite.validationReportLog(param.getChkCheckName() + " is visible on page ");

					List<WebElement> checksDetails = getElements(driver,
							returnElement(summaryCheckDetails, "$name", param.getChkCheckName().trim()));
					if (!checksDetails.isEmpty()) {
						// validatecheckDetails(checksDetails.get(1), param.getChkCheckName(), "Name",
						// soft);

						// validatecheckDetails(checksDetails.get(5), param.getChkCheckType(), "Type",
						// soft);

						// validatecheckDetails(checksDetails.get(2), param.getSuccessValue(),
						// "Success", soft);

						// validatecheckDetails(checksDetails.get(3), param.getFailureValue(),
						// "Failure", soft);

						// validatecheckDetails(checksDetails.get(4), param.getErrorValue(), "Error",
						// soft);
					} else {
						BaseSuite.reportFailLog(param.getChkCheckName() + " expression details not found ",
								"validatechecksDetailsOnExceptionReportSummary");
					}
				} else {
					BaseSuite.reportFailLog(param.getChkCheckName() + "is not visible ",
							"validatechecksDetailsOnExceptionReportSummary");
				}
			} else if (!param.getChkCheckName().isEmpty() && param.getChkCheckType().contains("Column")) {

				BaseSuite.reportLog(
						"================ validating expression : " + param.getChkCheckName() + " ===============");

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
						returnElement(summaryCheckname, "$name", param.getChkCheckName().trim()));

				if (isDisplayed(driver, returnElement(summaryCheckname, "$name", param.getChkCheckName().trim()))) {

					BaseSuite.validationReportLog(param.getChkCheckName() + " is visible on page ");

					List<WebElement> checksDetails = getElements(driver,
							returnElement(summaryCheckDetails, "$name", param.getChkCheckName().trim()));

					// validatecheckDetails(checksDetails.get(1), param.getChkCheckName(), "name",
					// soft);

					// validatecheckDetails(checksDetails.get(5), param.getChkCheckType(), "Type",
					// soft);

				} else {
					BaseSuite.reportFailLog(param.getChkCheckName() + "is not visible ",
							"validatechecksDetailsOnExceptionReportSummary");
				}
			} else {
				BaseSuite.reportFailLog("Expression name not found kindly check ",
						"validatechecksDetailsOnExceptionReportSummary");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void validatecheckDetails(By ele, String expectedvalue, String label, SoftAssert soft)
			throws InterruptedException {

		try {
			if (!expectedvalue.isEmpty()) {

				Thread.sleep(1000);

				javascript(driver, "arguments[0].scrollIntoView(true);", ele);

				String actual = getAttribute(driver, ele, "textContent").trim();

				if (actual.isEmpty()) {

					actual = getAttribute(driver, ele, "title");
				}

				BaseSuite.reportLog("Retrieved  " + label + " : " + actual);

				BaseSuite.reportLog("Expected " + label + " : " + expectedvalue);

				soft.assertEquals(actual.trim(), expectedvalue.trim(), "summary checks validation");

				if (actual.equalsIgnoreCase(expectedvalue.trim())) {

					BaseSuite.validationReportLog("Expression " + label + " matched successfully ");
				} else {

					BaseSuite.reportFailLog("Expression " + label + " not matched", "validatecheckDetails");
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// select export type and download, verify and get downloaded file path
	public void selectExportReportTypeAndDownload(String instanceId, String exportFormat, String downloadType,
			String ruleID) throws Throwable {
		String s;
		try {

			moveToElement(driver, downloadButton);

			displayAndClick(driver, downloadButton);

			isDisplayed(driver, returnElement(summaryExportType, "$name", downloadType));

			if (isDisplayed(driver, returnElement(summaryExportType, "$name", downloadType))) {

				BaseSuite.validationReportLog(downloadType + " option is visible");

				BaseSuite.reportLog("clicking on " + downloadType + " option ");

				displayAndClick(driver, returnElement(summaryExportType, "$name", downloadType));

				Thread.sleep(2000);

				// verifyVisibilityOfButtons(driver, downloadingLoader, "Loader Button", true);

				inVisible(driver, downloadingLoader, Constant.ruleWait);

				BaseSuite.validationReportLog("Clicked on " + downloadType + " option successfully");

				if (isDisplayed(driver, ToastMsgClosedBtn)) {

					captureToastMsg(driver, toastMsgCon, popUpClose, noRecondToDownloadMsg,
							"After clicking save button");
				}
			} else {

				BaseSuite.reportFailLog("expected Export option not visible ", "selectExportReportTypeAndDownload");
			}
			if (downloadType.contains("All")) {

				s = "All";

			} else {

				s = "FE";
			}

			verifyDownloadedFile(ruleID, instanceId, s, exportFormat);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void verifyDownloadedFile(String ruleId, String instanceId, String downloadType, String exportFormat)
			throws Throwable {
		try {

			BaseSuite.reportLog("Getting Downloaded Exception Report File.. ");

			Thread.sleep(3000);

			File f = new File(System.getProperty("user.dir") + "\\src\\Downloads\\" + "R_" + ruleId + "_"
					+ instanceId.trim() + "_" + downloadType + "." + exportFormat.trim().toLowerCase());
			if (f.exists()) {
				BaseSuite.validationReportLog("Downloaded file available  : " + f);

			} else {
				BaseSuite.reportFailLog("File not found kindly check path : " + f, "verifyDownloadedFile");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// click on data testing sub module
	public void clickOnDataTestingSubMobuleName(String subModuleName) throws Throwable {

		try {
			// clickOnButton(driver, dataTestingOpen, "Data Testing panel Open", true);
			Thread.sleep(2000);

			clickOnButton(driver, returnElement(dataTestingSubModuleName, "$name", subModuleName), subModuleName, true);

			boolean flag = isDisplayed(driver, discardButtons);

			if (flag) {

				clickOnButton(driver, discardButtons, "Discard ", true);
			}

			// clickOnButton(driver, dataTestingClose, "Data Testing panel Close ", true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String checkExceptionSummary(String createdRuleInstanceId, String createdRuleID,
			String executedRuleJsonEntity, String exceptionReportFormat, String workspaceID, String downloadType,
			SoftAssert soft, String icedqRole, boolean expoertedFileFlag, boolean failureErrorOnly, String ruleStatus,
			String sourceCount, String targetCount, String exitCode) throws Throwable {

		TestDataThroughApi vt = new TestDataThroughApi(driver);

		String ruleID = null;

		DataTestingParameters exceptionparam = null;

		ArrayList<String> chktype = null;

		try {

			String instanceID = clickOnInstanceIDOfRuleOnRecentRuns();

			DataTestingParameters summaryparam = setExceptionSummaryParameters(executedRuleJsonEntity, 1);

			if (expoertedFileFlag) {
				if (isDisplayed(driver, downloadExceptionReport1)) {
					BaseSuite.validationReportLog(
							"Verifying the detail if Store exported file only checkbox is checked");

					if (!summaryparam.getRuleType().equalsIgnoreCase("Pushdown")) {
						verifyVisibilityOfButtons(driver, showPercentageButton, "Show Percentage Button", true);
					}

					if (summaryparam.getRuleType().equalsIgnoreCase("Recon")) {
						verifyVisibilityOfButtons(driver, highlightButton, "Highlight Button", true);

					}

					verifyVisibilityOfButtons(driver, downloadExceptionReportButton, "Download Exception Report",
							false);

					verifyVisibilityOfButtons(driver, copyUrlButton, "Share button", true);

					BaseSuite.validationReportLog(
							"Download Exception Report link is visible after click on instance id");

					displayAndClick(driver, downloadExceptionReport1);

					BaseSuite.validationReportLog("Download Exception Report link is clicked successfully");
				} else {
					BaseSuite.reportFailLog("Download Exception Report link is not visible after click on instance id",
							"checkExceptionSummary");

				}
			} else {
				if (failureErrorOnly && ruleStatus.equalsIgnoreCase("success")) {

					if (!summaryparam.getRuleType().equalsIgnoreCase("Pushdown"))

					{

						verifyVisibilityOfButtons(driver, showPercentageButton, "Show Percentage Button", true);

					}

					if (summaryparam.getRuleType().equalsIgnoreCase("Recon")) {
						verifyVisibilityOfButtons(driver, highlightButton, "Highlight Button", true);

					}

					verifyVisibilityOfButtons(driver, downloadExceptionReportButton, "Download Exception Report",
							false);

					verifyVisibilityOfButtons(driver, copyUrlButton, "Share button", true);

					if (isDisplayed(driver, checkNameNoRecord)) {

						BaseSuite.validationReportLog(
								"No records to display text is visible after click on instance id for success rule");

					} else {

						BaseSuite.reportFailLog(
								"No records to display text is not visible after click on instance id for success rule",
								"");
					}
				}

				else {
					if (sourceCount.equals("0") || targetCount.equals("0") && exitCode.equals("0")) {

						List<WebElement> noRecordCount = getElements(driver, checkNameNoRecord);

						int val = noRecordCount.size();

						if (val == 2) {

							BaseSuite.validationReportLog(
									"No record to display text is visible for zero source count and exit code");

							if (!summaryparam.getRuleType().equalsIgnoreCase("Pushdown")) {
								verifyVisibilityOfButtons(driver, showPercentageButton, "Show Percentage Button", true);

							}

							if (summaryparam.getRuleType().equalsIgnoreCase("Recon")) {
								verifyVisibilityOfButtons(driver, highlightButton, "Highlight Button", true);
							}

							verifyVisibilityOfButtons(driver, downloadExceptionReportButton,
									"Download Exception Report", false);

							verifyVisibilityOfButtons(driver, copyUrlButton, "Share button", true);

						} else {

							BaseSuite.reportFailLog(
									"No record to display text is not visible for zero source count and exit code", "");
						}

					}

					else {

						int count = 0;

						// DataTestingParameters summaryparam =
						// setExceptionSummaryParameters(executedRuleJsonEntity, 1);

						ruleID = summaryparam.getRuleObjectId();

						String status = summaryparam.getInstanceStatus();

						String finalStatus = status.substring(0, 1).toUpperCase() + status.substring(1);
						;

						validateExceptionReportPage(summaryparam.getRuleName(), summaryparam.getRuleType(), finalStatus,
								soft);

						if (!summaryparam.getWorkflowStatus().equalsIgnoreCase("error")) {

							if (!isDisplayed(driver, norecordsOnSummary)) {

								if (summaryparam.getRuleType().toLowerCase().contains("recon")) {

									ArrayList<String> chktype1 = TestDataThroughApi
											.getJsonArrayValueUsingJsonPathExpreesion(executedRuleJsonEntity,
													reconSummaryExpIndexList);

									exceptionparam = setExceptionSummaryParameters1(executedRuleJsonEntity,
											summaryparam.getRuleType(), "1");

									validateDiffJoinSummary(exceptionparam, soft);

									for (int y = 1; y < chktype1.size(); y++) {

										exceptionparam = setExceptionSummaryParameters1(executedRuleJsonEntity,
												summaryparam.getRuleType(), chktype1.get(y));

										validateChecksOnExceptionReportSummary(exceptionparam,
												summaryparam.getRuleType(), soft);

									}

								} else {

									chktype = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, valSummaryExpIndexList);

									if (summaryparam.getRuleType().equalsIgnoreCase("pushdown")) {
										count = chktype.size();

										if (count > 8) {
											count = 8;
										}

									} else {
										count = chktype.size();
									}

									for (int y = 1; y < count; y++) {

										exceptionparam = setExceptionSummaryParameters1(executedRuleJsonEntity,
												summaryparam.getRuleType(), chktype.get(y));

										validateChecksOnExceptionReportSummary(exceptionparam,
												summaryparam.getRuleType(), soft);

									}

								}

								displayAndClick(driver, summary_SearchBar);

								displayAndClick(driver, searchBarClear);

								displayAndClick(driver, selectAllCheckBox);

								if (summaryparam.getRuleType().equalsIgnoreCase("pushdown")) {
									if (count > 6) {
										displayAndClick(driver, selectAllCheckBox);
									}
								}

								List<WebElement> list = driver.findElements(listOfCheckNames);

								int count1;

								if (summaryparam.getRuleType().equalsIgnoreCase("pushdown")) {
									count1 = list.size();

									if (count1 > 8) {
										count1 = 8;
									}
								} else {
									count1 = list.size();
								}

								for (int i = 0; i < count1; i++) {

									String checkName = list.get(i).getText();

									int k;

									if (summaryparam.getRuleType().equalsIgnoreCase("Recon")) {
										k = 1;
									} else {
										k = 2;
									}

									exceptionparam = setExceptionSummaryParameters1(executedRuleJsonEntity,
											summaryparam.getRuleType(), Integer.toString(i + k));

									Thread.sleep(2000);

									if (checkName.equalsIgnoreCase("DiffJoin")) {

										validatecheckDetails(executedExceptionReportDiffJoinName, "DiffJoin",
												"Diff Join Name", soft);

										validatecheckDetails(
												returnElement(executedExceptionReportDiffSuccessCount, "$name",
														"DiffJoin"),
												exceptionparam.getDiffJoinSuccess(), "Success Count", soft);

										validatecheckDetails(
												returnElement(executedExceptionReportDiffFailureCount, "$name",
														"DiffJoin"),
												exceptionparam.getDiffJoinFailure(), "Failure Count", soft);

										validatecheckDetails(
												returnElement(executedExceptionReportDiffErrorCount, "$name",
														"DiffJoin"),
												exceptionparam.getDiffJoinError(), "Error Count", soft);

										ArrayList<String> joinList = TestDataThroughApi
												.getJsonArrayValueUsingJsonPathExpreesion(executedRuleJsonEntity,
														"$.items[0].ruleInfo.objects[2].configuration.joins..index");

										for (int j = 0; j < joinList.size(); j++) {
											String sourceJoin = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
													executedRuleJsonEntity,
													"$.items[0].ruleInfo.objects[2].configuration.joins[" + j
															+ "].sourceKey");

											String targetJoin = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
													executedRuleJsonEntity,
													"$.items[0].ruleInfo.objects[2].configuration.joins[" + j
															+ "].targetKey");

											if (sourceJoin.equalsIgnoreCase(targetJoin)) {
												boolean flag = isDisplayed(driver,
														returnTwoElements(executedExceptionReportColumnName,
																"$checkname", "DiffJoin", "$name",
																sourceJoin.toUpperCase()));

												if (flag) {
													BaseSuite.validationReportLog(
															"Diff join column is visible on exception report");
												} else {
													BaseSuite.reportFailLog(
															"Diff join column is not visible on exception report",
															"ValidatingDiffJoinColumnName");
												}
											} else {

												boolean flag = isDisplayed(driver, returnTwoElements(
														executedExceptionReportColumnName, "$checkname", "DiffJoin",
														"$name",
														sourceJoin.toUpperCase() + " / " + targetJoin.toUpperCase()));

												if (flag) {
													BaseSuite.validationReportLog(
															"Diff join column is visible on exception report");
												} else {
													BaseSuite.reportFailLog(
															"Diff join column is not visible on exception report",
															"ValidatingDiffJoinColumnName");
												}
											}

										}

									}

									else {

										displayAndClick(driver, returnElement(checkNameChecckBox, "$name", checkName));

										validatecheckDetails(executedExceptionReportCheckName,
												exceptionparam.getChkCheckName(), "Check Name", soft);

										if (!exceptionparam.getChkCheckType().contains("Column")) {
											validatecheckDetails(
													returnElement(executedExceptionReportSuccessCount, "$name",
															checkName),
													exceptionparam.getSuccessValue(), "Success Count", soft);

											validatecheckDetails(
													returnElement(executedExceptionReportFailureCount, "$name",
															checkName),
													exceptionparam.getFailureValue(), "Failure Count", soft);

											validatecheckDetails(
													returnElement(executedExceptionReportErrorCount, "$name",
															checkName),
													exceptionparam.getErrorValue(), "Error Count", soft);

										}

										// validatecheckDetails(returnTwoElements(executedExceptionReportColumnName,
										// "$checkname", checkName, "$name", ruleID), exceptionparam.getErrorValue(),
										// "Column Name", soft);

										List<WebElement> dataList = getElements(driver, checkColumnDataList);

										if (dataList.size() > 0) {

											BaseSuite.validationReportLog("On " + checkName
													+ " column record table is displayed after selecting " + checkName
													+ " column checkbox");

										} else {
											BaseSuite.reportFailLog("On " + checkName
													+ " column record table is not displayed after selecting "
													+ checkName + " column checkbox", checkName);

										}

										displayAndClick(driver, returnElement(checkColumnCheck, "$name", checkName));

										if (summaryparam.getRuleType().equalsIgnoreCase("Validation")
												|| summaryparam.getRuleType().equalsIgnoreCase("Pushdown")) {
											if (isDisplayed(driver, checkNameNoRecord)) {
												BaseSuite.validationReportLog("On " + checkName
														+ " column record table is not displayed after unselecting "
														+ checkName + " column checkbox");

											} else {
												BaseSuite.reportFailLog("On " + checkName
														+ " column record table is displayed after unselecting "
														+ checkName + " column checkbox", checkName);

											}
										} else {
											if (isDisplayed(driver, checkNameNoRecord)) {

												BaseSuite.reportFailLog(
														"On Diff join column record table is not displayed after unselecting "
																+ checkName + " column checkbox",
														checkName);

											} else {

												BaseSuite.validationReportLog(
														"On Diff join column record table is displayed after unselecting "
																+ checkName + " column checkbox");

											}

										}

									}

								}
							}
						}

						String executedRuleJsonEntity1 = vt.exceptionJsonbody(createdRuleInstanceId,
								BaseSuite.WorkspaceID, icedqRole);

						DataTestingParameters summaryparam1 = setExceptionSummaryParameters(executedRuleJsonEntity1, 1);

						selectExportReportTypeAndDownload(createdRuleInstanceId, exceptionReportFormat, downloadType,
								createdRuleID);

					}
				}

			}

		}

		catch (Exception e) {
			e.getMessage();
		}
		return ruleID;
	}

	public DataTestingParameters setExceptionSummaryParameters1(String jsonEntity, String ruleType, String chkNum)
			throws Exception {
		DataTestingParameters param = new DataTestingParameters();

		try {
			if (ruleType.toLowerCase().contains("validation") || ruleType.toLowerCase().contains("pushdown")) {
				param.setChkCheckName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						vsummaryReportChecksPath + chkNum + ")].name"));
				param.setChkCheckType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						vsummaryReportChecksPath + chkNum + ")].type"));
				param.setSuccessValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						vsummaryReportChecksPath + chkNum + ")].instance.successCount"));
				param.setFailureValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						vsummaryReportChecksPath + chkNum + ")].instance.failureCount"));
				param.setErrorValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						vsummaryReportChecksPath + chkNum + ")].instance.errorCount"));
				param.setExceptionReportFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[2].configuration.format[0]"));
				param.setShowDownloadExceptionurl(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[2].configuration.createExportDownloadLink"));
			} else {

				param.setChkCheckName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						rsummaryReportChecksPath + chkNum + ")].name"));

				param.setChkCheckType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						rsummaryReportChecksPath + chkNum + ")].type"));

				param.setSuccessValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						rsummaryReportChecksPath + chkNum + ")].instance.successCount"));

				param.setFailureValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						rsummaryReportChecksPath + chkNum + ")].instance.failureCount"));

				param.setErrorValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						rsummaryReportChecksPath + chkNum + ")].instance.errorCount"));

				param.setExceptionReportFormat(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[4].configuration.format[0]"));

				param.setShowDownloadExceptionurl(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[2].configuration.createExportDownloadLink"));

				param.setDiffJoinSuccess(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[3].configuration.checks[0].instance.successCount"));

				param.setDiffJoinFailure(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[3].configuration.checks[0].instance.failureCount"));

				param.setDiffJoinError(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.items[0].ruleInfo.objects[3].configuration.checks[0].instance.errorCount"));
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("");
		}
		return param;
	}

	public void validateChecksOnExceptionReportSummary(DataTestingParameters param, String ruleType, SoftAssert soft)
			throws InterruptedException {

		TestDataThroughApi vt = new TestDataThroughApi(driver);

		if (param.getChkCheckName() != null && !param.getChkCheckType().contains("Column")) {
			BaseSuite.reportLog("Verifying Expression on Exception report summary ");

			searchCheckNameInExceptionReportSummarySection(param.getChkCheckName());

			if (isDisplayed(driver, returnElement(summarycheckName, "$name", param.getChkCheckName()))) {

				BaseSuite.reportLog(
						"================ validating expression : " + param.getChkCheckName() + " ===============");

				vt.validatecheckDetails(returnElement(summarycheckName, "$name", param.getChkCheckName()),
						param.getChkCheckName(), "Expression Name", soft);

				/*
				 * vt.validatecheckDetails(returnElement(summarycheckType, "$name",
				 * param.getChkCheckName()), param.getChkCheckType(), "Expression Type", soft);
				 */

				verifyIndividualLabel(driver, returnTwoElements(summarycheckType, "$name", param.getChkCheckName(),
						"$checkType", param.getChkCheckType()), param.getChkCheckType() + " Check Icon");

				vt.validatecheckDetails(returnElement(summarycheckSuccessCount, "$name", param.getChkCheckName()),
						param.getSuccessValue(), "Expression Success count", soft);

				vt.validatecheckDetails(returnElement(summarycheckFailureCount, "$name", param.getChkCheckName()),
						param.getFailureValue(), "Expression Failure count", soft);

				vt.validatecheckDetails(returnElement(summarycheckErrorCount, "$name", param.getChkCheckName()),
						param.getErrorValue(), "Expression Error count", soft);

			} else {

				BaseSuite.reportFailLog("Expression not found kindly check " + param.getChkCheckName(),
						"validateChecksOnExceptionReportSummary");
			}

		} else if (param.getChkCheckType().contains("Column")) {

			searchCheckNameInExceptionReportSummarySection(param.getChkCheckName());

			if (isDisplayed(driver, returnElement(summarycheckName, "$name", param.getChkCheckName()))) {

				vt.validatecheckDetails(returnElement(summarycheckName, "$name", param.getChkCheckName()),
						param.getChkCheckName(), "Column Name", soft);

				verifyIndividualLabel(driver, returnTwoElements(summarycheckType, "$name", param.getChkCheckName(),
						"$checkType", param.getChkCheckType()), param.getChkCheckType() + " Check Icon");

				if (ruleType.equalsIgnoreCase("pushdown")) {
					String val = getAttribute(driver, returnElement(columnCheckBox, "$name", param.getChkCheckName()),
							"class");

					if (val.contains("check")) {
						BaseSuite
								.validationReportLog("For column " + param.getChkCheckName() + " checkbox is checked ");
					} else {
						BaseSuite.validationReportLog(
								"For column " + param.getChkCheckName() + " checkbox is unchecked ");
					}
				}

			} else {
				BaseSuite.reportFailLog("Column not found kindly check " + param.getChkCheckName(),
						"validateChecksOnExceptionReportSummary");
			}
		}

	}

	public void searchCheckNameInExceptionReportSummarySection(String checkName) throws InterruptedException {

		try {
			isDisplayed(driver, summary_SearchBar);
			if (isDisplayed(driver, summary_SearchBar)) {

				BaseSuite.reportLog("Entering expression name : " + checkName);

				clear_Click_SendKeys(driver, 8, summary_SearchBar, checkName);

				BaseSuite.validationReportLog("Entered expression name successfully");

				isDisplayed(driver, summary_SearchBtn);

				if (isDisplayed(driver, summary_SearchBtn)) {

					BaseSuite.reportLog("Clicking on search button");

					// click(driver, summary_SearchBtn);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();",
							driver.findElement(summary_SearchBtn));
					BaseSuite.validationReportLog("Clicked on search button");

					inVisible(driver, spinner, Constant.ruleWait);

					Thread.sleep(2000);
				} else {
					BaseSuite.reportFailLog("search button not visible",
							"searchCheckNameInExceptionReportSummarySection");
				}

			} else {
				BaseSuite.reportFailLog("search bar not visible", "searchCheckNameInExceptionReportSummarySection");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// -------------------Vipul's Method Ends-------------------------
	/*****************************************
	 * Neha's comman methods
	 *********************************************************************************/
	/**********************
	 * Check section (New custom check & add column) related methods
	 ***********************/

	public void verifyAllAddedColumnNColexpName(DataTestingParameters param, String jsonEntity) throws Exception {
		TestDataThroughApi nn = new TestDataThroughApi(driver);
		String colName = null, genColExpName = null, genColExp = null, actColExpName = null, actColExp = null;
		try {
			param.setColumnList(nn.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns..name"));
			List<WebElement> actualColExp = getElements(driver, pushdown_allExpName);
			int ae = actualColExp.size();
			// $.objects[1].configuration.checks..name - check name
			List<WebElement> actualColChkName = getElements(driver, pushdown_allChkName);
			int an = actualColChkName.size();

			int total = param.getColumnList().size();
			int j = 0, l = 0;
			BaseSuite.validationReportLog("Verifying all column added as an expression in rule with expression name :");
			for (int i = 0, k = 1; (i < total & i < ae) & (k <= an); i++, k++) {

				colName = param.getColumnList().get(i);
				genColExp = generateColumnCheckExpForPushdown(colName);
				genColExpName = generateColumnCheckNameForPushdown(colName);

				// verify generated ones with actual ones
				actColExp = actualColExp.get(i).getAttribute("title");
				System.out.println(actColExp);
				actColExpName = actualColChkName.get(k).getText();
				System.out.println(actColExpName);

				if (genColExp.equalsIgnoreCase(actColExp)) {
					j++;
					BaseSuite.reportLog("Column expression is generated as expected :: " + actColExp);

				} else {
					BaseSuite.reportFailLog(
							"Unable to match actual column expression:: " + actColExp + " with expected:: " + genColExp,
							"verifyAllAddedColumnNColexpName");
				}

				if (genColExpName.equalsIgnoreCase(actColExpName)) {
					l++;
					BaseSuite.reportLog("Column expression name is generated as expected :: " + actColExpName);
				} else {
					BaseSuite.reportFailLog(
							"Unable to match actual column expression:: " + actColExp + " with expected:: " + genColExp,
							"verifyAllAddedColumnNColexpName");
				}

			}

			if (j == l) {
				BaseSuite.validationReportLog("All column expression & name added to the rule i.e. " + j
						+ " expression successfully verified.");
			}

		} catch (Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}
	}

	// method to click on add button
	public void clickOnCheck_AddButton() {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", check_add_button);
			isDisplayed(driver, check_add_button);
			BaseSuite.reportLog("Add button is displayed.");
			isClickable(driver, check_add_button, "Add ", true);
			displayAndClick(driver, check_add_button);
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if (isDisplayed(driver, custom_Check_pane_inputBox)) {
				BaseSuite.validationReportLog("Add button is clicked successfully & custom check pane is opened.");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on New Check button from list of options.
	public void clickOnNewCheckMenuOption() {
		try {
			isDisplayed(driver, check_add_NewChkbutton);
			BaseSuite.reportLog("New check button/menu option is displayed.");
			isClickable(driver, check_add_NewChkbutton, "New Check ", true);
			displayAndClick(driver, check_add_NewChkbutton);
			BaseSuite.validationReportLog("New check button/menu option is clicked successfully.");
			isDisplayed(driver, check_NewChecks_Panel);
			BaseSuite.validationReportLog("New Checks panel is displayed.");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on Add column button from list of options.
	public void clickOnAddColumnMenuOption() {
		try {
			isDisplayed(driver, check_add_AddColbutton);
			BaseSuite.reportLog("Add column button/menu option is displayed.");
			isClickable(driver, check_add_AddColbutton, "Add Column", true);
			displayAndClick(driver, check_add_AddColbutton);
			BaseSuite.validationReportLog("Add column button/menu option is clicked successfully.");
			isDisplayed(driver, check_AddColumn_Sidebar);
			BaseSuite.validationReportLog("Add column sidebar is opened.");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to return number of column available in add column side bar
	public String returnNoColavailable_AddCol() {
		String noCol = null, comString;
		try {
			isDisplayed(driver, check_AddCol_Sidebar_srch_noOfCol);
			comString = getText(driver, check_AddCol_Sidebar_srch_noOfCol);
			String[] label = comString.split(" ");
			String temp = label[0];
			noCol = temp.substring(1);
		} catch (Exception e) {
			BaseSuite.reportLog(e.getMessage());
		}
		return noCol;
	}

	// method to add New custom check expression of user choice.Final for API

	public void addCustomCheckExpression(DataTestingParameters param, SoftAssert soft) throws Throwable {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			String checkName, checkStatus, checkType, dimension, customExpression;
			// set parameters
			checkName = param.getChkCheckName();
			// dimension = param.getChkDimension();
			checkStatus = param.getChkStatus();
			customExpression = param.getChkExpression();
			Thread.sleep(1000);

			clickOnAddButtonSideMenu();

			clickOnNewCustomCheckMenuOption();

			Thread.sleep(1000);

			isDisplayed(driver, custom_Check_pane_inputBox);

			boolean chkPane = isDisplayed(driver, custom_Check_pane_inputBox);
			isDisplayed(driver, check_custCol_textarea);
			boolean chkTextArea = isDisplayed(driver, check_custCol_textarea);
			if ((chkPane) & (chkTextArea)) {
				// add check name

				String chkname = dp.enterCheckName(checkName);

				// add custom expression - NEED TO CREATE NEW METHOD
				String chkStatus = dp.selectCheckEnableStatus(checkStatus);

				addAndValidatedAddedExpression(checkName, customExpression.trim(), chkStatus, soft);

			} else {
				BaseSuite.reportFailLog("Custom Check pane is displaye , but without UI content. Kindly check. ",
						"addCustomChkExpressionToRule");
			}

		} catch (Exception e) {

		}
	}

	// dimesion has been removed from API - need to delete after final merge
	public void verifyDimensionOfExp(String dimension, SoftAssert soft) {
		try {

			isDisplayed(driver, customExp_dropdownlist_dimension);
			boolean dimStatus = isDisplayed(driver, customExp_dropdownlist_dimension);

			if (dimStatus) {
				BaseSuite.reportLog("Dimension dropdown is displayed on custom exp pane.");
				String dimVal = getAttribute(driver, customExp_dropdownlist_dimension, "aria-label");
				soft.assertEquals(dimVal, dimension,
						"Expected dimension value i.e. " + dimension + ", didnt matched with actual i.e. " + dimVal);
				if (dimVal.equalsIgnoreCase(dimension)) {
					BaseSuite.validationReportLog("Expected dimension value matched with actual. i.e. " + dimension);
				} else {

					BaseSuite.reportFailLog(
							"Expected dimension value i.e. " + dimension + ", didnt matched with actual i.e. " + dimVal,
							"verifyDimensionOfExp");
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.getMessage() + ", error in verifyDimensionOfExp method.");
		}
	}

	public void addAndValidatedAddedExpression(String checkName, String expression, String checkStatus, SoftAssert soft)
			throws Exception, Throwable {
		try {

			isDisplayed(driver, check_custCol_textarea);
			BaseSuite.reportLog("Textbox is displayed to enter expression.");
			Thread.sleep(1000);
			clear_SendKeys(driver, check_custCol_textarea, expression);
			BaseSuite.reportLog("Adding custom expression : " + expression + " to rule.");
			// Need to add Test logic.

			if (isDisplayed(driver, check_AddCheck_btn)) {
				if (isEnabled(driver, check_AddCheck_btn)) {
					BaseSuite.validationReportLog("Add check button is displayed and its enabled.");
					displayAndClick(driver, check_AddCheck_btn);
					BaseSuite.reportLog("Button clicked successfully.");
					inVisible(driver, spinner, Constant.ruleWait);
					BaseSuite.reportLog("Spinner is displayed.");
					Thread.sleep(1500);
					// captureToastMsg(driver, toastMsgCon, popUpClose,
					// toastMessageAfterSaveListOptions,"After addin custom expression");
					verifyAddCustomExpressiontoRule(checkName, expression, checkStatus, soft);
				} else {
					BaseSuite.reportFailLog(
							"Save button is not enabled when after entering custom expression , kindly check.",
							"addAndValidatedAddedExpression");
				}

			} else {
				BaseSuite.reportFailLog("Save button is not displayed on add custom check pane , kindly check.",
						"addAndValidatedAddedExpression");
			}
			javascript(driver, "arguments[0].scrollIntoView(true);", check_add_button);

		} catch (Exception e) {
		}
	}

	// ********************* result type related methods ***********************//

	// method to select multipleResult Type.
	public void selectResultType(DataTestingParameters param) {
		try { //
			isDisplayed(driver, check_resultType_rowLabel);
			BaseSuite.reportLog("result type is displayed.");
			switch (param.ruleType.toLowerCase()) {
			case "recon":
			case "ht recon":
				uncheckDefaultResultTypeForRule(param);
				BaseSuite.reportLog(
						"Selecting result type for " + param.ruleType.toLowerCase() + " rule as per user choice.");
				chooseResultTypeForRecon(param);

				break;
			case "validation":
			case "ht validation":
				BaseSuite.reportLog(
						"Selecting result type for " + param.ruleType.toLowerCase() + " rule as per user choice.");
				chooseResultTypeForValidation(param);

				break;
			case "pushdown":
				break;

			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// method uncheck all by default result types
	public void uncheckDefaultResultTypeForRule(DataTestingParameters param) {
		String rA_B, rB_A, rExp, r_AnB, status;
		try {

			switch (param.ruleType.toLowerCase()) {
			case "recon":
			case "ht recon":
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "a-b"));
				rA_B = getAttribute(driver, returnElement(ruleResultType, "$resultType", "a-b"), "aria-checked");
				if (rA_B.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "a-b"));

				}
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "b-a"));
				rB_A = getAttribute(driver, returnElement(ruleResultType, "$resultType", "b-a"), "aria-checked");
				if (rB_A.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "b-a"));
				}
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "expression"));
				rExp = getAttribute(driver, returnElement(ruleResultType, "$resultType", "expression"), "aria-checked");
				if (rExp.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "expression"));
				}
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "anb"));
				r_AnB = getAttribute(driver, returnElement(ruleResultType, "$resultType", "anb"), "aria-checked");
				if (r_AnB.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "anb"));
				}
				break;
			case "validation":
			case "ht validation":
				String status_exp, status_row;
				// returnElement(ruleResultType, "$resultType", exp);
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "expression"));
				status_exp = getAttribute(driver, returnElement(ruleResultType, "$resultType", "expression"),
						"aria-checked");
				if (status_exp.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "expression"));

				}
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "rowcount"));
				status_row = getAttribute(driver, returnElement(ruleResultType, "$resultType", "rowcount"),
						"aria-checked");
				if (status_row.equalsIgnoreCase("true")) {
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "rowcount"));

				}

				break;

			}

			BaseSuite.reportLog("Clear default selected result type.");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to click on Save&Validate&Publish menu button from options.
	public boolean clickOnPublishButton() throws Exception, Throwable {
		boolean flag = true;
		try {
			isDisplayed(driver, rulePublishButton);
			BaseSuite.reportLog("Publish button is displayed.");
			displayAndClick(driver, rulePublishButton);
			BaseSuite.validationReportLog("Publish button clicked successfully.");
			inVisible(driver, spinner, Constant.ruleWait);
			// currently no message is displayed after clicking publish
			captureToastMsg(driver, toastMsgCon, popUpClose, toastMessageAfterSaveListOptions,
					"After clicking Publish button");

			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Thread.sleep(2000);
			if (isDisplayed(driver, ruleCurrentStatus)) {
				String status = getAttribute(driver, ruleCurrentStatus, "title");
				if (status.trim().equalsIgnoreCase(status_Publish)) {
					BaseSuite.validationReportLog(
							"After clicking published button, icon next to rule name successfully changed to "
									+ status_Validate + ".");
				} else {
					BaseSuite.reportErrorLog("After clicking published button, rule status changed to " + status
							+ ",which is not expected kindly check.");
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return flag;
	}

	//// method to click on Save&Validate&Publish menu button from options.
	public boolean clickOnPublishButton(String expMsg) throws Exception {
		boolean flag = true;
		try {
			isDisplayed(driver, rulePublishButton);
			BaseSuite.reportLog("Publish button is displayed.");
			displayAndClick(driver, rulePublishButton);
			BaseSuite.validationReportLog("Publish button clicked successfully.");
			inVisible(driver, spinner, Constant.ruleWait);
			// currently no message is displayed after clicking publish
			captureToastMsg(driver, toastMsgCon, popUpClose, expMsg, "After clicking Publish button");

		} catch (Exception e) {
			flag = false;
			throw new Exception(e.getMessage());
		}
		return flag;
	}

	// verify name has been updated on rule label too.
	public boolean isLabelUpdate(String ruleLabel) throws Exception, InterruptedException {
		boolean status = false;
		String label = null;
		try {
			isDisplayed(driver, ruleCurrentStatus);
			Thread.sleep(1500);
			label = getText(driver, ruleCurrentStatus);
			if (label.equalsIgnoreCase(ruleLabel)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {

		}
		return status;
	}

	// get total countofExpression for rule as per testdata.
	public int totalExpressionsInRule(DataTestingParameters param) {
		int noExp = 0;
		int countNChk = 0, countCustChk = 0;
		try {
			if ((param.ruleType.equalsIgnoreCase("recon")) | (param.ruleType.equalsIgnoreCase("validation"))) {
				String newCheck, custExp;

				newCheck = param.getAddCheck();
				custExp = param.getChk_CustExpressions();
				if (!newCheck.isEmpty()) {
					String[] tNewChk = newCheck.split(",");
					countNChk = tNewChk.length;
				}
				if (!custExp.isEmpty()) {
					String[] tcustChk = custExp.split(",");
					countCustChk = tcustChk.length;
				}

				noExp = countNChk + countCustChk;
			} else if (param.ruleType.equalsIgnoreCase("checksum")) {

				noExp = 1;
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return noExp;

	}

	public void validateAddedColumnListDetails(String checkType, String colname, String expression,
			String expectedColExpName, SoftAssert soft) throws Throwable {

		Thread.sleep(2000);

		scrollToLocator(returnElement(check_addedCol_expression, "$expCol", expression), expression);

		BaseSuite.reportLog("Verifying name & expression for added column:" + colname);
		boolean statusE = isDisplayed(driver, returnElement(check_addedCol_expression, "$expCol", expression));
		boolean statusN = isDisplayed(driver, returnElement(check_addedCol_colName, "$expCol", expression));
		if ((statusE) & (statusN)) {

			String tempExp = getText(driver, returnElement(check_addedCol_expression, "$expCol", expression));

			if (tempExp.equalsIgnoreCase(expression)) {
				soft.assertEquals(tempExp, expression, "Add column check expression didnt matched with expected.");

				BaseSuite.validationReportLog(
						"Expression :: " + expression + " has been added to check section successfully.");

				String chk_ColName = getText(driver,
						returnElement(check_addedCol_colName, "$expCol", expression.trim())).trim();

				System.out.println("##Column Name:: " + chk_ColName);

				if (!chk_ColName.isEmpty()) {

					if (chk_ColName.trim().equalsIgnoreCase(expectedColExpName.trim())) {

						soft.assertEquals(chk_ColName.trim(), expectedColExpName.trim(),
								"Actual column check name didnt matched with expected.");

						BaseSuite.validationReportLog("Name :: " + chk_ColName + " has been added successfully.");

					} else {
						BaseSuite.reportFailLog(
								"Column name hasnt added with expected format i.e. expected format="
										+ expectedColExpName + " where as actual=" + chk_ColName + " ,kindly check.",
								"validateAddedColumnListDetails");
					}
				} else {
					BaseSuite.reportErrorLog("Unable to read added column's name, kindly check.");
				}
			} else {
				BaseSuite.reportFailLog("Column expression hasn't added with expected format, kindly check.",
						"validateAddedColumnListDetails");
			}
		}

	}

	// validate add column to the rule.
	public void validateAddedColumnListDetails(String colname, String expression, String expectedColExpName,
			SoftAssert soft) {

		BaseSuite.reportLog("Verifying name & expression for added column:" + colname);
		boolean statusE = isDisplayed(driver, returnElement(check_addedCol_expression, "$expCol", expression));
		boolean statusN = isDisplayed(driver, returnElement(check_addedCol_colName, "$expCol", expression));
		if ((statusE) & (statusN)) {

			String tempExp = getAttribute(driver, returnElement(check_addedCol_expression, "$expCol", expression),
					"title");
			if (tempExp.equalsIgnoreCase(expression)) {
				soft.assertEquals(tempExp, expectedColExpName,
						"Add column check expression didnt matched with expected.");
				BaseSuite.validationReportLog(
						"Expression :: " + expression + " has been added to check section successfully.");
				String chk_ColName = getText(driver,
						returnElement(check_addedCol_colName, "$expCol", expression.trim()));
				if (!chk_ColName.isEmpty()) {
					if (chk_ColName.equalsIgnoreCase(expectedColExpName.trim())) {
						soft.assertEquals(chk_ColName, expectedColExpName,
								"Actual column check name didnt matched with expected.");
						BaseSuite.validationReportLog("Name :: " + chk_ColName + " has been added successfully.");
					} else {
						BaseSuite.reportFailLog(
								"Column name hasnt added with expected format i.e. expected format="
										+ expectedColExpName + " where as actual=" + chk_ColName + " ,kindly check.",
								"validateAddedColumnListDetails");
					}
				} else {
					BaseSuite.reportErrorLog("Unable to read added column's name, kindly check.");
				}
			} else {
				BaseSuite.reportFailLog("Column expression hasn't added with expected format, kindly check.",
						"validateAddedColumnListDetails");
			}
		}

	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Methods using API Testdata
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	// ++++++++++++++++++++++++++++++++++++++++++++++++Neha's updated Methods for
	// api testdata *******************************************************

	// Neha's Method to set parameter
	public DataTestingParameters setColumnValidationParametersUsingApi(String jsonEntity, String settingType, int i)
			throws Exception {
		DataTestingParameters param = new DataTestingParameters();
		TestDataThroughApi nn = new TestDataThroughApi(driver);
		param.setRuleType(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.ruleType"));
		String ruleType = param.getRuleType();
		if (settingType.equalsIgnoreCase("source")) {
			param.setColumnList(nn.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.payload.info.objects[0].configuration.columns..columnName"));
			param.setColumnName(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns[" + i + "].name"));
			param.setColumnDataType(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns[" + i + "].datatype"));

		} else if (settingType.equalsIgnoreCase("target")) {
			if (param.getRuleType().equalsIgnoreCase("recon")) {
				param.setColumnName(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.info.objects[5].configuration.columns[" + i + "]..columnName"));
				param.setColumnDataType(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.info.objects[5].configuration.columns[" + i + "]..datatype"));

			} else if (param.getRuleType().equalsIgnoreCase("checksum")) {
				param.setColumnName(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.columns[0].name"));
				param.setColumnDataType(nn.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.columns[0].datatype"));
			}

		}

		return param;
	}

	/*
	 * //select result types //method to select multipleResult Type. public void
	 * selectResultType(String ruleType, String resultTypes) {
	 * try{isDisplayedInLoop(driver,1,check_resultType_rowLabel);BaseSuite.
	 * reportLog("result type is displayed.");uncheckDefaultResultTypeForRule(
	 * ruleType);switch(ruleType.toLowerCase()){case"recon":BaseSuite.
	 * reportLog("Selecting result type for recon rule as per user choice.");
	 * chooseResultTypeForReconUsingApi(resultTypes);
	 * 
	 * break;case"validation":BaseSuite.
	 * reportLog("Selecting result type for validation ruleas per user choice.");
	 * chooseResultTypeForValidationUsingApi(resultTypes); //
	 * chooseResultTypeForValidation(resultTypes);
	 * 
	 * break;case"checksum": // code block break; } } catch (Exception e) {
	 * e.getMessage();=======
	 * 
	 * }
	 * 
	 * }catch(Exception
	 * e){BaseSuite.reportLog("received error::- "+e.getMessage());} }
	 */

	// New Method to validate source/target columns fast one
	public void validateConnectionColNDatatype(String ruletype, String settingType, int total, SoftAssert soft)
			throws Throwable {
		try {
			String colName = null, colDataType = null;
			boolean statusOfSource, statusOfTarget;

			// clickon tab as per setting type

			if (settingType.equalsIgnoreCase("source")) {
				scrollToLocator(sourceSettingTab, "sourceSetting tab");

				if (isDisplayed(driver, sourceSettingTab)) {
					BaseSuite.reportLog("SourceSetting tab is displayed , clicking it.");

					isClickable(driver, sourceSettingTab, "source setting tab", true);

					displayAndClick(driver, sourceSettingTab);

					BaseSuite.validationReportLog("Successfully clicked on sourceSetting tab.");

					boolean flag = isDisplayed(driver, sourceDatasetConnectionType);

					if (flag) {

						statusOfSource = isDisplayed(driver, scolVal_NoRecord);

						if (!statusOfSource) {
							if (ruletype.equalsIgnoreCase("checksum")) {
								isDisplayed(driver, scolVal_ColName);
								colName = getText(driver, scolVal_ColName);
								isDisplayed(driver, scolVal_ColDataType_chk);
								colDataType = getText(driver, scolVal_ColDataType_chk);
								BaseSuite
										.validationReportLog("For checksum rule , in source setting has column name :: "
												+ colName + " & its data type :: " + colDataType);
							} else if ((ruletype.equalsIgnoreCase("recon"))
									|| (ruletype.equalsIgnoreCase("validation"))) {
								List<WebElement> colNames = getElements(driver, scolVal_ColName);
								List<WebElement> coldatatypes = getElements(driver, scolVal_Coldatatype);

								int tcol = 0, tcolD = 0;
								tcol = colNames.size();
								tcolD = coldatatypes.size();

								if ((tcol == total) & (tcolD == total)) {
									BaseSuite.validationReportLog(
											"Total number of columns available after get data are matched i.e. total="
													+ total + " are displayed in source.");
								} else {
									BaseSuite.reportFailLog(
											"Unable to match database record received using api and at application , kindly reverify it.",
											"validateConnectionColNDatatype");

								}
							}
						} else {
							BaseSuite.reportFailLog(
									"Source table column not retrived from connection selected , kindly check.",
									"validateConnectionColNDatatype");
						}

					} else {
						BaseSuite.reportErrorLog(
								"After clicking source setting user is not redirected to source setting UI, Kindly check");
					}

				} else {
					BaseSuite.reportErrorLog(
							"In source setting, sourceSetting tab button is not displayed, Kindly check");
				}

			} else if (settingType.equalsIgnoreCase("target")) {
				scrollToLocator(targetSettingTab, "targetSetting tab");

				if (isDisplayed(driver, targetSettingTab)) {
					BaseSuite.reportLog("TargetSetting tab is displayed , clicking it.");

					isClickable(driver, targetSettingTab, "targetSetting tab", true);

					displayAndClick(driver, targetSettingTab);

					BaseSuite.validationReportLog("Successfully clicked on targetSetting tab.");

					boolean flag = isDisplayed(driver, targetDatasetConnectionType);

					if (flag) {
						statusOfTarget = isDisplayed(driver, tcolVal_NoRecord);

						if (!statusOfTarget) {
							if (ruletype.equalsIgnoreCase("checksum")) {
								javascript(driver, "arguments[0].scrollIntoView(true);", tcolVal_ColName);
								isDisplayed(driver, tcolVal_ColName);
								colName = getText(driver, tcolVal_ColName);
								isDisplayed(driver, tcolVal_ColDataType_chk);
								colDataType = getText(driver, tcolVal_ColDataType_chk);
								BaseSuite
										.validationReportLog("For checksum rule , in target setting has column name :: "
												+ colName + " & its data type :: " + colDataType);
							} else if ((ruletype.equalsIgnoreCase("recon"))
									|| (ruletype.equalsIgnoreCase("validation"))) {
								List<WebElement> colNames = getElements(driver, tcolVal_ColName);
								List<WebElement> coldatatypes = getElements(driver, tcolVal_Coldatatype);

								int tcol = 0, tcolD = 0;
								tcol = colNames.size();
								tcolD = coldatatypes.size();

								if ((tcol == total) & (tcolD == total)) {
									BaseSuite.validationReportLog(
											"Total number of columns available after get data are matched i.e. total="
													+ total + " are displayed in target.");
								} else {
									BaseSuite.reportFailLog(
											"Unable to match database record received using api and at application , kindly reverify it.",
											"validateConnectionColNDatatype");

								}
							}
						} else {
							BaseSuite.reportErrorLog(
									"After clicking target setting user is not redirected to target setting UI, Kindly check");
						}

					} else {
						BaseSuite.reportErrorLog(
								"In target setting, targetSetting tab button is not displayed, Kindly check");
					}

				} else {
					BaseSuite.reportFailLog("Source table column not retrived from connection selected , kindly check.",
							"validateConnectionColNDatatype");
				}
			} else {
				BaseSuite.reportErrorLog(
						"You have entered invalid setting type in validateConnectionColNDatatype method,kindly revisit.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Method for checksum rule default expression validation using API ***
	public void validateChecksumDefaultExpression(DataTestingParameters param, SoftAssert soft, String jsonEntity,
			String icedqRole, String workspaceId, String sourceQuery, String targetQuery, String ruleType)
			throws Exception, Throwable {
		try {

			String expName = param.getChkCheckName();// $.objects[2].configuration.checks[0].name
			// String expression = param.getChkExpression();//
			// $.objects[2].configuration.checks[0].expression
			String expType = param.getChkCheckType();// $.objects[2].configuration.checks[0].type
			String expStatus = param.getChkStatus();// $.objects[2].configuration.checks[0].isActive
			// verifying added expression
			isDisplayed(driver, chksum_chk_deafultExp);

			Thread.sleep(1000);

			boolean status = isDisplayed(driver, chksum_chk_deafultExp);

			if (status) {

				String cName = getText(driver, checksum_default_expName);

				soft.assertEquals(cName.trim(), expName,
						"Actual expression name :: " + cName + ",didnt matched with expected :: " + expName);

				BaseSuite.validationReportLog("Expression name validated successfully.");

				String actualExp = getText(driver, chksum_chk_deafultExp);

				if (!actualExp.isEmpty()) {
					if (actualExp.equalsIgnoreCase(param.getChkExpression())) {
						soft.assertEquals(actualExp.trim(), param.getChkExpression(),
								"Actual expression didnt matched with expected expression.");

						BaseSuite.validationReportLog("Checksum expression :: " + actualExp
								+ ", matched with expected expression :: " + param.getChkExpression());

					} else {

						clickOnDefaultExpression(actualExp.trim());

						updateAndValidatedAddedDefaultExpression(param, expName, param.getChkExpression(), jsonEntity,
								icedqRole, workspaceId, sourceQuery, targetQuery, ruleType);

					}

					String eStatus = getText(driver, checksum_default_expStatus);

					String exp_status = returnExpressionStatus(param.getChkStatus());

					soft.assertEquals(exp_status.trim(), eStatus.trim(),
							"Actual expression status :: " + eStatus + ",didnt matched with expected :: " + exp_status);

					BaseSuite.validationReportLog("Expression status validated successfully.");
				} else {
					BaseSuite.reportErrorLog(
							"Unable to get text from default expression element as its empty, kindly check.");
				}

			} else {
				BaseSuite.reportErrorLog("Unable to locate auto generated checksum expression, kindly check.");
			}

		} catch (Exception e) {
			throw new AssertionError();
		}
	}

	public void updateAndValidatedAddedDefaultExpression(DataTestingParameters param, String checkName,
			String expression, String jsonEntity, String icedqRole, String workspaceId, String sourceQuery,
			String targetQuery, String ruleType) throws Exception, Throwable {
		try {

			Thread.sleep(2000);

			// verifyVisibilityOfButtons(driver, customExp_updateCheck_btn, "Update", true);

			verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

			clear(driver, check_custCol_textarea);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(checkName);

				// verifyVisibilityOfButtons(driver, customExp_updateCheck_btn, "Update",
				// false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				if (!expression.contains("#")) {

					String[] expVal = expression.split(" ");

					int count = expVal.length;

					for (int colNum = 0; colNum < count; colNum++) {

						String result = expVal[colNum];

						if (result.startsWith("S.[")) {
							WebElement ele;

							displayAndClick(driver, sourceDropdown);

							Actions action = new Actions(driver);

							ele = getElement(driver, sourceDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("S.", "");

							javascript(driver, "arguments[0].scrollIntoView(true);",
									returnElement(customSorceColumnName, "$name", col1));

							displayAndClick(driver, returnElement(customSorceColumnName, "$name", col1));

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("T.[")) {
							WebElement ele;

							displayAndClick(driver, targetDropdown);

							Actions action = new Actions(driver);

							ele = getElement(driver, targetDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("T.", "");

							javascript(driver, "arguments[0].scrollIntoView(true);",
									returnElement(customTargetColumnName, "$name", col1));

							displayAndClick(driver, returnElement(customTargetColumnName, "$name", col1));

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);
						} else if (result.matches("^[a-zA-Z0-9.0]*$")) {
							BaseSuite.reportLog("Entering value on expression box");

							sendKeys(driver, expressionArea, result);

							WebElement ele = getElement(driver, expressionArea);

							ele.sendKeys(Keys.SPACE);

							BaseSuite.validationReportLog("Expression entered successfully");
						} else {

							BaseSuite.reportLog("Clicking on operator button");

							displayAndClick(driver, returnElement(operatorOption, "$name", result));

							BaseSuite.validationReportLog("Operator button clicked successfully");

						}

					}

				} else {

					BaseSuite.reportLog("Entering value on expression box");

					sendKeys(driver, expressionArea, expression);

					BaseSuite.validationReportLog("Expression entered successfully");

				}
				//

				// verifyVisibilityOfButtons(driver, customExp_updateCheck_btn, "Update", true);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				if (expression.startsWith("S.[") || expression.startsWith("T.[")) {
					checkTestFunctionality(param, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

					List<WebElement> ele = getElements(driver, testColCheck);

					if (ele.size() > 0) {
						BaseSuite.validationReportLog(
								"Test functionality with source and target column name is visible after experssion entered on expression box");

						for (int colNum = 0; colNum < ele.size(); colNum++) {
							BaseSuite.validationReportLog(ele.get(colNum).getText());

						}
					} else {
						BaseSuite.reportFailLog(
								"Test functionality with source and target column name is not visible after experssion entered on expression box",
								"Test functionality for custom check");

					}

					List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

					if (ele1.size() > 0) {
						BaseSuite.validationReportLog(
								"Test functionality with source and target column input box is visible after experssion entered on expression box");

						for (int colNum = 0; colNum < ele.size(); colNum++) {
							BaseSuite.validationReportLog(ele.get(colNum).getText());

						}
					} else {
						BaseSuite.reportFailLog(
								"Test functionality with source and target column input box is not visible after experssion entered on expression box",
								"Test functionality for custom check");

					}
				}

				javascript(driver, "arguments[0].scrollIntoView(true);", expressionArea);

				String customeCheck = getAttribute(driver, expressionArea, "value");

				if (customeCheck.trim().equals(expression)) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					// verifyVisibilityOfButtons(driver, customExp_updateCheck_btn, "Update", true);

					verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_UpdateCheck_btn);
					 
					BaseSuite.validationReportLog("Save button clicked successfully");

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered custom check value not match successfully,Kindly check!",
							"addCustomChkExpressionToRule");
				}

			} else {

				BaseSuite.reportFailLog("Custom Check pane is displaye , but without UI content. Kindly check. ",
						"addCustomChkExpressionToRule");
			}

		} catch (java.lang.Exception e) {

			e.getMessage();

		}
	}

	public String returnExpressionStatus(String value) {
		String bvalue = null;
		try {

			if (value.equalsIgnoreCase("true")) {
				bvalue = "Active";
			} else if (value.equalsIgnoreCase("false")) {
				bvalue = "Inactive";
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return bvalue;
	}

	// Search on recent run - Verify search element
	public void enterTextToSearchInRecentRun(String instanceID) throws Exception {
		try {

			isDisplayed(driver, recentRun_SearchInputbox);

			BaseSuite.reportLog("Search textbox is displayed in recent run.");

			clear_Click_SendKeys(driver, 1, recentRun_SearchInputbox, instanceID.trim());

			BaseSuite.validationReportLog("Entered instance id to search in recent run :: " + instanceID + ".");

		} catch (Exception e) {
			BaseSuite.reportLog(e.getMessage());
		}
	}

	// method to print execution details in report.

	public void getExecutionLogDetails() throws Exception, InterruptedException {
		try {
			clickOnExecutionLogButton();

			Thread.sleep(2000);

			isDisplayed(driver, recentrun_ExecutionLog_Summary);

			if (isDisplayed(driver, recentrun_ExecutionLog_Summary)) {
				BaseSuite.reportLog("Execution summary is displayed.");

				String summary = getAttribute(driver, recentrun_ExecutionLog_Summary, "value");

				String[] printSum = summary.split("\n");

				BaseSuite.reportLog(
						"---------------------------------------Execution Logs---------------------------------------");

				for (int i = 0; i < printSum.length; i++) {

					BaseSuite.reportLog(printSum[i]);

				}
				BaseSuite.reportLog(
						"---------------------------------------Execution Logs end here---------------------------------------");
				clickOnCancelBtnOfExecutionLog();

			} else {

				BaseSuite.reportFailLog("Not able to view the execution log datails,Kindly check",
						"printExecutionLogDetails");
			}

		} catch (Exception e) {

			BaseSuite.reportLog(e.getMessage());
		}
	}

	// Method to check occurance of connection type in execution log public
	static int returnIndexIncaseOfSameConnType(String text, String str, String connType) {
		if (isStrEmpty(text) || isStrEmpty(str)) {
			return 0;
		}

		int index = 0, count = 0;

		while (true) {

			if (connType.equalsIgnoreCase("source")) {
				index = text.indexOf(str);
				return index;

			} else if (connType.equalsIgnoreCase("target")) {
				index = text.indexOf(str, index);
				if (index != -1) {
					count++;
					index += str.length();
					if (count == 2) {
						return index;
					}
				} else {
					break;
				}
			}

		}

		return index;
	}

	// method to add new check for pattern check
	public void addPatternCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		try {
			String chkExpression = setExpressionValue(p);

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(patternCheck, "Pattern");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				choosePattern(p.getChkPatternType(), soft);

				if (p.getChkPatternType().equalsIgnoreCase("custom")) {

					selectRegexForCustomPattern(p.getChkDateRegex(), soft);
				}

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				selectCaseInsensitive(p.getCaseSensitive());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}

				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered Pattern check value not match successfully,Kindly check!",
							"addPatternCheck");
				}

			} else {

				BaseSuite.reportFailLog("Pattern Check pane is displaye , but without UI content. Kindly check. ",
						"addPatternCheck");

			}

		} catch (java.lang.Exception e) {

			throw new Exception("");
		}
	}

	// method to update check for pattern check
	public void updatePatternCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		try {
			boolean updateAddFlag = false;

			String chkExpression = setExpressionValue(p);

			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddFlag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(patternCheck, "Pattern");
			} else {
				updateAddFlag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddFlag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				choosePattern(p.getChkPatternType(), soft);

				if (p.getChkPatternType().equalsIgnoreCase("custom")) {

					selectRegexForCustomPattern(p.getChkDateRegex(), soft);
				}

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				selectCaseInsensitive(p.getCaseSensitive());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}

				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				// javascript(driver, "arguments[0].scrollIntoView(true);", expressionArea);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddFlag) {

						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");

					} else {

						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered Pattern check value not match successfully,Kindly check!",
							"addPatternCheck");
				}

			} else {

				BaseSuite.reportFailLog("Pattern Check pane is displaye , but without UI content. Kindly check. ",
						"addPatternCheck");

			}

		} catch (java.lang.Exception e) {

			throw new Exception("");
		}
	}

	/*
	 * // method to validate exception report tab expression public void
	 * validateExpressionDetailsOnExceptionReportTab(String filename, String
	 * sheetname, String columnname, SoftAssert soft) throws Exception { try { int
	 * row1; String status; String[] ct = columnname.split(","); int count =
	 * getcount(columnname, ','); BaseSuite.
	 * reportLog("Verifying Added check expression on Exception report tab");
	 * 
	 * for (int i = 0; i <= count; i++) { if (!ct[i].isEmpty()) { row1 =
	 * findRow(filename, sheetname, ct[i]);
	 * 
	 * DataTestingParameters p = setChecksParametersUsingExcel(filename, sheetname,
	 * row1); String checkName = p.getChkCheckName(); BaseSuite.reportLog(
	 * "============   Validating expression  : " + checkName +
	 * "   =================="); javascript(driver,
	 * "arguments[0].scrollIntoView(true);",
	 * returnElement(expressionReportCheckName, "$name", checkName));
	 * isDisplayedInLoop(driver, 5, returnElement(expressionReportCheckName,
	 * "$name", checkName)); List<WebElement> rowdata = getElements(driver,
	 * returnElement(exceptionReportCheckDetails, "$name", checkName));
	 * 
	 * String chkname = rowdata.get(0).getAttribute("textContent"); String chkExp =
	 * rowdata.get(1).getAttribute("textContent"); String chktype =
	 * rowdata.get(2).getAttribute("textContent"); String chkstatus =
	 * rowdata.get(3).getAttribute("textContent"); String chkShow =
	 * rowdata.get(4).getAttribute("textContent");
	 * 
	 * if (!chkname.isEmpty()) {
	 * BaseSuite.reportLog("Validating Expression Name...");
	 * BaseSuite.reportLog("Retrived Expression Name : " + chkname);
	 * BaseSuite.reportLog("Expected Expression Name : " + p.getChkCheckName());
	 * 
	 * soft.assertEquals(chkname.trim(), p.getChkCheckName().trim(), "test20");
	 * 
	 * if (chkname.trim().equalsIgnoreCase(p.getChkCheckName().trim())) {
	 * BaseSuite.validationReportLog("Expression name are matched successfully"); }
	 * else { BaseSuite.reportFailLog("Expression name doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } else {
	 * BaseSuite.reportFailLog("Expression name not found kindly check",
	 * "validateExpressionDetailsOnExceptionReportTab"); }
	 * 
	 * if (!chkExp.isEmpty()) { BaseSuite.reportLog("Validating Expression...");
	 * BaseSuite.reportLog("Retrived Expression  : " + chkExp);
	 * BaseSuite.reportLog("Expected Expression  : " + p.getChkExpression());
	 * 
	 * soft.assertEquals(chkExp.trim(), p.getChkExpression().trim(), "test21");
	 * 
	 * if (chkExp.trim().equalsIgnoreCase(p.getChkExpression().trim())) {
	 * BaseSuite.validationReportLog("Expression matched successfully"); } else {
	 * BaseSuite.reportFailLog("Expression doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } else {
	 * BaseSuite.reportFailLog("Expression not found kindly check",
	 * "validateExpressionDetailsOnExceptionReportTab"); }
	 * 
	 * if (!chktype.isEmpty()) { if
	 * (!p.getChkCheckType().equalsIgnoreCase("custom")) {
	 * BaseSuite.reportLog("Validating Expression Type...");
	 * BaseSuite.reportLog("Retrived Expression Type : " + chktype);
	 * BaseSuite.reportLog("Expected Expression Type : " + p.getChkCheckType());
	 * 
	 * soft.assertEquals(chktype.trim(), p.getChkCheckType().trim(), "test22");
	 * 
	 * if (chktype.trim().equalsIgnoreCase(p.getChkCheckType().trim())) {
	 * 
	 * BaseSuite.validationReportLog("Expression Type matched successfully"); } else
	 * { BaseSuite.reportFailLog("Expression Type doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } else {
	 * BaseSuite.reportLog("Validating Expression Type...");
	 * BaseSuite.reportLog("Retrived Expression Type : " + chktype);
	 * BaseSuite.reportLog("Expected Expression Type : Custom");
	 * 
	 * soft.assertEquals(chktype.trim(), "Custom", "test21");
	 * 
	 * if (chktype.trim().equalsIgnoreCase("Custom")) {
	 * BaseSuite.validationReportLog("Expression Type matched successfully"); } else
	 * { BaseSuite.reportFailLog("Expression Type doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } } else {
	 * BaseSuite.reportFailLog("Expression Type not found kindly check",
	 * "validateExpressionDetailsOnExceptionReportTab"); }
	 * 
	 * if (!chkstatus.isEmpty()) {
	 * 
	 * if (chkstatus.trim().equalsIgnoreCase("Active")) { status = "true"; } else {
	 * status = "false"; } BaseSuite.reportLog("Validating Expression Status...");
	 * BaseSuite.reportLog("Retrived Expression Status : " + status);
	 * BaseSuite.reportLog("Expected Expression Status : " +
	 * p.getChkStatus().toLowerCase());
	 * 
	 * soft.assertEquals(status.trim(), p.getChkStatus().toLowerCase().trim(),
	 * "test23");
	 * 
	 * if (status.trim().equalsIgnoreCase(p.getChkStatus().trim())) {
	 * BaseSuite.validationReportLog("Expression Status matched successfully"); }
	 * else { BaseSuite.reportFailLog("Expression Status doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); }
	 * 
	 * if (status.equalsIgnoreCase("true")) {
	 * 
	 * if (!chkShow.isEmpty()) {
	 * 
	 * String showstate = getAttribute(driver,
	 * returnElement(exceptionReporExpShowCheckbox, "$name",
	 * p.getChkCheckName().trim()), "aria-checked");
	 * BaseSuite.reportLog("Validating Expression Visible checkbox...");
	 * BaseSuite.reportLog("Retrived Expression visible checkbox : " + showstate);
	 * BaseSuite.reportLog("Expected Expression visible checkbox : " + status);
	 * 
	 * soft.assertEquals(showstate.trim(), status, "test24"); if
	 * (showstate.trim().equalsIgnoreCase(status.trim())) {
	 * BaseSuite.validationReportLog(
	 * "Expression visible checkbox matched successfully"); } else {
	 * BaseSuite.reportFailLog("Expression visible checkbox doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } } else { String
	 * showstate = getAttribute(driver, returnElement(exceptionReporExpShowCheckbox,
	 * "$name", p.getChkCheckName().trim()), "aria-checked");
	 * BaseSuite.reportLog("Validating Expression Visible checkbox...");
	 * BaseSuite.reportLog("Retrived Expression visible checkbox : " + showstate);
	 * BaseSuite.reportLog("Expected Expression visible checkbox : " + status);
	 * 
	 * soft.assertEquals(showstate.trim(), status, "test24.1"); if
	 * (showstate.trim().equalsIgnoreCase(status.trim())) {
	 * BaseSuite.validationReportLog(
	 * "Expression visible checkbox matched successfully"); } else {
	 * BaseSuite.reportFailLog("Expression visible checkbox doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } } else {
	 * BaseSuite.reportFailLog("Expression Status not found kindly check",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } }
	 * 
	 * } catch (java.lang.Exception e) {
	 * 
	 * throw new Exception(""); } }
	 */

	// method to add DataTypeCheck from new check of out of box expression
	public void addDatatypeCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		try {
			String chkExpression = setExpressionValue(p);

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(datatTypeCheck, "Datatype");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				chooseDatatype(p.getChkDataType());

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {

						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}

				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			} else {

				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");

			}

		} catch (java.lang.Exception e) {

			throw new Exception("");
		}
	}

	// method to add DataTypeCheck from new check of out of box expression
	public void updateDatatypeCheck(DataTestingParameters p, String ruleType, String jsonEntity, int checkNumber,
			SoftAssert soft, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		try {
			boolean updateAddFlag = false;

			String chkExpression = setExpressionValue(p);

			searchCheckName(p.getChkCheckName());

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				updateAddFlag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(datatTypeCheck, "Datatype");
			} else {
				updateAddFlag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", p.getChkCheckName()));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				enterCheckName(p.getChkCheckName());

				selectCheckEnableStatus(p.getChkStatus());

				if (updateAddFlag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {

					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				chooseAttributeColumn(p.getChkColumnname(), soft);

				chooseDatatype(p.getChkDataType());

				selectTrimDataCheckbox(p.getChkTrimData());

				selectIgnoreNullsCheckbox(p.getChkIgnoreNulls());

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(p, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {

						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {

					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getAttribute("placeholder"));

					}

				} else {

					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				String expression = getCheckInfoDetails();

				boolean flag = checkExpression(expression, chkExpression, soft);

				if (flag) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (updateAddFlag) {
						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");

					} else {
						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(p.getChkCheckName());

				} else {

					BaseSuite.reportFailLog(
							"Actual and entered completeness check value not match successfully,Kindly check!",
							"addCompletenessCheck");
				}
			} else {

				BaseSuite.reportFailLog("Completeness Check pane is displaye , but without UI content. Kindly check. ",
						"addCompletenessCheck");

			}

		} catch (java.lang.Exception e) {

			throw new Exception("");
		}
	}

	/*
	 * * if (status.trim().equalsIgnoreCase(p.getChkStatus().trim())) {
	 * BaseSuite.validationReportLog("Expression Status matched successfully"); }
	 * else { BaseSuite.reportFailLog("Expression Status doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); }
	 * 
	 * if (status.equalsIgnoreCase("true")) {
	 * 
	 * if (!chkShow.isEmpty()) {
	 * 
	 * String showstate = getAttribute(driver,
	 * returnElement(exceptionReporExpShowCheckbox, "$name",
	 * p.getChkCheckName().trim()), "aria-checked");
	 * BaseSuite.reportLog("Validating Expression Visible checkbox...");
	 * BaseSuite.reportLog("Retrived Expression visible checkbox : " + showstate);
	 * BaseSuite.reportLog("Expected Expression visible checkbox : " + status);
	 * 
	 * soft.assertEquals(showstate.trim(), status, "test24"); if
	 * (showstate.trim().equalsIgnoreCase(status.trim())) {
	 * BaseSuite.validationReportLog(
	 * "Expression visible checkbox matched successfully"); } else {
	 * BaseSuite.reportFailLog("Expression visible checkbox doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } } else { String
	 * showstate = getAttribute(driver, returnElement(exceptionReporExpShowCheckbox,
	 * "$name", p.getChkCheckName().trim()), "aria-checked");
	 * BaseSuite.reportLog("Validating Expression Visible checkbox...");
	 * BaseSuite.reportLog("Retrived Expression visible checkbox : " + showstate);
	 * BaseSuite.reportLog("Expected Expression visible checkbox : " + status);
	 * 
	 * soft.assertEquals(showstate.trim(), status, "test24.1"); if
	 * (showstate.trim().equalsIgnoreCase(status.trim())) {
	 * BaseSuite.validationReportLog(
	 * "Expression visible checkbox matched successfully"); } else {
	 * BaseSuite.reportFailLog("Expression visible checkbox doesn't matched",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } } else {
	 * BaseSuite.reportFailLog("Expression Status not found kindly check",
	 * "validateExpressionDetailsOnExceptionReportTab"); } } }
	 * 
	 * } catch (java.lang.Exception e) {
	 * 
	 * throw new Exception(""); } }
	 */

	// Click on check node
	public void clickOnCheckNode() {
		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", check_Node_click);
			isDisplayed(driver, check_Node_click);
			BaseSuite.reportLog("Check node button is displayed.");
			displayAndClick(driver, check_Node_click);
			BaseSuite.validationReportLog("Successfully clicked on check button.");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void chooseCheck(By locator, String label) {
		try {

			isDisplayed(driver, locator);

			BaseSuite.reportLog(label + " check button/menu option is displayed.");

			boolean falg = isClickable(driver, locator, "New Custom Check ", true);

			if (falg) {
				displayAndClick(driver, locator);

				BaseSuite.validationReportLog(label + " check button/menu option is clicked successfully.");
			} else {
				BaseSuite.reportFailLog(label + " Check button is not clickable,Kindly check", "chooseCheck");
			}

		} catch (Exception e) {

			throw new AssertionError("Facing issue while clicking on Choose check option");
		}
	}

	// method to click on New Check button from list of options.
	public void clickOnNewCustomCheckMenuOption() {
		try {

			isDisplayed(driver, check_add_NewCustCheckbutton);

			BaseSuite.reportLog("New custom check button/menu option is displayed.");

			isClickable(driver, check_add_NewCustCheckbutton, "New Custom Check ", true);

			displayAndClick(driver, check_add_NewCustCheckbutton);

			BaseSuite.validationReportLog("New custom check button/menu option is clicked successfully.");

		} catch (Exception e) {

			throw new AssertionError("Facing issue while clicking on Custome check option");
		}
	}

	public String getColumnNameValueForTest(String icedqRole, String workspaceId, String connectionId, String query,
			String colName) {
		String baseUrl;

		String colNameValue = null;

		try {
			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				baseUrl = readconfig.ruleListApiUrlCloudInstance();
			} else {
				baseUrl = "http://qa.onprem.icedq.com/api/v1/data?Connection-Id=" + connectionId;
			}

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType,
					"{\r\n    \"source\": \"SQL\",\r\n    " + "\"connectionId\": \"" + connectionId + "\",\r\n    "
							+ "\"properties\": {\r\n        \"sql\": \"" + query + "\"\r\n    " + "}\r\n  \r\n}");
			Request request = new Request.Builder()

					.url(baseUrl)

					.method("POST", body).addHeader("workspace-id", workspaceId)

					.addHeader("Content-Type", "application/json")

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto).build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			colNameValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonBody, "$.data[0]." + colName);

		} catch (IOException e) {

			e.getMessage();
		}
		return colNameValue;
	}

	public String getParameterJson(String parameterId, String workspaceId, String icedqRole) {
		String baseUrl;

		String jsonEntity = null;

		try {
			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			baseUrl = System.getProperty("testDataApiUrl");

			baseUrl = baseUrl.replace("https://", "");

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet("http://" + baseUrl + "/api/v1/parameters/" + parameterId);

			getRequest.setHeader("Authorization", "Bearer " + auto);

			getRequest.setHeader("workspace-id", workspaceId);

			getRequest.setHeader("Content-Type", "application/json");

			HttpResponse response;

			response = httpClient.execute(getRequest);

			org.apache.http.HttpEntity entity = response.getEntity();

			jsonEntity = EntityUtils.toString(entity);

		} catch (IOException e) {

			e.getMessage();
		}
		return jsonEntity;
	}

	public String getParameterValue(String parameterId, String workspaceId, String icedqRole, int count) {
		String baseUrl;

		String value = null;

		try {
			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			baseUrl = System.getProperty("testDataApiUrl");

			baseUrl = baseUrl.replace("https://", "");

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet("http://" + baseUrl + "/api/v1/parameters/" + parameterId);

			getRequest.setHeader("Authorization", "Bearer " + auto);

			getRequest.setHeader("workspace-id", workspaceId);

			getRequest.setHeader("Content-Type", "application/json");

			HttpResponse response;

			response = httpClient.execute(getRequest);

			org.apache.http.HttpEntity entity = response.getEntity();

			String string1 = null;

			string1 = EntityUtils.toString(entity);

			value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(string1,
					"$.info.parameters[" + count + "].value");

		} catch (IOException e) {

			e.getMessage();
		}
		return value;
	}

	public void checkTestFunctionality(DataTestingParameters param, String jsonEntity, String icedqRole,
			String workspaceId, String sourceQuery, String targetQuery) {
		/*
		 * try { String connId;
		 * 
		 * String nameCol;
		 * 
		 * String query = null;
		 * 
		 * String key = null;
		 * 
		 * String value = null;
		 * 
		 * String paraId =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
		 * "$.properties.parameterId");
		 * 
		 * String paraJson = getParameterJson(paraId, workspaceId, icedqRole);
		 * 
		 * List<WebElement> ele = getElements(driver, testColCheck);
		 * 
		 * if (ele.size() > 0) { for (int colNum = 0; colNum < ele.size(); colNum++) {
		 * int position = colNum + 1;
		 * 
		 * String name = ele.get(colNum).getText();
		 * 
		 * if (name.contains("S.[")) { nameCol = name.replaceAll("S.\\[|\\]", "");
		 * 
		 * if (param.getSourceInput().equalsIgnoreCase("Table")) {
		 * 
		 * sourceQuery =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
		 * "$.objects[0].configuration.sql");
		 * 
		 * if (sourceQuery.contains("#")) { ArrayList<String> keyList =
		 * TestDataThroughApi .getJsonArrayValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters..key");
		 * 
		 * for (int i = 0; i < keyList.size(); i++) { key =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].key");
		 * 
		 * key = "#" + key + "#";
		 * 
		 * if (key.equalsIgnoreCase(sourceQuery)) { value =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].value"); }
		 * 
		 * }
		 * 
		 * query = sourceQuery.replace("#" + key + "#", value); } else { query =
		 * sourceQuery;
		 * 
		 * }
		 * 
		 * } else {
		 * 
		 * if (sourceQuery.contains("#")) { ArrayList<String> keyList =
		 * TestDataThroughApi .getJsonArrayValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters..key");
		 * 
		 * for (int i = 0; i < keyList.size(); i++) { key =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].key");
		 * 
		 * key = "#" + key + "#";
		 * 
		 * // key = "#"+key.toUpperCase()+"#";
		 * 
		 * value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].value");
		 * 
		 * sourceQuery = sourceQuery.replaceAll("(?i)" + key, value);
		 * 
		 * query = sourceQuery; }
		 * 
		 * } else { query = sourceQuery;
		 * 
		 * } }
		 * 
		 * connId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
		 * "$.objects[0].connectionId"); } else { nameCol = name.replaceAll("T.\\[|\\]",
		 * "");
		 * 
		 * if (param.getTargetInput().equalsIgnoreCase("Table")) { targetQuery =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
		 * "$.objects[0].configuration.sql");
		 * 
		 * if (targetQuery.contains("#")) { ArrayList<String> keyList =
		 * TestDataThroughApi .getJsonArrayValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters..key");
		 * 
		 * for (int i = 0; i < keyList.size(); i++) { key =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].key");
		 * 
		 * key = "#" + key.toLowerCase() + "#";
		 * 
		 * key = "#" + key.toUpperCase() + "#";
		 * 
		 * value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].value");
		 * 
		 * sourceQuery = sourceQuery.replaceAll(key, value);
		 * 
		 * query = sourceQuery; }
		 * 
		 * } else { query = targetQuery;
		 * 
		 * }
		 * 
		 * } else {
		 * 
		 * if (targetQuery.contains("#")) { ArrayList<String> keyList =
		 * TestDataThroughApi .getJsonArrayValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters..key");
		 * 
		 * for (int i = 0; i < keyList.size(); i++) { key =
		 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].key");
		 * 
		 * key = "#" + key.toLowerCase() + "#";
		 * 
		 * key = "#" + key.toUpperCase() + "#";
		 * 
		 * value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(paraJson,
		 * "$.info.parameters[" + i + "].value");
		 * 
		 * sourceQuery = sourceQuery.replaceAll(key, value);
		 * 
		 * query = sourceQuery; } } else { query = targetQuery;
		 * 
		 * } }
		 * 
		 * connId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
		 * "$.objects[1].connectionId"); }
		 * 
		 * String val = getColumnNameValueForTest(icedqRole, workspaceId, connId, query,
		 * nameCol);
		 * 
		 * WebElement colEle = getElement(driver,
		 * By.xpath("(//table[@class='mytable pad-table']//tr//td[2]//input)["+position+
		 * "]"));
		 * 
		 * colEle.clear();
		 * 
		 * colEle.sendKeys(val);
		 * 
		 * } displayAndClick(driver, testExecuteButton);
		 * 
		 * TestDataThroughApi data = new TestDataThroughApi(driver);
		 * 
		 * data.getTestOutputForChecks(String.valueOf(true)); } else {
		 * BaseSuite.reportFailLog(
		 * "Test functionality with source and target column name is not visible after experssion entered on expression box"
		 * , "Test functionality for custom check");
		 * 
		 * } } catch (java.lang.Exception e) {
		 * 
		 * e.getMessage(); }
		 * 
		 */}

	public void dataQualityDimension(String ruleType, String jsonEntity, int checkNumber) {
		try {

			int obj;
			if (ruleType.equalsIgnoreCase("Recon")) {
				obj = 3;
			} else {
				obj = 1;
			}
			// BaseSuite.reportLog("Selecting data quality dimension value");

			ArrayList<String> fieldName = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[" + obj + "].configuration.checks[" + checkNumber + "].customFields..field");

			for (int i = 0; i < fieldName.size(); i++) {

				if (fieldName.get(i).equals("Data Quality Dimension")) {

					ArrayList<String> deminsion = TestDataThroughApi
							.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.objects[" + obj
									+ "].configuration.checks[" + checkNumber + "].customFields[" + i + "].values");

					int count = deminsion.size();

					if (!deminsion.isEmpty()) {
						for (int j = 0; j < deminsion.size(); j++) {

							String val = deminsion.get(j).replaceAll("\\[|\\]", "");

							if (!val.isBlank()) {
								String value = getAttribute(driver, dataQualityDimensionBox, "data-initial-value");

								String[] resultType = value.trim().split(",");

								int co1 = resultType.length;

								String result = resultType[j];

								if (!result.equalsIgnoreCase(val)) {
									javascript(driver, "arguments[0].scrollIntoView(true);", dataQualityDimensionBox);

									displayAndClick(driver, dataQualityDimensionBox);

									displayAndClick(driver, returnElement(dataQualityDimensionValue, "$name", val));

									Thread.sleep(2000);
								}

							}

						}
					}
				}
			}

			BaseSuite.validationReportLog("Data quality dimension value selected successfully");

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	// method to add New custom check expression of user choice.Final for API

	public void addCustomCheckExpression(DataTestingParameters param, String ruleType, String jsonEntity,
			int checkNumber, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			String checkName, checkStatus, checkType, dimension, customExpression;

			checkName = param.getChkCheckName();

			checkStatus = param.getChkStatus();

			customExpression = param.getChkExpression();

			// Thread.sleep(1000);

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(check_add_NewCustCheckbutton, "Custom");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				dp.enterCheckName(checkName);

				dp.selectCheckEnableStatus(checkStatus);

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				// addAndValidatedAddedExpression(checkName, customExpression.trim(), chkStatus,
				// soft);
				// String val =
				// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// customExpression);

				if (!(customExpression.contains("#") || customExpression.contains("\\")
						|| customExpression.contains("IN") || customExpression.contains("in")
						|| customExpression.contains("startsWith") || customExpression.contains("endsWith")
						|| customExpression.contains("()") || customExpression.contains("?"))) {

					String[] expVal = customExpression.split(" ");

					int count = expVal.length;

					for (int colNum = 0; colNum < count; colNum++) {

						String result = expVal[colNum];

						if (result.startsWith("S.[")) {
							WebElement ele;

							displayAndClick(driver, sourceDropdown);

							Thread.sleep(2000);

							Actions action = new Actions(driver);

							ele = getElement(driver, sourceDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("S.", "");

							boolean uppercaseCol = isDisplayed(driver,
									returnElement(customSorceColumnName, "$name", col1.toUpperCase()));

							boolean lowercaseCol = isDisplayed(driver,
									returnElement(customSorceColumnName, "$name", col1.toLowerCase()));

							boolean camelcaseCol = isDisplayed(driver,
									returnElement(customSorceColumnName, "$name", col1));

							if (uppercaseCol) {
								selectCheckColumnFromList(customSorceColumnName, col1.toUpperCase());
							} else if (lowercaseCol) {
								selectCheckColumnFromList(customSorceColumnName, col1.toLowerCase());
							} else if (camelcaseCol) {
								selectCheckColumnFromList(customSorceColumnName, col1);
							} else {

								selectCheckColumnFromList(customSorceColumnNameTranslate, col1.toLowerCase());
							}

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("T.[")) {
							WebElement ele;

							displayAndClick(driver, targetDropdown);

							Thread.sleep(2000);

							Actions action = new Actions(driver);

							ele = getElement(driver, targetDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("T.", "");

							boolean uppercaseCol = isDisplayed(driver,
									returnElement(customTargetColumnName, "$name", col1.toUpperCase()));

							boolean lowercaseCol = isDisplayed(driver,
									returnElement(customTargetColumnName, "$name", col1.toLowerCase()));

							boolean camelcaseCol = isDisplayed(driver,
									returnElement(customTargetColumnName, "$name", col1));

							if (uppercaseCol) {
								selectCheckColumnFromList(customTargetColumnName, col1.toUpperCase());
							} else if (lowercaseCol) {
								selectCheckColumnFromList(customTargetColumnName, col1.toLowerCase());
							} else if (camelcaseCol) {
								selectCheckColumnFromList(customTargetColumnName, col1);
							} else {

								selectCheckColumnFromList(customTargetColumnNameTranslate, col1.toLowerCase());
							}

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("fn_")) {

							WebElement ele;

							displayAndClick(driver, functionDropdown);

							Thread.sleep(2000);

							Actions action = new Actions(driver);

							ele = getElement(driver, functionDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							sendKeys(driver, expressionArea, customExpression);

							Thread.sleep(2000);
						} else if (result.matches("[A-Za-z0-9-']+")) {

							BaseSuite.reportLog("Entering value on expression box");

							sendKeys(driver, expressionArea, result);

							getElement(driver, expressionArea).sendKeys(Keys.SPACE);

							BaseSuite.validationReportLog("Expression entered successfully");

						} else {

							BaseSuite.reportLog("Clicking on operator button");

							displayAndClick(driver, returnElement(operatorOption, "$name", result));

							BaseSuite.validationReportLog("Operator button clicked successfully");

						}

					}
				} else {
					BaseSuite.reportLog("Entering value on expression box");

					if (customExpression.contains("\\")) {
						boolean isRegex;

						try {
							java.util.regex.Pattern.compile(customExpression);

							isRegex = true;

						} catch (PatternSyntaxException e) {

							isRegex = false;
						}
						if (isRegex) {
							customExpression = customExpression.replace("\\\\", "\\");
						} else {
							customExpression = customExpression.replace("\\", "\"");
						}

					}
					sendKeys(driver, expressionArea, customExpression);

					BaseSuite.validationReportLog("Expression entered successfully");

				}
				//

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(param, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				javascript(driver, "arguments[0].scrollIntoView(true);", expressionArea);

				String customeCheck = getAttribute(driver, expressionArea, "value").trim();

				if (customeCheck.trim().equalsIgnoreCase(customExpression)) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(checkName);

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered custom check value not match successfully,Kindly check!",
							"addCustomChkExpressionToRule");
				}

			} else {

				BaseSuite.reportFailLog("Custom Check pane is displaye , but without UI content. Kindly check. ",
						"addCustomChkExpressionToRule");
			}

		} catch (java.lang.Exception e) {

			e.getMessage();

		}
	}

	public void updateCustomCheckExpression(DataTestingParameters param, String ruleType, String jsonEntity,
			int checkNumber, String icedqRole, String workspaceId, String sourceQuery, String targetQuery)
			throws Exception {

		DataTestingPage dp = new DataTestingPage(driver);

		try {
			boolean flag = false;
			String checkName, checkStatus, checkType, dimension, customExpression;

			checkName = param.getChkCheckName();

			checkStatus = param.getChkStatus();

			customExpression = param.getChkExpression();

			searchCheckName(checkName);

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				flag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(check_add_NewCustCheckbutton, "Custom");

			} else {
				flag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", checkName));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				dp.enterCheckName(checkName);

				dp.selectCheckEnableStatus(checkStatus);

				if (flag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);
				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				clear(driver, expressionArea);

				if (!(customExpression.contains("#") || customExpression.contains("\\")
						|| customExpression.contains("IN") || customExpression.contains("in")
						|| customExpression.contains("startsWith") || customExpression.contains("endsWith")
						|| customExpression.contains("()") || customExpression.contains("?"))) {

					String[] expVal = customExpression.split(" ");

					int count = expVal.length;

					for (int colNum = 0; colNum < count; colNum++) {

						String result = expVal[colNum];

						if (result.startsWith("S.[")) {
							WebElement ele;

							displayAndClick(driver, sourceDropdown);

							Thread.sleep(2000);

							Actions action = new Actions(driver);

							ele = getElement(driver, sourceDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("S.", "");

							javascript(driver, "arguments[0].scrollIntoView(true);",
									returnElement(customSorceColumnName, "$name", col1));

							displayAndClick(driver, returnElement(customSorceColumnName, "$name", col1));

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("T.[")) {
							WebElement ele;

							displayAndClick(driver, targetDropdown);

							Thread.sleep(2000);

							Actions action = new Actions(driver);

							ele = getElement(driver, targetDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("T.", "");

							javascript(driver, "arguments[0].scrollIntoView(true);",
									returnElement(customTargetColumnName, "$name", col1));

							displayAndClick(driver, returnElement(customTargetColumnName, "$name", col1));

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("fn_")) {

							WebElement ele;

							displayAndClick(driver, functionDropdown);

							Thread.sleep(2000);

							Actions action = new Actions(driver);

							ele = getElement(driver, functionDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							sendKeys(driver, expressionArea, customExpression);

							Thread.sleep(2000);
						} else if (result.matches("[A-Za-z0-9-']+")) {

							BaseSuite.reportLog("Entering value on expression box");

							sendKeys(driver, expressionArea, result);

							getElement(driver, expressionArea).sendKeys(Keys.SPACE);

							BaseSuite.validationReportLog("Expression entered successfully");

						} else {

							BaseSuite.reportLog("Clicking on operator button");

							displayAndClick(driver, returnElement(operatorOption, "$name", result));

							BaseSuite.validationReportLog("Operator button clicked successfully");

						}

					}
				} else {
					BaseSuite.reportLog("Entering value on expression box");

					if (customExpression.contains("\\")) {
						boolean isRegex;

						try {
							java.util.regex.Pattern.compile(customExpression);

							isRegex = true;

						} catch (PatternSyntaxException e) {

							isRegex = false;
						}
						if (isRegex) {
							customExpression = customExpression.replace("\\\\", "\\");
						} else {
							customExpression = customExpression.replace("\\", "\"");
						}

					}
					sendKeys(driver, expressionArea, customExpression);

					BaseSuite.validationReportLog("Expression entered successfully");

				}
				//

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(param, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				javascript(driver, "arguments[0].scrollIntoView(true);", expressionArea);

				String customeCheck = getAttribute(driver, expressionArea, "value");

				if (customeCheck.trim().equalsIgnoreCase(customExpression)) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (flag) {
						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");
					} else {
						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(checkName);

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered custom check value not match successfully,Kindly check!",
							"addCustomChkExpressionToRule");
				}

			} else {

				BaseSuite.reportFailLog("Custom Check pane is displaye , but without UI content. Kindly check. ",
						"addCustomChkExpressionToRule");
			}

		} catch (java.lang.Exception e) {

			e.getMessage();

		}
	}

	public void verifyAddCustomExpressiontoRule(String checkName, String expression, String checkStatus,
			SoftAssert soft) throws Exception {
		try {

			if (isDisplayed(driver, returnElement(check_CustCheck_addedExp, "$expression", expression))) {
				BaseSuite.validationReportLog("Successfully added custom expression as :: " + expression);

				// verify custom check expression name

				isDisplayed(driver, returnElement(check_CustCheck_addedExp_checkName, "$expression", expression));

				String chkName = getText(driver,
						returnElement(check_CustCheck_addedExp_checkName, "$expression", expression));

				soft.assertEquals(chkName, checkName, "Actual expression name didnt matched with expected.");

				BaseSuite.validationReportLog(
						"Correctly added check name as: " + chkName + ", for recently added expression: " + expression);

				// removed From UI // verify custom check expression type
				BaseSuite.reportLog("Verifying check type for added expression.");
				String chktype = getText(driver,
						returnElement(check_CustCheck_addedExp_checkType, "$expression", expression));
				// soft.assertEquals(chktype.trim(), checkType,"Actual expression check type
				// didnt matched with expected.");
				BaseSuite.validationReportLog(
						"Correctly added check type as: " + chktype + ", for recently added expression: " + expression);

				// verify custom check expression status

				isDisplayed(driver,
						returnElement(check_CustCheck_addedExp_checkStatus, "$expression", checkName.trim()));

				String chkStatus = getText(driver,
						returnElement(check_CustCheck_addedExp_checkStatus, "$expression", checkName.trim()));

				if (chkStatus.equalsIgnoreCase("active")) {
					chkStatus = "true";
				} else if (chkStatus.equalsIgnoreCase("inactive")) {
					chkStatus = "false";
				}

				soft.assertEquals(chkStatus, checkStatus,
						"For added expression actual status didnt matched with expected.");

				BaseSuite.validationReportLog("Correctly added check status as: " + chkStatus
						+ ", for recently added expression: " + expression);

			} else {

				BaseSuite.reportFailLog("Unabled to add expression :: " + expression + " , Kindly check.",
						"addCustomChkExpressionToRule");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void verifyResutType(String jsonEntity, String ruleType) {
		try {
			ArrayList<String> expList;

			if (ruleType.equalsIgnoreCase("Recon")) {

				expList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks[0].expression..values");
			} else {

				expList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks[0].expression..values");
			}

			int count = expList.size();

			String val;

			WebElement ele;

			String exp;

			for (int i = 0; i < count; i++) {

				if (ruleType.equalsIgnoreCase("Recon")) {

					exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[3].configuration.checks[0].expression.values[" + i + "]");
				} else {

					exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.checks[0].expression.values[" + i + "]");
				}

				switch (exp) {

				case "a-b":

					ele = driver.findElement(buttonAB);

					val = ele.getAttribute("class");

					if (val.contains("active")) {

						BaseSuite.validationReportLog("A-B result type is selected after revisiting the rule");

					} else {

						BaseSuite.reportFailLog("A-B result type is not selected after revisiting the rule",
								"verifyResutType");
					}
					break;

				case "b-a":

					ele = driver.findElement(buttonBA);

					val = ele.getAttribute("class");

					if (val.contains("active")) {

						BaseSuite.validationReportLog("B-A result type is selected after revisiting the rule");

					} else {

						BaseSuite.reportFailLog("B-A result type is not selected after revisiting the rule",
								"verifyResutType");
					}

					break;

				case "anb":

					ele = driver.findElement(buttonAnB);

					val = ele.getAttribute("class");

					if (val.contains("active")) {

						BaseSuite.validationReportLog("AnB result type is selected after revisiting the rule");

					} else {

						BaseSuite.reportFailLog("AnB result type is not selected after revisiting the rule",
								"verifyResutType");

					}

					break;

				case "Xp":

					ele = driver.findElement(buttonExp);

					val = ele.getAttribute("class");

					if (val.contains("active")) {

						BaseSuite.validationReportLog("Expression result type is selected after revisiting the rule");

					} else {

						BaseSuite.reportFailLog("Expression result type is not selected after revisiting the rule",
								"verifyResutType");
					}

					break;

				default:

					ele = driver.findElement(buttonRowCount);

					val = ele.getAttribute("class");

					if (val.contains("active")) {

						BaseSuite.validationReportLog("Row count result type is selected after revisiting the rule");

					} else {

						BaseSuite.reportFailLog("Row count result type is not selected after revisiting the rule",
								"verifyResutType");
					}

					break;
				}

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	/********************* result type related methods ***********************/
	// method to select multipleResult Type.
	public void selectResultType(DataTestingParameters param, String jsonEntity) {
		try {

			BaseSuite.reportLog("Selecting reult type as per user choice");

			String val;

			switch (param.getRuleType().toLowerCase()) {

			case "recon":
			case "ht recon":

				WebElement ele;

				ele = driver.findElement(buttonAB);

				ele.click();

				ele = driver.findElement(buttonBA);

				ele.click();

				ele = driver.findElement(buttonExp);

				ele.click();

				ArrayList<String> expList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks[0].expression..values");

				int count = expList.size();

				for (int i = 0; i < count; i++) {

					String exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[3].configuration.checks[0].expression.values[" + i + "]");

					switch (exp) {

					case "a-b":

						ele = driver.findElement(buttonAB);

						val = ele.getAttribute("class");

						if (val.contains("active")) {

							BaseSuite.validationReportLog("A-B result type is alredy selected");

						} else {
							BaseSuite.reportLog("Clicking on A-B result type");

							ele.click();

							BaseSuite.validationReportLog("A-B result type clicked successfully");
						}
						break;

					case "b-a":

						ele = driver.findElement(buttonBA);

						val = ele.getAttribute("class");

						if (val.contains("active")) {

							BaseSuite.validationReportLog("B-A result type is alredy selected");

						} else {
							BaseSuite.reportLog("Clicking on B-A result type");

							ele.click();

							BaseSuite.validationReportLog("B-A result type clicked successfully");
						}

						break;

					case "anb":

						ele = driver.findElement(buttonAnB);

						val = ele.getAttribute("class");

						if (val.contains("active")) {

							BaseSuite.validationReportLog("AnB result type is alredy selected");

						} else {
							BaseSuite.reportLog("Clicking on AnB result type");

							ele.click();

							BaseSuite.validationReportLog("AnB result type clicked successfully");
						}

						break;

					default:

						ele = driver.findElement(buttonExp);

						val = ele.getAttribute("class");

						if (val.contains("active")) {

							BaseSuite.validationReportLog("Expression result type is alredy selected");

						} else {
							BaseSuite.reportLog("Clicking on Expression result type");

							ele.click();

							BaseSuite.validationReportLog("Expression result type clicked successfully");
						}

						break;
					}
				}

				break;

			case "validation":
			case "ht validation":

				ele = driver.findElement(expressionButton);

				val = ele.getAttribute("class");

				if (val.contains("active")) {

					BaseSuite.validationReportLog(
							"Expression result type is by default selected for Validation/Ht validation rule");

				} else {

					BaseSuite.reportFailLog(
							"Expression result type is by default not selected for Validation/Ht validation rule",
							"selectResultType");

				}

				break;

			case "pushdown":

				ele = driver.findElement(rowCountButton);

				val = ele.getAttribute("class");

				if (val.contains("active")) {

					BaseSuite.validationReportLog("Row count result type is by default selected for Pushbown rule");

				} else {

					BaseSuite.reportFailLog("Row count result type is by default not selected for Pushbown rule",
							"selectResultType");

				}

				break;

			}
		} catch (Exception e) {

			throw new AssertionError("Facing some issue while selecting result type,Kindly check!");
		}

	}

	public void updateSelectResultType(String jsonEntity, String resultType) {
		String val;
		try {
			ArrayList<String> expList;

			if (resultType.equalsIgnoreCase("Recon")) {
				expList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks[0].expression..values");

				List<WebElement> list = driver.findElements(resultTypeList);

				for (int j = 0; j < list.size(); j++) {
					String value = list.get(j).getAttribute("title");

					value = value.toLowerCase().trim();

					WebElement ele = driver.findElement(returnElement(updateResultType, "$name", value));

					val = ele.getAttribute("class");

					if (val.contains("active")) {
						BaseSuite.reportLog("Clicking on " + value + " result type");

						ele.click();

						BaseSuite.validationReportLog(value + " result type clicked successfully");
					}
				}
			} else {
				expList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks[0].expression..values");

			}

			int count = expList.size();

			for (int i = 0; i < count; i++) {
				String exp;

				if (resultType.equalsIgnoreCase("Recon")) {
					exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[3].configuration.checks[0].expression.values[" + i + "]");

					if (exp.equalsIgnoreCase("XP")) {
						exp = "expression";
					}
				} else {
					exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.checks[0].expression.values[" + i + "]");

					if (exp.equalsIgnoreCase("XP")) {
						exp = "expression";
					} else {
						exp = "rowcount";
					}
				}

				WebElement ele = driver.findElement(returnElement(updateResultType, "$name", exp));

				val = ele.getAttribute("class");

				if (val.contains("active")) {

					BaseSuite.validationReportLog(exp + " result type is by default selected");

				} else {

					BaseSuite.reportLog("Clicking on " + exp + " result type");

					ele.click();

					BaseSuite.validationReportLog(exp + " result type clicked successfully");
				}

			}
		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	// method to get default status of result type for each rule type
	// Recon= a-b,b-a,&expression /anb
	// checksum = autogenerate expression
	// validation= xp
	public void checkdefaultstatusOfResultType(DataTestingParameters param) {

		try {
			switch (param.getRuleType().toLowerCase()) {
			case "recon":
			case "ht recon":
				BaseSuite.reportLog("Verifying default status of result type for recon rule.");
				defaultStatusOfResultTypeForReconRule();

				break;
			case "validation":
			case "ht validation":
				BaseSuite.reportLog("Verifying default status of result type for validation rule.");
				defaultStatusOfResultTypeForValidationRule();
				break;

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// method to check by default status of resultType of validation rule
	public void defaultStatusOfResultTypeForReconRule() {
		String rA_B, rB_A, rExp, r_AnB, status;
		try {

			isDisplayed(driver, returnElement(ruleResultType, "$resultType", "a-b"));
			rA_B = getAttribute(driver, returnElement(ruleResultType, "$resultType", "a-b"), "aria-checked");
			isDisplayed(driver, returnElement(ruleResultType, "$resultType", "b-a"));
			rB_A = getAttribute(driver, returnElement(ruleResultType, "$resultType", "b-a"), "aria-checked");
			isDisplayed(driver, returnElement(ruleResultType, "$resultType", "expression"));
			rExp = getAttribute(driver, returnElement(ruleResultType, "$resultType", "expression"), "aria-checked");
			isDisplayed(driver, returnElement(ruleResultType, "$resultType", "anb"));
			r_AnB = getAttribute(driver, returnElement(ruleResultType, "$resultType", "anb"), "aria-checked");
			if ((rA_B.equalsIgnoreCase("true")) & (rB_A.equalsIgnoreCase("true")) & (rExp.equalsIgnoreCase("true"))
					& (r_AnB.equalsIgnoreCase("false"))) {
				BaseSuite.validationReportLog(
						"In Recon rule by default a-b,b-a and expression result type is selected,where as anb is unchecked.");
			} else {
				BaseSuite.reportFailLog(
						"By default in Recon rule a-b,b-a and expression result type should be selected but here is the combination selected as a-b="
								+ rA_B + ",b-a=" + rB_A + ", anb=" + r_AnB + " & Xp=" + rExp + ". So kindly check.",
						"defaultStatusOfResultTypeForReconRule");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to check by default status of resultType of validation rule
	public void defaultStatusOfResultTypeForValidationRule() {
		try {
			String exp = "expression", rowC = "rowcount", status_exp, status_row;
			// returnElement(ruleResultType, "$resultType", exp);
			isDisplayed(driver, returnElement(ruleResultType, "$resultType", exp));
			status_exp = getAttribute(driver, returnElement(ruleResultType, "$resultType", exp), "aria-checked");
			isDisplayed(driver, returnElement(ruleResultType, "$resultType", rowC));
			status_row = getAttribute(driver, returnElement(ruleResultType, "$resultType", rowC), "aria-checked");
			if ((status_exp.equalsIgnoreCase("true")) & (status_row.equalsIgnoreCase("false"))) {
				BaseSuite.validationReportLog(
						"By default Xp i.e expression result type is selected, and row count is unchecked.");
			} else if ((status_exp.equalsIgnoreCase("false")) || (status_row.equalsIgnoreCase("true"))) {
				BaseSuite.reportFailLog("By default Xp i.e expression result type is not selected, kindly check.",
						"checkdefaultstatusOfResultType");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to set result type for recon rule as per user choice.(enter ,
	// seperated value as a-b,b-a,expression,anb)
	public void chooseResultTypeForRecon(DataTestingParameters param) throws Exception {
		String reconResultTypes = "a-b b-a anb expression";
		try {
			String reconStr = param.getResultTypes().trim();

			// ArrayList<String> strResultTypes= param.getResultType();

			String[] resultType = reconStr.split(",");
			// int count = strResultTypes.size(); //resultType.length;
			int count = resultType.length;
			for (int colNum = 0; colNum < count; colNum++) {
				System.out.println(resultType[colNum]);

				String resultT = resultType[colNum].toLowerCase();
				if (reconResultTypes.contains(resultT)) {
					System.out.println("For result Type:: " + resultType[colNum]);
					isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultT));
					BaseSuite.reportLog("For recon rule result type : " + resultT + " is displayed.");
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", resultT));
					String status = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultT),
							"aria-checked");
					BaseSuite.validationReportLog("Result type is clicked successfully so final status is : " + resultT
							+ " is set to :" + status);

				} else {
					BaseSuite.reportErrorLog("Invalid result type is entered as a input , kindly check.");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// method to set result type for recon rule as per user choice.(enter ,
	// seperated value as a-b,b-a,expression,anb)
	public void chooseResultTypeForValidation(DataTestingParameters param) {
		String resultType1 = "expression", resultType2 = "rowcount";
		try {
			// split logic
			String[] resultType = param.getResultTypes().trim().split(",");
			int count = resultType.length;

			for (int colNum = 0; colNum < count; colNum++) {

				String resultT = resultType[colNum].toLowerCase();

				/*
				 * if((!resultTypes.equalsIgnoreCase(resultType1))&((!resultTypes.
				 * equalsIgnoreCase(resultType2)))) { BaseSuite.
				 * reportErrorLog("Invalid result type is entered as a input , kindly check.");
				 * } else {
				 */
				/*
				 * if (resultT.equalsIgnoreCase(resultType1)) {
				 * 
				 * isDisplayedInLoop(driver, 2, returnElement(ruleResultType, "$resultType",
				 * resultT)); BaseSuite.reportLog("For recon rule result type : " + resultT +
				 * " is displayed."); displayAndClick(driver, returnElement(ruleResultType,
				 * "$resultType", resultT)); String status = getAttribute(driver,
				 * returnElement(ruleResultType, "$resultType", resultT), "aria-checked");
				 * BaseSuite.
				 * validationReportLog("Result type is clicked successfully so final status is : "
				 * + resultT + " is set to :" + status); isDisplayedInLoop(driver, 2,
				 * returnElement(ruleResultType, "$resultType", resultType2.trim())); String
				 * statuso = getAttribute(driver, returnElement(ruleResultType, "$resultType",
				 * resultType2.trim()), "aria-checked"); if (statuso.equalsIgnoreCase("false"))
				 * { BaseSuite.validationReportLog("When " + resultType1 +
				 * " result type is selected," + resultType2 + " result type is unchecked"); }
				 * else { // need to ask this implimentation }
				 * 
				 * } else { if (resultT.equalsIgnoreCase(resultType2)) {
				 * isDisplayedInLoop(driver, 2, returnElement(ruleResultType, "$resultType",
				 * resultT)); BaseSuite.reportLog("For recon rule result type : " + resultT +
				 * " is displayed."); displayAndClick(driver, returnElement(ruleResultType,
				 * "$resultType", resultT)); String status = getAttribute(driver,
				 * returnElement(ruleResultType, "$resultType", resultT), "aria-checked");
				 * BaseSuite.
				 * validationReportLog("Result type is clicked successfully so final status is : "
				 * + resultT + " is set to :" + status); isDisplayedInLoop(driver, 2,
				 * returnElement(ruleResultType, "$resultType", resultType1.trim())); String
				 * statuso = getAttribute(driver, returnElement(ruleResultType, "$resultType",
				 * resultType1.trim()), "aria-checked"); if (statuso.equalsIgnoreCase("false"))
				 * { BaseSuite.validationReportLog("When " + resultType2 +
				 * " result type is selected," + resultType1 + " result type is unchecked"); }
				 * else { // need to ask this implimentation } }
				 * 
				 * }
				 */

			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to validated autogenerated expression in checksum rule
	public void defaultStatusOfResultType_autogeneratedExp_ForCheckSumRule() throws Exception {
		try {
			// need to check in execution.
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checksum_checkNode_click);
			Thread.sleep(2500);
			isDisplayed(driver, checksum_checkNode_click);
			displayAndClick(driver, checksum_checkNode_click);
			// get data from source n target to get column name
			isDisplayed(driver, sourceNodeClick);
			displayAndClick(driver, sourceNodeClick);
			dataButton(sourceData);
			Thread.sleep(2000);
			previewData(sourcegetData);
			javascript(driver, "arguments[0].scrollIntoView(true);", chksum_source_colHeader);
			String source_colheader = returnSourceColHeaadeForCheckSum("Source");
			if (!(source_colheader.isEmpty())) {
				source_colheader = "S.[" + source_colheader + "]";
			}
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", targetNodeClick);
			Thread.sleep(1500);
			displayAndClick(driver, targetNodeClick);
			dataButton(targetData);
			Thread.sleep(2000);
			previewData(targetgetdata);
			javascript(driver, "arguments[0].scrollIntoView(true);", chksum_target_colHeader);
			String target_colHeader = returnTargetColHeaadeForCheckSum("Target");
			if (!(target_colHeader.isEmpty())) {
				target_colHeader = "T.[" + target_colHeader + "]";
			}
			// create autogenerated expression
			String finalExp = source_colheader + " - " + target_colHeader + " == 0"; // S.[SOURCEHEADER] -
			// T.[TARGETHEADER] == 0
			BaseSuite.reportLog("Expected expression is :: " + finalExp);
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checksum_checkNode_click);
			Thread.sleep(2000);
			isDisplayed(driver, checksum_checkNode_click);
			displayAndClick(driver, checksum_checkNode_click);
			// will go to check section & verify
			String actualExp = null;
			Thread.sleep(1000);
			isDisplayed(driver, chksum_chk_deafultExp);
			Thread.sleep(1000);
			boolean status = isDisplayed(driver, chksum_chk_deafultExp);
			if (status) {
				actualExp = getAttribute(driver, chksum_chk_deafultExp, "title");
				System.out.println("expression created : " + actualExp);
				if (finalExp.trim().equalsIgnoreCase(actualExp.trim())) {
					BaseSuite.validationReportLog(
							"For checksum rule correct expression is generated as :: " + actualExp);
				} else {
					BaseSuite.reportFailLog(
							"For checksum rule expected expression : " + finalExp.trim()
									+ " didn't matched with actual expression : " + actualExp,
							"defaultStatusOfResultType_autogeneratedExp_ForCheckSumRule");
				}
			}
		} catch (java.lang.Exception e) {
			throw new Exception("");
		}
	}

	public String returnSourceColHeaadeForCheckSum(String connT) {
		String colHeader = null;
		try {
			Thread.sleep(2000);
			isDisplayed(driver, chksum_source_colHeader);
			BaseSuite.reportLog(connT + " column header element is displayed.");
			colHeader = getText(driver, chksum_source_colHeader); // getAttribute(driver,
																	// chksum_source_colHeader,
			// "inner HTML");

			if (colHeader.trim().isEmpty()) {
				BaseSuite.reportErrorLog("Unable to get " + connT + " column header after get data.");

			} else {
				BaseSuite.validationReportLog("In " + connT + " column header is :: " + colHeader);
			}

		} catch (java.lang.Exception e) {
			e.getMessage();
		}
		return colHeader;
	}

	public String returnTargetColHeaadeForCheckSum(String connT) {
		String colHeader = null;
		try {
			Thread.sleep(2000);
			isDisplayed(driver, chksum_target_colHeader);
			BaseSuite.reportLog(connT + " column header element is displayed.");
			colHeader = getText(driver, chksum_target_colHeader);
			if (colHeader.trim().isEmpty()) {
				BaseSuite.reportErrorLog("Unable to get " + connT + " column header after get data.");

			} else {
				BaseSuite.validationReportLog("In " + connT + " column header is :: " + colHeader);
			}

		} catch (java.lang.Exception e) {
			e.getMessage();
		}
		return colHeader;
	}

	/************** Recen Run related methods *************************/

	public void clickOnRecentRunButton() {
		try {
			verifyVisibilityOfButtons(driver, recentRunButton, "Recent Run", true);

			BaseSuite.reportLog("Clicking on Recent run button");

			displayAndClick(driver, recentRunButton);

			Thread.sleep(2000);

			BaseSuite.validationReportLog("Recent run button clicked successfully");
		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	// method to click on refresh button from recent run tab.
	public void clickOnRecentRunTabRefreshIcon() {
		try {

			Thread.sleep(2000);

			javascript(driver, "arguments[0].scrollIntoView(true);", recent_RefreshBtn);

			isDisplayed(driver, recent_RefreshBtn);

			BaseSuite.reportLog("Refresh icon on recent run tab is displayed.");

			displayAndClick(driver, recent_RefreshBtn);

			// displayAndClick(driver, recent_RefreshBtn);

			Thread.sleep(2000);

			BaseSuite.validationReportLog("Refresh icon clicked successfully.");

			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.reportLog("Spinner is displayed.");

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	// method to get exit code from search result of single instance id.
	public void returnExitCodeOfInstanceId(String instanceId) {
		try {
			if (instanceId != null) {

				isDisplayed(driver,
						returnElement(recentRun_GetExistCodeusingInstanceId, "$instanceId", instanceId.trim()));
				BaseSuite.reportLog("Checking exit code for instance Id : " + instanceId);
				String exitCode = getText(driver,
						returnElement(recentRun_GetExistCodeusingInstanceId, "$instanceId", instanceId.trim()));
				BaseSuite.validationReportLog("For given instance id exit code is : " + exitCode);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to get status of rule based on instance id.
	public String returnStatusOfRuleUsingInstanceId(String instanceId) throws Exception {
		String status = null;
		try {
			isDisplayed(driver, returnElement(recentRun_getStatus_usingInstanceId, "$instanceId", instanceId.trim()));
			BaseSuite.reportLog("Checking rule's status for instance Id : " + instanceId.trim());
			status = getText(driver,
					returnElement(recentRun_getStatus_usingInstanceId, "$instanceId", instanceId.trim()));
			BaseSuite.validationReportLog("For given instance id the status of rule is : " + status);

		} catch (Exception e) {
			throw new Exception("");
		}
		return status;
	}

	// total number of recent run history available
	public String returnTotalRecentrunHistoryForRule() throws Exception {
		String num;

		isDisplayed(driver, recentRun_totalitems);
		String noItems = getText(driver, recentRun_totalitems);
		if (!noItems.isEmpty()) {
			String[] temp = noItems.trim().split(" ");
			num = temp[0].substring(1);
		} else {
			num = null;
		}
		return num;
	}

	// search method which will return instance id on the basis of status of rule
	public String getInstanceIdOfRunningRule(String input) throws Exception {
		String instanceId = null;
		try {

			isDisplayed(driver, recentRun_SearchInputbox);
			String noOfItems = returnTotalRecentrunHistoryForRule();
			BaseSuite.reportLog("Recent run has " + noOfItems + " items in history.");
			BaseSuite.reportLog("Search textbox is displayed.");
			clear_Click_SendKeys(driver, 1, recentRun_SearchInputbox, input.trim());
			BaseSuite.validationReportLog("Looking for instance id of rule with status :: " + input + ".");
			displayAndClick(driver, recentRun_SeachBtn);
			BaseSuite.reportLog("Clicked on search button.");
			inVisible(driver, spinner, Constant.ruleWait);
			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			boolean status = isDisplayed(driver, recentRun_NoRecordToDisplay);
			if (status) {
				int i = Integer.parseInt(noOfItems);
				if (i == 1) {

					isDisplayed(driver, recentRun_firstrun_status);
					String statusF = getText(driver, recentRun_firstrun_status);
					BaseSuite.reportErrorLog(
							"Rule is in status :: " + statusF + ", hence unable to finding running rule.");
				} else {
					isDisplayed(driver, recentRun_SearchInputbox);
					BaseSuite.reportLog("Search textbox is displayed, now searching for Success status.");
					input = "Success";
					clear_Click_SendKeys(driver, 1, recentRun_SearchInputbox, input.trim());
					displayAndClick(driver, recentRun_SeachBtn);
					BaseSuite.reportLog("Clicked on search button.");
					inVisible(driver, spinner, Constant.ruleWait);
					//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					status = isDisplayed(driver, recentRun_NoRecordToDisplay);
					if (status) {

					}

					BaseSuite.reportErrorLog("Unable to find matching records of rule with status as " + input
							+ ", no record to display.");
				}

			} else {
				instanceId = getText(driver, returnElement(recentRun_GetInstanceIdUsingStatus, "$status", input));
				BaseSuite.validationReportLog("Successfully retrived instance id of rule which is in " + input
						+ " status, as  :: " + instanceId);
			}

		} catch (Exception e) {
			throw new Exception("");
		}
		return instanceId;
	}

	// create method which will check status of rule (after clicking run button)
	// till we get status other than running.

	public ArrayList<String> checkStatusOfRunningRule(String ruleType, String expectedSourceCount,
			String expectedTargetCount, String expectedExitCode) {

		String statusOfRule = null;

		String instanceIdofRule = null;

		String exitcodeOfRule = null;

		String sourceCountOfRule = null;

		String targetCountOfRule = null;

		String exitCodeOfRule = null;

		String elapsedTime = null;

		ArrayList<String> list = new ArrayList<String>();

		List<String> namesList;
		try {
			statusOfRule = getText(driver, recentrun_latest_statusofrule);

			isDisplayed(driver, recentrun_latest_instanceId);

			instanceIdofRule = getText(driver, recentrun_latest_instanceId);

			BaseSuite.validationReportLog("Final status of rule executed as : " + statusOfRule);

			BaseSuite.reportLog("Instance id for latest run of current rule : " + instanceIdofRule);

			exitcodeOfRule = getText(driver, recentrun_latest_exitCode);

			BaseSuite.validationReportLog("Exit code of rule current rule : " + exitcodeOfRule);

			sourceCountOfRule = getText(driver, recentRunSourceCount);

			if (!(ruleType.equalsIgnoreCase("Script"))) {

				BaseSuite.reportLog("Retrieved source count : " + sourceCountOfRule);

				BaseSuite.reportLog("Expected source count :" + expectedSourceCount);

				if (sourceCountOfRule.equalsIgnoreCase(expectedSourceCount.trim())) {

					BaseSuite.validationReportLog("Source count of rule matched successfully");

				} else {

					BaseSuite.reportFailLog("Source count of rule not matched successfully",
							"checkStatusOfRunningRule");
				}
			}

			targetCountOfRule = getText(driver, recentRunTartgetCount);

			if (!(ruleType.equalsIgnoreCase("Validation") || ruleType.equalsIgnoreCase("Pushdown")
					|| ruleType.equalsIgnoreCase("Script"))) {

				BaseSuite.reportLog("Retrieved target count : " + targetCountOfRule);

				BaseSuite.reportLog("Expected target count :" + expectedTargetCount);

				if (targetCountOfRule.equalsIgnoreCase(expectedTargetCount.trim())) {

					BaseSuite.validationReportLog("Target count of rule matched successfully");

				} else {

					BaseSuite.reportFailLog("Target count of rule not matched successfully",
							"checkStatusOfRunningRule");
				}
			}

			exitCodeOfRule = getText(driver, recentRunExitCode);

			BaseSuite.reportLog("Retrieved exitCode count : " + exitCodeOfRule);

			BaseSuite.reportLog("Expected exitCode count :" + expectedExitCode);

			if (exitCodeOfRule.equalsIgnoreCase(expectedExitCode.trim())) {

				BaseSuite.validationReportLog("ExitCode of rule matched successfully");

			} else {

				BaseSuite.reportFailLog("ExitCode of rule not matched successfully", "checkStatusOfRunningRule");
			}

			elapsedTime = getText(driver, recentRunElapsedTime);

			BaseSuite.validationReportLog("Elapsed Time of rule current rule : " + elapsedTime);

			namesList = Arrays.asList(instanceIdofRule, statusOfRule, sourceCountOfRule, targetCountOfRule,
					exitCodeOfRule, elapsedTime);

			list.addAll(namesList);

		} catch (Exception e) {

			e.getMessage();
		}
		return list;

	}

	public String createHtmlViewTable(String[][] datatable, String tableTitle) {

		StringBuilder htmlbuilder = new StringBuilder();

		htmlbuilder.append(ruleRecentRunsTableCSSStyle);

		htmlbuilder.append("<table class =\"rule1\">");

		htmlbuilder.append("<caption>" + tableTitle + "</caption>");

		htmlbuilder.append("<thead>");

		htmlbuilder.append("<tr class=\"e-row\">");

		for (String header : datatable[0]) {

			htmlbuilder.append("<th class=\"e-headercell\">").append(header).append("</th>");

		}
		htmlbuilder.append("</tr>");

		htmlbuilder.append("</thead>");

		htmlbuilder.append("<tbody>");

		for (int i = 1; i < datatable.length; i++) {

			htmlbuilder.append("<tr class=\"e-row\">");

			for (String cell : datatable[i]) {

				if (cell.trim().equalsIgnoreCase("success")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#32cd32\">").append(cell).append("</td>");

				} else if (cell.trim().equalsIgnoreCase("warning")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#F8C753\">").append(cell).append("</td>");

				} else if (cell.trim().equalsIgnoreCase("error")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#a9a6a6\">").append(cell).append("</td>");

				} else if (cell.trim().equalsIgnoreCase("skipped")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#c8c8c8\">").append(cell).append("</td>");

				} else if (cell.trim().equalsIgnoreCase("pass")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#32cd32\">").append(cell).append("</td>");

				} else if (cell.trim().equalsIgnoreCase("fail")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#d03211\">").append(cell).append("</td>");
				} else if (cell.trim().equalsIgnoreCase("blocker")) {

					htmlbuilder.append("<td class=\"e-rowcell\" style=\"color:#d03211\">").append(cell).append("</td>");

				} else {

					htmlbuilder.append("<td class=\"e-rowcell\">").append(cell).append("</td>");
				}
			}

			htmlbuilder.append("</tr>");
		}

		htmlbuilder.append("</tbody>");

		htmlbuilder.append("</table>");

		return htmlbuilder.toString();
	}

	public void getRuleInstanceTable(ArrayList<String> list) {

		try {

			String[][] table = new String[2][7];

			String[] header = { "Seq", "Instance ID", "Status", "Source Count", "Target Count", "Exit Code",
					"Elapsed Time" };

			table[0] = header;

			String instanceId = list.get(0);

			String runStatus = list.get(1);

			String sourceCount = list.get(2);

			String targetCount = list.get(3);

			String exitCode = list.get(4);

			String time = list.get(5);

			String[] tableData = { "01", instanceId, runStatus, sourceCount, targetCount, exitCode, time };

			table[1] = tableData;

			BaseSuite.reportLog(createHtmlViewTable(table, "Rule Recent Runs Details"));

		} catch (Exception e) {

			BaseSuite.reportErrorLog("Error occurs while getRuleInstanceTable :: " + e.toString());
		}

	}

	// method to clear and do empty search on recent tab to get back list of recent
	// runs.
	public void clearNemptySearchOnRecentRuntab() {
		try {
			isDisplayed(driver, recentRun_SearchInputbox);
			clear(driver, recentRun_SearchInputbox);
			displayAndClick(driver, recentRun_SeachBtn);
			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Method to click run button.
	public boolean clickOnRunButton(String jsonEntity) throws InterruptedException {
		boolean flag = true;
		try {
			String ruleState = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.state");

			if (ruleState.equalsIgnoreCase("Published")) {
				isDisplayed(driver, ruleRunButton);

				// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				Thread.sleep(3000);

				if (verifyVisibilityOfButtons(driver, ruleRunButton, "Run", true)) {

					isClickable(driver, ruleRunButton, "Run", true);

					BaseSuite.reportLog("Run button is displayed.");

					displayAndClick(driver, ruleRunButton);

					BaseSuite.validationReportLog("Run button clicked successfully.");

					inVisible(driver, spinner, Constant.ruleWait);

					BaseSuite.reportLog("Spinner is displayed.");

				} else {

					flag = false;
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return flag;
	}

	// method to click on Iceon besides publish button
	public void clickOnRulePublishMenuListIconBtn() throws Exception {
		try {
			isDisplayed(driver, ruleBtnListMenuIcon);
			BaseSuite.reportLog("Menu button is displayed.");
			// displayAndClick(driver, ruleBtnListMenuIcon);
			Actions actions = new Actions(driver);
			wait = waitMethod(driver);
			actions.moveToElement(driver.findElement(ruleBtnListMenuIcon)).click().build().perform();
			BaseSuite.validationReportLog("Button clicked successfully.");
			isDisplayed(driver, saveMenuOptionsList);
			BaseSuite.validationReportLog("Rule publish menu options list is displayed.");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickONSaveRuleOption(String jsonEntity) {
		String ruleState = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.state");

		if (ruleState.equalsIgnoreCase("Published")) {
			BaseSuite.reportLog("Clicking on rule published button");

			displayAndClick(driver, rulePublishButton);

			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Published button clicked successfully");
		} else {
			BaseSuite.reportLog("Menu button is displayed.");

			isDisplayed(driver, ruleBtnListMenuIcon);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(ruleBtnListMenuIcon)).click().build().perform();

			BaseSuite.validationReportLog("Button clicked successfully.");

			if (isDisplayed(driver, saveListOption)) {
				BaseSuite.validationReportLog("Rule publish menu options list is displayed.");

				if (ruleState.equalsIgnoreCase("Validate")) {
					BaseSuite.reportLog("Clicking on validate button");

					displayAndClick(driver, validateBtn);

					inVisible(driver, spinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Validate button clicked successfully");
				} else {
					BaseSuite.reportLog("Clicking on Draft button");

					displayAndClick(driver, draftBtn);

					inVisible(driver, spinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Draft button clicked successfully");

				}
			} else {

				BaseSuite.reportFailLog("Rule publish menu options list is not display.", "clickONSaveRuleOption");
			}

		}

		if (isDisplayed(driver, toastMsgCon)) {
			captureToastMsg(driver, toastMsgCon, popUpClose, ruleSuccessMsg, "After clicking published button");
		}

	}

	// method to click on Save menu button from options.
	public void clickOnDraftMenuOptionBtn() throws Exception {
		try {
			isDisplayed(driver, ruleDraftButton);
			BaseSuite.reportLog("Draft button is displayed.");
			displayAndClick(driver, ruleDraftButton);
			BaseSuite.validationReportLog("Draft button clicked successfully.");
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, toastMsgCon, popUpClose, ruleSuccessMsg, "After clicking draft button");
			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Thread.sleep(2000);

			if (isDisplayed(driver, ruleCurrentStatus)) {
				String status = getAttribute(driver, ruleCurrentStatus, "title");
				if (status.trim().equalsIgnoreCase(status_Draft)) {
					BaseSuite.validationReportLog(
							"After clicking draft button, icon next to rule name successfully changed to "
									+ status_Draft + ".");
				} else {
					BaseSuite.reportErrorLog("After clicking draft button, rule status changed to " + status
							+ ",which is not expected kindly check.");
				}
			}

		} catch (java.lang.Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// method to click on Save menu button from options.

	public void clickOnDraftMenuOptionBtn(String message) throws Exception {
		try {
			isDisplayed(driver, ruleDraftButton);
			BaseSuite.reportLog("Draft button is displayed.");
			displayAndClick(driver, ruleDraftButton);
			BaseSuite.validationReportLog("Draft button clicked successfully.");
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, toastMsgCon, popUpClose, message, "After clicking draft button");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// method to click on Save&Validate menu button from options.
	public boolean clickOnValidateMenuOptionBtn() throws Exception {
		boolean flag = true;
		try {
			isDisplayed(driver, ruleValidateButton);
			BaseSuite.reportLog("Validate button is displayed.");
			displayAndClick(driver, ruleValidateButton);
			BaseSuite.validationReportLog("Validate button is clicked successfully.");
			inVisible(driver, spinner, Constant.ruleWait);
			// No message is displayed.
			// captureToastMsg(driver, toastMsgCon, popUpClose,
			// toastMessageAfterSaveListOptions,"After clicking Save and Validate button");
			//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			Thread.sleep(2000);
			if (isDisplayed(driver, ruleCurrentStatus)) {
				String status = getAttribute(driver, ruleCurrentStatus, "title");
				if (status.trim().equalsIgnoreCase(status_Validate)) {
					BaseSuite.validationReportLog(
							"After clicking validate button, icon next to rule name successfully changed to "
									+ status_Validate + ".");
				} else {
					BaseSuite.reportErrorLog("After clicking validate button, rule status changed to " + status
							+ ",which is not expected kindly check.");
					flag = false;
				}
			} else {
				flag = false;
			}

		} catch (java.lang.Exception e) {
			throw new Exception(e.getMessage());
		}
		return flag;
	}

	// method to click on Save&Validate menu button from options.
	public boolean clickOnValidateMenuOptionBtn(String message) throws Exception {
		boolean flag = true;
		try {
			isDisplayed(driver, ruleValidateButton);
			BaseSuite.reportLog("Validate button is displayed.");
			displayAndClick(driver, ruleValidateButton);
			BaseSuite.validationReportLog("Validate button is clicked successfully.");
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, toastMsgCon, popUpClose, message, "After clicking validate button");

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return flag;
	}

	// click on excution log button
	public void clickOnExecutionLogButton() throws Exception {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			Thread.sleep(2000);

			if (isDisplayed(driver, recentrun_ExecutionLogBtn)) {

				// wait = waitMethod(driver);
				int i = 0;
				do {

					javascript(driver, "arguments[0].click();", recentrun_ExecutionLogBtn);

					i++;

				} while (i <= 2);

				BaseSuite.validationReportLog("Check tab node button clicked successfully");

			} else {
				BaseSuite.reportFailLog("Execution log button not visible", "clickOnExecutionLogButton");
			}

			BaseSuite.validationReportLog("Execution log button clicked successfully.");

			isDisplayed(driver, recentrun_ExecutionLog_recentlogbox);

			boolean window = isEnabled(driver, recentrun_ExecutionLog_Summary);

			if (window) {

				BaseSuite.validationReportLog("After click,recent logs window is opened.");

			} else {

				BaseSuite.reportErrorLog("Unable to open recent logs window.");
			}

		} catch (java.lang.Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	// get execution summary from log to print in report:: EXCEL METHOD
	public void getExecutionLogSummary(DataTestingParameters param, String filename, String sheetname)
			throws Exception {

		try {

			isDisplayed(driver, recentrun_ExecutionLog_recentlogbox);

			isDisplayed(driver, recentrun_ExecutionLog_Summary);

			BaseSuite.validationReportLog("Execution summary is displayed.");
			String summary = getAttribute(driver, recentrun_ExecutionLog_Summary, "value");// innerHTML
			int noexp = totalExpressionsInRule(param);
			int flag;
			if ((param.ruleType.equalsIgnoreCase("recon")) | (param.ruleType.equalsIgnoreCase("checksum"))) {
				BaseSuite.reportLog("**********Connection details as per execution log**********");
				String scName = param.getSourceConnection();
				System.out.println("SourceConnection--- " + scName);
				String sourceConnType = getConnectionTypeForRule(filename, sheetname, scName.trim());
				if (!sourceConnType.isEmpty()) {
					// getConnectionDetailsInExecutionLog(summary,
					// sourceConnType.toUpperCase(),"source");
				}

				String tcName = param.getTargetConnection();
				System.out.println("TargetConnection--- " + tcName);
				String targetConnType = getConnectionTypeForRule(filename, sheetname, tcName.trim());
				if (!targetConnType.isEmpty()) {
					// getConnectionDetailsInExecutionLog(summary,
					// targetConnType.toUpperCase(),"target");
				}

				BaseSuite.reportLog("**********Expression Summary as per execution log**********");
				getExpressionSummaryInExecutionLog(summary, noexp);
				BaseSuite.reportLog("**********Exit code as per execution log**********");
				getExitCodeInExecutionLog(summary);
			} else if (param.ruleType.equalsIgnoreCase("validation")) {
				BaseSuite.reportLog("**********Connection details as per execution log**********");
				String sourceConnType = getConnectionTypeForRule(filename, sheetname, param.sourceConnection);
				if (!sourceConnType.isEmpty()) {
					// getConnectionDetailsInExecutionLog(summary,
					// sourceConnType.toUpperCase(),"Source");
				}
				BaseSuite.reportLog("**********Expression Summary as per execution log**********");
				getExpressionSummaryInExecutionLog(summary, noexp);
				BaseSuite.reportLog("**********Exit code as per execution log**********");
				getExitCodeInExecutionLog(summary);
			}
		} catch (Exception e) {
			throw new Exception("");
		}
	}

	// method to get connection types as per rule
	// filename-testdata,sheetname-ConnectionDetails,colname-connectionType
	public String getConnectionTypeForRule(String filename, String sheetname, String connName) throws Exception {
		String connType = null;
		try {
			// DataTestingPage dp= new DataTestingPage(driver);
			int row1;

			NewConnectionRepoPage conn = new NewConnectionRepoPage(driver);

			row1 = findRow(filename, sheetname, connName);// "Connection"
			ConnectionPoJO connParam = conn.setConnectionParameters(filename, sheetname, row1);
			connType = connParam.getConnectionType();

		} catch (java.lang.Exception e) {
			throw new Exception("");

		}

		return connType;
	}

	// exit code as per execution log
	public void getExitCodeInExecutionLog(String strExecutionLog) {
		int index = strExecutionLog.indexOf("exit code");
		int newIndex = index + 43;
		String exitcode = strExecutionLog.substring(newIndex);
		System.out.println(exitcode);
		BaseSuite.reportLog(exitcode);
	}

	// Expression evaluated in execution log
	public void getExpressionSummaryInExecutionLog(String strExecutionLog, int noOfExpressionsInRule) {
		int index = strExecutionLog.indexOf("Expression Summary:");
		int newIndex = index + 54;

		String expressions = strExecutionLog.substring(newIndex);
		String[] exp = expressions.split("\n");
		// String[] exp1 = exp[0].split("\n");
		for (int i = 0; i <= noOfExpressionsInRule; i++) {
			// String[] exp1 = exp[i];
			BaseSuite.reportLog(exp[i]);
			System.out.println(exp[i]);
			do {

			} while (i > 0 && i <= noOfExpressionsInRule);

		}

	}

	// Connection details in execution log
	public void getConnectionDetailsInExecutionLog(String strExecutionLog, String connectionName, String type,
			int flag) {
		try {
			int index = 0;

			if (flag == 1) // set flag =1 when source & target both has same connection type.
			{
				index = returnIndexIncaseOfSameConnType(strExecutionLog, connectionName, type);
				System.out.println(String.valueOf(index));
			} else if (flag == 0) // when source & target both has different connection type.
			{
				index = strExecutionLog.indexOf(connectionName);
				System.out.println(String.valueOf(index));
			} else {
				BaseSuite.reportErrorLog(
						"Invalid value of Flag in case of connection type for execution log method, please check.");
			}

			boolean check = strExecutionLog.contains(connectionName.toUpperCase());
			if (check) {

				int newIndex = index - 28;
				String conn = strExecutionLog.substring(newIndex);
				String[] details;
				String[] conne = conn.split("\n");
				BaseSuite.reportLog(conne[0]);
				for (int i = 1; i <= 3; i++) {
					details = conne[i].split(",");
					if (details.length > 1) {
						System.out.println(details[3]);
						BaseSuite.reportLog(details[3]);
					} else {
						details = conne[i + 1].split(",");
						System.out.println(details[3]);
						BaseSuite.reportLog(details[3]);
					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// refactored method :: add colum check. EXCEL ki method hai Need to confirm
	// after code review
	public void addColumnCheckToRule(DataTestingParameters param, SoftAssert soft) throws Exception { // new
																										// method
		try {

			String expression = param.getChkExpression().trim();
			String expCheckColName = param.getChkColumnname().trim();
			String colType = null, colName = null;

			clickOnAddButtonSideMenu();
			clickOnAddColumnMenuOption();

			// split using .
			String[] partsOfExp = expression.split("\\.");
			if (partsOfExp[0].equalsIgnoreCase("s")) {
				colType = "source";
			} else if (partsOfExp[0].equalsIgnoreCase("t")) {
				colType = "target";
			}

			colName = partsOfExp[1].replace("[", "").replace("]", "");
			System.out.println(colName);
			// Click on tab as per colTYpe
			clickOnColumnType(colType);

			isDisplayed(driver, check_AddColumn_Sidebar);
			isDisplayed(driver, check_AddCol_Sidebar_searchBox);
			BaseSuite.reportLog("Search box is displayed on side bar.");

			searchInAddColumnPane(colType);

			boolean status = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName));
			if (status) {
				selectColumnCheckboxFromList(colName);
				Thread.sleep(2000);
				clickOnAddButtonInAddColumnPane();
				validateAddedColumnListDetails(colName, expression, expCheckColName, soft);

			} else {
				BaseSuite.reportErrorLog("Unable to find column with name :" + colName);
			}

		} catch (java.lang.Exception e) {
			throw new Exception("");
		}
	}

	// refactoring add column method as per API final with testdata
	public void AddColumnCheckToRuleApi(DataTestingParameters param, SoftAssert soft) throws Exception {
		try {
			String checkName, checkStatus, checkType, colExpression;
			// set parameters
			checkType = param.getChkCheckType();
			checkName = param.getChkCheckName();
			colExpression = param.getChkExpression();
			checkStatus = param.getChkStatus();

			String colType = null, colName = null;
			// split using .

			String[] partsOfExp = colExpression.split("\\.");
			if (partsOfExp[0].equalsIgnoreCase("s")) {
				colType = "source";
			} else if (partsOfExp[0].equalsIgnoreCase("t")) {
				colType = "target";
			}

			colName = partsOfExp[1].replace("[", "").replace("]", "");
			System.out.println(colName);

			clickOnAddButtonSideMenu();

			clickOnAddColumnMenuOption();

			clickOnColumnType(colType);

			isDisplayed(driver, check_AddColumn_Sidebar);

			isDisplayed(driver, check_AddCol_Sidebar_searchBox);
			BaseSuite.reportLog("Search box is displayed on side bar.");

			searchInAddColumnPane(colName);// change logic here

			boolean statusL = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toLowerCase()));
			boolean statusU = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toUpperCase()));
			if (statusL) {
				selectColumnCheckboxFromList(colName.toLowerCase());

			} else if (statusU) {
				selectColumnCheckboxFromList(colName.toUpperCase());

			} else {
				BaseSuite.reportErrorLog("Unable to find column :: " + colName);
			}

			Thread.sleep(2000);
			clickOnAddButtonInAddColumnPane();
			// validateAddedColumnListDetails(checkType, colName, colExpression, checkName,
			// soft);

		} catch (java.lang.Exception e) {

		}
	}

	// select checkbox of expected column

	public void selectColumnCheckboxFromList(String colName) {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			dp.scrollToLocator(returnElement(check_addCol_sidebar_columToChoose, "$colname", colName), colName);
			isDisplayed(driver, returnElement(check_addCol_sidebar_columToChoose_chkbox, "$colname", colName));
			BaseSuite.reportLog("Column with name :- " + colName + " is displayed.");
			displayAndClick(driver, returnElement(check_addCol_sidebar_columToChoose_chkbox, "$colname", colName));
			BaseSuite.validationReportLog("Column with name :- " + colName + " is Selected.");
		} catch (java.lang.Exception e) {
			e.getMessage();
		}

	}

	public void selectCheckColumnFromList(String locator, String colName) {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			dp.scrollToLocator(returnElement(locator, "$name", colName), colName);

			isDisplayed(driver, returnElement(locator, "$name", colName));

			BaseSuite.reportLog("Column with name :- " + colName + " is displayed.");

			displayAndClick(driver, returnElement(locator, "$name", colName));

			BaseSuite.validationReportLog("Column with name :- " + colName + " is Selected.");

		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Methods using API Testdata @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

	// Click on tab as per requirement
	public void clickOnColumnType(String strType) throws Exception {
		try {
			if (strType.equalsIgnoreCase("source")) {

				isDisplayed(driver, chk_addCol_SourceTab);

				displayAndClick(driver, chk_addCol_SourceTab);

			} else {

				isDisplayed(driver, chk_addCol_TargetTab);

				displayAndClick(driver, chk_addCol_TargetTab);

			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Click On AddColumn buttton.
	public void clickOnAddButtonSideMenu() throws Exception {

		try {
			BaseSuite.reportLog("Click on Add button side menu option.");

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", chk_addButton_SideMenuBtn);

			clickOnButton(driver, chk_addButton_SideMenuBtn, "Add ", true);

			// isDisplayedInLoop(driver, 3, check_add_AddColbutton);
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	// Method to validate column name and datatype list for api as test data.
	public void validateColumnNameNColumnDataType(DataTestingParameters param, String jsonEntity, String settingType,
			SoftAssert soft) throws Exception, InterruptedException {
		try {
			TestDataThroughApi nn = new TestDataThroughApi(driver);

			if (settingType.equalsIgnoreCase("source")) {
				param.setColumnList(nn.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[0].configuration.columns..name"));

			} else if (settingType.equalsIgnoreCase("target")) {
				param.setColumnList(nn.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.columns..name"));

			}

			int total = param.getColumnList().size();
			// setColumnValidationParametersUsingApi(jsonEntity, settingType, total); //need
			// to replace this total with i if we need details of each column name and
			// datatype.
			// validateConnectionColNDatatype(param.getRuleType(), settingType, total,
			// soft);

			// commented as its taking more time to execute this method . keeping as
			// backup

			for (int i = 0; i < total; i++) {
				DataTestingParameters p = setColumnValidationParametersUsingApi(jsonEntity, settingType, i);

				validateConnectionColNDatatype(param.getRuleType(), settingType, p.getColumnName(),
						p.getColumnDataType(), i, soft);
			}

		} catch (Exception e) {
			System.out.println("Log++++++++++++" + e.getMessage());
			throw new Exception("");
		}
	}

	// API- method to validate source/target column name from DB
	public void validateConnectionColNDatatype(String ruletype, String settingType, String expColName,
			String expColDataType, int i, SoftAssert soft) {
		try {
			String colName = null, colDataType = null;
			boolean statusOfSource, statusOfTarget;
			// are we in source setting or target settings

			if (settingType.equalsIgnoreCase("source")) {

				statusOfSource = isDisplayed(driver, scolVal_NoRecord);
				if (!statusOfSource) {
					// load all data from UI
					if (ruletype.equalsIgnoreCase("checksum")) {
						isDisplayed(driver, scolVal_ColName);
						colName = getText(driver, scolVal_ColName);
						isDisplayed(driver, scolVal_ColDataType_chk);
						colDataType = getText(driver, scolVal_ColDataType_chk);
					}

					else if ((ruletype.equalsIgnoreCase("recon")) || (ruletype.equalsIgnoreCase("validation"))) {

						List<WebElement> colNames = getElements(driver, scolVal_ColName);
						List<WebElement> coldatatypes = getElements(driver, scolVal_Coldatatype);

						colName = colNames.get(i).getText();
						colDataType = coldatatypes.get(i).getText();
					}
					// match it with API data
					soft.assertEquals(colName, expColName, "Source column with name " + colName
							+ " : is not matched with expected column name : " + expColName);
					soft.assertEquals(colDataType, expColDataType, "Source column with datatype " + colDataType
							+ " : is not matched with expected column datatype : " + expColDataType);
					BaseSuite.validationReportLog(
							"Successfully matched source column name & datatype for  " + colName + "->" + colDataType);

				} else {
					BaseSuite.reportErrorLog(
							"Source table column not retrived from connection selected , kindly check.");
				}

			} else if (settingType.equalsIgnoreCase("target")) {
				statusOfTarget = isDisplayed(driver, tcolVal_NoRecord);
				if (!statusOfTarget) {
					if (ruletype.equalsIgnoreCase("checksum")) {
						javascript(driver, "arguments[0].scrollIntoView(true);", tcolVal_ColName);
						isDisplayed(driver, tcolVal_ColName);
						colName = getText(driver, tcolVal_ColName);
						isDisplayed(driver, tcolVal_ColDataType_chk);
						colDataType = getText(driver, tcolVal_ColDataType_chk);
					} else if ((ruletype.equalsIgnoreCase("recon")) || (ruletype.equalsIgnoreCase("validation"))) {
						List<WebElement> colNames = getElements(driver, tcolVal_ColName);
						List<WebElement> coldatatypes = getElements(driver, tcolVal_Coldatatype);

						colName = colNames.get(i).getText();
						colDataType = coldatatypes.get(i).getText();
					}
					// match it with API data
					soft.assertEquals(colName, expColName, "Target column with name " + colName
							+ " : is not matched with expected column name : " + expColName);
					soft.assertEquals(colDataType, expColDataType, "Target column with datatype " + colDataType
							+ " : is not matched with expected column datatype : " + expColDataType);
					BaseSuite.validationReportLog(
							"Successfully matched target column name & datatype for  " + colName + "->" + colDataType);

				} else {
					BaseSuite.reportErrorLog(
							"Target table column not retrived from connection selected , kindly check.");
				}

			}
		} catch (Exception e) {

		}
	}

	// method to select multipleResult Type.
	public void selectResultType(String ruleType, String resultTypes) {
		try {
			// isDisplayedInLoop(driver, 1, check_resultType_rowLabel);
			BaseSuite.reportLog("verifying selected result type in check section.");
			uncheckDefaultResultTypeForRule(ruleType);
			switch (ruleType.toLowerCase()) {
			case "recon":
				BaseSuite.reportLog("Selecting result type for recon rule as per user choice.");
				chooseResultTypeForReconUsingApi(resultTypes);

				break;
			case "validation":
			case "checksum":
			case "pushdown":

				break;

			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void checksum_checkNodeClick() {
		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checksum_checkNode_click);
			Thread.sleep(2500);
			isDisplayed(driver, checksum_checkNode_click);
			displayAndClick(driver, checksum_checkNode_click);
			BaseSuite.validationReportLog("Successfully clicked on check node button.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	// method to update checksum default expression.
	public void clickOnDefaultExpression(String exp) {
		try {
			if (isDisplayed(driver, returnElement(check_CustCheck_addedExp, "$expression", exp))) {
				BaseSuite.reportLog("Default expression for rule is displayed.");
				displayAndClick(driver, returnElement(check_CustCheck_addedExp, "$expression", exp));
				isDisplayed(driver, check_custCol_textarea);
				if (isDisplayed(driver, check_custCol_textarea)) {
					BaseSuite.validationReportLog(
							"Successfully clicked on expression, Update Custom Check pane is displayed.");
				}
			} else {
				BaseSuite.reportErrorLog("Unable to find checksum default expression, kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to verify resultType selected in validation / pushdown - for API
	public boolean verifySelectedResultType(String ruleType, String resultType) throws Exception {
		String status = null, rsType = null;
		boolean selected = false;
		try {
			if ((resultType.equalsIgnoreCase("xp")) & (ruleType.equalsIgnoreCase("validation"))) {
				selected = checkDefaultStatusOfResultType(ruleType, resultType);

			} else if ((resultType.equalsIgnoreCase("rowcount")) & (ruleType.equalsIgnoreCase("pushdown"))) {
				selected = checkDefaultStatusOfResultType(ruleType, resultType.toLowerCase());
			} else {
				BaseSuite.reportErrorLog("Kindly check rule type, as its other than validation or pushdown");
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return selected;
	}

	public boolean checkDefaultStatusOfResultType(String ruleType, String resultType) {
		String rsType = null;
		String status = null;
		boolean selected = false;
		try {

			BaseSuite.reportLog("Verifying is " + resultType + " selected by default or not?");
			if (ruleType.equalsIgnoreCase("validation")) {
				resultType = "expression";
			}
			isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultType));
			rsType = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultType), "title");
			BaseSuite.reportLog("result type :: " + rsType + " is displyed.");
			status = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultType), "aria-checked");
			if (status.equalsIgnoreCase("true")) {
				selected = true;
				BaseSuite
						.validationReportLog("For rule type " + ruleType + " ," + resultType + " is already selected.");

			} else {
				selected = false;
				BaseSuite.reportFailLog(
						"For rule type " + ruleType + " ," + resultType + " is unchecked, kindly check.",
						"verifySelectedResultType");

			}

		} catch (Exception e) {

		}
		return selected;
	}

	// method uncheck all by default result types for API
	public void uncheckDefaultResultTypeForRule(String ruleType) {
		String rA_B, rB_A, rExp, r_AnB, status;
		try {

			switch (ruleType.toLowerCase()) {
			case "recon":
			case "ht recon":
				BaseSuite.reportLog("unchecking all selected result types for " + ruleType.toLowerCase() + " rule.");

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "a-b"));

				rA_B = getAttribute(driver, returnElement(ruleResultType, "$resultType", "a-b"), "aria-checked");

				if (rA_B.equalsIgnoreCase("true")) {

					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "a-b"));

				}

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "b-a"));

				rB_A = getAttribute(driver, returnElement(ruleResultType, "$resultType", "b-a"), "aria-checked");

				if (rB_A.equalsIgnoreCase("true")) {

					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "b-a"));
				}

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "expression"));

				rExp = getAttribute(driver, returnElement(ruleResultType, "$resultType", "expression"), "aria-checked");

				if (rExp.equalsIgnoreCase("true")) {

					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "expression"));

				}

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "anb"));

				r_AnB = getAttribute(driver, returnElement(ruleResultType, "$resultType", "anb"), "aria-checked");

				if (r_AnB.equalsIgnoreCase("true")) {

					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "anb"));

				}
				BaseSuite
						.reportLog("unselected default selected result types for " + ruleType.toLowerCase() + " rule.");

				break;
			case "validation":
			case "ht validation":

				String status_exp;
				// returnElement(ruleResultType, "$resultType", exp);
				BaseSuite.reportLog(
						"Verifying can we unselect default result type for " + ruleType.toLowerCase() + " rule.");

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "expression"));

				status_exp = getAttribute(driver, returnElement(ruleResultType, "$resultType", "expression"),
						"aria-checked");

				if (status_exp.equalsIgnoreCase("true")) {

					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "expression"));

					if (status_exp.equalsIgnoreCase("false")) {

						BaseSuite.reportErrorLog("User is able to uncheck single result type, kindly check a error");

					} else {

						BaseSuite.validationReportLog("For " + ruleType.toLowerCase()
								+ " rule, we can't uncheck selected single result type.");
					}

				}

				break;
			case "pushdown":
			case "ht pushdown":
				BaseSuite.reportLog(
						"Verifying can we unselect default result type for " + ruleType.toLowerCase() + " rule.");

				String status_row;

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", "rowcount"));

				status_row = getAttribute(driver, returnElement(ruleResultType, "$resultType", "rowcount"),
						"aria-checked");

				if (status_row.equalsIgnoreCase("true")) {

					displayAndClick(driver, returnElement(ruleResultType, "$resultType", "rowcount"));

					status_row = getAttribute(driver, returnElement(ruleResultType, "$resultType", "rowcount"),
							"aria-checked");

					if (status_row.equalsIgnoreCase("false")) {

						BaseSuite.reportErrorLog("User is able to uncheck single result type, kindly check a error");

					} else {
						BaseSuite.validationReportLog("For " + ruleType.toLowerCase()
								+ " rule, we can't uncheck selected single result type.");
					}
				}
				break;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog("Exception received in result type :: " + e.getMessage());
		}
	}

	// method to set result type for recon rule as per user choice.(enter ,
	// seperated value as a-b,b-a,expression,anb)
	public void chooseResultTypeForReconUsingApi(String resultTypes) throws Exception {
		String reconResultTypes = "a-b b-a anb expression";
		try {
			String result_Input = resultTypes.replace("[", "").replace("]", "").toLowerCase();
			// split logic
			String[] resultType = result_Input.trim().split(",");
			int count = resultType.length;

			for (int colNum = 0; colNum < count; colNum++) {

				String resultT = resultType[colNum].toLowerCase();
				if (reconResultTypes.contains(resultT)) {
					if (resultT.equalsIgnoreCase("xp")) {
						resultT = "expression";
					}

					isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultT));
					BaseSuite.reportLog("For recon rule result type : " + resultT + " is displayed.");
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", resultT));
					String status = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultT),
							"aria-checked");
					BaseSuite.validationReportLog("Result type is clicked successfully so final status is : " + resultT
							+ " is set to :" + status);

				} else {
					BaseSuite.reportErrorLog("Invalid result type is entered as a input , kindly check.");
				}

			}

		} catch (Exception e) {
			throw new Exception("");
		}
	}

	public void chooseResultTypeForValidationUsingApi(String resultType) {
		String resultType1 = "expression", resultType2 = "rowcount";
		try {

			String resultT;
			// remove [] from string

			resultT = resultType.replace("[", "").replace("]", "").toLowerCase();
			System.out.println(resultT);

			if (resultT.equalsIgnoreCase(resultType1)) {

				isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultT));
				BaseSuite.reportLog("For recon rule result type : " + resultT + " is displayed.");
				displayAndClick(driver, returnElement(ruleResultType, "$resultType", resultT));
				String status = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultT),
						"aria-checked");
				BaseSuite.validationReportLog("Result type is clicked successfully so final status is : " + resultT
						+ " is set to :" + status);
				isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultType2.trim()));
				String statuso = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultType2.trim()),
						"aria-checked");
				if (statuso.equalsIgnoreCase("false")) {
					BaseSuite.validationReportLog("When " + resultType1 + " result type is selected," + resultType2
							+ " result type is unchecked");
				} else {
					// need to ask this implimentation
				}

			} else {
				if (resultT.equalsIgnoreCase(resultType2)) {
					isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultT));
					BaseSuite.reportLog("For recon rule result type : " + resultT + " is displayed.");
					displayAndClick(driver, returnElement(ruleResultType, "$resultType", resultT));
					String status = getAttribute(driver, returnElement(ruleResultType, "$resultType", resultT),
							"aria-checked");
					BaseSuite.validationReportLog("Result type is clicked successfully so final status is : " + resultT
							+ " is set to :" + status);
					isDisplayed(driver, returnElement(ruleResultType, "$resultType", resultType1.trim()));
					String statuso = getAttribute(driver,
							returnElement(ruleResultType, "$resultType", resultType1.trim()), "aria-checked");
					if (statuso.equalsIgnoreCase("false")) {
						BaseSuite.validationReportLog("When " + resultType2 + " result type is selected," + resultType1
								+ " result type is unchecked");
					} else {
						// need to ask this implimentation
					}
				}

			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// method to search on recent run tab with single instance id. - search test
	// case
	public void searchOnRecentTabUsingInstanceId(String instanceID, SoftAssert soft)
			throws Exception, InterruptedException {
		try {
			scrollToLocator(recentRun_SearchInputbox, "Search input box");
			if (instanceID == null) {
				BaseSuite.reportErrorLog("Unable to processed as InstanceId in null.");
			} else {

				enterTextToSearchInRecentRun(instanceID);

				clickOnSeachIcon();

				verifySearchResultInRecentRun(instanceID, soft);

			}

		} catch (Exception e) {
			throw new Exception("");
		}
	}

//verify search result in recent run.
	public void verifySearchResultInRecentRun(String instanceID, SoftAssert soft) throws Exception {
		try {
			String resultInstID = null;
			boolean status = isDisplayed(driver, recentRun_NoRecordToDisplay);
			if (status) {
				BaseSuite.reportErrorLog("Unable to find matching records with instance id : " + instanceID
						+ " as no record to display.");

			} else {

				List<WebElement> results = getElements(driver, recentRun_Search_rowCount);

				int no = results.size();

				if (no == 1) {
					resultInstID = getText(driver,
							returnElement(recentRun_SearchusingInstanceId, "$instanceId", instanceID));

					soft.assertEquals(instanceID, resultInstID,
							"Search failed : Unable to match actual with expected instance id.");

					BaseSuite.validationReportLog(
							"Successfully searched instance id= " + instanceID + " in recent run.");
				} else if (no > 1) {
					BaseSuite.reportLog("Search result has multiple values, lets verify all.");
					List<WebElement> insresults = getElements(driver, recentRun_search_multi_instanceIDs);
					for (int i = 0; i < no & i < insresults.size(); i++) {
						resultInstID = insresults.get(i).getText();
						int j = i + 1;
						if (resultInstID.contains(instanceID)) {

							BaseSuite.validationReportLog(
									j + "." + resultInstID + " validated as per search input successfully.");
						} else {
							BaseSuite.reportFailLog(
									j + "." + resultInstID
											+ " doesnt contains search input still in search result , kindly check.",
									"verifySearchResultInRecentRun");
						}

					}
				}
			}

		} catch (Exception e) {
			BaseSuite.reportLog(e.getMessage());
		}
	}

//Click on search button
	public void clickOnSeachIcon() throws Exception {
		try {
			isDisplayed(driver, recentRun_SeachBtn);

			BaseSuite.reportLog("Search icon button is displayed.");

			displayAndClick(driver, recentRun_SeachBtn);

			BaseSuite.reportLog("Successfully clicked on search button.");

			inVisible(driver, spinner, Constant.ruleWait);
			// need to add no record to display logic
			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		} catch (Exception e) {
			BaseSuite.reportLog(e.getMessage());
		}
	}

	// get execution summary from log to print in report:: for API //OLD METHOD AS
	// PER OLD REQUIREMENT.
	public void getExecutionLogSummaryForApi(DataTestingParameters param, SoftAssert soft) throws Exception {

		try {
			int totalExp = 1; // param.getNoOfExp();
			isDisplayed(driver, recentrun_ExecutionLog_recentlogbox);
			isDisplayed(driver, recentrun_ExecutionLog_Summary);

			BaseSuite.validationReportLog("Execution summary is displayed.");
			String summary = getAttribute(driver, recentrun_ExecutionLog_Summary, "value");// innerHTML
			int flag;
			int noexp = totalExpressionsInRuleForAPI(param, totalExp);
			if ((param.ruleType.equalsIgnoreCase("recon")) | (param.ruleType.equalsIgnoreCase("checksum"))) {
				BaseSuite.reportLog("**********Connection details as per execution log**********");
				String scName = ""; // param.getSourceConnection();
				System.out.println("SourceConnection--- " + scName);
				String sourceConnType = "ORACLE"; // param.getSourceConnType();
				String targetConnType = "POSTGRESQL"; // ORACLE
				if ((!sourceConnType.isEmpty()) && (!targetConnType.isEmpty())) {
					if (sourceConnType.equalsIgnoreCase(targetConnType)) {
						flag = 1;
					} else {
						flag = 0;
					}
					getConnectionDetailsInExecutionLog(summary, sourceConnType.toUpperCase(), "source", flag);
					String tcName = ""; // param.getTargetConnection();
					System.out.println("TargetConnection--- " + tcName);
					// param.getTargetConnType();

					getConnectionDetailsInExecutionLog(summary, targetConnType.toUpperCase(), "target", flag);

				}

				// }

				BaseSuite.reportLog("**********Expression Summary as per execution log**********");
				getExpressionSummaryInExecutionLog(summary, noexp);
				BaseSuite.reportLog("**********Exit code as per execution log**********");
				getExitCodeInExecutionLog(summary);
			}
			if ((param.ruleType.equalsIgnoreCase("validation")) || (param.ruleType.equalsIgnoreCase("pushdown"))) {
				BaseSuite.reportLog("**********Connection details as per execution log**********");

				String sourceConnType = "ORACLE";// param.getSourceConnection(); //param.getSourceConnType();
				System.out.println("SourceConnection--- " + sourceConnType);
				if (!sourceConnType.isEmpty()) {
					getConnectionDetailsInExecutionLog(summary, sourceConnType.toUpperCase(), "source", 0);
				}
				if (param.ruleType.equalsIgnoreCase("validation")) {
					BaseSuite.reportLog("**********Expression Summary as per execution log**********");
					getExpressionSummaryInExecutionLog(summary, noexp);
				}

				BaseSuite.reportLog("**********Exit code as per execution log**********");
				getExitCodeInExecutionLog(summary);

			}

			clickOnCancelBtnOfExecutionLog();
		} catch (Exception e) {
			throw new Exception("");
		}
	}

	public static boolean isStrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	// get total countofExpression for rule as per testdata.
	public int totalExpressionsInRuleForAPI(DataTestingParameters param, int totalExp) {
		int noExp = 0;
		try {
			if ((param.ruleType.equalsIgnoreCase("recon")) | (param.ruleType.equalsIgnoreCase("validation"))) {
				noExp = totalExp;

				String newCheck, custExp;
				newCheck = param.getAddCheck();
				String[] tNewChk = newCheck.split(",");
				int countNChk = tNewChk.length;
				custExp = param.getChk_CustExpressions();
				String[] tcustChk = custExp.split(",");
				int countCustChk = tcustChk.length;
				noExp = countNChk + countCustChk;

			} else if (param.ruleType.equalsIgnoreCase("checksum")) {

				noExp = 1;
			} else if ((param.ruleType.equalsIgnoreCase("pushdown"))) {
				// noExp = 0;
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return noExp;

	}

	// **********************************Neha's comman methods
	// Ends*********************************************************// *

	// *************************Dhawal's
	// Code*********************************************/

	public void clickOnSourceDataset() throws InterruptedException {

		try {

			WebElement ele = driver.findElement(sourceDatasetButton);

			BaseSuite.reportLog("Clicking on Source dataset button");

			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetButton);

			Thread.sleep(4000);

			Actions builder = new Actions(driver);

			builder.click(ele).build().perform();

			Thread.sleep(3000);

			BaseSuite.reportLog("Source dataset button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void clickOnTargetDataset() throws InterruptedException {

		try {

			WebElement ele = driver.findElement(targetDatasetButton);

			BaseSuite.reportLog("Clicking on Target dataset button");

			javascript(driver, "arguments[0].scrollIntoView(true);", targetDatasetButton);

			Thread.sleep(4000);

			Actions builder = new Actions(driver);

			builder.moveToElement(ele).click().build().perform();

			Thread.sleep(3000);

			BaseSuite.reportLog("Target dataset button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void clickOnDiffJoin() throws InterruptedException {

		try {

			WebElement ele = driver.findElement(diffJoinButton);

			BaseSuite.reportLog("Clicking on Diff join button");
			Thread.sleep(3000);
			javascript(driver, "arguments[0].scrollIntoView(true);", diffJoinButton);

			isDisplayed(driver, diffJoinButton);
			Thread.sleep(3000);
			displayAndClick(driver, diffJoinButton);
			BaseSuite.reportLog("Target Diff join node button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void xmlXpath(String jsonEntity, String expression) {
		try {
			String xpath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			BaseSuite.reportLog("Entering detail in Xpath field");

			javascript(driver, "arguments[0].scrollIntoView(true);", xmlXpath);

			WebElement ele = getElement(driver, xmlXpath);

			displayAndClick(driver, xmlXpath);

			ele.sendKeys(xpath);

			BaseSuite.validationReportLog("Detailed entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void addCalculatedCheck(DataTestingParameters param, String ruleType, String jsonEntity, int checkNumber,
			String icedqRole, String workspaceId, String sourceQuery, String targetQuery) throws Exception {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			String checkName, checkStatus, customExpression;

			checkName = param.getChkCheckName();

			checkStatus = param.getChkStatus();

			customExpression = param.getChkExpression();

			Thread.sleep(1000);

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			chooseCheck(calculatedCheck, "Calculated");

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				dp.enterCheckName(checkName);

				dp.selectCheckEnableStatus(checkStatus);

				verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				// addAndValidatedAddedExpression(checkName, customExpression.trim(), chkStatus,
				// soft);
				// String val =
				// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// customExpression);
				if (!(customExpression.contains("#") || customExpression.contains("\\")
						|| customExpression.contains("IN") || customExpression.contains("in")
						|| customExpression.contains("startsWith") || customExpression.contains("endsWith")
						|| customExpression.contains("()") || customExpression.contains("?"))) {

					String[] expVal = customExpression.split(" ");

					int count = expVal.length;

					for (int colNum = 0; colNum < count; colNum++) {

						String result = expVal[colNum];

						if (result.startsWith("S.[")) {
							WebElement ele;

							displayAndClick(driver, sourceDropdown);

							Actions action = new Actions(driver);

							ele = getElement(driver, sourceDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("S.", "");

							boolean uppercaseCol = isDisplayed(driver,
									returnElement(customSorceColumnName, "$name", col1.toUpperCase()));

							boolean lowercaseCol = isDisplayed(driver,
									returnElement(customSorceColumnName, "$name", col1.toLowerCase()));

							boolean camelcaseCol = isDisplayed(driver,
									returnElement(customSorceColumnName, "$name", col1));

							if (uppercaseCol) {
								selectCheckColumnFromList(customSorceColumnName, col1.toUpperCase());
							} else if (lowercaseCol) {
								selectCheckColumnFromList(customSorceColumnName, col1.toLowerCase());
							} else if (camelcaseCol) {
								selectCheckColumnFromList(customSorceColumnName, col1);
							} else {

								selectCheckColumnFromList(customSorceColumnNameTranslate, col1.toLowerCase());
							}

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("T.[")) {
							WebElement ele;

							displayAndClick(driver, targetDropdown);

							Actions action = new Actions(driver);

							ele = getElement(driver, targetDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("T.", "");

							boolean uppercaseCol = isDisplayed(driver,
									returnElement(customTargetColumnName, "$name", col1.toUpperCase()));

							boolean lowercaseCol = isDisplayed(driver,
									returnElement(customTargetColumnName, "$name", col1.toLowerCase()));

							boolean camelcaseCol = isDisplayed(driver,
									returnElement(customTargetColumnName, "$name", col1));

							if (uppercaseCol) {
								selectCheckColumnFromList(customTargetColumnName, col1.toUpperCase());
							} else if (lowercaseCol) {
								selectCheckColumnFromList(customTargetColumnName, col1.toLowerCase());
							} else if (camelcaseCol) {
								selectCheckColumnFromList(customTargetColumnName, col1);
							} else {

								selectCheckColumnFromList(customTargetColumnNameTranslate, col1.toLowerCase());
							}

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);
						} else if (result.matches("[A-Za-z0-9-']+")) {
							BaseSuite.reportLog("Entering value on expression box");

							sendKeys(driver, expressionArea, result);

							BaseSuite.validationReportLog("Expression entered successfully");
						} else {

							BaseSuite.reportLog("Clicking on operator button");

							displayAndClick(driver, returnElement(operatorOption, "$name", result));

							BaseSuite.validationReportLog("Operator button clicked successfully");

						}

					}
				} else {
					BaseSuite.reportLog("Entering value on expression box");

					if (customExpression.contains("\\")) {
						boolean isRegex;

						try {
							java.util.regex.Pattern.compile(customExpression);

							isRegex = true;

						} catch (PatternSyntaxException e) {

							isRegex = false;
						}
						if (isRegex) {
							customExpression = customExpression.replace("\\\\", "\\");
						} else {
							customExpression = customExpression.replace("\\", "\"");
						}

					}
					sendKeys(driver, expressionArea, customExpression);

					BaseSuite.validationReportLog("Expression entered successfully");

				}
				//

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(param, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				javascript(driver, "arguments[0].scrollIntoView(true);", expressionArea);

				String customeCheck = getAttribute(driver, expressionArea, "value");

				if (customeCheck.trim().equalsIgnoreCase(customExpression)) {
					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

					BaseSuite.reportLog("Clicking on save button");

					displayAndClick(driver, check_AddCheck_btn);

					BaseSuite.validationReportLog("Save button clicked successfully");

					verifyAddedCheckOnCheckSection(checkName);

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered custom check value not match successfully,Kindly check!",
							"addCalculatedCheck");
				}

			} else {

				BaseSuite.reportFailLog("Calculated Check pane is displaye , but without UI content. Kindly check. ",
						"addCalculatedCheck");
			}

		} catch (java.lang.Exception e) {

			e.getMessage();

		}
	}

	public void updateCalculatedCheck(DataTestingParameters param, String ruleType, String jsonEntity, int checkNumber,
			String icedqRole, String workspaceId, String sourceQuery, String targetQuery) throws Exception {
		DataTestingPage dp = new DataTestingPage(driver);
		try {
			boolean flag = false;

			String checkName, checkStatus, customExpression;

			checkName = param.getChkCheckName();

			checkStatus = param.getChkStatus();

			customExpression = param.getChkExpression();

			searchCheckName(checkName);

			if (isDisplayed(driver, checkNoRecordCheckMess)) {
				flag = true;

				clickOnAddButtonSideMenu();

				validateNewCheckPane();

				chooseCheck(check_add_NewCustCheckbutton, "Custom");

			} else {
				flag = false;

				BaseSuite.reportLog("Clicking on check name");

				displayAndClick(driver, returnElement(clickOnCheckName, "$name", checkName));

				BaseSuite.validationReportLog("Check name clicked successfully");

			}

			Thread.sleep(1000);

			isDisplayed(driver, checkPaneOpenSection);

			boolean chkPane = isDisplayed(driver, checkPaneOpenSection);

			isDisplayed(driver, checkPaneNameSection);

			boolean chkTextArea = isDisplayed(driver, checkPaneNameSection);

			if ((chkPane) && (chkTextArea)) {

				dp.enterCheckName(checkName);

				dp.selectCheckEnableStatus(checkStatus);

				if (flag) {
					verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", false);

					verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				} else {
					verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

				}

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				clear(driver, expressionArea);

				// addAndValidatedAddedExpression(checkName, customExpression.trim(), chkStatus,
				// soft);
				// String val =
				// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				// customExpression);

				if (!(customExpression.contains("#") || customExpression.contains("\\")
						|| customExpression.contains("IN") || customExpression.contains("in")
						|| customExpression.contains("startsWith") || customExpression.contains("endsWith")
						|| customExpression.contains("()") || customExpression.contains("?"))) {

					String[] expVal = customExpression.split(" ");

					int count = expVal.length;

					for (int colNum = 0; colNum < count; colNum++) {

						String result = expVal[colNum];

						if (result.startsWith("S.[")) {
							WebElement ele;

							displayAndClick(driver, sourceDropdown);

							Actions action = new Actions(driver);

							ele = getElement(driver, sourceDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("S.", "");

							javascript(driver, "arguments[0].scrollIntoView(true);",
									returnElement(customSorceColumnName, "$name", col1));

							displayAndClick(driver, returnElement(customSorceColumnName, "$name", col1));

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

						} else if (result.startsWith("T.[")) {
							WebElement ele;

							displayAndClick(driver, targetDropdown);

							Actions action = new Actions(driver);

							ele = getElement(driver, targetDropdown);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);

							String col = result.replaceAll("\\[|\\]", "");

							String col1 = col.replace("T.", "");

							javascript(driver, "arguments[0].scrollIntoView(true);",
									returnElement(customTargetColumnName, "$name", col1));

							displayAndClick(driver, returnElement(customTargetColumnName, "$name", col1));

							Thread.sleep(2000);

							javascript(driver, "arguments[0].scrollIntoView(true);", ele);

							action.moveToElement(ele).doubleClick().build().perform();

							Thread.sleep(2000);
						} else if (result.matches("[A-Za-z0-9-']+")) {
							BaseSuite.reportLog("Entering value on expression box");

							sendKeys(driver, expressionArea, result);

							BaseSuite.validationReportLog("Expression entered successfully");
						} else {

							BaseSuite.reportLog("Clicking on operator button");

							displayAndClick(driver, returnElement(operatorOption, "$name", result));

							BaseSuite.validationReportLog("Operator button clicked successfully");

						}

					}
				} else {
					BaseSuite.reportLog("Entering value on expression box");

					if (customExpression.contains("\\")) {
						boolean isRegex;

						try {
							java.util.regex.Pattern.compile(customExpression);

							isRegex = true;

						} catch (PatternSyntaxException e) {

							isRegex = false;
						}
						if (isRegex) {
							customExpression = customExpression.replace("\\\\", "\\");
						} else {
							customExpression = customExpression.replace("\\", "\"");
						}

					}
					sendKeys(driver, expressionArea, customExpression);

					BaseSuite.validationReportLog("Expression entered successfully");

				}
				//

				verifyVisibilityOfButtons(driver, testExecuteButton, "Execute button", false);

				verifyVisibilityOfButtons(driver, testClearButtonBy, "Clear button", false);

				checkTestFunctionality(param, jsonEntity, icedqRole, workspaceId, sourceQuery, targetQuery);

				List<WebElement> ele = getElements(driver, testColCheck);

				if (ele.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column name is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column name is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				List<WebElement> ele1 = getElements(driver, testColCheckInputBox);

				if (ele1.size() > 0) {
					BaseSuite.validationReportLog(
							"Test functionality with source and target column input box is visible after experssion entered on expression box");

					for (int colNum = 0; colNum < ele.size(); colNum++) {
						BaseSuite.validationReportLog(ele.get(colNum).getText());

					}
				} else {
					BaseSuite.reportFailLog(
							"Test functionality with source and target column input box is not visible after experssion entered on expression box",
							"Test functionality for custom check");

				}

				dataQualityDimension(ruleType, jsonEntity, checkNumber);

				javascript(driver, "arguments[0].scrollIntoView(true);", expressionArea);

				String customeCheck = getAttribute(driver, expressionArea, "value");

				if (customeCheck.trim().equalsIgnoreCase(customExpression)) {

					BaseSuite.validationReportLog("Actual and entered custom check value match successfully");

					if (flag) {
						verifyVisibilityOfButtons(driver, check_AddCheck_btn, "Save button", true);

						verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, check_AddCheck_btn);

						BaseSuite.validationReportLog("Save button clicked successfully");
					} else {
						verifyVisibilityOfButtons(driver, check_UpdateCheck_btn, "Update", true);

						verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

						BaseSuite.reportLog("Clicking on Update button");

						displayAndClick(driver, check_UpdateCheck_btn);

						BaseSuite.validationReportLog("Update button clicked successfully");

					}

					verifyAddedCheckOnCheckSection(checkName);

				} else {
					BaseSuite.reportFailLog(
							"Actual and entered custom check value not match successfully,Kindly check!",
							"addCalculatedCheck");
				}

			} else {

				BaseSuite.reportFailLog("Calculated Check pane is displaye , but without UI content. Kindly check. ",
						"addCalculatedCheck");
			}

		} catch (java.lang.Exception e) {

			e.getMessage();

		}
	}

	public String enterDetailsInTargetDataset(String jsonEntity, DataTestingParameters param, String singleConnection,
			String workspaceid, String icedqRole, String changeQueryConn, SoftAssert soft)
			throws Exception, InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		String query = null;

		String connName;

		String schema;

		String table;

		String targetConnectionType;

		String connType = null;

		String connectionType = null;

		String fileConnectionType = null;

		String[] loginDetails = null;

		try {

			XLUtils xlReader = new XLUtils();

			if (!singleConnection.isEmpty()) {

				String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

				loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, singleConnection);

				connName = loginDetails[0];

				/*
				 * if (BaseSuite.baseURL.equals("https://qa.onprem.icedq.com")) { connName =
				 * connName + "_" + BaseSuite.WorkspaceName + "_" + "vault"; }
				 */

				schema = loginDetails[1];

				table = loginDetails[2];

				targetConnectionType = loginDetails[3];

				fileConnectionType = loginDetails[4];

			} else {
				String connID = param.getTargetConnectionID();

				String json = TestDataThroughApi.getConnectionJsonEntity(workspaceid, connID, icedqRole);

				connName = TestDataThroughApi.getConnectionNmae(json);

				fileConnectionType = TestDataThroughApi.getConnectionType(json);

				schema = param.getTargetSchema();

				table = param.getTargetTable();

				targetConnectionType = param.getTargetConnType();

				connectionType = TestDataThroughApi.getConnectionType(jsonEntity);

			}

			clickOnTargetDataset();

			selectTargetConnectionType(targetConnectionType);

			selectTargetConnection(connName);

			boolean testFlag = isEnabled(driver, targetDatasetTestButton);

			String connTestMess = "";

			if (testFlag) {
				connTestMess = testButton(targetDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			}

			if ((connTestMess.equalsIgnoreCase(connectionTestMess)) || (!isEnabled(driver, targetDatasetTestButton))) {

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", false);

				if (!targetConnectionType.equalsIgnoreCase("File")) {

					targetSelectInput(param.getTargetInput());

					if (!param.getTargetInput().equalsIgnoreCase("SQL")) {

						if (isDisplayed(driver, dataTestingTargetSchemaLabel)) {
							selectSchema(targetDatasetSchemaClick, schema);
						}

						if (!param.getTargetInput().equalsIgnoreCase("wizard")) {
							selectTable(targetDatasetTableClick, table);
							;
						}

					}

					if (param.getRuleType().equalsIgnoreCase("Recon")) {

						appendOrderBy(param.getTargetAppendOrder(), targetAppendOrderBy);

						deferredSort(targetDeferredSort, jsonExpressionTargetDeferredSort, targetColumnDelimiter,
								jsonExpressionTargetColumnDelimiter, targetRowDelimiter,
								jsonExpressionTargetRowDelimiter, targetTextQualifier,
								jsonExpressionTargetTextQualifier, jsonEntity);

					}
					if (param.getTargetInput().equalsIgnoreCase("SQL")) {
						// Thread.sleep(4000);

						query = enterDBQuery(param.getTargetInput(), targetDatasetDataQueryBox, param.getTargetQuery(),
								schema, table, changeQueryConn);

					}

					verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

					if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
						if (param.getSourceInput().equalsIgnoreCase("SQL")) {
							verifyVisibilityOfButtons(driver, copyFromSourceButton, "Copy From Source Button", true);
						}
					}

					previewData(targetgetdata);

					// verifyVisibilityOfButtons(driver, sourceDataCancelBtn, "Cancel Button",
					// true);

					verifyTableList(targetTableList);
					// my method

				} else {

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("Excel"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						selectFileType(targetDatasetSetFileType, param.getTargetFileType());

					}

					singleFile(targetSingleFileCheckbox, targetSingleFile, jsonEntity, jsonExpressionTargetSingleFile);

					String flag = parameterisedPath(targetParameterisedCheckbox, targetParameterisedPath, jsonEntity,
							jsonExpressionTargetParameterisedPath);

					String containerVal = getAttribute(driver, targetContainer, "value");

					if (!containerVal.isBlank()) {

						BaseSuite.validationReportLog("Container is not empty " + containerVal);

						isEditable(driver, targetContainer, "Container");

					} else {

						BaseSuite.reportFailLog("Container is empty,Kindly check!", "Container");
					}

					String filePath;

					if (flag.equalsIgnoreCase("true")) {

						BaseSuite.reportLog("Entering file path");

						isClickable(driver, targetSelectFile, "File path", true);

						filePath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetTargetFilePath);

						javascript(driver, "arguments[0].scrollIntoView(true);", targetSelectFile);

						displayAndClick(driver, targetSelectFile);

						clear_SendKeys(driver, targetSelectFile, filePath);

						BaseSuite.validationReportLog("File path entered successfully");

					} else {
						isClickable(driver, targetSelectFile, "File path", false);

						getFileButton(targetDatasetSetFileButton);

						if (!singleConnection.isEmpty()) {
							filePath = loginDetails[2];
						} else {
							filePath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[1].configuration.filePath");

						}

						selectFilePath(jsonEntity, filePath);

					}

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						if (param.getTargetFileType() != null
								&& param.getTargetFileType().equalsIgnoreCase("Delimited")) {

							columnDelimiter(targetColumnDelimiter, jsonEntity, jsonExpressionTargetColumnDelimiter);

							textQualifier(targetTextQualifier, jsonEntity, jsonExpressionTargetTextQualifier);

						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")) {

							rowDelimiter(targetRowDelimiter, jsonEntity, jsonExpressionTargetRowDelimiter);

							trimData(targetTrimDataCheckBox, targetTrimData, jsonEntity, jsonExpressionTargetTrimData);
						}

						skipRowTop(targetSkipRowTop, jsonEntity, jsonExpressionTargetSkipRowTop);

						fixedString(targetFixedStringValue, jsonEntity, jsonExpressionTargetfixedStringValue);

						emptyStringIsNull(targetEmptyStringisNULLCheckbox, targetEmptyStringisNULL, jsonEntity,
								jsonExpressionTargetEmptyString);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionRuleType);

						if (ruleType.contains("Recon") && fileConnectionType.equalsIgnoreCase("flat-file")) {

							caseSensitive(targetCaseSensitiveCheckBox, targetCaseSensitive, jsonEntity,
									jsonExpressionTargetCaseSensitive);

							isSorted(targetIsSortedCheckBox, targetIsSorted, jsonEntity, jsonExpressionTargetIsSorted);

						}

						if (!fileConnectionType.equalsIgnoreCase("flat-file")) {

							includeHeaders(targetIncludeHeadersCheckbox, targetIncludeHeaders, jsonEntity,
									jsonExpressionTargetIncludeHeaders);

						}

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						headerRow(targetHeaderRow, jsonEntity, jsonExpressionTargetHeaderRow);

						skipRowBottom(targetSkipRowBottom, jsonEntity, jsonExpressionTargetSkipRowBottom);

						whiteSpaceIsNull(targetWhiteSpaceisNULLCheckbox, targetWhiteSpaceisNULL, jsonEntity,
								jsonExpressionTargetWhiteSpace);

						clickOnGetSchemaButton(targetGetSchema, targetRefreshSchema, targetgetdata);

						refereshDataButton(targetRefreshSchema);

					} else {

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

							xmlTableName(jsonEntity, targetXmlTableNameText, targetXmlTableNameEdit,
									jsonExpressionTargetXmlTableName);
						}

						String id = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetXmlFileSchemaId);

						targetSelectPropertyForFileRule(workspaceid, id, icedqRole);

						if ((fileConnectionType.equalsIgnoreCase("XML") || fileConnectionType.equalsIgnoreCase("JSON")
								|| fileConnectionType.equalsIgnoreCase("Excel")
								|| (fileConnectionType.equalsIgnoreCase("parquet")))
								&& param.getRuleType().equalsIgnoreCase("Recon")) {

							appendOrderBy(param.getTargetAppendOrder(), targetAppendOrderBy);

							fileDeferredSort(targetDeferredSort, jsonEntity, jsonExpressionTargetDeferredSort);
						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

							getFileSchema(targetFileGetSchema);

							targetSaveSchema(targetSchemaSaveButton);

							javascript(driver, "arguments[0].scrollIntoView(true);", targetSchemaID);

							String schemaId = getAttribute(driver, targetSchemaID, "value");

							if (!schemaId.isBlank()) {

								BaseSuite.validationReportLog("Schema ID is not empty " + schemaId);

								isEditable(driver, targetSchemaID, "Schema Id");

							} else {

								BaseSuite.reportFailLog("Schema ID is empty,Kindly check!", "SchemaId");
							}
						}

					}

					if (param.getTargetFileType() != null && param.getTargetFileType().equalsIgnoreCase("Fixed")) {

						String fileLayout = System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\DataTesting\\FixedFileLayout.xlsx";

						XLUtils xl = new XLUtils();

						String ruleName = xl.readUsingColName(fileLayout, "Staff", 1, "FileLayout");

						fixedFileTextArea(targetFixedFileTextArea, targetFixedFileTextAreaClear, ruleName,
								fileTargetAdvanceButton, fileTargetTargetButton);

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						if (param.getRuleType().equalsIgnoreCase("Checksum")) {
							BaseSuite.reportLog("Selecting function to calculate checksum from file");

							ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									jsonEntity, "$.objects[1].configuration.columns..name");

							int count = list.size();

							if (count != 0) {

								for (int i = 0; i < count; i++) {
									String function = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
											"$.objects[1].configuration.columns[" + i + "].function");

									if (function != null) {
										String name = list.get(i);

										javascript(driver, "arguments[0].scrollIntoView(true);",
												fileTargetTargetButton);

										Thread.sleep(2000);

										displayAndClick(driver, returnElement(checksumTargetColumnName, "$name", name));

										displayAndClick(driver, returnElement(targetFunction, "$fun", function));

										BaseSuite.validationReportLog(
												"Function selected to calculate checksum from file");

										break;

									}
								}

							}

						}

						enterFilterConditionExpression(jsonEntity, targetFilterColumnOperator,
								targetFilterConditionColumnList, targetFilterConditionExpressions, param.getRuleType(),
								targetFilterConditionLable, targetOperator, soft);

						filePreviewData(targetgetdata);

					} else {

						enterTargetQueryInXmlFile(targetDatasetDataQueryBox, jsonEntity,
								jsonExpressionTargetXmlFileQuery, jsonExpressionTargetXmlFileTable);

						if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
							if (param.getTargetInput().equalsIgnoreCase("SQL")) {
								verifyVisibilityOfButtons(driver, copyFromSourceButton, "Copy From Source Button",
										true);

							}
						}

						previewData(targetgetdata);

					}
				}

			}

			else {
				BaseSuite.reportFailLog(
						"Not able to create a rule because connection details is invalid, kindly check the connection details",
						"enterDetailsInTargetDataset");
				throw new AssertionError(
						"Not able to create a rule because connection details is invalid , kindly check");
			}
		} catch (Exception e) {

			throw new Exception("");
		}
		return query;

	}

	public String enterDetailsInTargetDatasetForVault(String jsonEntity, DataTestingParameters param, String connName,
			String schema, String table, String changeQueryConn)
			throws Exception, InterruptedException, JsonMappingException, JsonProcessingException {

		String query = null;

		try {

			XLUtils xlReader = new XLUtils();

			/*
			 * if(!singleConnection.isEmpty()) {
			 * 
			 * String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
			 * 
			 * String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet,
			 * BaseSuite.TargetConnection);
			 * 
			 * connName = loginDetails[0];
			 * 
			 * schema = loginDetails[1];
			 * 
			 * table = loginDetails[2]; } else { String connID =
			 * param.getTargetConnectionID();
			 * 
			 * String json =
			 * TestDataThroughApi.getConnectionJsonEntity(workspaceid,connID,icedqRole);
			 * 
			 * connName =TestDataThroughApi.getConnectionNmae(json);
			 * 
			 * schema = param.getTargetSchema();
			 * 
			 * table = param.getTargetTable();
			 * 
			 * }
			 */

			clickOnTargetDataset();

			selectTargetConnectionType(param.getTargetConnType());

			selectTargetConnection(connName);

			targetSelectInput(param.getTargetInput());

			boolean testFlag = isEnabled(driver, targetDatasetTestButton);

			String connTestMess = "";

			if (testFlag) {
				connTestMess = testButton(targetDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			}

			if ((connTestMess.equalsIgnoreCase(connectionTestMess)) || (!isEnabled(driver, targetDatasetTestButton))) {

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", false);

				if (param.getTargetConnType().equalsIgnoreCase("Database")) {

					if (!param.getTargetInput().equalsIgnoreCase("SQL")) {

						selectSchema(targetDatasetSchemaClick, schema);

						if (!param.getTargetInput().equalsIgnoreCase("wizard")) {
							selectTable(targetDatasetTableClick, table);
							;
						}

					}

					if (param.getRuleType().equalsIgnoreCase("Recon")) {

						appendOrderBy(param.getTargetAppendOrder(), targetAppendOrderBy);

						deferredSort(targetDeferredSort, jsonExpressionTargetDeferredSort, targetColumnDelimiter,
								jsonExpressionTargetColumnDelimiter, targetRowDelimiter,
								jsonExpressionTargetRowDelimiter, targetTextQualifier,
								jsonExpressionTargetTextQualifier, jsonEntity);

					}
					if (param.getTargetInput().equalsIgnoreCase("SQL")) {
						// Thread.sleep(4000);

						query = enterDBQuery(param.getTargetInput(), targetDatasetDataQueryBox, param.getTargetQuery(),
								schema, table, changeQueryConn);

					}

					verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

					previewData(targetgetdata);

					verifyVisibilityOfButtons(driver, sourceDataCancelBtn, "Cancel Button", true);

					verifyTableList(targetTableList);
					// my method

				} else {
					/*
					 * 
					 * if (!BaseSuite.SourceConnection.toUpperCase().contains("XML")) {
					 * 
					 * selectFileType(param.getTargetFileType());
					 * 
					 * }
					 * 
					 * singleFile(targetSingleFile, jsonEntity, jsonExpressionTargetSingleFile);
					 * 
					 * String flag = parameterisedPath(targetParameterisedPath, jsonEntity,
					 * jsonExpressionTargetParameterisedPath);
					 * 
					 * if (flag.equalsIgnoreCase("true")) {
					 * BaseSuite.reportLog("Entering file path");
					 * 
					 * String filePath =
					 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					 * jsonExpressionTargetTargetFilePath);
					 * 
					 * javascript(driver, "arguments[0].scrollIntoView(true);", targetSelectFile);
					 * 
					 * clear_SendKeys(driver, targetSelectFile, filePath);
					 * 
					 * BaseSuite.validationReportLog("File path entered successfully"); } else {
					 * 
					 * getFileButton();
					 * 
					 * selectFilePath(jsonEntity, jsonExpressionTargetTargetFilePath);
					 * 
					 * }
					 * 
					 * setPropertiesButton();
					 * 
					 * if (BaseSuite.SourceConnection.toUpperCase().contains("XML")) {
					 * 
					 * 
					 * xmlXpath(jsonEntity, flag);
					 * 
					 * xmlTableName(jsonEntity, jsonExpressionXmlTableName);
					 * 
					 * clickOnGetSchemaButton();
					 * 
					 * saveSchema();
					 * 
					 * getSchemaID(jsonEntity, jsonExpressionXmlFileSchemaId);
					 * 
					 * enterQueryInXmlFile(sourceDatasetDataQueryBox, jsonEntity,
					 * jsonExpressionXmlFileQuery, jsonExpressionXmlFileTable);
					 * 
					 * previewData(sourcegetData);
					 * 
					 * }
					 * 
					 * else {
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Dilimited")) {
					 * 
					 * columnDelimiter(targetColumnDelimiter, jsonEntity,
					 * jsonExpressionTargetColumnDelimiter); }
					 * 
					 * rowDelimiter(targetRowDelimiter, jsonEntity,
					 * jsonExpressionTargetRowDelimiter);
					 * 
					 * textQualifier(targetTextQualifier, jsonEntity,
					 * jsonExpressionTargetTextQualifier);
					 * 
					 * skipRowTop(targetSkipRowTop, jsonEntity, jsonExpressionTargetSkipRowTop);
					 * 
					 * headerRow(targetHeaderRow, jsonEntity, jsonExpressionTargetHeaderRow);
					 * 
					 * skipRowBottom(targetSkipRowBottom, jsonEntity,
					 * jsonExpressionTargetSkipRowBottom);
					 * 
					 * String ruleType =
					 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					 * jsonExpressionRuleType);
					 * 
					 * if (ruleType.equalsIgnoreCase("Recon") ||
					 * ruleType.equalsIgnoreCase("Ht Recon")) {
					 * caseSensitive(TargetCaseSensitiveCheckBox, targetCaseSensitive, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * isSorted(targetIsSortedCheckBox, targetIsSorted, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * }
					 * 
					 * trimData(targetTrimDataCheckBox, targetTrimData, jsonEntity,
					 * jsonExpressionTargetTrimData);
					 * 
					 * emptyStringIsNull(targetEmptyStringisNULLCheckbox, targetWhiteSpaceisNULL,
					 * jsonEntity, jsonExpressionTargetEmptyString);
					 * 
					 * whiteSpaceIsNull(targetWhiteSpaceisNULLCheckbox, DatasetSpinner, jsonEntity,
					 * jsonExpressionTargetWhiteSpace);
					 * 
					 * fixedString(targetFixedStringCheckbox, targetFixedString,
					 * targetFixedStringValue, jsonEntity, jsonExpressionTargetFixedString,
					 * jsonExpressionTargetfixedStringValue);
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Fixed")) {
					 * 
					 * //overrideLayout(targetOverrideLayoutCheckBox, targetOverrideLayout,
					 * jsonEntity,jsonExpressionTargetOverrideLayout);
					 * 
					 * }
					 * 
					 * filePreviewData(targetgetdata);
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Dilimited")) {
					 * changeDataTypeForTargetDelimitedFile(jsonEntity);
					 * 
					 * }
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Fixed")) {
					 * 
					 * targetAddColumn(jsonEntity);
					 * 
					 * }
					 * 
					 * if (param.getRuleType().equalsIgnoreCase("Checksum")) {
					 * targetFunction(jsonEntity); }
					 * 
					 * enterFilterConditionExpression(jsonEntity, targetFilterColumnOperator,
					 * targetFilterConditionColumnList, targetFilterConditionExpressions,
					 * param.getRuleType(), soft);
					 * 
					 * refereshDataButton(targetRefereshDataButton);
					 * 
					 * fileLayoutButton(fileLayout); }
					 */}

			}

			else {
				BaseSuite.reportFailLog(
						"Not able to create a rule because connection details is invalid, kindly check the connection details",
						"enterDetailsInTargetDataset");
				throw new AssertionError(
						"Not able to create a rule because connection details is invalid , kindly check");
			}
		} catch (Exception e) {

			throw new Exception("");
		}
		return query;

	}

	public void createDBFileRules(String jsonEntity, DataTestingParameters param, String connectionName,
			DataTestingParameters xparam, String fileName, String sheetName, SoftAssert soft, String folderName,
			String icedqRole) throws Throwable {

		try {
			verifyDataTestingLandingPage();

			clickOnAddNewFolderOrExistingOne(param);

			enterDetailsInAddNewPane(param);

			// enterDetailsInAddNewPaneAPI(param, "workspaceID", icedqRole);

			// enterDetailsInOverviewSection(xparam);

			enterDetailsInAdvancedSettingOfOverviewSection(param);

			// enterDetailsInSourceSetting(jsonEntity, param, soft);

			switch (param.getRuleType().toLowerCase()) {

			case "checksum":
				// enterDetailsInTargetDataset(jsonEntity, param, soft);

				defaultStatusOfResultType_autogeneratedExp_ForCheckSumRule();

				break;
			case "recon":
			case "ht recon":

				// enterDetailsInTargetDataset(jsonEntity, param, soft);

				addJoins(param.getJoinColumnName());

				clickOnCheckNode1();

				checkdefaultstatusOfResultType(param);

				selectResultType(param);

				addNewCheckUsingExcelData(fileName, sheetName, param.getAddCheck(), soft); // add new check
				addNewCheckUsingExcelData(fileName, sheetName, param.getChk_CustExpressions(), soft); // new
																										// custom
																										// check
				addNewCheckUsingExcelData(fileName, sheetName, param.getChk_ColumnNames(), soft);// add column

				clickOnExceptionReportNode();

				// validateExceptionReportTab();
				selectExportFileFormat(param.getExceptionReportFormat(), soft);
				// enableStoreFailureAndErrorsOnly(param.getStoreFailureAndErrors(), soft);
				validateResultType(param.getResultTypes(), soft);

				validateExpressionDetailsOnExceptionReportTab(fileName, sheetName, param.getAddCheck(), soft);
				// validateExpressionDetailsOnExceptionReportTab(fileName, sheetName,
				// param.getChk_CustExpressions(), soft);
				// validateExpressionDetailsOnExceptionReportTab(fileName, sheetName,
				// param.getChk_ColumnNames(), soft);

				break;

			case "validation":
			case "ht validation":

				clickOnCheckNode1();

				checkdefaultstatusOfResultType(param);

				selectResultType(param);

				addNewCheckUsingExcelData(fileName, sheetName, param.getAddCheck(), soft);// add new check
				addNewCheckUsingExcelData(fileName, sheetName, param.getChk_CustExpressions(), soft); // new
																										// custom
																										// check
				addNewCheckUsingExcelData(fileName, sheetName, param.getChk_ColumnNames(), soft);// add column

				// clickOnCheckNode1();
				// addColumnsInChecks(param); // add column check
				clickOnExceptionReportNode();

				// validateExceptionReportTab();
				// enableStoreFailureAndErrorsOnly(param.getStoreFailureAndErrors(), soft);

				validateResultType(param.getResultTypes(), soft);

				validateExpressionDetailsOnExceptionReportTab(fileName, sheetName, param.getAddCheck(), soft);
				validateExpressionDetailsOnExceptionReportTab(fileName, sheetName, param.getChk_CustExpressions(),
						soft);
				validateExpressionDetailsOnExceptionReportTab(fileName, sheetName, param.getChk_ColumnNames(), soft);

				break;

			default:

				BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

				break;

			}
			clickOnRulePublishMenuListIconBtn();
			clickOnPublishButton();
			// clickOnRunButton();
			clickOnRecentRunTabRefreshIcon();
			// checkStatusOfRunningRule();

		} catch (Exception e) {

			throw new Exception("");
		}

	}

	public DataTestingParameters setRuleParameters(String fileName, String sheetName, int rowNumber)
			throws Exception, EncryptedDocumentException, InvalidFormatException, IOException {
		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();

		try {

			param.setSourceName(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceName"));
			param.setSourceConnType(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceConnType"));
			param.setSourceInput(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceInput"));
			param.setSourceConnection(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceConnection"));
			param.setSourceSchema(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceSchema"));
			param.setSourceTable(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceTable"));
			param.setSourceAppendOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceAppendOrder"));
			param.setSourecPath(xl.readUsingColName(fileName, sheetName, rowNumber, "SourecPath"));
			param.setSourceQuery(xl.readUsingColName(fileName, sheetName, rowNumber, "SourceQuery"));
			param.setRuleType(xl.readUsingColName(fileName, sheetName, rowNumber, "ruleType"));
			param.setTargetName(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetName"));
			param.setTargetConnType(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetConnType"));
			param.setTargetInput(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetInput"));
			param.setTargetConnection(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetConnection"));
			param.setTargetSchema(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetSchema"));
			param.setTargetTable(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetTable"));
			param.setTargetAppendOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetAppendOrder"));
			param.setTargetPath(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetPath"));
			param.setTargetQuery(xl.readUsingColName(fileName, sheetName, rowNumber, "TargetQuery"));

			// Rahul's setter
			param.setExistingFolder(xl.readUsingColName(fileName, sheetName, rowNumber, "ExistingFolder"));
			param.setFolderName(xl.readUsingColName(fileName, sheetName, rowNumber, "FolderName"));
			param.setEngineTypeOption(xl.readUsingColName(fileName, sheetName, rowNumber, "EngineTypeOption"));
			param.setRuleName(xl.readUsingColName(fileName, sheetName, rowNumber, "ruleName"));
			param.setRuleCode(xl.readUsingColName(fileName, sheetName, rowNumber, "ruleCode"));
			param.setDescription(xl.readUsingColName(fileName, sheetName, rowNumber, "description"));
			param.setPurpose(xl.readUsingColName(fileName, sheetName, rowNumber, "Purpose"));
			param.setCriticality(xl.readUsingColName(fileName, sheetName, rowNumber, "Criticality"));
			param.setEnableactiveOption(xl.readUsingColName(fileName, sheetName, rowNumber, "EnableactiveOption"));
			param.setStopAtRow(xl.readUsingColName(fileName, sheetName, rowNumber, "StopAtRow"));
			param.setStopAtError(xl.readUsingColName(fileName, sheetName, rowNumber, "StopAtError"));
			param.setStopAtTime(xl.readUsingColName(fileName, sheetName, rowNumber, "StopAtTime"));
			param.setParameterFilename(xl.readUsingColName(fileName, sheetName, rowNumber, "parameterFilename"));
			param.setDop(xl.readUsingColName(fileName, sheetName, rowNumber, "Dop"));
			param.setWorkSpaceFolder(xl.readUsingColName(fileName, sheetName, rowNumber, "WorkSpaceFolder"));
			param.setMetaDataRuleType(xl.readUsingColName(fileName, sheetName, rowNumber, "MetaDataRuleType"));
			param.setChecksName(xl.readUsingColName(fileName, sheetName, rowNumber, "ChecksName"));
			param.setChecksStatus(xl.readUsingColName(fileName, sheetName, rowNumber, "ChecksStatus"));
			param.setWarningMsg(xl.readUsingColName(fileName, sheetName, rowNumber, "WarningMsg"));
			param.setFormulaName(xl.readUsingColName(fileName, sheetName, rowNumber, "formulaName"));
			param.setFormulaoptionname(xl.readUsingColName(fileName, sheetName, rowNumber, "Formulaoptionname"));
			param.setOperatorselection(xl.readUsingColName(fileName, sheetName, rowNumber, "Operatorselection"));
			param.setFormulavalue(xl.readUsingColName(fileName, sheetName, rowNumber, "formulavalue"));
			param.setVariablename(xl.readUsingColName(fileName, sheetName, rowNumber, "variablename"));
			param.setFormulaNameSearch(xl.readUsingColName(fileName, sheetName, rowNumber, "formulaNameSearch"));
			param.setWorkflowfolderName(xl.readUsingColName(fileName, sheetName, rowNumber, "WorkflowfolderName"));

			// Neha's param
			param.setChk_SoTkeyward(xl.readUsingColName(fileName, sheetName, rowNumber, "Source/Target"));
			param.setChk_ColumnNames(xl.readUsingColName(fileName, sheetName, rowNumber, "cutomCheck_ColumnNames"));
			param.setChk_CustExpressions(xl.readUsingColName(fileName, sheetName, rowNumber, "CustomExpressions"));
			param.setResultTypes(xl.readUsingColName(fileName, sheetName, rowNumber, "resultTypes"));
			// param.setResultTypes(xl.readUsingColName(fileName, sheetName,
			// rowNumber,"recentRunInput"));

			param.setJoinColumnName(xl.readUsingColName(fileName, sheetName, rowNumber, "DiffJoin"));
			param.setAddCheck(xl.readUsingColName(fileName, sheetName, rowNumber, "AddNewCheck"));

			param.setChkExpression(xl.readUsingColName(fileName, sheetName, rowNumber, "Expression"));
			param.setChkCheckName(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckName"));
			param.setChkCheckType(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckType"));
			param.setChkColumnname(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckColumnName"));
			param.setChkDimension(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckDimension"));
			param.setChkStatus(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckStatus"));
			param.setChkTestValue1(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestValue1"));
			param.setChkTestValue2(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestValue2"));
			param.setChkTestOutput(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestOutput"));
			param.setChkOperator(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckOperator"));
			param.setChkOperatorValue1(xl.readUsingColName(fileName, sheetName, rowNumber, "Operator1"));
			param.setChkOperatorValue2(xl.readUsingColName(fileName, sheetName, rowNumber, "Operator2"));
			param.setChkTrimData(xl.readUsingColName(fileName, sheetName, rowNumber, "TrimData"));
			param.setChkEmptyStringAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "EmptyStringAsNull"));
			param.setChkWhiteSpaceAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "WhiteSpaceAsNull"));
			param.setChkFixedStringAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "FixedStringAsNull"));
			param.setChkIgnoreNulls(xl.readUsingColName(fileName, sheetName, rowNumber, "IgnoreNulls"));
			param.setNewCheckType(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckType"));
			param.setChkPatternType(xl.readUsingColName(fileName, sheetName, rowNumber, "SelectPattern"));
			param.setChkExpression(xl.readUsingColName(fileName, sheetName, rowNumber, "Expression"));
			param.setChkCheckName(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckName"));
			param.setChkCheckType(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckType"));
			param.setChkColumnname(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckColumnName"));
			param.setChkDimension(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckDimension"));
			param.setChkStatus(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckStatus"));
			param.setChkTestValue1(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestValue1"));
			param.setChkTestValue2(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestValue2"));
			param.setChkTestOutput(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckTestOutput"));
			param.setChkOperator(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckOperator"));
			param.setChkOperatorValue1(xl.readUsingColName(fileName, sheetName, rowNumber, "Operator1"));
			param.setChkOperatorValue2(xl.readUsingColName(fileName, sheetName, rowNumber, "Operator2"));
			param.setChkTrimData(xl.readUsingColName(fileName, sheetName, rowNumber, "TrimData"));
			param.setChkEmptyStringAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "EmptyStringAsNull"));
			param.setChkWhiteSpaceAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "WhiteSpaceAsNull"));
			param.setChkFixedStringAsNull(xl.readUsingColName(fileName, sheetName, rowNumber, "FixedStringAsNull"));
			param.setChkIgnoreNulls(xl.readUsingColName(fileName, sheetName, rowNumber, "IgnoreNulls"));
			param.setNewCheckType(xl.readUsingColName(fileName, sheetName, rowNumber, "CheckType"));
			param.setChkPatternType(xl.readUsingColName(fileName, sheetName, rowNumber, "SelectPattern"));

			param.setStoreFailureAndErrors(
					xl.readUsingColName(fileName, sheetName, rowNumber, "StoreFailureAndErrors"));
			param.setExceptionReportFormat(
					xl.readUsingColName(fileName, sheetName, rowNumber, "ExceptionReportFormat"));
			param.setStoreXLSX(xl.readUsingColName(fileName, sheetName, rowNumber, "StoreXlsx"));

			return param;

		} catch (Exception e) {

			throw new Exception("");
		}

	}

	public DataTestingParameters setRuleParametersForApi(String workspaceID, String jsonEntity, String icedqRole)
			throws Exception {
		DataTestingParameters param = new DataTestingParameters();
		try {
			String targetinput = "";

			param.setRuleSate(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.state"));

			param.setRuleType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.ruleType"));
			//param.setRuleType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.ruleType"));

			String ruletype = param.getRuleType();

			if (!ruletype.equalsIgnoreCase("script"))

			{

				String sourceType = param.setSourceConnType(TestDataThroughApi
						.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[0].connectionType"));

				param.setSourceConnection(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[0].connectionId"));
				/*
				 * param.setParameterFileId(
				 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				 * "$.properties.parameterId"));
				 */
				param.setSourceConnectionID(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[0].connectionId"));

				param.setSourceInput(
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[0].input"));

				String sourceinput = param.getSourceInput();

				if (!sourceinput.equalsIgnoreCase("SQL")) {

					param.setSourceSchema(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[0].configuration.schemaName"));

					param.setSourceTable(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[0].configuration.tableName"));
				}

				if (ruletype.equalsIgnoreCase("recon")) {

					param.setSourceAppendOrder(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[0].configuration.appendOrderBy"));

				}
				if (!sourceType.equalsIgnoreCase("File")) {

					if (!sourceinput.equalsIgnoreCase("Table")) {
						param.setSourceQuery(TestDataThroughApi
								.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[0].configuration.sql")
								.replaceAll("\\\\n", " "));
					}

				} else {
					param.setSourceFileType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[0].configuration.fileType"));
				}

				if (ruletype.equalsIgnoreCase("recon") || ruletype.equalsIgnoreCase("ht recon")
						|| ruletype.equalsIgnoreCase("checksum")) {

					param.setTargetConnectionID(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].connectionId"));

					String targetType = param.setTargetConnType(TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[1].connectionType"));

					param.setTargetName(
							TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[1].name"));

					param.setTargetConnType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].connectionType"));

					param.setTargetInput(
							TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[1].input"));

					targetinput = param.getTargetInput();

					if (!targetinput.equalsIgnoreCase("SQL")) {
						param.setTargetSchema(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[1].configuration.schemaName"));

						param.setTargetTable(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[1].configuration.tableName"));
					}

					if (!ruletype.equalsIgnoreCase("checksum")) {

						param.setTargetAppendOrder(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[1].configuration.appendOrderBy"));

						param.setResultType(TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[3].configuration.checks[0].expression..values"));

					}
					if (!targetType.equalsIgnoreCase("File")) {

						if (!targetinput.equalsIgnoreCase("Table")) {
							param.setTargetQuery(TestDataThroughApi
									.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.objects[1].configuration.sql")
									.replaceAll("\\\\n", " "));
						}
					} else {

						param.setTargetFileType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[1].configuration.fileType"));

					}

				} else if (ruletype.equalsIgnoreCase("validation") || ruletype.equalsIgnoreCase("pushdown")) {
					// in case of pushown/validation.

					param.setResultType(TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.checks[0].expression.values"));
					param.setResultTypes(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.checks[0].expression.values[0]"));

				}

			}

			else {
				int num = 1;

				param.setScriptConnVarName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[?(@.id=='Variable')].configuration.variables[" + num + "].name"));

				param.setScriptValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[?(@.id=='Script')].configuration.script"));

			}
			param.setEngineTypeOption(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.properties.engineType"));

			// param.setFolderName(
			// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
			// "items[5].folderName"));

			param.setFolderName(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items..folderName"));

			param.setRuleName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name"));

			param.setRuleCode(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.code"));

			param.setDescription(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.description"));

			param.setPurpose(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.purpose"));

			param.setCriticality(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.properties.criticality"));

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.customFields..field");

			for (int j = 0; j < list.size(); j++) {

				String field = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.customFields[" + j + "].field");

				if (field.equals("Severity")) {
					param.setSeverity(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.customFields[" + j + "].values"));

					break;

				}

			}

			param.setEnableactiveOption(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.isActive"));

			param.setStopAtRow(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.properties.stopAtRowCount"));

			param.setStopAtError(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.properties.stopAtFailAndErrorCount"));

			param.setStopAtTime(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.properties.stopAtTime"));

			String parameterID = (TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,

					"$.properties.parameterId"));

			String parameterName = TestDataThroughApi.getParameterName(workspaceID, parameterID, icedqRole);

			param.setParameterFilename(parameterName);

			param.setDop(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.properties.degreeOfParallelism"));

			return param;

		} catch (Exception e) {

			throw new Exception("");
		}

	}

	// refactoring add column method as per API final with testdata
	public void addColumnCheckToRuleApi(DataTestingParameters param, SoftAssert soft) throws Throwable {
		try {
			String checkName, checkStatus, checkType, colExpression;
			// set parameters
			checkType = param.getChkCheckType();
			checkName = param.getChkCheckName();
			colExpression = param.getChkExpression();
			checkStatus = param.getChkStatus();

			String colType = null, colName = null;
			// split using .

			String[] partsOfExp = colExpression.split("\\.");

			if (partsOfExp[0].equalsIgnoreCase("s")) {

				colType = "source";

			} else if (partsOfExp[0].equalsIgnoreCase("t")) {

				colType = "target";
			}

			colName = partsOfExp[1].replace("[", "").replace("]", "");

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			clickOnColumnType(colType);

			List<WebElement> ele = getElements(driver, sourceTargetColumnList);

			if (ele.size() > 0) {
				BaseSuite.validationReportLog(colType + " has total " + ele.size() + " columns,available in list.");
			} else {
				BaseSuite.reportFailLog(colType, "searchInAddColumnPane");
			}

			searchInAddColumnPane(colName);// change logic here

			verifyVisibilityOfButtons(driver, checkAddColumnSidebarAddBtn, "Add", false);

			verifyVisibilityOfButtons(driver, checkAddColumnSidebarCancelBtn, "Cancle", true);

			boolean statusL = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toLowerCase()));

			boolean statusU = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toUpperCase()));

			boolean statusCamelCase = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName));

			if (statusL) {

				selectColumnCheckboxFromList(colName.toLowerCase());

			} else if (statusU) {

				selectColumnCheckboxFromList(colName.toUpperCase());

			} else if (statusCamelCase) {

				selectColumnCheckboxFromList(colName);

			} else {

				BaseSuite.reportErrorLog("Unable to find column :: " + colName);
			}

			Thread.sleep(2000);

			verifyVisibilityOfButtons(driver, checkAddColumnSidebarAddBtn, "Add", true);

			verifyVisibilityOfButtons(driver, checkAddColumnSidebarCancelBtn, "Cancle", true);

			clickOnAddButtonInAddColumnPane();

			// validateAddedColumnListDetails(checkType, colName, colExpression, checkName,
			// soft);

			verifyAddedCheckOnCheckSection(colName);

		} catch (java.lang.Exception e) {

		}
	}

	// refactoring add column method as per API final with testdata
	public void updateColumnCheckToRuleApi(DataTestingParameters param, SoftAssert soft) throws Throwable {
		try {
			String checkName, checkStatus, checkType, colExpression;
			// set parameters
			checkType = param.getChkCheckType();
			checkName = param.getChkCheckName();
			colExpression = param.getChkExpression();
			checkStatus = param.getChkStatus();

			String colType = null, colName = null;
			// split using .

			String[] partsOfExp = colExpression.split("\\.");

			if (partsOfExp[0].equalsIgnoreCase("s")) {

				colType = "source";

			} else if (partsOfExp[0].equalsIgnoreCase("t")) {

				colType = "target";
			}

			colName = partsOfExp[1].replace("[", "").replace("]", "");

			clickOnAddButtonSideMenu();

			validateNewCheckPane();

			clickOnColumnType(colType);

			List<WebElement> ele = getElements(driver, sourceTargetColumnList);

			if (ele.size() > 0) {

				BaseSuite.validationReportLog(colType + " has total " + ele.size() + " columns,available in list.");

			} else {

				BaseSuite.reportFailLog(colType, "searchInAddColumnPane");
			}

			searchInAddColumnPane(colName);

			verifyVisibilityOfButtons(driver, checkAddColumnSidebarAddBtn, "Add", false);

			verifyVisibilityOfButtons(driver, checkAddColumnSidebarCancelBtn, "Cancle", true);

			boolean statusL = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toLowerCase()));

			boolean statusU = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toUpperCase()));

			boolean statusCamelCase = isDisplayed(driver,
					returnElement(check_addCol_sidebar_columToChoose, "$colname", colName));

			boolean flag = false;

			if (statusL) {

				String val = getAttribute(driver,
						returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toLowerCase()), "class");

				if (val.contains("check")) {
					BaseSuite.validationReportLog("Column is already checked");

					displayAndClick(driver, checkAddColumnSidebarCancelBtn);
				} else {
					selectColumnCheckboxFromList(colName.toLowerCase());

					flag = true;

				}

			} else if (statusU) {

				String val = getAttribute(driver,
						returnElement(check_addCol_sidebar_columToChoose, "$colname", colName.toUpperCase()), "class");

				if (val.contains("check")) {
					BaseSuite.validationReportLog("Column is already checked");

					displayAndClick(driver, checkAddColumnSidebarCancelBtn);
				} else {
					selectColumnCheckboxFromList(colName.toUpperCase());

					flag = true;

				}

			} else if (statusCamelCase) {

				String val = getAttribute(driver,
						returnElement(check_addCol_sidebar_columToChoose, "$colname", colName), "class");

				if (val.contains("check")) {
					BaseSuite.validationReportLog("Column is already checked");

					displayAndClick(driver, checkAddColumnSidebarCancelBtn);
				} else {
					selectColumnCheckboxFromList(colName);

					flag = true;

				}

			} else {

				BaseSuite.reportErrorLog("Unable to find column :: " + colName);
			}

			if (flag) {
				Thread.sleep(2000);

				verifyVisibilityOfButtons(driver, checkAddColumnSidebarAddBtn, "Add", true);

				verifyVisibilityOfButtons(driver, checkAddColumnSidebarCancelBtn, "Cancle", true);

				clickOnAddButtonInAddColumnPane();
			}

			// validateAddedColumnListDetails(checkType, colName, colExpression, checkName,
			// soft);

			verifyAddedCheckOnCheckSection(colName);

		} catch (java.lang.Exception e) {

		}
	}

	// searching on add column pane
	public void searchInAddColumnPane(String searchInput) throws InterruptedException {
		try {
			if (!searchInput.isEmpty()) {

				Thread.sleep(2000);

				isDisplayed(driver, check_AddCol_Sidebar_searchBox);

				if (isDisplayed(driver, check_AddCol_Sidebar_searchBox)) {
					BaseSuite.reportLog("Search box is displayed on side bar.");

					clear_Click_SendKeys(driver, 1, check_AddCol_Sidebar_searchBox, searchInput);

					BaseSuite.reportLog("Searching for " + searchInput + " side columns.");

					displayAndClick(driver, check_AddCol_Sidebar_searchBtn);

					BaseSuite.validationReportLog("Search button clicked successfully.");

					isDisplayed(driver, check_AddCol_Sidebar_srch_noOfCol);

					BaseSuite.reportLog("verifying how many columns " + searchInput + " have.");

				} else {
					BaseSuite.reportFailLog("Column search bar is not visible,Kindly check!", "searchInAddColumnPane");
				}

			} else {

				BaseSuite.reportErrorLog("Unable to search as input is null, kindly check.");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Click on add column button.
	public void clickOnAddButtonInAddColumnPane() throws Exception {
		try {

			isDisplayed(driver, checkAddColumnSidebarAddBtn);

			BaseSuite.reportLog("Add button is displayed.");

			isClickable(driver, checkAddColumnSidebarAddBtn, "Add", true);

			displayAndClick(driver, checkAddColumnSidebarAddBtn);

			BaseSuite.validationReportLog("Add button clicked successfully.");

			inVisible(driver, spinner, Constant.ruleWait);

			BaseSuite.reportLog("Spinner is displayed.");

		} catch (java.lang.Exception e) {
			throw new Exception("");
		}
	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Methods using API Testdata @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

// method to add New custom check expression of user choice.

	public void addCustomCheckExpression(String checkName, String chkExpression, String checkType, String checkStatus,
			SoftAssert soft) throws Exception {

		try {

			clickOnCheck_AddButton();

			clickOnNewCustomCheckMenuOption();

			Thread.sleep(2000);

			isDisplayed(driver, check_CustChk_headerlbl);
			boolean chkPane = isDisplayed(driver, check_CustChk_headerlbl);
			isDisplayed(driver, check_custCol_textarea);
			boolean chkTextArea = isDisplayed(driver, check_custCol_textarea);
			if ((chkPane) & (chkTextArea)) { // add
												// check
												// name
				String chkname = enterCheckName(checkName); // chooseDimensionOfCheck future option No requirement
															// currently.
				// add custom expression String chkStatus =
				selectEnableStatusCheckbox(checkStatus);

				// addAndValidatedAddedExpression(chkname,chkExpression.trim(),chkStatus,soft);

			} else {
				BaseSuite.reportFailLog("Custom Check pane is displaye , but without UI content. Kindly check. ",
						"addCustomChkExpressionToRule");
			}

		} catch (java.lang.Exception e) {
			throw new Exception("");
		}
	}

	public void validateSourceColumnNameNColumnDataType(String jsonEntity, By table, By colNameLocator,
			By dataTypeLocator) {
		try {
			BaseSuite.reportLog("Verifying the table column name and column data type");

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns..name");

			int count = list.size();

			javascript(driver, "arguments[0].scrollIntoView(true);", table);

			if (isDisplayed(driver, table)) {

				for (int i = 0; i < count; i++) {

					String colName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[0].configuration.columns[" + i + "].name");

					String colType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[0].configuration.columns[" + i + "].datatype");

					List<WebElement> listOfCol = getElements(driver, colNameLocator);

					String nameCol = listOfCol.get(i).getText().trim();

					if (colName.trim().equalsIgnoreCase(nameCol)) {

						BaseSuite.validationReportLog("Source colum name " + nameCol + " matched successfully");

					} else {

						BaseSuite.reportFailLog("Source colum name " + nameCol + " not matched",
								"validateColumnNameNColumnDataType");
					}
					List<WebElement> listOfDataType = getElements(driver, dataTypeLocator);

					String nameDataType = listOfDataType.get(i).getText().trim();

					if (colType.trim().equalsIgnoreCase(nameDataType)) {

						BaseSuite.validationReportLog("Source data type " + nameDataType + " matched successfully");

					} else {

						BaseSuite.reportFailLog("Source data type " + nameDataType + " not matched",
								"validateColumnNameNColumnDataType");
					}
				}
			} else {
				throw new AssertionError("Source/Target table column name and data type is not visible");
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void validateTargetColumnNameNColumnDataType(String jsonEntity, By table, By colNameLocator,
			By dataTypeLocator) {
		try {
			BaseSuite.reportLog("Verifying the table column name and column data type");

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[1].configuration.columns..name");

			int count = list.size();

			javascript(driver, "arguments[0].scrollIntoView(true);", table);

			if (isDisplayed(driver, table)) {

				for (int i = 0; i < count; i++) {

					String colName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.columns[" + i + "].name");

					String colType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.columns[" + i + "].datatype");

					List<WebElement> listOfCol = getElements(driver, colNameLocator);

					String nameCol = listOfCol.get(i).getText().trim();

					if (colName.trim().equalsIgnoreCase(nameCol)) {

						BaseSuite.validationReportLog("Target colum name " + nameCol + " matched successfully");

					} else {

						BaseSuite.reportFailLog("Target colum name " + nameCol + " not matched",
								"validateTargetColumnNameNColumnDataType");
					}
					List<WebElement> listOfDataType = getElements(driver, dataTypeLocator);

					String nameDataType = listOfDataType.get(i).getText().trim();

					if (colType.trim().equalsIgnoreCase(nameDataType)) {

						BaseSuite.validationReportLog("Target data type " + nameDataType + " matched successfully");

					} else {

						BaseSuite.reportFailLog("Target data type " + nameDataType + " not matched",
								"validateTargetColumnNameNColumnDataType");
					}
				}
			} else {
				throw new AssertionError("Source/Target table column name and data type is not visible");
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void subcriptionFunctionality() {

		if (isDisplayed(driver, subscribersTitle)) {

			BaseSuite.validationReportLog("Subcription title is displayed on the page");

		} else {

			BaseSuite.reportFailLog("Subcription title is not displayed on the page", "");

		}

		if (isDisplayed(driver, onSuccessTitle)) {

			BaseSuite.validationReportLog("On Success Title is displayed on the page");

		} else {

			BaseSuite.reportFailLog("On Success Title is not displayed on the page", "");

		}
		if (isDisplayed(driver, onFailureTitle)) {

			BaseSuite.validationReportLog("On Failure Title is displayed on the page");

		} else {

			BaseSuite.reportFailLog("On Failure Title is not displayed on the page", "");

		}
		if (isDisplayed(driver, onErrorTitle)) {

			BaseSuite.validationReportLog("On Error Title is displayed on the page");

		} else {

			BaseSuite.reportFailLog("On Error Title is not displayed on the page", "");

		}

	}

	public void selectSourceConnectionType(String connType) throws InterruptedException {
		try {
			if (!connType.equalsIgnoreCase("Database")) {
				BaseSuite.reportLog("Selecting connection type");

				isDisplayed(driver, sourceDatasetConnectionType);

				Thread.sleep(3000);

				isDisplayed(driver, sourceDatasetConnectionType);

				displayAndClick(driver, sourceDatasetConnectionType);

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

				isDisplayed(driver, returnElement(sourceDatasetConnectionTypeSelect, "$name", capitalize(connType)));

				displayAndClick(driver,
						returnElement(sourceDatasetConnectionTypeSelect, "$name", capitalize(connType)));

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Connection type selected successfully");
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void selectTargetConnectionType(String connType) {
		try {
			BaseSuite.reportLog("Selecting connection type");

			isDisplayed(driver, targetDatasetConnectionType);

			// Thread.sleep(3000);
			/*
			 * Actions actions = new Actions(driver);
			 * 
			 * wait = waitMethod(driver);
			 * 
			 * actions.moveToElement(driver.findElement(targetDatasetConnectionType)).
			 * perform();
			 * 
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(
			 * targetDatasetConnectionType));
			 * 
			 * actions.click(driver.findElement(targetDatasetConnectionType)).build().
			 * perform();
			 */
			displayAndClick(driver, targetDatasetConnectionType);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

			isDisplayed(driver, returnElement(sourceDatasetConnectionTypeSelect, "$name", capitalize(connType)));

			displayAndClick(driver, returnElement(sourceDatasetConnectionTypeSelect, "$name", capitalize(connType)));

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Connection type selected successfully");

			// captureToastMsg(driver, toastMsg, popUpClose, connectionTypeMess, "Connection
			// Type");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void sourceSelectInput(String input) {
		try {

			BaseSuite.reportLog("Clicking on " + input + " Input radio button");

			if (input.equalsIgnoreCase("Table")) {
				displayAndClick(driver, dafaultInput);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				isClickable(driver, sourceDatasetSchemaClick, input, true);

				isClickable(driver, sourceDatasetTableClick, input, true);
			} else if (input.equalsIgnoreCase("sql")) {
				displayAndClick(driver, sQLInput);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				isClickable(driver, sourceDatasetSchemaClick, input, false);

				isClickable(driver, sourceDatasetTableClick, input, false);
			} else {
				displayAndClick(driver, wizardInput);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				isClickable(driver, sourceDatasetSchemaClick, input, true);

				isClickable(driver, sourceDatasetTableClick, input, false);
			}

			BaseSuite.validationReportLog(input + " Input radio button clicked successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void targetSelectInput(String input) {
		try {

			BaseSuite.reportLog("Clicking on " + input + " Input radio button");

			if (input.equalsIgnoreCase("Table")) {
				displayAndClick(driver, targetDafaultInput);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				isClickable(driver, targetDatasetSchemaClick, input, true);

				isClickable(driver, targetDatasetTableClick, input, true);
			} else if (input.equalsIgnoreCase("sql")) {
				displayAndClick(driver, targetSQLInput);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				isClickable(driver, targetDatasetSchemaClick, input, false);

				isClickable(driver, targetDatasetTableClick, input, false);
			} else {
				displayAndClick(driver, targetWizardInput);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				isClickable(driver, targetDatasetSchemaClick, input, true);

				isClickable(driver, targetDatasetTableClick, input, false);
			}

			BaseSuite.validationReportLog(input + " Input radio button clicked successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// Method to click on cancelButton on executionLog dialogue box
	public void clickOnCancelBtnOfExecutionLog() {
		try {
			verifyVisibilityOfButtons(driver, recentRun_ExecutionLog_DownloadBtn, "Download", true);

			verifyVisibilityOfButtons(driver, recentRun_ExecutionLog_CopyBtn, "Copy", true);

			if (verifyVisibilityOfButtons(driver, recentRun_ExecutionLog_closeBtn, "Cancel", true)) {

				displayAndClick(driver, recentRun_ExecutionLog_closeBtn);

				displayAndClick(driver, recentRun_ExecutionLog_closeBtn);

				BaseSuite.validationReportLog("Successfully clicked on cancel button.");
			} else {

				BaseSuite.reportFailLog("unable to find cancel button on execution log screen, kindly check",
						"clickOnCancelBtnOfExecutionLog");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void xmlTableName(String jsonEntity, By tableValue, By editButton, String expression)
			throws InterruptedException {
		try {
			Thread.sleep(2000);

			javascript(driver, "arguments[0].scrollIntoView(true);", tableValue);

			String tableName = getText(driver, tableValue);

			String nameTable = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			if (tableName.contains("tblname_")) {

				BaseSuite.validationReportLog("Table name present on table name field");

			} else {

				BaseSuite.reportLog("Entering Table name on table name field");

				displayAndClick(driver, editButton);

				clear_SendKeys(driver, xmlTableName, nameTable);

				verifyVisibilityOfButtons(driver, xmlTableCancelButton, "Cancel Button", true);

				displayAndClick(driver, xmlTableSaveButton);

				BaseSuite.validationReportLog("Table name field entered successfully");
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void getFileSchema(By locator) {
		try {

			if (isDisplayed(driver, locator)) {
				BaseSuite.reportLog("Clicking to get file schema");

				displayAndClick(driver, locator);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Get file schema clicked successfully");

				if (isDisplayed(driver, toastMsgCon)) {

					throw new Exception("Facing issues with the file schema,Kindly check!");
				}

			} else {
				BaseSuite.reportFailLog("Gey file schema button is no enable,Kindly check!", "getFileSchema");
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void readPropertyForFileRule(String workspaceID, String schemaID, String icedqRole) {

		String json = TestDataThroughApi.getFileRuleSchemaJson(workspaceID, schemaID, icedqRole);

		ArrayList<String> jsonList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(json,
				"$.schemaInfo.properties..key");

		for (int i = 0; i < jsonList.size(); i++) {
			String jsonVal = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
					"$.schemaInfo.properties[" + i + "].key");

		}

	}

	public void sourceSelectPropertyForFileRule(String workspaceID, String schemaID, String icedqRole)
			throws InterruptedException {
		try {
			boolean executeFlag = false;

			String val = null;

			String propertyValue = null;

			javascript(driver, "arguments[0].scrollIntoView(true);", addPropertyButton);

			String json = TestDataThroughApi.getFileRuleSchemaJson(workspaceID, schemaID, icedqRole);

			ArrayList<String> jsonList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(json,
					"$.schemaInfo.properties..key");

			List<WebElement> list = getElements(driver, defaultPropertyList);

			List<String> webelementList = new ArrayList<String>();

			for (WebElement e : list) {

				webelementList.add(e.getText());
			}

			for (int i = 0; i < jsonList.size(); i++) {
				String jsonVal = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[" + i + "].key");

				if (!jsonVal.equalsIgnoreCase("XPath")) {

					boolean flag = webelementList.contains("Table Name");

					int j;

					if (flag) {
						j = i + 1;
					} else {
						j = i;
					}

					int count = list.size();

					if (j < count) {

						val = list.get(j).getText();
					}

					if (jsonVal.equalsIgnoreCase(val)) {

						javascript(driver, "arguments[0].scrollIntoView(true);",
								returnElement(xmlTypeDetectionSchemeEdit, "$name", val));

						verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
								"Edit Button", true);

						String att = getAttribute(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"class");

						if (att.contains("disabled")) {
							BaseSuite.validationReportLog("Delete button is disabled");
						} else {
							BaseSuite.reportFailLog("Delete button is enable for default property,Kindly check!",
									"sourceSelectPropertyForFileRule");
						}

						BaseSuite.reportLog("Clicking on edit button");

						displayAndClick(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val));

						BaseSuite.validationReportLog("Edit button clicked successfully");

						propertyValue = jsonVal;

						executeFlag = true;

					} else {

						BaseSuite.reportLog("Clicking on Add property button");

						displayAndClick(driver, addPropertyButton);

						BaseSuite.validationReportLog("Add property button clicked successfully");

						BaseSuite.reportLog("Selecting dropdown value from list");

						displayAndClick(driver, propertyDropdown);

						Thread.sleep(2000);

						List<WebElement> addedPropertyList = getElements(driver, propertyDropdownList);

						List<String> finalStrings = new ArrayList<String>();

						for (WebElement e : addedPropertyList) {

							finalStrings.add(e.getText());
						}

						finalStrings.retainAll(jsonList);

						if (!finalStrings.isEmpty()) {

							for (int k = 0; k <= finalStrings.size(); k++) {

								String text = finalStrings.get(k);

								propertyValue = text;

								displayAndClick(driver, returnElement(propertyDropdownValue, "$name", propertyValue));

								BaseSuite.validationReportLog("Dropdown value selected successfully");

								executeFlag = true;

								break;

							}
						} else {

							displayAndClick(driver, xmlTableCancelButton);

							executeFlag = false;

							break;

						}

					}

					if (executeFlag) {

						BaseSuite.reportLog("Entering property value");

						String value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
								"$.schemaInfo.properties[?(@.key=='" + propertyValue + "')].value");

						displayAndClick(driver, typeDetectionSchemeDefaultValue);

						clear_SendKeys(driver, typeDetectionSchemeDefaultValue, value);

						BaseSuite.validationReportLog("Property value entered successfully");

						verifyVisibilityOfButtons(driver, xmlTableSaveButton, "Save Button", true);

						verifyVisibilityOfButtons(driver, xmlTableCancelButton, "Cancle Button", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, xmlTableSaveButton);

						BaseSuite.validationReportLog("Save button clicked successfully");

						verifyVisibilityOfButtons(driver, addPropertyButton, "Add Property", true);

						verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
								"Edit Button", true);

						if (jsonVal.equalsIgnoreCase(val)) {

							String att = getAttribute(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
									"class");

							if (att.contains("disabled")) {
								BaseSuite.validationReportLog("Delete button is disabled");
							} else {
								BaseSuite.reportFailLog("Delete button is enable for default property,Kindly check!",
										"sourceSelectPropertyForFileRule");
							}

						} else {

							verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
									"Delete Button", true);

						}

					}

				} else {
					xmlXpath(json, "$.schemaInfo.properties[?(@.key=='XPath')].value");
				}

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void targetSelectPropertyForFileRule(String workspaceID, String schemaID, String icedqRole)
			throws InterruptedException {
		try {
			boolean executeFlag = false;

			String val = null;

			String propertyValue = null;

			javascript(driver, "arguments[0].scrollIntoView(true);", targetAddPropertyButton);

			String json = TestDataThroughApi.getFileRuleSchemaJson(workspaceID, schemaID, icedqRole);

			ArrayList<String> jsonList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(json,
					"$.schemaInfo.properties..key");

			List<WebElement> list = getElements(driver, targetDefaultPropertyList);

			List<String> webelementList = new ArrayList<String>();

			for (WebElement e : list) {

				webelementList.add(e.getText());
			}

			for (int i = 0; i < jsonList.size(); i++) {
				String jsonVal = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[" + i + "].key");

				if (!jsonVal.equalsIgnoreCase("XPath")) {

					boolean flag = webelementList.contains("Table Name");

					int j;

					if (flag) {
						j = i + 1;
					} else {
						j = i;
					}

					int count = list.size();

					if (j < count) {

						val = list.get(j).getText();
					}

					if (jsonVal.equalsIgnoreCase(val)) {

						javascript(driver, "arguments[0].scrollIntoView(true);",
								returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val));

						verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
								"Edit Button", true);

						String att = getAttribute(driver,
								returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val), "class");

						if (att.contains("disabled")) {
							BaseSuite.validationReportLog("Delete button is disabled");
						} else {
							BaseSuite.reportFailLog("Delete button is enable for default property,Kindly check!",
									"sourceSelectPropertyForFileRule");
						}

						BaseSuite.reportLog("Clicking on edit button");

						displayAndClick(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val));

						BaseSuite.validationReportLog("Edit button clicked successfully");

						propertyValue = jsonVal;

						executeFlag = true;

					} else {

						BaseSuite.reportLog("Clicking on Add property button");

						displayAndClick(driver, targetAddPropertyButton);

						BaseSuite.validationReportLog("Add property button clicked successfully");

						BaseSuite.reportLog("Selecting dropdown value from list");

						displayAndClick(driver, propertyDropdown);

						Thread.sleep(2000);

						List<WebElement> addedPropertyList = getElements(driver, propertyDropdownList);

						List<String> finalStrings = new ArrayList<String>();

						for (WebElement e : addedPropertyList) {

							finalStrings.add(e.getText());
						}

						finalStrings.retainAll(jsonList);

						if (!finalStrings.isEmpty()) {

							for (int k = 0; k <= finalStrings.size(); k++) {

								String text = finalStrings.get(k);

								propertyValue = text;

								displayAndClick(driver, returnElement(propertyDropdownValue, "$name", propertyValue));

								BaseSuite.validationReportLog("Dropdown value selected successfully");

								executeFlag = true;

								break;

							}
						} else {

							displayAndClick(driver, xmlTableCancelButton);

							executeFlag = false;

							break;

						}

					}

					if (executeFlag) {

						BaseSuite.reportLog("Entering property value");

						String value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
								"$.schemaInfo.properties[?(@.key=='" + propertyValue + "')].value");

						displayAndClick(driver, typeDetectionSchemeDefaultValue);

						clear_SendKeys(driver, typeDetectionSchemeDefaultValue, value);

						BaseSuite.validationReportLog("Property value entered successfully");

						verifyVisibilityOfButtons(driver, xmlTableSaveButton, "Save Button", true);

						verifyVisibilityOfButtons(driver, xmlTableCancelButton, "Cancle Button", true);

						BaseSuite.reportLog("Clicking on save button");

						displayAndClick(driver, xmlTableSaveButton);

						BaseSuite.validationReportLog("Save button clicked successfully");

						verifyVisibilityOfButtons(driver, targetAddPropertyButton, "Add Property", true);

						verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
								"Edit Button", true);

						if (jsonVal.equalsIgnoreCase(val)) {

							String att = getAttribute(driver,
									returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val), "class");

							if (att.contains("disabled")) {
								BaseSuite.validationReportLog("Delete button is disabled");
							} else {
								BaseSuite.reportFailLog("Delete button is enable for default property,Kindly check!",
										"sourceSelectPropertyForFileRule");
							}

						} else {

							verifyVisibilityOfButtons(driver,
									returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val), "Delete Button",
									true);

						}

					}

				} else {
					xmlXpath(json, "$.schemaInfo.properties[?(@.key=='XPath')].value");
				}

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void sourceReadPropertyForFileRule(String workspaceID, String schemaID, String icedqRole, String connType)
			throws InterruptedException {

		javascript(driver, "arguments[0].scrollIntoView(true);", addPropertyButton);

		String json = TestDataThroughApi.getFileRuleSchemaJson(workspaceID, schemaID, icedqRole);

		ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(json,
				"$.schemaInfo.properties..key");

		for (int i = 0; i < list.size(); i++) {

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
					"$.schemaInfo.properties[" + i + "].key");

			int j = i + 2;

			// String val2 =
			// driver.findElement(By.xpath("//table[@id='gridProperties_content_table']//tr["+j+"]//td[1]")).getText();

			boolean flag = isDisplayed(driver,
					By.xpath("//table[@id='gridProperties_content_table']//tr[" + j + "]//td[1]"));

			String value;

			String defaultName;

			String propertyValue;

			if (flag) {

				switch (val) {

				case "TypeDetectionScheme":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule TypeDetectionScheme property name is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule TypeDetectionScheme property name is not disabled",
								"TypeDetectionScheme");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='TypeDetectionScheme')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule TypeDetectionScheme property value is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule TypeDetectionScheme property value is not disabled",
								"TypeDetectionScheme");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					if (connType.equalsIgnoreCase("flat-file-sql")) {

						String output = getAttribute(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"class");

						if (output.contains("disabled")) {
							BaseSuite.validationReportLog(
									"After revisiting the rule Delete button is disable for default property");
						} else {
							BaseSuite.reportFailLog(
									"After revisiting the rule Delete button is not disable for default property",
									"Delete Button");
						}

					} else {
						verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"Delete Button", true);

					}

					break;

				case "DataModel":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog("After revisiting the rule DataModel property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule DataModel property name is not disabled",
								"DataModel");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='DataModel')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog("After revisiting the rule DataModel property value is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule DataModel property value is not disabled",
								"DataModel");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					if (connType.equalsIgnoreCase("XML") || connType.equalsIgnoreCase("json")) {
						String output = getAttribute(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"class");

						if (output.contains("disabled")) {
							BaseSuite.validationReportLog(
									"After revisiting the rule Delete button is disable for default property");
						} else {
							BaseSuite.reportFailLog(
									"After revisiting the rule Delete button is not disable for default property",
									"Delete Button");
						}
					} else {
						verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"Delete Button", true);

					}

					break;

				case "Charset":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog("After revisiting the rule Charset property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule Charset property name is not disabled",
								"Charset");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='Charset')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog("After revisiting the rule Charset property value is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule Charset property value is not disabled",
								"Charset");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "RowScanDepth":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule RowScanDepth property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule RowScanDepth property name is not disabled",
								"RowScanDepth");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='RowScanDepth')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule RowScanDepth property value is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule RowScanDepth property value is not disabled",
								"RowScanDepth");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "SkipHeaderComments":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule SkipHeaderComments property name is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule SkipHeaderComments property name is not disabled",
								"SkipHeaderComments");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='SkipHeaderComments')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule SkipHeaderComments property value is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule SkipHeaderComments property value is not disabled",
								"SkipHeaderComments");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "Timeout":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog("After revisiting the rule Timeout property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule Timeout property name is not disabled",
								"Timeout");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='Timeout')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog("After revisiting the rule Timeout property value is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule Timeout property value is not disabled",
								"Timeout");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "FlattenArrays":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule FlattenArrays property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule FlattenArrays property name is not disabled",
								"FlattenArrays");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='FlattenArrays')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule FlattenArrays property value is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule FlattenArrays property value is not disabled",
								"FlattenArrays");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "FlattenObjects":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule FlattenObjects property name is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule FlattenObjects property name is not disabled",
								"FlattenObjects");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='FlattenObjects')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule FlattenObjects property value is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule FlattenObjects property value is not disabled",
								"FlattenObjects");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "PushAttributes":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule PushAttributes property name is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule PushAttributes property name is not disabled",
								"PushAttributes");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='PushAttributes')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog(
								"After revisiting the rule PushAttributes property value is disabled");

					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule PushAttributes property value is not disabled",
								"PushAttributes");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				case "XMLFormat":

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog("After revisiting the rule XMLFormat property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule XMLFormat property name is not disabled",
								"XMLFormat");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='XMLFormat')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite.validationReportLog("After revisiting the rule XMLFormat property value is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule XMLFormat property value is not disabled",
								"XMLFormat");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

					break;

				default:

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					defaultName = getText(driver,
							returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

					if (defaultName.equalsIgnoreCase(val)) {

						BaseSuite.validationReportLog("After revisiting the rule JSONFormat property name is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule JSONFormat property name is not disabled",
								"JSONFormat");

					}

					value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
							"$.schemaInfo.properties[?(@.key=='JSONFormat')].value");

					propertyValue = getText(driver, returnElement(defaultPropertyValueText, "$name", val));

					if (value.equalsIgnoreCase(propertyValue)) {

						BaseSuite
								.validationReportLog("After revisiting the rule JSONFormat property value is disabled");

					} else {
						BaseSuite.reportFailLog("After revisiting the rule JSONFormat property value is not disabled",
								"JSONFormat");

					}

					verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeEdit, "$name", val),
							"Edit Button", true);

					if (connType.equalsIgnoreCase("XML") || connType.equalsIgnoreCase("json")) {
						String output = getAttribute(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"class");

						if (output.contains("disabled")) {
							BaseSuite.validationReportLog(
									"After revisiting the rule Delete button is disable for default property");
						} else {
							BaseSuite.reportFailLog(
									"After revisiting the rule Delete button is not disable for default property",
									"Delete Button");
						}
					} else {
						verifyVisibilityOfButtons(driver, returnElement(xmlTypeDetectionSchemeDelete, "$name", val),
								"Delete Button", true);

					}

					break;

				}

			}
		}

		verifyVisibilityOfButtons(driver, addPropertyButton, "Add Property", true);
	}

	public void targetReadPropertyForFileRule(String workspaceID, String schemaID, String icedqRole, String connType)
			throws InterruptedException {

		javascript(driver, "arguments[0].scrollIntoView(true);", targetAddPropertyButton);

		String json = TestDataThroughApi.getFileRuleSchemaJson(workspaceID, schemaID, icedqRole);

		ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(json,
				"$.schemaInfo.properties..key");

		for (int i = 0; i < list.size(); i++) {

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
					"$.schemaInfo.properties[" + i + "].key");

			int j = i + 2;
			String value;

			String defaultName;

			String propertyValue;

			switch (val) {

			case "TypeDetectionScheme":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog(
							"After revisiting the rule TypeDetectionScheme property name is disabled");

				} else {
					BaseSuite.reportFailLog(
							"After revisiting the rule TypeDetectionScheme property name is not disabled",
							"TypeDetectionScheme");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='TypeDetectionScheme')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog(
							"After revisiting the rule TypeDetectionScheme property value is disabled");

				} else {
					BaseSuite.reportFailLog(
							"After revisiting the rule TypeDetectionScheme property value is not disabled",
							"TypeDetectionScheme");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				if (connType.equalsIgnoreCase("flat-file-sql")) {
					String output = getAttribute(driver,
							returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val), "class");

					if (output.contains("disabled")) {
						BaseSuite.validationReportLog(
								"After revisiting the rule Delete button is disable for default property");
					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule Delete button is not disable for default property",
								"Delete Button");
					}
				} else {
					verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

				}

				break;

			case "DataModel":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(i), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule DataModel property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule DataModel property name is not disabled",
							"DataModel");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='DataModel')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule DataModel property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule DataModel property value is not disabled",
							"DataModel");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				if (connType.equalsIgnoreCase("XML") || connType.equalsIgnoreCase("json")) {

					String output = getAttribute(driver,
							returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val), "class");

					if (output.contains("disabled")) {
						BaseSuite.validationReportLog(
								"After revisiting the rule Delete button is disable for default property");
					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule Delete button is not disable for default property",
								"Delete Button");
					}

				} else {
					verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

				}

				break;

			case "Charset":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule Charset property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule Charset property name is not disabled",
							"Charset");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='Charset')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule Charset property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule Charset property value is not disabled",
							"Charset");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "RowScanDepth":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule RowScanDepth property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule RowScanDepth property name is not disabled",
							"RowScanDepth");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='RowScanDepth')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule RowScanDepth property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule RowScanDepth property value is not disabled",
							"RowScanDepth");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "SkipHeaderComments":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog(
							"After revisiting the rule SkipHeaderComments property name is disabled");

				} else {
					BaseSuite.reportFailLog(
							"After revisiting the rule SkipHeaderComments property name is not disabled",
							"SkipHeaderComments");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='SkipHeaderComments')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog(
							"After revisiting the rule SkipHeaderComments property value is disabled");

				} else {
					BaseSuite.reportFailLog(
							"After revisiting the rule SkipHeaderComments property value is not disabled",
							"SkipHeaderComments");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "Timeout":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule Timeout property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule Timeout property name is not disabled",
							"Timeout");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='Timeout')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule Timeout property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule Timeout property value is not disabled",
							"Timeout");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "FlattenArrays":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule FlattenArrays property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule FlattenArrays property name is not disabled",
							"FlattenArrays");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='FlattenArrays')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule FlattenArrays property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule FlattenArrays property value is not disabled",
							"FlattenArrays");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "FlattenObjects":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule FlattenObjects property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule FlattenObjects property name is not disabled",
							"FlattenObjects");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='FlattenObjects')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite
							.validationReportLog("After revisiting the rule FlattenObjects property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule FlattenObjects property value is not disabled",
							"FlattenObjects");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "PushAttributes":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule PushAttributes property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule PushAttributes property name is not disabled",
							"PushAttributes");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='PushAttributes')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite
							.validationReportLog("After revisiting the rule PushAttributes property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule PushAttributes property value is not disabled",
							"PushAttributes");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			case "XMLFormat":

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule XMLFormat property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule XMLFormat property name is not disabled",
							"XMLFormat");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='XMLFormat')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule XMLFormat property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule XMLFormat property value is not disabled",
							"XMLFormat");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
						"Delete Button", true);

				break;

			default:

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnTwoElements(defaultPropertyText, "$num", Integer.toString(j), "$name", val));

				defaultName = getText(driver,
						returnTwoElements(targetDefaultPropertyText, "$num", Integer.toString(j), "$name", val));

				if (defaultName.equalsIgnoreCase(val)) {

					BaseSuite.validationReportLog("After revisiting the rule JSONFormat property name is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule JSONFormat property name is not disabled",
							"JSONFormat");

				}

				value = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json,
						"$.schemaInfo.properties[?(@.key=='JSONFormat')].value");

				propertyValue = getText(driver, returnElement(targetDefaultPropertyValueText, "$name", val));

				if (value.equalsIgnoreCase(propertyValue)) {

					BaseSuite.validationReportLog("After revisiting the rule JSONFormat property value is disabled");

				} else {
					BaseSuite.reportFailLog("After revisiting the rule JSONFormat property value is not disabled",
							"JSONFormat");

				}

				verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeEdit, "$name", val),
						"Edit Button", true);

				if (connType.equalsIgnoreCase("XML") || connType.equalsIgnoreCase("json")) {
					String output = getAttribute(driver,
							returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val), "class");

					if (output.contains("disabled")) {
						BaseSuite.validationReportLog(
								"After revisiting the rule Delete button is disable for default property");
					} else {
						BaseSuite.reportFailLog(
								"After revisiting the rule Delete button is not disable for default property",
								"Delete Button");
					}
				} else {
					verifyVisibilityOfButtons(driver, returnElement(targetXmlTypeDetectionSchemeDelete, "$name", val),
							"Delete Button", true);

				}

				break;

			}

		}

		verifyVisibilityOfButtons(driver, targetAddPropertyButton, "Add Property", true);
	}

	public void clickOnGetSchemaButton(By generateSchema, By refreshSchema, By previewData)
			throws InterruptedException {
		try {
			BaseSuite.reportLog("Clicking on Get Schema button");

			javascript(driver, "arguments[0].scrollIntoView(true);", generateSchema);

			Thread.sleep(3000);

			verifyVisibilityOfButtons(driver, generateSchema, "Get Schema", true);

			displayAndClick(driver, generateSchema);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Get Schema button clicked successfully");

			verifyVisibilityOfButtons(driver, refreshSchema, "Refresh Schema", true);

			verifyVisibilityOfButtons(driver, previewData, "Preview Data", true);

			verifyFileTableList();

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void clickOnSetSQLButton() {
		try {
			BaseSuite.reportLog("Clicking on Set SQL button");

			displayAndClick(driver, setSqlButton);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Set SQL button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void clickOnResetButton() {
		try {
			BaseSuite.reportLog("Clicking on Reset button");

			displayAndClick(driver, resetButton);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Reset button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void clickOnViewSchemaButton() {
		try {
			BaseSuite.reportLog("Clicking on view Schema button");

			displayAndClick(driver, veiwSchema);

			BaseSuite.validationReportLog("view Schema button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void getSchemaID(String jsonEntity, String expression) {
		try {

			XLUtils xlReader = new XLUtils();

			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, BaseSuite.SourceConnection);

			String connName = loginDetails[0];

			String schema = loginDetails[1];

			String table = loginDetails[2];

			javascript(driver, "arguments[0].scrollIntoView(true);", schemaID);

			String id = getAttribute(driver, schemaID, "value");

			isEditable(driver, checkNameLocator, "Schema ID: " + id);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void saveSchema(By locator) throws InterruptedException {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetButton);

			// verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", false);

			BaseSuite.reportLog("Clicking on save Schema button");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			Thread.sleep(2000);

			displayAndClick(driver, locator);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("save Schema button clicked successfully");

			captureToastMsg(driver, toastMsgCon, popUpClose, ruleSuccessMsg, "After clicking Schema button");

			javascript(driver, "arguments[0].scrollIntoView(true);", sourcegetData);

			verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void targetSaveSchema(By locator) throws InterruptedException {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetButton);

			// verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", false);

			BaseSuite.reportLog("Clicking on save Schema button");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			Thread.sleep(2000);

			displayAndClick(driver, locator);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("save Schema button clicked successfully");

			javascript(driver, "arguments[0].scrollIntoView(true);", sourcegetData);

			verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void enterDetailInXmlRule(String jsonEntity, String expression) {
		try {
			// xmlTableName(jsonEntity, expression);
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public String enterDetailsInSourceSetting(String jsonEntity, DataTestingParameters param, String singleConnection,
			String workspaceid, String icedqRole, String changeQueryConn, SoftAssert soft) throws Throwable {

		String query = null;

		String connName;

		String schema;

		String table;

		String sourceConnectionType;

		String connType = null;

		String connectionType = null;

		String fileConnectionType = null;

		String[] loginDetails = null;

		try {

			XLUtils xlReader = new XLUtils();

			if (!singleConnection.isEmpty()) {

				String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

				loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, singleConnection);

				connName = loginDetails[0];

				/*
				 * if (BaseSuite.baseURL.equals("https://qa.onprem.icedq.com")) { connName =
				 * connName + "_" + BaseSuite.WorkspaceName + "_" + "vault"; }
				 */
				 
				schema = loginDetails[1];

				table = loginDetails[2];

				sourceConnectionType = loginDetails[3];

				fileConnectionType = loginDetails[4];

			} else {

				String connID = param.getSourceConnectionID();

				String json = TestDataThroughApi.getConnectionJsonEntity(workspaceid, connID, icedqRole);

				connName = TestDataThroughApi.getConnectionNmae(json);

				fileConnectionType = TestDataThroughApi.getConnectionType(json);

				schema = param.getSourceSchema();

				table = param.getSourceTable();

				sourceConnectionType = param.getSourceConnType().trim();

				connectionType = TestDataThroughApi.getConnectionType(jsonEntity);
			}

			clickOnSourceDataset();

			selectSourceConnectionType(sourceConnectionType);

			selectSourceConnection(connName);

			boolean testFlag = isEnabled(driver, sourceDatasetTestButton);

			String connTestMess = "";

			if (testFlag) {
				connTestMess = testButton(sourceDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			}

			if ((connTestMess.equalsIgnoreCase(connectionTestMess)) || (!isEnabled(driver, sourceDatasetTestButton))) {

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", false);

				if (!sourceConnectionType.equalsIgnoreCase("File")) {

					sourceSelectInput(param.getSourceInput());

					if (!param.getSourceInput().equalsIgnoreCase("SQL")) {

						if (isDisplayed(driver, dataTestingSchemaLabel)) {
							selectSchema(sourceDatasetSchemaClick, schema);

						}

						if (!param.getSourceInput().equalsIgnoreCase("wizard")) {

							Thread.sleep(2000);

							selectTable(sourceDatasetTableClick, table);
						}

					}

					if (param.getRuleType().equalsIgnoreCase("Recon")) {

						if (!fileConnectionType.equalsIgnoreCase("AtScale")) {
							appendOrderBy(param.getSourceAppendOrder(), sourceAppendOrderBy);

						}

						deferredSort(sourceDeferredSort, jsonExpressionSourceDeferredSort, sourceColumnDelimiter,
								jsonExpressionSourceColumnDelimiter, sourceRowDelimiter,
								jsonExpressionSourceRowDelimiter, sourceTextQualifier,
								jsonExpressionSourceTextQualifier, jsonEntity);

					}
					if (param.getSourceInput().equalsIgnoreCase("SQL")) {

						query = enterDBQuery(param.getSourceInput(), sourceDatasetDataQueryBox, param.getSourceQuery(),
								schema, table, changeQueryConn);

					}

					verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

					if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
						if (param.getSourceInput().equalsIgnoreCase("SQL")) {
							verifyVisibilityOfButtons(driver, copyFromTargetButton, "Copy From Target Button", true);
						}
					}

					previewData(sourcegetData);

					// verifyVisibilityOfButtons(driver, sourceDataCancelBtn, "Cancel Button",
					// true);

					verifyTableList(sourceTableList);

				} else {

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("Excel"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						selectFileType(sourceDatasetSetFileType, param.getSourceFileType());

					}

					singleFile(sourceSingleFileCheckbox, sourceSingleFile, jsonEntity, jsonExpressionSourceSingleFile);

					String flag = parameterisedPath(sourceParameterisedCheckbox, sourceParameterisedPath, jsonEntity,
							jsonExpressionSourceParameterisedPath);

					String containerVal = getAttribute(driver, sourceContainer, "value");

					if (!containerVal.isBlank()) {

						BaseSuite.validationReportLog("Container is not empty " + containerVal);

						isEditable(driver, sourceContainer, "Container");

					} else {

						BaseSuite.reportFailLog("Container is empty,Kindly check!", "Container");
					}

					String filePath;

					if (flag.equalsIgnoreCase("true")) {

						BaseSuite.reportLog("Entering file path");

						isClickable(driver, sourceSelectFile, "File path", true);

						filePath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceFilePath);

						javascript(driver, "arguments[0].scrollIntoView(true);", sourceSelectFile);

						displayAndClick(driver, sourceSelectFile);

						clear_SendKeys(driver, sourceSelectFile, filePath);

						BaseSuite.validationReportLog("File path entered successfully");

					} else {
						isClickable(driver, sourceSelectFile, "File path", false);

						getFileButton(sourceDatasetSetFileButton);

						if (!singleConnection.isEmpty()) {
							filePath = loginDetails[2];
						} else {
							filePath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[0].configuration.filePath");

						}

						selectFilePath(jsonEntity, filePath);

					}

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						if (param.getSourceFileType() != null
								&& param.getSourceFileType().equalsIgnoreCase("Delimited")) {

							columnDelimiter(sourceColumnDelimiter, jsonEntity, jsonExpressionSourceColumnDelimiter);

							textQualifier(sourceTextQualifier, jsonEntity, jsonExpressionSourceTextQualifier);

						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")) {
							rowDelimiter(sourceRowDelimiter, jsonEntity, jsonExpressionSourceRowDelimiter);

							trimData(sourceTrimDataCheckBox, sourceTrimData, jsonEntity, jsonExpressionSourceTrimData);
						}

						skipRowTop(sourceSkipRowTop, jsonEntity, jsonExpressionSourceSkipRowTop);

						fixedString(sourceFixedStringValue, jsonEntity, jsonExpressionSourceFixedStringValue);

						emptyStringIsNull(sourceEmptyStringisNULLCheckbox, sourceEmptyStringisNULL, jsonEntity,
								jsonExpressionSourceEmptyString);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionRuleType);

						if (ruleType.contains("Recon") && fileConnectionType.equalsIgnoreCase("flat-file")) {

							caseSensitive(sourceCaseSensitiveCheckBox, sourceCaseSensitive, jsonEntity,
									jsonExpressionSourceCaseSensitive);

							isSorted(sourceIsSortedCheckBox, sourceIsSorted, jsonEntity, jsonExpressionSourceIsSorte);

						}

						if (!fileConnectionType.equalsIgnoreCase("flat-file")) {
							includeHeaders(sourceIncludeHeadersCheckbox, sourceIncludeHeaders, jsonEntity,
									jsonExpressionSourceIncludeHeaders);

						}

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						headerRow(sourceHeaderRow, jsonEntity, jsonExpressionSourceHeaderRow);

						skipRowBottom(sourceSkipRowBottom, jsonEntity, jsonExpressionSourceSkipRowBottom);

						whiteSpaceIsNull(sourceWhiteSpaceisNULLCheckbox, sourceWhiteSpaceisNULL, jsonEntity,
								jsonExpressionSourceWhiteSpace);

						clickOnGetSchemaButton(sourceGetSchema, sourceRefreshSchema, sourcegetData);

						refereshDataButton(sourceRefreshSchema);

					} else {

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !fileConnectionType.equalsIgnoreCase("parquet")) {

							xmlTableName(jsonEntity, sourceXmlTableNameText, sourceXmlTableNameEdit,
									jsonExpressionSourceXmlTableName);

						}

						String id = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceXmlFileSchemaId);

						sourceSelectPropertyForFileRule(workspaceid, id, icedqRole);

						if ((fileConnectionType.equalsIgnoreCase("XML") || fileConnectionType.equalsIgnoreCase("JSON")
								|| fileConnectionType.equalsIgnoreCase("Excel")
								|| fileConnectionType.equalsIgnoreCase("Parquet"))
								&& param.getRuleType().equalsIgnoreCase("Recon")) {

							appendOrderBy(param.getSourceAppendOrder(), sourceAppendOrderBy);

							fileDeferredSort(sourceDeferredSort, jsonEntity, jsonExpressionSourceDeferredSort);
						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !fileConnectionType.equalsIgnoreCase("Parquet")) {

							getFileSchema(SourceFileGetSchema);
							
							if(isDisplayed(driver, sourceSchemaText))
							{
								saveSchema(sourceSchemaSaveButton);

								javascript(driver, "arguments[0].scrollIntoView(true);", sourceSchemaID);

								String schemaId = getAttribute(driver, sourceSchemaID, "value");

								if (!schemaId.isBlank()) {

									BaseSuite.validationReportLog("Schema ID is not empty " + schemaId);

									isEditable(driver, sourceSchemaID, "Schema Id");

								} else {

									BaseSuite.reportFailLog("Schema ID is empty,Kindly check!", "SchemaId");
								}
							}
							else
							{
								BaseSuite.reportFailLog("Facing issue while getting the file schema", "Get Schema");
								
							}

						}

					}

					if (param.getSourceFileType() != null && param.getSourceFileType().equalsIgnoreCase("Fixed")) {

						String fileLayout = System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\DataTesting\\FixedFileLayout.xlsx";

						XLUtils xl = new XLUtils();

						String ruleName = xl.readUsingColName(fileLayout, "Staff", 1, "FileLayout");

						fixedFileTextArea(sourceFixedFileTextArea, sourceFixedFileTextAreaClear, ruleName,
								fileSourceAdvanceButton, fileSourceSourceButton);

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						if (param.getRuleType().equalsIgnoreCase("Checksum")) {
							BaseSuite.reportLog("Selecting function to calculate checksum from file");

							ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									jsonEntity, "$.objects[0].configuration.columns..name");

							int count = list.size();

							if (count != 0) {

								for (int i = 0; i < count; i++) {
									String function = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
											"$.objects[0].configuration.columns[" + i + "].function");

									if (function != null) {
										String name = list.get(i);

										javascript(driver, "arguments[0].scrollIntoView(true);",
												fileSourceSourceButton);

										Thread.sleep(2000);

										displayAndClick(driver, returnElement(checksumSourceColumnName, "$name", name));

										displayAndClick(driver, returnElement(sourceFunction, "$fun", function));

										BaseSuite.validationReportLog(
												"Function selected to calculate checksum from file");

										break;
									}
								}

							}

						}

						enterFilterConditionExpression(jsonEntity, sourceFilterColumnOperator,
								sourceFilterConditionColumnList, sourceFilterConditionExpressions, param.getRuleType(),
								sourceFilterConditionLable, sourceOperator, soft);

						filePreviewData(sourcegetData);

					} else {

						query = enterQueryInXmlFile(sourceDatasetDataQueryBox, jsonEntity,
								jsonExpressionSourceXmlFileQuery, jsonExpressionSourceXmlFileTable);

						if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
							if (param.getSourceInput().equalsIgnoreCase("SQL")) {
								verifyVisibilityOfButtons(driver, copyFromTargetButton, "Copy From Target Button",
										true);
							}
						}

						previewData(sourcegetData);

					}

				}
			}

			else {
				BaseSuite.reportFailLog(
						"Not able to create a rule because connection details is invalid, kindly check the connection details or may be Test button is visible in case of File Connection",
						"");
				throw new AssertionError(
						"Not able to create a rule because connection details is invalid , kindly check");
			}
		} catch (Exception e) {

			throw new Exception("");
		}
		return query;

	}

	public String enterDetailsInSourceSettingForVault(String jsonEntity, DataTestingParameters param, String connName,
			String schema, String table, String changeQueryConn) throws Throwable {

		String query = null;

		try {

			XLUtils xlReader = new XLUtils();

			/*
			 * if(!singleConnection.isEmpty()) {
			 * 
			 * String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;
			 * 
			 * String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet,
			 * BaseSuite.SourceConnection);
			 * 
			 * connName = loginDetails[0];
			 * 
			 * schema = loginDetails[1];
			 * 
			 * table = loginDetails[2]; } else { String connID =
			 * param.getSourceConnectionID();
			 * 
			 * String json =
			 * TestDataThroughApi.getConnectionJsonEntity(workspaceid,connID,icedqRole);
			 * 
			 * connName =TestDataThroughApi.getConnectionNmae(json);
			 * 
			 * schema = param.getSourceSchema();
			 * 
			 * table = param.getSourceTable();
			 * 
			 * }
			 */
			clickOnSourceDataset();

			selectSourceConnectionType(param.getSourceConnType());

			selectSourceConnection(connName);

			sourceSelectInput(param.getSourceInput());

			boolean testFlag = isEnabled(driver, sourceDatasetTestButton);

			String connTestMess = "";

			if (testFlag) {
				connTestMess = testButton(sourceDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			}

			if ((connTestMess.equalsIgnoreCase(connectionTestMess)) || (!isEnabled(driver, sourceDatasetTestButton))) {

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", false);

				if (param.getSourceConnType().equalsIgnoreCase("Database")) {

					if (!param.getSourceInput().equalsIgnoreCase("SQL")) {

						selectSchema(sourceDatasetSchemaClick, schema);

						if (!param.getSourceInput().equalsIgnoreCase("wizard")) {

							Thread.sleep(2000);

							selectTable(sourceDatasetTableClick, table);
						}

					}

					if (param.getRuleType().equalsIgnoreCase("Recon")) {

						appendOrderBy(param.getSourceAppendOrder(), sourceAppendOrderBy);

						deferredSort(sourceDeferredSort, jsonExpressionSourceDeferredSort, sourceColumnDelimiter,
								jsonExpressionSourceColumnDelimiter, sourceRowDelimiter,
								jsonExpressionSourceRowDelimiter, sourceTextQualifier,
								jsonExpressionSourceTextQualifier, jsonEntity);

					}
					if (param.getSourceInput().equalsIgnoreCase("SQL")) {

						query = enterDBQuery(param.getSourceInput(), sourceDatasetDataQueryBox, param.getSourceQuery(),
								schema, table, changeQueryConn);

					}

					verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

					previewData(sourcegetData);

					verifyVisibilityOfButtons(driver, sourceDataCancelBtn, "Cancel Button", true);

					verifyTableList(sourceTableList);

				} else {
					/*
					 * 
					 * if (!BaseSuite.SourceConnection.toUpperCase().contains("XML")) {
					 * selectFileType(param.getSourceFileType()); }
					 * 
					 * singleFile(sourceSingleFile, jsonEntity,
					 * jsonExpressionXmlFileSourceSingleFile);
					 * 
					 * String flag = parameterisedPath(sourceParameterisedPath, jsonEntity,
					 * jsonExpressionXmlFileSourceParameterisedPath);
					 * 
					 * if (flag.equalsIgnoreCase("true")) {
					 * BaseSuite.reportLog("Entering file path");
					 * 
					 * String filePath =
					 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					 * jsonExpressionXmlFileSourceFilePath);
					 * 
					 * javascript(driver, "arguments[0].scrollIntoView(true);", sourceSelectFile);
					 * 
					 * clear_SendKeys(driver, sourceSelectFile, filePath);
					 * 
					 * BaseSuite.validationReportLog("File path entered successfully"); } else {
					 * getFileButton();
					 * 
					 * selectFilePath(jsonEntity, "$.objects[0].configuration.filePath");
					 * 
					 * }
					 * 
					 * setPropertiesButton();
					 * 
					 * if (BaseSuite.SourceConnection.toUpperCase().contains("XML")) {
					 * 
					 * xmlXpath(jsonEntity, flag);
					 * 
					 * xmlTableName(jsonEntity, jsonExpressionXmlTableName); }
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Dilimited")) ; {
					 * columnDelimiter(sourceColumnDelimiter, jsonEntity,
					 * jsonExpressionSourceColumnDelimiter); }
					 * 
					 * rowDelimiter(sourceRowDelimiter, jsonEntity,
					 * jsonExpressionSourceRowDelimiter);
					 * 
					 * textQualifier(sourceTextQualifier, jsonEntity,
					 * jsonExpressionSourceTextQualifier);
					 * 
					 * skipRowTop(sourceSkipRowTop, jsonEntity, jsonExpressionSourceSkipRowTop);
					 * 
					 * headerRow(sourceHeaderRow, jsonEntity, jsonExpressionSourceHeaderRow);
					 * 
					 * skipRowBottom(sourceSkipRowBottom, jsonEntity,
					 * jsonExpressionSourceSkipRowBottom);
					 * 
					 * String ruleType =
					 * TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					 * jsonExpressionRuleType);
					 * 
					 * if (ruleType.equalsIgnoreCase("Recon") ||
					 * ruleType.equalsIgnoreCase("Ht Recon")) {
					 * caseSensitive(sourceCaseSensitiveCheckBox, sourceCaseSensitive, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * isSorted(sourceIsSortedCheckBox, sourceIsSorted, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * }
					 * 
					 * trimData(sourceTrimDataCheckBox, sourceTrimData, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * emptyStringIsNull(sourceEmptyStringisNULLCheckbox, sourceEmptyStringisNULL,
					 * jsonEntity, jsonExpressionSourceEmptyString);
					 * 
					 * whiteSpaceIsNull(sourceWhiteSpaceisNULLCheckbox, sourceWhiteSpaceisNULL,
					 * jsonEntity, jsonExpressionSourceWhiteSpace);
					 * 
					 * fixedString(sourceFixedStringCheckbox, sourceFixedString,
					 * sourceFixedStringValue, jsonEntity, jsonExpressionSourceFixedString,
					 * jsonExpressionSourceFixedStringValue);
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Fixed")) {
					 * 
					 * clickOnGetSchemaButton();
					 * 
					 * if (param.getRuleType().equalsIgnoreCase("Recon")) {
					 * 
					 * appendOrderBy(param.getSourceAppendOrder());
					 * 
					 * deferredSort(sourceDeferredSortCheckBox, sourceDeferredSort,
					 * jsonExpressionSourceDeferredSort, sourceColumnDelimiter,
					 * jsonExpressionSourceColumnDelimiter, sourceRowDelimiter,
					 * jsonExpressionSourceRowDelimiter, sourceTextQualifier,
					 * jsonExpressionSourceTextQualifier, jsonEntity);
					 * 
					 * }
					 * 
					 * saveSchema();
					 * 
					 * getSchemaID(jsonEntity, jsonExpressionXmlFileSchemaId);
					 * 
					 * enterQueryInXmlFile(sourceDatasetDataQueryBox, jsonEntity,
					 * jsonExpressionXmlFileQuery, jsonExpressionXmlFileTable);
					 * 
					 * previewData(sourcegetData);
					 * 
					 * } else {
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Dilimited")) {
					 * columnDelimiter(sourceColumnDelimiter, jsonEntity,
					 * jsonExpressionSourceColumnDelimiter); }
					 * 
					 * rowDelimiter(sourceRowDelimiter, jsonEntity,
					 * jsonExpressionSourceRowDelimiter);
					 * 
					 * textQualifier(sourceTextQualifier, jsonEntity,
					 * jsonExpressionSourceTextQualifier);
					 * 
					 * skipRowTop(sourceSkipRowTop, jsonEntity, jsonExpressionSourceSkipRowTop);
					 * 
					 * headerRow(sourceHeaderRow, jsonEntity, jsonExpressionSourceHeaderRow);
					 * 
					 * skipRowBottom(sourceSkipRowBottom, jsonEntity,
					 * jsonExpressionSourceSkipRowBottom);
					 * 
					 * if (ruleType.equalsIgnoreCase("Recon") ||
					 * ruleType.equalsIgnoreCase("Ht Recon")) {
					 * caseSensitive(sourceCaseSensitiveCheckBox, sourceCaseSensitive, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * isSorted(sourceIsSortedCheckBox, sourceIsSorted, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * }
					 * 
					 * trimData(sourceTrimDataCheckBox, sourceTrimData, jsonEntity,
					 * jsonExpressionSourceTrimData);
					 * 
					 * emptyStringIsNull(sourceEmptyStringisNULLCheckbox, sourceEmptyStringisNULL,
					 * jsonEntity, jsonExpressionSourceEmptyString);
					 * 
					 * whiteSpaceIsNull(sourceWhiteSpaceisNULLCheckbox, sourceWhiteSpaceisNULL,
					 * jsonEntity, jsonExpressionSourceWhiteSpace);
					 * 
					 * fixedString(sourceFixedStringCheckbox, sourceFixedString,
					 * sourceFixedStringValue, jsonEntity, jsonExpressionSourceFixedString,
					 * jsonExpressionSourceFixedStringValue);
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Fixed")) {
					 * 
					 * overrideLayout(sourceOverrideLayoutCheckBox, sourceOverrideLayout,
					 * jsonEntity, jsonExpressionSourceOverrideLayout); }
					 * 
					 * filePreviewData(sourcegetData);
					 * 
					 * if (param.getSourceFileType().equalsIgnoreCase("Dilimited")) {
					 * 
					 * changeDataTypeForSourceDelimitedFile(jsonEntity);
					 * 
					 * } if (param.getSourceFileType().equalsIgnoreCase("Fixed")) {
					 * 
					 * // fixedFileTextArea(sourceFixedFileTextArea,sourceFixedFileTextAreaClear,
					 * connTestMess);
					 * 
					 * // displayAndClick(driver, sourceFileDataButton);
					 * 
					 * // refereshDataButton(sourceRefereshDataButton);
					 * 
					 * sourceAddColumn(jsonEntity);
					 * 
					 * }
					 * 
					 * if (param.getRuleType().equalsIgnoreCase("Checksum")) {
					 * sourceFunction(jsonEntity); }
					 * 
					 * enterFilterConditionExpression(jsonEntity, sourceFilterColumnOperator,
					 * sourceFilterConditionColumnList, sourceFilterConditionExpressions,
					 * param.getRuleType(), soft);
					 * 
					 * refereshDataButton(sourceRefereshDataButton);
					 * 
					 * fileLayoutButton(fileLayout);
					 * 
					 * }
					 * 
					 */}
			}

			else {
				BaseSuite.reportFailLog(
						"Not able to create a rule because connection details is invalid, kindly check the connection details or may be Test button is visible in case of File Connection",
						"");
				throw new AssertionError(
						"Not able to create a rule because connection details is invalid , kindly check");
			}
		} catch (Exception e) {

			throw new Exception("");
		}
		return query;

	}

	public static void imageClick() {
		try {

			Pattern DesktpIcon = new Pattern("C:\\Users\\DhawalThakre\\Desktop\\sourceDataset.png");
			Screen s = new Screen();
			s.click(DesktpIcon);
			System.out.println("Desktop is Clicked.");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getWorkflowId(String workspaceId, String ruleId, String auto) {
		String workFlowId = null;

		try {
			String url;

			url = System.getProperty("testDataApiUrl");

			url = url.replace("https://", "");

			OkHttpClient httpClient = new OkHttpClient();

			Request request = new Request.Builder()

					.url("http://" + url + "/api/v1/workflows:fetchWorkflowId")

					.addHeader("workspace-id", workspaceId) // add request headers

					.addHeader("Content-Type", "application/json")

					.addHeader("Object-Id", ruleId)

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = httpClient.newCall(request).execute();

			workFlowId = response.body().string();

		} catch (IOException e) {

			e.getMessage();
		}
		return workFlowId;

	}

	public String addSubscription(String ruleId, String workspaceId, String icedqRole) {
		String entity1 = null;

		try {
			String url;

			String auth = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			String workflowId = getWorkflowId(workspaceId, ruleId, auth);

			url = System.getProperty("testDataApiUrl");

			url = url.replace("https://", "");

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(
					"http://" + url + "/api/v1/subscriptions/" + workflowId + "?eventType=completed");

			getRequest.setHeader("Authorization", "Bearer " + auth);

			getRequest.setHeader("workspace-id", workspaceId);

			getRequest.setHeader("Content-Type", "application/json");

			HttpResponse response;

			response = httpClient.execute(getRequest);

			org.apache.http.HttpEntity entity = response.getEntity();

			String string1 = null;

			string1 = EntityUtils.toString(entity);

			if (!string1.contains("Provided eventType is not present in the requested subscription")) {

				moreOption("Subscription");

				subcriptionFunctionality();

				List<String> successList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(string1,
						"$.events[0].subscriptions..status");

				int cout = successList.size();

				String userId;

				String userName;

				if (cout != 0) {

					for (int i = 0; i < cout; i++) {

						String status = successList.get(i).toString();

						if (status.equalsIgnoreCase("success")) {
							List<String> successUserId = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									string1, "$.events[0].subscriptions[" + i + "].user..id");

							int successCount = successUserId.size();

							for (int j = 0; j < successCount; j++) {
								String successId = successUserId.get(j).toString();

								userName = getUserNameFromUserID(successId, workspaceId);

								onSuccess(userName, successId);

							}
						} else if (status.equalsIgnoreCase("failure")) {
							List<String> failureUserId = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									string1, "$.events[0].subscriptions[" + i + "].user..id");

							int failureCount = failureUserId.size();

							for (int j = 0; j < failureCount; j++) {
								String failureId = failureUserId.get(j).toString();

								userName = getUserNameFromUserID(failureId, workspaceId);

								onFailure(userName, failureId);

							}

						} else {
							List<String> errorUserId = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									string1, "$.events[0].subscriptions[" + i + "].user..id");

							int errorCount = errorUserId.size();

							for (int j = 0; j < errorCount; j++) {
								String errorId = errorUserId.get(j).toString();

								userName = getUserNameFromUserID(errorId, workspaceId);

								onError(userName, errorId);

							}

						}

					}
				}

				verifyVisibilityOfButtons(driver, subscriptionSaveButton, "Save Button", true);

				verifyVisibilityOfButtons(driver, subscriptionCancelButton, "Cancel Button", true);

				BaseSuite.reportLog("Clicking on subcription save buttton");

				displayAndClick(driver, subscriptionSaveButton);

				BaseSuite.validationReportLog("Subcription save button clicked successfully");

			}

		} catch (IOException e) {

			e.getMessage();
		}
		return entity1;

	}

	public String getUserNameFromUserID(String userID, String workspaceID) {
		String userName = null;
		try {
			String url;

			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(ConstantProperty.ICEDQ_ADMINUSER);

			url = System.getProperty("testDataApiUrl");

			url = url.replace("https://", "");

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet("http://" + url + "/api/v1/users/" + userID);

			getRequest.setHeader("workspace-id", workspaceID);

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("Authorization", "Bearer " + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			org.apache.http.HttpEntity entity1 = response.getEntity();

			String string1 = null;

			string1 = EntityUtils.toString((org.apache.http.HttpEntity) entity1);

			userName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(string1, "$.fullName");
		} catch (IOException e) {

			e.getMessage();
		}
		return userName;

	}

	public void onSuccess(String successUser, String userId) {
		if (!successUser.isEmpty()) {
			int count = getcount(successUser, ',');

			String[] result = successUser.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String joinCol1 = result[colNum];

				BaseSuite.reportLog("Clicking on success field to add user/group");

				displayAndClick(driver, successUsers);

				displayAndClick(driver, returnElement(subscribersNameList, "$name", joinCol1));

				String val = getAttribute(driver, returnElement(successUsersAdded, "$name", userId), "title");

				if (val.equals(successUser)) {
					BaseSuite.validationReportLog("User/group added successfully");
				} else {

					BaseSuite.reportFailLog("User not added successfully on Success email,Kimdly check", "onSuccess");
				}

			}
		}
	}

	public void onFailure(String failureUser, String userId) {
		if (!failureUser.isEmpty()) {

			int count = getcount(failureUser, ',');

			String[] result = failureUser.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String joinCol1 = result[colNum];

				BaseSuite.reportLog("Clicking on failure field to add user/group");

				displayAndClick(driver, failureUsers);

				displayAndClick(driver, returnElement(subscribersNameList, "$name", joinCol1));

				String val = getAttribute(driver, returnElement(failureUsersAdded, "$name", userId), "title");

				if (val.equals(failureUser)) {
					BaseSuite.validationReportLog("User/group added successfully");
				} else {

					BaseSuite.reportFailLog("User not added successfully on Failure email,Kimdly check", "onFailure");
				}

			}
		}
	}

	public void onError(String errorUser, String userId) {
		if (!errorUser.isEmpty()) {

			int count = getcount(errorUser, ',');

			String[] result = errorUser.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String joinCol1 = result[colNum];

				BaseSuite.reportLog("Clicking on failure field to add user/group");

				displayAndClick(driver, errorUsers);

				displayAndClick(driver, returnElement(subscribersNameList, "$name", joinCol1));

				String val = getAttribute(driver, returnElement(errorUsersAdded, "$name", userId), "title");

				if (val.equals(errorUser)) {
					BaseSuite.validationReportLog("User/group added successfully");

				} else {
					BaseSuite.reportFailLog("User not added successfully on Error email,Kimdly check", "onError");
				}

			}
		}
	}

	public void appendOrderBy(String appendOrder, By locator) {
		try {

			if (!appendOrder.equalsIgnoreCase("true")) {

				BaseSuite.reportLog("Clicking on Append OrderBy checkbox");

				displayAndClick(driver, locator);

				BaseSuite.validationReportLog("Append OrderBy checkbox clicked successfully");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void selectSourceConnection(String sourceConnection) throws Throwable {
		try {
			boolean flag = false;

			BaseSuite.reportLog("Selecting " + sourceConnection + " connection");

			Thread.sleep(500);

			javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetConnectionClick);

			isDisplayed(driver, sourceDatasetConnectionClick);

			// Thread.sleep(3000);
			/*
			 * Actions actions = new Actions(driver);
			 * 
			 * wait = waitMethod(driver);
			 * 
			 * actions.moveToElement(driver.findElement(sourceDatasetConnectionClick)).
			 * perform();
			 * 
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(
			 * sourceDatasetConnectionClick));
			 * 
			 * actions.click(driver.findElement(sourceDatasetConnectionClick)).build().
			 * perform();
			 */

			isDisplayed(driver, sourceDatasetConnectionClick);

			displayAndClick(driver, sourceDatasetConnectionClick);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

			isDisplayed(driver, sourceDatasetConnectionSearch);

			Thread.sleep(5000);

			sendKeys(driver, sourceDatasetConnectionSearch, sourceConnection);

			boolean conName = isDisplayed(driver,
					returnElement(sourceDatasetConnectionSelect, "$name", sourceConnection));

			if (conName) {
				displayAndClick(driver, returnElement(sourceDatasetConnectionSelect, "$name", sourceConnection));

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog(sourceConnection + " connection selected successfully");

				flag = true;

			} else {
				flag = false;

				BaseSuite.reportFailLog("Searched connection " + sourceConnection + " not found,Kindly check!",
						"selectSourceConnection");

			}

			// captureToastMsg(driver, toastMsg, popUpClose, connectionMess, "Connection");
		} catch (Exception e) {

			throw new Exception("Searched connection " + sourceConnection + " not found,Kindly check!");
		}

	}

	public void selectTargetConnection(String targetConnection) throws InterruptedException {
		try {
			boolean flag = false;

			BaseSuite.reportLog("Selecting " + targetConnection + " connection");

			Thread.sleep(5000);

			javascript(driver, "arguments[0].scrollIntoView(true);", targetDatasetConnectionClick);

			// Thread.sleep(3000);;
			/*
			 * Actions actions = new Actions(driver);
			 * 
			 * wait = waitMethod(driver);
			 * 
			 * actions.moveToElement(driver.findElement(targetDatasetConnectionClick)).
			 * perform();
			 * 
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(
			 * targetDatasetConnectionClick));
			 * 
			 * actions.click(driver.findElement(targetDatasetConnectionClick)).build().
			 * perform();
			 */

			isDisplayed(driver, targetDatasetConnectionClick);

			displayAndClick(driver, targetDatasetConnectionClick);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

			isDisplayed(driver, sourceDatasetConnectionSearch);

			Thread.sleep(5000);

			sendKeys(driver, sourceDatasetConnectionSearch, targetConnection);

			boolean conName = isDisplayed(driver,
					returnElement(sourceDatasetConnectionSelect, "$name", targetConnection));

			if (conName) {
				displayAndClick(driver, returnElement(sourceDatasetConnectionSelect, "$name", targetConnection));

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog(targetConnection + " connection selected successfully");

				flag = true;

			} else {
				flag = false;

				throw new SkipException("Searched connection " + targetConnection + " not found,Kindly check!");
			}

			// captureToastMsg(driver, toastMsg, popUpClose, connectionMess, "Connection");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void selectSchema(By locator, String schema) {
		try {
			BaseSuite.reportLog("Selecting " + schema + " schema");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			isDisplayed(driver, locator);

			// Thread.sleep(3000);
			/*
			 * Actions actions = new Actions(driver);
			 * 
			 * wait = waitMethod(driver);
			 * 
			 * actions.moveToElement(driver.findElement(locator)).perform();
			 * 
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			 * 
			 * actions.click(driver.findElement(locator)).build().perform();
			 */
			isDisplayed(driver, locator);

			displayAndClick(driver, locator);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(dropDownBox1)).clickAndHold().build().perform();

			isDisplayed(driver, SourceDatasetSchemaSearch);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			sendKeys(driver, SourceDatasetSchemaSearch, schema);

			isDisplayed(driver, returnElement(sourceDatasetSchemaSelect, "$name", schema));

			displayAndClick(driver, returnElement(sourceDatasetSchemaSelect, "$name", schema));

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog(schema + " schema selected successfully");

			// captureToastMsg(driver, toastMsg, popUpClose, schemaMess, "Schema");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public String parameterisedPath(By checkboxLocator, By locator, String json, String exp) {
		String val = null;

		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, exp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on parameterised path checkbox to uncheck it");

				// displayAndClick(driver, locator);

				WebElement ele1 = driver.findElement(locator);

				ele1.click();

				BaseSuite.validationReportLog("Successfully unchecked the parameterised path checkbox");
			}

		} catch (Exception e) {

			e.getMessage();
		}
		return val;
	}

	public void isSorted(By checkboxLocator, By selectCheckboxLocator, String json, String isSortedExp) {
		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, isSortedExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on Is Sorted checkbox to check/uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully checked/unchecked the Is Sorted checkbox");

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void deferredSort(By selectCheckboxLocator, String deferredSortExp, By columnDelimiterLocator,
			String columnDelimiterExp, By rowDelimiterLocator, String rowDelimiterExp, By textQualifierLocator,
			String textQualifierExp, String json) {
		try {

			WebElement ele = driver.findElement(selectCheckboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, deferredSortExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Deferred Sort is Sorted checkbox to check/uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully checked/unchecked the Deferred Sort checkbox");

				columnDelimiter(columnDelimiterLocator, json, columnDelimiterExp);

				rowDelimiter(rowDelimiterLocator, json, rowDelimiterExp);

				textQualifier(textQualifierLocator, json, textQualifierExp);
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void fileDeferredSort(By selectCheckboxLocator, String json, String deferredSortExp) {
		try {
			WebElement ele = driver.findElement(selectCheckboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, deferredSortExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Deferred Sort is Sorted checkbox to check/uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully checked/unchecked the Deferred Sort checkbox");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void trimData(By checkboxLocator, By selectCheckboxLocator, String json, String dataTrimExp) {
		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, dataTrimExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on Trim data checkbox to uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully unchecked the Trim data checkbox");

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void fileLayout(By locator) {
		try {
			BaseSuite.reportLog("Clicking on File layout button");

			displayAndClick(driver, locator);

			BaseSuite.validationReportLog("File layout button clicked successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void refereshDataButton(By locator) throws InterruptedException {
		try {
			BaseSuite.reportLog("Clicking on referesh data button");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			displayAndClick(driver, locator);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			Thread.sleep(2000);

			BaseSuite.validationReportLog("referesh data button clicked successfully");

			verifyFileTableList();

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void fileLayoutButton(By locator) {
		try {
			BaseSuite.reportLog("Clicking on file layout button");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			displayAndClick(driver, locator);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("file layout button clicked successfully");

			WebElement ele = getElement(driver, fileLayoutJson);

			String val = ele.getText();

			if (val.isBlank()) {
				BaseSuite.reportFailLog("Json code is not displayed properly after click on file layout",
						"fileLayoutButton");
			} else {
				BaseSuite.validationReportLog("Json code displayed properly after click on file layout");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void whiteSpaceIsNull(By checkboxLocator, By selectCheckboxLocator, String json,
			String spaceWhiteIsNullExp) {
		try {
			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, spaceWhiteIsNullExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on White Space is Null checkbox to uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully unchecked the White Space is Null checkbox");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void selectTable(By locator, String table) {
		try {
			BaseSuite.reportLog("Selecting " + table + " Table");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			isDisplayed(driver, locator);

			// Thread.sleep(3000);
			/*
			 * Actions actions = new Actions(driver);
			 * 
			 * wait = waitMethod(driver);
			 * 
			 * actions.moveToElement(driver.findElement(locator)).perform();
			 * 
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			 * 
			 * actions.click(driver.findElement(locator)).build().perform();
			 */
			isDisplayed(driver, locator);

			displayAndClick(driver, locator);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(dropDownBox1)).clickAndHold().build().perform();

			isDisplayed(driver, sourceDatasetTableSearch);

			sendKeys(driver, sourceDatasetTableSearch, table);

			isDisplayed(driver, returnElement(sourceDatasetTableSelect, "$name", table));

			displayAndClick(driver, returnElement(sourceDatasetTableSelect, "$name", table));

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog(table + " Table selected successfully");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void setCustomSqlButton(By locator) {
		try {
			BaseSuite.reportLog("Clicking on Set custome SQL button");

			isDisplayed(driver, locator);
			displayAndClick(driver, locator);

			BaseSuite.validationReportLog("Set custome SQL button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyTableList(By locator) throws Exception {
		try {

			if (isDisplayed(driver, locator)) {

				javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", locator);

				List<WebElement> ele = driver.findElements(locator);

				int count = ele.size();

				if (count > 0) {

					BaseSuite.validationReportLog("Table list retrive successfully after click on getdata button");
				} else {

					BaseSuite.reportFailLog(
							"Table list not retrive successfully after click on getdata button, kindly check the query",
							"verifyTableList");
					throw new Exception("");
				}

			} else {
				BaseSuite.reportFailLog(
						"Table list not retrive successfully after click on getdata button, kindly check the query",
						"verifyTableList");
				throw new Exception("");

			}
		} catch (Exception e) {

			throw new Exception("");
		}

	}

	public void verifyFileTableList() throws Exception {
		try {

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", fileTableList);

			isDisplayed(driver, fileTableList);

			List<WebElement> ele = driver.findElements(fileTableList);

			int count = ele.size();

			if (count > 0) {

				BaseSuite.validationReportLog(
						"Table list retrive successfully after click on Preview data/Referesh data button");
			} else {

				BaseSuite.reportFailLog(
						"Table list not retrive successfully after click on Preview data/Referesh data button, kindly check the query",
						"verifyTableList");
				throw new Exception("");
			}
		} catch (Exception e) {

			throw new Exception("");
		}

	}

	public void selectFileType(By locator, String fileType) {

		try {
			BaseSuite.reportLog("Selecting " + fileType + " File Type");

			// Thread.sleep(2000);

			displayAndClick(driver, locator);

			Actions actions = new Actions(driver);

			wait = waitMethod(driver);

			actions.moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

			displayAndClick(driver, returnElement(sourceDatasetSetFileTypeSelect, "$name", fileType));

			BaseSuite.validationReportLog(fileType + " File Type selected successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public String singleFile(By checkboxLocator, By locator, String json, String exp) {
		String val = null;

		try {
			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			if (flag) {
				BaseSuite.validationReportLog("Single File is by default selected");

				val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, exp);

				if (!Boolean.parseBoolean(val) == flag) {

					BaseSuite.reportLog("Clicking on single file checkbox to uncheck it");

					displayAndClick(driver, locator);

					BaseSuite.validationReportLog("Successfully unchecked the single file checkbox");
				}
			} else {
				BaseSuite.reportFailLog("Single File is by default not selected,Kindly check", "singleFile");

			}

		} catch (Exception e) {

			e.getMessage();
		}
		return val;
	}

	public String revisiteSingleFileCheckbox(By locator, String json, String exp) {
		String val = null;

		try {
			WebElement ele = driver.findElement(locator);

			boolean flag = ele.isSelected();

			val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, exp);

			if (Boolean.parseBoolean(val) == flag) {
				BaseSuite.validationReportLog(
						"After revisiting the rule Single File checkbox result matched with accepted condition " + val);
			} else {
				BaseSuite.reportFailLog(
						"After revisiting the rule Single File checkbox result not matched with accepted condition "
								+ val,
						"revisiteSingleFileCheckbox");

			}

		} catch (Exception e) {

			e.getMessage();
		}
		return val;
	}

	public String revisiteParameterisedPathCheckbox(By locator, String json, String exp) {
		String val = null;

		try {

			WebElement ele = driver.findElement(locator);

			boolean flag = ele.isSelected();

			val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, exp);

			if (val == null) {
				val = "false";
			}

			if (Boolean.parseBoolean(val) == flag) {
				BaseSuite.validationReportLog(
						"After revisiting the rule Parameterised Path checkbox result matched with accepted condition "
								+ val);
			} else {
				BaseSuite.reportFailLog(
						"After revisiting the rule Parameterised Path checkbox result not matched with accepted condition "
								+ val,
						"revisiteParameterisedPathCheckbox");

			}

		} catch (Exception e) {

			e.getMessage();
		}
		return val;
	}

	public void getFileButton(By locator) throws InterruptedException {
		try {
			BaseSuite.reportLog("Clicking on Set File button");

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			Thread.sleep(1000);

			displayAndClick(driver, locator);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Set File button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void setPropertiesButton() throws InterruptedException {
		try {
			BaseSuite.reportLog("Clicking on Set Properties button");

			javascript(driver, "arguments[0].scrollIntoView(true);", setProperties);

			Thread.sleep(1000);

			displayAndClick(driver, setProperties);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Set Properties button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void container(By locator, String containerName) {
		try {
			BaseSuite.reportLog("Entering container");

			clear_SendKeys(driver, locator, containerName);

			BaseSuite.validationReportLog("Container entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void filePath(By locator, String fileName) {
		try {
			BaseSuite.reportLog("Entering file path");

			clear_SendKeys(driver, locator, fileName);

			BaseSuite.validationReportLog("file path entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void selectFilePath(String jsonEntity, String filePathExpression) throws InterruptedException {
		try {

			// TestDataThroughApi testData = new TestDataThroughApi(driver);

			// String container =
			// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
			// containerExpression);

			// String filePath =
			// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
			// filePathExpression);

			// String replaceValue = filePath.replaceAll(container, "");

			String finalReplaceValue = filePathExpression.replaceAll("/", " ").trim();

			int count = getcount(finalReplaceValue, ' ');

			String[] result = finalReplaceValue.split(" ");

			BaseSuite.reportLog("Selecting file");

			String formulaSelection = null;

			for (int colNum = 0; colNum <= count; colNum++) {

				formulaSelection = result[colNum];

				Thread.sleep(2000);

				if (isDisplayed(driver, returnElement(chooseFile, "$name", formulaSelection))) {
					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(chooseFile, "$name", formulaSelection));

					displayAndClick(driver, returnElement(chooseFile, "$name", formulaSelection));

					// displayAndClick(driver, returnElement(chooseFile, "$name",
					// formulaSelection));

					inVisible(driver, searchRuleSpinner, Constant.ruleWait);

				} else {
					BaseSuite.reportFailLog("Searched file not present,Kindly check!", "selectFilePath");

				}

			}

			moveToElement(driver, returnElement(chooseFileHover, "$name", formulaSelection));

			Thread.sleep(2000);

			javascript(driver, "arguments[0].click();", returnElement(selectButton, "$name", formulaSelection));

			// displayAndClick(driver, returnElement(selectButton, "$name",
			// formulaSelection));

			BaseSuite.validationReportLog("File selected successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void columnDelimiter(By locator, String jsonEntity, String expression) {
		try {
			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			BaseSuite.reportLog("Entering column Delimiter");

			clear_SendKeys(driver, locator, val);

			BaseSuite.validationReportLog("column Delimiter Entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void rowDelimiter(By locator, String jsonEntity, String expression) {
		try {
			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			if (!val.isBlank()) {
				BaseSuite.reportLog("Entering row Delimiter");

				String finalVal = val.replace("\\", "");

				String actualVal = '\\' + finalVal;

				clear_SendKeys(driver, locator, actualVal);

				BaseSuite.validationReportLog("row Delimiter Entered successfully");
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void textQualifier(By locator, String jsonEntity, String expression) {
		try {
			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			String finalVal;

			if (val.matches("\\/")) {
				finalVal = val.replace("/", "\"");
			} else {
				finalVal = val;
			}

			BaseSuite.reportLog("Entering text qualifier");

			clear_SendKeys(driver, locator, finalVal);

			BaseSuite.validationReportLog("text qualifier Entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void skipRowTop(By locator, String jsonEntity, String expression) {
		try {
			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			BaseSuite.reportLog("Entering skip row top");

			clear_SendKeys(driver, locator, val);

			BaseSuite.validationReportLog("skip row top Entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void headerRow(By locator, String jsonEntity, String expression) {
		try {
			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			BaseSuite.reportLog("Entering header row");

			clear_SendKeys(driver, locator, val);

			BaseSuite.validationReportLog("header row Entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void skipRowBottom(By locator, String jsonEntity, String expression) {
		try {
			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, expression);

			BaseSuite.reportLog("Entering Skip row bottom");

			clear_SendKeys(driver, locator, val);

			BaseSuite.validationReportLog("Skip row bottom Entered successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void caseSensitive(By checkboxLocator, By selectCheckboxLocator, String json, String caseSensitiveExp) {
		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, caseSensitiveExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on case sensitive checkbox to check/uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully checked/unchecked the case sensitive checkbox");

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void fixedFileTextArea(By locator1, By locator2, String fixedFileText, By advanceButtonLocator,
			By sourceTargetButtonLocator) throws FileNotFoundException, InterruptedException {
		try {
			BaseSuite.reportLog("Entering fixed file layout");

			javascript(driver, "arguments[0].scrollIntoView(true);", advanceButtonLocator);

			Thread.sleep(2000);

			displayAndClick(driver, advanceButtonLocator);

			displayAndClick(driver, advanceButtonLocator);

			WebElement ele = driver.findElement(locator1);

			ele.click();

			ele.click();

			selectAllAndBackSpace(driver, locator2);

			driver.findElement(locator2).sendKeys(fixedFileText);

			javascript(driver, "arguments[0].scrollIntoView(true);", advanceButtonLocator);

			displayAndClick(driver, sourceTargetButtonLocator);

			BaseSuite.validationReportLog("fixed file layout Entered successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void emptyStringIsNull(By checkboxLocator, By selectCheckboxLocator, String json,
			String stringEmptyIsNullExp) {
		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, stringEmptyIsNullExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on Emty String is Null checkbox to uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully unchecked the Emty String is Null checkbox");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void includeHeaders(By checkboxLocator, By selectCheckboxLocator, String json, String stringEmptyIsNullExp) {
		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, stringEmptyIsNullExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on Include headers checkbox to uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully unchecked the Include headers checkbox");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void overrideLayout(By checkboxLocator, By selectCheckboxLocator, String json, String overrideLayoutExp) {
		try {

			WebElement ele = driver.findElement(checkboxLocator);

			boolean flag = ele.isSelected();

			String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, overrideLayoutExp);

			if (!Boolean.parseBoolean(val) == flag) {

				BaseSuite.reportLog("Clicking on override layout checkbox to uncheck it");

				displayAndClick(driver, selectCheckboxLocator);

				BaseSuite.validationReportLog("Successfully unchecked the override layout checkbox");

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void fixedString(By fixedStringValueLocator, String json, String valueExp) {
		try {

			String output = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(json, valueExp);

			if (!output.equalsIgnoreCase("null")) {

				BaseSuite.reportLog("Entering fixed string value");

				clear_SendKeys(driver, fixedStringValueLocator, output);

				BaseSuite.validationReportLog("fixed string value Entered successfully " + output);

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public String enterFilterConditionExpression(String jsonEntity, By operatorListLocator, By columnListLocator,
			By sendKeyLocator, String ruleType, By filterLable, String operatorLocator, SoftAssert soft)
			throws InterruptedException {

		String filterVal = null;

		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", filterLable);

			int k;

			if (isDisplayed(driver, targetSettingLable)) {
				k = 2;
			} else {
				k = 1;
			}

			// Thread.sleep(4000);

			List<WebElement> ele1 = driver.findElements(operatorListLocator);

			BaseSuite.reportLog("Verifying operator buttons");

			int count1 = ele1.size();

			for (int i = 0; i < count1; i++) {

				String val = ele1.get(i).getText();

				displayAndClick(driver, returnElement(operatorLocator, "$name", val));

				// ele1.get(i).click();

				String value1 = getAttribute(driver, sendKeyLocator, "value");

				BaseSuite.validationReportLog(value1 + " operator button clicked successfully");

				clear(driver, sendKeyLocator);

			}

			List<WebElement> ele = driver.findElements(columnListLocator);

			int count = ele.size();

			for (int i = 0; i < count; i++) {

				int j = i + 1;

				WebElement element = driver
						.findElement(By.xpath("(//ejs-listview[@id='sample-list']//ul//li[" + j + "])[" + k + "]"));

				javascript(driver, "arguments[0].scrollIntoView(true);", element);

				String val = element.getText();

				Thread.sleep(3000);

				element.click();

				String value = getAttribute(driver, sendKeyLocator, "value");

				soft.assertTrue(value.contains(val), "Text not found!");

				clear(driver, sendKeyLocator);

				String apiValue;

				apiValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[0].configuration.columns[" + i + "].name");

				if (ruleType.contains("Recon") || ruleType.equalsIgnoreCase("Checksum")) {

					apiValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[1].configuration.columns[" + i + "].name");

				}

				if (val.equals(apiValue)) {

					BaseSuite.validationReportLog("filter column Successfully Matched");

				}

				else {
					BaseSuite.reportFailLog("filter column didn't match", "enterFilterConditionExpression");

				}
			}
			BaseSuite.reportLog("Entering filter condition expression");

			filterVal = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.filterCondition");

			clear_SendKeys(driver, sendKeyLocator, filterVal);

			BaseSuite.validationReportLog("filter condition expression Entered successfully");

		} catch (Exception e) {

			e.getMessage();
		}
		return filterVal;

	}

	public String readFilterConditionExpression(String jsonEntity, By operatorListLocator, By columnListLocator,
			By getTextLocator) throws InterruptedException {

		String filterVal = null;

		try {

			List<WebElement> ele1 = driver.findElements(operatorListLocator);

			BaseSuite.reportLog("Verifying operator buttons");

			Thread.sleep(4000);

			int count1 = ele1.size();

			for (int i = 0; i < count1; i++) {

				String val = ele1.get(i).getText();

				boolean flag = ele1.get(i).isDisplayed();

				if (flag) {
					BaseSuite.validationReportLog(val + " operator button is Displayed on the page");
				} else {
					BaseSuite.reportFailLog(val + " operator button is not Displayed on the page",
							"readFilterConditionExpression");
				}

			}

			List<WebElement> ele = driver.findElements(columnListLocator);

			int count = ele.size();

			for (int i = 0; i < count; i++) {

				int j = i + 1;

				WebElement element = driver
						.findElement(By.xpath("//ejs-listview[@id='sample-list']//ul//li[" + j + "]"));

				javascript(driver, "arguments[0].scrollIntoView(true);", element);

				String val = ele.get(i).getText();

				boolean flag = ele.get(i).isDisplayed();

				if (flag) {
					BaseSuite.validationReportLog(val + " Column name is Displayed on the page");
				} else {
					BaseSuite.reportFailLog(val + " Column name is not Displayed on the page",
							"readFilterConditionExpression");
				}

			}

			filterVal = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.filterCondition");

			String output = getText(driver, getTextLocator);

			if (output.equalsIgnoreCase(filterVal)) {
				BaseSuite
						.validationReportLog("Entered filter condition matched successfully after revisiting the rule");
			} else {
				BaseSuite.reportFailLog("Entered filter condition not matched successfully after revisiting the rule",
						"readFilterConditionExpression");

			}

		} catch (Exception e) {

			e.getMessage();
		}
		return filterVal;

	}

	public String enterDBQuery(String inputType, By locator, String query, String schemaName, String tableName,
			String changeQueryConn) throws InterruptedException, JsonMappingException, JsonProcessingException {

		String dynamicQuery = query;

		try {

			if (!inputType.equalsIgnoreCase("Table")) {

				if (!query.isEmpty() && !query.contains("\\r")) {

					BaseSuite.reportLog("Entering Query in query box");

					javascript(driver, "arguments[0].scrollIntoView(true);", locator);

					Thread.sleep(1000);

					selectAllAndBackSpace(driver, locator);

					WebElement ele = getElement(driver, locator);

					Actions act = new Actions(driver);

					act.moveToElement(ele).click().build().perform();

					if (schemaName != null && !schemaName.isEmpty()) {

						if (query.contains(schemaName)) {

							dynamicQuery = query.replaceAll(sqlQueryDynamicSchemaReg + tableName + "\\b",
									schemaName + "." + tableName);

						}

						else {

							if (!changeQueryConn.isEmpty()) {
								XLUtils xl = new XLUtils();

								String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

								String[] loginDetails = xl.readDataFromExcelUsingColumnName(sheet, changeQueryConn);

								String changeSchema = loginDetails[1];

								String changeTable = loginDetails[2];

								dynamicQuery = query.replaceAll("(?i)\\b" + changeSchema + "." + changeTable + "\\b",
										schemaName + "." + tableName);

							}

						}
					}

					if (!dynamicQuery.isEmpty()) {

						Thread.sleep(1000);

						sendKeys(driver, locator, dynamicQuery);

						BaseSuite.validationReportLog("Query Entered successfully in query box : " + dynamicQuery);

					} else {
						BaseSuite.reportFailLog("SQL query not found kindly check", "enterDBQuery");
					}
				} else {
					javascript(driver, "arguments[0].scrollIntoView(true);", locator);

					Thread.sleep(1000);
					// selectAllAndBackSpace(driver, locator);

					WebElement ele = getElement(driver, locator);

					Actions act = new Actions(driver);

					query = query.replace("\\r\\n\\t", "\r\n\t");

					query = query.replace("\\", "\"");

					query = query.replace("\"r", "@");

					query = query.replace("\"t", "");

					int count = getcount(query, '@');

					String[] result = query.split("@");

					for (int colNum = 0; colNum <= count; colNum++) {
						String queryValue = result[colNum].trim();

						act.moveToElement(ele).click().build().perform();

						ele.sendKeys(queryValue);

						if (queryValue.startsWith("(")) {
							ele.sendKeys(Keys.ARROW_RIGHT);

							ele.sendKeys(Keys.BACK_SPACE);
						}

						ele.sendKeys(Keys.SPACE);

						ele.sendKeys(Keys.ENTER);

					}
				}

			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e.getMessage());
		}
		return dynamicQuery;

	}

	public String enterQueryInXmlFile(By locator, String jsonEntity, String queryExp, String tableExp)
			throws InterruptedException {

		String exp = null;

		try {
			exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, queryExp);

			String table = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, tableExp);

			if (isDisplayed(driver, xmlTableText)) {
				String actualExp = getText(driver, xmlTableText);

				String finalQuery = exp.replaceAll(table, actualExp);

				exp = finalQuery;
			}

			if (!exp.isEmpty()) {

				BaseSuite.reportLog("Entering Query in query box");

				javascript(driver, "arguments[0].scrollIntoView(true);", sourcegetData);

				Thread.sleep(2000);

				selectAllAndBackSpace(driver, locator);

				sendKeys(driver, locator, exp);

				BaseSuite.validationReportLog("Query Entered successfully in query box : " + exp);

			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e.getMessage());
		}
		return exp;

	}

	public String enterTargetQueryInXmlFile(By locator, String jsonEntity, String queryExp, String tableExp)
			throws InterruptedException {

		String exp = null;

		try {
			exp = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, queryExp);

			String table = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, tableExp);

			if (isDisplayed(driver, targetXmlTableNameText)) {
				String actualExp = getText(driver, targetXmlTableNameText);

				String finalQuery = exp.replaceAll(table, actualExp);

				exp = finalQuery;
			}

			if (!exp.isEmpty()) {

				BaseSuite.reportLog("Entering Query in query box");

				javascript(driver, "arguments[0].scrollIntoView(true);", sourcegetData);

				Thread.sleep(2000);

				selectAllAndBackSpace(driver, locator);

				sendKeys(driver, locator, exp);

				BaseSuite.validationReportLog("Query Entered successfully in query box : " + exp);

			}
		} catch (Exception e) {

			BaseSuite.reportErrorLog(e.getMessage());
		}
		return exp;

	}

	public void sourceAddColumn(String jsonEntity) throws InterruptedException {

		try {

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns..name");

			int i;

			for (i = 0; i < list.size(); i++) {

				BaseSuite.reportLog("Clicking on Add column button");

				Thread.sleep(2000);

				if (i > 0) {

					javascript(driver, "arguments[0].scrollIntoView(true);", sourceAddColumn);
					waitForElement(driver, sourceAddColumn);

					Thread.sleep(1000);

					displayAndClick(driver, sourceAddColumn);

				}

				BaseSuite.validationReportLog("Add column button clicked successfully");

				javascript(driver, "arguments[0].scrollIntoView(true);",
						By.xpath(
								"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
										+ i + "']//td[@data-colindex='1']"));

				Thread.sleep(2000);

				driver.findElement(By
						.xpath("(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
								+ i + "']//td[@data-colindex='1']"))
						.click();

				waitForElement(driver, sourceColumnName);

				clear_Click_SendKeys(driver, 5, sourceColumnName,
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[0].configuration.columns[" + i + "].name"));

				driver.findElement(By.xpath("//input[@id='scolGridcolumnName']")).sendKeys(Keys.ENTER);

				Thread.sleep(2000);

				driver.findElement(By
						.xpath("(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
								+ i + "']//td[@data-colindex='3']"))
						.click();

				waitForElement(driver, sourceStartPoint);

				clear_Click_SendKeys(driver, 5, sourceStartPoint,
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[0].configuration.columns[" + i + "].startPosition"));

				driver.findElement(By.xpath("//input[@id='scolGridstartPosition']")).sendKeys(Keys.ENTER);

				Thread.sleep(2000);

				driver.findElement(By
						.xpath("(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
								+ i + "']//td[@data-colindex='4']"))
						.click();

				waitForElement(driver, sourceEndPoint);

				clear_Click_SendKeys(driver, 5, sourceEndPoint, TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
						jsonEntity, "$.objects[0].configuration.columns[" + i + "].endPosition"));

				driver.findElement(By.xpath("//input[@id='scolGridendPosition']")).sendKeys(Keys.ENTER);

				Thread.sleep(2000);

				String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[0].configuration.columns[" + i + "].datatype");

				if (!val.equalsIgnoreCase("Text")) {
					Thread.sleep(2000);

					driver.findElement(By.xpath(
							"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='" + i
									+ "']//td[@data-colindex='2']"))
							.click();

					displayAndClick(driver, returnElement(engineTypeSelectOption, "$name", val));

					if (val.equalsIgnoreCase("Date") || val.equalsIgnoreCase("Time")
							|| val.equalsIgnoreCase("Timestamp")) {
						Thread.sleep(2000);

						driver.findElement(By.xpath(
								"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
										+ i + "']//td[@data-colindex='5']"))
								.click();

						displayAndClick(driver, returnElement(propertiesselectParameter, "$name", val));

					}
				}

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void sourceFunction(String jsonEntity) throws InterruptedException {
		try {
			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns..name");

			for (int i = 0; i < list.size(); i++) {

				String fun = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[0].configuration.columns[" + i + "].function");

				Thread.sleep(2000);

				if (fun != null) {

					javascript(driver, "arguments[0].scrollIntoView(true);", By.xpath(
							"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='" + i
									+ "']//td[@data-colindex='6']"));

					driver.findElement(By.xpath(
							"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='" + i
									+ "']//td[@data-colindex='6']"))
							.click();

					displayAndClick(driver, returnElement(propertiesselectParameter, "$name", fun));
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void targetFunction(String jsonEntity) throws InterruptedException {
		try {
			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[1].configuration.columns..name");

			for (int i = 0; i < list.size(); i++) {

				String fun = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.columns[" + i + "].function");

				Thread.sleep(2000);

				if (fun != null) {

					javascript(driver, "arguments[0].scrollIntoView(true);", By.xpath(
							"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='" + i
									+ "']//td[@data-colindex='6']"));

					driver.findElement(By.xpath(
							"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='" + i
									+ "']//td[@data-colindex='6']"))
							.click();

					displayAndClick(driver, returnElement(propertiesselectParameter, "$name", fun));
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void targetAddColumn(String jsonEntity) throws InterruptedException {

		try {

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[1].configuration.columns..name");

			int i;

			for (i = 0; i < list.size(); i++) {

				BaseSuite.reportLog("Clicking on Add column button");

				if (i > 0) {

					Thread.sleep(1000);

					javascript(driver, "arguments[0].scrollIntoView(true);", targetAddColumn);

					waitForElement(driver, sourceAddColumn);

					Thread.sleep(1000);

					displayAndClick(driver, targetAddColumn);

				}

				BaseSuite.validationReportLog("Add column button clicked successfully");

				javascript(driver, "arguments[0].scrollIntoView(true);",
						By.xpath(
								"(//colgroup[@id='content-tcolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
										+ i + "']//td[@data-colindex='1']"));

				Thread.sleep(1000);

				driver.findElement(By
						.xpath("(//colgroup[@id='content-tcolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
								+ i + "']//td[@data-colindex='1']"))
						.click();

				waitForElement(driver, targetColumnName);

				clear_Click_SendKeys(driver, 5, targetColumnName,
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[1].configuration.columns[" + i + "].name"));

				driver.findElement(By.xpath("//input[@id='tcolGridcolumnName']")).sendKeys(Keys.ENTER);

				Thread.sleep(1000);

				driver.findElement(By
						.xpath("(//colgroup[@id='content-tcolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
								+ i + "']//td[@data-colindex='3']"))
						.click();

				waitForElement(driver, targetStartPoint);

				clear_Click_SendKeys(driver, 5, targetStartPoint,
						TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[1].configuration.columns[" + i + "].startPosition"));

				driver.findElement(By.xpath("//input[@id='tcolGridstartPosition']")).sendKeys(Keys.ENTER);

				Thread.sleep(1000);

				driver.findElement(By
						.xpath("(//colgroup[@id='content-tcolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='"
								+ i + "']//td[@data-colindex='4']"))
						.click();

				waitForElement(driver, targetEndPoint);

				clear_Click_SendKeys(driver, 5, targetEndPoint, TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
						jsonEntity, "$.objects[1].configuration.columns[" + i + "].endPosition"));

				driver.findElement(By.xpath("//input[@id='tcolGridendPosition']")).sendKeys(Keys.ENTER);

				String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.columns[" + i + "].datatype");

				if (!val.equalsIgnoreCase("Text")) {
					Thread.sleep(1000);

					driver.findElement(By.xpath(
							"(//colgroup[@id='content-tcolGridcolgroup']//following::tbody)[1]//tr[@data-rowindex='" + i
									+ "']//td[@data-colindex='2']"))
							.click();

					displayAndClick(driver, returnElement(engineTypeSelectOption, "$name", val));
				}

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void changeDataTypeForSourceDelimitedFile(String jsonEntity) throws InterruptedException {

		try {

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[0].configuration.columns..name");

			int i;

			for (i = 0; i < list.size(); i++) {

				String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"objects[0].configuration.columns[" + i + "].datatype");

				int j = i + 1;

				if (!val.equalsIgnoreCase("Text")) {

					WebElement ele = driver.findElement(By.xpath(
							"((//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@aria-rowindex='"
									+ j + "']//td[@data-colindex='2']//span)[2]"));

					javascript(driver, "arguments[0].scrollIntoView(true);", ele);

					Thread.sleep(1000);

					ele.click();

					Thread.sleep(1000);

					displayAndClick(driver, returnElement(engineTypeSelectOption, "$name", val));

					if (val.equalsIgnoreCase("Date") || val.equalsIgnoreCase("Time")
							|| val.equalsIgnoreCase("Timestamp")) {
						WebElement format = driver.findElement(By.xpath(
								"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@aria-rowindex='"
										+ j + "']//td[@data-colindex='5']"));

						Thread.sleep(1000);

						format.click();

						Thread.sleep(1000);

						String formatVal = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"objects[0].configuration.columns[" + i + "].format");

						displayAndClick(driver, returnElement(formatTypeSelectOption, "$name", formatVal));

					}

				}

				Thread.sleep(1000);

			}
			WebElement ele1 = driver.findElement(By.xpath(
					"((//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@aria-rowindex='1']//td[@data-colindex='2']//span)[2]"));

			javascript(driver, "arguments[0].scrollIntoView(true);", ele1);

			Thread.sleep(2000);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void changeDataTypeForTargetDelimitedFile(String jsonEntity) throws InterruptedException {

		try {

			ArrayList<String> list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.payload.info.objects[5].configuration.columns..columnName");

			int i;

			for (i = 0; i < list.size(); i++) {

				String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.payload.info.objects[0].configuration.columns[" + i + "].datatype");

				if (!val.equalsIgnoreCase("String")) {
					driver.findElement(By.xpath(
							"(//colgroup[@id='content-scolGridcolgroup']//following::tbody)[1]//tr[@aria-rowindex='" + i
									+ "']//td[@aria-colindex='2']"))
							.click();

					Thread.sleep(2000);

					displayAndClick(driver, returnElement(engineTypeSelectOption, "$name", val));
				}

				Thread.sleep(2000);

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void connectionSchemaTablePath(By locator, String path) {
		try {
			String mess = getAttribute(driver, locator, "value");

			BaseSuite.validationReportLog("Retrived Message for is :" + mess);

			BaseSuite.validationReportLog("Expected Message for is :" + path.trim());

			if (!mess.isEmpty()) {

				if (mess.trim().equalsIgnoreCase(path.trim())) {

					BaseSuite.validationReportLog(" Message Successfully Matched");
				} else {
					BaseSuite.reportFailLog(" Messages didn't match", "captureLoginMsg");

				}

			} else {
				BaseSuite.reportFailLog(" Messages didn't match", "captureLoginMsg");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void previewData(By locator) throws Exception, InterruptedException {
		try {
			BaseSuite.reportLog("Clicking on Get data button");

			Actions a = new Actions(driver);

			Thread.sleep(2000);

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			isDisplayed(driver, locator);

			Thread.sleep(3000);

			isDisplayed(driver, locator);

			wait.until(ExpectedConditions.elementToBeClickable(locator));

			javascript(driver, "arguments[0].click();", locator);

			Thread.sleep(1000);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Get data button clicked successfully");

			if (isDisplayed(driver, toastMsgCon)) {
				String validMess = getText(driver, toastMsg).trim();

				if (!validMess.equalsIgnoreCase(ruleSuccessMsg)) {
					captureToastMsg(driver, toastMsg, popUpClose, "", "Connection Test");

					throw new Exception("Facing issues with the preview data,Kindly check!");

				}

			}

		} catch (Exception e) {

			throw new Exception("Facing issues with the preview data,Kindly check!");
		}
	}

	public void refreshData(By locator) throws Exception, InterruptedException {
		try {
			BaseSuite.reportLog("Clicking on Refresh data button");

			Actions a = new Actions(driver);

			Thread.sleep(2000);

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			isDisplayed(driver, locator);

			Thread.sleep(3000);

			isDisplayed(driver, locator);

			wait.until(ExpectedConditions.elementToBeClickable(locator));

			javascript(driver, "arguments[0].click();", locator);

			Thread.sleep(1000);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Refresh data button clicked successfully");

		} catch (Exception e) {

			throw new Exception("");
		}
	}

	public void filePreviewData(By locator) throws Exception, InterruptedException {
		try {

			BaseSuite.reportLog("Clicking on Get data button");

			Actions a = new Actions(driver);

			javascript(driver, "arguments[0].scrollIntoView(true);", locator);

			isDisplayed(driver, locator);

			wait.until(ExpectedConditions.elementToBeClickable(locator));

			javascript(driver, "arguments[0].click();", locator);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Get data button clicked successfully");

			if (isDisplayed(driver, toastMsgCon)) {
				throw new Exception("Facing issues with the file preview data,Kindly check!");
			}

			verifyFileTableList();

		} catch (Exception e) {

			throw new Exception("");
		}
	}

	public void cancleButton() {
		BaseSuite.reportLog("Clicking on Cancle button");

		displayAndClick(driver, cancleButton);

		BaseSuite.validationReportLog("Cancle button clicked successfully");
	}

	public void nextButton(By locator) {

		BaseSuite.reportLog("Clicking on Source/Target Dataset Next button");

		isDisplayed(driver, locator);

		javascript(driver, "arguments[0].click();", locator);

		inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

		BaseSuite.validationReportLog("Source/Target Dataset Next button clicked successfully");
	}

	public void dataButton(By locator) {

		BaseSuite.reportLog("Clicking on Source/Target Dataset Data button");

		isDisplayed(driver, locator);

		displayAndClick(driver, locator);

		BaseSuite.validationReportLog("Source/Target Dataset Data button clicked successfully");
	}

	public String testButton(By locator) {

		String mess = null;

		try {

			BaseSuite.reportLog("Clicking on Test button");

			displayAndClick(driver, locator);

			BaseSuite.reportLog("Test button clicked successfully");

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			isDisplayed(driver, toastMsg);

			mess = getText(driver, toastMsg);

			captureToastMsg(driver, toastMsg, popUpClose, connectionTestMess, "Connection Test");

		} catch (Exception e) {

			e.getMessage();
		}
		return mess;
	}

	public void editButton(By locator) {

		try {
			BaseSuite.reportLog("Clicking on Edit button");

			displayAndClick(driver, locator);

			BaseSuite.validationReportLog("Edit button clicked successfully");

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void getFiles(String fileFolderName, String fileName) {
		BaseSuite.reportLog("Clicking on Get Files button");

		displayAndClick(driver, getFile);

		BaseSuite.reportLog("Get Files button clicked successfully");

		inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

		javascript(driver, "arguments[0].scrollIntoView(true);",
				returnElement(selectFileFolder, "$name", fileFolderName));

		BaseSuite.reportLog("Clicking on " + fileFolderName + " Folder to select file");

		displayAndClick(driver, returnElement(selectFileFolder, "$name", fileFolderName));

		BaseSuite.reportLog(fileFolderName + " Folder clicked successfully to select file");

		inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

		javascript(driver, "arguments[0].scrollIntoView(true);", returnElement(selectFile, "$name", fileName));

		BaseSuite.reportLog("Clicking on " + fileName + " File from " + fileFolderName + " Folder");

		displayAndClick(driver, returnElement(selectFile, "$name", fileName));

		BaseSuite.reportLog(fileName + " File from " + fileFolderName + " Folder selected successfully");

		javascript(driver, "arguments[0].scrollIntoView(true);", selectBottom);

		BaseSuite.reportLog("Clicking on Select button");

		displayAndClick(driver, selectBottom);

		BaseSuite.reportLog("Select button clicked successfully");

	}

	// Use for new rule data======Excel
	public void addJoins(String joinColName) throws Exception, InterruptedException {

		try {
			clickOnDiffJoin();

			Thread.sleep(2000);

			if (!joinColName.isEmpty()) {

				int count = getcount(joinColName, ',');

				String[] result = joinColName.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String joinCol1 = result[colNum];

					String[] joins = joinCol1.split("=");

					String sourceJoin = joins[0];

					String targetJoin = joins[1];

					if (!sourceJoin.isEmpty() || !targetJoin.isEmpty()) {

						javascript(driver, "arguments[0].scrollIntoView(true);",
								returnElement(joinSourceColName, "$name", sourceJoin));

						BaseSuite.reportLog("Applying join on source and target side");

						dragAndDrop(driver, returnElement(joinSourceColName, "$name", sourceJoin),
								returnElement(joinTargetColName, "$name", targetJoin));

						BaseSuite.validationReportLog("Join successfully applied on source " + sourceJoin
								+ " column and " + targetJoin + " ");

					}
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	// Use for existing rule data=====API
	public void addJoins(int colPosition, String scrJoin, String trgJoin) throws Exception, InterruptedException {

		try {
			clickOnDiffJoin();

			String val = getText(driver, sourceTargetJoinMess);

			if (val.equals(sourceTargetJoinText)) {

				BaseSuite.validationReportLog("Source join and Target join headline matched successfully");

			} else {

				BaseSuite.reportFailLog("Source join and Target join headline not matched", "addJoins");
			}

			Thread.sleep(2000);

			String scr1 = scrJoin.toUpperCase();

			String scr2 = scrJoin.toLowerCase();

			String trg1 = trgJoin.toUpperCase();

			String trg2 = trgJoin.toLowerCase();

			verifyVisibilityOfButtons(driver, connect, "Connect Button", true);

			if (colPosition == 0) {
				verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", false);

				verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", false);

			}

			if (!scrJoin.isEmpty() || !trgJoin.isEmpty()) {

				BaseSuite.reportLog("Applying join on source and target side");

				if (isDisplayed(driver, returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2))) {
					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2));

					displayAndClick(driver, returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2));

					displayAndClick(driver, returnTwoElements(joinTargetColName, "$name1", trg1, "$name2", trg2));

				} else if (isDisplayed(driver, returnElement(joinSourceColNameTranslate, "$name", scr2))) {

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(joinSourceColNameTranslate, "$name", scr2));

					displayAndClick(driver, returnElement(joinSourceColNameTranslate, "$name", scr2));

					displayAndClick(driver, returnElement(joinTargetColNameTranslate, "$name", trg2));

				} else {

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(joinSourceColName, "$name1", scrJoin));

					displayAndClick(driver, returnElement(joinSourceColName, "$name1", scrJoin));

					displayAndClick(driver, returnElement(joinTargetColName, "$name1", trgJoin));
				}

				verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", true);

				verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", true);

				BaseSuite.validationReportLog(
						"Join successfully applied on source " + scrJoin + " column and " + trgJoin + " ");

			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	// Use for existing rule data=====API
	public void updateJoins(int colPosition, String scrJoin, String trgJoin) throws Exception, InterruptedException {

		try {
			clickOnDiffJoin();

			if (colPosition == 0) {
				displayAndClick(driver, disconnectAll);
			}

			String val = getText(driver, sourceTargetJoinMess);

			if (val.equals(sourceTargetJoinText)) {

				BaseSuite.validationReportLog("Source join and Target join headline matched successfully");

			} else {

				BaseSuite.reportFailLog("Source join and Target join headline not matched", "addJoins");
			}

			Thread.sleep(2000);

			String scr1 = scrJoin.toUpperCase();

			String scr2 = scrJoin.toLowerCase();

			String trg1 = trgJoin.toUpperCase();

			String trg2 = trgJoin.toLowerCase();

			verifyVisibilityOfButtons(driver, connect, "Connect Button", true);

			if (colPosition == 0) {
				verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", false);

				verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", false);

			}

			if (!scrJoin.isEmpty() || !trgJoin.isEmpty()) {

				BaseSuite.reportLog("Applying join on source and target side");

				if (isDisplayed(driver, returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2))) {
					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2));

					displayAndClick(driver, returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2));

					displayAndClick(driver, returnTwoElements(joinTargetColName, "$name1", trg1, "$name2", trg2));

				} else {

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(joinSourceColName, "$name1", scrJoin));

					displayAndClick(driver, returnElement(joinSourceColName, "$name1", scrJoin));

					displayAndClick(driver, returnElement(joinTargetColName, "$name1", trgJoin));
				}

				verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", true);

				verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", true);

				BaseSuite.validationReportLog(
						"Join successfully applied on source " + scrJoin + " column and " + trgJoin + " ");

			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void joinAll() {
		try {
			BaseSuite.reportLog("Clicking on ConnectAll button");

			displayAndClick(driver, diffJoinConnectAll);

			BaseSuite.validationReportLog("ConnectAll button clicked successfully");
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void disconnectAll() {
		try {
			BaseSuite.reportLog("Clicking on DisconnectAll button");

			displayAndClick(driver, diffJoinDisConnectAll);

			BaseSuite.validationReportLog("DisconnectAll button clicked successfully");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void addAllAsExpression() {
		try {
			BaseSuite.reportLog("Clicking on Add All As Expression button");

			displayAndClick(driver, diffJoinDisConnectAll);

			BaseSuite.validationReportLog("Add All As Expression button clicked successfully");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Rahul's Code
	// ThisMethod is use to click on the new folder and Existing folder option
	public void clickOnAddNewFolderOrExistingOne(DataTestingParameters param) throws InterruptedException {
		try {
			List<WebElement> ele = driver.findElements(folderList);

			boolean flag = false;

			for (WebElement e : ele) {

				String val = e.getText();

				if (val.equals(param.getFolderName())) {

					flag = true;

					displayAndClick(driver, returnElement(selectExistingFolder, "$name", param.getFolderName()));

					inVisible(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Existing folder selected Successfully");

					break;

				}

			}

			if (flag == false) {

				Thread.sleep(2000);

				wait.until(ExpectedConditions.elementToBeClickable(addNewFolderButton)).click();

				// displayAndClick(driver, addNewFolderButton);

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Clicked on Add New Folder ");

				sendKeys(driver, enterNewFolderName, param.getFolderName());

				Thread.sleep(2000);

				driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

				// displayAndClick(driver, enterNewFolderName);

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				captureToastMsg(driver, toastMsg, toastMsgClosedBtn, folderCreatedMessText, "Folder Created");

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("New Folder Created Successfully");

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	// This Method is use to click on the new folder and Existing folder
	// option=========For API

	public void clickOnAddNewFolderOrExistingOneAPI(DataTestingParameters param, String workspaceID, String ruleName,
			String icedqRole) throws InterruptedException {
		try {

			String folder = TestDataThroughApi.getfolderNameUsingFolderList(workspaceID, ruleName, icedqRole);

			String str = folder.replace("/", " ");

			String str1 = str.trim();

			int count = getcount(str1, ' ');

			String[] result = str1.split(" ");

			for (int colNum = 0; colNum <= count; colNum++) {

				String folderName = result[colNum];

				List<WebElement> ele = driver.findElements(folderList);

				boolean flag = false;

				for (WebElement e : ele) {

					String val = e.getText();

					if (val.equalsIgnoreCase(folderName)) {

						flag = true;

						Thread.sleep(2000);

						displayAndClick(driver, returnElement(selectExistingFolder, "$name", folderName));

						inVisible(driver, datasetSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Existing folder selected Successfully");

						break;

					}

				}

				if (flag == false) {

					displayAndClick(driver, addNewFolder);

					inVisible(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Clicked on Add New Folder ");

					sendKeys(driver, enterNewFolderName, folderName);

					Thread.sleep(1000);

					driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

					captureToastMsg(driver, toastMsg, toastMsgClosedBtn, folderCreatedMessText,
							"Folder created Message.");

					inVisible(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Clicked on outside the Text Box");

					inVisible(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("New Folder Created Successfully");

					if (count > 0) {

						displayAndClick(driver, returnElement(selectExistingFolder, "$name", folderName.trim()));

						displayAndClick(driver, addsubFolder);

						BaseSuite.validationReportLog("Clicked on Add New SubFolder ");

						inVisible(driver, datasetSpinner, Constant.ruleWait);

						sendKeys(driver, enterNewFolderName, folderName);

						driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

						BaseSuite.validationReportLog("New Child Folder Created Successfully");

					}

				}
				break;
			}

		}

		catch (Exception e) {

			e.getMessage();

		}
	}

	public void folderSelectOnAdvanceFilter(String folderName) {

		try {
			String folder = null;

			BaseSuite.reportLog("Selecting folder");

			int count = getcount(folderName, '/');

			String[] result = folderName.split("/");

			for (int colNum = 0; colNum <= count; colNum++) {

				folder = result[colNum];

				if (!folder.isEmpty()) {
					BaseSuite.reportLog("Searching for folder " + folder);

					displayAndClick(driver, advanceFolderSearch);

					clear(driver, advanceFolderSearch);

					sendKeys(driver, advanceFolderSearch, folder);

					displayAndClick(driver, advanceFolderSearchBarButton);

					displayAndClick(driver, returnElement(advanceFolderNameClick, "$name", folder));

					inVisible(driver, datasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog(folder + " Folder searched successfully");
				}

			}

			displayAndClick(driver, returnElement(folderCheckBox, "$name", folder));

			inVisible(driver, datasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Folder selected successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	/*
	 * public void clearall() { try {
	 * BaseSuite.validationReportLog("Click on ClearAll");
	 * 
	 * displayAndClick(driver, clearAll);
	 * 
	 * inVisible(driver, datasetSpinner, Constant.ruleWait);
	 * 
	 * BaseSuite.validationReportLog("Clear All clicked successfully"); } catch
	 * (Exception e) { e.getMessage(); }
	 * 
	 * }
	 */

	// This method is use to click on New Rule Button

	public void clickOnNewRule() {

		try {

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			if (isEnabled(driver, newRuleBtn)) {

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				actions.moveToElement(driver.findElement(newRuleBtn)).perform();

				wait.until(ExpectedConditions.visibilityOfElementLocated(newRuleBtn));

				actions.click(driver.findElement(newRuleBtn)).build().perform();

				BaseSuite.reportLog("New Rule Button visible on Page");

				BaseSuite.reportLog("click on New Rule Button");

				BaseSuite.validationReportLog("New Rule Button Clicked");
			} else {
				BaseSuite.reportFailLog("New Rule Button is not visible", "newRuleBtn");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}
	// This Method is use to check New Rule pane functionality

	public void enterDetailsInAddNewPane(DataTestingParameters param) throws InterruptedException {
		try {
			clickOnNewRule();
			// validation checks for Add new Rule pane

			if (isDisplayed(driver, addNewRuleText)) {
				String val = getText(driver, addNewRuleText);
				BaseSuite.validationReportLog(val + " Text is displayed clearly ");
			} else {
				BaseSuite.reportFailLog("AddNewRuleText is fail to display", "addNewRuleText");
			}
			String value = getAttribute(driver, wksfoldertext, "text");
			BaseSuite.validationReportLog(" Folder Label Text is displayed clearly ");

			if (isEnabled(driver, workspacefolder)) {
				String val4 = getAttribute(driver, workspacefolder, "title");
				BaseSuite.validationReportLog(" Selected Folder displayed clearly ");
			} else {
				BaseSuite.reportFailLog("folder is fail to display", "workspacefolder");
			}
			if (isDisplayed(driver, ruleNameText)) {
				String val5 = getText(driver, ruleNameText);
				BaseSuite.validationReportLog(val5 + " Text is displayed clearly ");
			} else {
				BaseSuite.reportFailLog("Rule Name text is fail to display", "ruleNameText");
			}

			if (isDisplayed(driver, rulenameinnertext)) {
				String val1 = getAttribute(driver, rulenameinnertext, "value");
				BaseSuite.validationReportLog(val1 + " Text is displayed clearly ");
			} else {
				BaseSuite.reportFailLog("Rule Name inner text is fail to display", "rulenameinnertext");
			}
			if (isDisplayed(driver, engineTypeText)) {
				String val2 = getText(driver, engineTypeText);
				BaseSuite.validationReportLog(val2 + " Text is displayed clearly ");
			} else {
				BaseSuite.reportFailLog("engineType Text is fail to display", "engineTypeText");
			}
			if (isDisplayed(driver, engineTypeinnerText)) {
				String val2 = getAttribute(driver, engineTypeinnerText, "text");
				BaseSuite.validationReportLog("Internal Text is displayed clearly ");
			} else {
				BaseSuite.reportFailLog("engineType Text is fail to display", "engineTypeinnerText");
			}
			if (isDisplayed(driver, chooseTemplateText)) {
				String val3 = getText(driver, chooseTemplateText);
				BaseSuite.validationReportLog(val3 + " Text is displayed clearly ");
				List<WebElement> qwerty = driver.findElements(
						By.xpath("//ejs-sidebar[@id='default1']//input[@type='radio']//following::label"));
				for (int i = 0; i < qwerty.size(); i++) {

					String vals = qwerty.get(i).getText();

					qwerty.get(i);
					BaseSuite.validationReportLog(vals + " Template is clearly visible ");
				}
			} else {
				BaseSuite.reportFailLog("chooseTemplate Text is fail to display", "chooseTemplateText");
			}
			verifyVisibilityOfButtons(driver, cancelButton, "cancel button", true);

			// Fuctional validation check

			BaseSuite.reportLog("clicking on path");

			javascript(driver, "arguments[0].click();", pathSelect);

			BaseSuite.validationReportLog(" path clicked successfully ");

			if (isEnabled(driver, pathTree)) {
				Thread.sleep(2000);

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnElement(validScrollFolder, "$name", param.getFolderName()));

				clear_Click_SendKeys(driver, 10, addNewSearchBar, param.getFolderName());

				click(driver, addNewPanSearchBarButton);

				click(driver, returnElement(validScrollFolder, "$name", param.getFolderName()));

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				String folder = getText(driver, returnElement(validScrollFolder, "$name", param.getFolderName()));

				Thread.sleep(2000);

				if (folder.trim().equalsIgnoreCase(param.getFolderName().trim())) {
					BaseSuite.validationReportLog(param.getFolderName() + " Folder is visble");

					BaseSuite.reportLog("clicking on select Button");

					// click(driver, selectBtn);

					BaseSuite.validationReportLog(" Select Button clicked successfully ");
				} else {
					BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");
				}

				if (!param.getRuleName().isEmpty()) {

					String rulenamecapture = getAttribute(driver, nameRule, "value");
					BaseSuite.validationReportLog(rulenamecapture + " Rule Name Text is displayed clearly ");
					inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				} else {
					BaseSuite.reportLog("Click on Rule Name");

					clear_SendKeys(driver, nameRule, param.getRuleName());

					inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Rule Name field is visible and Editable");

				}
				BaseSuite.reportLog("Click on Engine Type option");

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				displayAndClick(driver, engineType);

				javascript(driver, "arguments[0].click();", engineType);

				BaseSuite.validationReportLog("Engine Type option Clicked successfully");

				BaseSuite.reportLog("Engine Type option clicked");

				javascript(driver, "arguments[0].click();",
						returnElement(engineTypeSelectOption, "$name", param.getEngineTypeOption()));

				BaseSuite.validationReportLog(param.getEngineTypeOption() + " Engine Type option clearly visible");

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				BaseSuite.reportLog("Choosed Template");

				Thread.sleep(1000);

				displayAndClick(driver, returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));

				BaseSuite.validationReportLog(param.getRuleType() + " Template Selected successfully");

			} else {
				BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");

			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

// This Method is use to check New Rule pane functionality===============through
// API

	public void enterDetailsInAddNewPaneAPI(DataTestingParameters param, String workspaceID, String ruleName,
			String icedqRole, String ruleCreateFolder) throws Exception {

		String folder = null;

		String folderName;

		try {

			if (ruleCreateFolder.isEmpty()) {

				folderName = TestDataThroughApi.getfolderNameUsingFolderList(workspaceID, ruleName, icedqRole);

			} else {

				folderName = ruleCreateFolder;

			}

			clickOnNewRule();

			Thread.sleep(2000);

			BaseSuite.reportLog("clicking on path");

			javascript(driver, "arguments[0].click();", pathSelect);

			BaseSuite.validationReportLog(" path clicked successfully");

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			if (isDisplayed(driver, pathTree)) {
				Thread.sleep(2000);

				String str = folderName.replace("/", " ");

				String str1 = str.trim();

				// String str1=str.strip();

				int count = getcount(str1, ' ');

				String[] result = str1.split(" ");

				for (int colNum = 0; colNum <= count; colNum++) {

					folder = result[colNum];

					if (!folderName.isBlank()) {

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

						waitForElement(driver, (returnElement(validScrollFolder, "$name", folder)));

						javascript(driver, "arguments[0].scrollIntoView(true);",
								returnElement(validScrollFolder, "$name", folder));

						if (colNum == 0) {
							clear_Click_SendKeys(driver, 10, addNewSearchBar, folder);

							click(driver, addNewPanSearchBarButton);

							Thread.sleep(2000);

						}

						click(driver, returnElement(validScrollFolder, "$name", folder));

						Thread.sleep(2000);

						inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

					}

				}

				click(driver, returnElement(folderselectBtn, "$name", folder));

				BaseSuite.validationReportLog("Folder option Clicked successfully");

				BaseSuite.validationReportLog(" Select Folder clicked successfully ");

			} else {

				BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");
			}

			if (!param.getRuleName().isEmpty()) {
				BaseSuite.reportLog("Click on Rule Name");

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				clear_Click_SendKeys(driver, 10, nameRule, param.getRuleName());
				BaseSuite.reportLog("Entered Rule name :: " + param.getRuleName());
				BaseSuite.validationReportLog("Rule Name field is visible and Editable");

			}
			BaseSuite.reportLog("Click on Engine Type option");

			inVisible(driver, datasetSpinner, Constant.ruleWait);

			displayAndClick(driver, engineType);

			javascript(driver, "arguments[0].click();", engineType);

			BaseSuite.validationReportLog("Engine Type option Clicked successfully");

			BaseSuite.reportLog("Engine Type option clicked");

			javascript(driver, "arguments[0].click();",
					returnElement(engineTypeSelectOption, "$name", param.getEngineTypeOption()));

			BaseSuite.validationReportLog("Engine Type option clearly visible");

			BaseSuite.reportLog("Choosed Template");

			javascript(driver, "arguments[0].scrollIntoView(true);",
					returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));

			displayAndClick(driver, returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));

			inVisible(driver, datasetSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog(param.getRuleType() + " Template Selected successfully");

//			validationcheckforvisibility(param, "input");

		} catch (java.lang.Exception e) {

			BaseSuite.reportLog(e.toString());

		}

	}

	public void validationcheckforvisibility(DataTestingParameters param) throws InterruptedException {
		try {
			// Buttons validation check

			inVisible(driver, datasetSpinner, Constant.ruleWait);

			if (isEnabled(driver, ruleRunButton)) {

				BaseSuite.reportFailLog("Run Button is Enable", "validationcheckforvisibility");

			} else {

				BaseSuite.validationReportLog("Run Button is disable");

			}

			if (isEnabled(driver, deleteButton)) {

				BaseSuite.reportFailLog("Delete Button is Enable", "validationcheckforvisibility");
			} else {

				BaseSuite.validationReportLog("Delete Button is Enable");

			}

			if (isEnabled(driver, moreButton)) {

				BaseSuite.reportFailLog("More Button is disable", "validationcheckforvisibility");

			} else {

				BaseSuite.validationReportLog("More Button is Enable");

			}

			verifyVisibilityOfButtons(driver, publishButton, "Publish button", true);

			Thread.sleep(2000);

			verifyVisibilityOfButtons(driver, discardDetailButton, "Discard button", false);

			if (param.getRuleType().equalsIgnoreCase("Validation")
					|| param.getRuleType().equalsIgnoreCase("pushdown")) {

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, sourcedataset_buttons, "Source button", true);

				String checkButton = getAttribute(driver, checks_buttons, "class");

				if (checkButton.contains("disable")) {
					BaseSuite.validationReportLog("Check node disable on the page");
				} else {
					BaseSuite.reportFailLog("Check node enable on the page", "validationcheckforvisibility");
				}

				String exceptionRportButton = getAttribute(driver, exceptionReport_buttons, "class");

				if (exceptionRportButton.contains("disable")) {
					BaseSuite.validationReportLog("Exception Report node disable on the page");
				} else {
					BaseSuite.reportFailLog("Exception Report node enable on the page", "validationcheckforvisibility");
				}

				String summaryButton = getAttribute(driver, summary_buttons, "class");

				if (summaryButton.contains("disable")) {
					BaseSuite.validationReportLog("Summary node disable on the page");
				} else {
					BaseSuite.reportFailLog("Summary node enable on the page", "validationcheckforvisibility");
				}

			}

			else if (param.getRuleType().equalsIgnoreCase("checksum")) {

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, sourcedataset_buttons, "Source button", true);

				verifyVisibilityOfButtons(driver, targetDataset_buttons, "Target button", true);

				String checkButton = getAttribute(driver, checks_buttons, "class");

				if (checkButton.contains("disable")) {
					BaseSuite.validationReportLog("Check node disable on the page");
				} else {
					BaseSuite.reportFailLog("Check node enable on the page", "validationcheckforvisibility");
				}

				String summaryButton = getAttribute(driver, summary_buttons, "class");

				if (summaryButton.contains("disable")) {
					BaseSuite.validationReportLog("Summary node disable on the page");
				} else {
					BaseSuite.reportFailLog("Summary node enable on the page", "validationcheckforvisibility");
				}

			} else if (param.getRuleType().equalsIgnoreCase("Recon")) {

				inVisible(driver, datasetSpinner, Constant.ruleWait);

				verifyVisibilityOfButtons(driver, sourcedataset_buttons, "Source button", true);

				verifyVisibilityOfButtons(driver, targetDataset_buttons, "Target button", true);

				String diffJoin = getAttribute(driver, diffJoin_buttons, "class");

				if (diffJoin.contains("disable")) {
					BaseSuite.validationReportLog("Diff join node disable on the page");
				} else {
					BaseSuite.reportFailLog("Diff join node enable on the page", "validationcheckforvisibility");
				}

				String checkButton = getAttribute(driver, checks_buttons, "class");

				if (checkButton.contains("disable")) {
					BaseSuite.validationReportLog("Check node disable on the page");
				} else {
					BaseSuite.reportFailLog("Check node enable on the page", "validationcheckforvisibility");
				}

				String exceptionRportButton = getAttribute(driver, exceptionReport_buttons, "class");

				if (exceptionRportButton.contains("disable")) {
					BaseSuite.validationReportLog("Exception Report node disable on the page");
				} else {
					BaseSuite.reportFailLog("Exception Report node enable on the page", "validationcheckforvisibility");
				}

				String summaryButton = getAttribute(driver, summary_buttons, "class");

				if (summaryButton.contains("disable")) {
					BaseSuite.validationReportLog("Summary node disable on the page");
				} else {
					BaseSuite.reportFailLog("Summary node enable on the page", "validationcheckforvisibility");
				}

			}

		} catch (Exception e) {
		}

	}

	// validate the overview section Title
	public void overviewlabelvalidate() {
		try {

			if (isDisplayed(driver, overviewlabel)) {

				String val = getText(driver, overviewlabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

			} else {

				BaseSuite.reportFailLog("overview label is fail to display", "overviewlabel");
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	// This Method is use to Enter the Rule Name in Overview
	public void rulename(DataTestingParameters param, String connName) {
		try {
			if (isDisplayed(driver, rulenameLabel)) {

				String val = getText(driver, rulenameLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (param.getRuleName().isEmpty()) {

					String checkrule = getAttribute(driver, ruleNameField, "value");

					BaseSuite.validationReportLog(checkrule + " _Rule Name Text is displayed clearly ");
				} else {

					BaseSuite.reportLog("Entering rule name");

					clear_SendKeys(driver, ruleNameField, param.getRuleName() + " " + connName);

					inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

					BaseSuite.validationReportLog("Rule name entered successfully");

				}
			}
		} catch (Exception e) {

			throw new Exception("Not able to enter rule name,Kindly check!");
		}
	}

	// This Method is use to Enter the Rule Code in Overview
	public void RuleCode(DataTestingParameters param) {

		try {
			if (isDisplayed(driver, rulecodeLabel)) {
				String val = getText(driver, rulecodeLabel);
				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (!param.getRuleCode().isEmpty()) {
					if (isDisplayed(driver, rulecodeField))

						displayAndClick(driver, rulecodeField);

					BaseSuite.reportLog("Entering code in Rule code field");

					sendKeys(driver, rulecodeField, param.getRuleCode());

					String checkrulecode = getAttribute(driver, rulecodeField, "value");

					BaseSuite.validationReportLog(checkrulecode + " Code Entered in Rule code field");

				}
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	// This Method is use to enter details in Degree of parallelism(DOP)
	public void DegreeOfPeralleilsm(DataTestingParameters param) {
		try {
			if (isDisplayed(driver, dopLabel)) {
				String val = getText(driver, dopLabel);
				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");
			}
			int count1 = 1;
			if (Integer.parseInt(param.getDop()) < count1) {
				if (!param.getDop().isEmpty()) {

					BaseSuite.validationReportLog("Entering Value in DOP");

					sendKeys(driver, dopField, param.getDop());

					BaseSuite.validationReportLog("Entered Value in DOP successfully");

				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String scriptParseButton() throws Throwable {
		String mess = null;

		try {

			isDisplayed(driver, scriptParseButton);
			Thread.sleep(2000);
			clickOnButton(driver, scriptParseButton, "Parse Button", true);

			inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			isDisplayed(driver, toastMsg);
			mess = getText(driver, toastMsg);

			captureToastMsg(driver, toastMsg, popUpClose, scriptParseMsg, "Script Parse");

		} catch (Exception e) {
			e.getMessage();
		}

		return mess;
	}

	public String generateColumnCheckExpForPushdown(String columnName) {
		String gen_colChkExp = null;
		try {
			gen_colChkExp = "s.[" + columnName + "]";
			System.out.println(gen_colChkExp);

		} catch (Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}

		return gen_colChkExp.toUpperCase();

	}

	public DataTestingParameters setTestcaseParameter() throws Exception {
		DataTestingParameters param = new DataTestingParameters();

		param.setFolderName(foldername);
		param.setRuleName(valRuleName);
		param.setEngineTypeOption(vengineType);
		param.setRuleType(valTemplate);

		return param;
	}

	public boolean addCalculatedColumnInRule(String checkName, String checkStatus, String chkExpression,
			SoftAssert soft) throws Throwable {

		boolean flag = true;
		try {
			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			String cname = enterCheckName(checkName);

			String st = selectCheckEnableStatus(checkStatus);

			chooseAttributeForCalculatedCheck(chkExpression, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			validateAddedCheckDetails(cname, chkExpression, "Calculated", st, soft);

			flag = selectActiveOrInactiveStatusOfExpression(checkName, "Inactive", soft);

		} catch (Exception e) {

			e.getMessage();
			flag = false;
		}
		return flag;
	}

	/*
	 * public boolean clickOnRunButton(String toastMessage) { boolean flag = true;
	 * try { isDisplayedInLoop(driver, 2, ruleRunButton); if
	 * (verifyVisibilityOfButtons(driver, ruleRunButton, "Run", true)) {
	 * isClickable(driver, ruleRunButton, "Run", true);
	 * BaseSuite.reportLog("Run button is displayed."); displayAndClick(driver,
	 * ruleRunButton);
	 * BaseSuite.validationReportLog("Run button clicked successfully.");
	 * inVisible(driver, spinner, Constant.ruleWait);
	 * BaseSuite.reportLog("Spinner is displayed.");
	 * 
	 * flag = captureToastMsg(driver, toastMsgCon, popUpClose, toastMessage,
	 * "After clicking Run button - DAT-2811");
	 * 
	 * } else { flag = false; }
	 * 
	 * } catch (Exception e) { e.getMessage(); } return flag; }
	 */
	// verify autogenerated Rule name
	public boolean verifyAutogeneratedRuleName() {
		boolean status = false, flag1 = false, flag2 = false;
		try {
			if (isDisplayed(driver, nameRule)) {
				BaseSuite.reportLog("Verifying autogenerated rule in add new rule pane.");
				String ruleName = getAttribute(driver, nameRule, "value");
				String[] str = ruleName.split("_");
				flag1 = isStringOnlyAlphabet(str[0].trim());
				flag2 = isStringHasOnlyDigits(str[1].trim());

				if ((flag1 == true) && (flag2 == true)) {
					System.out.println("Rule name is as per expectation :: " + ruleName);
					status = true;
					BaseSuite.validationReportLog("Rule name is generated correctly.");

				} else {
					System.out.println("Rule name is not as per expectation :: " + ruleName);
					BaseSuite.reportErrorLog("Rule name is not generated as per expectation , kindly check.");

				}

			}

		} catch (Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}
		return status;

	}

	// check string has only alphabets
	public static boolean isStringOnlyAlphabet(String str) {
		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")) && (str.equalsIgnoreCase("rule")));
	}

	// check string has only numbers
	public boolean isStringHasOnlyDigits(String str) {
		return ((!str.equals("")) && (str != null) && (str.matches("[0-9]+") && str.length() > 1));
	}

	// add other details in new rule pane
	public void selectRuleEngineNTemplateDetails(DataTestingParameters param) {
		BaseSuite.reportLog("Click on Engine Type option");

		inVisible(driver, datasetSpinner, Constant.ruleWait);

		displayAndClick(driver, engineType);

		javascript(driver, "arguments[0].click();", engineType);

		BaseSuite.validationReportLog("Engine Type option Clicked successfully");

		BaseSuite.reportLog("Engine Type option clicked");

		// javascript(driver, "arguments[0].click();", //
		returnElement(engineTypeSelectOption, "$name", param.getEngineTypeOption());

		BaseSuite.validationReportLog("Engine Type option clearly visible");

		BaseSuite.reportLog("Choosed Template");

		displayAndClick(driver, returnElement(chooseTemplate, "$name", param.getRuleType().toLowerCase()));

		BaseSuite.validationReportLog(param.getRuleType() + " Template Selected successfully");

	}

	//// User is able to Create Validation rule in Validate mode without details
	public void verifyUserIsUnableToCreateRuleWithoutDetailsInValidateMode(DataTestingParameters param, SoftAssert soft)
			throws Exception, Throwable {
		try {

			DataTestingPage dp = new DataTestingPage(driver);
			dp.clickOnAddNewFolderOrExistingOne(param);
			dp.clickOnNewRule();
			enterFolderDetails(param);
			verifyAutogeneratedRuleName();
			selectRuleEngineNTemplateDetails(param);
			Thread.sleep(1000);
			dp.clickOnRulePublishMenuListIconBtn();
			dp.clickOnValidateMenuOptionBtn(sourceNtSelectedMsg);
			// dp.enterDetailsInSourceSetting("", param, soft);
			dp.clickOnRulePublishMenuListIconBtn();
			dp.clickOnValidateMenuOptionBtn(expNtAddedMsg);

		} catch (Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}
	}

// This Method is use to Enter the Rule Code in Overview
	public void ruleCode(DataTestingParameters param) {

		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", rulecodeLabel);

			if (isDisplayed(driver, rulecodeLabel)) {

				String val = getText(driver, rulecodeLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (param.getRuleCode() != null) {

					BaseSuite.reportLog("Entering code in Rule code field");

					sendKeys(driver, rulecodeField, param.getRuleCode());

					clear_SendKeys(driver, rulecodeField, param.getRuleCode());

					String checkrulecode = getAttribute(driver, rulecodeField, "value");

					BaseSuite.validationReportLog(checkrulecode + " Code Entered in Rule code field");

				}
			} else {
				BaseSuite.reportFailLog("Rule code field is not visible,Kindly check", "criticality");
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter rule code,Kindly check!");
		}
	}

	// This Method is use to Enter the Detailed Description in overview
	public void description(DataTestingParameters param) {

		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", descriptionLabel);

			if (isDisplayed(driver, descriptionLabel)) {

				String val = getText(driver, descriptionLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (param.getDescription() != null) {

					if (isDisplayed(driver, descriptionField)) {

						displayAndClick(driver, descriptionField);

						BaseSuite.reportLog("Entering description in Description field");

						sendKeys(driver, descriptionField, param.getDescription());

						String descriptiondata = getAttribute(driver, descriptionField, "value");

						BaseSuite.validationReportLog(descriptiondata + " Description Entered in description field");
					}
				}

			} else {
				BaseSuite.reportFailLog("Description field is not visible,Kindly check", "criticality");
			}
		} catch (Exception e) {

			throw new Exception("Not able to enter discription,Kindly check!");
		}
	}

	// This Method is to use to filled the purpose field for overview
	public void purpose(DataTestingParameters param) {

		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", purposeLabel);

			if (isDisplayed(driver, purposeLabel)) {

				String val = getText(driver, purposeLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (param.getPurpose() != null) {

					if (isDisplayed(driver, purposeField)) {

						displayAndClick(driver, purposeField);

						BaseSuite.reportLog("Entering Data in Purpose field");

						sendKeys(driver, purposeField, param.getPurpose());

						String purposedata = getAttribute(driver, purposeField, "value");

						BaseSuite.validationReportLog(purposedata + " Data Entered in Purpose field ");

					}

				}
			} else {
				BaseSuite.reportFailLog("Purpose field is not visible,Kindly check", "criticality");
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter purpose,Kindly check!");
		}

	}

	// This Method is to check the criticality of the rule
	public void criticality(DataTestingParameters param) {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", criticalityLabel);

			if (isDisplayed(driver, criticalityLabel)) {

				String val = getText(driver, criticalityLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (!param.getCriticality().isEmpty()) {

					BaseSuite.reportLog("Click on Criticality option");

					javascript(driver, "arguments[0].scrollIntoView(true);", criticalityLabel);

					Actions actions = new Actions(driver);

					wait = waitMethod(driver);

					Thread.sleep(2000);

					actions.moveToElement(driver.findElement(criticalityclick)).perform();

					wait.until(ExpectedConditions.visibilityOfElementLocated(criticalityclick));

					actions.clickAndHold(driver.findElement(criticalityclick)).build().perform();

					Thread.sleep(2000);

					BaseSuite.validationReportLog("Criticality option Clicked successfully");

					displayAndClick(driver, returnElement(criticalityselect, "$name", param.getCriticality()));

					String criticalitydata = driver
							.findElement(By.xpath("//span[@formcontrolname='criticality']//select//option"))
							.getAttribute("text");

					BaseSuite.validationReportLog(" Ciriticality option Selected " + criticalitydata);

				}
			} else {
				BaseSuite.reportFailLog("Criticality field is not visible,Kindly check", "criticality");
			}

		} catch (java.lang.Exception e) {

			throw new Exception("Not able to enter criticality,Kindly check!");
		}
	}

	// This Method is to check the severity of the rule
	public void severity(DataTestingParameters param) {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", severityLabel);

			if (isDisplayed(driver, severityLabel)) {

				String val = getText(driver, severityLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (!param.getSeverity().isEmpty()) {

					BaseSuite.reportLog("Click on Severity option");

					javascript(driver, "arguments[0].scrollIntoView(true);", severityLabel);

					Actions actions = new Actions(driver);

					wait = waitMethod(driver);

					Thread.sleep(2000);

					actions.moveToElement(driver.findElement(severityclick)).perform();

					wait.until(ExpectedConditions.visibilityOfElementLocated(severityclick));

					actions.click(driver.findElement(severityclick)).build().perform();

					Thread.sleep(2000);

					BaseSuite.validationReportLog("Severity option Clicked successfully");

					String var = param.getSeverity().replaceAll("[\\[\\](){}]", "");

					displayAndClick(driver, returnElement(severitySelect, "$name", var));

					String severitydata = getAttribute(driver, severityclick, "class");

					BaseSuite.validationReportLog(" Severity option Selected " + severitydata);

				}
			} else {
				BaseSuite.reportFailLog("Severity field is not visible,Kindly check", "severity");
			}

		} catch (java.lang.Exception e) {

			throw new Exception("Not able to enter Severity,Kindly check!");
		}
	}

	// This Method is to use click on the Stop At Row option
	public void stopAtRow(DataTestingParameters param) {
		try {
			if (isDisplayed(driver, stopAtRowLabel)) {

				String val = getText(driver, stopAtRowLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				int count = 0;

				if (param.getStopAtRow() != null) {
					if (Integer.parseInt(param.getStopAtRow()) > count) {

						javascript(driver, "arguments[0].scrollIntoView(true);", stopAtRowField);

						sendKeys(driver, stopAtRowField, param.getStopAtRow());

						String val1 = getText(driver, stopAtRowField);

						BaseSuite.validationReportLog(val1 + "Stop At Row field is visible & ready to Update");
					}

				}

			} else {
				BaseSuite.reportFailLog("Stop At Row field is not visible,Kindly check!", "stopAtRow");
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at row field");
		}
	}

	// This Method is to use Click on Stop At Error option
	public void stopAtError(DataTestingParameters param) {
		try {
			if (isDisplayed(driver, stopAtErrorLabel)) {

				String val = getText(driver, stopAtErrorLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				int count = 0;

				if (param.getStopAtError() != null) {
					if (Integer.parseInt(param.getStopAtError()) > count) {

						BaseSuite.reportLog("Click on Stop At Error");

						clear_SendKeys(driver, stopAtErrorField, param.getStopAtError());

						String val1 = getText(driver, stopAtErrorField);

						BaseSuite.validationReportLog(val1 + " Stop At Error field is visible & ready to Update");
					}

				}

			} else {
				BaseSuite.reportFailLog("Stop At Error field is not visible,Kindly check!", "stopAtError");
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at error field");
		}
	}

	// this Method is use to check UI-validation

	// This Method is to use click on Stop At Time option
	public void stopAtTime(DataTestingParameters param) throws InterruptedException {
		try {
			if (isDisplayed(driver, stopAtAfterTimeLabel)) {

				String val = getText(driver, stopAtAfterTimeLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				int count = 5;

				if (param.getStopAtTime() != null) {
					if (Integer.parseInt(param.getStopAtTime()) >= count) {
						{
							BaseSuite.reportLog("Click on Stop At Time");

							javascript(driver, "arguments[0].scrollIntoView(true);", stopAfterTimeField);

							clear_SendKeys(driver, stopAfterTimeField, param.getStopAtTime());

							Thread.sleep(2000);

							String val1 = getText(driver, stopAfterTimeField);

							BaseSuite.validationReportLog(val1 + " Stop At Time field is visible & ready for Use");

						}

					}

				}

			} else {
				BaseSuite.reportFailLog("Stop After Time field is not visible,Kindly check!", "stopAtTime");
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at time field");
		}
	}

	// This Method is use to Select the Parameter
	public void parameterSection(DataTestingParameters param) {
		try {
			if (isDisplayed(driver, parameterLabel)) {

				String val = getText(driver, parameterLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (param.getParameterFilename() != null) {

					if (!param.getParameterFilename().isEmpty()) {

						BaseSuite.reportLog("Click on Select Parameter option");

						isDisplayed(driver, parameterclick);

						Actions actions = new Actions(driver);

						//wait = waitMethod(driver);

						Thread.sleep(2000);

						javascript(driver, "arguments[0].scrollIntoView(true);", parameterclick);

						actions.moveToElement(driver.findElement(parameterclick)).clickAndHold().perform();

						//wait.until(ExpectedConditions.visibilityOfElementLocated(parameterclick));

						BaseSuite.validationReportLog("Parameter option Clicked successfully");

						Thread.sleep(2000);

						clear_Click_SendKeys(driver, 0, parameterSearch, param.getParameterFilename());

						BaseSuite.validationReportLog("Parameter option is ready to search Parameter's");

						//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

						displayAndClick(driver, returnElement(parameterSelect, "$name", param.getParameterFilename()));

						Thread.sleep(1000);

						// javascript(driver,
						// "arguments[0].scrollIntoView(true);",returnElement(propertiesselectParameter,"$name",
						// param.getParameterFilename()));

						BaseSuite.validationReportLog("Parameter Selected successfully");
					}
				}
			} else {
				BaseSuite.reportFailLog("Parameter field is not visible,Kindly check!", "parameterSection");
			}

		} catch (java.lang.Exception e) {

			throw new Exception("Not able to enter detail in parameter field");
		}
	}

	// This Method is to check the Switch button Working
	public void switchbutton(DataTestingParameters param) {
		try {
			isClickable(driver, switchbtn, "Deactivate-Reactive", true);

			BaseSuite.validationReportLog("Deactivate-Reactive button is displayed.");

			if (param.getEnableactiveOption().equalsIgnoreCase("True"))

			{

				BaseSuite.validationReportLog("Activate is already Enable");

			} else {

				displayAndClick(driver, switchbtn);

				BaseSuite.validationReportLog("Deactivate is Enable");
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	// This Method is use to enter details in Degree of parallelism(DOP)
	public void degreeOfPeralleilsm(DataTestingParameters param) {
		try {

			int count1 = 1;

			if (isDisplayed(driver, dopLabel)) {

				String val = getText(driver, dopLabel);

				BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

				if (Integer.parseInt(param.getDop()) > count1 && !param.getDop().isEmpty()) {

					BaseSuite.validationReportLog("Entering Value in DOP");

					sendKeys(driver, dopField, param.getDop());

					BaseSuite.validationReportLog("Entered Value in DOP successfully");

				}
			} else {
				BaseSuite.reportFailLog("Degree Of Parallelism field is not visible,Kindly check!",
						"degreeOfPeralleilsm");
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at time field");
		}

	}

	public void enterDetailsInOverviewSection(DataTestingParameters param, String connName) {
		try {
			overviewlabelvalidate();

			rulename(param, connName);

			ruleCode(param);

			description(param);

			purpose(param);

			// criticality(param);

			// severity(param);

		} catch (Exception e) {

			throw new Exception("Facing some issues while entering detail on overview section");

		}
	}

	// Main method to check the Advanced setting working or not
	public void enterDetailsInAdvancedSettingOfOverviewSection(DataTestingParameters param)
			throws InterruptedException {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", advanceSettingLabel);

			Thread.sleep(2000);

			if (isDisplayed(driver, advanceSettingLabel)) {

				String val = getText(driver, advanceSettingLabel);

				displayAndClick(driver, advanceSettingLabel);

				Thread.sleep(2000);

				javascript(driver, "arguments[0].scrollIntoView(true);", parameterclick);

				BaseSuite.validationReportLog(val + " Title is displayed clearly ");

			}

			if (param.getEngineTypeOption().equalsIgnoreCase("High Throughput")
					|| param.getEngineTypeOption().equalsIgnoreCase("Cluster")) {

				degreeOfPeralleilsm(param);

			}

			if (param.getRuleType().equalsIgnoreCase("Validation") || param.getRuleType().equalsIgnoreCase("Recon")) {

				stopAtRow(param);

				if (!param.getRuleType().equalsIgnoreCase("pushdown")) {

					stopAtError(param);
				}

				stopAtTime(param);

			}

			parameterSection(param);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	// switchbutton(param);

	// -------->This method use to click on summary option in test rules section
	/*
	 * public void clickOnSummary() throws InterruptedException { try {
	 * Thread.sleep(3000);
	 * 
	 * inVisible(driver, datasetSpinner, Constant.ruleWait);
	 * 
	 * BaseSuite.validationReportLog(" Click on Summary ");
	 * 
	 * Actions actions = new Actions(driver);
	 * 
	 * wait = waitMethod(driver);
	 * 
	 * javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
	 * clickonsummary);
	 * 
	 * //wait.until(ExpectedConditions.visibilityOfElementLocated(clickonsummary));
	 * 
	 * actions.click(driver.findElement(clickonsummary)).build().perform();
	 * 
	 * displayAndClick(driver, clickonsummary);
	 * 
	 * BaseSuite.validationReportLog(" Summary Section clicked successfully ");
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.getMessage();
	 * 
	 * }
	 * 
	 * }
	 * 
	 */
	// method to click on exception report node on flow diagram
	public void clickOnSummary() throws Exception {

		try {
			inVisible(driver, datasetSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Clicking on  Summary node in flow diagram ");

			javascript(driver, "arguments[0].scrollIntoView(true);", clickonsummary);

			BaseSuite.reportLog("Clicking on Summary tab node button/link/field");

			isDisplayed(driver, clickonsummary);

			if (isDisplayed(driver, clickonsummary)) {

				// wait = waitMethod(driver);
				int i = 0;
				do {

					displayAndClick(driver, clickonsummary);

					i++;

				} while (i <= 2);

				BaseSuite.validationReportLog("Summary tab node button clicked successfully");

			} else {

				BaseSuite.reportFailLog("Summary tab node button not visible", "clickOnCheckNode1");
			}
		} catch (Exception e) {

			e.getMessage();

			throw new Exception("Exection found for Summary tab , kindly check :: " + e.getMessage());
		}
	}

	// -------->This method use to click on New Variables option in test rules
	// section
	public void clickOnAddVariabe() throws InterruptedException {
		try {

			Thread.sleep(2000);

			BaseSuite.validationReportLog(" Click on Add button");

			displayAndClick(driver, clicknewvariable);

			BaseSuite.validationReportLog("Add button clicked successfully ");

		} catch (Exception e) {

			e.getMessage();
		}

	}
	// click on variable Name to check functionality

	public void variabelName(String varName) {

		try {
			if (isEnabled(driver, variablename)) {

				BaseSuite.validationReportLog("Entering variable name");

				isDisplayed(driver, variablename);

				Thread.sleep(1000);

				displayAndClick(driver, variablename);

				clear_SendKeys(driver, variablename, varName);

				BaseSuite.validationReportLog("Variable name entered successfully");

			} else {

				BaseSuite.validationReportLog("Variable Name is Not clickable and disable ");

			}

		} catch (InterruptedException e) {
			e.getMessage();
		}

	}

	public void validatingNameAndSearch(String searchValue) throws Exception {
		try {

			// Use to check Search bar functionality
			int count = getcount(searchValue, ',');

			String[] result = searchValue.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String formulaSearch = result[colNum];

				if (isEnabled(driver, searchformulavalue)) {
					BaseSuite.validationReportLog("Search field is clickable and Enable ");
				} else {
					BaseSuite.validationReportLog("Search field is Not clickable and disable ");

				}

				BaseSuite.validationReportLog("click on Search bar to search the formula value");

				displayAndClick(driver, searchformulavalue);

				BaseSuite.validationReportLog("Clicked successfully ");

				clear_SendKeys(driver, searchformulavalue, formulaSearch);

				driver.findElement(searchformulavalue).sendKeys(Keys.ENTER);

				Thread.sleep(2000);

				if (isDisplayed(driver, sercheditem)) {
					BaseSuite.validationReportLog(" Searched Result found successfully");

				} else {
					BaseSuite.validationReportLog("Searched Result didn't find ");
				}
				clear(driver, searchformulavalue);

				driver.findElement(searchformulavalue).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {

			e.getMessage();
		}
	}
	// This method use to check formulas functionality

	public void validatingformulas(String formulaValue) throws Exception {
		try {
			int count = getcount(formulaValue, ',');

			String[] result = formulaValue.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String formulaSelection = result[colNum];

				BaseSuite.validationReportLog("Click on formula Name ");

				displayAndClick(driver, returnElement(selectformula, "$name", formulaSelection));

				BaseSuite.validationReportLog("formula Name clicked successfully ");

				WebElement element = driver.findElement(
						By.xpath("//ejs-sidebar[@id='accsidebar']//ejs-treeview[@id='template']//span//div[text()='"
								+ formulaSelection + "']"));

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				wait.until(ExpectedConditions.visibilityOf(element));

				actions.moveToElement(element).perform();

				JavascriptExecutor js = (JavascriptExecutor) driver;

				actions.doubleClick(element).build().perform();

				Thread.sleep(2000);

				System.out.println(element);

				//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				List<WebElement> list = driver.findElements(By.xpath(
						"//span//div[text()='" + formulaSelection + "']//following::ul[@style='display: block;']//li"));

				for (int i = 0; i < list.size(); i++) {

					String val = list.get(i).getText();

					list.get(i).click();

					displayAndClick(driver, formulaexpression);

					String val1 = getAttribute(driver, formulaexpression, "value");

					clear(driver, formulaexpression);

					BaseSuite.validationReportLog("Retrived Message is :" + val);
					BaseSuite.validationReportLog("Expected Message is :" + val1.trim());

					if (val.contains(val1.trim())) {

						BaseSuite.validationReportLog("Message Successfully Matched");

					}

					else {
						BaseSuite.reportFailLog("Messages didn't match", "captureToastMsg");

					}
				}

				displayAndClick(driver, returnElement(formulavalueclick, "$name", formulaSelection));

				click(driver, formulaexpression);

				Thread.sleep(3000);

			}
		} catch (InterruptedException e) {

			e.getMessage();
		}
	}
	// Use to check operator functionality

	public void validatingoperators() {

		try {
			clear(driver, formulaexpression);

			BaseSuite.validationReportLog(" Select operator ");

			List<WebElement> operatorList = driver.findElements(By.xpath("//div[@class='operators-grp']//button"));

			for (int i = 0; i < operatorList.size(); i++) {

				String val = operatorList.get(i).getText();

				operatorList.get(i).click();

				displayAndClick(driver, formulaexpression);

				String valoperate = getAttribute(driver, formulaexpression, "value");

				clear(driver, formulaexpression);

				BaseSuite.validationReportLog("Retrived Message is :" + val);
				BaseSuite.validationReportLog("Expected Message is :" + valoperate.trim());

				BaseSuite.validationReportLog("operator clicked successfully ");

				if (val.contains(valoperate.trim())) {

					BaseSuite.validationReportLog("Message Successfully Matched");

				}

				else {
					BaseSuite.reportFailLog("Messages didn't match", "captureToastMsg");

				}
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	// Enter value in Expression Area to Evaluate the expression------For API
	public void validatingExpression(String expression) {
		try {
			BaseSuite.validationReportLog("Enter Expression to evaluate for Execution ");

			displayAndClick(driver, formulaexpression);

			sendKeys(driver, formulaexpression, expression);

			Thread.sleep(2000);

			BaseSuite.validationReportLog("Expression Enter and evaluated successfully");

			// Functionality use to check Add New Variable Button

			BaseSuite.validationReportLog("Click on Add New Variable Button to Save the Evaluation result");

			displayAndClick(driver, addvariable);

			Thread.sleep(2000);

			BaseSuite.validationReportLog(
					"successfully Saved the Evaluation result by clicking on Add New Variable Button");

		} catch (InterruptedException e) {

			e.getMessage();
		}
	}

	// Rahul's -> this method is to use the set parameters for stories 504,776
	public DataTestingParameters setRuleParameters() {
		DataTestingParameters param = new DataTestingParameters();
		try {

			param.setRuleName(prop.getProperty("DataTesting.rulename"));
			param.setRuleTemplateNames(prop.getProperty("DataTesting.ruleTemplateNames"));
			param.setFolderName(prop.getProperty("DataTesting.folderName"));
			param.setEngineTypeOption(prop.getProperty("DataTesting.EngineTypeOption"));
			param.setRuleType(prop.getProperty("DataTesting.RuleType"));
			param.setCalculatedNametext1(prop.getProperty("DataTesting.CalculatedNametext1"));
			param.setCalculatedNametext2(prop.getProperty("DataTesting.CalculatedNametext2"));
			param.setCalculatedNametext3(prop.getProperty("DataTesting.CalculatedNametext3"));
			param.setColName1(prop.getProperty("DataTesting.ColName1"));
		} catch (Exception e) {

		}
		return param;
	}

	// method to enter check name in name field only to check the validation msg
	public void enterCheckNametovalidatemsg(DataTestingParameters param) throws Throwable {

		try {

			BaseSuite.reportLog("checking Name field is displayed or not");
			isDisplayed(driver, checkNameLabel);
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", checkNameLabel);
			verifyIndividualLabel(driver, checkNameLabel, "Name");

			if (isDisplayed(driver, checkNameField)) {
				String cname = getAttribute(driver, checkNameField, "value");

				if (cname.isEmpty()) {

					BaseSuite.reportFailLog("Check Name field is Empty on current page", "enterCheckNametovalidatemsg");

				}
			} else {
				clear(driver, checkNameField);

				String cname1 = getAttribute(driver, checkNameField, "value");

				BaseSuite.validationReportLog("Name field is Empty on page with Displayed No value" + cname1);

				String cname2 = getText(driver, checksNameValidationError1);

				BaseSuite.validationReportLog("Name field is Empty so Error Msg mentioned ," + cname2);

				Thread.sleep(1000);

				clear_Click_SendKeys(driver, 0, checkNameField, param.getCalculatedNametext1());

				String cname3 = getText(driver, checksNameValidationError2);

				BaseSuite.validationReportLog(cname3);

				Thread.sleep(1000);

				clear_Click_SendKeys(driver, 0, checkNameField, param.getCalculatedNametext2());

				String cname4 = getText(driver, checksNameValidationError2);

				BaseSuite.validationReportLog(cname4);

				Thread.sleep(1000);

				clear_Click_SendKeys(driver, 0, checkNameField, param.getCalculatedNametext3());

				String cname5 = getText(driver, checksNameValidationError2);

				BaseSuite.validationReportLog(cname5);

				String cname6 = getText(driver, checksNameValidationError3);

				BaseSuite.validationReportLog(cname6);

			}
		} catch (java.lang.Exception e) {
			e.getMessage();

			BaseSuite.reportFailLog("Name field not found kindly check", "enterCheckName");
			clickOnCancelCheckButton();

			throw new Exception("");
		}
	}
	// Rauls's Method for stories

	// Story-504 //NRR-8655/NRR-8654/NRR-8643/NRR-8641

	public void publishbuttonvisibilitycheckForReaderAndExecutor(String ruleName, SoftAssert soft) throws Throwable {
		try {

			clickOnNextGenMenuTab("Data Testing");

			// clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

			isDisplayed(driver, rulePublishButton);

			BaseSuite.validationReportLog("Publish button is displayed in NRR-8655 .");

			inVisible(driver, spinner, Constant.ruleWait);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// sTORY: DAT-504---> NRR-8653,NRR-8652,NRR-8635,NRR-8638
	public void publishbuttonvisibilitycheckForOwnerAndContributor(DataTestingParameters param, String ruleName,
			SoftAssert soft) throws Throwable {
		try {
			clickOnNextGenMenuTab("Data Testing");

			enterDetailsInAddNewPane(param);

			isDisplayed(driver, rulePublishButton);

			BaseSuite.validationReportLog("Publish button is displayed.");

			inVisible(driver, spinner, Constant.ruleWait);
		} catch (Exception e) {

		}
	}

	//// story-DAT-776 ---> NRR-9083,NRR-9084,NRR-9087,NRR-9088
	public void VerifythatNamefieldiseditableornotForReaderAndExecutor(DataTestingParameters param, SoftAssert soft)
			throws Throwable {
		try {
			clickOnNextGenMenuTab("Data Testing");

			verifyDataTestingLandingPage();

			enterDetailsInAddNewPane(param);

			captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, runErrorMsgtintative, "Rule(s) List");

			inVisible(driver, spinner, Constant.ruleWait);
		} catch (java.lang.Exception e) {

		}
	}

	// story-DAT-776 --->
	// NRR-9081,NRR-9082,NRR-9085,NRR-9086,NRR-9077,NRR-9078.NRR-9066,NRR-9065
	public void verifythatNamefieldiseditableornotForOwnerAndContributor(DataTestingParameters xparam,
			String workspaceID, String ruleName, String icedqRoleName, SoftAssert soft) throws Throwable {
		try {

			DataTestingPage rule = new DataTestingPage(driver);

			TestDataThroughApi datathru = new TestDataThroughApi(driver);

			String ruleID = datathru.getRuleIDFromRuleName(ruleName, workspaceID, icedqRoleName);

			String ruleJson = datathru.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRoleName);

			String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(ruleJson, "$.ruleType");

			// rule.clickOnNextGenMenuTab("Connections");

			// List<String> connectionList =
			// datathru.createConnection(ruleType,ruleJson,workspaceID,"$.objects..connectionId",
			// soft, icedqRoleName);

			DataTestingParameters param = setRuleParametersForApi(workspaceID, ruleJson, icedqRoleName);
			rule.clickOnNextGenMenuTab("Data Testing");

			rule.verifyDataTestingLandingPage();

			rule.clickOnAddNewFolderOrExistingOneAPI(param, workspaceID, ruleName, icedqRoleName);

			// rule.enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName,
			// icedqRoleName);

			// enterDetailsInOverviewSection(param);

			enterDetailsInAdvancedSettingOfOverviewSection(param);

			// rule.enterDetailsInSourceSetting(ruleJson, param, soft);

			rule.clickOnCheckNode1();

			// addChecksToRule(ruleJson, param, soft);

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			enterCheckNametovalidatemsg(xparam);

			calculatedcancelbtn();

		} catch (java.lang.Exception e) {

		}
	}

	public void calculatedcancelbtn() {
		try {
			BaseSuite.validationReportLog("Click on Cancel button Please");

			click(driver, calculatedcolumnCancelbtn);

			BaseSuite.validationReportLog("Cancel button clicked succcessfully");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void enterScriptOfScriptRule(String scriptValue) {

		try {

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", scriptTextAreaField);

			isDisplayed(driver, scriptTextAreaField);

			BaseSuite.reportLog("verifying script textarea visible or not");

			if (isDisplayed(driver, scriptTextAreaField)) {

				BaseSuite.validationReportLog("script textarea is visible");

				if (!scriptValue.isEmpty()) {

					scriptValue = scriptValue.replace("\\r\\n", "\r\n");
					scriptValue = scriptValue.replace("\\", "\"");

					BaseSuite.reportLog("Entering script : " + scriptValue);

					WebElement ele = driver.findElement(scriptTextAreaField);

					ele.sendKeys(Keys.CONTROL, "a");

					ele.sendKeys(Keys.BACK_SPACE);

					sendKeys(driver, scriptTextAreaField, scriptValue);

					for (int i = 0; i < 3; i++) {

						ele.sendKeys(Keys.DELETE);
					}

					BaseSuite.validationReportLog("Entererd script successfully");

				}

			} else {
				BaseSuite.reportFailLog("Script field not visible kindly check", "enterScriptOfScriptRule");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickOnAddConnectionButtonInScriptObject() throws Exception {

		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", connectionTabOnScript);

			displayAndClick(driver, connectionTabOnScript);

			clickOnButton(driver, scriptAddConnBtn, "Add Connection", true);

		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void clickOnTestConnectionBtn(String connectionVariable, String toastMsg) throws Exception {

		try {
			clickOnButton(driver, returnElement(scriptTestConnectionBtn, connDynamicVar, connectionVariable),
					"Test Connection", true);

			inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, toastMsgCon, popUpClose, toastMsg, "Test Connection");

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	public void selectConnectionInScriptObject(String connectionVariable, String connectionName) {

		try {

			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});",
					returnElement(connectionDropdown, connDynamicVar, connectionVariable));

			isDisplayed(driver, returnElement(connectionDropdown, connDynamicVar, connectionVariable));

			if (isDisplayed(driver, returnElement(connectionDropdown, connDynamicVar, connectionVariable))) {

				BaseSuite.reportLog("clicking on search connection dropdown");

				displayAndClick(driver, returnElement(connectionDropdown, connDynamicVar, connectionVariable));

				BaseSuite.validationReportLog("Clicked on search connection dropdown");

				BaseSuite.reportLog("Entering connection name in search : " + connectionName);

				clear_Click_SendKeys(driver, 3,
						returnElement(connectionSearchInput, connDynamicVar, connectionVariable), connectionName);

				BaseSuite.validationReportLog("Entered connection name successfully");

				isDisplayed(driver, returnElement(selectconnName, connDynamicVar, connectionName));

				if (isDisplayed(driver, returnElement(selectconnName, connDynamicVar, connectionName))) {

					BaseSuite.reportLog("clicking on searched connection");

					displayAndClick(driver, returnElement(selectconnName, connDynamicVar, connectionName));

					BaseSuite.validationReportLog("Connection selected successfully");

					boolean flag = verifyVisibilityOfButtons(driver, scriptConnectionVariableSaveButton, "Save Button",
							true);

					verifyVisibilityOfButtons(driver, scriptConnectionVariableCancelButton, "Cancel Button", true);

					if (flag) {
						displayAndClick(driver, scriptConnectionVariableSaveButton);

					} else {
						BaseSuite.reportFailLog("Connection variable save button is not visible,Kindli check!",
								"selectConnectionInScriptObject");
					}

				} else {
					BaseSuite.reportFailLog("Search Connection not found kindly check",
							"selectConnectionInScriptObject");
				}
			} else {
				BaseSuite.reportFailLog("select connection dropdown button not found kindly check",
						"selectConnectionInScriptObject");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void enterConnectionVariableName(String connectionVariableName) {

		try {
			javascript(driver, "arguments[0].scrollIntoView({behavior:'smooth'});", connVarNamefield);

			isDisplayed(driver, connVarNamefield);

			BaseSuite.reportLog("verifying connection variable field");

			if (isDisplayed(driver, connVarNamefield)) {

				BaseSuite.validationReportLog("Connection variable field is visible");

				String name = getAttribute(driver, connVarNamefield, "value");

				BaseSuite.reportLog("default connection variable name is : " + name);

				if (!connectionVariableName.isEmpty()) {

					BaseSuite.reportLog("Clicking on connection variable name");

					Actions act = new Actions(driver);

					act.doubleClick(driver.findElement(connVarNamefield)).perform();

					BaseSuite.validationReportLog("Double clicked on connection variable name successfully");

					BaseSuite.reportLog("Entering connection name : " + connectionVariableName);

					clear_Click_SendKeys(driver, 4, connVarNamefield, connectionVariableName);

					String acname = getAttribute(driver, connVarNamefield, "value");

					if (acname.trim().equals(connectionVariableName)) {

						BaseSuite.validationReportLog("Entered connection variable name successfully");

					} else {

						BaseSuite.reportFailLog("entered connection variable name not found kindly check " + acname,
								"enterConnectionVariableName");
					}
				}
			} else {

				BaseSuite.reportFailLog("Connection variable name field not visible kindly check",
						"enterConnectionVariableName");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/*
	 * // need to check n delete public void
	 * verifyAllAddedColumnNColexpName(DataTestingParameters param, String
	 * jsonEntity) throws Exception {
	 * 
	 * TestDataThroughApi nn = new TestDataThroughApi(driver); String colName =
	 * null, genColExpName = null, genColExp = null, actColExpName = null, actColExp
	 * = null; try { param.setColumnList(TestDataThroughApi.
	 * getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
	 * "$.objects[0].configuration.columns..name")); List<WebElement> actualColExp =
	 * getElements(driver, pushdown_allExpName); int ae = actualColExp.size();
	 * $.objects[1].configuration.checks..name - check name List<WebElement>
	 * actualColChkName = getElements(driver, pushdown_allChkName); int an =
	 * actualColChkName.size();
	 * 
	 * int total = param.getColumnList().size(); int j = 0, l = 0; BaseSuite.
	 * validationReportLog("Verifying all column added as an expression in rule with expression name :"
	 * ); for (int i = 0, k = 1; (i < total & i < ae) & (k <= an); i++, k++) {
	 * 
	 * colName = param.getColumnList().get(i); genColExp =
	 * generateColumnCheckExpForPushdown(colName); genColExpName =
	 * generateColumnCheckNameForPushdown(colName);
	 * 
	 * // verify generated ones with actual ones actColExp =
	 * actualColExp.get(i).getAttribute("title"); System.out.println(actColExp);
	 * actColExpName = actualColChkName.get(k).getText();
	 * System.out.println(actColExpName);
	 * 
	 * if (genColExp.equalsIgnoreCase(actColExp)) { j++;
	 * BaseSuite.reportLog("Column expression is generated as expected :: " +
	 * actColExp);
	 * 
	 * } else { BaseSuite.reportFailLog(
	 * "Unable to match actual column expression:: " + actColExp +
	 * " with expected:: " + genColExp, "verifyAllAddedColumnNColexpName"); }
	 * 
	 * if (genColExpName.equalsIgnoreCase(actColExpName)) { l++;
	 * BaseSuite.reportLog("Column expression name is generated as expected :: " +
	 * actColExpName); } else { BaseSuite.reportFailLog(
	 * "Unable to match actual column expression:: " + actColExp +
	 * " with expected:: " + genColExp, "verifyAllAddedColumnNColexpName"); }
	 * 
	 * }
	 * 
	 * if (j == l) { BaseSuite.
	 * validationReportLog("All column expression & name added to the rule i.e. " +
	 * j + " expression successfully verified."); }
	 * 
	 * } catch (Exception e) { BaseSuite.reportLog("Exception Received:: " +
	 * e.toString()); } }
	 */

	public String generateColumnCheckNameForPushdown(String columnName) {
		String gen_colChkExp = null;
		try {
			gen_colChkExp = "fyi_s_" + columnName;
			System.out.println(gen_colChkExp);

		} catch (Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}

		return gen_colChkExp.toLowerCase();

	}

	public void clearSearchBar() throws Exception {

		try {
			clear_Click_SendKeys(driver, 10, searchBox, "");

			clickOnButton(driver, searchButton, "Search button", true);
		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	public void deleteRules() throws Exception {

		try {
			clickOnDeleteButton();

			validateDeletePopUpWindow();

			clickOnButton(driver, deleteDelBtn, "Delete", true);

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			captureToastMsg(driver, toastMsg, toastMsgClosedBtn, deleteToastMsg, "Rule Delete");
		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	public boolean validatePublishButtonAndSaveOptionDropDownBtn(SoftAssert soft) throws Exception {
		boolean flag = true;
		try {

			isDisplayed(driver, publishBtn);

			flag = verifyVisibilityOfButtons(driver, publishBtn, "Publish", true);

			flag = isClickable(driver, publishBtn, "Publish", true);

			flag = verifyVisibilityOfButtons(driver, saveOptionDropDown, "Save Option DropDown", true);

			boolean s = isClickable(driver, saveOptionDropDown, "Save Option DropDown", true);

			if (s) {

				clickOnButton(driver, saveOptionDropDown, "Save Option dropdown", true);

				flag = verifyVisibilityOfButtons(driver, validateBtn, "Validate", true);

				flag = isClickable(driver, validateBtn, "Validate", true);

				flag = verifyVisibilityOfButtons(driver, draftBtn, "Draft", true);

				flag = isClickable(driver, draftBtn, "Draft", true);

			} else {
				BaseSuite.reportFailLog("Save Option button not visible",
						"validatePublishButtonAndSaveOptionDropDownBtn");
			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
		return flag;
	}

	public boolean validateRunButton() {

		boolean flag = true;

		isDisplayed(driver, ruleRunButton);

		if (isDisplayed(driver, ruleRunButton)) {

			flag = verifyVisibilityOfButtons(driver, ruleRunButton, "Run", true);

			if (isEnabled(driver, ruleRunButton)) {

				BaseSuite.validationReportLog("Run button is enabled");

			} else {

				BaseSuite.reportFailLog("Run button is disabled", "validateRunButton");
			}

			flag = isClickable(driver, ruleRunButton, "Run", true);

		} else {
			BaseSuite.reportFailLog("Run button is not visible", "validateRunButton");
		}
		return flag;
	}

	public boolean selectActiveOrInactiveStatusOfExpression(String checkName, String status, SoftAssert soft) {

		String acState;
		boolean flag = true;
		try {
			BaseSuite.reportLog("Verify active or inactive status of expression / column ");

			javascript(driver, "arguments[0].scrollIntoView(true);",
					returnElement(checksStatusBtn, "$name", checkName));

			isDisplayed(driver, returnElement(checksStatusBtn, "$name", checkName));

			if (isDisplayed(driver, returnElement(checksStatusBtn, "$name", checkName))) {

				acState = getAttribute(driver, returnElement(checksStatusBtn, "$name", checkName), "textContent");

				BaseSuite.reportLog(checkName + " expression / column status is selected as : " + acState);

				if (!acState.isEmpty() || acState != null) {

					if (acState.trim().equalsIgnoreCase(status)) {

						BaseSuite.validationReportLog(
								"Expression/ column status already selected as expected : " + status);

					} else {

						BaseSuite.reportLog("Changing the status of expression / column ");

						BaseSuite.reportLog("Clicking on status button of expression / column");

						displayAndClick(driver, returnElement(checksStatusBtn, "$name", checkName));

						BaseSuite.validationReportLog("Clicked on status button successfully");

						isDisplayed(driver, checksStatusList);

						if (isDisplayed(driver, checksStatusList)) {

							BaseSuite.reportLog("Clicking on " + status);

							displayAndClick(driver, checksStatusList);

							BaseSuite.validationReportLog("Clicked on " + status + " button successfully");

						} else {
							BaseSuite.reportFailLog("Status dropdown list not visible kindly check",
									"selectActiveOrInactiveStatusOfExpression");
							flag = false;
						}
						acState = getAttribute(driver, returnElement(checksStatusBtn, "$name", checkName),
								"textContent");
						BaseSuite.reportLog(checkName + " expression / column status is selected as : " + acState);
					}
					if (!acState.isEmpty()) {

						soft.assertEquals(status, acState, "selectActiveOrInactiveStatusOfExpression");

						if (!status.equalsIgnoreCase(acState)) {
							BaseSuite.reportFailLog("Expected status and Actual status of expression not matched",
									"selectActiveOrInactiveStatusOfExpression");
							flag = false;
						} else {
							BaseSuite.validationReportLog(
									"Expected status : " + status + " and Actual status : " + acState + " are matched");
						}
					}
				}
			} else {
				BaseSuite.reportFailLog(checkName + " expression / column status button not visible kindly check",
						"selectActiveOrInactiveStatusOfExpression");
				flag = false;
			}
		} catch (Exception e) {
			e.getMessage();
			flag = false;
		}
		return flag;
	}

	public boolean clickOnNewRuleUserSpecific() {
		boolean flag = true;
		try {
			if (isEnabled(driver, newRuleBtn)) {

				Actions actions = new Actions(driver);

				wait = waitMethod(driver);

				actions.moveToElement(driver.findElement(newRuleBtn)).perform();

				wait.until(ExpectedConditions.visibilityOfElementLocated(newRuleBtn));

				actions.click(driver.findElement(newRuleBtn)).build().perform();

				BaseSuite.reportLog("New Rule Button visible on Page");

				BaseSuite.reportLog("click on New Rule Button");

				BaseSuite.validationReportLog("New Rule Button Clicked");

				isDisplayed(driver, toastMsg);

				if (isDisplayed(driver, toastMsg)) {

					captureToastMsg(driver, toastMsg, popUpClose, userPrivilegeMsg, "User Previlege");

				} else {
					BaseSuite.reportFailLog("Toast message not visible kindly check - issue id - DAT-2732",
							"clickOnNewRuleUserSpecific");

					isDisplayed(driver, newRuleCancelBtn);

					displayAndClick(driver, newRuleCancelBtn);
					flag = false;
				}
			} else {
				BaseSuite.reportFailLog("New Rule Button is not visible", "clickOnNewRuleUserSpecific");
				flag = false;
			}

		} catch (Exception e) {

			e.getMessage();
		}
		return flag;
	}

//#############################-Neha Story comman methods-################################	

	// User is able to Create Validation rule in published mode without any details
	public void verifyAddNewPane(DataTestingParameters param, SoftAssert soft) throws Throwable {
		try {

			DataTestingPage dp = new DataTestingPage(driver);
			dp.clickOnAddNewFolderOrExistingOne(param);
			dp.clickOnNewRule();
			enterFolderDetails(param);
			verifyAutogeneratedRuleName();
			selectRuleEngineNTemplateDetails(param);
			Thread.sleep(1000);
			dp.clickOnPublishButton(sourceNtSelectedMsg);
			// dp.enterDetailsInSourceSetting("", param, soft);
			dp.clickOnPublishButton(expNtAddedMsg);

		} catch (java.lang.Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}
	}

	// setting all parameters required in NRR-549 story test cases
	public DataTestingParameters setTestcaseParameters() throws Exception {
		DataTestingParameters param = new DataTestingParameters();

		param.setFolderName(foldername);
		param.setEngineTypeOption(vengineType);
		param.setRuleType(valTemplate);
		param.setSourceConnType(connType);
		param.setSourceInput("SQL");
		param.setSourceConnection(connName);
		param.setSourceQuery(customQuery);
		param.setSourceSchema("REGRESSION_QA");
		param.setSourceTable("customer");

		return param;
	}

	// enter folder details
	public void enterFolderDetails(DataTestingParameters param) throws Exception {
		try {
			BaseSuite.reportLog("clicking on path");

			javascript(driver, "arguments[0].click();", pathSelect);

			BaseSuite.validationReportLog(" path clicked successfully ");

			if (isEnabled(driver, pathTree)) {
				Thread.sleep(2000);

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnElement(validScrollFolder, "$name", param.getFolderName()));

				click(driver, returnElement(validScrollFolder, "$name", param.getFolderName()));

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				String folder = getText(driver, returnElement(validScrollFolder, "$name", param.getFolderName()));

				Thread.sleep(2000);

				if (folder.trim().equalsIgnoreCase(param.getFolderName().trim())) {
					BaseSuite.validationReportLog(param.getFolderName() + " is visble");

					BaseSuite.reportLog("clicking on select Button");

					// click(driver, selectBtn);

					BaseSuite.validationReportLog(" Select Button clicked successfully ");
				} else {
					BaseSuite.reportFailLog(param.getFolderName() + "is fail to display", "selectpathRule");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

//method to verify status of run button after certain condition.
	public void verifyStatusOfRunBtnInRule() {
		try {

			if (isDisplayed(driver, ruleRunButton)) {
				BaseSuite.validationReportLog("Run button is displayed on page.");
				BaseSuite.reportLog("Verifying state of run button.");
				if (!(isEnabled(driver, ruleRunButton))) {
					BaseSuite.validationReportLog("Run button is disbled on the page.");
					isClickable(driver, ruleRunButton, "run button", false);
				} else {
					BaseSuite.reportFailLog("Run button is enabled on page,Kindly check.",
							"verifyStatusOfRunBtnInRule");
				}

			} else {
				BaseSuite.reportFailLog("Run button is not displayed on page,Kindly check.",
						"verifyStatusOfRunBtnInRule");
			}

		} catch (Exception e) {
			BaseSuite.reportLog("Exception Received:: " + e.toString());
		}
	}

	// method to click on data testing sub menu tab
	public void clickOnDataTestingSubMenuTab(String moduleName) throws Exception {

		try {

			if (isDisplayed(driver, deletePopupDeleteBtn)) {

				clickOnButton(driver, deletePopupDeleteBtn, "Delete popup", true);
			}

			if (isDisplayed(driver, sidebarCloseIcon)) {

				clickOnButton(driver, sidebarCloseIcon, "Sidebar close icon ", true);
			}

			if (isDisplayed(driver, returnElement(dataTestingSubMenuTab, "$name", moduleName.trim()))) {

				javascript(driver, "arguments[0].scrollIntoView(true);",
						returnElement(dataTestingSubMenuTab, "$name", moduleName.trim()));

				clickOnButton(driver, returnElement(dataTestingSubMenuTab, "$name", moduleName.trim()),
						moduleName + " sub menu ", true);

				/*
				 * isDisplayedInLoop(driver, 0, sidebarCloseIcon); if (isDisplayed(driver,
				 * sidebarCloseIcon)) { clickOnButton(driver, sidebarCloseIcon,
				 * "Sidebar close icon ", true); }
				 */

				if (isDisplayed(driver, discardButtons)) {

					clickOnButton(driver, discardButtons, " Discard ", true);
				}

				inVisible(driver, dataTSpinner, Constant.ruleWait);
				Thread.sleep(2000);
				// getWindowHandler(driver);
				// checkElement(driver, checkNameLocator, "Column name", "refer issue
				// -DAT-2766");
			} else {
				BaseSuite.reportFailLog(moduleName + " sub menu tab not visible kindly check", "clickOnNextGenMenuTab");
				BaseSuite.reportLog("Refreshing the current page");
				driver.navigate().refresh();
				getWindowHandler(driver);
				throw new AssertionError(moduleName + " sub menu tab not visible kindly check");
			}
		} catch (java.lang.Exception e) {

			e.getMessage();
			BaseSuite.reportFailLog(moduleName + " sub menu tab not visible kindly check ", "clickOnNextGenMenuTab");
			throw new AssertionError(moduleName + " sub menu tab not visible kindly check :: " + e.getMessage());
		}
	}

	public void searchCheckName(String checkName) throws InterruptedException {
		try {
			Thread.sleep(2000);

			BaseSuite.reportLog("Entering check name on search bar");

			displayAndClick(driver, checkSearchBar);

			clear_SendKeys(driver, checkSearchBar, checkName.trim());

			if (!isDisplayed(driver, noRecordOnCheck)) {
				displayAndClick(driver, checkSearchButton);

				BaseSuite.validationReportLog("Check name entered successfully");
			} else {
				BaseSuite.reportFailLog("Searched result not found,Kindly check!", checkName);
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void searchSummaryName(String checkName) throws InterruptedException {
		try {
			Thread.sleep(2000);

			BaseSuite.reportLog("Entering Summary name on search bar");

			displayAndClick(driver, summaryCheckSearchBar);

			clear_SendKeys(driver, summaryCheckSearchBar, checkName.trim());

			displayAndClick(driver, summaryCheckSearchBarButton);

			BaseSuite.validationReportLog("Check name entered successfully");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyAddedCheckOnCheckSection(String checkName) {
		try {

			searchCheckName(checkName);

			boolean flag = isDisplayed(driver, searchCheckName);

			if (flag) {
				BaseSuite.validationReportLog("Added column is visible on the check list");
			} else {
				BaseSuite.reportFailLog("Added column is not visible on the check list",
						"verifyAddedCheckOnCheckSection");
			}

			displayAndClick(driver, checkSearchBar);

			displayAndClick(driver, checkSearchClearButton);

		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void verifyAddedSummaryOnSummarySection(String checkName) {
		try {
			Thread.sleep(2000);

			BaseSuite.reportLog("Entering summary name on search bar");

			displayAndClick(driver, summaryCheckSearchBar);

			sendKeys(driver, summaryCheckSearchBar, checkName);

			displayAndClick(driver, summaryCheckSearchBarButton);

			BaseSuite.validationReportLog("summary name entered successfully");

			boolean flag = isDisplayed(driver, searchSummaryName);

			if (flag) {
				BaseSuite.validationReportLog("Added summary variable is visible on the summary list");
			} else {
				BaseSuite.reportFailLog("Added summary variable is not visible on the summary list",
						"verifyAddedSummaryOnSummarySection");
			}

			displayAndClick(driver, summaryCheckSearchBar);

			displayAndClick(driver, summaryCheckSearchClearButton);

		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void addSummary(String summaryName, String summaryValue, By saveUpdateLocator) {
		try {

			if (!summaryValue.contains("#")) {
				String[] expVal = summaryValue.split(" ");

				int val = expVal.length;

				for (int colNum = 0; colNum < val; colNum++) {

					int val1 = colNum + 1;

					String result = expVal[colNum];

					if (result.matches("^[a-zA-Z0-9]*$")) {

						BaseSuite.validationReportLog("Enter Expression to evaluate for Execution ");

						displayAndClick(driver, formulaexpression);

						sendKeys(driver, formulaexpression, result);

						if (val1 != val) {
							driver.findElement(formulaexpression).sendKeys(Keys.SPACE);
						}

						BaseSuite.validationReportLog("Expression Enter and evaluated successfully");

					} else {

						BaseSuite.reportLog("Clicking on operator button");

						displayAndClick(driver, formulaexpression);

						displayAndClick(driver, returnElement(operatorOption, "$name", result));

						BaseSuite.validationReportLog("Operator button clicked successfully");
					}

				}
			} else {
				BaseSuite.validationReportLog("Enter Expression to evaluate for Execution ");

				sendKeys(driver, formulaexpression, summaryValue);

				BaseSuite.validationReportLog("Expression Enter and evaluated successfully");

			}

			String customeCheck = getAttribute(driver, expressionArea, "value");

			if (customeCheck.trim().equals(summaryValue)) {

				BaseSuite.validationReportLog("Actual and entered summary value match successfully");

				verifyVisibilityOfButtons(driver, addvariable, "Save", true);

				verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

				BaseSuite.reportLog("Clicking on save button");

				displayAndClick(driver, saveUpdateLocator);

				BaseSuite.validationReportLog("Save button clicked successfully");

				verifyAddedSummaryOnSummarySection(summaryName);

			} else {

				BaseSuite.reportFailLog("Actual and entered summary value not match successfully,Kindly check!",
						"summaryVariable");
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void summaryVariable(DataTestingParameters param, String jsonEntity) throws java.lang.Exception {
		try {
			ArrayList<String> summaryList;

			int count = 0;

			if (param.getRuleType().equalsIgnoreCase("Recon") || param.getRuleType().equalsIgnoreCase("HT Recon")) {

				summaryList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[5].configuration.checks..id");

				count = 5;
			} else {
				summaryList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..id");

				count = 3;

			}

			int count1 = summaryList.size();

			for (int i = 0; i < count1; i++) {

				String summaryName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[" + count + "].configuration.checks[" + i + "].name");

				String summaryValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[" + count + "].configuration.checks[" + i + "].expression.value");
				if (i == 0) {
					clickOnSummary();
				}

				switch (summaryName) {

				case "exitcode":

					if (!summaryValue.equalsIgnoreCase("exitcode")) {
						displayAndClick(driver, summaryExitcode);

						if (isDisplayed(driver, summaryPane)) {
							boolean flag = isEditable(driver, variablename, "Name");

							if (flag) {
								BaseSuite.reportFailLog("Variable name field is editable,Kindly check ",
										"summaryVariable");
							} else {
								BaseSuite.validationReportLog("Variable name field is not editable ");
							}

							displayAndClearInputField(driver, 2, formulaexpression);

							addSummary(summaryName, summaryValue, summaryUpdateBtn);
							;

						}

					}

					String val = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[" + count + "].configuration.checks[0].isOverride");

					if (val.equalsIgnoreCase("true")) {
						BaseSuite.reportLog("Clicking on override exit code checkbox");

						displayAndClick(driver, enableOverrideExitCode);

						BaseSuite.validationReportLog("override exit code checkbox clicked successfully");
					}

					break;

				default:

					clickOnAddVariabe();

					variabelName(summaryName);

					verifyVisibilityOfButtons(driver, addvariable, "Save", false);

					verifyVisibilityOfButtons(driver, cancelCheckButton, "Cancel", true);

					addSummary(summaryName, summaryValue, addvariable);

					break;
				}

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void downloadExceptionReport(String instanceId, String downloadType, String exportFormat, String ruleId)
			throws Throwable {
		try {
			String s;

			if (isDisplayed(driver, downloadExceptionReport)) {

				if (downloadType.equalsIgnoreCase("True")) {

					s = "FE";

				} else {

					s = "All";
				}

				BaseSuite.reportLog("Clicking on Download Exception Report button");

				displayAndClick(driver, downloadExceptionReport);

				BaseSuite.validationReportLog("Download Exception Report button clicked successfully");

				Thread.sleep(2000);

				verifyDownloadedFile(ruleId, instanceId, s, exportFormat);

			} else {

				BaseSuite.reportFailLog("Download Exception Report button is not visible,Kindly check",
						"downloadExceptionReport");

			}
		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void clickOnDataTestingBreadcrumbLink() throws java.lang.Exception {

		try {

			if (isDisplayed(driver, discardButtons)) {

				clickOnButton(driver, discardButtons, " Discard ", true);
			}

			isDisplayed(driver, dataTestingBreadCrumbs);

			if (isDisplayed(driver, dataTestingBreadCrumbs)) {

				clickOnButton(driver, dataTestingBreadCrumbs, "Connection Repository Breadcrumb", true);

				isDisplayed(driver, discardButtons);

				if (isDisplayed(driver, discardButtons)) {

					clickOnButton(driver, discardButtons, " Discard ", true);
				}

			} else {
				BaseSuite.reportFailLog("Connection Repository breadcrumb link not visible",
						"clickOnDataTestingBreadcrumbLink");

				driver.navigate().refresh();

				displayAndClick(driver, dataTestingTab);

				throw new AssertionError();
			}
		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError();
		}
	}

	public void moreOption(String value) {
		try {
			BaseSuite.reportLog("Clicking on more option button");

			moveToElement(driver, moreOptionButton);

			displayAndClick(driver, moreOptionButton);

			// javascript(driver, "arguments[0].click();", moreOptionButton);

			if (isDisplayed(driver, moreOptionDropDownButton)) {

				BaseSuite.validationReportLog("Drop down list is open after click on More button");

				displayAndClick(driver, returnElement(moreValueOption, "$name", value));

				// inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog(value + " Drop down list option is selected");

				if (value.equalsIgnoreCase("Duplicate") || value.equalsIgnoreCase("Share")
						|| value.equalsIgnoreCase("Activate") || value.equalsIgnoreCase("Deactivate")) {
					switch (value) {

					case "Duplicate":

						captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, ruleDuplicateMess,
								"Rule " + value + " Message");

						inVisible(driver, dataTSpinner, Constant.ruleWait);

						break;

					case "Share":

						captureToastMsg(driver, toastMsg, ToastMsgClosedBtn, ruleCopyMess,
								"Rule " + value + " Message");

						break;

					case "Activate":

						verifyVisibilityOfButtons(driver, ruleRunButton, "Run", true);

						break;

					case "Deactivate":

						verifyVisibilityOfButtons(driver, ruleRunButton, "Run", false);

						break;

					default:

						BaseSuite.reportFailLog("Entered value is not matched,Kindly check!", "moreOption");

						break;

					}

				}

				if (!value.equalsIgnoreCase("Move") && !value.equalsIgnoreCase("Copy")
						&& !value.equalsIgnoreCase("Duplicate")) {

					displayAndClick(driver, returnElement(dataTestingSubMenuTab, "$name", "Rules"));

				}

			} else {
				BaseSuite.reportFailLog("Drop down list is not open after click on More button", "moreOption");
			}

			BaseSuite.validationReportLog("More option button clicked successfully");

		} catch (java.lang.Exception e) {

			e.printStackTrace();
		}

	}

	public int getDownloadExceptionResponce(String instanceId, String workspaceId, String userRole) throws IOException {

		int statusCode = 0;

		try {
			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(userRole);
			/*
			 * OkHttpClient client = new OkHttpClient().newBuilder().build();
			 * 
			 * MediaType mediaType = MediaType.parse("text/plain");
			 * 
			 * RequestBody body = RequestBody.create(mediaType,"");
			 * 
			 * Request request = new Request.Builder()
			 * 
			 * .url("http://qa.onprem.icedq.com/api/v1/exceptions/"+instanceId+
			 * "/downloadall?format=excel.all&contentType=application/json&entityType=rule")
			 * 
			 * .addHeader("workspace-id", workspaceId)
			 * 
			 * .addHeader("Authorization", "Bearer "+auto)
			 * 
			 * .addHeader("Cookie", "JSESSIONID=FE85E289D51923129281CDB20926B530")
			 * 
			 * .build();
			 * 
			 * Call call = client.newCall(request);
			 * 
			 * Response response = call.execute();
			 * 
			 * System.out.println(response);
			 */

			// OkHttpClient client = new OkHttpClient().newBuilder().build();
			OkHttpClient client = new OkHttpClient();
			HttpUrl.Builder urlBuilder = HttpUrl
					.parse("http://qa.onprem.icedq.com/api/v1/exceptions/" + instanceId
							+ "/downloadall?format=excel.all&contentType=application/json&entityType=rule")
					.newBuilder();

			String url = urlBuilder.build().toString();

			Request request = new Request.Builder()

					.url(url)

					.addHeader("workspace-id", workspaceId)

					.addHeader("Authorization", "Bearer " + auto).addHeader("org-id", "org-iam.icedq").build();

			Call call = client.newCall(request);

			Response response = call.execute();

			System.out.println(response);

		} catch (IOException e) {

			e.getMessage();
		}
		return statusCode;
	}

	public void updateRuleName(String ruleName, String connectioName) {
		try {
			if (ruleName != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", ruleNameField);

				if (isDisplayed(driver, rulenameLabel)) {

					String val = getText(driver, rulenameLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					BaseSuite.reportLog("Entering rule name");

					clear_SendKeys(driver, ruleNameField, ruleName + "_Update");

					BaseSuite.validationReportLog("Rule name entered successfully");

				} else {

					BaseSuite.reportFailLog("Rule Name label is not display,Kindly check!", "updateRuleName");
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateRuleCode(DataTestingParameters param) {
		try {
			if (param.getRuleCode() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", rulecodeField);

				if (isDisplayed(driver, rulecodeLabel)) {

					String val = getText(driver, rulecodeLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					BaseSuite.reportLog("Entering rule code");

					clear_SendKeys(driver, rulecodeField, param.getRuleCode());

					BaseSuite.validationReportLog("Rule code entered successfully");

				} else {

					BaseSuite.reportFailLog("Rule code label is not display,Kindly check!", "updateRuleCode");
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void updateDescription(DataTestingParameters param) {
		try {
			if (param.getDescription() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", descriptionField);

				if (isDisplayed(driver, descriptionLabel)) {

					String val = getText(driver, descriptionLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					BaseSuite.reportLog("Entering rule description");

					clear_SendKeys(driver, descriptionField, param.getDescription());

					BaseSuite.validationReportLog("Rule description entered successfully");

				} else {

					BaseSuite.reportFailLog("Description label is not display,Kindly check!", "updateDescription");
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updatePurpose(DataTestingParameters param) {
		try {
			if (param.getPurpose() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", purposeField);

				if (isDisplayed(driver, purposeLabel)) {

					String val = getText(driver, purposeLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					BaseSuite.reportLog("Entering rule purpose");

					clear_SendKeys(driver, purposeField, param.getPurpose());

					BaseSuite.validationReportLog("Rule purpose entered successfully");

				} else {

					BaseSuite.reportFailLog("Purpose label is not display,Kindly check!", "updatePurpose");
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateDegreeOfPeralleilsm(DataTestingParameters param) {
		try {

			if (param.getDop() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", dopField);

				if (isDisplayed(driver, dopLabel)) {

					String val = getText(driver, dopLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					if (param.getDop() != null) {

						BaseSuite.validationReportLog("Entering Value in DOP");

						clear_SendKeys(driver, dopField, param.getDop());

						BaseSuite.validationReportLog("Entered Value in DOP successfully");

					}

				} else {

					BaseSuite.reportFailLog("Degree Of Parallelism field is not visible,Kindly check!",
							"degreeOfPeralleilsm");
				}
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at time field");
		}

	}

	public void updateStopAtRow(DataTestingParameters param) {
		try {
			if (param.getStopAtRow() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", stopAtRowLabel);

				if (isDisplayed(driver, stopAtRowLabel)) {

					String val = getText(driver, stopAtRowLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					if (param.getStopAtRow() != null) {

						BaseSuite.validationReportLog("Entering Value in stopAtRow");

						javascript(driver, "arguments[0].scrollIntoView(true);", stopAtRowField);

						clear_SendKeys(driver, stopAtRowField, param.getStopAtRow());

						BaseSuite.validationReportLog("Entered Value in stopAtRow successfully");

					}

				} else {
					BaseSuite.reportFailLog("Stop At Row field is not visible,Kindly check!", "updateStopAtRow");
				}
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at row field");
		}
	}

	// This Method is to use Click on Stop At Error option
	public void updateStopAtError(DataTestingParameters param) {
		try {
			if (param.getStopAtError() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", stopAtErrorLabel);

				if (isDisplayed(driver, stopAtErrorLabel)) {

					String val = getText(driver, stopAtErrorLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					if (param.getStopAtError() != null) {

						BaseSuite.reportLog("Click on Stop At Error");

						clear_SendKeys(driver, stopAtErrorField, param.getStopAtError());

						BaseSuite.validationReportLog("Entered Value in stopAtError successfully");
					}

				} else {
					BaseSuite.reportFailLog("Stop At Error field is not visible,Kindly check!", "updateStopAtError");
				}
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at error field");
		}
	}

	public void updateStopAtTime(DataTestingParameters param) throws InterruptedException {
		try {
			if (param.getStopAtTime() != null) {
				javascript(driver, "arguments[0].scrollIntoView(true);", stopAtAfterTimeLabel);

				if (isDisplayed(driver, stopAtAfterTimeLabel)) {

					String val = getText(driver, stopAtAfterTimeLabel);

					BaseSuite.validationReportLog(val + " lablel is displayed clearly ");

					if (param.getStopAtTime() != null) {

						BaseSuite.reportLog("Click on Stop At Time");

						javascript(driver, "arguments[0].scrollIntoView(true);", stopAfterTimeField);

						clear_SendKeys(driver, stopAfterTimeField, param.getStopAtTime());

						BaseSuite.validationReportLog("Entered Value in stopAtTime successfully");

					}

				} else {
					BaseSuite.reportFailLog("Stop After Time field is not visible,Kindly check!", "updateStopAtTime");
				}
			}

		} catch (Exception e) {

			throw new Exception("Not able to enter detail in stop at time field");
		}
	}

	public void updateAdvancedSetting(DataTestingParameters param) throws InterruptedException {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", advanceSettingLabel);

			Thread.sleep(2000);

			if (isDisplayed(driver, advanceSettingLabel)) {

				String val = getText(driver, advanceSettingLabel);

				displayAndClick(driver, advanceSettingLabel);

				Thread.sleep(2000);

				javascript(driver, "arguments[0].scrollIntoView(true);", parameterclick);

				BaseSuite.validationReportLog(val + " Title is displayed clearly ");

			}

			if (param.getEngineTypeOption().equalsIgnoreCase("HighThroughput")
					|| param.getEngineTypeOption().equalsIgnoreCase("Cluster")) {

				if (!param.getRuleType().equalsIgnoreCase("Script")) {
					updateDegreeOfPeralleilsm(param);

				}

			}

			if (param.getRuleType().equalsIgnoreCase("Validation") || param.getRuleType().equalsIgnoreCase("Recon")) {

				updateStopAtRow(param);

				if (!param.getRuleType().equalsIgnoreCase("pushdown")) {

					updateStopAtError(param);
				}

				updateStopAtTime(param);

			}

			parameterSection(param);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateOverviewSection(DataTestingParameters param, String connName) throws InterruptedException {
		try {

			// updateRuleName(param,connName);

			updateRuleCode(param);

			updateDescription(param);

			updatePurpose(param);

			criticality(param);

			severity(param);

			updateAdvancedSetting(param);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateOverviewSection(String ruleName, DataTestingParameters param, String connName)
			throws InterruptedException {
		try {

			updateRuleName(ruleName, connName);

			updateRuleCode(param);

			updateDescription(param);

			updatePurpose(param);

			criticality(param);

			severity(param);

			updateAdvancedSetting(param);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateSourceDataset(DataTestingParameters param, String connectionName, String jsonEntity,
			String changeQueryConn, String icedqRole, String workspaceId, SoftAssert soft) throws Throwable {
		try {
			String query = null;

			String connName;

			String schema;

			String table;

			String sourceConnectionType;

			String fileConnectionType;

			XLUtils xlReader = new XLUtils();

			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, connectionName);

			connName = loginDetails[0];

			schema = loginDetails[1];

			table = loginDetails[2];

			sourceConnectionType = loginDetails[3];

			fileConnectionType = loginDetails[4];

			connName = connName + "_" + BaseSuite.WorkspaceName + "_" + "vault";

			clickOnSourceDataset();

			selectSourceConnectionType(sourceConnectionType);

			selectSourceConnection(connName);

			sourceSelectInput(param.getSourceInput());

			boolean testFlag = isEnabled(driver, sourceDatasetTestButton);

			String connTestMess = "";

			if (testFlag) {
				connTestMess = testButton(sourceDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

			}

			if ((connTestMess.equalsIgnoreCase(connectionTestMess)) || (!isEnabled(driver, sourceDatasetTestButton))) {

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				// String val = getText(driver, sourceDatasetConnection);

				if (!sourceConnectionType.equalsIgnoreCase("File")) {

					if (!param.getSourceInput().equalsIgnoreCase("SQL")) {

						selectSchema(sourceDatasetSchemaClick, schema);

						if (!param.getSourceInput().equalsIgnoreCase("wizard")) {

							Thread.sleep(2000);

							selectTable(sourceDatasetTableClick, table);
						}

					}

					if (param.getRuleType().equalsIgnoreCase("Recon")) {

						appendOrderBy(param.getSourceAppendOrder(), sourceAppendOrderBy);

						deferredSort(sourceDeferredSort, jsonExpressionSourceDeferredSort, sourceColumnDelimiter,
								jsonExpressionSourceColumnDelimiter, sourceRowDelimiter,
								jsonExpressionSourceRowDelimiter, sourceTextQualifier,
								jsonExpressionSourceTextQualifier, jsonEntity);

					}
					if (param.getSourceInput().equalsIgnoreCase("SQL")) {

						/*
						 * javascript(driver, "arguments[0].scrollIntoView(true);",
						 * sourceDatasetDataQueryBox);
						 * 
						 * WebElement ele = getElement(driver, sourceDatasetDataQueryBox);
						 * 
						 * ele.sendKeys(Keys.CONTROL, "a");
						 * 
						 * ele.sendKeys(Keys.BACK_SPACE);
						 * 
						 * clear_SendKeys(driver, sourceDatasetDataQueryBox, param.getSourceQuery());
						 */

						query = enterDBQuery(param.getSourceInput(), sourceDatasetDataQueryBox, param.getSourceQuery(),
								schema, table, changeQueryConn);

					}

					verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

					previewData(sourcegetData);

					verifyTableList(sourceTableList);

				} else {
					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("Excel"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						selectFileType(sourceDatasetSetFileType, param.getSourceFileType());

					}

					singleFile(sourceSingleFileCheckbox, sourceSingleFile, jsonEntity, jsonExpressionSourceSingleFile);

					String flag = parameterisedPath(sourceParameterisedCheckbox, sourceParameterisedPath, jsonEntity,
							jsonExpressionSourceParameterisedPath);

					String containerVal = getAttribute(driver, sourceContainer, "value");

					if (!containerVal.isBlank()) {

						BaseSuite.validationReportLog("Container is not empty " + containerVal);

						isEditable(driver, sourceContainer, "Container");

					} else {

						BaseSuite.reportFailLog("Container is empty,Kindly check!", "Container");
					}

					if (flag.equalsIgnoreCase("true")) {

						BaseSuite.reportLog("Entering file path");

						isClickable(driver, sourceSelectFile, "File path", true);

						String filePath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceFilePath);

						javascript(driver, "arguments[0].scrollIntoView(true);", sourceSelectFile);

						displayAndClick(driver, sourceSelectFile);

						clear_SendKeys(driver, sourceSelectFile, filePath);

						BaseSuite.validationReportLog("File path entered successfully");

					} else {
						isClickable(driver, sourceSelectFile, "File path", false);

						getFileButton(sourceDatasetSetFileButton);

						selectFilePath(jsonEntity, "$.objects[0].configuration.filePath");

					}

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						if (param.getSourceFileType() != null
								&& param.getSourceFileType().equalsIgnoreCase("Delimited")) {

							columnDelimiter(sourceColumnDelimiter, jsonEntity, jsonExpressionSourceColumnDelimiter);

							textQualifier(sourceTextQualifier, jsonEntity, jsonExpressionSourceTextQualifier);

						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")) {
							rowDelimiter(sourceRowDelimiter, jsonEntity, jsonExpressionSourceRowDelimiter);

							trimData(sourceTrimDataCheckBox, sourceTrimData, jsonEntity, jsonExpressionSourceTrimData);
						}

						skipRowTop(sourceSkipRowTop, jsonEntity, jsonExpressionSourceSkipRowTop);

						fixedString(sourceFixedStringValue, jsonEntity, jsonExpressionSourceFixedStringValue);

						emptyStringIsNull(sourceEmptyStringisNULLCheckbox, sourceEmptyStringisNULL, jsonEntity,
								jsonExpressionSourceEmptyString);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionRuleType);

						if (ruleType.contains("Recon") && connType.equalsIgnoreCase("flat-file")) {
							caseSensitive(sourceCaseSensitiveCheckBox, sourceCaseSensitive, jsonEntity,
									jsonExpressionSourceTrimData);

							isSorted(sourceIsSortedCheckBox, sourceIsSorted, jsonEntity, jsonExpressionSourceTrimData);

						}

						if (!fileConnectionType.equalsIgnoreCase("flat-file")) {
							includeHeaders(sourceIncludeHeadersCheckbox, sourceIncludeHeaders, jsonEntity,
									jsonExpressionSourceIncludeHeaders);

						}

					}
					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						headerRow(sourceHeaderRow, jsonEntity, jsonExpressionSourceHeaderRow);

						skipRowBottom(sourceSkipRowBottom, jsonEntity, jsonExpressionSourceSkipRowBottom);

						whiteSpaceIsNull(sourceWhiteSpaceisNULLCheckbox, sourceWhiteSpaceisNULL, jsonEntity,
								jsonExpressionSourceWhiteSpace);

						clickOnGetSchemaButton(sourceGetSchema, sourceRefreshSchema, sourcegetData);

						refereshDataButton(sourceRefreshSchema);

					} else {

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !fileConnectionType.equalsIgnoreCase("parquet")) {

							xmlTableName(jsonEntity, sourceXmlTableNameText, sourceXmlTableNameEdit,
									jsonExpressionSourceXmlTableName);
						}

						String id = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceXmlFileSchemaId);

						sourceSelectPropertyForFileRule(workspaceId, id, icedqRole);

						if ((fileConnectionType.equalsIgnoreCase("XML") || fileConnectionType.equalsIgnoreCase("JSON")
								|| fileConnectionType.equalsIgnoreCase("Excel")
								|| fileConnectionType.equalsIgnoreCase("Parquet"))
								&& param.getRuleType().equalsIgnoreCase("Recon")) {

							appendOrderBy(param.getSourceAppendOrder(), sourceAppendOrderBy);

							fileDeferredSort(sourceDeferredSort, jsonEntity, jsonExpressionSourceDeferredSort);
						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !fileConnectionType.equalsIgnoreCase("Parquet")) {

							getFileSchema(SourceFileGetSchema);

							saveSchema(sourceSchemaSaveButton);

							javascript(driver, "arguments[0].scrollIntoView(true);", sourceSchemaID);

							String schemaId = getAttribute(driver, sourceSchemaID, "value");

							if (!schemaId.isBlank()) {

								BaseSuite.validationReportLog("Schema ID is not empty " + schemaId);

								isEditable(driver, sourceSchemaID, "Schema Id");

							} else {

								BaseSuite.reportFailLog("Schema ID is empty,Kindly check!", "SchemaId");
							}
						}

					}

					if (param.getSourceFileType() != null && param.getSourceFileType().equalsIgnoreCase("Fixed")) {

						String fileLayout = System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\DataTesting\\FixedFileLayout.xlsx";

						XLUtils xl = new XLUtils();

						String ruleName = xl.readUsingColName(fileLayout, "Staff", 1, "FileLayout");

						fixedFileTextArea(sourceFixedFileTextArea, sourceFixedFileTextAreaClear, ruleName,
								fileSourceAdvanceButton, fileSourceSourceButton);

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						enterFilterConditionExpression(jsonEntity, sourceFilterColumnOperator,
								sourceFilterConditionColumnList, sourceFilterConditionExpressions, param.getRuleType(),
								sourceFilterConditionLable, sourceOperator, soft);

						filePreviewData(sourcegetData);

					} else {

						query = enterQueryInXmlFile(sourceDatasetDataQueryBox, jsonEntity,
								jsonExpressionSourceXmlFileQuery, jsonExpressionSourceXmlFileTable);

						if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
							if (param.getSourceInput().equalsIgnoreCase("SQL")) {
								verifyVisibilityOfButtons(driver, copyFromTargetButton, "Copy From Target Button",
										true);
							}
						}

						previewData(sourcegetData);

					}

				}
			}

			else {
				BaseSuite.reportFailLog(
						"Not able to update a rule because connection details is invalid, kindly check the connection details or may be Test button is visible in case of File Connection",
						"");
				throw new AssertionError(
						"Not able to update a rule because connection details is invalid , kindly check");
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void updateTargetDataset(DataTestingParameters param, String targetConnectionName, String jsonEntity,
			String changeQueryConn, String icedqRole, String workspaceId, SoftAssert soft)
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		try {
			String query = null;

			String connName;

			String schema;

			String table;

			String targetConnectionType;

			String fileConnectionType;

			XLUtils xlReader = new XLUtils();

			String sheet = System.getProperty("user.dir") + Constant.CONNECTIONDETAILS;

			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(sheet, targetConnectionName);

			connName = loginDetails[0];

			schema = loginDetails[1];

			table = loginDetails[2];

			targetConnectionType = loginDetails[3];

			fileConnectionType = loginDetails[4];

			clickOnTargetDataset();

			connName = connName + "_" + BaseSuite.WorkspaceName + "_" + "vault";

			selectTargetConnectionType(targetConnectionType);

			selectTargetConnection(connName);

			targetSelectInput(param.getTargetInput());

			boolean testFlag = isEnabled(driver, targetDatasetTestButton);

			String connTestMess = "";

			if (testFlag) {
				connTestMess = testButton(targetDatasetTestButton);

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);
			}

			if ((connTestMess.equalsIgnoreCase(connectionTestMess)) || (!isEnabled(driver, targetDatasetTestButton))) {

				inVisible(driver, sourceDatasetSpinner, Constant.ruleWait);

				// verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", false);

				if (!param.getTargetConnType().equalsIgnoreCase("File")) {

					if (!param.getTargetInput().equalsIgnoreCase("SQL")) {

						selectSchema(targetDatasetSchemaClick, schema);

						if (!param.getTargetInput().equalsIgnoreCase("wizard")) {

							Thread.sleep(2000);

							selectTable(targetDatasetTableClick, table);

						}

					}

					if (param.getRuleType().equalsIgnoreCase("Recon")) {

						appendOrderBy(param.getTargetAppendOrder(), targetAppendOrderBy);

						deferredSort(targetDeferredSort, jsonExpressionTargetDeferredSort, targetColumnDelimiter,
								jsonExpressionTargetColumnDelimiter, targetRowDelimiter,
								jsonExpressionTargetRowDelimiter, targetTextQualifier,
								jsonExpressionTargetTextQualifier, jsonEntity);

					}
					if (param.getTargetInput().equalsIgnoreCase("SQL")) {
						// Thread.sleep(4000);

						/*
						 * javascript(driver, "arguments[0].scrollIntoView(true);",
						 * targetDatasetDataQueryBox);
						 * 
						 * WebElement ele = getElement(driver, targetDatasetDataQueryBox);
						 * 
						 * ele.sendKeys(Keys.CONTROL, "a");
						 * 
						 * ele.sendKeys(Keys.BACK_SPACE);
						 * 
						 * clear_SendKeys(driver, targetDatasetDataQueryBox, param.getTargetQuery());
						 */

						query = enterDBQuery(param.getTargetInput(), targetDatasetDataQueryBox, param.getTargetQuery(),
								schema, table, changeQueryConn);

					}

					verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

					previewData(targetgetdata);

					verifyTableList(targetTableList);
					// my method

				} else {

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("Excel"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						selectFileType(targetDatasetSetFileType, param.getTargetFileType());

					}

					singleFile(targetSingleFileCheckbox, targetSingleFile, jsonEntity, jsonExpressionTargetSingleFile);

					String flag = parameterisedPath(targetParameterisedCheckbox, targetParameterisedPath, jsonEntity,
							jsonExpressionTargetParameterisedPath);

					String containerVal = getAttribute(driver, targetContainer, "value");

					if (!containerVal.isBlank()) {

						BaseSuite.validationReportLog("Container is not empty " + containerVal);

						isEditable(driver, targetContainer, "Container");

					} else {

						BaseSuite.reportFailLog("Container is empty,Kindly check!", "Container");
					}

					if (flag.equalsIgnoreCase("true")) {

						BaseSuite.reportLog("Entering file path");

						isClickable(driver, targetSelectFile, "File path", true);

						String filePath = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetTargetFilePath);

						javascript(driver, "arguments[0].scrollIntoView(true);", targetSelectFile);

						displayAndClick(driver, targetSelectFile);

						clear_SendKeys(driver, targetSelectFile, filePath);

						BaseSuite.validationReportLog("File path entered successfully");

					} else {
						isClickable(driver, targetSelectFile, "File path", false);

						getFileButton(targetDatasetSetFileButton);

						selectFilePath(jsonEntity, jsonExpressionTargetTargetFilePath);

					}

					if (!(fileConnectionType.equalsIgnoreCase("XML")) && !(fileConnectionType.equalsIgnoreCase("JSON"))
							&& !(fileConnectionType.equalsIgnoreCase("parquet"))) {

						if (param.getTargetFileType() != null
								&& param.getTargetFileType().equalsIgnoreCase("Delimited")) {

							columnDelimiter(targetColumnDelimiter, jsonEntity, jsonExpressionTargetColumnDelimiter);

							textQualifier(targetTextQualifier, jsonEntity, jsonExpressionTargetTextQualifier);

						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")) {

							rowDelimiter(targetRowDelimiter, jsonEntity, jsonExpressionTargetRowDelimiter);

							trimData(targetTrimDataCheckBox, targetTrimData, jsonEntity, jsonExpressionTargetTrimData);
						}

						skipRowTop(targetSkipRowTop, jsonEntity, jsonExpressionTargetSkipRowTop);

						fixedString(targetFixedStringValue, jsonEntity, jsonExpressionTargetfixedStringValue);

						emptyStringIsNull(targetEmptyStringisNULLCheckbox, targetEmptyStringisNULL, jsonEntity,
								jsonExpressionTargetEmptyString);

						String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionRuleType);

						if (ruleType.contains("Recon") && fileConnectionType.equalsIgnoreCase("flat-file")) {
							caseSensitive(targetCaseSensitiveCheckBox, targetCaseSensitive, jsonEntity,
									jsonExpressionTargetTrimData);

							isSorted(targetIsSortedCheckBox, targetIsSorted, jsonEntity, jsonExpressionTargetTrimData);

						}

						if (!fileConnectionType.equalsIgnoreCase("flat-file")) {

							includeHeaders(targetIncludeHeadersCheckbox, targetIncludeHeaders, jsonEntity,
									jsonExpressionTargetIncludeHeaders);

						}

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						headerRow(targetHeaderRow, jsonEntity, jsonExpressionTargetHeaderRow);

						skipRowBottom(targetSkipRowBottom, jsonEntity, jsonExpressionTargetSkipRowBottom);

						whiteSpaceIsNull(targetWhiteSpaceisNULLCheckbox, targetWhiteSpaceisNULL, jsonEntity,
								jsonExpressionTargetWhiteSpace);

						clickOnGetSchemaButton(targetGetSchema, targetRefreshSchema, targetgetdata);

						refereshDataButton(targetRefreshSchema);

					} else {

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !fileConnectionType.equalsIgnoreCase("parquet")) {

							xmlTableName(jsonEntity, targetXmlTableNameText, targetXmlTableNameEdit,
									jsonExpressionTargetXmlTableName);
						}

						String id = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetXmlFileSchemaId);

						targetSelectPropertyForFileRule(workspaceId, id, icedqRole);

						if ((fileConnectionType.equalsIgnoreCase("XML") || fileConnectionType.equalsIgnoreCase("JSON")
								|| fileConnectionType.equalsIgnoreCase("Excel")
								|| fileConnectionType.equalsIgnoreCase("Parquet"))
								&& param.getRuleType().equalsIgnoreCase("Recon")) {

							appendOrderBy(param.getTargetAppendOrder(), targetAppendOrderBy);

							fileDeferredSort(targetDeferredSort, jsonEntity, jsonExpressionTargetDeferredSort);
						}

						if (!fileConnectionType.equalsIgnoreCase("Excel")
								&& !fileConnectionType.equalsIgnoreCase("Parquet")) {

							getFileSchema(targetFileGetSchema);

							saveSchema(targetSchemaSaveButton);

							javascript(driver, "arguments[0].scrollIntoView(true);", targetSchemaID);

							String schemaId = getAttribute(driver, targetSchemaID, "value");

							if (!schemaId.isBlank()) {

								BaseSuite.validationReportLog("Schema ID is not empty " + schemaId);

								isEditable(driver, targetSchemaID, "Schema Id");

							} else {

								BaseSuite.reportFailLog("Schema ID is empty,Kindly check!", "SchemaId");
							}
						}

					}

					if (param.getTargetFileType() != null && param.getTargetFileType().equalsIgnoreCase("Fixed")) {

						String fileLayout = System.getProperty("user.dir")
								+ "\\src\\main\\resources\\testdata\\DataTesting\\FixedFileLayout.xlsx";

						XLUtils xl = new XLUtils();

						String ruleName = xl.readUsingColName(fileLayout, "Staff", 1, "FileLayout");

						fixedFileTextArea(targetFixedFileTextArea, targetFixedFileTextAreaClear, ruleName,
								fileTargetAdvanceButton, fileTargetTargetButton);

					}

					if (fileConnectionType.equalsIgnoreCase("flat-file")) {

						enterFilterConditionExpression(jsonEntity, targetFilterColumnOperator,
								targetFilterConditionColumnList, targetFilterConditionExpressions, param.getRuleType(),
								targetFilterConditionLable, targetOperator, soft);

						filePreviewData(targetgetdata);

					} else {

						enterQueryInXmlFile(targetDatasetDataQueryBox, jsonEntity, jsonExpressionTargetXmlFileQuery,
								jsonExpressionTargetXmlFileTable);

						if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
							if (param.getSourceInput().equalsIgnoreCase("SQL")) {
								verifyVisibilityOfButtons(driver, copyFromTargetButton, "Copy From Target Button",
										true);
							}
						}

						previewData(targetgetdata);

					}

				}
			} else {
				BaseSuite.reportFailLog(
						"Not able to update a rule because connection details is invalid, kindly check the connection details or may be Test button is visible in case of File Connection",
						"");
				throw new AssertionError(
						"Not able to update a rule because connection details is invalid , kindly check");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void updateDiffJoin(String scrJoin, String trgJoin) throws InterruptedException {

		try {
			clickOnDiffJoin();

			String val = getText(driver, sourceTargetJoinMess);

			if (val.equals(sourceTargetJoinText)) {

				BaseSuite.validationReportLog("Source join and Target join headline matched successfully");

			} else {

				BaseSuite.reportFailLog("Source join and Target join headline not matched", "addJoins");
			}

			Thread.sleep(2000);

			String scr1 = scrJoin.toUpperCase();

			String scr2 = scrJoin.toLowerCase();

			String trg1 = trgJoin.toUpperCase();

			String trg2 = trgJoin.toLowerCase();

			BaseSuite.validationReportLog("Verifying the visibility of the button before disconnecting the join");

			verifyVisibilityOfButtons(driver, connect, "Connect Button", true);

			verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", true);

			verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", true);

			displayAndClick(driver, disconnectAll);

			BaseSuite.validationReportLog("Verifying the visibility of the button after disconnecting the join");

			verifyVisibilityOfButtons(driver, connect, "Connect Button", true);

			verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", false);

			verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", false);

			if (!scrJoin.isEmpty() || !trgJoin.isEmpty()) {

				BaseSuite.reportLog("Applying join on source and target side");

				if (isDisplayed(driver, returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2))) {
					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2));

					dragAndDrop(driver, returnTwoElements(joinSourceColName, "$name1", scr1, "$name2", scr2),
							returnTwoElements(joinTargetColName, "$name1", trg1, "$name2", trg2));

				} else {

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(joinSourceColName, "$name1", scrJoin));

					dragAndDrop(driver, returnElement(joinSourceColName, "$name1", scrJoin),
							returnElement(joinTargetColName, "$name1", trgJoin));
				}

				verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", true);

				verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", true);

				BaseSuite.validationReportLog(
						"Join successfully applied on source " + scrJoin + " column and " + trgJoin + " ");

			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void updateChecksToRule(DataTestingParameters param, String jsonEntity, String icedqRole, String workspaceId,
			String sourceQuery, String targetQuery) throws Throwable {
		try {
			ArrayList<String> checkType = null;

			SoftAssert soft = new SoftAssert();

			if (param.getRuleType().equalsIgnoreCase("Recon")) {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..type");

			} else if (param.getRuleType().equalsIgnoreCase("Validation")) {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks..type");

			}

			if (checkType != null) {
				for (int i = 1; i < checkType.size(); i++) {
					try {

						updateCheckUsingJSONTestData(param.getRuleType(), jsonEntity, i, soft, icedqRole, workspaceId,
								sourceQuery, targetQuery);

					} catch (Exception e) {

						BaseSuite.reportErrorLog("Failed due to exception :" + e.getMessage());

					} finally {

						if (isDisplayed(driver, discardPopupMsg) || isDisplayed(driver, cancelCheckButton)) {

							handleDiscardPopupWindowOnChecks();

							clickOnCancelCheckButton();
						}

					}

				}
			} else {

				throw new AssertionError("Getting null value for check types,Kindly check!");
			}
		} catch (Exception e) {

			throw new AssertionError("Not able to add checks on rule,Kindly check!");
		}

	}

	public void duplicateRule(String folderName, String searchRuleName, String icedqRole, SoftAssert soft)
			throws Throwable {

		boolean flag = false;

		boolean expoertedFileFlag = false;

		try {

			clickOnSearchedRuleNameOnDataTestingPage(folderName, searchRuleName, soft);

			moreOption("Duplicate");

			TestDataThroughApi test = new TestDataThroughApi(driver);

			String ruleID = test.getRuleIDFromRuleName(searchRuleName, BaseSuite.WorkspaceID, icedqRole);

			String jsonEntity = test.getRuleJsonEntityUsingRuleID(BaseSuite.WorkspaceID, ruleID, icedqRole);

			DataTestingParameters param = setRuleParametersForApi(BaseSuite.WorkspaceID, jsonEntity, icedqRole);

			DataTestingParameters xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

			flag = Boolean.valueOf(xrparam.getStoreFailureAndErrors());

			expoertedFileFlag = Boolean.valueOf(xrparam.getStoreExportedFileOnly());

			boolean runStatus = clickOnRunButton(jsonEntity);

			if (runStatus) {

				clickOnRecentRunButton();

				String statusOfRule;

				String executedRuleJsonEntity;

				String instanceId;

				do {

					clickOnRecentRunButton();

					clickOnRecentRunTabRefreshIcon();

					isDisplayed(driver, recentrun_latest_statusofrule);

					statusOfRule = getText(driver, recentrun_latest_statusofrule);

					isDisplayed(driver, recentrun_latest_instanceId);

				} while ((statusOfRule.equalsIgnoreCase("running")) || (statusOfRule.equalsIgnoreCase("submitted")));

				String expectedSourceCount = null;

				String expectedTargetCount = null;

				String expectedExitCode;

				instanceId = getText(driver, recentrun_latest_instanceId);

				executedRuleJsonEntity = test.exceptionJsonbody(instanceId, BaseSuite.WorkspaceID, icedqRole);

				/*
				 * state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
				 * executedRuleJsonEntity, "$.items[0].instanceSummary.state");
				 */

				if (!param.getRuleType().equalsIgnoreCase("Script")) {
					expectedSourceCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
							"$.items[0].instanceSummary.metrics.sourceCount");

					expectedTargetCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
							"$.items[0].instanceSummary.metrics.targetCount");

				}

				if (param.getRuleType().equalsIgnoreCase("Script")
						|| param.getRuleType().equalsIgnoreCase("Pushdown")) {
					expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
							"$.items[0].exitCode");

				} else {
					if (param.getRuleType().equalsIgnoreCase("Checksum")) {
						expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
								executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalErrorCount");
					} else {

						expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
								executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalCount");
					}

				}

				ArrayList<String> ruleInstanceDetailList = checkStatusOfRunningRule(param.getRuleType(),
						expectedSourceCount, expectedTargetCount, expectedExitCode);

				getRuleInstanceTable(ruleInstanceDetailList);

				getExecutionLogDetails();

				String createdRuleInstanceID = ruleInstanceDetailList.get(0);

				String ruleStatus = ruleInstanceDetailList.get(1);

				String sourceCount = ruleInstanceDetailList.get(2);

				String targetCount = ruleInstanceDetailList.get(3);

				String exitCode = ruleInstanceDetailList.get(4);

				String ruleId = getText(driver, returnElement(ruleIdText, "$name", param.getRuleName()));

				if (!(param.getRuleType().equalsIgnoreCase("checksum")
						|| param.getRuleType().equalsIgnoreCase("Script"))) {

					if (xrparam.getStoreFailureAndErrors().equalsIgnoreCase("True")
							&& ruleStatus.equalsIgnoreCase("success")) {
						verifyVisibilityOfButtons(driver, downloadExceptionReport, "Download Exception Report", true);

					} else {
						downloadExceptionReport(createdRuleInstanceID, xrparam.getStoreFailureAndErrors(), "xlsx",
								ruleId);
					}
				}

				if (!(param.getRuleType().equalsIgnoreCase("checksum")
						|| param.getRuleType().equalsIgnoreCase("script"))) {

					checkExceptionSummary(createdRuleInstanceID, ruleId, executedRuleJsonEntity, "xlsx",
							BaseSuite.WorkspaceID, "Download All", soft, icedqRole, expoertedFileFlag, flag, ruleStatus,
							sourceCount, targetCount, exitCode);

				}

			}

			else {

				BaseSuite.skipReportLog("Rule :" + param.getRuleName() + " not able to run kindly check , ");

			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}
	}

	public void duplicateRule(String workspaceID, String folderId, String ruleName, String icedqRole, SoftAssert soft)
			throws Throwable {

		boolean flag = false;

		boolean expoertedFileFlag = false;

		List<String> ruleIdList = null;

		TestDataThroughApi testData = new TestDataThroughApi(driver);

		String ruleID;

		int count;

		try {

			if (ruleName.isEmpty()) {

				ruleIdList = testData.getRuleListFromSpecificFolder(folderId, workspaceID, icedqRole);

				count = ruleIdList.size();

			} else {

				count = 1;
			}

			for (int i = 0; i < count; i++) {

				if (count > 0) {

					if (count > 1) {
						ruleName = "";
					}

					if (ruleName.isEmpty()) {

						ruleID = ruleIdList.get(i);

						String jsonEntity = testData.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

						ruleName = testData.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name");

					} else {

						ruleID = testData.getRuleIDFromRuleName(ruleName, workspaceID, icedqRole);

					}

					String jsonEntity = testData.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

					DataTestingParameters param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

					clickOnSearchedRuleNameOnDataTestingPage(ruleName, soft);

					moreOption("Duplicate");

					TestDataThroughApi test = new TestDataThroughApi(driver);

					DataTestingParameters xrparam = setExceptionReportParametersUsingApi(jsonEntity,
							param.getRuleType());

					flag = Boolean.valueOf(xrparam.getStoreFailureAndErrors());

					expoertedFileFlag = Boolean.valueOf(xrparam.getStoreExportedFileOnly());

					boolean runStatus = clickOnRunButton(jsonEntity);

					if (runStatus) {

						clickOnRecentRunButton();

						String statusOfRule;

						String executedRuleJsonEntity;

						String instanceId;

						do {

							clickOnRecentRunButton();

							clickOnRecentRunTabRefreshIcon();

							isDisplayed(driver, recentrun_latest_statusofrule);

							statusOfRule = getText(driver, recentrun_latest_statusofrule);

							isDisplayed(driver, recentrun_latest_instanceId);

						} while ((statusOfRule.equalsIgnoreCase("running"))
								|| (statusOfRule.equalsIgnoreCase("submitted")));

						String expectedSourceCount = null;

						String expectedTargetCount = null;

						String expectedExitCode;

						instanceId = getText(driver, recentrun_latest_instanceId);

						executedRuleJsonEntity = test.exceptionJsonbody(instanceId, BaseSuite.WorkspaceID, icedqRole);

						/*
						 * state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
						 * executedRuleJsonEntity, "$.items[0].instanceSummary.state");
						 */

						if (!param.getRuleType().equalsIgnoreCase("Script")) {
							expectedSourceCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
									executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.sourceCount");

							expectedTargetCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
									executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.targetCount");

						}

						if (param.getRuleType().equalsIgnoreCase("Script")
								|| param.getRuleType().equalsIgnoreCase("Pushdown")) {
							expectedExitCode = TestDataThroughApi
									.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity, "$.items[0].exitCode");

						} else {
							if (param.getRuleType().equalsIgnoreCase("Checksum")) {
								expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
										executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalErrorCount");
							} else {

								expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
										executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalErrorCount");
							}

						}

						ArrayList<String> ruleInstanceDetailList = checkStatusOfRunningRule(param.getRuleType(),
								expectedSourceCount, expectedTargetCount, expectedExitCode);

						getRuleInstanceTable(ruleInstanceDetailList);

						getExecutionLogDetails();

						String createdRuleInstanceID = ruleInstanceDetailList.get(0);

						String ruleStatus = ruleInstanceDetailList.get(1);

						String sourceCount = ruleInstanceDetailList.get(2);

						String targetCount = ruleInstanceDetailList.get(3);

						String exitCode = ruleInstanceDetailList.get(4);

						String ruleId = getText(driver, returnElement(ruleIdText, "$name", param.getRuleName()));

						ruleId = ruleId.replaceAll("[\\[\\](){}]", "");

						if (!(param.getRuleType().equalsIgnoreCase("checksum")
								|| param.getRuleType().equalsIgnoreCase("Script"))) {

							if (xrparam.getStoreFailureAndErrors().equalsIgnoreCase("True")
									&& ruleStatus.equalsIgnoreCase("success")) {
								verifyVisibilityOfButtons(driver, downloadExceptionReport, "Download Exception Report",
										true);

							} else {
								downloadExceptionReport(createdRuleInstanceID, xrparam.getStoreFailureAndErrors(),
										"xlsx", ruleId);
							}
						}

						if (!(param.getRuleType().equalsIgnoreCase("checksum")
								|| param.getRuleType().equalsIgnoreCase("script"))) {

							checkExceptionSummary(createdRuleInstanceID, ruleId, executedRuleJsonEntity, "xlsx",
									BaseSuite.WorkspaceID, "Download All", soft, icedqRole, expoertedFileFlag, flag,
									ruleStatus, sourceCount, targetCount, exitCode);

						}

					}

					else {

						BaseSuite.skipReportLog("Rule :" + param.getRuleName() + " not able to run kindly check , ");

					}

				}

				clickOnDataTestingSubMobuleName("Rules");

			}
		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void deleteRuleFromDetailsPage(String folderId, String searchRuleName, String workspaceID, String icedqRole,
			SoftAssert soft) throws Throwable {
		try {

			TestDataThroughApi testData = new TestDataThroughApi(driver);

			DataTestingParameters xrparam = null;

			boolean flag = false;

			boolean expoertedFileFlag = false;

			List<String> ruleIdList = null;

			String ruleID;

			int count;

			if (searchRuleName.isEmpty()) {

				ruleIdList = testData.getRuleListFromSpecificFolder(folderId, workspaceID, icedqRole);

				count = ruleIdList.size();

			} else {

				count = 1;
			}

			for (int i = 0; i < count; i++) {

				if (count > 0) {

					if (searchRuleName.isEmpty()) {

						ruleID = ruleIdList.get(i);

					} else {

						ruleID = testData.getRuleIDFromRuleName(searchRuleName, workspaceID, icedqRole);

					}

					String jsonEntity = testData.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

					DataTestingParameters param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

					clickOnSearchedRuleNameOnDataTestingPage(param.getRuleName(), soft);

					deleteRuleFromRuleDetailsPage(param.getRuleName(), soft);
				}

			}
		} catch (Exception e) {

			e.getMessage();
		}
	}

	public String searchCopyMoveFolder(String folderName) {
		String folder = null;

		int count = getcount(folderName, '/');

		String[] result = folderName.split("/");

		for (int colNum = 0; colNum <= count; colNum++) {

			folder = result[colNum];

			if (!folder.isEmpty()) {
				if (colNum == 1) {
					displayAndClick(driver, copyMoveFolderSearchClick);

				}

				sendKeys(driver, copyMoveFolderSearchSendKey, folder);

				displayAndClick(driver, copyMoveFolderSearchBarClick);

				displayAndClick(driver, returnElement(folderNameClick, "$name", folder));

				clear(driver, copyMoveFolderSearchSendKey);
			}

		}

		moveToElement(driver, folderMoveHover);

		displayAndClick(driver, returnElement(folderNameClickSelectButton, "$name", folderName));

		return folder;

	}

	public void copyRuleFunctionality(String ruleName, String folderNameToCopy, String folderNameFromCopy,
			SoftAssert soft) throws java.lang.Exception {
		try {
			boolean flag = false;

			folderSelectOnAdvanceFilter(folderNameFromCopy);

			int count = getcount(ruleName, ',');

			String[] result = ruleName.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String rule = result[colNum];

				flag = searchRuleOnDataTestingLandingPage(folderNameFromCopy, rule.trim(), soft);

				displayAndClick(driver, returnElement(ruleNameCheckBox, "$name", rule));

			}

			moreOption("Copy");

			verifyVisibilityOfButtons(driver, copyButton, "Copy Button", false);

			verifyVisibilityOfButtons(driver, buttonCancel, "Cancel Button", true);

			String nameFolder = searchCopyMoveFolder(folderNameToCopy);

			String val = getAttribute(driver, selectedFolderGetText, "title");

			if (val.equals(folderNameToCopy)) {

				BaseSuite.validationReportLog("Expected folder and selected folder matched successfully");

				String val1 = getText(driver, folderCopyMoveNoteMess);

				count = count + 1;

				String copyMoveNote = "You will be copying " + count + " Rule to " + nameFolder + " folder.";

				if (val1.equals(copyMoveNote)) {

					BaseSuite.validationReportLog("Expected and actual note message matched successfully");

				} else {

					BaseSuite.reportFailLog("Expected and actual note message not match,Kindly check!",
							"copyRuleFunctionality");

				}

				BaseSuite.reportLog("Clicking on Copy button");

				displayAndClick(driver, copyButton);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Copy button clicked successfully");

				Thread.sleep(3000);

				String log = getText(driver, copyMoveLogText);

				if (log.isBlank()) {

					BaseSuite.reportFailLog("Log message is blank,Kindly check!", log);

				} else {

					BaseSuite.validationReportLog("Rule copied successfully" + log);
				}

				verifyVisibilityOfButtons(driver, copyMoveLogCopyToClipboard, "Copy to clipboard", true);

				verifyVisibilityOfButtons(driver, copyMoveLogReferesh, "Referesh Log", true);

				BaseSuite.reportLog("Clicking on Done button");

				displayAndClick(driver, doneBtn);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Done button clicked successfully");

				displayAndClick(driver, removeAppliedFilter);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				folderSelectOnAdvanceFilter(folderNameToCopy);

				searchRuleOnDataTestingLandingPage(folderNameToCopy, ruleName.trim(), soft);

				String value = getText(driver, returnElement(ruleFolderText, "$name", folderNameToCopy));

				if (value.equals(nameFolder)) {
					BaseSuite.validationReportLog("Folder copied properly to target folder" + value);
				} else {
					BaseSuite.reportFailLog("Folder not copied properly to target folder,Kindly check!",
							"copyRuleFunctionality");
				}

				displayAndClick(driver, removeAppliedFilter);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			} else {

				BaseSuite.reportFailLog("Expected folder and selected folder not match,Kindly check!",
						"copyRuleFunctionality");

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void moveRuleFunctionality(String ruleName, String folderNameToMove, String folderNameFromMove,
			SoftAssert soft) throws java.lang.Exception {
		try {
			boolean flag = false;

			folderSelectOnAdvanceFilter(folderNameFromMove);

			int count = getcount(ruleName, ',');

			String[] result = ruleName.split(",");

			for (int colNum = 0; colNum <= count; colNum++) {

				String rule = result[colNum];

				flag = searchRuleOnDataTestingLandingPage(folderNameFromMove, rule.trim(), soft);

				displayAndClick(driver, returnElement(ruleNameCheckBox, "$name", rule));

			}

			moreOption("Move");

			verifyVisibilityOfButtons(driver, moveButton, "Move Button", false);

			verifyVisibilityOfButtons(driver, buttonCancel, "Cancel Button", true);

			String nameFolder = searchCopyMoveFolder(folderNameToMove);

			String val = getAttribute(driver, selectedFolderGetText, "title");

			if (val.equals(folderNameToMove)) {

				BaseSuite.validationReportLog("Expected folder and selected folder matched successfully");

				String val1 = getText(driver, folderCopyMoveNoteMess);

				count = count + 1;

				String copyMoveNote = "You will be moving " + count + " Rule to " + nameFolder + " folder.";

				if (val1.equals(copyMoveNote)) {

					BaseSuite.validationReportLog("Expected and actual note message matched successfully");

				} else {

					BaseSuite.reportFailLog("Expected and actual note message not match,Kindly check!",
							"moveRuleFunctionality");

				}

				BaseSuite.reportLog("Clicking on Move button");

				displayAndClick(driver, moveButton);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Move button clicked successfully");

				String log = getText(driver, copyMoveLogText);

				if (log.isBlank()) {

					BaseSuite.reportFailLog("Log message is blank,Kindly check!", log);

				} else {

					BaseSuite.validationReportLog("Rule moved successfully" + log);
				}

				verifyVisibilityOfButtons(driver, copyMoveLogCopyToClipboard, "Copy to clipboard", true);

				verifyVisibilityOfButtons(driver, copyMoveLogReferesh, "Referesh Log", true);

				BaseSuite.reportLog("Clicking on Done button");

				displayAndClick(driver, doneBtn);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Done button clicked successfully");

				displayAndClick(driver, removeAppliedFilter);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

				folderSelectOnAdvanceFilter(folderNameToMove);

				searchRuleOnDataTestingLandingPage(folderNameToMove, ruleName.trim(), soft);

				String value = getText(driver, returnElement(ruleFolderText, "$name", folderNameToMove));

				if (value.equals(nameFolder)) {
					BaseSuite.validationReportLog("Folder moved properly to target folder" + value);
				} else {
					BaseSuite.reportFailLog("Folder not moved properly to target folder,Kindly check!",
							"copyRuleFunctionality");
				}

				displayAndClick(driver, removeAppliedFilter);

				inVisible(driver, dataTSpinner, Constant.ruleWait);

			} else {

				BaseSuite.reportFailLog("Expected folder and selected folder not match,Kindly check!",
						"copyRuleFunctionality");

			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void deleteRuleFromListingPage(String ruleName, String folderId, String workspaceID, String icedqRole,
			SoftAssert soft) {
		try {

			TestDataThroughApi testData = new TestDataThroughApi(driver);

			DataTestingParameters xrparam = null;

			boolean flag = false;

			boolean expoertedFileFlag = false;

			List<String> ruleIdList = null;

			String ruleID;

			int count;

			if (ruleName.isEmpty()) {

				ruleIdList = testData.getRuleListFromSpecificFolder(folderId, workspaceID, icedqRole);

				count = ruleIdList.size();

			} else {

				count = 1;
			}

			for (int i = 0; i < count; i++) {

				if (count > 0) {

					if (ruleName.isEmpty()) {

						ruleID = ruleIdList.get(i);

					} else {

						ruleID = testData.getRuleIDFromRuleName(ruleName, workspaceID, icedqRole);

					}

					String jsonEntity = testData.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

					DataTestingParameters param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

					displayAndClick(driver, landingPageRefreshButton);

					inVisible(driver, dataTSpinner, Constant.ruleWait);

					searchRuleOnDataTestingLandingPage(param.getRuleName().trim(), soft);

					displayAndClick(driver, returnElement(ruleNameCheckBox, "$name", param.getRuleName()));

					moreOption("Delete");

					if (isDisplayed(driver, bulkDeletePane)) {

						BaseSuite.validationReportLog("Delete pane open after click on delete button");

						verifyVisibilityOfButtons(driver, bulkDeleteButton, "Delete Button", true);

						verifyVisibilityOfButtons(driver, buttonCancel, "Cancel Button", true);

						String note = getText(driver, bulkDeleteLog);

						if (!note.isEmpty()) {

							BaseSuite.validationReportLog(
									"Expected and actual note message matched successfully " + note);

						} else {

							BaseSuite.reportFailLog("Expected and actual note message not match,Kindly check!",
									"deleteRuleFromListingPage");

						}

						BaseSuite.reportLog("Clicking on Delete button");

						displayAndClick(driver, bulkDeleteButton);

						inVisible(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Delete button clicked successfully");

						String log = getText(driver, copyMoveLogText);

						if (log.isBlank()) {

							BaseSuite.reportFailLog("Log message is blank,Kindli check!", log);

						} else {

							BaseSuite.validationReportLog("Rule moved successfully" + log);

							verifyVisibilityOfButtons(driver, copyMoveLogCopyToClipboard, "Copy to clipboard", true);

						}

						verifyVisibilityOfButtons(driver, copyMoveLogReferesh, "Referesh Log", true);

						BaseSuite.reportLog("Clicking on Done button");

						displayAndClick(driver, doneBtn);

						inVisible(driver, dataTSpinner, Constant.ruleWait);

						BaseSuite.validationReportLog("Done button clicked successfully");

						Thread.sleep(Constant.ruleWait);

						boolean flag1;

						do {

							displayAndClick(driver, landingPageRefreshButton);

							inVisible(driver, dataTSpinner, Constant.ruleWait);

							flag1 = searchRuleOnDataTestingLandingPage(param.getRuleName().trim(), soft);

						} while (!isDisplayed(driver, noRecordToDisplayMess));

						if (flag1) {
							BaseSuite.reportFailLog("Rule not deleted after performing delete action,Kindly check!",
									"deleteRuleFromListingPage");
						} else {
							BaseSuite.validationReportLog("Rule deleted after performing delete action");

						}

					} else {
						BaseSuite.reportFailLog("Delete pane not open after click on delete button,Kondly check!",
								"deleteRuleFromListingPage");

					}

				}

			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void activateAndDeactivateRule(String folderName, String ruleName, SoftAssert soft) {
		try {

			int count = getcount(ruleName, ';');

			String[] result = ruleName.split(";");

			for (int colNum = 0; colNum <= count; colNum++) {

				String val = result[colNum];

				String[] finalVal = val.split(",");

				String rule = finalVal[0];

				String option = finalVal[1];

				clickOnSearchedRuleNameOnDataTestingPage(folderName, rule, soft);

				moreOption(option);

			}

		} catch (java.lang.Exception e) {

			e.getMessage();
		}

	}

	public void ruleReadFunction(String folderId, String workspaceID, String ruleName, String icedqRole,
			SoftAssert soft) throws Throwable {
		try {

			TestDataThroughApi testData = new TestDataThroughApi(driver);

			DataTestingParameters xrparam = null;

			boolean flag = false;

			boolean expoertedFileFlag = false;

			List<String> ruleIdList = null;

			String ruleID;

			int count;

			if (ruleName.isEmpty()) {

				ruleIdList = testData.getRuleListFromSpecificFolder(folderId, workspaceID, icedqRole);

				count = ruleIdList.size();

			} else {

				count = 1;
			}

			for (int i = 0; i < count; i++) {

				if (count > 0) {

					if (ruleName.isEmpty()) {

						ruleID = ruleIdList.get(i);

					} else {

						ruleID = testData.getRuleIDFromRuleName(ruleName, workspaceID, icedqRole);

					}

					String jsonEntity = testData.getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

					DataTestingParameters param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

					String folderName = TestDataThroughApi.getfolderNameUsingFolderList(workspaceID,
							param.getRuleName(), icedqRole);

					clickOnSearchedRuleNameOnDataTestingPage(folderName, param.getRuleName(), soft);

					readOverviewDetails(param);

					readAdvancedSettingOfOverviewSection(param);

					if (!param.getRuleType().equalsIgnoreCase("Script")) {

						readSourceDatasetDetails(param, workspaceID, icedqRole, jsonEntity);

						if (param.getRuleType().equalsIgnoreCase("Recon")
								|| param.getRuleType().equalsIgnoreCase("Checksum")) {

							readTargetDatasetDetails(param, workspaceID, icedqRole, jsonEntity);

							if (!param.getRuleType().equalsIgnoreCase("Checksum")) {

								verifyJoinApplied(jsonEntity);

							}

						}

						clickOnCheckNode1();

						if (param.getRuleType().equalsIgnoreCase("Validation")
								|| param.getRuleType().equalsIgnoreCase("Recon")) {

							verifyVisibilityOfButtons(driver, chk_addButton_SideMenuBtn, "Add Button", true);
						}

						if (!param.getRuleType().equalsIgnoreCase("Checksum")) {

							verifyResutType(jsonEntity, param.getRuleType());
						}

						verifyCheckAfterRevisitingTheRule(param, jsonEntity);

						if (!param.getRuleType().equalsIgnoreCase("Checksum")) {

							clickOnExceptionReportNode();

							xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

							WebElement textEle = driver.findElement(By.xpath(
									"(//div[contains(text(),'Export File Format')]//following::select//option)[1]"));

							String text = textEle.getAttribute("value");

							String val = xrparam.getExceptionReportFormat();

							if (text.equalsIgnoreCase(val)) {

								BaseSuite.validationReportLog(
										"Export file format matched with excepted result after revisiting the rule :: "
												+ text);

							} else {

								BaseSuite.reportFailLog(
										"Export file format not matched with excepted result after revisiting the rule :: "
												+ text,
										"validateExceptionReportTab ");
							}

							flag = revisiteDetailOfStoreFailureError(param.getRuleType(), xrparam);

							expoertedFileFlag = revisiteDetailOfStoreExportedFile(xrparam);

							revisiteDetailOfShowDownloadException(xrparam);

							String exportFileRowLimitText = getAttribute(driver, exportFileRowLimit, "aria-valuenow");

							if (exportFileRowLimitText == null) {
								exportFileRowLimitText = "";

							}

							String exportFileRowLimitVal = xrparam.getExportFileRowLimit();

							if (exportFileRowLimitVal == null) {
								exportFileRowLimitVal = "";

							}

							if (exportFileRowLimitText.equalsIgnoreCase(exportFileRowLimitVal)) {

								BaseSuite.validationReportLog(
										"Export file Row limit matched with excepted result after revisiting the rule :: "
												+ exportFileRowLimitVal);

							} else {

								BaseSuite.reportFailLog(
										"Export file Row limit not matched with excepted result after revisiting the rule :: "
												+ exportFileRowLimitVal,
										"validateExceptionReportTab ");
							}

							verifyChecksOnExceptionReport(param, jsonEntity);

						}

						revisiteSummaryDetail(param, jsonEntity);

					} else {
						param = testData.setScriptRuleParametersForApi(jsonEntity, "1");

						String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								"$.objects[?(@.id=='Script')].configuration.script");

						javascript(driver, "arguments[0].scrollIntoView(true);",
								By.xpath("//div[@class='editor-container']"));

						String val = getText(driver, By.xpath("//div[@class='editor-container']"));

						if (!val.isEmpty()) {
							BaseSuite.validationReportLog("Script text box is not blank after revisiting the rule");

						} else {
							BaseSuite.reportFailLog(
									"Script text box is blanked after revisiting the rule,Kindly check!",
									"ruleReadFunction");
						}

						ArrayList<String> connVarList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
								jsonEntity, "$.objects[?(@.id=='Variable')].configuration.variables..name");

						for (int a = 0; a < connVarList.size(); a++) {

							DataTestingParameters scparam = testData.setScriptRuleParametersForApi(jsonEntity,
									Integer.toString(a));

							Thread.sleep(3000);

							javascript(driver, "arguments[0].scrollIntoView(true);", connectionTabOnScript);

							displayAndClick(driver, connectionTabOnScript);

							int b = a + 1;

							String connValue = getText(driver,
									returnElement(scriptConnectionVariableName, "$num", Integer.toString(b)));

							if (connValue.equals(scparam.getScriptConnVarName())) {
								BaseSuite.validationReportLog(
										"Connection variable name is matched after revisiting the rule");
							} else {
								BaseSuite.reportFailLog(
										"Connection variable name is not match after revisiting the rule",
										"ruleReadFunction");

							}

							String conId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[?(@.id=='Variable')].configuration.variables[" + a
											+ "].properties.connectionId");

							String json = TestDataThroughApi.getConnectionJsonEntity(workspaceID, conId, icedqRole);

							String connName1 = TestDataThroughApi.getConnectionNmae(json);

							String connNameValue = getText(driver,
									returnElement(scriptConnectionName, "$num", Integer.toString(b)));

							if (connNameValue.equals(connName1)) {
								BaseSuite.validationReportLog("Connection name is matched after revisiting the rule");
							} else {
								BaseSuite.reportFailLog("Connection name is not match after revisiting the rule",
										"ruleReadFunction");

							}

							String connIdValue = getText(driver,
									returnElement(scriptConnectionId, "$num", Integer.toString(b)));

							if (!connIdValue.isEmpty()) {
								BaseSuite.validationReportLog(
										connIdValue + " Connection ID is visible after revisiting the rule");
							} else {
								BaseSuite.reportFailLog("Connection ID is not visible after revisiting the rule",
										"ruleReadFunction");

							}

							verifyVisibilityOfButtons(driver,
									returnElement(connVarTestButton, connDynamicVar, scparam.getScriptConnVarName()),
									"Test", true);

							verifyVisibilityOfButtons(driver,
									returnElement(connEditButton, connDynamicVar, scparam.getScriptConnVarName()),
									"Edit", true);

							verifyVisibilityOfButtons(driver, returnElement(scriptConnectionPenEdit, connDynamicVar,
									scparam.getScriptConnVarName()), "EditIcon", true);

							verifyVisibilityOfButtons(driver, returnElement(scriptConnectionDelete, connDynamicVar,
									scparam.getScriptConnVarName()), "Delete", true);

						}

					}

					String expectedSourceCount = null;

					String expectedTargetCount = null;

					String expectedExitCode;

					String statusOfRule;

					String executedRuleJsonEntity;

					String instanceId;

					clickOnRecentRunTabRefreshIcon();

					statusOfRule = getText(driver, recentrun_latest_statusofrule);

					isDisplayed(driver, recentrun_latest_instanceId);

					instanceId = getText(driver, recentrun_latest_instanceId);

					executedRuleJsonEntity = testData.exceptionJsonbody(instanceId, BaseSuite.WorkspaceID, icedqRole);

					if (!param.getRuleType().equalsIgnoreCase("Script")) {
						expectedSourceCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
								executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.sourceCount");

						expectedTargetCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
								executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.targetCount");

					}

					if (param.getRuleType().equalsIgnoreCase("Script")
							|| param.getRuleType().equalsIgnoreCase("Pushdown")) {
						expectedExitCode = TestDataThroughApi
								.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity, "$.items[0].exitCode");

					} else {
						if (param.getRuleType().equalsIgnoreCase("Checksum")) {
							expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
									executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalErrorCount");
						} else {

							expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
									executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalErrorCount");
						}

					}

					ArrayList<String> ruleInstanceDetailList = checkStatusOfRunningRule(param.getRuleType(),
							expectedSourceCount, expectedTargetCount, expectedExitCode);

					getRuleInstanceTable(ruleInstanceDetailList);

					getExecutionLogDetails();

					String createdRuleInstanceID = ruleInstanceDetailList.get(0);

					String ruleStatus = ruleInstanceDetailList.get(1);

					String sourceCount = ruleInstanceDetailList.get(2);

					String targetCount = ruleInstanceDetailList.get(3);

					String exitCode = ruleInstanceDetailList.get(4);

					String ruleId = getText(driver, returnElement(ruleIdText, "$name", param.getRuleName()));

					ruleId = ruleId.replaceAll("[\\[\\](){}]", "");

					if (!(param.getRuleType().equalsIgnoreCase("checksum")
							|| param.getRuleType().equalsIgnoreCase("Script"))) {

						if (xrparam.getStoreFailureAndErrors().equalsIgnoreCase("True")
								&& ruleStatus.equalsIgnoreCase("success")) {
							verifyVisibilityOfButtons(driver, downloadExceptionReport, "Download Exception Report",
									true);

						} else {
							downloadExceptionReport(createdRuleInstanceID, xrparam.getStoreFailureAndErrors(), "xlsx",
									ruleId);
						}
					}

					if (!(param.getRuleType().equalsIgnoreCase("checksum")
							|| param.getRuleType().equalsIgnoreCase("script"))) {

						checkExceptionSummary(createdRuleInstanceID, ruleId, executedRuleJsonEntity, "xlsx",
								BaseSuite.WorkspaceID, "Download All", soft, icedqRole, expoertedFileFlag, flag,
								ruleStatus, sourceCount, targetCount, exitCode);

					}

				}

				else {

					BaseSuite.skipReportLog("No Rules Found inside workspace , ID : " + workspaceID);
				}

				Thread.sleep(2000);

				clickOnDataTestingSubMenuTab("Rules");

			}

		}

		catch (Exception e) {

			e.getMessage();
		}
	}

	public void readOverviewDetails(DataTestingParameters param) throws InterruptedException {
		try {
			/*
			 * String ruleIconVal = getAttribute(driver, ruleIcon, "title");
			 * 
			 * if (ruleIconVal.equalsIgnoreCase(param.getRuleType())) {
			 * BaseSuite.validationReportLog(ruleIconVal +
			 * " Rule icon is visible after revisiting the rule"); } else {
			 * BaseSuite.reportFailLog(ruleIconVal +
			 * " Rule icon is not visible after revisiting the rule",
			 * "readOverviewDetails");
			 * 
			 * }
			 */
			inVisible(driver, dataTSpinner, Constant.ruleWait);

			Thread.sleep(2000);

			String ruleNameHeadlineVal = getText(driver, ruleNameHeadline).trim();

			if (ruleNameHeadlineVal.equalsIgnoreCase(param.getRuleName().trim())) {
				BaseSuite.validationReportLog(
						ruleNameHeadlineVal + " Rule name headling is visible after revisiting the rule");
			} else {
				BaseSuite.reportFailLog(
						ruleNameHeadlineVal + " Rule name headling is not visible after revisiting the rule",
						"readOverviewDetails");

			}

			String ruleState = getAttribute(driver, ruleSateChip, "title");

			if (ruleState.equalsIgnoreCase(param.getRuleSate())) {
				BaseSuite.validationReportLog(ruleState + " Rule state chip is visible after revisiting the rule");
			} else {
				BaseSuite.reportFailLog(ruleState + " Rule state chip is not visible after revisiting the rule",
						"readOverviewDetails");

			}

			verifyVisibilityOfButtons(driver, ruleRunButton, "Run Button", true);

			verifyVisibilityOfButtons(driver, publishBtn, "Publish Button", false);

			verifyVisibilityOfButtons(driver, discardDetailButton, "Discard Button", false);

			verifyVisibilityOfButtons(driver, recentRunButton, "Recent Run Button", true);

			verifyVisibilityOfButtons(driver, deleteButtoninsideRule, "Delete Button", true);

			verifyVisibilityOfButtons(driver, moreOptionButton, "More Button", true);

			verifyRetrivedValues(driver, ruleNameField, "Rule Name", "value", param.getRuleName());

			verifyRetrivedValues(driver, rulecodeField, "Rule Code", "value", param.getRuleCode());

			verifyRetrivedValues(driver, descriptionField, "Description", "value", param.getDescription());

			verifyRetrivedValues(driver, purposeField, "Purpose", "value", param.getPurpose());

			javascript(driver, "arguments[0].scrollIntoView(true);", criticalityclick);

			verifyDropDownSelectedValue(driver, criticalityValueGet, "Criticality", param.getCriticality());

			// String var = param.getSeverity().replaceAll("[\\[\\](){}]", "");

			// verifyDropDownSelectedValue(driver, severityValueGet, "Severity", var);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	// Main method to check the Advanced setting working or not
	public void readAdvancedSettingOfOverviewSection(DataTestingParameters param) throws InterruptedException {
		try {
			javascript(driver, "arguments[0].scrollIntoView(true);", advanceSettingLabel);

			Thread.sleep(2000);

			if (isDisplayed(driver, advanceSettingLabel)) {

				String val = getText(driver, advanceSettingLabel);

				displayAndClick(driver, advanceSettingLabel);

				Thread.sleep(2000);

				javascript(driver, "arguments[0].scrollIntoView(true);", parameterclick);

				BaseSuite.validationReportLog(val + " Title is displayed clearly ");

			}

			if (param.getEngineTypeOption().equalsIgnoreCase("High Throughput")
					|| param.getEngineTypeOption().equalsIgnoreCase("Cluster")) {

				verifyRetrivedValues(driver, dopField, "Degree Of Parallelism", "value", param.getDop());

			}

			if (param.getRuleType().equalsIgnoreCase("Validation") || param.getRuleType().equalsIgnoreCase("Recon")) {

				verifyRetrivedValues(driver, stopAtRowField, "Stop At Row", "value", param.getStopAtRow());

				if (!param.getRuleType().equalsIgnoreCase("pushdown")) {

					verifyRetrivedValues(driver, stopAtErrorField, "Stop At Error", "value", param.getStopAtError());
				}

				verifyRetrivedValues(driver, stopAfterTimeField, "Stop At Error", "value", param.getStopAtTime());

			}

			if (param.getParameterFilename() != null) {
				WebElement ele = driver.findElement(By.xpath("//span[@formcontrolname='paramFile']//select//option"));

				String val = ele.getAttribute("text");

				if (val.equals(param.getParameterFilename())) {

					BaseSuite.validationReportLog("Parameter value matched successfully with expected result");

				} else {

					BaseSuite.reportFailLog("Parameter value not match,Kindly check!",
							"readAdvancedSettingOfOverviewSection");
				}
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void readSourceDatasetDetails(DataTestingParameters param, String workspaceID, String icedqRole,
			String jsonEntity)
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		try {

			clickOnSourceDataset();

			String sourceConnType = param.getSourceConnType().replaceAll("\\d+", "").replaceAll("(.)([A-Z])", "$1 $2");

			if (sourceConnType.equalsIgnoreCase("Cloud DB")) {
				sourceConnType = sourceConnType.replaceAll("Cloud DB", "Cloud Data Warehouse");
			}

			verifyDropDownSelectedValue(driver, connectionTypeValueGet, "Connection Type", sourceConnType);

			String json = TestDataThroughApi.getConnectionJsonEntity(workspaceID, param.getSourceConnection(),
					icedqRole);

			String connType = TestDataThroughApi.getConnectionType(json);

			String connName = TestDataThroughApi.getConnectionNmae(json);

			verifyDropDownSelectedValue(driver, connectionValueGet, "Connection", connName);

			verifyVisibilityOfButtons(driver, sourceDatasetTestButton, "Test Button", true);

			verifyVisibilityOfButtons(driver, sourceDatasetEditButton, "Edit Button", true);

			if (!param.getSourceConnType().equalsIgnoreCase("File")) {

				verifyRadioButtonSelected(param.getSourceInput(), sourceDefaultRadioButton, sourceSqlRadioButton,
						sourceWizardRadioButton);

				if (!param.getSourceInput().equalsIgnoreCase("SQL")) {

					verifyDropDownSelectedValue(driver, schemaValueGet, "Schema", param.getSourceSchema());

					if (!param.getSourceInput().equalsIgnoreCase("wizard")) {

						verifyDropDownSelectedValue(driver, tableValueGet, "Table/Veiw", param.getSourceTable());
					}

				}

				if (param.getRuleType().equalsIgnoreCase("Recon")) {

					javascript(driver, "arguments[0].scrollIntoView(true);", sourceAppendOrderBy);

					if (param.getSourceAppendOrder().equalsIgnoreCase("true")) {
						WebElement ele = driver.findElement(By.xpath(
								"//div[@id='ssettingForm']//span[text()='Append Order By']//preceding::input[1]"));

						boolean flag = ele.isSelected();

						if (flag) {
							BaseSuite.validationReportLog("Append Order By is selected after revisiting thhe rule");
						} else {
							BaseSuite.reportFailLog("Append Order By is not selected after revisiting thhe rule",
									"SourceDataset");
						}

					} else {
						WebElement ele = driver.findElement(By
								.xpath("//div[@id='ssettingForm']//span[text()='Deferred Sort']//preceding::input[1]"));

						boolean flag = ele.isSelected();

						if (flag) {
							BaseSuite.validationReportLog("Deferred Sort is selected after revisiting thhe rule");

							verifyRetrivedValues(driver, sourceColumnDelimiter, "Column Delimiter", "value",
									jsonExpressionSourceColumnDelimiter);

							verifyRetrivedValues(driver, sourceRowDelimiter, "Row Delimiter", "value",
									jsonExpressionSourceRowDelimiter);

							verifyRetrivedValues(driver, sourceTextQualifier, "Text Qualifier", "value",
									jsonExpressionSourceTextQualifier);
						} else {
							BaseSuite.reportFailLog("Deferred Sort is not selected after revisiting thhe rule",
									"SourceDataset");
						}

					}

				}

				if (param.getSourceInput().equalsIgnoreCase("SQL")) {

					javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetDataQueryBox);

					verifyRetrivedValues(driver, sourceDatasetDataQueryBox, "SQL Query", "value",
							param.getSourceQuery());
				}

				javascript(driver, "arguments[0].scrollIntoView(true);", sourcegetData);

				verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

				if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
					if (param.getSourceInput().equalsIgnoreCase("SQL")) {
						verifyVisibilityOfButtons(driver, copyFromTargetButton, "Copy From Target Button", true);
					}
				}

			} else {
				if (!(connType.equalsIgnoreCase("XML")) && !(connType.equalsIgnoreCase("JSON"))
						&& !(connType.equalsIgnoreCase("Excel"))) {
					verifyDropDownSelectedValue(driver, schemaValueGet, "File Type", param.getSourceFileType());
				}

				revisiteSingleFileCheckbox(sourceSingleFileCheckbox, jsonEntity, jsonExpressionSourceSingleFile);

				String flag = revisiteParameterisedPathCheckbox(sourceParameterisedCheckbox, jsonEntity,
						jsonExpressionSourceParameterisedPath);

				String containerVal = getAttribute(driver, sourceContainer, "value");

				if (!containerVal.isBlank()) {

					BaseSuite.validationReportLog("Container is not empty " + containerVal);

					isEditable(driver, sourceContainer, "Container");

				} else {

					BaseSuite.reportFailLog("Container is empty,Kindly check!", "Container");
				}

				if (flag.equalsIgnoreCase("true")) {
					isClickable(driver, sourceSelectFile, "File path", true);
				} else {
					isClickable(driver, sourceSelectFile, "File path", false);
				}

				verifyRetrivedValues(driver, sourceFilePathText, "File Path", "value", TestDataThroughApi
						.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionSourceFilePath));

				verifyVisibilityOfButtons(driver, sourceDatasetSetFileButton, "Get File Button", true);

				if (!(connType.equalsIgnoreCase("XML")) && !(connType.equalsIgnoreCase("JSON"))) {

					if (param.getSourceFileType() != null && param.getSourceFileType().equalsIgnoreCase("Delimited")) {

						verifyRetrivedValues(driver, sourceColumnDelimiter, "Column Delimiter", "value",
								TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										jsonExpressionSourceColumnDelimiter));

						String textQualifier = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceTextQualifier);

						if (textQualifier.equalsIgnoreCase("\\")) {
							textQualifier = "\"";
						}

						verifyRetrivedValues(driver, sourceTextQualifier, "Text Qualifier", "value", textQualifier);
					}

					if (!connType.equalsIgnoreCase("Excel")) {

						String rowDelimiter = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceRowDelimiter);

						if (rowDelimiter.equalsIgnoreCase("\\\\n")) {
							rowDelimiter = "\\n";
						}

						verifyRetrivedValues(driver, sourceRowDelimiter, "Row Delimiter", "value", rowDelimiter);

						verifyCheckboxSelectedValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceTrimData), sourceTrimDataCheckBox, "Trim Data");

					}

					verifyRetrivedValues(driver, sourceSkipRowTop, "Skip Row From Top", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionSourceSkipRowTop));

					verifyRetrivedValues(driver, sourceFixedStringValue, "Fixed String", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionSourceFixedStringValue));

					verifyCheckboxSelectedValue(
							TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									jsonExpressionSourceEmptyString),
							sourceEmptyStringisNULLCheckbox, "Empty Value as null");

					String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							jsonExpressionRuleType);

					if (ruleType.contains("Recon") && connType.equalsIgnoreCase("flat-file")) {

						verifyCheckboxSelectedValue(
								TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										jsonExpressionSourceCaseSensitive),
								sourceCaseSensitiveCheckBox, "Case Sensitive");

						verifyCheckboxSelectedValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionSourceIsSorte), sourceIsSortedCheckBox, "Is Sorted");

					}

					if (!connType.equalsIgnoreCase("flat-file")) {

						verifyCheckboxSelectedValue(
								TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										jsonExpressionSourceIncludeHeaders),
								sourceIncludeHeadersCheckbox, "Include Headers");

					}

				}

				if (connType.equalsIgnoreCase("flat-file")) {

					verifyRetrivedValues(driver, sourceHeaderRow, "Header Row", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionSourceHeaderRow));

					verifyRetrivedValues(driver, sourceSkipRowBottom, "Skip Row Button", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionSourceSkipRowBottom));

					verifyCheckboxSelectedValue(
							TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									jsonExpressionSourceWhiteSpace),
							sourceWhiteSpaceisNULLCheckbox, "whiteS pace Is Null");

				}

				else {

					if (!connType.equalsIgnoreCase("Excel")) {

						xmlTableName(jsonEntity, sourceXmlTableNameText, sourceXmlTableNameEdit,
								jsonExpressionSourceXmlTableName);
					}

					String id = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							jsonExpressionSourceXmlFileSchemaId);

					sourceReadPropertyForFileRule(workspaceID, id, icedqRole, connType);

					if ((connType.equalsIgnoreCase("XML") || connType.equalsIgnoreCase("JSON")
							|| connType.equalsIgnoreCase("Excel")) && param.getRuleType().equalsIgnoreCase("Recon")) {

						javascript(driver, "arguments[0].scrollIntoView(true);", sourceAppendOrderBy);

						if (param.getSourceAppendOrder().equalsIgnoreCase("true")) {

							WebElement ele = driver.findElement(By.xpath(
									"//div[@id='ssettingForm']//span[text()='Append Order By']//preceding::input[1]"));

							boolean flag1 = ele.isSelected();

							if (flag1) {
								BaseSuite.validationReportLog("Append Order By is selected after revisiting thhe rule");
							} else {
								BaseSuite.reportFailLog("Append Order By is not selected after revisiting thhe rule",
										"SourceDataset");
							}

						} else {
							WebElement ele = driver.findElement(By.xpath(
									"//div[@id='ssettingForm']//span[text()='Deferred Sort']//preceding::input[1]"));

							boolean deferredSortFlag = ele.isSelected();

							if (deferredSortFlag) {

								BaseSuite.validationReportLog("Deferred Sort is selected after revisiting thhe rule");

							} else {
								BaseSuite.reportFailLog("Deferred Sort is not selected after revisiting thhe rule",
										"SourceDataset");
							}

						}

					}

					if (!connType.equalsIgnoreCase("Excel")) {

						verifyVisibilityOfButtons(driver, SourceFileGetSchema, "Get Schema", false);

						javascript(driver, "arguments[0].scrollIntoView(true);", sourceSchemaTab);

						displayAndClick(driver, sourceSchemaTab);

						displayAndClick(driver, sourceSchemaTab);

						Thread.sleep(2000);

						verifyVisibilityOfButtons(driver, sourceSchemaSaveButton, "Save Schema", false);

						String fileSchemaText = getText(driver, sourceFileSchemaText);

						if (!fileSchemaText.isEmpty()) {
							BaseSuite.validationReportLog("File schema is not empty after revisiting thhe rule");
						} else {
							BaseSuite.reportFailLog("File schema is empty after revisiting thhe rule",
									"FileSchemaText");
						}

						javascript(driver, "arguments[0].scrollIntoView(true);", sourceSchemaID);

						String schemaId = getAttribute(driver, sourceSchemaID, "value");

						if (!schemaId.isBlank()) {

							BaseSuite.validationReportLog(
									"Schema ID is not empty after revisiting the rule " + schemaId);

							isEditable(driver, sourceSchemaID, "Schema Id");

						} else {

							BaseSuite.reportFailLog("Schema ID is empty after revisiting the rule,Kindly check!",
									"SchemaId");
						}
					}

				}

				if (param.getSourceFileType() != null && param.getSourceFileType().equalsIgnoreCase("Fixed")) {

					javascript(driver, "arguments[0].scrollIntoView(true);", fileSourceAdvanceButton);

					displayAndClick(driver, fileSourceAdvanceButton);

					displayAndClick(driver, fileSourceAdvanceButton);

					Thread.sleep(2000);

					String fixedFileText = getText(driver, sourceFixedFileTextArea);

					if (!fixedFileText.isEmpty()) {
						BaseSuite.validationReportLog("Fixed file text area is not empty after revisiting the rule");
					} else {
						BaseSuite.reportFailLog("Fixed file text area is empty after revisiting the rule",
								"FixedFileTex");

					}

					javascript(driver, "arguments[0].scrollIntoView(true);", sourceRefreshSchema);

				}

				if (connType.equalsIgnoreCase("flat-file")) {

					readFilterConditionExpression(jsonEntity, sourceFilterColumnOperator,
							sourceFilterConditionColumnList, sourceFilterConditionExpressions);

					verifyVisibilityOfButtons(driver, sourceRefreshSchema, "Refresh Schema", true);

					verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

				} else {

					javascript(driver, "arguments[0].scrollIntoView(true);", sourceDatasetDataQueryBox);

					verifyRetrivedValues(driver, sourceDatasetDataQueryBox, "SQL Query", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionSourceXmlFileQuery));

					javascript(driver, "arguments[0].scrollIntoView(true);", sourcegetData);

					verifyVisibilityOfButtons(driver, sourcegetData, "Preview Data", true);

					if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
						if (param.getSourceInput().equalsIgnoreCase("SQL")) {
							verifyVisibilityOfButtons(driver, copyFromTargetButton, "Copy From Target Button", true);
						}
					}

				}

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void readTargetDatasetDetails(DataTestingParameters param, String workspaceID, String icedqRole,
			String jsonEntity) throws InterruptedException {

		try {

			clickOnTargetDataset();

			String targetConnType = param.getTargetConnType().replaceAll("\\d+", "").replaceAll("(.)([A-Z])", "$1 $2");

			verifyDropDownSelectedValue(driver, targetConnectionTypeValueGet, "Connection Type", targetConnType);

			String json = TestDataThroughApi.getConnectionJsonEntity(workspaceID, param.getTargetConnectionID(),
					icedqRole);

			String connType = TestDataThroughApi.getConnectionType(json);

			String connName = TestDataThroughApi.getConnectionNmae(json);

			verifyDropDownSelectedValue(driver, targetConnectionValueGet, "Connection", connName);

			verifyVisibilityOfButtons(driver, targetDatasetTestButton, "Test Button", true);

			verifyVisibilityOfButtons(driver, targetDatasetEditButton, "Edit Button", true);

			if (!param.getTargetConnType().equalsIgnoreCase("File")) {

				verifyRadioButtonSelected(param.getTargetInput(), targetDefaultRadioButton, targetSqlRadioButton,
						targetWizardRadioButton);

				if (!param.getTargetInput().equalsIgnoreCase("SQL")) {

					verifyDropDownSelectedValue(driver, targetSchemaValueGet, "Schema", param.getTargetSchema());

					if (!param.getTargetInput().equalsIgnoreCase("wizard")) {

						verifyDropDownSelectedValue(driver, targetTableValueGet, "Table/Veiw", param.getTargetTable());
					}

				}

				if (param.getRuleType().equalsIgnoreCase("Recon")) {

					javascript(driver, "arguments[0].scrollIntoView(true);", targetAppendOrderBy);

					if (param.getTargetAppendOrder().equalsIgnoreCase("true")) {
						WebElement ele = driver.findElement(By.xpath(
								"//div[@id='tsettingForm']//span[text()='Append Order By']//preceding::input[1]"));

						boolean flag = ele.isSelected();

						if (flag) {
							BaseSuite.validationReportLog("Append Order By is selected after revisiting thhe rule");
						} else {
							BaseSuite.reportFailLog("Append Order By is not selected after revisiting thhe rule",
									"SourceDataset");
						}

					} else {
						WebElement ele = driver.findElement(By
								.xpath("//div[@id='tsettingForm']//span[text()='Deferred Sort']//preceding::input[1]"));

						boolean flag = ele.isSelected();

						if (flag) {
							BaseSuite.validationReportLog("Deferred Sort is selected after revisiting thhe rule");

							verifyRetrivedValues(driver, targetColumnDelimiter, "Column Delimiter", "value",
									jsonExpressionTargetColumnDelimiter);

							verifyRetrivedValues(driver, targetRowDelimiter, "Row Delimiter", "value",
									jsonExpressionTargetRowDelimiter);

							verifyRetrivedValues(driver, targetTextQualifier, "Text Qualifier", "value",
									jsonExpressionTargetTextQualifier);
						} else {
							BaseSuite.reportFailLog("Deferred Sort is not selected after revisiting thhe rule",
									"SourceDataset");
						}

					}

				}

				if (param.getTargetInput().equalsIgnoreCase("SQL")) {

					javascript(driver, "arguments[0].scrollIntoView(true);", targetDatasetDataQueryBox);

					verifyRetrivedValues(driver, targetDatasetDataQueryBox, "SQL Query", "value",
							param.getTargetQuery());
				}

				javascript(driver, "arguments[0].scrollIntoView(true);", targetgetdata);

				verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

				if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
					if (param.getTargetInput().equalsIgnoreCase("SQL")) {
						verifyVisibilityOfButtons(driver, copyFromSourceButton, "Copy From Source Button", true);
					}
				}

			} else {

				if (!(connType.equalsIgnoreCase("XML")) && !(connType.equalsIgnoreCase("JSON"))
						&& !(connType.equalsIgnoreCase("Excel"))) {
					verifyDropDownSelectedValue(driver, schemaValueGet, "File Type", param.getTargetFileType());
				}

				revisiteSingleFileCheckbox(targetSingleFileCheckbox, jsonEntity, jsonExpressionTargetSingleFile);

				String flag = revisiteParameterisedPathCheckbox(targetParameterisedCheckbox, jsonEntity,
						jsonExpressionTargetParameterisedPath);

				String containerVal = getAttribute(driver, targetContainer, "value");

				if (!containerVal.isBlank()) {

					BaseSuite.validationReportLog("Container is not empty " + containerVal);

					isEditable(driver, targetContainer, "Container");

				} else {

					BaseSuite.reportFailLog("Container is empty,Kindly check!", "Container");
				}

				if (flag.equalsIgnoreCase("true")) {
					isClickable(driver, targetSelectFile, "File path", true);
				} else {
					isClickable(driver, targetSelectFile, "File path", false);
				}

				verifyRetrivedValues(driver, targetFilePathText, "File Path", "value", TestDataThroughApi
						.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionTargetTargetFilePath));

				verifyVisibilityOfButtons(driver, targetDatasetSetFileButton, "Get File Button", true);

				if (!(connType.equalsIgnoreCase("XML")) && !(connType.equalsIgnoreCase("JSON"))) {

					if (param.getTargetFileType() != null && param.getTargetFileType().equalsIgnoreCase("Delimited")) {

						verifyRetrivedValues(driver, targetColumnDelimiter, "Column Delimiter", "value",
								TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										jsonExpressionTargetColumnDelimiter));

						String textQualifier = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetTextQualifier);

						if (textQualifier.equalsIgnoreCase("\\")) {
							textQualifier = "\"";
						}

						verifyRetrivedValues(driver, targetTextQualifier, "Text Qualifier", "value", textQualifier);
					}

					if (!connType.equalsIgnoreCase("Excel")) {

						String rowDelimiter = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetRowDelimiter);

						if (rowDelimiter.equalsIgnoreCase("\\\\n")) {
							rowDelimiter = "\\n";
						}

						verifyRetrivedValues(driver, targetRowDelimiter, "Row Delimiter", "value", rowDelimiter);

						verifyCheckboxSelectedValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetTrimData), targetTrimDataCheckBox, "Trim Data");

					}

					verifyRetrivedValues(driver, targetSkipRowTop, "Skip Row From Top", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionTargetSkipRowTop));

					verifyRetrivedValues(driver, targetFixedStringValue, "Fixed String", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionTargetfixedStringValue));

					verifyCheckboxSelectedValue(
							TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									jsonExpressionTargetEmptyString),
							targetEmptyStringisNULLCheckbox, "Empty Value as null");

					String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							jsonExpressionRuleType);

					if (ruleType.contains("Recon") && connType.equalsIgnoreCase("flat-file")) {

						verifyCheckboxSelectedValue(
								TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										jsonExpressionTargetCaseSensitive),
								targetCaseSensitiveCheckBox, "Case Sensitive");

						verifyCheckboxSelectedValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
								jsonExpressionTargetIsSorted), targetIsSortedCheckBox, "Is Sorted");

					}

					if (!connType.equalsIgnoreCase("flat-file")) {

						verifyCheckboxSelectedValue(
								TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										jsonExpressionTargetIncludeHeaders),
								targetIncludeHeadersCheckbox, "Include Headers");

					}

				}

				if (connType.equalsIgnoreCase("flat-file")) {

					verifyRetrivedValues(driver, targetHeaderRow, "Header Row", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionTargetHeaderRow));

					verifyRetrivedValues(driver, targetSkipRowBottom, "Skip Row Button", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionTargetSkipRowBottom));

					verifyCheckboxSelectedValue(
							TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									jsonExpressionTargetWhiteSpace),
							targetWhiteSpaceisNULLCheckbox, "whiteS pace Is Null");

				}

				else {

					if (!connType.equalsIgnoreCase("Excel")) {

						xmlTableName(jsonEntity, targetXmlTableNameText, targetXmlTableNameEdit,
								jsonExpressionTargetXmlTableName);
					}

					String id = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							jsonExpressionTargetXmlFileSchemaId);

					targetReadPropertyForFileRule(workspaceID, id, icedqRole, connType);

					if ((connType.equalsIgnoreCase("XML") || connType.equalsIgnoreCase("JSON")
							|| connType.equalsIgnoreCase("Excel")) && param.getRuleType().equalsIgnoreCase("Recon")) {

						javascript(driver, "arguments[0].scrollIntoView(true);", targetAppendOrderBy);

						if (param.getTargetAppendOrder().equalsIgnoreCase("true")) {

							WebElement ele = driver.findElement(By.xpath(
									"//div[@id='tsettingForm']//span[text()='Append Order By']//preceding::input[1]"));

							boolean flag1 = ele.isSelected();

							if (flag1) {
								BaseSuite.validationReportLog("Append Order By is selected after revisiting thhe rule");
							} else {
								BaseSuite.reportFailLog("Append Order By is not selected after revisiting thhe rule",
										"TargetDataset");
							}

						} else {
							WebElement ele = driver.findElement(By.xpath(
									"//div[@id='tsettingForm']//span[text()='Deferred Sort']//preceding::input[1]"));

							boolean deferredSortFlag = ele.isSelected();

							if (deferredSortFlag) {

								BaseSuite.validationReportLog("Deferred Sort is selected after revisiting thhe rule");

							} else {
								BaseSuite.reportFailLog("Deferred Sort is not selected after revisiting thhe rule",
										"TargetDataset");
							}

						}

					}

					if (!connType.equalsIgnoreCase("Excel")) {

						verifyVisibilityOfButtons(driver, targetFileGetSchema, "Get Schema", false);

						javascript(driver, "arguments[0].scrollIntoView(true);", targetSchemaTab);

						displayAndClick(driver, targetSchemaTab);

						displayAndClick(driver, targetSchemaTab);

						Thread.sleep(2000);

						verifyVisibilityOfButtons(driver, targetSchemaSaveButton, "Save Schema", true);

						String fileSchemaText = getText(driver, targetFileSchemaText);

						if (!fileSchemaText.isEmpty()) {
							BaseSuite.validationReportLog("File schema is not empty after revisiting thhe rule");
						} else {
							BaseSuite.reportFailLog("File schema is empty after revisiting thhe rule",
									"FileSchemaText");
						}

						javascript(driver, "arguments[0].scrollIntoView(true);", targetSchemaID);

						String schemaId = getAttribute(driver, targetSchemaID, "value");

						if (!schemaId.isBlank()) {

							BaseSuite.validationReportLog(
									"Schema ID is not empty after revisiting the rule " + schemaId);

							isEditable(driver, targetSchemaID, "Schema Id");

						} else {

							BaseSuite.reportFailLog("Schema ID is empty after revisiting the rule,Kindly check!",
									"SchemaId");
						}
					}

				}

				if (param.getTargetFileType() != null && param.getTargetFileType().equalsIgnoreCase("Fixed")) {

					javascript(driver, "arguments[0].scrollIntoView(true);", fileTargetAdvanceButton);

					displayAndClick(driver, fileTargetAdvanceButton);

					displayAndClick(driver, fileTargetAdvanceButton);

					Thread.sleep(2000);

					String fixedFileText = getText(driver, targetFixedFileTextArea);

					if (!fixedFileText.isEmpty()) {
						BaseSuite.validationReportLog("Fixed file text area is not empty after revisiting the rule");
					} else {
						BaseSuite.reportFailLog("Fixed file text area is empty after revisiting the rule",
								"FixedFileTex");

					}

					javascript(driver, "arguments[0].scrollIntoView(true);", targetRefreshSchema);

				}

				if (connType.equalsIgnoreCase("flat-file")) {

					readFilterConditionExpression(jsonEntity, targetFilterColumnOperator,
							targetFilterConditionColumnList, targetFilterConditionExpressions);

					verifyVisibilityOfButtons(driver, targetRefreshSchema, "Refresh Schema", true);

					verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

				} else {

					javascript(driver, "arguments[0].scrollIntoView(true);", targetDatasetDataQueryBox);

					verifyRetrivedValues(driver, targetDatasetDataQueryBox, "SQL Query", "value", TestDataThroughApi
							.getJsonValueUsingJsonPathExpreesion(jsonEntity, jsonExpressionTargetXmlFileQuery));

					javascript(driver, "arguments[0].scrollIntoView(true);", targetgetdata);

					verifyVisibilityOfButtons(driver, targetgetdata, "Preview Data", true);

					if (param.getRuleType().contains("Recon") || param.getRuleType().contains("Checksum")) {
						if (param.getTargetInput().equalsIgnoreCase("SQL")) {
							verifyVisibilityOfButtons(driver, copyFromSourceButton, "Copy From Source Button", true);
						}
					}

				}

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyDropDownSelectedValue(WebDriver driver, By locator, String labelName, String inputToCompare) {
		try {
			BaseSuite.reportLog("retriving values for " + labelName);

			isDisplayed(driver, locator);

			Select select = new Select(driver.findElement(locator));

			WebElement option = select.getFirstSelectedOption();

			String retrivedValue = option.getAttribute("text");

			BaseSuite.validationReportLog("Retrived Message for " + labelName + " is :" + retrivedValue.trim());

			BaseSuite.validationReportLog("Expected Message for " + labelName + " is :" + inputToCompare.trim());

			if (!retrivedValue.isEmpty()) {

				Assert.assertEquals(retrivedValue, inputToCompare);

				BaseSuite.validationReportLog(labelName + " is matched & verified");

			} else {

				BaseSuite.reportFailLog(labelName + " is not matching", "verifyRetrivedValues");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void verifyCheckboxSelectedValue(String checkboxName, By locator, String labelName) {
		try {

			if (checkboxName.equalsIgnoreCase("true")) {

				WebElement ele = driver.findElement(locator);

				boolean flag = ele.isSelected();

				if (flag) {

					BaseSuite.validationReportLog(labelName + " is selected after revisiting thhe rule");

				} else {

					BaseSuite.reportFailLog(labelName + " is not selected after revisiting thhe rule",
							"verifyCheckboxSelectedValue");
				}

			} else {
				WebElement ele = getElement(driver, locator);

				boolean flag = ele.isSelected();

				if (flag) {

					BaseSuite.reportFailLog(labelName + " is not selected after revisiting thhe rule",
							"verifyCheckboxSelectedValue");

				} else {

					BaseSuite.validationReportLog(labelName + " is selected after revisiting thhe rule");
				}

			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void verifyRadioButtonSelected(String input, By locator1, By locator2, By locator3) {
		try {

			WebElement ele;

			BaseSuite.reportLog("Verifying radio button");

			if (input.equalsIgnoreCase("Table")) {

				ele = driver.findElement(locator1);

			} else if (input.equalsIgnoreCase("sql")) {

				ele = driver.findElement(locator2);

			} else {

				ele = driver.findElement(locator3);
			}

			boolean flag = ele.isSelected();

			if (flag) {
				BaseSuite.validationReportLog("Radio button is selected after revisiting the rule");
			} else {
				BaseSuite.reportFailLog("Radio button is not selected after revisiting the rule,Kindly check!",
						"verifyRadioButtonSelected");
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyJoinApplied(String jsonEntity) throws InterruptedException {
		try {
			clickOnDiffJoin();

			String val = getText(driver, sourceTargetJoinMess);

			if (val.equals(sourceTargetJoinText)) {

				BaseSuite.validationReportLog("Source join and Target join headline matched successfully");

			} else {

				BaseSuite.reportFailLog("Source join and Target join headline not matched", "addJoins");
			}

			verifyVisibilityOfButtons(driver, connect, "Connect Button", true);

			verifyVisibilityOfButtons(driver, addAllExpression, "Add all expresion Button", true);

			verifyVisibilityOfButtons(driver, disconnectAll, "Disconnect Button", true);

			ArrayList<String> sourceJoin = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[2].configuration.joins..sourceKey");

			ArrayList<String> targetJoin = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
					"$.objects[2].configuration.joins..targetKey");

			for (int j = 0; j < sourceJoin.size(); j++) {

				String source = getAttribute(driver, returnElement(sourceJoinApplied, "$name", sourceJoin.get(j)),
						"class");

				String target = getAttribute(driver, returnElement(targetJoinApplied, "$name", targetJoin.get(j)),
						"class");

				if (source.equalsIgnoreCase("port pin") && target.equalsIgnoreCase("port pin")) {
					BaseSuite.validationReportLog("Source and Target join is applied after revisiting the rule");

				} else {
					BaseSuite.reportFailLog("Source and Target join is not applied after revisiting the rule",
							"verifyJoinApplied");
				}

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyChecksOnExceptionReport(DataTestingParameters param, String jsonEntity) {
		try {
			ArrayList<String> checkType = null;

			SoftAssert soft = new SoftAssert();

			if (param.getRuleType().equalsIgnoreCase("Recon")) {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..type");

			} else if (param.getRuleType().equalsIgnoreCase("Validation")) {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks..type");

			}

			if (checkType != null) {

				String chkExpp = null;

				for (int i = 1; i < checkType.size(); i++) {

					DataTestingParameters p = setChecksParametersUsingApi(jsonEntity, param.getRuleType(), i);

					javascript(driver, "arguments[0].scrollIntoView(true);",
							returnElement(checkNameOnExceptionReportTab, "$name", p.getChkCheckName()));

					verifyIndividualLabel(driver,
							returnElement(checkNameOnExceptionReportTab, "$name", p.getChkCheckName()),
							"Check Name " + p.getChkCheckName());

					if (p.getChkExpression().contains("\\")) {
						chkExpp = p.getChkExpression().replaceAll("\\\\", "\"");

					} else {
						chkExpp = p.getChkExpression();
					}

					verifyIndividualLabel(driver, returnElement(expressionNameOnExceptionReportTab, "$name", chkExpp),
							"Check Expression " + p.getChkExpression());

					verifyIndividualLabel(driver,
							returnElement(expressionStatusOnExceptionReportTab, "$name", Integer.toString(i)),
							"Active Check Status");

					String val1 = p.getCheckVisibility();

					WebElement ele = driver.findElement(
							By.xpath("((//table[@id='Normalgrid_content_table'])[2]//tr//td//span//input)[" + i + "]"));

					boolean falg1 = ele.isSelected();

					if (val1.equalsIgnoreCase("true")) {
						if (falg1) {

							BaseSuite.validationReportLog("Check show check box is checked after revisiting the rule");

						} else {

							BaseSuite.reportFailLog("Check show check box not checked after revisiting the rule",
									"revisiteDetailsInExceptionPeport");

						}
					} else {
						if (falg1) {

							BaseSuite.reportFailLog("Check show check box is checked after revisiting the rule",
									"revisiteDetailsInExceptionPeport");

						} else {

							BaseSuite
									.validationReportLog("Check show check box is unchecked after revisiting the rule");

						}

					}
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyCheckAfterRevisitingTheRule(DataTestingParameters param, String jsonEntity)
			throws java.lang.Exception {
		try {
			ArrayList<String> checkType = null;

			SoftAssert soft = new SoftAssert();

			if (param.getRuleType().equalsIgnoreCase("Recon")) {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..type");

			} else if (param.getRuleType().equalsIgnoreCase("Validation")
					|| param.getRuleType().equalsIgnoreCase("pushdown")) {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks..type");

			} else {

				checkType = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[2].configuration.checks..type");
			}

			if (checkType != null) {

				if (!param.getRuleType().equalsIgnoreCase("Checksum")
						&& !param.getRuleType().equalsIgnoreCase("pushdown")) {

					verifyVisibilityOfButtons(driver, chk_addButton_SideMenuBtn, "Add ", true);
				}

				verifyVisibilityOfButtons(driver, checkActiveButton, "Activate Button", false);

				verifyVisibilityOfButtons(driver, checkDeactiveButton, "Deactivate Button", false);

				verifyVisibilityOfButtons(driver, checkDeleteButton, "Delete Button", false);

				for (int i = 0; i < checkType.size(); i++) {

					DataTestingParameters p = setChecksParametersUsingApi(jsonEntity, param.getRuleType(), i);

					String chkExpp;

					if (!p.getChkCheckType().equalsIgnoreCase("ResultType")) {

						if (!param.getRuleType().equalsIgnoreCase("Checksum")) {
							searchCheckName(p.getChkCheckName());
						}

						if (p.getChkExpression().contains("\\")) {
							chkExpp = p.getChkExpression().replaceAll("\\\\", "\"");

						} else {
							chkExpp = p.getChkExpression();
						}

						verifyRetrivedValues(driver, addedCheckName, "Check Name", p.getChkCheckName());

						verifyRetrivedValues(driver, addedCheckExpression, "Check Expression", chkExpp);

						String checkStatus = getText(driver, addedCheckStatus).trim();

						String val = p.getChkStatus();

						if (val.equalsIgnoreCase("true")) {
							val = "Active";
						} else {
							val = "Deactive";
						}

						if (checkStatus.equalsIgnoreCase(val)) {

							BaseSuite.validationReportLog("Check is Active as excepted");

						} else {

							BaseSuite.reportFailLog("Check is not Active,Kindly check!",
									"verifyCheckAfterRevisitingTheRule");
						}

						if (param.getRuleType().equalsIgnoreCase("Pushdown")) {

							verifyCheckTableButton(checkTableDeactiveButton, "Deactivate");

							verifyCheckTableButton(checkTableEditButton, "Edit");

							verifyCheckTableButton(checkTableDeleteButton, "Delete");

						} else if (param.getRuleType().equalsIgnoreCase("Checksum")) {

							verifyCheckTableButton(checkTableDeactiveButton, "Deactivate");

							verifyVisibilityOfButtons(driver, checkTableEditButton, "Edit", true);

							verifyCheckTableButton(checkTableDeleteButton, "Delete");

						} else {

							verifyVisibilityOfButtons(driver, checkTableDeactiveButton, "Deactivate", true);

							verifyVisibilityOfButtons(driver, checkTableEditButton, "Edit", true);

							verifyVisibilityOfButtons(driver, checkTableDeleteButton, "Delete", true);
						}

					}
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void revisiteDetailsInExceptionPeport(String jsonEntity, DataTestingParameters param) throws Throwable {
		try {
			clickOnExceptionReportNode();

			DataTestingParameters xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

			WebElement textEle = driver.findElement(
					By.xpath("(//div[contains(text(),'Export File Format')]//following::select//option)[1]"));

			String text = textEle.getAttribute("value");

			String val = xrparam.getExceptionReportFormat();

			if (text.equalsIgnoreCase(val)) {

				BaseSuite.validationReportLog(
						"Export file format matched with excepted result after revisiting the rule :: " + text);

			} else {

				BaseSuite.reportFailLog(
						"Export file format not matched with excepted result after revisiting the rule :: " + text,
						"validateExceptionReportTab ");
			}

			revisiteDetailOfStoreFailureError(param.getRuleType(), xrparam);

			revisiteDetailOfStoreExportedFile(xrparam);

			revisiteDetailOfShowDownloadException(xrparam);

			String exportFileRowLimitText = getAttribute(driver, exportFileRowLimit, "aria-valuenow");

			if (exportFileRowLimitText == null) {
				exportFileRowLimitText = "";

			}

			String exportFileRowLimitVal = xrparam.getExportFileRowLimit();

			if (exportFileRowLimitVal == null) {
				exportFileRowLimitVal = "";

			}

			if (exportFileRowLimitText.equalsIgnoreCase(exportFileRowLimitVal)) {

				BaseSuite.validationReportLog(
						"Export file Row limit matched with excepted result after revisiting the rule :: " + text);

			} else {

				BaseSuite.reportFailLog(
						"Export file Row limit not matched with excepted result after revisiting the rule :: " + text,
						"validateExceptionReportTab ");
			}

			verifyChecksOnExceptionReport(param, jsonEntity);

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public boolean revisiteDetailOfStoreFailureError(String ruleType, DataTestingParameters xrparam) {
		boolean flag = false;
		try {
			if (ruleType.equalsIgnoreCase("pushdown")) {
				if (ruleType.equalsIgnoreCase("pushdown")) {

					String status = getAttribute(driver, storeExportedFileCheckboxDisabeEnable, "class");

					if (status.contains("disabled")) {

						BaseSuite.validationReportLog(
								"Store Failure & Errors Only check box is disable for pushdown rule");

						flag = false;

					} else {
						BaseSuite.validationReportLog(
								"Store Failure & Errors Only check box is enable for pushdown rule");
					}
				}
			} else {
				String val1 = xrparam.getStoreFailureAndErrors();

				WebElement ele = driver
						.findElement(By.xpath("//span[text()='Store Failure & Errors Only']//preceding::input[1]"));

				boolean falg1 = ele.isSelected();

				if (val1.equalsIgnoreCase("true")) {
					if (falg1) {

						BaseSuite.validationReportLog(
								"Store failure and Error only check box is checked after revisiting the rule");

						flag = true;

					} else {

						BaseSuite.reportFailLog(
								"Store failure and Error only check box not checked after revisiting the rule",
								"revisiteDetailsInExceptionPeport");

					}
				} else {
					if (falg1) {

						BaseSuite.reportFailLog(
								"Store failure and Error only check box is checked after revisiting the rule",
								"revisiteDetailsInExceptionPeport");

					} else {

						BaseSuite.validationReportLog(
								"Store failure and Error only check box is unchecked after revisiting the rule");

						flag = false;
					}

				}
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return flag;

	}

	public boolean revisiteDetailOfStoreExportedFile(DataTestingParameters xrparam) {
		boolean flag = false;

		try {
			String val2 = xrparam.getStoreExportedFileOnly();

			WebElement ele1 = driver
					.findElement(By.xpath("//span[text()='Store Exported File Only']//preceding::input[1]"));

			boolean falg2 = ele1.isSelected();

			if (val2.equalsIgnoreCase("true")) {
				if (falg2) {

					BaseSuite.validationReportLog(
							"Store Exported File only check box is checked after revisiting the rule");

					flag = true;

				} else {

					BaseSuite.reportFailLog("Store Exported File only check box not checked after revisiting the rule",
							"revisiteDetailsInExceptionPeport");

				}
			} else {
				if (falg2) {

					BaseSuite.reportFailLog("Store Exported File only check box is checked after revisiting the rule",
							"revisiteDetailsInExceptionPeport");

				} else {

					BaseSuite.validationReportLog(
							"Store Exported File only check box is unchecked after revisiting the rule");

					flag = false;

				}

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return flag;

	}

	public void revisiteDetailOfShowDownloadException(DataTestingParameters xrparam) {
		try {

			String val3 = xrparam.getShowDownloadExceptionurl();

			WebElement ele2 = driver
					.findElement(By.xpath("//span[text()='Show Download Exception Url']//preceding::input[1]"));

			boolean falg3 = ele2.isSelected();

			if (val3.equalsIgnoreCase("true")) {
				if (falg3) {

					BaseSuite.validationReportLog(
							"Show Download Exception Url check box is checked after revisiting the rule");

				} else {

					BaseSuite.reportFailLog(
							"Show Download Exception Url check box not checked after revisiting the rule",
							"revisiteDetailsInExceptionPeport");

				}
			} else {
				if (falg3) {

					BaseSuite.reportFailLog(
							"Show Download Exception Url check box is checked after revisiting the rule",
							"revisiteDetailsInExceptionPeport");

				} else {

					BaseSuite.validationReportLog(
							"Show Download Exception Url check box is unchecked after revisiting the rule");

				}

			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void revisiteSummaryDetail(DataTestingParameters param, String jsonEntity) throws InterruptedException {
		try {
			ArrayList<String> summaryList;

			clickOnSummary();

			verifyVisibilityOfButtons(driver, clicknewvariable, "Add button", true);

			verifyVisibilityOfButtons(driver, clickDeletevariable, "Delete button", false);

			int count = 0;

			if (param.getRuleType().equalsIgnoreCase("Recon") || param.getRuleType().equalsIgnoreCase("HT Recon")) {

				summaryList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[5].configuration.checks..id");

				count = 5;
			} else {
				summaryList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..id");

				count = 3;

			}

			int count1 = summaryList.size();

			for (int i = 0; i < count1; i++) {

				String summaryName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[" + count + "].configuration.checks[" + i + "].name");

				String summaryValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[" + count + "].configuration.checks[" + i + "].expression.value");

				String isOverrideFlag = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[" + count + "].configuration.checks[" + i + "].isOverride");

				searchSummaryName(summaryName);

				verifyRetrivedValues(driver, summaryVariableTex, "Summary variable Name", summaryName);

				verifyRetrivedValues(driver, summaryFormulaText, "Summary variable Formula", summaryValue);

				WebElement ele2 = driver.findElement(By.xpath("(//span[@title='Variable']//following::input)[1]"));

				boolean falg3 = ele2.isSelected();

				if (isOverrideFlag.equalsIgnoreCase("true")) {
					if (falg3) {

						BaseSuite.validationReportLog(
								"Is override exit code check box is checked after revisiting the rule");

					} else {

						BaseSuite.reportFailLog("Is override exit code check box not checked after revisiting the rule",
								"revisiteDetailsInExceptionPeport");

					}
				} else {
					if (falg3) {

						BaseSuite.reportFailLog("Is override exit code check box is checked after revisiting the rule",
								"revisiteDetailsInExceptionPeport");

					} else {

						BaseSuite.validationReportLog(
								"Is override exit code check box is unchecked after revisiting the rule");

					}

				}

				verifyVisibilityOfButtons(driver, summaryEditButton, "Edit button", true);

				verifyCheckTableButton(summaryDeleteButton, "Delete");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void verifyCheckTableButton(By locator, String buttonName) {
		try {
			String val = getAttribute(driver, locator, "class");

			if (val.contains("dis")) {
				BaseSuite.validationReportLog(buttonName + " button is disabled");
			} else {
				BaseSuite.reportFailLog(buttonName + " button is enable,kindly check!", "verifyCheckTableButton");

			}
		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void handleDiscardWindow() {
		try {
			isDisplayedInLoop(driver, 0, discardButtons);
			if (isDisplayed(driver, discardButtons)) {

				clickOnButton(driver, discardButtons, discardContent, true);

				inVisible(driver, dataTSpinner, Constant.ruleWait);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error occurs while handleDiscardWindow :: " + e.toString());

		}
	}

	// validate title of functionality
	public boolean validateTitle(By locator, String label) {
		boolean flag = false;
		isDisplayedInLoop(driver, 2, locator);

		if (isDisplayed(driver, locator)) {

			flag = true;

			BaseSuite.validationReportLog(label + " title is visible");

		} else {
			BaseSuite.reportFailLog(label + " title not visible", "validateTitle");

		}
		return flag;
	}

	// click on rules tab
	public boolean clickOnRulesTab() {
		boolean flag = false;
		int i = 0;
		try {
			inVisible(driver, dataTSpinner, Constant.ruleWait);

			handleDiscardWindow();

			isDisplayedInLoop(driver, 2, ruleTab);

			if (isDisplayed(driver, ruleTab)) {

				flag = isClickable(driver, ruleTab, "Rules tab", true);

				if (flag) {

					BaseSuite.reportLog("Clicking on Rules tab");

					displayAndClick(driver, ruleTab);

					BaseSuite.validationReportLog("Clicked on Rules tab");

					handleDiscardWindow();

					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					do {
						i++;

						waitForExecution(1000);

						inVisible(driver, dataTSpinner, Constant.ruleWait);

					} while (i == 4);

					handleDiscardWindow();

					flag = validateTitle(ruleTitle, "Rules");

					if (!flag) {

						BaseSuite.reportFailLog("Rules tab not visible", "clickOnRulesTab");

						driver.navigate().refresh();

						driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					}
					clickOnButton(driver, refreshRuleButton, refreshContent, true);
				}
			} else {
				BaseSuite.reportFailLog("Rules tab not visible", "clickOnRulesTab");
				handleDiscardWindow();
				throw new AssertionError(ConstantProperty.TESTCASE_FAILED);
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog("Error occurs while clickOnRulesTab :: " + e.toString());

			throw new AssertionError(ConstantProperty.TESTCASE_FAILED);
		}

		return flag;

	}

	public void continueNext(String methodName, ExtentTest test, String errorMsg, String fileName, String sheetName,
			int ruleNumber, String columnName, Logger log) throws Exception, IOException {

		try {
			BaseClassUtil util = new BaseClassUtil();

			XLUtils xl = new XLUtils();

			// sheet
			xl.writeToExcel("Fail", fileName, sheetName, ruleNumber, columnName);// write the excel as fail into the
			// status
			// column
			test.error("Rule with Rule number " + ruleNumber + " failed");// log the error in
			// extent
			// report

			test.error(errorMsg);// Log the exception in extent report

			String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen
			// shot

			test.log(Status.FAIL, methodName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

			log.debug(errorMsg);// also log this error into application log
			waitForElement(driver, brdCrumsDataTesting);

			displayAndClick(driver, brdCrumsDataTesting);

			if (isDisplayed(driver, discardButtons)) {

				displayAndClick(driver, discardButtons);// we have to click on yes button to discard
				// changed if
				// this message appears

			}

			log.debug("Rule number " + ruleNumber + " failed");// log the rule number into log

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
