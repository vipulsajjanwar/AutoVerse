package com.framework.integration;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * EmailReportMailer
 *
 * A reusable, customizable Java utility to build and send automation-report emails.
 * Features:
 *  - Section-based builder methods (title + content)
 *  - HTML body support with table/grid helper
 *  - Attach files, zipped attachments, HTML reports, and log text
 *  - Simple send(...) method using JavaMail (javax.mail / Jakarta Mail)
 *
 * Dependencies:
 *  - javax.mail (or jakarta.mail)
 *  - activation (for older Java versions; newer JDK may include)
 *
 * Usage: see main(...) at bottom for an example.
 */
// Updated for TestNG integration – supports IReporter & Listener hooks
public class EmailReportMailer {

    private final Properties smtpProps = new Properties();
    private String username;
    private String password;

    // Mail metadata
    private String from;
    private final List<String> to = new ArrayList<>();
    private final List<String> cc = new ArrayList<>();
    private String subject = "Automation Report";

    // HTML sections, in order added
    private final List<Section> sections = new ArrayList<>();

    // attachments (file path or in-memory)
    private final List<File> fileAttachments = new ArrayList<>();
    private final List<InMemoryAttachment> inMemoryAttachments = new ArrayList<>();

    public EmailReportMailer() {
        // sensible defaults (can be overridden)
        smtpProps.put("mail.smtp.auth", "true");
        smtpProps.put("mail.smtp.starttls.enable", "true");
    }

    // ---- SMTP / Credentials configuration ----
    public EmailReportMailer withSmtpHost(String host) {
        smtpProps.put("mail.smtp.host", host);
        return this;
    }

    public EmailReportMailer withSmtpPort(int port) {
        smtpProps.put("mail.smtp.port", String.valueOf(port));
        return this;
    }

    public EmailReportMailer withCredentials(String username, String password) {
        this.username = username;
        this.password = password;
        return this;
    }

    public EmailReportMailer withFrom(String from) {
        this.from = from;
        return this;
    }

    public EmailReportMailer addTo(String recipient) {
        this.to.add(recipient);
        return this;
    }

    public EmailReportMailer addCc(String recipient) {
        this.cc.add(recipient);
        return this;
    }

    public EmailReportMailer withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    // ---- Sections & body building ----
    public EmailReportMailer addSection(String title, String htmlContent) {
        sections.add(new Section(title, htmlContent));
        return this;
    }

    public EmailReportMailer addPlainTextSection(String title, String plainText) {
        String escaped = escapeHtml(plainText).replace("\n", "<br/>");
        sections.add(new Section(title, escaped));
        return this;
    }

    /**
     * Helper to add an HTML table section. headers is a list of header strings.
     * rows is a list of rows, each row is a list of cell values.
     */
    public EmailReportMailer addTableSection(String title, List<String> headers, List<List<String>> rows) {
        String tableHtml = buildHtmlTable(headers, rows);
        sections.add(new Section(title, tableHtml));
        return this;
    }

    // ---- Attachments ----
    public EmailReportMailer attachFile(File f) {
        if (f != null && f.exists()) fileAttachments.add(f);
        return this;
    }

    public EmailReportMailer attachFile(String path) {
        return attachFile(new File(path));
    }

    public EmailReportMailer attachLog(String filename, String logContent) {
        inMemoryAttachments.add(new InMemoryAttachment(filename, logContent.getBytes(StandardCharsets.UTF_8), "text/plain"));
        return this;
    }

    public EmailReportMailer attachHtmlReport(String filename, String htmlContent) {
        inMemoryAttachments.add(new InMemoryAttachment(filename, htmlContent.getBytes(StandardCharsets.UTF_8), "text/html; charset=UTF-8"));
        return this;
    }

