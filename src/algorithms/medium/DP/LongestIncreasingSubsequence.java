package algorithms.medium.DP;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/triangle">...</a>
 * This solution beats 46.32% other Java submissions' runtime
 * This solution beats 76.88% other Java submissions' memory complexity
 */
public class LongestIncreasingSubsequence {

    /**
     * Bottom-up approach
     * @param nums input array
     * @return maximum increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        int solution = 1;
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = nums.length - 2; i >= 0; i--) {

            int longest = 0;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] < nums[k] && dp[k] > longest) {
                    longest = dp[k];
                }
            }
            dp[i] += longest;
            if (dp[i] > solution) solution = dp[i];
        }

        return solution;
    }
}
