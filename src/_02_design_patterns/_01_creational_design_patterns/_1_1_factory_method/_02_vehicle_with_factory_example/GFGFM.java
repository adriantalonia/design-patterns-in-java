package _02_design_patterns._01_creational_design_patterns._1_1_factory_method._02_vehicle_with_factory_example;

public class GFGFM {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        ClientFM twoWheelerClient = new ClientFM(twoWheelerFactory);
        VehicleFM twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        ClientFM fourWheelerClient = new ClientFM(fourWheelerFactory);
        VehicleFM fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }
}
