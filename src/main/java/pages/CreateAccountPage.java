package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage extends BasePage {

	private final WebElement firstNameField;
	private final WebElement lastNameField;
	private final WebElement emailField;
	private final WebElement passwordField;
	private final WebElement passwordConfirmationField;
	private final WebElement createAccountButton;

	public CreateAccountPage (WebDriver driver) {
		super(driver);
		firstNameField = driver.findElement(By.id("firstname"));
		lastNameField = driver.findElement(By.id("lastname"));
		emailField = driver.findElement(By.id("email_address"));
		passwordField = driver.findElement(By.id("password"));
		passwordConfirmationField = driver.findElement(By.id("password-confirmation"));
		createAccountButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'action submit primary')]"));
	}

	public void fillNewAccountForm(String firstName, String lastName, String email, String password){
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		passwordConfirmationField.sendKeys(password);
		createAccountButton.click();
	}
}
