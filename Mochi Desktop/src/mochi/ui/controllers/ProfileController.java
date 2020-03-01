package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mochi.User;
import mochi.db.DBConnection;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

	public TextField usernameField;
	public TextField firstNameField;
	public TextField lastNameField;
	public TextField emailField;
	public Button submitButton;

	private Connection database;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();

		usernameField.setFocusTraversable(false);
		usernameField.setMouseTransparent(true);
		usernameField.setText(User.getUsername());

		firstNameField.setFocusTraversable(false);
		firstNameField.setMouseTransparent(true);
		firstNameField.setText(User.getFirstname());

		lastNameField.setFocusTraversable(false);
		lastNameField.setMouseTransparent(true);
		lastNameField.setText(User.getLastname());

		emailField.setFocusTraversable(false);
		emailField.setMouseTransparent(true);
		emailField.setText(User.getEmail());

		submitButton.setFocusTraversable(false);
		submitButton.setMouseTransparent(true);
	}

	public boolean editButtonClicked() {
		firstNameField.setFocusTraversable(true);
		firstNameField.setMouseTransparent(false);
		firstNameField.setEditable(true);

		lastNameField.setFocusTraversable(true);
		lastNameField.setMouseTransparent(false);
		lastNameField.setEditable(true);

		emailField.setFocusTraversable(true);
		emailField.setMouseTransparent(false);
		emailField.setEditable(true);

		submitButton.setMouseTransparent(false);

		if (usernameField.isEditable() && firstNameField.isEditable() && lastNameField.isEditable() && emailField.isEditable())
			return true;
		return false;
	}

	private boolean updateInformation() {
		PreparedStatement statement = null;

		try {
			statement = database.prepareStatement("UPDATE `mochi-desktop`.User SET" +
					" firstname = ?, lastname = ? WHERE username = ?");
			statement.setString(1, firstNameField.getText());
			statement.setString(2, lastNameField.getText());
			statement.setString(3, User.getUsername());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean submitButtonClicked() {

		firstNameField.setFocusTraversable(false);
		firstNameField.setMouseTransparent(true);
		firstNameField.setEditable(false);

		lastNameField.setFocusTraversable(false);
		lastNameField.setMouseTransparent(true);
		lastNameField.setEditable(false);

		emailField.setFocusTraversable(false);
		emailField.setMouseTransparent(true);
		emailField.setEditable(false);

		submitButton.setMouseTransparent(true);

		System.out.println("OK");

		return updateInformation();
	}

}
