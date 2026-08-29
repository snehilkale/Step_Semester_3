package classproblems1;

public class four {

    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[256];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (counts[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }
    private static void processInput(String input) {
        char result = findFirstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.println("Input: \"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + input + "\" -> No Non-Repeating Character Found");
        }
    }
    public static void main(String[] args) {
        processInput("swiss");
        processInput("aabbcc");
    }
}
