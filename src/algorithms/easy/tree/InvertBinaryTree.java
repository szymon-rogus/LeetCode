package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree">...</a>
 * This solution beats 8.70% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
