package ps.boj.boj_2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static String word;

    public static void main(String[] args) throws Exception {
        word = input.getString();

        if (word.length() % 2 != 0) {
            System.out.println(0);
            return;
        }
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) == '(') {
                value *= 2;
                stack.push(word.charAt(index));
            } else if (word.charAt(index) == '[') {
                value *= 3;
                stack.push(word.charAt(index));
            } else if (word.charAt(index) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                } else if (word.charAt(index - 1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if (word.charAt(index) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                } else if (word.charAt(index - 1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        System.out.println(result);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
