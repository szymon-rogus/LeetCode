package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/univalued-binary-tree">...</a>
 * This solution beats 28.57% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class UnivaluedBinaryTree {

    public static boolean isUnivalTree(TreeNode root) {
        int helper = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.val != helper) return false;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return true;
    }
}
