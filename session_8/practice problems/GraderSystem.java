import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluate();
}

class ExactMatchQuestion extends Question {
    public ExactMatchQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    @Override
    public double evaluate() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.toLowerCase().split(",");
        String studentAnsLower = studentAnswer.toLowerCase();
        
        int matchCount = 0;
        for (String keyword : keywords) {
            if (studentAnsLower.contains(keyword.trim())) {
                matchCount++;
            }
        }
        
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
}

public class GraderSystem {
    public static void processGrades(List<String> inputLines) {
        double totalScore = 0.0;
        // Regex to parse Type "Text" "Correct" "Student" Points
        Pattern pattern = Pattern.compile("([A-Z]+)\\s+\"[^\"]+\"\\s+\"([^\"]+)\"\\s+\"([^\"]+)\"\\s+(\\d+(?:\\.\\d+)?)");
        
        for (String line : inputLines) {
            Matcher matcher = pattern.matcher(line.trim());
            if (matcher.find()) {
                String type = matcher.group(1);
                String correct = matcher.group(2);
                String student = matcher.group(3);
                double points = Double.parseDouble(matcher.group(4));
                
                Question q = null;
                if (type.equals("MCQ") || type.equals("TF")) {
                    q = new ExactMatchQuestion(correct, student, points);
                } else if (type.equals("ESSAY")) {
                    q = new EssayQuestion(correct, student, points);
                }
                
                if (q != null) {
                    double score = q.evaluate();
                    System.out.printf(Locale.US, "%s: %.2f\n", type, score);
                    totalScore += score;
                }
            }
        }
        System.out.printf(Locale.US, "Total Score: %.2f\n", totalScore);
    }

    public static void main(String[] args) {
        processGrades(List.of(
            "MCQ \"What is the capital of France?\" \"Paris\" \"Paris\" 10",
            "ESSAY \"Name two OOP principles.\" \"Inheritance, Polymorphism, Encapsulation\" \"Polymorphism is one.\" 20"
        ));
    }
}
