package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.utils.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    WebDriver driver;
    Screenshot screenshot;


    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(@Optional("myComp") String browser) {
        getDriver(browser);
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
    }

    public WebDriver getDriver(String browser) {
        driver = null;
        try {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                ChromeOptions optionsCh = new ChromeOptions();
                optionsCh.addArguments("--disable-notifications");
                driver = new RemoteWebDriver(new URL("http://ec2-13-59-33-74.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsCh);
            } else if (browser.equals("firefox")) {
                FirefoxOptions optionsFF = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://ec2-13-59-33-74.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsFF);
            } else if (browser.equals("myComp")) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                ChromeOptions optionsCh = new ChromeOptions();
                optionsCh.addArguments("--disable-notifications");
                driver = new ChromeDriver();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        screenshot.getScreenshot(result);
        driver.quit();
    }
}