package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.Product;
import mochi.User;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;
import mochi.ui.ProductInformation;
import mochi.ui.ProfileUI;
import mochi.ui.WishlistUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
	public Pane pane;
	public Label storeLabel;
	public Label titleLabel;
	public Label profileLabel;
	public TableView<ProductInformation> table;

	public TableColumn<ProductInformation, String> cname;
	public TableColumn<ProductInformation, String> cuser;
	public TableColumn<ProductInformation, String> cprice;
	public TableColumn<ProductInformation, String> cgenre;

	private Connection database;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.database = DBConnection.getDatabase();
		if (!(User.getFirstname() == null)) {
			titleLabel.setText(User.getFirstname() + "'s Library");
			profileLabel.setText(User.getFirstname());
		}
		libraryListFill();
	}

	private boolean libraryListFill() {
		ObservableList<ProductInformation> list = FXCollections.observableArrayList();
		ArrayList<Product> productList = User.getLibraryList();

		if (!(productList == null) && !(productList.isEmpty())) {
			for (Product p : productList)
				list.add(new ProductInformation(p.getPid(), p.getPname(), p.getPgenre(), p.getPdescription(), p.getPprice(), p.getPusername()));

			cname.setCellValueFactory(new PropertyValueFactory<>("name"));
			cgenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
			cprice.setCellValueFactory(new PropertyValueFactory<>("price"));
			cuser.setCellValueFactory(new PropertyValueFactory<>("user"));

			table.setItems(list);
			return true;
		}
		else {
			return false;
		}
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

	private boolean setWishlistScene() throws IOException {
		Stage primaryStage = (Stage) pane.getScene().getWindow();
		WishlistUI wishlistUI = new WishlistUI();

		if (wishlistUI != null) {
			primaryStage.setScene(wishlistUI.getWishlistScene());
			return true;
		}
		return false;
	}

	public boolean wishlistLabelClicked() throws IOException {
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

	public boolean profileLabelClicked() throws IOException {
		return setProfileScene();
	}
}
