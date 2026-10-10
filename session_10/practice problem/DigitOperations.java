public class DigitOperations {
    public static void processNumber(int n) {
        int sum = 0, reverse = 0, temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}
