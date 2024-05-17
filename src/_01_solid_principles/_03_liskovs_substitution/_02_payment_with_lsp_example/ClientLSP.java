package _01_solid_principles._03_liskovs_substitution._02_payment_with_lsp_example;

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
