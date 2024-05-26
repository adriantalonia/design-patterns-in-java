# Factory Method

![img](/src/resources/img/creational/factory/factory-method.png)

<!-- TOC -->
* [Factory Method](#factory-method)
  * [Intent](#intent)
  * [GoF Definition](#gof-definition)
  * [What is the Factory Method Design Pattern in Java?](#what-is-the-factory-method-design-pattern-in-java)
  * [When to use Factory Method Design Pattern?](#when-to-use-factory-method-design-pattern)
  * [Applicability](#applicability)
  * [Components of Factory Method Design Pattern](#components-of-factory-method-design-pattern)
    * [Structure](#structure)
  * [Factory Method Design Pattern Example](#factory-method-design-pattern-example)
    * [Without Factory Method Design Pattern](#without-factory-method-design-pattern)
      * [What are the problems with the above design?](#what-are-the-problems-with-the-above-design)
      * [How do we avoid the problem?](#how-do-we-avoid-the-problem)
    * [With Factory Method Design Pattern](#with-factory-method-design-pattern)
<!-- TOC -->

It is a creational design pattern that talks about the creation of an object. The factory design pattern says to define an interface ( A java interface or an abstract class) for creating the object and let the subclasses decide which class to instantiate.
> Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Intent
> Define an interface for creating an object, but let subclasses decide which class to
instantiate. Factory Method lets a class defer instantiation to subclasses.

## GoF Definition
> It defines an interface for creating an object, but lets subclasses decide which class to
instantiate. The Factory Method pattern lets a class defer instantiation to subclasses.

## What is the Factory Method Design Pattern in Java?
> Factory Method Design Pattern define an interface for creating an object, but let subclass decide which class to instantiate. Factory Method lets a class defer instantiation to subclass.

This pattern enables flexibility, extensibility, and maintainability in the codebase by allowing subclasses to define their own implementation of the factory method to create specific types of objects.

## When to use Factory Method Design Pattern?
- **When you want to encapsulate object creation:** If you have a complex object creation process or if the process may vary based on conditions, encapsulating this logic in a factory method can simplify client code and promote reusability.
- **When you want to decouple client code from concrete classes:** sing the Factory Method Pattern allows you to create objects through an interface or abstract class, abstracting away the specific implementation details of the concrete classes from the client code. This promotes loose coupling and makes it easier to modify or extend the system without impacting existing client code.
- **When you need to support multiple product variations:** If your application needs to create different variations of a product or if new types of products may be introduced in the future, the Factory Method Pattern provides a flexible way to accommodate these variations by defining factory methods for each product type.
- **When you want to support customization or configuration:** Factories can be used to encapsulate configuration logic, allowing clients to customize the creation process by providing parameters or configuration options to the factory method.

## Applicability
Use the Factory Method pattern when
* a class can't anticipate the class of objects it must create.
* a class wants its subclasses to specify the objects it creates.
* classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

## Components of Factory Method Design Pattern

1. **Creator**

   This is an abstract class or an interface that declares the factory method. The creator typically contains a method that serves as a factory for creating objects. It may also contain other methods that work with the created objects.

2. **Concrete Creator**

   Concrete Creator classes are subclasses of the Creator that implement the factory method to create specific types of objects. Each Concrete Creator is responsible for creating a particular product(Concrete Product).

3. **Product**

   This is the interface or abstract class for the objects that the factory method creates. The Product defines the common interface for all objects that the factory method can create.

4. **Concrete Product**

   Concrete Product classes are the actual objects that the factory method creates. Each Concrete Product class implements the Product interface or extends the Product abstract class.

### Structure
![img](/src/resources/img/creational/factory/factory-method-structure.png)

## Factory Method Design Pattern Example

Below is the problem statement to understand Factory Method Design Pattern:

> Consider a software application that needs to handle the creation of various types of vehicles, such as Two Wheelers, Three Wheelers, and Four Wheelers. Each type of vehicle has its own specific properties and behaviors.

### Without Factory Method Design Pattern

```java
abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am four wheeler");
    }
}

// Client (or user) class
class Client {
    private Vehicle pVehicle;

    public Client(int type) {
        if (type == 1) {
            pVehicle = new TwoWheeler();
        } else if (type == 2) {
            pVehicle = new FourWheeler();
        } else {
            pVehicle = null;
        }
    }

    public void cleanup() {
        if (pVehicle != null) {
            pVehicle = null;
        }
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}

// Driver program
public class GFG {
    public static void main(String[] args) {
        Client pClient = new Client(1);
        Vehicle pVehicle = pClient.getVehicle();
        if (pVehicle != null) {
            pVehicle.printVehicle();
        }
        pClient.cleanup();
    }
}
```
**Output:**
```
I am two wheeler
```

#### What are the problems with the above design?
In the above code design:

- **Tight Coupling:** The client class Client directly instantiates the concrete classes (TwoWheeler and FourWheeler) based on the input type provided during its construction. This leads to tight coupling between the client and the concrete classes, making the code difficult to maintain and extend.
- **Violation of Single Responsibility Principle (SRP):** The Client class is responsible not only for determining which type of vehicle to instantiate based on the input type but also for managing the lifecycle of the vehicle object (e.g., cleanup). This violates the Single Responsibility Principle, which states that a class should have only one reason to change.
- **Limited Scalability:** Adding a new type of vehicle requires modifying the Client class, which violates the Open-Closed Principle. This design is not scalable because it cannot accommodate new types of vehicles without modifying existing code.

#### How do we avoid the problem?
- **Define Factory Interface:** Create a VehicleFactory interface or abstract class with a method for creating vehicles.
- **Implement Concrete Factories:** Implement concrete factory classes (TwoWheelerFactory and FourWheelerFactory) that implement the VehicleFactory interface and provide methods to create instances of specific types of vehicles.
- **Refactor Client:** Modify the Client class to accept a VehicleFactory instance instead of directly instantiating vehicles. The client will request a vehicle from the factory, eliminating the need for conditional logic based on vehicle types.
- **Enhanced Flexibility:** With this approach, adding new types of vehicles is as simple as creating a new factory class for the new vehicle type without modifying existing client code.

### With Factory Method Design Pattern

Let’s breakdown the code into component wise code:

![img](/src/resources/img/creational/factory/factory-method-structure-diagram.jpg)

```java
// Product interface representing a vehicle
public abstract class Vehicle {
    public abstract void printVehicle();
}

// Concrete product classes representing different types of vehicles
public class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

public class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am four wheeler");
    }
}
```

```java
// Factory interface defining the factory method
public interface VehicleFactory {
    Vehicle createVehicle();
}

// Concrete factory class for TwoWheeler
public class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

// Concrete factory class for FourWheeler
public class FourWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

```

```java
// Client class
class Client {
    private Vehicle pVehicle;

    public Client(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}

// Driver program
public class GFG {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();

```

**Output:**
```
I am two wheeler
I am four wheeler
```