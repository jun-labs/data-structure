package ps.boj.boj_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 참조: https://moonsbeen.tistory.com/204
public class Main {

    static int n;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        StringBuilder sb = new StringBuilder();

        for (int index = 1; index <= n; index++) {
            int number = input.getInteger();
            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= number) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new int[]{index, number});
        }
        System.out.println(sb);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
