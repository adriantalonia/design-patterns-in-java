package _01_solid_principles._04_interface_segregation._01_printer_without_isp_example;

public class BasicPrinter implements Printer {
    @Override
    public void printDocument() {
        System.out.println("The basic printer prints a document.");
    }

    @Override
    public void sendFax() {
        throw new UnsupportedOperationException("Not supported");
    }
}
