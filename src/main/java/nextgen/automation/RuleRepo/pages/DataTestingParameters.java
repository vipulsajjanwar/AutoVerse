package nextgen.automation.RuleRepo.pages;

import java.util.ArrayList;

public class DataTestingParameters {
	
	String sourceName;
	String sourceConnType;
	String sourceInput;
	String sourceConnection;
	String sourceConnectionID;
	String targetConnectionID;
	String sourceSchema;
	String sourceTable;
	String ruleType;
	String sourceAppendOrder;
	String sourecPath;
	String sourceQuery;
	String sourceFileType;
	String targetName;
	String targetConnType;
	String targetInput;
	String targetConnection;
	String targetSchema;
	String targetTable;
	String targetAppendOrder;
	String targetPath;
	String targetQuery;
	String targetFileType;
	String chk_ColumnNames;  //, seperated col ex. "gender,Email"
	String chk_SoTkeyward;  // this variable need value as source or target. For add column check.
	String chk_CustExpressions; // for custom Expression "S.[CUSTOMERID]==T.[CUSTOMERID],S.[ACCTNUMBER]-T.[ACCTNUMBER]= 0"
	String resultTypes; //ex. a-b,b-a etc
	int noOfExp;
	String columnName;
	String columnDataType;
	ArrayList<String> columnList; 
	ArrayList<String> resultType; 
	String parameterFileId;
	String paramfile_filename;
	String paramfile_desc;
	ArrayList<String> paramfile_key;
	ArrayList<String> paramfile_value;
	ArrayList<String> paramfile_remark;
	String checkVisibility;
	String settingType;
	
	
	
	String ruleSate;
	String updatedCheckName;
	String chkCheckName; //for check name
	String chkCheckType; // for api
	String chkStatus;				//true-false
	String chkDimension;
	String chkColumnname;
	String chkTestValue;
	String chkOperator;
	String chkOperatorValue1;
	String chkOperatorValue2;		
	String newCheckType;			//new check type - for excel
	String chkTrimData;				//true-false
	String chkEmptyStringAsNull;	//true-false
	String chkWhiteSpaceAsNull;		//true-false
	String chkFixedStringAsNull;	//string value
	String chkIgnoreNulls;			//true-false
	String caseSensitive;
	String chkTestOutput;			//true-false
	String joinColumnName;
	String addCheck;
	String chkExpression;  // each check expression
	String chkPatternType;
	String chkCustomPattern;
	String chkTestValue2;
	String StoreFailureAndErrors;	//true-false
	String chkInputValue;
	String chkDataType;
	String chkDateFormat;
	String chkDateRegex;
	String exceptionReportFormat;
	String storeXLSX;
	String showDownloadExceptionurl;
	String scriptValue;
	String scriptConnVarName;
	String scriptConnName;
	String scriptConnId;
	String storeExportedFileOnly;
	String exportFileRowLimit;
	//Rahul's Parameters
	

	String existingFolder;
	String folder;
	String folderName;
	String engineTypeOption;
	String chooseTemplateType;
	String wksFolder;
	String ruleName;
	String checkrule;
	String ruleCode;
	String description;
	String purpose;
	String EnableactiveOption;
	String criticality;
	String stopAtRow;
	String stopAtError;
	String stopAtTime;
	String parameterFilename;
	String dop;
	String workSpaceFolder;
	String metaDataRuleType;
	String RuleTemplateNames;
	String CalculatedNametext2;
    String calculatedNametext1;
    String calculatedNametext3;
    String colName1;
    String workspaceID;
    
    
  
