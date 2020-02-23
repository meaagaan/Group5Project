package mochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreateProduct extends Application {
    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Product Registration");
        Label product_name = new Label("Product name");
        TextField pn = new TextField();
        Label product_description = new Label("Description");
        TextField pd = new TextField();
        ChoiceBox<String> genre = new ChoiceBox<>();
        genre.getItems().addAll("education", "business", "personal");

        button = new Button("Product Registration");
        button.setText("Register Product");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(product_name);
        layout.getChildren().addAll(pn);
        layout.getChildren().addAll(product_description);
        layout.getChildren().addAll(pd);
        layout.getChildren().addAll(genre);

        layout.getChildren().addAll(button);


        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}