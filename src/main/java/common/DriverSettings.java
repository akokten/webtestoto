package common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSettings {

    public DriverSettings() {
    }
    private static ChromeDriver chromeDriver = null;
    private static FirefoxDriver firefoxDriver = null;

    public static WebDriver invokeBrowser(String browser) {

        System.out.println(browser);

        String workingDir = System.getProperty("user.dir");

        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("disable-dev-shm-usage");
            //chromeOptions.addArguments("--headless");

           // System.setProperty("webdriver.chrome.driver", workingDir + "/src/main/resources/driver/chromedriver");
            WebDriverManager.chromedriver().setup();
            chromeDriver = new ChromeDriver(chromeOptions);
            chromeDriver.manage().deleteAllCookies();
            chromeDriver.manage().window().maximize();

            return chromeDriver;


//        } else if (browser.equalsIgnoreCase("Firefox")) {
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.addArguments("--disable-infobars");
//            firefoxOptions.addArguments("--no-sandbox");
//            firefoxOptions.addArguments("disable-dev-shm-usage");
//           // firefoxOptions.addArguments("--headless");
//
//           // System.setProperty("webdriver.gecko.driver", workingDir + "/src/main/resources/driver/geckodriver");
//            WebDriverManager.firefoxdriver().setup();
//            firefoxDriver = new FirefoxDriver(firefoxOptions);
//            firefoxDriver.manage().deleteAllCookies();
//            firefoxDriver.manage().window().maximize();
//
//            return firefoxDriver;

        }
        return null;

    }
    }

