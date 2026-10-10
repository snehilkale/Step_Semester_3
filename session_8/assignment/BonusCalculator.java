package assignment;

import java.util.List;
import java.util.Locale;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }

    public abstract double getBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    
    @Override
    public double getBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }
    
    @Override
    public double getBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double salary) { super(name, salary); }
    
    @Override
    public double getBonus() {
        return 2000.0; // Fixed bonus
    }
}

public class BonusCalculator {
    public static void processBonuses(List<String> inputLines) {
        double totalBonus = 0.0;
        
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);
            
            Employee employee = null;
            switch (type) {
                case "FULLTIME": employee = new FullTimeEmployee(name, salary); break;
                case "PARTTIME": employee = new PartTimeEmployee(name, salary); break;
                case "INTERN": employee = new Intern(name, salary); break;
            }
            
            if (employee != null) {
                double bonus = employee.getBonus();
                System.out.printf(Locale.US, "%s: %.2f\n", employee.getName(), bonus);
                totalBonus += bonus;
            }
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        processBonuses(List.of("FULLTIME Asha 50000", "PARTTIME Ravi 30000", "INTERN Neha 15000"));
    }
}

