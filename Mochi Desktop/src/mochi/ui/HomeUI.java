package mochi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mochi.ui.controllers.HomeController;

import java.io.IOException;

public class HomeUI
{
    private Scene homeScene;
    private HomeController homeController;

    public HomeUI() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/HomeUI.fxml"));
        Parent root = loader.load();

        this.homeController = loader.getController();
        this.homeScene = new Scene(root);
    }

    public Scene getHomeScene() { return this.homeScene; }

    public HomeController getHomeController() { return this.homeController; }
}
