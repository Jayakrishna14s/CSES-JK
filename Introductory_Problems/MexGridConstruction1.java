// Brute Force

import java.util.HashSet;
import java.util.Scanner;

class MexGridConstruction1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        HashSet<Integer>[] row = new HashSet[n];
        HashSet<Integer>[] col = new HashSet[n];

        for (int i = 0; i < n; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = 0;
                while (row[i].contains(x) || col[j].contains(x)) {
                    x++;
                }
                System.out.print(x + " ");
                row[i].add(x);
                col[j].add(x);
            }
            System.out.println();
        }
    }
}
