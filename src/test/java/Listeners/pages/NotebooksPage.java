package test.java.Listeners.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

import java.util.List;

public class NotebooksPage extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final String allProductsXpath = "//div[@class = 'goods-tile__inner']";
    private final By allProducts = By.xpath(allProductsXpath);
    private final String allProducersXPath = "//label[@_ngcontent-c53=\"\"]";
    private final By allProducers = By.xpath(allProducersXPath);
    String searchItemsXpath;
    private String producerStr;

    public NotebooksPage(WebDriver driver) {
        logger.trace("initializing");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("Open notebooks page")
    public NotebooksPage open() {
        logger.info("opening");
        logger.error("checking creating and functioning of the error.log");
        logger.warn("checking creating and functioning of the warn.log");
        driver.get(PropertyLoader.loadProperty("urlNotebooks"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    @Step("Choose a random producer")
    public String chooseRandomProducer() {
        wait.until((ExpectedConditions.visibilityOfElementLocated(allProducers)));
        List<WebElement> producers = driver.findElements(allProducers);
        int max = producers.size();
        int rand = (int) (Math.random() * max);
        String producer = producers.get(rand).getAttribute("for");
        producers.get(rand).click();
        return producer;
    }

    @Step("Choose Producer by Producer Name {producerStr}")
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

    @Step("Get list of all present elements")
    public List<WebElement> getElements() {
        logger.info("getting all the elements present");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        return driver.findElements(allProducts);
    }

    @Step("Get list of elements that contain {searchStr}")
    public List<WebElement> getElements(String searchStr) {
        logger.info("getting all the elements that contain " + searchStr);
        searchItemsXpath = allProductsXpath +
                "/a/span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                + searchStr.toLowerCase() + "')]";
        By searchItems = By.xpath(searchItemsXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchItems));
        return driver.findElements(searchItems);
    }
}
