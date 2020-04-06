package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.ProductPageAssist;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.ForgotUI;
import mochi.ui.ProductUI;
import mochi.ui.ProfileUI;
import mochi.ui.WishlistUI;
import mochi.ui.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import mochi.Product;

public class HomeController implements Initializable
{
    private Connection database;

    public ComboBox filterCombo;

    public ComboBox sortCombo;

    public TextField searchField;

    public ComboBox profileCombo;

    public Button createProduct;

    public Button helpButton;

    public Pane pane;

    public Button tempProfileButton;

    public Button wishlistButton;

    public TableView<ProductInformation> table;

    public TableColumn<ProductInformation, String> cname;
    public TableColumn<ProductInformation, String> cuser;
    public TableColumn<ProductInformation, String> cprice;
    public TableColumn<ProductInformation, String> cgenre;
    //public TableColumn<ProductInformation, Button> viewing;
    public Button view;

    public String p;


    ObservableList<ProductInformation> lst= FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.database = DBConnection.getDatabase();

        ObservableList<String> filterOptions = FXCollections.observableArrayList("Price", "Ratings", "Genre");
        filterCombo.setItems(filterOptions);

        /* UNCOMMENT IF WE DECIDE TO INCLUDE DROP DOWN FOR SORTING
        ObservableList<String> sortOptions = FXCollections.observableArrayList("Price", "Ratings", "Popularity");
        sortCombo.setItems(sortOptions);
        */

        try {
            ResultSet s= database.createStatement().executeQuery("SELECT * FROM `mochi-desktop`.Product;");
            while(s.next()){

                lst.add(new ProductInformation(s.getString("ProductID"), s.getString("productN"),
                        s.getString("genreName"), s.getString("descriptionOfProduct"),
                        s.getString("priceOfProduct"), s.getString("userName")));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        cgenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        cprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cuser.setCellValueFactory(new PropertyValueFactory<>("user"));

        //viewing.setCellValueFactory(view);
        table.setItems(lst);
        //if(table.getSelectionModel().getSelectedItem().getName()!=null){
        //    product=cname.setText(product.getName());
        //}

        searchField.setPromptText("Search");
    }

    /*
    public boolean userProfileChoice() throws IOException {

        if (profileCombo.getValue().equals("User Profile"))
            return userProfileOptionClicked();
        if (profileCombo.getValue().equals("Settings"))
            return settingsOptionClicked();
        if (profileCombo.getValue().equals("Wishlist"))
            return wishlistOptionClicked();
        else
            return false;
    }
     */

    public boolean userProfileOptionClicked() throws IOException
    {
        return setProfileScene();
    }

    private boolean setProfileScene() throws IOException {

        Stage primaryStage = (Stage) pane.getScene().getWindow();
        ProfileUI profileUI = new ProfileUI();

        if (profileUI != null) {
            primaryStage.setScene(profileUI.getProfileScene());
            return true;
        }
        return false;
    }

    public boolean settingsOptionClicked() throws IOException {
        return false;
    }

    public boolean wishlistOptionClicked() throws IOException {
        return setWishlistScene();
    }

    private boolean setWishlistScene () throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        WishlistUI wishlistUI = new WishlistUI();

        if (wishlistUI != null){
            primaryStage.setScene(wishlistUI.getWishlistScene());
            return true;
        }
        return false;
    }

    public boolean helpButtonClicked() throws IOException
    {
        return setHelpScene();
    }

    private boolean setHelpScene() throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        ForgotUI forgotUI = new ForgotUI();

        if (forgotUI != null) {
            primaryStage.setScene(forgotUI.getForgotScene());
            return true;
        }
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

    private boolean setProductPage() throws IOException {
        String name= "1";

        name=table.getSelectionModel().getSelectedItem().getName();
        ProductPageAssist object = new ProductPageAssist();
        object.setPname(name);
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = database.prepareStatement("SELECT genreName, descriptionOfProduct, priceOfProduct FROM Product WHERE productN = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                object.setPgenre(resultSet.getString("genreName"));
                object.setPdescription(resultSet.getString("descriptionOfProduct"));
                object.setPprice(resultSet.getString("priceOfProduct"));
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Stage primaryStage = (Stage) view.getScene().getWindow();
        ProductPageUI productpageUI = new ProductPageUI();

        if (productpageUI != null) {
            primaryStage.setScene(productpageUI.getProductPageScene());
            return true;
        }
        return false;
    }

    public boolean viewClick() throws IOException{
        return setProductPage();
    }



    /*
    public boolean tempProfileLabelClicked() throws IOException {
        return setProfileScene();
    }
    */

}
