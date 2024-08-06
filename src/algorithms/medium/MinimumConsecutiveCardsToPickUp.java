package algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up">...</a>
 * This solution beats 26.73% other Java submissions' memory complexity
 * This solution beats 36.68% other Java submissions' runtime
 */
public class MinimumConsecutiveCardsToPickUp {
    public static int minimumCardPickup(int[] cards) {
        int difference = cards.length + 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                int localDiff = i - map.get(cards[i]) + 1;
                difference = Math.min(difference, localDiff);
                map.replace(cards[i], i);
            } else {
                map.put(cards[i], i);
            }
        }
        return difference == cards.length + 1 ? -1 : difference;
    }
}
