package algorithms.easy.tree;

import dataStrucutres.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes">...</a>
 * This solution beats 60.29% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class CountCompleteTreeNodes {

    // This is the most basic problem when first dealing with Trees
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
