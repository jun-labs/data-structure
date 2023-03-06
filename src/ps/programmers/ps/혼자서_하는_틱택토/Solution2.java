package ps.programmers.ps.혼자서_하는_틱택토;

class Solution2 {

    private char[][] map;
    static int COUNT = 3;

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
        if (isWinAs('O')) {
            if (isWinAs('X') || other + 1 != circle) {
                return 0;
            }
            return 1;
        }
        if (isWinAs('X')) {
            if (isWinAs('O') || circle != other) {
                return 0;
            }
            return 1;
        }
        return 1;
    }

    private boolean isWinAs(char character) {
        // 대각선(오른쪽 아래)
        boolean flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[index][index] != map[1][1] || map[index][index] != character || map[index][index] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 대각선(오른쪽 위)
        flag = true;
        for (int index = COUNT - 1; index >= 0; index--) {
            if (map[index][COUNT - 1 - index] != map[1][1] || map[index][COUNT - 1 - index] != character || map[index][COUNT - 1 - index] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 가로(위)
        flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[0][index] != map[0][0] || map[0][index] != character || map[0][index] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 가로(중간)
        flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[1][index] != map[1][0] || map[1][index] != character || map[1][index] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 가로(아래)
        flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[2][index] != map[2][0] || map[2][index] != character || map[2][index] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 세로(왼쪽)
        flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[index][0] != map[0][0] || map[index][0] != character || map[index][0] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 세로(가운데)
        flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[index][1] != map[1][1] || map[index][1] != character || map[index][1] == '.') {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        // 세로(오른쪽)
        flag = true;
        for (int index = 0; index < COUNT; index++) {
            if (map[index][2] != map[1][2] || map[index][2] != character || map[index][2] == '.') {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        String[] board4 = {"...", "...", "..."};
        String[] otherExample = {"XXX", "XOO", "OOO"};

        Solution2 solution = new Solution2();
        System.out.println(solution.solution(otherExample));
    }
}
