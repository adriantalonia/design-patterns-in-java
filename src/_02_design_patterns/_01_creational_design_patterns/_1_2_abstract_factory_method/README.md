# Abstract Factory Method

<!-- TOC -->
* [Abstract Factory Method](#abstract-factory-method)
  * [GoF Definition](#gof-definition)
  * [Concept](#concept)
  * [What is the Abstract Factory Pattern?](#what-is-the-abstract-factory-pattern)
  * [Components of Abstract Factory Pattern](#components-of-abstract-factory-pattern)
    * [Structure](#structure)
  * [Abstract Factory example (CarFactory)](#abstract-factory-example-carfactory)
    * [What can be the challenges while implementing this system?](#what-can-be-the-challenges-while-implementing-this-system)
    * [How Abstracy Factory Pattern help to solve above challenges?](#how-abstracy-factory-pattern-help-to-solve-above-challenges)
    * [Example Diagram](#example-diagram)
    * [Code](#code)
  * [Abstract Factory example (FurnitureFactory)](#abstract-factory-example-furniturefactory)
    * [Explanation of the Code](#explanation-of-the-code)
    * [Diagram](#diagram)
    * [Code](#code-1)
  * [Advantages of using Abstract Factory Pattern](#advantages-of-using-abstract-factory-pattern)
  * [Disadvantages of using Abstract Factory Pattern](#disadvantages-of-using-abstract-factory-pattern)
  * [When to use Abstract Factory Pattern](#when-to-use-abstract-factory-pattern)
  * [When not to use Abstract Factory Pattern](#when-not-to-use-abstract-factory-pattern)
<!-- TOC -->

The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes, in simpler terms the Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other.

## GoF Definition
> It provides an interface for creating families of related or dependent objects without
specifying their concrete classes.

## Concept
An abstract factory is often referred to as a factory of factories. In this pattern, you provide
a way to encapsulate a group of individual factories that have a common theme. In this
process, you do not instantiate a class directly; instead, you instantiate a concrete factory
and thereafter create products using the factory.

## What is the Abstract Factory Pattern?
The Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other. It provides a set of rules or instructions that let you create different types of things without knowing exactly what those things are. This helps you keep everything organized and lets you switch between different types easily, following the same set of rules.

- Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over factory pattern.
- Abstract Factory patterns work around a super-factory which creates other factories.
- Abstract factory pattern implementation provides us with a framework that allows us to create objects that follow a general pattern.
- So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.

## Components of Abstract Factory Pattern

1. **Abstract Factory**

   Abstract Factory serves as a high-level blueprint that defines a set of rules for creating families of related objects without specifying their concrete classes. It declares a series of methods, each responsible for creating a particular type of object and ensures that concrete factories adhere to a common interface, providing a consistent way to produce related sets of objects.

2. **Concrete Factories**

   Concrete Factories implement the rules specified by the abstract factory. It contain the logic for creating specific instances of objects within a family. Also multiple concrete factories can exist, each tailored to produce a distinct family of related objects.

3. **Abstract Products**

   Abstract Products represents a family of related objects by defining a set of common methods or properties. It acts as an abstract or interface type that all concrete products within a family must adhere to and provides a unified way for concrete products to be used interchangeably.

4. **Concrete Products**

   They are the actual instances of objects created by concrete factories. They implement the methods declared in the abstract products, ensuring consistency within a family and belong to a specific category or family of related objects.

5. **Client**

   Client utilizes the abstract factory to create families of objects without specifying their concrete types and interacts with objects through abstract interfaces provided by abstract products. Client enjoys the flexibility of seamlessly switching between families of objects by changing the concrete factory instance.

### Structure
![img](/src/resources/img/creational/abstract_factory/abstract-factory-structure-diagram.png)

## Abstract Factory example (CarFactory)

> Imagine you’re managing a global car manufacturing company. You want to design a system to create cars with specific configurations for different regions, such as North America and Europe. Each region may have unique requirements and regulations, and you want to ensure that cars produced for each region meet those standards.

### What can be the challenges while implementing this system?
- One challenge can be designing cars with specific features and configurations for different regions.
- The other main challenge is to ensure consistency in the production of cars and their specifications within each region.
- Adapting the system to changes in regulations or introducing new features for a specific region becomes challenging. Modifications would need to be made in multiple places, increasing the chances of introducing bugs and making the system more prone to errors.

### How Abstracy Factory Pattern help to solve above challenges?
- The abstract factory ensures that each region has its concrete factory, responsible for creating cars and specifications consistent with the local market requirements. This promotes consistency in the design and features of the vehicles produced for each region.
- Each concrete factory encapsulates the logic for creating cars and specifications specific to a region. This isolation allows you to make changes or introduce new features for a particular region without affecting the rest of the system. For example, if regulations change in North America, you can modify the NorthAmericaCarFactory without impacting the EuropeCarFactor.
- Adding support for a new region involves creating a new concrete factory for that region. This expansion can be done without modifying existing code, providing a scalable and modular solution.
- The pattern promotes a clear separation between the creation of products (cars and specifications) and their actual use.

### Example Diagram

![img](/src/resources/img/creational/abstract_factory/abstract-factory-structure-diagram-example.png)

### Code

```java
// Abstract Factory Interface
interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}

// Concrete Factory for North America Cars
class NorthAmericaCarFactory implements CarFactory {
    public Car createCar() {
        return new Sedan();
    }

    public CarSpecification createSpecification() {
        return new NorthAmericaSpecification();
    }
}

// Concrete Factory for Europe Cars
class EuropeCarFactory implements CarFactory {
    public Car createCar() {
        return new Hatchback();
    }

    public CarSpecification createSpecification() {
        return new EuropeSpecification();
    }
}
```

```java
// Abstract Product Interface for Cars
interface Car {
    void assemble();
}
 
// Abstract Product Interface for Car Specifications
interface CarSpecification {
    void display();
}

// Concrete Product for Sedan Car
class Sedan implements Car {
    public void assemble() {
        System.out.println("Assembling Sedan car.");
    }
}

// Concrete Product for Hatchback Car
class Hatchback implements Car {
    public void assemble() {
        System.out.println("Assembling Hatchback car.");
    }
}

// Concrete Product for North America Car Specification
class NorthAmericaSpecification implements CarSpecification {
    public void display() {
        System.out.println("North America Car Specification: Safety features compliant with local regulations.");
    }
}

// Concrete Product for Europe Car Specification
class EuropeSpecification implements CarSpecification {
    public void display() {
        System.out.println("Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.");
    }
}
```

```java
// Client Code
public class CarFactoryClient {
    public static void main(String[] args) {
        // Creating cars for North America
        CarFactory northAmericaFactory = new NorthAmericaCarFactory();
        Car northAmericaCar = northAmericaFactory.createCar();
        CarSpecification northAmericaSpec = northAmericaFactory.createSpecification();
 
        northAmericaCar.assemble();
        northAmericaSpec.display();
 
        // Creating cars for Europe
        CarFactory europeFactory = new EuropeCarFactory();
        Car europeCar = europeFactory.createCar();
        CarSpecification europeSpec = europeFactory.createSpecification();
 
        europeCar.assemble();
        europeSpec.display();
    }
}
```

**Output:**
```
Assembling Sedan car.
North America Car Specification: Safety features compliant with local regulations.
Assembling Hatchback car.
Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.
```

## Abstract Factory example (FurnitureFactory)

### Explanation of the Code

1. **Abstract Products (Chair and Table):** These are interfaces defining the types of products that can be created (e.g., Chair and Table). Each interface has methods relevant to the product (e.g., sitOn for chairs and use for tables).

2. **Concrete Products (VictorianChair, ModernChair, VictorianTable, ModernTable):** These are the specific implementations of the products. Each product implements the corresponding interface and provides the specific behavior.

3. **Abstract Factory (FurnitureFactory):** This interface declares methods for creating abstract products. It has methods createChair and createTable to create chairs and tables, respectively.

4. **Concrete Factories (VictorianFurnitureFactory, ModernFurnitureFactory):** These classes implement the FurnitureFactory interface. Each concrete factory is responsible for creating a specific set of related products. For example, VictorianFurnitureFactory creates Victorian-style chairs and tables.

5. **Client:** The client uses a furniture factory to create and use a family of related products. The client does not know the concrete classes of the products; it only interacts with the interfaces provided by the abstract products and factories.
6. This implementation ensures that the client code is independent of the specific types of products created, adhering to the principle of programming to an interface, not an implementation. This makes the system more flexible and easier to extend with new types of products and factories.

### Diagram

```
               +--------------------+
               |   FurnitureFactory |
               +--------------------+
               | +createChair()     |
               | +createTable()     |
               +--------------------+
                        ^
                        |
       +----------------+----------------+
       |                                 |
+-----------------------+       +----------------------+
| VictorianFurnitureFactory |   | ModernFurnitureFactory |
+-----------------------+       +----------------------+
| +createChair()        |       | +createChair()       |
| +createTable()        |       | +createTable()       |
+-----------------------+       +----------------------+
        ^                                ^
        |                                |
+---------------+                +---------------+
| VictorianChair |               | ModernChair    |
+---------------+                +---------------+
| +sitOn()      |                | +sitOn()       |
+---------------+                +---------------+
        ^
        |
+---------------+                +---------------+
| VictorianTable |               | ModernTable    |
+---------------+                +---------------+
| +use()        |                | +use()         |
+---------------+                +---------------+
```

### Code

```java
// Abstract Product A
public interface Chair {
    void sitOn(); // Method to sit on the chair
}

// Abstract Product B
public interface Table {
    void use(); // Method to use the table
}
```

```java
// Concrete Product A1 - Victorian style chair
public class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian Chair");
    }
}

// Concrete Product A2 - Modern style chair
public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern Chair");
    }
}

// Concrete Product B1 - Victorian style table
public class VictorianTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a Victorian Table");
    }
}

// Concrete Product B2 - Modern style table
public class ModernTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a Modern Table");
    }
}

```

```java
// Abstract Factory interface that declares creation methods for each type of product
public interface FurnitureFactory {
    Chair createChair(); // Method to create a chair
    Table createTable(); // Method to create a table
}
```

```java
// Concrete Factory 1 - Creates Victorian style furniture
public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair(); // Creates a Victorian style chair
    }

    @Override
    public Table createTable() {
        return new VictorianTable(); // Creates a Victorian style table
    }
}

// Concrete Factory 2 - Creates Modern style furniture
public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair(); // Creates a Modern style chair
    }

    @Override
    public Table createTable() {
        return new ModernTable(); // Creates a Modern style table
    }
}
```

```java
public class Client {
    private Chair chair;
    private Table table;

    // Client uses a FurnitureFactory to create specific types of furniture
    public Client(FurnitureFactory factory) {
        chair = factory.createChair(); // Create a chair
        table = factory.createTable(); // Create a table
    }

    // Use the created furniture
    public void useFurniture() {
        chair.sitOn(); // Use the chair
        table.use(); // Use the table
    }

    public static void main(String[] args) {
        // Create a Victorian furniture factory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        // Create a client with Victorian furniture
        Client victorianClient = new Client(victorianFactory);
        victorianClient.useFurniture(); // Use the Victorian furniture

        // Create a Modern furniture factory
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        // Create a client with Modern furniture
        Client modernClient = new Client(modernFactory);
        modernClient.useFurniture(); // Use the Modern furniture
    }
}
```

**Output:**
```
Sitting on a Victorian Chair
Using a Victorian Table
Sitting on a Modern Chair
Using a Modern Table
```

## Advantages of using Abstract Factory Pattern
This pattern is particularly useful when the client doesn’t know exactly what type to create.

- **Isolation of concrete classes:**
  - The Abstract Factory pattern helps you control the classes of objects that an application creates.
  - Because a factory encapsulates the responsibility and the process of creating product objects, it isolates clients from implementation classes.
  - Clients manipulate instances through their abstract interfaces. Product class names are isolated in the implementation of the concrete factory; they do not appear in client code.
- **Exchanging Product Families easily:**
  - The class of a concrete factory appears only once in an application, that is where it’s instantiated.
  - This makes it easy to change the concrete factory an application uses.
  - It can use various product configurations simply by changing the concrete factory.
  - Because an abstract factory creates a complete family of products, the whole product family changes at once.
- **Promoting consistency among products:**
  - When product objects in a family are designed to work together, it’s important that an application use objects from only one family at a time. AbstractFactory makes this easy to enforce.

## Disadvantages of using Abstract Factory Pattern
- **Complexity:**
  - Abstract Factory can introduce additional complexity to the codebase.
  - Having multiple factories and abstract product interfaces may be overkill for simpler projects.
- **Rigidity with New Product Types:**
  - Adding new product types (classes) to the system can be challenging.
  - You might need to modify not just the concrete factories but also the abstract factory interface, potentially impacting existing code.
- **Increased Number of Classes:**
  - As you introduce more abstract factories and product families, the number of classes in your system can grow rapidly.
  - This can make the code harder to manage and understand, particularly for smaller projects.
- **Dependency Inversion Principle Violation:**
  - In some cases, the Abstract Factory pattern may lead to a violation of the Dependency Inversion Principle, especially if client code directly depends on concrete factory implementations rather than the abstract interfaces.
- **Limited Extensibility:**
  - Extending the abstract factory hierarchy or introducing new product families might require modifications to multiple parts of the code, potentially leading to cascading changes and making the system less extensible.
- **Not Ideal for Simple Systems:**
  - The Abstract Factory pattern may be overkill for  smaller, less complex systems where the overhead of defining abstract factories and products outweighs the benefits of the pattern.

## When to use Abstract Factory Pattern
- **Multiple families of related products:** When your system needs to be configured with multiple families of related products, and you want to ensure that the products from one family are compatible with the products from another family.
- **Flexibility and extensibility:** If you need to allow for variations or extensions in the products or their families, the Abstract Factory pattern provides a way to introduce new product variants without modifying existing client code.
- **Encapsulation of creation logic:** The pattern encapsulates the creation of objects, making it easier to change or extend the creation process without affecting the client code.
- **Consistency across product families:** If you want to enforce consistency among the products created by different factories, the Abstract Factory pattern can help maintain a uniform interface.

## When not to use Abstract Factory Pattern
- **The product families are not likely to change:** If the products and their families are unlikely to change or be extended, using the Abstract Factory pattern might introduce unnecessary complexity.
- **Not dealing with multiple families of objects:** If your application is not concerned with creating families of related objects and you are dealing with single, independent objects, using the Abstract Factory pattern may be overkill.
- **The overhead is too high:** In some cases, the overhead of creating and maintaining multiple factories may outweigh the benefits, especially in smaller applications or when there is no need for extensive configurability.
- **A simpler solution is sufficient:** If a simpler creational pattern, such as the Factory Method or Builder pattern, meets your requirements, there may be no need to introduce the additional complexity of the Abstract Factory pattern.

## Common Interview Questions on Abstract Factory Pattern

**1. What is the Abstract Factory pattern?**

The Abstract Factory pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**2. When would you use the Abstract Factory pattern?**

Use the Abstract Factory pattern when you need to create a set of related objects that must be used together and when you want to ensure that the created objects are compatible.

**3. How does the Abstract Factory pattern differ from the Factory Method pattern?**

The Factory Method pattern is used to create a single product, whereas the Abstract Factory pattern is used to create families of related or dependent products.

**4. Can you give an example of where the Abstract Factory pattern might be used in real-world applications?**

The Abstract Factory pattern is often used in GUI toolkits (like Java's Swing or AWT) where you might have different look-and-feel themes. Each theme would be a factory that creates a set of widgets (buttons, text fields, etc.) consistent with that theme.

**5. What are the benefits of using the Abstract Factory pattern?**

- The benefits include:
  - Ensuring consistency among products created by the factory.
  - Encapsulating the creation logic of a set of related products.
  - Making it easy to swap between different families of products by changing the factory.

**6. What are the drawbacks of using the Abstract Factory pattern?**
- The drawbacks include:
  - The complexity of adding new products to the factory, which might require changes to the factory interface and all concrete factories.
  - The pattern can lead to a proliferation of classes, making the codebase harder to maintain.

**7. How would you implement the Abstract Factory pattern if you had to support adding new products in the future?**
- To support adding new products, you could use the Abstract Factory pattern in combination with the Prototype pattern. This allows new products to be added without changing the factory interface, as the factory would clone prototype instances rather than create new ones directly.

**8. Is the Abstract Factory pattern a good choice for building a simple application? Why or why not?**

For simple applications, the Abstract Factory pattern might be overkill. It adds unnecessary complexity if the application doesn't require the flexibility of creating families of related objects or if the number of products is very small and unlikely to change.