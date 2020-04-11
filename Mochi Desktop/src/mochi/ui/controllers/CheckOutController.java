package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;
import mochi.ui.LibraryUI;
import mochi.ui.WishlistUI;


public class CheckOutController implements Initializable {
    public Pane pane;

    public Label productname;
    public TextField cardnumber;
    public TextField cvc;
    public TextField expiration;
    public TextField pemail;
    public Label sucess;
    public Label storeid;
    public Label wishlistid;
    public Label libraryid;
    public Label user;
    public Label price;
    public Button checkout;

    private Connection database;
    private String productID = "-1";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
        productname.setFocusTraversable(false);
        productname.setMouseTransparent(true);
        productname.setText(ProductPageAssist.getPname());
        price.setFocusTraversable(false);
        price.setMouseTransparent(true);
        price.setText(ProductPageAssist.getPprice());
        productID = Integer.toString(ProductPageAssist.getPid());
    }

    public boolean CheckoutClick() throws FileNotFoundException, SQLException {
        sucess.setText("Product Purchased");

        return addLibrary();

    }
    public boolean setHomeScene() throws IOException {
        Stage primaryStage = (Stage) storeid.getScene().getWindow();
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
        Stage primaryStage = (Stage) wishlistid.getScene().getWindow();
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
        Stage primaryStage = (Stage) libraryid.getScene().getWindow();
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

    public boolean addLibrary() throws FileNotFoundException, SQLException {
        if (Integer.valueOf(productID) != -1) {
            LibraryDatabase libraryDatabase = new LibraryDatabase(database);
            ArrayList<Product> userLibrary = User.getLibraryList();
            if (userLibrary != null) {
                libraryDatabase.findProduct(productID, userLibrary);
            } else {
                userLibrary = new ArrayList<Product>();
                libraryDatabase.findProduct(productID, userLibrary);
                User.setLibraryList(userLibrary);
            }
            libraryDatabase.writeText(userLibrary);
            libraryDatabase.writeFile(User.getUsername());
            return true;
        }
        return false;
    }
}
