package algorithms.medium;

import lombok.AllArgsConstructor;

/**
 <a href="https://leetcode.com/problems/add-two-numbers/description/">...</a>
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return moveDanglingOne(l2);
        }
        if (l2 == null) {
            return moveDanglingOne(l1);
        }

        ListNode recursiveList;

        int value = l1.val + l2.val;
        if (value > 9) {
            value = value % 10;
            if (l1.next != null) {
                l1.next.val++;
            } else if (l2.next != null) {
                l2.next.val++;
            } else {
                l1.next = new ListNode(1, null);
            }
        }
        recursiveList = addTwoNumbers(l1.next, l2.next);

        return new ListNode(value, recursiveList);
    }

    private ListNode moveDanglingOne(ListNode node) {
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

    @AllArgsConstructor
    public static class ListNode {

      int val;
      ListNode next;
    }
}
