package _01_solid_principles._01_single_responsability._02_employee_srp_example;

import org.w3c.dom.ls.LSOutput;

public class ClientSRP {

    public static void main(String[] args) {
        System.out.println("*** A demo that follows the SRP.***");

        EmployeeSRP robin = new EmployeeSRP("Robin", "Smith", 7.5);
        showEmpDetail(robin);

        System.out.println("\n*******\n");
        EmployeeSRP kevin = new EmployeeSRP("Kevin", "Proctor", 3.2);
        showEmpDetail(kevin);
    }

    private static void showEmpDetail(EmployeeSRP emp) {
        // Display employee detail
        emp.displayEmpDetails();

        // Generate the ID
        EmployeeIdGenerator idGenerator = new EmployeeIdGenerator();
        String empId = idGenerator.generateEmpId(emp.firstName);
        System.out.println("The employee id: " + empId);

        // Check the seniority level
        SeniorityChecker seniorityChecker = new SeniorityChecker();
        System.out.println("This employee is a " + seniorityChecker.checkSeniority(emp.experienceInYears) + " employee.");
    }

}
