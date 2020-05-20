package test.java.pageObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pageObject.pages.HomePage;
import test.java.pageObject.pages.SearchPage;

import static org.testng.Assert.assertEquals;

public class TestSearch extends TestBaseSetup {
    HomePage homePage;
    SearchPage searchPage;
    String searchStr;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testItemsAfterSearch() {
        // Открыть главную страницу
        // Ввести в поиск «iPhone»
        searchStr = "iPhone";
        homePage.open().search(searchStr);
        // Проверить что в списке товаров отображаются только iPhone
        int actualNumberElements = searchPage.getElements().size();
        int expectedNumberElements = searchPage.getElements(searchStr).size();
        assertEquals(
                actualNumberElements,
                expectedNumberElements,
                "Number of the items to be " + expectedNumberElements + " but got " + actualNumberElements);
    }


    @Test
    public void testLinksLeftAfterSearch() {
        // Открыть главную страницу
        // Ввести в поиск «Samsung»
        searchStr = "Samsung";
        homePage.open().search(searchStr);
        // Проверить что левой панели списка типов товаров отображаются все типы товаров Samsung

        int actualNumberLinks = searchPage.getLinksLeft().size();
        int expectedNumberLinks = 9;
        assertEquals(
                actualNumberLinks,
                expectedNumberLinks,
                "Number of the links to be " + expectedNumberLinks + " but got " + actualNumberLinks);
    }
}