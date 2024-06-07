package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._03_animal_factory_example;

public class Tiger implements Animal {

    public Tiger() {
        System.out.println("\nA tiger is created");
    }

    public Tiger(String color) {
        System.out.println("\nA tiger with " + color+ " color is created.");
    }

    @Override
    public void displayBehavior() {
        System.out.println("Tiger says: Halum.");
        System.out.println("It loves to roam in a jungle.");
    }
}
