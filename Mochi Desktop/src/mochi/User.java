package mochi;

import mochi.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class User
{
    String username;
    String password;
    String email;
    String verified;
    String dateOfBirth;

    private Connection database;


    public User(String username, String password, String email)
    {
        this.database = DBConnection.getDatabase();


        try
        {
            Statement statement = database.createStatement();
            String sql = "INSERT INTO user " + " (username, password, email)" + " VALUES (username, password, email)";
            statement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return;
        }

    }
}
