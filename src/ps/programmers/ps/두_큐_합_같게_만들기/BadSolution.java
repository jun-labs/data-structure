package ps.programmers.ps.두_큐_합_같게_만들기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BadSolution {

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

        int answer = 0;
        int maxSize = queueA.size() + queueB.size();
        while (sumA != target) {
            if (sumA < target) {
                Integer value = queueB.poll();
                sumA += value;
                sumB -= value;
                queueA.add(value);
            } else if (sumA > target) {
                Integer value = queueA.poll();
                sumA -= value;
                sumB += value;
                queueB.add(value);
            } else if (sumA == target) {
                return answer;
            }
            answer++;
        }
        return -1;
    }

    public long getSum(Queue<Integer> queue) {
        return queue.isEmpty() ? 0 : queue.stream().reduce(Integer::sum).get();
    }

    public static void main(String[] args) throws Exception {
        int[] arrayA = {3, 3, 3, 3};
        int[] arrayB = {3, 3, 21, 3};
        int[] arrayAA = {1, 1, 1};
        int[] arrayBB = {5, 1, 1};
        int[] arrayAAA = {1, 1, 1, 1, 1};
        int[] arrayBBB = {1, 1, 1, 9, 1};
        Solution solution = new Solution();
        System.out.println(solution.solution(arrayA, arrayB));
    }
}
