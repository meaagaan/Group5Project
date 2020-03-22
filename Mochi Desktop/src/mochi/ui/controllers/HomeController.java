package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ProductUI;
import mochi.ui.ProfileUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    private Connection database;

    public ComboBox filterCombo;

    public ComboBox sortCombo;

    public TextField searchField;
    public Label searchLabel;

    public ComboBox profileCombo;

    public Button createProduct;

    public Button helpButton;

    public Pane pane;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.database = DBConnection.getDatabase();

        ObservableList<String> filterOptions = FXCollections.observableArrayList("Price", "Ratings", "Genre");
        filterCombo.setItems(filterOptions);

        ObservableList<String> sortOptions = FXCollections.observableArrayList("Price", "Ratings", "Popularity");
        sortCombo.setItems(sortOptions);

        ObservableList<String> profileOptions = FXCollections.observableArrayList("User Profile", "Settings", "Wishlist");
        profileCombo.setItems(profileOptions);
    }

    public boolean userProfileChoice() throws IOException {

        if (profileCombo.getValue().equals("User Profile"))
           return  userProfileOptionClicked();
        if (profileCombo.getValue().equals("Settings"))
            return settingsOptionClicked();
        if (profileCombo.getValue().equals("Wishlist"))
            return wishlistOptionClicked();
        else
            return false;
    }

    public boolean userProfileOptionClicked() throws IOException
    {
        return false;
    }

    public boolean settingsOptionClicked() throws IOException
    {
        return false;
    }

    public boolean wishlistOptionClicked()
    {
        return false;
    }

    public boolean helpButtonClicked() throws IOException
    {
        return false;
    }

    private boolean setProfileScene () throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        ProfileUI profileUI = new ProfileUI();

        if (profileUI != null) {
            primaryStage.setScene(profileUI.getProfileScene());
            return true;
        }
        return false;
    }

    public boolean tempProfileLabelClicked() throws IOException {
        return setProfileScene();
    }

    public boolean setProductScene() throws IOException{
        Stage primaryStage = (Stage) createProduct.getScene().getWindow();
        ProductUI productUI = new ProductUI();

        if (productUI != null) {
            primaryStage.setScene(productUI.getProductScene());
            return true;
        }
        return false;
    }
    public boolean createProductClick() throws IOException{
        return setProductScene();
    }

}

