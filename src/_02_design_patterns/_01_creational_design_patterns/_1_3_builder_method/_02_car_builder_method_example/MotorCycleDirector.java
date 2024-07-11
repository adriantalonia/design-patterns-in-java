package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

public class MotorCycleDirector extends Director {
    // The motor cycle director follows
    // its own sequence:
    // Add brand name-> make body-> insert wheels.
    public Vehicle instruct(Builder builder) {
        builder.addBrandName();
        builder.buildBody();
        builder.insertWheels();
        return builder.getVehicle();
    }
}
