package mochi;

import mochi.db.DBConnection;
import mochi.ui.RegistrationUI;
import java.sql.Connection;
import java.util.Properties;

// adjusts the value under "verified" in user table. default is 'new' -> 'verified' when user clicks email link
public class VerifyEmail
{
    public static void sendVerificationEmail(String id, String email, String hash)
    {
        Properties properties = new Properties();
    }
}
