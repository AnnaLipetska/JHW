package main.java.Homework2;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        System.out.println(min(5, 2, 3));
    }

    public static int min(int a, int b, int c) {
        // Первый вариант. С помощью вложенных условий.
        int min;
        if (a <= b) {
            if (a <= c) min = a;
            else min = c;
        } else {
            if (b <= c) min = b;
            else min = c;
        }

        return min;

        //Второй вариант. С помощью Math.min.
        /*int min;
        if (a <= b) {
            min = Math.min(a, c);
        } else {
            min = Math.min(b, c);
        }
        return min;*/
    }

}


