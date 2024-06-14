package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._01_computer_builder_method_example;

public class ComputerDirector {
    // The construct method takes a Builder object and calls its methods
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}
