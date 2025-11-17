package com.framework.ai;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // restrict frontend origin
public class CodeGenController {

    @Autowired
    private CodeGenService codeGenService;

    @PostMapping("/generate")
    public ResponseEntity<Map<String, Object>> generate(
            @RequestParam String prompt,
            @RequestParam String path) {
        try {
            String result = codeGenService.generateCode(prompt, path);
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", result
            ));
        } catch (SecurityException se) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                    "status", "error",
                    "message", "Invalid file path: " + se.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "error",
                    "message", e.getMessage()
            ));
        }
    }
}
