package algorithms.medium.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers">...</a>
 * This solution beats 90.01% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int val) {
        if (root == null) return val;

        val *= 10;
        val += root.val;

        if (root.left == null && root.right == null) return val;
        if (root.left == null) return sumNumbers(root.right, val);
        if (root.right == null) return sumNumbers(root.left, val);
        return sumNumbers(root.left, val) + sumNumbers(root.right, val);
    }
}
