package mochi.ui.controllers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import mochi.ui.ForgotUI;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class ForgotControllerTest extends ApplicationTest {
	private ForgotController forgotController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		ForgotUI forgotUI = new ForgotUI();
		Scene forgotScene = forgotUI.getForgotScene();

		this.forgotController = forgotUI.getForgotController();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(forgotScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Switching scene to login ui
	public void switchToLoginUI() {
		Platform.runLater(() -> {
			try {
				assertEquals(forgotController.loginLabelClick(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	// Switching scene to registration ui
	public void switchToRegistrationUI() {
		Platform.runLater(() -> {
			try {
				assertEquals(forgotController.signUpLabelClick(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	// Check if everything is working when the email is correct.
	public void sendSuccess() {
		clickOn("#emailField").write("admin@email.com");
		Platform.runLater(() -> {
			assertEquals(forgotController.sendButtonClick(), true);
			verifyThat("#warningLabel", hasText("Please check your email."));
		});
	}

	@Test
	// Check if everything is working when the email is incorrect.
	public void sendFail() {
		clickOn("#emailField").write("admin1@mail.com");
		Platform.runLater(() -> {
			assertEquals(forgotController.sendButtonClick(), false);
			verifyThat("#warningLabel", hasText("This email does not associated with any account."));
		});
	}
}