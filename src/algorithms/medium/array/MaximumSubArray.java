package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray">...</a>
 * This solution beats 99.56% other Java submissions' runtime
 * This solution beats 13.11% other Java submissions' memory complexity
 */
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int pointer = 0;
        int localSum = 0;
        while (pointer < nums.length) {
            localSum += nums[pointer];
            sum = Math.max(sum, localSum);
            localSum = Math.max(0, localSum);
            pointer++;
        }
        return sum;
    }
}
