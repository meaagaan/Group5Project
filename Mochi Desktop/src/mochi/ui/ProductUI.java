package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;



public class ProductUI {
    private Scene productScene;

    public ProductUI() throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("fxmls/ProductUI.fxml"));
        this.productScene = new Scene(loader);
    }

    public Scene getProductScene() {
        return this.productScene;
    }

}