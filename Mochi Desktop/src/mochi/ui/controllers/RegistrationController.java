package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.LoginUI;
import mochi.ui.RegistrationUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
    public Pane pane;
    public Label loginLabel;
    public Button confirmButton;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField emailField;
    public PasswordField passwordField;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
    }

    public boolean loginLabelClick() throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        LoginUI loginUI = new LoginUI();

        if (loginUI != null) {
            primaryStage.setScene(loginUI.getLoginScene());
            return true;
        }
        return false;
    }

    public boolean confirmButtonClick() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = emailField.getText();
        String password = passwordField.getText();

        return true;
    }
}
