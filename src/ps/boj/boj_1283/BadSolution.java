package ps.boj.boj_1283;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BadSolution {

    static int n;
    static Set<String> uniqueAlpha = new HashSet<>();
    static List<String> alpha = new LinkedList<>();
    static Map<String, String> capital = new HashMap<>();
    static List<String> answer = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        n = input.integer();

        for (int index = 0; index < n; index++) {
            String str = input.getString();
            alpha.add(str);
        }

        while (!alpha.isEmpty()) {
            String str = alpha.get(0);
            String[] array = str.split(" ");
            String firstAlpha = array[0];
            if (!isRegistered(firstAlpha)) {
                capital.put(firstAlpha.substring(0, 1).toLowerCase(), firstAlpha.substring(0, 1).toLowerCase());
                firstAlpha = "[" + str.substring(0, 1) + "]" + str.substring(1);
                alpha.remove(0);
                answer.add(firstAlpha);
                continue;
            } else {
                String original = firstAlpha;
                if (array.length == 1) {
                    String sttr = "";
                    for (int index = 0; index < firstAlpha.length(); index++) {
                        if (!isRegistered((firstAlpha.charAt(index) + "").toLowerCase())) {
                            capital.put((firstAlpha.charAt(0) + "").toLowerCase(), (firstAlpha.charAt(0) + "").toLowerCase());
                            sttr += "[" + firstAlpha.charAt(index) + "]" + firstAlpha.substring(index + 1);
                            answer.add(str);
                            alpha.remove(0);
                            break;
                        } else {
                            sttr += firstAlpha.charAt(index);
                        }
                    }
                    answer.add(sttr);
                    alpha.remove(0);
                    continue;
                } else {
                    for (int index = 1; index < array.length; index++) {
                        String secondAlpha = array[index];
                        if (!isRegistered(secondAlpha)) {
                            capital.put((secondAlpha.charAt(0) + "").toLowerCase(), (secondAlpha.charAt(0) + "").toLowerCase());
                            secondAlpha = "[" + secondAlpha.charAt(0) + "]" + secondAlpha.substring(1);
                            answer.add(original + " " + secondAlpha);
                            alpha.remove(0);
                            break;
                        } else {
                            String origin = "";
                            for (int start = 0; start < str.length(); start++) {
                                if (!isRegistered(str.charAt(start) + "")) {
                                    origin += "[" + str.charAt(start) + "]" + str.substring(start + 1);
                                    capital.put(("" + str.charAt(start)).toLowerCase(), ("" + str.charAt(start)).toLowerCase());
                                    answer.add(origin);
                                    alpha.remove(0);
                                    break;
                                } else {
                                    origin += str.charAt(start);
                                }
                            }
                        }
                    }
                }
            }
            alpha.remove(0);

//
//            for (String eachAlpha : answer) {
//                System.out.println(eachAlpha);
//            }
//            break;

//            String original = "";
//            for (int index = 0; index < array.length; index++) {
//                boolean flag = false;
//                String first = array[index];
//                for (int start = 0; start < first.length() - 1; start++) {
//                    String al = first.substring(start, start + 1);
//                    if (!isRegisteredV2(al)) {
//                        if (!flag) {
//                            capital.put(al.toLowerCase(), al.toLowerCase());
//                            original += "[" + al + "]" + first.substring(start + 1);
//                            flag = true;
//                        }
//                    } else {
//                        original += al;
//                    }
//                }
//            }
//            alpha.remove(0);
//            answer.add(original);
        }

        for (String alpha : answer) {
            System.out.println(alpha);
        }
    }

    private static boolean isRegistered(String alpha) {
        return capital.get(alpha.substring(0, 1).toLowerCase()) != null;
    }

    private static boolean isRegisteredV2(String alpha) {
        return capital.get(alpha.toLowerCase()) != null;
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
