package algorithms.easy.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree">...</a>
 * This solution beats 45.16% other Java submissions' memory complexity
 * This solution beats 100.00% other Java submissions' runtime
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        ///  checking the height condition on current root
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        /// if the condition is met, we can run it again on left and right subtree
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }
}
