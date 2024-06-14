package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._01_computer_builder_method_example;

public class OfficeComputerBuilder implements Builder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Office CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("8GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}