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


    // test if user profile choice box exist
    // test if starReview choice box exist
    // test for error when only star review is empty
    // test for error when only review textArea is empty
    // test for error when both star review and review textArea are empty
    // test when successful.
//    @Test
//    public void userProfileChoiceBoxExist() {
//        clickOn("#userProfileChoiceBox").clickOn("Profile");
//        verifyThat("#userProfileChoiceBox", node -> this.userInformationMap.get(2).equals(((ChoiceBox)node).getValue()));
//    }
}
