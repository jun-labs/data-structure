package ps.boj.boj_14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 최초 시도 풀이
public class Main2 {
    static int n, m, x, y, k;
    static int[][] map;
    static Map<Integer, Integer> command = new HashMap<>();
    static int[] execution;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static {
        command.put(1, 0);
        command.put(2, 1);
        command.put(3, 3);
        command.put(4, 2);
    }

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        x = input.integer();
        y = input.integer();
        k = input.integer();
        execution = new int[k];
        map = new int[n][m];

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                map[x][y] = input.integer();
            }
        }

        for (int index = 0; index < k; index++) {
            execution[index] = input.integer();
        }
    }

    static boolean moveable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Dice {
        static int[][] map = new int[4][3];
        static int row = 3;
        static int column = 2;

        int bottomX;
        int bottomY;

        int topX;
        int topY;

        static {
            map[0][1] = 2;
            map[1][0] = 4;
            map[1][1] = 1;
            map[1][2] = 3;
            map[2][1] = 5;
            map[3][1] = 6;
        }

        public Dice() {
            this.topX = 1;
            this.topY = 1;

            this.bottomX = 3;
            this.bottomY = 1;
        }

        void moveSouth() {
            int temp = map[0][1];
            for (int index = 0; index < row; index++) {
                map[index][1] = map[index + 1][1];
            }
            map[row][1] = temp;


        }

        void moveNorth() {
            int temp = map[row][1];
            for (int index = row; index >= 1; index--) {
                map[index][1] = map[index - 1][1];
            }
            map[0][1] = temp;
        }

        void moveWest() {
            int left = map[1][0];
            int middle = map[1][1];
            int right = map[1][2];

            map[1][0] = middle;
            map[1][1] = right;
            map[1][2] = left;

            topX = 1;
            topY = 1;

        }

        void moveEast() {
            int left = map[1][0];
            int middle = map[1][1];
            int right = map[1][2];

            map[1][0] = right;
            map[1][1] = left;
            map[1][2] = middle;
        }

        void print() {
            for (int x = 0; x <= row; x++) {
                for (int y = 0; y <= column; y++) {
                    System.out.print(map[x][y] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) throws Exception {
            Dice dice = new Dice();
            dice.print();
            ;
            System.out.println();
            dice.moveSouth();
            dice.print();
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
    }
}
