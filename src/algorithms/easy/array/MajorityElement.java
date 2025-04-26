package algorithms.easy.array;

/**
 * <a href="https://leetcode.com/problems/majority-element">...</a>
 * This solution beats 60.09% other Java submissions' memory complexity
 * This solution beats 99.89% other Java submissions' runtime
 */
public class MajorityElement {

    /// [...](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm)
    public int majorityElement(int[] nums) {
        int counter = 0;
        int currentElement = nums[0];
        for (int num : nums) {
            if (counter == 0) {
                currentElement = num;
                counter++;
            } else if (currentElement == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return currentElement;
    }
}
