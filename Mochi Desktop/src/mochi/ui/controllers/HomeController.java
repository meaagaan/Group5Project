package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mochi.db.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    private Connection database;

    public ChoiceBox filterChoice;
    public Label filterLabel;
    public ChoiceBox sortChoice;
    public Label sortLabel;
    public TextField searchField;
    

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.database = DBConnection.getDatabase();
    }
}
