package com.framework.ai;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CodeGenService {

    private final OpenAIClient client;
    private static final Path BASE_DIR = Path.of("generated"); // safe root folder

    public CodeGenService() {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("OPENAI_API_KEY environment variable not set");
        }

        this.client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }

    public String generateCode(String prompt, String filePath) throws IOException {
        ChatCompletion completion = client.chat().completions().create(
                ChatCompletionCreateParams.builder()
                        .model(ChatModel.GPT_5) // change if needed
                        .addUserMessage(prompt)
                        .build()
        );

        StringBuilder sb = new StringBuilder();
        completion.choices().forEach(choice ->
                choice.message().content().ifPresent(sb::append)
        );

        String output = extractCodeBlock(sb.toString());
        Path safePath = validateAndResolvePath(filePath);

        Files.createDirectories(safePath.getParent());
        Files.writeString(safePath, output,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

        return "✅ Code saved to: " + safePath.toAbsolutePath();
    }

    // Extract code block content from markdown ``` ``` syntax
    private String extractCodeBlock(String text) {
        Matcher matcher = Pattern.compile("```[a-zA-Z0-9]*\\n([\\s\\S]*?)```").matcher(text);
        return matcher.find() ? matcher.group(1).trim() : text.trim();
    }

    // Prevent path traversal and enforce base directory
    private Path validateAndResolvePath(String filePath) {
        Path resolved = BASE_DIR.resolve(filePath).normalize();
        if (!resolved.startsWith(BASE_DIR)) {
            throw new SecurityException("Path outside allowed directory");
        }
        return resolved;
    }
}
