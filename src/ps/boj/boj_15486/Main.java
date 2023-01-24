package ps.boj.boj_15486;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        T = new int[n + 2];
        P = new int[n + 2];
        dp = new int[n + 2];

        for (int index = 0; index < n; index++) {
            T[index + 1] = input.integer();
            P[index + 1] = input.integer();
        }

        for (int index = 1; index <= n + 1; index++) {
            dp[index] = Math.max(dp[index - 1], dp[index]);

            int day = index + T[index];
            if (day <= n + 1) {
                dp[day] = Math.max(dp[day], dp[index] + P[index]);
            }
        }
        System.out.println(dp[n + 1]);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
