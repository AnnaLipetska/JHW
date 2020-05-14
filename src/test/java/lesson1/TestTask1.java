package test.java.lesson1;

import main.java.lesson1.Task1_ForTesting;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask1 {
    Task1_ForTesting task1;


    @BeforeMethod
    public void initialize() {
        this.task1 = new Task1_ForTesting();
    }

    @Test(dataProvider = "minNumbers")
    public void minShouldReturnMinValue(int a, int b, int c, int expectedMin) {
        int actualMin = this.task1.min(a, b, c);
        assertEquals(
                actualMin,
                expectedMin,
                "Expected minimal number to be " + expectedMin + " but got " + actualMin + "."
        );
    }

    @DataProvider(name = "minNumbers")
    public Object[][] getData() {
        return new Object[][]{
                {2, 3, 5, 2},
                {3, 2, 5, 2},
                {5, 4, 2, 2},
                {0, -2, 1, -2},
                {-256, -255, 255, -256}
        };
    }
}

