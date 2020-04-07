package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class CheckoutUI {
    private Scene checkoutScene;

    public CheckoutUI() throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("fxmls/CheckOutUI.fxml"));
        this.checkoutScene = new Scene(loader);
    }

    public Scene getCheckoutScene() {
        return this.checkoutScene;
    }
}