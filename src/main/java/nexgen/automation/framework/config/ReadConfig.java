package nexgen.automation.framework.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {

	Properties pro;
	final  Logger log = Logger.getLogger(ReadConfig.class);
	public ReadConfig()
	{
		File src = new File(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			log.error("Exception is " + e.getMessage());
		}
	}

	public String UserKeytabLocation()
	{
		return pro.getProperty("UserKeytabLocation");
	}

	public String KerberosConfigLocation()
	{
		return pro.getProperty("KerberosConfigLocation");
	}

	public String JavaTruststoreLocation()
	{
		return pro.getProperty("JavaTruststoreLocation");
	}

	public String mailUserName()
	{
		return pro.getProperty("MailUserName");
	}

	public String mailPassword()
	{
		return pro.getProperty("MailPassword");
	}
	public String emailHost()
	{
		return pro.getProperty("EmailHost");
	}

	public String mailPort()
	{
		return pro.getProperty("MailPort");
	}

	public String from()
	{
		return pro.getProperty("From");
	}

	public String to()
	{
		return pro.getProperty("To");
	}

	public String cc()
	{
		return pro.getProperty("CC");
	}

	public String bcc()
	{
		return pro.getProperty("BCC");
	}
	public String subject()
	{
		return pro.getProperty("Subject");
	}
	public String companyName()
	{
		return pro.getProperty("CompanyName");
	}
	public String mailSignatureName()
	{
		return pro.getProperty("MailSignatureName");
	}
	public String zapiCloudBaseUrl()
	{
		return pro.getProperty("ZAPI_CLOUD_BASE_URL");
	}
	public String apiGetExecution()
	{
		return pro.getProperty("API_GET_EXECUTIONS");
	}
	public String apiUpdateExecution()
	{
		return pro.getProperty("API_UPDATE_EXECUTION");
	}
	public String zephyrUserName()
	{
		return pro.getProperty("ZephyruserName");
	}
	public String accessKey()
	{
		return pro.getProperty("ACCESS_KEY");
	}
	public String secretKey()
	{
		return pro.getProperty("SECRET_KEY");
	}

	public String jira()
	{
		return pro.getProperty("Jira");
	}

	public String jiraBaseURL()
	{
		return pro.getProperty("JiraBaseURL");
	}
	public String jiraIssueUrl()
	{
		return  pro.getProperty("jiraIssueUrl");
	}

	public String createIssueURL()
	{
		return pro.getProperty("CreateIssueURL");
	}

	public String jiraUserName()
	{
		return pro.getProperty("JiraUserName");
	}

	public String jiraPassword()
	{
		return pro.getProperty("JiraPassword");
	}

	public String jiraLinkIssueURL()
	{
		return pro.getProperty("JiraLinkIssueURL");
	}

	public String jiraAtachmentURL()
	{
		return pro.getProperty("JiraAtachmentURL");
	}

	public String jiraCreateIssueURL()
	{
		return pro.getProperty("JiraCreateIssueURL");
	}
	public String TokenRequestUrl()
	{
		return pro.getProperty("TOKEN_REQUEST_URL");
	}
	public String xRayTestingUrl()
	{
		return pro.getProperty("XRAY_TESTNG_URL");
	}

	public String xRayClientID()
	{
		return pro.getProperty("XRAY_CLIENT_ID");
	}
	public String xRayClientSeret()
	{
		return pro.getProperty("XRAY_CLIENT_SECRET");
	}
	public String xRayGrafQL()
	{
		return pro.getProperty("XRAY_GrafQL");
	}

	public String xRayBaseUrl()
	{
		return pro.getProperty("XrayBaseURL");
	}

	public String retry()
	{
		return pro.getProperty("Retry");
	}

	public String emailSignature()
	{
		return pro.getProperty("EMAIL_SIGNATURE");
	}

	public String excelPath()
	{
		return pro.getProperty("ExcelPath");
	}

	public String dbDetails()
	{
		return pro.getProperty("dbDetails");
	}

	public String config()
	{
		return pro.getProperty("config");
	}

	public String loginDetails()
	{
		return pro.getProperty("loginDetails");
	}

	public String UserDetails()
	{
		return pro.getProperty("UserDetails");
	}

	public String connectionDetails()
	{
		return pro.getProperty("connectionDetails");
	}

	public String connectionRuleVaultDetails()
	{
		return pro.getProperty("ConnectionRuleVaultDetails");
	}

	public String pageLoadTimeout()
	{
		return pro.getProperty("pageLoadTimeout");
	}

	public String implicitWait()
	{
		return pro.getProperty("implicitWait");
	}

	public String shortWait()
	{
		return pro.getProperty("shortWait");
	}

	public String mediumWait()
	{
		return pro.getProperty("mediumWait");
	}

	public String longWait()
	{
		return pro.getProperty("longWait");
	}

	public String shortW()
	{
		return pro.getProperty("shortW");
	}

	public String mediumW()
	{
		return pro.getProperty("mediumW");
	}

	public String longW()
	{
		return pro.getProperty("longW");
	}
	public String hpalmBaseURL()
	{
		return pro.getProperty("hpalmBaseURL");
	}

	public String hpalmauthentication()
	{
		return pro.getProperty("hpalmauthentication");
	}

	public String hpalmauthenticated()
	{
		return pro.getProperty("hpalmauthenticated");
	}

	public String hpalmSession()
	{
		return pro.getProperty("hpalmSession");
	}

	public String hpalmUserName()
	{
		return pro.getProperty("hpalmUserName");
	}

	public String hpalmPassword()
	{
		return  pro.getProperty("hpalmPassword");
	}

	public String ruleWait()
	{
		String ruleWait=pro.getProperty("ruleWait");
		return ruleWait;
	}

	public String clientID()
	{

		return pro.getProperty("clientId");

	}

	public String clientSecret()
	{

		return pro.getProperty("clientSecret");

	}

	public String clientIdOnPremInstance()
	{

		return pro.getProperty("clientIdOnPremInstance");

	}

	public String clientSecreOnPremInstancet()
	{

		return pro.getProperty("clientSecreOnPremInstancet");

	}

	public String tokenUrl()
	{

		return pro.getProperty("tokenUrl");

	}

	public String tokenUrlForOnPremInstance()
	{

		return pro.getProperty("tokenUrlForOnPremInstance");

	}

	public String tokenUrlForDev4Instance()
	{

		return pro.getProperty("tokenUrlForDev4Instance");

	}



	public String userName()
	{

		return pro.getProperty("userName");

	}

	public String password()
	{

		return pro.getProperty("password");

	}

	public String ruleListApiUrlCloudInstance()
	{

		return pro.getProperty("ruleListApiUrlCloudInstance");

	}

	public String ruleListApiUrlOnPremInstance()
	{

		return pro.getProperty("ruleListApiUrlOnPremInstance");

	}

	public String workflowListApiUrl()
	{

		return pro.getProperty("workflowListApiUrl");

	}

	public String connectionListApiUrl()
	{

		return pro.getProperty("connectionListApiUrl");

	}


	public String columndetailsApi()
	{

		return pro.getProperty("columndetailsApi");

	}

	public String instanceUrl()
	{

		return pro.getProperty("instanceUrl");

	}
	public String Encryption()
	{
		return pro.getProperty("Encryption");
	}
	public String ruleExceptionReportUrl()
	{
		return pro.getProperty("RuleExceptionReportAPIUrl");
	}

	public String ruleExceptionReportAPIUrlOnPrem()
	{
		return pro.getProperty("RuleExceptionReportAPIUrlOnPrem");
	}

	public String nextGenConnectionDetailsExcel() {

		return pro.getProperty("NextGenConnectionDetails");
	}

	public String ConnectionDetailPageRExcel() {

		return pro.getProperty("ConnectionDetailPageR");
	}
	public String ExistingConnectionOfVaultExcel() {

		return pro.getProperty("ExistingConnectionOfVault");
	}

	public String databaseURL() {

		return pro.getProperty("databaseURL");
	}
	public String databaseUsername() {

		return pro.getProperty("databaseUsername");
	}
	public String databasePassword() {

		return pro.getProperty("databasePassword");
	}

	public String QAInstanceloginDetails()
	{
		return pro.getProperty("QAInstanceloginDetails");
	}

	public String AppicationBaseURL()
	{
		return pro.getProperty("ApplicationBaseURL");
	}

	public boolean readWorkflowDataFromExcel()
	{
		return Boolean.parseBoolean(pro.getProperty("readWorkflowDataFromExcel"));
	}

	public String workflowTestDataExcelPath() {
		return pro.getProperty("NextGenWorkflowTestData");
	}

	public String groupsServiceTestDataExcelPath() {

		return pro.getProperty("NextgenGroupsServiceTestDataExcel");
	}

	public String parametersServiceTestDataExcelPath() {

		return pro.getProperty("NextgenParametersServiceTestDataExcel");
	}

	public String workspacesServiceTestDataExcelPath() {

		return pro.getProperty("NextgenWorkspacesServiceTestDataExcel");
	}

	public String accountsServiceTestDataExcelPath() {

		return pro.getProperty("NextgenAccountsServiceTestDataExcel");
	}
	public boolean getFlagRunAllScenario() {

		return Boolean.parseBoolean(pro.getProperty("flag.RunAllScenariosOfWorkflow"));
	}

	public String getAccountId() {

		return pro.getProperty("accountID");
	}

	public String secretsServiceTestDataExcelPath() {

		return pro.getProperty("NextgenSecretsServiceTestDataExcel");
	}

	public String nextgenExcelJsonConnection() {

		return pro.getProperty("Nexgen.excel.connection.json");
	}

	public String usersServiceTestDataExcelPath() {

		return pro.getProperty("NextgenUsersServiceTestDataExcel");
	}

	public String functionsServiceTestDataExcelPath() {

		return pro.getProperty("NextgenFunctionsServiceTestDataExcel");
	}

	public boolean getRunAllScenarioOfFunctions() {

		return Boolean.parseBoolean(pro.getProperty("flag.RunAllScenariosOfFunctions"));
	}

	public String getRemoteWebDriverURL() {

		return pro.getProperty("huburl");
	}

	public String connectionDataDHExcel() {

		return pro.getProperty("ConnectionDataDH");
	}

	public String elkURL() {

		return pro.getProperty("elasticSearchURL");
	}

	public boolean elkStatus() {

		return Boolean.parseBoolean(pro.getProperty("elasticSearchStatus"));
	}

	public String authorVipuls() {

		return pro.getProperty("author.sign.vipul");
	}

	public String authorDhawalT() {

		return pro.getProperty("author.sign.dhawal");
	}
	public String authorRahulW() {

		return pro.getProperty("author.sign.rahul");
	}
	public String authorDannyH() {

		return pro.getProperty("author.sign.danny");
	}
	
	public String elkUserName() {

		return pro.getProperty("elk.username");
	}
	
	public String elkPassword() {

		return pro.getProperty("elk.password");
	}
	
	public String kibanaURL() {
		
		return pro.getProperty("kibanaURL");
	}
	
	public String kibanaSanityPath() {
		
		return pro.getProperty("kibana.sanity.dashboard.path");
		
	}
	
	public String kibanaRegressionPath() {
		
		return pro.getProperty("kibana.regression.dashboard.path");
		
	}
	
	public String nextGenCustomFieldServiceTestDataExcel() {
		
		return pro.getProperty("NextgenCustomFieldServiceTestDataExcel");
	}
	
	public String nextGenFederationServiceTestDataExcel() {
		
		return pro.getProperty("NextgenFederationServiceTestDataExcel");
	}
	
	public String nextGenIdentityProviderServiceTestDataExcel() {
		
		return pro.getProperty("NextgenIdentityProviderServiceTestDataExcel");
	}
	
	public boolean multiTenentAccount() {
		
		return Boolean.parseBoolean(pro.getProperty("multi.Tenent.Account"));
	}
	
	public String nextGenSchedulerServiceTestDataExcel() {
		
		return pro.getProperty("NextgenSchedulerServiceTestDataExcel");
	}
	
	public String nextGenSchedulerServiceRegTestDataExcel() {
		
		return pro.getProperty("NextgenSchedulerServiceRegTestDataExcel");
	}
	
	public String icedqAdminUsername() {
		return pro.getProperty("icedqadmin.username");
	}
	
	public String icedqAdminPassword() {
		return pro.getProperty("icedqadmin.password");
	}
	
	public String nextGenFolderServiceTestDataExcel() {
		
		return pro.getProperty("NextgenFolderServiceTestDataExcel");
	}
}


