package uz.pdp.variable_hiding_shadowing;

public class Main {
    Integer number = 1000;

    public static void main(String[] args) {
//        User user = new User();
//        Student student = new Student();
//        User studentAsChild = new Student();
//
//        user.printAge();
//        student.printAge();
//        studentAsChild.printAge();
        Integer number = 34;
        System.out.println(number);
    }
}

class User {
    Integer age = 40;

    public void printAge() {
        System.out.println(age);
    }
}

class Student extends User {
    Integer age = 30;

    public void printAge() {
        System.out.println(age);
    }
}
