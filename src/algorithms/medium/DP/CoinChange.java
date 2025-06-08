package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/coin-change">...</a>
 * This solution beats 78.55% other Java submissions' runtime
 * This solution beats 72.83% other Java submissions' memory complexity
 */
/// SICK FUCK!
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        /// memoization table
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) dp[i] = amount + 1;
        dp[0] = 0;

        /// bottom up approach - we count the minimum coins needed for every amount between 0 and our target amount
        /// starting from 0 and building and saving the next amount in dp table
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
