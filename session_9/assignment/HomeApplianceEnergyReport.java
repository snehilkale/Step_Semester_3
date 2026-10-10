import java.util.Scanner;

interface SaverModeSupported {}

abstract class Appliance {
    double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerRating();
    public abstract String getType();

    public double calculateUnits(boolean saverMode) {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverMode && this instanceof SaverModeSupported) {
            units *= 0.75;
        }
        return units;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours); }
    @Override public double getPowerRating() { return 150.0; }
    @Override public String getType() { return "FRIDGE"; }
}

class AC extends Appliance implements SaverModeSupported {
    public AC(double hours) { super(hours); }
    @Override public double getPowerRating() { return 1500.0; }
    @Override public String getType() { return "AC"; }
}

class TV extends Appliance {
    public TV(double hours) { super(hours); }
    @Override public double getPowerRating() { return 100.0; }
    @Override public String getType() { return "TV"; }
}

class Washer extends Appliance implements SaverModeSupported {
    public Washer(double hours) { super(hours); }
    @Override public double getPowerRating() { return 500.0; }
    @Override public String getType() { return "WASHER"; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;
        
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean requestSaver = tokens.length > 2 && tokens[2].equals("SAVER");
            
            Appliance appliance = null;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(hours); break;
                case "AC": appliance = new AC(hours); break;
                case "TV": appliance = new TV(hours); break;
                case "WASHER": appliance = new Washer(hours); break;
            }
            
            if (appliance != null) {
                if (requestSaver && !(appliance instanceof SaverModeSupported)) {
                    System.out.printf("%s: saver mode not supported%n", appliance.getType());
                } else {
                    double units = appliance.calculateUnits(requestSaver);
                    double cost = units * 8.0;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
                    totalCost += cost;
                }
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
