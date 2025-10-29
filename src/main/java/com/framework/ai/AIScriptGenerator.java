package com.framework.ai;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class AIScriptGenerator {

	
	private static final String API_KEY = "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";

	    // 🔹 One-call AI → returns Java test + JSON locators
	    public static String generateSeleniumScriptWithLocators(String prompt, String filePath, String url,String packageName) throws Exception 
	    {
	       
	    	   // 1️⃣ Trust all SSL certs for Jsoup
	       
	    	HttpClient client = createInsecureHttpClientAndTrustAll();

	        // 🔹 Fetch DOM with Jsoup
	        Document doc = Jsoup.connect(url).get();
	        String domHtml = doc.outerHtml();

	        String systemPrompt = """
	            Convert the following user prompt into ONLY a valid Java Selenium WebDriver test using TestNG.
	            - Class name must be meaningful and match the filename.
	            - Use ChromeDriver.
	            - Do not include explanations, markdown, or comments outside Java code.

	            Also extract reliable Selenium locators from the given HTML DOM.
	            - Return them as a JSON object after the code.
	            - Keys = element names (snake_case).
	            - Values = {tag, id, name, cssSelector, by_xpath }.
	            - Prefer xpath > value > name > cssSelector > id.

	            ⚠️ Output format:
	            ```java
	            // Java Selenium code
	            ```
	            ```json
	            { "element_name": { ... } }
	            ```
	            """;

	        JSONObject requestBody = new JSONObject()
	                .put("model", "gpt-4o-mini")
	                .put("messages", new JSONArray()
	                        .put(new JSONObject().put("role", "system").put("content", systemPrompt))
	                        .put(new JSONObject().put("role", "user").put("content",
	                                "User prompt: " + prompt + "\nHTML content:\n" + domHtml)))
	                .put("temperature", 0.2)
	                .put("max_tokens", 2000);

	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + API_KEY)
	                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString(), StandardCharsets.UTF_8))
	                .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        JSONObject json = new JSONObject(response.body());

	        if (!json.has("choices")) {
	            throw new RuntimeException("Unexpected AI response: " + response.body());
	        }

	        String content = json.getJSONArray("choices")
	                .getJSONObject(0)
	                .getJSONObject("message")
	                .getString("content");

	        // --- Extract code & locators ---
	        String scriptPart = extractBetween(content, "```java", "```");
	        String locatorsPart = extractBetween(content, "```json", "```");

	        if (scriptPart == null || locatorsPart == null) {
	            throw new RuntimeException("AI response missing java/json blocks:\n" + content);
	        }

	     // --- Fix class name = file name ---
	        String className = new File(filePath).getName().replace(".java", "");
	        scriptPart = scriptPart.replaceAll("public class \\w+", "public class " + className);

	        // --- Add package name ---
	        String packageLine = (packageName != null && !packageName.isBlank())
	                ? "package " + packageName + ";\n\n"
	                : "";

	        String rawScript = packageLine + scriptPart;


	        // --- Process locators ---
	        JSONObject locators = new JSONObject(locatorsPart.trim());
	        StringBuilder locatorsBlock = new StringBuilder("\n    // 🔹 Auto-generated locators\n");

	        for (String key : locators.keySet()) {
	            JSONObject attributes = locators.getJSONObject(key);
	            String chosenLocator = buildLocator(attributes);
	            if (chosenLocator == null) continue;

	            String variableName = toCamelCase(key);
	            locatorsBlock.append("    By ")
	             .append(variableName).append("Locator") // 👈 add suffix
	             .append(" = ")
	             .append(chosenLocator)
	             .append(";\n");


	            // Replace inline By.*(...) with variable
	            for (String attr : attributes.keySet()) {
	                Object rawVal = attributes.get(attr);
	                List<String> values = new ArrayList<>();

	                if (rawVal instanceof JSONArray arr) {
	                    for (int i = 0; i < arr.length(); i++) {
	                        String v = arr.optString(i);
	                        if (v != null && !v.isBlank() && !v.equals("[]")) values.add(v);
	                    }
	                } else {
	                    String v = rawVal.toString();
	                    if (!v.isBlank() && !v.equals("[]")) values.add(v);
	                }

	                for (String val : values) {
	                    String safeValue = val.replaceAll("([\"\\\\])", "\\\\$1");

	                    rawScript = rawScript.replaceAll(
	                    	    "By\\.id\\(" + Pattern.quote("\"" + safeValue + "\"") + "\\)",
	                    	    variableName + "Locator"
	                    	);
	                    rawScript = rawScript.replaceAll(
	                    	    "By\\.name\\(" + Pattern.quote("\"" + safeValue + "\"") + "\\)",
	                    	    variableName + "Locator"
	                    	);
	                    rawScript = rawScript.replaceAll(
	                    	    "By\\.cssSelector\\(" + Pattern.quote("\"" + safeValue + "\"") + "\\)",
	                    	    variableName + "Locator"
	                    	);	                    
	                    
	                    rawScript = rawScript.replaceAll(
	                    	    "By\\.xpath\\(" + Pattern.quote("\"" + safeValue + "\"") + "\\)",
	                    	    variableName + "Locator"
	                    	);
	                }
	            }
	        }

	        // --- Insert locators inside class ---
	        String finalScript;
	        if (rawScript.contains("{")) {
	            int index = rawScript.indexOf("{") + 1;
	            finalScript = rawScript.substring(0, index) + locatorsBlock + rawScript.substring(index);
	        } else {
	            finalScript = rawScript + locatorsBlock;
	        }
	        
	        // --- Replace System.setProperty with WebDriverManager ---
	        finalScript = finalScript.replaceAll(
	            "System\\.setProperty\\(.*?chromedriver.*?\\);",
	            "WebDriverManager.chromedriver().setup();"
	        );

	        // --- Ensure WebDriverManager import is present ---
	        if (!finalScript.contains("import io.github.bonigarcia.wdm.WebDriverManager;")) {
	            finalScript = finalScript.replaceFirst(
	                "(import org\\.testng\\.annotations\\.Test;)",
	                "$1\nimport io.github.bonigarcia.wdm.WebDriverManager;"
	            );
	        }
	  
	        
	     // --- Always add waitForElement helper ---
	       
	        	    int insertPos = finalScript.lastIndexOf("}");
	        	    if (insertPos > 0) {
	        	        String waitHelpers = """
	        	            // 🔹 Generic explicit waits
	        	            private WebElement waitForElementVisible(By locator) {
	        	                return new WebDriverWait(driver, Duration.ofSeconds(30))
	        	                        .until(ExpectedConditions.visibilityOfElementLocated(locator));
	        	            }

	        	            private WebElement waitForElementClickable(By locator) {
	        	                return new WebDriverWait(driver, Duration.ofSeconds(30))
	        	                        .until(ExpectedConditions.elementToBeClickable(locator));
	        	            }

	        	            private WebElement waitForElementPresent(By locator) {
	        	                return new WebDriverWait(driver, Duration.ofSeconds(30))
	        	                        .until(ExpectedConditions.presenceOfElementLocated(locator));
	        	            }

	        	            private boolean waitForElementToDisappear(By locator) {
	        	                return new WebDriverWait(driver, Duration.ofSeconds(30))
	        	                        .until(ExpectedConditions.invisibilityOfElementLocated(locator));
	        	            }

	        	            private boolean waitForTitle(String title) {
	        	                return new WebDriverWait(driver, Duration.ofSeconds(30))
	        	                        .until(ExpectedConditions.titleContains(title));
	        	            }
	        	            """;
	        	        finalScript = finalScript.substring(0, insertPos) + waitHelpers + "\n}";
	        	    }
	        	

	            if (!finalScript.contains("import java.time.Duration;")) {
	                finalScript = finalScript.replaceFirst(
	                    "(import org\\.testng\\.annotations\\.Test;)",
	                    "$1\nimport java.time.Duration;"
	                );
	            }
	            
	            if (!finalScript.contains("import org.openqa.selenium.WebElement;")) {
	                finalScript = finalScript.replaceFirst(
	                    "(import org\\.testng\\.annotations\\.Test;)",
	                    "$1\nimport org.openqa.selenium.WebElement;"
	                );
	            }



	         // --- Remove old WebDriverWait field and constructor usage ---
	            finalScript = finalScript.replaceAll("private WebDriverWait wait;\\s*", "");
	            finalScript = finalScript.replaceAll("wait\\s*=\\s*new WebDriverWait\\(driver,.*?\\);", "");

	            // --- Replace common waits with helper methods ---
	            finalScript = finalScript.replaceAll(
	                "wait\\.until\\(ExpectedConditions\\.visibilityOfElementLocated\\((.*?)\\)\\)",
	                "waitForElementVisible($1)"
	            );

	            finalScript = finalScript.replaceAll(
	                "wait\\.until\\(ExpectedConditions\\.elementToBeClickable\\((.*?)\\)\\)",
	                "waitForElementClickable($1)"
	            );

	            finalScript = finalScript.replaceAll(
	                "wait\\.until\\(ExpectedConditions\\.presenceOfElementLocated\\((.*?)\\)\\)",
	                "waitForElementPresent($1)"
	            );

	            finalScript = finalScript.replaceAll(
	                "wait\\.until\\(ExpectedConditions\\.invisibilityOfElementLocated\\((.*?)\\)\\)",
	                "waitForElementToDisappear($1)"
	            );

	            finalScript = finalScript.replaceAll(
	                "wait\\.until\\(ExpectedConditions\\.titleContains\\((.*?)\\)\\)",
	                "waitForTitle($1)"
	            );


	     
	        saveToFile(filePath, finalScript);
	        return finalScript;
	        
	     
		
	        }
	    

	    // 🔹 Extract helper
	    private static String extractBetween(String text, String start, String end) {
	        int s = text.indexOf(start);
	        if (s == -1) return null;
	        s += start.length();
	        int e = text.indexOf(end, s);
	        if (e == -1) return null;
	        return text.substring(s, e).trim();
	    }
	 // 🔹 Save to File (auto-create package folders if needed)
	    public static void saveToFile(String filePath, String content) throws IOException {
	        File file = new File(filePath);

	        // ✅ If filename does not end with .java, append it
	        if (!filePath.endsWith(".java")) {
	            file = new File(filePath + ".java");
	        }

	        // ✅ Auto-create package directories if missing
	        File parentDir = file.getParentFile();
	        if (parentDir != null && !parentDir.exists()) {
	            boolean created = parentDir.mkdirs();
	            if (created) {
	                System.out.println("📁 Created package directories: " + parentDir.getAbsolutePath());
	            } else {
	                System.out.println("⚠️ Failed to create some directories or already exist: " + parentDir.getAbsolutePath());
	            }
	        }

	        // ✅ Save the file
	        try (FileWriter writer = new FileWriter(file)) {
	            writer.write(content);
	        }

	        System.out.println("✅ Script saved to: " + file.getAbsolutePath());
	    }


	    // 🔹 Build best locator
	    private static String buildLocator(JSONObject attributes) {
	        if (attributes.has("id")) {
	            String id = attributes.optString("id", "").trim();
	            if (!id.isEmpty() && !id.equals("[]")) return "By.id(\"" + id + "\")";
	        }
	        if (attributes.has("name")) {
	            String name = attributes.optString("name", "").trim();
	            if (!name.isEmpty() && !name.equals("[]")) return "By.name(\"" + name + "\")";
	        }
	        if (attributes.has("cssSelector")) {
	            String css = attributes.optString("cssSelector", "").trim();
	            if (!css.isEmpty() && !css.equals("[]")) return "By.cssSelector(\"" + css + "\")";
	        }
	        if (attributes.has("by_xpath")) {
	            Object xpathObj = attributes.get("by_xpath");
	            if (xpathObj instanceof JSONArray arr && arr.length() > 0) {
	                String candidate = arr.optString(0, "").trim();
	                if (!candidate.isEmpty() && !candidate.equals("[]")) return "By.xpath(\"" + candidate + "\")";
	            } else {
	                String candidate = xpathObj.toString().trim();
	                if (!candidate.isEmpty() && !candidate.equals("[]")) return "By.xpath(\"" + candidate + "\")";
	            }
	        }
	        return null;
	    }

	    // 🔹 snake_case → camelCase
	    private static String toCamelCase(String key) {
	        StringBuilder result = new StringBuilder();
	        boolean capitalizeNext = false;
	        for (char c : key.toCharArray()) {
	            if (c == '_' || c == '-') {
	                capitalizeNext = true;
	            } else {
	                if (capitalizeNext) {
	                    result.append(Character.toUpperCase(c));
	                    capitalizeNext = false;
	                } else {
	                    result.append(result.length() == 0 ? Character.toLowerCase(c) : c);
	                }
	            }
	        }
	        return result.toString();
	    }
	    
	    
	 // 🔹 SSL helper – disables certificate validation and returns insecure HttpClient
	    public static HttpClient createInsecureHttpClientAndTrustAll() throws Exception {
	        // 1️⃣ Trust all SSL certs globally (for Jsoup, HttpsURLConnection)
	        TrustManager[] trustAllCerts = new TrustManager[]{
	            new X509TrustManager() {
	                public X509Certificate[] getAcceptedIssuers() { return null; }
	                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
	                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
	            }
	        };

	        SSLContext sc = SSLContext.getInstance("TLS");
	        sc.init(null, trustAllCerts, new SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

	        // 2️⃣ Build and return HttpClient ignoring SSL validation
	        return HttpClient.newBuilder()
	                .sslContext(sc)
	                .build();
	    }

	 

	    
	}

	



	    
	    
	    

	


	   
	

	 
	




