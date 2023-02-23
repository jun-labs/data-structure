package ps.boj.boj_13023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Integer>[] relationship;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        relationship = new ArrayList[n];

        for (int index = 0; index < n; index++) {
            relationship[index] = new ArrayList<>();
        }

        for (int index = 0; index < m; index++) {
            int friendA = input.integer();
            int friendB = input.integer();
            relationship[friendA].add(friendB);
            relationship[friendB].add(friendA);
        }

        for (int index = 0; index < n; index++) {
            visited = new boolean[n];
            dfs(index, 0);
        }

        System.out.println(0);
    }

    private static void dfs(int me, int count) {
        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }

        List<Integer> friends = relationship[me];

        for (Integer friend : friends) {
            if (!visited[friend]) {
                visited[friend] = true;
                dfs(friend, count + 1);
                visited[friend] = false;
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

        public String next() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public char[] nToCharArray() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
}
