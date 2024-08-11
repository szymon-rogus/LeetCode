package algorithms.hard.tree;

import dataStrucutres.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum">...</a>
 * This solution beats 46.52% other Java submissions' memory complexity
 * This solution beats 13.50% other Java submissions' runtime
 */
public class BinaryTreeMaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        int maxSum = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentMax = Math.max(maxPathSum(node.left, 0), 0)
                    + Math.max(maxPathSum(node.right, 0), 0) + node.val;
            maxSum = Math.max(maxSum, currentMax);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return maxSum;
    }

    private static int maxPathSum(TreeNode root, int val) {
        if (root == null) return val;

        val += root.val;
        int tempVal = Math.max(maxPathSum(root.left, val), maxPathSum(root.right, val));

        return Math.max(tempVal, val);
    }
}
