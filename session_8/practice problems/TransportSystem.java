import java.util.List;
import java.util.Locale;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) { super(distance); }
    
    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Max fare limit
    }
}

class Train extends Transport {
    public Train(double distance) { super(distance); }
    
    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakFactor;

    public Metro(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakFactor;
    }
}

public class TransportSystem {
    public static void processJourneys(List<String> inputLines) {
        double total = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            
            Transport transport = null;
            switch (type) {
                case "BUS": 
                    transport = new Bus(distance); 
                    break;
                case "TRAIN": 
                    transport = new Train(distance); 
                    break;
                case "METRO": 
                    double peakFactor = Double.parseDouble(parts[2]);
                    transport = new Metro(distance, peakFactor); 
                    break;
            }
            
            if (transport != null) {
                double fare = transport.calculateFare();
                System.out.printf(Locale.US, "%s: %.2f\n", type, fare);
                total += fare;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f\n", total);
    }

    public static void main(String[] args) {
        processJourneys(List.of("BUS 15", "TRAIN 50", "METRO 10 1.5"));
    }
}