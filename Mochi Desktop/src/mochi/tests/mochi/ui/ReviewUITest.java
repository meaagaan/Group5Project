package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

import java.sql.Connection;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

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

    @Test
    public void MochiLabelExist() {
        verifyThat("#mochiLabel", Node::isVisible);
        verifyThat("#mochiLabel", NodeQueryUtils.hasText("Mochi"));
    }

    @Test
    public void programLabelExist() {
        verifyThat("#programLabel", Node::isVisible);
        verifyThat("#programLabel", NodeQueryUtils.hasText("Hello World"));
    }

    @Test
    public void averageRatingLabelExist() {
        verifyThat("#averageRatingLabel", Node::isVisible);
        verifyThat("#averageRatingLabel", NodeQueryUtils.hasText("Average Rating: 5.0"));
    }

    @Test
    public void userProfileLabelExist() {
        verifyThat("#userProfileLabel", Node::isVisible);
        verifyThat("#userProfileLabel", NodeQueryUtils.hasText("User Profile"));
    }

    @Test
    public void textAreaReviewExist() {
        verifyThat("#textAreaReview", Node::isVisible);
        verifyThat("#textAreaReview", NodeQueryUtils.hasText(""));
    }

    @Test
    public void submitReviewButtonExist() {
        verifyThat("#submitReviewButton", Node::isVisible);
        verifyThat("#submitReviewButton", NodeQueryUtils.hasText("Submit Review"));
    }

    @Test
    public void ratingTableColumnExist() {
        verifyThat("#ratingTableColumn", Node::isVisible);
    }

    @Test
    public void userTableColumnExist() {
        verifyThat("#userTableColumn", Node::isVisible);
    }

    @Test
    public void reviewTableColumnExist() {
        verifyThat("#reviewTableColumn", Node::isVisible);
    }

    @Test
    public void textAreaReviewContain() {
        clickOn("#textAreaReview").write("123");
        verifyThat("#textAreaReview", hasText("123"));
    }

    @Test
    public void errorLabelExist() {
            verifyThat("#errorLabel", hasText(""));
    }
}
