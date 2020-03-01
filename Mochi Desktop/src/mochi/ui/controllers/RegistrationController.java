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
    public Label emailError;
    public Label usernameError;
    public Label passwordError;
    public Label confirmError;

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

    public boolean confirmButtonClick() throws SQLException {
        ResultSet resultSet = null;
        Statement statement = null;

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String query;
        boolean ErrorFlag = false;

        try {
            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.User;");

            while(resultSet.next()) {
                // check to see if username is taken
                if (resultSet.getString(1).equals(username)) {
                    usernameError.getStyleClass().add("Warning_Label_Error");
                    usernameError.setText("Taken");
                    ErrorFlag = true;
                }

                // check if it is a valid email, then checks if it is taken
                if (email.contains("@") && email.contains(".com")) {
                    if (resultSet.getString(4).equals(email)) {
                        emailError.getStyleClass().add("Warning_Label_Error");
                        emailError.setText("Taken");
                        ErrorFlag = true;
                    }
                }
                else
                {
                    emailError.getStyleClass().add("Warning_Label_Error");
                    emailError.setText("Invalid");
                    ErrorFlag = true;
                }

                // check if any of the fields are empty.
                if (firstName.equals("") || lastName.equals("") || email.equals("") ||
                        username.equals("") || password.equals("")) {
                    confirmError.getStyleClass().add("Warning_Label_Error");
                    confirmError.setText("One or more empty fields");
                    ErrorFlag = true;
                }

                // if ErrorFlag is changed once, an error occurred somewhere.
                if (ErrorFlag){
                    return false;
                }

                // do a check to see if it meets password requirements
                            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        // putting the information into the database.
        query = "insert into User values ('" + username + "', '" + firstName + "', '" + lastName + "', '" + email + "');";
        statement.executeUpdate(query);
        query = "insert into Login values ('" + username + "', '" + password + "', " + "0);";
        statement.executeUpdate(query);

        return false;
    }
}
