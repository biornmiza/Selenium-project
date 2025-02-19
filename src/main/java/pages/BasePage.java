package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void hover(String xpath){
        WebElement option = driver.findElement(By.xpath(xpath));
        // Create action object to hover over located element
        Actions action = new Actions(driver);
        action.moveToElement(option).perform();
    }

    public void hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void click(String xpath){
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }


}
