package algorithms.easy.tree;

import dataStrucutres.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal">...</a>
 * This solution beats 75.48% other Java submissions' memory complexity
 * This solution beats 5.23% other Java submissions' runtime
 */
public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            sum += Math.abs(sum(node.left) - sum(node.right));

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return sum;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;

        return sum(root.left) + root.val + sum(root.right);
    }
}
