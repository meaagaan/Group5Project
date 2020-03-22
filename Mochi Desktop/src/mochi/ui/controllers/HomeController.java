package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ForgotUI;
import mochi.ui.HomeUI;
import mochi.ui.ProductUI;
import mochi.ui.ProfileUI;
import mochi.ui.stylesheets.LibraryUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    private Connection database;

    public ChoiceBox filterChoice;

    public ComboBox filterCombo;
    public Label filterLabel;

    public ChoiceBox sortChoice;

    public ComboBox sortCombo;
    public Label sortLabel;

    public TextField searchField;
    public Label searchLabel;

    public ChoiceBox profileChoice;

    public ComboBox profileCombo;
    public Label profileLabel;
    public Button createProduct;
    public Pane pane;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.database = DBConnection.getDatabase();

        ObservableList<String> filterOptions = FXCollections.observableArrayList("Price", "Ratings", "Genre");
        filterChoice.setItems(filterOptions);

        ObservableList<String> sortOptions = FXCollections.observableArrayList("Price", "Ratings", "Popularity");
        sortChoice.setItems(sortOptions);

        ObservableList<String> profileOptions = FXCollections.observableArrayList("User Profile", "Settings", "Wishlist");
        profileChoice.setItems(profileOptions);
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

