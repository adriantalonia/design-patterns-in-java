package _01_solid_principles._02_open_close._01_student_without_ocp_example;

public class Student {
    String name;
    String regNumber;
    String department;
    double score;

    public Student(String name, String regNumber, double score, String department) {
        this.name = name;
        this.regNumber = regNumber;
        this.department = department;
        this.score = score;
    }

    @Override
    public String toString() {
        return ("Name: " + name +
                "\nReg Number: " + regNumber +
                "\nDepartment: " + department +
                "\nScore: " + score +"\n");
    }
}
