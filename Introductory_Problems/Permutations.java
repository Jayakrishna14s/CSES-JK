
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Permutations {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(n == 1) {
            bw.write("1");
        }
        else if(n <= 3) {
            bw.write("NO SOLUTION");    
        } else {
            int v = n / 2 + 1;
            for(int i = 0; i < n; i++) {
                bw.write(((i % 2 == 0) ? v + i / 2 : 1 + i / 2) + " ");
            }
        }
        bw.flush();
    }    
}
