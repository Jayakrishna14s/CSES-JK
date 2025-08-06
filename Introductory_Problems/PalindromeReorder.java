import java.util.Scanner;

class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); 
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder("");

        int countOdd = 0;
        int oddIndex = -1;
        for(int i = 0; i < 26; i++) {
            countOdd += cnt[i] & 1;
            if(cnt[i] % 2 == 1) {
                oddIndex = i;
            }
        }

        if(countOdd > 1) {
            sb.append("NO SOLUTION");
        } else {
            for(int i = 0; i < 26; i++) {
                char ch =  ( char) ('A' + i);
                for(int j = 0; j < cnt[i] / 2; j++) {
                    sb.append(ch);
                }
            }
            if(oddIndex != -1)
                sb.append((char) ('A' + oddIndex));

            for(int i = 25; i>=0; i--) {
                char ch =  ( char) ('A' + i);
                for(int j = 0; j < cnt[i] / 2; j++) {
                    sb.append(ch);
                }
            }
        }

        System.out.println(sb.toString());
    }    
}
