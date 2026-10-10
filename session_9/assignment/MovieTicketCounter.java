import java.util.Locale;
import java.util.Scanner;

abstract class TicketBooking {
    int count;
    static final double CONVENIENCE_FEE = 20.0;

    public TicketBooking(int count) {
        this.count = count;
    }

    public abstract double getTicketPrice();
    public abstract String getSeatType();

    public double calculateAmount() {
        return (getTicketPrice() * count) + CONVENIENCE_FEE;
    }
}

class RegularBooking extends TicketBooking {
    public RegularBooking(int count) { super(count); }
    @Override public double getTicketPrice() { return 150.0; }
    @Override public String getSeatType() { return "REGULAR"; }
}

class PremiumBooking extends TicketBooking {
    public PremiumBooking(int count) { super(count); }
    @Override public double getTicketPrice() { return 250.0; }
    @Override public String getSeatType() { return "PREMIUM"; }
}

class ReclinerBooking extends TicketBooking {
    public ReclinerBooking(int count) { super(count); }
    @Override public double getTicketPrice() { return 400.0; }
    @Override public String getSeatType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        double total = 0.0;
        for (int i = 0; i < n; i++) {
            if (!sc.hasNext()) break;
            String type = sc.next().trim();
            if (!sc.hasNextInt()) break;
            int count = sc.nextInt();

            if (count <= 0) {
                continue;
            }

            TicketBooking booking = null;
            String normalizedType = type.toUpperCase(Locale.ROOT);

            switch (normalizedType) {
                case "REGULAR": booking = new RegularBooking(count); break;
                case "PREMIUM": booking = new PremiumBooking(count); break;
                case "RECLINER": booking = new ReclinerBooking(count); break;
                default: continue;
            }

            double amount = booking.calculateAmount();
            System.out.printf("%s: %.2f%n", booking.getSeatType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
