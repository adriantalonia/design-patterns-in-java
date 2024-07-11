package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

public interface Builder {
    void addBrandName();
    void buildBody();
    void insertWheels();
    Vehicle getVehicle();
}
