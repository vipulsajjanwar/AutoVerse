package nexgen.automation.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.http.client.methods.HttpGet;


public class APIUtil {

	private static final String APPURL ="https://192.168.100.35:32222/";
	private static final String TOKENURL = "https://192.168.100.35:32222/auth/realms/iam.icedq/protocol/openid-connect/token"; // Replace with actual token URL
	private static final String CLIENTID = "icedq.admin-ui";
	private static final String CLIENTSECRET = "b2e25665-7fce-49fa-9c63-f7c872dabcf2";
	private static final Pattern pat = Pattern.compile("\"access_token\":\"(.*?)\"");

	private static final String BEARER="Bearer ";
	private static final String AUTHORIZATION="Authorization";
	private static final String APPLICATIONJSON="application/json";

	static final Logger log = Logger.getLogger(APIUtil.class);

	private APIUtil() {
		throw new IllegalStateException("API Utility class");
	}

	
	public static String generateToken() {
		String auth=null;
		try {
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
					RequestBody body = RequestBody.create(mediaType, "grant_type=password&client_id=icedq.admin-ui&username=account_owner&password=Account!2345");
					Request request = new Request.Builder()
					  .url("http://192.168.100.35:32222/auth/realms/icedq/protocol/openid-connect/token")
					  .method("POST", body)
					  .addHeader("Content-Type", "application/x-www-form-urlencoded")
					  .build();
					Response response = client.newCall(request).execute();
					
					auth = response.toString();
		} catch (IOException e) {
			e.getMessage();
		}
				
			return 	auth;
	}
	
	
	
	// Method to generate OAuth Bearer Token
	public static String generateOAuthToken(String username, String password) {

		String content = "grant_type=password&username=" + username + "&password=" + password;

		String returnValue = "";

		HttpURLConnection httpCon = null;

		try {

			String auth = CLIENTID + ":" + CLIENTSECRET;

			String authentication = Base64.getEncoder().encodeToString(auth.getBytes());

			URL url = new URL(TOKENURL);

			httpCon = (HttpURLConnection) url.openConnection();

			httpCon.setRequestMethod("POST");

			httpCon.setDoOutput(true);

			httpCon.setRequestProperty(AUTHORIZATION, "Basic " + authentication);

			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			httpCon.setRequestProperty("Accept", APPLICATIONJSON);

			// Send the POST data
			try (PrintStream os = new PrintStream(httpCon.getOutputStream())) {
				os.print(content);
			}

			// Read the response
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
					StringWriter out = new StringWriter(httpCon.getContentLength() > 0 ? httpCon.getContentLength() : 2048)) {

				String line;
				while ((line = reader.readLine()) != null) {
					out.append(line);
				}

				String response = out.toString();

				// Match and extract the OAuth token from the response
				Matcher matcher = pat.matcher(response);
				if (matcher.matches() && matcher.groupCount() > 0) {
					returnValue = matcher.group(1);
				}
			}

		} catch (Exception e) {

			log.error(e.getMessage());

		} finally {

			if(httpCon!=null) {
				httpCon.disconnect();
			}
		}

		return returnValue;
	}

	// Method to generate request headers with support for custom headers
	public static Map<String, String> generateHeaders(String authToken, Map<String, String> customHeaders) {
		// Create default headers
		Map<String, String> headers = new HashMap<>();
		headers.put(AUTHORIZATION, BEARER + authToken);
		headers.put("Content-Type", APPLICATIONJSON);
		headers.put("Accept", APPLICATIONJSON);

		// Add any custom headers passed in
		if (customHeaders != null && !customHeaders.isEmpty()) {
			headers.putAll(customHeaders);
		}

		return headers;
	}

	// Method to send a GET request
	public static String sendGetRequest(String path, String authToken, Map<String, String> customHeaders){
		String jsonEntity = null;

		try {
			HttpGet getRequest = new HttpGet(APPURL+path);

			getRequest.setHeader(AUTHORIZATION, BEARER + authToken);

			// Add custom headers from the map
			if (customHeaders != null && !customHeaders.isEmpty()) {
				for (Map.Entry<String, String> entry : customHeaders.entrySet()) {
					getRequest.setHeader(entry.getKey(), entry.getValue());
				}
			}
			// Execute the HTTP request
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse response = httpClient.execute(getRequest);

			// Get the response status code
			int statusCode = response.getStatusLine().getStatusCode();
			log.info("Status code for the GET request: " + statusCode);

			// Check for a successful response
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				jsonEntity = EntityUtils.toString(entity);  // Convert the response entity to a string
				log.info("Response body: " + jsonEntity);
			} else {
				log.error("Request failed with status code: " + statusCode);
			}
		} catch (ClientProtocolException | ParseException e) {
			log.error(e.getMessage());
		}  catch (IOException ex) {
			log.error(ex.getMessage());
		}

		return jsonEntity;

	}

	public static String sendPostRequest(String path, String authToken,Map<String, String> customHeaders, String jsonBody){
		String jsonEntity = null;

		try {
			
			 // Initialize OkHttpClient
	        OkHttpClient client = new OkHttpClient();

	        // Set up MediaType for JSON
	        MediaType mediaType = MediaType.parse(APPLICATIONJSON);
	        
	     // Request body: set an empty body if the ruleType is "All"
	        RequestBody body;
	        
	        body = RequestBody.create(mediaType, jsonBody); 
	        
	     // Start building the request
	        Request.Builder requestBuilder = new Request.Builder()
	                .url(APPURL)
	                .post(body)  // POST method with body
	                .addHeader("Content-Type", APPLICATIONJSON)
	                .addHeader(AUTHORIZATION, BEARER + authToken);

	        // Add custom headers from the map
	        for (Map.Entry<String, String> entry : customHeaders.entrySet()) {
	            requestBuilder.addHeader(entry.getKey(), entry.getValue());
	        }
	        
	     // Build the final request
	        Request request = requestBuilder.build();
	        
	        Response response = client.newCall(request).execute();

			jsonEntity = response.body().string();
	   

			// Get the response status code
			int statusCode = response.code();
			log.info("Status code for the POST request: " + statusCode);

			// Check for a successful response (status code 200 OK)
			if (statusCode == HttpStatus.SC_OK) {
				log.info("Response body: " + jsonEntity);
			} else {
				log.error("Request failed with status code: " + statusCode);
			}
		} catch (UnsupportedEncodingException | ClientProtocolException e ) {
			log.error(e.getMessage());
		} catch (IOException ex) {
			log.error(ex.getMessage());
		} 

		return jsonEntity;
	}

}
