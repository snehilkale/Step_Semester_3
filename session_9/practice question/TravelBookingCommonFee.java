import java.util.Scanner;

abstract class Booking {
    double distanceKm;
    static final double BOOKING_FEE = 50.0;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double getBaseFare();
    public abstract String getMode();

    public double getTotalFare() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    public Bus(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class Train extends Booking {
    public Train(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class Flight extends Booking {
    public Flight(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking = null;
            
            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;
                case "TRAIN":
                    booking = new Train(distance);
                    break;
                case "FLIGHT":
                    booking = new Flight(distance);
                    break;
            }
            
            if (booking != null) {
                System.out.printf("%s: %.2f%n", booking.getMode(), booking.getTotalFare());
            }
        }
    }
}
