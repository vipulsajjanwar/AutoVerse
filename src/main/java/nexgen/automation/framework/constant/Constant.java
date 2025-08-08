package nexgen.automation.framework.constant;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;



public class Constant extends BaseSuite {

	private static ReadConfig readconfig = new ReadConfig();
	public static final long  PAGE_LOAD_TIMEOUT = Integer.parseInt(readconfig.pageLoadTimeout());
	public static final long IMPLICITWAIT = Integer.parseInt(readconfig.implicitWait());
	public static final  int SHORTWAIT = Integer.parseInt(readconfig.shortWait());
	public static final  int MEDIUMWAIT = Integer.parseInt(readconfig.mediumWait());
	public static  final int LONGWAIT = Integer.parseInt(readconfig.longWait());
	
	public static final  int SHOTW = Integer.parseInt(readconfig.shortW());
	public static  final int MEDIUMW= Integer.parseInt(readconfig.mediumW());
	public static  final int LONGW = Integer.parseInt(readconfig.longW());
	
	// count of test cases and taking suite name
		public static int failedTC;
		public static int passedTC;
		public static int testskip;
		public static int test;
		public static String suitename = "";
		public static String screenshotPath = "";

	public static final String JAVATRUST_STORE_LOCATION = readconfig.JavaTruststoreLocation();
	
	public static final String USER_KEYTAB_LOCATION = readconfig.UserKeytabLocation();
	
	public static final String KERBEROS_CONFIG_LOCATION = readconfig.KerberosConfigLocation();
		
	public static final String EMAIL_SIGNATURE = readconfig.emailSignature();
					
	public static  final String EXCELPATH = readconfig.excelPath();
	
	public static  final String DBDETAILS = readconfig.dbDetails();
	
	public static  final  String LOGINDETAILS=readconfig.loginDetails();
	
	public static final String USERDETAILS = readconfig.UserDetails();
	
	public static final String CONNECTIONDETAILS = readconfig.connectionDetails();
	
	public static final String CONNECTIONRULEVAULTDETAILS =  readconfig.connectionRuleVaultDetails();
	
	public static final String NEXTGENCONNECTIONDETAILS = readconfig.nextGenConnectionDetailsExcel();
	
	public static  final  String QAINSTANCELOGINDETAILS=readconfig.QAInstanceloginDetails();

	public static final String ConnectionDetailPageR = readconfig.ConnectionDetailPageRExcel();
	
	public static final String ExistingConnectionOfVault = readconfig.ExistingConnectionOfVaultExcel();

	public static final String NEXTGEN_WORKFLOW_TESTDATA_EXCEL_PATH=readconfig.workflowTestDataExcelPath();
	
	public static final String DATABASEURL = readconfig.databaseURL();
	
	public static final String DATABASEUSERNAME = readconfig.databaseUsername();
	
	public static final String DATABASEPASSWORD = readconfig.databasePassword();
	
	public static final Boolean READWORKFLOWDATAFROMEXCEL= readconfig.readWorkflowDataFromExcel();
	
	public static final String NEXTGEN_GROUPS_TESTDATA_EXCEL_PATH =readconfig.groupsServiceTestDataExcelPath();
	
	public static final String NEXTGEN_PARAMETERS_TESTDATA_EXCEL_PATH = readconfig.parametersServiceTestDataExcelPath();
	
	public static final String NEXTGEN_WORKSPACE_TESTDATA_EXCEL_PATH = readconfig.workspacesServiceTestDataExcelPath();

	public static final String NEXTGEN_ACCOUNT_TESTDATA_EXCEL_PATH = readconfig.accountsServiceTestDataExcelPath();
	
	public static final String NEXTGEN_SECRETS_TESTDATA_EXCEL_PATH = readconfig.secretsServiceTestDataExcelPath();

	public static final String ConnectionDataDH = readconfig.connectionDataDHExcel();
	
