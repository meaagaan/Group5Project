package mochi.ui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.LoginController;

import java.io.IOException;


public class LoginUI {
	private Scene loginScene;
	private LoginController loginController;

	public LoginUI() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/LoginUI.fxml"));
		Parent root = loader.load();

		this.loginController = loader.getController();
		this.loginScene = new Scene(root);
	}

	public Scene getLoginScene() {
		return this.loginScene;
	}

	public LoginController getLoginController() {
		return this.loginController;
	}
}
