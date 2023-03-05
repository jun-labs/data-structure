package ps.boj.boj_11053;

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
            int max = 0;
            for (int subIndex = 0; subIndex < index; subIndex++) {
                if (numbers[subIndex] < numbers[index]) {
                    max = Math.max(max, dp[subIndex]);
                }
            }
            dp[index] = max + 1;
        }

        int answer = 0;
        for (int index = 0; index < n; index++) {
            answer = Math.max(answer, dp[index]);
        }
        System.out.println(answer);
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
