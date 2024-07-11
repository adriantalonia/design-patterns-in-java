package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

public class Car extends Vehicle {
    String brandName;

    public Car(String brandName) {
        this.brandName = brandName;
        System.out.println("\nWe are about to make a " +
                brandName + " car.");
    }
}
