package _01_solid_principles._01_single_responsability._01_employee_without_srp_example;

public class Client {

    public static void main(String[] args) {

        System.out.println("*** A demo without SRP ***");

        Employee emp01 = new Employee("Robin", "Smith", 7.5);
        showEmpDetail(emp01);

        System.out.println("\n*******\n");

        Employee emp02 = new Employee("Kevin", "Proctor", 3.2);
        showEmpDetail(emp02);
    }

    private static void showEmpDetail(Employee emp) {
        emp.displayEmpDetails();
        System.out.println("The employee id: " + emp.generateEmployeeId(emp.firstName));
        System.out.println("This employee is a " + emp.checkSeniority(emp.experienceInYears));
    }
}
