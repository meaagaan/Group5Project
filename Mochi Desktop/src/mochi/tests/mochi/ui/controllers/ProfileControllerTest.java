package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ProfileUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;

public class ProfileControllerTest extends ApplicationTest {

	ProfileController profileController;

	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		ProfileUI profileUI = new ProfileUI();
		Scene profileScene = profileUI.getProfileScene();

		this.profileController = profileUI.getProfileController();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(profileScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Check if the button is clicked.
	public void editButtonClicked() {
		Platform.runLater(() -> {
			assertEquals(true, profileController.editButtonClicked());
		});
	}

	@Test
	public void submitButtonClicked() {
		Platform.runLater(() -> {
			assertEquals(true, profileController.submitButtonClicked());
		});
	}
}