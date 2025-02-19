package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import java.time.Duration;

public class EmptyShoppingCartTest extends BaseTest{ // Precondition: ShoppingCartTest
    private ShoppingCartPage shoppingCartPage;

    @Override
    @BeforeClass
    public void setup(){
        super.setup();

        // Sign In
        homePage.clickSignInLink();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lddljfnf@gmail.com", "reCd!AJDBKw_xt3n");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        homePage = new HomePage(driver);
    }

    @Test
    public void testEmptyShoppingCart(){
        // Go to Shopping Cart Page
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        homePage.goToCart();
        shoppingCartPage = new ShoppingCartPage(driver);

        // Delete the first item on shopping cart.
        int previousCount = shoppingCartPage.getNumberOfDeleteOptions();
        shoppingCartPage.deleteProduct(1);

        // Verify that the number of elements in Shopping Cart table is decreased by 1.
        int count = shoppingCartPage.getNumberOfDeleteOptions();
        Assert.assertEquals(count, previousCount - 1);

        // Repeat steps 1&2 until the last item is deleted.
        while(count != 0){
            shoppingCartPage.deleteProduct(1);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
            count = shoppingCartPage.getNumberOfDeleteOptions();
        }
        // Verify that Shopping Cart is empty (Check message ‘You have no items in your shopping cart.’ is displayed).
        Assert.assertTrue(shoppingCartPage.emptyCartMessageDisplayed());

    }
    // Close the browser -  already defined in BaseTest class
}
