
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TwoSets {
    public static String twoSets(int n) {
        if(n % 4 != 0 && n % 4 != 3) {
            return "NO";
        }
        StringBuilder sb = new StringBuilder("");
        sb.append("YES\n");
        if(n % 4 == 0) {
            sb.append(n / 2).append("\n");

            for(int i = 1; i <= n / 4; i++) {
                sb.append(i).append(" ");
            }
            for(int i = 1 + 3 * n / 4; i <= n; i++) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            sb.append(n / 2).append("\n");
            for(int i = 1 + n / 4; i <= 3 * n / 4; i++) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {
            sb.append((n + 1) / 2).append("\n");
            sb.append("1 2 ");

            for(int i = 4; i <= 3 + n / 4; i++) {
                sb.append(i).append(" ");
            }

            for(int i = n + 1 - n / 4; i <= n; i++) {
                sb.append(i).append(" ");
            }

            sb.append("\n");

            sb.append(n / 2).append("\n");
            sb.append("3 ");

            for(int i = 4 + n / 4; i <= n - n / 4; i++) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString(); 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(twoSets(n));

        bw.flush();
    }    
}
