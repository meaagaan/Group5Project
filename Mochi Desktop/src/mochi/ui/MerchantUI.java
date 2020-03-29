package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MerchantUI {
    Scene MerchantScene;

    public MerchantUI() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxmls/MerchantUI.fxml"));
        this.MerchantScene = new Scene(root);
    }

    public Scene getMerchantScene() { return MerchantScene;}
}
