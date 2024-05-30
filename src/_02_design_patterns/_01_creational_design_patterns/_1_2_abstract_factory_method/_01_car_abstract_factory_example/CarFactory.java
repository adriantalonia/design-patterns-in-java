package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._01_car_abstract_factory_example;

public interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}
