package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._03_animal_factory_example;

public class AnimalClient {

    public static void main(String[] args) {
        System.out.println("*** Factory Method Pattern Demo.***");
        AnimalFactory factory;
        Animal animal;

        // Create a tiger and display its behavior
        // using TigerFactory
        factory = new TigerFactory();
        animal = factory.createAnimal();
        animal.displayBehavior();

        // Create a dog and display its behavior
        factory = new DogFactory();
        animal = factory.createAnimal();
        animal.displayBehavior();

        // ***Factory Method pattern modified demonstration.***
        System.out.println("\n***Factory Method pattern modified demonstration.***");
        AnimalFactory factory2;
        // Create a tiger and display its behavior
        // using TigerFactory
        factory2 = new TigerFactory();
        factory2.createAndDisplayAnimal("Yellow");

        // Create a dog and display its behavior
        factory2 = new DogFactory();
        factory2.createAndDisplayAnimal("White");
    }
}
