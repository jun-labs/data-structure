package ps.programmers.ps.바탕화면_정리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BadSolution {
    static char[][] map;
    static int LUX = 0;
    static int LUY = 0;
    static int MAX_DISTANCE = 100_000;
    static int maxRow = 0;
    static int minRow = 1000000;
    static int maxCol = 0;
    static int minCol = 1000000;
    static int shop = 0;
    static List<Point> points = new ArrayList<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int[] solution(String[] wallpaper) {
        map = new char[wallpaper.length][wallpaper[0].length()];
        for (int x = 0; x < wallpaper.length; x++) {
            for (int y = 0; y < wallpaper[0].length(); y++) {
                map[x][y] = wallpaper[x].charAt(y);
                if (map[x][y] == '#') {
                    shop++;
                    maxRow = Math.max(x, maxRow);
                    minRow = Math.min(x, minRow);
                    maxCol = Math.max(y, maxCol);
                    minCol = Math.min(y, minCol);
                }

            }
        }

        for (int x = 0; x < wallpaper.length; x++) {
            for (int y = 0; y < wallpaper[0].length(); y++) {
                if (x == minRow && y == minCol) {
                    if (map[x][y] == '#') {
                        points.add(new Point(x, y, 1));
                    } else {
                        points.add(new Point(x, y, 0));
                    }
                }
            }
        }

        for (int index = 0; index < points.size(); index++) {
            bfs(points.get(index));
        }

        return new int[]{LUX, LUY, maxRow + 1, maxCol + 1};
    }

    static void bfs(Point point) {
        int startRow = point.lux;
        int startCol = point.luy;
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.count == shop) {
                int distance = (maxRow - startRow) + (maxCol - startCol);
                if (distance < MAX_DISTANCE) {
                    LUX = Math.max(startRow, LUX);
                    LUY = Math.max(startCol, LUY);
                    MAX_DISTANCE = distance;
                }
                return;
            }

            for (int index = 0; index < 4; index++) {
                int nextX = poll.lux + dx[index];
                int nextY = poll.luy + dy[index];
                if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length && nextX >= startRow && nextX <= maxRow && nextY >= startCol && nextY <= maxCol && !visited[nextX][nextY]) {
                    queue.add(new Point(nextX, nextY, poll.count + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BadSolution solution = new BadSolution();
        String[] case1 = {".#...", "..#..", "...#."};
        String[] case4 = {"..", "#."};
        String[] case3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] array = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(solution.solution(array));
    }

    static class Point {
        int lux;
        int luy;
        int count;

        public Point(int lux, int luy, int count) {
            this.lux = lux;
            this.luy = luy;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("Row: %s, Col: %s, Count: %s", lux, luy, count);
        }
    }
}
