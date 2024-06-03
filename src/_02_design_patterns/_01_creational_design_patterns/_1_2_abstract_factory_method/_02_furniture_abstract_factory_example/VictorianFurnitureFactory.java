package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._02_furniture_abstract_factory_example;

// Concrete Factory 1 - Creates Victorian style furniture
public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair(); // Creates a Victorian style chair
    }

    @Override
    public Table createTable() {
        return new VictorianTable(); // Creates a Victorian style table
    }
}
