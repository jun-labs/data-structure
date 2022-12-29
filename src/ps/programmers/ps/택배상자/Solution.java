package ps.programmers.ps.택배상자;

import java.util.Stack;

public class Solution {

    static Stack<Integer> queue = new Stack<>();
    static Stack<Integer> numbers = new Stack<>();

    static int count = 0;
    static int targetIndex = 0;

    public int solution(int[] order) {
        for (int index = order.length; index >= 0; index--) {
            numbers.add(index);
        }

        for (int index = 0; index < order.length; index++) {
            int targetValue = order[targetIndex];

            int currentNumbersValue;

            if (queue.isEmpty()) {
                currentNumbersValue = numbers.peek();
            } else {
                currentNumbersValue = queue.peek();
            }

            if (targetValue == currentNumbersValue) {
                if (!queue.isEmpty()) {
                    queue.pop();
                } else {
                    numbers.pop();
                }
                increaseValue();
            } else if (!queue.isEmpty() && queue.peek() == targetValue) {
                queue.pop();
                increaseValue();
            } else {
                while (!numbers.isEmpty()) {
                    int value = numbers.peek();
                    if (value == targetValue) {
                        increaseValue();
                        numbers.pop();
                        break;
                    } else {
                        queue.add(numbers.pop());
                    }
                }
            }
        }
        return count;
    }

    private static void increaseValue() {
        count++;
        targetIndex++;
    }

    public static void main(String[] args) throws Exception {
        int[] order = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.solution(order));
    }
}
