package nextgen.automation.workflow.service.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.DataIntegrityUtils;
import nexgen.automation.framework.util.XLUtils;
import nextgen.automation.RuleRepo.pages.DataTestingPage;
import nextgen.automation.framework.enums.OverrideType;

public class WorkflowServicePage extends WorkflowPage {

	public WorkflowServicePage(WebDriver driver) {
		super(driver);

	}

	By connectionNameFieldTitle =getElementLocator(prop.getProperty("workflow.connection.field.title"));
	By connectionNameField = getElementLocator(prop.getProperty("workflow.connection.field.name"));
	By connectionNameFieldValidation = getElementLocator(prop.getProperty("workflow.connection.field.validation"));
	By ruleNameFieldTitle =getElementLocator(prop.getProperty("workflow.rule.field.title"));
	By ruleNameField = getElementLocator(prop.getProperty("workflow.rule.field.name"));
	By ruleNameFieldValidation = getElementLocator(prop.getProperty("workflow.rule.field.validation"));
	By connectionSaveButton = getElementLocator(prop.getProperty("paramerers.details.button.save"));
	By ruleStateOnRulePage = getElementLocator(prop.getProperty("rule.details.title.current.status"));
	By parametersAppliedFilterCross=getElementLocator(prop.getProperty("Workflow.default.Applied.filter"));
	By listingPageStaticCount = getElementLocator(prop.getProperty("Workflows.listing.static.count"));
	By folderSearchExpandIcon = getElementLocator(prop.getProperty("Workflows.listing.folderpath.expand"));
	By listingMasterCheckbox = getElementLocator(prop.getProperty("Workflows.listing.column.mastercheckbox"));
	By listingColumnName = getElementLocator(prop.getProperty("Workflows.listing.column.name"));
	By listingColumndesc = getElementLocator(prop.getProperty("Workflows.listing.column.description"));
	By listingColumnFolder = getElementLocator(prop.getProperty("Workflows.listing.column.folder"));
	By listingColumnLastUpdated = getElementLocator(prop.getProperty("Workflows.listing.column.lastupdated"));
	By parameterLabel = getElementLocator(prop.getProperty("DataTesting.ParameterLabel"));
	By parameterclick = getElementLocator(prop.getProperty("DataTesting.Parameterclick"));
	By parameterSearch = getElementLocator(prop.getProperty("rule.details.parameter.select.input"));
	By advanceSettingLabel = getElementLocator(prop.getProperty("DataTesting.AdvanceSettingLabel"));
	By sourceDatasetConnectionClick = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionClick"));
	By sourceDatasetConnectionSearch = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionSearch"));
	By sourceDatasetConnection = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnection"));
	By dropDownBox = getElementLocator(prop.getProperty("RuleRepo.DropDownBox"));
	By ruleSourceDatasetTab = getElementLocator(prop.getProperty("rule.details.source.dataset.tab"));
	By ruleTargetDatasetTab = getElementLocator(prop.getProperty("rule.details.target.dataset.tab"));
	By ruleDiffJoinTab = getElementLocator(prop.getProperty("rule.details.diffjoin.tab"));
	By ruleChecksTab = getElementLocator(prop.getProperty("rule.details.checks.tab"));
	By exceptionReportTab = getElementLocator(prop.getProperty("rule.details.exceptionreport.tab"));
	By targetDatasetConnectionClick = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetConnectionClick"));
	By sourceDatasetConnectionType = getElementLocator(prop.getProperty("RuleRepo.SourceDatasetConnectionType"));
	By targetDatasetConnectionType = getElementLocator(prop.getProperty("RuleRepo.TargetDatasetConnectionType"));
	By sourceSQLQueryEditor = getElementLocator(prop.getProperty("rule.details.source.sql.query.editor"));
	By targetSQLQueryEditor = getElementLocator(prop.getProperty("rule.details.target.sql.query.editor"));
	By sourcegetData = getElementLocator(prop.getProperty("RuleRepo.SourceGetData"));
	By targetgetdata = getElementLocator(prop.getProperty("RuleRepo.TargetGetData"));
	By workflowDetailsRuleRefreshIcon= getElementLocator(prop.getProperty("workflow.details.rules.list.refreshIcon"));
	By engineTypeField = getElementLocator(prop.getProperty("rule.details.newrulepane.engineType.field"));
	By languageTypeField = getElementLocator(prop.getProperty("rule.details.newrulepane.languageType.field"));
	By addCheckButton = getElementLocator(prop.getProperty("rule.details.checks.add.button"));
	By customCheckIcon = getElementLocator(prop.getProperty("rule.details.checks.custom.label"));
	By customExpressiontextbox = getElementLocator(prop.getProperty("rule.details.checks.custom.expression.textarea"));
	By saveCheckButton = getElementLocator(prop.getProperty("rule.details.checks.custom.save.button"));
	By storeFailureErrorOnlyCheckbox = getElementLocator(prop.getProperty("rule.details.exceptionreport.storefailureerroronly.checkbox"));

	String connectionNameLabel="connection name";
	String hyphenContent=prop.getProperty("String.hyphenContent");
	String lastUpdatedContent="Last Updated";
	String folderCheckboxOnListingPage = prop.getProperty("Workflows.listing.folderpath.checkbox");
	String listingStaticAvatar = prop.getProperty("Workflows.listing.static.avatar");
	String listingStaticName = prop.getProperty("Workflows.listing.static.name");
	String listingStaticState = prop.getProperty("Workflows.listing.static.state");
	String listingStaticDesc = prop.getProperty("Workflows.listing.static.desc");
	String listingStaticFolder = prop.getProperty("Workflows.listing.static.folder");
	String listingStaticlastUpdate = prop.getProperty("Workflows.listing.static.lastupdate");
	public static final String RRTIMESTAMPFORMAT ="M/d/yyyy, h:mm:ss a";
	String sourceDatasetConnectionSelect = prop.getProperty("RuleRepo.SourceDatasetConnectionSelect");
	String parameterSelect = prop.getProperty("rule.details.parameter.select.using.folderpath");
	String sourceDatasetConnectionTypeSelect = prop.getProperty("rule.details.source.connectorType.select");
	String connectionInputSourceTypeLocator = prop.getProperty("rule.details.connection.input.source.type");
	String connectionInputTargetLocator = prop.getProperty("rule.details.connection.input.target.type");
	String monacoEditorScript=prop.getProperty("monaco.editor.javascript");
	String engineTypeDropdown = prop.getProperty("rule.details.source.engineType.dd");
	String languageTypeDropdown = prop.getProperty("rule.details.source.languageType.dd");
	String chooseTemplage=prop.getProperty("rule.details.newrulepane.choosetemplate");
	String workflowFolderSearchDropdownArrow = prop.getProperty("workflow.folderSearch.folder.dropdown.icon");
	String placeholderRuleName = "Enter rule name";
	String emplyRuleNameMsg = "Rule name is required.";
	String sourceContent="Source";
	String targetContent="Target";
	String sourceTableDiffJoinColumnIndex = prop.getProperty("rule.details.diffjoin.source.column.index");
	String targetTableDiffJoinColumnIndex = prop.getProperty("rule.details.diffjoin.target.column.index");

	// set workflow parameters using excel
	public DataTestingParameters setWorkflowDetailsUsingExcelData(String fileName, String sheetName, int rowNumber, String icedqUser) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			boolean isContributor = icedqUser.toLowerCase().contains(contributorContent);

