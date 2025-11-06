package pcbuilder.reporting;

// Import PC Anda dari paketnya
import pcbuilder.PC;

// Sesuai Misi 2  
public class PCReportGenerator {
    
    // METHOD INI CEMBURU PADA PC!  
    /*public void generateReport() {
        System.out.println("--- PC Build Report ---");
        System.out.println("CPU: " + this.getCPU().getName());
        System.out.println("Motherboard: " + this.getMotherboard().getName());
        System.out.println("RAM Sticks: " + this.ramSticks.size());
        System.out.println("-----------------------");
    }
        */
    // Setelah di refaktoring
    public void generateReport(PC pc) {
        pc.generateReport();
    }
}