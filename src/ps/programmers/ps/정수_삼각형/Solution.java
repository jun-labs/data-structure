package ps.programmers.ps.정수_삼각형;

public class Solution {
    static int[][] dp;
    static int answer = 0;

    public int solution(int[][] triangle) {
        int rowLimit = triangle.length;
        int columnLimit = triangle.length;

        dp = new int[rowLimit][columnLimit];
        dp[0][0] = triangle[0][0];

        for (int row = 1; row < rowLimit; row++) {
            for (int column = 0; column < triangle[row].length; column++) {
                if (column == 0) dp[row][column] = dp[row - 1][column] + triangle[row][column];
                else dp[row][column] = Math.max(dp[row - 1][column], dp[row - 1][column - 1]) + triangle[row][column];
            }
        }

        for (int index = 0; index < rowLimit; index++) {
            answer = Math.max(answer, dp[rowLimit - 1][index]);
        }
        return answer;
    }
}
