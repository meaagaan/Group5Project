package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.LibraryDatabase;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.ForgotUI;
import mochi.ui.LibraryUI;
import mochi.ui.RegistrationUI;
import mochi.WishlistDatabase;
import mochi.ui.HomeUI;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
		HomeUI homeUI = new HomeUI();

		if (homeUI != null) {
			primaryStage.setScene(homeUI.getHomeScene());
			return true;
		}
		return false;
	}

	private boolean retreiveUserInformation(String username) {
		WishlistDatabase wishlistDatabase = new WishlistDatabase(database);
		LibraryDatabase libraryDatabase = new LibraryDatabase(database);

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = database.prepareStatement("SELECT firstname, lastname, email FROM User WHERE username = ?");
			statement.setString(1, username);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				User.setUsername(username);
				User.setFirstname(resultSet.getString("firstname"));
				User.setLastname(resultSet.getString("lastname"));
				User.setEmail(resultSet.getString("email"));
				return (true && (wishlistDatabase.readFile(username) || libraryDatabase.readFile(username)));
			}
			else {
				return false;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginButtonClick() {
		User currentUser = new User();

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String username = usernameField.getText();
		String password = passwordField.getText();

		try {
			statement = database.prepareStatement("SELECT password, verified FROM Login WHERE username = ?");
			statement.setString(1, username);
			resultSet = statement.executeQuery();

			if (resultSet.next() && password.equals(resultSet.getString("password"))) {
				return (retreiveUserInformation(username) == true && setMainScene() == true
						&& User.setVerified(resultSet.getInt("verified")) == true) ? true : false;
			}
			else {
				warningLabel.getStyleClass().add("Warning_Label_Error");
				warningLabel.setText("You've enter a wrong username or password.");
				return false;
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
