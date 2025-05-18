package algorithms.easy.tree.traversal;

import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal">...</a>
 */
public class BinaryTreePreorderTraversal {

    /**
     * Recursive solution with extra recursive method
     * This solution beats 100% other Java submissions' runtime
     * This solution beats 43.64% other Java submissions' memory complexity
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root == null) return list;

        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    /**
     * Iterative solution with Stack
     * This solution beats 100% other Java submissions' runtime
     * This solution beats 92.05% other Java submissions' memory complexity
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return list;
    }
}
