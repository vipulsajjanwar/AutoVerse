package nextgen.automation.workflow.service.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WorkflowsServiceAPIPage extends PageUtil{

	static String httpsProtocalContent="https";
	/* ---------- API Variables -------------*/
	static ReadConfig readconfig = new ReadConfig();
	protected static final Logger log = Logger.getLogger(WorkflowsServiceAPIPage.class);
	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	private static final String CLIENTID = readconfig.clientIdOnPremInstance();
	private static final String CLIENTSECRET = readconfig.clientSecreOnPremInstancet();
	private static final String AUTH = CLIENTID + ":" + CLIENTSECRET;
	private static final String AUTHENTICATION = Base64.getEncoder().encodeToString(AUTH.getBytes());
	static final String USERNAME = readconfig.userName();
	static final String PASSWORD = readconfig.password();
	static final String HTTPCLIENT = null;
	static String authetication = prop.getProperty("Authetication");
	static String basic = prop.getProperty("Basic");
	static String contentType = prop.getProperty("ContentType");
	static String contentTypeText="content-type";

	static String authorization=prop.getProperty("api.authorization");
	static String apibasic=prop.getProperty("api.apibasic");
	static String apicontentType=prop.getProperty("api.apicontentType");
	static String applicationJSonContentType=prop.getProperty("api.applicationJSonContentType");
	static String apiworkspaceId=prop.getProperty("api.apiworkspaceId");
	static String apiorgId=prop.getProperty("api.apiorgId");
	static String apiBearer=prop.getProperty("api.apiBearer");
	static String jsonPathName=prop.getProperty("ConnName.JsonPath");
	static String jsonPathGetId=prop.getProperty("jsonPathGetId");
	/** -------------------------------------------- Workflow API Methods -------------------------------------------- **/

	//If single user login flag is true in XML file than pass double quote for role name(EX-role name = "")
	//If single user login flag is false in XML file than pass ICEDQ role name on parameter(EX-role name = Wprkspace_Owner)
	public static String getOAuthBearerTokenBasedOnIcedqRole(String roleName) {
		String uN;
		String pW;
		String orgid;
		XLUtils xlReader = new XLUtils();

		if(BaseSuite.singleUserLogin) {

			uN = BaseSuite.username;
			pW = BaseSuite.password;

		}else {
			String[] loginDetails = xlReader.readDataFromExcelUsingColumnName(roleName);

			uN = loginDetails[0];

			pW = loginDetails[1];	
		}
		String content = "grant_type=password&username=" + uN + "&password=" + pW;

		BufferedReader reader = null;

		HttpURLConnection connection = null;

		String returnValue = "";

		if(BaseSuite.baseURL.contains("api")) {
			orgid="iam.icedq";

		}else {
			orgid="icedq.qa";
		}
		if(BaseSuite.baseURL.contains(httpsProtocalContent)) {
			/**BaseSuite.baseURL=BaseSuite.baseURL.replace(httpsProtocalContent, "http");*/
		}
		if(!BaseSuite.baseURL.endsWith("/")) {
			BaseSuite.baseURL=BaseSuite.baseURL+"/";
		}


		try {

			URL url = new URL(BaseSuite.baseURL+"auth/realms/"+orgid+"/protocol/openid-connect/token");

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");

			connection.setDoOutput(true);

			connection.setRequestProperty(authorization, apibasic + AUTHENTICATION);

			connection.setRequestProperty(apicontentType, "application/x-www-form-urlencoded");

			connection.setRequestProperty("Accept", applicationJSonContentType);

			try (PrintStream os = new PrintStream(connection.getOutputStream());) {

				os.print(content);

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String line = null;

				StringWriter out = new StringWriter(
						connection.getContentLength() > 0 ? connection.getContentLength() : 2048);

				while ((line = reader.readLine()) != null) {

					out.append(line);
				}
				String response = out.toString();

				Matcher matcher = pat.matcher(response);

				if (matcher.matches() && matcher.groupCount() > 0) {

					returnValue = matcher.group(1);
				}
			}
		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (reader != null) {

				try {

					reader.close();

					connection.disconnect();

				} catch (IOException e) {
					e.getMessage();
				}
			}


		}

		return returnValue;
	}

	public static  List<String> getJsonArrayValueUsingJsonPathExpreesion1(String jsonEntity, String expression) {
		ArrayList<String> list = new ArrayList<>();

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				String value1 = o.toString().replace("\"", "");

				list.add(value1);

			}

		} catch (Exception e) {

			e.getMessage();
		}

		return list;

	}

	public static String getJsonValueUsingJsonPathExpreesion1(String jsonEntity, String expression) {
		String value = "";

		try {

			BufferedReader buffer = new BufferedReader(new StringReader(jsonEntity));

			String line = null;

			StringBuilder buider = new StringBuilder();

			while ((line = buffer.readLine()) != null) {
				buider.append(line);

			}

			String jsonContent = buider.toString();

			log.info(jsonContent);

			Configuration conf = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
					.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();

			ArrayNode node = JsonPath.using(conf).parse(jsonContent).read(expression);

			for (Object o : node) {

				value = o.toString().replace("\"", "");
			}

			if(value==null) {
				value="";
			}

		} catch (Exception e) {

			e.getMessage();
		}

		return value;

	}

	// get list of custom workflow id from workspace

	public static List<String> getCustomWorkflowIdFromWorkspace(String workspaceId,String icedqRole) {
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse(contentType);

			RequestBody body = RequestBody.create(mediaType,
					"{\"filter\":[{\"attribute\":\"workflowType\",\"operator\":\"In\",\"datatype\":\"string\",\"value\":\"Custom\"}]}");

			Request request = new Request.Builder()

					.url(readconfig.workflowListApiUrl()).method("POST", body)

					.addHeader(contentTypeText, contentType)

					.addHeader(apiworkspaceId, workspaceId)

					.addHeader(apiorgId, "org-iam.icedq")

					.addHeader(authetication, apiBearer + auto)

					// .addHeader("Cookie", "JSESSIONID=864D9BE317797369277797E49EED9043")

					.build();

			Response response = client.newCall(request).execute();

			String r = response.body().string();

			return null;//getJsonArrayValueUsingJsonPathExpreesion(r, "$.items..id");

		} catch (Exception e) {

			e.getMessage();
		}
		return Collections.emptyList();

	}

	// get workflow info from workflow id and workspace id
	public static String getWorkflowInfoFromWorkflowID(String workflowID, String workspaceId,String icedqRole) {
		String jsonEntity = null;
		try {

			String auto = getOAuthBearerTokenBasedOnIcedqRole(icedqRole);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(readconfig.AppicationBaseURL() + "api/v1/workflows/" + workflowID);

			getRequest.setHeader(apicontentType, applicationJSonContentType);

			getRequest.setHeader(apiworkspaceId, workspaceId);

			getRequest.setHeader(authorization, apiBearer + auto);

			HttpResponse response;

			response = httpClient.execute(getRequest);

			log.info("response---------------- " + response);

			int statusCode = response.getStatusLine().getStatusCode();

			log.info("Status code for getting issues ----------- " + statusCode);

			HttpEntity entity1 = response.getEntity();

			jsonEntity = EntityUtils.toString(entity1);


		} catch (Exception e) {

			e.getMessage();
		}
		return jsonEntity;
	}
	
	
}
