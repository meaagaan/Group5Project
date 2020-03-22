package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class ProfileUITest extends ApplicationTest {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DBConnection connection = new DBConnection();

		ProfileUI profileUI = new ProfileUI();
		Scene profileScene = profileUI.getProfileScene();

		primaryStage.setTitle("Mochi Desktop");
		primaryStage.setScene(profileScene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	@Test
	// Check if the username label display correctly.
	public void usernameLabelExist() {
		verifyThat("#usernameLabel", Node::isVisible);
		verifyThat("#usernameLabel", hasText("Username"));
	}

	@Test
	// Check if the name label display correctly.
	public void nameLabelExist() {
		verifyThat("#nameLabel", Node::isVisible);
		verifyThat("#nameLabel", hasText("Name"));
	}

	@Test
	// Check if the email label display correctly.
	public void emailLabelExist() {
		verifyThat("#emailLabel", Node::isVisible);
		verifyThat("#emailLabel", hasText("Email"));
	}

	@Test
	// Check if the store label display correctly.
	public void storeLabelExist() {
		verifyThat("#storeLabel", Node::isVisible);
		verifyThat("#storeLabel", hasText("Store"));
	}

	@Test
	// Check if the library label display correctly.
	public void libraryLabelExist() {
		verifyThat("#libraryLabel", Node::isVisible);
		verifyThat("#libraryLabel", hasText("Library"));
	}

	@Test
	// Check if the submit button display correctly.
	public void submitButtonExist() {
		verifyThat("#submitButton", Node::isVisible);
		verifyThat("#submitButton", hasText("Submit"));
	}

	@Test
	// Check if the edit button display correctly.
	public void editButtonExist() {
		verifyThat("#editButton", Node::isVisible);
	}
}