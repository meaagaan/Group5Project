package mochi;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// sends hashed verification email to new users
public class SendVerificationEmailUtil
{
    public static void sendLinkEmail(String id, String recipient, String hash) throws Exception
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        // email server host is Gmail
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // logs in to the mochi gmail account
        String mochiEmail = "mochidesktop@gmail.com";
        String mochiEmailPassword = "NvaleHh1ovGKq1p1";

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mochiEmail, mochiEmailPassword);
            }
        });

        Message message = prepareMessage(session, mochiEmail, recipient);

        Transport.send(message);

    }

    private static Message prepareMessage(Session session, String mochiEmail, String recipient)
    {
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mochiEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("User Email Verification");
            message.setText("Hello, \n " +
                            "Thank you for making an account with Mochi. Please follow the link to verify your" +
                            " account registration: (ADD LINK HERE) \n" +
                            "Thanks! \n" +
                            "(please do not respond to this email)");
            return message;
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
