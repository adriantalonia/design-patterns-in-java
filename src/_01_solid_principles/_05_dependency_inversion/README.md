# Dependency Inversion Principle(DIP)

<!-- TOC -->
* [Dependency Inversion Principle(DIP)](#dependency-inversion-principledip)
  * [Initial Program](#initial-program)
    * [Analysis](#analysis)
  * [Better Program](#better-program)
    * [Analysis](#analysis-1)
<!-- TOC -->

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

Assume that you have a two-layer application. Using this application, a user can save an
employee ID in a database. To demonstrate this, let’s use a console application instead of
a GUI application. You have two classes, UserInterface and OracleDatabase. As per its
name, UserInterface represents a user interface such as a form where a user can type
an employee ID and click the Save button to save the ID in a database. OracleDatabase
is used to mimic an Oracle database. Again, for simplicity, there is no actual database in
this application and there is no code to validate an employee ID. Here your focus is on
the DIP only, so those discussions are not important.

By using the **saveEmployeeId**() method of UserInterface, you can save an
employee id to a database. Notice the code for the UserInterface class:

```java
class UserInterface {
    private OracleDatabase oracleDatabase;
    
    public UserInterface() {
        this.oracleDatabase = new OracleDatabase();
    }
    
    public void saveEmployee(String empId) {
        // Assuming that this is a valida data
        // so, storing it in the database
      oracleDatabase.saveEmpInDatabase(empId);
    }
}
```

You instantiate an OracleDatabase object inside the UserInterface constructor.
Later you use this object to invoke the saveEmpIdInDatabase() method, which does the
actual saving inside the Oracle database. This style of coding is very common. But there
are some problems. I’ll discuss them in the analysis section before we look at a better
approach. For now, see the complete program, which does not follow the DIP.

**Code:**
```java
public class UserInterface {
  private OracleDatabase oracleDatabase;
  public UserInterface() {
    this.oracleDatabase = new OracleDatabase();
  }

  public void saveEmployee(String empId) {
    // Assuming that this is a valida data
    // so, storing it in the database
    oracleDatabase.saveEmpInDatabase(empId);
  }
}

public class OracleDatabase {
  public void saveEmpIdInDatabase(String empId) {
    System.out.println("The id: " + empId + " was saved in Oracle database");

  }
}

public class Client {
  public static void main(String[] args) {
    System.out.println("***A demo without DIP***");
    UserInterface userInterface = new UserInterface();
    userInterface.saveEmployee("E001");
  }
}
```

**Output:**
```
***A demo without DIP***
The id: E001 was saved in Oracle database
```

### Analysis
The program is simple, but it suffers from the following issues:

- The top-level class (**UserInterface**) has too much dependency on the
bottom-level class (**OracleDatabase**). These two classes are tightly coupled.
So, in the future, if the OracleDatabase class changes (for example, when
you change the signature of the **saveEmpIdInDatabase**(...) method), you
need to adjust the UserInterface class.
- The low-level class should be available before you write the top-level
class. So, you are forced to complete the low-level class before you write
or test the high-level class.
- **What if you use a different database?** For example, you may want to
switch from the Oracle database to a MySQL database or you may need
to support both.

## Better Program

```java
public interface Database {
    void saveEmpIdInDatabase(String empId);
}

public class OracleDatabaseIDP implements Database {
  @Override
  public void saveEmpIdInDatabase(String empId) {
    System.out.println("The id: " + empId + " is saved in the Oracle database.");
  }
}

public class MySQLDatabase implements Database {
  @Override
  public void saveEmpIdInDatabase(String empId) {
    System.out.println("The id: " + empId + " is saved in the MySQL database.");
  }
}

public class UserInterfaceIDP {
  Database database;

  public UserInterfaceIDP(Database database) {
    this.database = database;
  }

  public void saveEmployeeId(String empId) {
    database.saveEmpIdInDatabase(empId);
  }
}

public class ClientIDP {
  public static void main(String[] args) {
    System.out.println("***A demo with DIP***");
    // Using Oracle now
    Database database = new OracleDatabaseIDP();
    UserInterfaceIDP userInterfaceIDP = new UserInterfaceIDP(database);
    userInterfaceIDP.saveEmployeeId("E001");

    // Using MySQL
    database = new MySQLDatabase();
    userInterfaceIDP = new UserInterfaceIDP(database);
    userInterfaceIDP.saveEmployeeId("E002");
  }
}
```

**Code:**
```
A demo with DIP
The id: E001 is saved in the Oracle database.
The id: E002 is saved in the MySQL database.
```

### Analysis

You can see that this program resolves all the potential issues of the program in
the better program. In short, in OOP, I suggest following the Robert C. Martin quote:
> High-level modules simply should not depend on low-level modules in
any way.

So, when you have a base class and a derived class, your base class should not
know about any of its derived classes. But there are few exceptions to this suggestion.
For example, consider the case when your base class needs to restrict the count of the
derived class instances at a certain point.

One last point. You can see that in the better program, the UserInterface class
constructor accepts a database parameter. You can provide an additional facility to a
user when you use both the constructor and the setter method (setDatabase) inside this
class. Here is sample code for you. Notice the additional code in bold.

```java
public class UserInterfaceIDP {
  Database database;

  public UserInterfaceIDP(Database database) {
    this.database = database;
  }

  public void setDatabase(Database database) {
    this.database = database;
  }

  public void saveEmployeeId(String empId) {
    database.saveEmpIdInDatabase(empId);
  }
}
```

**What is the benefit?** Now you can instantiate a database while instantiating the
UserInterface class and change the target database later using the setter method. Here
is sample code. You can append the last part of this segment at the end of main() to see
new output.

```java
    // Using Oracle now
    Database database = new OracleDatabaseIDP();
    UserInterfaceIDP userInterfaceIDP = new UserInterfaceIDP(database);
    userInterfaceIDP.saveEmployeeId("E001");

    // Changing the target database
    userInterfaceIDP.setDatabase(new MySQLDatabase());
    userInterfaceIDP.saveEmployeeId("E002");
```