			param.setTestScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, ketTestScenario));
			param.setScenarioType(xl.readUsingColName(fileName, sheetName, rowNumber, keyScenarioType));
			param.setExecutionstate(xl.readUsingColName(fileName, sheetName, rowNumber, "execute"));
			param.setAdvanceSearch(xl.readUsingColName(fileName, sheetName, rowNumber, "advanceSearch"));
			param.setIsActive(xl.readUsingColName(fileName, sheetName, rowNumber, "removeExistingFilter"));
			param.setOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "order"));
			param.setType(xl.readUsingColName(fileName,sheetName, rowNumber, "type"));			
			param.setChkCheckType(xl.readUsingColName(fileName,sheetName, rowNumber, "checkAll"));
			param.setWorkflowName(xl.readUsingColName(fileName,sheetName, rowNumber, keyworkflowName));
			param.setRuleName(xl.readUsingColName(fileName,sheetName, rowNumber, "ruleName"));
			param.setSearchName(xl.readUsingColName(fileName,sheetName, rowNumber, isContributor ? "searchName2" : "searchName"));
			param.setUpdatedCheckName(xl.readUsingColName(fileName,sheetName, rowNumber, isContributor ? "updateName2" : "updateName"));
			param.setFolderName(xl.readUsingColName(fileName,sheetName, rowNumber, keyfolderName));
			param.setWorkflowExecutionStatus(xl.readUsingColName(fileName,sheetName, rowNumber, "executeWorkflow"));
			return param;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  "error occurs while setWorkflowDetailsUsingExcelData "+e.toString());
		}
		return param;

	}

	// set workflow parameters using excel
	public DataTestingParameters setWorkflowDetailsUsingExcelData(String fileName, String sheetName, int rowNumber) {

		DataTestingParameters param = new DataTestingParameters();
		XLUtils xl = new XLUtils();
		try {

			param.setTestScenarioName(xl.readUsingColName(fileName, sheetName, rowNumber, ketTestScenario));
			param.setScenarioType(xl.readUsingColName(fileName, sheetName, rowNumber, keyScenarioType));
			param.setExecutionstate(xl.readUsingColName(fileName, sheetName, rowNumber, "execute"));
			param.setAdvanceSearch(xl.readUsingColName(fileName, sheetName, rowNumber, "advanceSearch"));
			param.setIsActive(xl.readUsingColName(fileName, sheetName, rowNumber, "removeExistingFilter"));
			param.setOrder(xl.readUsingColName(fileName, sheetName, rowNumber, "order"));
			param.setType(xl.readUsingColName(fileName,sheetName, rowNumber, "type"));			
			param.setChkCheckType(xl.readUsingColName(fileName,sheetName, rowNumber, "checkAll"));
			param.setWorkflowName(xl.readUsingColName(fileName,sheetName, rowNumber, keyworkflowName));
			param.setRuleName(xl.readUsingColName(fileName,sheetName, rowNumber, "ruleName"));
			param.setSearchName(xl.readUsingColName(fileName,sheetName, rowNumber, "searchName"));
			param.setUpdatedCheckName(xl.readUsingColName(fileName,sheetName, rowNumber, "updateName"));
			param.setFolderName(xl.readUsingColName(fileName,sheetName, rowNumber, keyfolderName));
			param.setWorkflowExecutionStatus(xl.readUsingColName(fileName,sheetName, rowNumber, "executeWorkflow"));
			param.setUpdateRule(xl.readUsingColName(fileName,sheetName, rowNumber, "updateRule"));
			param.setWorkflowfolderName(getConnectionOrParameterName(fileName, OverrideType.FOLDER));
			param.setRuleFolderName(getConnectionOrParameterName(fileName, OverrideType.FOLDER));
			param.setRuleState(xl.readUsingColName(fileName,sheetName, rowNumber, "ruleState"));
			param.setRuleStatus(xl.readUsingColName(fileName,sheetName, rowNumber, "ruleStatus"));
			param.setWorkflowStatus(xl.readUsingColName(fileName,sheetName, rowNumber, "workflowStatus"));
			param.setParameterName(getDefaultValueOnNull(fileName,sheetName, rowNumber, "parameterName", OverrideType.PARAMETER));
			param.setParamFolderName(getDefaultValueOnNull(fileName,sheetName, rowNumber, "paramFolder", OverrideType.FOLDER));
			param.setSourceConnection(getDefaultValueOnNull(fileName,sheetName, rowNumber, "sourceConnection", OverrideType.SOURCE));
			param.setTargetConnection(getDefaultValueOnNull(fileName,sheetName, rowNumber, "targetConnection", OverrideType.TARGET));
			param.setRuleType(xl.readUsingColName(fileName,sheetName, rowNumber, "ruleType"));
			param.setRuleEngineType("Standard");
			param.setSourceQuery(xl.readUsingColName(fileName,sheetName, rowNumber, "sourceQuery"));
			param.setTargetQuery(xl.readUsingColName(fileName,sheetName, rowNumber, "targetQuery"));

			return param;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  "error occurs while setWorkflowDetailsUsingExcelData "+e.toString());
		}
		return param;

	}

	public String getDefaultValueOnNull(String fileName, String sheetName, int rowNumber, String columnName, OverrideType type) {
		XLUtils xl = new XLUtils();
		String xlvalue="";
		try {
			xlvalue = xl.readUsingColName(fileName,sheetName, rowNumber, columnName);

			if(xlvalue.isEmpty()) {

				xlvalue = getConnectionOrParameterName(fileName, type);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  "error occurs while getDefaultValueOnNull "+e.toString());
		}

		return xlvalue; 
	}


	public String clickOnEditButtonOFConnectionAndParameters(OverrideType type, String editType) {
		String mainWindow = null;

		try {
			By editBtnLocator = null;
			String editBtnTitle = null;

			boolean isFind = editType.equalsIgnoreCase(OverrideType.FIND.toString());

			switch (type) {
			case PARAMETER:
				editBtnLocator = isFind ? parameterOverrideFindConnEdit : parameterOverrideReplaceConnEdit;
				editBtnTitle = isFind ? "Find Parameter edit button" : "Replace Parameter edit button";
				break;

			case SOURCE:
				editBtnLocator = isFind ? sourceConnOverrideFindConnEdit : sourceConnOverrideReplaceConnEdit;
				editBtnTitle = isFind ? "Find Source Connection edit button" : "Replace Source Connection edit button";
				break;

			case TARGET:
				editBtnLocator = isFind ? targetConnOverrideFindConnEdit : targetConnOverrideReplaceConnEdit;
				editBtnTitle = isFind ? "Find Target Connection edit button" : "Replace Target Connection edit button";
				break;

			default:
				BaseSuite.reportErrorLog("Invalid OverrideType : " + type);
				return null;
			}

			clickOnButton(driver, editBtnLocator, editBtnTitle, true);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			mainWindow = getWindowHandle(driver);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnEditButtonOFConnectionAndParameters ");
		}

		return mainWindow;
	}

	public boolean validateUpdatedNameOfConnectionOrParameter(OverrideType type,String editType, String updatedName) {
		boolean isUpdated=true;
		try {
			boolean isFind = editType.equalsIgnoreCase(OverrideType.FIND.toString());
			By updateFieldLocator = null;
			switch (type) {
			case PARAMETER:
				updateFieldLocator = isFind ? parameterOverrideFindParamName : parameterOverrideReplaceParamName;

				break;

			case SOURCE:
				updateFieldLocator = isFind ? sourceConnOverrideFindConnName : sourceConnOverrideReplaceConnName;

				break;

			case TARGET:
				updateFieldLocator = isFind ? targetConnOverrideFindConnName : targetConnOverrideReplaceConnName;

				break;

			default:
				BaseSuite.reportErrorLog("Invalid OverrideType: " + type);

			}

			isDisplayedInLoop(driver, 60, updateFieldLocator);

			String newName=getValue(driver, updateFieldLocator);

			isUpdated=stringOutput(newName, updatedName, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateUpdatedNameOfConnectionOrParameter ");
			isUpdated=false;
		}
		return isUpdated;
	}

	public boolean clickOnOverrideIconOfRule(OverrideType type, String ruleName, String input) {
		Actions action = new Actions(driver);
		boolean isVisible = true;
		String methodName = "clickOnOverrideIconOfRule";

		try {
			String logInfo = logString +"Edit button functionality of : " + ruleName;
			By overrideTitle = null;
			By linkLocator = null;
			By buttonLocator = null;

			if (type == OverrideType.PARAMETER) {
				logInfo += " with parameter: " + input + logString;
				linkLocator = returnElement(worklfowAddedRuleParameterLink, dynamicName, ruleName);
				buttonLocator = returnElement(workflowDetailsParameterOverrideButton, dynamicName, ruleName);
				overrideTitle = parameterOverrideTitle;

			} else if (type == OverrideType.SOURCE) {
				logInfo += " with source connection: " + input + logString;
				linkLocator = returnElement(worklfowAddedRuleSourceConnLink, dynamicName, ruleName);
				buttonLocator = returnElement(workflowDetailsSourceConnOverrideButton, dynamicName, ruleName);
				overrideTitle = sourceConnOverrideTitle;

			} else if (type == OverrideType.TARGET) {
				logInfo += " with target connection: " + input + logString;
				linkLocator = returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleName);
				buttonLocator = returnElement(workflowDetailsTargetConnOverrideButton, dynamicName, ruleName);
				overrideTitle = sourceConnOverrideTitle;

			} else {
				BaseSuite.reportErrorLog("Invalid input type: " + type);
				return false;
			}

			BaseSuite.reportLog(logInfo);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 5, linkLocator);
			if (isDisplayed(driver, linkLocator)) {
				WebElement linkElement = driver.findElement(linkLocator);
				action.moveToElement(linkElement).click().perform();
			} else {
				BaseSuite.reportFailLog("Link not visible for rule: " + ruleName, methodName);
				return false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, buttonLocator);
			if (isDisplayed(driver, buttonLocator)) {
				WebElement overrideButton = driver.findElement(buttonLocator);
				action.moveToElement(overrideButton).click().perform();
			} else {
				BaseSuite.reportFailLog(overrideTitle+" Override button not visible for rule: " + ruleName, methodName);
				return false;
			}

			isDisplayedInLoop(driver, 3, overrideTitle);
			if (!isDisplayed(driver, overrideTitle)) {
				BaseSuite.reportFailLog(overrideTitle+ "Override dialog not opened for: " + type + " - " + ruleName, methodName);
				isVisible = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnOverrideIconOfRule ");
			isVisible = false;
		}

		return isVisible;
	}


	public boolean clickOnBulkOverrideIcon(OverrideType type, String editType, String input) {
		Actions action = new Actions(driver);
		boolean isVisible = true;
		String methodName = "clickOnBulkOverrideIcon";

		try {
			String logInfo = logString +"Edit button functionality of : " + editType+ " "+ type.toString()+" bulk override";
			By overrideTitle = null;
			By buttonLocator = null;

			if (type == OverrideType.PARAMETER) {
				logInfo += " with parameter: " + input + logString;

				buttonLocator = rulesDatasetsParameterConnOverrideButton;
				overrideTitle = parameterOverrideTitle;

			} else if (type == OverrideType.SOURCE) {
				logInfo += " with source connection: " + input + logString;

				buttonLocator = rulesDatasetsSourceConnOverrideButton;
				overrideTitle = sourceConnOverrideTitle;

			} else if (type == OverrideType.TARGET) {
				logInfo += " with target connection: " + input + logString;

				buttonLocator = rulesDatasetsTargetConnOverrideButton;
				overrideTitle = sourceConnOverrideTitle;

			} else {
				BaseSuite.reportErrorLog("Invalid input type: " + type);
				return false;
			}

			BaseSuite.reportLog(logInfo);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 3, buttonLocator);
			if (isDisplayed(driver, buttonLocator)) {
				WebElement overrideButton = driver.findElement(buttonLocator);
				action.moveToElement(overrideButton).click().perform();
			} else {
				BaseSuite.reportFailLog(overrideTitle+" Override button not visible : " + type.toString(), methodName);
				return false;
			}

			isDisplayedInLoop(driver, 3, overrideTitle);
			if (!isDisplayed(driver, overrideTitle)) {
				BaseSuite.reportFailLog(overrideTitle+ "Override dialog not opened for: " + editType + " - " + type.toString(), methodName);
				isVisible = false;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnBulkOverrideIcon ");
			isVisible = false;
		}

		return isVisible;
	}

	public void searchSelectConnectionOrParameterOnPopupWindow(OverrideType type, String editType, String searchName) {
		try {
			By dropdownLocator = null;
			String searchPlaceholder = null;
			By searchBar = sourceConnOverrideSearchBar;
			By elementToClick = null;
			String elementTitle = "";
			By clearField = null;

			boolean isFind = editType.equalsIgnoreCase(OverrideType.FIND.toString());

			switch (type) {
			case TARGET:
				dropdownLocator = isFind ? targetConnOverrideFindConnDD : targetConnOverrideReplaceConnDD;
				searchPlaceholder = "Search connection";
				elementToClick = returnElement(sourceConnectionNameLink, dynamicName, searchName);
				elementTitle = searchName + " "+connectionNameLabel;
				clearField = targetConnOverrideReplaceConnClearIcon;
				break;

			case SOURCE:
				dropdownLocator = isFind ? sourceConnOverrideFindConnDD : sourceConnOverrideReplaceConnDD;
				searchPlaceholder = "Search connection";
				elementToClick = returnElement(sourceConnectionNameLink, dynamicName, searchName);
				elementTitle = searchName + " "+connectionNameLabel;
				clearField = sourceConnOverrideReplaceConnClearIcon;
				break;

			case PARAMETER:
				dropdownLocator = isFind ? parameterOverrideFindConnDD : parameterOverrideReplaceConnDD;
				searchPlaceholder = placeholderSearchParameter;

				if (workflowParamFolder.isEmpty()) {
					elementToClick = returnElement(parameterNameForOverride, dynamicName, searchName);
				} else {
					elementToClick = returnTwoElements(newParameterOverrideWithFolderPath, dynamicName, searchName, dynamicFolderName, workflowParamFolder);
				}

				elementTitle = parameterNameContent;
				clearField = parameterOverrideReplaceConnClearIcon;
				break;

			default:
				BaseSuite.reportErrorLog("Invalid OverrideType: " + type);
				return;
			}

			BaseSuite.reportLog("Clicking on "+editType+" " + type.name().toLowerCase() + " dropdown ");
			displayAndClick(driver, dropdownLocator);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 2, clearField);
			if(isDisplayed(driver, clearField)) {
				displayAndClick(driver, clearField);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			}

			BaseSuite.reportLog("Clicked on "+editType+" " + type.name().toLowerCase() + " dropdown");
			sendkeysToField(driver, searchBar, searchPlaceholder, searchName);

			clickOnFieldOrButton(driver, elementToClick, elementTitle);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " searchSelectConnectionOrParameterOnPopupWindow ");
		}
	}

	public boolean updateConnectionOrParameter(OverrideType type, String editType, String searchName,String updateName, String icedqUser) {
		String mainWindow = null;

		boolean isUpdated=true;
		try {
			mainWindow=clickOnEditButtonOFConnectionAndParameters(type, editType);

			BaseSuite.reportLog("Navigated to new tab of : "+type);

			if(type==OverrideType.PARAMETER) {

				isUpdated=new ParametersServicePage(driver).updateParameterNameFunctionalityForWorkflow(searchName, updateName, icedqUser);

			}else if(type==OverrideType.SOURCE || type==OverrideType.TARGET){

				isUpdated=updateConnectionNameAndSave(searchName, updateName, icedqUser);
			}

			closeCurrentTabAndSwitchToMain(driver, mainWindow);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " updateConnectionOrParameter ");
		}
		return isUpdated;
	}

	public String getConnectionOrParameterName(String filePath, OverrideType type) {
		String searchName = "";
		String methodName = "getConnectionOrParameterName";

		try {
			XLUtils xl = new XLUtils();

			String readColumnName = getRuleFolderColumnName(workflowFolderNameForSanity);
			String cellKey = "";

			switch (type) {
			case TARGET:
				cellKey = keyRuleTargetConnection;
				break;

			case SOURCE:
				cellKey = keyRuleSourceConnection;
				break;

			case PARAMETER:
				cellKey = keyRuleParameter;
				break;
			case FOLDER:
				cellKey = keyRuleFolder;
				break;

			default:
				BaseSuite.reportErrorLog("[" + methodName + "] Invalid OverrideType: " + type);
				return "";
			}

			searchName = xl.readUsingColNameAndCellContains(filePath, wkflsheetName, keyColumn, cellKey, readColumnName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " in " + methodName);
		}

		return searchName;
	}

	public String getOverrideConnectionOrParameterName(String filePath, OverrideType type) {
		String searchName = "";
		String methodName = "getOverrideConnectionOrParameterName";

		try {
			XLUtils xl = new XLUtils();

			String readColumnName = getRuleFolderColumnName(workflowFolderNameForSanity);
			String cellKey = "";

			switch (type) {
			case TARGET:
				cellKey = keyRuleOverridetarget;
				break;

			case SOURCE:
				cellKey = keyRuleOverrideSource;
				break;

			case PARAMETER:
				cellKey = keyRuleOverrideParameter;
				break;

			case FOLDER:
				cellKey = keyRuleFolder;
				break;
			default:
				BaseSuite.reportErrorLog("[" + methodName + "] Invalid OverrideType: " + type);
				return "";
			}

			searchName = xl.readUsingColNameAndCellContains(filePath, wkflsheetName, keyColumn, cellKey, readColumnName);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " in " + methodName);
		}

		return searchName;
	}

	public void overrideConnectionOrParameter(OverrideType type, boolean isOverride, String searchValue) {

		try {
			if(!isOverride) { return ;}
			switch (type) {
			case TARGET:
				BaseSuite.reportLog(" Clicking on replace connection dropdown");

				displayAndClick(driver, targetConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.reportLog("Clicked on replace connection dropdown ");

				sendkeysToField(driver, sourceConnOverrideSearchBar, " Search connection", searchValue);

				clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, searchValue), searchValue+"connection name ");

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnButton(driver, targetConnOverrideReplaceConnbtn, replaceTargetConnectioField, true);

				captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, workflowSingleTargetConnectionOverrideToastMsg, targetConnectionOverrideField);
				break;

			case SOURCE:
				BaseSuite.reportLog(" Clicking on replace connection dropdown ");

				displayAndClick(driver, sourceConnOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.reportLog(" Clicked on replace connection dropdown");

				sendkeysToField(driver, sourceConnOverrideSearchBar, "Search connection ", searchValue);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnFieldOrButton(driver, returnElement(sourceConnectionNameLink, dynamicName, searchValue), searchValue+" "+connectionNameLabel);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnEditButtonOfConnection(sourceConnOverrideReplaceConnEdit, replaceConnectionEditField, searchValue);

				clickOnButton(driver, sourceConnOverrideReplaceConnbtn, replaceSourceConnectionField, true);

				captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, workflowSingleSourceConnectionOverrideToastMsg, sourceConnectionOverrideField);
				break;

			case PARAMETER:
				BaseSuite.reportLog("Clicking on replace parameter dropdown ");

				displayAndClick(driver, parameterOverrideReplaceConnDD);isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				BaseSuite.reportLog(" Clicked on replace parameter dropdown ");

				sendkeysToField(driver, sourceConnOverrideSearchBar, placeholderSearchParameter, searchValue);

				if(workflowParamFolder.isEmpty()) {

					clickOnFieldOrButton(driver, returnElement(parameterNameForOverride, dynamicName, searchValue), parameterNameContent);
				}else {
					clickOnFieldOrButton(driver, returnTwoElements(newParameterOverrideWithFolderPath, dynamicName, searchValue, dynamicFolderName, workflowParamFolder), parameterNameContent);
				}
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				clickOnButton(driver, parameterOverrideReplaceConnbtn, replaceParameterField, true);

				captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, workflowSingleParameterOverrideToastMsg, parameterOverrideField);
				break;

			default:
				BaseSuite.reportErrorLog("[overrideConnectionOrParameter] Invalid OverrideType: " + type);

			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " overrideConnectionOrParameter ");
		}
	}


	public boolean editBulkOverrideConnectionOrParameterFromWorkflowDetailPage(
			OverrideType type, OverrideType scenario, String ruleName, String editType, String icedqUser) {

		String initialSearchName=null;
		String initialUpdateName=null;

		try {

			boolean isSingleOverride = scenario == OverrideType.SINGLE;
			boolean isReplaceType = editType.equalsIgnoreCase(OverrideType.REPLACE.toString());
			boolean hasPermission = hasUpdatePermission(type, icedqUser);

			initialSearchName = getInitialSearchName(type, isReplaceType);

			if (initialSearchName.isEmpty()) return true;

			initialUpdateName = initialSearchName + "_NewUpdate";

			String finalSearchName = hasPermission ? computeFinalSearchName(isSingleOverride, initialSearchName) : initialSearchName;
			String finalUpdateName = hasPermission ? computeFinalUpdateName(isSingleOverride, initialSearchName, initialUpdateName) : initialUpdateName;

			if (!openOverridePopup(type, ruleName, finalSearchName, isSingleOverride, editType)) return false;

			validateOverridePopupWindow(type, getOverrideTitle(type));

			performSearchSelection(type, editType, finalSearchName, isReplaceType, isSingleOverride);

			boolean isUpdated = updateConnectionOrParameter(type, editType, finalSearchName, finalUpdateName, icedqUser);

			postUpdateActions(type, editType, isReplaceType, isSingleOverride, hasPermission, finalSearchName, finalUpdateName);

			clickOnWorkflowSaveOption(isReplaceType && hasPermission && isSingleOverride, publishContent, "",icedqUser);

			return isUpdated;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " editBulkOverrideConnectionOrParameterFromWorkflowDetailPage ");
			return false;
		}
	}


	private boolean hasUpdatePermission(OverrideType type, String user) {
		boolean isParam = type == OverrideType.PARAMETER;
		boolean isConn = type == OverrideType.SOURCE || type == OverrideType.TARGET;
		boolean isOwner = user.toLowerCase().contains(ownerContent);
		boolean isContributor = user.toLowerCase().contains(contributorContent);

		return (isParam && (isOwner || isContributor)) || (isConn && isOwner);
	}

	private String getInitialSearchName(OverrideType type, boolean isReplaceType) {
		return isReplaceType
				? getOverrideConnectionOrParameterName(WORKFLOWEXCELFILEPATH, type)
						: getConnectionOrParameterName(WORKFLOWEXCELFILEPATH, type);
	}


	private String computeFinalSearchName(boolean isSingleOverride, String baseName) {
		return isSingleOverride ? baseName : baseName + "_NewUpdate";
	}

	private String computeFinalUpdateName(boolean isSingleOverride, String baseName, String updateName) {
		return isSingleOverride ? updateName : baseName;
	}

	private boolean openOverridePopup(OverrideType type, String ruleName, String finalSearchName, boolean isSingleOverride, String editType) {
		boolean popupVisible = isSingleOverride 
				? clickOnOverrideIconOfRule(type, ruleName, finalSearchName) 
						: clickOnBulkOverrideIcon(type, editType, finalSearchName);

		if (!popupVisible) {
			BaseSuite.reportFailLog(getOverrideFieldName(type) + overrideFunctionalityErrorLog, "editParameterFromWorkflowDetailPage");
			return false;
		}
		return true;
	}

	private void performSearchSelection(OverrideType type, String editType, String finalSearchName, boolean isReplace, boolean isSingleOverride) {
		if (isReplace && isSingleOverride) {
			searchSelectConnectionOrParameterOnPopupWindow(type, OverrideType.REPLACE.toString(), finalSearchName);
		} else if (!isSingleOverride) {
			searchSelectConnectionOrParameterOnPopupWindow(type, editType, finalSearchName);
		}
	}

	private void postUpdateActions(OverrideType type,String editType,  boolean isReplaceType, boolean isSingleOverride,
			boolean hasPermission, String finalSearchName, String finalUpdateName) {
		BaseSuite.reportLog("Verifying updated name of " + type);

		clickOnButton(driver, overrideRefreshIcon, refreshContent, true);
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if (!isReplaceType && isSingleOverride) {
			String expected = hasPermission ? finalUpdateName : finalSearchName;
			validateUpdatedNameOfConnectionOrParameter(type, editType, expected);
		}

		boolean doOverride = isReplaceType && hasPermission && isSingleOverride;
		overrideConnectionOrParameter(type, doOverride, finalUpdateName);

		if(doOverride) {  return ; }

		clickOnButton(driver, overrideDiscardIcon, discardContent, true);
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	}



	public boolean validateOverridePopupWindow(OverrideType type, String expectedTitle) {
		String actualTitle = "";
		boolean result = false;

		try {
			if (type == OverrideType.PARAMETER) {
				isDisplayedInLoop(driver, 3, parameterOverrideTitle);
				actualTitle = getText(driver, parameterOverrideTitle);
			} else if (type == OverrideType.SOURCE) {
				isDisplayedInLoop(driver, 3, sourceConnOverrideTitle);
				actualTitle = getText(driver, sourceConnOverrideTitle);
			} else if (type == OverrideType.TARGET) {
				isDisplayedInLoop(driver, 5, sourceConnOverrideTitle);
				actualTitle = getText(driver, sourceConnOverrideTitle);
			} else {
				BaseSuite.reportFailLog("Invalid override type provided.", "validateOverridePopupWindow");
				return false;
			}

			if (actualTitle.trim().equalsIgnoreCase(expectedTitle.trim())) {
				BaseSuite.validationReportLog("Override popup title matched: " + expectedTitle);
				result = true;
			} else {
				BaseSuite.reportFailLog("Expected title: " + expectedTitle + " but found: " + actualTitle, "validateOverridePopupWindow");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "Error in validating override popup title for " + type + ": " + e.toString());
		}

		return result;
	}


	public boolean performSingleOverride(OverrideType type, String ruleName, String name, String expectedToast) {
		boolean isSuccessful = true;
		try {
			name = checkNullValue(name);
			if (name.isEmpty()) return true;

			// Step 1: Open override popup
			boolean popupVisible = clickOnOverrideIconOfRule(type, ruleName, name);
			if (!popupVisible) {
				BaseSuite.reportFailLog(getOverrideFieldName(type) + overrideFunctionalityErrorLog, "performSingleOverride");
				return false;
			}

			validateOverridePopupWindow(type, getOverrideTitle(type));

			BaseSuite.reportLog("Clicking on replace " + type.name().toLowerCase() + " dropdown");
			By dropdown = getReplaceDropdownLocator(type);
			displayAndClick(driver, dropdown);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			sendkeysToField(driver, sourceConnOverrideSearchBar, "Search", name);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			clickOnFieldOrButton(driver, getConnectionOrParamLocator(type, name), name + " name");

			By replaceBtn = getReplaceButtonLocator(type);
			clickOnButton(driver, replaceBtn, getReplaceFieldName(type), true);

			isSuccessful = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, getOverrideFieldName(type));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " performSingleOverride ");
			isSuccessful = false;
		}
		return isSuccessful;
	}

	private By getReplaceDropdownLocator(OverrideType type) {
		switch (type) {
		case SOURCE:
			return sourceConnOverrideReplaceConnDD;
		case TARGET:
			return targetConnOverrideReplaceConnDD;
		case PARAMETER:
			return parameterOverrideReplaceConnDD;
		default:
			throw new IllegalArgumentException("Unknown override type : " + type);
		}
	}

	private By getReplaceButtonLocator(OverrideType type) {
		switch (type) {
		case SOURCE:
			return sourceConnOverrideReplaceConnbtn;
		case TARGET:
			return targetConnOverrideReplaceConnbtn;
		case PARAMETER:
			return parameterOverrideReplaceConnbtn;
		default:
			throw new IllegalArgumentException("Unknown override type : " + type);
		}
	}


	private By getConnectionOrParamLocator(OverrideType type, String name) {
		if(type==OverrideType.PARAMETER) {

			if (workflowParamFolder.isEmpty()) {
				return returnElement(parameterNameForOverride, dynamicName, name);
			} else {
				return returnTwoElements(newParameterOverrideWithFolderPath, dynamicName, name, dynamicFolderName, workflowParamFolder);
			}


		}else {
			return returnElement(sourceConnectionNameLink, dynamicName, name);
		}
	}


	private String getOverrideFieldName(OverrideType type) {
		switch (type) {
		case SOURCE:
			return sourceConnectionOverrideField;
		case TARGET:
			return targetConnectionOverrideField;
		case PARAMETER:
			return parameterOverrideField;
		default:
			throw new IllegalArgumentException("Unknown override type: " + type);
		}
	}

	private String getReplaceFieldName(OverrideType type) {
		switch (type) {
		case SOURCE:
			return replaceSourceConnectionField;
		case TARGET:
			return replaceTargetConnectioField;
		case PARAMETER:
			return replaceParameterField;
		default:
			throw new IllegalArgumentException("Unknown override type: " + type);
		}
	}

	private String getOverrideTitle(OverrideType type) {
		switch (type) {
		case SOURCE:
			return "Source Connection";
		case TARGET:
			return "Target Connection";
		case PARAMETER:
			return "Parameter";
		default:
			throw new IllegalArgumentException("Unknown override type:  " + type);
		}
	}

	public boolean editConnectionOrParameterFunctionalityInWorkflow(OverrideType type, OverrideType scenario,String ruleName, String searchName, String updateName,String editType, String icedqUser) {
		boolean isUpdated=true;

		try {
			log.info(searchName+updateName);
			clickOnWorkflowSidebarPanelOpenOrClose(false);

			BaseSuite.reportLog(createHtmlTable1(getRulesConnectionAndParameterTable(), "Before Rules Connection and Parameter configuration"));

			isUpdated= editBulkOverrideConnectionOrParameterFromWorkflowDetailPage(type, scenario, ruleName, editType, icedqUser);

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			BaseSuite.reportLog(createHtmlTable1(getRulesConnectionAndParameterTable(), "After Rules Connection and Parameter configuration"));

		}catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " editConnectionOrParameterFunctionalityInWorkflow ");
			isUpdated = false;
		}
		return isUpdated;
	}

	public boolean executeWorkflow(boolean flag, String workflowName, boolean downloadZip, boolean exceptionReport, String workflowExecutionStatus, String icedqUser) {

		try {
			if (!flag || icedqUser.contains(readerFlag)) {
				return true;
			}

			String workflowId = getWorkflowIdOnWorkflowDetailsPage();
			String status = clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount, "");
			String instanceId = validateWorkflowRecentRunInfo();

			BaseSuite.reportLog(workflowExecutionLog);

			if(!workflowExecutionStatus.isEmpty()) {

				BaseSuite.reportLog("verifying workflow execution status...");
				stringContainsOutput(status, workflowExecutionStatus, true);

			}

			flag = searchRecentRunOnRecentRunsField(flag, instanceId);

			if (flag && !status.toLowerCase().contains(runningStatus)) {
				flag = clickOnExecutionDetails();

				flag = downloadExceptionReportInWorkflow(
						flag,
						workflowId,
						instanceId,
						allContent,
						zipContent,
						downloadZip
						);

				flag = validateWorkflowExecutionDetailsInRecentRuns(
						flag,
						instanceId,
						workflowName,
						exceptionReport
						);
			} else {
				BaseSuite.reportFailLog(workflowLongRunMessage, "executeWorkflow1");

				flag = false;
				clickOnExecutionDetails();
				clickOnExpandArrowToWorkflowInstanceId(flag, instanceId);

				List<String> ruleInstanceIds = getRuleExecutionInstaceIdListFromWorkflow(true, instanceId);

				getWorkflowInstanceTable();
				getInstanceTable(ruleInstanceIds);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " executeWorkflow ");
			return false;
		}
		return flag;
	}

	public boolean executeWorkflowAndValidate(boolean flag, String workflowName, boolean downloadZip, boolean exceptionReport, String workflowExecutionStatus, String ruleState, String icedqUser) {

		try {
			if (!flag || icedqUser.contains(readerFlag)) {
				return verifyVisibilityOfButtons(driver, workflowDetailsRunButton, runContent, false);

			}

			String workflowId = getWorkflowIdOnWorkflowDetailsPage();
			String status = clickOnRunButtonOnWorkflowAndGetStatus(workflowRefreshCount, "");
			String instanceId = validateWorkflowRecentRunInfo();

			BaseSuite.reportLog(workflowExecutionLog);

			if(!workflowExecutionStatus.isEmpty()) {

				BaseSuite.reportLog("verifying workflow execution status...");
				stringContainsOutput(status, workflowExecutionStatus, true);

			}

			flag = searchRecentRunOnRecentRunsField(flag, instanceId);

			if (flag && !status.toLowerCase().contains(runningStatus)) {
				flag = clickOnExecutionDetails();

				flag = downloadExceptionReportInWorkflow(
						flag,
						workflowId,
						instanceId,
						allContent,
						zipContent,
						downloadZip
						);

				flag = validateWorkflowExecutionDetailsInRecentRunsAndValidate(
						flag,
						instanceId,
						workflowName,
						exceptionReport,
						ruleState);
			} else {
				BaseSuite.reportFailLog(workflowLongRunMessage, "executeWorkflowAndValidate");

				flag = false;
				clickOnExecutionDetails();
				clickOnExpandArrowToWorkflowInstanceId(flag, instanceId);

				List<String> ruleInstanceIds = getRuleExecutionInstaceIdListFromWorkflow(true, instanceId);

				getWorkflowInstanceTable();
				getInstanceTable(ruleInstanceIds);

			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " executeWorkflowAndValidate ");
			return false;
		}
		return flag;
	}

	public boolean validateWorkflowExecutionDetailsInRecentRunsAndValidate(boolean flag, String instaceId, String workflowName,boolean exceptionReport, String ruleState) {
		String logs="Validating Rule execution details of Instance Id ";
		String method="validateWorkflowExecutionDetailsInRecentRunsAndValidate ";
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

				validateRecentRunsForSinglePageAndValidate(Integer.toString(i),flag, instaceId, logs, workflowName, exReportFlag, ruleState);

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

	public boolean validateRecentRunsForSinglePageAndValidate(String pageNum,Boolean flag,String instaceId,String logs,String workflowName,boolean exceptionReport, String ruleState) {
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

				if(!ruleState.isEmpty()) {

					stringContainsOutput(status, ruleState, true);
				}

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
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateRecentRunsForSinglePageAndValidate ");
			flag=false;
		}		
		return flag;
	}

	public boolean updateConnectionNameAndSave(String searchName,String updateName, String icedqUser) {

		boolean flag =true;

		try {

			isDisplayedInLoop(driver, 60, connectionNameField);
			viewAndValidateField(driver, connectionNameField, "Connection Name", searchName, true);

			validatAndeEnterValueToTextField(driver, connectionNameFieldTitle, connectionNameField, connectionNameFieldValidation, "Connection Name", "Enter connection name", updateName, "Connection name is required.");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			if((icedqUser.toLowerCase().contains(ownerContent))){

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

	public boolean clickOnSaveButtonAndValidateToast(boolean flag, String expectedToastMessage) {
		boolean tag =true;

		clickOnButton(driver, connectionSaveButton, saveContent, true);

		if(isDisplayed(driver, toastMsg)) {

			flag=captureToastMsg(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage, "Connection Created/updated");
			tag=false;
		}

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		if(tag && !expectedToastMessage.isEmpty()) {
			flag=captureToastMsgWithContains(driver, toastMsg, toastMsgClosedBtn, expectedToastMessage,"Connection Created/updated");
		}
		return flag;
	}

	//Advance search 

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

		try {

			if(!clearAll) { return ;}

			BaseSuite.reportLog("Removing applied filters...");

			isDisplayedInLoop(driver, 2, workflowAppliedFilterCross);

			if(!isDisplayed(driver, workflowAppliedFilterCross)) {

				return ;
			}
			BaseSuite.validationReportLog("Applied filters cross icon is visible");

			BaseSuite.reportLog("Clicking on Applied filters cross icon");

			new Actions(driver).moveToElement(driver.findElement(workflowAppliedFilterCross)).click().build().perform();

			BaseSuite.validationReportLog("Clicked on Applied filters cross icon");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			// Retry once if still displayed
			if (isDisplayed(driver, workflowAppliedFilterCross)) {
				waitForExecution(2000);
			}

			// Final check
			if (!isDisplayed(driver, workflowAppliedFilterCross)) {
				BaseSuite.validationReportLog("Successfully removed applied filters");
			} else {
				BaseSuite.reportFailLog("Applied filters cross icon still visible", "removeAppliedFilterofParameter");
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

			clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);

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

				searchFunctionalityMethod(driver, flag, workflowFolderSearchField, workflowFolderSearchButton, labelFolderSearch, workflowFolderSearchPlaceholder, searchFolder);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				selectcheckbox(driver, returnElement(folderCheckboxOnListingPage, dynamicName, rf), rf);

				count++;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

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

	public boolean advanceSearchFunctionalityOnWorkflowsListingPage(boolean clearAll, String advanceSearchRef, String filePath) {

		boolean flag = true;
		try {

			removeAppliedFilterofParameter(clearAll);

			String [] ref = !advanceSearchRef.isEmpty() ? advanceSearchRef.split(",") : new String [] {""};

			int count = 1;

			for(String rf : ref) {

				BaseSuite.reportLog(hyphenContent + " Applying advance search filter - Iteration : " + count + hyphenContent);

				DataTestingParameters param = setAdvanceSearchParamUsingExcel(filePath, rf);

				applyFilterUsingFolderSearch(param.getFolder());

				validateNSelectTypeInAdvanceSearch(param.getType(), true);

				validateNSelectWorkflowStateInAdvanceSearchNew(param.getWorkflowState(), true);

				validateNSelectUpdatedByUserInAdvanceSearch(param.getFullName(), true);

				validateNSelectLastUpdatedInAdvanceSearch(param.getLastUpdatedFrom(), param.getLastUpdatedTo());

				count++; // increment counter
			}

			getWorkflowsListingPageTable(false);

			BaseSuite.reportLog(hyphenContent + " Applied advance search filter " + hyphenContent);



		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " advanceSearchFunctionalityOnWorkflowsListingPage :: " + e.toString());
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
						selectUncheckbox(locator, rf);
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
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectUpdatedByUserInAdvanceSearch ");
			flag=false;
		}
		return flag;
	}

	//validate and select last updated dates in advanced search
	public boolean validateNSelectLastUpdatedInAdvanceSearch(String startDate, String endDate) {

		boolean flag=true;
		try {

			expandFilterSidebar(advancedSearchExpand);

			javascript(driver, scrollToElementArg, advancedSearchLastUpdatedLabel);

			verifyIndividualLabel(driver, advancedSearchLastUpdatedLabel, lastUpdatedContent);

			expandFilterSidebar(advancedSearchLastUpdatedExpand);

			BaseSuite.reportLog(hyphenContent+"Selecting date from : "+startDate+" to : "+endDate+hyphenContent);

			compareTwoDates(flag, calanderDateFormat, startDate, endDate);

			javascript(driver, scrollToElementArg, advancedSearchLastUpdatedFrom);

			if(!startDate.isEmpty() && isDisplayed(driver, advancedSearchLastUpdatedFrom) ) {

				BaseSuite.validationReportLog("From field is visible");

				verifyPlaceHolderValue(driver,advancedSearchLastUpdatedFrom, "From", "From");

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
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectLastUpdatedInAdvanceSearch ");
			flag=false;
		}
		return flag;
	}

	public boolean validateNSelectTypeInAdvanceSearch(String typeValue, boolean checkStatus) {

		try {
			expandFilterSidebar(advancedSearchExpand);

			verifyIndividualLabel(driver, advancedSearchTypeLabel, "Type");

			expandFilterSidebar(advancedSearchTypeExpand);

			printlist(advancedSearchTypeList, "type", attributeTextContent);

			String [] ref = !typeValue.isEmpty() ? typeValue.split(",") : new String [] {""};

			int count = 1;

			for(String rf : ref) {

				BaseSuite.reportLog(hyphenContent+" "+count+" Selecting workflow type : "+rf+" "+hyphenContent);

				By locator = returnElement(advanceSearchTypeCheckbox, dynamicName, rf);

				isDisplayedInLoop(driver, 0, locator);

				if (!isDisplayed(driver, locator)) {
					BaseSuite.reportFailLog(rf + " type not found kindly check", "validateNSelectTypeInAdvanceSearch");
					return false;
				}

				if (checkStatus) {
					selectcheckbox(driver, locator, rf);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				} else {
					selectUncheckbox(locator, rf);
				}

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				count++; // increment counter
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle + " validateNSelectTypeInAdvanceSearch :: " + e.toString());
			return false;
		}

		return true;
	}

	public void validateUnexpectedToast(String method) {

		if(isDisplayed(driver, toastMsg)) {
			BaseSuite.reportFailLog("Unexpected toast message appeared", method);
		}
	}

	public void getTableForWorkflows(List<String> list) {

		try {

			if(list.isEmpty()) { return ; }

			String [][] table = new String[list.size()+1][4];

			String[] header = { "No.", "Type", "Name", "State", descriptionContent, folderContent, lastUpdatedContent};

			table[0] = header;

			for (int i = 0; i < list.size(); i++) {

				String num = Integer.toString(i + 1);

				String type = list.get(i).split(",")[1];

				String name = list.get(i).split(",")[2];

				String stat = list.get(i).split(",")[3];

				String desc = list.get(i).split(",")[4];

				String fold = list.get(i).split(",")[5];

				String lu = list.get(i).split(",")[6];

				String[] data = { num, type, name, stat, desc, fold, lu};

				table[i + 1] = data;

			}

			BaseSuite.reportLog(createHtmlTable1(table,"Workflow listing"));

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "error observed while getTableForWorkflows :: " + e.toString());
		}
	}

	public List<String> validateWorkflowDetails(List<String> list, int rowNum) {

		String num=Integer.toString(rowNum+1);

		String type = getAttribute(driver, returnElement(listingStaticAvatar, dynamicName, num), attributeTitle);

		String name = getAttribute(driver, returnElement(listingStaticName, dynamicName, num), attributeTextContent);

		String stat = getAttribute(driver, returnElement(listingStaticState, dynamicName, num), attributeTitle);

		String desc = getAttribute(driver, returnElement(listingStaticDesc, dynamicName, num), attributeTextContent);

		String fold = getAttribute(driver, returnElement(listingStaticFolder, dynamicName, num), attributeTitle);

		String lupd = getAttribute(driver, returnElement(listingStaticlastUpdate, dynamicName, num), attributeTextContent);

		lupd = lupd.contains(",") ? lupd.replace(",", " |") : lupd;

		list.add(num+","+type+","+name+","+stat+","+desc+","+fold+","+lupd);

		return list;

	}

	public boolean getWorkflowsListingPageTable(boolean checkAll) {
		boolean flag=true;

		try {
			List<String> list = new ArrayList<>();

			List<String> paginationInfo = getPaginationDetails(driver, workflowListingPageMsg, workflowListingPagearrow, workflowListingPageNoRecordDisplay, workflowsTitle);

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
					list = validateWorkflowDetails(list, i);
				}
				if(!checkAll) { break;}

				clickOnNextPageArrow(pn < totalPages, pn);
			}

			getTableForWorkflows(list);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,  errorLogTitle+" getWorkflowsListingPageTable ");
			flag=false;
		}

		return flag;
	}

	public boolean validateNSelectWorkflowStateInAdvanceSearchNew( String stateValue,boolean checkstatus) {
		boolean flag=true;
		try {

			expandFilterSidebar(advancedSearchExpand);

			verifyIndividualLabel(driver, advancedSearchStateLabel, stateContent);

			expandFilterSidebar(advancedSearchStateExpand);

			printlist(advancedSearchStateList, stateContent, attributeTextContent);

			String [] ref = !stateValue.isEmpty() ? stateValue.split(",") : new String [] {""};

			int count=1;

			for(String rf : ref) {

				BaseSuite.reportLog(hyphenContent+" "+count+" Selecting workflow state : "+rf+" "+hyphenContent);

				By locator = returnElement(advanceSearchStateCheckbox, dynamicName, rf);

				isDisplayedInLoop(driver, 2, locator);

				if(isDisplayed(driver, locator)) {
					if(checkstatus) {	

						selectcheckbox(driver, locator, rf);

						isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					}else {

						selectUncheckbox(locator, rf);
					}
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}else {
					BaseSuite.reportFailLog(rf+" State not found kindly check", "validateNSelectWorkflowStateInAdvanceSearchNew");
					flag=false;
				}

				count++;
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateNSelectWorkflowStateInAdvanceSearchNew ");
			flag=false;
		}
		return flag;
	}

	public boolean validateSortingFunctionalityOnWorkflow(String type , String order, boolean checkAllRecords) {
		boolean isSortedCorrectly = true;

		try {

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.reportLog("Verifying existing workflows displayed on listing page : 1 before sorting");

			List<String> paginationInfo = getPaginationDetails(driver, workflowListingPageMsg, workflowListingPagearrow, workflowListingPageNoRecordDisplay, workflowsTitle);

			int totalRecords = Integer.parseInt(paginationInfo.get(1));
			if (totalRecords == 0) {
				BaseSuite.reportLog("Unable to perform sorting as no records found.");
				return true;
			}

			getWorkflowsListingPageTable(Integer.toString(totalRecords), checkAllRecords, type);

			isSortedCorrectly = sortListByColumn(type, order, totalRecords, checkAllRecords);

			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " validateSortingFunctionalityOnWorkflow :: " + e.toString());
			return false;
		}

		return isSortedCorrectly;
	}

	public void clickOnNextPageArrow(boolean click, int pageNumber) {

		try {
			// Click next page if not on the last page
			if (!click) { return ; } 

			BaseSuite.reportLog("Clicking on next arrow to go on page : "+pageNumber);
			displayAndClick(driver, workflowListingNextPageArrow, nextPageArrowContent); 
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Clicked on page : "+pageNumber);
			validateUnexpectedToast("clickOnNextPageArrow");
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnNextPageArrow");
		}

	}


	public List<String> getWorkflowsListingPageTable(String totalCount, boolean checkAll, String type) {

		List<String> list = new ArrayList<>();
		List<String> columnTextValues = new ArrayList<>();
		try {
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
					list = validateWorkflowDetails(list, i);
				}
				if(!checkAll) { break;}

				clickOnNextPageArrow(pn < totalPages, pn);

			}

			getTableForWorkflows(list);

			clickOnButton(driver, refreshWorkflowButton, refreshContent, true);

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

			BaseSuite.reportLog("Verifying workflows after sorting by " + type + " in " + order + " order");

			// Perform sort click
			displayAndClick(driver, locator, type + " column");

			if (!isAscending) {
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				displayAndClick(driver, locator, type + " column");  // Click again for descending
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			List<String> columnData=getWorkflowsListingPageTable(Integer.toString(totalRecords), checkAllRecords, type);

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

	public boolean updateRuleDetailsFromWorkflow(DataTestingParameters param, String ruleName, String folderName, String updateName, String icedqUser) {
		boolean isUpdated=true;

		try {

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			BaseSuite.reportLog(createHtmlTable1(getRulesConnectionAndParameterTable(), "Before Rules Connection and Parameter configuration"));

			isUpdated=updateRuleDetails(param, ruleName, folderName, updateName, icedqUser);

			clickOnWorkflowSidebarPanelOpenOrClose(false);

			BaseSuite.reportLog(createHtmlTable1(getRulesConnectionAndParameterTable(), "After Rules Connection and Parameter configuration"));

		}catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " updateRuleDetailsFromWorkflow ");
			isUpdated = false;
		}
		return isUpdated;
	}


	public String clickOnRuleNameOnWorkflowDetailsPage(String ruleName, String folderName) {

		String mainWindow=null;

		try {
			String ruleNameAndFolderLog="Rule name : "+ruleName+ " folder : "+folderName;

			By locator = returnTwoElements(ruleNameHyperlinkUsingFolder, dynamicName, ruleName, dynamicFolderName, folderName);

			isDisplayedInLoop(driver, 2, locator);
			if(!isDisplayed(driver, locator)) { 

				BaseSuite.reportFailLog("Rule not visible kindly check :: "+ruleNameAndFolderLog+ " "+ locator, "clickOnRuleNameOnWorkflowDetailsPage");

				return "";
			}

			BaseSuite.reportLog("Clicking on rule name hyperlink : "+ruleNameAndFolderLog);

			javascript(driver, scrollToElementArg, locator);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, locator);

			BaseSuite.validationReportLog("Clicked on rule name hyperlink : "+ruleNameAndFolderLog);

			mainWindow = getWindowHandle(driver);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnRuleNameOnWorkflowDetailsPage ");
		}

		return mainWindow;
	}

	public boolean updateRuleNameAndSave(DataTestingParameters param, String searchName,String updateName, boolean hasPermission, String saveOption) {

		boolean flag =true;

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			isDisplayedInLoop(driver, 60, ruleNameField);
			viewAndValidateField(driver, ruleNameField, ruleNameContent, searchName, true);

			validatAndeEnterValueToTextField(driver, ruleNameFieldTitle, ruleNameField, ruleNameFieldValidation, ruleNameContent, placeholderRuleName, updateName, emplyRuleNameMsg);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			updateRuleDetailsOfParameterAndConnections(param);

			clickOnRuleSaveOption(hasPermission, saveOption, hasPermission ? "" : ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, hasPermission);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateRuleNameAndSave :: "+e.toString());
			flag=false;
		}

		return flag;

	}

	//click on workflow save button as per workflow state
	public boolean clickOnRuleSaveOption(boolean flag, String saveOption, String expectedToast, boolean hasPermission) {
		boolean tag=true;
		Actions action = new Actions(driver);
		try {

			BaseSuite.reportLog("Saving rule in mode : "+saveOption);

			if(saveOption.toLowerCase().trim().equalsIgnoreCase(publishContent)) {

				flag=clickOnButton(driver, workflowDetailsPublishButton, workflowPublish, true);
			}
			else if(saveOption.toLowerCase().trim().equalsIgnoreCase(validateContent)) {

				BaseSuite.reportLog("Clicking on save option drowdown");

				action.moveToElement(driver.findElement(workflowDetailsPublishDropDown)).click().build().perform();

				javascript(driver, jscriptToMouseHover, workflowDetailsPublishDropDown);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.reportLog("Clicking on validate option button");

				javascript(driver, jscriptToClick, workflowDetailsValidateButton);

			}else if(saveOption.toLowerCase().trim().equalsIgnoreCase(draftContent)) {

				BaseSuite.reportLog("Clicking on save option drowdown");

				action.moveToElement(driver.findElement(workflowDetailsPublishDropDown)).click().build().perform();

				javascript(driver, jscriptToMouseHover, workflowDetailsPublishDropDown);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);	

				BaseSuite.reportLog("Clicking on draft option button");

				javascript(driver, jscriptToClick, workflowDetailsDraftButton);

			}

			if(isDisplayed(driver, toastMsg)) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Rule Save");
				tag=false;
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if(!expectedToast.isEmpty() && tag) {

				flag=captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, expectedToast, "Rule Save ");
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			validateStatusofRule(saveOption, hasPermission);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" clickOnWorkflowSaveOption ");

			flag=false;
		}

		return flag;

	}

	public boolean validateStatusofRule(String exStatus, boolean validate) {
		boolean flag1 =true;
		try {

			if(!validate) { return true; }

			BaseSuite.reportLog("verifying state of rule ");

			String acStatus = getAttribute(driver, ruleStateOnRulePage, attributeTitle);

			if(exStatus.toLowerCase().contains(validateContent.toLowerCase())) {
				exStatus=exStatus+"d";
			}else if(exStatus.toLowerCase().contains(publishContent.toLowerCase())){
				exStatus=exStatus+"ed";
			}

			flag1=stringContainsOutput(acStatus, exStatus, true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" validateStatusofRule ");

			flag1=false;
		}

		return flag1;

	}

	public boolean updateRuleDetails(DataTestingParameters param, String ruleName, String folderName, String updateName, String icedqUser) {

		try {

			boolean hasPermission = icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent);

			String[] ruleNameList = ruleName.split(",");
			/**	String[] ruleFolderList = folderName.split(",");*/
			String[] updateNameList = updateName.split(",");

			if(ruleNameList.length == updateNameList.length) {

				for (int i = 0; i < ruleNameList.length; i++) {

					String rule = ruleNameList[i].trim();
					/**	String folder = ruleFolderList[i].trim();*/
					String update = updateNameList[i].trim();

					String mainWindow = clickOnRuleNameOnWorkflowDetailsPage(rule, folderName);

					driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

					updateRuleNameAndSave(param, rule, update, hasPermission, publishContent);

					closeCurrentTabAndSwitchToMain(driver, mainWindow);

					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				}
			}else {
				BaseSuite.reportLog("Mismatch in number of rules &updates : "+ruleNameList+" : "+updateNameList);
			}

			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			return true;

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " editBulkOverrideConnectionOrParameterFromWorkflowDetailPage ");
			return false;
		}
	}

	public static boolean isValidFolderName(String folderName) {
		return folderName.matches("^[a-zA-Z0-9_-]+$");
	}


	public boolean createNewFolderFunctionality(String folderName, String icedqUser) {
		boolean isFolderNew = true;

		try {

			boolean hasPermission = icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent);

			isDisplayedInLoop(driver, 2, workflowFolderSearchNewFolderButton);

			if(!isDisplayed(driver, workflowFolderSearchNewFolderButton)) {

				BaseSuite.reportFailLog("New folder button not visible", icedqUser);
				return false;
			}

			BaseSuite.reportLog("Clicking on New Folder button...");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			displayAndClick(driver, workflowFolderSearchNewFolderButton);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog("Clicked on New Folder button");

			if (!hasPermission || isDisplayed(driver, toastMsg)) {
				return captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Privilege");
			}

			BaseSuite.reportLog("Entering folder name: " + folderName);

			sendKeys(driver, enterNewFolderName, folderName);

			BaseSuite.validationReportLog("Entered folder name: " + folderName);

			waitForExecution(1000);

			BaseSuite.reportLog("performing enter button action ...");

			driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			if (isDisplayed(driver, toastMsg) || isValidFolderName(folderName)) {
				isFolderNew = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, folderCreatedToastMsg, folderContent + " " + createdContent);
			} else {
				isFolderNew = createFolderIfNotCreated(folderName);
			}

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);


		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " createNewFolderFunctionality :: " + e.toString());
			isFolderNew = false;
		}

		return isFolderNew;
	}


	public boolean updateExistingFolderFunctionality(String searchFolderName, String updatedFolderName, String icedqUser) {
		Actions action = new Actions(driver);
		boolean isUpdated = false;

		try {
			boolean hasPermission = icedqUser.contains(ownerContent) || icedqUser.contains(contributorContent);

			// Step 1: Search the folder
			boolean found = searchFunctionalityMethod(driver, true, workflowFolderFilterSearchBar,
					workflowFolderFilterSearchButton, searchFolderContent,
					workflowFolderSearchPlaceholder, searchFolderName);

			By existingFlocator = returnElement(workflowFolderName, dynamicName, searchFolderName);
			// Step 2: Wait for search result
			isDisplayedInLoop(driver, 3, existingFlocator);

			// Step 3: If folder is found
			if (found && !isDisplayed(driver, existingFlocator)) {

				BaseSuite.reportFailLog("Folder not found in search: " + searchFolderName,"");
				return false;
			}

			WebElement folderElement = driver.findElement(existingFlocator);
			action.moveToElement(folderElement).click().perform();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			// Step 4: Click on edit button
			By editButtonLocator = returnElement(workflowFolderNameEditButton, dynamicName, searchFolderName);
			isDisplayedInLoop(driver, 5, editButtonLocator);

			if (!isDisplayed(driver, editButtonLocator)) {
				BaseSuite.reportFailLog("Edit button not found for folder: " + searchFolderName, "");
				return false;
			}
			WebElement editBtn = driver.findElement(editButtonLocator);
			action.moveToElement(editBtn).click().perform();

			// Retry if input is not shown
			if (!isDisplayed(driver, enterNewFolderName)) {
				action.moveToElement(editBtn).click().perform();
			}

			// Step 5: Enter new folder name
			BaseSuite.reportLog("Entering updated folder name: " + updatedFolderName);
			sendKeys(driver, enterNewFolderName, updatedFolderName);
			BaseSuite.validationReportLog("Entered folder name: " + updatedFolderName);

			waitForExecution(1000);
			driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			// Step 6: Check for permission or toast
			if (!hasPermission || isDisplayed(driver, toastMsg)) {
				isUpdated = captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, WORKFLOWPRIVILEGEFORBIDDENMESSAGE, "Folder Privilege");
			} else {
				isUpdated = true;
				BaseSuite.validationReportLog("Folder updated successfully to: " + updatedFolderName);
			}

			// Step 7: Refresh folder list
			clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent + " " + refreshContent, true);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " updateExistingFolderFunctionality :: " + e.toString());
			isUpdated = false;
		}

		return isUpdated;
	}

	public boolean applyFilterUsingFolderSearchForWorkflow(String searchFoldername) {

		boolean flag=true;
		try {

			applyFilterUsingFolderSearch(searchFoldername);

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

			removeAppliedFilterofParameter(true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" filterFolderFunctionality ");

			flag=false;
		}
		return flag;
	}

	public boolean updateRuleDetails(DataTestingParameters param, String ruleFolderName, String saveMode, boolean hasPermission) {
		DataTestingPage dp = new DataTestingPage(driver);
		boolean flag=true;
		try {

			dp.clickOnRulesTab();

			flag=searchFunctionalityMethod(driver, true, dataTestingSearchBox, dataTestingSearchButton, searchRuleLabel, searchRuleLabel, param.getRuleName());

			if(!flag) { return flag;}

			flag=clickOnNameOnListingPage( param.getRuleName(), ruleFolderName, "Rule");

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=updateRuleNameAndSave(param, param.getRuleName(), param.getUpdateRule(), hasPermission, saveMode);

		}catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateRuleDetails ");

			flag=false;
		}

		return flag;
	}

	public boolean updateRuleAndValidateDefaultWorkflow(DataTestingParameters param, String folderName,  String icedqUser) {
		boolean flag=true;
		try {

			boolean hasPermission = icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent);

			flag=updateRuleDetails(param, folderName, param.getRuleState(), hasPermission);

			if(!flag) { return flag; }

			clickOnWorkflowsTabNew();

			validateNSelectTypeInAdvanceSearch("Default", true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= searchAndClickOnWorkflowNameOnWorkflowListingPage(param.getWorkflowName(),folderName);

			if(!flag) { return flag; }

			if(!hasPermission) { return flag;}

			flag=executeWorkflowAndValidate(Boolean.parseBoolean(param.getWorkflowExecutionStatus()), param.getWorkflowName(), false, false, param.getWorkflowStatus(), param.getRuleStatus(), icedqUser);

		}catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" updateRuleAndValidateDefaultWorkflow ");

			flag=false;
		}
		return flag;

	}

	// This Method is use to Select the Parameter
	public void parameterSection(String parameterName, String folderName) {
		try {
			waitForExecution(2000);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 5, parameterLabel);
			if (!isDisplayed(driver, parameterLabel)) {
				BaseSuite.reportFailLog("Parameter field is not visible. Kindly check!", "parameterSection");
				return;
			}

			String labelValue = getText(driver, parameterLabel);
			BaseSuite.validationReportLog(labelValue + " label is displayed clearly");

			// Check if parameterName is non-null and non-empty
			if (parameterName != null && !parameterName.trim().isEmpty()) {
				BaseSuite.reportLog("Click on Select Parameter option");
				isDisplayedInLoop(driver, 5, parameterclick);
				isDisplayed(driver, parameterclick);

				// Wait for spinner before interacting
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				// Scroll into view and click
				javascript(driver, scrollToElementArg, parameterclick);
				waitForExecution(1000);
				new Actions(driver).moveToElement(driver.findElement(parameterclick)).clickAndHold().perform();

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				isDisplayedInLoop(driver, 5, parameterSearch);
				if(isDisplayed(driver, parameterSearch)) {
					BaseSuite.validationReportLog("Parameter option clicked successfully");
				}else {
					displayAndClick(driver, parameterclick);
					isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				}

				BaseSuite.reportLog("Entering name in parameter : "+parameterName);
				clear_Click_SendKeys(driver, 0, parameterSearch, parameterName);
				BaseSuite.validationReportLog("Entered name in search field : "+parameterName);
				BaseSuite.reportLog("Clicking on parameter name.");
				isDisplayedInLoop(driver, 5, returnTwoElements(parameterSelect, dynamicName, parameterName, dynamicFolderName, folderName));
				displayAndClick(driver, returnTwoElements(parameterSelect, dynamicName, parameterName, dynamicFolderName, folderName));
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				BaseSuite.validationReportLog("Parameter selected successfully : parameter name : "+parameterName+" folder : /"+folderName);
			} else {
				BaseSuite.reportLog("No parameterName provided. Skipping parameter selection.");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " parameterSection ");
		}
	}

	public void clickOnAdvanceSettingSection() {
		try {
			// Scroll to the Advanced Settings label
			javascript(driver, scrollToElementArg, advanceSettingLabel);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			// Check if label is visible
			if (isDisplayed(driver, advanceSettingLabel)) {
				String labelText = getText(driver, advanceSettingLabel);
				BaseSuite.validationReportLog(labelText + " Title is displayed clearly");

				// Click the label
				displayAndClick(driver, advanceSettingLabel);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				// Scroll to next related section (parameter section?)
				javascript(driver, scrollToElementArg, parameterclick);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			} else {
				BaseSuite.reportFailLog("Advanced Setting label is not visible", "clickOnAdvanceSettingSection");
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnAdvanceSettingSection ");
		}
	}

	public void selectConnection(String connectionName, By tabLocator,  By clickLocator, String type) {
		String methodName="selectConnection";
		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(2000);

			handleUnwantedToastWindow();

			BaseSuite.reportLog(" Selecting " + connectionName + " as " + type + " connection");

			BaseSuite.reportLog("Clicking on  " + type + " dataset.");

			isDisplayedInLoop(driver, 2, tabLocator);
			// Scroll and click
			javascript(driver, scrollToElementArg, tabLocator);

			if (isDisplayed(driver, tabLocator)) {
				displayAndClick(driver, tabLocator);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
				BaseSuite.reportLog("Clicked on  " + type + " dataset.");
			} else {
				BaseSuite.reportFailLog(type + " connection dropdown not visible. ",methodName);
			}
			isDisplayedInLoop(driver, 2, clickLocator);
			// Scroll and click
			javascript(driver, scrollToElementArg, clickLocator);
			if (isDisplayed(driver, clickLocator)) {
				displayAndClick(driver, clickLocator);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
			} else {
				BaseSuite.reportFailLog(type + " connection dropdown not visible.",methodName);
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			waitForExecution(1000);
			// Interact with dropdown
			new Actions(driver).moveToElement(driver.findElement(dropDownBox)).clickAndHold().perform();
			isDisplayed(driver, sourceDatasetConnectionSearch);
			sendKeys(driver, sourceDatasetConnectionSearch, connectionName);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			waitForExecution(1000);
			// Select the matched option
			By dynamicOption = returnElement(sourceDatasetConnectionSelect, dynamicName, connectionName);
			if (isDisplayed(driver, dynamicOption)) {
				displayAndClick(driver, dynamicOption);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				BaseSuite.validationReportLog(connectionName + " " + type + " connection selected successfully");
			} else {
				BaseSuite.reportFailLog("Searched " + type + " connection '" + connectionName + "' not found.",methodName);
			}

			handleUnwantedToastWindow();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " select" + type + " Connection ");

		}
	}

	public void handleUnwantedToastWindow() {

		if(isDisplayed(driver, toastMsgClosedBtn)) {
			displayAndClick(driver, toastMsgClosedBtn);
		}
	}

	public void selectSourceConnection(boolean selectOrNot, String sourceConnection) {
		if(!selectOrNot) { return ; }	
		selectConnection(sourceConnection, ruleSourceDatasetTab, sourceDatasetConnectionClick, sourceContent);

	}

	public void selectTargetConnection(boolean selectOrNot, String targetConnection) {
		if(!selectOrNot) { return ; }

		selectConnection(targetConnection, ruleTargetDatasetTab, targetDatasetConnectionClick, targetContent);

	}

	public void updateRuleDetailsOfParameterAndConnections(DataTestingParameters param) {

		try {

			clickOnAdvanceSettingSection();

			parameterSection(param.getParameterName(), param.getParamFolderName());

			boolean notHasSourceConn = param.getRuleType().equalsIgnoreCase(scriptContent);

			boolean hasTargetConn = param.getRuleType().equalsIgnoreCase(reconContent) ||  param.getRuleType().equalsIgnoreCase(checksumContent);

			selectSourceConnection(!notHasSourceConn, param.getSourceConnection());

			selectTargetConnection(hasTargetConn, param.getTargetConnection());

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " updateRuleDetailsOfParameterAndConnections ");
		}

	}

	public void selectConnectionType(String connType, String type){
		try {

			BaseSuite.reportLog("Selecting "+type+" connector type as "+connType);

			By clicklocator = type.equalsIgnoreCase(sourceContent) ? sourceDatasetConnectionType : targetDatasetConnectionType;

			By selectLocator= returnElement(sourceDatasetConnectionTypeSelect, dynamicName, capitalize(connType));

			isDisplayed(driver, clicklocator);

			waitForExecution(3000);

			isDisplayed(driver, clicklocator);

			displayAndClick(driver, clicklocator);

			new Actions(driver).moveToElement(driver.findElement(dropDownBox)).clickAndHold().build().perform();

			isDisplayed(driver, selectLocator);

			displayAndClick(driver,selectLocator);

			inVisible(driver, dataTSpinner, Constant.ruleWait);

			BaseSuite.validationReportLog(connType+" connector type selected successfully");

		} catch (Exception e) {

			BaseSuite.reportErrorLog(e, errorLogTitle + " selectConnectionType ");
		}

	}

	public void selectConnection(String connectorType, String connectionName, By tabLocator,  By clickLocator, String type) {
		String methodName="selectConnection";

		try {
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(2000);

			handleUnwantedToastWindow();

			BaseSuite.reportLog("Selecting " + connectionName + " as " + type + " connection");

			BaseSuite.reportLog("Clicking on  " + type + " dataset");

			isDisplayedInLoop(driver, 2, tabLocator);
			// Scroll and click
			javascript(driver, scrollToElementArg, tabLocator);
			
			waitForExecution(1000);

			if (isDisplayed(driver, tabLocator)) {
				displayAndClick(driver, tabLocator);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
				BaseSuite.reportLog("Clicked on  " + type + " dataset");
			} else {
				BaseSuite.reportFailLog(type + " Tab not visible",methodName);
			}

			selectConnectionType(connectorType, type);

			isDisplayedInLoop(driver, 2, clickLocator);
			// Scroll and click
			javascript(driver, scrollToElementArg, clickLocator);
			if (isDisplayed(driver, clickLocator)) {
				displayAndClick(driver, clickLocator);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
			} else {
				BaseSuite.reportFailLog(type + " connection dropdown not visible",methodName);
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			waitForExecution(1000);
			// Interact with dropdown
			new Actions(driver).moveToElement(driver.findElement(dropDownBox)).clickAndHold().perform();
			isDisplayed(driver, sourceDatasetConnectionSearch);
			sendKeys(driver, sourceDatasetConnectionSearch, connectionName);
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			waitForExecution(1000);
			// Select the matched option
			By dynamicOption = returnElement(sourceDatasetConnectionSelect, dynamicName, connectionName);
			if (isDisplayed(driver, dynamicOption)) {
				displayAndClick(driver, dynamicOption);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				BaseSuite.validationReportLog(connectionName + " " + type + " connection selected successfully");
			} else {
				BaseSuite.reportFailLog("Searched " + type + " connection '" + connectionName + "' not found.",methodName);
			}

			handleUnwantedToastWindow();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " select" + type + " Connection ");

		}
	}

	public void enterSQLQueryInEditor(String query, String type) {
		
		BaseSuite.reportLog("Entering sql query for "+type);
		
		BaseSuite.reportCodeLog(query);

		int modelIndex = type.equalsIgnoreCase(sourceContent) ? 0 : 2;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "monaco.editor.getModels()[" + modelIndex + "].setValue(arguments[0]);";

		js.executeScript(script, query);

		BaseSuite.reportLog("Entered sql query for "+type);
	}

	public boolean clickOnPreviewData(By locator, String type) {

		BaseSuite.reportLog("Clicking on Get/Preview data button for "+type);

		javascript(driver, scrollToElementArg, locator);
		
		waitMethod(driver, 3).until(ExpectedConditions.elementToBeClickable(locator));

		javascript(driver, "arguments[0].click();", locator);

		waitForExecution(1000);

		inVisible(driver, dataTSpinner, Constant.ruleWait);

		BaseSuite.validationReportLog(type+" Get/Preview data button clicked successfully");

		if(isDisplayed(driver, toastMsgClosedBtn)) {

			captureToastMsgWithOutWait(driver, toastMsg, toastMsgClosedBtn, "", "On "+type+" Preview data");
			return false;
		}
		return true;
	}

	public void selectSourceConnection(boolean selectOrNot, String connectorType,  String sourceConnection, String inputType, String sqlQuery) {

		if(!selectOrNot) { return ; }	

		selectConnection(connectorType, sourceConnection, ruleSourceDatasetTab, sourceDatasetConnectionClick, sourceContent);

		selectInputType(inputType, sourceContent);

		enterSQLQueryInEditor(sqlQuery,sourceContent);

		clickOnPreviewData(sourcegetData, sourceContent);
	}

	public void selectTargetConnection(boolean selectOrNot,String connectorType, String targetConnection, String inputType, String sqlQuery) {

		if(!selectOrNot) { return ; }

		selectConnection(connectorType, targetConnection, ruleTargetDatasetTab, targetDatasetConnectionClick, targetContent);

		selectInputType(inputType, targetContent);

		enterSQLQueryInEditor(sqlQuery,targetContent);

		clickOnPreviewData(targetgetdata, targetContent);

	}

	public boolean selectInputType(String input, String type) {
		
		BaseSuite.reportLog("Selecting input type as "+input + " for "+type);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		By locator = returnElement(type.equalsIgnoreCase(sourceContent) ? connectionInputSourceTypeLocator : connectionInputTargetLocator, dynamicName, input);

		isDisplayedInLoop(driver, 2, locator);
		if(!isDisplayed(driver, locator)) { return false; }

		new Actions(driver).moveToElement(driver.findElement(locator)).click().perform();
		/**displayAndClick(driver, locator);*/

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		
		BaseSuite.reportLog("Selected input type as "+input);

		return true;
	}
	
	public boolean clickOnDiffJoin(String ruleType) {

		try {

			if(!ruleType.trim().equalsIgnoreCase(reconContent)) return true;

			BaseSuite.reportLog("Clicking on diffJoin tab");

			isDisplayedInLoop(driver, 2, ruleDiffJoinTab);
			// Scroll and click
			javascript(driver, scrollToElementArg, ruleDiffJoinTab);
			
			waitForExecution(1000);

			if (isDisplayed(driver, ruleDiffJoinTab)) {
				displayAndClick(driver, ruleDiffJoinTab);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
				BaseSuite.reportLog("Clicked on diffJoin tab");
			} else {
				BaseSuite.reportFailLog("diffJoin Tab not visible","clickOnDiffJoin");
				return true;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "clickOnDiffJoin :: Exception occurred - " + e.toString());
			return false;
		}
		return true;
	}
	
	public boolean clickOnRecordChecks(String ruleType) {

		try {

			if(ruleType.equalsIgnoreCase(scriptContent)) return true;

			BaseSuite.reportLog("Clicking on checks tab");

			isDisplayedInLoop(driver, 2, ruleChecksTab);
			// Scroll and click
			javascript(driver, scrollToElementArg, ruleChecksTab);
			
			waitForExecution(1000);

			if (isDisplayed(driver, ruleChecksTab)) {
				displayAndClick(driver, ruleChecksTab);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
				BaseSuite.reportLog("Clicked on checks tab");
			} else {
				BaseSuite.reportFailLog("checks Tab not visible","clickOnRecordChecks");
				return true;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "clickOnRecordChecks :: Exception occurred - " + e.toString());
			return false;
		}
		return true;
	}
	
	public boolean clickOnExceptionReportTab(String ruleType) {

		try {

			if(ruleType.equalsIgnoreCase(checksumContent) || ruleType.equalsIgnoreCase(scriptContent)) return true;

			BaseSuite.reportLog("Clicking on exceptionReport tab");

			isDisplayedInLoop(driver, 2, ruleChecksTab);
			// Scroll and click
			javascript(driver, scrollToElementArg, exceptionReportTab);
			
			waitForExecution(1000);

			if (isDisplayed(driver, exceptionReportTab)) {
				displayAndClick(driver, exceptionReportTab);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				waitForExecution(1000);
				BaseSuite.reportLog("Clicked on exceptionReport tab");
			} else {
				BaseSuite.reportFailLog("exceptionReport Tab not visible","clickOnExceptionReportTab");
				return true;
			}
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "clickOnExceptionReportTab :: Exception occurred - " + e.toString());
			return false;
		}
		return true;
	}
	
	public void applyDiffJoinOnColumn(int sourceIndex, int targetIndex) {
		
		BaseSuite.reportLog("Applying diff join on index of source : "+sourceIndex + " and target : "+targetIndex);
		
		if (sourceIndex <= 0 || targetIndex <= 0) {
	        BaseSuite.reportLog("Invalid input: Source or Target index is zero or negative. Skipping selection.");
	        return;
	    }

	    selectColumn(sourceContent, sourceIndex, returnElement(sourceTableDiffJoinColumnIndex, dynamicName, String.valueOf(sourceIndex)));
	    selectColumn(targetContent, targetIndex, returnElement(targetTableDiffJoinColumnIndex, dynamicName, String.valueOf(targetIndex)));
	    
	    BaseSuite.validationReportLog("Diff join applied successfully");
	}

	private void selectColumn(String type, int index, By locator) {
		
	    BaseSuite.reportLog("Selecting  " + type.toLowerCase() + " column index '" + index + "'");
	    
	    javascript(driver, scrollToElementArg, locator);
	    
	    waitForExecution(1000);

	    isDisplayedInLoop(driver, 1, locator);

	    if (isDisplayed(driver, locator)) {
	        displayAndClick(driver, locator);
	        BaseSuite.reportLog("Selected  " + type.toLowerCase() + " column index '" + index + "'");
	    } else {
	        BaseSuite.reportFailLog(type + " column index: " + index + " not visible in table", "applyDiffJoinOnColumn");
	    }
	}
	
	public void addCustomCheck(String checkType, String checkName, String checkState, String checkExpression, String checkDesc) {
		
		try {
			
			if(!checkType.trim().equalsIgnoreCase("custom")) return ;
			
			BaseSuite.reportLog(hyphenContent+"   Adding custom check   "+hyphenContent);
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			clickOnButton(driver, addCheckButton, "Add", true);
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			displayAndClick(driver, customCheckIcon);
			
			//click on edit check name 
			log.info(checkName);
			//enter check name 
			log.info(checkState);
			// check and select check state 
			
			sendKeys(driver, customExpressiontextbox, "custom expression textbox", checkExpression);
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			// enter check description
			log.info(checkDesc);
			clickOnButton(driver, saveCheckButton, "Save", true);
			
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			
			BaseSuite.reportLog(hyphenContent+"   Added custom check successfully   "+hyphenContent);
						
		}catch(Exception e) {
			BaseSuite.reportErrorLog(e, "addCustomCheck :: Exception occurred - " + e.toString());
		}
		
	}


	public void selectValueFromDropdown(By fieldLocator, By valueLocator, String label, String input) {
		try {
			if (input == null || input.trim().isEmpty()) {
				BaseSuite.reportLog("Input value for '" + label + "' is null or empty. Skipping selection.");
				return;
			}

			BaseSuite.reportLog("Selecting '" + label + "' : " + input);
			isDisplayedInLoop(driver, 1, fieldLocator);

			BaseSuite.reportLog("Verifying if " + label + " is visible. ");
			if (isDisplayed(driver, fieldLocator)) {
				BaseSuite.validationReportLog(label + " is visible.");
				BaseSuite.reportLog("Clicking on '" + label + "' field.");
				displayAndClick(driver, fieldLocator);

				BaseSuite.reportLog("Verifying if '" + input + "' value is visible.");
				if (isDisplayed(driver, valueLocator)) {
					BaseSuite.validationReportLog(input + " is visible.");
					BaseSuite.reportLog("Clicking on '" + input + "' value.");
					displayAndClick(driver, valueLocator);
				} else {
					BaseSuite.reportFailLog("Dropdown value '" + input + "' not visible. ","selectValueFromDropdown");
				}
			} else {
				BaseSuite.reportFailLog("Field '" + label + "' not visible.","selectValueFromDropdown");
			}
			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "selectValueFromDropdown :: Exception occurred - " + e.toString());
		}
	}


	public void enterDetailsOnAddNewRulePane(String folderPath, String ruleName, String engineType, String languageType, String chooseTemplate) {

		try {
			new ParametersServicePage(driver).searchAndSelectFolderOnAddNewPane(folderPath, "Rules");

			validatAndeEnterValueToTextField(driver, ruleNameFieldTitle, ruleNameField, ruleNameFieldValidation, ruleNameContent, placeholderRuleName, ruleName, emplyRuleNameMsg);

			selectValueFromDropdown(engineTypeField, returnElement(engineTypeDropdown, dynamicName, engineType), "Engine Type", engineType);

			selectValueFromDropdown(languageTypeField, returnElement(languageTypeDropdown, dynamicName, languageType), "Langauge Type", languageType);

			clickOnButton(driver, returnElement(chooseTemplage, dynamicName, chooseTemplate.toLowerCase().trim()), "Choose template : "+chooseTemplate, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "enterDetailsOnAddNewRulePane :: Exception occurred - " + e.toString());
		}

	}
	
	public void diffjoinSection(String ruleType, DataTestingParameters ruleparam ) {
		
		clickOnDiffJoin(ruleType);
		
		if(!ruleType.trim().equalsIgnoreCase(reconContent)) return ;
		
		applyDiffJoinOnColumn(1, 1);
		
	}
	
	public void checksSection(String ruleType, DataTestingParameters ruleparam ) {
		
		clickOnRecordChecks(ruleType);
		
		if(ruleType.equalsIgnoreCase(reconContent) || ruleType.equalsIgnoreCase(validationContent)) addCustomCheck("custom", "", "", "S.[customerid] != null", "");
		
	}
	
	public void exceptionReportSection(String ruleType, boolean storeFNEFlag ) {


		clickOnExceptionReportTab(ruleType);

		if(ruleType.equalsIgnoreCase(checksumContent) || ruleType.equalsIgnoreCase(scriptContent) || ruleType.equalsIgnoreCase(pushdownContent)) return ;

		if(!storeFNEFlag) { 
			unselectcheckbox(driver, storeFailureErrorOnlyCheckbox, "Store Failure & Errors Only");
		}else {
			selectcheckbox(driver, storeFailureErrorOnlyCheckbox, "Store Failure & Errors Only");
		}

	}
	
	public void ruleConfiguration(String ruleType, DataTestingParameters ruleparam, boolean storeFNEFlag) {
		
		try {
			
			diffjoinSection(ruleType, ruleparam);

			checksSection(ruleType, ruleparam);
			
			exceptionReportSection(ruleType, storeFNEFlag);
			
			//summary
			
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "ruleConfiguration :: Exception occurred - " + e.toString());
		}
	
	}

	public boolean clickOnAddNewRuleButtonAndCreateRule(DataTestingParameters ruleparam, String ruleName, String ruleFolderName, String icedqUser) {
		String saveOption = publishContent;
		boolean flag = true;
		boolean exceptionReportFlag=false;
		String mainWindow = null;
		try {
			mainWindow = clickOnNewRuleInWorkflowDetails(true, true, icedqUser);

			enterDetailsOnAddNewRulePane(ruleFolderName, ruleName, ruleparam.getRuleEngineType(), "Groovy", ruleparam.getRuleType());

			boolean hasPermission = icedqUser.toLowerCase().contains(ownerContent) || icedqUser.toLowerCase().contains(contributorContent);

			validatAndeEnterValueToTextField(driver, ruleNameFieldTitle, ruleNameField, ruleNameFieldValidation, ruleNameContent, placeholderRuleName, ruleName, emplyRuleNameMsg);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			waitForExecution(1000);

			clickOnAdvanceSettingSection();

			parameterSection(ruleparam.getParameterName(), ruleparam.getParamFolderName());

			boolean notHasSourceConn = ruleparam.getRuleType().equalsIgnoreCase(scriptContent);

			boolean hasTargetConn = ruleparam.getRuleType().equalsIgnoreCase(reconContent) ||  ruleparam.getRuleType().equalsIgnoreCase(checksumContent);

			selectSourceConnection(!notHasSourceConn, "Database", ruleparam.getSourceConnection(), "sql", ruleparam.getSourceQuery());

			selectTargetConnection(hasTargetConn, "Database", ruleparam.getTargetConnection(), "sql", ruleparam.getTargetQuery());
			
			ruleConfiguration(ruleparam.getRuleType(), ruleparam, exceptionReportFlag);

			clickOnRuleSaveOption(hasPermission, saveOption, hasPermission ? "Rule created successfully." : ConstantProperty.CONN_INVALID_PRIVILEGES_TOASTMSG, hasPermission);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " clickOnAddNewRuleButtonAndCreateRule ");
			flag=false;
		}finally {
			
			closeCurrentTabAndSwitchToMain(driver, mainWindow);
		}
		return flag;
	}


	public void clickOnFolderHierarchyDropdown(String folderPath) {
		try {
			BaseSuite.reportLog("Attempting to click on folder hierarchy dropdown for path: " + folderPath);

			By locator = returnElement(workflowFolderSearchDropdownArrow, dynamicName, folderPath);

			isDisplayedInLoop(driver, 2, locator);

			if (isDisplayed(driver, locator)) {
				BaseSuite.reportLog("Dropdown arrow for '" + folderPath + "' is visible. Clicking...");
				displayAndClick(driver, locator);
				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
				BaseSuite.validationReportLog("Clicked on dropdown for folder path: " + folderPath);
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "clickOnFolderHierarchyDropdown :: Exception occurred - " + e.toString());
		}
	}

	public boolean checkFolderExistOrNot(String folderPath) {

		String[] folders = folderPath.split("/");

		String lastChild = folders[folders.length - 1];

		searchFunctionalityMethod(driver, true, workflowFolderSearchField, workflowFolderSearchButton, labelFolderSearch, workflowFolderSearchPlaceholder, lastChild);

		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

		isDisplayedInLoop(driver, 2, returnElement(folderName, dynamicName, "/"+folderPath));

		if(isDisplayed(driver, returnElement(folderName, dynamicName, "/"+folderPath))) {

			BaseSuite.reportLog("Folder exists : "+"/"+folderPath);
			return true;
		}
		return false;
	}

	public boolean createFolderHierarchy(String[] folders, String icedqUser) {
		boolean flag = true;
		String parentPath = "";
		Actions action = new Actions(driver);

		for (int i = 0; i < folders.length; i++) {
			String folder = folders[i];
			String currentPath = parentPath + "/" + folder;
			By currentPathBy = returnElement(folderName, dynamicName, currentPath);

			BaseSuite.reportLog("Searching for folder: " + currentPath);

			isDisplayedInLoop(driver, 2, currentPathBy);

			if (isDisplayed(driver, currentPathBy)) {

				BaseSuite.reportLog("Folder exists: " + currentPath);

				clickOnFolderHierarchyDropdown(currentPath);

			} else {
				BaseSuite.reportLog("Folder not found. Creating folder: " + folder + " under: " + parentPath);

				if (!parentPath.isEmpty()) selectParentFolder(action, parentPath);

				if (i == 0) return createNewFolderOrSelectExistingOnFolderSearchSideBar(folder, icedqUser);

				flag = createFolder(action, folder, parentPath, currentPathBy);

			}

			parentPath = currentPath; // update for next iteration
		}

		return flag;
	}

	private void selectParentFolder(Actions action, String parentPath) {
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
		WebElement parentEle = driver.findElement(returnElement(folderName, dynamicName, parentPath));
		action.moveToElement(parentEle).click().perform();
		isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
	}

	private boolean createFolder(Actions action, String folder, String parentPath, By currentPathBy) {
		try {
			By addButton = returnElement(workflowFolderNameAddButton, dynamicName, parentPath.substring(1));
			isDisplayedInLoop(driver, 3, addButton);
			if (!isDisplayed(driver, addButton)) return false;

			WebElement addBtn = driver.findElement(addButton);
			action.moveToElement(addBtn).click().perform();

			if (!isDisplayed(driver, enterNewFolderName)) {
				action.moveToElement(addBtn).click().perform(); // retry
			}

			sendKeys(driver, enterNewFolderName, folder);
			driver.findElement(enterNewFolderName).sendKeys(Keys.ENTER);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			WebElement parentEle = driver.findElement(returnElement(folderName, dynamicName, parentPath));
			action.moveToElement(parentEle).click().perform();

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);
			return isDisplayed(driver, currentPathBy);
		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, "createFolder exception");
			return false;
		}
	}



	public boolean searchAndCreateFolderHierarchy(String folderPath, String icedqUser) {
		boolean flag = true;

		try {
			

			if (folderPath.startsWith("/")) folderPath = folderPath.substring(1);

			String[] folders = folderPath.split("/");

			flag= checkFolderExistOrNot(folderPath);

			if(flag) return true;

			clickOnButton(driver, workflowListingFolderRefreshIcon, folderContent+" "+refreshContent, true);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag= createFolderHierarchy(folders, icedqUser);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " searchAndCreateFolderHierarchy ");
		}

		return flag;
	}

	//add rules to workflow 
	public boolean addRuleToWorkflowDetails(String ruleName, String ruleFolderName){

		boolean flag =true;
		try {

			clickOnWorkflowSidebarPanelOpenOrClose(true);

			clickOnButton(driver, workflowDetailsRuleTabRefreshIcon, "Rules Tab Refresh", true);

			validateAndSearchRuleOnWorkflowDetailsPage(flag, ruleName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			flag=clickOnRuleCheckboxOnWorkflowDetailsPage(ruleName, ruleFolderName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			clickOnAddRulesButtonOnWorkflowDetailsPage(true);

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" addRulesToWorkflowDetails ");

			flag=false;
		}
		return flag;
	}

	//select workflow rules flag
	public boolean selectWorkflowSingleRulesFlag(String ruleName, String ruleFolderName, String workflowJsonEntity,String sourceConnection, String targetConnection, String parameterName) {
		ruleSequenceUseFlagList=null;
		rulesConfigurationtable=null;
		boolean flag=true;
		try {
			boolean hasMultipleRules = false;

			DataTestingParameters ruleParam = setWorkflowRulesParametersForApi(0, workflowJsonEntity);

			BaseSuite.reportLog("----------------------- validating added rule : "+ruleName+" and configuring features of workflow -----------------------");

			String sfeToastMsg = hasMultipleRules ? workflowToastSFEUncheck : workflowToastSFELastSequence;
			String useToastMsg = hasMultipleRules ? "" : workflowToastUseColumnEnabled;
			String activeToastMsg = hasMultipleRules ? "" : workflowToastActiveColumnEnabled;

			selectRuleFlags(flag,ruleName, workflowDetailsRuleSuccessFlag, successContent, ruleParam.getOnSuccess(), sfeToastMsg);

			selectRuleFlags(flag,ruleName, workflowDetailsRuleFailureFlag, failureContent, ruleParam.getOnFailure(), sfeToastMsg);

			selectRuleFlags(flag,ruleName, workflowDetailsRuleErrorFlag, errorContent, ruleParam.getOnError(), sfeToastMsg);	

			checkConnectionAndParameterOnAddedRules(ruleName, sourceConnection, targetConnection, parameterName);

			/**validateAndSingleOverrideFunctionality(flag, workflowJsonEntity, ruleList, i,isOverride);*/

			flag=selectRuleUseAndActiveFlags(flag,ruleName, workflowDetailsRuleUseFlag, useContent, ruleParam.getUseExitCode(),useToastMsg);

			flag=selectRuleUseAndActiveFlags(flag,ruleName, workflowDetailsRuleActiveFlag, activeContent, ruleParam.getIsRuleActive(),activeToastMsg);

			validateFolderNameOnRuleDatasetTab(ruleName, ruleFolderName);

			isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

			ruleSequenceUseFlagList=getRulesSequenceUseFlagStatus();

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e,errorLogTitle+" selectWorkflowSingleRulesFlag ");

			flag=false;
		}

		return flag;
	}

	public boolean checkConnectionAndParameterOnAddedRules(String ruleName, String sourceConnection, String targetConnection, String parameterName) {
		Boolean flag=true;
		try {

			By ruleTypeLocator = returnElement(workflowDetailsAddedRuleType, dynamicName, ruleName);
			isDisplayedInLoop(driver, 5, ruleTypeLocator);
			javascript(driver, scrollToElementArg, ruleTypeLocator);

			String ruleType = getAttribute(driver, ruleTypeLocator, attributeTitle);
			if (ruleType == null) {
				BaseSuite.reportErrorLog("Rule type not found for rule: " + ruleName);
				return false;
			}

			boolean isScriptRule = ruleType.equalsIgnoreCase(scriptContent);
			boolean isReconOrChecksum = ruleType.equalsIgnoreCase(reconContent) || ruleType.equalsIgnoreCase(checksumContent);

			By sourceLocator = returnElement(worklfowAddedRuleSourceConnLink, dynamicName, ruleName);
			By targetLocator = returnElement(worklfowAddedRuleTargetConnLink, dynamicName, ruleName);
			By paramLocator  = returnElement(worklfowAddedRuleParameterLink, dynamicName, ruleName);

			if (!isScriptRule) {
				viewAndValidateField(sourceLocator, sourceConnectionField, sourceConnection, true);
				String targetExpected = isReconOrChecksum ? targetConnection : "";
				checkExpectedValueWithActual(driver, true, targetLocator, targetConnectionField, targetExpected, true);
				checkExpectedValueWithActual(driver, true, paramLocator, parameterField, parameterName, true);
			} else {
				viewAndValidateField(sourceLocator, sourceConnectionField, "", true);
				checkExpectedValueWithActual(driver, true, targetLocator, targetConnectionField, "", true);
				checkExpectedValueWithActual(driver, true, paramLocator, parameterField, parameterName, false); // false as per your logic
			}

		} catch (Exception e) {
			BaseSuite.reportErrorLog(e, errorLogTitle + " checkConnectionAndParameterOnAddedRules ");
			flag=false;
		}
		return flag;
	}


	//create workflow using automation database details
	public boolean createWorkflowInSpecifiedModeUsingNewRule(DataTestingParameters param,DataTestingParameters rulparam, String foldername, String icedqUser) {

		boolean flag = true;
		String newWorkflowName=null;
		String newRuleName = null;
		String workflowid=null;

		try {

			if(icedqUser.contains(readerFlag) || icedqUser.contains(executorContent) || icedqUser.contains(adminContent)) {
				
				return clickOnNewWorkflowButton(flag,icedqUser);
			}

			String workflowJsonEntity=param.getWorkflowJsonValue();
			String workflowSubscriptionJSon=param.getWorkflowSubscriptionJsonValue();
			String workflowMode=param.getWorkflowSaveMode();
			boolean downloadZip =Boolean.parseBoolean(param.getWorkflowDownloadZip());
			boolean exceptionReport=Boolean.parseBoolean(param.getWorkflowExceptionReportCheck());
			String workflowExecutionStatus=rulparam.getWorkflowStatus();

			DataTestingParameters workflowParam = setWorkflowParametersForApi(workflowJsonEntity);

			newWorkflowName = rulparam.getWorkflowName()+ System.getProperty("foldersuffix", "");
			newRuleName = rulparam.getRuleName()+ System.getProperty("foldersuffix", "");

			flag=searchAndCreateFolderHierarchy(foldername, icedqUser);

			if(!flag) {	return flag;}

			flag= clickOnNewWorkflowButton(flag,icedqUser);

			flag=enterDetailsToAddNewWorkflowPane(flag,foldername, newWorkflowName, workflowParam.getWorkflowType());

			flag=clickonWorkflowOverviewAndEnterDetails(flag,newWorkflowName, workflowParam.getWorkflowCode(), workflowParam.getWorkflowDescription());

			if(!workflowMode.toLowerCase().contains(draftContent)) {

				flag=clickonWorkflowRulesAndDatasetTab(flag);

				flag=clickOnAddNewRuleButtonAndCreateRule(rulparam, newRuleName, foldername,icedqUser);

				if(!flag) {	return flag;}

				clickOnButton(driver, workflowDetailsRuleRefreshIcon, rulesContent+" "+refreshContent, true);

				isNotDisplayed(driver, dataTSpinner, Constant.ruleWait);

				addRuleToWorkflowDetails(newRuleName, foldername);

				flag=clickOnWorkflowSidebarPanelOpenOrClose(false);

				flag=selectWorkflowSingleRulesFlag(newRuleName,foldername, workflowJsonEntity, rulparam.getSourceConnection(),rulparam.getTargetConnection(), rulparam.getParameterName());	
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

}
