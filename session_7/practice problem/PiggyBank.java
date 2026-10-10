public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    // Money can only be added through this method
    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
            System.out.println("Deposited: " + amount + " | Current savings: " + this.savings);
        }
    }

    // Money can only be removed if there are sufficient funds
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
            System.out.println("Withdrew: " + amount + " | Current savings: " + this.savings);
        } else {
            System.out.println("Withdrawal of " + amount + " rejected. Insufficient funds.");
        }
    }

    // Read-only access to savings
    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);    // savings = 100
        pb.withdraw(30);    // savings = 70
        pb.withdraw(500);   // rejected, savings stays 70
        System.out.println("Final savings: " + pb.getSavings());
    }
}
