package nexgen.automation.framework.reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ConstantProperty;
import nexgen.automation.framework.util.CustomTimeUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ELKUtils extends BaseSuite{

	private ELKUtils() {}
/**	static boolean flag=Constant.ELK_STATUS;**/
	static boolean flag= BaseSuite.elkFlag;
	static String elkurl = Constant.ELK_URL.toLowerCase();
	static String elkusername= Constant.ELK_USERNAME;
	static String elkpassword= Constant.ELK_PASSWORD;
	static ReadConfig mailconfig = new ReadConfig();
	static String indexType ="_doc";
	
	static String datetimeFormat = "yyyy/MM/dd HH:mm:ss";
	static String dateFormat = "yyyy/MM/dd";
	
	public static void sendDetailsToElk(String testname, String status, String author, String testCaseId, String testgroups, String icedqUser) {
		
		try {
			if(flag) {	
				
				String xrayid = "";
								
				String credentials = elkusername + ":" + elkpassword;
				String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
								
				xrayid = testCaseId.toLowerCase().contains("nrr") ? mailconfig.xRayBaseUrl()+testCaseId : testCaseId;
				
				author =  author.isEmpty() ? Constant.AUTHOR_DHAWALT : author;
				
				OkHttpClient client = new OkHttpClient().newBuilder().build();

				MediaType mediaType = MediaType.parse("application/json");
				
				// Prepare the JSON body as a string
				String requestBodyContent = "{\r\n"
				    + "    \"testName\": \"" + testname + "\",\r\n"
				    + "    \"status\": \"" + status + "\",\r\n"
				    + "    \"module\": \"" + getModuleName(BaseSuite.ModuleName) + "\",\r\n"
				    + "    \"author\": \"" + author + "\",\r\n"
				    + "    \"executionTime\": \"" + CustomTimeUtil.getUTCTimeFormat(datetimeFormat) + "\",\r\n"
				    + "    \"executionDate\": \"" + new SimpleDateFormat(dateFormat).format(new Date()) + "\",\r\n"
				    + "    \"testCaseId\": \"" + xrayid + "\",\r\n"
				    + "    \"instanceURL\": \"" + trimLastCharIfSlash(BaseSuite.baseURL) + "\",\r\n"
				    + "    \"executionMessage\": \"" + BaseSuite.subjectMessage + "\",\r\n"
				    + "    \"buildId\": \"" + BaseSuite.buildId.toLowerCase() + "\",\r\n"
				    + "    \"releaseId\": \"" + BaseSuite.releaseName + "\",\r\n"
				    + "    \"icedqUser\": \"" + getUserFullName(icedqUser) + "\",\r\n"
				    + "    \"testGroups\": \"" + testgroups + "\"\r\n"
				    + "}";


				RequestBody body = RequestBody.create(mediaType, requestBodyContent);
				
				String elkdocURL = elkurl+"/"+BaseSuite.suiteType.toLowerCase()+"-v1"+"/"+indexType+"/"+BaseSuite.suiteType.toLowerCase()+"-"+BaseSuite.buildId.toLowerCase()+"-"+testCaseId.toLowerCase();

				log.info("ElasticSearch Request URL: "+elkdocURL);
				BaseSuite.reportLog("ElasticSearch Request URL: "+elkdocURL)	;
				log.info("ElasticSearch Request body: "+requestBodyContent);
				Request request = new Request.Builder()

						.url(elkdocURL).method("POST", body)

						.addHeader("content-type", "application/json")
						
						.addHeader("Authorization", "Basic " + encodedCredentials)

						.build();

				Response response = client.newCall(request).execute();

				/**	Assert.assertEquals(response.code(), 201);*/

				log.info("ElasticSearch Response code: "+response.code());
				
				String responseBody = response.body().string(); // Get the response body as a string
				
				log.info("ElasticSearch Response Body: " + responseBody);  // Log the response body
			/**	BaseSuite.reportLog("ElasticSearch Response Body: " + responseBody);*/
			}
		} catch (IOException e) {
			log.info(e.getMessage());
		}

	}
	
	public static String getModuleName(String moduleName) {
		String name = null;
		
		try {
			switch(moduleName.toLowerCase().trim()) {
			
			case "administration":
				name=ConstantProperty.MODULE_ADMIN;
				break;
			case "datatesting":
				name=ConstantProperty.MODULE_DATATESTING;
				break;
			case "connectionrepo":
				name=ConstantProperty.MODULE_CONNECTIONS;
				break;
			case "scheduler":
				name=ConstantProperty.MODULE_SCHEDULER;
				break;
			default:
				name=moduleName;
				break;
			
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		return name;
	}
		
	public static String trimLastCharIfSlash(String input) {
        if (input != null && input.endsWith("/")) {
            return input.substring(0, input.length() - 1);
        }
        return input; // Return the original string if it doesn't end with '/'.
    }
	
	public static String getUserFullName(String icedqUser) {
		String user="";
		switch(icedqUser.toLowerCase()){

		case "account_owner":
			user="Account Owner";
			break;
		case "account_contributor":
			user="Account Contributor";
			break;
		case "account_executor":
			user="Account Executor";
			break;
		case "account_reader":
			user="Account Reader";
			break;
		case "workspace_owner":
			user="Workspace Owner";
			break;
		case "workspace_contributor":
			user="Workspace Contributor";
			break;
		case "workspace_executor":
			user="Workspace Executor";
			break;
		case "workspace_reader":
			user="Workspace Reader";
			break;
		case "application_admin":
			user="Application Admin";
			break;
		case "super_admin":
			user="Super Admin";
			break;
		default : 
			user="icedq user";
			break;

		}

		return user;
	}
}
