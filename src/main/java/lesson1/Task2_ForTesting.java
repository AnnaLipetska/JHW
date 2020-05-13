package main.java.lesson1;

/* Мое имя
Передаланное задание, так чтобы метод был вынесен из метода main и чтобы возвращал что-нибудь.
*/

public class Task2_ForTesting {

    public static void main(String[] args) {
        String s = "Anna";

        System.out.println(createString(s));
    }

    public static String createString(String s) {
        String longString = "";
        for (int i = 0; i < 5; i++) {
            longString = longString + s;
            for (int j = 1; j < 10; j++) {
                longString = (longString + " " + s);
            }
            longString = (longString + "\n");
        }
        return longString;
    }
}
