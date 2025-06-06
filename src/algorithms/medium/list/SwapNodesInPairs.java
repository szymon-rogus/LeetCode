package algorithms.medium.list;

import dataStructures.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/submissions">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 77.39% other Java submissions' memory complexity
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Seems to be super easy when you don't have to use pointers :)
        ListNode newNext = new ListNode(head.val, swapPairs(head.next.next));
        return new ListNode(head.next.val, newNext);
    }
}
