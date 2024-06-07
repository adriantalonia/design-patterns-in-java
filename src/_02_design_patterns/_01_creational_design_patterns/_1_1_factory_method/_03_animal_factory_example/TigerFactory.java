package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._03_animal_factory_example;

public class TigerFactory extends AnimalFactory {

    // Creating and returning a 'Tiger' instance
    @Override
    protected Animal createAnimal() {
        return new Tiger();
    }

    @Override
    protected Animal createAnimal(String color) {
        return new Tiger(color);
    }
}
