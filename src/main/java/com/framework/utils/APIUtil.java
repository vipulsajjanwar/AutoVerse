package com.framework.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framwork.pojo.AuthConfig;
import com.framwork.pojo.ConnectionProperty;
import com.framwork.pojo.Info;
import com.framwork.pojo.RequestPayLoads;
import com.framwork.pojo.ServerConfig;
import com.sun.tools.sjavac.Log;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIUtil {
	
	private APIUtil() {
		
	}
	
	static final Logger log = Logger.getLogger(APIUtil.class);
	
	private static final String BEARER="Bearer ";
	private static final String AUTHORIZATION="Authorization";
	private static final String APPLICATION_JSON="application/json";
	private static final String CONTENT_TYPE="Content-Type";
	
	private static final String CLIENT_ID = "icedq.admin-ui";
	private static final String CLIENT_SECRET = "b2e25665-7fce-49fa-9c63-f7c872dabcf2";
	private static final Pattern TOKEN_PATTERN = Pattern.compile("\"access_token\":\"(.*?)\"");
	
	    private static final String ACCEPT = "Accept";
	    private static final String FORM_URLENCODED = "application/x-www-form-urlencoded";
	    
	    private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	  /**
     * Generates OAuth2 access token by sending a POST request to the token endpoint.
     *
     * @param tokenUrl URL to obtain the token
     * @param username Username for authentication
     * @param password Password for authentication
     * @return access token as a String
     */
	// Method to generate OAuth Bearer Token
    public static String getOAuthBearerToken(String tokenURL, String username, String password) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
            String encodedAuth = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

            String requestBody = "grant_type=password&username=" + username + "&password=" + password;

            URL url = new URL(tokenURL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty(AUTHORIZATION, "Basic " + encodedAuth);
            connection.setRequestProperty(CONTENT_TYPE, FORM_URLENCODED);
            connection.setRequestProperty(ACCEPT, APPLICATION_JSON);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(requestBody.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = connection.getResponseCode();
            InputStream responseStream = (responseCode == 200) 
                ? connection.getInputStream()
                : connection.getErrorStream();

            reader = new BufferedReader(new InputStreamReader(responseStream, StandardCharsets.UTF_8));
            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            String response = responseBuilder.toString();

            // Use regex to extract the token
            Matcher matcher = TOKEN_PATTERN.matcher(response);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                log.error("Token not found in response: " + response);
            }

        } catch (Exception e) {
            log.error("Error while generating token: ", e);
        } finally {
            try {
                if (reader != null) reader.close();
                if (connection != null) connection.disconnect();
            } catch (IOException e) {
                log.error("Error closing resources: ", e);
            }
        }

        return null;
    }
    
    public static String getOAuthBearerToken1(String tokenURL, String username, String password) {
        HttpURLConnection connection = null;

        try {
            // Build encoded Basic Auth string
            String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
            String encodedAuth = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

            // URL-encoded form data
            String requestBody = "grant_type=password&username=" + URLEncoder.encode(username, "UTF-8") +
                                 "&password=" + URLEncoder.encode(password, "UTF-8");

            URL url = new URL(tokenURL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty(AUTHORIZATION, "Basic " + encodedAuth);
            connection.setRequestProperty(CONTENT_TYPE, FORM_URLENCODED);
            connection.setRequestProperty(ACCEPT, APPLICATION_JSON);

            // Write request body using try-with-resources
            try (OutputStream os = connection.getOutputStream()) {
                os.write(requestBody.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = connection.getResponseCode();

            // Read response stream using try-with-resources
            try (InputStream is = (responseCode == 200) ? connection.getInputStream() : connection.getErrorStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }

                String response = responseBuilder.toString();

                if (responseCode == 200) {
                    JSONObject json = new JSONObject(response);
                    return json.optString("access_token", null);
                } else {
                    log.error("Token request failed. HTTP " + responseCode + " - Response: " + response);
                }
            }

        } catch (Exception e) {
            log.error("Error while generating token: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }
    
    
 // Method to generate request headers with support for custom headers
 	public static Map<String, String> generateHeaders(String authToken, Map<String, String> customHeaders) {
 		// Create default headers
 		Map<String, String> headers = new HashMap<>();
 		headers.put(AUTHORIZATION, BEARER + authToken);
 		headers.put(CONTENT_TYPE, APPLICATION_JSON);
 		headers.put(ACCEPT, APPLICATION_JSON);

 		// Add any custom headers passed in
 		if (customHeaders != null && !customHeaders.isEmpty()) {
 			headers.putAll(customHeaders);
 		}

 		return headers;
 	}
 	
 	
 // Method to send a GET request
 	public static String sendGetRequest(String appURL, String path, String authToken, Map<String, String> customHeaders){
 		String jsonEntity = null;

 		try {
 			HttpGet getRequest = new HttpGet(appURL+path);

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
 	
 	public static String sendPostRequest(String appURL, String path, String authToken, Map<String, String> customHeaders, String jsonBody){
		String jsonEntity = null;

		try {
			
			 // Initialize OkHttpClient
	        OkHttpClient client = new OkHttpClient();

	        // Set up MediaType for JSON
	        MediaType mediaType = MediaType.parse(APPLICATION_JSON);
	        
	     // Request body: set an empty body if the ruleType is "All"
	        RequestBody body;
	        
	        body = RequestBody.create(jsonBody, mediaType); 
	        
	     // Start building the request
	        Request.Builder requestBuilder = new Request.Builder()
	                .url(appURL+path)
	                .post(body)  // POST method with body
	                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
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
 	
 	
    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Send a GET request with Bearer token
     */
    public static Response sendGet(String url, String token) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader(AUTHORIZATION, BEARER + token)
                .addHeader(ACCEPT, APPLICATION_JSON)
                .get()
                .build();

        return client.newCall(request).execute();
    }

    /**
     * Send a POST request with JSON payload and Bearer token
     */
    public static Response sendPost(String url, Object bodyObj, String token) throws IOException {
        String json = mapper.writeValueAsString(bodyObj);
        RequestBody body = RequestBody.create(json, MediaType.get(APPLICATION_JSON));

        Request request = new Request.Builder()
                .url(url)
                .addHeader(AUTHORIZATION, BEARER + token)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .post(body)
                .build();

        return client.newCall(request).execute();
    }

    /**
     * Send a PUT request with JSON payload and Bearer token
     */
    public static Response sendPut(String url, Object bodyObj, String token) throws IOException {
       
    	String json = mapper.writeValueAsString(bodyObj);
       
    	RequestBody body = RequestBody.create(json, MediaType.get(APPLICATION_JSON));

        Request request = new Request.Builder()
                .url(url)
                .addHeader(AUTHORIZATION, BEARER + token)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .put(body)
                .build();

        return client.newCall(request).execute();
    }

    /**
     * Send a DELETE request with optional body and Bearer token
    
    public static Response sendDelete(String url, Object bodyObj, String token) throws IOException {
        RequestBody body = null;

        if (bodyObj != null) {
            String json = mapper.writeValueAsString(bodyObj);
            body = RequestBody.create(json, MediaType.get("application/json"));
        }

        Request.Builder builder = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json");

        if (body != null) {
            builder.delete(body);
        } else {
            builder.delete();
        }

        return builder.build().let(client::newCall).execute();
    }
 */
    /**
     * Generate OAuth2 token (password grant type)
     */
    public static String generateOAuth2Token(String tokenUrl, String clientId, String username, String password) {
    	/**      
    	 String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
       String encodedAuth = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
*/
    	
    	String formData = "grant_type="+ URLEncoder.encode("password", StandardCharsets.UTF_8) +
                "&client_id=" + URLEncoder.encode(clientId, StandardCharsets.UTF_8) +
                "&username=" + URLEncoder.encode(username, StandardCharsets.UTF_8) +
                "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8);

    	MediaType mediaType = MediaType.parse(FORM_URLENCODED);
        RequestBody body = RequestBody.create(formData, mediaType);

        Request request = new Request.Builder()
                .url(tokenUrl)
                .post(body)
                .addHeader(CONTENT_TYPE, FORM_URLENCODED)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String res = response.body().string();
                return mapper.readTree(res).get("access_token").asText();
            } else {
                log.error("Token generation failed: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createDBConnectionPayload() {
		String requestbody="";
		try {
			Info info = new Info();
			info.setHost("140.82.201.97");
			info.setPort("50002");
			info.setDatabase("regression_database");
			info.setUseCustomCertificates(false);

			ServerConfig serverConfig = new ServerConfig();
			serverConfig.setUseJDBCurl(false);
			serverConfig.setJdbcUrl("jdbc:oracle:thin:@[host]:[port]:[database]");
			serverConfig.setCacheConnectionType("");
			serverConfig.setInfo(info);

			ConnectionProperty prop1 = new ConnectionProperty();
			prop1.setName("loginTimeout");
			prop1.setType("System");
			prop1.setValue("30");

			ConnectionProperty prop2 = new ConnectionProperty();
			prop2.setName("useDateAsTimestamp");
			prop2.setType("System");
			prop2.setValue("false");

			AuthConfig auth = new AuthConfig();
			auth.setUsername("admin");
			auth.setPassword("Oracle");

			RequestPayLoads payload = new RequestPayLoads();
			payload.setName("abc");
			payload.setConnectorId("oracle");
			payload.setDriverId("oracle");
			payload.setServiceProviderName("oracle");
			payload.setAuthTypeId("password");
			payload.setServerInstanceName("");
			payload.setSecretId("scrt-4d710589-2d8d-52f6-b008-b407e077f9ca");
			payload.setSslSecretId(null);
			payload.setUseVault(true);
			payload.setType("System");
			payload.setServerConfig(serverConfig);
			payload.setConnectionProperties(Arrays.asList(prop1, prop2));
			payload.setAuthConfig(auth);
			payload.setCustomFields(Arrays.asList());
			payload.setPreferences(Arrays.asList());

			requestbody = JsonUtil.convertObjectToJson(payload);
		} catch (Exception e) {
			Log.error("Exception occur : "+ e );
		}

		return requestbody;

	}
    
}
