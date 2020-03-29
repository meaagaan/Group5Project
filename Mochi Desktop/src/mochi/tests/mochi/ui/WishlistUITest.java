package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class WishlistUITest extends ApplicationTest {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		WishlistUI wishlistUI = new WishlistUI();
		Scene wishlistScene = wishlistUI.getWishlistScene();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(wishlistScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Check if the title label display correctly.
	public void titleLabelExist() {
		verifyThat("#titleLabel", Node::isVisible);
		verifyThat("#titleLabel", hasText("PlaceHolder"));
	}

	@Test
	// Check if the profile label display correctly.
	public void profileLabelExist() {
		verifyThat("#profileLabel", Node::isVisible);
		verifyThat("#profileLabel", hasText("PlaceHolder"));
	}

	@Test
	// Check if the store label display correctly.
	public void storeLabelExist() {
		verifyThat("#storeLabel", Node::isVisible);
		verifyThat("#storeLabel", hasText("Store"));
	}

	@Test
	// Check if the library label display correctly.
	public void libraryLabelExist() {
		verifyThat("#libraryLabel", Node::isVisible);
		verifyThat("#libraryLabel", hasText("Library"));
	}

	@Test
	// Check if the wishlist label display correctly.
	public void wishlistLabelExist() {
		verifyThat("#wishlistLabel", Node::isVisible);
		verifyThat("#wishlistLabel", hasText("Wishlist"));
	}

	@Test
	// Check if the wishlist list display correctly.
	public void wishlistTableExist() {
		verifyThat("#wishList", Node::isVisible);
	}
}