import pcbuilder.PC;
import pcbuilder.component.core.*;
import pcbuilder.component.storage.*;
import pcbuilder.component.peripheral.*;
import pcbuilder.component.BaseComponent;
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Selamat datang di Vortex PC Solutions!");
        System.out.println("Merakit PC baru...");

        // 1. Siapkan Komponen Inti (Wajib)
        CPU cpu = new CPU("Intel Core i9-13900K", 5000000);
        Motherboard mobo = new Motherboard("ASUS ROG STRIX Z790", 2500000);
        RAM ram = new RAM("Corsair Vengeance 32GB", 1200000);

        // 2. Rakit PC (Memasukkan komponen inti via Composition)
        PC myGamingPC = new PC(cpu, mobo, ram);

        // 3. Tambah Komponen Storage (Minimal 1)
        // Ini valid, karena SSD "is-a" BaseComponent
        myGamingPC.addStorage(new SSD("Samsung 980 Pro 1TB", 1500000));

        // 4. Tambah Komponen Peripheral (Opsional)
        // Ini valid, karena Keyboard "is-a" BaseComponent
        myGamingPC.addPeripheral(new Keyboard("Logitech G Pro X", 750000));
        myGamingPC.addPeripheral(new Mouse("Razer DeathAdder V3", 450000));
        myGamingPC.addPeripheral(new Monitor("LG UltraGear 27\"", 3000000));

        // 5. Tampilkan Konfigurasi
        myGamingPC.printConfiguration();

        // 6. Hitung Total Harga
        double total = myGamingPC.calculateTotalPrice();
        System.out.printf("Total Harga PC Rakitan Anda: Rp %,.2f\n", total);
        
        // --- Peringatan Desain (Seperti yang dibahas sebelumnya) ---
        // Desain ini tidak bisa mencegah hal berikut:
        System.out.println("\n--- Peringatan Desain ---");
        System.out.println("Menambahkan Mouse ke slot Storage...");
        myGamingPC.addStorage(new Mouse("Mouse di Slot SSD?!", 100000));
        
        // Mouse akan tercetak di bawah kategori STORAGE
        myGamingPC.printConfiguration();
    }
}