package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 78.59% other Java submissions' memory complexity
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int pStart = 0;
        int limit = 1;

        for (int pEnd = 1; pEnd < nums.length; pEnd++) {
            /// Hard to explain. This time we have two cases when we swap values.
            /// Basic case when the value changes and when we have the same values on both pointers
            /// but limit has not been met. As we can store up to 2 duplicates we swap also when we are below the limit
            if (nums[pStart] != nums[pEnd]) {
                pStart++;
                int temp = nums[pStart];
                nums[pStart] = nums[pEnd];
                nums[pEnd] = temp;
                /// we reset the limit as we start with new value on startPointer
                limit = 1;
            } else if (limit < 2) {
                pStart++;
                int temp = nums[pStart];
                nums[pStart] = nums[pEnd];
                nums[pEnd] = temp;
                /// we still work with the same value but we search for the second one to reach the limit now
                limit++;
            }
        }

        return ++pStart;
    }
}
