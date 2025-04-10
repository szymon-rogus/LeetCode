package algorithms.medium;

/**
 * <a href="https://leetcode.com/problems/find-peak-element">...</a>
 * This solution beats 22.40% other Java submissions' memory complexity
 * This solution beats 100.00% other Java submissions' runtime
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        /// we bisect to direction where the neighbour of current mid-point is greater
        while (s < e) {
            int m = s + (e - s) / 2;
            if ((m + 1) < nums.length && nums[m] > nums[m + 1]) {
                e = m;
            }
            else {
                s = m + 1;
            }
        }
        return  s;
    }
}
