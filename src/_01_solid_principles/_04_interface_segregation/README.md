# Interface Segregation Principle(ISP)

<!-- TOC -->
* [Interface Segregation Principle(ISP)](#interface-segregation-principleisp)
  * [Initial Program](#initial-program)
  * [Initial program without ISP](#initial-program-without-isp)
  * [Analysis](#analysis)
  * [Better Program](#better-program)
<!-- TOC -->

You often see a fat interface that contains many methods. A class that implements the
interface may not need all these methods. So why does the interface contain all these
methods? One possible answer is to support some of the implementing classes of this
interface. This is the area the Interface Segregation Principle focuses on. It suggests that
you don’t pollute an interface with these unnecessary methods only to support one (or
some) of the implementing classes of this interface. The idea is that **a client should not
depend on a method that it does not use.**

**POINTS TO REMEMBER**

Note the following points before you proceed further:

- A client means any class that uses another class (or interface).
- The word “Interface” of the Interface Segregation Principle is not limited to a
Java interface. The same concept applies to any supertype, such as an abstract
class or a simple parent class.
- Many examples across different sources explain the violation 
of the ISP with an emphasis on throwing an exception such as
UnsupportedOperationException() in Java. Demonstration 7 also
demonstrate such an example. It shows the disadvantages of an approach that
does not follow the ISP (and the LSP). You saw earlier that the LSP can deal
with this kind of problem. I mentioned this in the code analysis too.
- The ISP suggests that your class should not depend on interface methods that
it does not use. This statement will make sense to you when you go through the
following example and remember the previous points.

## Initial Program

Assume that you have the interface Printer with two methods, printDocument() and
sendFax(). There are several users of this class. For simplicity, let’s consider two of them
only: BasicPrinter and AdvancedPrinter.

```java
interface Printer {
    void printDocument();
    void sendFax();
}
```

```java
class BasicPrinter implements Printer {
    @Override
    void printDocument() {
        // do something
    }
    @Override
    void sendFax() {
        // do something
    }
}
```

```java
class AdvancedPrinter implements Printer {
    @Override
    void printDocument() {
        // do something
    }
    @Override
    void sendFax() {
        // do something
    }
}
```

A basic printer can print documents. It does not support any other functionality. So,
**BasicPrinter** needs the **printDocument()** method only. An advanced printer can print
documents as well as send faxes. So, the **AdvancedPrinter** needs both methods.
In this case, a change to the sendFax() method in AdvancedPrinter can force the
**interface Printer** to change, which in turn, forces the **BasicPrinter** code to recompile.

But **why does a user invite the problem in the first place? Or why does a user
need to change a base class (or, an interface)?** To answer this, assume that you want
to show which type of fax you are using in a later development phase. You know that
there are different variations of fax methods, such as _LanFax, InternetFax (or EFax), and
AnalogFax_. So, earlier, the **SendFax()** method did not use any parameters, but now it
needs to accept a parameter to show the type of fax it uses.
To demonstrate this further, suppose you have a fax hierarchy that may look like the
following.

```java
interface Fax {
    void faxType();
}

class LanFax implements Fax {
    @Override
    public void faxType() {
        System.out.println("Using lan fax to send the fax");
    }
}

class EFax implements Fax {
    @Override
    public void faxType() {
        System.out.println("Using internet fax(efax) to send the fax.");
    }
}
```

To use this inheritance hierarchy, once you modify the **sendFax**() method to
**sendFax(Fax faxType)** in the **AdvancedPrinter** class, it demands you change the
interface **Printer** (**yes, you break the OCP here too**). But it is not over yet! When you
update **Printer**, you need to update the **BasicPrinter** class too to accommodate this
change. **Now you see the problem!**

---
**Note:** 

You saw that a change in **AdvancedPrinter** causes changes in the
interface **Printer**, which in turn causes **BasicPrinter** to update its fax method.
So, you can see that though the **BasicPrinter** does not need this fax method at
all, still a change in **AdvancedPrinter** causes it to change and recompile. The
ISP suggests you take care of this kind of scenario.
---

## Initial program without ISP

**Code:**
```java
public interface Printer {
    void printDocument();
    void sendFax();
}

public class BasicPrinter implements Printer {
  @Override
  public void printDocument() {
    System.out.println("The basic printer prints a document.");
  }

  @Override
  public void sendFax() {
    throw new UnsupportedOperationException("Not supported");
  }
}

public class AdvancedPrinter implements Printer {
  @Override
  public void printDocument() {
    System.out.println("The advanced printer prints a document.");
  }

  @Override
  public void sendFax() {
    System.out.println("The advanced printer sends a fax.");
  }
}

public class Client {
  public static void main(String[] args) {
    System.out.println("*** A demo without ISP ***");
    Printer printer = new AdvancedPrinter();
    printer.printDocument();
    printer.sendFax();

    printer = new BasicPrinter();
    printer.printDocument();
    printer.sendFax(); // will throw error
  }
}
```

**Output:**
```
*** A demo without ISP ***
The advanced printer prints a document.
The advanced printer sends a fax.
The basic printer prints a document.
```

## Analysis

You can see that to prevent the runtime exceptions, I needed to comment out a line of
code. I kept this dead code for this discussion. You know that you should avoid this kind
of commented code because it can cause potential problems in the long run. Since no
one touches the commented code, there is a possibility that in the future lots of changes
will occur in the codebase and then this code will become irrelevant. So, when a new
developer reads the code, they will be clueless about it.

Most importantly, as said before, in this design, if you change the sendFax() method
signature in AdvancedPrinter, you need to adjust the change in Printer, which causes
BasicPrinter to change and recompile. I discussed this in detail.

 Think about the problem from another angle. Assume that you need to support
another printer that can print, fax, and photocopy. In this case, if you add a
photocopying method in the Printer interface, both the existing clients, BasicPrinter
and AdvancedPrinter, need to accommodate the change.

## Better Program

Let’s find a better solution. You understand that there are two different activities:
one is to print some documents and the other is to send a fax. So, in the upcoming
example, you create two interfaces named Printer and FaxDevice. Printer contains
the printDocument() method and FaxDevice contains the SendFax() method. The idea
is simple:

- The class that wants print functionality implements the Printer
interface, and the class that wants fax functionality implements the
FaxDevice interface.
- If a class wants both functionalities, it implements both interfaces.

---
You should not assume that the ISP says an interface should have only one
method. In this example, there are two methods in the Printer interface and the
BasicPrinter class needs only one of them. This is why you see the segregated
interfaces with a single method only.
---

**Code:**
```java
public interface PrintISP {
  void printDocument();
}

public interface FaxDevice {
    void sendFax();
}
```

```java
public class BasicPrinterISP implements PrinterISP {
    @Override
    public void printDocument() {
        System.out.println("The basic printer prints a document.");
    }
}

public class AdvancedPrinterISP implements PrinterISP, FaxDevice {
  @Override
  public void sendFax() {
    System.out.println("The advanced printer prints a document.");
  }

  @Override
  public void printDocument() {
    System.out.println("The advanced printer sends a fax.");
  }
}
```

```java
public class ClientISP {
    public static void main(String[] args) {
        System.out.println("***A demo that follows ISP.***");

        PrinterISP printer = new BasicPrinterISP();
        printer.printDocument();
        printer = new AdvancedPrinterISP();
        printer.printDocument();
        FaxDevice faxDevice = new AdvancedPrinterISP();
        faxDevice.sendFax();
    }
}
```

**Output:**
```
***A demo that follows ISP.***
The basic printer prints a document.
The advanced printer prints a document.
The advanced printer sends a fax.
```

