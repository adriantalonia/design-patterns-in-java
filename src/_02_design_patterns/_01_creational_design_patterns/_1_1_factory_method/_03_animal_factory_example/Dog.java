package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._03_animal_factory_example;

public class Dog implements Animal {

    public Dog() {
        System.out.println("\nA dog is created.");
    }

    public Dog(String color) {
        System.out.println("\nA dog with " + color+ " color is created.");
    }

    @Override
    public void displayBehavior() {
        System.out.println("It says: Bow-Wow.");
        System.out.println ("It prefers barking.");
    }
}
