package ps.boj.boj_2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        m = input.getInteger();
        board = new int[n][m];
        visited = new int[2][n][m];

        for (int row = 0; row < n; row++) {
            char[] temp = input.next().toCharArray();
            for (int col = 0; col < m; col++) {
                board[row][col] = temp[col] - '0';
            }
        }
        for (int axis = 0; axis < 2; axis++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    visited[axis][row][col] = -1;
                }
            }
        }

        bfs();
        System.out.println(answer(n, m));
    }

    static void bfs() {
        Point point = new Point(0, 0, 0);
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int count = poll.count;

            for (int index = 0; index < 4; index++) {
                int nextX = x + dx[index];
                int nextY = y + dy[index];
                if (moveable(nextX, nextY)) {
                    if (!meetWall(nextX, nextY) && visited[count][nextX][nextY] == -1) {
                        visited[count][nextX][nextY] = visited[count][x][y] + 1;
                        queue.add(new Point(nextX, nextY, count));
                    } else if (meetWall(nextX, nextY) && count == 0 && visited[count][nextX][nextY] == -1) {
                        visited[count + 1][nextX][nextY] = visited[count][x][y] + 1;
                        queue.add(new Point(nextX, nextY, count + 1));
                    }
                }
            }
        }
    }

    static boolean moveable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static boolean meetWall(int x, int y) {
        return board[x][y] == 1;
    }

    static int answer(int n, int m) {
        if (visited[0][n - 1][m - 1] == -1 && visited[1][n - 1][m - 1] == -1) {
            return -1;
        }
        if (visited[0][n - 1][m - 1] != -1 && visited[1][n - 1][m - 1] != -1) {
            return Math.min(visited[0][n - 1][m - 1], visited[1][n - 1][m - 1]);
        }
        return Math.max(visited[0][n - 1][m - 1], visited[1][n - 1][m - 1]);
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s", x, y, count);
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
