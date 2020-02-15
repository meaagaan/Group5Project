package mochi.ui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;


public class LoginUI {
	Scene loginScene;

	public LoginUI(Stage primaryStage, Connection database) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fxmls/LoginUI.fxml"));

		this.loginScene = new Scene(root);
	}

	public Scene getLoginScene() {
		return loginScene;
	}
}
