package org.example;


public class Main {
    public static void main(String[] args) {
        // Replace these with the recipient's email, subject, and body
        String to = "recepient-email@gmail.com";
        String subject = "Test Email";
        String body = "This is a test email.";
        String filePath = "D:/Java-Projects/OM Wallet API_v1.2 (1).pdf";

        System.out.println("Sending a Text Email");
        SendMail.SendEmail(to, subject, body);

        System.out.println("Sending an Email with attachment");
        SendAttachment.sendEmailWithAttachment(to, subject, body, filePath);


    }

}