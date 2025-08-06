
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TwoKnights {
   
    
    public static long twoKnights(long n) {
        int[] baseCases = new int[]{-1, 0, 6, 28, 96};
        if(n <= 4) return baseCases[(int) n];

        long res = 0;
        // case - 8 positions attacks
        res += (n - 4) * (n - 4) * (n * n - 9);
        //case - 6 position attacks
        res += (n - 4) * 4 * (n * n - 7);
        // case - 4 positions attacks
        res += (4 + 4 * (n - 4)) * (n * n - 5);
        // case - 3 positions attacks
        res += 8 * (n * n - 4);
        // case - 2 positions attacks
        res += 4 * (n * n - 3);

        return res / 2; 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int k = 1; k <= n; k++) {
            bw.write(twoKnights(k) + "\n");
        }
        bw.flush();
    }    
}
