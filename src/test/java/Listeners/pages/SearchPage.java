package test.java.Listeners.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By linkLeft = By.xpath("//a[@class='m-cat-l-i-title-link novisited']");
    String allProductsXpath = "//div[@class = 'goods-tile__inner']";
    private final By allProducts = By.xpath(allProductsXpath);
    String searchItemsXpath;

    public SearchPage(WebDriver driver) {
        logger.trace("initializing");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getElements() {
        logger.info("getting all the elements present");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        return driver.findElements(allProducts);
    }

    public List<WebElement> getElements(String searchStr) {
        logger.info("getting all the elements that contains the text that we search");
        searchItemsXpath = String.format("%s/a/span[contains(text(), '%s')]", allProductsXpath, searchStr);
        By searchItems = By.xpath(searchItemsXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchItems));
        return driver.findElements(searchItems);
    }

    public List<WebElement> getLinksLeft() {
        logger.info("getting the list of the links on the left side of the page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkLeft));
        return driver.findElements(linkLeft);
    }
}
