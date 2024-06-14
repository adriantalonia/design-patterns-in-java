package _02_design_patterns._01_creational_design_patterns._1_3_builder_method._01_computer_builder_method_example;

public class Client {
    public static void main(String[] args) {
        // Using the GamingComputerBuilder to create a gaming computer
        Builder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();

        // Using the OfficeComputerBuilder to create an office computer
        Builder officeBuilder = new OfficeComputerBuilder();
        director.construct(officeBuilder);
        Computer officeComputer = officeBuilder.getResult();
        officeComputer.displayInfo();
    }
}
