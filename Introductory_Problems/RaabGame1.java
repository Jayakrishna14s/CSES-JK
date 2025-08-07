
import java.util.Scanner;

class RaabGame1 {
    public static void newLine() {
        System.out.println();
    }

    public static void print(int s, int e) {
        for (int i = s; i <= e; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        while (Q-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 0 && b == 0) {
                System.out.println("YES");
                print(1, n);
                newLine();
                print(1, n);
                newLine();
            } else if (a == 0 || b == 0 || a + b > n) {
                System.out.println("NO");
            } else {
                int toRotate = a + b;
                System.out.println("YES");
                print(1, n);
                newLine();
                print(a + 1, toRotate);
                print(1, a);
                print(toRotate + 1, n);
                newLine();
            }
        }
        sc.close();

    }
}
