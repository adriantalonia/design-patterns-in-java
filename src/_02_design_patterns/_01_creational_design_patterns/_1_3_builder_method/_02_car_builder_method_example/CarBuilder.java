package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

public class CarBuilder implements Builder {

    Car car;

    public CarBuilder() {
        car = new Car("Ford");
    }

    @Override
    public void addBrandName() {
        car.add("Adding the car brand: " + car.brandName);
    }

    @Override
    public void buildBody() {
        car.add(" Making the car body.");
    }

    @Override
    public void insertWheels() {
        car.add(" 4 wheels are added to the car.");
    }

    @Override
    public Vehicle getVehicle() {
        return car;
    }
}
