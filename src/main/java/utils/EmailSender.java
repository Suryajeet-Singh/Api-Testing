package utils;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.util.Properties;

public class EmailSender {

    public static void sendReport() {

        String fromEmail = System.getProperty("emailUser");
        String password = System.getProperty("emailPassword");
        String toEmail = System.getProperty("emailTo");

        // ✅ Safety Check
        if (fromEmail == null || password == null || toEmail == null) {
            System.out.println("❌ Email properties missing. Skipping email send.");
            return;
        }

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(
                props,
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

            message.setSubject("✅ API Automation Execution Report");

            // Email Body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(
                    "<h3>Automation Execution Completed</h3>" +
                            "<p>Please find attached Extent Report.</p>",
                    "text/html"
            );

            // Attachment
            File reportFile = new File("test-output/ExtentReport.html");

            if (!reportFile.exists()) {
                System.out.println("❌ Extent Report not found!");
                return;
            }

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(reportFile);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("✅ Email Sent Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}