package algorithms.easy.list;

import dataStrucutres.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists">...</a>
 * This solution beats 12.84% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
