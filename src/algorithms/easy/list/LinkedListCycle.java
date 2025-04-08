package algorithms.easy.list;

import dataStructures.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle">...</a>
 * This solution beats 10.88% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode oneStep = new ListNode(head.val, head.next);
        ListNode twoStep = new ListNode(head.val, head.next);

        while (true) {
            if (twoStep.next != null && twoStep.next.next != null) {
                twoStep = twoStep.next.next;
            } else {
                return false;
            }

            if (oneStep.next != null) {
                oneStep = oneStep.next;
            }

            if (oneStep == twoStep) return true;
        }
    }
}
