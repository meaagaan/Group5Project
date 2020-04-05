package mochi.ui.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;
import mochi.ui.ProductUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class ProductController implements Initializable {
    public Pane pane;

    public Label productLabel;
    public Label registration;
    public Label genreLabel;
    public Label priceLabel;
    public Label descriptionLabel;

    public Button confirmButton;
    public Button returnHome;

    public TextField productName;
    public TextField description;
    public TextField price;

    public Label ProductError;
    public Label confirmError;
    public Label confirmation;

    public Button loading;
    public Button open;


    ObservableList <String>choice = FXCollections.observableArrayList("educational", "business","personal");
    public ChoiceBox options;
    private Connection database;
    public String user;
    String type="educational";
    public PreparedStatement store;
    public FileInputStream fileInputStream;
    public File file;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();

        options.setItems(choice);

        if(options.getSelectionModel().getSelectedItem()=="educational"){
            type="educational";
        }
        else if(options.getSelectionModel().getSelectedItem()=="business"){
            type="business";
        }
        else{
            type="personal";
        }
        user= User.getUsername();


    }

    public void fileUpload() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File file = fileChooser.showOpenDialog(open.getScene().getWindow());
        try{
            FileInputStream fileInputStream= new FileInputStream(file);
            if(file== null){
                System.out.println("no file chocse");
            }
            store=database.prepareStatement("INSERT INTO Product (image) VALUES (?)");
            store.setBinaryStream(1,fileInputStream, file.length());
            store.executeUpdate();
            //Image image= new Image(fileInputStream);
            Image image= new Image(file.toURI().toString(), 100, 150, true, true);
            ImageView imageView = null;
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(150);
            imageView.setPreserveRatio(true);
        }
        catch (IOException | SQLException e){
            System.out.println(e.getMessage());
        }

    }

    //private void loadingFile() {

    //}



    public boolean confirmButtonClick() throws SQLException, IOException {

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement p= null;
        ResultSet r= null;
        String productN = productName.getText();
        String genreName= type;
        String descriptionOfProduct = description.getText();
        String priceOfProduct = price.getText();
        String query;
        String userName= user;
        Integer ProductID= 0;


        try {
            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.Product;");

            while(resultSet.next()) {
                // check to see if product is taken
                if (resultSet.getString(1).equals(productName)) {
                    ProductError.getStyleClass().add("Product_Error");
                    ProductError.setText("Taken");
                    return false;
                }


                // check if any of the fields are empty.
                if (productN.equals("") ||
                        genreName.equals("") || descriptionOfProduct.equals("") ||
                        priceOfProduct.equals("")) {
                    confirmError.getStyleClass().add("Empty_Error");
                    confirmError.setText("One or more empty fields");
                    return false;
                }
                else{
                    confirmation.getStyleClass().add("Confirmation");
                    confirmation.setText("Your product has been created");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // putting the product information into the database.

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));

        File file = fileChooser.showOpenDialog(open.getScene().getWindow());

        FileInputStream fileInputStream= new FileInputStream(file);
        if(file== null){
            System.out.println("no file chocse");
        }

        //Image image= new Image(fileInputStream);
        Image image= new Image(file.toURI().toString(), 100, 150, true, true);
        ImageView imageView = null;
        imageView.setImage(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        p= database.prepareStatement("INSERT INTO Product (productN, genreName, descriptionOfProduct, priceOfProduct, userName, image) VALUES (?,?,?,?,?,?)");
        p.setString(1, productN);
        p.setString(2,genreName);
        p.setString(3, descriptionOfProduct);
        p.setString(4,priceOfProduct);
        p.setString(5,userName);
        p.setBinaryStream(6,fileInputStream, file.length());
        p.executeUpdate();

        //preparedStatement = (PreparedStatement) database.prepareStatement(query);
        //preparedStatement.executeUpdate(query);
        //statement.executeUpdate(query);

        return false;
    }
    public boolean setHomeScene() throws IOException{
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
}