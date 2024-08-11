package algorithms.medium.list;

import dataStrucutres.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists">...</a>
 * This solution beats 14.75% other Java submissions' memory complexity
 * This solution beats 12.30% other Java submissions' runtime
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;

        int size = 0;
        ListNode tempHead = head;
        while (head != null) {
            head = head.next;
            size++;
        }
        k %= size;
        return rotateRightRecursive(tempHead, k);
    }

    private ListNode rotateRightRecursive(ListNode head, int k) {
        if (k == 0) return head;

        ListNode temp = head;
        while (head.next != null) {
            if (head.next.next == null) {
                ListNode node = new ListNode(head.next.val, temp);
                head.next = null;
                return rotateRight(node, k - 1);
            } else {
                head = head.next;
            }
        }
        return null;
    }
}
