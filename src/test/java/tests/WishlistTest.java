package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WishlistPage;

import java.time.Duration;

public class WishlistTest extends PageFiltersTest{ // Precondition: PageFiltersTest
    private WishlistPage wishlistPage;
    @Test
    public void testWishlist(){
        // Remove Price filter.
        int previousCount = productPage.getNumberOfSelectedProducts();
        productPage.clearFilters();

        // Check the items number displayed is increased.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Assert.assertTrue(previousCount < productPage.getNumberOfSelectedProducts());

        // Add the two first item in the Wish List + check successful message
        // Item 1
        productPage.addToWishList(1);
        wishlistPage = new WishlistPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        Assert.assertTrue(wishlistPage.getSuccessMessage());
        wishlistPage.continueShopping();

        // Item 2
        productPage.addToWishList(2);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        Assert.assertTrue(wishlistPage.getSuccessMessage());
        wishlistPage.continueShopping();

        // Click on User Profile, and check the correct number of items is displayed (My Wish List (2 items)).
        Assert.assertEquals(productPage.getNumberOfWishlistItems(), 2);
    }

}
