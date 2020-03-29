package mochi.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import mochi.db.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class MerchantController implements Initializable {
    public Pane pane;
    public Label storeLabel;
    public Label libraryLabel;
    public Label wishlistLabel;
    public Label userProfileLabel;
    public TableView productTableView;
    public TableColumn productNameTableColumn;
    public TableColumn priceTableColumn;
    public TableColumn ratingTableColumn;

    private Connection database;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.database = DBConnection.getDatabase();
    }

}