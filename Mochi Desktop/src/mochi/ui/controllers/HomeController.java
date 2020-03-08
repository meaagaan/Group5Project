package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public Label searchLabel;
    public ChoiceBox profileChoice;
    public Label profileLabel;


    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.database = DBConnection.getDatabase();

        ObservableList<String> filterOptions = FXCollections.observableArrayList("Price", "Reviews", "Genre");
        filterChoice.setItems(filterOptions);

        ObservableList<String> sortOptions = FXCollections.observableArrayList("Price", "Ratings", "Popularity");
        sortChoice.setItems(sortOptions);

        ObservableList<String> profileOptions = FXCollections.observableArrayList("User Profile", "Settings", "Help", "Wishlist");
        profileChoice.setItems(profileOptions);
    }


}
