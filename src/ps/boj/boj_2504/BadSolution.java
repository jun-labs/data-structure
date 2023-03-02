package ps.boj.boj_2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BadSolution {

    private static String word;

    public static void main(String[] args) throws Exception {
        word = input.getString();

        if (word.length() % 2 != 0) {
            System.out.println(0);
            return;
        }

        Stack<Character> stack = new Stack<>();
        int result = 0;

        int left = 0;
        int right = 0;
        for (int index = 0; index < word.length(); index++) {
            stack.push(word.charAt(index));
            if (word.charAt(index) == '(' || word.charAt(index) == '[') {
                left++;
            } else if (word.charAt(index) == ')' || word.charAt(index) == ']') {
                right++;
            }

            if ((left != 0 && right != 0) && left == right) {
                int multiply = 1;
                int sum = 0;
                char before = 'Z';
                if (stack.size() > 2) {
                    while (!stack.isEmpty()) {
                        char pop = stack.pop();
                        if ((before == '[' && pop == ')') || (before == '(' && pop == ']')) {
                            sum += multiply;
                            multiply = 1;
                            before = pop;
                            continue;
                        }
                        if (pop == ')') {
                            multiply *= 2;
                        } else if (pop == ']') {
                            System.out.println(2);
                            multiply *= 3;
                        }
                        before = pop;
                    }
                    multiply = 1;
                } else {
                    while (!stack.isEmpty()) {
                        char pop = stack.pop();
                        if (pop == ')') {
                            sum += 2;
                        } else {
                            sum += 3;
                        }
                    }
                    multiply = 1;
                }
                result += sum;
            }
        }
        if (left != right) {
            System.out.println(0);
            return;
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
