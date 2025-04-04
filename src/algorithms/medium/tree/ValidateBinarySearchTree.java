package algorithms.medium.tree;

import dataStrucutres.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree">...</a>
 * This solution beats 52.24% other Java submissions' memory complexity
 * This solution beats 3.23% other Java submissions' runtime
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (!valid(node)) {
                return false;
            }
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return true;
    }

    private boolean valid(TreeNode node) {
        if (node == null) return true;

        return validLeft(node.left, node.val) && validRight(node.right, node.val);
    }

    private boolean validLeft(TreeNode node, int value) {
        if (node == null) return true;
        if (node.val < value) return validLeft(node.left, value) && validLeft(node.right, value);
        return false;
    }

    private boolean validRight(TreeNode node, int value) {
        if (node == null) return true;
        if (node.val > value) return validRight(node.left, value) && validRight(node.right, value);
        return false;
    }
}
