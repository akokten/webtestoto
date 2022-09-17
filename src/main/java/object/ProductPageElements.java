package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageElements {
    public WebElement firstProduct;

    public ProductPageElements(WebDriver driver) {
        firstProduct = driver.findElement(By.cssSelector("#productList > div:nth-child(2)"));
    }
}
