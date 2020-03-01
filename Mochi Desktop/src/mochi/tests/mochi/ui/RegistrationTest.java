package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

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
    // Check if the login label display correctly.
    public void loginLabelExist() {
        verifyThat("#loginLabel", Node::isVisible);
        verifyThat("#loginLabel", NodeQueryUtils.hasText("Login"));
    }

    @Test
    // Check if the sign up label display correctly.
    public void signUpLabelExist() {
        verifyThat("#signUpLabel", Node::isVisible);
        verifyThat("#signUpLabel", NodeQueryUtils.hasText("Sign up"));
    }

    @Test
    // Check if the username field display correctly.
    public void usernameFieldExist() {
        verifyThat("#usernameField", Node::isVisible);
        verifyThat("#usernameField", NodeQueryUtils.hasText(""));
    }




}
