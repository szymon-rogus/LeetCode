package algorithms.easy.DP;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 77.96% other Java submissions' memory complexity
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int oneStep = cost[cost.length - 2];
        int twoStep = cost[cost.length - 1];

        for (int i = cost.length - 3; i >= 0; i--) {
            int temp = cost[i] + Math.min(oneStep, twoStep);
            twoStep = oneStep;
            oneStep = temp;
        }

        return Math.min(oneStep, twoStep);
    }
}
