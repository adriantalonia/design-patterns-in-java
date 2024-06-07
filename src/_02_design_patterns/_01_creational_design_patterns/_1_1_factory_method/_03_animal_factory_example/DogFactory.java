package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._03_animal_factory_example;

public class DogFactory  extends AnimalFactory {

    // Creating and returning a 'Dog' instance
    @Override
    protected Animal createAnimal() {
        return new Dog();
    }

    @Override
    protected Animal createAnimal(String color) {
        return new Dog(color);
    }
}
