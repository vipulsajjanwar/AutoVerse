package nexgen.automation.framework.xray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.util.Base64;
import com.sun.jersey.core.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;


import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import nextgen.automation.RuleRepo.pages.TestDataThroughApi;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class UpdateTestExecutionsUsingIDs {

	
	
static ReadConfig readconfig = new ReadConfig();

	static final   Logger log = Logger.getLogger(UpdateTestExecutionsUsingIDs.class);

	public static final String XRAY_GrafQL = readconfig.xRayGrafQL();

	private static String jiraBaseUrl = readconfig.jiraBaseURL();
	private static String jiraIssueUrl = readconfig.jiraIssueUrl();
	private static String jiraUserName = readconfig.jiraUserName();
	private static String jiraPassword = readconfig.jiraPassword();
	private static String jiraAtachmentURL = readconfig.jiraAtachmentURL();
	private static String jiraAttUrl = readconfig.jira();
	
	public void updateTestExecutions()
			throws IOException {

		String testExecution = BaseSuite.executionKey;
		
		log.info("Test execution Id :: "+testExecution);
		
		if(!testExecution.isEmpty()) {

			String executionID = getIssueIDs(testExecution);

			log.info(executionID);

			String reportDoc = ExecutionResult.reportDocPath;
			XLUtils xlReader = new XLUtils();
			int rowCount = xlReader.getRowCount(reportDoc, "Sheet1");

			for(int rowNum =0; rowNum<rowCount; rowNum++ ) {

				int rowNumber = rowNum +1;

				String issueKey = xlReader.getCellData(reportDoc, "Sheet1", rowNumber, 1);

				String status = xlReader.getCellData(reportDoc, "Sheet1", rowNumber, 2);

				String issueID = getIssueIDs(issueKey);

				String exeStatus = addStatus(status);

				log.info("Issue key - "+issueKey);
				log.info("Issue status - "+status);
				log.info("Issue ID - "+issueID);

				try {

					String auth = UpdateTestExecutions.generateToken();

					//		log.info(auth);

					String exeID = getExecutionIDs(auth, issueID,executionID);

					log.info(exeID);

					updateStatus(exeID,exeStatus,auth);

					if(status.equals("1"))
					{
						String filename = System.getProperty("user.dir") + "/reports/"+ExecutionResult.suitename+"-reports"+"/"+ BaseSuite.reportname;

						String testRunID = getTestRunID(issueID, exeID);

						addAttachmentsForFailTestCase(filename, testRunID);
					}


				} catch (Exception e) {
					log.error(e.getMessage());

				}
			}

		}else {
			log.info("Test execution ID is empty");
		}
		
	}

	
	public String addStatus(String status) {
		
		String updateStatus=null;
		
		if(status.equals("1")) {
			
			updateStatus = "Passed";
			
		}else if(status.equals("2")) {
			
			updateStatus = "Failed";
			
		}else if(status.equals("3")) {
			
			updateStatus = "UNEXECUTED";
			
		}
			
	return updateStatus;
		
	}
	
public  String getExecutionIDs(String auth,String testCaseId,String executionId) throws IOException {
		
		String queryParam = "{getTestRun( testIssueId: \""+testCaseId+"\", testExecIssueId: \""+executionId+"\") {id status { name color description } gherkin examples { id status { name color description } } }}";

		String testCaseAddUrl = XRAY_GrafQL+"?query="+ URLEncoder.encode(queryParam, "UTF-8");
			
		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		
		HttpGet getRequest = new HttpGet(testCaseAddUrl);
		
		getRequest.setHeader("Authorization", "Bearer " + auth);
		
		getRequest.setHeader("Content-Type","application/json");
		
		getRequest.setHeader("Accept","application/json");
		
		HttpResponse response;
				
		response = httpClient.execute(getRequest);
				
	//	log.info("response----------------"+response);
				
		int statusCode = response.getStatusLine().getStatusCode();
		
		log.info("Status code for getting issues -----------"+statusCode);

		org.apache.http.HttpEntity entity1 = response.getEntity();
		
		String string1 = null;
		
		string1 = EntityUtils.toString((org.apache.http.HttpEntity) entity1);
			
		JSONObject allIssues = new JSONObject(string1);

	//	log.info(allIssues.toString());
	
	//	log.info(allIssues.getJSONObject("data").toString());
		
		JSONObject resp1 = allIssues.getJSONObject("data");
		
	//	log.info(resp1.getJSONObject("getTestRun").toString());
		
		JSONObject resp2 = resp1.getJSONObject("getTestRun");
		
		log.info(resp2.get("id").toString());
		
		return resp2.get("id").toString();

}
	
public void updateStatus(String exeID, String status, String auth) throws IOException {

	
	try {
		String queryParam = "mutation {updateTestRunStatus( id: \"" + exeID + "\", status: \"" + status + "\")}";

		String testCaseAddUrl = XRAY_GrafQL + "?query=" + URLEncoder.encode(queryParam, "UTF-8");

		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();

		HttpPost postRequest = new HttpPost(testCaseAddUrl);

		postRequest.setHeader("Authorization", "Bearer " + auth);

		postRequest.setHeader("Content-Type", "application/json");

		postRequest.setHeader("Accept", "application/json");

		HttpResponse response;

		response = httpClient.execute(postRequest);

		log.info("response----------------" + response);

		int statusCode = response.getStatusLine().getStatusCode();

		log.info("Status code for getting issues -----------" + statusCode);
	} catch (Exception e) {

		e.getMessage();
		
	}
}

	public  String getIssueIDs(String id) throws org.apache.http.ParseException, IOException {

		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		
		HttpGet getRequest = new HttpGet(jiraBaseUrl+jiraIssueUrl+id);
		System.out.println(jiraBaseUrl+jiraIssueUrl+id);
		String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));
		
		getRequest.setHeader("Authorization", "Basic " + auth);
		
		getRequest.setHeader("Content-Type","application/json");
		
		getRequest.setHeader("Accept","application/json");
		 
		 HttpResponse response;
				
		response = httpClient.execute(getRequest);
				
		log.info(response.toString());
				
		int statusCode = response.getStatusLine().getStatusCode();
		
		log.info("Status code for getting issues -----------"+statusCode);
		
		org.apache.http.HttpEntity entity1 = response.getEntity();
			
		String string1 = null;
		
		string1 = EntityUtils.toString((org.apache.http.HttpEntity) entity1);
			
		JSONObject allIssues = new JSONObject(string1);

		log.info(allIssues.toString());
		
		log.info("ID ------"+allIssues.get("id"));

		return allIssues.get("id").toString();
		
	}
	
	public static void addAttachmentsForFailTestCase(String filePath,String testRunID) {
		
		String auth = UpdateTestExecutions.generateToken();
		try {
			
			String base64 = PageUtil.base64Encoder(filePath);
			
			System.out.println(base64);

			OkHttpClient client = new OkHttpClient().newBuilder().build();
			
			MediaType mediaType = MediaType.parse("application/json");
			
			RequestBody body = RequestBody.create(mediaType,
					
					"{\"query\":\"mutation {\\r\\n    addEvidenceToTestRun(\\r\\n        id: \\\""+testRunID+"\\\",\\r\\n        evidence: [\\r\\n            {\\r\\n                filename: \\\""+BaseSuite.reportname+"\\\"\\r\\n                mimeType: \\\"text/plain\\\"\\r\\n                data: \\\""+base64+"\\\"\\r\\n            }\\r\\n        ]\\r\\n    ) {\\r\\n        addedEvidence\\r\\n        warnings\\r\\n    }\\r\\n}\",\"variables\":{}}");
			
			Request request = new Request.Builder().url(XRAY_GrafQL)
					
					.method("POST", body)
					
					.addHeader("Authorization","Bearer " +auth)
					
					.addHeader("Content-Type", "application/json").build();
			
			Response response = client.newCall(request).execute();
			
			log.info(response);

		} catch (IOException e) {

			log.error(e.getMessage());
		}

	}
	
	
