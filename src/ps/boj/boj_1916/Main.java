package ps.boj.boj_1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Node>[] nodes;
    static final int MAX_COST = Integer.MAX_VALUE;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        m = input.getInteger();

        nodes = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int index = 1; index <= n; index++) {
            nodes[index] = new ArrayList<>();
            distance[index] = MAX_COST;
        }

        for (int index = 0; index < m; index++) {
            int from = input.getInteger();
            int to = input.getInteger();
            int cost = input.getInteger();
            nodes[from].add(new Node(to, cost));
        }

        int start = input.getInteger();
        int destination = input.getInteger();

        dijkstra(start);
        System.out.println(distance[destination]);
    }

    private static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.destination]) continue;

            visited[node.destination] = true;

            List<Node> nextNodes = nodes[node.destination];
            for (Node nextNode : nextNodes) {
                if (distance[nextNode.destination] > distance[node.destination] + nextNode.cost) {
                    distance[nextNode.destination] = distance[node.destination] + nextNode.cost;
                    queue.add(new Node(nextNode.destination, distance[nextNode.destination]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String next() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
