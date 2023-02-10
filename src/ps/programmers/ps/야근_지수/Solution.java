package ps.programmers.ps.야근_지수;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 참조 https://moonsbeen.tistory.com/160
 */
class Solution {
    static long answer = 0;

    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.offer(work);
        }

        while (n > 0) {
            int work = queue.poll();
            if (work == 0) break;
            work -= 1;
            queue.offer(work);
            n -= 1;
        }

        for (int number : queue) {
            answer += sqr(number);
        }
        return answer;
    }

    private long sqr(int number) {
        return (long) Math.pow(number, 2);
    }

    public static void main(String[] args) throws Exception {
        int a = Integer.MAX_VALUE;
        int b = 1;
        System.out.println(a + b);
    }
}
