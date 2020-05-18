package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    By personal = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");
    By name = By.xpath("//input[@formcontrolname = 'name'] ");
    By username = By.xpath("//input[@formcontrolname='username']");
    By password = By.xpath("//input[@formcontrolname='password']");
    By greenButton = By.cssSelector("[class = 'button button_size_large button_color_green auth-modal__submit']");


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
        waitClick(personal); // Нажать «войдите в личный кабинет»
        waitClick(register); // Нажать «Зарегестрироваться"

        // Кликнуть по полям Ваше имя, Эл. почта, Приудмайте пароль
        waitClick(name);
        waitClick(username);
        waitClick(password);
    }

    public void waitClick(By elementToClick) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
    }

    @Test
    public void negAllEmpty() {
        // Оставить пустыми «Ваше имя», «Эл. Почта или номер телефона», «Придумайте Пароль»
        // Нажать «Войти»
        waitClick(greenButton);
    }

    @Test
    public void negNameUsernameEmpty() {
        //Оставить пустыми 2 поля из 3 «Ваше имя», «Эл. Почта или номер телефона», «Придумайте Пароль»
        //Одно поле заполнить - Буду заполнять поле пароль.
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys("Password1");
        passwordField.sendKeys(Keys.ENTER);
        // Нажать «Войти»
        waitClick(greenButton);
    }

    @AfterMethod
    public void afterMethod() {
        // driver.quit();
    }

}
