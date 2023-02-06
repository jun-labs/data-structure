package ps.boj.boj_1283;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://velog.io/@cjhlsb/Algorithm-%EB%B0%B1%EC%A4%80-1283%EB%B2%88-%EB%8B%A8%EC%B6%95%ED%82%A4-%EC%A7%80%EC%A0%95
public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        String[] alpha = new String[n];
        boolean[] registered = new boolean[26];

        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = input.getString();
        }

        for (int index = 0; index < alpha.length; index++) {
            if (alpha[index].contains(" ")) {
                boolean flag = false;
                String[] alphaList = alpha[index].split(" ");
                for (int start = 0; start < alphaList.length; start++) {
                    if (!registered[Character.toUpperCase(alphaList[start].charAt(0)) - 65]) {
                        registered[Character.toUpperCase(alphaList[start].charAt(0)) - 65] = true;
                        alphaList[start] = "[" + alphaList[start].charAt(0) + "]" + alphaList[start].substring(1);
                        flag = true;
                        break;
                    }
                }

                alpha[index] = String.join(" ", alphaList);

                if (!flag) {
                    for (int start = 0; start < alpha[index].length(); start++) {
                        char character = alpha[index].charAt(start);
                        if (character == ' ') continue;
                        if (!registered[Character.toUpperCase(character) - 65]) {
                            registered[Character.toUpperCase(character) - 65] = true;
                            alpha[index] = alpha[index].substring(0, start) + "[" + character + "]" + alpha[index].substring(start + 1);
                            break;
                        }
                    }
                }
            } else {
                for (int start = 0; start < alpha[index].length(); start++) {
                    char character = alpha[index].charAt(start);
                    if (!registered[Character.toUpperCase(character) - 65]) {
                        registered[Character.toUpperCase(character) - 65] = true;
                        alpha[index] = alpha[index].substring(0, start) + "[" + character + "]" + alpha[index].substring(start + 1);
                        break;
                    }
                }
            }
        }

        for (String i : alpha) {
            System.out.println(i);
        }
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            return br.readLine();
        }
    }
}
