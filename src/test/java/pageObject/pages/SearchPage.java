package test.java.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By linkLeft = By.xpath("//a[@class='m-cat-l-i-title-link novisited']");
    String allProductsXpath = "//div[@class = 'goods-tile__inner']";
    private final By allProducts = By.xpath(allProductsXpath);
    String searchItemsXpath;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public List<WebElement> getElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        return driver.findElements(allProducts);
    }

    public List<WebElement> getElements(String searchStr) {
        searchItemsXpath = String.format("%s/a/span[contains(text(), '%s')]", allProductsXpath, searchStr);
        By searchItems = By.xpath(searchItemsXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchItems));
        return driver.findElements(searchItems);
    }

    public List<WebElement> getLinksLeft() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkLeft));
        return driver.findElements(linkLeft);
    }
}
