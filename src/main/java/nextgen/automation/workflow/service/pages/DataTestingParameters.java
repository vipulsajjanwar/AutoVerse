package nextgen.automation.workflow.service.pages;

import java.util.ArrayList;

public class DataTestingParameters {
	
	String sourceName;
	String sourceConnType;
	String sourceInput;
	String sourceConnection;
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
	String resultTypes; //ex. a-b,b-a etc
	int noOfExp;
	String columnName;
	String columnDataType;
	ArrayList<String> columnList; 
	ArrayList<String> resultType; 
	String parameterFileId;
	String settingType;

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
	
	String chkTestOutput;			//true-false
	String joinColumnName;
	String addCheck;
	String chkExpression;  // each check expression
	String chkPatternType;
	String chkCustomPattern;
	String chkTestValue2;
	String storeFailureAndErrors;	//true-false
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
	String enableactiveOption;
	String criticality;
	String stopAtRow;
	String stopAtError;
	String stopAtTime;
	String parameterFilename;
	String dop;
	String workSpaceFolder;
	String metaDataRuleType;
	String ruleTemplateNames;
	String calculatedNametext2;
    String calculatedNametext1;
    String calculatedNametext3;
    String colName1;
    
    String checksName;
    String checksStatus;
    String warningMsg;
    String formulaName;
	String formulaoptionname;
	String operatorselection;
	String formulavalue;
	String variablename;
	String formulaNameSearch;
    String workflowfolderName;


	
	
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
    
	String sequenceSelect;
	String sequenceShuffle;
	String sequenceDelete;
	String isOverride;
	String runType;
	String saveMode;
	String functionality;
	
	String fieldValidationMessage;
	String toastValidationMessage;
	String scenarioType;
	String scenarioName;
	String find;
	String replace;
	String searchName;
	String ruleUpdateJson;
	
	String parameterName;
	String parameterDescription;
	String parameterJson;
	String parameterKey;
	String parameterValue;
	String parameterRemark;
	String parameterType;
	String parameterUpdateJson;
	String parameterUpdateName;
	String parameterUpdateDescription;
	String parameterUpdateKey;
	String parameterUpdateValue;
	String parameterUpdateRemark;
	
	String groupName;
	String groupDescription;
	String groupIdentity;
	String userName;
	String fullName;
	String firstName;
	String lastName;
	String userStatus;
	String addUser;
	String removeUser;
	String searchGroupName;
	String updateGroupName;
	String updateGroupDescription;
	String email;
	String password;
	String confirmPassword;
	String userIdentify;
	
	
	String accountName;
	String workspaceName;
	String role;
	String scope;
	String type;
	String workspaceType;
	
	String searchWorkspaceName;
	String updateWorkspaceName;
	String updateWorkspaceDescription;
	
	String addGroup;
	String removeGroup;
	String assignTo;
	String adminFlag;
	
	String searchAccountName;
	String updateAccountName;
	String updateAccountDescription;
	String addWorkspace;
	
	String vaultType;
	String secretType;
	String secretName;
	String secretDescription;
	String secretKey;
	String secretValue;
	String editSecretKey;
	String editSecretValue;
	String importJson;
	String secretKeys;
	String updateSecretName;
	String updateSecretDescription;
	String deleteSecretKey;
	String editype;
	
	String className;
	String classDescription;
	String classState;
	String classType;
	
	String functionName;
	String functionType;
	String functionDescription;
	String functionState;
	String functionScript;
	String functionMethodName;
	String functionParameters;
	String functionReturnType;
	String functionAdd;
	String functionUpdate;
	String functionDelete;
	
	String updatedBy;
	String lastUpdatedFrom;
	String lastUpdatedTo;
	
	/** Custom fields */
	
	String fieldName;
	String fieldType;
	String fieldDisplayName;
	String fieldAccountName;
	String fieldDescription;
	String fieldValue;
	String fieldValueDescription;
	String fieldHiddenValue;
	String fieldValueDefaultFlag;
	
