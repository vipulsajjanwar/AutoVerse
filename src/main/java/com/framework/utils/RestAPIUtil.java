package com.framework.utils;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Modern, Optimized API Utility using OkHttp
 */
public class RestAPIUtil {

    private static final Logger log = LogManager.getLogger(APIUtil.class);
    private static final OkHttpClient client = new OkHttpClient();

    private RestAPIUtil() {}

    // Build URL with query params
    private static String buildUrl(String url, Map<String, String> params) {
        if (params == null || params.isEmpty()) return url;
        StringBuilder sb = new StringBuilder(url);
        sb.append("?");
        params.forEach((k, v) -> sb.append(k).append("=")
                .append(URLEncoder.encode(v, StandardCharsets.UTF_8)).append("&"));
        return sb.substring(0, sb.length() - 1);
    }

    // Generic GET
    public static String get(String url, Map<String, String> headers, Map<String, String> params) {
        try {
            String finalUrl = buildUrl(url, params);
            Request.Builder req = new Request.Builder().url(finalUrl);

            if (headers != null)
                headers.forEach(req::addHeader);

            Response response = client.newCall(req.build()).execute();
            String body = response.body() != null ? response.body().string() : null;

            log.info("GET {} => {}", finalUrl, response.code());
            return body;
        } catch (Exception e) {
            log.error("GET call failed: {}", e.getMessage());
            return null;
        }
    }

    // Generic POST (JSON)
    public static String postJson(String url, Map<String, String> headers, String jsonBody) {
        try {
            RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));

            Request.Builder req = new Request.Builder().url(url).post(body);

            if (headers != null)
                headers.forEach(req::addHeader);

            Response response = client.newCall(req.build()).execute();
            String res = response.body() != null ? response.body().string() : null;

            log.info("POST {} => {}", url, response.code());
            return res;
        } catch (Exception e) {
            log.error("POST failed: {}", e.getMessage());
            return null;
        }
    }

    // Form POST
    public static String postForm(String url, Map<String, String> headers, Map<String, String> formData) {
        try {
            FormBody.Builder form = new FormBody.Builder();
            if (formData != null)
                formData.forEach(form::add);

            Request.Builder req = new Request.Builder().url(url).post(form.build());
            if (headers != null)
                headers.forEach(req::addHeader);

            Response response = client.newCall(req.build()).execute();
            return response.body() != null ? response.body().string() : null;
        } catch (IOException e) {
            log.error("Form POST failed: {}", e.getMessage());
            return null;
        }
    }

    // Delete
    public static String delete(String url, Map<String, String> headers) {
        try {
            Request.Builder req = new Request.Builder().url(url).delete();
            if (headers != null)
                headers.forEach(req::addHeader);

            Response response = client.newCall(req.build()).execute();
            return response.body() != null ? response.body().string() : null;
        } catch (Exception e) {
            log.error("DELETE failed: {}", e.getMessage());
            return null;
        }
    }


    // ================= Retry with Exponential Backoff =================
    private static Response executeWithRetry(Request request, int maxRetries) throws IOException {
        int attempt = 0;
        long waitTime = 1000;
        IOException lastEx;
        while (attempt < maxRetries) {
            try {
                return client.newCall(request).execute();
            } catch (IOException e) {
                lastEx = e;
                attempt++;
                if (attempt >= maxRetries) throw lastEx;
                try { Thread.sleep(waitTime); } catch (InterruptedException ignored) {}
                waitTime *= 2;
            }
        }
        throw new IOException("Retry attempts exceeded");
    }

    // ================= Bearer Token Auto-Refresh =================
    private static String bearerToken;
    private static TokenProvider tokenProvider;

    public interface TokenProvider {
        String refreshToken();
    }

    public static void setTokenProvider(TokenProvider provider) { tokenProvider = provider; }

    private static void applyBearer(Request.Builder req) {
        if (bearerToken != null)
            req.addHeader("Authorization", "Bearer " + bearerToken);
    }

    // ================= API Validator Utility =================
    public static boolean validateStatus(int actual, int expected) {
        return actual == expected;
    }

    public static boolean validateContains(String response, String expected) {
        return response != null && response.contains(expected);
    }

    // ================= Integration with AI Listener =================
    public static String explainFailureAI(String endpoint, String response) {
        return com.framework.integration.GenerativeAIUtil.explainFailure(endpoint, response);
    }

    // ================= Multipart File Upload =================
    public static String uploadFile(String url, Map<String,String> headers, File file) {
        try {
            RequestBody fileBody = RequestBody.create(file, MediaType.parse("application/octet-stream"));
            MultipartBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", file.getName(), fileBody)
                    .build();

            Request.Builder req = new Request.Builder().url(url).post(requestBody);

            if (headers != null) headers.forEach(req::addHeader);
            applyBearer(req);

            Response response = executeWithRetry(req.build(), 3);
            return response.body() != null ? response.body().string() : null;
        } catch (Exception e) {
            return explainFailureAI(url, e.getMessage());
        }
    }
}

