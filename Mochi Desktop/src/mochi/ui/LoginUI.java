package mochi.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.sql.Connection;


public class LoginUI {
	Scene loginScene;

	public LoginUI(Stage primaryStage, Connection database) {
		GridPane grid = new GridPane();

		Text sceneTitle = new Text("Login");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		Label usernameLabel = new Label("Username: ");
		Label passwordLabel = new Label("Password: ");

		TextField usernameField = new TextField();
		TextField passwordField = new TextField();

		Button loginButton = new Button("Login");

		HBox loginHBox = new HBox(10);
		loginHBox.setAlignment(Pos.BOTTOM_RIGHT);
		loginHBox.getChildren().add(loginButton);

		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		grid.add(sceneTitle, 0, 0, 2, 1);

		grid.add(usernameLabel, 0, 1);
		grid.add(passwordLabel, 0, 2);

		grid.add(usernameField, 1, 1);
		grid.add(passwordField, 1, 2);

		grid.add(loginHBox, 1, 4);

		this.loginScene = new Scene(grid, 300, 275);
	}

	public Scene getLoginScene() {
		return loginScene;
	}
}
