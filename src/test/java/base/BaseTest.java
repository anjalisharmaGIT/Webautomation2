package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigReader;

import java.time.Duration;

@Listeners(utils.ExtentListener.class)
public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setup() {
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("baseUrl");
        System.out.println("Browser: " +browser);
        System.out.println("Browser: " +browser);
        System.out.println("URL:" +url);



        // According to the browser name passed from configfile, we are opening the browser
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
