package algorithms.easy.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree">...</a>
 * This solution beats 76% other Java submissions' memory complexity
 * This solution beats 80.58% other Java submissions' runtime
 */
public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;


        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;

        return Math.min(left, right);
    }
}
