package ps.boj.boj_15886;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {

    static Set<Integer> set = new HashSet<>();
    static String word;

    public static void main(String[] args) throws Exception {
        int n = input.integer();
        word = input.getString();

        for (int index = 0; index < n; index++) {
            boolean[] visited = new boolean[n];
            dfs(index, visited);
        }
        System.out.println(set.size());
    }

    private static void dfs(int index, boolean[] visited) {
        if (set.contains(index)) {
            return;
        }
        if (visited[index]) {
            set.add(index);
            return;
        }
        visited[index] = true;
        if (word.charAt(index) == 'E') dfs(index + 1, visited);
        else dfs(index - 1, visited);
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
