package algorithms.easy.tree;


import dataStrucutres.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal">...</a>
 * This solution beats 15.01% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
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
