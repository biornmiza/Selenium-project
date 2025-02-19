package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to page
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void quit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
