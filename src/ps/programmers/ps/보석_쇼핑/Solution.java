package ps.programmers.ps.보석_쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    static Map<String, Integer> map = new HashMap<>();
    static Set<String> gemSet;
    static Queue<String> queue = new LinkedList<>();

    static int start = 0;
    static int startPointer = 0;
    static int length = Integer.MAX_VALUE;

    public static int[] solution(String[] gems) {
        gemSet = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemSet.size();

        for (int index = 0; index < gems.length; index++) {
            map.put(gems[index], map.getOrDefault(gems[index], 0) + 1);
            queue.add(gems[index]);

            while (map.get(queue.peek()) > 1) {
                map.put(queue.peek(), map.get(queue.poll()) - 1);
                startPointer++;
            }

            if (map.size() == totalKinds && length > (index - startPointer)) {
                start = startPointer;
                length = (index - start);
            }
        }
        return new int[]{start + 1, start + 1 + length};
    }
}
