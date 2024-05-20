# Dependency Inversion Principle(DIP)

The DIP covers two important things:

- A high-level concrete class should not depend on a low-level
  concrete class. Instead, both should depend on abstractions.
- Abstractions should not depend upon details. Instead, the details
  should depend upon abstractions.

The reason for the **first point** is simple. If the low-level class changes, the high-level
class needs to adjust to the change; otherwise, the application breaks. What does this
mean? It means you should avoid creating a concrete low-level class inside a high-level
class. Instead, you should use abstract classes or interfaces. As a result, you remove the
tight coupling between the classes.

The **second point** is also easy to understand when you analyze the case study
discussed in the ISP section. You saw that if an interface needs to change to support one
of its clients, other clients can be impacted due to the change. No client likes to see such
an application.

---
In his book Agile Principles, Patterns and Practices in C#, Robert C. Martin explains
that a traditional software development model in those days (such as structured
analysis and design) tends to create software where high-level modules used
to depend on low-level modules. But in OOP, a well-designed program opposes
this idea. It inverts the dependency structure that often results from a traditional
procedural method. This is the reason he used the word “inversion” in this
principle.
---

## Initial Program