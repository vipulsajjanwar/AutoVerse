package nextgen.automation.RuleRepo.pages;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.util.SystemPropertyUtils;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.connectionRepo.ConnectionPoJO;
import nexgen.automation.framework.connectionRepo.NewConnectionRepoPage;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Stopwatch;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;

public class TestDataThroughApi extends DataTestingPage {

	public TestDataThroughApi(WebDriver driver) {

		super(driver);

	}

	static ReadConfig readconfig = new ReadConfig();

	protected static final Logger log = Logger.getLogger(TestDataThroughApi.class);

	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");

	private static final String clientId = readconfig.clientID();

	private static final String clientSecret = readconfig.clientSecret();

	private static final String clientIdOnPremInstance = readconfig.clientIdOnPremInstance();

	private static final String clientSecreOnPremInstancet = readconfig.clientSecreOnPremInstancet();

	private static final String tokenUrl = readconfig.tokenUrl();

	private static final String tokenUrlForOnPremInstance = readconfig.tokenUrlForOnPremInstance();
	
	private static final String tokenUrlForDev4Instance = readconfig.tokenUrlForDev4Instance();
	

	private static final String userName = readconfig.userName();

	private static final String password = readconfig.password();

	private static final String HttpClient = null;
	By checkList = getElementLocator(prop.getProperty("dataT.CheckList"));

	String checkDetails = prop.getProperty("dataT.CheckDetails");
	/*
	 * public static String getOAuthBearerToken() {
	 * 
	 * String content = "grant_type=password&username=" + BaseSuite.username +
	 * "&password=" + BaseSuite.password;
	 * 
	 * BufferedReader reader = null;
	 * 
	 * HttpsURLConnection connection = null;
	 * 
	 * String returnValue = "";
	 * 
	 * try { URL url = new URL(tokenUrl);
	 * 
	 * connection = (HttpsURLConnection) url.openConnection();
	 * 
	 * connection.setRequestMethod("POST");
	 * 
	 * connection.setDoOutput(true);
	 * 
	 * connection.setRequestProperty("Authorization", "Basic " + authentication);
	 * 
	 * connection.setRequestProperty("Content-Type",
	 * "application/x-www-form-urlencoded");
	 * 
	 * connection.setRequestProperty("Accept", "application/json");
	 * 
	 * PrintStream os = new PrintStream(connection.getOutputStream());
	 * 
	 * os.print(content);
	 * 
	 * os.close();
	 * 
	 * reader = new BufferedReader(new
	 * InputStreamReader(connection.getInputStream()));
	 * 
	 * String line = null;
	 * 
	 * StringWriter out = new StringWriter( connection.getContentLength() > 0 ?
	 * connection.getContentLength() : 2048);
	 * 
	 * while ((line = reader.readLine()) != null) {
	 * 
	 * out.append(line); } String response = out.toString();
	 * 
	 * Matcher matcher = pat.matcher(response);
	 * 
	 * if (matcher.matches() && matcher.groupCount() > 0) {
	 * 
	 * returnValue = matcher.group(1); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.getMessage();
	 * 
	 * } finally {
	 * 
	 * if (reader != null) {
	 * 
	 * try {
	 * 
	 * reader.close();
	 * 
	 * } catch (IOException e) {
	 * 
	 * } }
	 * 
	 * connection.disconnect(); }
	 * 
	 * return returnValue; }
	 */

	// If single user login flag is true in XML file than pass double quote for
	// rolename(Ex-rolename = "")
	// If single user login flag is false in XML file than pass icedq role name on
	// parameter(Ex-rolename = Wprkspace_Owner)
	public static String getOAuthBearerTokenBasedOnIcedqRole(String roleName) {
		String UN;
		String PW;
		XLUtils xlReader = new XLUtils();

		if (BaseSuite.singleUserLogin) {

			UN = BaseSuite.username;
			PW = BaseSuite.password;

		} else {
			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(roleName);

			UN = loginDetails[0];

			PW = loginDetails[1];
		}
		String content = "grant_type=password&username=" + UN + "&password=" + PW;

		BufferedReader reader = null;

		HttpURLConnection httpCon = null;

		String returnValue = "";

		String baseUrl;

		String id;

		String secret;

		try {
			
			String val = System.getProperty("testDataApiUrl");
			
			if (val.contains("api.icedq.net")) {
				baseUrl = tokenUrl;

				id = clientId;

				secret = clientSecret;

			} else {
				
			
				baseUrl = tokenUrlForOnPremInstance;
			
				id = clientIdOnPremInstance;

				secret = clientSecreOnPremInstancet;
			}
			
			String auth = id + ":" + secret;

			String authentication = Base64.getEncoder().encodeToString(auth.getBytes());

			URL url = new URL(baseUrl);

			httpCon = (HttpURLConnection) url.openConnection();

			httpCon.setRequestMethod("POST");

			httpCon.setDoOutput(true);

			httpCon.setRequestProperty("Authorization", "Basic " + authentication);

			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			httpCon.setRequestProperty("Accept", "application/json");

			PrintStream os = new PrintStream(httpCon.getOutputStream());

			os.print(content);

			os.close();

			reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));

			String line = null;

			StringWriter out = new StringWriter(httpCon.getContentLength() > 0 ? httpCon.getContentLength() : 2048);

			while ((line = reader.readLine()) != null) {

				out.append(line);
			}
			String response = out.toString();

			Matcher matcher = pat.matcher(response);

			if (matcher.matches() && matcher.groupCount() > 0) {

				returnValue = matcher.group(1);
			}

		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (reader != null) {

				try {

					reader.close();

				} catch (IOException e) {

				}
			}

