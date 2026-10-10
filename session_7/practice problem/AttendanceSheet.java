public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        // First check if the array is full, then check for duplicates
        if (count < presentStudents.length && !isPresent(name)) {
            presentStudents[count] = name;
            count++;
        }
    }

    // Checks internal array without exposing it
    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Ignored, already present
        
        System.out.println("Present count: " + sheet.getPresentCount()); // Output: 2
        System.out.println("Is Ben present? " + sheet.isPresent("Ben")); // Output: true
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // Output: false
    }
}
