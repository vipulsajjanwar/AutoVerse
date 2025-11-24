package com.framework.integration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Lightweight and flexible generative AI utility that supports:
 *  - OpenAI API
 *  - Azure OpenAI
 *  - Google Gemini (via API gateway)
 *  - Any custom LLM endpoint
 * 
 * Designed for Selenium + TestNG frameworks.
 */
public class GenerativeAIUtil {

    private static final Logger log = LogManager.getLogger(GenerativeAIUtil.class);

    private static String MODEL = "gpt-4.1-mini";  
    private static String ENDPOINT = "https://api.openai.com/v1/chat/completions";
    private static String API_KEY = System.getenv("GENAI_KEY");

    private GenerativeAIUtil() {}

    /**
     * Easy method to switch model dynamically.
     */
    public static void setModel(String modelName) {
        MODEL = modelName;
    }

    /**
     * Configure endpoint for:
     *  OpenAI / Azure OpenAI / Gemini Proxy / Private LLM
     */
    public static void setEndpoint(String endpoint) {
        ENDPOINT = endpoint;
    }

    /**
     * Main method to generate AI text.
     */
    public static String generate(String prompt) {
        try {

            if (API_KEY == null || API_KEY.isEmpty()) {
                throw new RuntimeException("GENAI_KEY env variable not set!");
            }

            JSONObject json = new JSONObject();
            json.put("model", MODEL);

            JSONArray messages = new JSONArray();
            JSONObject userMsg = new JSONObject();
            userMsg.put("role", "user");
            userMsg.put("content", prompt);
            messages.put(userMsg);

            json.put("messages", messages);
            json.put("temperature", 0.3);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDPOINT))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject result = new JSONObject(response.body());
            return result.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content")
                    .trim();

        } catch (Exception e) {
            log.error("Generative AI error: {}", e.getMessage());
            return "AI generation failed: " + e.getMessage();
        }
    }

    /**
     * AI-based Test Failure Root Cause Explanation
     */
    public static String explainFailure(String testName, String stacktrace) {
        String prompt =
                "Explain root cause of following test failure in short:\n\n" +
                "Test Name: " + testName + "\n\n" +
                "Stacktrace:\n" + stacktrace +
                "\n\nGive a simple, developer-friendly summary.";

        return generate(prompt);
    }

    /**
     * AI-based Email Report Summary Generator
     */
    public static String generateEmailSummary(int passed, int failed, int skipped) {
        String prompt =
                "Create a short HTML summary for an automation test execution:\n" +
                "Passed: " + passed + "\n" +
                "Failed: " + failed + "\n" +
                "Skipped: " + skipped + "\n" +
                "Write 3-4 lines. Professional tone.";

        return generate(prompt);
    }

    /**
     * Auto-generate a meaningful commit message
     */
    public static String generateCommitMessage(String changedFiles) {
        String prompt =
                "Write a clean Git commit message summarizing changes:\n" +
                changedFiles +
                "\nFollow: <type>: <scope>: <description>";

        return generate(prompt);
    }

    /**
     * Convert image description or OCR text into human readable summary
     */
    public static String summarizeScreenshotResult(String extractedText) {
        String prompt =
                "Summarize the following screenshot OCR text into a short description:\n" +
                extractedText;

        return generate(prompt);
    }
}
