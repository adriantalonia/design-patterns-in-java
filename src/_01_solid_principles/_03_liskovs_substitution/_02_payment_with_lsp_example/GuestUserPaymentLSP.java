package _01_solid_principles._03_liskovs_substitution._02_payment_with_lsp_example;

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
