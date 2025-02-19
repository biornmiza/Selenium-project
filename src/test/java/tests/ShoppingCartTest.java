package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

import java.time.Duration;

public class ShoppingCartTest extends PageFiltersTest { // Precondition: PageFiltersTest
    protected ShoppingCartPage shoppingCartPage;

    @Test
    public void testShoppingCart() {
        // Add all displayed items to the Shopping Cart (Select one of the size options + hover over item and click Add to Cart button).
        // Add products one by one
        productPage.addToCart(2, "XS", 1);

        // Check successful message (text + icon)
        Assert.assertTrue(productPage.addedToCartDisplayed());

        // Open the Shopping Cart (by clicking shopping cart link included on the successful message).
        productPage.click("//a[text()='shopping cart']");

        // Verify that we have navigated to Shopping Cart Page.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
        Assert.assertEquals(driver.getTitle(), "Shopping Cart");
        shoppingCartPage = new ShoppingCartPage(driver);

        // Verify that the prices sum for all items is equal to Order Total price in the Summary section.
        Assert.assertEquals(shoppingCartPage.getProductSubtotals(), shoppingCartPage.getOrderTotal());
    }

}
