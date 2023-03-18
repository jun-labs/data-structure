package ps.programmers.ps.쿼드압축_후_개수_세기;

public class Solution {

    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        recursive(0, 0, totalSize, arr);
        return answer;
    }

    private void recursive(int x, int y, int size, int[][] array) {
        if (check(x, y, size, array)) {
            answer[array[x][y]]++;
            return;
        }

        recursive(x, y, size / 2, array);
        recursive(x, y + size / 2, size / 2, array);
        recursive(x + size / 2, y, size / 2, array);
        recursive(x + size / 2, y + size / 2, size / 2, array);

    }

    private boolean check(int x, int y, int size, int[][] array) {
        if (size == 1) {
            return true;
        }

        for (int xIndex = x; xIndex < x + size; xIndex++) {
            for (int yIndex = y; yIndex < y + size; yIndex++) {
                if (array[x][y] != array[xIndex][yIndex]) return false;
            }
        }
        return true;
    }
}
