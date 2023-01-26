package ps.programmers.ps.빛의_경로_사이클;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 참조: https://record-developer.tistory.com/99
class Solution {

    static boolean[][][] visited;
    static int row, column;
    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int[] solution(String[] grid) {
        List<Integer> temp = new ArrayList<>();

        row = grid.length;
        column = grid[0].length();

        visited = new boolean[row][column][4];

        for (int r = 0; r < row; r++) {
            for (int col = 0; col < column; col++) {
                for (int direction = 0; direction < 4; direction++) {
                    if (!visited[r][col][direction]) {
                        temp.add(cycle(grid, r, col, direction));
                    }
                }
            }
        }

        Collections.sort(temp);
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static int cycle(String[] grid,
                            int currentRow,
                            int currentColumn,
                            int direction) {
        int count = 0;

        while (!visited[currentRow][currentColumn][direction]) {
            count++;
            visited[currentRow][currentColumn][direction] = true;

            if (grid[currentRow].charAt(currentColumn) == 'L') {
                direction = (direction + 3) % 4;
            } else if (grid[currentRow].charAt(currentColumn) == 'R') {
                direction = (direction + 1) % 4;
            }

            currentRow = (currentRow + dx[direction] + row) % row;
            currentColumn = (currentColumn + dy[direction] + column) % column;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        String[] grid = {"SL", "LR"};
        Solution solution = new Solution();
        System.out.println(solution.solution(grid));
    }
}
