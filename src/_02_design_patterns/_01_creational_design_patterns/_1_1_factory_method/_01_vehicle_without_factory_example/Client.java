package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._01_vehicle_without_factory_example;

public class Client {
    private Vehicle pVehicle;

    public Client(int type) {
        if (type == 1) {
            pVehicle = new TwoWheeler();
        } else if (type == 2) {
            pVehicle = new FourWheeler();
        } else {
            pVehicle = null;
        }
    }

    public void cleanup() {
        if (pVehicle != null) {
            pVehicle = null;
        }
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}
