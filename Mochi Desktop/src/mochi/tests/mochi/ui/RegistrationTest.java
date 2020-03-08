package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class RegistrationTest extends ApplicationTest {

    private Stage currentStage;
    private Connection database;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();
        this.database = connection.getDatabase();

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
        clickOn("#usernameField").write("Admin");
        clickOn("#confirmButton");
        verifyThat("#usernameError", hasText("Taken"));
    }

    @Test
    public void ErrorWhenTakenEmail() {
        clickOn("#emailField").write("Admin@mail.com");
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

    @Test
    public void ValidPassword() {
        clickOn("#passwordField").write("12345");
        clickOn("#confirmButton");
        verifyThat("#passwordError", hasText(""));
    }

    @Test
    public void InvalidPassword() {
        clickOn("#passwordField").write("1234");
        clickOn("#confirmButton");
        verifyThat("#passwordError", hasText("Invalid, Needs 5 characters"));
    }

    @Test
    public void SuccessfulRegistration() throws SQLException {

        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = (Statement) database.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `mochi-desktop`.User;");

            while(resultSet.next()) {
                if (resultSet.getString(1).equals("123")) {
                    statement.executeUpdate("DELETE FROM `mochi-desktop`.`User` WHERE (`username` = '123');");
                    statement.executeUpdate("DELETE FROM `mochi-desktop`.`Login` WHERE (`username` = '123');");
                    break;
                }
            }

            clickOn("#firstNameField").write("123");
            clickOn("#lastNameField").write("123");
            clickOn("#emailField").write("123@gmail.com");
            clickOn("#usernameField").write("123");
            clickOn("#passwordField").write("123123");
            clickOn("#confirmButton");
            verifyThat("#confirmError", hasText("Success"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
