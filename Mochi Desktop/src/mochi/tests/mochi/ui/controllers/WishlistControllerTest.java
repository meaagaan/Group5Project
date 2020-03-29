package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.WishlistUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;

public class WishlistControllerTest extends ApplicationTest {
	WishlistController wishlistController;

	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		WishlistUI wishlistUI = new WishlistUI();
		Scene wishlistScene = wishlistUI.getWishlistScene();

		this.wishlistController = wishlistUI.getWishlistController();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(wishlistScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Check if the store is clicked.
	public void storeLabelClicked() {
		Platform.runLater(() -> {
			try {
				assertEquals(true, wishlistController.storeLabelClicked());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	// Check if the library is clicked.
	public void libraryLabelClicked() {
		Platform.runLater(() -> {
			try {
				assertEquals(true, wishlistController.libraryLabelClicked());
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
				assertEquals(true, wishlistController.profileLabelClicked());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}