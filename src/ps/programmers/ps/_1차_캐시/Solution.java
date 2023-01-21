package ps.programmers.ps._1차_캐시;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    static Deque<String> deque = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            if (deque.size() < cacheSize) {
                if (deque.isEmpty()) {
                    answer += 5;
                } else {
                    if (deque.contains(city)) {
                        answer += 1;
                    } else {
                        answer += 5;
                    }
                }
                deque.addLast(city);
            } else {
                if (deque.contains(city)) {
                    deque.remove(city);
                    answer += 1;
                } else {
                    answer += 5;
                    deque.removeFirst();
                }
                deque.addLast(city);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int cashSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        Solution solution = new Solution();
        System.out.println(solution.solution(cashSize, cities2));
    }
}
