package mochi.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class RegistrationTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();

        RegistrationUI registrationUI = new RegistrationUI();
        Scene registrationScene = registrationUI.getRegistrationScene();

        primaryStage.setScene(registrationScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Test
    public void containLoginLabel() {
        verifyThat("#loginLabel", hasText("Login"));
    }

    @Test
    public void containSignupLabel() {
        verifyThat("#signUpLabel", hasText("Sign Up"));
    }
}
