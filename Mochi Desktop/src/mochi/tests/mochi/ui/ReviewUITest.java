package mochi.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.sql.Connection;

public class ReviewUITest extends ApplicationTest {

    private Stage currentStage;
    private Connection database;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();
        this.database = connection.getDatabase();

        ReviewUI reviewUI = new ReviewUI();
        Scene reviewScene = reviewUI.getReviewScene();

        currentStage = primaryStage;

        primaryStage.setScene(reviewScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    // test if mochi label exist
    // test if programLabel exist
    // test if averageRatingLabel exist
    // test if User Profile exist
    // test if user profile choice box exist
    // test if starReview choice box exist
    // test if textAreaReview exist
    // test if textAreaReview returns what is typed inside of it.
    // test if submit review button exist
    // test if reviewTableView exist
    // test for tableColumn of Rating, User, Review
    // test for error when only star review is empty
    // test for error when only review textArea is empty
    // test for error when both star review and review textArea are empty
    // test when successful.
}