	public static final String NEXTGEN_TESTDATA_JSON_CONNECTION = readconfig.nextgenExcelJsonConnection();
	
	public static final String NEXTGEN_USERS_TESTDATA_EXCEL_PATH =readconfig.usersServiceTestDataExcelPath();
	
	public static final String NEXTGEN_FUNCTIONS_TESTDATA_EXCEL_PATH = readconfig.functionsServiceTestDataExcelPath();
	
	public static final String NEXTGEN_CUSTOMFIELD_TESTDATA_EXCEL_PATH = readconfig.nextGenCustomFieldServiceTestDataExcel();
	
	public static final String NEXTGEN_FEDERATION_TESTDATA_EXCEL_PATH = readconfig.nextGenFederationServiceTestDataExcel();
	
	public static final String NEXTGEN_IDENTITYPROVIDER_TESTDATA_EXCEL_PATH = readconfig.nextGenIdentityProviderServiceTestDataExcel();
	
	public static final String NEXTGEN_SCHEDULER_TESTDATA_EXCEL_PATH = readconfig.nextGenSchedulerServiceTestDataExcel();
	
	public static final String NEXTGEN_SCHEDULER_REG_TESTDATA_EXCEL_PATH = readconfig.nextGenSchedulerServiceRegTestDataExcel();
	
	public static final String ICEDQ_ADMIN_USERNAME = readconfig.icedqAdminUsername();
	
	public static final String ICEDQ_ADMIN_PASSWORD = readconfig.icedqAdminPassword();
	
	public static final String NEXTGEN_FOLDER_SERVICE_TESTDATA_EXCEL_PATH = readconfig.nextGenFolderServiceTestDataExcel();
	
	
	//Issue key for all test cases will be stored here	
		public static String issueKey= "";
		
		public static String reportDocPath =null;
										
		public static String ExcelPath = readconfig.excelPath();
		
		public static String dbDetails = readconfig.dbDetails();
		
		public static String loginDetails=readconfig.loginDetails();
		
		public static String UserDetails=readconfig.UserDetails();
		
		public static int currentRowNum = 1;
		
		public static String components;
		
		public static String lables;
		
		public static boolean retryFlag;
		
		public static int retryFlagCount;
		
		public static int totalcount;
		
		public static int ruleWait = Integer.parseInt(readconfig.ruleWait());
	
		
		/**Constant variable for logs**/
		
		public static String CONNECTIONNAME = "Connection Name";
		
		public static String USERNAMELABLE = "User Name";
		
		public static String EMAILLABLE = "Email";
		
		public static String FIRSTNAMELABLE = "First Name";
		
		public static String LASTNAMELABLE = "Last Name";
		
		public static String PASSWORDLABLE = "Password";
		
		public static String CONFIRMPASSWORDLABLE = "Confirm Password";
		
		public static String AttributeValue = "value";
		
		public static String accountId = readconfig.getAccountId();
		
		public static final boolean RUN_ALL_SCENARIO_FLAG_OF_FUNCTIONS = readconfig.getRunAllScenarioOfFunctions();
		
		public static final String REMOTE_HUB_URL = readconfig.getRemoteWebDriverURL();
		
		public static final String ELK_URL = readconfig.elkURL();
		
		public static final String KIBANA_URL = readconfig.kibanaURL();
		
		public static final String ELK_USERNAME = readconfig.elkUserName();
		
		public static final String ELK_PASSWORD = readconfig.elkPassword();
		
		public static final boolean ELK_STATUS = readconfig.elkStatus();
		
		public static final String AUTHOR_VIPULS = readconfig.authorVipuls();
		
		public static final String AUTHOR_DHAWALT = readconfig.authorDhawalT();
		
		public static final String AUTHOR_RAHULW = readconfig.authorRahulW();
		
		public static final String AUTHOR_DANNYH = readconfig.authorDannyH();

		public static final boolean MULTI_TENENT_ACCOUNT=readconfig.multiTenentAccount();
	}
