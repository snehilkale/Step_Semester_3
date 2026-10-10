import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;
    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0 + 60000.0; }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) { super(name); }
    @Override public double calculateTuition() { return 20000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double totalCollected = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = null;
            
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new Scholar(name); break;
            }
            
            if (student != null) {
                double fee = student.calculateTuition();
                if (student instanceof BusUser) {
                    fee += ((BusUser) student).getTransportFee();
                }
                System.out.printf("%s: %.2f%n", student.name, fee);
                totalCollected += fee;
            }
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}
