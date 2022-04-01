package com.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {

	public String send(String to,String sub,String msg)
	{
		final String userName="manishpurohit560@gmail.com";
		final String password="manish@123";
		
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		
		//to use https 
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.EnableSSL.enable","true");
		
		//just to debuge the mail process or to see logs
		props.put("mail.debug","true");
		props.put("mail.smtp.auth","true");
		
		Session session = Session.getInstance(props,new Authenticator() {
		
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
			{
				return new javax.mail.PasswordAuthentication(userName, password);
			}
		});
		
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userName));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
		
			//create a multipart object so we can use multiple parts for email content(text,attachements etc..)
			Multipart emailContent=new MimeMultipart();
			
			//text body part
			MimeBodyPart textContent=new MimeBodyPart();
			textContent.setText(msg);
			
		
			try {
				MimeBodyPart attachmentContent=new MimeBodyPart();
				
				attachmentContent.attachFile("C:\\Users\\Lenovo\\Pictures\\Saved Pictures\\Camera Roll\\IMG_7386 (2).JPG");
				
				//adding both the content to the multipart object of email
				emailContent.addBodyPart(attachmentContent);
				emailContent.addBodyPart(textContent);
				
				message.setContent(emailContent);
				Transport.send(message);
				return "email sent";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
			Transport.send(message);
			System.out.println("done");
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}