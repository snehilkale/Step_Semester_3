import java.util.List;
import java.util.Locale;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    
    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    
    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliverySystem {
    public static void processDeliveries(List<String> inputLines) {
        double total = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);
            
            Delivery delivery = null;
            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customs = Double.parseDouble(parts[3]);
                    delivery = new InternationalDelivery(weight, distance, customs);
                    break;
            }
            
            if (delivery != null) {
                double fee = delivery.calculateFee();
                System.out.printf(Locale.US, "%s: %.2f\n", type, fee);
                total += fee;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f\n", total);
    }

    public static void main(String[] args) {
        processDeliveries(List.of("STANDARD 10 50", "EXPRESS 5 20", "INTERNATIONAL 20 100 30"));
    }
}