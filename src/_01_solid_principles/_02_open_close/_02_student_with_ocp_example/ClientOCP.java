package _01_solid_principles._02_open_close._02_student_with_ocp_example;

import java.util.ArrayList;
import java.util.List;

public class ClientOCP {

    public static void main(String[] args) {
        System.out.println("*** A demo that follows the OCP.***");
        List<StudentOCP> enrollScienceStudents = enrollScienceStudents();
        List<StudentOCP> enrollArtsStudents = enrollArtsStudents();
        List<StudentOCP> enrollStudents = new ArrayList<>();
        enrollStudents.addAll(enrollScienceStudents);
        enrollStudents.addAll(enrollArtsStudents);

        System.out.println("===Results:===");
        for (StudentOCP student : enrollStudents) {
            System.out.println(student);
        }

        System.out.println("===Distinctions:===");
        DistinctionDecider scienceDistinctionDecider = new ScienceDistinctionDecider();
        DistinctionDecider artsDistinctionDecider = new ArtsDistinctionDecider();

        for (StudentOCP student : enrollScienceStudents) {
            scienceDistinctionDecider.evaluateDistinction(student);
        }

        for (StudentOCP student : enrollArtsStudents) {
            artsDistinctionDecider.evaluateDistinction(student);
        }
    }

    private static List<StudentOCP> enrollScienceStudents() {
        StudentOCP sam = new ScienceStudent("Sam","R1",81.5,"Comp.Sc.");
        StudentOCP bob = new ScienceStudent("Bob","R2",72,"Physics");
        List<StudentOCP> scienceStudents = new ArrayList<StudentOCP>();
        scienceStudents.add(sam);
        scienceStudents.add(bob);
        return scienceStudents;
    }

    private static List<StudentOCP> enrollArtsStudents() {
        StudentOCP john = new ArtsStudent("John", "R3", 71,"History");
        StudentOCP kate = new ArtsStudent("Kate", "R4", 66.5,"English");
        List<StudentOCP> artsStudents = new ArrayList<StudentOCP>();
        artsStudents.add(john);
        artsStudents.add(kate);
        return artsStudents;
    }
}
