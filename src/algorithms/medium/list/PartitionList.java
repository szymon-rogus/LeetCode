package algorithms.medium.list;

import dataStructures.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/partition-list/">...</a>
 * This solution beats 41.21% other Java submissions' memory complexity
 * This solution beats 5.18% other Java submissions' runtime
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        List<Integer> smaller = new LinkedList<>();
        List<Integer> greater = new LinkedList<>();

        while (head != null) {
            if (head.val < x) {
                smaller.add(head.val);
            } else {
                greater.add(head.val);
            }
            head = head.next;
        }

        smaller.addAll(greater);
        return getNext(smaller);
    }

    private static ListNode getNext(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }

        ListNode node = new ListNode(list.removeFirst());
        node.next = getNext(list);
        return node;
    }
}
