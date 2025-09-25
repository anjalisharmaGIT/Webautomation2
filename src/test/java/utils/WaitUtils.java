package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
