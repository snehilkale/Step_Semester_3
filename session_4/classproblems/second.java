package classproblems;

import java.util.*;

public class second {
    public static void main(String[] args) {
        int lowest = 0, i, High = 0, Q = 0, R = 0, M = 0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of Array");
        int n = sc.nextInt();
        int A[] = new int[n];

        System.out.println("Enter the elements");
        for (i = 0; i < n; i++) {
            System.out.println("Enter price at day " + i);
            A[i] = sc.nextInt();
        }

        for (i = 0; i < n - 1; i++) {
            if (A[i] < A[i + 1]) {
                lowest = A[i];
                Q = i - 1;
            } else {
                lowest = A[i + 1];
                Q = i - 1;
                M++;
            }
        }

        for (i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                High = A[i];
                R = i - 1;
            } else {
                High = A[i + 1];
                R = i - 1;
            }
        }

        if (M + 2 == A.length) {
            System.out.println("Prices only fall so no trade");
        } else {
            System.out.println("Buy on day " + Q + " at price " + lowest + " sell on day " + R + " at price " + High);
        }

        sc.close();
    }
} 
