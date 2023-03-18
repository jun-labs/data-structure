package ps.programmers.ps.햄버거_만들기;

import java.util.Stack;

public class Solution {

    static final Stack<Integer> stack = new Stack<>();
    static int answer = 0;

    public int solution(int[] ingredient) {
        for (int eachIngredient : ingredient) {
            stack.push(eachIngredient);
            if (stack.size() >= 4) {
                if (makeable()) {
                    answer++;
                    int stackIndex = 0;
                    while (stackIndex < 4) {
                        stack.pop();
                        stackIndex++;
                    }
                }
            }
        }
        return answer;
    }

    private boolean makeable() {
        int size = stack.size();
        return stack.get(size - 1) == 1 &&
                stack.get(size - 2) == 3 &&
                stack.get(size - 3) == 2 &&
                stack.get(size - 4) == 1;
    }

    public static void main(String[] args) throws Exception {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.solution(ingredient2));
    }
}
