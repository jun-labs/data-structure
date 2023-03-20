package ps.boj.boj_17609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://haerang94.tistory.com/411
public class Main {

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        for (int index = 0; index < n; index++) {
            String word = input.getString();
            char[] array = word.toCharArray();
            if (isPalindrome(array, 0, word.length() - 1)) {
                System.out.println(0);
                continue;
            }
            if (isPalindromeV2(array, 0, word.length() - 1)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    private static boolean isPalindrome(char[] array, int left, int right) {
        while (left <= right) {
            if (array[left] != array[right]) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }


    private static boolean isPalindromeV2(char[] array, int left, int right) {
        while (left <= right) {
            if (array[left] != array[right]) {//다름
                boolean a = isPalindrome(array, left + 1, right);
                boolean b = isPalindrome(array, left, right - 1);
                return a != false || b != false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
