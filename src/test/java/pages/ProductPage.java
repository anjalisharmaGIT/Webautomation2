package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.ArrayList;

public class ProductPage {
    private WebDriver driver;
    private WaitUtils wait;

    private By addToCartButton = By.xpath("//button[text()='Add to cart']");

    public ProductPage(WebDriver driver, int timeout) {
        this.driver = driver;
        wait = new WaitUtils(driver, timeout);
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public WebElement addToCart() {
        wait.waitForClickable(addToCartButton);
        return driver.findElement(addToCartButton);
    }
}
