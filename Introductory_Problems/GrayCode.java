
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class GrayCode {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int n = Integer.parseInt(br.readLine());

        char[][] mat = new char[1 << n][n];
        for(int j = n - 1; j >= 0; j--) {
            int pos = n - 1 - j;
            int window = (1 << pos); 
            for(int i = 0, x = 0; i < (1 << n); i+=window, x++) {
                for(int k = 0; k < window; k++) {
                    mat[i + k][j] = (char)('0' + ((x & 1) ^ ((x >> 1) & 1))); 
                }
            }
        }

        for(int i = 0; i < (1 << n); i++) {
            for(int j = 0; j < n; j++) {
                bw.write(mat[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
    }    
}
