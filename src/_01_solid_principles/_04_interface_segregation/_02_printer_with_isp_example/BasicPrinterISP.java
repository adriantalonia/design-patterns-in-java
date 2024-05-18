package _01_solid_principles._04_interface_segregation._02_printer_with_isp_example;

public class BasicPrinterISP implements PrinterISP {
    @Override
    public void printDocument() {
        System.out.println("The basic printer prints a document.");
    }
}
