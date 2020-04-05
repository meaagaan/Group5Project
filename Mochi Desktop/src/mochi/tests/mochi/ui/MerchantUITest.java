package mochi.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mochi.db.DBConnection;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.NodeQueryUtils;

import java.sql.Connection;

import static org.testfx.api.FxAssert.verifyThat;

public class MerchantUITest extends ApplicationTest {

    private Stage currentStage;
    private Connection database;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBConnection connection = new DBConnection();
        this.database = connection.getDatabase();

        MerchantUI merchantUI = new MerchantUI();
        Scene merchantScene = merchantUI.getMerchantScene();

        currentStage = primaryStage;

        primaryStage.setScene(merchantScene);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @Test
    public void MerchantPageLabelExist() {
        verifyThat("#merchantPageLabel", Node::isVisible);
        verifyThat("#merchantPageLabel", NodeQueryUtils.hasText("Merchant Page"));
    }

    @Test
    public void StoreLabelExist() {
        verifyThat("#storeLabel", Node::isVisible);
        verifyThat("#storeLabel", NodeQueryUtils.hasText("Store"));
    }

    @Test
    public void LibraryLabelExist() {
        verifyThat("#libraryLabel", Node::isVisible);
        verifyThat("#libraryLabel", NodeQueryUtils.hasText("Library"));
    }

    @Test
    public void WishListLabelExist() {
        verifyThat("#wishlistLabel", Node::isVisible);
        verifyThat("#wishlistLabel", NodeQueryUtils.hasText("Wishlist"));
    }

    @Test
    public void MerchantLabelExist() {
        verifyThat("#MerchantLabel", Node::isVisible);
        verifyThat("#MerchantLabel", NodeQueryUtils.hasText("Merchant"));
    }

    @Test
    public void UserProfileLabelExist() {
        verifyThat("#userProfileLabel", Node::isVisible);
        verifyThat("#userProfileLabel", NodeQueryUtils.hasText("User Profile"));
    }

    @Test
    public void productNameColumnExist() {
        verifyThat("#productNameTableColumn", Node::isVisible);
    }

    @Test
    public void productPriceColumnExist() {
        verifyThat("#priceTableColumn", Node::isVisible);
    }
}
