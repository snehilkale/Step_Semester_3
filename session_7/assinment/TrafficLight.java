package assinment;

public class TrafficLight {
    private final String id;
    private String color; // "RED", "GREEN", "YELLOW"

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Starts on RED
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor()); // RED
        t.next();
        System.out.println(t.getColor()); // GREEN
        t.next();
        System.out.println(t.getColor()); // YELLOW
        t.next();
        System.out.println(t.getColor()); // RED
    }
}
