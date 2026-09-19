import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded eligibility checks
    public static boolean isDraftable(int matchesPlayed) {
        // Veteran rule: 10 or more matches
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        // Combined rule: at least 5 matches AND not injured
        if (isDraftable(matchesPlayed)) {
            return true;
        }
        return (matchesPlayed >= 5) && !injured;
    }

    @Override
    public int compareTo(Player other) {
        // Higher batting average ranks first (descending order)
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        Player[] tempDrafted = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (isDraftable(p.matchesPlayed, p.injured)) {
                tempDrafted[count++] = p;
            }
        }

        Player[] drafted = Arrays.copyOf(tempDrafted, count);
        Arrays.sort(drafted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < drafted.length; i++) {
            sb.append(i + 1).append(". ").append(drafted[i].name);
            if (i < drafted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}