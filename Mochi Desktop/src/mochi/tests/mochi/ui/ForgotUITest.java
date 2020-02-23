package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class ForgotUITest extends ApplicationTest {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ForgotUI forgotUI = new ForgotUI();
		Scene forgotScene = forgotUI.getForgotScene();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(forgotScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Check if the login label display correctly.
	public void loginLabelExist() {
		verifyThat("#loginLabel", Node::isVisible);
		verifyThat("#loginLabel", hasText("Login"));
	}

	@Test
	// Check if the sign up label display correctly.
	public void signUpLabelExist() {
		verifyThat("#signUpLabel", Node::isVisible);
		verifyThat("#signUpLabel", hasText("Sign up"));
	}

	@Test
	// Check if the email field display correctly.
	public void emailFieldExist() {
		verifyThat("#emailField", Node::isVisible);
		verifyThat("#emailField", hasText(""));
	}

	@Test
	// Check if the email field contain correct information.
	public void emailFieldContain() {
		clickOn("#emailField").write("myemail@email.com");
		verifyThat("#emailField", hasText("myemail@email.com"));
	}

	@Test
	// Check if the send button display correctly.
	public void sendButtonExist() {
		verifyThat("#sendButton", Node::isVisible);
		verifyThat("#sendButton", hasText("Send"));
	}
}