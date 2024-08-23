package algorithms.medium.tree;

import dataStrucutres.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/recover-binary-search-tree">...</a>
 * This solution beats 29.44% other Java submissions' memory complexity
 * This solution beats 6.85% other Java submissions' runtime
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

        int first = 0;
        int second = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                first = list.get(i);
                for (int j = 0; j < list.size() - 1; j++) {
                    if (list.get(j) > list.get(j + 1)) {
                        second = list.get(j);
                        break;
                    }
                }
                break;
            }
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int changes = 0;
        while (!stack.isEmpty()) {
            if (changes == 2) break;
            TreeNode node = stack.pop();

            if (node.val == first) {
                node.val = second;
                changes++;
            } else if (node.val == second) {
                node.val = first;
                changes++;
            }

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
