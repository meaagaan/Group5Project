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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
    public Pane pane;
    public Label loginLabel;
    public Button confirmButton;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField emailField;
    public TextField usernameField;
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
        ResultSet resultSet = null;
        Statement statement = null;

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
    //
        try {
            statement = (Statement)  database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.user");

            while(resultSet.next()) {
                if (resultSet.getString(1).equals(username) &&
                        resultSet.getString(2).equals(password)) {
                    //warningLabel.getStyleClass().add("Warning_Label_Success");
                    //warningLabel.setText("Welcome.");
                    return true;
                }
                else {
                    //warningLabel.getStyleClass().add("Warning_Label_Error");
                    //warningLabel.setText("You've enter a wrong username or password.");
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
