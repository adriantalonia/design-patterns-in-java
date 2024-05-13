package _01_solid_principles._01_single_responsability._02_employee_srp_example;

import java.util.Random;

public class EmployeeIdGenerator {
    String empId;
    public String generateEmpId(String empFirstName) {
        int random = new Random().nextInt(1000);
        empId = empFirstName.substring(0, 1) + random;
        return empId;
    }
}
