
import java.util.Scanner;

class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.print(n + " ");
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = 1 + 3 * n;
            }
            System.out.print(n + " ");
        }

        sc.close();
    }    
}
