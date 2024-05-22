package _01_solid_principles._05_dependency_inversion._02_database_with_dip_example;

public class MySQLDatabase implements Database {
    @Override
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("The id: " + empId + " is saved in the MySQL database.");
    }
}
