package algorithms.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum">...</a>
 * This solution beats 6.17% other Java submissions' memory complexity
 * This solution beats 99.79% other Java submissions' runtime
 */
public class MinimumSizeSubarraySum {

    /// Two pointer solution - pointers draw the line where we have currently the most accurate subarray.
    /// Greedy solution - when we can obtain subarray of smaller len - we update minimumLen
    public static int minSubArrayLen(int target, int[] nums) {
        int startP = 0;
        int endP = 0;
        int len = 0;
        int minimumLen = nums.length;
        while (endP < nums.length) {
            if (target > 0) {
                target -= nums[endP];
                endP++;
                len++;
            } else {
                minimumLen = Math.min(minimumLen, len);
                if (target + nums[startP] <= 0) {
                    target += nums[startP];
                    startP++;
                    len--;
                } else {
                    target -= nums[endP];
                    endP++;
                    len++;
                }
            }
        }

        while (startP < nums.length && target < 0) {
            minimumLen = Math.min(minimumLen, len);
            if (target + nums[startP] <= 0) {
                target += nums[startP];
                startP++;
                len--;
            } else {
                return minimumLen;
            }
        }

        return target <= 0 ? Math.min(minimumLen, len) : 0;
    }
}
