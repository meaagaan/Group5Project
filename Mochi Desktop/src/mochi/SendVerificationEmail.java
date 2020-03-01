package mochi;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

// sends hashed verification email to new users
public class SendVerificationEmail
{
    public static void sendLinkEmail(String id, String email, String hash)
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        // email server host is Gmail
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mochidesktop@gmail.com", "NvaleHh1ovGKq1p1");
            }
        });


    }
}
