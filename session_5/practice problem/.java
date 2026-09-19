import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Overloaded eligibility checks
    public static boolean isEligible(double cgpa) {
        // Direct CGPA threshold: 7.5 or above
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        // Borderline CGPA (6.5 to 7.49) requires codingScore >= 60
        if (isEligible(cgpa)) {
            return true;
        }
        return (cgpa >= 6.5) && (codingScore >= 60);
    }

    public double getCompositeScore() {
        // Formula: (CGPA * 10) + CodingScore
        return (this.cgpa * 10.0) + this.codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        // Sort in descending order of composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] eligibleTemp = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                eligibleTemp[count++] = c;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(eligibleTemp, count);
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append(i + 1)
              .append(". ")
              .append(shortlisted[i].name)
              .append(" (")
              .append(shortlisted[i].getCompositeScore())
              .append(")");
            
            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}