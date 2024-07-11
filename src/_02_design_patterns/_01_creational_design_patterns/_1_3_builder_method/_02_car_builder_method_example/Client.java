package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

public class Client {
    public static void main(String[] args) {
        System.out.println("*** Builder Pattern Demonstration. ***");
    // Making a car
        Builder builder = new CarBuilder();
        Director director = new CarDirector();
        Vehicle vehicle = director.instruct(builder);
        vehicle.showProduct();
    // Making a motorcycle
        builder = new MotorCycleBuilder();
        director = new MotorCycleDirector();
        vehicle = director.instruct(builder);
        vehicle.showProduct();
    }
}
