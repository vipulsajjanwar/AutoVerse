package nexgen.automation.framework.connectionRepo;

/**
 * @author VipulSajjanwar
 *
 */
public class ConnectionPoJO {
	
	String connectionType;
	String connName;
	String driverName;
	String authentication;
	String customJdbcFullUrl;
	String server;
	String dsn;
	String host;
	String port;
	String database;
	String type;
	String username;
	String password;
	String connProperty;
	String nameAccount;
	String regionValue;
	String cloudPlatformVal;
	String wareHouseVal;
	String databaseNameVal;
	String Connection_search;
	String instaceName;
	String domainName;
	String filePathKey;
	String keyVaultName;
	String clientId;
	String tenantId;
	String clientSecret;
	String privateKeySecretName;
	String privateKeyPasswordSecretName;
	String customJDBCURLValue;
	String serviceProviderName;
	String fileType;
	String folderPath;
	String container;
	String accessKey;
	String secretKey;
	String testFile;
	//rahul's string parameters
	String name;
	String locationname;
	String filetypename;
	String authenticationname;
	String filepath;
	String typeselect;
	String accountname;
	String AzureAccesskey;
	String sessiontoken;
	String region;
	String access;
	String secret;
	String dropDownValue;
	String Connectionsearch;
	String connectionid;
	String connectorID;
	String accountIdentifire;
	String warehouse;
	String databaseName;
	String propertyName;
	String testScenario;
	String FieldName;
	String connectionJsonValue;
	String connectionJsonValueS3;
	String connectionJsonValueAzure;
	String validationMessage;
	String onSaveValidation;
	String onTestValidation;
	String scenario;
	String genericFieldName;
	String ConnectionJson;
	String OnSaveValidate;
	String OnTestValidate;
	String validationMesg;
	String keyFileContent;
	String keyFilePassword;
	String securityToken;
	String connectionJsonValueLocal;
	String AuthenticationSnowflake;
	String ConnectionJsonForUsername;
	String ConnectionJsonForKeyPair;
	String ConnectionJsonForAzureKeyVault;
    String sybaseCredentials;
    String ConnectionJsonForSQLServeNativeSQLServerAuth;
    String ConnectionJsonForSQLServerNativeWindowsAuth;
    String ConnectionJsonForSQLServerCustomSQLServerAuth;
    String ConnectionJsonForSQLServerCustomWindowsAuth;
    String DriverType;
    String SecretName;
    String vaultstatus;
    String secretPassword; 
    String sandboxcheckbox;
    String useSSLCheckbox;
    String javatruststorePass;
    String servicePrincipal;
    String TicketCacheFileName;
    String jaasProperties;
    String projectid;

    String publicSecret;
    String privateSecret;
    String awsAccessKey;
    String awsSecretKey;
    String azureAccessKey;
    String azureAccountName;
    
    String testScenarioName;
    String scenarioType;
	String secretsColumn;

    String cloudProvidername;
    String DatabricksEnvironmentname;
    String DatabricksPassword;
	String httpPathValue;

	String ConnectionJsonForDatabricks;
	String secretId;
	String userPrincipal;
	String ConnectionJsonValueAzureUser;
	String ConnectionJsonValueS3User;
	String ConnectionJsonValueAzureSharedUser;
	String ConnectionJsonValueAzureShared;
	String KerberosCreate;
	String ConnectionJsonForLocal;
	String ConnectionJsonForExcelLocal;
    String hiveUsernamePassword;
 	
