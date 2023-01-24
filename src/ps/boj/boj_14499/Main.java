package ps.boj.boj_14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://minhamina.tistory.com/133
public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Map<Integer, Integer> commands = new HashMap<>();

    static {
        commands.put(1, 0);
        commands.put(2, 1);
        commands.put(3, 3);
        commands.put(4, 2);
    }

    public static void main(String[] args) throws Exception {
        n = input.integer();
        m = input.integer();
        x = input.integer();
        y = input.integer();
        k = input.integer();

        map = new int[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                map[x][y] = input.integer();
            }
        }

        Dice currentDice = new Dice(0, 1, 2, 3, 4, 5);
        int[] dice = new int[6];

        for (int index = 0; index < k; index++) {
            int command = input.integer();

            int top = currentDice.top;
            int front = currentDice.front;
            int back = currentDice.back;
            int left = currentDice.left;
            int right = currentDice.right;
            int bottom = currentDice.bottom;

            Dice nextDice;

            if (command == 1) {
                command = commands.get(command);
                nextDice = new Dice(left, front, back, bottom, top, right);
            } else if (command == 2) {
                command = commands.get(command);
                nextDice = new Dice(right, front, back, top, bottom, left);
            } else if (command == 3) {
                command = commands.get(command);
                nextDice = new Dice(front, bottom, top, left, right, back);
            } else {
                command = commands.get(command);
                nextDice = new Dice(back, top, bottom, left, right, front);
            }

            int nextX = x + dx[command];
            int nextY = y + dy[command];

            if (!moveable(nextX, nextY)) {
                continue;
            }

            currentDice = nextDice;
            x = nextX;
            y = nextY;

            if (map[x][y] == 0) {
                map[x][y] = dice[nextDice.bottom];
            } else {
                dice[nextDice.bottom] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[nextDice.top]);
        }
    }

    static boolean moveable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Dice {
        int top, front, back, left, right, bottom;

        Dice(int top, int front, int back, int left, int right, int bottom) {
            this.top = top;
            this.front = front;
            this.back = back;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
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
