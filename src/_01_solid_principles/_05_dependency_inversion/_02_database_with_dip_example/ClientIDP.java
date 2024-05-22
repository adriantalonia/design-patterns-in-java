package _01_solid_principles._05_dependency_inversion._02_database_with_dip_example;

public class ClientIDP {
    public static void main(String[] args) {
        System.out.println("***A demo with DIP***");
        // Using Oracle now
        Database database = new OracleDatabaseIDP();
        UserInterfaceIDP userInterfaceIDP = new UserInterfaceIDP(database);
        userInterfaceIDP.saveEmployeeId("E001");

        // Using MySQL
        database = new MySQLDatabase();
        userInterfaceIDP = new UserInterfaceIDP(database);
        userInterfaceIDP.saveEmployeeId("E002");
    }
}
