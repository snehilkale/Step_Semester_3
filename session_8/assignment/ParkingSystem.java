package assignment;

import java.util.List;
import java.util.Locale;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double getCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    
    @Override
    public double getCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    
    @Override
    public double getCharge() {
        if (hours <= 1) return 30.0;
        return 30.0 + ((hours - 1) * 20.0);
    }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    
    @Override
    public double getCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0); // Minimum charge of ₹100
    }
}

public class ParkingSystem {
    public static void processParking(List<String> inputLines) {
        double total = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            
            Vehicle vehicle = null;
            switch (type) {
                case "BIKE": vehicle = new Bike(hours); break;
                case "CAR": vehicle = new Car(hours); break;
                case "TRUCK": vehicle = new Truck(hours); break;
            }
            
            if (vehicle != null) {
                double charge = vehicle.getCharge();
                System.out.printf(Locale.US, "%s: %.2f\n", type, charge);
                total += charge;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f\n", total);
    }

    public static void main(String[] args) {
        processParking(List.of("BIKE 3", "CAR 4", "TRUCK 1", "CAR 1"));
    }
}
