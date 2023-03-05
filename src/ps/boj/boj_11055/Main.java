package ps.boj.boj_11055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] numbers;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        numbers = new int[n];
        dp = new int[n];

        for (int index = 0; index < n; index++) {
            numbers[index] = input.getInteger();
        }

        for (int index = 0; index < n; index++) {
            dp[index] = numbers[index];
            for (int subIndex = 0; subIndex < index; subIndex++) {
                if (numbers[subIndex] < numbers[index] && dp[index] < dp[subIndex] + numbers[index]) {
                    dp[index] = dp[subIndex] + numbers[index];
                }
            }
        }

        int max = 0;
        for(int index=0; index<n; index++){
            max= Math.max(max, dp[index]);
        }
        System.out.println(max);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String next() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
