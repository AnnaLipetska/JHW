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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RequestBackCallNegativeTests {
    WebDriver driver;
    WebDriverWait wait;
    By personal = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");
    By name = By.xpath("//input[@formcontrolname = 'name'] ");
    By username = By.xpath("//input[@formcontrolname='username']");
    By password = By.xpath("//input[@formcontrolname='password']");
    By greenButton = By.cssSelector("[class = 'button button_size_large button_color_green auth-modal__submit']");
    String expectedColor = "rgb(248, 65, 71)";
    String actualNameColor;
    String actualUsernameColor;
    String actualPasswordColor;


    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/"); // Зайти на главную страницу https://rozetka.com.ua/
        waitClick(personal); // Нажать «войдите в личный кабинет»
        wait.until(ExpectedConditions.visibilityOfElementLocated(register)); //
        waitClick(register); // Нажать «Зарегестрироваться"

        // Кликнуть по полям Ваше имя, Эл. почта, Приудмайте пароль

    }

    public void waitClick(By elementToClick) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
    }

    public String getActualColor(By field) {
        return driver.findElement(field).getCssValue("border-color");
    }

    public void waitRed(By fieldToHaveRedBorder) {
        wait.until(ExpectedConditions
                .attributeToBe(driver.findElement(fieldToHaveRedBorder), "border-color", expectedColor));
    }

    @Test
    public void negAllEmpty() {
        // Кликнуть по полям Ваше имя, Эл. почта, Приудмайте пароль
        waitClick(name);
        waitClick(username);
        waitClick(password);
        // Оставить пустыми «Ваше имя», «Эл. Почта или номер телефона», «Придумайте Пароль»
        // Нажать «Войти»
        waitClick(greenButton);

        // Проверить что незаполненные поля подкрашены красным цветом
        waitRed(name);
        actualNameColor = getActualColor(name);
        waitRed(username);
        actualUsernameColor = getActualColor(username);
        waitRed(password);
        actualPasswordColor = getActualColor(password);


        assertEquals(
                actualNameColor,
                expectedColor,
                "Expected color of the border of the field Ваше имя to be " + expectedColor +
                        " but got " + actualNameColor
        );

        assertEquals(
                expectedColor,
                actualUsernameColor,
                "Expected color of the border of the field Эл. почта to be " + expectedColor +
                        " but got " + actualUsernameColor
        );

        assertEquals(
                expectedColor,
                actualPasswordColor,
                "Expected color of the border of the field Придумайте пароль to be " + expectedColor +
                        " but got " + actualPasswordColor
        );
    }

    @Test
    public void negNameUsernameEmpty() {
        // Кликнуть по полям Ваше имя, Эл. почта, Приудмайте пароль
        waitClick(name);
        waitClick(username);
        waitClick(password);
        //Оставить пустыми 2 поля из 3 «Ваше имя», «Эл. Почта или номер телефона», «Придумайте Пароль»
        //Одно поле заполнить - Буду заполнять поле пароль.
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys("Password1");
        passwordField.sendKeys(Keys.ENTER);
        // Нажать «Войти»
        waitClick(greenButton);

        // Проверить что незаполненные поля подкрашены красным цветом, а заполненное поле не подкрашено красным
        waitRed(name);
        actualNameColor = getActualColor(name);
        waitRed(username);
        actualUsernameColor = getActualColor(username);
        actualPasswordColor = getActualColor(password);

        assertEquals(
                actualNameColor,
                expectedColor,
                "Expected color of the border of the field Ваше имя to be " + expectedColor +
                        " but got " + actualNameColor
        );

        assertEquals(
                expectedColor,
                actualUsernameColor,
                "Expected color of the border of the field Эл. почта to be " + expectedColor +
                        " but got " + actualUsernameColor
        );

        assertNotEquals(
                expectedColor,
                actualPasswordColor,
                "Expected color of the border of the field Придумайте пароль not to be " + expectedColor +
                        " but it is."
        );
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
