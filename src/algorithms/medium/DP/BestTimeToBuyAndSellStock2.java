package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">...</a>
 * This solution beats 77.56% other Java submissions' runtime
 * This solution beats 57.66% other Java submissions' memory complexity
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {

        ///  greedy approach - we are adding to solution any local changes when the price is going up
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
