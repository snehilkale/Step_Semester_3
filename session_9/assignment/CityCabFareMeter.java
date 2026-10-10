import java.util.Scanner;

interface NightServiceCapable {}

abstract class Cab {
    double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRate();
    public abstract String getType();

    public double calculateBaseFare() {
        double fare = getRate() * km;
        return Math.max(fare, 100.0);
    }
}

class Mini extends Cab {
    public Mini(double km) { super(km); }
    @Override public double getRate() { return 10.0; }
    @Override public String getType() { return "MINI"; }
}

class Sedan extends Cab implements NightServiceCapable {
    public Sedan(double km) { super(km); }
    @Override public double getRate() { return 14.0; }
    @Override public String getType() { return "SEDAN"; }
}

class SUV extends Cab implements NightServiceCapable {
    public SUV(double km) { super(km); }
    @Override public double getRate() { return 18.0; }
    @Override public String getType() { return "SUV"; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double totalFare = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = null;
            
            switch (type) {
                case "MINI": cab = new Mini(km); break;
                case "SEDAN": cab = new Sedan(km); break;
                case "SUV": cab = new SUV(km); break;
            }
            
            if (cab != null) {
                if (time.equals("NIGHT") && !(cab instanceof NightServiceCapable)) {
                    System.out.printf("%s: night service not available%n", cab.getType());
                } else {
                    double fare = cab.calculateBaseFare();
                    if (time.equals("NIGHT")) {
                        fare *= 1.20;
                    }
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                    totalFare += fare;
                }
            }
        }
        System.out.printf("Total: %.2f%n", totalFare);
    }
}
