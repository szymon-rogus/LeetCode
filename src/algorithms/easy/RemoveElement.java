package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/remove-element">...</a>
 * This solution beats 82.72% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int pointerStart = 0;
        int pointerEnd = nums.length - 1;
        int elements = 0;

        while (pointerStart < pointerEnd) {
            if (nums[pointerStart] != val) {
                pointerStart++;
            } else {
                while (nums[pointerEnd] == val) {
                    pointerEnd--;
                    if (pointerEnd == pointerStart) break;
                }
                nums[pointerStart] = nums[pointerEnd];
                nums[pointerEnd] = val;

                pointerStart++;
                pointerEnd--;
            }
        }

        int counter = 0;
        while (counter < nums.length && nums[counter] != val) {
            elements++;
            counter++;
        }
        return elements;
    }
}
