package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-of-left-leaves">...</a>
 * This solution beats 76.49% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class SumOfLeftLeaves {

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    private static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return isLeft ? root.val : 0;

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
