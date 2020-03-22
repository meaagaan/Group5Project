package mochi.ui.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ProductUI;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class ProductControllerTest extends Application {
    ProductController productController;

    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();

        ProductUI productUI = new ProductUI();
        Scene productScene = productUI.getProductScene();

        primaryStage.setTitle("Mochi Desktop");
        primaryStage.setScene(productScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }
    @Test
    // Check if the confirm button is clicked.
    public void confirmButtonClick(){
        Platform.runLater(() -> {
            try {
                assertEquals(true, productController.confirmButtonClick());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @Test
    // Check if the returnHome button is clicked.
    public void returnHomeClick(){
        Platform.runLater(() -> {
            try {
                assertEquals(true, productController.returnHomeClick());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
