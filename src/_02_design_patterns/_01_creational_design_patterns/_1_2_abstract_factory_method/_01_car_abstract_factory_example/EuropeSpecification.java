package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._01_car_abstract_factory_example;

public class EuropeSpecification implements CarSpecification {
    public void display() {
        System.out.println("Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.");
    }
}
