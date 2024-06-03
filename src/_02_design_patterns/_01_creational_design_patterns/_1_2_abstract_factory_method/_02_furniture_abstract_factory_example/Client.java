package _02_design_patterns._01_creational_design_patterns._1_2_abstract_factory_method._02_furniture_abstract_factory_example;

public class Client {
    private Chair chair;
    private Table table;

    // Client uses a FurnitureFactory to create specific types of furniture
    public Client(FurnitureFactory factory) {
        chair = factory.createChair(); // Create a chair
        table = factory.createTable(); // Create a table
    }

    // Use the created furniture
    public void useFurniture() {
        chair.sitOn(); // Use the chair
        table.use(); // Use the table
    }

    public static void main(String[] args) {
        // Create a Victorian furniture factory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        // Create a client with Victorian furniture
        Client victorianClient = new Client(victorianFactory);
        victorianClient.useFurniture(); // Use the Victorian furniture

        // Create a Modern furniture factory
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        // Create a client with Modern furniture
        Client modernClient = new Client(modernFactory);
        modernClient.useFurniture(); // Use the Modern furniture
    }
}
