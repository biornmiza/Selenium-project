package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage extends BasePage{

    public WishlistPage(WebDriver driver){
        super(driver);
    }

    public boolean getSuccessMessage(){
        WebElement message = driver.findElement(By.xpath("//div[contains(text(), 'has been added to your Wish List')]"));
        return message.isDisplayed();
    }

    public void continueShopping(){
        super.click("//a[contains(@href, 'tops-women/jackets-women.html') and text()='here']");
    }

}
