package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.LibraryController;

import java.io.IOException;

public class LibraryUI {
	private Scene libraryScene;
	private LibraryController libraryController;

	public LibraryUI() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/LibraryUI.fxml"));
		Parent root = loader.load();

		this.libraryController = loader.getController();
		this.libraryScene = new Scene(root);
	}

	public Scene getLibraryScene() {
		return this.libraryScene;
	}

	public LibraryController getLibraryController() {
		return this.libraryController;
	}
}
