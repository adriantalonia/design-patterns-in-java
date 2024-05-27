package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._02_vehicle_with_factory_example;

public class ClientFM {
    private final VehicleFM pVehicle;

    public ClientFM(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public VehicleFM getVehicle() {
        return pVehicle;
    }
}
