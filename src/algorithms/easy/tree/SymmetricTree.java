package algorithms.easy.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 90.39% other Java submissions' memory complexity
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null && rootRight == null) return true;
        if (rootLeft == null || rootRight == null) return false;

        if (rootLeft.val == rootRight.val) {
            return isSymmetric(rootLeft.left, rootRight.right) && isSymmetric(rootLeft.right, rootRight.left);
        }
        return false;
    }
}
