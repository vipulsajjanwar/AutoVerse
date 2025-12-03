package com.framework.utils;

import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ELKUtil {

	private ELKUtil(){}
	public static final Logger log = LogManager.getLogger(ELKUtil.class);

	static boolean flag= false;
	static String elkurl = "";
	static String elkusername= "";
	static String elkpassword= "";
	static String indexType ="_doc";
	static String datetimeFormat = "yyyy/MM/dd HH:mm:ss";
	static String dateFormat = "yyyy/MM/dd";

	public static void sendDetailsToElk(String testCaseId, String requestBodyContent ) {

		try {
			if(!flag) return;

			String xrayid = testCaseId;

			String credentials = elkusername + ":" + elkpassword;
			String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

			OkHttpClient client = new OkHttpClient().newBuilder().build();

			MediaType mediaType = MediaType.parse("application/json");

			RequestBody body = RequestBody.create(requestBodyContent, mediaType);

			String elkdocURL = elkurl+xrayid;

			log.info("ElasticSearch Request URL: {}",elkdocURL);
			log.info("ElasticSearch Request body: {}",requestBodyContent);

			Request request = new Request.Builder()

					.url(elkdocURL).method("POST", body)

					.addHeader("content-type", "application/json")

					.addHeader("Authorization", "Basic " + encodedCredentials)

					.build();

			Response response = client.newCall(request).execute();

			/**	Assert.assertEquals(response.code(), 201);*/

			log.info("ElasticSearch Response code: {}",response.code());

			String responseBody = response.body().string(); // Get the response body as a string

			log.info("ElasticSearch Response Body: {}", responseBody);  // Log the response body


		} catch (Exception e) {
			log.info(e.getMessage());
		}finally {

			log.info("");
		}

	}
}