public static String getTestRunID(String testCaseID,String executionID) {
		
		try {
			String auth = UpdateTestExecutions.generateToken();
			String testRunID = null;
			
				OkHttpClient client = new OkHttpClient().newBuilder()
						  .build();
				
						MediaType mediaType = MediaType.parse("application/json");
						
						RequestBody body = RequestBody.create(mediaType, "{\"query\":\"{\\r\\n    getTestRun( testIssueId: \\\""+testCaseID+"\\\", testExecIssueId: \\\""+executionID+"\\\") {\\r\\n        id\\r\\n        status {\\r\\n            name\\r\\n            color\\r\\n            description\\r\\n        }\\r\\n        gherkin\\r\\n        examples {\\r\\n            id\\r\\n            status {\\r\\n                name\\r\\n                color\\r\\n                description\\r\\n            }\\r\\n        }\\r\\n    }\\r\\n}\",\"variables\":{}}");
						
						Request request = new Request.Builder()
								
						  .url(XRAY_GrafQL)
						  
						  .method("POST", body)
						  
						  .addHeader("Authorization", "Bearer "+auth)
						 
						  .addHeader("Content-Type", "application/json")
						  
						  .build();
						
						Response response = client.newCall(request).execute();
						
						log.info(response);
						
						String jsonEntity = response.toString();
						
						 testRunID	=  TestDataThroughApi.getJsonValueUsingJsonPathExpreesion(jsonEntity, "$.data.getTestRun.id");
		} catch (IOException e) {
		
			e.getMessage();
		}
		return executionID;
	

	}
	
	
	
	

	public static File getLastModified(String directoryFilePath)
	{
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}
	
	public void updateTestExecutions(String executionId, String reportDocPath)
			throws IOException {

		String testExecution = executionId;
		
		String executionID = getIssueIDs(testExecution);
			
		log.info(executionID);
		
		String reportDoc = reportDocPath;
		XLUtils xlReader = new XLUtils();
		int rowCount = xlReader.getRowCount(reportDoc, "Sheet1");
		
		for(int rowNum =0; rowNum<rowCount; rowNum++ ) {
			
			int rowNumber = rowNum +1;
		
			String issueKey = xlReader.getCellData(reportDoc, "Sheet1", rowNumber, 1);
			
			String status = xlReader.getCellData(reportDoc, "Sheet1", rowNumber, 2);
			
			String issueID = getIssueIDs(issueKey);
			
			String exeStatus = addStatus(status);
			
			log.info("Issue key - "+issueKey);
			log.info("Issue status - "+status);
			log.info("Issue ID - "+issueID);
			
			try {
				
				String auth = UpdateTestExecutions.generateToken();
				
				log.info(auth);

				String exeID = getExecutionIDs(auth, issueID,executionID);
				
				log.info(exeID);
				
				updateStatus(exeID,exeStatus,auth);
			/**	
				if(status.equals("1"))
				{
					String filename = System.getProperty("user.dir") + "/reports/"+ExecutionResult.suitename+"-reports"+"/"+ BaseSuite.reportname;
					
					String testRunID = getTestRunID(issueID, exeID);
				
					addAttachmentsForFailTestCase(filename, testRunID);
				}
		**/
				
			} catch (Exception e) {
				log.error(e.getMessage());
				
			}
			
			
		}
		
	}
	
	
}
