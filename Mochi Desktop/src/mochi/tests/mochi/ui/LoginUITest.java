package mochi.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class LoginUITest extends ApplicationTest {
    Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        DBConnection connection = new DBConnection();

        LoginUI loginUI = new LoginUI();
        Scene loginScene = loginUI.getLoginScene();

        primaryStage.setTitle("Mochi Desktop");
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Test
    // This test check if the scene change when click sign up label.
    public void signUpLabelClick() {
        clickOn("#signUpLabel");
        assertEquals(RegistrationUI.class, primaryStage.getScene().getClass());
    }
}