package algorithms.easy.array;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum">...</a>
 * This solution beats 30.31% other Java submissions' memory complexity
 * This solution beats 98.84% other Java submissions' runtime
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        /// we store value and index in map and search if the possible difference already exists.
        /// As we want to return indices, we keep them as the values in map (and values of nums are store as keys)
        for (int i = 0; i < nums.length; i++) {
            int searched = target - nums[i];

            if (map.containsKey(searched)) {
                int first = map.get(searched);
                return new int[] {first, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
