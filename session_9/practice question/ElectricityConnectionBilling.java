import java.util.Scanner;

abstract class Connection {
    int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class Home extends Connection {
    public Home(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class Shop extends Connection {
    public Shop(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class Factory extends Connection {
    public Factory(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double total = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection conn = null;
            
            switch (type) {
                case "HOME":
                    conn = new Home(units);
                    break;
                case "SHOP":
                    conn = new Shop(units);
                    break;
                case "FACTORY":
                    conn = new Factory(units);
                    break;
            }
            
            if (conn != null) {
                double bill = conn.calculateBill();
                System.out.printf("%s: %.2f%n", conn.getType(), bill);
                total += bill;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
