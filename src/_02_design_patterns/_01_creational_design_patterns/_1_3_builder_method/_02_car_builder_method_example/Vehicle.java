package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._02_car_builder_method_example;

import java.util.LinkedList;

abstract class Vehicle {
    private LinkedList<String> parts;

    public Vehicle() {
        parts = new LinkedList<>();
    }

    public void add(String part) {
        parts.add(part);
    }

    public void showProduct () {
        System.out.println("There are the construction sequences: ");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
