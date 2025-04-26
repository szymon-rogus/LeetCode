package algorithms.easy.array;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct">...</a>
 * This solution beats 30.00% other Java submissions' memory complexity
 * This solution beats 33.59% other Java submissions' runtime
 */
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public int minimumOperations(int[] nums) {
        List<Integer> checkList = new LinkedList<>();

        /// we want to find first occurrence of duplicates starting from the end of array (as we remove from the start)
        for (int i = nums.length - 1; i >= 0; i--) {
            /// if we come up with the first duplicate, we set pointer to this position and divide it by 3
            /// as this is the number of elements removed in every operation.
            if (checkList.contains(nums[i])) {
                int position = i + 1;
                return position % 3 == 0 ? position / 3 : position / 3 + 1;
            }
            checkList.add(nums[i]);
        }

        return 0;
    }
}
