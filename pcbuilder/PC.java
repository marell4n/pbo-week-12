package pcbuilder;

import pcbuilder.component.core.*;
import pcbuilder.component.peripheral.*;
import pcbuilder.component.storage.*;
import pcbuilder.component.BaseComponent;
import java.util.*;

public class PC {

    // 1. Relasi Composition (Wajib ada)
    private final CPU core_cpu;
    private final Motherboard core_motherboard;
    private final RAM core_ram;

    // 2. Relasi Aggregation (Opsional)
    // Tipe List diubah ke BaseComponent
    private final List<BaseComponent> storageDevices;
    private final List<BaseComponent> peripheralDevices;

    public PC(CPU cpu, Motherboard motherboard, RAM ram) {
        this.core_cpu = cpu;
        this.core_motherboard = motherboard;
        this.core_ram = ram;
        
        // Inisialisasi diubah ke BaseComponent
        this.storageDevices = new ArrayList<>();
        this.peripheralDevices = new ArrayList<>();
    }

    /**
     * Menambahkan komponen Storage (Aggregation)
     * Parameter diubah ke BaseComponent
     */
    public void addStorage(BaseComponent storage) {
        this.storageDevices.add(storage);
    }

    /**
     * Menambahkan komponen Peripheral (Aggregation)
     * Parameter diubah ke BaseComponent
     */
    public void addPeripheral(BaseComponent peripheral) {
        this.peripheralDevices.add(peripheral);
    }

    /**
     * Menghitung total harga semua komponen yang terpasang.
     */
    public double calculateTotalPrice() {
        double total = 0;

        // Harga Komponen Inti
        total += this.core_cpu.getPrice();
        total += this.core_motherboard.getPrice();
        total += this.core_ram.getPrice();

        // Harga Semua Storage
        for (BaseComponent storage : storageDevices) {
            total += storage.getPrice();
        }

        // Harga Semua Peripheral
        for (BaseComponent peripheral : peripheralDevices) {
            total += peripheral.getPrice();
        }

        return total;
    }
    
    /**
     * [BARU] Method untuk menampilkan semua komponen yang terpasang.
     */
    public void printConfiguration() {
        System.out.println("--- Konfigurasi PC Anda ---");
        // Komponen Inti
        System.out.println("CORE:");
        System.out.printf("  - CPU: %s (Rp %,.0f)\n", core_cpu.getName(), core_cpu.getPrice());
        System.out.printf("  - Motherboard: %s (Rp %,.0f)\n", core_motherboard.getName(), core_motherboard.getPrice());
        System.out.printf("  - RAM: %s (Rp %,.0f)\n", core_ram.getName(), core_ram.getPrice());

        // Komponen Storage
        System.out.println("STORAGE:");
        if (storageDevices.isEmpty()) {
            System.out.println("  - (Tidak ada storage terpasang)");
        } else {
            for (BaseComponent storage : storageDevices) { // Tipe diubah
                System.out.printf("  - %s (Rp %,.0f)\n", storage.getName(), storage.getPrice());
            }
        }

        // Komponen Peripheral
        System.out.println("PERIPHERAL:");
        if (peripheralDevices.isEmpty()) {
            System.out.println("  - (Tidak ada peripheral terpasang)");
        } else {
            for (BaseComponent peripheral : peripheralDevices) { // Tipe diubah
                System.out.printf("  - %s (Rp %,.0f)\n", peripheral.getName(), peripheral.getPrice());
            }
        }
        System.out.println("-----------------------------");
    }
}