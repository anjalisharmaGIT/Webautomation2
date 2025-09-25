package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {
    private WebDriver driver;
    private WaitUtils wait;

    private By closePopup = By.xpath("//button[contains(text(),'✕')]");
    private By searchBox = By.name("q");
    private By searchButton = By.cssSelector("button[type='submit']");

    public HomePage(WebDriver driver, int timeout) {
        this.driver = driver;
        wait = new WaitUtils(driver, timeout);
    }

    public void closeLoginPopup() {
        try {
            wait.waitForVisible(closePopup).click();
        } catch (Exception e) {
            // sometimes popup doesn't appear
        }
    }

    public void searchProduct(String product) {
        wait.waitForVisible(searchBox).sendKeys(product);
        wait.waitForClickable(searchButton);
        driver.findElement(searchButton).click();
    }
}
