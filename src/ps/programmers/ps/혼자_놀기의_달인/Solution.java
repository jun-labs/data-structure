package ps.programmers.ps.혼자_놀기의_달인;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    private boolean[] visited;
    private List<Integer> cardGroups = new ArrayList<>();
    private int[] cardList;

    public int solution(int[] cards) {
        int length = cards.length;
        visited = new boolean[length];
        cardList = cards;

        for (int index = 0; index < length; index++) {
            int cardCount = count(index);
            cardGroups.add(cardCount);
        }
        cardGroups.sort(Comparator.reverseOrder());
        if (cardGroups.size() == 1) {
            return 0;
        }
        return cardGroups.get(0) * cardGroups.get(1);
    }

    private int count(int index) {
        int cardIndex = index;
        int count = 0;
        while (!visited[cardIndex]) {
            visited[cardIndex] = true;
            count++;
            cardIndex = cardList[cardIndex] - 1;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        int[] n = {8, 6, 3, 7, 2, 5, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(n));
    }
}
