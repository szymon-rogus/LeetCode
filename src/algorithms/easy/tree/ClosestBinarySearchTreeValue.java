package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/closest-binary-search-tree-value">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 34.54% other Java submissions' memory complexity
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int value = root.val;
        double abs = Math.abs(value - target);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            /// updating abs and our searched value
            if (Math.abs(node.val - target) < abs) {
                value = node.val;
                abs = Math.abs(node.val - target);
            } else if (Math.abs(node.val - target) == abs) {
                value = Math.min(node.val, value);
                abs = Math.abs(node.val - target);
            }

            /// we have to go to subtree which can give us possible better solution
            /// the other subtree will have values with bigger abs than our current abs, so we can skip this one
            if (node.val > target) {
                if (node.left != null) stack.push(node.left);
            } else if (node.val < target) {
                if (node.right != null) stack.push(node.right);
            } else return node.val;

        }

        return value;
    }
}
