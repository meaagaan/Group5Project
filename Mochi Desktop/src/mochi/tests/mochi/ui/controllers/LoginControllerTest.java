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
            assertEquals(loginController.signUpLabelClick(), true);
        });
    }

    @Test
	// Switching scene to forgot ui
	public void switchToForgotUI() {
		Platform.runLater(() -> {
			try {
				assertEquals(loginController.needHelpLabelClick(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

    @Test
	// Check if everything is working when login successfully.
    public void loginSuccess() {
        clickOn("#usernameField").write("admin");
        clickOn("#passwordField").write("123456789");
        Platform.runLater(() -> {
            assertEquals(loginController.loginButtonClick(), true);
			verifyThat("#warningLabel", hasText("Welcome."));
        });
    }

    @Test
	// Check if everything is working when fail to login.
	public void loginFail() {
		clickOn("#usernameField").write("admin");
		clickOn("#passwordField").write("12345678");
		Platform.runLater(() -> {
			assertEquals(loginController.loginButtonClick(), false);
			verifyThat("#warningLabel", hasText("You've enter a wrong username or password."));
		});
	}

}