package com.framework.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.framework.base.BaseClass;
import com.framework.constant.Constant;
import com.framework.utils.FileUtil;
import com.framework.utils.MailUtil;
import com.framework.variables.ExecutionVariables;

public class EmailIntegration extends MailUtil {

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
    public void sendEmail(String subject, 
                          String attachments, 
                          String to, String cc, String bcc) {

        try {
        	
        	String base64Image = MailUtil.encodeImageToBase64(BaseClass.DIR_PATH + "/src/main/resources/assets/icedq-logo.png");
        	String base64Icon = MailUtil.encodeImageToBase64(BaseClass.DIR_PATH + "/src/main/resources/assets/icedqIcon.png");
        	
        	
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
         // Set the body of email
			StringBuilder mailBody = new StringBuilder();
			
			mailBody.append("<html><body style='font-family:Arial;background:#f4f4f9;padding:20px;'>")
            .append("<div style='max-width:900px;margin:auto;background:white;border-radius:8px;padding:20px;'>")

            .append(buildHeaderSection(base64Image))
            .append(buildTableSection(ExecutionVariables.startTime, ExecutionVariables.endTime, ExecutionVariables.suitename, ExecutionVariables.workspaceName, ExecutionVariables.passedTC,  ExecutionVariables.failedTC,  ExecutionVariables.skippedTC))
            .append(buildLinksSection(ExecutionVariables.baseURL, ExecutionVariables.totalcount, Constant.MAIL_SUBJECT))
            .append(buildXraySection("", ""))
            .append(buildKibanaSection(Constant.ELK_ENABLE, ExecutionVariables.suiteType, Constant.KIBANA_URL, Constant.KIBANA_URL, Constant.KIBANA_URL, ExecutionVariables.buildID))
            .append(buildReportSection(ExecutionVariables.suitename))
            .append(buildFooterSection("AutoVerse"))
            .append(buildSignatureSection(base64Icon, "vipul.s"))

            .append("</div></body></html>");
            
            
            htmlPart.setContent(mailBody.toString(), "text/html; charset=UTF-8");
            multipart.addBodyPart(htmlPart);

            addFolderAsZipAttachment(multipart, attachments);

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
        props.put("mail.smtp.socketFactory.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

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

    public void addAttachment(MimeMultipart multipart, String filePath) throws MessagingException {
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
    
    private void addFolderAsZipAttachment(MimeMultipart multipart, String folderPath) throws MessagingException {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            log.warn("Folder not found: " + folderPath);
            return;
        }

        try {
            // Create ZIP file in temp location
            String zipFilePath = folder.getParent() + "/" + folder.getName() + ".zip";
            FileUtil.zipFolder(folderPath, zipFilePath);

            // Attach ZIP file
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(zipFilePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(new File(zipFilePath).getName());

            multipart.addBodyPart(attachmentPart);
            log.info("Attached folder as ZIP: {}", zipFilePath);

        } catch (IOException e) {
            log.error("Failed to zip folder: " + folderPath, e);
        }
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
