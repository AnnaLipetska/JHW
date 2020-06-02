package test.java.Listeners;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.Listeners.pages.HomePage;
import test.java.Listeners.pages.SearchPage;

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
        List<String> expectedList = new ArrayList<>(Arrays.asList(
                "Смартфоны, ТВ и электроника",
                "Уцененные товары",
                "Компьютеры и ноутбуки",
                "Бытовая техника, интерьер",
                "Комплектующие и аксессуары для электронных сигарет",
                "Клейкая лента, скотч, стрейч пленка",
                "Спорт и увлечения",
                "Аккумуляторы и зарядные устройства для инструмента и садовой техники",
                "Аксессуары для видеонаблюдения"
        ));

        List<String> acttualList = new ArrayList<>();

        List<WebElement> actualElList = searchPage.getLinksLeft();
        for (WebElement el : actualElList) {
            acttualList.add(el.getText());
        }

        assertEquals(
                acttualList,
                expectedList,
                "The actual list of the links is not equal to the expected list");
    }
}