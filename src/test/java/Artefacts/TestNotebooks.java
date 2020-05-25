package test.java.Artefacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Artefacts.pages.NotebooksPage;

import static org.testng.Assert.assertEquals;

public class TestNotebooks extends TestBaseSetup {
    NotebooksPage notebooksPage;

    @BeforeMethod
    public void initialize() {
        notebooksPage = new NotebooksPage(driver);
    }

    @Test(dataProvider = "producers")
    public void testFilter(String producer) {
        notebooksPage.open();
        notebooksPage.chooseProducer(producer);
        int actualNumberElements = notebooksPage.getElements().size();
        int expectedNumberElements = notebooksPage.getElements(producer).size();
        assertEquals(
                actualNumberElements,
                expectedNumberElements,
                "Number of the items to be " + expectedNumberElements + " but got " + actualNumberElements);
    }

    @DataProvider(name = "producers")
    public Object[][] getData() {
        return new Object[][]{
                {"Acer"},
                {"Apple"},
                {"Asus"},
                {"Dell"},
                {"Dream Machines"}
        };
    }
}