package ps.programmers.ps._2xn타일링;

public class Solution {
    static final int a1 = 1;
    static int[] array;
    static long value = 1000000007;

    public int solution(int n) {
        array = new int[n + 1];
        array[0] = 1;
        array[1] = a1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
            array[i] %= value;
        }

        return array[n];
    }
}
