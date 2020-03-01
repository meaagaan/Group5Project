package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class LoginUITest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginUI loginUI = new LoginUI();
        Scene loginScene = loginUI.getLoginScene();

        primaryStage.setTitle("Mochi Desktop");
        primaryStage.setScene(loginScene);
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
	// Check if the need help label display correctly.
	public void needHelpLabelExist() {
		verifyThat("#needHelpLabel", Node::isVisible);
		verifyThat("#needHelpLabel", hasText("Need Help?"));
	}

	@Test
	// Check if the warning label empty.
	public void warningLabelEmpty() {
		verifyThat("#warningLabel", hasText(""));
	}

	@Test
	// Check if the username field display correctly.
	public void usernameFieldExist() {
		verifyThat("#usernameField", Node::isVisible);
		verifyThat("#usernameField", hasText(""));
	}

	@Test
	// Check if the username field contain correct information.
	public void usernameFieldContain() {
		clickOn("#usernameField").write("myusername");
		verifyThat("#usernameField", hasText("myusername"));
	}

	@Test
	// Check if the password field display correctly.
	public void passwordFieldExist() {
		verifyThat("#passwordField", Node::isVisible);
		verifyThat("#passwordField", hasText(""));
	}

	@Test
	// Check if the username field contain correct information.
	public void passwordFieldContain() {
		clickOn("#passwordField").write("6543516815");
		verifyThat("#passwordField", hasText("6543516815"));
	}

	@Test
	// Check if the login button display correctly.
	public void loginButtonExist() {
		verifyThat("#loginButton", Node::isVisible);
		verifyThat("#loginButton", hasText("Login"));
	}
}