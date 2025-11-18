package com.framework.ai;

import static spark.Spark.*;

import java.io.File;

import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WebServer {

    public static void main(String[] args) {
        // Run on port 9090
        port(9090);

        // Serve static files from /resources/public
        staticFiles.location("/assets");

        // API endpoint
        post("/generate-test", (req, res) -> {
            res.type("application/json");

            try {
                JsonObject body = JsonParser.parseString(req.body()).getAsJsonObject();

                String prompt = body.get("prompt").getAsString();
                String url = body.has("url") ? body.get("url").getAsString() : "https://qa.onprem.icedq.com/";
                String fullClassPath = body.has("fullClassPath")
                        ? body.get("fullClassPath").getAsString()
                        : body.get("filename").getAsString();

                // ✅ Convert package/class to proper file path
                String baseDir = "src/test/java";
                String filePath = buildJavaFilePath(baseDir, fullClassPath);

                // ✅ Ensure directory exists
                File file = new File(filePath);
                if (!file.getParentFile().exists()) {
                    boolean created = file.getParentFile().mkdirs();
                    if (created) {
                        System.out.println("📁 Created package directories: " + file.getParentFile().getAbsolutePath());
                    }
                }

                // ✅ Extract package name
                String packageName = extractPackageName(fullClassPath);

                // ✅ Generate Selenium code
                String generatedCode = AIScriptGenerator.generateSeleniumScriptWithLocators(
                        prompt, filePath, url, packageName
                );

                JSONObject response = new JSONObject();
                response.put("status", "success");
                response.put("path", filePath);
                response.put("package", packageName);
                response.put("code", generatedCode);

                return response.toString(2);

            } catch (Exception e) {
                res.status(500);
                JSONObject error = new JSONObject();
                error.put("status", "error");
                error.put("message", e.getMessage());
                return error.toString(2);
            }
        });
    }

    // ✅ Build full file path from package + class name
    private static String buildJavaFilePath(String baseDir, String fullClassPath) {
        // Add .java extension if missing
        if (!fullClassPath.endsWith(".java")) {
            fullClassPath = fullClassPath + ".java";
        }

        // Replace dots (.) with slashes (/)
        String relativePath = fullClassPath.replace('.', '/');

        // Make sure we don’t end up with /java.java at the end
        relativePath = relativePath.replace("/java", ".java");

        // Return combined path
        return baseDir + (baseDir.endsWith("/") ? "" : "/") + relativePath;
    }

    // ✅ Extract package name for generator usage
    private static String extractPackageName(String fullClassPath) {
        if (fullClassPath.contains(".")) {
            int lastDot = fullClassPath.lastIndexOf('.');
            return fullClassPath.substring(0, lastDot);
        }
        return "";
    }
}
