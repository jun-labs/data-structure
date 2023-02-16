package ps.programmers.ps.시소_짝꿍;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    static long answer = 0;
    static Map<Double, Integer> map = new HashMap<>();

    public long solution(int[] weights) {
        Arrays.sort(weights);
        for (int weight : weights) {
            answer += calculate(weight);
        }
        return answer;
    }

    public long calculate(int weight) {
        long result = 0;

        double caseA = weight * 1.0;
        double caseB = (weight * 2.0) / 4.0;
        double caseC = (weight * 2.0) / 3.0;
        double caseD = (weight * 3.0) / 4.0;

        if (map.containsKey(caseA)) {
            result += map.get(caseA);
        }
        if (map.containsKey(caseB)) {
            result += map.get(caseB);
        }
        if (map.containsKey(caseC)) {
            result += map.get(caseC);
        }
        if (map.containsKey(caseD)) {
            result += map.get(caseD);
        }
        map.put(caseA, map.getOrDefault(weight * 1.0, 0) + 1);
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] weights = {100, 180, 360, 100, 270};
        Solution solution = new Solution();
        System.out.println(solution.solution(weights));
    }
}
