package algorithms.easy.array;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/split-the-array">...</a>
 * This solution beats 31.20% other Java submissions' memory complexity
 * This solution beats 64.84% other Java submissions' runtime
 */
public class SplitTheArray {

    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        /// we have to count frequency of each distinct element.
        /// if an element appears in more than 2 copies in array, we can't create 2 distinct arrays
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count == 2) return false;
                map.put(num, ++count);
            } else {
                map.put(num, 1);
            }
        }
        return true;
    }
}
