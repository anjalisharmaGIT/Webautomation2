package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class FlipkartE2ETest extends BaseTest {

    @Test
    public void testFlipkartE2E() {
        int timeout = Integer.parseInt(utils.ConfigReader.get("timeout"));

        HomePage home = new HomePage(driver, timeout);
        SearchResultsPage results = new SearchResultsPage(driver, timeout);
        ProductPage product = new ProductPage(driver, timeout);
        CartPage cart = new CartPage(driver, timeout);

        //home.closeLoginPopup();
        home.searchProduct("samsung s24 ultra");
        results.selectFirstProduct("Samsung Galaxy S24 5G Snapdragon (Marble Gray, 128 GB)").click();
        product.switchToNewTab();
        product.addToCart().click();
        Assert.assertTrue(cart.isProductInCart("Samsung Galaxy S24 5G Snapdragon (Marble Gray, 128 GB)").isDisplayed());
    }
}

