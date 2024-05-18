package _01_solid_principles._04_interface_segregation._01_printer_without_isp_example;

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
