package _01_solid_principles._01_single_responsability._01_employee_without_srp_example;

import java.util.Random;

public class Employee {
    public String firstName, lastName, empId;
    public double experienceInYears;

    public Employee(String firstName, String lastName, double experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experienceInYears;
    }

    public void displayEmpDetails() {
        System.out.println("The employee name: " + lastName + ", " + firstName);
        System.out.println("This employee has " + experienceInYears + " years of experience.");
    }

    public String checkSeniority(double experienceInYears) {
        return experienceInYears > 5 ? "Senior" : "Junior";
    }

    public String generateEmployeeId(String empFirstName) {
        int randomNumber = new Random().nextInt(1000);
        empId = empFirstName.substring(0, 1) + randomNumber;
        return empId;
    }
}