	String updateFieldDisplayName;
	String updateFieldDescription;
	String updateFieldValue;
	String updateFieldValueDescription;
	String updateFieldHiddenValue;
	String updateFieldValueDefaultFlag;
	
	/** LDAP */
	
	String ldapEnabledFlag;
	String consoleDisplayName;
	String priority;
	String importUsersFlag;
	String editMode;
	String syncRegistrations;
	String vendor;
	String usernameLdapAttribute;
	String rdnLdapAttribute;
	String uuidLdapAttribute;
	String userObjectClasses;
	String connectionURL;
	String usersDN;
	String customUserLdapFilter;
	String searchScope;
	String bindType;
	String bindDN;
	String bindCredential;
	String pagination;
	String updateConsoleDisplayName;
	
	String mappers;
	String customMappers;
	String mapperName;
	String mapperType;
	String userModel;
	String ldapAttribute;
	String ldapGroupsDn;
	String groupNameLdap;
	String groupObjectClasses;
	String membershipLdapAttribute;
	String membershipType;
	String membershipUserLdap;
	String ldapFilter;
	String mode;
	String userGroupsRetrieveStategy;
	String memberOFLdap;
	String mappedGroup;
	String updateMappers;
	
	/** IDP */
	String idpEnabled;
	String idpRedirectURI;
	String idpAlias;
	String idpDisplayName;
	String idpDisplayOrder;
	String idpUserDiscoveryEndpoint;
	String idpDiscoveryEndpoint;
	String idpClientAuthentication;
	String idpClientID;
	String idpClientSecret;
	String idpScopes;
	String idpAuthorizationURL;
	String idpTokenURL;
	String idpLogoutURL;
	String idpUserInfoURL;
	String idpIssuer;
	String idpValidateSignatures;
	String idpUsePKCE;
	String idpUpdateDisplayName;
	
	String claim;
	String userAttributeName;
	
	String count;
	String advanceSearch;
	String order;
	
	String updateRule;
	String ruleStatus;
	String ruleState;
	String paramFolderName;
	
	String updateParameterName;
	String updateParameterDesc;
	
