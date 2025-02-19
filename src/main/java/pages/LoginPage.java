package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private final WebElement emailField;
    private final WebElement passwordField;
    private final WebElement submitButton;

    public LoginPage(WebDriver driver){
        super(driver);
        emailField = driver.findElement(By.id("email"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.id("send2"));
    }

    public void login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
