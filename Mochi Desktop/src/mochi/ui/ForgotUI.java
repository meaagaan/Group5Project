package mochi.ui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class ForgotUI {
    Scene forgotScene;

    public ForgotUI() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxmls/ForgotUI.fxml"));

        this.forgotScene = new Scene(root);
    }

    public Scene getForgotScene() {
        return forgotScene;
    }
}