package test.java.Artefacts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NotebooksPage extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final String allProductsXpath = "//div[@class = 'goods-tile__inner']";
    private final By allProducts = By.xpath(allProductsXpath);
    String searchItemsXpath;
    private String producerStr;


    public NotebooksPage(WebDriver driver) {
        logger.trace("initializing");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public NotebooksPage open() {
        logger.info("opening");
        logger.error("checking creating and functioning of the error.log");
        logger.warn("checking creating and functioning of the warn.log");
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public NotebooksPage chooseProducer(String producerStr) {
        logger.info("starting choosing a producer");
        this.producerStr = producerStr;
        logger.info("waiting for producer " + producerStr + " to be clickable");
        By producer = By.cssSelector("[for = '" + producerStr + "']");
        wait.until(ExpectedConditions.elementToBeClickable(producer));
        logger.info("clicking the producer " + producerStr);
        driver.findElement(producer).click();
        return this;
    }

    public List<WebElement> getElements() {
        logger.info("getting all the elements present");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        return driver.findElements(allProducts);
    }

    public List<WebElement> getElements(String searchStr) {
        logger.info("getting all the elements that contains " + searchStr);
        searchItemsXpath = String.format("%s/a/span[contains(text(), '%s')]", allProductsXpath, searchStr);
        By searchItems = By.xpath(searchItemsXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchItems));
        return driver.findElements(searchItems);
    }
}
