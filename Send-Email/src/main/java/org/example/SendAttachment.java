package org.example;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class SendAttachment {

    public static void sendEmailWithAttachment(String to, String subject, String body, String filePath)
    {
        // Replace these with your email details
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Part two is the attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully with attachment.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email with attachment.");
        }
    }




}
