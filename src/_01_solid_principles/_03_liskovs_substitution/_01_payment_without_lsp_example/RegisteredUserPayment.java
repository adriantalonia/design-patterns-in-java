package _01_solid_principles._03_liskovs_substitution._01_payment_without_lsp_example;

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
