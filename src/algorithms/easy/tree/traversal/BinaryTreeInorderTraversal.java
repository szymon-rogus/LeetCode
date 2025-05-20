package algorithms.easy.tree.traversal;

import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal">...</a>
 */
public class BinaryTreeInorderTraversal {

    /**
     * Recursive solution with extra recursive method
     * This solution beats 100% other Java submissions' runtime
     * This solution beats 44.04% other Java submissions' memory complexity
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root == null) return list;

        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    /**
     * Iterative solution with Stack
     * This solution beats 100% other Java submissions' runtime
     * This solution beats 92.05% other Java submissions' memory complexity
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        return null;
    }
}
