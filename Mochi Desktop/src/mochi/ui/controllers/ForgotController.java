package mochi.ui.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.LoginUI;
import mochi.ui.RegistrationUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ForgotController {
    public Pane pane;
    public Label loginLabel;
    public Label signUpLabel;
    public Label warningLabel;
    public TextField emailField;
    public Button sendButton;

    private Connection database;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
    }

    public boolean signUpLabelClick() {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        RegistrationUI registrationUI = new RegistrationUI();

        if (registrationUI != null) {
            primaryStage.setScene(registrationUI.getScene());
            return true;
        }
        return false;
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

    public boolean sendButtonClick() {
        ResultSet resultSet = null;
        Statement statement = null;

        String email = emailField.getText();

        try {
            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.user");

            while(resultSet.next()) {
                if (resultSet.getString(3).equals(email)) {
                    warningLabel.getStyleClass().add("Warning_Label_Success");
                    warningLabel.setText("Please check your email.");

                    // Send email here
                    return true;
                }
                else {
                    warningLabel.getStyleClass().add("Warning_Label_Error");
                    warningLabel.setText("This email does not associated with any account.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
