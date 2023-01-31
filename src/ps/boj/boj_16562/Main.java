package ps.boj.boj_16562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://javaju.tistory.com/114
public class Main {

    static int n;
    static int m;
    static int k;
    static int[] friendCost;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        k = input.integer();

        friendCost = new int[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int index = 1; index <= n; index++) {
            friendCost[index] = input.integer();
        }

        for (int index = 1; index <= n; index++) {
            parent[index] = index;
        }

        for (int index = 0; index < m; index++) {
            int friendA = input.integer();
            int friendB = input.integer();
            union(friendA, friendB);
        }

        int friend = 0;
        int answer = 0;

        for (int index = 1; index <= n; index++) {
            int parent = find(index);
            if (visited[parent]) {
                friend++;
                continue;
            }
            if (k - friendCost[index] >= 0) {
                friend++;
                answer += friendCost[index];
                k -= friendCost[index];
                visited[parent] = true;
            }
        }
        if (friend == n) {
            System.out.println(answer);
        } else {
            System.out.println("Oh no");
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
        if (friendCost[x] < friendCost[y]) {
            friendCost[y] = friendCost[x];
        } else {
            friendCost[x] = friendCost[y];
        }
    }

    static int find(int index) {
        if (index == parent[index]) return index;
        return parent[index] = find(parent[index]);
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
