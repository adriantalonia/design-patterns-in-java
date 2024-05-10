# Single Responsibility Principle

A class acts like a container that can hold many things such as data, properties, or
methods. If you put in too much data or methods that are not related to each other,
you end up with a bulky class that can create problems in the future. Let’s consider an
example. Suppose you create a class with multiple methods that do different things.
In such a case, even if you make a small change in one method, you need to retest the
whole class again to ensure the workflow is correct. Thus, changes in one method can
impact the other related method(s) in the class. This is why the single responsibility
principle opposes this idea of putting multiple responsibilities in a class. It says that **_a
class should have only one reason to change_**.

#### POINT TO REMEMBER:
When you follow the SRP, your code is smaller, cleaner, and less fragile. 

**_So how do you follow this principle?_** 

A simple answer is you can divide a big problem into smaller chunks based
on different responsibilities and put each of these small parts into separate classes. 

_**The next question is, what do we mean by responsibility?**_ 

In simple words, responsibility is a reason for a change. 

In his best-selling book Clean Architecture (Pearson, 2017), Robert C. Martin
warns us not to confuse this principle with the principle that says **a function** should do one,
and only one, thing. He also says that perhaps the best way to understand this principle is
when you look at the symptoms of violating it.

### 01 employee without SRP example

Demonstration 1 has an Employee class with three different methods. Here are the details:

* The **displayEmpDetail()** shows the employee's name and their working experience in years.
* The **generateEmpId()** method generates an employee id using string concatenation. The logic is simple: I concatenate the first word of the first name with a random number to form an employee ID. In the following demonstration, inside the main() method (the client code)I create two Employee instances and use these methods to display the relevant details.
* The **checkSeniority()** method evaluates whether an employee is a senior person. I assume that if the employee has 5+ years of experience, he is a senior employee; otherwise, he is a junior employee.

**Code:**
```java
public class Employee {
    public String firstName, lastName, empId;
    public double experienceInYears;

    public Employee(String firstName, String lastName, double experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experienceInYears;
    }

    public void displayEmpDetails() {
        System.out.println("The employee name: " + lastName + ", " + firstName);
        System.out.println("This employee has " + experienceInYears + " years of experience.");
    }

    public String checkSeniority(double experienceInYears) {
        return experienceInYears > 5 ? "Senior" : "Junior";
    }

    public String generateEmployeeId(String empFirstName) {
        int randomNumber = new Random().nextInt(1000);
        empId = empFirstName.substring(0, 1) + randomNumber;
        return empId;
    }
}
```

```java
public class Client {

    public static void main(String[] args) {

        System.out.println("*** A demo without SRP ***");

        Employee emp01 = new Employee("Robin", "Smith", 7.5);
        showEmpDetail(emp01);

        System.out.println("\n*******\n");

        Employee emp02 = new Employee("Kevin", "Proctor", 3.2);
        showEmpDetail(emp02);
    }

    private static void showEmpDetail(Employee emp) {
        emp.displayEmpDetails();
        System.out.println("The employee id: " + emp.generateEmployeeId(emp.firstName));
        System.out.println("This employee is a " + emp.checkSeniority(emp.experienceInYears));
    }
}
```
**Response:**
```
*** A demo without SRP ***
The employee name: Smith, Robin
This employee has 7.5 years of experience.
The employee id: R216
This employee is a Senior

*******

The employee name: Proctor, Kevin
This employee has 3.2 years of experience.
The employee id: K721
This employee is a Junior
```

## Analysis

What is the problem with this design? This answer is that I violate the SRP here. You
can see that displaying an employee detail, generating an employee id, or checking a
seniority level are all different activities. Since I put everything in a single class, I may
face problems adopting new changes in the future. Here are some possible reasons:

- The top management can set a different criterion to decide a
seniority level.
- They can also use a complex algorithm to generate the employee id.

In each case, I’ll need to modify the Employee class. Now you understand that it is
better to follow the SRP and separate these activities.

## Better Program
In the following demonstration, I introduce two more classes. The **SeniorityChecker**
class now contains the _checkSeniority_() method and the **EmployeeIdGenerator** class
contains the _generateEmpId_(...) method to generate the employee id. As a result, in
the future, if I need to change the program logic to determine the seniority level or use
a new algorithm to generate an employee id, I can make the changes in the respective
classes. Other classes are untouched, so I do not need to retest those classes.

To improve the code readability and avoid clumsiness inside the main() method, I
use the static method _showEmpDetail_(...). This method calls the _displayEmpDetail_()
method from Employee, the generateEmpId() method from **EmployeeIdGenerator**,
and the _checkSeniority_() method from **SeniorityChecker**. You understand
that this method was not necessary, but it makes the client code simple and easily
understandable.

