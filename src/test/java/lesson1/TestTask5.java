package test.java.lesson1;

import main.java.lesson1.Task5_ForTesting;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask5 {
    Task5_ForTesting task5;

    @BeforeMethod
    public void initialize() {
        this.task5 = new Task5_ForTesting();
    }

    @Test
    public void testTask5() {
        String expectedReversedString = "!!!dlrow olleH";
        String actualReversedString = task5.reverse("Hello world!!!");
        assertEquals(
                expectedReversedString,
                actualReversedString,
                "Expected " + expectedReversedString + " but got " + actualReversedString + "."
        );
    }
}
