package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class SearchResultsPage {
    private WebDriver driver;
    private WaitUtils wait;

    private By firstProduct = By.cssSelector("a._1fQZEK");

    public SearchResultsPage(WebDriver driver, int timeout) {
        this.driver = driver;
        wait = new WaitUtils(driver, timeout);
    }

    public WebElement selectFirstProduct(String productName) {
        By product_to_select = By.xpath("//div[text()='"+productName+"']");
        return wait.waitForVisible(product_to_select);

    }
}
