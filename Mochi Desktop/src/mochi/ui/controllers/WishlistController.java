package mochi.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mochi.Product;
import mochi.ProductPageAssist;
import mochi.User;
import mochi.WishlistDatabase;
import mochi.db.DBConnection;
import mochi.ui.HomeUI;
import mochi.ui.LibraryUI;
import mochi.ui.ProductInformation;
import mochi.ui.ProfileUI;
import mochi.ui.ProductPageUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.*;

public class WishlistController implements Initializable {
	public Pane pane;
	public Label storeLabel;
	public Label titleLabel;
	public Label profileLabel;
	public Button viewButton;
	public TableView<ProductInformation> table;

	public TableColumn<ProductInformation, String> cname;
	public TableColumn<ProductInformation, String> cuser;
	public TableColumn<ProductInformation, String> cprice;
	public TableColumn<ProductInformation, String> cgenre;

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
		index = table.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			table.getItems().remove(index);

			ObservableList<ProductInformation> list = table.getItems();
			ArrayList<Product> productList = new ArrayList<Product>();

			for (ProductInformation p : list)
				productList.add(new Product(p.getId(), p.getName(), p.getGenre(), p.getProductinfo(), p.getPrice(), p.getUser()));

			User.setWishlist(productList);
			this.wishlistDatabase.writeText(User.getWishlist());
			this.wishlistDatabase.writeFile(User.getUsername());
			return true;
		}
		return false;
	}

	private boolean wishListFill() {
		ObservableList<ProductInformation> list = FXCollections.observableArrayList();
		ArrayList<Product> productList = User.getWishlist();

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

	private boolean setProductPage() throws IOException {
		ProductInformation selectedProduct = table.getSelectionModel().getSelectedItem();
		ProductPageAssist product = new ProductPageAssist();

		product.setPname(selectedProduct.getName());
		product.setPgenre(selectedProduct.getGenre());
		product.setPdescription(selectedProduct.getProductinfo());
		product.setPprice(selectedProduct.getPrice());

		Stage primaryStage = (Stage) pane.getScene().getWindow();
		ProductPageUI productpageUI = new ProductPageUI();

		if (productpageUI != null) {
			primaryStage.setScene(productpageUI.getProductPageScene());
			return true;
		}
		return false;
	}

	public boolean viewButtonClicked() throws IOException {
		return setProductPage();
	}
}
