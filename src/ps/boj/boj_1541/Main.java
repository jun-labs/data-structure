package ps.boj.boj_1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        String row = input.getString();
        String[] splitByMinus = row.split("\\-");

        int result = 0;
        for (int index = 0; index < splitByMinus.length; index++) {
            int temp = 0;
            String[] splitByPlus = splitByMinus[index].split("\\+");
            for (String value : splitByPlus) {
                temp += Integer.parseInt(value);
            }
            if (index == 0) result += temp;
            else result -= temp;
        }
        System.out.println(result);
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
