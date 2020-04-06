package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.Product;
import mochi.ProductPageAssist;
import mochi.User;
import mochi.ui.HomeUI;
import mochi.ui.LibraryUI;
import mochi.ui.ProductInformation;
import mochi.db.DBConnection;
import mochi.ui.WishlistUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {
    public Label prname;
    public Label genreName;
    public Label priceName;
    public Label descriptionName;
    public Label genre;
    public Label price;
    public Label description;
    public Button returnHome;
    public Button wishlist;
    public Button library;
    public Pane pane;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();

        prname.setFocusTraversable(false);
        prname.setMouseTransparent(true);
        prname.setText(ProductPageAssist.getPname());

        genre.setFocusTraversable(false);
        genre.setMouseTransparent(true);
        genre.setText(ProductPageAssist.getPgenre());

        price.setFocusTraversable(false);
        price.setMouseTransparent(true);
        price.setText(ProductPageAssist.getPprice());

        description.setFocusTraversable(false);
        description.setMouseTransparent(true);
        description.setText(ProductPageAssist.getPdescription());

    }
    public boolean setHomeScene() throws IOException {
        Stage primaryStage = (Stage) returnHome.getScene().getWindow();
        HomeUI homeUI = new HomeUI();

        if (homeUI != null) {
            primaryStage.setScene(homeUI.getHomeScene());
            return true;
        }
        return false;
    }
    public boolean returnHomeClick() throws IOException{
        return setHomeScene();

    }

    public boolean setWishListScene() throws IOException {
        Stage primaryStage = (Stage) wishlist.getScene().getWindow();
        WishlistUI wishlistUI = new WishlistUI();

        if (wishlistUI != null) {
            primaryStage.setScene(wishlistUI.getWishlistScene());
            return true;
        }
        return false;
    }
    public boolean wishlistClick() throws IOException{
        return setWishListScene();

    }

    public boolean setLibraryScene() throws IOException {
        Stage primaryStage = (Stage) library.getScene().getWindow();
        LibraryUI libraryUI = new LibraryUI();

        if (libraryUI != null) {
            primaryStage.setScene(libraryUI.getLibraryScene());
            return true;
        }
        return false;
    }
    public boolean LibraryClick() throws IOException{
        return setLibraryScene();

    }

}
