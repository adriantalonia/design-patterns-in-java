package _01_solid_principles._03_liskovs_substitution._02_payment_with_lsp_example;

import _01_solid_principles._03_liskovs_substitution._01_payment_without_lsp_example.Payment;

import java.util.ArrayList;
import java.util.List;

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
