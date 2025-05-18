package algorithms.easy.tree.traversal;

import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal">...</a>
 */
public class BinaryTreePostorderTraversal {

    /**
     * Recursive solution with extra recursive method
     * This solution beats 100% other Java submissions' runtime
     * This solution beats 45.17% other Java submissions' memory complexity
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root == null) return list;

        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    /**
     * Iterative solution with Stack
     * This solution beats 100% other Java submissions' runtime
     * This solution beats 15.84% other Java submissions' memory complexity
     */
    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return list;
    }
}
