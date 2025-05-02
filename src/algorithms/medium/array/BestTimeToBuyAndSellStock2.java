package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">...</a>
 * This solution beats 57.66% other Java submissions' memory complexity
 * This solution beats 77.56% other Java submissions' runtime
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPointer = 0;
        int sellPointer = 0;

        for (int i = 0; i < prices.length; i++) {
            /// when we pass local maximum, we have to sell it on the passed local maximum - greedy approach
            if (prices[i] <= prices[sellPointer]) {
                profit += prices[sellPointer] - prices[buyPointer];
                buyPointer = i;
            }
            /// sellPointer will always follow iteration
            sellPointer = i;
        }

        /// in case we reached the end of loop but has not time to sell due to lack of local maximum (end of right neighbor)
        if (sellPointer > buyPointer) profit += prices[sellPointer] - prices[buyPointer];

        return profit;
    }
}
