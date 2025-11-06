package pcbuilder.reporting;

public class Customer {
    private String name;
    private String email;
    private String memberLevel;

    public Customer(String name, String email, String memberLevel) {
        this.name = name;
        this.email = email;
        this.memberLevel = memberLevel;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMemberLevel() { return memberLevel; }

    // Refactoring: Memindahkan method dari SalesReport.java
    public void printCustomerDetails() {
        System.out.println("---- Customer Report Details ----");
        System.out.println("Nama Pelanggan: " + this.getName());
        System.out.println("Email Kontak  : " + this.getEmail());
        System.out.println("Level Member  : " + this.getMemberLevel());
        System.out.println("---------------------------------");
    }
}