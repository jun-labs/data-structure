package ps.boj.boj_1976;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();

        parent = new int[n + 1];

        for (int index = 1; index <= n; index++) {
            parent[index] = index;
        }

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                int nubmer = input.integer();
                if (nubmer == 1) {
                    union(x, y);
                }
            }
        }

        int start = find(input.integer());

        for (int index = 1; index < m; index++) {
            int city = input.integer();
            if (start != find(city)) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
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
    }

    static int find(int index) {
        if (index == parent[index]) return index;
        return find(parent[index]);
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

