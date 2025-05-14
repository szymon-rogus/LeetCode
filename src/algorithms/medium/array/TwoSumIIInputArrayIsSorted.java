package algorithms.medium.array;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">...</a>
 * This solution beats 64.69% other Java submissions' memory complexity
 * This solution beats 93.12% other Java submissions' runtime
 */
public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[] {start + 1, end + 1};
            }
        }
        return new int[] {start + 1, end + 1};
    }
}
