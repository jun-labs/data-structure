package ps.programmers.ps.덧칠하기;

public class Solution {

    static boolean[] visited;

    public int solution(int n, int m, int[] section) {
        if (m == 1) {
            return section.length;
        }
        visited = new boolean[n + 1];

        for (int index = 0; index <= n; index++) {
            visited[index] = true;
        }

        for (int index = 0; index < section.length; index++) {
            visited[section[index]] = false;
        }

        int answer = 0;
        for (int index = 1; index <= n; index++) {
            int k = index + m;
            if (!visited[index]) {
                if (k >= n) {
                    k = n;
                    for (int subIndex = index; subIndex <= n; subIndex++) {
                        visited[subIndex] = true;
                    }
                } else {
                    for (int subIndex = index; subIndex < k; subIndex++) {
                        visited[subIndex] = true;
                    }
                }
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};
//        System.out.println(solution.solution(n, m, section));
        System.out.println(solution.solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}
