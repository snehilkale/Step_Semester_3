public class PalindromeChecker {
    public static void check(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();
        
        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }
}
