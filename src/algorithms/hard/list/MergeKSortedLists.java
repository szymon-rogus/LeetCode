package algorithms.hard.list;

import dataStrucutres.ListNode;
import java.util.Arrays;
import static algorithms.easy.list.MergeTwoSortedLists.mergeTwoLists;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists">...</a>
 * This solution beats 8.66% other Java submissions' memory complexity
 * This solution beats 75.43% other Java submissions' runtime
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);

        ListNode[] one = Arrays.copyOfRange(lists, 0, lists.length / 2);
        ListNode[] two = Arrays.copyOfRange(lists, lists.length / 2, lists.length);

        // I used implementation from other exercise - the method can be transferred here
        return mergeTwoLists(mergeKLists(one), mergeKLists(two));
    }
}
