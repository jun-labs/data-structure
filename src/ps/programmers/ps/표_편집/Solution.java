package ps.programmers.ps.표_편집;

import java.util.Stack;

/**
 * U X: 현재 선택된 행에서 X칸 위를 선택
 * D X: 현재 선택된 행에서 X칸 아래에 있는 행을 선택
 * C: 현재 선택된 행을 삭제한 후 바로 아래 행을 선택. 마지막일 경우 바로 윗 행을 선택
 * Z: 가장 최근에 삭제된 행을 원래대로 복구(현재 선택된 행은 바뀌지 않음)
 */
public class Solution {
    static Stack<Integer> remove = new Stack<>();
    static int size;
    static int pointer;

    public static String solution(int n, int k, String[] cmd) {
        size = n;
        pointer = k;

        for (String eachCommand : cmd) {
            char command = eachCommand.charAt(0);

            if (command == 'U') pointer -= Integer.parseInt(eachCommand.substring(2));
            else if (command == 'D') pointer += Integer.parseInt(eachCommand.substring(2));
            else if (command == 'C') {
                remove.add(pointer);
                size--;
                if (pointer == size) pointer -= 1;
            } else if (command == 'Z') {
                if (remove.pop() <= pointer) pointer++;
                size++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("O".repeat(Math.max(size, 0)));

        while (!remove.isEmpty()) {
            stringBuilder.insert(remove.pop(), "X");
        }
        return stringBuilder.toString();
    }
}
