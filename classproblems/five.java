package classproblems;

import java.util.*;

public class five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A[] = new int[0];
        int B[] = new int[0];

        System.out.println("Enter size of array");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Enter k");
        int k = sc.nextInt();
        k = k % A.length;

        for (int i = 0; i < n; i++) {
            B[i] = A[i];
            A[i] = B[(i + k) % A.length];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(B[i]);
        }

        sc.close();
    }
}