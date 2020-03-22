package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;
import mochi.ui.ProfileUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
	public Pane pane;
	public Label storeLabel;
	public Label titleLabel;
	public Label profileLabel;
	public ListView libraryList;
	private Connection database;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();

		titleLabel.setText(User.getFirstname() + "'s Library");
		profileLabel.setText(User.getFirstname());

		libraryList.getItems().add("Program 1");
	}

	private boolean setHomeScene () throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		HomeUI homeUI = new HomeUI();

		if (homeUI != null) {
			primaryStage.setScene(homeUI.getHomeScene());
			return true;
		}
		return false;
	}

	public boolean storeLabelClicked() throws IOException {
		return setHomeScene();
	}

	private boolean setProfileScene() throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		ProfileUI profileUI = new ProfileUI();

		if (profileUI != null) {
			primaryStage.setScene(profileUI.getProfileScene());
			return true;
		}
		return false;
	}

	public boolean profileLabelClicked() throws IOException {
		return setProfileScene();
	}
}
