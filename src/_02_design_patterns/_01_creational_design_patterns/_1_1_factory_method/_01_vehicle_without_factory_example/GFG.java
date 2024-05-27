package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._01_vehicle_without_factory_example;

public class GFG {
    public static void main(String[] args) {
        Client pClient = new Client(1);
        Vehicle pVehicle = pClient.getVehicle();
        if (pVehicle != null) {
            pVehicle.printVehicle();
        }
        pClient.cleanup();
    }
}
