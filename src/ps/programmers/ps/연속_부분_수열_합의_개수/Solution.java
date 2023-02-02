package ps.programmers.ps.연속_부분_수열_합의_개수;

import java.util.HashSet;
import java.util.Set;

class Solution {

    static int maxLength;
    static int[] elementsCopy;
    static Set<Integer> answer = new HashSet<>();

    public int solution(int[] elements) {
        elementsCopy = elements;
        maxLength = elements.length;

        for (int index = 1; index <= elements.length; index++) {
            search(index);
        }
        return answer.size();
    }

    void search(int target) {
        for (int index = 0; index < maxLength; index++) {
            int startNumber = index;
            int count = 0;
            int sum = 0;

            while (true) {
                sum += elementsCopy[startNumber];
                count++;
                startNumber++;
                if (count == target) {
                    answer.add(sum);
                    break;
                }
                if (startNumber >= maxLength) {
                    startNumber = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution.solution(elements));
    }
}
