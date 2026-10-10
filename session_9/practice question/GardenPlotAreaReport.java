import java.util.Scanner;

abstract class Plot {
    String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double getArea();
    public abstract String getShape();
}

class Circle extends Plot {
    double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        double totalArea = 0.0;
        
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot = null;
            
            switch (shape) {
                case "CIRCLE":
                    plot = new Circle(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plot = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    plot = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
                    break;
            }
            
            if (plot != null) {
                double area = plot.getArea();
                System.out.printf("%s (%s): %.2f%n", plot.owner, plot.getShape(), area);
                totalArea += area;
            }
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
