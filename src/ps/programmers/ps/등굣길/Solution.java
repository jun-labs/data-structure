package ps.programmers.ps.등굣길;

public class Solution {

    private static final int DIVISION = 1_000_000_007;
    static int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        map = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;
        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < m + 1; col++) {
                if (map[row][col] == -1) continue;
                if (map[row][col - 1] > 0) map[row][col] += (map[row][col - 1] % DIVISION);
                if (map[row - 1][col] > 0) map[row][col] += (map[row - 1][col] % DIVISION);
            }
        }
        return map[n][m];
    }
}
