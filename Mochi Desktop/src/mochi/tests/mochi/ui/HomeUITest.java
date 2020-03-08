package mochi.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class HomeUITest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HomeUI homeUI = new HomeUI();
        Scene homeScene = homeUI.getHomeScene();

        primaryStage.setScene(homeScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    // Check if the User Profile Button Display properly
    // Check if search field display properly
    // check if filter label display properly
    // check if choice box display properly




}