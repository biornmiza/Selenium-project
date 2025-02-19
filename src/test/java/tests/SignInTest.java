package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class SignInTest extends BaseTest{
    private LoginPage loginPage;

    @Test
    public void testSignIn(){
        // Click on Sign In link.
        homePage.clickSignInLink();

        // Login with the credentials created from Test 1.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        loginPage = new LoginPage(driver);
        loginPage.login("lddljfnf@gmail.com", "reCd!AJDBKw_xt3n");

        // Check your username is displayed on right corner of the page.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.usernameDisplayed());

        // Click on User profile and Sign Out.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
        homePage.signout();
    }

}
