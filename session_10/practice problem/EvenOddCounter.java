import java.util.List;

public class EvenOddCounter {
    public static void countEvenOdd(List<Integer> numbers) {
        int even = 0, odd = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
