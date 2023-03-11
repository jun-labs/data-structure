package ps.programmers.ps.귤_고르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static Map<Integer, Integer> oranges = new HashMap<>();

    public int solution(int k, int[] tangerine) {
        for (Integer orange : tangerine) {
            oranges.put(orange, oranges.getOrDefault(orange, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(oranges.keySet());
        keys.sort((key1, key2) -> oranges.get(key2) - oranges.get(key1));

        // 중복을 최대한 많이
        int answer = 0;
        for (Integer key : keys) {
            k -= oranges.get(key);
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[] array1 = {1, 3, 2, 5, 4, 5, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(6, array1));
    }
}
