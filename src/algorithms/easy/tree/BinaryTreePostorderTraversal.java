package algorithms.easy.tree;


import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 45.17% other Java submissions' memory complexity
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root == null) return list;

        postorderTraversal(root, list);
        return list;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }
}
