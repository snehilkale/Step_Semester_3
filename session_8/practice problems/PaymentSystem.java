import java.util.List;
import java.util.Locale;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double getAdjustedAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    
    @Override
    public double getAdjustedAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    
    @Override
    public double getAdjustedAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    
    @Override
    public double getAdjustedAmount() {
        return amount; // No fee
    }
}

public class PaymentSystem {
    public static void processPayments(List<String> inputLines) {
        double total = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            
            Payment payment = null;
            // Factory logic to instantiate the correct object
            switch (type) {
                case "CARD": payment = new CardPayment(amount); break;
                case "WALLET": payment = new WalletPayment(amount); break;
                case "BANKTRANSFER": payment = new BankTransferPayment(amount); break;
            }
            
            if (payment != null) {
                double adjusted = payment.getAdjustedAmount();
                System.out.printf(Locale.US, "%s: %.2f\n", type, adjusted);
                total += adjusted;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f\n", total);
    }

    public static void main(String[] args) {
        processPayments(List.of("CARD 1000", "WALLET 500", "BANKTRANSFER 2000"));
    }
}
