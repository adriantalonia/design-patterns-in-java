package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._01_car_abstract_factory_example;

public class NorthAmericaSpecification implements CarSpecification {
    public void display() {
        System.out.println("North America Car Specification: Safety features compliant with local regulations.");
    }
}
