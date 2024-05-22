package _01_solid_principles._05_dependency_inversion._02_database_with_dip_example;

public class UserInterfaceIDP {
    Database database;

    public UserInterfaceIDP(Database database) {
        this.database = database;
    }

    public void saveEmployeeId(String empId) {
        database.saveEmpIdInDatabase(empId);
    }
}
