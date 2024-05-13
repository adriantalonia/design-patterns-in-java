package _01_solid_principles._01_single_responsability._02_employee_srp_example;

public class EmployeeSRP {
    public String firstName, lastName, empId;
    public double experienceInYears;
    public EmployeeSRP(String firstName, String lastName, double experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experienceInYears;
    }

    public void displayEmpDetails() {
        System.out.println("The employee name: " + lastName + ", " + firstName);
        System.out.println("This employee has " + experienceInYears + " years of experience.");
    }
}