	String testType;
	
	
	
	
	
	
	
	
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
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
		return calculatedNametext2;
	}
	public String setCalculatedNametext2(String calculatedNametext2) {
		return calculatedNametext2;
	}
	public String getRuleTemplateNames() {
		return ruleTemplateNames;
	}
	public String setRuleTemplateNames(String ruleTemplateNames) {
		return ruleTemplateNames;
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
		return enableactiveOption;
	}
	public void setEnableactiveOption(String enableactiveOption) {
		this.enableactiveOption = enableactiveOption;
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
		return storeFailureAndErrors;
	}
	public String setStoreFailureAndErrors(String storeFailureAndErrors) {
		return storeFailureAndErrors;
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

	public String getParameterFileId() {
		return parameterFileId;
	}
	public void setParameterFileId(String parameterFileId) {
		this.parameterFileId = parameterFileId;
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
	public String getSequenceSelect() {
		return sequenceSelect;
	}
	public void setSequenceSelect(String sequenceSelect) {
		this.sequenceSelect = sequenceSelect;
	}
	public String getSequenceShuffle() {
		return sequenceShuffle;
	}
	public void setSequenceShuffle(String sequenceShuffle) {
		this.sequenceShuffle = sequenceShuffle;
	}
	public String getSequenceDelete() {
		return sequenceDelete;
	}
	public void setSequenceDelete(String sequenceDelete) {
		this.sequenceDelete = sequenceDelete;
	}
	public String getIsOverride() {
		return isOverride;
	}
	public void setIsOverride(String isOverride) {
		this.isOverride = isOverride;
	}
	public String getRunType() {
		return runType;
	}
	public void setRunType(String runType) {
		this.runType = runType;
	}
	public String getSaveMode() {
		return saveMode;
	}
	public void setSaveMode(String saveMode) {
		this.saveMode = saveMode;
	}
	public String getWorkflowfolderName() {
		return workflowfolderName;
	}
	public void setWorkflowfolderName(String workflowfolderName) {
		this.workflowfolderName = workflowfolderName;
	}
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}
	public String getFieldValidationMessage() {
		return fieldValidationMessage;
	}
	public void setFieldValidationMessage(String fieldValidationMessage) {
		this.fieldValidationMessage = fieldValidationMessage;
	}
	public String getToastValidationMessage() {
		return toastValidationMessage;
	}
	public void setToastValidationMessage(String toastValidationMessage) {
		this.toastValidationMessage = toastValidationMessage;
	}
	public String getScenarioType() {
		return scenarioType;
	}
	public void setScenarioType(String scenarioType) {
		this.scenarioType = scenarioType;
	}
	public String getScenarioName() {
		return scenarioName;
	}
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	public String getReplace() {
		return replace;
	}
	public void setReplace(String replace) {
		this.replace = replace;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getRuleUpdateJson() {
		return ruleUpdateJson;
	}
	public void setRuleUpdateJson(String ruleUpdateJson) {
		this.ruleUpdateJson = ruleUpdateJson;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getParameterDescription() {
		return parameterDescription;
	}
	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}
	public String getParameterJson() {
		return parameterJson;
	}
	public void setParameterJson(String parameterJson) {
		this.parameterJson = parameterJson;
	}
	public String getParameterKey() {
		return parameterKey;
	}
	public void setParameterKey(String parameterKey) {
		this.parameterKey = parameterKey;
	}
	public String getParameterValue() {
		return parameterValue;
	}
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	public String getParameterRemark() {
		return parameterRemark;
	}
	public void setParameterRemark(String parameterRemark) {
		this.parameterRemark = parameterRemark;
	}
	public String getParameterType() {
		return parameterType;
	}
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	public String getParameterUpdateJson() {
		return parameterUpdateJson;
	}
	public void setParameterUpdateJson(String parameterUpdateJson) {
		this.parameterUpdateJson = parameterUpdateJson;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public String getGroupIdentity() {
		return groupIdentity;
	}
	public void setGroupIdentity(String groupIdentity) {
		this.groupIdentity = groupIdentity;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getRemoveUser() {
		return removeUser;
	}
	public void setRemoveUser(String removeUser) {
		this.removeUser = removeUser;
	}
	public String getSearchGroupName() {
		return searchGroupName;
	}
	public void setSearchGroupName(String searchGroupName) {
		this.searchGroupName = searchGroupName;
	}
	public String getUpdateGroupName() {
		return updateGroupName;
	}
	public void setUpdateGroupName(String updateGroupName) {
		this.updateGroupName = updateGroupName;
	}
	public String getUpdateGroupDescription() {
		return updateGroupDescription;
	}
	public void setUpdateGroupDescription(String updateGroupDescription) {
		this.updateGroupDescription = updateGroupDescription;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getWorkspaceName() {
		return workspaceName;
	}
	public void setWorkspaceName(String workspaceName) {
		this.workspaceName = workspaceName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWorkspaceType() {
		return workspaceType;
	}
	public void setWorkspaceType(String workspaceType) {
		this.workspaceType = workspaceType;
	}
	public String getSearchWorkspaceName() {
		return searchWorkspaceName;
	}
	public void setSearchWorkspaceName(String searchWorkspaceName) {
		this.searchWorkspaceName = searchWorkspaceName;
	}
	public String getUpdateWorkspaceName() {
		return updateWorkspaceName;
	}
	public void setUpdateWorkspaceName(String updateWorkspaceName) {
		this.updateWorkspaceName = updateWorkspaceName;
	}
	public String getUpdateWorkspaceDescription() {
		return updateWorkspaceDescription;
	}
	public void setUpdateWorkspaceDescription(String updateWorkspaceDescription) {
		this.updateWorkspaceDescription = updateWorkspaceDescription;
	}
	public String getAddGroup() {
		return addGroup;
	}
	public void setAddGroup(String addGroup) {
		this.addGroup = addGroup;
	}
	public String getRemoveGroup() {
		return removeGroup;
	}
	public void setRemoveGroup(String removeGroup) {
		this.removeGroup = removeGroup;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}
	public String getSearchAccountName() {
		return searchAccountName;
	}
	public void setSearchAccountName(String searchAccountName) {
		this.searchAccountName = searchAccountName;
	}
	public String getUpdateAccountName() {
		return updateAccountName;
	}
	public void setUpdateAccountName(String updateAccountName) {
		this.updateAccountName = updateAccountName;
	}
	public String getUpdateAccountDescription() {
		return updateAccountDescription;
	}
	public void setUpdateAccountDescription(String updateAccountDescription) {
		this.updateAccountDescription = updateAccountDescription;
	}
	public String getAddWorkspace() {
		return addWorkspace;
	}
	public void setAddWorkspace(String addWorkspace) {
		this.addWorkspace = addWorkspace;
	}
	public String getVaultType() {
		return vaultType;
	}
	public void setVaultType(String vaultType) {
		this.vaultType = vaultType;
	}
	public String getSecretType() {
		return secretType;
	}
	public void setSecretType(String secretType) {
		this.secretType = secretType;
	}
	public String getSecretName() {
		return secretName;
	}
	public void setSecretName(String secretName) {
		this.secretName = secretName;
	}
	public String getSecretDescription() {
		return secretDescription;
	}
	public void setSecretDescription(String secretDescription) {
		this.secretDescription = secretDescription;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getSecretValue() {
		return secretValue;
	}
	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	public String getEditSecretKey() {
		return editSecretKey;
	}
	public void setEditSecretKey(String editSecretKey) {
		this.editSecretKey = editSecretKey;
	}
	public String getEditSecretValue() {
		return editSecretValue;
	}
	public void setEditSecretValue(String editSecretValue) {
		this.editSecretValue = editSecretValue;
	}
	public String getImportJson() {
		return importJson;
	}
	public void setImportJson(String importJson) {
		this.importJson = importJson;
	}
	public String getSecretKeys() {
		return secretKeys;
	}
	public void setSecretKeys(String secretKeys) {
		this.secretKeys = secretKeys;
	}
	public String getUpdateSecretName() {
		return updateSecretName;
	}
	public void setUpdateSecretName(String updateSecretName) {
		this.updateSecretName = updateSecretName;
	}
	public String getUpdateSecretDescription() {
		return updateSecretDescription;
	}
	public void setUpdateSecretDescription(String updateSecretDescription) {
		this.updateSecretDescription = updateSecretDescription;
	}
	public String getDeleteSecretKey() {
		return deleteSecretKey;
	}
	public void setDeleteSecretKey(String deleteSecretKey) {
		this.deleteSecretKey = deleteSecretKey;
	}
	public String getEditype() {
		return editype;
	}
	public void setEditype(String editype) {
		this.editype = editype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUserIdentify() {
		return userIdentify;
	}
	public void setUserIdentify(String userIdentify) {
		this.userIdentify = userIdentify;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	public String getClassState() {
		return classState;
	}
	public void setClassState(String classState) {
		this.classState = classState;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getFunctionType() {
		return functionType;
	}
	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}
	public String getFunctionDescription() {
		return functionDescription;
	}
	public void setFunctionDescription(String functionDescription) {
		this.functionDescription = functionDescription;
	}
	public String getFunctionState() {
		return functionState;
	}
	public void setFunctionState(String functionState) {
		this.functionState = functionState;
	}
	public String getFunctionScript() {
		return functionScript;
	}
	public void setFunctionScript(String functionScript) {
		this.functionScript = functionScript;
	}
	public String getFunctionMethodName() {
		return functionMethodName;
	}
	public void setFunctionMethodName(String functionMethodName) {
		this.functionMethodName = functionMethodName;
	}
	public String getFunctionParameters() {
		return functionParameters;
	}
	public void setFunctionParameters(String functionParameters) {
		this.functionParameters = functionParameters;
	}
	public String getFunctionReturnType() {
		return functionReturnType;
	}
	public void setFunctionReturnType(String functionReturnType) {
		this.functionReturnType = functionReturnType;
	}
	public String getFunctionAdd() {
		return functionAdd;
	}
	public void setFunctionAdd(String functionAdd) {
		this.functionAdd = functionAdd;
	}
	public String getFunctionUpdate() {
		return functionUpdate;
	}
	public void setFunctionUpdate(String functionUpdate) {
		this.functionUpdate = functionUpdate;
	}
	public String getFunctionDelete() {
		return functionDelete;
	}
	public void setFunctionDelete(String functionDelete) {
		this.functionDelete = functionDelete;
	}
	public String getParameterUpdateName() {
		return parameterUpdateName;
	}
	public void setParameterUpdateName(String parameterUpdateName) {
		this.parameterUpdateName = parameterUpdateName;
	}
	public String getParameterUpdateDescription() {
		return parameterUpdateDescription;
	}
	public void setParameterUpdateDescription(String parameterUpdateDescription) {
		this.parameterUpdateDescription = parameterUpdateDescription;
	}
	public String getParameterUpdateKey() {
		return parameterUpdateKey;
	}
	public void setParameterUpdateKey(String parameterUpdateKey) {
		this.parameterUpdateKey = parameterUpdateKey;
	}
	public String getParameterUpdateValue() {
		return parameterUpdateValue;
	}
	public void setParameterUpdateValue(String parameterUpdateValue) {
		this.parameterUpdateValue = parameterUpdateValue;
	}
	public String getParameterUpdateRemark() {
		return parameterUpdateRemark;
	}
	public void setParameterUpdateRemark(String parameterUpdateRemark) {
		this.parameterUpdateRemark = parameterUpdateRemark;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getLastUpdatedFrom() {
		return lastUpdatedFrom;
	}
	public void setLastUpdatedFrom(String lastUpdatedFrom) {
		this.lastUpdatedFrom = lastUpdatedFrom;
	}
	public String getLastUpdatedTo() {
		return lastUpdatedTo;
	}
	public void setLastUpdatedTo(String lastUpdatedTo) {
		this.lastUpdatedTo = lastUpdatedTo;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldDisplayName() {
		return fieldDisplayName;
	}
	public void setFieldDisplayName(String fieldDisplayName) {
		this.fieldDisplayName = fieldDisplayName;
	}
	public String getFieldAccountName() {
		return fieldAccountName;
	}
	public void setFieldAccountName(String fieldAccountName) {
		this.fieldAccountName = fieldAccountName;
	}
	public String getFieldDescription() {
		return fieldDescription;
	}
	public void setFieldDescription(String fieldDescription) {
		this.fieldDescription = fieldDescription;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getFieldValueDescription() {
		return fieldValueDescription;
	}
	public void setFieldValueDescription(String fieldValueDescription) {
		this.fieldValueDescription = fieldValueDescription;
	}
	public String getFieldHiddenValue() {
		return fieldHiddenValue;
	}
	public void setFieldHiddenValue(String fieldHiddenValue) {
		this.fieldHiddenValue = fieldHiddenValue;
	}
	public String getFieldValueDefaultFlag() {
		return fieldValueDefaultFlag;
	}
	public void setFieldValueDefaultFlag(String fieldValueDefaultFlag) {
		this.fieldValueDefaultFlag = fieldValueDefaultFlag;
	}
	public String getUpdateFieldDisplayName() {
		return updateFieldDisplayName;
	}
	public void setUpdateFieldDisplayName(String updateFieldDisplayName) {
		this.updateFieldDisplayName = updateFieldDisplayName;
	}
	public String getUpdateFieldDescription() {
		return updateFieldDescription;
	}
	public void setUpdateFieldDescription(String updateFieldDescription) {
		this.updateFieldDescription = updateFieldDescription;
	}
	public String getUpdateFieldValue() {
		return updateFieldValue;
	}
	public void setUpdateFieldValue(String updateFieldValue) {
		this.updateFieldValue = updateFieldValue;
	}
	public String getUpdateFieldValueDescription() {
		return updateFieldValueDescription;
	}
	public void setUpdateFieldValueDescription(String updateFieldValueDescription) {
		this.updateFieldValueDescription = updateFieldValueDescription;
	}
	public String getUpdateFieldHiddenValue() {
		return updateFieldHiddenValue;
	}
	public void setUpdateFieldHiddenValue(String updateFieldHiddenValue) {
		this.updateFieldHiddenValue = updateFieldHiddenValue;
	}
	public String getUpdateFieldValueDefaultFlag() {
		return updateFieldValueDefaultFlag;
	}
	public void setUpdateFieldValueDefaultFlag(String updateFieldValueDefaultFlag) {
		this.updateFieldValueDefaultFlag = updateFieldValueDefaultFlag;
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
	public String getLdapEnabledFlag() {
		return ldapEnabledFlag;
	}
	public void setLdapEnabledFlag(String ldapEnabledFlag) {
		this.ldapEnabledFlag = ldapEnabledFlag;
	}
	public String getConsoleDisplayName() {
		return consoleDisplayName;
	}
	public void setConsoleDisplayName(String consoleDisplayName) {
		this.consoleDisplayName = consoleDisplayName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getImportUsersFlag() {
		return importUsersFlag;
	}
	public void setImportUsersFlag(String importUsersFlag) {
		this.importUsersFlag = importUsersFlag;
	}
	public String getEditMode() {
		return editMode;
	}
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}
	public String getSyncRegistrations() {
		return syncRegistrations;
	}
	public void setSyncRegistrations(String syncRegistrations) {
		this.syncRegistrations = syncRegistrations;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getUsernameLdapAttribute() {
		return usernameLdapAttribute;
	}
	public void setUsernameLdapAttribute(String usernameLdapAttribute) {
		this.usernameLdapAttribute = usernameLdapAttribute;
	}
	public String getRdnLdapAttribute() {
		return rdnLdapAttribute;
	}
	public void setRdnLdapAttribute(String rdnLdapAttribute) {
		this.rdnLdapAttribute = rdnLdapAttribute;
	}
	public String getUuidLdapAttribute() {
		return uuidLdapAttribute;
	}
	public void setUuidLdapAttribute(String uuidLdapAttribute) {
		this.uuidLdapAttribute = uuidLdapAttribute;
	}
	public String getUserObjectClasses() {
		return userObjectClasses;
	}
	public void setUserObjectClasses(String userObjectClasses) {
		this.userObjectClasses = userObjectClasses;
	}
	public String getConnectionURL() {
		return connectionURL;
	}
	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}
	public String getUsersDN() {
		return usersDN;
	}
	public void setUsersDN(String usersDN) {
		this.usersDN = usersDN;
	}
	public String getCustomUserLdapFilter() {
		return customUserLdapFilter;
	}
	public void setCustomUserLdapFilter(String customUserLdapFilter) {
		this.customUserLdapFilter = customUserLdapFilter;
	}
	public String getSearchScope() {
		return searchScope;
	}
	public void setSearchScope(String searchScope) {
		this.searchScope = searchScope;
	}
	public String getBindType() {
		return bindType;
	}
	public void setBindType(String bindType) {
		this.bindType = bindType;
	}
	public String getBindDN() {
		return bindDN;
	}
	public void setBindDN(String bindDN) {
		this.bindDN = bindDN;
	}
	public String getBindCredential() {
		return bindCredential;
	}
	public void setBindCredential(String bindCredential) {
		this.bindCredential = bindCredential;
	}
	public String getPagination() {
		return pagination;
	}
	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
	public String getUpdateConsoleDisplayName() {
		return updateConsoleDisplayName;
	}
	public void setUpdateConsoleDisplayName(String updateConsoleDisplayName) {
		this.updateConsoleDisplayName = updateConsoleDisplayName;
	}
	public String getMapperName() {
		return mapperName;
	}
	public void setMapperName(String mapperName) {
		this.mapperName = mapperName;
	}
	public String getMapperType() {
		return mapperType;
	}
	public void setMapperType(String mapperType) {
		this.mapperType = mapperType;
	}
	public String getUserModel() {
		return userModel;
	}
	public void setUserModel(String userModel) {
		this.userModel = userModel;
	}
	public String getLdapAttribute() {
		return ldapAttribute;
	}
	public void setLdapAttribute(String ldapAttribute) {
		this.ldapAttribute = ldapAttribute;
	}
	public String getLdapGroupsDn() {
		return ldapGroupsDn;
	}
	public void setLdapGroupsDn(String ldapGroupsDn) {
		this.ldapGroupsDn = ldapGroupsDn;
	}
	public String getGroupNameLdap() {
		return groupNameLdap;
	}
	public void setGroupNameLdap(String groupNameLdap) {
		this.groupNameLdap = groupNameLdap;
	}
	public String getGroupObjectClasses() {
		return groupObjectClasses;
	}
	public void setGroupObjectClasses(String groupObjectClasses) {
		this.groupObjectClasses = groupObjectClasses;
	}
	public String getMembershipLdapAttribute() {
		return membershipLdapAttribute;
	}
	public void setMembershipLdapAttribute(String membershipLdapAttribute) {
		this.membershipLdapAttribute = membershipLdapAttribute;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public String getMembershipUserLdap() {
		return membershipUserLdap;
	}
	public void setMembershipUserLdap(String membershipUserLdap) {
		this.membershipUserLdap = membershipUserLdap;
	}
	public String getLdapFilter() {
		return ldapFilter;
	}
	public void setLdapFilter(String ldapFilter) {
		this.ldapFilter = ldapFilter;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getUserGroupsRetrieveStategy() {
		return userGroupsRetrieveStategy;
	}
	public void setUserGroupsRetrieveStategy(String userGroupsRetrieveStategy) {
		this.userGroupsRetrieveStategy = userGroupsRetrieveStategy;
	}
	public String getMemberOFLdap() {
		return memberOFLdap;
	}
	public void setMemberOFLdap(String memberOFLdap) {
		this.memberOFLdap = memberOFLdap;
	}
	public String getMappedGroup() {
		return mappedGroup;
	}
	public void setMappedGroup(String mappedGroup) {
		this.mappedGroup = mappedGroup;
	}
	public String getMappers() {
		return mappers;
	}
	public void setMappers(String mappers) {
		this.mappers = mappers;
	}
	public String getCustomMappers() {
		return customMappers;
	}
	public void setCustomMappers(String customMappers) {
		this.customMappers = customMappers;
	}
	public String getUpdateMappers() {
		return updateMappers;
	}
	public void setUpdateMappers(String updateMappers) {
		this.updateMappers = updateMappers;
	}
	public String getIdpEnabled() {
		return idpEnabled;
	}
	public void setIdpEnabled(String idpEnabled) {
		this.idpEnabled = idpEnabled;
	}
	public String getIdpRedirectURI() {
		return idpRedirectURI;
	}
	public void setIdpRedirectURI(String idpRedirectURI) {
		this.idpRedirectURI = idpRedirectURI;
	}
	public String getIdpAlias() {
		return idpAlias;
	}
	public void setIdpAlias(String idpAlias) {
		this.idpAlias = idpAlias;
	}
	public String getIdpDisplayName() {
		return idpDisplayName;
	}
	public void setIdpDisplayName(String idpDisplayName) {
		this.idpDisplayName = idpDisplayName;
	}
	public String getIdpDisplayOrder() {
		return idpDisplayOrder;
	}
	public void setIdpDisplayOrder(String idpDisplayOrder) {
		this.idpDisplayOrder = idpDisplayOrder;
	}
	public String getIdpUseDiscoveryEndpoint() {
		return idpUserDiscoveryEndpoint;
	}
	public void setIdpUseDiscoveryEndpoint(String idpUserDiscoveryEndpoint) {
		this.idpUserDiscoveryEndpoint = idpUserDiscoveryEndpoint;
	}
	public String getIdpDiscoveryEndpoint() {
		return idpDiscoveryEndpoint;
	}
	public void setIdpDiscoveryEndpoint(String idpDiscoveryEndpoint) {
		this.idpDiscoveryEndpoint = idpDiscoveryEndpoint;
	}
	public String getIdpClientAuthentication() {
		return idpClientAuthentication;
	}
	public void setIdpClientAuthentication(String idpClientAuthentication) {
		this.idpClientAuthentication = idpClientAuthentication;
	}
	public String getIdpClientID() {
		return idpClientID;
	}
	public void setIdpClientID(String idpClientID) {
		this.idpClientID = idpClientID;
	}
	public String getIdpClientSecret() {
		return idpClientSecret;
	}
	public void setIdpClientSecret(String idpClientSecret) {
		this.idpClientSecret = idpClientSecret;
	}
	public String getIdpScopes() {
		return idpScopes;
	}
	public void setIdpScopes(String idpScopes) {
		this.idpScopes = idpScopes;
	}
	public String getIdpAuthorizationURL() {
		return idpAuthorizationURL;
	}
	public void setIdpAuthorizationURL(String idpAuthorizationURL) {
		this.idpAuthorizationURL = idpAuthorizationURL;
	}
	public String getIdpTokenURL() {
		return idpTokenURL;
	}
	public void setIdpTokenURL(String idpTokenURL) {
		this.idpTokenURL = idpTokenURL;
	}
	public String getIdpLogoutURL() {
		return idpLogoutURL;
	}
	public void setIdpLogoutURL(String idpLogoutURL) {
		this.idpLogoutURL = idpLogoutURL;
	}
	public String getIdpUserInfoURL() {
		return idpUserInfoURL;
	}
	public void setIdpUserInfoURL(String idpUserInfoURL) {
		this.idpUserInfoURL = idpUserInfoURL;
	}
	public String getIdpIssuer() {
		return idpIssuer;
	}
	public void setIdpIssuer(String idpIssuer) {
		this.idpIssuer = idpIssuer;
	}
	public String getIdpValidateSignatures() {
		return idpValidateSignatures;
	}
	public void setIdpValidateSignatures(String idpValidateSignatures) {
		this.idpValidateSignatures = idpValidateSignatures;
	}
	public String getIdpUsePKCE() {
		return idpUsePKCE;
	}
	public void setIdpUsePKCE(String idpUsePKCE) {
		this.idpUsePKCE = idpUsePKCE;
	}
	public String getIdpUpdateDisplayName() {
		return idpUpdateDisplayName;
	}
	public void setIdpUpdateDisplayName(String idpUpdateDisplayName) {
		this.idpUpdateDisplayName = idpUpdateDisplayName;
	}
	public String getClaim() {
		return claim;
	}
	public void setClaim(String claim) {
		this.claim = claim;
	}
	public String getUserAttributeName() {
		return userAttributeName;
	}
	public void setUserAttributeName(String userAttributeName) {
		this.userAttributeName = userAttributeName;
	}
	public String getAdvanceSearch() {
		return advanceSearch;
	}
	public void setAdvanceSearch(String advanceSearch) {
		this.advanceSearch = advanceSearch;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getUpdateRule() {
		return updateRule;
	}
	public void setUpdateRule(String updateRule) {
		this.updateRule = updateRule;
	}
	public String getRuleStatus() {
		return ruleStatus;
	}
	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	public String getRuleState() {
		return ruleState;
	}
	public void setRuleState(String ruleState) {
		this.ruleState = ruleState;
	}
	public String getParamFolderName() {
		return paramFolderName;
	}
	public void setParamFolderName(String paramFolderName) {
		this.paramFolderName = paramFolderName;
	}
	public String getUpdateParameterName() {
		return updateParameterName;
	}
	public void setUpdateParameterName(String updateParameterName) {
		this.updateParameterName = updateParameterName;
	}
	public String getUpdateParameterDesc() {
		return updateParameterDesc;
	}
	public void setUpdateParameterDesc(String updateParameterDesc) {
		this.updateParameterDesc = updateParameterDesc;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	
	

	

	
}
