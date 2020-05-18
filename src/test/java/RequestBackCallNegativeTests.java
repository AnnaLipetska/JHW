package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RequestBackCallNegativeTests {
    WebDriver driver;
    WebDriverWait wait;
    By name = By.cssSelector("[formcontrolname=’name’]");
    By username = By.cssSelector("[formcontrolname='username']");
    By password = By.cssSelector("[formcontrolname=’password’]");
    By personal = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/"); // Зайти на главную страницу https://rozetka.com.ua/
        wait.until(ExpectedConditions.elementToBeClickable(personal)).click(); // Нажать «войдите в личный кабинет»
        wait.until(ExpectedConditions.elementToBeClickable(register)).click(); // Нажать «Зарегестрироваться"
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(name))).click(); // Кликнуть по полю Ваше имя
        //wait.until(ExpectedConditions.elementToBeClickable(username)).click(); // Кликнуть по полю Эл. почта
        //wait.until(ExpectedConditions.elementToBeClickable(password)).click(); // Кликнуть по полю Придумайте пароль
    }


    @Test
    public void negAllEmpty() {

    }

    @Test
    public void negNameUsernameEmpty() {

    }

    @AfterMethod
    public void afterMethod() {
        // driver.quit();
    }

}
