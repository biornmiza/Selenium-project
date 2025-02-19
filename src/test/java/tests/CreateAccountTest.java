package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.CustomerAccountPage;
import java.time.Duration;
import java.util.Objects;


public class CreateAccountTest extends BaseTest{
	private CreateAccountPage createAccountPage;
	private CustomerAccountPage customerAccountPage;

	@Test
	public void testNewAccount() {
		// Click Create an Account link
		homePage.clickNewAccountLink();
		createAccountPage = new CreateAccountPage(driver);

		// Check title of the open page
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

		// Fill in form fields + click Create An Account Button
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
		createAccountPage.fillNewAccountForm("biorno", "eucnr", "lddljfnf@gmail.com", "reCd!AJDBKw_xt3n");

		// Check successful message is displayed on the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("Thank you for registering with Main Website Store."));

		// Click on User profile and Sign Out
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
		customerAccountPage = new CustomerAccountPage(driver);
		customerAccountPage.signout();
	}
}
