package com.webteam_rest.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	private Properties mailServerProperties;
	private Session getMailSession;
	private MimeMessage generateMailMessage;
	private String userName;
	private String password;
	
	public void setCredentials(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	
	public  void generateAndSendGmailEmail(String toAddr,String subject,String content) throws AddressException, MessagingException {
		 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		this.mailServerProperties = System.getProperties();
		this.mailServerProperties.put("mail.smtp.port", "587");
		this.mailServerProperties.put("mail.smtp.auth", "true");
		this.mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		this.getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		this.generateMailMessage = new MimeMessage(getMailSession);
		this.generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddr));
		
		this.generateMailMessage.setSubject(subject);
		//String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
		this.generateMailMessage.setContent(content, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", this.userName, this.password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
		
}
