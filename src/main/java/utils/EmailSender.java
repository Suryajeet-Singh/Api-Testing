package utils;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class EmailSender {

    public static void sendReport() {

        final String fromEmail = System.getProperty("emailUser");
        final String password = System.getProperty("emailPassword");
        final String toEmail = System.getProperty("emailTo");

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));

            message.setSubject("API Automation Report");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Automation Execution Completed.\nPlease find attached report.");

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile(new File("test-output/ExtentReport.html"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachment);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("✅ Email Sent Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}