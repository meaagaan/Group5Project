package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.RegistrationUI;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Pane pane;
    public Label signUpLabel;
    public Label warningLabel;
    public Button loginButton;
    public TextField usernameField;
    public TextField passwordField;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
    }

    public void signUpLabelClick() {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        RegistrationUI registrationUI = new RegistrationUI();

        primaryStage.setScene(registrationUI.getScene());
    }

    public void loginButtonClick() {
        ResultSet resultSet = null;
        Statement statement = null;

        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.user");

            while(resultSet.next()) {
                if (resultSet.getString(1).equals(username) &&
                        resultSet.getString(2).equals(password)) {
                    warningLabel.getStyleClass().add("Warning_Label_Success");
                    warningLabel.setText("Welcome.");
                }
                else {
                    warningLabel.getStyleClass().add("Warning_Label_Error");
                    warningLabel.setText("You've enter a wrong username or password.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
