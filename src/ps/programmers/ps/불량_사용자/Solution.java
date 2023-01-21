package ps.programmers.ps.불량_사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 참조: https://moonsbeen.tistory.com/45
 */
public class Solution {

    static Set<String> kinds = new HashSet<>();
    static String[] regex;
    static String[] users;
    static boolean[] visited;

    public int solution(String[] user_id, String[] baaned_id) {
        regex = new String[baaned_id.length];
        users = user_id;
        visited = new boolean[user_id.length];

        replcaeForRegex(baaned_id);
        backtracking(0, "");

        return kinds.size();
    }

    private static void replcaeForRegex(String[] baaned_id) {
        for (int index = 0; index < baaned_id.length; index++) {
            regex[index] = baaned_id[index].replace("*", ".");
        }
    }

    private void backtracking(int bannedIdIndex, String result) {
        if (bannedIdIndex == regex.length) {
            String[] bannedIds = result.split(" ");
            Arrays.sort(bannedIds);

            String kind = String.join(" ", bannedIds);
            kinds.add(kind);
            return;
        }

        for (int index = 0; index < users.length; index++) {
            if (!visited[index] && users[index].matches(regex[bannedIdIndex])) {
                visited[index] = true;
                backtracking(bannedIdIndex + 1, getResult(result, index));
                visited[index] = false;
            }
        }
    }

    private static String getResult(String result, int index) {
        return result + " " + users[index];
    }

    public static void main(String[] args) throws Exception {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};

        Solution solution = new Solution();
        System.out.println(solution.solution(user_id, banned_id));
    }
}
