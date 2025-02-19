package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    public int getNumberOfDeleteOptions(){
        List<WebElement> deleteOptions = driver.findElements(By.xpath("//a[@class='action action-delete']"));
        return deleteOptions.size();
    }

    public void deleteProduct(int index){
        List<WebElement> deleteOptions = driver.findElements(By.xpath("//a[@class='action action-delete']"));
        deleteOptions.get(index-1).click();
    }

    public double getProductSubtotals(){
        List<WebElement> subtotals = driver.findElements(By.xpath("//td[@class='col subtotal']//span[@class='price']"));

        double total = 0.0;
        for (WebElement subtotal : subtotals) {
            String priceText = subtotal.getText().replace("$", ""); // Remove $ and format
            double price = Double.parseDouble(priceText);
            total += price;
        }
        return total;
    }

    public double getOrderTotal(){
        WebElement total = driver.findElement(By.xpath("//td[@class='amount' and @data-th='Order Total']//span[@class='price']"));
        String totalPrice = total.getText().replace("$", "");
        return Double.parseDouble(totalPrice);
    }

    public boolean emptyCartMessageDisplayed(){
        WebElement message = driver.findElement(By.xpath("//p[text()='You have no items in your shopping cart.']"));
        return message.isDisplayed();
    }
}
