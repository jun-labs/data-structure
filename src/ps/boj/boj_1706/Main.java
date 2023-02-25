package ps.boj.boj_1706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        r = input.integer();
        c = input.integer();
        map = new char[r][c];

        for (int x = 0; x < r; x++) {
            String row = input.getString();
            for (int y = 0; y < c; y++) {
                map[x][y] = row.charAt(y);
            }
        }

        String min = String.valueOf((char) ('z' + 1));

        for (int row = 0; row < r; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col <= c; col++) {
                if (col == c || map[row][col] == '#') {
                    String temp = sb.toString();
                    if (temp.length() >= 2 && temp.compareTo(min) < 0) {
                        min = temp;
                    }
                    sb = new StringBuilder();
                } else {
                    sb.append(map[row][col]);
                }
            }
        }

        for (int col = 0; col < c; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row <= r; row++) {
                if (row == r || map[row][col] == '#') {
                    String temp = sb.toString();
                    if (temp.length() >= 2 && temp.compareTo(min) < 0) {
                        min = temp;
                    }
                    sb = new StringBuilder();
                } else {
                    sb.append(map[row][col]);
                }
            }
        }
        System.out.println(min);
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
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
