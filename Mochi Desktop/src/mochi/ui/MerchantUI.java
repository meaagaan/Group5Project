package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.MerchantController;

import java.io.IOException;

public class MerchantUI {
    private Scene MerchantScene;
    private MerchantController merchantController;

    public MerchantUI() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/MerchantUI.fxml"));
        Parent root = loader.load();

        this.merchantController = loader.getController();
        this.MerchantScene = new Scene(root);
    }

    public Scene getMerchantScene() { return MerchantScene;}

    public MerchantController getMerchantController() {
        return this.merchantController;
    }
}
