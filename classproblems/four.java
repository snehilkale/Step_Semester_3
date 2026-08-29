package classproblems;

import java.util.*;

public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of A & B");
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int A[] = new int[n];
        int B[] = new int[m];
        int temp = 0;

        System.out.println("Enter elements of A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Enter elements of B:");
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        int C[] = new int[A.length + B.length];

        System.arraycopy(A, 0, C, 0, A.length);
        System.arraycopy(B, 0, C, A.length, B.length);

        for (int i = 0; i < C.length - 1; i++) {
            if (C[i] > C[i + 1]) {
                temp = C[i];
                C[i] = C[i + 1];
                C[i + 1] = temp;
            }
        }

        for (int i = 0; i < C.length; i++) {
            System.out.println(C[i]);
        }

        sc.close();
    }
}
