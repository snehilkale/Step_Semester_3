package classproblems;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of arr");
        int n = sc.nextInt();
        int A[] = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Enter the Target ");
        int target = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] + A[j] == target) {
                    System.out.println("[" + j + ", " + i + "]");
                }
            }
        }

        sc.close();
    }
}
