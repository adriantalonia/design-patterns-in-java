package _01_solid_principles._02_open_close._02_student_with_ocp_example;

abstract class StudentOCP {
    String name;
    String regNumber;
    String department;
    double score;

    public StudentOCP(String name, String regNumber, double score) {
        this.name = name;
        this.regNumber = regNumber;
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
