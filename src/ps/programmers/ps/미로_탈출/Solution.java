package ps.programmers.ps.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static String[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        Point source = new Point(-1, -1);
        Point lever = new Point(-1, -1);
        Point target = new Point(-1, -1);

        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length(); y++) {
                map[x][y] = maps[x].split("")[y];
                if (map[x][y].equals("S")) {
                    source.x = x;
                    source.y = y;
                }
                if (map[x][y].equals("L")) {
                    lever.x = x;
                    lever.y = y;
                }
                if (map[x][y].equals("E")) {
                    target.x = x;
                    target.y = y;
                }
            }
        }
        int fromSourceToLever = fromAToB(source, lever);
        if (fromSourceToLever == 0) {
            return -1;
        }

        int fromLeverToTarget = fromAToB(new Point(lever.x, lever.y, fromSourceToLever), target);
        if (fromLeverToTarget == 0) {
            return -1;
        }
        return fromLeverToTarget;
    }

    static int fromAToB(Point source, Point target) {
        boolean[][] visited = createBoard();
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        visited[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            int count = p.count;

            if (x == target.x && y == target.y) {
                return count;
            }

            for (int index = 0; index < 4; index++) {
                int nextX = x + dx[index];
                int nextY = y + dy[index];
                if (moveable(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, count + 1));
                }
            }
        }
        return 0;
    }

    private static boolean[][] createBoard() {
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y].equals("X")) {
                    visited[x][y] = true;
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] array = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        String[] array2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        String[] array3 = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        String[] array4 = {"XXXXXL", "XXXXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        String[] array5 = {"XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX"};
        System.out.println(solution.solution(array));
    }

    static boolean moveable(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && !map[x][y].equals("X");
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.count = 0;
        }

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
