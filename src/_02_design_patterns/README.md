# Design Patterns

<!-- TOC -->
* [Design Patterns](#design-patterns)
  * [What are Design Patterns?](#what-are-design-patterns)
  * [Types of Software Design Patterns](#types-of-software-design-patterns)
  * [1. Creational Design Patterns](#1-creational-design-patterns)
    * [1.1 Factory Method](#11-factory-method)
    * [1.2 Abstract Factory Method](#12-abstract-factory-method)
    * [1.3 Builder Method](#13-builder-method)
    * [1.4 Prototype Method](#14-prototype-method)
    * [1.5 Singleton Method](#15-singleton-method)
  * [2. Structural Design Patterns in Java](#2-structural-design-patterns-in-java)
    * [2.1 Adapter Method](#21-adapter-method)
    * [2.2 Bridge Method](#22-bridge-method)
    * [2.3 Composite Method](#23-composite-method)
    * [2.4 Decorator Method](#24-decorator-method)
    * [2.5 Facade Method](#25-facade-method)
    * [2.6 Proxy Method](#26-proxy-method)
    * [2.7 Flyweight Method](#27-flyweight-method)
  * [3. Behavioral Design Patterns in Java](#3-behavioral-design-patterns-in-java)
    * [3.1 Chain of Responsibility Design Pattern](#31-chain-of-responsibility-design-pattern)
    * [3.2 Command Method](#32-command-method)
    * [3.3 Iterator Method](#33-iterator-method)
    * [3.4 Mediator Method](#34-mediator-method)
    * [3.5 Memento Method](#35-memento-method)
    * [3.6 Observer method](#36-observer-method)
    * [3.7 State Method](#37-state-method)
    * [3.8 Strategy Method](#38-strategy-method)
    * [3.9 Template Method](#39-template-method)
    * [3.10 Visitor Method](#310-visitor-method)
    * [3.11 Null Object Method](#311-null-object-method)
<!-- TOC -->

Software design patterns are communicating objects and classes that are customized to solve a general design problem in a particular context. Software design patterns are general, reusable solutions to common problems that arise during the design and development of software. They represent best practices for solving certain types of problems and provide a way for developers to communicate about effective design solutions.

## What are Design Patterns?

A design pattern is a generic repeatable solution to a frequently occurring problem in software design that is used in software engineering. It isn’t a complete design that can be written in code right away. It is a description or model for problem-solving that may be applied in a variety of contexts.

## Types of Software Design Patterns

There are three types of Design Patterns:

1. Creational Design Pattern
2. Structural Design Pattern
3. Behavioral Design Pattern

## 1. Creational Design Patterns
   Creational design patterns are a subset of design patterns in software development. They deal with the process of object **creation**, trying to make it more flexible and efficient. It makes the system **independent** and how its objects are created, composed, and represented.

**Types of Creational Design Patterns in Java:**

### [1.1 Factory Method](_01_creational_design_patterns/_1_1_factory_method/README.md)
Factory Method is a creational design pattern, that provide an interface for creating objects in superclass, but subclasses are responsible to create the instance of the class.

### 1.2 Abstract Factory Method
Abstract Factory Method is a creational design pattern, it provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### 1.3 Builder Method
Builder Method is a creational design pattern, it provides an interface for constructing an object and then have concrete builder classes that implement this interface to create specific objects in a stepwise manner.

### 1.4 Prototype Method
Prototype Method is a creational design pattern, it provide to create new objects with the same structure and initial state as an existing object without explicitly specifying their class or construction details.

### 1.5 Singleton Method
Singleton Method is a creational design pattern, it provide a class has only one instance, and that instance provides a global point of access to it.

## 2. Structural Design Patterns in Java
   Structural design patterns are a subset of design patterns in software development that focus on the composition of classes or objects to form larger, more complex structures. They help in organizing and managing relationships between objects to achieve greater flexibility, reusability, and maintainability in a software system.

**Types of Structural Design Patterns in Java:**

### 2.1 Adapter Method
Adapter Method is a structural design pattern, it allows you to make two incompatible interfaces work together by creating a bridge between them.

### 2.2 Bridge Method
Bridge Method is a structural design pattern,it provide to design separate an object’s abstraction from its implementation so that the two can vary independently.

### 2.3 Composite Method
Composite Method is structural design pattern, it’s used to compose objects into tree structures to represent part-whole hierarchies. This pattern treats both individual objects and compositions of objects it allow clients to work with complex structures of objects as if they were individual objects.

### 2.4 Decorator Method
Decorator Method is structural design pattern, it allows to add behavior to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

### 2.5 Facade Method
Facade Method is a structural design pattern, it provides a simplified, higher-level interface to a set of interfaces in a subsystem, making it easier for clients to interact with that subsystem.

### 2.6 Proxy Method
Proxy Method is a structural design pattern, it provide to create a substitute for an object, which can act as an intermediary or control access to the real object.

### 2.7 Flyweight Method
Flyweight Method is a structural design pattern, it is used when we need to create a lot of objects of a class. Since every object consumes memory space that can be crucial for low memory devices, flyweight design pattern can be applied to reduce the load on memory by sharing objects.

## 3. Behavioral Design Patterns in Java
   Behavioral design patterns are a subsetof design patterns in software development that deal with the communication and interaction between objects and classes. They focus on how objects and classes collaborate and communicate to accomplish tasks and responsibilities.

**Types of Behavioral Design Pattern in Java:**

### 3.1 Chain of Responsibility Design Pattern
The Chain of Responsibility design pattern is a behavioral design pattern that allows an object to pass a request along a chain of handlers. Each handler in the chain decides either to process the request or to pass it along the chain to the next handler.

### 3.2 Command Method
Command Method is a Behavioral Design Pattern, it promotes loose coupling between the sender (client) and the receiver (the object that performs the operation) and provides a way to support undoable operations.

### 3.3 Iterator Method
Iterator Method is a Behavioral Design Pattern, it provides a way to access elements of an aggregate object (a collection) sequentially without exposing the underlying representation of that collection.

### 3.4 Mediator Method
Mediator Method is a Behavioral Design Pattern, it promotes loose coupling between objects by centralizing their communication through a mediator object. Instead of objects directly communicating with each other, they communicate through the mediator, which encapsulates the interaction and coordination logic.

### 3.5 Memento Method
Momento Method is a Behavioral Design Pattern, it provide to save and restore the previous state of an object without revealing the details of its implementation.

### 3.6 Observer method
Observer Method is a Behavioral Design Pattern, it defines a one-to-many dependency between objects, so that when one object (the subject) changes state, all its dependents (observers) are notified and updated automatically.

### 3.7 State Method
State Method is a Behavioral Design Pattern, it allows an object to alter its behavior when its internal state changes.

### 3.8 Strategy Method
Strategy Method is a Behavioral Design Pattern, it defines a family of algorithms, encapsulates each one, and makes them interchangeable and it allows a client to choose an appropriate algorithm from a family of algorithms at runtime.

### 3.9 Template Method
Template Method is a Behavioral Design Pattern, it defines the skeleton of an algorithm in a method but lets subclasses alter some steps of that algorithm without changing its structure.

### 3.10 Visitor Method
Visitor Method is a Behavioral Design Pattern, it is used when you have a set of structured, hierarchical objects and you want to perform various operations on these objects without modifying their classes.

### 3.11 Null Object Method
Null Object Method is a Behavioral Design Pattern, it is used to handle the absence of a valid object by providing an object that does nothing or provides default behavior.