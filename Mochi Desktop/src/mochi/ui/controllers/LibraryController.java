package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
	public Pane pane;
	public Label storeLabel;
	public Label titleLabel;
	private Connection database;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();

		titleLabel.setText(User.getFirstname() + "'s Library");
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
}
