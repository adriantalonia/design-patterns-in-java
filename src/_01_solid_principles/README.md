# SOLID Principles

<!-- TOC -->
* [SOLID Principles](#solid-principles)
  * [1. Single Responsibility Principle(SRP) 🔗](#1-single-responsibility-principle--srp--)
  * [2. Open/Close Principle (OCP) 🔗](#2-openclose-principle--ocp--)
  * [3. Liskov’s Substitution Principle 🔗](#3-liskovs-substitution-principle-)
  * [4. Interface Segregation Principle 🔗](#4-interface-segregation-principle-)
  * [5. Dependency Inversion Principle 🔗](#5-dependency-inversion-principle-)
  * [Summary](#summary)
  * [Q&A](#qa)
<!-- TOC -->

In software development, **Object-Oriented Design** plays a crucial role when it comes to writing flexible, scalable, maintainable, and reusable code. There are so many benefits of using OOD but every developer should also know the SOLID principle for good object-oriented design in programming. The SOLID principle was introduced by Robert C. Martin, also known as Uncle Bob and it is a coding standard in programming. 

This principle is an acronym of the five principles which are given below:

1. **Single Responsibility Principle (SRP)**
2. **Open/Closed Principle (OCP)**
3. **Liskov’s Substitution Principle (LSP)**
4. **Interface Segregation Principle (ISP)**
5. **Dependency Inversion Principle (DIP)**

## [1. Single Responsibility Principle(SRP)](_01_single_responsability/README.md) 🔗
This principle states that “A class should have only one reason to change” which means every class should have a single responsibility or single job or single purpose. In other words, a class should have only one job or purpose within the software system.

Let’s understand Single Responsibility Principle using an example:

> Imagine a baker who is responsible for baking bread. The baker’s role is to focus on the task of baking bread, ensuring that the bread is of high quality, properly baked, and meets the bakery’s standards.

* However, if the baker is also responsible for managing the inventory, ordering supplies, serving customers, and cleaning the bakery, this would violate the SRP.
* Each of these tasks represents a separate responsibility, and by combining them, the baker’s focus and effectiveness in baking bread could be compromised.
* To adhere to the SRP, the bakery could assign different roles to different individuals or teams. For example, there could be a separate person or team responsible for managing the inventory, another for ordering supplies, another for serving customers, and another for cleaning the bakery.

## [2. Open/Close Principle (OCP)](_02_open_close/README.md) 🔗

This principle states that “Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification” which means you should be able to extend a class behavior, without modifying it.

Let’s understand Open/Closed Principle using an example:

> Imagine you have a class called PaymentProcessor that processes payments for an online store. Initially, the PaymentProcessor class only supports processing payments using credit cards. However, you want to extend its functionality to also support processing payments using PayPal.

Instead of modifying the existing **PaymentProcessor** class to add PayPal support, you can create a new class called **PayPalPaymentProcessor** that extends the **PaymentProcessor** class. This way, the PaymentProcessor class remains closed for modification but open for extension, adhering to the **Open-Closed Principle**

## [3. Liskov’s Substitution Principle](_03_liskovs_substitution/README.md) 🔗

The principle was introduced by Barbara Liskov in 1987 and according to this principle “Derived or child classes must be substitutable for their base or parent classes“. This principle ensures that any class that is the child of a parent class should be usable in place of its parent without any unexpected behavior.

Let’s understand Liskov’s Substitution Principle using an example:

> One of the classic examples of this principle is a rectangle having four sides. A rectangle’s height can be any value and width can be any value. A square is a rectangle with equal width and height. So we can say that we can extend the properties of the rectangle class into square class.

In order to do that you need to swap the child (square) class with parent (rectangle) class to fit the definition of a square having four equal sides but a derived class does not affect the behavior of the parent class so if you will do that it will violate the Liskov Substitution Principle.

## [4. Interface Segregation Principle](_04_interface_segregation/README.md) 🔗

This principle is the first principle that applies to Interfaces instead of classes in SOLID and it is similar to the single responsibility principle. It states that “do not force any client to implement an interface which is irrelevant to them“. Here your main goal is to focus on avoiding fat interface and give preference to many small client-specific interfaces. You should prefer many client interfaces rather than one general interface and each interface should have a specific responsibility.

Let’s understand Interface Segregation Principle using an example:

> Suppose if you enter a restaurant and you are pure vegetarian. The waiter in that restaurant gave you the menu card which includes vegetarian items, non-vegetarian items, drinks, and sweets.

* In this case, as a customer, you should have a menu card which includes only vegetarian items, not everything which you don’t eat in your food. Here the menu should be different for different types of customers.
* The common or general menu card for everyone can be divided into multiple cards instead of just one. Using this principle helps in reducing the side effects and frequency of required changes.

## [5. Dependency Inversion Principle](_05_dependency_inversion/README.md) 🔗

The Dependency Inversion Principle (DIP) is a principle in object-oriented design that states that “High-level modules should not depend on low-level modules. Both should depend on abstractions“. Additionally, abstractions should not depend on details. Details should depend on abstractions.

- In simpler terms, the DIP suggests that classes should rely on abstractions (e.g., interfaces or abstract classes) rather than concrete implementations.
- This allows for more flexible and decoupled code, making it easier to change implementations without affecting other parts of the codebase.

Let’s understand Dependency Inversion Principle using an example:

> In a software development team, developers depend on an abstract version control system (e.g., Git) to manage and track changes to the codebase. They don’t depend on specific details of how Git works internally.

This allows developers to focus on writing code without needing to understand the intricacies of version control implementation.

## Summary

The SOLID principles are the fundamental guidelines in object-oriented design. They
are high-level concepts that help you develop better software. They are neither rules nor
laws, but they help you think of possible scenarios/outcomes in advance.

## Q&A

1. **What are the SOLID principles in Java?**

   The SOLID principles are a set of five design principles that help developers create more maintainable and scalable software.

   - **Single Responsibility Principle (SRP):**
     A class should have only one reason to change. It should have only one responsibility.
   - **Open/Closed Principle (OCP):**
     Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. You should be able to add new functionality without altering existing code.
   - **Liskov Substitution Principle (LSP):**
     Subtypes must be substitutable for their base types without altering the correctness of the program. Derived classes should be able to replace their base classes without causing errors.
   - **Interface Segregation Principle (ISP):**
     Clients should not be forced to depend on interfaces they do not use. It's better to have multiple specific interfaces than one large, general-purpose interface.
   - **Dependency Inversion Principle (DIP):**
     High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.


2. **Explain the Single Responsibility Principle (SRP) with an example in Java.**
   
    SRP states that a class should have only one reason to change. In Java, this means that a class should have only one responsibility.
```java
// Bad example violating SRP   
class Employee {       
    void calculateSalary() {           
        // Calculate employee salary       
    }       
    void saveToDatabase() {           
        // Save employee data to the database       
    }   
}
```
In the above code, the Employee class has two responsibilities: calculating the salary and saving to the database. It would be better to have separate classes for these tasks to adhere to SRP.

3. **How does the Open/Closed Principle (OCP) promote extensibility in Java?**
    
    OCP encourages software entities to be open for extension but closed for modification. This means you can add new functionality without altering existing code. In Java, this is often achieved through inheritance and interfaces.

```java
 // Example of OCP
interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI radius radius;
    }
}


class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}
```
Here, you can add new shapes Triangle without modifying the existing Shape interface or classes, demonstrating the open-for-extension, and closed-for modification principle.


4. **Explain the Liskov Substitution Principle (LSP) and its importance in Java?**

   LSP states that derived classes (subtypes) must be substitutable for their base classes without altering the correctness of the program. In Java, this ensures that when you use a subclass, it should behave in a way that is consistent with the superclass. This principle is crucial for ensuring the polymorphic behavior of objects in inheritance hierarchies.

```java
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Program {
    static void DrawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();

        DrawShape(shape1); // Outputs: Drawing a circle
        DrawShape(shape2); // Outputs: Drawing a square
    }
}
```


5. **How does the Interface Segregation Principle (ISP) improve design in Java?**
    
    ISP suggests that clients should not be forced to depend on interfaces they do not use. In Java, this means that interfaces should be tailored to specific client needs rather than having a single large interface. This improves code maintainability and avoids unnecessary dependencies.

```java
 // Bad example violating ISP   
interface Worker {
    void work();
    void eat();
}

class Engineer implements Worker {
    public void work() {
    // Engineer working       
    }

    public void eat() {
    // Engineer eating       
    }
}
```
It's better to have separate interfaces like Workable and Eatable to adhere to ISP.

6. **Explain how the Dependency Inversion Principle promotes flexibility in Java.**
   
    DIP states that high-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions. In Java, this is often achieved through the use of interfaces and dependency injection. It promotes flexibility by allowing you to change implementations without affecting high-level modules.

```java
// High-level module   
class ReportGenerator {
    private DataSource dataSource;

    public ReportGenerator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String generateReport() {
        // Generate report using dataSource       
    }
}

// Low-level module   
interface DataSource {
    String getData();
}

class DatabaseDataSource implements DataSource {
    public String getData() {
// Get data from the database       
    }
}

class FileDataSource implements DataSource {

    public String getData() {
// Read data from a file       
    }
}
``` 
With DIP and dependency injection, you can easily switch between DatabaseDataSource and FileDataSource without changing the ReportGenerator class, promoting flexibility and maintainability.

