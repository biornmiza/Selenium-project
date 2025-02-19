package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void clearFilters(){
        super.click("//span[text()='Clear All']");
    }

    public void filter(String filter){
        super.click("//div[@class='filter-options-title' and text()='" + filter + "']");
    }

    public void addToWishList(int index){
        // Hover over product
        List<WebElement> products = driver.findElements(By.xpath("//li[@class='item product product-item']//div[@class='product-item-info']"));
        super.hover(products.get(index - 1));
        // Click add to wishlist
        List<WebElement> options = driver.findElements(By.xpath("//a[@class='action towishlist']"));
        options.get(index - 1).click();
    }

    public void addToCart(int index, String size, int colorIndex){
        // Select size
        List<WebElement> sizes = driver.findElements(By.xpath("//div[contains(@id, 'option-label-size') and @option-label='" + size + "']"));
        sizes.get(index-1).click();

        // Select color
        List<WebElement> colors = driver.findElements(By.xpath("//div[contains(@id, 'option-label-color') and @index='" + colorIndex + "']"));
        colors.get(index-1).click();

        // Hover over product and click add to cart
        List<WebElement> products = driver.findElements(By.xpath("//li[@class='item product product-item']//div[@class='product-item-info']"));
        super.hover(products.get(index - 1));
        List<WebElement> addButtons = driver.findElements(By.xpath("//li[@class='item product product-item']//button[@type='submit' and @title='Add to Cart' and @class='action tocart primary']"));
        addButtons.get(index-1).click();
    }

    public boolean addedToCartDisplayed(){
        WebElement addedMessage = driver.findElement(By.xpath("//div[contains(text(), 'You added')]"));
        return addedMessage.isDisplayed();
    }

    public int getNumberOfSelectedProducts(){
        List<WebElement> products = driver.findElements(By.xpath("//li[@class='item product product-item']//div[@class='product-item-info']"));
        return products.size();
    }

    public int getNumberOfSelectedColors(String color){
        List<WebElement> selectedColors = driver.findElements(By.xpath("//div[@class='swatch-option color selected' and @option-label='" + color +"']"));
        return selectedColors.size();
    }

    public int getNumberOfMatchingPrices(double minPrice, double maxPrice){
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@id, 'product-price')]"));
        int count = 0;
        for (WebElement priceElement: priceElements){
            String priceText = priceElement.getDomAttribute("data-price-amount");
            double price = Double.parseDouble(priceText);
            if ((price >= minPrice) && (price <= maxPrice))
                count++;
        }
        return count;
    }

    public int getNumberOfWishlistItems(){
        super.click("//button[@class='action switch']");

        int counter;
        WebElement counterText = driver.findElement(By.xpath("//span[@class='counter qty' and @data-bind='text: wishlist().counter']"));
        counter = Integer.parseInt(counterText.getText().substring(0, 1));
        return counter;
    }
}
