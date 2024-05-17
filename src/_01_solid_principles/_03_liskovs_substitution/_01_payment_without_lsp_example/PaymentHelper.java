package _01_solid_principles._03_liskovs_substitution._01_payment_without_lsp_example;

import java.util.ArrayList;
import java.util.List;

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

    public void processNewPayment() {
        for (Payment payment : payments) {
            payment.newPayment();
            System.out.println("--------------");
        }
    }
}
