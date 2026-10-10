import java.util.Scanner;

abstract class Staff {
    String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double getPay();
}

class FullTime extends Staff {
    double weeklySalary;

    public FullTime(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPay() {
        return weeklySalary;
    }
}

class Hourly extends Staff {
    int hours;
    double rate;

    public Hourly(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double getPay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

class Intern extends Staff {
    double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double getPay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double totalPayroll = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff = null;
            
            switch (type) {
                case "FULLTIME":
                    staff = new FullTime(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    staff = new Hourly(name, sc.nextInt(), sc.nextDouble());
                    break;
                case "INTERN":
                    staff = new Intern(name, sc.nextDouble());
                    break;
            }
            
            if (staff != null) {
                double pay = staff.getPay();
                System.out.printf("%s: %.2f%n", staff.name, pay);
                totalPayroll += pay;
            }
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }
}
