package ps.boj.boj_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int targetNode;
    static int[] nodes;
    static boolean[] visited;
    static int answer = 0;
    static int root = 0;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        nodes = new int[n];
        visited = new boolean[n];

        for (int index = 0; index < n; index++) {
            nodes[index] = input.integer();
            if (nodes[index] == -1) root = index;
        }

        targetNode = input.integer();

        deleteNode(targetNode);
        count(root);
        System.out.println(answer);
    }

    private static void deleteNode(int node) {
        nodes[node] = Integer.MAX_VALUE;

        for (int index = 0; index < n; index++) {
            if (nodes[index] == node) deleteNode(index);
        }
    }

    private static void count(int node) {
        visited[node] = true;
        boolean leaf = true;

        if (nodes[node] != Integer.MAX_VALUE) {
            for (int index = 0; index < n; index++) {
                if (nodes[index] == node && !visited[index]) {
                    count(index);
                    leaf = false;
                }
            }
            if (leaf) answer++;
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
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
