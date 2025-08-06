import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class NumberSpiral {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(q-- > 0) {
            String[] yx = br.readLine().split(" ");

            long y = Integer.parseInt(yx[0]);
            long x = Integer.parseInt(yx[1]);

            long max = Math.max(y, x);
            long min = Math.min(y, x);
            long pe = 1 + max * (max - 1);

            long diff = max - min;
            
            long res = -1;
            if(max % 2 == 0) {
                if(x == min) {
                    res = pe + diff;
                } else {
                    res = pe - diff;
                }
            } else {
                if(x == min) {
                    res = pe - diff; 
                } else {
                    res = pe + diff;
                }
            }

            bw.write(res + "\n");

        }
        bw.flush();
    }    
}


/* 
 * T(n) = T(n - 1) + 2 * (n - 1)
 * = T(n - 2) + 2 * (n - 2) + 2 * (n - 1)
 * = T(n - k) + 2 * (n - k) + ... + 2 * (n - 1)
 * = T(n - k) + 2 * [n * k - k * (k + 1) / 2]
 * put k = (n - 1)
 * = T(1) + 2 * [n * (n - 1) - (n - 1) * n / 2]
 * = T(1) + n * (n - 1)
 */