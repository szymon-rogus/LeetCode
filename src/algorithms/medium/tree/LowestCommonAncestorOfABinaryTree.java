package algorithms.medium.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree">...</a>
 * This solution beats 63.66% other Java submissions' runtime
 * This solution beats 73.07% other Java submissions' memory complexity
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /// if we come to the end there is key in this subtree
        if (root == null) return null;
        /// we found one of the keys
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
