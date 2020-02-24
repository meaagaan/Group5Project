package mochi.ui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.ForgotController;

import java.io.IOException;


public class ForgotUI {
    private Scene forgotScene;
    private ForgotController forgotController;

    public ForgotUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/ForgotUI.fxml"));
        Parent root = loader.load();

        this.forgotController = loader.getController();
        this.forgotScene = new Scene(root);
    }

    public Scene getForgotScene() {
        return this.forgotScene;
    }

    public ForgotController getForgotController() {
        return this.forgotController;
    }
}