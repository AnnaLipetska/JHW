package test.java.Artefacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.Screenshot;

public class TestBaseSetup {
    WebDriver driver;
    Screenshot screenshot = new Screenshot(driver);

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        screenshot.getScreenshot(result);
        driver.quit();
    }
}