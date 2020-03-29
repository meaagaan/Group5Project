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

		ReviewUI loginUI = new ReviewUI();
		Scene loginScene = loginUI.getReviewScene();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(loginScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
