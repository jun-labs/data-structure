package ps.programmers.ps.이모티콘_할인행사;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int USER_DISCOUNT_RATE = 0;
    private static final int AVAILABLE_PURCHASING_PRICE = 1;

    static int[] discounts = {10, 20, 30, 40};
    static int maxServiceJoinCount = 0;
    static int emotionPurchasePrice = 0;
    static List<Integer> discount = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        for (int index = 0; index < emoticons.length; index++) {
            emoticons[index] /= 100;
        }
        dfs(0, emoticons.length, users, emoticons);
        return new int[]{maxServiceJoinCount, emotionPurchasePrice};
    }

    static void dfs(int count, int n, int[][] users, int[] emotions) {
        if (count == n) {
            solve(users, emotions);
            return;
        }
        for (int index = 0; index < 4; index++) {
            discount.add(discounts[index]);
            dfs(count + 1, n, users, emotions);
            discount.remove(discount.size() - 1);
        }
    }

    static void solve(int[][] users, int[] emotions) {
        int joinServiceCount = 0;
        int totalPrice = 0;

        for (int[] user : users) {
            int price = 0;
            for (int index = 0; index < emotions.length; index++) {
                if (discount.get(index) >= user[USER_DISCOUNT_RATE]) {
                    price += emotions[index] * (100 - discount.get(index));
                }
            }
            if (price >= user[AVAILABLE_PURCHASING_PRICE]) {
                joinServiceCount++;
            } else {
                totalPrice += price;
            }
        }
        if (maxServiceJoinCount < joinServiceCount) {
            maxServiceJoinCount = joinServiceCount;
            emotionPurchasePrice = totalPrice;
        } else {
            if (maxServiceJoinCount != joinServiceCount) {
                return;
            }
            if (emotionPurchasePrice < totalPrice) {
                emotionPurchasePrice = totalPrice;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emotions = {7000, 9000};
        Solution solution = new Solution();
        System.out.println(solution.solution(users, emotions));
    }
}
