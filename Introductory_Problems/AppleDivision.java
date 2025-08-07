
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class AppleDivision {

    public static long generateSubsets(int[] apples, long subsetSum, int idx, long sum) {
        if (idx == -1) {
            long remSum = sum - subsetSum;
            long diff = Math.abs(subsetSum - remSum);

            return diff;
        }

        return Math.min(generateSubsets(apples, subsetSum + apples[(int) idx], idx - 1, sum),
                generateSubsets(apples, subsetSum, idx - 1, sum));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] apples = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long sum = 0;
        for (int apple : apples) {
            sum += apple;
        }

        bw.write(generateSubsets(apples, 0, n - 1, sum) + "\n");

        bw.flush();
    }
}
