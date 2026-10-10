package assignment;
public class problem2 {

    public static void attendanceSummary(int[] days) {
        if (days == null) {
            System.out.println("Present: 0, Longest streak: 0");
            return;
        }

        int presentCount = 0;
        int currentStreak = 0;
        int maxStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + presentCount + ", Longest streak: " + maxStreak);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(days1);

        int[] days2 = {0, 0, 0};
        attendanceSummary(days2);
    }
}
