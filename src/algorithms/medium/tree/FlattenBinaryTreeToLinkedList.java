package algorithms.medium.tree;

import dataStrucutres.TreeNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list">...</a>
 * This solution beats 78.05% other Java submissions' memory complexity
 * This solution beats 22.62% other Java submissions' runtime
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            if (!stack.isEmpty()) {
                node.right = stack.peek();
                node.left = null;
            }
        }

    }
}