	public String getHiveUsernamePassword() {
		return hiveUsernamePassword;
	}
	public void setHiveUsernamePassword(String hiveUsernamePassword) {
		this.hiveUsernamePassword = hiveUsernamePassword;
	}
	public String getKerberosCreate() {
		return KerberosCreate;
	}
	public void setKerberosCreate(String kerberosCreate) {
		KerberosCreate = kerberosCreate;
	}
	public String getConnectionJsonValueAzureSharedUser() {
		return ConnectionJsonValueAzureSharedUser;
	}
	public void setConnectionJsonValueAzureSharedUser(String connectionJsonValueAzureSharedUser) {
		ConnectionJsonValueAzureSharedUser = connectionJsonValueAzureSharedUser;
	}
	public String getConnectionJsonValueAzureShared() {
		return ConnectionJsonValueAzureShared;
	}
	public void setConnectionJsonValueAzureShared(String connectionJsonValueAzureShared) {
		ConnectionJsonValueAzureShared = connectionJsonValueAzureShared;
	}
	public String getConnectionJsonValueAzureUser() {
		return ConnectionJsonValueAzureUser;
	}
	public void setConnectionJsonValueAzureUser(String connectionJsonValueAzureUser) {
		ConnectionJsonValueAzureUser = connectionJsonValueAzureUser;
	}
	public String getConnectionJsonValueS3User() {
		return ConnectionJsonValueS3User;
	}
	public void setConnectionJsonValueS3User(String connectionJsonValueS3User) {
		ConnectionJsonValueS3User = connectionJsonValueS3User;
	}
	public String getUserPrincipal() {
		return userPrincipal;
	}
	public void setUserPrincipal(String userPrincipal) {
		this.userPrincipal = userPrincipal;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getJaasProperties() {
		return jaasProperties;
	}
	public void setJaasProperties(String jaasProperties) {
		this.jaasProperties = jaasProperties;
	}
	public String getTicketCacheFileName() {
		return TicketCacheFileName;
	}
	public void setTicketCacheFileName(String ticketCacheFileName) {
		TicketCacheFileName = ticketCacheFileName;
	}
	public String getServicePrincipal() {
		return servicePrincipal;
	}
	public void setServicePrincipal(String servicePrincipal) {
		this.servicePrincipal = servicePrincipal;
	}
	public String getJavatruststorePass() {
		return javatruststorePass;
	}
	public void setJavatruststorePass(String javatruststorePass) {
		this.javatruststorePass = javatruststorePass;
	}
	public String getUseSSLCheckbox() {
		return useSSLCheckbox;
	}
	public void setUseSSLCheckbox(String useSSLCheckbox) {
		this.useSSLCheckbox = useSSLCheckbox;
	}
	public String getSandboxcheckbox() {
		return sandboxcheckbox;
	}
	public void setSandboxcheckbox(String sandboxcheckbox) {
		this.sandboxcheckbox = sandboxcheckbox;
	}
	public String getSecretPassword() {
		return secretPassword;
	}
	public void setSecretPassword(String secretPassword) {
		this.secretPassword = secretPassword;
	}
	public String getVaultstatus() {
		return vaultstatus;
	}
	public void setVaultstatus(String vaultstatus) {
		this.vaultstatus = vaultstatus;
	}
	public String getSecretName() {
	return SecretName;
}
public void setSecretName(String secretName) {
	SecretName = secretName;
}
	public String getDriverType() {
		return DriverType;
	}
	public void setDriverType(String driverType) {
		DriverType = driverType;
	}
	public String getConnectionJsonForSQLServeNativeSQLServerAuth() {
		return ConnectionJsonForSQLServeNativeSQLServerAuth;
	}
	public void setConnectionJsonForSQLServeNativeSQLServerAuth(String connectionJsonForSQLServeNativeSQLServerAuth) {
		ConnectionJsonForSQLServeNativeSQLServerAuth = connectionJsonForSQLServeNativeSQLServerAuth;
	}
	public String getConnectionJsonForSQLServerNativeWindowsAuth() {
		return ConnectionJsonForSQLServerNativeWindowsAuth;
	}
	public void setConnectionJsonForSQLServerNativeWindowsAuth(String connectionJsonForSQLServerNativeWindowsAuth) {
		ConnectionJsonForSQLServerNativeWindowsAuth = connectionJsonForSQLServerNativeWindowsAuth;
	}
	public String getConnectionJsonForSQLServerCustomSQLServerAuth() {
		return ConnectionJsonForSQLServerCustomSQLServerAuth;
	}
	public void setConnectionJsonForSQLServerCustomSQLServerAuth(String connectionJsonForSQLServerCustomSQLServerAuth) {
		ConnectionJsonForSQLServerCustomSQLServerAuth = connectionJsonForSQLServerCustomSQLServerAuth;
	}
	public String getConnectionJsonForSQLServerCustomWindowsAuth() {
		return ConnectionJsonForSQLServerCustomWindowsAuth;
	}
	public void setConnectionJsonForSQLServerCustomWindowsAuth(String connectionJsonForSQLServerCustomWindowsAuth) {
		ConnectionJsonForSQLServerCustomWindowsAuth = connectionJsonForSQLServerCustomWindowsAuth;
	}
	public String getSybaseCredentials() {
		return sybaseCredentials;
	}
	public void setSybaseCredentials(String sybaseCredentials) {
		this.sybaseCredentials = sybaseCredentials;
	}
	public String getConnectionJsonForUsername() {
		return ConnectionJsonForUsername;
	}
	public void setConnectionJsonForUsername(String connectionJsonForUsername) {
		ConnectionJsonForUsername = connectionJsonForUsername;
	}
	public String getConnectionJsonForKeyPair() {
		return ConnectionJsonForKeyPair;
	}
	public void setConnectionJsonForKeyPair(String connectionJsonForKeyPair) {
		ConnectionJsonForKeyPair = connectionJsonForKeyPair;
	}
	public String getConnectionJsonForAzureKeyVault() {
		return ConnectionJsonForAzureKeyVault;
	}
	public void setConnectionJsonForAzureKeyVault(String connectionJsonForAzureKeyVault) {
		ConnectionJsonForAzureKeyVault = connectionJsonForAzureKeyVault;
	}
	public String getAuthenticationSnowflake() {
		return AuthenticationSnowflake;
	}
	public void setAuthenticationSnowflake(String authenticationSnowflake) {
		AuthenticationSnowflake = authenticationSnowflake;
	}
	public String getOnSaveValidate() {
		return OnSaveValidate;
	}
	public void setOnSaveValidate(String onSaveValidate) {
		OnSaveValidate = onSaveValidate;
	}
	public String getOnTestValidate() {
		return OnTestValidate;
	}
	public void setOnTestValidate(String onTestValidate) {
		OnTestValidate = onTestValidate;
	}
	public String getValidationMesg() {
		return validationMesg;
	}
	public void setValidationMesg(String validationMesg) {
		this.validationMesg = validationMesg;
	}


	public String getConnectionJson() {
		return ConnectionJson;
	}
	public void setConnectionJson(String connectionJson) {
		ConnectionJson = connectionJson;
	}
	public String getGenericFieldName() {
		return genericFieldName;
	}
	public void setGenericFieldName(String genericFieldName) {
		this.genericFieldName = genericFieldName;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public String getPropertyName() {
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getConnectorID() {
		return connectorID;
	}
	public void setConnectorID(String connectorID) {
		this.connectorID = connectorID;
	}
	public String getKeyVaultName() {
		return keyVaultName;
	}
	public void setKeyVaultName(String keyVaultName) {
		this.keyVaultName = keyVaultName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getPrivateKeySecretName() {
		return privateKeySecretName;
	}
	public void setPrivateKeySecretName(String privateKeySecretName) {
		this.privateKeySecretName = privateKeySecretName;
	}
	public String getPrivateKeyPasswordSecretName() {
		return privateKeyPasswordSecretName;
	}
	public void setPrivateKeyPasswordSecretName(String privateKeyPasswordSecretName) {
		this.privateKeyPasswordSecretName = privateKeyPasswordSecretName;
	}
	public String getFilePathKey() {
		return filePathKey;
	}
	public void setFilePathKey(String filePathKey) {
		this.filePathKey = filePathKey;
	}
	public String getKeyFileContent() {
		return keyFileContent;
	}
	public String getKeyFilePassword() {
		return keyFilePassword;
	}
	public void setKeyFilePassword(String keyFilePassword) {
		this.keyFilePassword = keyFilePassword;
	}
	public void setKeyFileContent(String keyFileContent) {
		this.keyFileContent = keyFileContent;
	}
	public String getConnectionid() {
		return connectionid;
	}
	public void setConnectionid(String connectionid) {
		this.connectionid = connectionid;
	}
	public String getConnectionsearch() {
		return Connectionsearch;
	}
	public void setConnectionsearch(String connectionsearch) {
		Connectionsearch = connectionsearch;
	}
	public String getDropDownValue() {
		return dropDownValue;
	}
	public void setDropDownValue(String dropDownValue) {
		this.dropDownValue = dropDownValue;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	public String getFiletypename() {
		return filetypename;
	}
	public void setFiletypename(String filetypename) {
		this.filetypename = filetypename;
	}
	public String getAuthenticationname() {
	return authenticationname;
	}
	public void setAuthenticationname(String authenticationname) {
		this.authenticationname = authenticationname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getTypeselect() {
		return typeselect;
	}
	public void setTypeselect(String typeselect) {
		this.typeselect = typeselect;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAzureAccesskey() {
		return AzureAccesskey;
	}
	public void setAzureAccesskey(String accountkey) {
		this.AzureAccesskey = accountkey;
	}
	public String getSessiontoken() {
		return sessiontoken;
	}
	public void setSessiontoken(String sessiontoken) {
		this.sessiontoken = sessiontoken;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	//
	public String getcloudProvidername() {
		return cloudProvidername;
	}

	public void setcloudProvidername(String cloudProvidername) {
		this.cloudProvidername = cloudProvidername;
	}

	public String getDatabricksEnvironmentname() {
		return DatabricksEnvironmentname;
	}

	public void setDatabricksEnvironmentname(String DatabricksEnvironmentname) {
		this.DatabricksEnvironmentname = DatabricksEnvironmentname;
	}

	public String getDatabricksPassword() {
		return DatabricksPassword;
	}

	public void setDatabricksPassword(String DatabricksPassword) {
		this.DatabricksPassword = DatabricksPassword;
	}
	
	
	public String getHttpPath() {
		return httpPathValue;
	}
	public void setHttpPath(String httpPathValue) {
		this.httpPathValue = httpPathValue;
	}
	//---------------------------------------------------------------------//
	
	public String getConnectionJSONForExcelLocal() {
		return ConnectionJsonForExcelLocal;
	}
	public void setConnectionJSONForExcelLocal(String ConnectionJsonForExcelLocal) {
		this.ConnectionJsonForExcelLocal = ConnectionJsonForExcelLocal;
	}
	
	
	public String getConnectionJSONForLocal() {
		return ConnectionJsonForLocal;
	}
	public void setConnectionJSONForLocal(String ConnectionJsonForLocal) {
		this.ConnectionJsonForLocal = ConnectionJsonForLocal;
	}	

	//---------------------------------------------------------------------------//
	
	public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	
	public String getConnection_search() {
		return Connection_search;
	}
	public void setConnection_search(String connection_search) {
		Connection_search = connection_search;
	}
	
	public String getConnName() {
		return connName;
	}
	public void setConnName(String connName) {
		this.connName = connName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getAuthentication() {
		return authentication;
	}
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	public String getCustomJdbcFullUrl() {
		return customJdbcFullUrl;
	}
	public void setCustomJdbcFullUrl(String customJdbcFullUrl) {
		this.customJdbcFullUrl = customJdbcFullUrl;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDsn() {
		return dsn;
	}
	public void setDsn(String dsn) {
		this.dsn = dsn;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConnProperty() {
		return connProperty;
	}
	public void setConnProperty(String connProperty) {
		this.connProperty = connProperty;
	}
	public String getNameAccount() {
		return nameAccount;
	}
	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}
	public String getRegionValue() {
		return regionValue;
	}
	public void setRegionValue(String regionValue) {
		this.regionValue = regionValue;
	}
	public String getCloudPlatformVal() {
		return cloudPlatformVal;
	}
	public void setCloudPlatformVal(String cloudPlatformVal) {
		this.cloudPlatformVal = cloudPlatformVal;
	}
	public String getWareHouseVal() {
		return wareHouseVal;
	}
	public void setWareHouseVal(String wareHouseVal) {
		this.wareHouseVal = wareHouseVal;
	}
	public String getDatabaseNameVal() {
		return databaseNameVal;
	}
	public void setDatabaseNameVal(String databaseNameVal) {
		this.databaseNameVal = databaseNameVal;
	}
	public String getInstaceName() {
		return instaceName;
	}
	public void setInstaceName(String instaceName) {
		this.instaceName = instaceName;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getCustomJDBCURLValue() {
		return customJDBCURLValue;
	}
	public void setCustomJDBCURLValue(String customJDBCURLValue) {
		this.customJDBCURLValue = customJDBCURLValue;
	}
	public String getAccountIdentifire() {
		return accountIdentifire;
	}
	public void setAccountIdentifire(String accountIdentifire) {
		this.accountIdentifire = accountIdentifire;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getTestScenario() {
		return testScenario;
	}
	public void setTestScenario(String testScenario) {
		this.testScenario = testScenario;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getConnectionJsonValue() {
		return connectionJsonValue;
	}
	public void setConnectionJsonValue(String connectionJsonValue) {
		this.connectionJsonValue = connectionJsonValue;
	}
	
	public String getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}
	public String getOnSaveValidation() {
		return onSaveValidation;
	}
	public void setOnSaveValidation(String onSaveValidation) {
		this.onSaveValidation = onSaveValidation;
	}
	public String getOnTestValidation() {
		return onTestValidation;
	}
	public void setOnTestValidation(String onTestValidation) {
		this.onTestValidation = onTestValidation;
	}
	public String getConnectionJsonValueS3() {
		return connectionJsonValueS3;
	}
	public void setConnectionJsonValueS3(String connectionJsonValueS3) {
		this.connectionJsonValueS3 = connectionJsonValueS3;
	}
	public String getConnectionJsonValueAzure() {
		return connectionJsonValueAzure;
	}
	public void setConnectionJsonValueAzure(String connectionJsonValueAzure) {
		this.connectionJsonValueAzure = connectionJsonValueAzure;
	}
	public String getSecurityToken() {
		return securityToken;
	}
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}
	public String getConnectionJsonValueLocal() {
		return connectionJsonValueLocal;
	}
	public void setConnectionJsonValueLocal(String connectionJsonValueLocal) {
		this.connectionJsonValueLocal = connectionJsonValueLocal;
	}

	public String getPublicSecret() {
		return publicSecret;
	}
	public void setPublicSecret(String publicSecret) {
		this.publicSecret = publicSecret;
	}
	public String getPrivateSecret() {
		return privateSecret;
	}
	public void setPrivateSecret(String privateSecret) {
		this.privateSecret = privateSecret;
	}
	public String getAwsAccessKey() {
		return awsAccessKey;
	}
	public void setAwsAccessKey(String awsAccessKey) {
		this.awsAccessKey = awsAccessKey;
	}
	public String getAwsSecretKey() {
		return awsSecretKey;
	}
	public void setAwsSecretKey(String awsSecretKey) {
		this.awsSecretKey = awsSecretKey;
	}
	public String getAzureAccessKey() {
		return azureAccessKey;
	}
	public void setAzureAccessKey(String azureAccessKey) {
		this.azureAccessKey = azureAccessKey;
	}
	public String getAzureAccountName() {
		return azureAccountName;
	}
	public void setAzureAccountName(String azureAccountName) {
		this.azureAccountName = azureAccountName;
	}
	public String getTestScenarioName() {
		return testScenarioName;
	}
	public void setTestScenarioName(String testScenarioName) {
		this.testScenarioName = testScenarioName;
	}
	public String getScenarioType() {
		return scenarioType;
	}
	public void setScenarioType(String scenarioType) {
		this.scenarioType = scenarioType;
	}
	public String getSecretsColumn() {
		return secretsColumn;
	}
	public void setSecretsColumn(String secretsColumn) {
		this.secretsColumn = secretsColumn;
	}

	public String getTestFile() {
		return testFile;
	}
	public void setTestFile(String testFile) {
		this.testFile = testFile;
	}
	

	
	
	

}
