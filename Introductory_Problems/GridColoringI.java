
import java.util.Scanner;

class GridColoringI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 0) {
                    grid[i][j] = grid[i][j] == 'A' ? 'B' : 'A';
                } else {
                    grid[i][j] = grid[i][j] == 'C' ? 'D' : 'C';
                }

                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
