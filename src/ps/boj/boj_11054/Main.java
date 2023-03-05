package ps.boj.boj_11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://cocoon1787.tistory.com/702
public class Main {

    static int answer = 0;
    static int n;
    static int[] numbers;
    static int[] up;
    static int[] down;

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        numbers = new int[n];
        up = new int[n];
        down = new int[n];

        for (int index = 0; index < n; index++) {
            numbers[index] = input.getInteger();
        }

        for (int index = 0; index < n; index++) {
            int max = 0;
            for (int subIndex = 0; subIndex < index; subIndex++) {
                if (numbers[subIndex] < numbers[index]) {
                    max = Math.max(max, up[subIndex]);
                }
            }
            up[index] = max + 1;
        }

        for (int index = n - 1; index >= 0; index--) {
            int max = 0;
            for (int subIndex = n - 1; subIndex > index; subIndex--) {
                if (numbers[subIndex] < numbers[index]) {
                    max = Math.max(max, down[subIndex]);
                }
            }
            down[index] = max + 1;
        }

        for (int index = 0; index < n; index++) {
            answer = Math.max(answer, up[index] + down[index] - 1);
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
