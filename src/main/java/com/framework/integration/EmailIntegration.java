package com.framework.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailIntegration {

    private static final Logger log = LogManager.getLogger(EmailIntegration.class);

    private final String smtpHost;
    private final String smtpPort;
    private final String username;
    private final String password;

    private EmailIntegration(Builder builder) {
        this.smtpHost = builder.smtpHost;
        this.smtpPort = builder.smtpPort;
        this.username = builder.username;
        this.password = builder.password;
    }

    // ============================
    // ======= SEND EMAIL =========
    // ============================
    public void sendEmail(String subject, String htmlBody, 
                          List<String> attachments, 
                          String to, String cc, String bcc) {

        try {
            Session session = createSession();
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));
            setRecipients(message, Message.RecipientType.TO, to);
            setRecipients(message, Message.RecipientType.CC, cc);
            setRecipients(message, Message.RecipientType.BCC, bcc);
            message.setSubject(subject);

            MimeMultipart multipart = new MimeMultipart("mixed");

            // HTML body
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlBody, "text/html; charset=UTF-8");
            multipart.addBodyPart(htmlPart);

            // Attachments
            if (attachments != null) {
                for (String filePath : attachments) {
                    addAttachment(multipart, filePath);
                }
            }

            message.setContent(multipart);

            Transport.send(message);
            log.info("Email sent successfully.");

        } catch (Exception e) {
            log.error("Failed to send email: " + e.getMessage(), e);
        }
    }

    // ============================
    // ========== HELPERS =========
    // ============================

    private Session createSession() {
        Properties props = new Properties();

        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // TLS
        props.put("mail.smtp.ssl.trust", smtpHost);

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private void setRecipients(MimeMessage message, Message.RecipientType type, String recipients) throws MessagingException {
        if (recipients != null && !recipients.trim().isEmpty()) {
            message.setRecipients(type, InternetAddress.parse(recipients));
        }
    }

    private void addAttachment(MimeMultipart multipart, String filePath) throws MessagingException {
        File file = new File(filePath);
        if (!file.exists()) {
            log.warn("Attachment file not found: " + filePath);
            return;
        }

        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataSource source = new FileDataSource(file);

        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName(file.getName());

        multipart.addBodyPart(attachmentPart);
        log.info("Attached: {}", file.getName());
    }

    // ============================
    // ===== BASE64 ENCODER =======
    // ============================
    public String encodeBase64Image(String imagePath) throws IOException {
        File file = new File(imagePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = fis.readAllBytes();
            return Base64.getEncoder().encodeToString(bytes);
        }
    }

    // ============================
    // ========= BUILDER ==========
    // ============================
    public static class Builder {
        private String smtpHost;
        private String smtpPort;
        private String username;
        private String password;

        public Builder setHost(String host) {
            this.smtpHost = host;
            return this;
        }

        public Builder setPort(String port) {
            this.smtpPort = port;
            return this;
        }

        public Builder setUser(String user) {
            this.username = user;
            return this;
        }

        public Builder setPassword(String pwd) {
            this.password = pwd;
            return this;
        }

        public EmailIntegration build() {
            return new EmailIntegration(this);
        }
    }
    
    /**
     * 
     * 
     * EmailIntegration mailer = new EmailIntegration.Builder()
        .setHost("smtp.gmail.com")
        .setPort("587")
        .setUser("you@gmail.com")
        .setPassword("app-password")
        .build();

mailer.sendEmail(
        "Automation Report",
        htmlTemplate,
        List.of("reports/extent.html", "logs/execution.log"),
        "to@example.com",
        "cc@example.com",
        null
);

     */
}
