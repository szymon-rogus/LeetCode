package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/search-insert-position">...</a>
 * This solution beats 31.54% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        int start = 0;
        int end = nums.length;
        int pointer = (end + start) / 2;
        while (start < end - 1) {
            if (nums[pointer] == target) {
                return pointer;
            }
            if (nums[pointer] < target) {
                start = pointer;

            } else {
                end = pointer;
            }
            pointer = (end + start) / 2;
        }
        return end;
    }
}
