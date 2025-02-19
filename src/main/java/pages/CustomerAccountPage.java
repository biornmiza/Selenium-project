package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerAccountPage extends BasePage{
    private WebElement dropdownButton;
    private WebElement signoutLink;

    public CustomerAccountPage(WebDriver driver){
        super(driver);
        dropdownButton = driver.findElement(By.xpath("//button[@class='action switch' and span[text()='Change']]"));
        signoutLink = driver.findElement(By.xpath("//a[contains(@href, '/customer/account/logout')]"));
    }

    public void signout(){
        dropdownButton.click();
        signoutLink.click();
    }
}
