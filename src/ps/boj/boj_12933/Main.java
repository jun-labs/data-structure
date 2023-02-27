package ps.boj.boj_12933;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String word;
    static char[] validAlphas = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws Exception {
        word = input.getString();
        int n = word.length();
        char[] alphas = word.toCharArray();
        if (alphas.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        while (n != 0) {
            int pointer = 0;
            int index = 0;
            boolean flag = false;
            int[] temp = new int[5];

            while (index < alphas.length) {
                if (alphas[index] == validAlphas[pointer]) {
                    temp[pointer++] = index;
                    if (pointer == 5) {
                        n -= 5;
                        flag = true;
                        pointer = 0;
                        for (int tempIndex = 0; tempIndex < 5; tempIndex++) {
                            alphas[temp[tempIndex]] = 'X';
                        }
                    }
                }
                index++;
            }
            if (flag) count++;
            else break;
        }
        System.out.println(n == 0 ? count : -1);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
