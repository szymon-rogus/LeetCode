package algorithms.easy;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/same-tree">...</a>
 * This solution beats 47.70% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
