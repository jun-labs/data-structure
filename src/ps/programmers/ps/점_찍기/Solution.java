package ps.programmers.ps.점_찍기;

public class Solution {

    public long solution(int k, int d) {
        long answer = 0;

        for (long index = 0; index <= d / k; index++) {
            long x = k * index;
            long y = (long) Math.sqrt(
                    (long) Math.pow(d, 2) - (long) Math.pow(x, 2)
            ) / k;
            answer += (y + 1);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int k = 2;
        int d = 4;

        Solution solution = new Solution();
        System.out.println(solution.solution(k, d));
    }
}
