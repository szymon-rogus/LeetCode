package algorithms.medium;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii">...</a>
 * This solution beats 31.54% other Java submissions' memory complexity
 * This solution beats 60.43% other Java submissions' runtime
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        int jumps = 0;
        int pointer = 0;

        while (pointer < nums.length - 1) {
            int currentValue = nums[pointer];
            int nextPosition = pointer;
            int nextValue = nums[pointer];
            for (int i = pointer + 1; i <= pointer + currentValue; i++) {
                if (i == nums.length - 1) {
                    return ++jumps;
                }
                if (nums[i] + i >= nextValue + nextPosition && nums[i] != 0) {
                    nextValue = nums[i];
                    nextPosition = i;
                }
            }

            pointer = nextPosition;
            jumps++;
        }
        return jumps;
    }
}
