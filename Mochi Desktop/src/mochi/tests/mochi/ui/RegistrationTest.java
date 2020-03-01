package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

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
    public void loginLabelExist() {
        verifyThat("#loginLabel", Node::isVisible);
        verifyThat("#loginLabel", NodeQueryUtils.hasText("Login"));
    }

    // A Test to figure out how to see if the scene has changed

    @Test
    public void signUpLabelExist() {
        verifyThat("#signUpLabel", Node::isVisible);
        verifyThat("#signUpLabel", NodeQueryUtils.hasText("Sign up"));
    }

    @Test
    public void confirmButtonExist() {
        verifyThat("#confirmButton", Node::isVisible);
        verifyThat("#confirmButton", NodeQueryUtils.hasText("Confirm"));
    }

    @Test
    public void allTextFieldsExist() {
        verifyThat("#firstNameField", Node::isVisible);
        verifyThat("#firstNameField", NodeQueryUtils.hasText(""));

        verifyThat("#lastNameField", Node::isVisible);
        verifyThat("#lastNameField", NodeQueryUtils.hasText(""));

        verifyThat("#emailField", Node::isVisible);
        verifyThat("#emailField", NodeQueryUtils.hasText(""));

        verifyThat("#usernameField", Node::isVisible);
        verifyThat("#usernameField", NodeQueryUtils.hasText(""));

        verifyThat("#passwordField", Node::isVisible);
        verifyThat("#passwordField", NodeQueryUtils.hasText(""));
    }

    @Test
    public void allFieldContainCorrectInformation() {
        clickOn("#firstNameField").write("firstname");
        verifyThat("#firstNameField", NodeQueryUtils.hasText("firstname"));

        clickOn("#lastNameField").write("lastname");
        verifyThat("#lastNameField", NodeQueryUtils.hasText("lastname"));

        clickOn("#emailField").write("email@email.com");
        verifyThat("#emailField", NodeQueryUtils.hasText("email@email.com"));

        clickOn("#usernameField").write("username");
        verifyThat("#usernameField", NodeQueryUtils.hasText("username"));

        clickOn("#passwordField").write("password");
        verifyThat("#passwordField", NodeQueryUtils.hasText("password"));
    }

    @Test
    public void ErrorLabelEmpty() {
        verifyThat("#usernameError", hasText(""));
        verifyThat("#emailError", hasText(""));
        verifyThat("#passwordError", hasText(""));
        verifyThat("#confirmError", hasText(""));
    }

    @Test
    public void ErrorWhenTakenUsername() {
        clickOn("#usernameField").write("admin");
        clickOn("#confirmButton");
        verifyThat("#usernameError", hasText("Taken"));
    }

    @Test
    public void ErrorWhenTakenEmail() {
        clickOn("#emailField").write("admin@email.com");
        clickOn("#confirmButton");
        verifyThat("#emailError", hasText("Taken"));
    }

    @Test
    public void ErrorWhenInvalidEmailWithNoAtSign() {
        clickOn("#emailField").write("admin");
        clickOn("#confirmButton");
        verifyThat("#emailError", hasText("Invalid"));
    }

    @Test
    public void ErrorWhenInvalidEmailWithNoDotCom() {
        clickOn("#emailField").write("admin@gmail");
        clickOn("#confirmButton");
        verifyThat("#emailError", hasText("Invalid"));
    }

    @Test
    public void NoErrorWhenvalidEmail() {
        clickOn("#emailField").write("google@gmail.com");
        clickOn("#confirmButton");
        verifyThat("#emailError", hasText(""));
    }


    // valid password
    // invalid password

}
