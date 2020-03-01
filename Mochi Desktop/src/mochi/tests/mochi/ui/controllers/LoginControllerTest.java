package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.LoginUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class LoginControllerTest extends ApplicationTest {
    private LoginController loginController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();

        LoginUI loginUI = new LoginUI();
        Scene loginScene = loginUI.getLoginScene();

        this.loginController = loginUI.getLoginController();

        primaryStage.setTitle("Mochi Desktop");
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Test
    // Switching scene to registration ui
    public void switchToRegistrationUI() {
        Platform.runLater(() -> {
			try {
				assertEquals(true, loginController.signUpLabelClick());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
    }

    @Test
	// Switching scene to forgot ui
	public void switchToForgotUI() {
		Platform.runLater(() -> {
			try {
				assertEquals(true, loginController.needHelpLabelClick());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

    @Test
	// Check if everything is working when login successfully.
    public void loginSuccess() {
        clickOn("#usernameField").write("admin");
        clickOn("#passwordField").write("admin");
        Platform.runLater(() -> {
            assertEquals(true, loginController.loginButtonClick());
        });
    }

    @Test
	// Check if everything is working when fail to login.
	public void loginFail() {
		clickOn("#usernameField").write("admin");
		clickOn("#passwordField").write("12345678");
		Platform.runLater(() -> {
			assertEquals(false, loginController.loginButtonClick());
		});
	}

}