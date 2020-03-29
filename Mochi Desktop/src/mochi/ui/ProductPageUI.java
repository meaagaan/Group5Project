package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ProductPageUI {
    private Scene productpageScene;

    public ProductPageUI() throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("fxmls/ProductPageUI.fxml"));
        this.productpageScene = new Scene(loader);
    }

    public Scene getProductPageScene() {
        return this.productpageScene;
    }
}
