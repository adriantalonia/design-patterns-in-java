package _01_solid_principles._03_liskovs_substitution._01_payment_without_lsp_example;

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
