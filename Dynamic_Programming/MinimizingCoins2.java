import java.io.*;
import java.util.Arrays;

public class MinimizingCoins2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int INF = Integer.MAX_VALUE;

        int[] nx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nx[0], x = nx[1];

        int[][] dp = new int[n + 1][x + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            dp[i][0] = 0;
            for (int j = 1; j <= x; j++) {
                int pick = j - coin >= 0 && dp[i][j - coin] != INF ? 1 + dp[i][j - coin] : INF;
                int notPick = dp[i - 1][j];

                dp[i][j] = Math.min(pick, notPick);
            }
        }

        // for (int i = 0; i <= n; i++) {
        // for (int j = 0; j <= x; j++) {
        // bw.write(dp[i][j] + " ");
        // }
        // bw.newLine();
        // }

        bw.write((dp[n][x] == INF ? -1 : dp[n][x]) + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
