package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/rotate-array">...</a>
 * This solution beats 28.59% other Java submissions' runtime
 * This solution beats 92.93% other Java submissions' memory complexity
 */
public class RotateArray {

    /**
     * Brutal solution O(n) runtime and memory
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;

        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            rotated[newIndex] = nums[i];
        }

        System.arraycopy(rotated, 0, nums, 0, nums.length);
    }
}
