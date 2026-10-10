package assignment;
import java.util.List;
import java.util.Locale;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double getFinalAmount();
}

class Student extends Customer {
    public Student(double amount) { super(amount); }
    
    @Override
    public double getFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    public Staff(double amount) { super(amount); }
    
    @Override
    public double getFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    public Guest(double amount) { super(amount); }
    
    @Override
    public double getFinalAmount() {
        return amount + 10.0; // ₹10 service charge
    }
}

public class CanteenBilling {
    public static void processBills(List<String> inputLines) {
        double total = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            
            Customer customer = null;
            switch (type) {
                case "STUDENT": customer = new Student(amount); break;
                case "STAFF": customer = new Staff(amount); break;
                case "GUEST": customer = new Guest(amount); break;
            }
            
            if (customer != null) {
                double finalAmount = customer.getFinalAmount();
                System.out.printf(Locale.US, "%s: %.2f\n", type, finalAmount);
                total += finalAmount;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f\n", total);
    }

    public static void main(String[] args) {
        processBills(List.of("STUDENT 200", "STAFF 300", "GUEST 150"));
    }
}
