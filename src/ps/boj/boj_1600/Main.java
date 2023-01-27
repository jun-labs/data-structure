package ps.boj.boj_1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int w, h;
    static int map[][];
    static int[] horseXMove = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[] horseYMove = {-1, -2, 1, 2, -1, -2, 1, 2};

    static int[] monkeyXMove = {1, -1, 0, 0};
    static int[] monkeyYMove = {0, 0, 1, -1};

    static int min = Integer.MAX_VALUE;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        k = input.integer();
        w = input.integer();
        h = input.integer();
        map = new int[h][w];

        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                map[x][y] = input.integer();
            }
        }

        visited = new boolean[h][w][k + 1];
        Monkey monkey = new Monkey(0, 0, 0, k);
        int result = bfs(monkey);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static int bfs(Monkey monkey) {
        visited[monkey.x][monkey.y][k] = true;
        Queue<Monkey> queue = new LinkedList<>();
        queue.add(monkey);

        while (!queue.isEmpty()) {
            Monkey pollMonkey = queue.poll();

            if (pollMonkey.x == h - 1 && pollMonkey.y == w - 1) {
                return pollMonkey.count;
            }

            for (int index = 0; index < 4; index++) {
                int nextX = pollMonkey.x + monkeyXMove[index];
                int nextY = pollMonkey.y + monkeyYMove[index];
                if (moveeable(nextX, nextY) && isFirstVisited(visited[nextX][nextY][pollMonkey.jump])) {
                    visited[nextX][nextY][pollMonkey.jump] = true;
                    queue.add(new Monkey(nextX, nextY, pollMonkey.count + 1, pollMonkey.jump));
                }
            }

            if (pollMonkey.jump > 0) {
                for (int index = 0; index < horseXMove.length; index++) {
                    int nextX = pollMonkey.x + horseXMove[index];
                    int nextY = pollMonkey.y + horseYMove[index];
                    if (moveeable(nextX, nextY) && isFirstVisited(visited[nextX][nextY][pollMonkey.jump - 1])) {
                        visited[nextX][nextY][pollMonkey.jump - 1] = true;
                        queue.add(new Monkey(nextX, nextY, pollMonkey.count + 1, pollMonkey.jump - 1));
                    }
                }
            }
        }
        return min;
    }

    private static boolean isFirstVisited(boolean visited) {
        return !visited;
    }

    static boolean moveeable(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w && map[x][y] != 1;
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

    static class Monkey {
        int x;
        int y;
        int count;
        int jump;

        public Monkey(int x, int y, int count, int jump) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.jump = jump;
        }

        @Override
        public String toString() {
            return "Monkey{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", jump=" + jump +
                    '}';
        }
    }
}
