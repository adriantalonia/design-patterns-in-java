package _01_solid_principles._02_open_close._02_student_with_ocp_example;

public class ArtsStudent extends StudentOCP {
    public ArtsStudent(String name, String regNumber, double score, String dept) {
        super(name, regNumber, score);
        this.department = dept;
    }
}
