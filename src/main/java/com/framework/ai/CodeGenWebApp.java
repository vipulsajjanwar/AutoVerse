package com.framework.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CodeGenWebApp {
    public static void main(String[] args) {
        SpringApplication.run(CodeGenWebApp.class, args);
    }

    // Run Spring Boot app on port 2210
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customPort() {
        return factory -> factory.setPort(2210);
    }
}
