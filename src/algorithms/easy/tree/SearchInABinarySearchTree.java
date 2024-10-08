package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree">...</a>
 * This solution beats 16.60% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class SearchInABinarySearchTree {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
