public class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade;
        if (avg >= 75) {
            grade = 'B'; 
        } else if (avg >= 60) {
            grade = 'C';
        } else if (avg >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
       
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, avg >= 75 ? 'B' : (avg >= 50 ? 'D' : 'F'));
    }
}
