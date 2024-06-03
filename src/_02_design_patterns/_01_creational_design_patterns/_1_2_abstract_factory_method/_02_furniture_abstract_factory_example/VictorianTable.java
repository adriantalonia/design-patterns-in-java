package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._02_furniture_abstract_factory_example;

// Concrete Product B1 - Victorian style table
public class VictorianTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a Victorian Table");
    }
}
