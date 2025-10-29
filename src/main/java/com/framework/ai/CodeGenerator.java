package com.framework.ai;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

/**
 * Simple code generator that asks an OpenAI model to generate code text
 * and writes it to a specific location on disk.
 *
 * Requirements:
 *  - Set environment variable OPENAI_API_KEY before running the app.
 *  - The project uses the official openai-java client.
 *
 * See README / docs for API usage: https://platform.openai.com/docs/api-reference/chat/create
 */
public class CodeGenerator {

    private final OpenAIClient client;

    public CodeGenerator() {
        // Create client using environment configuration (OPENAI_API_KEY, etc).
        this.client = OpenAIOkHttpClient.fromEnv();
    }

    /**
     * Ask the LLM to generate a source file (for example, a Java class).
     *
     * @param prompt    natural language prompt instructing the model what to generate
     * @param model     model to use (e.g., ChatModel.GPT_4_1 or ChatModel.GPT_4o or ChatModel.GPT_5 depending on your access)
     * @param outPath   full path to write the generated file (directory will be created if required)
     * @throws IOException if writing file fails
     */
    public void generateAndWriteFile(String prompt, ChatModel model, Path outPath) throws IOException {
        // Build request params
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage(prompt)
                .model(model)
                .build();

        // Call the Chat Completions API synchronously
        ChatCompletion completion = client.chat().completions().create(params);

        // Extract assistant content (join multiple choices/messages if present)
        StringBuilder generated = new StringBuilder();
        completion.choices().stream()
                .map(choice -> choice.message().content()) // Optional<String>
                .forEach(opt -> opt.ifPresent(generated::append));

        String generatedText = generated.toString().trim();

        if (generatedText.isEmpty()) {
            throw new IOException("No content returned from model.");
        }

        // Ensure parent directories exist
        Path parent = outPath.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }

        // Write to disk (overwrite if exists)
        Files.writeString(outPath, generatedText,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

        System.out.println("Wrote generated output to: " + outPath.toAbsolutePath() + " ("
                + generatedText.length() + " chars) at " + Instant.now());
    }

    // Demo main: how to call
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage: java -jar code-generator.jar \"<brief prompt>\" <output-file-path>");
            System.err.println("Example: java -jar code-generator.jar \"Generate a Java class named HelloWorld that prints Hello\" ./src/test/java/com/tests/HelloWorld.java");
            System.exit(1);
        }

        String prompt = args[0];
        Path outPath = Path.of(args[1]);

        CodeGenerator gen = new CodeGenerator();

        // Choose a model you have access to; using GPT_4_1 as example — change per your account
        gen.generateAndWriteFile(prompt, ChatModel.GPT_4_1, outPath);
    }
}
