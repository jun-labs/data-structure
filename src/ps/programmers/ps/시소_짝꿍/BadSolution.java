package ps.programmers.ps.시소_짝꿍;

import java.util.Arrays;

class BadSolution {

    static int[] distance = {2, 3, 4};
    static long answer = 0;

    public long solution(int[] weights) {
        Arrays.sort(weights);
        for (int x = 0; x < weights.length - 1; x++) {
            for (int y = x + 1; y < weights.length; y++) {
                if (weights[x] == weights[y]) {
                    answer++;
                    continue;
                }
                int weightA = weights[x];
                int weightB = weights[y];

                int a = 0;
                int b = 0;

                if (weightA > weightB) {
                    a = weightA;
                    b = weightB;
                } else {
                    a = weightB;
                    b = weightA;
                }
                if (getGCD(a, b) == 1) {
                    continue;
                }

                if (a * 2 == b * 4) answer++;
                else if (a * 2 == b * 3) answer++;
                else if (a * 3 == b * 4) answer++;
            }
        }
        return answer;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static void main(String[] args) throws Exception {
        int[] weights = {100, 180, 360, 100, 270};
        BadSolution solution = new BadSolution();
//        System.out.println(solution.solution(weights));
        System.out.println(BadSolution.getGCD(30, 17));

    }
}