	public String getCheckVisibility() {
		return checkVisibility;
	}
	public void setCheckVisibility(String checkVisibility) {
		this.checkVisibility = checkVisibility;
	}
	public String getExportFileRowLimit() {
		return exportFileRowLimit;
	}
	public void setExportFileRowLimit(String exportFileRowLimit) {
		this.exportFileRowLimit = exportFileRowLimit;
	}
	public String getRuleSate() {
		return ruleSate;
	}
	public void setRuleSate(String ruleSate) {
		this.ruleSate = ruleSate;
	}
	public String getWorkspaceID() {
		return workspaceID;
	}
	public void setWorkspaceID(String workspaceID) {
		this.workspaceID = workspaceID;
	}
	public String getSourceConnectionID() {
		return sourceConnectionID;
	}
	public void setSourceConnectionID(String sourceConnectionID) {
		this.sourceConnectionID = sourceConnectionID;
	}
	public String getTargetConnectionID() {
		return targetConnectionID;
	}
	public void setTargetConnectionID(String targetConnectionID) {
		this.targetConnectionID = targetConnectionID;
	}
	public String getChkTestValue() {
		return chkTestValue;
	}
	public void setChkTestValue(String chkTestValue) {
		this.chkTestValue = chkTestValue;
	}
	public String getChkCustomPattern() {
		return chkCustomPattern;
	}
	public void setChkCustomPattern(String chkCustomPattern) {
		this.chkCustomPattern = chkCustomPattern;
	}
	public String getStoreExportedFileOnly() {
		return storeExportedFileOnly;
	}
	public void setStoreExportedFileOnly(String storeExportedFileOnly) {
		this.storeExportedFileOnly = storeExportedFileOnly;
	}
	public String getChooseTemplateType() {
		return chooseTemplateType;
	}
	public void setChooseTemplateType(String chooseTemplateType) {
		this.chooseTemplateType = chooseTemplateType;
	}
	public String getWksFolder() {
		return wksFolder;
	}
	public void setWksFolder(String wksFolder) {
		this.wksFolder = wksFolder;
	}
	public String getOnSuccessUser() {
		return onSuccessUser;
	}
	public void setOnSuccessUser(String onSuccessUser) {
		this.onSuccessUser = onSuccessUser;
	}
	public String getOnFailureUser() {
		return onFailureUser;
	}
	public void setOnFailureUser(String onFailureUser) {
		this.onFailureUser = onFailureUser;
	}
	public String getOnErrorUser() {
		return onErrorUser;
	}
	public void setOnErrorUser(String onErrorUser) {
		this.onErrorUser = onErrorUser;
	}
	public String getOnSuccessUserType() {
		return onSuccessUserType;
	}
	public void setOnSuccessUserType(String onSuccessUserType) {
		this.onSuccessUserType = onSuccessUserType;
	}
	public String getOnFailureUserType() {
		return onFailureUserType;
	}
	public void setOnFailureUserType(String onFailureUserType) {
		this.onFailureUserType = onFailureUserType;
	}
	public String getOnErrorUserType() {
		return onErrorUserType;
	}
	public void setOnErrorUserType(String onErrorUserType) {
		this.onErrorUserType = onErrorUserType;
	}
	public String getCaseSensitive() {
		return caseSensitive;
	}
	public void setCaseSensitive(String caseSensitive) {
		this.caseSensitive = caseSensitive;
	}
	public String getColName1() {
		return colName1;
	}
	public void setColName1(String colName1) {
		this.colName1 = colName1;
	}
	public String getCalculatedNametext3() {
		return calculatedNametext3;
	}
	public void setCalculatedNametext3(String calculatedNametext3) {
		this.calculatedNametext3 = calculatedNametext3;
	}
	public String getCalculatedNametext1() {
		return calculatedNametext1;
	}
	public void setCalculatedNametext1(String calculatedNametext1) {
		this.calculatedNametext1 = calculatedNametext1;
	}
	
	public String getCalculatedNametext2() {
		return CalculatedNametext2;
	}
	public void setCalculatedNametext2(String calculatedNametext2) {
		CalculatedNametext2 = calculatedNametext2;
	}
	public String getRuleTemplateNames() {
		return RuleTemplateNames;
	}
	public void setRuleTemplateNames(String ruleTemplateNames) {
		RuleTemplateNames = ruleTemplateNames;
	}
	String checksName;
    String checksStatus;
    String warningMsg;
    String formulaName;
	String formulaoptionname;
	String operatorselection;
	String formulavalue;
	String variablename;
	String formulaNameSearch;
    String WorkflowfolderName;


	
	
	//exceptionsummary
	String diffJoinSummary;
	String successValue;
	String failureValue;
	String errorValue;
	String diffJoinSuccess;
	String diffJoinFailure;
	String diffJoinError;
	
	String workflowId;
	String instanceId;
	String instanceStatus;
	String executionstate;
	
	//workflow
	String workflowName;
	String workflowType;
	String workflowState;
	String workflowFolderID;
	String workflowCode;
	String workflowDescription;
	String workflowStatus;
	String workflowEngineType;
	String workflowTemplate;
	
	String onSuccess;
	String onFailure;
	String onError;
	String useExitCode;
	String isActive;
	String ruleEngineType;
	String isRuleActive;
	String ruleObjectId;
	String createRuleID;
	
	String overrideSourceConnID;
	String overrideSourceType;
	String overrideTargetConnID;
	String overrideTargetType;
	String overrideParamConnID;
	String overrideParamType;
	String severity;
	
