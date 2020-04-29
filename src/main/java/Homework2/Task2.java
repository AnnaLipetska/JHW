package main.java.Homework2;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for
*/

public class Task2 {

    public static void main(String[] args) {
        String s = "Anna";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        /*System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);
        System.out.println(
                s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " " + s + " "
                        + s);*/
    }
}
