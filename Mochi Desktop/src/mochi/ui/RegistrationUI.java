package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class RegistrationUI {
    Scene RegistrationScene;

    public RegistrationUI() throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("fxmls/RegistrationUI.fxml"));
            this.RegistrationScene = new Scene(root);
    }

    public Scene getRegistrationScene() {
        return RegistrationScene;
    }
}

