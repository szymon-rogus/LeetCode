package algorithms.medium.tree;

import dataStrucutres.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii">...</a>
 * This solution beats 72.89% other Java submissions' memory complexity
 * This solution beats 41.07% other Java submissions' runtime
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int pathSum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            pathSum += pathSumFixed(node, targetSum);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return pathSum;

    }

    private int pathSumFixed(TreeNode root, long targetSum) {
        if (root == null) return 0;

        targetSum -= root.val;

        if (targetSum == 0) {
            return pathSumFixed(root.left, targetSum) + 1 + pathSumFixed(root.right, targetSum);
        }
        return pathSumFixed(root.left, targetSum) + pathSumFixed(root.right, targetSum);
    }
}
