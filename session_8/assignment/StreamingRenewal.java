package assignment;

import java.time.LocalDate;
import java.util.List;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 365; }
}

public class StreamingRenewal {
    public static void processRenewals(List<String> inputLines) {
        for (String line : inputLines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);
            
            SubscriptionPlan plan = null;
            switch (type) {
                case "BASIC": plan = new BasicPlan(name, startDate); break;
                case "STANDARD": plan = new StandardPlan(name, startDate); break;
                case "PREMIUM": plan = new PremiumPlan(name, startDate); break;
            }
            
            if (plan != null) {
                System.out.println(plan.getName() + ": " + plan.calculateRenewalDate());
            }
        }
    }

    public static void main(String[] args) {
        processRenewals(List.of(
            "BASIC Asha 2024-01-15", 
            "STANDARD Ravi 2024-02-01", 
            "PREMIUM Neha 2024-03-10", 
            "BASIC Kiran 2024-12-20"
        ));
    }
}
