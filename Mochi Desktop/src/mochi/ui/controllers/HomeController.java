package mochi.ui.controllers;

import javafx.fxml.Initializable;
import mochi.db.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    private Connection database;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.database = DBConnection.getDatabase();
    }
}
