package ps.programmers.ps.두_큐_합_같게_만들기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

// 참조: https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%91%90-%ED%81%90-%ED%95%A9-%EA%B0%99%EA%B2%8C-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv2-Java
public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> queueA = Arrays.stream(queue1).boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> queueB = Arrays.stream(queue2).boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        long sumA = getSum(queueA);
        long sumB = getSum(queueB);

        long sum = sumA + sumB;
        long target = sum / 2;

        if (sum % 2 != 0) {
            return -1;
        }

        int p1 = 0;
        int p2 = 0;
        int maxSize = queueA.size() + queueB.size();

        while (p1 <= maxSize && p2 <= maxSize) {
            if (sumA == target) return p1 + p2;
            if (sumA < target) {
                Integer value = queueB.poll();
                sumA += value;
                sumB -= value;
                queueA.add(value);
                p1++;
            } else {
                Integer value = queueA.poll();
                sumA -= value;
                sumB += value;
                queueB.add(value);
                p2++;
            }
        }
        return -1;
    }

    public long getSum(Queue<Integer> queue) {
        return queue.isEmpty() ? 0 : queue.stream().reduce(Integer::sum).get();
    }

    public static void main(String[] args) {
        int[] arrayA = {3, 3, 3, 3};
        int[] arrayB = {3, 3, 21, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(arrayA, arrayB));
    }
}

