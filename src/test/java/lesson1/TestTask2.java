package test.java.lesson1;

import main.java.lesson1.Task2_ForTesting;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask2 {
    Task2_ForTesting task2;

    @BeforeMethod
    public void initialize() {
        this.task2 = new Task2_ForTesting();
    }

    @Test
    public void stringConsistsOfCorrectNumberOfSubstrings() {
        int actualNumberSubstrings = this.task2.createString("Anna").split("\n").length;
        int expectedNumberSbustrings = 5;
        assertEquals(
                actualNumberSubstrings,
                expectedNumberSbustrings,
                "Expected number of substrings to be " + expectedNumberSbustrings + "but got " + actualNumberSubstrings + "."
        );
    }

    @Test
    public void substringConsistsOfCorrectNumberOfNames() {
        int expectedNumberNames = 10;
        int actualNumberNames = 0;
        for (int i = 0; i < 5; i++) {
            actualNumberNames = this.task2.createString("Anna").split("\n")[i].split(" ").length;
            if (actualNumberNames != expectedNumberNames) break;
        }


        assertEquals(
                actualNumberNames,
                expectedNumberNames,
                "Expected number of names to be " + expectedNumberNames + " but got " + actualNumberNames + "."
        );
    }
}
