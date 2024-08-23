package algorithms.medium.tree;

import dataStrucutres.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/recover-binary-search-tree">...</a>
 * This solution beats 15.51% other Java submissions' memory complexity
 * This solution beats 35.91% other Java submissions' runtime
 */
public class KthSmallestElementInABST {

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;

        List<Integer> list = new LinkedList<>();

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

        return list.get(k - 1);
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
