package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._03_animal_factory_example;

public abstract class AnimalFactory {
    // This is the "factory method"
    // Notice that I defer the instantiation
    // process to the subclasses.
    protected abstract Animal createAnimal();
    protected abstract Animal createAnimal(String color);

    public void createAndDisplayAnimal(String color){
        Animal animal;
        animal = createAnimal(color);
        animal.displayBehavior();
    }
}
