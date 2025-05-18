package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/sort-colors">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 80.93% other Java submissions' memory complexity
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int num : nums) {
            if (num == 0) red++;
            if (num == 1) white++;
            if (num == 2) blue++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            }
            else if (blue > 0) {
                nums[i] = 2;
                blue--;
            }
        }
    }
}
