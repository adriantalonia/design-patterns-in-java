# Open/Closed Principle (OCP)

According to Robert C. Martin, the Open/Closed Principle is the most important
principle among all the principles of object-oriented design. In the book Clean
Architecture, he says the following:

> The Open-Closed Principle (OCP) was coined in 1988 by Bertrand Meyer.
It says: A software artifact should be open for extension but closed for
modification.

Some important thoughts behind this principle:

- Any modular decomposition technique must satisfy the Open-Closed
Principle. Modules should be both open and closed
- The contradiction between the two terms is only apparent as they
  correspond to goals of a different nature.
  - A module is said to be open if it is still available for extension. For
    example, it should be possible to expand its set of operations or
    add fields to its data structures. 
  - A module is said to be closed if it is available for use by other
    modules. This assumes that the module has been given a
    well-­defined, stable description (its interface in the sense of
    information hiding). At the implementation level, closure for a
    module also implies that you may compile it, perhaps store it in a
    library, and make it available for others (its clients) to use.
- The need for modules to be closed and the need for them to remain
  open arise for different reasons.
- Openness is useful for software developers because
  they can’t foresee all the elements that a module may need in the
  future. But the “closed” modules will satisfy project managers
  because they want to complete the project instead of waiting for
  everyone to complete their parts.

The previous points are self-explanatory. You understand that the idea behind this
design philosophy is that in a stable and working application, once you create a class and
other parts of your application start using it, any further change in the class can cause
the working application to break. If you require new features (or functionalities), instead
of changing the existing class, you can extend it to adopt the new requirements. 

**What is the benefit?** Since you do not change the old code, your existing functionalities continue
to work without any problems, and you can avoid testing them again. Instead, you test
the “extended” part (or functionalities) only.

> “A class is closed, since it may be compiled, stored in a library, baselined,
and used by client classes. But it is also open, since any new class may use it
as a parent, adding new features. When a descendant class is defined, there
is no need to change the original or to disturb its clients." by Bertrand Meyer


But inheritance promotes tight coupling. In programming, we like to remove these
tight couplings. Robert C. Martin improved the definition and made it polymorphic
OCP. The new proposal uses abstract base classes that use the protocols instead
of a superclass to allow different implementations. These protocols are closed for
modification, and they provide another level of abstraction that enables loose coupling.

### Initial Program

Assume that there is a small group of students who take a semester examination.
(To demonstrate this, I choose a small number of participants to help you focus on the
principle, not unnecessary details.) Sam, Bob, John, and Kate are the four students in
this example. They all belong to the Student class. To make a Student class instance,
you supply a name, registration number, and the marks obtained in the examination.
You also mention whether a student belongs to the Science department or the Arts
department.

For simplicity, let’s assume a particular college has the following four departments:

- Computer Science
- Physics
- History
- English

So, you see the following lines of code in the upcoming example:

> Student sam = new Student("Sam", "R1", 81.5, "Comp.Sc.");

> Student bob = new Student("Bob", "R2", 72, "Physics");

> Student john = new Student("John", "R3", 71, "History");

> Student kate = new Student("Kate", "R4", 66.5, "English");

When a student opts for computer science or physics, we say that they opt for the
science stream. Similarly, when a student belongs to the History or English department,
they are an arts student.

Start with two instance methods in this example. The **_displayResult_**() displays the
result with all necessary details of a student and the **_evaluateDistinction_**() method
evaluates whether a student is eligible for a distinction certificate. If a science student
scores above 80 in this examination, they get the certificate with distinction. But the
criterion for an arts student is slightly relaxed. An arts student gets the distinction if their
score is above 70.

**Code:**
```java
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
```

```java
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
```

```java
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
```

**Results:**
```
*** A demo without OCP.***
===Results:===
Name: Sam
Reg Number: R1
Department: Comp.Sc.
Score: 81.5

Name: Bob
Reg Number: R2
Department: Physics
Score: 72.0

Name: John
Reg Number: R3
Department: History
Score: 71.0

Name: Kate
Reg Number: R4
Department: English
Score: 66.5

===Distinctions:===
R1 has received a distinction in science.
R3 has received a distinction in arts.
```

## Analysis

Now you are following the SRP. If in the future the examining authority changes the
distinction criteria, you do not touch the Student class. So, this part is closed for
modification. This solves one part of the problem. Now think about another future
possibility:

- The college authority can introduce a new stream such as commerce
  and set a new distinction criterion for this stream.

You need to make some obvious changes again. For example, you need to modify the
**evaluateDistinction()** method and add another if statement to consider commerce
students. Now the question is, is it ok to modify the **evaluateDistinction()** method
in this manner? Remember that each time you modify the method, you need to test the
entire code workflow again.

You understand the problem now. In this demonstration, every time the distinction
criteria changes, you need to modify the evaluateDistinction() method in the
DistinctionDecider class. **_So, this class is not closed for modification._**