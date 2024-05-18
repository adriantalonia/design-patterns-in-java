package _01_solid_principles._04_interface_segregation._02_printer_with_isp_example;

public class AdvancedPrinterISP implements PrinterISP, FaxDevice {
    @Override
    public void sendFax() {
        System.out.println("The advanced printer sends a fax.");
    }

    @Override
    public void printDocument() {
        System.out.println("The advanced printer prints a document.");
    }
}
