package algorithms.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays">...</a>
 * This solution beats 24.11% other Java submissions' memory complexity
 * This solution beats 54.32% other Java submissions' runtime
 */
public class MakeTwoArraysEqualByReversingSubArrays {

    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(arr, target);
    }
}
