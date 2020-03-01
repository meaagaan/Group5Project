package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.ProfileController;

import java.io.IOException;

public class ProfileUI {
	private Scene profileScene;
	private ProfileController profileController;

	public ProfileUI() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/ProfileUI.fxml"));
		Parent root = loader.load();

		this.profileController = loader.getController();
		this.profileScene = new Scene(root);
	}

	public Scene getProfileScene() {
		return this.profileScene;
	}

	public ProfileController getForgotController() {
		return this.profileController;
	}
}
