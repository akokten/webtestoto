import common.*;
import object.BasketPageElements;
import object.FirstProductPageElements;
import object.MainPageElements;
import object.ProductPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.lang.reflect.Field;
import java.security.Key;
import static org.testng.Assert.assertEquals;


@Listeners(TestListener.class)
public class Login {
    public WebDriver driver;
    public WaitFunctions waitFunctions;
    public CommonFunctions commonFunctions;

    public Login() {
    }

    @Test
    @Parameters("browser")
    public void aGoHomePage(String browser) throws Exception {
        driver = DriverSettings.invokeBrowser(browser);
        waitFunctions = new WaitFunctions(driver);
        commonFunctions = new CommonFunctions(driver);
        ReadRequirementData readFileData = new ReadRequirementData();
        String url = readFileData.readData("URL");
        driver.get(url);
        waitFunctions.threadSleep(3);
    }

    @Test
    @Parameters("browser")
    public void bAddProductAndAssert(String browser) throws Exception {
        MainPageElements mainPageElements = new MainPageElements(driver);
        mainPageElements.SearchBtn.click();
        waitFunctions.threadSleep(3);
        mainPageElements.SearchBtn.sendKeys("Şort");
        waitFunctions.threadSleep(3);
        mainPageElements.SearchBtn.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        waitFunctions.threadSleep(3);
        mainPageElements.SearchBtn.sendKeys("Gömlek");
        mainPageElements.SearchBtn.sendKeys(Keys.ENTER);
        waitFunctions.threadSleep(5);

        ProductPageElements productPageElements = new ProductPageElements(driver);
        productPageElements.firstProduct.click();
        waitFunctions.threadSleep(3);
        String ilkfiyat = driver.findElement(By.cssSelector("#priceNew")).getText();
        //System.out.println(driver.findElement(By.cssSelector("#priceNew")).getText());
        waitFunctions.threadSleep(5);


        FirstProductPageElements firstProductPageElements = new FirstProductPageElements(driver);
        firstProductPageElements.chooseSize.click();
        firstProductPageElements.addBasket.click();
        waitFunctions.threadSleep(5);
        firstProductPageElements.goBasket.click();
        waitFunctions.threadSleep(5);
        String sonfiyat =driver.findElement(By.cssSelector("li.m-orderSummary__item.-grandTotal > span.m-orderSummary__value")).getText();
        //System.out.println(driver.findElement(By.cssSelector("li.m-orderSummary__item.-grandTotal > span.m-orderSummary__value")).getText());
        waitFunctions.threadSleep(2);
        Assert.assertEquals(ilkfiyat,sonfiyat);
    }

    @Test
    @Parameters("browser")
    public void cIncreaseAndDeleteProduct(String browser) throws Exception {
            BasketPageElements basketPageElements = new BasketPageElements(driver);
            basketPageElements.addProduct.click();
            waitFunctions.threadSleep(3);
            basketPageElements.addProduct.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            waitFunctions.threadSleep(3);
            basketPageElements.deleteProduct.click();
            waitFunctions.threadSleep(5);
    }

        @AfterClass
        public void finishTest () {
            driver.quit();
        }
    }