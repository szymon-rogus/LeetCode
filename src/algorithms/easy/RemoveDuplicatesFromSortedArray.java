package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/remove-element">...</a>
 * This solution beats 12.96% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int pStart = 0;

        for (int pEnd = 1; pEnd < nums.length; pEnd++) {
            /// if we encounter distinct number we switch it with next position of start pointer
            /// and move startPointer to this position
            if (nums[pStart] != nums[pEnd]) {
                pStart++;
                int temp = nums[pStart];
                nums[pStart] = nums[pEnd];
                nums[pEnd] = temp;
            }
        }

        /// ++ because pStart marks index from 0;
        return pStart + 1;
    }
}