	String workflowJsonValue;
	String ruleJsonValue;
	String overrideType;
	String overrideSubType;
	String overrideVariable;
	String overrideReplace;
	String overrideFind;
	String ruleFolderName;
	String ruleParameterName;
	String ruleSourceConnectionName;
	String ruleTargetConnectionName;
	
	String onSuccessUser;
	String onFailureUser;
	String onErrorUser;
	String onSuccessUserType;
	String onFailureUserType;
	String onErrorUserType;
	
	String workflowSubscriptionJsonValue;
	String workflowExecutionStatus;
	String workflowExecutionExitCode;
	String workflowOverrideJsonValue;
	String workflowUpdateJsonValue;
	
	String testScenarioName;
	String overviewContent;
	String testScenarioResult;
	String bulkOperationType;
	String removeWorkflowName;
	
	String workflowSaveMode;
	String workflowDownloadZip;
	String workflowExceptionReportCheck;
	String overrideSourceConnection;
	String overrideTargetConnection;
	String overrideParameter;

	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getScriptValue() {
		return scriptValue;
	}
	public void setScriptValue(String scriptValue) {
		this.scriptValue = scriptValue;
	}
	public String getScriptConnVarName() {
		return scriptConnVarName;
	}
	public void setScriptConnVarName(String scriptConnVarName) {
		this.scriptConnVarName = scriptConnVarName;
	}
	public String getScriptConnName() {
		return scriptConnName;
	}
	public void setScriptConnName(String scriptConnName) {
		this.scriptConnName = scriptConnName;
	}
	public String getScriptConnId() {
		return scriptConnId;
	}
	public void setScriptConnId(String scriptConnId) {
		this.scriptConnId = scriptConnId;
	}
	public String getCreateRuleID() {
		return createRuleID;
	}
	public void setCreateRuleID(String createRuleID) {
		this.createRuleID = createRuleID;
	}
	public String getShowDownloadExceptionurl() {
		return showDownloadExceptionurl;
	}
	public void setShowDownloadExceptionurl(String showDownloadExceptionurl) {
		this.showDownloadExceptionurl = showDownloadExceptionurl;
	}
	public String getWorkflowEngineType() {
		return workflowEngineType;
	}
	public void setWorkflowEngineType(String workflowEngineType) {
		this.workflowEngineType = workflowEngineType;
	}
	public String getWorkflowTemplate() {
		return workflowTemplate;
	}
	public void setWorkflowTemplate(String workflowTemplate) {
		this.workflowTemplate = workflowTemplate;
	}
	public String getWorkflowCode() {
		return workflowCode;
	}
	public void setWorkflowCode(String workflowCode) {
		this.workflowCode = workflowCode;
	}
	public String getWorkflowDescription() {
		return workflowDescription;
	}
	public void setWorkflowDescription(String workflowDescription) {
		this.workflowDescription = workflowDescription;
	}
	public String getWorkflowStatus() {
		return workflowStatus;
	}
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	public String getOverrideSourceConnID() {
		return overrideSourceConnID;
	}
	public void setOverrideSourceConnID(String overrideSourceConnID) {
		this.overrideSourceConnID = overrideSourceConnID;
	}
	public String getOverrideSourceType() {
		return overrideSourceType;
	}
	public void setOverrideSourceType(String overrideSourceType) {
		this.overrideSourceType = overrideSourceType;
	}
	public String getOverrideTargetConnID() {
		return overrideTargetConnID;
	}
	public void setOverrideTargetConnID(String overrideTargetConnID) {
		this.overrideTargetConnID = overrideTargetConnID;
	}
	public String getOverrideTargetType() {
		return overrideTargetType;
	}
	public void setOverrideTargetType(String overrideTargetType) {
		this.overrideTargetType = overrideTargetType;
	}
	public String getOverrideParamConnID() {
		return overrideParamConnID;
	}
	public void setOverrideParamConnID(String overrideParamConnID) {
		this.overrideParamConnID = overrideParamConnID;
	}
	public String getOverrideParamType() {
		return overrideParamType;
	}
	public void setOverrideParamType(String overrideParamType) {
		this.overrideParamType = overrideParamType;
	}
	public String getWorkflowState() {
		return workflowState;
	}
	public void setWorkflowState(String workflowState) {
		this.workflowState = workflowState;
	}
	public String getWorkflowFolderID() {
		return workflowFolderID;
	}
	public void setWorkflowFolderID(String workflowFolderID) {
		this.workflowFolderID = workflowFolderID;
	}
	public String getRuleObjectId() {
		return ruleObjectId;
	}
	public void setRuleObjectId(String ruleObjectId) {
		this.ruleObjectId = ruleObjectId;
	}
	public String getIsRuleActive() {
		return isRuleActive;
	}
	public void setIsRuleActive(String isRuleActive) {
		this.isRuleActive = isRuleActive;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getWorkflowType() {
		return workflowType;
	}
	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}
	public String getOnSuccess() {
		return onSuccess;
	}
	public void setOnSuccess(String onSuccess) {
		this.onSuccess = onSuccess;
	}
	public String getOnFailure() {
		return onFailure;
	}
	public void setOnFailure(String onFailure) {
		this.onFailure = onFailure;
	}
	public String getOnError() {
		return onError;
	}
	public void setOnError(String onError) {
		this.onError = onError;
	}
	public String getUseExitCode() {
		return useExitCode;
	}
	public void setUseExitCode(String useExitCode) {
		this.useExitCode = useExitCode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getRuleEngineType() {
		return ruleEngineType;
	}
	public void setRuleEngineType(String ruleEngineType) {
		this.ruleEngineType = ruleEngineType;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getInstanceStatus() {
		return instanceStatus;
	}
	public void setInstanceStatus(String instanceStatus) {
		this.instanceStatus = instanceStatus;
	}
	public String getExecutionstate() {
		return executionstate;
	}
	public void setExecutionstate(String executionstate) {
		this.executionstate = executionstate;
	}
	public String getDiffJoinSuccess() {
		return diffJoinSuccess;
	}
	public void setDiffJoinSuccess(String diffJoinSuccess) {
		this.diffJoinSuccess = diffJoinSuccess;
	}
	public String getDiffJoinFailure() {
		return diffJoinFailure;
	}
	public void setDiffJoinFailure(String diffJoinFailure) {
		this.diffJoinFailure = diffJoinFailure;
	}
	public String getDiffJoinError() {
		return diffJoinError;
	}
	public void setDiffJoinError(String diffJoinError) {
		this.diffJoinError = diffJoinError;
	}
	public String getDiffJoinSummary() {
		return diffJoinSummary;
	}
	public void setDiffJoinSummary(String diffJoinSummary) {
		this.diffJoinSummary = diffJoinSummary;
	}
	public String getSuccessValue() {
		return successValue;
	}
	public void setSuccessValue(String successValue) {
		this.successValue = successValue;
	}
	public String getFailureValue() {
		return failureValue;
	}
	public void setFailureValue(String failureValue) {
		this.failureValue = failureValue;
	}
	public String getErrorValue() {
		return errorValue;
	}
	public void setErrorValue(String errorValue) {
		this.errorValue = errorValue;
	}
	//Rahul's Getter-Setter
	
	public String getFormulaNameSearch() {
		return formulaNameSearch;
	}
	public void setFormulaNameSearch(String formulaNameSearch) {
		this.formulaNameSearch = formulaNameSearch;
	}
	public String getVariablename() {
		return variablename;
	}
	public void setVariablename(String variablename) {
		this.variablename = variablename;
	}
	public String getFormulavalue() {
		return formulavalue;
	}
	public void setFormulavalue(String formulavalue) {
		this.formulavalue = formulavalue;
	}
	public String getOperatorselection() {
		return operatorselection;
	}
	public void setOperatorselection(String operatorselection) {
		this.operatorselection = operatorselection;
	}
	public String getFormulaoptionname() {
		return formulaoptionname;
	}
	public void setFormulaoptionname(String formulaoptionname) {
		this.formulaoptionname = formulaoptionname;
	}
	public String getFormulaName() {
		return formulaName;
	}
	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}
	public String getWarningMsg() {
		return warningMsg;
	}
	public void setWarningMsg(String warningMsg) {
		this.warningMsg = warningMsg;
	}
	public String getChecksStatus() {
		return checksStatus;
	}
	public void setChecksStatus(String checksStatus) {
		this.checksStatus = checksStatus;
	}
	public String getChecksName() {
		return checksName;
	}
	public void setChecksName(String checksName) {
		this.checksName = checksName;
	}
	public String getMetaDataRuleType() {
		return metaDataRuleType;
	}
	public void setMetaDataRuleType(String metaDataRuleType) {
		this.metaDataRuleType = metaDataRuleType;
	}
	public String getWorkSpaceFolder() {
		return workSpaceFolder;
	}
	public void setWorkSpaceFolder(String workSpaceFolder) {
		this.workSpaceFolder = workSpaceFolder;
	}
	public String getParameterFilename() {
		return parameterFilename;
	}
	public void setParameterFilename(String parameterFilename) {
		this.parameterFilename = parameterFilename;
	}
	public String getStopAtTime() {
		return stopAtTime;
	}
	public void setStopAtTime(String stopAtTime) {
		this.stopAtTime = stopAtTime;
	}
	public String getStopAtError() {
		return stopAtError;
	}
	public void setStopAtError(String stopAtError) {
		this.stopAtError = stopAtError;
	}
	public String getStopAtRow() {
		return stopAtRow;
	}
	public void setStopAtRow(String stopAtRow) {
		this.stopAtRow = stopAtRow;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
	public String getEnableactiveOption() {
		return EnableactiveOption;
	}
	public void setEnableactiveOption(String EnableactiveOption) {
		this.EnableactiveOption = EnableactiveOption;
	}
	public String getCriticality() {
		return criticality;
	}
	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getCheckrule() {
		return checkrule;
	}
	public void setCheckrule(String checkrule) {
		this.checkrule = checkrule;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getEngineTypeOption() {
		return engineTypeOption;
	}
	public void setEngineTypeOption(String engineTypeOption) {
		this.engineTypeOption = engineTypeOption;
	}
	
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getExistingFolder() {
		return existingFolder;
	}
	public void setExistingFolder(String existingFolder) {
		this.existingFolder = existingFolder;
	}
	public String getResultTypes() {
		return resultTypes;
	}
	public void setResultTypes(String resultTypes) {
		this.resultTypes = resultTypes;
	}
	
	public String getAddCheck() {
		return addCheck;
	}
	public void setAddCheck(String addCheck) {
		this.addCheck = addCheck;
	}
	public String getJoinColumnName() {
		return joinColumnName;
	}
	public void setJoinColumnName(String joinColumnName) {
		this.joinColumnName = joinColumnName;

	}

	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceConnType() {
		return sourceConnType;
	}
	public String setSourceConnType(String sourceConnType) {
		return this.sourceConnType = sourceConnType;
	}
	public String getSourceInput() {
		return sourceInput;
	}
	public void setSourceInput(String sourceInput) {
		this.sourceInput = sourceInput;
	}
	public String getSourceConnection() {
		return sourceConnection;
	}
	public void setSourceConnection(String sourceConnection) {
		this.sourceConnection = sourceConnection;
	}
	public String getSourceSchema() {
		return sourceSchema;
	}
	public void setSourceSchema(String sourceSchema) {
		this.sourceSchema = sourceSchema;
	}
	public String getSourceTable() {
		return sourceTable;
	}
	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}
	public String getRuleType() {
		return ruleType;
	}
	public String setRuleType(String ruleType) {
		return this.ruleType = ruleType;
	}
	public String getSourceAppendOrder() {
		return sourceAppendOrder;
	}
	public void setSourceAppendOrder(String sourceAppendOrder) {
		this.sourceAppendOrder = sourceAppendOrder;
	}
	public String getSourecPath() {
		return sourecPath;
	}
	public void setSourecPath(String sourecPath) {
		this.sourecPath = sourecPath;
	}
	public String getSourceQuery() {
		return sourceQuery;
	}
	public void setSourceQuery(String sourceQuery) {
		this.sourceQuery = sourceQuery;
	}
	public String getSourceFileType() {
		return sourceFileType;
	}
	public void setSourceFileType(String sourceFileType) {
		this.sourceFileType = sourceFileType;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTargetConnType() {
		return targetConnType;
	}
	public String setTargetConnType(String targetConnType) {
		return this.targetConnType = targetConnType;
	}
	public String getTargetInput() {
		return targetInput;
	}
	public void setTargetInput(String targetInput) {
		this.targetInput = targetInput;
	}
	public String getTargetConnection() {
		return targetConnection;
	}
	public void setTargetConnection(String targetConnection) {
		this.targetConnection = targetConnection;
	}
	public String getTargetSchema() {
		return targetSchema;
	}
	public void setTargetSchema(String targetSchema) {
		this.targetSchema = targetSchema;
	}
	public String getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}
	public String getTargetAppendOrder() {
		return targetAppendOrder;
	}
	public void setTargetAppendOrder(String targetAppendOrder) {
		this.targetAppendOrder = targetAppendOrder;
	}
	public String getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	public String getTargetQuery() {
		return targetQuery;
	}
	public void setTargetQuery(String targetQuery) {
		this.targetQuery = targetQuery;
	}
	public String getTargetFileType() {
		return targetFileType;
	}
	public void setTargetFileType(String targetFileType) {
		this.targetFileType = targetFileType;
	}
	public String getChk_ColumnNames() {
		return chk_ColumnNames;
	}
	public void setChk_ColumnNames(String chk_ColumnNames) {
		this.chk_ColumnNames = chk_ColumnNames;
	}
	public String getChk_SoTkeyward() {
		return chk_SoTkeyward;
	}
	public void setChk_SoTkeyward(String chk_SoTkeyward) {
		this.chk_SoTkeyward = chk_SoTkeyward;
	}
	public String getChk_CustExpressions() {
		return chk_CustExpressions;
	}
	public void setChk_CustExpressions(String chk_CustExpressions) {
		this.chk_CustExpressions = chk_CustExpressions;
	}
	
	public String getChkTestOutput() {
		return chkTestOutput;
	}

	public void setChkTestOutput(String chkTestOutput) {
		this.chkTestOutput = chkTestOutput;
	}

	public String getChkIgnoreNulls() {
		return chkIgnoreNulls;
	}

	public void setChkIgnoreNulls(String chkIgnoreNulls) {
		this.chkIgnoreNulls = chkIgnoreNulls;
	}

	public String getChkTrimData() {
		return chkTrimData;
	}

	public void setChkTrimData(String chkTrimData) {
		this.chkTrimData = chkTrimData;
	}

	public String getChkEmptyStringAsNull() {
		return chkEmptyStringAsNull;
	}

	public void setChkEmptyStringAsNull(String chkEmptyStringAsNull) {
		this.chkEmptyStringAsNull = chkEmptyStringAsNull;
	}

	public String getChkWhiteSpaceAsNull() {
		return chkWhiteSpaceAsNull;
	}

	public void setChkWhiteSpaceAsNull(String chkWhiteSpaceAsNull) {
		this.chkWhiteSpaceAsNull = chkWhiteSpaceAsNull;
	}

	public String getChkFixedStringAsNull() {
		return chkFixedStringAsNull;
	}

	public void setChkFixedStringAsNull(String chkFixedStringAsNull) {
		this.chkFixedStringAsNull = chkFixedStringAsNull;
	}

	public String getNewCheckType() {
		return newCheckType;
	}

	public void setNewCheckType(String newCheckType) {
		this.newCheckType = newCheckType;
	}

	
 	public String getChkCheckName() {
 		return chkCheckName;
 	}

 	public void setChkCheckName(String chkCheckName) {
 		this.chkCheckName = chkCheckName;
 	}

 	public String getChkCheckType() {
 		return chkCheckType;
 	}

 	public void setChkCheckType(String chkCheckType) {
 		this.chkCheckType = chkCheckType;
 	}

 	public String getChkStatus() {
 		return chkStatus;
 	}

 	public void setChkStatus(String chkStatus) {
 		this.chkStatus = chkStatus;
 	}

 	public String getChkDimension() {
 		return chkDimension;
 	}

 	public void setChkDimension(String chkDimension) {
 		this.chkDimension = chkDimension;
 	}

 	public String getChkColumnname() {
 		return chkColumnname;
 	}

 	public void setChkColumnname(String chkColumnname) {
 		this.chkColumnname = chkColumnname;
 	}

 	public String getChkTestValue1() {
 		return chkTestValue;
 	}

 	public void setChkTestValue1(String chkTestValue) {
 		this.chkTestValue = chkTestValue;
 	}
	public String getChkOperator() {
		return chkOperator;
	}

	public void setChkOperator(String chkOperator) {
		this.chkOperator = chkOperator;
	}

	public String getChkOperatorValue1() {
		return chkOperatorValue1;
	}

	public void setChkOperatorValue1(String chkOperatorValue1) {
		this.chkOperatorValue1 = chkOperatorValue1;
	}

	public String getChkOperatorValue2() {
		return chkOperatorValue2;
	}

	public void setChkOperatorValue2(String chkOperatorValue2) {
		this.chkOperatorValue2 = chkOperatorValue2;
	}
	public String getChkExpression() {
		return chkExpression;
	}


	public void setChkExpression(String chkExpression) {
		this.chkExpression = chkExpression;
	}
	
	public String getChkPatternType() {
		return chkPatternType;
	}
	public void setChkPatternType(String chkPatternType) {
		this.chkPatternType = chkPatternType;
	}
	public String getChkTestValue2() {
		return chkTestValue2;
	}
	public void setChkTestValue2(String chkTestValue2) {
		this.chkTestValue2 = chkTestValue2;
	}
	public String getStoreFailureAndErrors() {
		return StoreFailureAndErrors;
	}
	public void setStoreFailureAndErrors(String storeFailureAndErrors) {
		StoreFailureAndErrors = storeFailureAndErrors;
	}
	public String getChkInputValue() {
		return chkInputValue;
	}
	public void setChkInputValue(String chkInputValue) {
		this.chkInputValue = chkInputValue;
	}
	public String getChkDataType() {
		return chkDataType;
	}
	public void setChkDataType(String chkDataType) {
		this.chkDataType = chkDataType;
	}
	public String getChkDateFormat() {
		return chkDateFormat;
	}
	public void setChkDateFormat(String chkDateFormat) {
		this.chkDateFormat = chkDateFormat;
	}
	public String getChkDateRegex() {
		return chkDateRegex;
	}
	public void setChkDateRegex(String chkDateRegex) {
		this.chkDateRegex = chkDateRegex;
	}
	public String getExceptionReportFormat() {
		return exceptionReportFormat;
	}
	public void setExceptionReportFormat(String exceptionReportFormat) {
		this.exceptionReportFormat = exceptionReportFormat;
	}
	public String getStoreXLSX() {
		return storeXLSX;
	}
	public void setStoreXLSX(String storeXLSX) {
		this.storeXLSX = storeXLSX;
	}
	public int getNoOfExp() {
		return noOfExp;
	}
	public void setNoOfExp(int noOfExp) {
		this.noOfExp = noOfExp;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnDataType() {
		return columnDataType;
	}
	public void setColumnDataType(String columnDataType) {
		this.columnDataType = columnDataType;
	}
	public ArrayList<String> getColumnList() {
		return columnList;
	}
	public void setColumnList(ArrayList<String> columnList) {
		this.columnList = columnList;
	}
	public String getSettingType() {
		return settingType;
	}
	public void setSettingType(String settingType) {
		this.settingType = settingType;
	}
	public ArrayList<String> getResultType() {
		return resultType;
	}
	public void setResultType(ArrayList<String> resultType) {
		this.resultType = resultType;
	}
	public String getUpdatedCheckName() {
		return updatedCheckName;
	}
	public void setUpdatedCheckName(String updatedCheckName) {
		this.updatedCheckName = updatedCheckName;
	}

	public void setWorkflowfolderName(String workflowfolderName) {
		WorkflowfolderName = workflowfolderName;
	}
	public String getWorkflowfolderName() {
		return WorkflowfolderName;
	}

	public String getParameterFileId() {
		return parameterFileId;
	}
	public void setParameterFileId(String parameterFileId) {
		this.parameterFileId = parameterFileId;
	}
	public String getParamfile_filename() {
		return paramfile_filename;
	}
	public void setParamfile_filename(String paramfile_filename) {
		this.paramfile_filename = paramfile_filename;
	}
	public String getParamfile_desc() {
		return paramfile_desc;
	}
	public void setParamfile_desc(String paramfile_desc) {
		this.paramfile_desc = paramfile_desc;
	}
	public ArrayList<String> getParamfile_key() {
		return paramfile_key;
	}
	public void setParamfile_key(ArrayList<String> paramfile_key) {
		this.paramfile_key = paramfile_key;
	}
	public ArrayList<String> getParamfile_value() {
		return paramfile_value;
	}
	public void setParamfile_value(ArrayList<String> paramfile_value) {
		this.paramfile_value = paramfile_value;
	}
	public ArrayList<String> getParamfile_remark() {
		return paramfile_remark;
	}
	public void setParamfile_remark(ArrayList<String> paramfile_remark) {
		this.paramfile_remark = paramfile_remark;
	}
	public String getWorkflowJsonValue() {
		return workflowJsonValue;
	}
	public void setWorkflowJsonValue(String workflowJsonValue) {
		this.workflowJsonValue = workflowJsonValue;
	}
	public String getRuleJsonValue() {
		return ruleJsonValue;
	}
	public void setRuleJsonValue(String ruleJsonValue) {
		this.ruleJsonValue = ruleJsonValue;
	}
	public String getOverrideType() {
		return overrideType;
	}
	public void setOverrideType(String overrideType) {
		this.overrideType = overrideType;
	}
	public String getOverrideSubType() {
		return overrideSubType;
	}
	public void setOverrideSubType(String overrideSubType) {
		this.overrideSubType = overrideSubType;
	}
	public String getOverrideVariable() {
		return overrideVariable;
	}
	public void setOverrideVariable(String overrideVariable) {
		this.overrideVariable = overrideVariable;
	}
	public String getOverrideReplace() {
		return overrideReplace;
	}
	public void setOverrideReplace(String overrideReplace) {
		this.overrideReplace = overrideReplace;
	}
	public String getRuleFolderName() {
		return ruleFolderName;
	}
	public void setRuleFolderName(String ruleFolderName) {
		this.ruleFolderName = ruleFolderName;
	}
	public String getRuleParameterName() {
		return ruleParameterName;
	}
	public void setRuleParameterName(String ruleParameterName) {
		this.ruleParameterName = ruleParameterName;
	}
	public String getRuleSourceConnectionName() {
		return ruleSourceConnectionName;
	}
	public void setRuleSourceConnectionName(String ruleSourceConnectionName) {
		this.ruleSourceConnectionName = ruleSourceConnectionName;
	}
	public String getRuleTargetConnectionName() {
		return ruleTargetConnectionName;
	}
	public void setRuleTargetConnectionName(String ruleTargetConnectionName) {
		this.ruleTargetConnectionName = ruleTargetConnectionName;
	}
	public String getWorkflowSubscriptionJsonValue() {
		return workflowSubscriptionJsonValue;
	}
	public void setWorkflowSubscriptionJsonValue(String workflowSubscriptionJsonValue) {
		this.workflowSubscriptionJsonValue = workflowSubscriptionJsonValue;
	}
	public String getWorkflowExecutionStatus() {
		return workflowExecutionStatus;
	}
	public void setWorkflowExecutionStatus(String workflowExecutionStatus) {
		this.workflowExecutionStatus = workflowExecutionStatus;
	}
	public String getWorkflowExecutionExitCode() {
		return workflowExecutionExitCode;
	}
	public void setWorkflowExecutionExitCode(String workflowExecutionExitCode) {
		this.workflowExecutionExitCode = workflowExecutionExitCode;
	}
	public String getOverrideFind() {
		return overrideFind;
	}
	public void setOverrideFind(String overrideFind) {
		this.overrideFind = overrideFind;
	}
	public String getWorkflowOverrideJsonValue() {
		return workflowOverrideJsonValue;
	}
	public void setWorkflowOverrideJsonValue(String workflowOverrideJsonValue) {
		this.workflowOverrideJsonValue = workflowOverrideJsonValue;
	}
	public String getWorkflowUpdateJsonValue() {
		return workflowUpdateJsonValue;
	}
	public void setWorkflowUpdateJsonValue(String workflowUpdateJsonValue) {
		this.workflowUpdateJsonValue = workflowUpdateJsonValue;
	}
	public String getTestScenarioName() {
		return testScenarioName;
	}
	public void setTestScenarioName(String testScenarioName) {
		this.testScenarioName = testScenarioName;
	}
	public String getOverviewContent() {
		return overviewContent;
	}
	public void setOverviewContent(String overviewContent) {
		this.overviewContent = overviewContent;
	}
	public String getTestScenarioResult() {
		return testScenarioResult;
	}
	public void setTestScenarioResult(String testScenarioResult) {
		this.testScenarioResult = testScenarioResult;
	}
	public String getBulkOperationType() {
		return bulkOperationType;
	}
	public void setBulkOperationType(String bulkOperationType) {
		this.bulkOperationType = bulkOperationType;
	}
	public String getRemoveWorkflowName() {
		return removeWorkflowName;
	}
	public void setRemoveWorkflowName(String removeWorkflowName) {
		this.removeWorkflowName = removeWorkflowName;
	}
	public String getWorkflowSaveMode() {
		return workflowSaveMode;
	}
	public void setWorkflowSaveMode(String workflowSaveMode) {
		this.workflowSaveMode = workflowSaveMode;
	}
	public String getWorkflowDownloadZip() {
		return workflowDownloadZip;
	}
	public void setWorkflowDownloadZip(String workflowDownloadZip) {
		this.workflowDownloadZip = workflowDownloadZip;
	}
	public String getWorkflowExceptionReportCheck() {
		return workflowExceptionReportCheck;
	}
	public void setWorkflowExceptionReportCheck(String workflowExceptionReportCheck) {
		this.workflowExceptionReportCheck = workflowExceptionReportCheck;
	}
	public String getOverrideSourceConnection() {
		return overrideSourceConnection;
	}
	public void setOverrideSourceConnection(String overrideSourceConnection) {
		this.overrideSourceConnection = overrideSourceConnection;
	}
	public String getOverrideTargetConnection() {
		return overrideTargetConnection;
	}
	public void setOverrideTargetConnection(String overrideTargetConnection) {
		this.overrideTargetConnection = overrideTargetConnection;
	}
	public String getOverrideParameter() {
		return overrideParameter;
	}
	public void setOverrideParameter(String overrideParameter) {
		this.overrideParameter = overrideParameter;
	}
	
	

	

	
}
