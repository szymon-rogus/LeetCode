package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/house-robber/">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 47.13% other Java submissions' memory complexity
 */
public class HouseRobber {

    /**
     * Top-bottom with memoization
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int prePrevious = nums[0];
        int previous = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(previous, prePrevious + nums[i]);

            prePrevious = previous;
            previous = current;
        }

        return previous;
    }
}
