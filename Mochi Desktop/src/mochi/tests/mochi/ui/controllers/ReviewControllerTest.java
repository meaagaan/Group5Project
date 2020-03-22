package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ReviewUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

import java.io.IOException;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class ReviewControllerTest extends ApplicationTest {

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
    public void switchToUserProfileUI() {
        clickOn("#userProfileChoiceBox");
        clickOn("My Profile");
        verifyThat("#storeLabel", NodeQueryUtils.hasText("Store"));
    }

    @Test
    public void switchToLibraryUI() {
        clickOn("#userProfileChoiceBox");
        clickOn("Library");
        verifyThat("#libraryLabel", NodeQueryUtils.hasText("Library"));
    }

    @Test
    public void ErrorWhenOnlyStarReviewEmpty() {
        clickOn("#starChoiceBox");
        clickOn("1 star");
        clickOn("#submitReviewButton");
        verifyThat("#errorLabel", NodeQueryUtils.hasText("No Review"));
    }

    @Test
    public void ErrorWhenOnlyReviewEmpty() {
        clickOn("#textAreaReview").write("asd");
        clickOn("#submitReviewButton");
        verifyThat("#errorLabel", NodeQueryUtils.hasText("No star rating"));
    }

    @Test
    public void ErrorWhenBothAreEmpty() {
        clickOn("#starChoiceBox");
        clickOn("1 star");
        clickOn("#textAreaReview").write("asd");
        clickOn("#submitReviewButton");
        verifyThat("#successLabel", NodeQueryUtils.hasText("Success"));
    }
}
