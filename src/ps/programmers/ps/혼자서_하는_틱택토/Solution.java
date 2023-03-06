package ps.programmers.ps.혼자서_하는_틱택토;

class Solution {

    private char[][] map;

    public int solution(String[] board) {
        int circle = 0;
        int other = 0;
        map = new char[board.length][board[0].length()];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length(); y++) {
                map[x][y] = board[x].charAt(y);
                if (map[x][y] == 'O') {
                    circle++;
                } else if (map[x][y] == 'X') {
                    other++;
                }
            }
        }
        if (circle == 0 && other == 0) {
            return 1;
        }
        if (circle - other < 0 || circle - other >= 2) {
            return 0;
        }
        if (isWin('O')) {
            if (isWin('X') || other + 1 != circle) {
                return 0;
            }
            return 1;
        }
        if (isWin('X')) {
            if (isWin('O') || circle != other) {
                return 0;
            }
            return 1;
        }
        return 1;
    }

    private boolean isWin(char character) {
        // 대각선 아래
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] != '.' && map[0][0] == character) {
            return true;
        }
        // 제일 위 가로
        if (map[0][0] == map[0][1] && map[0][1] == map[0][2] && map[0][0] != '.' && map[0][0] == character) {
            return true;
        }
        // 중간 가로
        if (map[1][0] == map[1][1] && map[1][1] == map[1][2] && map[1][0] != '.' && map[1][0] == character) {
            return true;
        }
        // 제일 아래 가로
        if (map[2][0] == map[2][1] && map[2][1] == map[2][2] && map[2][0] != '.' && map[2][0] == character) {
            return true;
        }
        // 왼쪽 대각선 아래
        if (map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[0][2] != '.' && map[0][2] == character) {
            return true;
        }
        // 제일 왼쪽 아래
        if (map[0][0] == map[1][0] && map[1][0] == map[2][0] && map[0][0] != '.' && map[0][0] == character) {
            return true;
        }
        // 가운데 아래
        if (map[0][1] == map[1][1] && map[1][1] == map[2][1] && map[0][1] != '.' && map[0][1] == character) {
            return true;
        }
        // 제일 오른쪽 아래
        if (map[0][2] == map[1][2] && map[1][2] == map[2][2] && map[0][2] != '.' && map[0][2] == character) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        String[] board4 = {"...", "...", "..."};
        String[] finalExample = {"XXX", "XOO", "OOO"};
        Solution solution = new Solution();
        System.out.println(solution.solution(finalExample));
    }
}
