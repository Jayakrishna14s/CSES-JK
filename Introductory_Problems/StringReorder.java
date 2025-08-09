import java.util.Scanner;

class StringReorder {

    public static String reOrder(char[] s) {
        int n = s.length;
        int[] cnt = new int[26];
        for (char ch : s) {
            cnt[ch - 'A']++;
            if (cnt[ch - 'A'] > (n + 1) / 2)
                return "-1";
        }

        char prev = '*';
        int rem = n;

        for (int i = 0; i < n; i++) {
            if (rem % 2 == 1) {
                int maxFreq = (rem + 1) / 2;
                int maxFreqIdx = -1;

                for (int j = 0; j < 26; j++) {
                    if (cnt[j] == maxFreq) {
                        maxFreqIdx = j;
                        break;
                    }
                }

                if (maxFreqIdx != -1) {
                    prev = (char) (maxFreqIdx + 'A');
                    cnt[maxFreqIdx]--;
                    s[i] = prev;
                } else {
                    for (int j = 0; j < 26; j++) {
                        char ch = (char) ('A' + j);
                        if (cnt[j] > 0 && ch != prev) {
                            prev = ch;
                            cnt[j]--;
                            break;
                        }
                    }
                    s[i] = prev;
                }
            } else {
                for (int j = 0; j < 26; j++) {
                    char ch = (char) ('A' + j);
                    if (cnt[j] > 0 && ch != prev) {
                        prev = ch;
                        cnt[j]--;
                        break;
                    }
                }
                s[i] = prev;
            }
            rem--;
        }

        return new String(s);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            char[] s = sc.next().toCharArray();
            System.out.println("\n" + reOrder(s));
        }
    }
}
