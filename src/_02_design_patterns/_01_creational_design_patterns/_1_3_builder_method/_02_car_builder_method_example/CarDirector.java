package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

public class CarDirector extends Director {
    // The car director follows
    // its own sequence:
    // Make body-> add wheels->then add the brand name.
    public Vehicle instruct(Builder builder) {
        builder.buildBody();
        builder.insertWheels();
        builder.addBrandName();
        return builder.getVehicle();
    }
}