
import java.util.Scanner;

class MissingNumber {

    public static void inPlaceSort(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            while(arr[i] != -1 && arr[arr[i] - 1] != arr[i]) {
                int temp1 = arr[i];
                int temp2 = arr[arr[i] - 1];

                arr[i] = temp2;
                arr[temp1- 1] = temp1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        arr[n - 1] = -1;

        inPlaceSort(arr, n);
        for(int i = 0; i < n; i++) {
            if(arr[i] == -1) {
                System.out.println(i + 1);
                break;
            }
        }

        sc.close();
    }    
}
