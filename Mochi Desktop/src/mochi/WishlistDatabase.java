package mochi;

import mochi.User;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WishlistDatabase {
    Connection connection;

    public WishlistDatabase(Connection connection) {
        this.connection = connection;
    }

    public boolean readFile(String username) throws SQLException, IOException {
        PreparedStatement statement;
        ResultSet resultSet;

        statement = connection.prepareStatement("SELECT wishlist FROM User WHERE username = ?");
        statement.setString(1, username);
        resultSet = statement.executeQuery();

        ArrayList<String> wishlist = new ArrayList<String>();

        System.out.println(resultSet);

        if (resultSet.next() && (resultSet.getObject(1) != null)) {
            File file = new File("db_wishlist.txt");
            FileOutputStream output = new FileOutputStream(file);

            Reader input = resultSet.getCharacterStream("wishlist");

            int character;
            boolean firstLine = true;
            StringBuilder stringBuilder = new StringBuilder();
            while ((character = input.read()) > 0) {
                output.write(character);

                if (!(character == 42 || character == 10 || character == 11 || character == 12 || character == 13)) {
                    stringBuilder.append((char)character);
                }
                else {
                    wishlist.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            return (true && User.setWishlist(wishlist));
        }
        return false;
    }

    public boolean writeFile(String username) throws SQLException, FileNotFoundException {
        PreparedStatement statement;

        statement = connection.prepareStatement("UPDATE User SET wishlist = ? WHERE username = ?");
        statement.setString(2, username);

        File file = new File("wishlist.txt");
        FileReader input = new FileReader(file);

        if (input != null) {
            statement.setCharacterStream(1, input);
            statement.executeUpdate();
            return true;
        }
        return false;
    }

    public boolean writeText(ArrayList<String> wishlist) {
        try {
            FileWriter myWriter = new FileWriter("wishlist.txt");
            if (wishlist == null) {
                return false;
            }
            else {
                for (String s : wishlist) {
                    myWriter.write(s);
                    myWriter.write('*');
                }
                myWriter.close();
                return true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
}
