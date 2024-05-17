package _01_solid_principles._03_liskovs_substitution._02_payment_with_lsp_example;

public class RegisteredUserPaymentLSP implements NewPayment, PreviousPayment {
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
