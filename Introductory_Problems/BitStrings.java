
import java.util.Scanner;

class BitStrings {
    public static int pow(long a, int n, int MOD) {
        long res = 1;
        while(n > 0) {
            if((n & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            n >>= 1;
        }
        return (int) res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pow(2, n, (int) 1e9 + 7));
        sc.close();
    }    
}
