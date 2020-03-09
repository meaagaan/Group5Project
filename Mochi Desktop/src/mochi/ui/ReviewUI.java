package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ReviewUI {
    Scene ReviewScene;

    public ReviewUI() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxmls/ReviewUI.fxml"));
        this.ReviewScene = new Scene(root);
    }

    public Scene getReviewScene() { return ReviewScene; }
}
