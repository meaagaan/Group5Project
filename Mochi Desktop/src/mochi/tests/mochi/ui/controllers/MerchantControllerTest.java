package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.MerchantUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class MerchantControllerTest extends ApplicationTest {

    MerchantController merchantController;
    private Stage currentStage;
    private Connection database;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();
        this.database = connection.getDatabase();

        MerchantUI merchantUI = new MerchantUI();
        Scene merchantScene = merchantUI.getMerchantScene();

        this.merchantController = merchantUI.getMerchantController();
        currentStage = primaryStage;

        primaryStage.setScene(merchantScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Test
    // Check if the store is clicked.
    public void storeLabelClicked() {
        Platform.runLater(() -> {
            try {
                assertEquals(true, merchantController.storeLabelClicked());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    // Check if the library is clicked.
    public void libraryLabelClicked() {
        Platform.runLater(() -> {
            try {
                assertEquals(true, merchantController.LibraryLabelClicked());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    // Check if the wishlist is clicked.
    public void wishlistLabelClicked() {
        Platform.runLater(() -> {
            try {
                assertEquals(true, merchantController.WishlistLabelClicked());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    // Check if the profile is clicked.
    public void profileLabelClicked() {
        Platform.runLater(() -> {
            try {
                assertEquals(true, merchantController.userProfileLabelClicked());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
