package main.java.lesson1;

public class Task1_ForTesting {

    public static void main(String[] args) {
        System.out.println(min(5, 2, 3));
    }

    public static int min(int a, int b, int c) {
        int min;
        if (a <= b) {
            if (a <= c) min = a;
            else min = c;
        } else {
            if (b <= c) min = b;
            else min = c;
        }

        return min;
    }

}


