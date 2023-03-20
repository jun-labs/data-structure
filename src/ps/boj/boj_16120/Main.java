package ps.boj.boj_16120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static String word;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        word = input.getString();

        for (int index = 0; index < word.length(); index++) {
            stack.push(word.charAt(index));
            if (stack.size() >= 4) {
                if (isPPAP()) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push('P');
                }
            }
        }
        if (stack.size() == 1 && stack.pop() == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }

    static boolean isPPAP() {
        int size = stack.size();
        return stack.get(size - 1) == 'P' &&
                stack.get(size - 2) == 'A' &&
                stack.get(size - 3) == 'P'
                && stack.get(size - 4) == 'P';
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
