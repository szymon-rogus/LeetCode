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

        /// two pointer approach
        ListNode oneStep = new ListNode(head.val, head.next);
        ListNode twoStep = new ListNode(head.val, head.next);

        while (true) {
            /// moving 2 steps
            if (twoStep.next != null && twoStep.next.next != null) {
                twoStep = twoStep.next.next;
            } else {
                return false;
            }

            /// moving one step
            if (oneStep.next != null) {
                oneStep = oneStep.next;
            }

            /// if there is a cycle, eventually the two pointer will meet
            if (oneStep == twoStep) return true;
        }
    }
}
