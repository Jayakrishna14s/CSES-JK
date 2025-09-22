import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class GridPathDescription {
    static char[] s;
    static int n;
    static int steps;
    static boolean[][] visited;

    public static int helper(int r, int c) {

        if (r < 0 || r > 6 || c < 0 || c > 6)
            return 0;

        if (visited[r][c])
            return 0;

        if (r == 6 && c == 0) {
            return steps == n ? 1 : 0;
        }

        if (c >= 1 && c <= 5 && !visited[r][c - 1] && !visited[r][c + 1] && (r == 0 && visited[r + 1][c] ||
                r == 6 && visited[r - 1][c]))
            return 0;

        if (r >= 1 && r <= 5 && !visited[r - 1][c] && !visited[r + 1][c] && (c == 0 && visited[r][c + 1] ||
                c == 6 && visited[r][c - 1]))
            return 0;

        if (r >= 1 && r <= 5 && c >= 1 && c <= 5
                && (visited[r][c + 1] && visited[r][c - 1] && !visited[r + 1][c] && !visited[r - 1][c] ||
                        visited[r + 1][c] && visited[r - 1][c] && !visited[r][c + 1] && !visited[r][c - 1]))
            return 0;

        if (r + 1 <= 6 && c + 1 <= 6 && visited[r + 1][c + 1] && !visited[r][c + 1] && !visited[r + 1][c])
            return 0;
        if (r + 1 <= 6 && c - 1 >= 0 && visited[r + 1][c - 1] && !visited[r][c - 1] && !visited[r + 1][c])
            return 0;
        if (r - 1 >= 0 && c - 1 >= 0 && visited[r - 1][c - 1] && !visited[r][c - 1] && !visited[r - 1][c])
            return 0;
        if (r - 1 >= 0 && c + 1 <= 6 && visited[r - 1][c + 1] && !visited[r][c + 1] && !visited[r - 1][c])
            return 0;

        char dir = s[steps];
        visited[r][c] = true;
        steps++;

        int res = 0;

        switch (dir) {
            case '?':
                // if (r < 6 && !visited[r + 1][c])
                res += helper(r + 1, c);
                // if (r > 0 && !visited[r - 1][c])
                res += helper(r - 1, c);
                // if (c < 6 && !visited[r][c + 1])
                res += helper(r, c + 1);
                // if (c > 0 && !visited[r][c - 1])
                res += helper(r, c - 1);
                break;
            case 'L':
                // if (c > 0 && !visited[r][c - 1])
                res += helper(r, c - 1);
                break;
            case 'R':
                // if (c < 6 && !visited[r][c + 1])
                res += helper(r, c + 1);
                break;
            case 'D':
                // if (r < 6 && !visited[r + 1][c])
                res += helper(r + 1, c);
                break;
            case 'U':
                // if (r > 0 && !visited[r - 1][c])
                res += helper(r - 1, c);
                break;
        }

        steps--;
        visited[r][c] = false;

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine().toCharArray();
        n = s.length;
        steps = 0;
        visited = new boolean[7][7];
        bw.write(helper(0, 0) + "");
        bw.flush();

    }
}