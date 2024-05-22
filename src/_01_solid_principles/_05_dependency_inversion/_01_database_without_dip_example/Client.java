package _01_solid_principles._05_dependency_inversion._01_database_without_dip_example;

public class Client {
    public static void main(String[] args) {
        System.out.println("***A demo without DIP***");
        UserInterface userInterface = new UserInterface();
        userInterface.saveEmployee("E001");
    }
}