			httpCon.disconnect();
		}

		return returnValue;
	}

	public static List<String> getRuleIdFromRuleList(String workspaceId, String ruleType, String ruleStateType,
			String icedqRole) {
		try {
			String baseUrl;

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			if (ruleType.equalsIgnoreCase("All")) {

				body = RequestBody.create(mediaType, "");

			} else {

				body = RequestBody.create(mediaType,
						"{\r\n\"filter\": [\r\n{\r\n\"attribute\": "
								+ "\"state\",\r\n\"operator\": \"In\",\r\n\"datatype\": \"string\",\r\n\"value\": \""
								+ ruleStateType + "\"\r\n},"
								+ "\r\n{\r\n\"attribute\": \"ruleType\",\r\n\"operator\": \"In\",\r\n\"datatype\": "
								+ "\"string\",\r\n\"value\": \"" + ruleType + "\"\r\n}\r\n]\r\n}");

			}

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				baseUrl = readconfig.ruleListApiUrlCloudInstance();
			} else {
				baseUrl = readconfig.ruleListApiUrlOnPremInstance();
			}

			Request request = new Request.Builder()

					.url(baseUrl).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceId)

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			return TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonBody, "$.items..id");

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	public static String getConnectionTypeFromConnectionList(String connectionJson, String connId) {

		String connectionType = null;

		try {

			JSONObject allIssues = new JSONObject(connectionJson);

			connectionType = (String) allIssues.get("connectorId");

		} catch (Exception e) {

			e.getMessage();
		}
		return connectionType;

	}

	public String getRuleJsonEntityUsingRuleID(String workspaceID, String ruleID, String icedqRole) {
		String jsonEntity = null;

		HttpGet getRequest;

		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				
				getRequest = new HttpGet("http://api.icedq.net/api/v1/rules/" + ruleID);
				
			} else {
				
				getRequest = new HttpGet("http://qa.onprem.icedq.com/api/v1/rules/" + ruleID);
			}

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("workspace-id", workspaceID);

			getRequest.setHeader("org-id", "org-iam.icedq");

			getRequest.setHeader("Authorization", "Bearer " + auto);

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
	
	public static String getFileRuleSchemaJson(String workspaceID, String schemaID, String icedqRole)
	{
		String jsonBody = null;
		
		HttpGet getRequest;
		
		String url;
		
		try {
			
			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);
			
			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				
				url = "http://api.icedq.net";
				
			} else {
			
				url = "http://qa.onprem.icedq.com";
			}
			
			getRequest = new HttpGet(url+"/api/v1/file-schema/"+schemaID);

			HttpClient httpClient = HttpClientBuilder.create().build();

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("workspace-id", workspaceID);

			getRequest.setHeader("org-id", "org-iam.icedq");

			getRequest.setHeader("Authorization", "Bearer "+auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonBody = EntityUtils.toString(entity1);
		
			
		} catch (IOException e) {
			
			e.getMessage();
		}
		return jsonBody;
		
	}

	public ArrayList<String> createConnection(String ruleType, String jsonEntity, String workspaceID, String jsonExp,
			SoftAssert soft, String icedqRole) {
		ArrayList<String> connectionList = new ArrayList<>();

		try {
			ArrayList<String> connList = null;

			String connectionName = null;

			NewConnectionRepoPage conn = new NewConnectionRepoPage(driver);
			if (!ruleType.equalsIgnoreCase("Script")) {

				connList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, jsonExp);

			} else {

				connList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, jsonExp);
			}
			// sourceAddColumn(jsonEntity);

			for (int j = 0; j < connList.size(); j++) {

				String connJsonEntity = TestDataThroughApi.getConnectionJsonEntity(workspaceID, connList.get(j),
						icedqRole);

				ConnectionPoJO connParam = conn.setConnectionParametersForApi(connJsonEntity);

				String connName = TestDataThroughApi.getConnectionNmae(connJsonEntity);

				connectionName = connName + "_" + BaseSuite.WorkspaceName;

				String connType = TestDataThroughApi.getConnectionTypeFromConnectionList(connJsonEntity,
						connList.get(j));

				switch (connType.toLowerCase()) {

				case "oracle":
				case "snowflake":
				case "postgres":
				case "redshift":
				case "teradata":
				case "DB2":
				case "sql-server":

					conn.createDBConnectionFromApi(connJsonEntity, connectionName, connType, connParam, soft);

					break;

				case "flat file (native)":

					conn.flatfilenativewithAPI(connJsonEntity, connParam, connectionName, soft, connType,
							connParam.getTypeselect());

				default:

					break;

				}

				connectionList.add(connectionName);
			}
		} catch (Exception e) {

			e.getMessage();
		}

		return connectionList;

	}

	// Main ethod
	public void getRuleInfoAndCreateRule(String workspaceID, String folderId,String ruleCreateFolder,String ruleType,String ruleName,
			String icedqRole, String sourceSingleConnection, String targetSingleConnection,String testDataInput,String changeQueryConn, SoftAssert soft)
			throws Throwable {

		boolean flag = false;

		boolean expoertedFileFlag = false;
		try {
			
			//String folderId = getfolderIdFromRuleList(workspaceID,ruleName,icedqRole);
			DataTestingParameters xrparam = null;
			
			DataTestingParameters param = null;
			
			XLUtils xl = new XLUtils();
			
			String sourceQuery = null;
			
			String targetQuery = null;
			
			int count = 0;
			
			String ruleID = null;
			
			int rowNumber = 0;
			
			List<String> ruleIdList = null;
			
			String fileName = null;
			
			String jsonEntity;
			
			if(!testDataInput.isEmpty())
			{
				
				fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\DataTesting\\RuleTestData.xlsx";
				
				count  = xl.getRowCount(fileName, "Sheet1");
				
				//ruleName = param.getRuleName();

			}
			else
			{

				if (ruleName.isEmpty() && folderId.isEmpty()) {
					
					ruleIdList = getRuleIdFromRuleList(workspaceID, ruleType, "Published", icedqRole);

					count = ruleIdList.size();
				}

				else if (ruleName.isEmpty()) {

					ruleIdList = getRuleListFromSpecificFolder(folderId, workspaceID, icedqRole);

					count = ruleIdList.size();

				} else {

					count = 1;
				}

			}

			if (count > 0) {

				for (int i = 0; i < count; i++) {

					try {

						if(testDataInput.isEmpty())
						{
							if (ruleName.isEmpty()) {

								ruleID = ruleIdList.get(i);

							} else {

								ruleID = getRuleIDFromRuleName(ruleName, workspaceID, icedqRole);

							}

							BaseSuite.reportLog("==============   Creating Rule : " + (i + 1)
									+ " reference Rule ID is : " + ruleID + " ==========");

							 jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);
						}
						else
						{
							fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\DataTesting\\RuleTestData.xlsx";
							
							 rowNumber = i + 1;
							
							 jsonEntity = xl.readUsingColName(fileName, "Sheet1", rowNumber, "RuleJson");
						}

						// List<String> connectionList = createConnection(ruleType, jsonEntity,
						// workspaceID, "$.objects..connectionId", soft,icedqRole);

						DataTestingPage rule = new DataTestingPage(driver);

						// rule.clickOnNextGenMenuTab("Data Testing");

						// addSubscription(auto, workspaceID);

						param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

						//verifyDataTestingLandingPage();

						// clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleName,icedqRole);

						enterDetailsInAddNewPaneAPI(param, workspaceID, param.getRuleName(), icedqRole,ruleCreateFolder);

						validationcheckforvisibility(param);

						enterDetailsInOverviewSection(param,sourceSingleConnection);

						enterDetailsInAdvancedSettingOfOverviewSection(param);

						if (!param.getRuleType().equalsIgnoreCase("Script")) {

							sourceQuery = enterDetailsInSourceSetting(jsonEntity, param, sourceSingleConnection,
									workspaceID, icedqRole,changeQueryConn, soft);
							
							if(param.getSourceConnType().equalsIgnoreCase("File"))
							{
								BaseSuite.reportLog("Clicking on source tab to validate the table column");
								
								Thread.sleep(4000);
								
								javascript(driver, "arguments[0].scrollIntoView(true);", fileSourceSourceButton);
								
								displayAndClick(driver, fileSourceSourceButton);
								
								displayAndClick(driver, fileSourceSourceButton);
								
								BaseSuite.validationReportLog("Source tab clicked successfully to validate the table column");
							}

							//validateSourceColumnNameNColumnDataType(jsonEntity,sourceTable,sourceColName,sourceDataType);;
						}
						
						xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

						switch (param.getRuleType().toLowerCase()) {

						case "checksum":

							targetQuery = enterDetailsInTargetDataset(jsonEntity, param, targetSingleConnection,
									workspaceID, icedqRole,changeQueryConn, soft);
							
							if(param.getTargetConnType().equalsIgnoreCase("File"))
							{
								BaseSuite.reportLog("Clicking on source tab to validate the table column");
								
								Thread.sleep(4000);
								
								javascript(driver, "arguments[0].scrollIntoView(true);", fileTargetTargetButton);
								
								displayAndClick(driver, fileTargetTargetButton);
								
								displayAndClick(driver, fileTargetTargetButton);
								
								BaseSuite.validationReportLog("Source tab clicked successfully to validate the table column");
							}

							//validateTargetColumnNameNColumnDataType(jsonEntity,targetTable,targetColName,targetDataType);;

							DataTestingParameters chkParam = setChecksParametersUsingApi(jsonEntity,
									param.getRuleType(), 0);

							clickOnCheckNode1();

							validateChecksumDefaultExpression(chkParam, soft, jsonEntity, icedqRole, workspaceID,
									sourceQuery, targetQuery, param.getRuleType());

							break;

						case "recon":
						case "ht recon":

							targetQuery = enterDetailsInTargetDataset(jsonEntity, param, targetSingleConnection,
									workspaceID, icedqRole, changeQueryConn, soft);
							

							if(param.getTargetConnType().equalsIgnoreCase("File"))
							{
								BaseSuite.reportLog("Clicking on source tab to validate the table column");
								
								Thread.sleep(4000);
								
								javascript(driver, "arguments[0].scrollIntoView(true);", fileTargetTargetButton);
								
								displayAndClick(driver, fileTargetTargetButton);
								
								displayAndClick(driver, fileTargetTargetButton);
								
								BaseSuite.validationReportLog("Source tab clicked successfully to validate the table column");
							}

							//validateTargetColumnNameNColumnDataType(jsonEntity,targetTable,targetColName,targetDataType);;


							ArrayList<String> sourceJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[2].configuration.joins..sourceKey");

							ArrayList<String> targetJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[2].configuration.joins..targetKey");

							for (int j = 0; j < sourceJoin.size(); j++) {

								addJoins(j, sourceJoin.get(j), targetJoin.get(j));
							}

							clickOnCheckNode1();

							verifyVisibilityOfButtons(driver, chk_addButton_SideMenuBtn, "Add Button", true);
							
							selectResultType(param, jsonEntity);

							addChecksToRule(param, jsonEntity, icedqRole, workspaceID, sourceQuery, targetQuery);

							ArrayList<String> checksdetails = getCheckDetailsFromCheckSection();

							clickOnExceptionReportNode();

							validateExceptionReportTab(param.getRuleType());

							selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

							flag = enableStoreFailureAndErrorsOnly(param.getRuleType(), xrparam.getStoreFailureAndErrors(), soft);

							expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

							selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

							// validateResultTypeOnExceptionReport(jsonEntity,"$.objects[3].configuration.checks[0].expression.values.*");

							validateExpression(checksdetails, exceptionReportCheckList);

							break;

						case "validation":
						case "ht validation":

							
							clickOnCheckNode1();
							
							verifyVisibilityOfButtons(driver, chk_addButton_SideMenuBtn, "Add Button", true);
							
							selectResultType(param, jsonEntity);

							addChecksToRule(param, jsonEntity, icedqRole, workspaceID, sourceQuery, targetQuery);

							ArrayList<String> checksdetails1 = getCheckDetailsFromCheckSection();

							clickOnExceptionReportNode();

							validateExceptionReportTab(param.getRuleType());

							selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

							flag = enableStoreFailureAndErrorsOnly(param.getRuleType(), xrparam.getStoreFailureAndErrors(), soft);

							expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

							selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

							// validateResultTypeOnExceptionReport(jsonEntity,"$.objects[1].configuration.checks[0].expression.values.*");

							validateExpression(checksdetails1, exceptionReportCheckList);

							break;

						case "script":

							param = setScriptRuleParametersForApi(jsonEntity, "1");
							
							String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[?(@.id=='Script')].configuration.script");

							enterScriptOfScriptRule(scriptValue);

							ArrayList<String> connVarList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									jsonEntity, "$.objects[?(@.id=='Variable')].configuration.variables..name");

							for (int a = 0; a < connVarList.size(); a++) {

								DataTestingParameters scparam = setScriptRuleParametersForApi(jsonEntity,
										Integer.toString(a));

								clickOnAddConnectionButtonInScriptObject();

								enterConnectionVariableName(scparam.getScriptConnVarName());

								String conId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[?(@.id=='Variable')].configuration.variables[" + a
												+ "].properties.connectionId");

								String json = TestDataThroughApi.getConnectionJsonEntity(workspaceID, conId, icedqRole);

								String connName = TestDataThroughApi.getConnectionNmae(json);

								selectConnectionInScriptObject(scparam.getScriptConnVarName(), connName);

								String msg = testButton(returnElement(connVarTestButton, connDynamicVar,
										scparam.getScriptConnVarName()));

							}

							break;

						case "pushdown":

							clickOnCheckNode1();

							selectResultType(param, jsonEntity);

							ArrayList<String> checksdetails2 = getCheckDetailsFromCheckSection();

							List<WebElement> checkList = getElements(driver, pushdownCheckList);

							if (checkList.size() > 0) {
								BaseSuite.validationReportLog(
										"FYI column list is display on check section for pushdown rule");
							} else {
								BaseSuite.reportFailLog(
										"FYI column list is not display on check section for pushdown rule", "");
							}

							clickOnExceptionReportNode();

							validateExceptionReportTab(param.getRuleType());

							selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

							flag = enableStoreFailureAndErrorsOnly(param.getRuleType(), xrparam.getStoreFailureAndErrors(), soft);

							expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

							selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

							validateExpression(checksdetails2, exceptionReportCheckList);

							break;

						default:

							BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

							break;
						}

						if (!param.getRuleType().equalsIgnoreCase("Script")) {
							
							summaryVariable(param, jsonEntity);
						}

						clickONSaveRuleOption(jsonEntity);

						//addSubscription(ruleID, workspaceID, icedqRole);
						
						boolean runStatus = clickOnRunButton(jsonEntity);

						if (runStatus) {

							clickOnRecentRunButton();

							clickOnRecentRunTabRefreshIcon();

							Thread.sleep(3000);

							if (isDisplayed(driver, recentrun_latest_instanceId)) {
								
								String statusOfRule;

								String state;

								String executedRuleJsonEntity;

								String ruleInstanceId;

								 String workflowInstanceId = getWorkflowInstanceID(workspaceID, icedqRole,ruleID);

								do {

									clickOnRecentRunTabRefreshIcon();

									isDisplayed(driver, recentrun_latest_statusofrule);

									Thread.sleep(2000);

									statusOfRule = getText(driver, recentrun_latest_statusofrule);

									isDisplayed(driver, recentrun_latest_instanceId);

								} while ((statusOfRule.equalsIgnoreCase("running"))
										|| (statusOfRule.equalsIgnoreCase("submitted")));

								ruleInstanceId = getRuleInstanceID(workspaceID, icedqRole, workflowInstanceId);

								executedRuleJsonEntity = exceptionJsonbody(ruleInstanceId, workspaceID, icedqRole);

								state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
										"$.items[0].instanceSummary.state");

								if (!state.equalsIgnoreCase("COMPLETED")) {
									do {
										executedRuleJsonEntity = exceptionJsonbody(ruleInstanceId, workspaceID,
												icedqRole);

										state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity, "$.items[0].instanceSummary.state");

									} while (!state.equalsIgnoreCase("COMPLETED"));
								}

								String expectedSourceCount = null;

								String expectedTargetCount = null;

								String expectedExitCode;

								if (!param.getRuleType().equalsIgnoreCase("Script")) {
									expectedSourceCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.sourceCount");

									expectedTargetCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.targetCount");

								}

								if (param.getRuleType().equalsIgnoreCase("Script")
										|| param.getRuleType().equalsIgnoreCase("Pushdown")) {
									expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].exitCode");

								} else {
									if (param.getRuleType().equalsIgnoreCase("Checksum")) {
										expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity,
												"$.items[0].instanceSummary.metrics.totalErrorCount");
									} else {

										expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity, "$.items[0].exitCode");
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

								String ruleId = getText(driver,
										returnElement(ruleIdText, "$name", param.getRuleName()));

								ruleId = ruleId.replaceAll("[\\[\\](){}]", "");

								if (!(param.getRuleType().equalsIgnoreCase("checksum")
										|| param.getRuleType().equalsIgnoreCase("Script"))) {

									if (xrparam.getStoreFailureAndErrors().equalsIgnoreCase("True")
											&& ruleStatus.equalsIgnoreCase("success")) {
										verifyVisibilityOfButtons(driver, downloadExceptionReport,
												"Download Exception Report", true);

									} else {
										downloadExceptionReport(createdRuleInstanceID,
												xrparam.getStoreFailureAndErrors(), xrparam.getExceptionReportFormat(),
												ruleId);
									}
								}

								if (!(param.getRuleType().equalsIgnoreCase("checksum")
										|| param.getRuleType().equalsIgnoreCase("script"))) {

									checkExceptionSummary(createdRuleInstanceID, ruleId, executedRuleJsonEntity,
											xrparam.getExceptionReportFormat(), workspaceID, "Download All", soft,
											icedqRole, expoertedFileFlag, flag, ruleStatus, sourceCount, targetCount,
											exitCode);

								}

							} else {
								BaseSuite.skipReportLog(
										"Rule :" + ruleIdList.get(i) + " instance id not generated kindly check , ");

							}

						}

						else {

							BaseSuite.skipReportLog("Rule :" + ruleIdList.get(i) + " not able to run kindly check , ");

						}

					}

					catch (InterruptedException e) {

						System.out.println("Log " + ruleIdList.get(i) + " *** \n" + e.getMessage());
						BaseSuite.skipReportLog("Rule :" + ruleIdList.get(i)
								+ " not created successfully kindly check , " + e.getMessage());

					} finally {
						
						clickOnDataTestingSubMobuleName("Rules");
						// clickOnNextGenMenuTab("Connections");

					}
				}
			} else {
				BaseSuite.skipReportLog("No Rules Found inside workspace , ID : " + workspaceID);
			}

		} catch (Exception e) {

			e.getMessage();
		} finally {

		}
	}
	
	public void executeRuleFuntionalityCheck(String workspaceID,String folderId, String icedqRole,SoftAssert soft)
	{
		
		try {
			
			DataTestingParameters param = null;
			
			DataTestingParameters xrparam = null;
			
			List<String> ruleIdList = null;
			
			String jsonEntity;
			
			String ruleID;
			
			int count;
			
			ruleIdList = getRuleListFromSpecificFolder(folderId, workspaceID, icedqRole);

			count = ruleIdList.size();
			
			if (count > 0) {

				for (int i = 0; i < count; i++) {

					ruleID = ruleIdList.get(i);

					BaseSuite.reportLog("==============   Creating Rule : " + (i + 1) + " reference Rule ID is : "
							+ ruleID + " ==========");

					jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

					boolean runStatus = clickOnRunButton(jsonEntity);

					if (runStatus) {

						clickOnRecentRunButton();

						String statusOfRule;

						String state;

						String executedRuleJsonEntity;

						String ruleInstanceId;

						String workflowInstanceId = getWorkflowInstanceID(workspaceID, icedqRole, ruleID);

						do {

							clickOnRecentRunTabRefreshIcon();

							isDisplayed(driver, recentrun_latest_statusofrule);

							statusOfRule = getText(driver, recentrun_latest_statusofrule);

							isDisplayed(driver, recentrun_latest_instanceId);

						} while ((statusOfRule.equalsIgnoreCase("running"))
								|| (statusOfRule.equalsIgnoreCase("submitted")));

						ruleInstanceId = getRuleInstanceID(workspaceID, icedqRole, workflowInstanceId);

						executedRuleJsonEntity = exceptionJsonbody(ruleInstanceId, workspaceID, icedqRole);

						state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
								"$.items[0].instanceSummary.state");

						if (!state.equalsIgnoreCase("COMPLETED")) {
							do {
								executedRuleJsonEntity = exceptionJsonbody(ruleInstanceId, workspaceID, icedqRole);

								state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
										"$.items[0].instanceSummary.state");

							} while (!state.equalsIgnoreCase("COMPLETED"));
						}

						String expectedSourceCount = null;

						String expectedTargetCount = null;

						String expectedExitCode;

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

						if (!(param.getRuleType().equalsIgnoreCase("checksum")
								|| param.getRuleType().equalsIgnoreCase("Script"))) {

							if (xrparam.getStoreFailureAndErrors().equalsIgnoreCase("True")
									&& ruleStatus.equalsIgnoreCase("success")) {
								verifyVisibilityOfButtons(driver, downloadExceptionReport, "Download Exception Report",
										true);

							} else {
								/*
								 * downloadExceptionReport(createdRuleInstanceID,
								 * xrparam.getStoreFailureAndErrors(), "xlsx", BaseSuite.WorkspaceID,
								 * icedqRole);
								 */
							}
						}

						if (!(param.getRuleType().equalsIgnoreCase("checksum")
								|| param.getRuleType().equalsIgnoreCase("script"))) {

							/*
							 * checkExceptionSummary(createdRuleInstanceID, executedRuleJsonEntity, "xlsx",
							 * workspaceID, "Download All", soft, icedqRole, "", "", ruleStatus,
							 * sourceCount, targetCount, exitCode);
							 */

						}

					}

					else {

						BaseSuite.skipReportLog("Rule :" + ruleIdList.get(i) + " not able to run kindly check , ");

					}

				}
			}
			
		} catch (Exception e) {

			e.getMessage();
		} 
		
	}
	
	// Main method
		public void createRuleUsingExcel(String folderId,String ruleCreateFolder,String ruleType,String ruleName,
				String icedqRole, String sourceSingleConnection, String targetSingleConnection,String changeQueryConn, SoftAssert soft)
				throws Throwable {

			boolean flag = false;

			boolean expoertedFileFlag = false;
			
			XLUtils xl = new XLUtils();
			
			String ruleWorkspaceId = null;
			try {
				
				DataTestingParameters xrparam = new DataTestingParameters();
				
				DataTestingParameters param = new DataTestingParameters();
				
				int rowNumber = 0;
				
				String fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\DataTesting\\UpdateRuleFunctionality.xlsx";
				
				int count  = xl.getRowCount(fileName, "UpdateRule");

				if (count > 0) {

					for (int i = 0; i < count; i++) {

						try {

							rowNumber = i + 1;
							
							String jsonEntity = xl.readUsingColName(fileName, "UpdateRule", rowNumber, "jsonEntity");

							BaseSuite.reportLog("==============   Creating Rule : " + (rowNumber) +" ==========");

							ruleWorkspaceId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, workspaceId);

							param = setRuleParametersForApi(ruleWorkspaceId, jsonEntity, icedqRole);

							enterDetailsInAddNewPaneAPI(param, ruleWorkspaceId, param.getRuleName(), icedqRole,ruleCreateFolder);

							validationcheckforvisibility(param);

							enterDetailsInOverviewSection(param,sourceSingleConnection);

							enterDetailsInAdvancedSettingOfOverviewSection(param);

							if (!param.getRuleType().equalsIgnoreCase("Script")) {

								enterDetailsInSourceSetting(jsonEntity, param, "",
										ruleWorkspaceId, icedqRole, changeQueryConn, soft);

								validateSourceColumnNameNColumnDataType(jsonEntity,sourceTable,sourceColName,sourceDataType);;
							}
							
							xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

							switch (param.getRuleType().toLowerCase()) {

							case "checksum":

								enterDetailsInTargetDataset(jsonEntity, param, "",
										ruleWorkspaceId, icedqRole, changeQueryConn, soft);

								validateTargetColumnNameNColumnDataType(jsonEntity,targetTable,targetColName,targetDataType);;

								DataTestingParameters chkParam = setChecksParametersUsingApi(jsonEntity,
										param.getRuleType(), 0);

								clickOnCheckNode1();

								validateChecksumDefaultExpression(chkParam, soft, jsonEntity, icedqRole, ruleWorkspaceId,
										 param.getSourceQuery(), param.getTargetQuery(), param.getRuleType());

								break;

							case "recon":
							case "ht recon":

								enterDetailsInTargetDataset(jsonEntity, param, "",
										ruleWorkspaceId, icedqRole, changeQueryConn, soft);

								validateTargetColumnNameNColumnDataType(jsonEntity,targetTable,targetColName,targetDataType);;


								ArrayList<String> sourceJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[2].configuration.joins..sourceKey");

								ArrayList<String> targetJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[2].configuration.joins..targetKey");

								for (int j = 0; j < sourceJoin.size(); j++) {

									addJoins(j, sourceJoin.get(j), targetJoin.get(j));
								}

								clickOnCheckNode1();

								selectResultType(param, jsonEntity);

								addChecksToRule(param, jsonEntity, icedqRole, ruleWorkspaceId, param.getSourceQuery(), param.getTargetQuery());

								ArrayList<String> checksdetails = getCheckDetailsFromCheckSection();

								clickOnExceptionReportNode();

								validateExceptionReportTab(param.getRuleType());

								selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

								flag = enableStoreFailureAndErrorsOnly(param.getRuleType(), xrparam.getStoreFailureAndErrors(), soft);

								expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

								selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

								// validateResultTypeOnExceptionReport(jsonEntity,"$.objects[3].configuration.checks[0].expression.values.*");

								validateExpression(checksdetails, exceptionReportCheckList);

								break;

							case "validation":
							case "ht validation":

								clickOnCheckNode1();

								selectResultType(param, jsonEntity);

								addChecksToRule(param, jsonEntity, icedqRole, ruleWorkspaceId, param.getSourceQuery(), param.getTargetQuery());

								ArrayList<String> checksdetails1 = getCheckDetailsFromCheckSection();

								clickOnExceptionReportNode();

								validateExceptionReportTab(param.getRuleType());

								selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

								flag = enableStoreFailureAndErrorsOnly(param.getRuleType(), xrparam.getStoreFailureAndErrors(), soft);

								expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

								selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

								// validateResultTypeOnExceptionReport(jsonEntity,"$.objects[1].configuration.checks[0].expression.values.*");

								validateExpression(checksdetails1, exceptionReportCheckList);

								break;

							case "script":

								param = setScriptRuleParametersForApi(jsonEntity, "1");
								
								String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[?(@.id=='Script')].configuration.script");

								enterScriptOfScriptRule(scriptValue);

								ArrayList<String> connVarList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
										jsonEntity, "$.objects[?(@.id=='Variable')].configuration.variables..name");

								for (int a = 0; a < connVarList.size(); a++) {

									DataTestingParameters scparam = setScriptRuleParametersForApi(jsonEntity,
											Integer.toString(a));

									clickOnAddConnectionButtonInScriptObject();

									enterConnectionVariableName(scparam.getScriptConnVarName());

									String conId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
											"$.objects[?(@.id=='Variable')].configuration.variables[" + a
													+ "].properties.connectionId");

									String json = TestDataThroughApi.getConnectionJsonEntity(ruleWorkspaceId, conId, icedqRole);

									String connName = TestDataThroughApi.getConnectionNmae(json);

									selectConnectionInScriptObject(scparam.getScriptConnVarName(), connName);

									String msg = testButton(returnElement(connVarTestButton, connDynamicVar,
											scparam.getScriptConnVarName()));

								}

								break;

							case "pushdown":

								clickOnCheckNode1();

								selectResultType(param, jsonEntity);

								ArrayList<String> checksdetails2 = getCheckDetailsFromCheckSection();

								List<WebElement> checkList = getElements(driver, pushdownCheckList);

								if (checkList.size() > 0) {
									BaseSuite.validationReportLog(
											"FYI column list is display on check section for pushdown rule");
								} else {
									BaseSuite.reportFailLog(
											"FYI column list is not display on check section for pushdown rule", "");
								}

								clickOnExceptionReportNode();

								validateExceptionReportTab(param.getRuleType());

								selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

								flag = enableStoreFailureAndErrorsOnly(param.getRuleType(), xrparam.getStoreFailureAndErrors(), soft);

								expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

								selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

								validateExpression(checksdetails2, exceptionReportCheckList);

								break;

							default:

								BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

								break;
							}

							if (!param.getRuleType().equalsIgnoreCase("Script")) {
								summaryVariable(param, jsonEntity);
							}

							clickONSaveRuleOption(jsonEntity);

							//addSubscription(ruleID, workspaceID, icedqRole);
							
							boolean runStatus = clickOnRunButton(jsonEntity);

							if (runStatus) {

								clickOnRecentRunButton();

								String statusOfRule;

								String state;

								String executedRuleJsonEntity;
								
								//String ruleID = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.id");

								//String ruleInstanceId = getRuleInstanceID(ruleWorkspaceId, icedqRole, ruleID);

								//int instanceId = Integer.parseInt(ruleInstanceId);

								//int val1 = instanceId + 1;

								do {
									clickOnRecentRunTabRefreshIcon();

									isDisplayed(driver,recentrun_latest_statusofrule);
									
									statusOfRule = getText(driver, recentrun_latest_statusofrule);

									isDisplayed(driver,recentrun_latest_instanceId);

									executedRuleJsonEntity = xl.readUsingColName(fileName, "UpdateRule", rowNumber, "executedRuleJsonEntity");

									state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(executedRuleJsonEntity,
											"$.items[0].instanceSummary.state");

								} while ((statusOfRule.equalsIgnoreCase("running"))
										|| (statusOfRule.equalsIgnoreCase("submitted")));

								if (!state.equalsIgnoreCase("COMPLETED")) {
									do {

										state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity, "$.items[0].instanceSummary.state");

									} while (!state.equalsIgnoreCase("COMPLETED"));
								}
								
								String expectedSourceCount = null;
								
								String expectedTargetCount = null;
								
								String expectedExitCode;
								
								if(!param.getRuleType().equalsIgnoreCase("Script"))
								{
									 expectedSourceCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.sourceCount");

									 expectedTargetCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.targetCount");

								}
							
								if(param.getRuleType().equalsIgnoreCase("Script") || param.getRuleType().equalsIgnoreCase("Pushdown"))
								{
									expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].exitCode");
									
								}
								else
								{
									if(param.getRuleType().equalsIgnoreCase("Checksum"))
									{
										expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity, "$.items[0].instanceSummary.metrics.totalErrorCount");
									}
									else
									{
										
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


								if (!(param.getRuleType().equalsIgnoreCase("checksum") || param.getRuleType().equalsIgnoreCase("Script"))) {

									if (xrparam.getStoreFailureAndErrors().equalsIgnoreCase("True")
											&& ruleStatus.equalsIgnoreCase("success")) {
										verifyVisibilityOfButtons(driver, downloadExceptionReport,
												"Download Exception Report", true);

									} else {
										downloadExceptionReport(createdRuleInstanceID, xrparam.getStoreFailureAndErrors(),
												"xlsx", ruleId);
									}
								}

								if (!(param.getRuleType().equalsIgnoreCase("checksum") || param.getRuleType().equalsIgnoreCase("script"))) {

									TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, ruleWorkspaceId);
									
									checkExceptionSummary(createdRuleInstanceID,ruleId, createdRuleInstanceID, "xlsx", ruleWorkspaceId,
											"Download All", soft, icedqRole, expoertedFileFlag, flag, ruleStatus,
											sourceCount, targetCount, exitCode);

								}

							}

							else {

								BaseSuite.skipReportLog("Rule :" + param.getRuleName() + " not able to run kindly check , ");

							}

						}

						catch (Exception e) {

							System.out.println("Log " + param.getRuleName() + " *** \n" + e.getMessage());
							BaseSuite.skipReportLog("Rule :" + param.getRuleName()
									+ " not created successfully kindly check , " + e.getMessage());

						} finally {
							clickOnDataTestingSubMobuleName("Rules");
							// clickOnNextGenMenuTab("Connections");

						}
					}
				} else {
					BaseSuite.skipReportLog("No Rules Found inside workspace , ID : " + ruleWorkspaceId);
				}

			} catch (Exception e) {

				e.getMessage();
			} finally {

			}
		}
	
	// Main method
		public void getRuleInfoAndUpdateRule(String folderId,String workspaceID,String targetFolderId,String icedqRole,String ruleName,String sourceConnectionName,String targetConnectionName,String changeQueryConn,SoftAssert soft)
				throws Throwable {

			TestDataThroughApi testData = new TestDataThroughApi(driver);

			DataTestingParameters xrparam = null;

			DataTestingParameters param = null;

			boolean flag = false;

			boolean expoertedFileFlag = false;

			List<String> ruleIdList = null;
			
			List<String> targetRuleIdList = null;

			String ruleID;
			
			String targetRuleID;
			
			String targetRuleName = null;

			try {

				int count;
				
				int targetRuleCount;

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

						param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

						//String folderName = TestDataThroughApi.getfolderNameUsingFolderList(workspaceID,
								//param.getRuleName(), icedqRole);
						
						targetRuleIdList = testData.getRuleListFromSpecificFolder(targetFolderId, BaseSuite.WorkspaceID, icedqRole);

						targetRuleCount = ruleIdList.size();
						
						for (int j = 0; j < targetRuleCount; j++) {

							if (targetRuleCount > 0) {

								targetRuleID = targetRuleIdList.get(j);
								
								String targetJsonEntity = testData.getRuleJsonEntityUsingRuleID(BaseSuite.WorkspaceID, targetRuleID, icedqRole);

								String targetType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(targetJsonEntity, "$.ruleType");
								
								if(targetType.equals(param.getRuleType()))
								{
									targetRuleName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(targetJsonEntity, "$.name");
									
									if(i>0)
									{
										clickOnDataTestingSubMobuleName("Rules");
									}
									
									clickOnSearchedRuleNameOnDataTestingPage(targetRuleName, soft);

									break;
								}
									
							}
							
						}
						
						
						
						
						BaseSuite.reportLog("==============   Updating Rule : " + (i + 1) + " reference Rule ID is : "
								+ ruleID + " ==========");

						/// param.setRuleType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						/// ruleType));

						// String ruletype = param.getRuleType();

						// ruleWorkspaceId =
						// TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						// workspaceId);

						if (!param.getRuleType().equalsIgnoreCase("Script")) {

							param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

						} else {

							param = setScriptRuleParametersForApi(jsonEntity, "1");

						}

						// String connJsonEntity = getConnectionJsonEntity(ruleWorkspaceId,
						// param.getSourceConnectionID(), icedqRole);

						// String sourceConnectionName = getConnectionNmae(connJsonEntity);

						// String targetConnJsonEntity = getConnectionJsonEntity(ruleWorkspaceId,
						// param.getTargetConnectionID(), icedqRole);

						// String targetConnectionName = getConnectionNmae(targetConnJsonEntity);

						// String folderName =
						// TestDataThroughApi.getfolderNameUsingFolderList(ruleWorkspaceId,
						// searchRuleName, icedqRole);

						// clickOnSearchedRuleNameOnDataTestingPage(folderName,searchRuleName, soft);

						updateOverviewSection(targetRuleName, param, sourceConnectionName);

						if (!param.getRuleType().equalsIgnoreCase("Script")) {

							updateSourceDataset(param, sourceConnectionName, jsonEntity, changeQueryConn, icedqRole,
									workspaceId, soft);

							// validateSourceColumnNameNColumnDataType(jsonEntity,sourceTable,sourceColName,sourceDataType);;
						}

						xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

						switch (param.getRuleType().toLowerCase()) {

						case "checksum":

							param.setWorkspaceID(getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.workspaceId"));

							updateTargetDataset(param, targetConnectionName, jsonEntity, changeQueryConn, icedqRole,
									workspaceId, soft);

							// validateTargetColumnNameNColumnDataType(jsonEntity,targetTable,targetColName,targetDataType);;

							DataTestingParameters chkParam = setChecksParametersUsingApi(jsonEntity,
									param.getRuleType(), 0);

							clickOnCheckNode1();

							validateChecksumDefaultExpression(chkParam, soft, jsonEntity, icedqRole,
									param.getWorkspaceID(), param.getSourceQuery(), param.getTargetQuery(),
									param.getRuleType());

							break;

						case "recon":
						case "ht recon":

							updateTargetDataset(param, targetConnectionName, jsonEntity, changeQueryConn, icedqRole,
									workspaceId, soft);

							// validateTargetColumnNameNColumnDataType(jsonEntity,targetTable,targetColName,targetDataType);;

							ArrayList<String> sourceJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[2].configuration.joins..sourceKey");

							ArrayList<String> targetJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[2].configuration.joins..targetKey");

							for (int j = 0; j < sourceJoin.size(); j++) {

								updateJoins(j, sourceJoin.get(j), targetJoin.get(j));
							}

							clickOnCheckNode1();

							verifyVisibilityOfButtons(driver, chk_addButton_SideMenuBtn, "Add Button", true);

							//updateSelectResultType(jsonEntity, param.getRuleType());
							
							selectResultType(param, jsonEntity);

							updateChecksToRule(param, jsonEntity, icedqRole, workspaceId, param.getSourceQuery(),
									param.getTargetQuery());

							ArrayList<String> checksdetails = getCheckDetailsFromCheckSection();

							clickOnExceptionReportNode();

							selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

							flag = enableStoreFailureAndErrorsOnly(param.getRuleType(),
									xrparam.getStoreFailureAndErrors(), soft);

							expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

							selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

							validateExpression(checksdetails, exceptionReportCheckList);

							break;

						case "validation":
						case "ht validation":

							clickOnCheckNode1();

							verifyVisibilityOfButtons(driver, chk_addButton_SideMenuBtn, "Add Button", true);

							updateSelectResultType(jsonEntity, param.getRuleType());

							updateChecksToRule(param, jsonEntity, icedqRole, workspaceId, param.getSourceQuery(),
									param.getTargetQuery());

							ArrayList<String> checksdetails1 = getCheckDetailsFromCheckSection();

							clickOnExceptionReportNode();

							selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

							flag = enableStoreFailureAndErrorsOnly(param.getRuleType(),
									xrparam.getStoreFailureAndErrors(), soft);

							expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

							selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

							validateExpression(checksdetails1, exceptionReportCheckList);

							break;

						case "script":

							String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
									"$.objects[?(@.id=='Script')].configuration.script");

							enterScriptOfScriptRule(scriptValue);

							ArrayList<String> connVarList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
									jsonEntity, "$.objects[?(@.id=='Variable')].configuration.variables..name");

							for (int a = 0; a < connVarList.size(); a++) {

								DataTestingParameters scparam = setScriptRuleParametersForApi(jsonEntity,
										Integer.toString(a));

								String val = connVarList.get(i);

								displayAndClick(driver, connectionTabOnScript);

								Thread.sleep(2000);

								List<WebElement> list = getElements(driver, By.xpath(
										"(//table[@id='scriptgrid_content_table']//following::tbody[@role='rowgroup'])[1]//tr//td[2]"));

								String ele = list.get(i).getText();

								if (val.equals(ele)) {
									i = i + 1;

									javascript(driver, "arguments[0].scrollIntoView(true);",
											By.xpath("(//button[@title='Edit'])[" + i + "]"));

									WebElement ele1 = getElement(driver,
											By.xpath("(//button[@title='Edit'])[" + i + "]"));

									ele1.click();
								} else {
									clickOnAddConnectionButtonInScriptObject();

									enterConnectionVariableName(scparam.getScriptConnVarName());
								}

								String conId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[?(@.id=='Variable')].configuration.variables[" + a
												+ "].properties.connectionId");

								String json = TestDataThroughApi.getConnectionJsonEntity(workspaceId, conId, icedqRole);

								String connName = TestDataThroughApi.getConnectionNmae(json);

								selectConnectionInScriptObject(scparam.getScriptConnVarName(), connName);

								String msg = testButton(returnElement(connVarTestButton, connDynamicVar,
										scparam.getScriptConnVarName()));

							}

							break;

						case "pushdown":

							clickOnCheckNode1();

							updateSelectResultType(jsonEntity, param.getRuleType());

							ArrayList<String> checksdetails2 = getCheckDetailsFromCheckSection();

							List<WebElement> checkList = getElements(driver, pushdownCheckList);

							if (checkList.size() > 0) {
								BaseSuite.validationReportLog(
										"FYI column list is display on check section for pushdown rule");
							} else {
								BaseSuite.reportFailLog(
										"FYI column list is not display on check section for pushdown rule", "");
							}

							clickOnExceptionReportNode();

							validateExceptionReportTab(param.getRuleType());

							selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

							flag = enableStoreFailureAndErrorsOnly(param.getRuleType(),
									xrparam.getStoreFailureAndErrors(), soft);

							expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(), soft);

							selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

							validateExpression(checksdetails2, exceptionReportCheckList);

							break;

						default:

							BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

							break;
						}

						if (!param.getRuleType().equalsIgnoreCase("Script")) {

							summaryVariable(param, jsonEntity);
						}

						clickONSaveRuleOption(jsonEntity);

						// addSubscription(ruleID, workspaceID, icedqRole);

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

							executedRuleJsonEntity = exceptionJsonbody(instanceId, BaseSuite.WorkspaceID, icedqRole);

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
								expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
										executedRuleJsonEntity, "$.items[0].exitCode");

							} else {
								if (param.getRuleType().equalsIgnoreCase("Checksum")) {
									expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity,
											"$.items[0].instanceSummary.metrics.totalErrorCount");
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
									verifyVisibilityOfButtons(driver, downloadExceptionReport,
											"Download Exception Report", true);

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

							BaseSuite
									.skipReportLog("Rule :" + param.getRuleName() + " not able to run kindly check , ");

						}

					}

				}
			}

			catch (Exception e) {

				System.out.println("Log " + param.getRuleName() + " *** \n" + e.getMessage());
				BaseSuite.skipReportLog(
						"Rule :" + param.getRuleName() + " not created successfully kindly check , " + e.getMessage());

			} finally {
				clickOnDataTestingSubMobuleName("Rules");
				// clickOnNextGenMenuTab("Connections");

			}

		}


		
	
	// Main method
		public void getRuleInfoAndCreateRuleForVaultFun(String workspaceID,String ruleCreateFolder,
				String icedqRole, String connName,String schema,String table,int rowNumber,String changeQueryConn,SoftAssert soft)
				throws Throwable {

			boolean flag = false;

			boolean expoertedFileFlag = false;
			
			//String ruleName = null;
			try {
				
				
				//String folderId = getfolderIdFromRuleList(workspaceID,ruleName,icedqRole);
				DataTestingParameters xrparam = null;
				
				DataTestingParameters param = null;
				
				XLUtils xl = new XLUtils();
			
				String ruleID;
				
				String sourceQuery = null;
				
				String targetQuery = null;
				
				String fileName = System.getProperty("user.dir") + Constant.CONNECTIONRULEVAULTDETAILS;
				
				String name = xl.readUsingColName(fileName, "Sheet1", rowNumber, "RuleName");
				
				String[] expVal = name.split(",");

				int count = expVal.length;

				for (int colNum = 0; colNum < count; colNum++) {

					String resultName = expVal[colNum];

					if (!name.isEmpty()) {

						try {

							ruleID = getRuleIDFromRuleName(resultName, workspaceID, icedqRole);

							BaseSuite.reportLog("==============   Creating Rule : " + (rowNumber + 1)
									+ " reference Rule ID is : " + ruleID + " ==========");

							String jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);

							// List<String> connectionList = createConnection(ruleType, jsonEntity,
							// workspaceID, "$.objects..connectionId", soft,icedqRole);

							DataTestingPage rule = new DataTestingPage(driver);

							// rule.clickOnNextGenMenuTab("Data Testing");

							// addSubscription(auto, workspaceID);

							if (!resultName.contains("Script")) {

								param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

							} else {

								param = setScriptRuleParametersForApi(jsonEntity, "1");

							}

							// verifyDataTestingLandingPage();

							// clickOnAddNewFolderOrExistingOneAPI(param,workspaceID,ruleName,icedqRole);

							enterDetailsInAddNewPaneAPI(param, workspaceID, param.getRuleName(), icedqRole,ruleCreateFolder);

							validationcheckforvisibility(param);

							enterDetailsInOverviewSection(param,connName);

							enterDetailsInAdvancedSettingOfOverviewSection(param);

							if (!param.getRuleType().equalsIgnoreCase("Script")) {

								sourceQuery = enterDetailsInSourceSettingForVault(jsonEntity, param, connName, schema,
										table,changeQueryConn);

								validateSourceColumnNameNColumnDataType(jsonEntity, sourceTable, sourceColName,
										sourceDataType);
								;
							}

							xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

							switch (param.getRuleType().toLowerCase()) {

							case "checksum":

								targetQuery = enterDetailsInTargetDatasetForVault(jsonEntity, param, connName, schema,
										table, changeQueryConn);

								validateTargetColumnNameNColumnDataType(jsonEntity, targetTable, targetColName,
										targetDataType);

								DataTestingParameters chkParam = setChecksParametersUsingApi(jsonEntity,
										param.getRuleType(), 0);

								clickOnCheckNode1();

								validateChecksumDefaultExpression(chkParam, soft, jsonEntity, icedqRole, workspaceID,
										sourceQuery, targetQuery, param.getRuleType());

								break;

							case "recon":
							case "ht recon":

								targetQuery = enterDetailsInTargetDatasetForVault(jsonEntity, param, connName, schema,
										table,changeQueryConn);

								validateTargetColumnNameNColumnDataType(jsonEntity, targetTable, targetColName,
										targetDataType);
								;

								ArrayList<String> sourceJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[2].configuration.joins..sourceKey");

								ArrayList<String> targetJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[2].configuration.joins..targetKey");

								for (int j = 0; j < sourceJoin.size(); j++) {

									addJoins(j, sourceJoin.get(j), targetJoin.get(j));
								}

								clickOnCheckNode1();

								selectResultType(param, jsonEntity);

								addChecksToRule(param, jsonEntity, icedqRole, workspaceID, sourceQuery, targetQuery);

								ArrayList<String> checksdetails = getCheckDetailsFromCheckSection();

								clickOnExceptionReportNode();

								validateExceptionReportTab(param.getRuleType());

								selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

								flag = enableStoreFailureAndErrorsOnly(param.getRuleType(),
										xrparam.getStoreFailureAndErrors(), soft);

								expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(),
										soft);

								selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

								// validateResultTypeOnExceptionReport(jsonEntity,"$.objects[3].configuration.checks[0].expression.values.*");

								validateExpression(checksdetails, exceptionReportCheckList);

								break;

							case "validation":
							case "ht validation":

								clickOnCheckNode1();

								selectResultType(param, jsonEntity);

								addChecksToRule(param, jsonEntity, icedqRole, workspaceID, sourceQuery, targetQuery);

								ArrayList<String> checksdetails1 = getCheckDetailsFromCheckSection();

								clickOnExceptionReportNode();

								validateExceptionReportTab(param.getRuleType());

								selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

								flag = enableStoreFailureAndErrorsOnly(param.getRuleType(),
										xrparam.getStoreFailureAndErrors(), soft);

								expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(),
										soft);

								selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

								// validateResultTypeOnExceptionReport(jsonEntity,"$.objects[1].configuration.checks[0].expression.values.*");

								validateExpression(checksdetails1, exceptionReportCheckList);

								break;

							case "script":

								String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
										"$.objects[?(@.id=='Script')].configuration.script");

								enterScriptOfScriptRule(scriptValue);

								ArrayList<String> connVarList = TestDataThroughApi
										.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
												"$.objects[?(@.id=='Variable')].configuration.variables..name");

								for (int a = 0; a < connVarList.size(); a++) {

									DataTestingParameters scparam = setScriptRuleParametersForApi(jsonEntity,
											Integer.toString(a));

									clickOnAddConnectionButtonInScriptObject();

									enterConnectionVariableName(scparam.getScriptConnVarName());

									String conId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
											"$.objects[?(@.id=='Variable')].configuration.variables[" + a
													+ "].properties.connectionId");

									String json = TestDataThroughApi.getConnectionJsonEntity(workspaceID, conId,
											icedqRole);

									String connName1 = TestDataThroughApi.getConnectionNmae(json);

									selectConnectionInScriptObject(scparam.getScriptConnVarName(), connName1);

									String msg = testButton(returnElement(connVarTestButton, connDynamicVar,
											scparam.getScriptConnVarName()));

								}

								break;

							case "pushdown":

								clickOnCheckNode1();

								selectResultType(param, jsonEntity);

								ArrayList<String> checksdetails2 = getCheckDetailsFromCheckSection();

								List<WebElement> checkList = getElements(driver, pushdownCheckList);

								if (checkList.size() > 0) {
									BaseSuite.validationReportLog(
											"FYI column list is display on check section for pushdown rule");
								} else {
									BaseSuite.reportFailLog(
											"FYI column list is not display on check section for pushdown rule", "");
								}

								clickOnExceptionReportNode();

								validateExceptionReportTab(param.getRuleType());

								selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

								flag = enableStoreFailureAndErrorsOnly(param.getRuleType(),
										xrparam.getStoreFailureAndErrors(), soft);

								expoertedFileFlag = enableStoreExportedFileOnly(xrparam.getStoreExportedFileOnly(),
										soft);

								selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

								validateExpression(checksdetails2, exceptionReportCheckList);

								break;

							default:

								BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

								break;
							}

							if (!param.getRuleType().equalsIgnoreCase("Script")) {
								summaryVariable(param, jsonEntity);
							}

							clickONSaveRuleOption(jsonEntity);

							addSubscription(ruleID, workspaceID, icedqRole);

							boolean runStatus = clickOnRunButton(jsonEntity);

							if (runStatus) {

								clickOnRecentRunButton();

								String statusOfRule;

								String state = null;

								String executedRuleJsonEntity = null;

								String ruleInstanceId = getWorkflowInstanceID(workspaceID, icedqRole, ruleID);

								int instanceId = Integer.parseInt(ruleInstanceId);

								int val1 = instanceId + 1;

								long timer = System.currentTimeMillis();

								long finalStartTime = TimeUnit.MILLISECONDS.toSeconds(timer);

								boolean isRunning = true;

								do {
									clickOnRecentRunTabRefreshIcon();

									isDisplayed(driver,recentrun_latest_statusofrule);

									statusOfRule = getText(driver, recentrun_latest_statusofrule);

									isDisplayed(driver,recentrun_latest_instanceId);

									executedRuleJsonEntity = exceptionJsonbody(String.valueOf(val1), workspaceID,
											icedqRole);

									state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
											executedRuleJsonEntity, "$.items[0].instanceSummary.state");

									long endTime = System.currentTimeMillis();

									long finalEndTime = TimeUnit.MILLISECONDS.toSeconds(endTime);

									long calculateTime = finalEndTime - finalStartTime;

									if (calculateTime > 100) {
										
										BaseSuite.otherReportLog("Rule is in Running/Submmitted state,Kindly check");

										isRunning = false;

										break;

									}

								} while ((statusOfRule.equalsIgnoreCase("running"))
										|| (statusOfRule.equalsIgnoreCase("submitted")));
							
								if (isRunning)

								{

									if (!state.equalsIgnoreCase("COMPLETED")) {
										do {
											executedRuleJsonEntity = exceptionJsonbody(String.valueOf(val1),
													workspaceID, icedqRole);

											state = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
													executedRuleJsonEntity, "$.items[0].instanceSummary.state");

										} while (!state.equalsIgnoreCase("COMPLETED"));
									}

									String expectedSourceCount = null;

									String expectedTargetCount = null;

									String expectedExitCode;

									if (!param.getRuleType().equalsIgnoreCase("Script")) {
										expectedSourceCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity,
												"$.items[0].instanceSummary.metrics.sourceCount");

										expectedTargetCount = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity,
												"$.items[0].instanceSummary.metrics.targetCount");

									}

									if (param.getRuleType().equalsIgnoreCase("Script")
											|| param.getRuleType().equalsIgnoreCase("Pushdown")) {
										expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
												executedRuleJsonEntity, "$.items[0].exitCode");

									} else {

										if (param.getRuleType().equalsIgnoreCase("Checksum")) {
											expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
													executedRuleJsonEntity,
													"$.items[0].instanceSummary.metrics.totalErrorCount");
										} else {

											expectedExitCode = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(
													executedRuleJsonEntity,
													"$.items[0].instanceSummary.metrics.totalCount");
										}
									}

									ArrayList<String> ruleInstanceDetailList = checkStatusOfRunningRule(
											param.getRuleType(), expectedSourceCount, expectedTargetCount,
											expectedExitCode);

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
											verifyVisibilityOfButtons(driver, downloadExceptionReport,
													"Download Exception Report", true);

										} else {
											downloadExceptionReport(createdRuleInstanceID,
													xrparam.getStoreFailureAndErrors(), "xlsx",ruleId );
										}
									}

									if (!(param.getRuleType().equalsIgnoreCase("checksum")
											|| param.getRuleType().equalsIgnoreCase("script"))) {

										checkExceptionSummary(createdRuleInstanceID,ruleId, String.valueOf(val1), "xlsx",
												workspaceID, "Download All", soft, icedqRole, expoertedFileFlag, flag,
												ruleStatus, sourceCount, targetCount, exitCode);

									}

								}

							}
							else {

								BaseSuite.skipReportLog("Rule :" + resultName + " not able to run kindly check , ");

							}

						}
						

						catch (Exception e) {

							System.out.println("Log " + resultName + " *** \n" + e.getMessage());
							BaseSuite.skipReportLog("Rule :" + resultName + " not created successfully kindly check , "
									+ e.getMessage());

						} finally {
							clickOnDataTestingSubMobuleName("Rules");
							// clickOnNextGenMenuTab("Connections");

						}

					}

					else {
						BaseSuite.skipReportLog("No Rules Found inside workspace , ID : " + workspaceID);
					}
				}

			} catch (Exception e) {

				e.getMessage();
			} finally {

			}
		}
		
		


	public static String getConnectionNmae(String jsonEntity) {
		String connName = null;
		try {
			JSONObject allIssues = new JSONObject(jsonEntity);

			connName = allIssues.getString("name");

		} catch (Exception e) {

			e.getMessage();
		}
		return connName;

	}
	
	public static String getConnectionType(String jsonEntity) {
		String connName = null;
		try {
			JSONObject allIssues = new JSONObject(jsonEntity);

			connName = allIssues.getString("connectorId");

		} catch (Exception e) {

			e.getMessage();
		}
		return connName;

	}

	public static String getConnectionJsonEntity(String workspaceid, String connID, String icedqRole) {
		String jsonEntity = null;
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			String url;

			HttpClient httpClient = HttpClientBuilder.create().build();

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				url = "http://api.icedq.net/api/v1/connections/";

			} else {
				url = "http://qa.onprem.icedq.com/api/v1/connections/";

			}

			HttpGet getRequest = new HttpGet(url + connID);

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("workspace-id", workspaceid);

			getRequest.setHeader("Authorization", "Bearer " + auto);

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

	public static String getParameterName(String workspaceID, String parameterID, String icedqRole) {
		String connName = null;
		try {

			String jsonEntity = null;

			String baseUrl;

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				baseUrl = "http://api.icedq.net/api/v1/parameters/";
			} else {
				baseUrl = "http://qa.onprem.icedq.com/api/v1/parameters/";
			}

			HttpGet getRequest = new HttpGet(baseUrl + parameterID);

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("workspace-id", workspaceID);

			getRequest.setHeader("Authorization", "Bearer " + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);

			// System.out.println(jsonEntity);

			JSONObject allIssues = new JSONObject(jsonEntity);

			// JSONObject obj = allIssues.getJSONObject("name");

			connName = allIssues.getString("name");

		} catch (Exception e) {

			e.getMessage();
		}
		return connName;

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

			System.out.println(jsonContent);

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

	public static ArrayList<String> getJsonArrayValueUsingJsonPathExpreesion(String jsonEntity, String expression) {
		ArrayList<String> list = new ArrayList<String>();

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {

				buider.append(line);

			}

			String jsonContent = buider.toString();

			System.out.println(jsonContent);

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			System.out.println(node.get(0));

			for (Object o : node) {

				String value1 = o.toString().replace("\"", "");

				String[] val = value1.split(",");

				int count = val.length;

				for (int colNum = 0; colNum < count; colNum++) {

					String result = val[colNum];

					list.add(result);
				}
			}

		} catch (Exception e) {

			e.getMessage();
		}

		return list;

	}

	public void verifyColumnNameOnTablePreview(String jsonEntity, String jsonExp) {

		ArrayList<String> col = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, jsonExp);

		for (int j = 0; j < col.size(); j++) {
			driver.findElements(appendOrderBy);

		}

	}

	public ArrayList<String> getCheckDetailsFromCheckSection() {

		ArrayList<String> list = new ArrayList<String>();
		try {

			List<WebElement> checks = getElements(driver, checkList);

			int count = checks.size();

			for (int i = 2; i <= count; i++) {

				List<WebElement> checkdet = getElements(driver,
						returnElement(checkDetails, "$num", Integer.toString(i)));

				for (WebElement w : checkdet) {

					list.add(w.getAttribute("textContent"));
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return list;
	}

	// exception report summary api code ::
	public String getRuleSummary(String ruleId, String icedqRole) {

		String executeruleJson = null;

		try {
			String instanceJson = getInstanceIDJson(ruleId, icedqRole);

			String workflowInstanceID = getJsonValueUsingJsonPathExpreesion(instanceJson,
					"$.items[0].workflowInstanceId");

			String ruleInstanceID = getJsonValueUsingJsonPathExpreesion(instanceJson, "$.items[0].objectInstanceId");

			String workflowID = getJsonValueUsingJsonPathExpreesion(instanceJson, "$.items[0].workflowId");

			String executeRuleID = getJsonValueUsingJsonPathExpreesion(instanceJson, "$.payload[0]..activityId");

			String workspaceID = getJsonValueUsingJsonPathExpreesion(instanceJson, "$.items[0].workspaceId");

			executeruleJson = getExecuteRuleJson(workflowInstanceID, ruleInstanceID, workflowID, executeRuleID, ruleId,
					workspaceID, icedqRole);

		} catch (Exception e) {
			e.getMessage();
		}

		return executeruleJson;
	}

	public String getInstanceIDJson(String ruleID, String icedqRole) {
		String jsonEntity = null;
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet("https://api.icedq.net/api/v1/instance/list/rule/" + ruleID);

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("Authorization", "Bearer " + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);

			System.out.println("json: \n" + jsonEntity);

		} catch (Exception e) {
			e.getMessage();
		}
		return jsonEntity;
	}

	public String getExecuteRuleJson(String workflowInstanceID, String instanceID, String workflowID,
			String executeRuleID, String ruleID, String workspaceID, String icedqRole) {

		String jsonEntity = null;
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet("https://api.icedq.net/api/v1/instance/details/" + workflowInstanceID + "/"
					+ instanceID + "/" + workflowID + "/" + executeRuleID + "/" + ruleID + "/" + workspaceID);

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("Authorization", "Bearer " + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);

			System.out.println("json: \n" + jsonEntity);

		} catch (Exception e) {
			e.getMessage();
		}
		return jsonEntity;

	}

	public static List<String> getfolderIdFromworkflowList(String workspaceID, String icedqRole) {
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			RequestBody body = RequestBody.create(mediaType,
					"{\r\n    \"filter\": [\r\n        {\r\n            \"attribute\": \"workflowType\",\r\n            \"operator\": \"In\",\r\n            \"datatype\": \"string\",\r\n            \"value\": \"Custom\"\r\n        }\r\n    ]\r\n}");

			Request request = new Request.Builder()

					.url(readconfig.workflowListApiUrl()).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceID)

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			return TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonBody, "$.items..folderId");

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	public static List<String> getfolderNamefromFolderIdList(String workspaceID, String icedqRole) {

		try {
			List<String> list = getfolderIdFromworkflowList(workspaceID, icedqRole);

			int count = list.size();

			for (int i = 0; i < count; i++) {

				String folderId = list.get(i).toString();

				String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

				HttpClient httpClient = HttpClientBuilder.create().build();

				HttpGet getRequest = new HttpGet("https://api.icedq.net/api/v1/folders/" + folderId);

				getRequest.setHeader("Content-Type", "application/json");

				getRequest.setHeader("workspace-id", workspaceID);

				getRequest.setHeader("org-id", "org-iam.icedq");

				getRequest.setHeader("Authorization", "Bearer " + auto);

				HttpResponse response;

				response = httpClient.execute(getRequest);

				log.info("response----------------" + response);

				int statusCode = response.getStatusLine().getStatusCode();

				log.info("Status code for getting issues -----------" + statusCode);

				HttpEntity entity1 = response.getEntity();

				String jsonEntity = EntityUtils.toString(entity1);

				return TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.folderPath");

			}

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	public ArrayList<String> getRuleListFromSpecificFolder(String folderId, String workspaceId, String icedqRole) {
		String orgId;

		ArrayList<String> list = null;

		try {
			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			String url;

			MediaType mediaType = MediaType.parse("application/json");

			RequestBody body = RequestBody.create(mediaType,
					"{\r\n" + "  \"filter\": [\r\n" + "    {\r\n" + "		\"attribute\": \"folderId\",\r\n"
							+ "		\"operator\": \"In\",\r\n" + "    	\"datatype\": \"string\",\r\n"
							+ "		\"value\": \"" + folderId + "\"\r\n" + "	}\r\n" + "  ]\r\n" + "}");

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				url = "http://api.icedq.net/api/v1/rules/search";

				orgId = "org-iam.icedq";

			} else {
				url = "http://qa.onprem.icedq.com/api/v1/rules/search";

				orgId = "org-icedq.qa";
			}

			Request request = new Request.Builder()

					.url(url)

					.method("POST", body)

					.addHeader("workspace-id", workspaceId)

					.addHeader("org-id", orgId)

					.addHeader("Content-Type", "application/json")

					.addHeader("Authorization", "Bearer " + auto)

					.addHeader("Cookie", "JSESSIONID=688C5B8EF8423611749D1D88537A0546")

					.build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			list = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(jsonBody, "$.items..id");

		} catch (IOException e) {

			e.getMessage();
		}
		return list;

	}

	public static String getfolderIdFromRuleList(String workspaceID, String ruleName, String icedqRole) {
		String folderId = null;
		String baseUrl;

		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			RequestBody body = RequestBody.create(mediaType,
					"{\r\n" + "  \"search\": [\r\n" + "    {\r\n" + "		\"attribute\": \"name\",\r\n"
							+ "		\"operator\": \"Equals\",\r\n" + "		\"value\": \"" + ruleName + "\"\r\n"
							+ "	}\r\n" + "  ]\r\n" + "}");

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				baseUrl = readconfig.ruleListApiUrlCloudInstance();
			} else {
				baseUrl = readconfig.ruleListApiUrlOnPremInstance();
			}
			Request request = new Request.Builder()

					.url(baseUrl).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceID)

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			String jsonBody = response.body().string();

			folderId = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonBody, "$.items[0].folderId");

		} catch (Exception e) {

			e.getMessage();
		}
		return folderId;
	}

	public static String getfolderNameUsingFolderList(String workspaceID, String ruleName, String icedqRole) {

		String folderName = null;
		String orgId;
		try {
			String folderId = getfolderIdFromRuleList(workspaceID, ruleName, icedqRole);

			HttpGet getRequest;

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				getRequest = new HttpGet("http://api.icedq.net/api/v1/folders/" + folderId);

				orgId = "org-iam.icedq";

			} else {
				getRequest = new HttpGet("http://qa.onprem.icedq.com/api/v1/folders/" + folderId);

				orgId = "org-icedq.qa";
			}

			getRequest.setHeader("Content-Type", "application/json");

			getRequest.setHeader("workspace-id", workspaceID);

			getRequest.setHeader("org-id", orgId);

			getRequest.setHeader("Authorization", "Bearer " + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response----------------" + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues -----------" + statusCode);

			HttpEntity entity1 = response.getEntity();

			String jsonEntity = EntityUtils.toString(entity1);

			folderName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.path");

		} catch (IOException e) {

		}
		return folderName;

	}

	public String getWorkflowInstanceID(String workspaceId, String icedqRole, String ruleId) throws InterruptedException {
		String instanceID = null;
		try {
			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			String url = System.getProperty("testDataApiUrl");

			url = url.replaceAll("https", "http");

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			RequestBody body = RequestBody.create(mediaType, "{\"objectId\":\"" + ruleId + "\"}");

			Request request = new Request.Builder()

					.url(url+"/api/v1/workflow:trigger")

					.method("POST", body)

					.addHeader("workspace-id", workspaceId)

					.addHeader("Content-Type", "application/json")

					.addHeader("Authorization", "Bearer " + auto)

					.addHeader("Cookie", "JSESSIONID=9826B52E68E71A2555E6C54F7A77139C")

					.build();
			
		Thread.sleep(Constant.ruleWait);
			
			Response response = client.newCall(request).execute();

			String jsonEntity = response.body().string();

			instanceID = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.instanceId");

		} catch (IOException e) {

			e.getMessage();
		}
		return instanceID;

	}
	
	public String getRuleInstanceID(String workspaceId, String icedqRole, String workflowInstanceId) throws InterruptedException 
		{	
			String ruleID = null;
		
			String jsonEntity = null;

			String baseUrl;

			try {
				
			
				baseUrl = System.getProperty("testDataApiUrl");

				baseUrl = baseUrl.replaceAll("https", "http");

				String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

				RequestBody body;

				OkHttpClient client = new OkHttpClient().newBuilder().build();

				MediaType mediaType = MediaType.parse("application/json");

				body = RequestBody.create(mediaType, "{\r\n    \"filter\": [\r\n        "
						+ "{\r\n            \"attribute\": \"parentInstanceId\",\r\n           "
						+ " \"operator\": \"Equals\",\r\n            "
						+ "\"datatype\": \"\",\r\n            \"value\": "+workflowInstanceId+"\r\n        }\r\n    "
						+ "]\r\n}");

				okhttp3.Request request = new okhttp3.Request.Builder()

						.url(baseUrl+readconfig.ruleExceptionReportAPIUrlOnPrem()).method("POST", body)

						.addHeader("content-type", "application/json")

						.addHeader("workspace-id", workspaceId)

						.addHeader("org-id", "org-iam.icedq")

						.addHeader("Authorization", "Bearer " + auto)

						.build();

				Response response = client.newCall(request).execute();

				jsonEntity = response.body().string();
				
				ruleID = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.items[0].objectInstanceId");

				/*
				 * do {
				 * 
				 * ruleID = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
				 * "$.items[0].objectInstanceId");
				 * 
				 * } while (ruleID == null);
				 */
			
			}

		 catch (IOException e) {

			e.getMessage();
		}
		return ruleID;

	}

	public String exceptionJsonbody(String instanceID, String workspaceID, String icedqRole)
			throws ClientProtocolException, IOException {

		String jsonEntity = null;

		String baseUrl;

		try {
			
			System.out.println(instanceID);
			
			baseUrl = System.getProperty("testDataApiUrl");

			baseUrl = baseUrl.replaceAll("https", "http");

			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			body = RequestBody.create(mediaType,
					 
					"{\r\n" + "    \"filter\": [\r\n" + "        {\r\n"
							+ "            \"attribute\": \"objectInstanceId\",\r\n"
							+ "            \"operator\": \"Equals\",\r\n" + "            \"datatype\": \"string\",\r\n"
							+ "            \"value\": " + instanceID + "\r\n" + "        }\r\n" + "    ]\r\n" + "}");

			okhttp3.Request request = new okhttp3.Request.Builder()

					.url(baseUrl+readconfig.ruleExceptionReportAPIUrlOnPrem()).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceID)

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			jsonEntity = response.body().string();

			System.out.println(jsonEntity);

			System.out.println(jsonEntity);
			System.out.println("----- Responce code : ---- " + response.code());
		} catch (IOException e) {
			e.getMessage();
		}

		return jsonEntity;
	}
	
	
	
	public String createdRuleExceptionJsonbody(String instanceID, String workspaceID, String icedqRole)
			throws ClientProtocolException, IOException {

		String jsonEntity = null;

		String baseUrl;

		try {
			
			System.out.println(instanceID);
			
			baseUrl = "http://192.168.100.35";

		//	baseUrl = baseUrl.replaceAll("https", "http");

			String auto = TestDataThroughApi.getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			body = RequestBody.create(mediaType,
					 
					"{\r\n" + "    \"filter\": [\r\n" + "        {\r\n"
							+ "            \"attribute\": \"objectInstanceId\",\r\n"
							+ "            \"operator\": \"Equals\",\r\n" + "            \"datatype\": \"string\",\r\n"
							+ "            \"value\": " + instanceID + "\r\n" + "        }\r\n" + "    ]\r\n" + "}");

			okhttp3.Request request = new okhttp3.Request.Builder()

					.url(baseUrl+readconfig.ruleExceptionReportAPIUrlOnPrem()).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceID)

					.addHeader("org-id", "org-iam.icedq")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();

			jsonEntity = response.body().string();

			System.out.println(jsonEntity);

			System.out.println(jsonEntity);
			System.out.println("----- Responce code : ---- " + response.code());
		} catch (IOException e) {
			e.getMessage();
		}

		return jsonEntity;
	}


	public DataTestingParameters setScriptRuleParametersForApi(String jsonEntity, String num) throws Exception {
		DataTestingParameters param = new DataTestingParameters();
		try {

			param.setRuleName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name"));

			param.setRuleCode(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.code"));

			param.setRuleType(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.ruleType"));

			param.setEngineTypeOption(
					TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.properties.engineType"));
			
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


			param.setFolderName("AutomationFolder");

			if (param.getRuleType().equalsIgnoreCase("Script")) {

				param.setScriptConnVarName(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[?(@.id=='Variable')].configuration.variables[" + num + "].name"));

				param.setScriptValue(TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[?(@.id=='Script')].configuration.script"));

			}

		} catch (Exception e) {
			throw new Exception();
		}
		return param;
	}

	public void addChecksToRule(String jsonEntity, DataTestingParameters param, SoftAssert soft) {

		ArrayList<String> expressionTypes = null;

		int totalChkExpression = 0;

		try {
			if (param.getRuleType().equalsIgnoreCase("Recon")) {

				expressionTypes = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..type");

			} else if (param.getRuleType().equalsIgnoreCase("Validation")) {

				expressionTypes = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks..type");

			}

			if (!expressionTypes.isEmpty()) {
				for (int k = 1; k <= expressionTypes.size(); k++) {

					DataTestingParameters rParam = setChecksParametersUsingApi(jsonEntity, param.getRuleType(), k);

					// Unable to recall logic need to change once i run the code
					if (rParam.getChkCheckType().equalsIgnoreCase("ResultType")) {
						if (!param.getResultType().isEmpty()) {
							for (int b = 0; b < param.getResultType().size(); b++) {
								String rs_type = param.getResultType().get(b);
								// selectResultType(param);
							}
						}
					} else {
						if (!(rParam.getChkCheckType().equalsIgnoreCase("column"))) {
							totalChkExpression = totalChkExpression + 1;
							param.setNoOfExp(totalChkExpression);
						}

						try {
							// addNewCheckUsingJSONTestData(param.getRuleType(), jsonEntity, k, soft);
						} catch (Exception e) {
							BaseSuite.reportErrorLog("Failed due to exception :" + e.getMessage());
						} finally {
							if (isDisplayed(driver, discardPopupMsg) || isDisplayed(driver, cancelCheckButton)) {
								handleDiscardPopupWindowOnChecks();
								clickOnCancelCheckButton();
							}
						}

					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// new code
	public void addChecksToRule(DataTestingParameters param, String jsonEntity, String icedqRole, String workspaceId,
			String sourceQuery, String targetQuery) throws Throwable {
		try {
			ArrayList<String> checkType = null;

			SoftAssert soft = new SoftAssert();

			if (param.getRuleType().equalsIgnoreCase("Recon")) {

				checkType = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[3].configuration.checks..type");

			} else if (param.getRuleType().equalsIgnoreCase("Validation")) {

				checkType = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
						"$.objects[1].configuration.checks..type");

			}

			if (checkType != null) {
				for (int i = 1; i < checkType.size(); i++) {
					try {

						addNewCheckUsingJSONTestData(param.getRuleType(), jsonEntity, i, soft, icedqRole, workspaceId,
								sourceQuery, targetQuery);

					} catch (Exception e) {

						BaseSuite.reportErrorLog("Failed due to exception :" + e.getMessage());

					} /*
						 * finally {
						 * 
						 * if (isDisplayed(driver, discardPopupMsg) || isDisplayed(driver,
						 * cancelCheckButton)) {
						 * 
						 * handleDiscardPopupWindowOnChecks();
						 * 
						 * clickOnCancelCheckButton(); }
						 * 
						 * }
						 */
				}
			} else {

				throw new AssertionError("Getting null value for check types,Kindly check!");
			}
		} catch (Exception e) {

			throw new AssertionError("Not able to add checks on rule,Kindly check!");
		}

	}

	public String getRuleIDFromRuleName(String ruleName, String workspaceId, String userRole) throws Exception {

		String ruleID = null;

		String baseUrl;

		try {
			String auto = getOAuthBearerTokenBasedOnIcedqRole(userRole);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			body = RequestBody.create(mediaType,
					"{\r\n" + "  \"search\": [\r\n" + "    {\r\n" + "		\"attribute\": \"name\",\r\n"
							+ "		\"operator\": \"Equals\",\r\n" + "		\"value\": \"" + ruleName + "\"\r\n"
							+ "	}\r\n" + "  ]\r\n" + "}");

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				baseUrl = readconfig.ruleListApiUrlCloudInstance();
			} else {
				baseUrl = readconfig.ruleListApiUrlOnPremInstance();
			}

			Request request = new Request.Builder()

					.url(baseUrl).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceId)

					.addHeader("Cookie", "JSESSIONID=F76D501BBC7C4FBF2D064CA25CB7AC51")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();
			int rcode = response.code();
			String jsonBody = response.body().string();

			ruleID = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonBody, "$.items[0].id");

			if (ruleID.isEmpty() || ruleID == null) {
				BaseSuite.reportFailLog("Search Rule API not returning rule id kindly check :: responce code :: "
						+ rcode + "Responce body :: " + jsonBody, "getRuleIDFromRuleName");
			}
		} catch (IOException e) {
			e.getMessage();
			BaseSuite.reportFailLog("Search Rule API not returning rule id kindly check exception",
					"getRuleIDFromRuleName");
			throw new Exception("Exception found while getting rule id ::" + e.getMessage());
		}

		return ruleID;

	}
	
	
	public String getRuleNameFromRuleID(String ruleID, String workspaceId, String userRole) throws Exception {

		String ruleName = null;

		String baseUrl;

		try {
			String auto = getOAuthBearerTokenBasedOnIcedqRole(userRole);

			RequestBody body;

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			body = RequestBody.create(mediaType,
					"{\r\n" + "  \"search\": [\r\n" + "    {\r\n" + "		\"attribute\": \"name\",\r\n"
							+ "		\"operator\": \"Equals\",\r\n" + "		\"value\": \"" + ruleID + "\"\r\n"
							+ "	}\r\n" + "  ]\r\n" + "}");

			if (System.getProperty("testDataApiUrl").contains("api.icedq.net")) {
				baseUrl = readconfig.ruleListApiUrlCloudInstance();
			} else {
				baseUrl = readconfig.ruleListApiUrlOnPremInstance();
			}

			Request request = new Request.Builder()

					.url(baseUrl).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("workspace-id", workspaceId)

					.addHeader("Cookie", "JSESSIONID=F76D501BBC7C4FBF2D064CA25CB7AC51")

					.addHeader("Authorization", "Bearer " + auto)

					.build();

			Response response = client.newCall(request).execute();
			int rcode = response.code();
			String jsonBody = response.body().string();

			ruleName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonBody, "$.items[0].name");

			if (ruleName.isEmpty() || ruleName == null) {
				BaseSuite.reportFailLog("Search Rule API not returning rule id kindly check :: responce code :: "
						+ rcode + "Responce body :: " + jsonBody, "getRuleNameFromRuleID");
			}
		} catch (IOException e) {
			e.getMessage();
			BaseSuite.reportFailLog("Search Rule API not returning rule id kindly check exception",
					"getRuleNameFromRuleID");
			throw new Exception("Exception found while getting rule id ::" + e.getMessage());
		}

		return ruleID;

	}

	public String createConnectionUsingConnId(String workspaceID, String connectionID, SoftAssert soft,
			String icedqRole) {
		String connectionName = null;
		try {
			NewConnectionRepoPage conn = new NewConnectionRepoPage(driver);

			String connJsonEntity = TestDataThroughApi.getConnectionJsonEntity(workspaceID, connectionID, icedqRole);

			ConnectionPoJO connParam = conn.setConnectionParametersForApi(connJsonEntity);

			String connName = TestDataThroughApi.getConnectionNmae(connJsonEntity);

			connectionName = connName + "_" + BaseSuite.WorkspaceName;

			String connType = TestDataThroughApi.getConnectionTypeFromConnectionList(connJsonEntity, connectionID);

			switch (connType.toLowerCase()) {

			case "oracle":
			case "snowflake":
			case "postgresql":
			case "redshift":
			case "teradata":
			case "DB2":

				conn.createDBConnectionFromApi(connJsonEntity, connectionName, connType, connParam, soft);

				break;

			case "flat file (native)":

				conn.flatfilenativewithAPI(connJsonEntity, connParam, connectionName, soft, connType,
						connParam.getTypeselect());

			default:

				break;

			}
		} catch (Exception e) {
			e.getMessage();
		}
		return connectionName;
	}

	public boolean getRuleIDAndCreateRules(String ruleID, String workspaceID, SoftAssert soft, String icedqRole)
			throws Throwable {
		boolean st = true;
		try {

			ArrayList<String> connectionList = new ArrayList<String>();
			ArrayList<String> connList = null;
			DataTestingParameters xrparam = null;
			DataTestingParameters param = null;

			try {

				String jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);
				BaseSuite.reportLog("Rule json : " + jsonEntity);
				String ruleType = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.ruleType");
				String ruleName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name");

				if (!ruleType.equalsIgnoreCase("Script")) {

					connList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.objects..connectionId");
				} else {

					connList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[?(@.id=='Variable')].configuration.variables..properties.connectionId");
				}
				// DO NOT UNCOMMENT

				/*
				 * if(connList.size()>0) {
				 * 
				 * clickOnNextGenMenuTab("Connections");
				 * 
				 * } for (int j = 0; j < connList.size(); j++) {
				 * 
				 * String connName1 = createConnectionUsingConnId(workspaceID, connList.get(j),
				 * soft,icedqRole);
				 * 
				 * connectionList.add(connName1); }
				 */

				if (!ruleType.equalsIgnoreCase("Script")) {

					param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

				} else {

					param = setScriptRuleParametersForApi(jsonEntity, "1");
				}

				// clickOnNextGenMenuTab("Data Testing");

				// verifyDataTestingLandingPage();

				// enterDetailsInAddNewPaneAPI(param,workspaceID,ruleName,icedqRole);

				// enterDetailsInOverviewSection(param);

				// enterDetailsInAdvancedSettingOfOverviewSection(param);

				if (!ruleType.equalsIgnoreCase("Script")) {

					// enterDetailsInSourceSetting(jsonEntity,param,soft);

				}
				xrparam = setExceptionReportParametersUsingApi(jsonEntity, param.getRuleType());

				switch (ruleType.toLowerCase()) {

				case "checksum":

					// enterDetailsInTargetDataset(jsonEntity,param,soft);

					validateColumnNameNColumnDataType(param, jsonEntity, "target", soft);

					DataTestingParameters chkParam = setChecksParametersUsingApi(jsonEntity, param.getRuleType(), 0);

					// validateChecksumDefaultExpression(chkParam,soft);

					break;

				case "recon":
				case "ht recon":

					// enterDetailsInTargetDataset(jsonEntity, param, soft);

					validateColumnNameNColumnDataType(param, jsonEntity, "target", soft);

					ArrayList<String> sourceJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[2].configuration.joins..sourceKey");

					ArrayList<String> targetJoin = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[2].configuration.joins..targetKey");

					for (int j = 0; j < sourceJoin.size(); j++) {

						// addJoins(sourceJoin.get(j), targetJoin.get(j));
					}

					clickOnCheckNode1();

					addChecksToRule(jsonEntity, param, soft);

					ArrayList<String> checksdetails = getCheckDetailsFromCheckSection();

					clickOnExceptionReportNode();

					// validateExceptionReportTab();

					selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

					enableStoreFailureAndErrorsOnly(ruleType, xrparam.getStoreFailureAndErrors(), soft);

					selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

					validateResultTypeOnExceptionReport(jsonEntity,
							"$.objects[3].configuration.checks[0].expression.values.*");

					// validateExpression(checksdetails, soft);

					break;

				case "validation":

					clickOnCheckNode1();

					addChecksToRule(jsonEntity, param, soft);

					ArrayList<String> checksdetails1 = getCheckDetailsFromCheckSection();

					clickOnExceptionReportNode();

					// validateExceptionReportTab();

					selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

					// enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

					selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

					validateResultTypeOnExceptionReport(jsonEntity,
							"$.objects[1].configuration.checks[0].expression.values.*");

					// validateExpression(checksdetails1, soft);

					break;

				case "script":

					String scriptValue = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
							"$.objects[?(@.id=='Script')].configuration.script");

					enterScriptOfScriptRule(scriptValue);

					ArrayList<String> connVarList = TestDataThroughApi.getJsonArrayValueUsingJsonPathExpreesion(
							jsonEntity, "$.objects[?(@.id=='Variable')].configuration.variables..name");

					for (int a = 0; a < connVarList.size(); a++) {

						DataTestingParameters scparam = setScriptRuleParametersForApi(jsonEntity, Integer.toString(a));

						clickOnAddConnectionButtonInScriptObject();

						//enterConnectionVariableName(Integer.toString(a + 1), scparam.getScriptConnVarName());

						selectConnectionInScriptObject(scparam.getScriptConnVarName(), connectionList.get(a));

						String msg = testButton(
								returnElement(connVarTestButton, connDynamicVar, scparam.getScriptConnVarName()));

					}

					break;

				case "pushdown":

					clickOnCheckNode1();

					uncheckDefaultResultTypeForRule(param.getRuleType());

					verifyAllAddedColumnNColexpName(param, jsonEntity);

					ArrayList<String> checksdetails2 = getCheckDetailsFromCheckSection();

					clickOnExceptionReportNode();

					// validateExceptionReportTab();

					selectExportFileFormat(xrparam.getExceptionReportFormat(), soft);

					// enableStoreFailureAndErrorsOnly(xrparam.getStoreFailureAndErrors(), soft);

					selectShowDownloadExceptionUrl(xrparam.getShowDownloadExceptionurl(), soft);

					validateResultTypeOnExceptionReport(jsonEntity,
							"$.objects[1].configuration.checks[0].expression.values.*");

					// validateExpression(checksdetails2, soft);

					break;

				default:

					BaseSuite.reportFailLog("None of the Rule type,Kindly check", "createDBFileRules");

					break;
				}
			} catch (Exception e) {
				st = false;
				BaseSuite.reportFailLog("Rule not created kindly check , " + e.getMessage(),
						"getRuleInfoAndCreateRule");

			}
		} catch (Exception e) {
			st = false;
			BaseSuite.reportFailLog("Rule not created kindly check , " + e.getMessage(), "getRuleInfoAndCreateRule");

		}
		return st;
	}

	public boolean verifyToActiveOrInactiveFunctionalityInChecksSection(String ruleID, String workspaceID,
			SoftAssert soft, String icedqRole) throws Throwable {
		boolean st = true;
		try {

			ArrayList<String> connectionList = new ArrayList<>();
			ArrayList<String> connList = null;

			DataTestingParameters param = null;

			String jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);
			String ruleName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name");
			connList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity, "$.objects..connectionId");
			/*
			 * if(!connList.isEmpty()) {
			 * 
			 * clickOnNextGenMenuTab("Connections");
			 * 
			 * } for (int j = 0; j < connList.size(); j++) {
			 * 
			 * String connName1 = createConnectionUsingConnId(workspaceID, connList.get(j),
			 * soft,icedqRole);
			 * 
			 * connectionList.add(connName1); }
			 */
			param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

			clickOnNextGenMenuTab("Data Testing");

			verifyDataTestingLandingPage();

			//enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRole,ruleCreateFolder);

			isDisplayed(driver,sourceDatasetButton);
			
			if (isDisplayed(driver, sourceDatasetButton)) {
				// enterDetailsInSourceSetting(jsonEntity,param,soft);

				clickOnCheckNode1();

				addChecksToRule(jsonEntity, param, soft);

				String chkName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity,
						checksJsonPath + 1 + "].name");

				selectActiveOrInactiveStatusOfExpression(chkName, "Inactive", soft);

				st = selectActiveOrInactiveStatusOfExpression(chkName, "Active", soft);
			} else {
				BaseSuite.reportFailLog("Rule designer page not visible kindly check ",
						"createConnectionAndSelectConnectionForRule");
			}
		} catch (Exception e) {
			e.getMessage();
			st = false;
		}
		return st;
	}

	public void createConnectionAndSelectConnectionForRule(String ruleID, String workspaceID, SoftAssert soft,
			String icedqRole) throws Throwable {

		ArrayList<String> connectionList = new ArrayList<>();
		ArrayList<String> connList = null;

		DataTestingParameters param = null;

		String jsonEntity = getRuleJsonEntityUsingRuleID(workspaceID, ruleID, icedqRole);
		String ruleName = TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.name");
		/*
		 * connList = getJsonArrayValueUsingJsonPathExpreesion(jsonEntity,
		 * "$.objects..connectionId");
		 * 
		 * if(!connList.isEmpty()) {
		 * 
		 * clickOnNextGenMenuTab("Connections");
		 * 
		 * } for (int j = 0; j < connList.size(); j++) {
		 * 
		 * String connName1 = createConnectionUsingConnId(workspaceID, connList.get(j),
		 * soft,icedqRole);
		 * 
		 * connectionList.add(connName1); }
		 */
		param = setRuleParametersForApi(workspaceID, jsonEntity, icedqRole);

		// clickOnNextGenMenuTab("Data Testing");

		verifyDataTestingLandingPage();

		//enterDetailsInAddNewPaneAPI(param, workspaceID, ruleName, icedqRole);

		isDisplayed(driver,sourceDatasetButton);
		
		if (isDisplayed(driver, sourceDatasetButton)) {
			// enterDetailsInSourceSetting(jsonEntity,param,soft);
		} else {
			BaseSuite.reportFailLog("Rule designer page not visible kindly check ",
					"createConnectionAndSelectConnectionForRule");
			throw new NoSuchElementException("Element not found kindly check");
		}
	}

	public boolean verifyToActiveOrInactiveFunctionalityInCalculatedChecksSection(String ruleID, String workspaceID,
			SoftAssert soft, String icedqRole) throws Throwable {
		boolean st = true;
		try {

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			isDisplayed(driver,checkStatusbutton);
		
			String s = selectCheckEnableStatus("false");

			selectCheckEnableStatus("true");

			if (s.isEmpty()) {
				st = false;
			}

			if (verifyVisibilityOfButtons(driver, cancelCheckButton, "Close", true)) {

				clickOnButton(driver, cancelCheckButton, "Close", true);
			}

		} catch (Exception e) {
			e.getMessage();
			st = false;
			clickOnButton(driver, cancelCheckButton, "Close", true);
		}
		return st;
	}

	public void checkExpressionCheckbox(String expName) {

		try {
			BaseSuite.reportLog("Verifying Expression/Column Checkbox..");

			isDisplayed(driver,returnElement(expressionCheckbox, "$name", expName));

			if (isDisplayed(driver, returnElement(expressionCheckbox, "$name", expName))) {

				BaseSuite.reportLog("Clicking on " + expName + "Expression checkbox");

				displayAndClick(driver, returnElement(expressionCheckbox, "$name", expName));

				BaseSuite.validationReportLog("Clicking on expression checkbox successfully");

			} else {
				BaseSuite.reportFailLog("Expression's checkbox not visible : " + expName, "checkExpressionCheckbox");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean verifyToAddCalculatedColumnAndDeleteCheckFunctionality(String checkName, String checkStatus,
			String chkExpression, SoftAssert soft) {

		boolean flag = true;
		try {

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			String cname = enterCheckName(checkName);

			String st = selectCheckEnableStatus(checkStatus);

			chooseAttributeForCalculatedCheck(chkExpression, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			validateAddedCheckDetails(cname, chkExpression, "Calculated", st, soft);

			verifyVisibilityOfButtons(driver, deleteChecksButton, "Delete Icon ", false);

			checkExpressionCheckbox(checkName);

			javascript(driver, "arguments[0].scrollIntoView(true);", deleteChecksButton);

			flag = verifyVisibilityOfButtons(driver, deleteChecksButton, "Delete Icon", true);

			clickOnButton(driver, deleteChecksButton, "Delete ", true);

			// handle delete check pop up
			isDisplayed(driver,deletePopupDeleteBtn);
			
			if (isDisplayed(driver, deletePopupDeleteBtn)) {
				BaseSuite.reportLog("Delete checks pop up window visible ");
				clickOnButton(driver, deletePopupDeleteBtn, "Delete popup", true);
			}

		} catch (Exception e) {
			e.getMessage();
			flag = false;
		}
		return flag;
	}

	public boolean validateCalculatedCheckCrossIcon(String ruleID, String workspaceID, SoftAssert soft,
			String icedqRole) throws Throwable {
		boolean st = true;
		try {

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			st = clickOnButton(driver, checksCrossIcon, "Calculated Column Cross icon", true);

			if (!isDisplayed(driver, checksCrossIcon)) {

				BaseSuite.validationReportLog("Checks/ column sidebar is closed successfully");

			} else {

				BaseSuite.reportFailLog("Checks/ column sidebar is not closed kindly check",
						"validateCalculatedCheckCrossIcon ");
				st = false;
			}

		} catch (Exception e) {
			e.getMessage();
			st = false;
			clickOnButton(driver, cancelCheckButton, "Close", true);
		}
		return st;
	}

	public boolean validateCalculatedCheckCancelButtonFunctionality(String ruleID, String workspaceID, SoftAssert soft,
			String icedqRole) throws Throwable {
		boolean st = true;
		try {

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			st = clickOnButton(driver, cancelCheckButton, "Checks Cancel button", true);

			if (!isDisplayed(driver, cancelCheckButton)) {

				BaseSuite.validationReportLog("Checks/ column sidebar is closed successfully");

			} else {

				BaseSuite.reportFailLog("Checks/ column sidebar is not closed kindly check",
						"validateCalculatedCheckCrossIcon");
				st = false;
			}

		} catch (Exception e) {
			e.getMessage();
			st = false;
			clickOnButton(driver, checksCrossIcon, "Close", true);
		}
		return st;
	}

	public boolean validateCalculatedCheckChangeColumnButtonFunctionality(String ruleID, String workspaceID,
			SoftAssert soft, String icedqRole) throws Throwable {
		boolean st = true;
		try {

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			st = clickOnButton(driver, backToChecksButton, "Change Column button", true);

			if (!isDisplayed(driver, backToChecksButton)) {

				BaseSuite.validationReportLog("Calculated column sidebar is closed successfully");

			} else {

				BaseSuite.reportFailLog("Calculated column  sidebar is not closed kindly check",
						"validateCalculatedCheckCrossIcon");
				st = false;
			}

		} catch (Exception e) {
			e.getMessage();
			st = false;
			clickOnButton(driver, checksCrossIcon, "Close", true);
		}
		return st;
	}

	public boolean validateCalculatedCheckSaveAndNextButtonFunctionality(String ruleID, String workspaceID,
			SoftAssert soft, String icedqRole) throws Throwable {
		boolean st = true;
		try {
			DataTestingPage dp = new DataTestingPage(driver);

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			enterCheckName(dp.colName);

			selectCheckEnableStatus(dp.colState);

			chooseAttributeForCalculatedCheck(dp.colExp, soft);

			st = clickOnButton(driver, checks_SaveAndNextBtn, "Save and Next button", true);

			isDisplayed(driver,checkNameField);
			
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			if (isDisplayed(driver, checkNameField) || isDisplayed(driver, chooseAttributeSearchField)
					|| isDisplayed(driver, checkStatusbutton)) {

				BaseSuite.validationReportLog("New Calculated colunn sidebar is opened successfully");

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

			} else {

				BaseSuite.reportFailLog("New Calculated colunn sidebar not properly visible, kindly check",
						"validateCalculatedCheckSaveAndNextButtonFunctionality");
				st = false;
			}

		} catch (Exception e) {
			e.getMessage();
			st = false;
			clickOnButton(driver, checksCrossIcon, "Close", true);
		}
		return st;
	}

	public boolean validateCalculatedCheckSaveButtonFunctionality(String ruleID, String workspaceID, SoftAssert soft,
			String icedqRole) throws Throwable {
		boolean st = true;
		try {
			DataTestingPage dp = new DataTestingPage(driver);

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			String name = enterCheckName(dp.colName);

			String state = selectCheckEnableStatus(dp.colState);

			chooseAttributeForCalculatedCheck(dp.colExp, soft);

			clickOnAddNewCheckButton(soft);

			inVisible(driver, spinner, Constant.ruleWait);

			if (!isDisplayed(driver, checkNameField)) {

				BaseSuite.validationReportLog("Calculated column siderbar closed successfully");

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);

			} else {

				BaseSuite.reportFailLog("Calculated colunn sidebar visible, kindly check",
						"validateCalculatedCheckSaveButtonFunctionality");
				st = false;
			}

			validateAddedCheckDetails(name, dp.colExp, "Calculated", state, soft);

		} catch (Exception e) {
			e.getMessage();
			st = false;
			clickOnButton(driver, checksCrossIcon, "Close", true);
		}
		return st;
	}

	public boolean getTestOutputForChecks(String expOutput) {
		String testOutput;
		boolean status = false;
		try {

			javascript(driver, "arguments[0].scrollIntoView(true);", checksTestOutputTitle);

			isDisplayed(driver,checksTestOutputTitle);

			if (isDisplayed(driver, checksTestOutputTitle)) {

				BaseSuite.validationReportLog("Test Output title is visible");

				isDisplayed(driver,checksTestOutputValue);

				if (isDisplayed(driver, checksTestOutputValue)) {

					BaseSuite.validationReportLog("Test output value is visible");

					testOutput = getText(driver, checksTestOutputValue);

					BaseSuite.validationReportLog("Retrived Test output is :" + testOutput);
					BaseSuite.validationReportLog("Expected Test output is :" + expOutput);
					{
						if (containsIgnoreCase(testOutput, testOutput)) {

							BaseSuite.validationReportLog("Actual and Expected Test output is matched successfully");

							status = true;

						} else {

							BaseSuite.reportFailLog("Actual and Expected Test output not matched",
									" getTestOutputForChecks");
						}
					}

				}

			} else {

				BaseSuite.reportFailLog("Test output title not visible", "getTestOutputForChecks");
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return status;

	}

	public String enterTestValueForChecks(String expValue, SoftAssert soft) {
		String acValue = null;
		try {
			isDisplayed(driver,checksTestAttribute);
			
			javascript(driver, "arguments[0].scrollIntoView(true);", checksTestAttribute);
			if (isDisplayed(driver, checksTestAttribute) && isDisplayed(driver, checksTestValueField)) {

				BaseSuite.validationReportLog("Test Functionality fields are displayed");

				String columnName = getText(driver, checksTestAttribute);
				String value = getAttribute(driver, checksTestValueField, "placeholder");
				if (!columnName.isEmpty() && !value.isEmpty()) {

					BaseSuite.reportLog("Selected attribute name : " + columnName);

					BaseSuite.reportLog("Placeholder for value field : " + value);

				} else {
					BaseSuite.reportFailLog("Selected attribute name and enter value field not found",
							"enterTestValueForChecks");
				}

				BaseSuite.reportLog("Entering Value :" + expValue);

				clear_Click_SendKeys(driver, 2, checksTestValueField, expValue);

				acValue = getAttribute(driver, checksTestValueField, "value");

				soft.assertEquals(acValue, expValue);

				if (!expValue.isEmpty()) {

					BaseSuite.validationReportLog("Entered value :" + expValue + " successfully");

				} else {

					BaseSuite.reportFailLog("Entered value not visible/found kindly check", "enterTestValueForChecks ");
				}
			} else {
				BaseSuite.reportFailLog("Test functionality fields not visible, Kindly check",
						"enterTestValueForChecks");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return acValue;
	}

	public boolean validateCalculatedCheckTestButtonFunctionality(String ruleID, String workspaceID, SoftAssert soft,
			String icedqRole) throws Throwable {
		boolean st = true;
		try {
			DataTestingPage dp = new DataTestingPage(driver);

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			enterCheckName(dp.colName);

			selectCheckEnableStatus(dp.colState);

			chooseAttributeForCalculatedCheck(dp.colExp, soft);

			isDisplayed(driver,checksTestAttribute);

			BaseSuite.reportLog("Verifying Test functionality fields");

			if (isDisplayed(driver, checksTestAttribute)) {

				javascript(driver, "arguments[0].scrollIntoView(true);", checksTestAttribute);

				verifyVisibilityOfButtons(driver, checksTestExecuteButton, " Execute", false);
				isClickable(driver, checksTestExecuteButton, "Execute ", false);

				verifyVisibilityOfButtons(driver, checksTestClearButton, " Clear", false);
				isClickable(driver, checksTestClearButton, "Clear ", false);

				enterTestValueForChecks(dp.validtestValue, soft);

				verifyVisibilityOfButtons(driver, checksTestExecuteButton, " Execute", true);
				isClickable(driver, checksTestExecuteButton, "Execute", true);

				verifyVisibilityOfButtons(driver, checksTestClearButton, "Clear ", true);
				isClickable(driver, checksTestClearButton, "Clear", true);

				clickOnButton(driver, checksTestExecuteButton, "Execute", true);

				st = getTestOutputForChecks(dp.validtextOutput);

				if (st) {

					clickOnButton(driver, checksTestClearButton, "Clear", true);

					enterTestValueForChecks(dp.invalidtestValue, soft);

					st = getTestOutputForChecks(dp.invalidtextOutput);

				} else {

					throw new AssertionError(
							"Failed Due to Assertion failure test output for calculated column expected true but found "
									+ st);
				}

			} else {
				BaseSuite.reportFailLog(
						"Test functionality fields not visible, Kindly check - refer issue id - DAT-4738",
						" validateCalculatedCheckTestButtonFunctionality");
				st = false;
			}

		} catch (Exception e) {
			BaseSuite.reportFailLog(
					"Exception/Bug occur for Test functionality, Kindly check - refer issue id - DAT-4738",
					"validateCalculatedCheckTestButtonFunctionality");
			e.getMessage();
			st = false;
			isDisplayed(driver,checksCrossIcon);
			
			if (isDisplayed(driver, checksCrossIcon)) {
				clickOnButton(driver, checksCrossIcon, "Close", true);
			}
		}
		return st;
	}

	public void verifyDiscardPopUpWindow() {

		try {
			BaseSuite.reportLog("Verifying the discard popup window");
			
			isDisplayed(driver,discardPopupTitle);

			if (isDisplayed(driver, discardPopupTitle)) {

				BaseSuite.validationReportLog("Discard popup window is visible");

				String title = getText(driver, discardPopupTitle);

				if (!title.isEmpty()) {

					BaseSuite.reportLog("Discard popup window title : " + title);
				}
				String msg = getText(driver, discardPopupMsg);

				if (!msg.isEmpty()) {
					BaseSuite.reportLog("Discard popup window message : " + msg);
				} else {
					BaseSuite.reportFailLog("Discard message not visible kindly check", "verifyDiscardPopUpWindow");
				}

				verifyVisibilityOfButtons(driver, discardPopUpCancelButton, "Cancel", true);

				verifyVisibilityOfButtons(driver, discardPopupBtn, "Discard", true);

			} else {
				BaseSuite.reportFailLog("Discard title not visible kindly check", "verifyDiscardPopUpWindow");

			}
		} catch (Exception e) {
			e.getMessage();
			throw new AssertionError("Discard title not visible");
		}
	}

	public boolean validateDiscardPopWindowAfterClickChangeColumnButton(String ruleID, String workspaceID,
			SoftAssert soft, String icedqRole) throws Throwable {
		boolean st = true;
		try {
			DataTestingPage dp = new DataTestingPage(driver);

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			enterCheckName(dp.colName);

			selectCheckEnableStatus(dp.colState);

			chooseAttributeForCalculatedCheck(dp.colExp, soft);

			st = clickOnButton(driver, backToChecksButton, "Change Column", true);

			if (st) {

				verifyDiscardPopUpWindow();

				st = clickOnButton(driver, discardPopUpCancelButton, " Cancel", true);
				if (st) {

					isDisplayed(driver,checkNameField);
					
					if (isDisplayed(driver, checkNameField)) {
						BaseSuite.validationReportLog("User on same calculated column pane");
					} else {
						BaseSuite.reportFailLog("Discard popup window not closed ",
								" validateDiscardPopWindowAfterClickChangeColumnButton");
					}
				}
				st = clickOnButton(driver, backToChecksButton, "Change Column", true);
				if (st) {
					verifyDiscardPopUpWindow();
				}
				st = clickOnButton(driver, discardPopupBtn, "Discard", true);
				if (st) {
					BaseSuite.reportLog("checking discard popup window closed or not");
					
					isDisplayed(driver,checksHeadingTitle);
					
					if (isDisplayed(driver, checksHeadingTitle)) {
						BaseSuite.validationReportLog("Discard popup window closed and Add Column pane is visible ");

					} else {
						BaseSuite.reportFailLog("Discard popup window not closed ",
								"validateDiscardPopWindowAfterClickChangeColumnButton");
					}
				}
			} else {
				BaseSuite.reportFailLog("Change column button not clicked  kindly check",
						"validateDiscardPopWindowAfterClickChangeColumnButton");
			}

		} catch (Exception e) {
			BaseSuite.reportFailLog("Exception/Bug occur for discard popup window , Kindly check",
					"validateCalculatedCheckTestButtonFunctionality");
			e.getMessage();
			st = false;
			clickOnButton(driver, checksCrossIcon, "Close", true);
		}
		return st;
	}

	public boolean validatedSaveAndSaveNextButton(String ruleID, String workspaceID, SoftAssert soft, String icedqRole)
			throws Throwable {
		boolean st = true;

		try {
			DataTestingPage dp = new DataTestingPage(driver);

			createConnectionAndSelectConnectionForRule(ruleID, workspaceID, soft, icedqRole);

			clickOnCheckNode1();

			clickOnAddButton_checkTab();

			clickOnAddColumnMenuOption();

			clickOnCheckType("Calculated");

			isDisplayed(driver,checks_SaveAndNextBtn);

			if (isDisplayed(driver, checks_SaveAndNextBtn) && isDisplayed(driver, addNewCheckButton)) {

				verifyVisibilityOfButtons(driver, addNewCheckButton, "Save", false);
				isClickable(driver, addNewCheckButton, "Save", false);

				verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", false);
				isClickable(driver, checks_SaveAndNextBtn, "Save and Next", false);

				enterCheckName(dp.colName);

				selectCheckEnableStatus(dp.colState);

				chooseAttributeForCalculatedCheck(dp.colExp, soft);

				verifyVisibilityOfButtons(driver, addNewCheckButton, "Save", true);
				isClickable(driver, addNewCheckButton, "Save", true);

				st = verifyVisibilityOfButtons(driver, checks_SaveAndNextBtn, "Save and Next", true);
				isClickable(driver, checks_SaveAndNextBtn, "Save and Next", true);

			} else {
				st = false;
				BaseSuite.reportFailLog("Save , Save and Next buttons not visible kindly check ",
						"validatedSaveAndSaveNextButton");
			}

		} catch (Exception e) {
			e.getMessage();
			st = false;
			throw new AssertionError(
					"Exception occurs while validating calculated column, kindly check " + e.getMessage());
		}
		return st;
	}
}
