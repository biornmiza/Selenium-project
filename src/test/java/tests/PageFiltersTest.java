package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import java.time.Duration;

public class PageFiltersTest extends BaseTest{
    protected ProductPage productPage;

    @Override
    @BeforeClass
    public void setup(){
        super.setup();

        // Precondition: Signed In
        do {
            homePage.clickSignInLink();

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("lddljfnf@gmail.com", "reCd!AJDBKw_xt3n");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            homePage = new HomePage(driver);
        } while(!homePage.usernameDisplayed());
    }

    @Test
    public void testPageFilters(){
        // On store menu click on Women dropdown.
        homePage.hover("//span[text()='Women']");

        // Hover over Tops dropdown on the open pop up and click on Jacket menu option.
        homePage.hover("//span[text()='Tops']");
        homePage.click("//span[text()='Jackets']");
        productPage = new ProductPage(driver);

        // From Shopping Options panel click on Color dropdown and choose one of the colors
        productPage.filter("Color");
        productPage.click("//div[@tabindex='-1' and @option-label='Yellow']");

        // Check that all the displayed products have the selected color bordered in red.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        Assert.assertEquals(productPage.getNumberOfSelectedProducts(), productPage.getNumberOfSelectedColors("Yellow"));

        // Click on Price dropdown and select the first option ($50.00 - $59.99) and check that only two product are displayed on the page.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        productPage.clearFilters();
        productPage.filter("Price");
        productPage.click("//a[contains(@href, '/jackets-women.html?price=50-60')]");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        Assert.assertEquals(productPage.getNumberOfSelectedProducts(), 4);

        // For each product displayed, check that the price matches the defined criteria.
        Assert.assertEquals(productPage.getNumberOfMatchingPrices(50, 59.99), productPage.getNumberOfSelectedProducts());
    }

}
