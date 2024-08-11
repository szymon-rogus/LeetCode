package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/path-sum">...</a>
 * This solution beats 57.48% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return targetSum - root.val == 0;
        if (root.left == null) return hasPathSum(root.right, targetSum - root.val);
        if (root.right == null) return hasPathSum(root.left, targetSum - root.val);

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
