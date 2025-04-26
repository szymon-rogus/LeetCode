package algorithms.easy.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays">...</a>
 * This solution beats 24.11% other Java submissions' memory complexity in version1
 * This solution beats 54.32% other Java submissions' runtime in version1
 * This solution beats 79.93% other Java submissions' memory complexity in version2
 * This solution beats 27.33% other Java submissions' runtime in version2
 */
public class MakeTwoArraysEqualByReversingSubArrays {

    ///  this specific solution has runtime complexity of O(n*log(n))
    /// and memory solution of O(log(n))
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(arr, target);
    }

    ///  this version works with runtime od O(n)
    /// and memory of O(n)
    public static boolean canBeEqual2(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int el : target) {
            if (map.containsKey(el)) {
                int count = map.get(el);
                map.put(el, ++count);
            } else {
                map.put(el, 1);
            }
        }

        for (int el : arr) {
            if (map.containsKey(el)) {
                int count = map.remove(el);
                if (count > 1) {
                    map.put(el, --count);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
}
