package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

public class ProductUITest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ProductUI productUI = new ProductUI();
        Scene productScene = productUI.getProductScene();

        primaryStage.setScene(productScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Test
    // Check if the registration label displays correctly.
    public void registrationLabelExist() {
        verifyThat("#registration", Node::isVisible);
        verifyThat("#registration", hasText("Product Registration"));
    }

    @Test
    // Check if the product label displays correctly.
    public void productLabelExist() {
        verifyThat("#productLabel", Node::isVisible);
        verifyThat("#productLabel", hasText("Product Name"));
    }

    @Test
    // Check if the genre label displays correctly.
    public void genreLabelExist() {
        verifyThat("#genreLabel", Node::isVisible);
        verifyThat("#genreLabel", hasText("Genre"));
    }

    @Test
    // Check if the price label displays correctly.
    public void priceLabelExist() {
        verifyThat("#priceLabel", Node::isVisible);
        verifyThat("#priceLabel", hasText("Price"));
    }

    @Test
    // Check if the description label displays correctly.
    public void descriptionLabelExist() {
        verifyThat("#descriptionLabel", Node::isVisible);
        verifyThat("#descriptionLabel", hasText("Description"));
    }

    @Test
    // Check if the empty warning label is empty.
    public void EmptyError() {
        verifyThat("#confirmError", hasText(""));
    }

    @Test
    // Check if the productName textfield displays correctly.
    public void productNameExist() {
        verifyThat("#productName", Node::isVisible);
        verifyThat("#productName", hasText(""));
    }

    @Test
    // Check if the productName has the correct information.
    public void productNameContain() {
        clickOn("#productName").write("visual studios");
        verifyThat("#productName", hasText("visual studios"));
    }

    @Test
    // Check if the price textfield displays correctly.
    public void priceExist() {
        verifyThat("#price", Node::isVisible);
        verifyThat("#price", hasText(""));
    }

    @Test
    // Check if the price has the correct information.
    public void priceContain() {
        clickOn("#price").write("5");
        verifyThat("#price", hasText("5"));
    }
    @Test
    // Check if the description textfield displays correctly.
    public void descriptionExist() {
        verifyThat("#description", Node::isVisible);
        verifyThat("#description", hasText(""));
    }

    @Test
    // Check if the description has the correct information.
    public void descriptionContain() {
        clickOn("#description").write("this product is to help programmers or anyone build programs and applications");
        verifyThat("#description", hasText("this product is to help programmers or anyone build programs and applications"));
    }

    @Test
    // Check if the create button display correctly.
    public void createButtonExist() {
        verifyThat("#confirmButton", Node::isVisible);
        verifyThat("#confirmButton", hasText("Create"));
    }
    @Test
    // Check if the HomePage button display correctly.
    public void homeButtonExist() {
        verifyThat("#returnHome", Node::isVisible);
        verifyThat("#returnHone", hasText("HomePage"));
    }
}