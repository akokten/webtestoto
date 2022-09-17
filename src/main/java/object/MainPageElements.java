package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageElements {
    public WebElement SearchBtn;

    public MainPageElements(WebDriver driver) {
        SearchBtn= driver.findElement(By.cssSelector("div.col-4.col-sm-4.col-md-4.col-lg-4.col-xl-6 > div > div > div > input"));
    }
}
