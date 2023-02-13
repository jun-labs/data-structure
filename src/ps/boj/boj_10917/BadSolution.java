package ps.boj.boj_10917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BadSolution {

    static int n, m;
    static int answer = 10_000;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        visited = new boolean[n];

        for (int index = 0; index < n; index++) {
            tree.add(new ArrayList<>());
        }

        for (int index = 0; index < m; index++) {
            int from = input.integer() - 1;
            int to = input.integer() - 1;
            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        visited[0] = true;
        dfs(0, 0);
        System.out.println(answer == 10_000 ? -1 : answer);
    }

    private static void dfs(int currentNode, int count) {
        if ((currentNode) == (n - 1)) {
            answer = Math.min(answer, count);
            return;
        }

        List<Integer> linked = tree.get(currentNode);

        for (Integer node : linked) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node, count + 1);
                visited[node] = false;
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
    }
}
