import java.util.HashSet;
import java.util.Scanner;

class ChessboardAndQueens {
    static HashSet<Integer> row;
    static HashSet<Integer> col;
    static HashSet<Integer> diag1;
    static HashSet<Integer> diag2;

    static boolean[][] isReserved;

    static void init(char[][] free_reserved) {
        row = new HashSet<>();
        col = new HashSet<>();
        diag1 = new HashSet<>();
        diag2 = new HashSet<>();

        isReserved = new boolean[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                isReserved[i][j] = free_reserved[i][j] == '*';
            }
        }
    }

    public static boolean notUnderAttack(int r, int c) {
        return !row.contains(r) && !col.contains(c) && !diag1.contains(r + c) && !diag2.contains(r - c);
    }

    public static int AttackingQueens(int r) {

        if (r == 8) {
            return 1;
        }
 
        int res = 0;
        for (int c = 0; c < 8; c++) {
            if (!isReserved[r][c] && notUnderAttack(r, c)) {
                row.add(r);
                col.add(c);
                diag1.add(r + c);
                diag2.add(r - c);

                res += AttackingQueens(r + 1);

                row.remove(r);
                col.remove(c);
                diag1.remove(r + c);
                diag2.remove(r - c);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] free_reserved = new char[8][];

        for (int i = 0; i < 8; i++) {
            free_reserved[i] = sc.next().toCharArray();
        }

        init(free_reserved);
        System.out.println(AttackingQueens(0));
    }
}
