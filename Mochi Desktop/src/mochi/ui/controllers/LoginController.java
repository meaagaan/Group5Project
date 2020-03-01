package mochi.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.ForgotUI;
import mochi.ui.ProfileUI;
import mochi.ui.RegistrationUI;

import java.io.IOException;
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
	public Label needHelpLabel;
	public Button loginButton;
	public TextField usernameField;
	public PasswordField passwordField;

	private Connection database;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();
	}

	public boolean signUpLabelClick() throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		RegistrationUI registrationUI = new RegistrationUI();

		if (registrationUI != null) {
			primaryStage.setScene(registrationUI.getRegistrationScene());
			return true;
		}
		return false;
	}

	public boolean needHelpLabelClick() throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		ForgotUI forgotUI = new ForgotUI();

		if (forgotUI != null) {
			primaryStage.setScene(forgotUI.getForgotScene());
			return true;
		}
		return false;
	}

	private boolean setMainScene () throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		ProfileUI profileUI = new ProfileUI();

		if (profileUI != null) {
			primaryStage.setScene(profileUI.getProfileScene());
			return true;
		}
		return false;
	}

	private boolean retreiveUserInformation(String username) {
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			statement = (Statement) database.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.User");

			while(resultSet.next()) {
				if (resultSet.getString(1).equals(username)) {
					User.setUsername(resultSet.getString(1));
					User.setFirstname(resultSet.getString(2));
					User.setLastname(resultSet.getString(3));
					User.setEmail(resultSet.getString(4));
					return true;
				}
				else {
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginButtonClick() {
		User currentUser = new User();

		ResultSet resultSet = null;
		Statement statement = null;

		String username = usernameField.getText();
		String password = passwordField.getText();

		try {
			statement = (Statement) database.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.Login");

			while(resultSet.next()) {
				if (resultSet.getString(1).equals(username) &&
						resultSet.getString(2).equals(password)) {
					return (retreiveUserInformation(username) == true && setMainScene() == true
							&& User.setVerified(resultSet.getInt(3)) == true) ? true : false;
				}
				else {
					warningLabel.getStyleClass().add("Warning_Label_Error");
					warningLabel.setText("You've enter a wrong username or password.");
					return false;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
