package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MailUtil {

	private static final String tdOpening = "<td style='padding: 12px; text-align: center; border: 1px solid #ddd;'>";
	private static final String tdClosing = "</td>";

	// -----------------------------------------------------------
	// 1) HEADER SECTION (Logo + Title)
	// -----------------------------------------------------------
	public static String buildHeaderSection(String base64Logo) {
		return "<div style='display: flex; align-items: center; justify-content: center; margin-bottom: 20px;'>"
				+ "<img src='data:image/png;base64," + base64Logo + "' style='max-width: 100px; margin-right: 10px;'/>"
				+ "<h3 style='color: #333;'>Test Automation Results</h3>"
				+ "</div>"
				+ "<hr style='border: none; border-top: 3px solid #4b7ad3; margin-top: 10px; margin-bottom: 20px;'/>";
	}

	// -----------------------------------------------------------
	// 2) TABLE (Execution Summary)
	// -----------------------------------------------------------
	public static String buildTableSection(
			String startTime, String endTime, String suiteName, String workspace,
			int passed, int failed, int skipped) {

		StringBuilder sb = new StringBuilder();

		sb.append("<table style='width: 100%; border-collapse: collapse; margin-top: 20px; "
				+ "box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); border-radius: 8px;'>");

		sb.append("<thead style='background-color: #4b7ad3; color: white; text-align: center;'>")
		.append("<tr>")
		.append("<th style='padding: 12px;'>Start Time (IST)</th>")
		.append("<th style='padding: 12px;'>End Time (IST)</th>")
		.append("<th style='padding: 12px;'>Suite</th>")
		.append("<th style='padding: 12px;'>Workspace</th>")
		.append("<th style='padding: 12px;'>Passed</th>")
		.append("<th style='padding: 12px;'>Failed</th>")
		.append("<th style='padding: 12px;'>Skipped</th>")
		.append("</tr></thead>");

		sb.append("<tbody><tr style='background-color: #f2f2f2;'>")
		.append(tdOpening).append(startTime).append(tdClosing)
		.append(tdOpening).append(endTime).append(tdClosing)
		.append(tdOpening).append(suiteName).append(tdClosing)
		.append(tdOpening).append(workspace).append(tdClosing)
		.append("<td style='padding: 12px; border:1px solid #ddd; color: green; font-size: 14pt;'>")
		.append(passed).append("</td>")
		.append("<td style='padding: 12px; border:1px solid #ddd; color: red; font-size: 14pt;'>")
		.append(failed).append("</td>")
		.append("<td style='padding: 12px; border:1px solid #ddd; color: blue; font-size: 14pt;'>")
		.append(skipped).append("</td>")
		.append("</tr></tbody></table><br/>");

		return sb.toString();
	}

	// -----------------------------------------------------------
	// 3) LINKS SECTION (App URL, Total Count, About Execution)
	// -----------------------------------------------------------
	public static String buildLinksSection(String appUrl, int totalCount, String subjectMessage) {

		StringBuilder sb = new StringBuilder();

		sb.append("<p><strong>Application URL:</strong> <a href='")
		.append(appUrl).append("' style='color:#007bff;'>").append(appUrl).append("</a></p>");

		sb.append("<p><strong>Total Test Cases:</strong> <b>")
		.append(totalCount).append("</b></p>");

		if (subjectMessage != null && !subjectMessage.isEmpty()) {
			sb.append("<p><strong>About Execution:</strong> <b>")
			.append(subjectMessage).append("</b></p>");
		}

		return sb.toString();
	}

	// -----------------------------------------------------------
	// 4) XRAY SECTION
	// -----------------------------------------------------------
	public static String buildXraySection(String baseUrl, String execKey) {

		if (execKey == null || execKey.isEmpty()) return "";

		return "<p><strong>X-Ray Execution:</strong> <a href='"
		+ baseUrl + execKey + "' style='color:#007bff;'>"
		+ baseUrl + execKey + "</a></p>";
	}

	// -----------------------------------------------------------
	// 5) KIBANA SECTION
	// -----------------------------------------------------------
	public static String buildKibanaSection(
			boolean elkFlag, String suiteType,
			String kibanaBase, String pathSanity, String pathRegression,
			String buildId) {

		if (!elkFlag) return "";

		try {
			String lower = buildId.toLowerCase();

			String query = "(filters:!((meta:(index:sanity-index1,key:buildId,params:(query:'"
					+ lower
					+ "'),type:phrase),query:(match_phrase:(buildId:'"
					+ lower + "')))))";

			String encoded = URLEncoder.encode(query, StandardCharsets.UTF_8);

			String finalUrl = suiteType.equalsIgnoreCase("sanity")
					? kibanaBase + pathSanity + encoded
							: kibanaBase + pathRegression + encoded;

			String title = suiteType.equalsIgnoreCase("sanity")
					? "NextGEN iceDQ Sanity Tests"
							: "NextGEN iceDQ Regression Tests";

			return "<p><strong>Kibana Dashboard:</strong> <a href='" + finalUrl
					+ "' style='color:#007bff;'>" + title + "</a></p>";

		} catch (Exception e) {
			return "";
		}
	}

	// -----------------------------------------------------------
	// 6) REPORT SECTION
	// -----------------------------------------------------------
	public static String buildReportSection(String reportName) {
		return "<br/><p>Report Link: <b>" + reportName + "</b></p><br/>";
	}

	// -----------------------------------------------------------
	// 7) FOOTER NOTE
	// -----------------------------------------------------------
	public static String buildFooterSection(String companyName) {
		return "<b>Note:</b> This email was generated automatically by "
				+ "<span style='color:orange; font-weight:bold;'>" + companyName
				+ "</span>. Please do not reply.<br/><br/>";
	}

	// -----------------------------------------------------------
	// 8) SIGNATURE SECTION
	// -----------------------------------------------------------
	public static String buildSignatureSection(String base64Icon, String signatureName) {

		return "<p><b style='color:#bbbab5;'>Thanks & Regards,</b></p>"
				+ "<table style='width:100%;'>"
				+ "<tr>"
				+ "<td style='width:10%; text-align:center;'>"
				+ "<img src='data:image/png;base64," + base64Icon + "' style='max-width:90px;'/><br/>"
				+ "<a href='https://icedq.com/' style='color:#4b7ad3;'>iceDQ.ai</a>"
				+ "</td>"
				+ "<td style='width:1%; background:#ffdd33;'></td>"
				+ "<td style='padding-left:10px;'>"
				+ "<b><i style='color:#4b7ad3;'>" + signatureName + " Team</i></b><br/>"
				+ "<i>Rethink Data Reliability!</i>"
				+ "</td>"
				+ "</tr></table>";
	}
	
	public static String encodeImageToBase64(String imagePath) throws IOException {
	    try {
			File file = new File(imagePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] imageBytes = new byte[(int) file.length()];
			fileInputStream.read(imageBytes);
			fileInputStream.close();
			return Base64.getEncoder().encodeToString(imageBytes);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return imagePath;
	}

}
