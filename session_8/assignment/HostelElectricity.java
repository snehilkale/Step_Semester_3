package assignment;

import java.util.List;
import java.util.Locale;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double getBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    
    @Override
    public double getBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double getBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) { super(units); }
    
    @Override
    public double getBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricity {
    public static void processBills(List<String> inputLines) {
        double total = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            
            Room room = null;
            switch (type) {
                case "SINGLE": 
                    room = new SingleRoom(units); 
                    break;
                case "SHARED": 
                    int occupants = Integer.parseInt(parts[2]);
                    room = new SharedRoom(units, occupants); 
                    break;
                case "AC": 
                    room = new ACRoom(units); 
                    break;
            }
            
            if (room != null) {
                double bill = room.getBill();
                System.out.printf(Locale.US, "%s: %.2f\n", type, bill);
                total += bill;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f\n", total);
    }

    public static void main(String[] args) {
        processBills(List.of("SINGLE 120", "SHARED 150 3", "AC 100"));
    }
}
