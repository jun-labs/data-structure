package ps.programmers.양과_늑대;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int maxSheepCount = 1;
    static int[] info;
    static List[] nodes = new ArrayList[17];

    public int solution(int[] _info, int[][] edges) {
        info = _info;

        for (int index = 0; index < 17; index++) {
            nodes[index] = new ArrayList();
        }

        for (int[] e : edges) {
            nodes[e[0]].add(e[1]);
        }

        dfs(1, 0, 0, new ArrayList<>());
        return maxSheepCount;
    }

    private void dfs(int sheep, int wolf, int index, List<Integer> next) {
        maxSheepCount = Math.max(maxSheepCount, sheep);

        List<Integer> temp = new ArrayList<>();
        temp.addAll(nodes[index]);
        temp.addAll(next);
        temp.remove(Integer.valueOf(index));

        for (int element : temp) {
            int nextSheep = sheep + (info[element] == 0 ? 1 : 0);
            int nextWolf = wolf + (info[element] == 1 ? 1 : 0);

            if (nextSheep > nextWolf) {
                dfs(nextSheep, nextWolf, element, temp);
            }
        }
    }
}
