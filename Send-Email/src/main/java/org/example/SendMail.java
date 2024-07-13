package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    // Send Email method
    public static void SendEmail(String To, String Subject, String Body)
    {
        // Email Credentials
        final String username = "your-email@example.com";
        final String password = "your-password";

        // Set properties for the email
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.host.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with an Authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Body);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }

    }
}
