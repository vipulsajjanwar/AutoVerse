package com.framework.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.framework.utils.XLUtil;

public class EmailIntegration {

	public static final Logger log = LogManager.getLogger(EmailIntegration.class);
	
	private EmailIntegration() {}
	
	String brOpening="<br/>";
	String tdOpeningStyle="<td style='padding: 12px; text-align: center; border: 1px solid #ddd; font-size: 10pt;'>";
	String tdClosing="</td>";
	
	String emailHost="";
	String mailPort="";
	String username="";
	String password="";
	static String to="";
	static String cc="";
	static String bcc="";
	static String mailSubject="";
	
	public void sendmailNew(String attachmentFile, StringBuilder mailBody){

		try {
			

			XLUtil xl = new XLUtil();

			// Create object of Property file
			Properties props = new Properties();

			// this will set host of server- you can change based on your requirement
			props.put("mail.smtp.host", emailHost);

			// set the port of socket factory
			props.put("mail.smtp.socketFactory.port", mailPort);

			// set socket factory
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			// set the authentication to true
			props.put("mail.smtp.auth", "true");

			// set the port of SMTP server
			props.put("mail.smtp.port", mailPort);

			props.put("mail.smtp.starttls.enable", "true");

			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);

				}

			});

			try {

				// Create object of MimeMessage class
				Message message = new MimeMessage(session);

				// Set the from address
				message.setFrom(new InternetAddress(username));

				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));

				message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));

				// Add the subject link
				message.setSubject(mailSubject);

				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();

				// Mention the file which you want to send
				String fileLocation = attachmentFile;
				String filename = fileLocation;

				log.info(filename);

				String file = xl.zipFile(filename, ".zip", fileLocation);

				long size = xl.getFileSizeNIO(file);

				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();

				if(size<=33000)
				{
		
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
