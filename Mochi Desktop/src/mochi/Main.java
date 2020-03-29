package mochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.LoginUI;
import mochi.ui.ReviewUI;

import java.sql.Connection;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		LoginUI loginUI = new LoginUI();
		Scene loginScene = loginUI.getLoginScene();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(loginScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
