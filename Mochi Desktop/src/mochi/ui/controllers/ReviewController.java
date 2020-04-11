package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mochi.ProductPageAssist;
import mochi.ReviewUserDetail;
import mochi.db.DBConnection;
import mochi.ui.LibraryUI;
import mochi.ui.LoginUI;
import mochi.ui.ProductUI;
import mochi.ui.ProfileUI;
import mochi.User;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ReviewController implements Initializable {
    public Pane pane;
    public Label programLabel;
    public Label errorLabel;
    public Label successLabel;
    public TextArea textAreaReview;
    public ChoiceBox<String> userProfileChoiceBox;
    public ChoiceBox<String> starChoiceBox;
    public Button submitReviewButton;
    public TableView<ReviewUserDetail> reviewTableView;
    public TableColumn<ReviewUserDetail, String> ratingTableColumn;
    public TableColumn<ReviewUserDetail, String> userTableColumn;
    public TableColumn<ReviewUserDetail, String> reviewTableColumn;
    public ObservableList<ReviewUserDetail> data;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();

        // choice box to see My profile, library, and wishlist.
        userProfileChoiceBox.setItems(FXCollections.observableArrayList("My Profile", "Library", "Wishlist"));

        // choice box to see all the possible ratings.
        starChoiceBox.setItems(FXCollections.observableArrayList("1 star", "2 star", "3 star", "4 star", "5 star"));

        // My profile choice box where clicking will lead to the new scene.
        userProfileChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (userProfileChoiceBox.getValue().equals("My Profile")) {
                try {
                    setUserProfileScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (userProfileChoiceBox.getValue().equals("Library")) {
                try {
                    setLibraryScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );

        try {
            String pName = ProductPageAssist.getPname();
            Integer pid = ProductPageAssist.getPid();

            programLabel.setText(pName);

            data = FXCollections.observableArrayList();
            ResultSet resultSet = null;
            Statement statement = null;

            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.Review;");

            while (resultSet.next()) {
                if (resultSet.getString(1).equals(pid)) {
                    data.add(new ReviewUserDetail(resultSet.getString(3), resultSet.getString(4),
                            resultSet.getString(5)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set cell value factory to tableview.
        ratingTableColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        userTableColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        reviewTableColumn.setCellValueFactory(new PropertyValueFactory<>("review"));

        reviewTableView.setItems(null);
        reviewTableView.setItems(data);
    }

    private boolean setUserProfileScene() throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        ProfileUI profileUI = new ProfileUI();

        if (profileUI != null) {
            primaryStage.setScene(profileUI.getProfileScene());
            return true;
        }
        return false;
    }

    private boolean setLibraryScene() throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        LibraryUI libraryUI = new LibraryUI();

        if (libraryUI != null) {
            primaryStage.setScene(libraryUI.getLibraryScene());
            return true;
        }
        return false;
    }

    // Submits the starReview and whats in the text area
    public boolean submitReviewButtonClick() throws SQLException {
        int errorStar = 0;
        int errorReview = 0;
        ResultSet resultSet = null;
        Statement statement = null;
        String query;

        String Review = textAreaReview.getText();
        String Rating = starChoiceBox.getValue();

        errorLabel.getStyleClass().add("Warning_Label_Normal");
        successLabel.getStyleClass().add("Warning_Label_Normal");
        errorLabel.setText("");
        successLabel.setText("");

        // error checking
        if (Rating == null) {
            errorStar = 1;
        }

        if (Review.equals("")) {
            errorReview = 1;
        }

        // No star rating, but there is a review.
        if (errorStar == 1 && errorReview == 0) {
            errorLabel.setText("No star rating");
            errorLabel.getStyleClass().add("Warning_Label_Error");
            return false;
        }
        // No review, but there is a star rating.
        else if (errorStar == 0 && errorReview == 1) {
            errorLabel.setText("No Review");
            errorLabel.setTextFill(Color.RED);
            errorLabel.getStyleClass().add("Warning_Label_Error");
            return false;
        }
        // Missing both.
        else if (errorStar == 1 && errorReview == 1) {
            errorLabel.setText("No Star Rating and Review");
            errorLabel.getStyleClass().add("Warning_Label_Error_Both");
            return false;
        }
        // Both are valid
        else if (errorStar == 0 && errorReview == 0) {
            successLabel.setText("Success");
            successLabel.getStyleClass().add("Warning_Label_Success");
        }

        int ProductID = ProductPageAssist.getPid();
        String ProductName = ProductPageAssist.getPname();
        String username = User.getUsername();
        statement = (Statement) database.createStatement();

        // putting the information into the database.
        query = "insert into Review values ('" + ProductID + "', '" + ProductName + "', '" + Rating + "', '" + username + "', '" + Review + "');";
        statement.executeUpdate(query);
        return true;
    }
}