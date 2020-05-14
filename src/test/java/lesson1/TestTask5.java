package test.java.lesson1;

import main.java.lesson1.Task5_ForTesting;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestTask5 {
    Task5_ForTesting task5;

    @BeforeMethod
    public void initialize() {
        this.task5 = new Task5_ForTesting();
    }

    @Parameters({"initialString", "expectedReversedString"})
    @Test
    public void testTask5(
            // @Optional - не могу понять как можно проставить его, если параметров больше одного
            String initialString, String expectedReversedString) {
        String actualReversedString = task5.reverse(initialString);
        assertEquals(
                expectedReversedString,
                actualReversedString,
                "Expected " + expectedReversedString + " but got " + actualReversedString + "."
        );
    }
}
