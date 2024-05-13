package _01_solid_principles._01_single_responsability._02_employee_srp_example;

public class SeniorityChecker {
    public String checkSeniority(double experienceInYears) {
        return experienceInYears > 5 ? "senior" : "junior";
    }
}
