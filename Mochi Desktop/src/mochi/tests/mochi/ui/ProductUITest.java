package mochi.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;

public class ProductUITest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ProductUI productUI = new ProductUI();
        Scene productScene = productUI.getProductScene();

        primaryStage.setScene(productScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }
    


}
