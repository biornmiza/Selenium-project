package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage extends BasePage{

	private WebElement createAccountLink;
	private WebElement signInLink;

	private WebElement welcomeMessage;

	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	public void clickNewAccountLink() {
		createAccountLink = driver.findElement(By.linkText("Create an Account"));
		createAccountLink.click();
	}

	public void clickSignInLink(){
		signInLink = driver.findElement(By.linkText("Sign In"));
		signInLink.click();
	}

	public boolean usernameDisplayed(){
		welcomeMessage = driver.findElement(By.xpath("//li[@class='greet welcome']//span[contains(@class, 'logged-in')]"));
		return welcomeMessage.isDisplayed();
	}

	public void signout(){
		super.click("//button[@class='action switch' and span[text()='Change']]");
		super.click("//a[contains(@href, '/customer/account/logout')]");
	}

	public void goToCart(){
		super.click("//a[@class='action showcart']");
		WebElement goToCartButton = driver.findElement(By.xpath("//a[@class='action viewcart']"));
		while(!goToCartButton.isDisplayed()){
			super.click("//a[@class='action showcart']");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
		}
		goToCartButton.click();

	}
}
