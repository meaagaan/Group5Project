package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ForgotUI;
import mochi.ui.ProductUI;

import java.io.IOException;
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

    public Boolean wishlistOptionClicked()
    {
        return false;
    }

    public boolean helpButtonClicked() throws IOException
    {
        return false;
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

