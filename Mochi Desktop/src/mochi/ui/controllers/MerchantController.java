package mochi.ui.controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.MerchantProductDetail;
import mochi.ReviewUserDetail;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MerchantController implements Initializable {
	public Pane pane;
	public Label storeLabel;
	public Label libraryLabel;
	public Label wishlistLabel;
	public Label userProfileLabel;
	public Label MerchantLabel;
	public Label merchantPageLabel;
	public TableView<MerchantProductDetail> productTableView;
	public TableColumn<MerchantProductDetail, String> productNameTableColumn;
	public TableColumn<MerchantProductDetail, String> priceTableColumn;
	public ObservableList<MerchantProductDetail> data;

	private Connection database;
	private String Username;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();
		if (!(User.getFirstname() == null )) {
			Username = User.getFirstname();
		}

		try {
			data = FXCollections.observableArrayList();
			ResultSet resultSet = null;
			Statement statement = null;

			statement = (Statement) database.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.Product;");

			while (resultSet.next() && resultSet.getString(6).equals(Username)) {
				data.add(new MerchantProductDetail(resultSet.getString(2), resultSet.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Set cell value factory to tableview.
		productNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
		priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

		productTableView.setItems(null);
		productTableView.setItems(data);
	}

	private boolean setHomeScene() throws IOException {
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

	private boolean setLibraryScene() throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		LibraryUI libraryUI = new LibraryUI();

		if (libraryUI != null) {
			primaryStage.setScene(libraryUI.getLibraryScene());
			return true;
		}
		return false;
	}

	public boolean LibraryLabelClicked() throws IOException {
		return setLibraryScene();
	}

	private boolean setWishlistScene() throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		WishlistUI wishlistUI = new WishlistUI();

		if (wishlistUI != null) {
			primaryStage.setScene(wishlistUI.getWishlistScene());
			return true;
		}
		return false;
	}

	public boolean WishlistLabelClicked() throws IOException {
		return setWishlistScene();
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

	public boolean userProfileLabelClicked() throws IOException {
		return setProfileScene();
	}
}