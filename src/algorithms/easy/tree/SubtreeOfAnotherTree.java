package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree">...</a>
 * This solution beats 22.29% other Java submissions' runtime
 * This solution beats 41.86% other Java submissions' memory complexity
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (same(node, subRoot)) return true;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return false;
    }

    private boolean same(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return root1.val == root2.val && same(root1.left, root2.left) && same(root1.right, root2.right);
    }
}
