package algorithms.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">...</a>
 * This solution beats 32.36% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int mergerPointer = 0;
        int[] mergedList = new int[nums1.length + nums2.length];
        while (true) {
            if (pointer1 >= nums1.length) {
                for (; pointer2 < nums2.length; pointer2++) {
                    mergedList[mergerPointer] = nums2[pointer2];
                    mergerPointer++;
                }
                break;
            }
            if (pointer2 >= nums2.length) {
                for (; pointer1 < nums1.length; pointer1++) {
                    mergedList[mergerPointer] = nums1[pointer1];
                    mergerPointer++;
                }
                break;
            }

            if (nums1[pointer1] <= nums2[pointer2]) {
                mergedList[mergerPointer] = nums1[pointer1];
                mergerPointer++;
                pointer1++;
            } else {
                mergedList[mergerPointer] = nums2[pointer2];
                mergerPointer++;
                pointer2++;
            }
        }

        if (mergedList.length % 2 == 1) {
            return mergedList[mergedList.length/2];
        }
        int medianIndex = mergedList.length/2;

        return (double) (mergedList[medianIndex] + mergedList[medianIndex - 1]) /2;
    }

    /**
     * Version with higher abstraction level
     * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays">...</a>
     * This solution beats 60.24% other Java submissions' memory complexity
     * This solution beats 63.45% other Java submissions' runtime
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        List<Integer> mergedList = new LinkedList<>();
        while (true) {
            if (pointer1 >= nums1.length) {
                for (; pointer2 < nums2.length; pointer2++) {
                    mergedList.add(nums2[pointer2]);
                }
                break;
            }
            if (pointer2 >= nums2.length) {
                for (; pointer1 < nums1.length; pointer1++) {
                    mergedList.add(nums1[pointer1]);
                }
                break;
            }

            if (nums1[pointer1] <= nums2[pointer2]) {
                mergedList.add(nums1[pointer1]);
                pointer1++;
            } else {
                mergedList.add(nums2[pointer2]);
                pointer2++;
            }
        }

        if (mergedList.size() % 2 == 1) {
            return mergedList.get(mergedList.size()/2);
        }
        int medianIndex = mergedList.size()/2;

        return (double) (mergedList.get(medianIndex) + mergedList.get(medianIndex - 1)) /2;
    }
}
