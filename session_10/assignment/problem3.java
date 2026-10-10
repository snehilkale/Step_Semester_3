package assignment;
import java.util.Arrays;

public class problem3 {

    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        // Handle k larger than array length using modulo
        int effectiveK = (int) (k % n);
        
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        long k1 = 2;
        System.out.println(Arrays.toString(rotateRoster(names1, k1)));

        String[] names2 = {"A", "B", "C", "D", "E"};
        long k2 = 7;
        System.out.println(Arrays.toString(rotateRoster(names2, k2)));
    }
}
