package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.WishlistController;

import java.io.IOException;

public class WishlistUI {
	private Scene wishlistScene;
	private WishlistController wishlistController;

	public WishlistUI() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/WishlistUI.fxml"));
		Parent root = loader.load();

		this.wishlistController = loader.getController();
		this.wishlistScene = new Scene(root);
	}

	public Scene getWishlistScene() {
		return this.wishlistScene;
	}

	public WishlistController getWishlistController() {
		return this.wishlistController;
	}
}
