package main.java.lesson2;

public class Main {
    public static void main(String[] args) {
        Task1 anna = new Task1();
        Task1 bobik = new Task1("bobik     ", 5);
        Task1 star = new Task1(15);
        star.setName("super star");
        anna.setName("          ");
        anna.setAge(200);

        System.out.println(anna.getName() + " " + anna.getAge() + " " + anna.getAgeGroup());
        System.out.println(bobik.getName() + " " + bobik.getAge() + " " + bobik.getAgeGroup());
        System.out.println(star.getName() + " " + star.getAge() + " " + star.getAgeGroup());

    }
}
