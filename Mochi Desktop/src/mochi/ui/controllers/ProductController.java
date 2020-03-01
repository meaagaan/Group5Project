package mochi.ui.controllers;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ProductUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    public Pane pane;
    public Label productLabel; //public Label loginLabel;
    public Button confirmButton;
    public TextField productName; //public TextField firstNameField;
    public TextField genre;  //public TextField lastNameField;
    public TextField description; //public TextField emailField;
    public TextField price; //public TextField usernameField;


    public Label ProductError;

    public Label confirmError;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
    }

    public boolean productLabelClick() throws IOException {
        /*Stage primaryStage = (Stage) pane.getScene().getWindow();
        ProductUI productUI = new ProductUI();

        if (productUI != null) {
            primaryStage.setScene(ProductUI.getproductScene());
            return true;
        }
        */
        return false;


    }

    public boolean confirmButtonClick() throws SQLException {
        ResultSet resultSet = null;
        Statement statement = null;

        String productN = productName.getText();
        String genreName = genre.getText();
        String descriptionOfProduct = description.getText();
        String priceOfProduct = price.getText();
        String query;
        boolean ErrorFlag = false;
/*
        try {
            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.Product;");

            while(resultSet.next()) {
                // check to see if product is taken
                if (resultSet.getString(1).equals(productName)) {
                    ProductError.getStyleClass().add("Warning_Label_Error");
                    ProductError.setText("Taken");
                    ErrorFlag = true;
                }


                // check if any of the fields are empty.
                if (productN.equals("") || genreName.equals("") || descriptionOfProduct.equals("") ||
                        priceOfProduct.equals("")) {
                    confirmError.getStyleClass().add("Warning_Label_Error");
                    confirmError.setText("One or more empty fields");
                    ErrorFlag = true;
                }

                // if ErrorFlag is changed once, an error occurred somewhere.
                if (ErrorFlag){
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

 */
        /*
        // putting the information into the database.
        query = "insert into Product values ('" + productN + "', '" + genreName + "', '" + descriptionOfProduct + "', '" + priceOfProduct + "');";
        statement.executeUpdate(query);
        */

        return false;
    }
}
