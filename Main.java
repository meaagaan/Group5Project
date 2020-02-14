
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

public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window= primaryStage;
        window.setTitle("Registration");
        Label first_name= new Label("First Name");
        TextField fname = new TextField();
        Label last_name= new Label("Last Name");
        TextField lname = new TextField();
        Label id_email= new Label("Email");
        TextField email = new TextField();
        Label passw= new Label("Enter a Password");
        TextField password = new TextField();

        button = new Button("Signup Demo");
        button.setText("SignUp");
        VBox layout =new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(first_name);
        layout.getChildren().addAll(fname);
        layout.getChildren().addAll(last_name);
        layout.getChildren().addAll(lname);
        layout.getChildren().addAll(id_email);
        layout.getChildren().addAll(email);
        layout.getChildren().addAll(passw);
        layout.getChildren().addAll(password);

        layout. getChildren(). addAll(button);



        Scene scene = new Scene(layout,500, 500);
        window.setScene(scene);
        window.show();
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
