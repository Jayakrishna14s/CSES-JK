
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CreatingStrings {
    public static void generate(int[] cnt, int n, StringBuilder curr, StringBuilder sb) {
        if(n == 0) {
            sb.append(curr.toString()).append("\n");
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(cnt[i] > 0) {
                char ch = (char) ('a' + i);

                curr.append(ch);
                cnt[i]--;
                generate(cnt, n - 1, curr, sb);
                cnt[i]++;
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] cnt = new int[26];
        String s = br.readLine();

        int n = s.length();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            cnt[idx]++;
        }

        int fact[] = new int[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        int countPerm = fact[n];
        for(int freq: cnt) {
            countPerm /= fact[freq];
        }

        bw.write(countPerm + "\n");

        StringBuilder curr = new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        generate(cnt, n, curr, sb);

        bw.write(sb.toString());
        bw.flush();
    }
}
