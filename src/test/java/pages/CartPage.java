package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CartPage {
    private WebDriver driver;
    private WaitUtils wait;

    private By cartProductTitle = By.cssSelector("a._2Kn22P");

    public CartPage(WebDriver driver, int timeout) {
        this.driver = driver;
        wait = new WaitUtils(driver, timeout);
    }

    public WebElement isProductInCart(String productName) {
        By product_in_cart = By.xpath("//a[text()='"+productName+"']");
        return wait.waitForVisible(product_in_cart);
    }
}
