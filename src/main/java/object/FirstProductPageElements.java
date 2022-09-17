package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstProductPageElements {
    public WebElement addBasket;
    public WebElement chooseSize;
    public WebElement goBasket;

    public FirstProductPageElements(WebDriver driver) {
        addBasket = driver.findElement(By.cssSelector("#addBasket"));
        chooseSize= driver.findElement(By.cssSelector("#sizes > div > span:nth-child(1)"));
        goBasket= driver.findElement(By.cssSelector("a.o-header__userInfo--item.bwi-cart-o.-cart > span"));
    }
}
