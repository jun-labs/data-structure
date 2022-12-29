package ps.programmers.디펜스_게임;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    static Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    public int solution(int n, int k, int[] enemy) {
        int length = enemy.length;

        for (int index = 0; index < length; index++) {
            n -= enemy[index];
            queue.add(enemy[index]);

            if (n < 0) {
                if (k >= 1 && !queue.isEmpty()) {
                    k--;
                    n += queue.poll();
                } else {
                    return index;
                }
            }
        }
        return enemy.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        int k = 4;
        int[] enemy = {3, 3, 3, 3};
        System.out.println(solution.solution(n, k, enemy));
    }
}
