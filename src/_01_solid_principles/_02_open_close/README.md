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

## Better Program

To tackle this problem, you can write a better program. The following program shows
such an example. It’s written following the OCP principle that suggests we **write code
segments (such as classes, or methods) that are open for extension but closed for
modification.**

> The OCP can be achieved in different ways, but **abstraction** is the heart of this
principle. If you can design your application following the OCP, your application is
flexible and extensible. It is not always easy to fully implement this principle, but
partial OCP compliance can generate greater benefit to you. Also notice that you
started demonstration 3 following the SRP. If you do not follow the OCP, you may
end up with a class that performs multiple tasks, which means the SRP is broken.

**Code:**
```java
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
```

```java
public class ArtsStudent extends StudentOCP {
    public ArtsStudent(String name, String regNumber, double score, String dept) {
        super(name, regNumber, score);
        this.department = dept;
    }
}

public class ScienceStudent extends StudentOCP {
  public ScienceStudent(String name, String regNumber, double score, String dept) {
    super(name, regNumber, score);
    this.department = dept;
  }
}
```

```java
public interface DistinctionDecider {
    void evaluateDistinction(StudentOCP student);
}

public class ScienceDistinctionDecider implements DistinctionDecider {
  @Override
  public void evaluateDistinction(StudentOCP student) {
    if (student.score > 80) {
      System.out.println(student.regNumber + " has received a distinction in science.");
    }
  }
}

public class ArtsDistinctionDecider implements DistinctionDecider {
  @Override
  public void evaluateDistinction(StudentOCP student) {
    if (student.score > 70) {
      System.out.println(student.regNumber + " has received a distinction in arts.");
    }
  }
}
```

```java
public class ClientOCP {

    public static void main(String[] args) {
        System.out.println("*** A demo OCP.***");
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
```

**Results:**
```

*** A demo that follows the OCP.***
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

What are the key advantages now? The following points tell you the answers:

- The **StudentOCP** class and **DistinctionDecider** are both unchanged
  for any future changes in the distinction criteria. They are closed for
  modification.
- Notice that every participant follows the SRP.
- Suppose you need to consider a new stream, say commerce. Then
  you can create a new class such as CommerceStudent. Notice that
  in a case like this, you do not need to touch the ArtsStudent or
  ScienceStudent classes.
- Similarly, when you consider different evaluation criteria for a
  different stream such as commerce, you can add a new derived
  class such as **CommerceDistinctionDecider** that implements the
  **DistinctionDecider** **interface** and you can set new distinction
  criteria for commerce students. In this case, you do not need to alter
  any existing class in the **DistinctionDecider** hierarchy. Obviously,
  the client code needs to adopt this change.
- Using this approach, you avoid an **if-else** chain (shown in
  demonstration 3). This chain could grow if you consider new
  streams such as commerce following the approach that is shown
  in demonstration 3. Remember that avoiding a big if-else chain
  is always considered a better practice. It is because avoiding the
  if-else chains lowers the cyclomatic complexity of a program and
  produces better code. (Cyclomatic complexity is a software metric
  to indicate the complexity of a program. It indicates the number
  of paths through a particular piece of code. So, in simple terms,
  by lowering the cyclomatic complexity you make your code easily
  readable and testable.)