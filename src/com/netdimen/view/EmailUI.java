package com.netdimen.view;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.netdimen.config.Config;
import com.netdimen.junit.JUnitAssert;
import com.netdimen.utils.WebDriverUtils;

public class EmailUI {
	
	// Suppress default constructor for noninstantiability
	private EmailUI() {

		throw new AssertionError();
	}

	public static void Send(String subject, String content) {
	      // Recipient's email ID needs to be mentioned.
		  String[] recipients = Config.getInstance().getProperty("mail.recipient").split(",");

	      // Sender's email ID needs to be mentioned
	      String from =  Config.getInstance().getProperty("mail.sender");

	      // Assuming you are sending email from localhost
	      String host = Config.getInstance().getProperty("system.smtpHost");

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         for(String recipient:recipients){
	        	 message.addRecipient(Message.RecipientType.TO,
                         new InternetAddress(recipient));
	         }

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Now set the actual message
	         message.setText(content);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent email successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	
	/**
	 * 
	 * @param driver
	 * @param title: Email Title e.g. Enrollment Confirmation
	 * @param ExpectedContent: Expected email content
	 */

 public static void CheckInternalEmail(WebDriver driver, String title, String ExpectedContent){
		
			Navigator.navigate(driver, Navigator.webElmtMgr.getNavigationPathList(
					"LearningCenter", "2.MyEmails"));
			
			By by = By.xpath("//a[contains(text(),'"+title+"') and descendant::img[contains(@src,'envelop_unread.png')]]");
			JUnitAssert.assertTrue(WebDriverUtils.getHowManyByPresntInPage(driver,by,true)>=1,"Fail to receive email:" + title);
			WebDriverUtils.clickLink(driver, by);
			by=By.xpath("//tr[@class='internal-mail-content']");
			String ActualContent=WebDriverUtils.getText(driver, by);
			JUnitAssert.assertTrue(ActualContent.contains(ExpectedContent), "Email Content is wrong. Expected Result:"+ExpectedContent+";Actual Result:"+ActualContent);		
 }
}
