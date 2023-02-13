package ps.boj.boj_10917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
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

        bfs(0);
        System.out.println(-1);
    }

    private static void bfs(int currentNode) {
        visited[currentNode] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(currentNode, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.nodeNumber == n - 1) {
                System.out.println(node.count);
                System.exit(0);
            }

            List<Integer> linkedNodes = tree.get(node.nodeNumber);

            for (Integer eachNode : linkedNodes) {
                if (!visited[eachNode]) {
                    visited[eachNode] = true;
                    queue.add(new Node(eachNode, node.count + 1));
                }
            }
        }
    }

    static class Node {
        int nodeNumber;
        int count;

        public Node(int nodeNumber, int count) {
            this.nodeNumber = nodeNumber;
            this.count = count;
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
