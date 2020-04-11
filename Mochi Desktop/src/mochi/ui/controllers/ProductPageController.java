package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.Product;
import mochi.ProductPageAssist;
import mochi.User;
import mochi.WishlistDatabase;
import mochi.ui.*;
import mochi.db.DBConnection;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {
    public Label prname;
    public Label genre;
    public Label price;
    public Label description;
    public Label storeid;
    public Label wishlistid;
    public Label libraryid;
    public ImageView imageView;
    public String pd;
    public Button checkoutButton;
    public Button Review;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            statement = database.prepareStatement("SELECT image FROM `mochi-desktop`.Product WHERE productN = ?");
            statement.setInt(1, 7);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Blob blob= resultSet.getBlob("image");
                InputStream binaryStream= blob.getBinaryStream();

                Image image= new Image(binaryStream);
                imageView.setImage(image);
                System.out.println("yest");
            }


        } catch (SQLException e ) {
            e.printStackTrace();
        }

        prname.setFocusTraversable(false);
        prname.setMouseTransparent(true);
        prname.setText(ProductPageAssist.getPname());

        genre.setFocusTraversable(false);
        genre.setMouseTransparent(true);
        genre.setText(ProductPageAssist.getPprice());

        price.setFocusTraversable(false);
        price.setMouseTransparent(true);
        price.setText(ProductPageAssist.getPgenre());

        description.setFocusTraversable(false);
        description.setMouseTransparent(true);
        description.setText(ProductPageAssist.getPdescription());

        //imageView.setImage(ProductPageAssist.getImage());

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
    public boolean setCheckOutScene() throws IOException {
        Stage primaryStage = (Stage) checkoutButton.getScene().getWindow();
        CheckoutUI checkoutUI = new CheckoutUI();

        if (checkoutUI != null) {
            primaryStage.setScene(checkoutUI.getCheckoutScene());
            return true;
        }
        return false;
    }
    public boolean CheckOutClick() throws IOException{
        return setCheckOutScene();

    }

    public boolean addWishlist() throws FileNotFoundException, SQLException {
        if (Integer.valueOf(pd) != -1) {
            WishlistDatabase wishlistDatabase = new WishlistDatabase(database);
            ArrayList<Product> userWishlist = User.getWishlist();
            if (userWishlist != null) {
                wishlistDatabase.findProduct(pd, userWishlist);
            } else {
                userWishlist = new ArrayList<Product>();
                wishlistDatabase.findProduct(pd, userWishlist);
                User.setWishlist(userWishlist);
            }
            wishlistDatabase.writeText(userWishlist);
            wishlistDatabase.writeFile(User.getUsername());
            return true;
        }
        return false;
    }

    public boolean setReviewScene() throws IOException {
        Stage primaryStage = (Stage) Review.getScene().getWindow();
        ReviewUI reviewUI = new ReviewUI();

        if (reviewUI != null) {
            primaryStage.setScene(reviewUI.getReviewScene());
            return true;
        }
        return false;
    }
    public boolean ReviewClick() throws IOException{
        return setReviewScene();

    }
}
