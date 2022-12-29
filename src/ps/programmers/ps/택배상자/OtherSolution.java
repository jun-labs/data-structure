package ps.programmers.ps.택배상자;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OtherSolution {

    static int cursor = 0;
    static Queue<Integer> mainStack = new LinkedList<>();
    static Stack<Integer> subStack = new Stack<>();

    public int solution(int[] order) {
        for (int index = 0; index < order.length; index++) {
            subStack.add(index + 1);

            while (!subStack.isEmpty()) {
                if (order[cursor] == subStack.peek()) {
                    mainStack.add(subStack.pop());
                    cursor++;
                } else {
                    break;
                }
            }
        }
        return mainStack.size();
    }

    public static void main(String[] args) throws Exception {
        int[] order = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        OtherSolution solution = new OtherSolution();
        System.out.println(solution.solution(order2));
    }
}
