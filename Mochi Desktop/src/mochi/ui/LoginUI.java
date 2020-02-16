package mochi.ui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class LoginUI {
	Scene loginScene;

	public LoginUI() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fxmls/LoginUI.fxml"));

		this.loginScene = new Scene(root);
	}

	public Scene getLoginScene() {
		return loginScene;
	}
}
