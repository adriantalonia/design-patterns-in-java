package _01_solid_principles._02_open_close._02_student_with_ocp_example;

public class ScienceDistinctionDecider implements DistinctionDecider {
    @Override
    public void evaluateDistinction(StudentOCP student) {
        if (student.score > 80) {
            System.out.println(student.regNumber + " has received a distinction in science.");
        }
    }
}
