package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import mochi.db.DBConnection;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ReviewController implements Initializable {
    public Pane pane;
    public Label averageRatingLabel;
    public Label programLabel;
    public TextArea textAreaReview;
    public ChoiceBox userProfileChoiceBox;
    public ChoiceBox starChoiceBox;
    public Button submitReviewButton;
    public TableView reviewTableView;
    public TableColumn ratingTableColumn;
    public TableColumn userTableColumn;
    public TableColumn reviewTableColumn;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
    }

    // Submits the starReview and whats in the text area
    public boolean submitReviewButtonClick() {
        return false;
    }

    // choice box to see 1, 2, 3, 4, 5 stars
    public boolean starReviewClick() {
        return false;
    }

    // choice box to see home, profile, and others
    public boolean userProfileClick() {
        return false;
    }

}