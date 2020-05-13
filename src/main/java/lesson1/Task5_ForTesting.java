package main.java.lesson1;

/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */
public class Task5_ForTesting {
    public static void main(String[] args) {
        System.out.println(reverse("Hello world!!!"));
    }

    public static String reverse(String str) {
        int length = str.length();
        String a = "";
        for (int i = length; i > 0; i--) {
            a = a + str.charAt(i - 1);
        }
        return a;
    }
}

