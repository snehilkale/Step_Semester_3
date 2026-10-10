import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    double weightKg;
    double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weightKg); }
    @Override public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override public double calculateCharge() { return 80.0 + (15.0 * weightKg); }
    @Override public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
    @Override public String getType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weightKg) + 50.0; }
    @Override public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
    @Override public String getType() { return "FRAGILE"; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel = null;
            
            switch (type) {
                case "STANDARD": parcel = new StandardParcel(weight, value); break;
                case "EXPRESS": parcel = new ExpressParcel(weight, value); break;
                case "FRAGILE": parcel = new FragileParcel(weight, value); break;
            }
            
            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).calculateInsurance(parcel.declaredValue) : 0.0;
                double total = charge + insurance;
                
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcel.getType(), charge, insurance, total);
                grandTotal += total;
            }
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
