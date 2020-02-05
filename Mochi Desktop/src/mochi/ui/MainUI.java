package mochi.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginUI loginUI = new LoginUI(primaryStage);

		Scene loginScene = loginUI.getLoginScene();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}
}
