package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._01_car_abstract_factory_example;

public class NorthAmericaCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public CarSpecification createSpecification() {
        return new NorthAmericaSpecification();
    }
}
