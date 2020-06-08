package test.java.Listeners;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Listeners.pages.NotebooksPage;

import static org.testng.Assert.assertEquals;

@TmsLink("TMS-123")
@Epic("Filters")
public class TestNotebooks extends TestBaseSetup {
    NotebooksPage notebooksPage;

    @BeforeMethod
    public void initialize() {
        notebooksPage = new NotebooksPage(driver);
    }

    @Link("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/")
    @Feature("Filtering of producers of notebooks")
    @Story("Positive test - choosing a producer of notebooks")
    @Issue("AAA-100")
    @Test //(dataProvider = "producers")
    public void testFilter(/*String producer*/) {
        notebooksPage.open();
        String producer = notebooksPage.chooseRandomProducer();
        //notebooksPage.chooseProducer(producer);
        int actualNumberElements = notebooksPage.getElements().size();
        int expectedNumberElements = notebooksPage.getElements(producer).size();
        assertEquals(
                actualNumberElements,
                expectedNumberElements,
                "Number of the items to be " + expectedNumberElements + " but got " + actualNumberElements);
    }

/*    @DataProvider(name = "producers")
    public Object[][] getData() {
        return new Object[][]{
                {"Acer"},
                {"Apple"},
                {"Asus"},
                {"Dell"},
                {"Dream Machines"}
        };
    }*/
}