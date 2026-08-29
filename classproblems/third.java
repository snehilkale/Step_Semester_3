package classproblems;
import java.util.*;
public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        System.out.println("Enter size of array ");
        int n = sc.nextInt();
        int A[] = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }
        }

        if (count != 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        sc.close();
    }
}