package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._02_furniture_abstract_factory_example;

// Concrete Factory 2 - Creates Modern style furniture
public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair(); // Creates a Modern style chair
    }

    @Override
    public Table createTable() {
        return new ModernTable(); // Creates a Modern style table
    }
}
