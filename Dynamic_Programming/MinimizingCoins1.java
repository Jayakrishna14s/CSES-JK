import java.io.*;
import java.util.*;

public class MinimizingCoins1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int INF = Integer.MAX_VALUE;

        int[] nx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[nx[1] + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 1; i <= nx[1]; i++) {
            int mn = INF;
            for (int coin : coins) {
                if (i - coin >= 0)
                    mn = Math.min(mn, dp[i - coin]);
            }

            if (mn != INF)
                dp[i] = 1 + mn;
        }

        int res = dp[nx[1]];
        res = res == INF ? -1 : res;

        bw.write(res + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}