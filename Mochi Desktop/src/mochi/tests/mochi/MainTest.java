package mochi;

import static org.testfx.api.FxAssert.verifyThat;

import mochi.db.DBConnection;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import mochi.ui.LoginUI;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.junit.Test;

public class MainTest extends ApplicationTest {
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

    @Test
    public void containSignupLabel() {
        verifyThat("#signUpLabel", hasText("Sign up"));
    }

    @Test
    public void containLoginLabel() {
        verifyThat("#loginLabel", hasText("Login"));
    }

    @Test
    public void tryLogin() {
        clickOn("#usernameField");
        write("admin");

        clickOn("#passwordField");
        write("1234");

        clickOn("#loginButton");
    }
}