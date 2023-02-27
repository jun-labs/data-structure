package ps.boj.boj_15886;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = input.integer();
        String word = input.getString();

        int answer = 0;
        for (int index = 0; index < n - 1; index++) {
            if (word.charAt(index) == 'E' && word.charAt(index + 1) == 'W') {
                answer += 1;
            }
        }
        System.out.println(answer);
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
