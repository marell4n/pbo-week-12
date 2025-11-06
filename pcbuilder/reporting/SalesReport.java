package pcbuilder.reporting;

public class SalesReport {
    public void printCustomerDetails(Customer customer) {
        /*System.out.println("---- Customer Report Details ----");
        System.out.println("Nama Pelanggan: " + customer.getName());
        System.out.println("Email Kontak  : " + customer.getEmail());
        System.out.println("Level Member  : " + customer.getMemberLevel());
        System.out.println("---------------------------------");
        */
        // Refactoring
        customer.printCustomerDetails();
    }
}