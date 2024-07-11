package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

abstract class Director {
    // Director knows how to use/instruct the
    // builder to create a vehicle.
    public abstract Vehicle instruct(Builder builder);
}
