package _01_solid_principles._05_dependency_inversion._01_database_without_dip_example;

public class UserInterface {
    private OracleDatabase oracleDatabase;
    public UserInterface() {
        this.oracleDatabase = new OracleDatabase();
    }

    public void saveEmployee(String empId) {
        // Assuming that this is a valida data
        // so, storing it in the database
        oracleDatabase.saveEmpIdInDatabase(empId);
    }
}
