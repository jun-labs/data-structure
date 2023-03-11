package ps.programmers.ps.바탕화면_정리;

public class Solution {

    static char[][] map;
    static int maxRow = 0;
    static int minRow = 1000000;
    static int maxCol = 0;
    static int minCol = 1000000;

    public int[] solution(String[] wallpaper) {
        map = new char[wallpaper.length][wallpaper[0].length()];
        for (int x = 0; x < wallpaper.length; x++) {
            for (int y = 0; y < wallpaper[0].length(); y++) {
                map[x][y] = wallpaper[x].charAt(y);
                if (map[x][y] == '#') {
                    maxRow = Math.max(x, maxRow);
                    minRow = Math.min(x, minRow);
                    maxCol = Math.max(y, maxCol);
                    minCol = Math.min(y, minCol);
                }

            }
        }
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] case1 = {".#...", "..#..", "...#."};
        String[] case4 = {"..", "#."};
        String[] case3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] array = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(solution.solution(array));
    }
}
