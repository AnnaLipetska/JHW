package test.java.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    private String searchStr;

    @FindBy(css = "[name='search']")
    private WebElement search;

    @FindBy(css = popupStrSelect)
    private List<WebElement> popup;

    @FindBy(css = popupStrSelect + " [class='popup-close']")
    private WebElement popupClose;


    public HomePage(WebDriver driver) {
        logger.trace("initializing");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }


    public HomePage open() {
        logger.info("opening");
        logger.error("checking creating and functioning of the error.log");
        logger.warn("checking creating and functioning of the warn.log");
        driver.get("https://rozetka.com.ua/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public HomePage search(String searchStr) {
        logger.info("starting the search process");
        this.searchStr = searchStr;
        logger.info("waiting for the search field to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(search));
        logger.info("checking popups");
        if (popup.size() > 0) {
            popupClose.click();
        }
        logger.info("typing into the search field");
        search.sendKeys(this.searchStr);
        logger.info("pressing Enter");
        search.sendKeys(Keys.ENTER);
        return this;
    }
}
