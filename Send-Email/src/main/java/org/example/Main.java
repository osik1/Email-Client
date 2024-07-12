package org.example;


public class Main {
    public static void main(String[] args) {
        // Replace these with the recipient's email, subject, and body
        String to = "recepient@example.com";
        String subject = "Test Email";
        String body = "This is a test email.";

        SendMail.SendEmail(to, subject, body);

    }

}