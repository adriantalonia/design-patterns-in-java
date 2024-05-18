package _01_solid_principles._04_interface_segregation._01_printer_without_isp_example;

public class Client {
    public static void main(String[] args) {
        System.out.println("*** A demo without ISP ***");
        Printer printer = new AdvancedPrinter();
        printer.printDocument();
        printer.sendFax();

        printer = new BasicPrinter();
        printer.printDocument();
        printer.sendFax(); // will throw error
    }
}
