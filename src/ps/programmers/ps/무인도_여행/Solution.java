package ps.programmers.ps.무인도_여행;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> answer = new ArrayList<>();

    public int[] solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int x = 0; x < maps.length; x++) {
            String[] temp = maps[x].split("");
            for (int y = 0; y < temp.length; y++) {
                map[x][y] = temp[y];
                if (map[x][y].equals("X")) {
                    visited[x][y] = true;
                }
            }
        }

        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length(); y++) {
                if (!map[x][y].equals("X")) {
                    bfs(x, y);
                }
            }
        }
        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);
        return answer.stream()
                .mapToInt(integer -> integer)
                .toArray();
    }

    static int bfs(int x, int y) {
        int count = 0;
        visited[x][y] = true;
        count += Integer.parseInt(map[x][y]);
        map[x][y] = "X";

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int index = 0; index < 4; index++) {
                int nextX = position.x + dx[index];
                int nextY = position.y + dy[index];
                if (moveable(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    count += Integer.parseInt(map[nextX][nextY]);
                    map[nextX][nextY] = "X";
                    queue.add(new Position(nextX, nextY));
                }
            }
        }
        answer.add(count);
        return count;
    }

    static boolean moveable(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && !map[x][y].equals("X") && !visited[x][y];
    }

    public static void main(String[] args) throws Exception {
        String[] array = {"X591X", "X1X5X", "X231X", "1XXX1"};
        System.out.println(new Solution().solution(array));
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("[(x, y) %s %s", x, y);
        }
    }
}