    /**
     * Create a zip in-memory containing the provided files (file paths may be on disk)
     * and attach the resulting zip as an in-memory attachment.
     */
    public EmailReportMailer attachZip(String zipFileName, List<File> filesToZip) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ZipOutputStream zos = new ZipOutputStream(baos)) {
            for (File f : filesToZip) {
                if (f == null || !f.exists()) continue;
                ZipEntry entry = new ZipEntry(f.getName());
                zos.putNextEntry(entry);
                Files.copy(f.toPath(), zos);
                zos.closeEntry();
            }
        }
        inMemoryAttachments.add(new InMemoryAttachment(zipFileName, baos.toByteArray(), "application/zip"));
        return this;
    }

    // ---- Send ----
    public void send() throws MessagingException, UnsupportedEncodingException {
        if (smtpProps.getProperty("mail.smtp.host") == null) {
            throw new IllegalStateException("SMTP host not configured. Call withSmtpHost(...)");
        }
        Session session = Session.getInstance(smtpProps, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                if (username != null && password != null) {
                    return new PasswordAuthentication(username, password);
                }
                return null;
            }
        });

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", to)));
            if (!cc.isEmpty()) {
                msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(String.join(",", cc)));
            }
            msg.setSubject(subject, "UTF-8");

            MimeMultipart rootMultipart = new MimeMultipart("mixed"); // attachments + body

            // Body part (alternative: html + plain)
            MimeBodyPart bodyPart = new MimeBodyPart();
            MimeMultipart alternative = new MimeMultipart("alternative");

            // plain text fallback
            MimeBodyPart plain = new MimeBodyPart();
            plain.setText(buildPlainTextSummary(), "UTF-8");
            alternative.addBodyPart(plain);

            // HTML part
            MimeBodyPart htmlPart = new MimeBodyPart();
            String htmlBody = buildFullHtmlBody();
            htmlPart.setContent(htmlBody, "text/html; charset=UTF-8");
            alternative.addBodyPart(htmlPart);

            bodyPart.setContent(alternative);
            rootMultipart.addBodyPart(bodyPart);

            // add file attachments from disk
            for (File f : fileAttachments) {
                MimeBodyPart att = new MimeBodyPart();
                DataSource source = new FileDataSource(f);
                att.setDataHandler(new DataHandler(source));
                att.setFileName(MimeUtility.encodeText(f.getName(), "UTF-8", null));
                rootMultipart.addBodyPart(att);
            }

            // add in-memory attachments
            for (InMemoryAttachment a : inMemoryAttachments) {
                MimeBodyPart att = new MimeBodyPart();
                DataSource ds = new ByteArrayDataSource(a.data, a.mimeType);
                att.setDataHandler(new DataHandler(ds));
                att.setFileName(MimeUtility.encodeText(a.filename, "UTF-8", null));
                rootMultipart.addBodyPart(att);
            }

            msg.setContent(rootMultipart);
            msg.setSentDate(new Date());

            Transport.send(msg);
        } catch (MessagingException | UnsupportedEncodingException ex) {
            throw ex;
        }
    }

    // ---- Helpers ----
    private String buildPlainTextSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(subject).append("\n\n");
        for (Section s : sections) {
            sb.append(s.title).append("\n");
            sb.append(stripHtml(s.htmlContent)).append("\n\n");
        }
        if (!fileAttachments.isEmpty() || !inMemoryAttachments.isEmpty()) {
            sb.append("Attachments: \n");
            for (File f : fileAttachments) sb.append(" - ").append(f.getName()).append("\n");
            for (InMemoryAttachment a : inMemoryAttachments) sb.append(" - ").append(a.filename).append("\n");
        }
        return sb.toString();
    }

    private String buildFullHtmlBody() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html><html><head><meta charset=\"utf-8\"><style>")
                .append(defaultStyles())
                .append("</style></head><body>");

        sb.append("<h1>").append(escapeHtml(subject)).append("</h1>");
        for (Section s : sections) {
            sb.append("<div class=\"section\">\n");
            if (s.title != null && !s.title.isEmpty()) {
                sb.append("<h2>").append(escapeHtml(s.title)).append("</h2>\n");
            }
            sb.append(s.htmlContent).append("\n");
            sb.append("</div>\n");
        }

        // attachments list (informational only)
        if (!fileAttachments.isEmpty() || !inMemoryAttachments.isEmpty()) {
            sb.append("<div class=\"attachments\"><h3>Attachments</h3><ul>");
            for (File f : fileAttachments) sb.append("<li>").append(escapeHtml(f.getName())).append("</li>");
            for (InMemoryAttachment a : inMemoryAttachments) sb.append("<li>").append(escapeHtml(a.filename)).append("</li>");
            sb.append("</ul></div>");
        }

        sb.append("</body></html>");
        return sb.toString();
    }

    private String defaultStyles() {
        return "body{font-family:Arial,Helvetica,sans-serif;font-size:14px;color:#222} h1{font-size:18px;} h2{font-size:16px;border-bottom:1px solid #eaeaea;padding-bottom:4px;} table{border-collapse:collapse;width:100%;margin:8px 0} table th, table td{border:1px solid #ddd;padding:6px;text-align:left;} .section{margin-bottom:12px;}";
    }

    private String buildHtmlTable(List<String> headers, List<List<String>> rows) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        if (headers != null && !headers.isEmpty()) {
            sb.append("<thead><tr>");
            for (String h : headers) sb.append("<th>").append(escapeHtml(h)).append("</th>");
            sb.append("</tr></thead>");
        }
        sb.append("<tbody>");
        if (rows != null) {
            for (List<String> r : rows) {
                sb.append("<tr>");
                for (String cell : r) sb.append("<td>").append(escapeHtml(cell)).append("</td>");
                sb.append("</tr>");
            }
        }
        sb.append("</tbody></table>");
        return sb.toString();
    }

    // Convert basic HTML to plain text (very simple)
    private String stripHtml(String html) {
        return html.replaceAll("<[^>]*>", "").replaceAll("&nbsp;", " ");
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }

    // ---- Inner types ----
    private static class Section {
        final String title;
        final String htmlContent;

        Section(String title, String htmlContent) {
            this.title = title;
            this.htmlContent = htmlContent == null ? "" : htmlContent;
        }
    }

    private static class InMemoryAttachment {
        final String filename;
        final byte[] data;
        final String mimeType;

        InMemoryAttachment(String filename, byte[] data, String mimeType) {
            this.filename = filename;
            this.data = data;
            this.mimeType = mimeType == null ? "application/octet-stream" : mimeType;
        }
    }

    // Simple ByteArrayDataSource to avoid external dependency (works with javax.activation.DataSource usage)
    private static class ByteArrayDataSource implements DataSource {
        private final byte[] data;
        private final String mime;

        ByteArrayDataSource(byte[] data, String mime) {
            this.data = data;
            this.mime = mime == null ? "application/octet-stream" : mime;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(data);
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("Read-only data source");
        }

        @Override
        public String getContentType() {
            return mime;
        }

        @Override
        public String getName() {
            return "ByteArrayDataSource";
        }
    }

    // ---- Example usage ----
    public static void main(String[] args) throws Exception {
        EmailReportMailer mailer = new EmailReportMailer()
                .withSmtpHost("smtp.example.com")
                .withSmtpPort(587)
                .withCredentials("reporter@example.com", "password")
                .withFrom("reporter@example.com")
                .addTo("devteam@example.com")
                .withSubject("Nightly Automation Report")
                ;

        // Add a textual section
        mailer.addPlainTextSection("Summary", "All 120 tests executed. 118 passed, 2 failed.");

        // Add a custom HTML section
        mailer.addSection("Top Failures", "<ul><li>LoginTest - timeout</li><li>PaymentTest - element not found</li></ul>");

        // Add a results table
        List<String> headers = Arrays.asList("Test", "Status", "Duration");
        List<List<String>> rows = new ArrayList<>();
        rows.add(Arrays.asList("LoginTest", "FAILED", "00:01:12"));
        rows.add(Arrays.asList("SearchTest", "PASSED", "00:00:20"));
        mailer.addTableSection("Test Results", headers, rows);

        // Attach a log file
        mailer.attachLog("run.log", "INFO: Started...\nERROR: something broke\n");

        // Attach an HTML report (in-memory)
        mailer.attachHtmlReport("report.html", "<html><body><h1>Report</h1><p>Details...</p></body></html>");

        // Attach files from disk
        // mailer.attachFile(new File("/path/to/selenium-screenshot.png"));

        // Attach zipped artifacts
        // mailer.attachZip("artifacts.zip", Arrays.asList(new File("a.html"), new File("b.log")));

        // Send
        // NOTE: To actually send, provide a working SMTP host, port, and credentials.
        // mailer.send();

        System.out.println("Prepared email (not sent in example). Configure SMTP and call send() to dispatch.");
    }
}
