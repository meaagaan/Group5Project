package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

import static org.testfx.api.FxAssert.verifyThat;

public class RegistrationTest extends ApplicationTest {

    private Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();

        RegistrationUI registrationUI = new RegistrationUI();
        Scene registrationScene = registrationUI.getRegistrationScene();

        currentStage = primaryStage;

        primaryStage.setScene(registrationScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Test
    // Check if the login label display correctly.
    public void loginLabelExist() {
        verifyThat("#loginLabel", Node::isVisible);
        verifyThat("#loginLabel", NodeQueryUtils.hasText("Login"));
    }

    // A Test to figure out how to see if the scene has changed

    @Test
    // Check if the sign up label display correctly.
    public void signUpLabelExist() {
        verifyThat("#signUpLabel", Node::isVisible);
        verifyThat("#signUpLabel", NodeQueryUtils.hasText("Sign up"));
    }

    @Test
    // Check if the first name field display correctly.
    public void firstNameFieldExist() {
        verifyThat("#firstNameField", Node::isVisible);
        verifyThat("#firstNameField", NodeQueryUtils.hasText(""));
    }

    @Test
    // Check if the first name field contain correct information.
    public void firstNameFieldContain() {
        clickOn("#firstNameField").write("firstname");
        verifyThat("#firstNameField", NodeQueryUtils.hasText("firstname"));
    }

    @Test
    // Check if the last name field display correctly.
    public void lastNameFieldExist() {
        verifyThat("#lastNameField", Node::isVisible);
        verifyThat("#lastNameField", NodeQueryUtils.hasText(""));
    }

    @Test
    // Check if the username field contain correct information.
    public void lastNameFieldContain() {
        clickOn("#lastNameField").write("lastname");
        verifyThat("#lastNameField", NodeQueryUtils.hasText("lastname"));
    }

    @Test
    // Check if the email field display correctly.
    public void emailFieldExist() {
        verifyThat("#emailField", Node::isVisible);
        verifyThat("#emailField", NodeQueryUtils.hasText(""));
    }

    @Test
    // Check if the username field contain correct information.
    public void emailFieldContain() {
        clickOn("#emailField").write("email");
        verifyThat("#emailField", NodeQueryUtils.hasText("email@email.com"));
    }


    @Test
    // Check if the username field display correctly.
    public void usernameFieldExist() {
        verifyThat("#usernameField", Node::isVisible);
        verifyThat("#usernameField", NodeQueryUtils.hasText(""));
    }

    @Test
    // Check if the username field contain correct information.
    public void usernameFieldContain() {
        clickOn("#usernameField").write("username");
        verifyThat("#usernameField", NodeQueryUtils.hasText("username"));
    }

    @Test
    // Check if the password field display correctly.
    public void passwordFieldExist() {
        verifyThat("#passwordField", Node::isVisible);
        verifyThat("#passwordField", NodeQueryUtils.hasText(""));
    }

    @Test
    // Check if the username field contain correct information.
    public void passwordFieldContain() {
        clickOn("#passwordField").write("password");
        verifyThat("#passwordField", NodeQueryUtils.hasText("password"));
    }

    @Test
    // Check if the login button display correctly.
    public void confirmButtonExist() {
        verifyThat("#confirmButton", Node::isVisible);
        verifyThat("#confirmButton", NodeQueryUtils.hasText("Confirm"));
    }

    // taken email
    // taken username
    // valid email
    // invalid email
    // valid password
    // invalid password

}
