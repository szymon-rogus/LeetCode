package algorithms.easy.array;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">...</a>
 * This solution beats 96.58% other Java submissions' memory complexity
 * This solution beats 99.81% other Java submissions' runtime
 */
public class BestTimeToBuyAndSellStock {

    /// Greedy approach
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPointer = 0;

        /// iterate over everyday
        for (int i = 0; i < prices.length; i++) {

            /// if we come up with better buy prices, we stick to it
            if (prices[buyPointer] > prices[i]) buyPointer = i;

            /// if we can get more profit, we update profit
            if (prices[i] - prices[buyPointer] > profit) profit = prices[i] - prices[buyPointer];
        }
        return profit;
    }
}
