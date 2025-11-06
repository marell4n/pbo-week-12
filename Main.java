import pcbuilder.PC;
import pcbuilder.component.core.*;
import pcbuilder.component.storage.*;
import pcbuilder.component.peripheral.*;
import pcbuilder.component.BaseComponent;

// Import untuk Misi 2
import pcbuilder.reporting.PCReportGenerator;
import pcbuilder.reporting.Customer;
import pcbuilder.reporting.SalesReport;

import java.text.NumberFormat;
// Import List
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Selamat datang di Vortex PC Solutions!");

        // --- Setup untuk Misi 1 (Disesuaikan untuk Misi 2) ---
        CPU cpu = new CPU("Intel Core i9-13900K", 5000000);
        Motherboard mobo = new Motherboard("ASUS ROG STRIX Z790", 2500000);
        
        // Buat List RAM sesuai perubahan di PC.java
        List<RAM> ramList = new ArrayList<>();
        ramList.add(new RAM("Corsair Vengeance 16GB", 800000));
        ramList.add(new RAM("Corsair Vengeance 16GB", 800000));

        // Rakit PC dengan List RAM
        PC myGamingPC = new PC(cpu, mobo, ramList);

        myGamingPC.addStorage(new SSD("Samsung 980 Pro 1TB", 1500000));
        myGamingPC.addPeripheral(new Keyboard("Logitech G Pro X", 750000));
        myGamingPC.addPeripheral(new Mouse("Razer DeathAdder V3", 450000));

        /*
        // --- DEMO MISI 2: TAHAP 1 ---
        System.out.println("\n======= DEMO MISI 2 - TAHAP 1 (PC Report) =======");
        PCReportGenerator pcReporter = new PCReportGenerator();
        // Panggilan ini sekarang mendelegasikan ke pc.generateReport()
        pcReporter.generateReport(myGamingPC);
        
        // --- DEMO MISI 2: TAHAP 2 ---
        System.out.println("\n======= DEMO MISI 2 - TAHAP 2 (Customer Report) =======");
        Customer customer = new Customer("Budi", "budi@email.com", "Gold");
        SalesReport salesReport = new SalesReport();
        
        // Panggilan ini sekarang mendelegasikan ke customer.printCustomerDetails()
        salesReport.printCustomerDetails(customer);
         */

         // --- 2. Finalisasi & Demo (Showcase) ---
        
        // Memanggil method refaktor (Misi 2)
        double finalPrice = myGamingPC.calculateTotalPrice();

        // Format output (Sesuai permintaan Showcase)
        Locale idLocale = Locale.of("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(idLocale);
        currencyFormatter.setMaximumFractionDigits(0); // Hapus desimal

        System.out.println();
        System.out.println("--- PC Build by Team \"Alpha\" ---");
        System.out.println();
        System.out.println("CPU: " + myGamingPC.getCPU().getName());
        System.out.println("Motherboard: " + myGamingPC.getMotherboard().getName());
        
        // Format RAM
        System.out.println("RAM: " + myGamingPC.getRamSticks().size() + "x " + myGamingPC.getRamSticks().get(0).getName());
        
        // Format Storage (Loop untuk semua storage)
        for (BaseComponent s : myGamingPC.getStorageDevices()) {
             System.out.println("Storage: " + s.getName());
        }

        // Format Peripheral (Loop untuk semua peripheral)
        for (BaseComponent p : myGamingPC.getPeripheralDevices()) {
             System.out.println("Peripheral: " + p.getName());
        }

        System.out.println();
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("Final Price: " + currencyFormatter.format(finalPrice));
        System.out.println();
        System.out.println("--- Build Successful! ---");
    }
}