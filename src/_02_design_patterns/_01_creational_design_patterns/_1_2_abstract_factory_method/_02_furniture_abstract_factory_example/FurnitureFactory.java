package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._02_furniture_abstract_factory_example;

// Abstract Factory interface that declares creation methods for each type of product
public interface FurnitureFactory {
    Chair createChair(); // Method to create a chair
    Table createTable(); // Method to create a table
}
