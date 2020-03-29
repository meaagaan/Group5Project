package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import mochi.Product;
import mochi.User;
import mochi.db.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {
    public TextField prname;
    public Label genreName;
    public Label priceName;
    public Label descriptionName;
    public TextField genre;
    public TextField price;
    public TextField description;
    public Button returnHome;
    public Button wishlist;
    public Pane pane;

    private Connection database;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();

        prname.setText(Product.getPname());

        genre.setText(Product.getPgenre());

        price.setText(Product.getPprice());

        description.setText(Product.getPdescription());

    }
}
