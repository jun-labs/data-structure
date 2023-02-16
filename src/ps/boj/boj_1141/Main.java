package ps.boj.boj_1141;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int answer = -100_000;
    static List<String> lst = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws Exception {
        n = input.integer();

        for (int index = 0; index < n; index++) {
            String word = input.getString();
            lst.add(word);
        }
        Collections.sort(lst, (x, y) -> y.length() - x.length());
        for (int index = 0; index < n - 1; index++) {
            List<String> temp = new ArrayList<>();
            temp.add(lst.get(index));
            dfs(index + 1, temp);
        }
        System.out.println(answer);
    }

    static void dfs(int start, List<String> temp) {
        if (start >= n) return;
        answer = Math.max(answer, temp.size());
        for (int index = start; index < n; index++) {
            String word = lst.get(index);
            boolean flag = true;
            for (String eachWord : temp) {
                if (eachWord.startsWith(word) || word.startsWith(eachWord)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                temp.add(word);
                dfs(start + 1, temp);
            }
        }
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            return br.readLine();
        }
    }
}
