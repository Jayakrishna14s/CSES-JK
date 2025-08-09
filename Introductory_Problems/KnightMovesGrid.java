import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class KnightMovesGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));

        board[0][0] = 0;

        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });

        int[][] dir = new int[][] {
                { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }
        };

        int moves = 0;
        while (!q.isEmpty()) {
            moves++;
            int cnt = q.size();
            while (cnt-- > 0) {
                int[] pos = q.poll();
                int x = pos[0], y = pos[1];

                for (int[] d : dir) {
                    int dx = d[0], dy = d[1];
                    if (0 <= x + dx && x + dx < n && 0 <= y + dy && y + dy < n
                            && board[x + dx][y + dy] > moves) {
                        board[x + dx][y + dy] = moves;
                        q.add(new int[] { x + dx, y + dy });
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(board[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
