//This class is use to send the email to client after the confirmation of the signup process

package signup;

import java.util.Properties;


import javax.mail.*;
import javax.mail.internet.*;


public class signupconfirmmail 
{
/*	public static void main(String [] args)
	{
		
		send("shaharyarshamshi@gmail.com");
	} */
	public  static void send(String email)
	{
		System.out.println("welcome ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		Properties prop=new Properties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		//prop.put("proxySet","true");
       // prop.put("socksProxyHost","172.16.20.2");
        //prop.put("socksProxyPort","3128");
		prop.put("mail.smtp.starttls.enable", "true");
		Session session=Session.getDefaultInstance(prop);
		session.setDebug(true);
           Message message=new MimeMessage(session);
           try
           {
        	   message.setSubject("Confirmation mail");
        	   message.setText("Welcome to the cross Platform payment portal ."
        	   		+ "now you can transfer money across different portal efficiently."
        			   +"Thanks for joining Do share your experience with your friend and help us to enhance our customer base");
           }
           catch(Exception e)
           {
        	   System.out.println("error 1");
           }
           try
           {
        	   Address to=new InternetAddress(email);
        	   Address from=new InternetAddress("shaharyarshamshi@gmail.com"); //the sender email id
        	   message.setFrom(from);
        	   message.setRecipient(Message.RecipientType.TO,to);
        	   Transport transport=session.getTransport();
        	   transport.connect("shaharyarshamshi@gmail.com", "MODERNHITLER");
        	   transport.sendMessage(message, message.getAllRecipients());
        	   transport.close();
        	   
           }
           catch (Exception e)
           {
        	   System.out.println("error 2");
           }
	}
           
          
	}


