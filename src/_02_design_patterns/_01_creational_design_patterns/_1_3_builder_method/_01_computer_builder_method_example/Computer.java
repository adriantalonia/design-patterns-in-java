package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._01_computer_builder_method_example;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    // Setters for setting the configuration details
    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    // Method to display the configuration of the computer
    public void displayInfo() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
}
