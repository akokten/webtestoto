package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPageElements {
    public WebElement addProduct;
    public WebElement deleteProduct;

    public BasketPageElements(WebDriver driver) {
        addProduct = driver.findElement(By.cssSelector("#quantitySelect0-key-0"));
        deleteProduct=driver.findElement(By.cssSelector(" #removeCartItemBtn0-key-0"));
    }
}