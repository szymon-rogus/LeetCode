package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">...</a>
 * This solution beats 15.39% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class MaximumDepthOfBinaryTree {
    
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);
    }
}
