package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.ProductController;

import java.io.IOException;


public class ProductUI {
    private Scene productScene;
    private ProductController productController;

    public ProductUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/ProductUI.fxml"));
        Parent root = loader.load();

        this.productController = loader.getController();
        this.productScene = new Scene(root);
    }

    public Scene getProductScene() {
        return this.productScene;
    }

    public ProductController getProductController() {
        return this.productController;
    }
}
