# Liskov’s Substitution Principle (LSP)

<!-- TOC -->
* [Liskov’s Substitution Principle (LSP)](#liskovs-substitution-principle-lsp)
  * [Initial Program](#initial-program)
  * [Better Program](#better-program-)
    * [Analysis](#analysis)
<!-- TOC -->

The Liskov Substitution Principle was initially introduced from the work of Barbara
Liskov in 1988. The LSP says that:

> you should be able to substitute a parent (or base) type with a subtype.

It means that in a program segment, you can use a derived class instead of its base class without altering the correctness of the program.

How do you use inheritance? There is a base class and you create one (or more) derived classes from it. Then you can add new methods in the derived classes. 
As long as you directly use the derived class method with a derived class object, everything is fine.
A problem may occur if you try to get the polymorphic behavior without following the LSP.

**How?**
ssume that there are two classes in which B is the
base class and D is the subclass (of B). Furthermore, assume that there is a method that
accepts a reference of B as an argument, something like the following:


```java
public void someMethod(B b) {
    // Some code
}
```

This method works fine until you pass a B instance to it. But what happens if you pass a D instance instead of a B instance? Ideally, the program should not fail. It is
because you use the concept of polymorphism and you say D is basically a B type since class D inherits from class B. You can relate this scenario with a common example when
we say a soccer player is also a player, where we consider the “player” class is a supertype of “soccer player.”

Now see what the LSP suggests to us? It says that **someMethod**() should not misbehave/fail if you pass a D instance instead of a B instance to it. But it may happen
if you do not write your code following the LSP. The concept will be clearer to you when you go through the upcoming example.

**POINT TO NOTE**

In design patterns, you often see polymorphic code. Here is a common example. Suppose you
have the following code segment:

```java
class B {}
class D extends B {}
```

Now you can write B obB=new B(); for sure. But notice that in this case, you can also write
```java
B obB = new D(); // Also Ok
```

Similarly, you can use the **interfaces** as the **supertype**. For example, if you have
```java
interface B {}
class D implements B {}
```
you can write
```java
B obB = new D(); // Also Ok
```

Polymorphic code shows your expertise but remember that it’s your responsibility to
implement polymorphic behavior properly and avoid unwanted outcomes.

## Initial Program

Consider an example I see every month. I use an online payment portal to pay my
electricity bill. Since I am a registered user, when I raise a payment request in this portal,
it shows my previous payments too. Let’s consider a simplified example based on this
real-life scenario.

Assume that you also have a payment portal where a registered user can raise a
payment request. You use method newPayment() for this. In this portal, you can also
show the user’s last payment details using a method called previousPaymentInfo().

Furthermore, you create the helper class PaymentHelper to display all the
previous payments and the new payment requests of these users. You use
showPreviousPayments() and processNewPayments() for these activities. These
methods call previousPaymentInfo() and newPayment() on the respective Payment
instances. You use an enhanced for statement (it’s often referred to as an enhanced for
loop) to serve these purposes. Here is the PaymentHelper class for your instant reference.

**Code:**
```java
public interface Payment {
    void previousPaymentInfo();
    void newPayment();
}
```

```java
class RegisteredUserPayment implements Payment {
    String name;
}
```

```java
public class RegisteredUserPayment implements Payment {
    String name;
    public RegisteredUserPayment(String userName) {
        this.name = userName;
    }

    @Override
    public void previousPaymentInfo() {
        System.out.println("Retrieving " + name + "'s payment details");
        // some other code, if any
    }

    @Override
    public void newPayment() {
        System.out.println("Processing " + name + "'s current payment request");
        // some other code, if any
    }
}
```

```java
public class PaymentHelper {
    List<Payment> payments = new ArrayList<Payment>();
    
    public void addUser(Payment user) {
        payments.add(user);
    }
    
    public void showPreviousPayments () {
        for (Payment payment : payments) {
            payment.previousPaymentInfo();
            System.out.println("--------------");
        }
    }
    
    public void processNewPayment(Payment newPayment) {
        for (Payment payment : payments) {
            payment.newPayment();
            System.out.println("--------------");
        }
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        System.out.println("***A demo without LSP.***\n");
        PaymentHelper helper = new PaymentHelper();

        // Instantiating two registered users
        RegisteredUserPayment robinPayment = new RegisteredUserPayment("Robin");
        RegisteredUserPayment jackPayment = new RegisteredUserPayment("Jack");

        // Adding the users to the helper
        helper.addUser(robinPayment);
        helper.addUser(jackPayment);

        // Processing the payments using the helper class
        helper.showPreviousPayments();
        helper.processNewPayment();
    }
}
```

**Results:**
```
***A demo without LSP.***

Retrieving Robin's payment details
--------------
Retrieving Jack's payment details
--------------
Processing Robin's current payment request
--------------
Processing Jack's current payment request
--------------
```

This program seems to be fine. **Now assume that you have a new requirement
that says you need to support guest users in the future**. You can process a guest user’s
payment request, but you do not show their last payment detail. So, you create the
following class that implements the Payment interface as follows:

```java
class GestUserPayment implements Payment {
    String name;
    public GestUserPayment() {
        this.name = "guest";
    }

    @Override
    public void previousPaymentInfo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void newPayment() {
        System.out.println("Processing " + name + "'s current payment request");
        // some other code, if any
    }
}
```

Inside the main() method you create a guest user instance now and try to use your
helper class in the same manner. Here is the new client code (notice the changes in
bold). For your easy understanding, I added some comments to draw your attention to
the code that causes the problem now.

```java
public class Client {
    public static void main(String[] args) {
        System.out.println("***A demo without LSP.***\n");
        PaymentHelper helper = new PaymentHelper();

        // Instantiating two registered users
        RegisteredUserPayment robinPayment = new RegisteredUserPayment("Robin");
        RegisteredUserPayment jackPayment = new RegisteredUserPayment("Jack");

        // Adding the users to the helper
        helper.addUser(robinPayment);
        helper.addUser(jackPayment);

        GuestUserPayment guestUser = new GuestUserPayment();
        helper.addUser(guestUser);

        // Processing the payments using the helper class
        helper.showPreviousPayments();
        helper.processNewPayment();
    }
}
```
In every iteration, you call the method previousPaymentInfo()
on the respective Payment object and the exception is raised for the GuestUserPayment
instance. So, you now know how a working solution can fail when you add a new code
segment. What is the solution? You will find it in the next section.

## Better Program 

The first obvious solution that may come into your mind is to introduce an if-else chain to
verify whether the Payment instance is a GuestUserPayment or a RegisteredUserPayment.
However, this is not the best possible solution in the sense that if you have another special
type of user, you again verify it inside this if-else chain. **Most importantly, you violate the
OCP each time you modify an existing class that uses this if-else chain.** So, let’s search
for a better solution.

In the upcoming program, you remove the **newPayment**() method from the Payment
interface. You place this method into another interface called NewPayment. As a result,
now you have two interfaces with the specific operations. Since all types of users can
raise a new payment request, the concrete classes of **RegisteredUserPayment** and
**GuestUserPayment** both implement the NewPayment interface. But you show the last
payment detail for the registered users only. So, the RegisteredUser class implements
the Payment interface. I always advocate for a proper name. Since Payment contains
the **previousPaymentInfo**() method, it makes sense to choose a better name, such as
PreviousPayment instead of Payment. So, now you see the following interfaces:

**Code:**
```java
public interface PreviousPayment {
    void previousPaymentInfo();
}

public interface NewPayment {
    void newPayment();
}
```

```java
public class RegisteredUserPaymentLSP implements NewPayment,PreviousPayment {
    String name;
    public RegisteredUserPaymentLSP(String userName) {
        this.name = userName;
    }
    @Override
    public void newPayment() {
        System.out.println("Processing " + name + "'s current payment request");
        // some other code, if any
    }

    @Override
    public void previousPaymentInfo() {
        System.out.println("Retrieving " + name + "'s payment details");
        // some other code, if any
    }
}
```

```java
public class GuestUserPaymentLSP implements NewPayment {
    String name;
    public GuestUserPaymentLSP() {
        this.name = "guest";
    }

    @Override
    public void newPayment() {
        System.out.println("Processing " + name + "'s current payment request");
        // some other code, if any
    }
}
```

```java
public class PaymentHelperLSP {

    List<PreviousPayment> previousPayments = new ArrayList<PreviousPayment>();
    List<NewPayment> newPayments = new ArrayList<NewPayment>();

    public void addNewPayment(NewPayment newPaymentRequest) {
        newPayments.add(newPaymentRequest);
    }

    public void addPreviousPayment(PreviousPayment previousPayment) {
        previousPayments.add(previousPayment);
    }

    public void showPreviousPayments() {
        for (PreviousPayment payment : previousPayments) {
            payment.previousPaymentInfo();
            System.out.println("--------------");
        }
    }

    public void processNewPayment() {
        for (NewPayment payment : newPayments) {
            payment.newPayment();
            System.out.println("--------------");
        }
    }
}
```

```java
public class ClientLSP {
    public static void main(String[] args) {
        System.out.println("***A demo that follows the LSP.***\n");
        PaymentHelperLSP helper = new PaymentHelperLSP();

        // Instantiating two registered users
        RegisteredUserPaymentLSP robinPayment = new RegisteredUserPaymentLSP("Robin");
        RegisteredUserPaymentLSP jackPayment = new RegisteredUserPaymentLSP("Jack");
        GuestUserPaymentLSP guestUser1 = new GuestUserPaymentLSP();

        // Adding the users to the helper
        helper.addPreviousPayment(robinPayment);
        helper.addPreviousPayment(jackPayment);

        helper.addNewPayment(robinPayment);
        helper.addNewPayment(jackPayment);
        helper.addNewPayment(guestUser1);

        // Processing the payments using the helper class
        helper.showPreviousPayments();
        helper.processNewPayment();
    }
}
```

**Results:**
```
***A demo that follows the LSP.***

Retrieving Robin's payment details
--------------
Retrieving Jack's payment details
--------------
Processing Robin's current payment request
--------------
Processing Jack's current payment request
--------------
Processing guest's current payment request
--------------
```

### Analysis

What are the key changes? Notice that initial program **showPreviousPayments**()
and **processNewPayments**() both process Payment instances inside the enhanced
for loop. But in better program, inside the **showPreviousPayments**() method, you
process **PreviousPayment** instances and inside the **NewPayments**() method, you
process **NewPayment** instances. This new structure solves the problem you faced in
initial program. You can see that this modified design conforms to the LSP because
objects are clearly substitutable and the program works properly.

