
import java.util.Scanner;

// Divide and Conquer

class MexGridConstruction2 {

    public static void divideAndConquer(int[][] mex, int s, int e) {
        if (s == e)
            return;
        int m = (s + e) / 2;

        divideAndConquer(mex, s, m);

        int offset = (e - s + 1) / 2;
        for (int i = m + 1; i <= e; i++) {
            for (int j = m + 1; j <= e; j++) {
                mex[i][j] = mex[i - offset][j - offset];
            }
        }

        for (int i = s; i <= m; i++) {
            for (int j = m + 1; j <= e; j++) {
                mex[i][j] = offset + mex[i][j - offset];
            }
        }

        for (int i = m + 1; i <= e; i++) {
            for (int j = s; j <= m; j++) {
                mex[i][j] = offset + mex[i - offset][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int N = 1;
        while (n > N) {
            N *= 2;
        }

        int[][] mex = new int[N][N];

        divideAndConquer(mex, 0, N - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mex[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}