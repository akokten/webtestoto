package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFunctions {

    public WebDriver driver;

    public WaitFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void threadSleep(int timeSecond) throws InterruptedException {

        int time = timeSecond*1000;
        Thread.sleep(time);
    }

    public void visibilityOfElementLocated(int timeOutInSecond, int frequency, By locator){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSecond))
                .pollingEvery(Duration.ofMillis(frequency))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void attribute(int timeOutInSecond, int frequency, By locator, String attribute, String value){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSecond))
                .pollingEvery(Duration.ofMillis(frequency))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.attributeToBe(locator,attribute,value));

    }

    public void explicitWait(int timeOutInSecond, By locator) {

        WebDriverWait wait = new WebDriverWait(driver,timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

