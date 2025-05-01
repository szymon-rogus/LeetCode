package algorithms.medium.list;

import dataStructures.ListNode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">...</a>
 * This solution beats 26.25% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtimes
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return moveDanglingOne(l2);
        }
        if (l2 == null) {
            return moveDanglingOne(l1);
        }

        int value = l1.val + l2.val;
        if (value > 9) {
            if (l1.next != null) {
                l1.next.val++;
            } else if (l2.next != null) {
                l2.next.val++;
            } else {
                l1.next = new ListNode(1, null);
            }
        }
        return new ListNode(value % 10, addTwoNumbers(l1.next, l2.next));
    }

    private static ListNode moveDanglingOne(ListNode node) {
        if (node != null && node.val > 9) {
            if (node.next != null) {
                node.next.val++;
                return new ListNode(node.val % 10, moveDanglingOne(node.next));
            } else {
                return new ListNode(node.val % 10, new ListNode(1, null));
            }
        }
        return node;
    }
}
