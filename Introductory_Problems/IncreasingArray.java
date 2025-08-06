import java.util.Scanner;

class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long res = 0;
        for(int i = 1; i < n; i++) {
            int max = Math.max(arr[i], arr[i - 1]);
            res += max - arr[i];
            arr[i] = max;
        }

        System.out.println(res);
        sc.close();
    }
}