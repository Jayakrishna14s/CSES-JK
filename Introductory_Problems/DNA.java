import java.util.Scanner;

class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int res = 0;
        int n = s.length(); 

        for(int i = 0, j = 0; i < n; i += j, j = 0) {
            char ch = s.charAt(i);
            while(i + j < n && s.charAt(i + j) == ch) {
                j++;
            }

            res = Math.max(res, j);
        }

        System.out.println(res);
        sc.close();
    }    
}
