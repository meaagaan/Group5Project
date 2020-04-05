package mochi;

import mochi.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User
{
    private static String username = null;
    private static String firstname = null;
    private static String lastname = null;
    private static String email = null;
    private static Integer verified = null;
    private static ArrayList<Product> wishlist = null;
    private static ArrayList<Product> librarytList = null;

    public static boolean setUsername(String userUsername) {
        username = userUsername;
        if (username == null)
            return false;
        return true;
    }

    public static boolean setFirstname(String userFirstname) {
        firstname = userFirstname;
        if (firstname == null)
            return false;
        return true;
    }

    public static boolean setLastname(String userLastname) {
        lastname = userLastname;
        if (lastname == null)
            return false;
        return true;
    }

    public static boolean setEmail(String userEmail) {
        email = userEmail;
        if (email == null)
            return false;
        return true;
    }

    public static boolean setVerified(int userStatus) {
        verified = userStatus;
        if (verified == null)
            return false;
        return true;
    }

    public static boolean setWishlist(ArrayList userWishlist) {
        wishlist = userWishlist;
        if (wishlist == null)
            return false;
        return true;
    }

    public static boolean setLibraryList(ArrayList userLibraryList) {
        librarytList = userLibraryList;
        if (librarytList == null)
            return false;
        return true;
    }

    public static String getUsername() {
        return username;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static String getLastname() {
        return lastname;
    }

    public static String getEmail() {
        return email;
    }

    public static Integer getVerified() {
        return verified;
    }

    public static ArrayList<Product> getWishlist() {
        return wishlist;
    }

    public static ArrayList<Product> getLibraryList() {
        return librarytList;
    }
}
