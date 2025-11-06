package pcbuilder;

// IMPORT YANG BENAR (karena component ada DI DALAM pcbuilder)
import pcbuilder.component.core.*;
import pcbuilder.component.peripheral.*;
import pcbuilder.component.storage.*;
import pcbuilder.component.BaseComponent;
import java.util.*;

public class PC {

    // 1. Relasi Composition (Wajib ada)
    private final CPU core_cpu;
    private final Motherboard core_motherboard;
    // Diubah untuk Misi 2
    private final List<RAM> ramSticks;

    // 2. Relasi Aggregation (Opsional)
    private final List<BaseComponent> storageDevices;
    private final List<BaseComponent> peripheralDevices;

    // Constructor diubah untuk Misi 2
    public PC(CPU cpu, Motherboard motherboard, List<RAM> ram) {
        this.core_cpu = cpu;
        this.core_motherboard = motherboard;
        this.ramSticks = ram;
        
        this.storageDevices = new ArrayList<>();
        this.peripheralDevices = new ArrayList<>();
    }

    // --- Getters untuk Misi 2 ---
    public CPU getCPU() {
        return this.core_cpu;
    }
    
    public Motherboard getMotherboard() {
        return this.core_motherboard;
    }
    
    public List<RAM> getRamSticks() {
        return this.ramSticks;
    }
    // --- Akhir Getters ---

    public void addStorage(BaseComponent storage) {
        this.storageDevices.add(storage);
    }

    public void addPeripheral(BaseComponent peripheral) {
        this.peripheralDevices.add(peripheral);
    }

    // [BARU] Getter untuk Misi 3 Showcase
    public List<BaseComponent> getStorageDevices() {
        return this.storageDevices;
    }

    public List<BaseComponent> getPeripheralDevices() {
        return this.peripheralDevices;
    }

    public double calculateTotalPrice() {
        double total = 0;
        total += this.core_cpu.getPrice();
        total += this.core_motherboard.getPrice();
        
        for(RAM ram : ramSticks) {
            total += ram.getPrice();
        }
        for (BaseComponent storage : storageDevices) {
            total += storage.getPrice();
        }
        for (BaseComponent peripheral : peripheralDevices) {
            total += peripheral.getPrice();
        }
        return total;
    }
    
    public void printConfiguration() {
        System.out.println("--- Konfigurasi PC Anda ---");
        System.out.println("CORE:");
        System.out.printf("  - CPU: %s (Rp %,.0f)\n", core_cpu.getName(), core_cpu.getPrice());
        System.out.printf("  - Motherboard: %s (Rp %,.0f)\n", core_motherboard.getName(), core_motherboard.getPrice());
        System.out.println("  - RAM:");
        for(RAM ram : ramSticks) {
            System.out.printf("    - %s (Rp %,.0f)\n", ram.getName(), ram.getPrice());
        }

        System.out.println("STORAGE:");
        if (storageDevices.isEmpty()) {
            System.out.println("  - (Tidak ada storage terpasang)");
        } else {
            for (BaseComponent storage : storageDevices) {
                System.out.printf("  - %s (Rp %,.0f)\n", storage.getName(), storage.getPrice());
            }
        }

        System.out.println("PERIPHERAL:");
        if (peripheralDevices.isEmpty()) {
            System.out.println("  - (Tidak ada peripheral terpasang)");
        } else {
            for (BaseComponent peripheral : peripheralDevices) {
                System.out.printf("  - %s (Rp %,.0f)\n", peripheral.getName(), peripheral.getPrice());
            }
        }
        System.out.println("-----------------------------");
    }

    /**
     * REFACTORING: Method dari Misi 2
     */
    public void generateReport() {
        System.out.println("--- PC Build Report ---");
        System.out.println("CPU: " + this.getCPU().getName());
        System.out.println("Motherboard: " + this.getMotherboard().getName());
        System.out.println("RAM Sticks: " + this.ramSticks.size());
        System.out.println("-----------------------");
    }
}