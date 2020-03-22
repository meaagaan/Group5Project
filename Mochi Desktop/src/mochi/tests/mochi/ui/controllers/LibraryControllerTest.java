package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.LibraryUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;

public class LibraryControllerTest extends ApplicationTest {
	LibraryController libraryController;

	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		LibraryUI libraryUI = new LibraryUI();
		Scene libraryScene = libraryUI.getLibraryScene();

		this.libraryController = libraryUI.getLibraryController();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(libraryScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Check if the store is clicked.
	public void storeLabelClicked() {
		Platform.runLater(() -> {
			try {
				assertEquals(true, libraryController.storeLabelClicked());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	// Check if the profile is clicked.
	public void profileLabelClicked() {
		Platform.runLater(() -> {
			try {
				assertEquals(true, libraryController.profileLabelClicked());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}