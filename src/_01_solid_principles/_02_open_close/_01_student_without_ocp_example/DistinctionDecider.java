package _01_solid_principles._02_open_close._01_student_without_ocp_example;

import java.util.List;

public class DistinctionDecider {
    List<String> science = List.of("Comp.Sc.", "Physics");
    List<String> arts = List.of("History", "English");

    public void evaluateDistinction(Student student) {
        if (science.contains(student.department)) {
            if (student.score > 80) {
                System.out.println(student.regNumber+" has received a distinction in science.");
            }
        }

        if (arts.contains(student.department)) {
            if (student.score > 70) {
                System.out.println(student.regNumber+" has received a distinction in arts.");
            }
        }
    }
}
