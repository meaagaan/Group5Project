package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mochi.ui.RegistrationUI;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Pane pane;
    public Text signUpText;
    public Button loginButton;
    public TextField usernameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.requestFocus();
    }

    public void signUpTextClick() {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        RegistrationUI registrationUI = new RegistrationUI();

        primaryStage.setScene(registrationUI.getScene());
    }
}
