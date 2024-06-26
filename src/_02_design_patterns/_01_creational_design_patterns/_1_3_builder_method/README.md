# Builder Method Pattern

<!-- TOC -->
* [Builder Method Pattern](#builder-method-pattern)
  * [GoF Definition](#gof-definition)
  * [Concept](#concept)
  * [Components of the Builder Design Pattern](#components-of-the-builder-design-pattern)
  * [Builder Design Pattern Example](#builder-design-pattern-example)
  * [Implementation](#implementation)
<!-- TOC -->

The Builder Design Pattern is a creational pattern used in software design to construct a complex object step by step. It allows the construction of a product in a step-by-step fashion, where the construction process can vary based on the type of product being built. The pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

![img](/src/resources/img/creational/builder/builder-method-img.png)

## GoF Definition

It separates the construction of a complex object from its representation so that the same
construction processes can create different representations.

## Concept

The Builder pattern is useful for creating complex objects that have multiple parts.
The object creation process should be independent of these parts. In addition, you
should be able to use the same construction process to create different representations
of the objects. This pattern is one of those design patterns that are relatively tough to
understand on the very first attempt. Once you see the code and analyze the structure,
they become easy.

## Components of the Builder Design Pattern

1. **Product** 

The Product is the complex object that the Builder pattern is responsible for constructing.
- It may consist of multiple components or parts, and its structure can vary based on the implementation.
- The Product is typically a class with attributes representing the different parts that the Builder constructs.

2. **Builder**

    The Builder is an interface or an abstract class that declares the construction steps for building a complex object.
   - It typically includes methods for constructing individual parts of the product.
   - By defining an interface, the Builder allows for the creation of different concrete builders that can produce variations of the product.

3. **ConcreteBuilder**

   ConcreteBuilder classes implement the Builder interface, providing specific implementations for building each part of the product.

   - Each ConcreteBuilder is tailored to create a specific variation of the product.
   - It keeps track of the product being constructed and provides methods for setting or constructing each part.

4. **Director**
   
    The Director is responsible for managing the construction process of the complex object.

   - It collaborates with a Builder, but it doesn’t know the specific details about how each part of the object is constructed.
   - It provides a high-level interface for constructing the product and managing the steps needed to create the complex object.
   
5. **Client**
   
    The Client is the code that initiates the construction of the complex object.

   - It creates a Builder object and passes it to the Director to initiate the construction process.
   - The Client may retrieve the final product from the Builder after construction is complete.

## Builder Design Pattern Example

**Problem Statement:**

> You are tasked with implementing a system for building custom computers. Each computer can have different configurations based on user preferences. The goal is to provide flexibility in creating computers with varying CPUs, RAM, and storage options.

Implement the Builder design pattern to achieve this, allowing the construction of computers through a step-by-step process. Use the provided components – Product (Computer), Builder interface, ConcreteBuilder (GamingComputerBuilder), Director, and Client

![img](/src/resources/img/creational/builder/builder-diagram-example.png)

**Code:**

```java
// Product
public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    // Setters for setting the configuration details
    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    // Method to display the configuration of the computer
    public void displayInfo() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
}

// Builder interface
public interface Builder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}

// ConcreteBuilder for Gaming Computer
public class GamingComputerBuilder implements Builder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Gaming CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// ConcreteBuilder for Office Computer
public class OfficeComputerBuilder implements Builder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Office CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("8GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// Director
public class ComputerDirector {
    // The construct method takes a Builder object and calls its methods
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        // Using the GamingComputerBuilder to create a gaming computer
        Builder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();

        // Using the OfficeComputerBuilder to create an office computer
        Builder officeBuilder = new OfficeComputerBuilder();
        director.construct(officeBuilder);
        Computer officeComputer = officeBuilder.getResult();
        officeComputer.displayInfo();
    }
}
```

## Implementation

In demonstration 1, Builder is used for the Builder interface and CarBuilder and
MotorCycleBuilder are two ConcreteBuilders. Car and MotorCycle are the concrete
products. The Director class has its usual meaning: it instructs a builder to make a
product. In demonstration 1, CarDirector and MotorCycleDirector are the concrete
directors that inherit from the abstract class Director.

### Class Diagram