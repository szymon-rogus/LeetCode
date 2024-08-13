package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst">...</a>
 * This solution beats 94.15% other Java submissions' memory complexity
 * This solution beats 51.71% other Java submissions' runtime
 */
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int val = root.val >= low && root.val <= high ? root.val : 0;

        if (root.left == null && root.right == null) return val;
        if (root.left == null) return rangeSumBST(root.right, low, high) + val;
        if (root.right == null ) return rangeSumBST(root.left, low, high) + val;

        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + val;
    }
}
