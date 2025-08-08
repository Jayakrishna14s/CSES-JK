import java.util.Scanner;

class MexGridConstruction3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mex = new int[n][n];
        int[] log2 = new int[101];
        for (int i = 2; i <= 100; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int offsetI = i == 0 ? 0 : (1 << log2[i]);
                int offsetJ = j == 0 ? 0 : (1 << log2[j]);

                if (offsetI == offsetJ) {
                    mex[i][j] = mex[i - offsetI][j - offsetJ];
                } else if (offsetI > offsetJ) {
                    mex[i][j] = mex[i - offsetI][j] + offsetI;
                } else {
                    mex[i][j] = mex[i][j - offsetJ] + offsetJ;
                }
                System.out.print(mex[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
