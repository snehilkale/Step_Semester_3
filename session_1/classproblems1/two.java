package classproblems1;

public class two {
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        return new String(original).equals(new String(reversed));
    }
    private static void verifyAndPrint(String input) {
        String iterRes = isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome";
        String recurRes = isPalindromeRecursive(input) ? "Palindrome" : "Not Palindrome";
        String arrRes = isPalindromeArrayReversal(input) ? "Palindrome" : "Not Palindrome";

        System.out.println("Input: \"" + input + "\"");
        System.out.println("Iterative: " + iterRes + " | Recursive: " + recurRes + " | Array Reversal: " + arrRes);
        System.out.println();
    }
    public static void main(String[] args) {
        verifyAndPrint("madam");
        verifyAndPrint("hello");
    }
}
