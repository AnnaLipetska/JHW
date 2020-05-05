package main.java.lesson2;

public class Task1 {
    // Реализовать у класса Task1 переменные age (тип int),  name (тип String), ageGroup(тип String)
    // не должно быть возможности напрямую устанавливать или читать значение age/name, поэтому private
    private int age = 0;
    private String name = "not defined";
    private String ageGroup;

    // Конструктор
    public Task1() {
        this("not defined", 0);
    }

    public Task1(String name) {
        this(name, 0);
    }

    public Task1(int age) {
        this("not defined", age);
    }

    public Task1(String name, int age) {
        this.name = CheckName(name);
        this.age = CheckAge(age);
        this.ageGroup = CalculateAgeGroup(age);
    }


    // реализовать методы геттеры и сеттеры для каждой переменной.
    public int getAge() {
        return this.CheckAge(age);
    }

    public void setAge(int age) { // максимальныое значение для возраста - 100
        age = CheckAge(age);
        ageGroup = CalculateAgeGroup(age);
    }

    public String getName() {
        name = CheckName(name);
        return this.name;
    }

    public void setName(String name) {
        this.name = CheckName(name);
    }

    public String getAgeGroup() {
        return this.ageGroup;
    }

    private void setAgeGroup(int age) {
// ageGroup можно только прочитать с помощью геттера, сеттер должен быть приватным и недоступным для других классов
    }

    private String CalculateAgeGroup(int age) {
        /**     - child если age до 15 лет
         *      - student  - если age от 15 до 25 лет
         *      - worker - если age от 26 до 65 лет
         *      - pensioner - если age старше 66 лет
         */
        if (age < 15) {
            ageGroup = "child";
        } else if (age >= 15 && age <= 25) {
            ageGroup = "student";
        } else if (age >= 26 && age <= 65) {
            ageGroup = "worker";
        } else if (age >= 66) {  // или можно просто else без условия
            ageGroup = "pensioner";
        }
        return this.ageGroup;
    }

    private String CheckName(String name) {
        // значение name не может быть короче чем 3 символа и длиннее чем 50 символов
        int nameLength = name.length();
        if (name.length() >= 3 && name.length() <= 50 && name.matches(".*[^\\s].*")) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            // не зависимо от того ввел пользователь имя с большой или с маленькой буквы,
            // оно должно быть записано в переменную name с большой буквы
        } else {
            System.out.println("The length of name should be 3 to 50 symbols and to consist of only whitespaces.");
            name = "not defined";
        }
        return name;
    }

    private int CheckAge(int age) {
        if (age >= 0 && age <= 100) {
            ;
        } else { // нельзя установить значение age меньше нуля
            System.out.println("You can't set age " + age);
            age = 0;
        }
        return age;
    }
}

