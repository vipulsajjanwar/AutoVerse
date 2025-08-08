package nexgen.automation.framework.sendmail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;

import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;


public class SendMailSSLWithAttachment {

	final  Logger log = Logger.getLogger(SendMailSSLWithAttachment.class);

	String brOpening="<br/>";
	String tdOpeningStyle="<td style='padding: 12px; text-align: center; border: 1px solid #ddd; font-size: 10pt;'>";
	String tdClosing="</td>";
	
	/**String kibanaSanityDashboardUrl=BaseSuite.kibanaURL+"/app/dashboards#/view/25947290-bb78-11ef-a162-ef3f7e9967ee?_a=";
	//String kibanaRegressionDashboardUrl=BaseSuite.kibanaURL+"/app/dashboards#/view/3ccdbac0-bb78-11ef-a162-ef3f7e9967ee?_a=";*/
	String dashboardTitle="<p><strong>Test Execution Dashboard : </strong> <a href='";
	
	String mailSubject = "NextGen iceDQ Test Automation Report : "+PageUtil.getModuleName(BaseSuite.ModuleName).toUpperCase()+" Service : "+ExecutionResult.suitename+" Suite";
	
	public void sendmail(){

		try {
			BaseClassUtil util = new BaseClassUtil();

			ReadConfig mailconfig = new ReadConfig();

			XLUtils xl = new XLUtils();

			// Create object of Property file
			Properties props = new Properties();

			// this will set host of server- you can change based on your requirement
			props.put("mail.smtp.host", mailconfig.emailHost());

			// set the port of socket factory
			props.put("mail.smtp.socketFactory.port", mailconfig.mailPort());

			// set socket factory
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			// set the authentication to true
			props.put("mail.smtp.auth", "true");

			// set the port of SMTP server
			props.put("mail.smtp.port", mailconfig.mailPort());

			props.put("mail.smtp.starttls.enable", "true");

			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,

					new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(mailconfig.mailUserName(), mailconfig.mailPassword());

				}

			});

			try {

				// Create object of MimeMessage class
				Message message = new MimeMessage(session);

				// Set the from address
				message.setFrom(new InternetAddress(mailconfig.mailUserName()));

				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailconfig.to()));

				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailconfig.cc()));

				message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailconfig.bcc()));

				// Add the subject link
				//message.setSubject("NextGen iCEDQ "+BaseSuite.ModuleName.toUpperCase()+" Service "+ExecutionResult.suitename+" Suite Automation Report");
				message.setSubject("NextGen iceDQ Test Automation Report : "+PageUtil.getModuleName(BaseSuite.ModuleName).toUpperCase()+" Service : "+ExecutionResult.suitename+" Suite");
				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();

				// Set the body of email

				StringBuilder mailBody = new StringBuilder();
				mailBody.append("Hi <b>Team</b>,");
				mailBody.append(brOpening);
				mailBody.append(brOpening);
				mailBody.append("This Automation Scripts has been run on Machine : <b>" + util.gethost()
				+ "</b> and following are the results.");



				
				// Mention the file which you want to send
				String fileLocation = System.getProperty("user.dir") + "/reports/"+ExecutionResult.suitename+"-reports";
				String filename = fileLocation+"/"+ BaseSuite.reportname;
				
				String base64Image = encodeImageToBase64(System.getProperty("user.dir") + "/src/main/resources/config/icedq-logo.png");
				
				log.info(filename);

				String file = xl.zipFile(filename, ".zip", fileLocation);

				long size = xl.getFileSizeNIO(file);

				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();

				if(size<=33000)
				{
					/**		mailBody.append("<br/><br/>");
					mailBody.append("<html><body style='font-family:arial'><div align=\"center\">")
					.append("<table style='font-size:10pt' >");

					// add columns in mail
					mailBody.append(
							"<table bgcolor=\"#e0e0e0\" style=\"BORDER-TOP:8px solid;\" width=\"800\" height=\"104\" align=\"center\" border=\"1\"><tr align=\"center\"><th>"
									+ "Start Time (IST)  " + "</th> <th>" +"End Time (IST)  " + "</th> <th>" + "TestSuite Name  "+ "</th> <th>" + "Workspace "
									+ "</th> <th><html><font color=\"green\">" + "Passed "
									+ "</th> <th><html><font color=\"red\">" + "Failed "
									+ "</th> <th><html><font color=\"blue\">" + "Skipped ");

					// add the column results in mail body
					mailBody.append("<tr align=\"center\">");
					mailBody.append("<td>");
					mailBody.append(BaseSuite.timesp);
					mailBody.append("</td>");
					mailBody.append("<td>");
					mailBody.append(BaseSuite.endTime);
					mailBody.append("</td>"); 
					mailBody.append("<td>");
					mailBody.append(ExecutionResult.suitename);
					mailBody.append("</td>");
					mailBody.append("<td>");
					mailBody.append(BaseSuite.WorkspaceName);
					mailBody.append("</td>");
					mailBody.append("<td>");
					mailBody.append("<html><font color=\"green\">").append(ExecutionResult.passedTC).append("</font></html>");
					mailBody.append(" </td>");
					mailBody.append("<td>");
					mailBody.append("<html><font color=\"red\">").append(ExecutionResult.failedTC).append("</font></html>");
					mailBody.append(" </td>");
					mailBody.append("<td>");
					mailBody.append("<html><font color=\"blue\">").append(ExecutionResult.testskip).append("</font></html>");
					mailBody.append(" </td>");
					mailBody.append("</table>");
					mailBody.append("</table></div></body></html>");
					mailBody.append("<br/><br/>");
					mailBody.append("Application URL : ").append("<b>").append(BaseSuite.baseURL).append("</b>");
					mailBody.append("<br/><br/>");
					mailBody.append("Total number of test cases : ").append("<b>").append(ExecutionResult.totalcount).append("</b>");
					if(!BaseSuite.subjectMessage.isEmpty()) {
						mailBody.append("<br/><br/>");
						mailBody.append("About Execution : ").append("<b>").append(BaseSuite.subjectMessage).append("</b>");
					}
					mailBody.append("<br/><br/>");
					mailBody.append("All the test cases status are updated in X-Ray test execution.");
					if(!BaseSuite.executionKey.isEmpty()) {
						mailBody.append("<br/><br/>");
						mailBody.append("X-Ray test execution URL : ").append("<b>").append(mailconfig.xRayBaseUrl()+BaseSuite.executionKey).append("</b>");
					}
					mailBody.append("<br/><br/>");
					mailBody.append("<b>Note</b> :This email was sent automatically by ");
					mailBody.append("<html><font color=\"orange\">").append("<b>"+mailconfig.companyName()+"</b>").append("</font></html>");
					mailBody.append(" System. Please do not reply.");
					mailBody.append("<br/><br/>");
					mailBody.append("<br><b>Thanks,</b><br><b><i>"+mailconfig.mailSignatureName()+".</i></b><br><br>");

					messageBodyPart1.setContent(mailBody.toString(), "text/html");
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();
					 */
					mailBody.append("<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px;'>");
					mailBody.append("<div style='max-width: 900px; margin: 0 auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);'>");
					// Add logo and heading in the same row (side by side)
					mailBody.append("<div style='display: flex; align-items: center; justify-content: center; margin-bottom: 20px;'>");
					
					// Logo on the left
					mailBody.append("<img src='data:image/png;base64," + base64Image + "' alt='Company Logo' style='max-width: 100px; height: auto; margin-right: 10px;'/>");
					
					// Heading on the right
					mailBody.append("<h3 style='color: #333;'>Test Automation Results</h3>");
					
					mailBody.append("</div>");
					
					// Add a blue line under the heading
					mailBody.append("<hr style='border: none; border-top: 3px solid #4b7ad3; margin-top: 10px; margin-bottom: 20px;'/>");


					// Table Styling
					mailBody.append("<table style='width: 100%; border-collapse: collapse; margin-top: 20px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); border-radius: 8px; table-layout: auto;'>");

					// Table Header
					mailBody.append("<thead style='background-color: #4b7ad3; color: white; text-align: center; font-size: 14px;'>");
					mailBody.append("<tr>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Start Time (IST)</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>End Time (IST)</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Test Suite Name</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Workspace</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Passed</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Failed</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Skipped</th>");
					mailBody.append("</tr>");
					mailBody.append("</thead>");

					// Table Body (data rows)
					mailBody.append("<tbody style='background-color: #ffffff; font-size: 13px;'>");

					// Striped Row Effect: Alternating background colors
					mailBody.append("<tr style='background-color: #f2f2f2;'>");
					mailBody.append(tdOpeningStyle + BaseSuite.timesp + tdClosing);
					mailBody.append(tdOpeningStyle + BaseSuite.endTime + tdClosing);
					mailBody.append(tdOpeningStyle + ExecutionResult.suitename + tdClosing);
					mailBody.append(tdOpeningStyle + BaseSuite.WorkspaceName + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: green; font-size: 14pt;'>" + ExecutionResult.passedTC + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: red; font-size: 14pt;'>" + ExecutionResult.failedTC + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: blue; font-size: 14pt;'>" + ExecutionResult.testskip + tdClosing);
					mailBody.append("</tr>");

					mailBody.append("</tbody>");

					mailBody.append("</table>");
					mailBody.append(brOpening);

					mailBody.append("<p><strong>Application URL:</strong> <a href='" + BaseSuite.baseURL + "' style='color: #007bff; text-decoration: none;'>"
							+ BaseSuite.baseURL + "</a></p>");
					mailBody.append("<p><strong>Total number of test cases:</strong> <b>" + ExecutionResult.totalcount + "</b></p>");

					if(!BaseSuite.subjectMessage.isEmpty()) {
						mailBody.append("<p><strong>About Execution:</strong> <b>" + BaseSuite.subjectMessage + "</b></p>");
					}

					mailBody.append("<p>All the test case statuses have been updated in X-Ray test execution.");
					if(!BaseSuite.executionKey.isEmpty()) {
	
						mailBody.append("<p><strong>X-Ray test execution URL:</strong> <a href='" + mailconfig.xRayBaseUrl() + BaseSuite.executionKey + "' style='color: #007bff;'>"
								+ mailconfig.xRayBaseUrl() + BaseSuite.executionKey + "</a></p>");
					}

					
					mailBody.append("<b>Note:</b> This email was sent automatically by ");
					mailBody.append("<span style='color: orange; font-weight: bold;'>" + mailconfig.companyName() + "</span> system. Please do not reply.");
					mailBody.append("<br/><br/>");

					mailBody.append("<p><b>Thanks,</b></p>");
					mailBody.append("<p><i>" + mailconfig.mailSignatureName() + "</i></p>");

					mailBody.append("</div>");
					mailBody.append("</body></html>");

					messageBodyPart1.setContent(mailBody.toString(), "text/html");
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();

					// Create data source and pass the filename
					DataSource source = new FileDataSource(file);

					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));

					// set the file
					messageBodyPart2.setFileName(new File(file).getName());

					// add body part 1
					multipart.addBodyPart(messageBodyPart2);

				}
				else 
				{
					mailBody.append("<br/><br/>");
					mailBody.append("Due to enormous log details, report log file size has been increased. It has exceeded attachment size limit of outlook hence sharing below link, where you can find complete report log.");
					mailBody.append("<br/><br/>");
					mailBody.append("<html><body style='font-family:arial'><div align=\"center\">")
					.append("<table style='font-size:10pt' >");

					// add columns in mail
					mailBody.append(
							"<table bgcolor=\"#e0e0e0\" style=\"BORDER-TOP:8px solid;\" width=\"800\" height=\"104\" align=\"center\" border=\"1\"><tr align=\"center\"><th>"
									+ "Start Time (IST)  " + "</th> <th>" +"End Time (IST)  " + "</th> <th>" + "TestSuite Name  "+ "</th> <th>" + "Repository "
									+ "</th> <th><html><font color=\"green\">" + "Passed "
									+ "</th> <th><html><font color=\"red\">" + "Failed "
									+ "</th> <th><html><font color=\"blue\">" + "Skipped ");

					// add the column results in mail body
					mailBody.append("<tr align=\"center\">");
					mailBody.append("<td>");
					mailBody.append(BaseSuite.timesp);
					mailBody.append(tdClosing);
					mailBody.append("<td>");
					mailBody.append(BaseSuite.endTime);
					mailBody.append(tdClosing); 
					mailBody.append("<td>");
					mailBody.append(ExecutionResult.suitename);
					mailBody.append(tdClosing);
					mailBody.append("<td>");
					mailBody.append(BaseSuite.WorkspaceName);
					mailBody.append(tdClosing);
					mailBody.append("<td>");
					mailBody.append("<html><font color=\"green\">").append(ExecutionResult.passedTC).append("</font></html>");
					mailBody.append(tdClosing);
					mailBody.append("<td>");
					mailBody.append("<html><font color=\"red\">").append(ExecutionResult.failedTC).append("</font></html>");
					mailBody.append(tdClosing);
					mailBody.append("<td>");
					mailBody.append("<html><font color=\"blue\">").append(ExecutionResult.testskip).append("</font></html>");
					mailBody.append(tdClosing);
					mailBody.append("</table>");
					mailBody.append("</table></div></body></html>");
					mailBody.append("<br/><br/>");
					mailBody.append("Application URL : ").append("<b>").append(BaseSuite.baseURL).append("</b>");
					mailBody.append("<br/><br/>");
					mailBody.append("Total number of test cases : ").append("<b>").append(ExecutionResult.totalcount).append("</b>");
					mailBody.append("<br/><br/>");
					mailBody.append("All the test cases status are updated in X-Ray test execution.");
					if(!BaseSuite.executionKey.isEmpty()) {
						mailBody.append("<br/><br/>");
						mailBody.append("X-Ray test execution URL : ").append("<b>").append(mailconfig.xRayBaseUrl()+BaseSuite.executionKey).append("</b>");
					}
					mailBody.append("<br/><br/>");
					mailBody.append("Report Link : ").append("<b>").append(filename).append("</b>");
					mailBody.append("<br/><br/>");
					mailBody.append("<b>Note</b> :This email was sent automatically by ");
					mailBody.append("<html><font color=\"orange\">").append("<b>"+mailconfig.companyName()+"</b>").append("</font></html>");
					mailBody.append(" System. Please do not reply.");
					mailBody.append("<br/><br/>");
					mailBody.append("<br><b>Thanks,</b><br><b><i>"+mailconfig.mailSignatureName()+".</i></b><br><br>");

					messageBodyPart1.setContent(mailBody.toString(), "text/html");


				}

				// add body part 2
				multipart.addBodyPart(messageBodyPart1);

				// set the content
				message.setContent(multipart);

				// finally send the email
				Transport.send(message);

				log.info("=====Email Sent=====");

			} catch (MessagingException e) {


				log.error(e.getMessage());;

				//log.error(e.getMessage());;
				throw new RuntimeException(e);


			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}

	}
	
	
	public void sendmailNew(){

		try {
			BaseClassUtil util = new BaseClassUtil();

			ReadConfig mailconfig = new ReadConfig();

			XLUtils xl = new XLUtils();

			// Create object of Property file
			Properties props = new Properties();

			// this will set host of server- you can change based on your requirement
			props.put("mail.smtp.host", mailconfig.emailHost());

			// set the port of socket factory
			props.put("mail.smtp.socketFactory.port", mailconfig.mailPort());

			// set socket factory
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			// set the authentication to true
			props.put("mail.smtp.auth", "true");

			// set the port of SMTP server
			props.put("mail.smtp.port", mailconfig.mailPort());

			props.put("mail.smtp.starttls.enable", "true");

			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(mailconfig.mailUserName(), mailconfig.mailPassword());

				}

			});

			try {

				// Create object of MimeMessage class
				Message message = new MimeMessage(session);

				// Set the from address
				message.setFrom(new InternetAddress(mailconfig.mailUserName()));

				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailconfig.to()));

				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailconfig.cc()));

				message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailconfig.bcc()));

				// Add the subject link
				message.setSubject(mailSubject);

				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();

				// Set the body of email
				StringBuilder mailBody = new StringBuilder();
				mailBody.append("Hi <b>Team</b>,");
				mailBody.append(brOpening);
				mailBody.append(brOpening);
				mailBody.append("This automation test suite has been executed on the machine:  <b>" + util.gethost()
				+ "</b>. Please find the summary of the test results below:");



				// Mention the file which you want to send
				String fileLocation = System.getProperty("user.dir") + "/reports/"+BaseSuite.buildId+"/"+ExecutionResult.suitename+"-reports";
				String filename = fileLocation+"/"+ BaseSuite.reportname;

				String base64Image = encodeImageToBase64(System.getProperty("user.dir") + "/src/main/resources/config/icedq-logo.png");
				String base64Icon = encodeImageToBase64(System.getProperty("user.dir") + "/src/main/resources/config/icedqIcon.png");
				

				log.info(filename);

				String file = xl.zipFile(filename, ".zip", fileLocation);

				long size = xl.getFileSizeNIO(file);

				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();

				if(size<=33000)
				{
					mailBody.append("<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px;'>");
					mailBody.append("<div style='max-width: 900px; margin: 0 auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);'>");
					// Add logo and heading in the same row (side by side)
					mailBody.append("<div style='display: flex; align-items: center; justify-content: center; margin-bottom: 20px;'>");

					// Logo on the left
					mailBody.append("<img src='data:image/png;base64," + base64Image + "' alt='Company Logo' style='max-width: 100px; height: auto; margin-right: 10px;'/>");

					// Heading on the right
					mailBody.append("<h3 style='color: #333;'>Test Automation Results</h3>");

					mailBody.append("</div>");

					// Add a blue line under the heading
					mailBody.append("<hr style='border: none; border-top: 3px solid #4b7ad3; margin-top: 10px; margin-bottom: 20px;'/>");


					// Table Styling
					mailBody.append("<table style='width: 100%; border-collapse: collapse; margin-top: 20px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); border-radius: 8px; table-layout: auto;'>");

					// Table Header
					mailBody.append("<thead style='background-color: #4b7ad3; color: white; text-align: center; font-size: 14px;'>");
					mailBody.append("<tr>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Start Time (IST)</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>End Time (IST)</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Test Suite Name</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Workspace</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Passed</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Failed</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Skipped</th>");
					mailBody.append("</tr>");
					mailBody.append("</thead>");

					// Table Body (data rows)
					mailBody.append("<tbody style='background-color: #ffffff; font-size: 13px;'>");

					// Striped Row Effect: Alternating background colors
					mailBody.append("<tr style='background-color: #f2f2f2;'>");
					mailBody.append(tdOpeningStyle + BaseSuite.timesp + tdClosing);
					mailBody.append(tdOpeningStyle + BaseSuite.endTime + tdClosing);
					mailBody.append(tdOpeningStyle + ExecutionResult.suitename + tdClosing);
					mailBody.append(tdOpeningStyle + BaseSuite.WorkspaceName + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: green; font-size: 14pt;'>" + ExecutionResult.passedTC + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: red; font-size: 14pt;'>" + ExecutionResult.failedTC + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: blue; font-size: 14pt;'>" + ExecutionResult.testskip + tdClosing);
					mailBody.append("</tr>");

					mailBody.append("</tbody>");

					mailBody.append("</table>");
					mailBody.append(brOpening);

					mailBody.append("<p><strong>Application URL:</strong> <a href='" + BaseSuite.baseURL + "' style='color: #007bff; text-decoration: none;'>"
							+ BaseSuite.baseURL + "</a></p>");
					mailBody.append("<p><strong>Total number of test cases:</strong> <b>" + ExecutionResult.totalcount + "</b></p>");

					if(!BaseSuite.subjectMessage.isEmpty()) {
						mailBody.append("<p><strong>About Execution:</strong> <b>" + BaseSuite.subjectMessage + "</b></p>");
					}

					mailBody.append("<p><strong>X-Ray Test Execution Status:</strong> All test case statuses have been updated in X-Ray.");
					if(!BaseSuite.executionKey.isEmpty()) {

						mailBody.append("<p><strong>X-Ray test execution URL:</strong> <a href='" + mailconfig.xRayBaseUrl() + BaseSuite.executionKey + "' style='color: #007bff;'>"
								+ mailconfig.xRayBaseUrl() + BaseSuite.executionKey + "</a></p>");
					}
					if(BaseSuite.elkFlag) {
						String kibanaURL="";
						String buildId = BaseSuite.buildId.toLowerCase();
						String queryPart = "(filters:!((meta:(index:sanity-index1,key:buildId,params:(query:'" + buildId + "'),type:phrase),query:(match_phrase:(buildId:'" + buildId + "')))))";
						String encodedQueryPart = URLEncoder.encode(queryPart, StandardCharsets.UTF_8);
						
						if(BaseSuite.suiteType.equalsIgnoreCase("sanity")) {
							kibanaURL = BaseSuite.kibanaURL+mailconfig.kibanaSanityPath() + encodedQueryPart;
							mailBody.append(dashboardTitle + kibanaURL + "' style='color: #007bff; text-decoration: none;'>NextGEN iceDQ Sanity Tests</a></p>");
							
						}else if(BaseSuite.suiteType.equalsIgnoreCase("regression")){
	
							kibanaURL = BaseSuite.kibanaURL+mailconfig.kibanaRegressionPath() + encodedQueryPart;
							mailBody.append(dashboardTitle + kibanaURL + "' style='color: #007bff; text-decoration: none;'>NextGEN iceDQ Regression Tests</a></p>");
							
						}
						
					}
					mailBody.append("<br/><br/>");
					mailBody.append("<b>Note:</b> This email was sent automatically by ");
					mailBody.append("<span style='color: orange; font-weight: bold;'>" + mailconfig.companyName() + "</span> system. Please do not reply.");
					mailBody.append("<br/><br/>");

					mailBody.append("<p><b  style='color: #bbbab5;'>Thanks & Regards,</b></p>");
					mailBody.append("<table style='width: 100%; border-collapse: collapse;'>");
					mailBody.append("  <tr>");
					mailBody.append("    <td style='width: 10%; text-align: center; vertical-align: middle;'>");
					mailBody.append("      <img src='data:image/png;base64," + base64Icon + "' alt='Company Logo' style='max-width: 90px; height: auto;'>");
					mailBody.append("      <a href='https://icedq.com/' style='font-weight: bold; text-decoration: none; color: #4b7ad3;'>iceDQ.ai</a>");
					mailBody.append("</td>");
					mailBody.append("    <td style='padding: 0.1px; width: 0.5px; background-color: #ffdd33; height: 100px;'>&nbsp;</td>"); 
					
					mailBody.append("    <td style='padding-left: 10px; '>");
					mailBody.append("      <b><i style='color: #4b7ad3;'>" + mailconfig.mailSignatureName() + " </i>Team</b><br/>");
					mailBody.append("      <i>Rethink Data Reliability!</i><br/>");
				/**	mailBody.append("      <a href='https://www.linkedin.com/company/icedq'><img src='cid:linkedinLogo' alt='LinkedIn' style='max-width: 10px; height: auto;></a> ");
				//	mailBody.append("      <a href='https://twitter.com/icedq'><img src='cid:xLogo' alt='X' style='max-width: 10px; height: auto;</a> ");
				//	mailBody.append("      <a href='https://www.youtube.com/icedq'><img src='cid:youtubeLogo' alt='YouTube' style='max-width: 10px; height: auto;</a>");*/
					mailBody.append("  </td>");
					mailBody.append("  </tr>");
					mailBody.append("</table>");

					mailBody.append("</div>");
					mailBody.append("</body></html>");

					messageBodyPart1.setContent(mailBody.toString(), "text/html");
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();

					// Create data source and pass the filename
					DataSource source = new FileDataSource(file);

					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));

					// set the file
					messageBodyPart2.setFileName(new File(file).getName());

					// add body part 1
					multipart.addBodyPart(messageBodyPart2);

				}
				else 
				{
					mailBody.append("<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px;'>");
					mailBody.append("<div style='max-width: 900px; margin: 0 auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);'>");
					// Add logo and heading in the same row (side by side)
					mailBody.append("<div style='display: flex; align-items: center; justify-content: center; margin-bottom: 20px;'>");

					// Logo on the left
					mailBody.append("<img src='data:image/png;base64," + base64Image + "' alt='Company Logo' style='max-width: 100px; height: auto; margin-right: 10px;'/>");

					// Heading on the right
					mailBody.append("<h3 style='color: #333;'>Test Automation Results</h3>");

					mailBody.append("</div>");

					// Add a blue line under the heading
					mailBody.append("<hr style='border: none; border-top: 3px solid #4b7ad3; margin-top: 10px; margin-bottom: 20px;'/>");


					// Table Styling
					mailBody.append("<table style='width: 100%; border-collapse: collapse; margin-top: 20px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); border-radius: 8px; table-layout: auto;'>");

					// Table Header
					mailBody.append("<thead style='background-color: #4b7ad3; color: white; text-align: center; font-size: 14px;'>");
					mailBody.append("<tr>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Start Time (IST)</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>End Time (IST)</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Test Suite Name</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Workspace</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Passed</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Failed</th>");
					mailBody.append("<th style='padding: 12px; border: 1px solid #ddd;'>Skipped</th>");
					mailBody.append("</tr>");
					mailBody.append("</thead>");

					// Table Body (data rows)
					mailBody.append("<tbody style='background-color: #ffffff; font-size: 13px;'>");

					// Striped Row Effect: Alternating background colors
					mailBody.append("<tr style='background-color: #f2f2f2;'>");
					mailBody.append(tdOpeningStyle + BaseSuite.timesp + tdClosing);
					mailBody.append(tdOpeningStyle + BaseSuite.endTime + tdClosing);
					mailBody.append(tdOpeningStyle + ExecutionResult.suitename + tdClosing);
					mailBody.append(tdOpeningStyle + BaseSuite.WorkspaceName + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: green; font-size: 14pt;'>" + ExecutionResult.passedTC + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: red; font-size: 14pt;'>" + ExecutionResult.failedTC + tdClosing);
					mailBody.append("<td style='padding: 12px; text-align: center; border: 1px solid #ddd; color: blue; font-size: 14pt;'>" + ExecutionResult.testskip + tdClosing);
					mailBody.append("</tr>");

					mailBody.append("</tbody>");

					mailBody.append("</table>");
					mailBody.append(brOpening);

					mailBody.append("<p><strong>Application URL:</strong> <a href='" + BaseSuite.baseURL + "' style='color: #007bff; text-decoration: none;'>"
							+ BaseSuite.baseURL + "</a></p>");
					mailBody.append("<p><strong>Total number of test cases:</strong> <b>" + ExecutionResult.totalcount + "</b></p>");

					if(!BaseSuite.subjectMessage.isEmpty()) {
						mailBody.append("<p><strong>About Execution:</strong> <b>" + BaseSuite.subjectMessage + "</b></p>");
					}

					mailBody.append("<p>All the test case statuses have been updated in X-Ray test execution.");
					if(!BaseSuite.executionKey.isEmpty()) {

						mailBody.append("<p><strong>X-Ray test execution URL:</strong> <a href='" + mailconfig.xRayBaseUrl() + BaseSuite.executionKey + "' style='color: #007bff;'>"
								+ mailconfig.xRayBaseUrl() + BaseSuite.executionKey + "</a></p>");
					}
					if(BaseSuite.elkFlag) {
						String kibanaURL="";
						String buildId = BaseSuite.buildId.toLowerCase();
						String queryPart = "(filters:!((meta:(index:sanity-index1,key:buildId,params:(query:'" + buildId + "'),type:phrase),query:(match_phrase:(buildId:'" + buildId + "')))))";
						String encodedQueryPart = URLEncoder.encode(queryPart, StandardCharsets.UTF_8);
						
						if(BaseSuite.suiteType.equalsIgnoreCase("sanity")) {
							kibanaURL = BaseSuite.kibanaURL+mailconfig.kibanaSanityPath() + encodedQueryPart;
							mailBody.append(dashboardTitle + kibanaURL + "' style='color: #007bff; text-decoration: none;'>NextGEN iceDQ Sanity Tests</a></p>");
							
						}else if(BaseSuite.suiteType.equalsIgnoreCase("regression")){
	
							kibanaURL = BaseSuite.kibanaURL+mailconfig.kibanaRegressionPath() + encodedQueryPart;
							mailBody.append(dashboardTitle + kibanaURL + "' style='color: #007bff; text-decoration: none;'>NextGEN iceDQ Regression Tests</a></p>");
							
						}
						
					}

					mailBody.append("<br/><br/>");
					mailBody.append("Report Link : ").append("<b>").append(filename).append("</b>");
					mailBody.append("<br/><br/>");
					mailBody.append("<b>Note:</b> This email was sent automatically by ");
					mailBody.append("<span style='color: orange; font-weight: bold;'>" + mailconfig.companyName() + "</span> system. Please do not reply.");
					mailBody.append("<br/><br/>");

					mailBody.append("<p><b  style='color: #bbbab5;'>Thanks & Regards,</b></p>");
					mailBody.append("<table style='width: 100%; border-collapse: collapse;'>");
					mailBody.append("  <tr>");
					mailBody.append("    <td style='width: 10%; text-align: center; vertical-align: middle;'>");
					mailBody.append("      <img src='data:image/png;base64," + base64Icon + "' alt='Company Logo' style='max-width: 90px; height: auto;'>");
					mailBody.append("      <a href='https://icedq.com/' style='font-weight: bold; text-decoration: none; color: #4b7ad3;'>iceDQ.ai</a>");
					mailBody.append("    </td>");
					mailBody.append("    <td style='padding: 0.1px; width: 0.5px; background-color: #ffdd33; height: 100px;'>&nbsp;</td>"); 
					
					mailBody.append("    <td style='padding-left: 10px; '>");
					mailBody.append("      <b><i style='color: #4b7ad3;'>" + mailconfig.mailSignatureName() + " </i>Team</b><br/>");
					mailBody.append("      <i>Rethink Data Reliability!</i><br/>");
				/**	mailBody.append("      <a href='https://www.linkedin.com/company/icedq'><img src='cid:linkedinLogo' alt='LinkedIn' style='max-width: 10px; height: auto;></a> ");
				//	mailBody.append("      <a href='https://twitter.com/icedq'><img src='cid:xLogo' alt='X' style='max-width: 10px; height: auto;</a> ");
				//	mailBody.append("      <a href='https://www.youtube.com/icedq'><img src='cid:youtubeLogo' alt='YouTube' style='max-width: 10px; height: auto;</a>");*/
					mailBody.append("    </td>");
					mailBody.append("  </tr>");
					mailBody.append("</table>");
					

					mailBody.append("</div>");
					mailBody.append("</body></html>");

					messageBodyPart1.setContent(mailBody.toString(), "text/html");


				}

				// add body part 2
				multipart.addBodyPart(messageBodyPart1);

				// set the content
				message.setContent(multipart);

				// finally send the email
				Transport.send(message);

				log.info("=====Email Sent=====");

			} catch (Exception e) {

				log.error(e.getMessage());

				throw new Exception(e);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
	public String encodeImageToBase64(String imagePath) throws IOException {
	    File file = new File(imagePath);
	    FileInputStream fileInputStream = new FileInputStream(file);
	    byte[] imageBytes = new byte[(int) file.length()];
	    fileInputStream.read(imageBytes);
	    fileInputStream.close();
	    return Base64.getEncoder().encodeToString(imageBytes);
	}

}