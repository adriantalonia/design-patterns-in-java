package _01_solid_principles._02_open_close._01_student_without_ocp_example;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        System.out.println("*** A demo without OCP.***");
        List<Student> enrolledStudents = enrollStudents();
        // Display all results
        System.out.println("===Results:===");
        for (Student student : enrolledStudents) {
            System.out.println(student);
        }
        System.out.println("===Distinctions:===");
        DistinctionDecider distinctionDecider = new DistinctionDecider();
        // Evaluate distinctions
        for (Student student : enrolledStudents) {
            distinctionDecider.evaluateDistinction(student);
        }
    }

    private static List<Student> enrollStudents() {
        Student sam = new Student("Sam", "R1", 81.5, "Comp.Sc.");
        Student bob = new Student("Bob", "R2", 72, "Physics");
        Student john = new Student("John", "R3", 71, "History");
        Student kate = new Student("Kate", "R4", 66.5, "English");
        return List.of(sam, bob, john, kate);
    }
}
