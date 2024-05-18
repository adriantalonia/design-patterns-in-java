package _01_solid_principles._04_interface_segregation._02_printer_with_isp_example;

public class ClientISP {
    public static void main(String[] args) {
        System.out.println("***A demo that follows ISP.***");

        PrinterISP printer = new BasicPrinterISP();
        printer.printDocument();
        printer = new AdvancedPrinterISP();
        printer.printDocument();
        FaxDevice faxDevice = new AdvancedPrinterISP();
        faxDevice.sendFax();
    }
}
