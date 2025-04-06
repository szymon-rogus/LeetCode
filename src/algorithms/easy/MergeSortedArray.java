package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array">...</a>
 * This solution beats 77.75% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                //swap bigger and zero
                nums1[pointer1 + pointer2 + 1] = nums1[pointer1];
                nums1[pointer1] = 0;

                pointer1--;
            } else {
                //swap bigger and zero
                nums1[pointer1 + pointer2 + 1] = nums2[pointer2];
                nums2[pointer2] = 0;

                pointer2--;
            }
        }

        if (pointer2 >= 0) {
            if (pointer2 + 1 >= 0) System.arraycopy(nums2, 0, nums1, 0, pointer2 + 1);
        }
    }
}
