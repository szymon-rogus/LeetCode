package algorithms.medium.DP;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets">...</a>
 * This solution beats 43.66% other Java submissions' runtime
 * This solution beats 65.99% other Java submissions' memory complexity
 */
public class MinimumCostForTickets {

    /// O(n) runtime - we have to hold ALL days from 1 to max in days, even those unused
    public int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        dp[1] = costs[0];
        Set<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }

        for (int i = 1; i <= days[days.length - 1]; i++) {
            if (set.contains(i)) {
                if (i <= 7) {
                    int oneDay = dp[i - 1] + costs[0];
                    int twoDay = costs[1];
                    int threeDay = costs[2];
                    dp[i] = Math.min(oneDay, Math.min(twoDay, threeDay));
                } else if (i <= 30) {
                    int oneDay = dp[i - 1] + costs[0];
                    int twoDay = dp[i - 7] + costs[1];
                    int threeDay = costs[2];
                    dp[i] = Math.min(oneDay, Math.min(twoDay, threeDay));
                } else {
                    int oneDay = dp[i - 1] + costs[0];
                    int twoDay = dp[i - 7] + costs[1];
                    int threeDay = dp[i - 30] + costs[2];
                    dp[i] = Math.min(oneDay, Math.min(twoDay, threeDay));
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[days[days.length - 1]];
    }
}
