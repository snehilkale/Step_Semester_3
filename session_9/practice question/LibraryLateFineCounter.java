import java.util.Scanner;

abstract class Item {
    String title;
    int daysLate;

    public Item(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();
}

class Book extends Item {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends Item {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends Item {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double totalFines = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            Item item = null;
            
            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;
                case "DVD":
                    item = new DVD(title, days);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, days);
                    break;
            }
            
            if (item != null) {
                double fine = item.calculateFine();
                System.out.printf("%s: %.2f%n", item.title, fine);
                totalFines += fine;
            }
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
