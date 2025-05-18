package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/jump-game">...</a>
 * This solution beats 80.94% other Java submissions' runtime
 * This solution beats 55.91% other Java submissions' memory complexity
 */
public class JumpGame {

    /// the whole logic is based on mathematical induction
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        /// current goal is a pointer we have to reach in specific step
        int currentGoal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int distance = currentGoal - i;
            /// if from this point we can reach current goal, we can set this point to be out current goal
            /// because reaching this point will guarantee reaching the end of array
            if (nums[i] >= distance) {
                currentGoal = i;
                if (currentGoal == 0) return true;
            }
        }

        return currentGoal == 0;
    }
}
