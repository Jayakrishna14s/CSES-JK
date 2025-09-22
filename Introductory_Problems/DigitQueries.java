
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class DigitQueries {
    public static int query(long k) {
        long[] power = new long[20];
        power[0] = 1;

        for (int i = 1; i < 20; i++) {
            power[i] = power[i - 1] * 10;
        }

        long countDigits = 0;
        long prevDigits = 0;
        int digits = -1;

        for (int i = 1; true; i++) {
            long curDigits = (power[i] - power[i - 1]) * i;
            countDigits += curDigits;
            if (countDigits >= k) {
                digits = i;
                break;
            }
            prevDigits = countDigits;
        }

        long lo = power[digits - 1], hi = power[digits] - 1;
        long res = -1;
        long resPos = -1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            long startPos = prevDigits + (mid - power[digits - 1]) * digits + 1;
            if (startPos <= k) {
                res = mid;
                resPos = startPos;

                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        long index = k - resPos;
        char digit = (res + "").charAt((int) index);

        return digit - '0';

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            long k = Long.parseLong(br.readLine());
            bw.write(query(k) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
