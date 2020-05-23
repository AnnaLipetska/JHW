package test.java.pageObject;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pageObject.pages.HomePage;
import test.java.pageObject.pages.SearchPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //.......
        // Additional check
        List<String> expecteList = Arrays.asList(
                "Смартфоны, ТВ и электроника",
                "Бытовая техника, интерьер",
                "Компьютеры и ноутбуки",
                "Уцененные товары",
                "Комплектующие и аксессуары для электронных сигарет",
                "Спорт и увлечения",
                "Аккумуляторы и зарядные устройства для инструмента и садовой техники",
                "Клейкая лента, скотч, стрейч пленка",
                "Аксессуары для видеонаблюдения"
        );

        String linkTest = null;
        List<String> acttualList = new ArrayList<>();

        List<WebElement> actualElList = searchPage.getLinksLeft();
        for (WebElement el : actualElList) {
            linkTest = el.getText();
            acttualList.add(linkTest);
        }

        assertEquals(
                acttualList,
                expecteList,
                "The actual list of the links is not equal to the expected list");
    }
}