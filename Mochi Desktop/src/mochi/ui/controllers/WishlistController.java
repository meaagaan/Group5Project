package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.User;
import mochi.WishlistDatabase;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;
import mochi.ui.LibraryUI;
import mochi.ui.ProfileUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class WishlistController implements Initializable {
	public Pane pane;
	public Label storeLabel;
	public Label titleLabel;
	public Label profileLabel;
	public ListView wishList;
	private Connection database;
	private WishlistDatabase wishlistDatabase;
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();
		this.wishlistDatabase = new WishlistDatabase(database);

		if (!(User.getFirstname() == null)) {
			titleLabel.setText(User.getFirstname() + "'s Wishlist");
			profileLabel.setText(User.getFirstname());
		}
		wishListFill();
	}

	public boolean deleteButtonClicked() throws FileNotFoundException, SQLException {
		int index = -1;
		index = wishList.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			wishList.getItems().remove(index);

			List<Object> list = Arrays.asList(wishList.getItems().toArray());
			List<String> stringList = list.stream()
					.map(object -> Objects.toString(object, null))
					.collect(Collectors.toList());

			User.setWishlist((ArrayList) stringList);
			this.wishlistDatabase.writeText(User.getWishlist());
			this.wishlistDatabase.writeFile(User.getUsername());
			return true;
		}
		return false;
	}

	private boolean wishListFill() {
		if (!(User.getWishlist() == null) && !(User.getWishlist().isEmpty())) {
			for (String s : User.getWishlist())
				wishList.getItems().add(s);
			return true;
		}
		else {
			return false;
		}
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

	private boolean setLibraryScene () throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		LibraryUI libraryUI = new LibraryUI();

		if (libraryUI != null) {
			primaryStage.setScene(libraryUI.getLibraryScene());
			return true;
		}
		return false;
	}

	public boolean libraryLabelClicked() throws IOException {
		return setLibraryScene();
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
