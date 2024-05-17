package _01_solid_principles._03_liskovs_substitution._01_payment_without_lsp_example;

public interface Payment {
    void previousPaymentInfo();
    void newPayment();
}
