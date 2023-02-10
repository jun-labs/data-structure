package ps.programmers.ps.야근_지수;

// 시간초과
class Solution_Bad {
    static long init = 100_000;
    static long answer = 100_000;
    static int MAX_COUNT;
    static int COUNT;

    public long solution(int n, int[] works) {
        MAX_COUNT = works.length;
        COUNT = n;

        int[] copy = works.clone();
        dfs(0, 0, copy);
        if (init == answer) {
            return 0;
        }
        return answer;
    }

    private void dfs(int count, int start, int[] array) {
        if (count == COUNT) {
            long sum = sumWorks(array);
            answer = Math.min(answer, sum);
        }

        for (int index = start; index < MAX_COUNT; index++) {
            int value = array[index];
            if (value - 1 >= 0) {
                array[index] -= 1;
                dfs(count + 1, start, array);
                array[index] += 1;
            }
        }
    }

    private long sumWorks(int[] works) {
        long sum = 0;
        for (int index = 0; index < works.length; index++) {
            sum += sqr(works[index]);
        }
        return sum;
    }

    private long sqr(int number) {
        return (long) Math.pow(number, 2);
    }
}
