
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TowerOfHanoi {
    public static void toh(char A, char B, char C, int n, StringBuilder sb) {
        if(n == 0) return;
        toh(A, C, B, n - 1, sb);
        sb.append(A).append(" ").append(C).append("\n");
        toh(B, A, C, n - 1, sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        toh('1', '2', '3', n, sb);
        int moves = (1 << n) - 1;
        bw.write(moves + "\n");
        bw.write(sb.toString());
        bw.flush();
    }    
}
